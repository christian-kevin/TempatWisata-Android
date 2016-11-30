

package com.ibm.mobileappbuilder.wisatajogja20161130061152.ds;
import java.net.URL;
import ibmmobileappbuilder.util.StringUtils;
import ibmmobileappbuilder.ds.restds.GeoPoint;
import com.ibm.mobileappbuilder.wisatajogja20161130061152.R;
import java.util.ArrayList;
import java.util.List;
import ibmmobileappbuilder.util.StringUtils;

// TempatwisataDSSchemaItem static data
public class TempatwisataDSItems{

    public static List<TempatwisataDSSchemaItem> ITEMS = new ArrayList<TempatwisataDSSchemaItem>();
    static {
        // Add items.
        TempatwisataDSSchemaItem item;
        item = new TempatwisataDSSchemaItem();
        item.lokasi = StringUtils.parseGeopoint("{  \"coordinates\": [    110.3130087,    -8.025896  ],  \"type\": \"Point\"}");
        item.gambar = R.drawable.jpg_250pxparangtritisdiliha;
        item.deskripsi = "Parangtritis adalah desa di kecamatan Kretek, Bantul, Daerah Istimewa Yogyakarta, Indonesia";
        item.tempat = "Bantul, DIY";
        item.namaWisata = "Pantai Parang Tritis";
        item.id = "583e6eb255a9480400a98387";
        addItem(item);
        item = new TempatwisataDSSchemaItem();
        item.gambar = R.drawable.jpg_maxresdefault;
        item.deskripsi = "Monumen Nasional atau yang populer disingkat dengan Monas atau Tugu Monas adalah monumen peringatan setinggi 132 meter yang didirikan untuk mengenang perlawanan dan perjuangan rakyat Indonesia";
        item.tempat = "Jakarta, Indonesia";
        item.lokasi = StringUtils.parseGeopoint("{  \"coordinates\": [    106.8271528,    -6.1753924  ],  \"type\": \"Point\"}");
        item.namaWisata = "Monumen Nasional";
        item.id = "583e6ffa55a9480400a9838b";
        addItem(item);
        item = new TempatwisataDSSchemaItem();
        item.gambar = R.drawable.png_purabalekambang;
        item.deskripsi = "Pantai Balekambang adalah sebuah pantai di pesisir selatan yang terletak di tepi Samudera Indonesia secara administratif masuk wilayah Dusun Sumber Jambe, Desa Srigonco, Kecamatan Bantur,Jawa Timur";
        item.tempat = "Jawa Timur, Indonesia";
        item.lokasi = StringUtils.parseGeopoint("{  \"coordinates\": [    112.5391259,    -8.4034458  ],  \"type\": \"Point\"}");
        item.namaWisata = "Pantai Balekambang";
        item.id = "583e708d92b90c04001d1348";
        addItem(item);
    }
    public static void addItem(TempatwisataDSSchemaItem item) {
        ITEMS.add(item);
    }
}

