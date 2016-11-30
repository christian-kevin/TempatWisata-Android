
package com.ibm.mobileappbuilder.wisatajogja20161130061152.ui;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ibm.mobileappbuilder.wisatajogja20161130061152.R;
import ibmmobileappbuilder.behaviors.ShareBehavior;
import ibmmobileappbuilder.util.image.ImageLoader;
import ibmmobileappbuilder.util.image.PicassoImageLoader;
import static ibmmobileappbuilder.util.image.ImageLoaderRequest.Builder.imageLoaderRequest;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.wisatajogja20161130061152.ds.TempatwisataDSSchemaItem;
import com.ibm.mobileappbuilder.wisatajogja20161130061152.ds.TempatwisataDS;

public class TempatWisataDetailFragment extends ibmmobileappbuilder.ui.DetailFragment<TempatwisataDSSchemaItem> implements ShareBehavior.ShareListener  {

    private Datasource<TempatwisataDSSchemaItem> datasource;
    public static TempatWisataDetailFragment newInstance(Bundle args){
        TempatWisataDetailFragment fr = new TempatWisataDetailFragment();
        fr.setArguments(args);

        return fr;
    }

    public TempatWisataDetailFragment(){
        super();
    }

    @Override
    public Datasource<TempatwisataDSSchemaItem> getDatasource() {
        if (datasource != null) {
            return datasource;
    }
       datasource = TempatwisataDS.getInstance(new SearchOptions());
        return datasource;
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        addBehavior(new ShareBehavior(getActivity(), this));

    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.tempatwisatadetail_detail;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final TempatwisataDSSchemaItem item, View view) {
        
        if(item.gambar != null){
            ImageView view0 = (ImageView) view.findViewById(R.id.view0);
            ImageLoader view0Loader = new PicassoImageLoader(view.getContext());
            view0Loader.load(imageLoaderRequest()
                            .withResourceToLoad(item.gambar)
                            .withTargetView(view0)
                            .build()
            );
            
        }
        if (item.deskripsi != null){
            
            TextView view1 = (TextView) view.findViewById(R.id.view1);
            view1.setText(item.deskripsi);
            
        }
        if (item.tempat != null){
            
            TextView view2 = (TextView) view.findViewById(R.id.view2);
            view2.setText(item.tempat);
            
        }
    }

    @Override
    protected void onShow(TempatwisataDSSchemaItem item) {
        // set the title for this fragment
        getActivity().setTitle(item.namaWisata);
    }
    @Override
    public void onShare() {
        TempatwisataDSSchemaItem item = getItem();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_TEXT, (item.deskripsi != null ? item.deskripsi : "" ) + "\n" +
                    (item.tempat != null ? item.tempat : "" ));
        intent.putExtra(Intent.EXTRA_SUBJECT, item.namaWisata);
        startActivityForResult(Intent.createChooser(intent, getString(R.string.share)), 1);
    }
}
