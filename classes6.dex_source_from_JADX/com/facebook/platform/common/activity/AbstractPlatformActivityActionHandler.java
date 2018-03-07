package com.facebook.platform.common.activity;

import android.app.Activity;
import com.facebook.platform.common.action.PlatformActionExecutor;
import com.google.common.base.Preconditions;

/* compiled from: stream_video_fps */
public abstract class AbstractPlatformActivityActionHandler<EXECUTOR extends PlatformActionExecutor, REQUEST extends PlatformActivityRequest> implements PlatformActivityActionHandler {
    private final Class<REQUEST> f4022a;
    private final String f4023b;

    protected abstract EXECUTOR m5920b(Activity activity, REQUEST request);

    protected AbstractPlatformActivityActionHandler(Class<REQUEST> cls, String str) {
        this.f4022a = cls;
        this.f4023b = str;
    }

    public final String mo290a() {
        return this.f4023b;
    }

    public REQUEST mo291b() {
        return (PlatformActivityRequest) this.f4022a.newInstance();
    }

    public final EXECUTOR mo289a(Activity activity, PlatformActivityRequest platformActivityRequest) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(platformActivityRequest);
        Preconditions.checkArgument(this.f4022a.isInstance(platformActivityRequest));
        return m5920b(activity, platformActivityRequest);
    }
}
