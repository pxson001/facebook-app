package com.facebook.analytics2.logger;

import android.content.Context;
import android.os.HandlerThread;
import com.facebook.analytics2.loggermodule.Analytics2LoggerModule.C02003;
import com.facebook.crudolib.params.ParamsCollectionPool;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: tap_meme_prompt */
public class EventProcessorManager {
    private static final MaxEventsPerBatchProvider f3239a = new SimpleMaxEventsPerBatchProvider(1);
    private final Context f3240b;
    private final Class<? extends Uploader> f3241c;
    @Nullable
    private final EventListener f3242d;
    @Nullable
    private final EventListener f3243e;
    @Nullable
    private final Class<? extends SamplingPolicyConfig> f3244f;
    private final Class<? extends HandlerThreadFactory> f3245g;
    private final BatchFixedMetadataHelper f3246h;
    private final SessionManager f3247i;
    private final ParamsCollectionPool f3248j;
    private final C02003 f3249k;
    private final UploadSchedulerParamsProvider f3250l;
    private final UploadSchedulerParamsProvider f3251m;
    private final MaxEventsPerBatchProvider f3252n;
    @GuardedBy("this")
    private EventProcessor f3253o;
    @GuardedBy("this")
    private EventProcessor f3254p;
    @GuardedBy("this")
    private SessionDelegate f3255q;

    public EventProcessorManager(Context context, Class<? extends Uploader> cls, @Nullable EventListener eventListener, @Nullable EventListener eventListener2, @Nullable Class<? extends SamplingPolicyConfig> cls2, Class<? extends HandlerThreadFactory> cls3, BatchFixedMetadataHelper batchFixedMetadataHelper, SessionManager sessionManager, ParamsCollectionPool paramsCollectionPool, AppBackgroundedProvider appBackgroundedProvider, UploadSchedulerParamsProvider uploadSchedulerParamsProvider, UploadSchedulerParamsProvider uploadSchedulerParamsProvider2, MaxEventsPerBatchProvider maxEventsPerBatchProvider) {
        this.f3240b = context;
        this.f3241c = cls;
        this.f3242d = eventListener;
        this.f3243e = eventListener2;
        this.f3244f = cls2;
        this.f3245g = cls3;
        this.f3246h = batchFixedMetadataHelper;
        this.f3247i = sessionManager;
        this.f3248j = paramsCollectionPool;
        this.f3249k = appBackgroundedProvider;
        this.f3250l = uploadSchedulerParamsProvider;
        this.f3251m = uploadSchedulerParamsProvider2;
        this.f3252n = maxEventsPerBatchProvider;
    }

    @Nullable
    public final synchronized EventProcessor m5402a() {
        return this.f3253o;
    }

    @Nonnull
    public final synchronized EventProcessor m5403b() {
        if (this.f3253o == null) {
            CommonUploadSchedulerParams commonUploadSchedulerParams = new CommonUploadSchedulerParams(this.f3241c, this.f3244f, this.f3245g, UploadJob$Priority.NORMAL, "regular");
            HandlerThread a = m5400a("Analytics-NormalPri-Proc", 10);
            HandlerThread handlerThread = a;
            EventListener eventListener = this.f3242d;
            this.f3253o = new EventProcessor(handlerThread, eventListener, new EventBatchStoreManagerFactory(this.f3240b, 2131558559, "normal", this.f3252n, this.f3252n, this.f3246h, this.f3248j, commonUploadSchedulerParams, this.f3249k, this.f3245g, this.f3250l), this);
            this.f3253o.m5557a(m5401e());
        }
        return this.f3253o;
    }

    @Nullable
    public final synchronized EventProcessor m5404c() {
        return this.f3254p;
    }

    @Nonnull
    public final synchronized EventProcessor m5405d() {
        if (this.f3254p == null) {
            CommonUploadSchedulerParams commonUploadSchedulerParams = new CommonUploadSchedulerParams(this.f3241c, this.f3244f, this.f3245g, UploadJob$Priority.HIGH, "ads");
            HandlerThread a = m5400a("Analytics-HighPri-Proc", 0);
            HandlerThread handlerThread = a;
            EventListener eventListener = this.f3243e;
            this.f3254p = new EventProcessor(handlerThread, eventListener, new EventBatchStoreManagerFactory(this.f3240b, 2131558560, "high", f3239a, this.f3252n, this.f3246h, this.f3248j, commonUploadSchedulerParams, this.f3249k, this.f3245g, this.f3251m), this);
            this.f3254p.m5557a(m5401e());
        }
        return this.f3254p;
    }

    @Nonnull
    private synchronized SessionDelegate m5401e() {
        if (this.f3255q == null) {
            this.f3255q = new SessionDelegate(this.f3247i);
        }
        return this.f3255q;
    }

    private HandlerThread m5400a(String str, int i) {
        HandlerThread a = ContextConstructorHelper.m5559a(this.f3240b).m5563b(this.f3245g.getName()).mo736a(str, i);
        a.start();
        return a;
    }
}
