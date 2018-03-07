package com.facebook.manageddatastore;

import android.content.Context;
import com.facebook.common.diagnostics.TraceLogger;

/* compiled from: succeeded */
public interface NetworkRequestCallback<K, V> {
    void mo113a(Context context, boolean z, K k, String str, V v);

    TraceLogger mo114b();
}
