package com.facebook.feed.util;

import android.content.Context;
import android.content.IntentFilter;
import com.facebook.base.broadcast.SafeLocalBroadcastReceiver;

/* compiled from: no failure reason */
public abstract class FeedNetworkConnectivityReceiver extends SafeLocalBroadcastReceiver {
    public FeedNetworkConnectivityReceiver(Context context) {
        super(context, new IntentFilter("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED"));
        m12857a();
    }
}
