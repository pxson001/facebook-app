package com.facebook.feed.fragment.controllercallbacks;

import android.content.Context;
import android.provider.MediaStore.Images.Media;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.api.Holder;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.logging.FeedLoggingUtil;
import com.facebook.feed.platformads.ScreenshotContentObserver;
import com.facebook.feed.platformads.ScreenshotContentObserverProvider;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.unit.FeedUnitHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.FeedTrackableUtil;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.inject.Inject;

/* compiled from: photosbycategory/?page_id=%s */
public class NewsFeedScreenshotController extends BaseController implements ResumePauseCallbacks {
    private final ScreenshotListener f9892a = new ScreenshotListener(this);
    private final NewsFeedAnalyticsEventBuilder f9893b;
    private final AnalyticsLogger f9894c;
    private final ScreenshotContentObserverProvider f9895d;
    public final GatekeeperStoreImpl f9896e;
    private final ObjectMapper f9897f;
    private ScreenshotContentObserver f9898g;
    public Context f9899h;
    public Holder<ListItemCollection<FeedEdge>> f9900i;
    public NewsFeedViewController f9901j;

    /* compiled from: photosbycategory/?page_id=%s */
    public class ScreenshotListener {
        final /* synthetic */ NewsFeedScreenshotController f9902a;

        public ScreenshotListener(NewsFeedScreenshotController newsFeedScreenshotController) {
            this.f9902a = newsFeedScreenshotController;
        }

        public final void m14930a() {
            if (this.f9902a.f9901j.mo1997n() != null) {
                FeedUnit a = FeedUnitHelper.m21141a((GraphQLFeedUnitEdge) ((ListItemCollection) this.f9902a.f9900i.f10429a).mo1375a(this.f9902a.f9901j.f10397b.m18035D()));
                if (FeedLoggingUtil.m14269a((Object) a)) {
                    NewsFeedScreenshotController.m14927a(this.f9902a, FeedTrackableUtil.m27148a(a));
                }
            }
        }
    }

    public static NewsFeedScreenshotController m14926a(InjectorLike injectorLike) {
        return new NewsFeedScreenshotController(NewsFeedAnalyticsEventBuilder.m14112a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), (ScreenshotContentObserverProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ScreenshotContentObserverProvider.class), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), FbObjectMapperMethodAutoProvider.m6609a(injectorLike));
    }

    @Inject
    public NewsFeedScreenshotController(NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger, ScreenshotContentObserverProvider screenshotContentObserverProvider, GatekeeperStoreImpl gatekeeperStoreImpl, ObjectMapper objectMapper) {
        this.f9893b = newsFeedAnalyticsEventBuilder;
        this.f9894c = analyticsLogger;
        this.f9895d = screenshotContentObserverProvider;
        this.f9896e = gatekeeperStoreImpl;
        this.f9897f = objectMapper;
    }

    public final void mo1264c() {
        boolean z = true;
        boolean a = this.f9896e.m2189a(1003, false);
        boolean z2;
        if (this.f9899h.checkCallingOrSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!(a && r6)) {
            z = false;
        }
        if (z) {
            InjectorLike injectorLike = this.f9895d;
            this.f9898g = new ScreenshotContentObserver(SystemClockMethodAutoProvider.m1498a(injectorLike), this.f9899h.getApplicationContext(), Handler_ForNonUiThreadMethodAutoProvider.m5523b(injectorLike), FeedEventBus.m4573a(injectorLike));
            this.f9899h.getContentResolver().registerContentObserver(Media.EXTERNAL_CONTENT_URI, true, this.f9898g);
            this.f9898g.f14085g = this.f9892a;
        }
    }

    public final void mo1265d() {
        if (this.f9898g != null) {
            this.f9898g.f14085g = null;
            this.f9899h.getContentResolver().unregisterContentObserver(this.f9898g);
            this.f9898g = null;
        }
    }

    public static void m14927a(NewsFeedScreenshotController newsFeedScreenshotController, JsonNode jsonNode) {
        if (newsFeedScreenshotController.f9893b != null && newsFeedScreenshotController.f9894c != null) {
            JsonNode a = jsonNode.mo708a(0);
            if (a != null) {
                try {
                    a = newsFeedScreenshotController.f9897f.m6636a(a.mo719B()).mo709b("ei");
                    if (a != null) {
                        newsFeedScreenshotController.f9894c.mo534d(NewsFeedAnalyticsEventBuilder.m14123f(a.mo719B()));
                    }
                } catch (IOException e) {
                }
            }
        }
    }
}
