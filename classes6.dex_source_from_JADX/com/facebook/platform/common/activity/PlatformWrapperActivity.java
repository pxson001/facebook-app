package com.facebook.platform.common.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: stream_disk_recording_space_check_interval_in_seconds */
public class PlatformWrapperActivity extends FbFragmentActivity implements IAuthNotRequired {
    private static final Class<?> f4069r = PlatformWrapperActivity.class;
    @Inject
    MonotonicClock f4070p;
    @Inject
    PlatformIntentDemuxer f4071q;
    private long f4072s;

    private static <T extends Context> void m5962a(Class<T> cls, T t) {
        m5963a((Object) t, (Context) t);
    }

    public static void m5963a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PlatformWrapperActivity) obj).m5961a((MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), PlatformIntentDemuxer.m5950b(injectorLike));
    }

    private void m5961a(MonotonicClock monotonicClock, PlatformIntentDemuxer platformIntentDemuxer) {
        this.f4070p = monotonicClock;
        this.f4071q = platformIntentDemuxer;
    }

    protected final void hy_() {
        Class cls = PlatformWrapperActivity.class;
        m5963a((Object) this, (Context) this);
        this.f4072s = this.f4070p.now();
    }

    protected final void m5964b(Bundle bundle) {
        new StringBuilder("onActivityCreate ").append(bundle);
        super.b(bundle);
        this.f4071q.m5958a(bundle, this, getIntent(), true, this.f4072s);
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 861097182);
        this.f4071q.m5955a();
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1304935540, a);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.f4071q.m5956a(i, i2, intent);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f4071q.m5960c(bundle);
    }
}
