package com.facebook.analytics2.logger;

/* compiled from: tabs */
public class CommonUploadSchedulerParams {
    public final Class<? extends Uploader> f3338a;
    public final Class<? extends SamplingPolicyConfig> f3339b;
    public final Class<? extends HandlerThreadFactory> f3340c;
    public final UploadJob$Priority f3341d;
    public final String f3342e;

    public CommonUploadSchedulerParams(Class<? extends Uploader> cls, Class<? extends SamplingPolicyConfig> cls2, Class<? extends HandlerThreadFactory> cls3, UploadJob$Priority uploadJob$Priority, String str) {
        this.f3338a = cls;
        this.f3339b = cls2;
        this.f3340c = cls3;
        this.f3341d = uploadJob$Priority;
        this.f3342e = str;
    }
}
