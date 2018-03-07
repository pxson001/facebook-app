package com.facebook.analytics2.logger;

import android.content.Context;
import android.support.v4.util.Pools$Pool;
import android.support.v4.util.Pools$SynchronizedPool;
import com.facebook.analytics.Analytics2ProcessPolicy;
import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.NewAnalyticsSamplingPolicy;
import com.facebook.analytics2.loggermodule.Analytics2LoggerModule.C02003;
import com.facebook.analytics2.loggermodule.Analytics2LoggerModule.C02012;
import com.facebook.analytics2.loggermodule.Analytics2LoggerModule.C02021;
import com.facebook.analytics2.loggermodule.FbandroidAppInfoProvider;
import com.facebook.crudolib.params.ParamsCollectionPool;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: tap_top_jewel_bar */
public class Analytics2Logger {
    private static final UploadSchedulerParams f3195i = new UploadSchedulerParams(TimeUnit.MINUTES.toMillis(15), TimeUnit.MINUTES.toMillis(45), 0, TimeUnit.MINUTES.toMillis(30));
    private static final UploadSchedulerParams f3196j = new UploadSchedulerParams(0, 0, 0, 0);
    private static final UploadSchedulerParams f3197k = new UploadSchedulerParams(TimeUnit.MINUTES.toMillis(15), TimeUnit.MINUTES.toMillis(45), 0, TimeUnit.MINUTES.toMillis(30));
    private static final UploadSchedulerParams f3198l = new UploadSchedulerParams(0, 0, 0, 0);
    private static final EventBuilder f3199m = new EventBuilder(false);
    final Pools$Pool<EventBuilder> f3200a;
    public final C02003 f3201b;
    @Nullable
    public final C02021 f3202c;
    final NewAnalyticsSamplingPolicy f3203d;
    @Nullable
    public final Analytics2ProcessPolicy f3204e;
    final EventProcessorManager f3205f;
    final ParamsCollectionPool f3206g = ParamsCollectionPool.m5397a();
    final SessionManager f3207h;

    /* compiled from: tap_top_jewel_bar */
    public class Builder {
        final Context f3166a;
        @Nullable
        Pools$Pool<EventBuilder> f3167b;
        @Nullable
        C02003 f3168c;
        @Nullable
        FbandroidAppInfoProvider f3169d;
        @Nullable
        C02012 f3170e;
        @Nullable
        C02021 f3171f;
        @Nullable
        EventListener f3172g;
        @Nullable
        EventListener f3173h;
        @Nullable
        Class<? extends Uploader> f3174i;
        @Nullable
        SessionManager f3175j;
        @Nullable
        NewAnalyticsSamplingPolicy f3176k;
        @Nullable
        Analytics2ProcessPolicy f3177l;
        @Nullable
        Class<? extends SamplingPolicyConfig> f3178m;
        @Nullable
        Class<? extends HandlerThreadFactory> f3179n;
        @Nullable
        UploadSchedulerParamsProvider f3180o;
        @Nullable
        UploadSchedulerParamsProvider f3181p;
        @Nullable
        MaxEventsPerBatchProvider f3182q;

        public Builder(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("context");
            }
            this.f3166a = context.getApplicationContext();
        }

        public final Builder m5341a(C02003 c02003) {
            this.f3168c = c02003;
            return this;
        }

        public final Builder m5343a(Class<? extends Uploader> cls) {
            this.f3174i = cls;
            return this;
        }

        public final Builder m5342a(FbandroidAppInfoProvider fbandroidAppInfoProvider) {
            this.f3169d = fbandroidAppInfoProvider;
            return this;
        }

        public final Builder m5340a(C02012 c02012) {
            this.f3170e = c02012;
            return this;
        }

        public final Builder m5339a(C02021 c02021) {
            this.f3171f = c02021;
            return this;
        }

        public final Builder m5337a(SessionManager sessionManager) {
            this.f3175j = sessionManager;
            return this;
        }

        public final Builder m5335a(EventListener eventListener) {
            this.f3172g = eventListener;
            return this;
        }

        public final Builder m5345b(EventListener eventListener) {
            this.f3173h = eventListener;
            return this;
        }

        public final Builder m5334a(NewAnalyticsSamplingPolicy newAnalyticsSamplingPolicy) {
            this.f3176k = newAnalyticsSamplingPolicy;
            return this;
        }

        public final Builder m5333a(Analytics2ProcessPolicy analytics2ProcessPolicy) {
            this.f3177l = analytics2ProcessPolicy;
            return this;
        }

