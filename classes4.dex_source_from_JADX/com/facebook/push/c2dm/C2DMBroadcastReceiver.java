package com.facebook.push.c2dm;

import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.google.common.collect.ImmutableMap.Builder;

/* compiled from: impression_type */
public class C2DMBroadcastReceiver extends DynamicSecureBroadcastReceiver {
    private static final Class<?> f10434a = C2DMBroadcastReceiver.class;

    public C2DMBroadcastReceiver() {
        super(new Builder().b("com.google.android.c2dm.intent.RECEIVE", new C2DMActionReceiver()).b("com.google.android.c2dm.intent.REGISTRATION", new C2DMActionReceiver()).b());
    }
}
