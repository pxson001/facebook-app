package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.zzsy;
import com.google.android.gms.internal.zzsy.zza;
import com.google.android.gms.internal.zzsz;
import com.google.android.gms.internal.zztj;
import java.util.ArrayList;
import java.util.List;

public class DataMapItem {
    private final Uri f13146a;
    public final DataMap f13147b;

    private DataMapItem(DataItem dataItem) {
        this.f13146a = dataItem.mo578b();
        this.f13147b = m13271b((DataItem) dataItem.a());
    }

    public static DataMapItem m13270a(DataItem dataItem) {
        if (dataItem != null) {
            return new DataMapItem(dataItem);
        }
        throw new IllegalStateException("provided dataItem is null");
    }

    private static DataMap m13271b(DataItem dataItem) {
        Throwable e;
        if (dataItem.mo579c() == null && dataItem.mo580d().size() > 0) {
            throw new IllegalArgumentException("Cannot create DataMapItem from a DataItem  that wasn't made with DataMapItem.");
        } else if (dataItem.mo579c() == null) {
            return new DataMap();
        } else {
            try {
                List arrayList = new ArrayList();
                int size = dataItem.mo580d().size();
                for (int i = 0; i < size; i++) {
                    DataItemAsset dataItemAsset = (DataItemAsset) dataItem.mo580d().get(Integer.toString(i));
                    if (dataItemAsset == null) {
                        throw new IllegalStateException("Cannot find DataItemAsset referenced in data at " + i + " for " + dataItem);
                    }
                    arrayList.add(Asset.m13225a(dataItemAsset.mo576b()));
                }
                return zzsy.m13206a(new zza(zzsz.m13220a(dataItem.mo579c()), arrayList));
            } catch (zztj e2) {
                e = e2;
                Log.w("DataItem", "Unable to parse datamap from dataItem. uri=" + dataItem.mo578b() + ", data=" + Base64.encodeToString(dataItem.mo579c(), 0));
                throw new IllegalStateException("Unable to parse datamap from dataItem.  uri=" + dataItem.mo578b(), e);
            } catch (NullPointerException e3) {
                e = e3;
                Log.w("DataItem", "Unable to parse datamap from dataItem. uri=" + dataItem.mo578b() + ", data=" + Base64.encodeToString(dataItem.mo579c(), 0));
                throw new IllegalStateException("Unable to parse datamap from dataItem.  uri=" + dataItem.mo578b(), e);
            }
        }
    }

    public final DataMap m13272a() {
        return this.f13147b;
    }
}
