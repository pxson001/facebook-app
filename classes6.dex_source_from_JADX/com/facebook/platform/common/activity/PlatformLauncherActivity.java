package com.facebook.platform.common.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.init.AppInitLock;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: stream_video_bit_rate */
public abstract class PlatformLauncherActivity extends Activity {
    private static final Class<?> f4024a = PlatformLauncherActivity.class;
    private static Integer f4025g = Integer.valueOf(0);
    private static long f4026h = 0;
    public final Class<? extends FbFragmentActivity> f4027b;
    public final int f4028c;
    public String f4029d;
    public FbInjector f4030e;
    public boolean f4031f;
    public long f4032i = 0;
    private MonotonicClock f4033j;
    private PlatformActivityThrottler f4034k;

    public PlatformLauncherActivity(Class<? extends FbFragmentActivity> cls, int i) {
        this.f4027b = cls;
        this.f4028c = i;
    }

    protected void onCreate(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -779805833);
        super.onCreate(bundle);
        this.f4030e = FbInjector.get(this);
        this.f4033j = (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(this.f4030e);
        this.f4032i = this.f4033j.now();
        this.f4034k = PlatformActivityThrottler.m5942a(this.f4030e);
        AppInitLock.a(this.f4030e).b();
        if (bundle == null) {
            ComponentName callingActivity = getCallingActivity();
            this.f4029d = callingActivity != null ? callingActivity.getPackageName() : null;
        } else {
            this.f4029d = bundle.getString("calling_package_key");
        }
        this.f4031f = false;
        if (bundle != null) {
            this.f4031f = bundle.getBoolean("child_act_launched");
            this.f4032i = bundle.getLong("platform_launch_time_ms");
        }
        if (!this.f4031f) {
            if (this.f4034k.m5944a()) {
                Bundle bundle2 = Bundle.EMPTY;
                if (getIntent().getExtras() != null) {
                    bundle2 = getIntent().getExtras();
                }
                Intent intent = new Intent(this, this.f4027b);
                intent.putExtras(bundle2);
                intent.putExtra("platform_launch_time_ms", this.f4032i);
                intent.putExtra("calling_package_key", this.f4029d);
                ((SecureContextHelper) DefaultSecureContextHelper.a(this.f4030e)).a(intent, this.f4028c, this);
                this.f4031f = true;
            } else {
                BLog.b(f4024a, "Api requests exceed the rate limit");
                finish();
                Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1661971517, a);
                return;
            }
        }
        LogUtils.c(497372785, a);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == this.f4028c) {
            this.f4031f = false;
            setResult(i2, intent);
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("platform_launch_time_ms", this.f4032i);
        bundle.putString("calling_package_key", this.f4029d);
        bundle.putBoolean("child_act_launched", this.f4031f);
    }
}
