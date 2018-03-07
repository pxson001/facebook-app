package com.facebook.common.executors;

import android.content.Context;
import android.os.Handler;
import com.facebook.common.android.AlarmManagerMethodAutoProvider;
import com.facebook.common.process.DefaultProcessUtil;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClockMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: max_contacts_to_upload */
public class WakingExecutorServiceProvider extends AbstractAssistedProvider<WakingExecutorService> {
    public final WakingExecutorService m8508a(String str, Handler handler) {
        return new WakingExecutorService((Context) getInstance(Context.class), (MonotonicClock) RealtimeSinceBootClockMethodAutoProvider.a(this), AlarmManagerMethodAutoProvider.b(this), DefaultProcessUtil.a(this), (BackgroundWorkLogger) BaseBackgroundWorkLogger.a(this), str, handler);
    }
}
