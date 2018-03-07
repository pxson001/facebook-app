package com.facebook.backstage.consumption;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger;
import com.facebook.backstage.consumption.ProfilesDataProvider.BackstageProfileObserver;
import com.facebook.backstage.data.BackstageProfile;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: savedAudienceTargeting */
public class BackstagePrefetchService extends FbIntentService {
    public static final String f4559a = BackstagePrefetchService.class.getSimpleName();
    @Inject
    BackstageAnalyticsLogger f4560b;
    @Inject
    ProfilesDataProvider f4561c;
    @Inject
    Context f4562d;
    private final CallerContext f4563e = CallerContext.a(BackstagePrefetchService.class);
    public final BackstageProfileObserver f4564f = new C04431(this);

    /* compiled from: savedAudienceTargeting */
    class C04431 implements BackstageProfileObserver {
        final /* synthetic */ BackstagePrefetchService f4558a;

        C04431(BackstagePrefetchService backstagePrefetchService) {
            this.f4558a = backstagePrefetchService;
        }

        public final void mo151a(ImmutableList<BackstageProfile> immutableList, ImmutableList<BackstageProfile> immutableList2) {
            this.f4558a.f4560b.f4267b.g("backstage_cache");
            this.f4558a.f4561c.m4546b(this.f4558a.f4564f);
        }
    }

    private static <T extends Context> void m4512a(Class<T> cls, T t) {
        m4513a((Object) t, (Context) t);
    }

    public static void m4513a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BackstagePrefetchService) obj).m4510a(BackstageAnalyticsLogger.m4259a(injectorLike), ProfilesDataProvider.m4540a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    private void m4510a(BackstageAnalyticsLogger backstageAnalyticsLogger, ProfilesDataProvider profilesDataProvider, Context context) {
        this.f4560b = backstageAnalyticsLogger;
        this.f4561c = profilesDataProvider;
        this.f4562d = context;
    }

    public BackstagePrefetchService() {
        super(f4559a);
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 65190119);
        super.onCreate();
        Class cls = BackstagePrefetchService.class;
        m4513a((Object) this, (Context) this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -601269825, a);
    }

    protected final void m4515a(Intent intent) {
        if ("PREFETCH_GRAPHQL".equals(intent.getAction())) {
            m4514b();
        } else if ("PREFTCH_MEDIA".equals(intent.getAction())) {
            Fresco.a(this.f4562d);
            m4511a(this.f4563e, intent.getParcelableArrayListExtra("MEDIA_URIS"));
        } else {
            BLog.b(f4559a, "Wrong intent action");
        }
    }

    private void m4514b() {
        this.f4560b.f4267b.f("backstage_cache");
        this.f4561c.m4542a(this.f4564f);
        this.f4561c.m4545a(false);
    }

    private static void m4511a(CallerContext callerContext, ArrayList<Uri> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            ImagePipeline h = ImagePipelineFactory.a().h();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                h.f(ImageRequestBuilder.a((Uri) arrayList.get(i)).m(), callerContext);
            }
        }
    }
}
