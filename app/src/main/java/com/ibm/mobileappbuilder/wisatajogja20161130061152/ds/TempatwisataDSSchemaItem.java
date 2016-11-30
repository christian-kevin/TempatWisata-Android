
package com.ibm.mobileappbuilder.wisatajogja20161130061152.ds;
import java.net.URL;
import ibmmobileappbuilder.util.StringUtils;
import ibmmobileappbuilder.ds.restds.GeoPoint;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class TempatwisataDSSchemaItem implements Parcelable, IdentifiableBean {

    @SerializedName("id") public String id;
    @SerializedName("namaWisata") public String namaWisata;
    @SerializedName("tempat") public String tempat;
    @SerializedName("deskripsi") public String deskripsi;
    @SerializedName("gambar") public Integer gambar;
    @SerializedName("lokasi") public GeoPoint lokasi;

    @Override
    public String getIdentifiableId() {
      return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(namaWisata);
        dest.writeString(tempat);
        dest.writeString(deskripsi);
        dest.writeValue(gambar);
        dest.writeDoubleArray(lokasi != null  && lokasi.coordinates.length != 0 ? lokasi.coordinates : null);
    }

    public static final Creator<TempatwisataDSSchemaItem> CREATOR = new Creator<TempatwisataDSSchemaItem>() {
        @Override
        public TempatwisataDSSchemaItem createFromParcel(Parcel in) {
            TempatwisataDSSchemaItem item = new TempatwisataDSSchemaItem();

            item.id = in.readString();
            item.namaWisata = in.readString();
            item.tempat = in.readString();
            item.deskripsi = in.readString();
            item.gambar = (Integer) in.readValue(null);
            double[] lokasi_coords = in.createDoubleArray();
            if (lokasi_coords != null)
                item.lokasi = new GeoPoint(lokasi_coords);
            return item;
        }

        @Override
        public TempatwisataDSSchemaItem[] newArray(int size) {
            return new TempatwisataDSSchemaItem[size];
        }
    };

}

