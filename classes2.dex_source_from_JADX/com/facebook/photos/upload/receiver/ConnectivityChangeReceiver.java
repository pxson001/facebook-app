package com.facebook.photos.upload.receiver;

import com.facebook.content.DynamicSecureBroadcastReceiver;

/* compiled from: throwable */
public class ConnectivityChangeReceiver extends DynamicSecureBroadcastReceiver {
    public ConnectivityChangeReceiver() {
        super("android.net.conn.CONNECTIVITY_CHANGE", new InternalReceiver());
    }
}
