package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: SENT */
public class BoltsMeasurementEventListener extends BroadcastReceiver {
    private static BoltsMeasurementEventListener f23973a;
    public Context f23974b;

    private BoltsMeasurementEventListener(Context context) {
        this.f23974b = context.getApplicationContext();
    }

    private void m25243b() {
        LocalBroadcastManager.a(this.f23974b).a(this);
    }

    public static BoltsMeasurementEventListener m25242a(Context context) {
        if (f23973a != null) {
            return f23973a;
        }
        BroadcastReceiver boltsMeasurementEventListener = new BoltsMeasurementEventListener(context);
        f23973a = boltsMeasurementEventListener;
        LocalBroadcastManager.a(boltsMeasurementEventListener.f23974b).a(boltsMeasurementEventListener, new IntentFilter("com.parse.bolts.measurement_event"));
        return f23973a;
    }

    protected void finalize() {
        try {
            m25243b();
        } finally {
            super.finalize();
        }
    }

    public void onReceive(Context context, Intent intent) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 545238913);
        AppEventsLogger appEventsLogger = new AppEventsLogger(context, null, null);
        String str = "bf_" + intent.getStringExtra("event_name");
        Bundle bundleExtra = intent.getBundleExtra("event_args");
        Bundle bundle = new Bundle();
        for (String str2 : bundleExtra.keySet()) {
            bundle.putString(str2.replaceAll("[^0-9a-zA-Z _-]", "-").replaceAll("^[ -]*", "").replaceAll("[ -]*$", ""), (String) bundleExtra.get(str2));
        }
        appEventsLogger.m14701a(str, bundle);
        LogUtils.a(intent, 2147318716, a);
    }
}
