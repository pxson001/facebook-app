package com.google.base;

import com.facebook.inject.AbstractProvider;
import com.google.common.base.Stopwatch;

/* compiled from: android.intent.action.DOWNLOAD_COMPLETE */
public class StopwatchMethodAutoProvider extends AbstractProvider<Stopwatch> {
    public Object get() {
        return Stopwatch.createUnstarted();
    }
}
