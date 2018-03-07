package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.common.data.Freezable;
import java.util.Map;

public interface DataItem extends Freezable<DataItem> {
    Uri mo578b();

    byte[] mo579c();

    Map<String, DataItemAsset> mo580d();
}