        public final Builder m5346b(Class<? extends SamplingPolicyConfig> cls) {
            this.f3178m = cls;
            return this;
        }

        public final Builder m5347c(Class<? extends HandlerThreadFactory> cls) {
            this.f3179n = cls;
            return this;
        }

        public final Builder m5336a(MaxEventsPerBatchProvider maxEventsPerBatchProvider) {
            this.f3182q = maxEventsPerBatchProvider;
            return this;
        }

        public final Builder m5338a(UploadSchedulerParamsProvider uploadSchedulerParamsProvider) {
            this.f3180o = uploadSchedulerParamsProvider;
            return this;
        }

        public final Analytics2Logger m5344a() {
            return new Analytics2Logger(this);
        }
    }

    Analytics2Logger(Builder builder) {
        UploadSchedulerParamsProvider uploadSchedulerParamsProvider;
        UploadSchedulerParamsProvider uploadSchedulerParamsProvider2;
        MaxEventsPerBatchProvider maxEventsPerBatchProvider;
        this.f3200a = m5364a(builder.f3167b);
        this.f3201b = (C02003) m5366a(builder.f3168c);
        this.f3203d = (NewAnalyticsSamplingPolicy) m5366a(builder.f3176k);
        this.f3204e = builder.f3177l;
        this.f3202c = builder.f3171f;
        this.f3207h = (SessionManager) m5366a(builder.f3175j);
        Context context = (Context) m5366a(builder.f3166a);
        Class cls = (Class) m5366a(builder.f3174i);
        EventListener eventListener = builder.f3172g;
        EventListener eventListener2 = builder.f3173h;
        Class cls2 = builder.f3178m;
        Class a = m5365a(builder.f3179n);
        BatchFixedMetadataHelper batchFixedMetadataHelper = new BatchFixedMetadataHelper(this.f3206g, (FbandroidAppInfoProvider) m5366a(builder.f3169d), (C02012) m5366a(builder.f3170e));
        SessionManager sessionManager = this.f3207h;
        ParamsCollectionPool paramsCollectionPool = this.f3206g;
        C02003 c02003 = builder.f3168c;
        if (builder.f3180o != null) {
            uploadSchedulerParamsProvider = builder.f3180o;
        } else {
            uploadSchedulerParamsProvider = new SimpleUploadSchedulerParamsProvider(f3195i, f3197k);
        }
        if (builder.f3181p != null) {
            uploadSchedulerParamsProvider2 = builder.f3181p;
        } else {
            uploadSchedulerParamsProvider2 = new SimpleUploadSchedulerParamsProvider(f3196j, f3198l);
        }
        if (builder.f3182q != null) {
            maxEventsPerBatchProvider = builder.f3182q;
        } else {
            maxEventsPerBatchProvider = new SimpleMaxEventsPerBatchProvider(50);
        }
        this.f3205f = new EventProcessorManager(context, cls, eventListener, eventListener2, cls2, a, batchFixedMetadataHelper, sessionManager, paramsCollectionPool, c02003, uploadSchedulerParamsProvider, uploadSchedulerParamsProvider2, maxEventsPerBatchProvider);
    }

    @Nonnull
    private static Pools$Pool<EventBuilder> m5364a(@Nullable Pools$Pool<EventBuilder> pools$Pool) {
        return pools$Pool != null ? pools$Pool : new Pools$SynchronizedPool(6);
    }

    private static Class<? extends HandlerThreadFactory> m5365a(@Nullable Class<? extends HandlerThreadFactory> cls) {
        return cls == null ? DefaultHandlerThreadFactory.class : cls;
    }

    @Nonnull
    private static <T> T m5366a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    @Deprecated
    public final EventBuilder m5369a(@Nullable String str, String str2, boolean z, EventLogType eventLogType, boolean z2) {
        if (((BaseAnalyticsConfig) this.f3203d.f3151a.get()).m3564a(str2, z)) {
            return m5367b(str, str2, eventLogType, z2);
        }
        return f3199m;
    }

    @Deprecated
    public final EventBuilder m5368a(@Nullable String str, String str2, EventLogType eventLogType, boolean z) {
        EventBuilder b = m5367b(str, str2, eventLogType, z);
        b.m5385a();
        return b;
    }

    private EventBuilder m5367b(@Nullable String str, String str2, EventLogType eventLogType, boolean z) {
        EventBuilder eventBuilder = (EventBuilder) this.f3200a.mo740a();
        if (eventBuilder == null) {
            eventBuilder = new EventBuilder(true);
        }
        eventBuilder.m5383a(this, str, str2, eventLogType, z);
        return eventBuilder;
    }
}
