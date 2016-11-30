package com.ibm.mobileappbuilder.wisatajogja20161130061152.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ibm.mobileappbuilder.wisatajogja20161130061152.R;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ui.ListGridFragment;
import ibmmobileappbuilder.util.image.ImageLoader;
import ibmmobileappbuilder.util.image.PicassoImageLoader;
import ibmmobileappbuilder.util.ViewHolder;
import static ibmmobileappbuilder.util.image.ImageLoaderRequest.Builder.imageLoaderRequest;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.wisatajogja20161130061152.ds.TempatwisataDSSchemaItem;
import com.ibm.mobileappbuilder.wisatajogja20161130061152.ds.TempatwisataDS;
import android.content.Intent;
import ibmmobileappbuilder.util.Constants;
import static ibmmobileappbuilder.util.NavigationUtils.generateIntentToAddOrUpdateItem;

/**
 * "TempatWisataFragment" listing
 */
public class TempatWisataFragment extends ListGridFragment<TempatwisataDSSchemaItem>  {

    private Datasource<TempatwisataDSSchemaItem> datasource;


    public static TempatWisataFragment newInstance(Bundle args) {
        TempatWisataFragment fr = new TempatWisataFragment();

        fr.setArguments(args);
        return fr;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    }

    protected SearchOptions getSearchOptions() {
        SearchOptions.Builder searchOptionsBuilder = SearchOptions.Builder.searchOptions();
        return searchOptionsBuilder.build();
    }


    /**
    * Layout for the list itselft
    */
    @Override
    protected int getLayout() {
        return R.layout.fragment_list;
    }

    /**
    * Layout for each element in the list
    */
    @Override
    protected int getItemLayout() {
        return R.layout.tempatwisata_item;
    }

    @Override
    protected Datasource<TempatwisataDSSchemaItem> getDatasource() {
        if (datasource != null) {
            return datasource;
        }
        datasource = TempatwisataDS.getInstance(getSearchOptions());
        return datasource;
    }

    @Override
    protected void bindView(TempatwisataDSSchemaItem item, View view, int position) {
        
        ImageLoader imageLoader = new PicassoImageLoader(view.getContext());
        ImageView image = ViewHolder.get(view, R.id.image);
        if(item.gambar != null){
            imageLoader.load(imageLoaderRequest()
                            .withResourceToLoad(item.gambar)
                            .withTargetView(image)
                            .fit()
                            .build()
            );
            
        }
        else {
            imageLoader.load(imageLoaderRequest()
                          .withResourceToLoad(R.drawable.ic_ibm_placeholder)
                          .withTargetView(image)
                          .build()
            );
        }
        
        
        TextView title = ViewHolder.get(view, R.id.title);
        
        if (item.namaWisata != null){
            title.setText(item.namaWisata);
            
        }
        
        TextView subtitle = ViewHolder.get(view, R.id.subtitle);
        
        if (item.tempat != null){
            subtitle.setText(item.tempat);
            
        }
    }


    @Override
    public void showDetail(TempatwisataDSSchemaItem item, int position) {
        // If we have forms, then we have to refresh when an item has been edited
        // Also with this we support list without details
        Bundle args = new Bundle();
        args.putInt(Constants.ITEMPOS, position);
        args.putParcelable(Constants.CONTENT, item);
        Intent intent = new Intent(getActivity(), TempatWisataDetailActivity.class);
        intent.putExtras(args);

        if (!getResources().getBoolean(R.bool.tabletLayout)) {
            startActivityForResult(intent, Constants.DETAIL);
        } else {
            startActivity(intent);
        }
    }

}
