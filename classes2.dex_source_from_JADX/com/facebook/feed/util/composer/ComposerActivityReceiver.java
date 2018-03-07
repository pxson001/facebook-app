package com.facebook.feed.util.composer;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.api.feedcache.memory.pendingstory.PendingStoryCache;
import com.facebook.base.broadcast.SafeLocalBroadcastReceiver;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.cache.OfflinePostConfigCache;
import com.facebook.composer.prefs.ComposerPrefKeys;
import com.facebook.composer.publish.cache.pendingstory.PendingStoryStore;
import com.facebook.composer.publish.common.ErrorDetails;
import com.facebook.composer.publish.common.ErrorDetails.Builder;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.composer.publish.common.PostParamsWrapper;
import com.facebook.composer.publish.optimistic.ComposerActivityBroadcaster.Result;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.InterstitialStartHelper;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ufiservices.data.FeedbackLoader;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: position_in_buffer */
public class ComposerActivityReceiver extends SafeLocalBroadcastReceiver {
    private static final Class<?> f9433a = ComposerActivityReceiver.class;
    private static final Listener f9434b = new C04091();
    public Listener f9435c = f9434b;
    public PendingStoryCache f9436d;
    private final DefaultAndroidThreadUtil f9437e;
    private final PendingStoryStore f9438f;
    public final AbstractFbErrorReporter f9439g;
    private final Clock f9440h;
    private final Lazy<FeedbackLoader> f9441i;
    private final InterstitialStartHelper f9442j;
    private final QeAccessor f9443k;
    private final OfflinePostConfigCache f9444l;
    public final OptimisticStoryStateCache f9445m;
    private final InlineCommentComposerCache f9446n;
    private final FbSharedPreferences f9447o;

    /* compiled from: position_in_buffer */
    final class C04091 implements Listener {
        C04091() {
        }

        public final boolean mo1936a(long j, GraphQLStory graphQLStory) {
            return false;
        }

        public final void mo1935a(GraphQLStory graphQLStory) {
        }

        public final void mo1938b(GraphQLStory graphQLStory) {
        }

        public final void mo1934a() {
        }

        public final void mo1937b() {
        }
    }

    /* compiled from: position_in_buffer */
    public interface Listener {
        void mo1934a();

        void mo1935a(GraphQLStory graphQLStory);

        boolean mo1936a(long j, GraphQLStory graphQLStory);

        void mo1937b();

        void mo1938b(GraphQLStory graphQLStory);
    }

    public static ComposerActivityReceiver m14428b(InjectorLike injectorLike) {
        return new ComposerActivityReceiver((Context) injectorLike.getInstance(Context.class), DefaultAndroidThreadUtil.m1646b(injectorLike), PendingStoryStore.m14442a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), IdBasedLazy.m1808a(injectorLike, 3530), InterstitialStartHelper.m13670b(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), OfflinePostConfigCache.m14456a(injectorLike), OptimisticStoryStateCache.m9726a(injectorLike), InlineCommentComposerCache.m14459a(injectorLike));
    }

    public static ComposerActivityReceiver m14421a(InjectorLike injectorLike) {
        return m14428b(injectorLike);
    }

    public final void m14430a(Listener listener, PendingStoryCache pendingStoryCache) {
        this.f9435c = listener;
        this.f9436d = pendingStoryCache;
        super.m12857a();
    }

    @Inject
    public ComposerActivityReceiver(Context context, AndroidThreadUtil androidThreadUtil, PendingStoryStore pendingStoryStore, FbErrorReporter fbErrorReporter, Clock clock, Lazy<FeedbackLoader> lazy, InterstitialStartHelper interstitialStartHelper, FbSharedPreferences fbSharedPreferences, QeAccessor qeAccessor, OfflinePostConfigCache offlinePostConfigCache, OptimisticStoryStateCache optimisticStoryStateCache, InlineCommentComposerCache inlineCommentComposerCache) {
        IntentFilter intentFilter = new IntentFilter("com.facebook.STREAM_PUBLISH_COMPLETE");
        intentFilter.addAction("com.facebook.STREAM_PUBLISH_START");
        intentFilter.addAction("com.facebook.STREAM_PUBLISH_PROGRESS");
        intentFilter.addAction("com.facebook.STREAM_PUBLISH_RESTART");
        intentFilter.addAction("com.facebook.STREAM_PUBLISH_MEDIA_PROCESSING_COMPLETE");
        super(context, intentFilter);
        this.f9437e = androidThreadUtil;
        this.f9438f = pendingStoryStore;
        this.f9439g = fbErrorReporter;
        this.f9440h = clock;
        this.f9441i = lazy;
        this.f9442j = interstitialStartHelper;
        this.f9447o = fbSharedPreferences;
        this.f9443k = qeAccessor;
        this.f9444l = offlinePostConfigCache;
        this.f9445m = optimisticStoryStateCache;
        this.f9446n = inlineCommentComposerCache;
    }

    public final void mo1730a(Context context, Intent intent) {
        this.f9442j.m13672a(context, new InterstitialTrigger(Action.POST_CREATED), InterstitialController.class, null);
        String action = intent.getAction();
        String stringExtra = intent.getStringExtra("extra_request_id");
        if (stringExtra == null) {
            BLog.b(f9433a, "Story published does not have a request id");
            return;
        }
        String stringExtra2 = intent.getStringExtra("extra_legacy_api_post_id");
        GraphQLStory graphQLStory = (GraphQLStory) intent.getParcelableExtra("extra_feed_story");
        if (Strings.isNullOrEmpty(stringExtra2) && graphQLStory != null) {
            stringExtra2 = Strings.nullToEmpty(graphQLStory.ai());
        }
        GraphQLStory a = this.f9436d.m9712a(stringExtra, stringExtra2);
        if (a != null) {
            graphQLStory = a;
        }
        if (graphQLStory == null) {
            BLog.a(f9433a, "No story available to show. Action:%s", new Object[]{action});
            return;
        }
        if ("com.facebook.STREAM_PUBLISH_COMPLETE".equals(action)) {
            long a2 = this.f9440h.mo211a();
            this.f9447o.edit().mo1275a(ComposerPrefKeys.f2673p, a2).commit();
            if (StoryAttachmentHelper.m28039l(graphQLStory)) {
                this.f9447o.edit().mo1275a(ComposerPrefKeys.f2677t, a2).commit();
            }
        }
        if (this.f9435c.mo1936a(intent.getLongExtra("extra_target_id", -1), graphQLStory)) {
            boolean a3 = m14427a(action, stringExtra, stringExtra2, intent);
            if (!a3 && "com.facebook.STREAM_PUBLISH_COMPLETE".equals(action)) {
                this.f9435c.mo1934a();
            } else if (a3 && "com.facebook.STREAM_PUBLISH_START".equals(action)) {
                this.f9435c.mo1935a(graphQLStory);
            }
        }
    }

    private boolean m14427a(String str, String str2, String str3, Intent intent) {
        GraphQLStory graphQLStory;
        if ("com.facebook.STREAM_PUBLISH_START".equals(str)) {
            graphQLStory = (GraphQLStory) intent.getParcelableExtra("extra_feed_story");
            if (m14426a(str2, str3)) {
                this.f9436d.m9715a(str2);
                this.f9436d.m9718b(str3);
            } else if (graphQLStory == null) {
                BLog.b(f9433a, "Pending story is null with request id " + str2);
                return false;
            }
            m14422a(this, str2, str3, graphQLStory);
        } else if ("com.facebook.STREAM_PUBLISH_PROGRESS".equals(str)) {
            if (m14426a(str2, str3)) {
                Optional d = this.f9438f.m14453d(str2);
                int intExtra = intent.getIntExtra("extra_percent_progress", 0);
                if (d.isPresent()) {
                    graphQLStory = ((PendingStory) d.get()).a();
                    if (this.f9445m.m9728a(graphQLStory) != GraphQLFeedOptimisticPublishState.POSTING) {
                        this.f9445m.m9729a(graphQLStory, GraphQLFeedOptimisticPublishState.POSTING);
                    }
                    if (!((PendingStory) d.get()).f()) {
                        ((PendingStory) d.get()).b(this.f9440h.mo211a(), true);
                    }
                    PendingStory pendingStory = (PendingStory) d.get();
                    long a = this.f9440h.mo211a();
                    if (pendingStory.c.e()) {
                        pendingStory.c.c(a, Math.min(990, Math.max(pendingStory.d, intExtra)));
                    }
                }
            } else {
                BLog.b(f9433a, "Pending story doesn't exist with request id %s (publish_begin)", new Object[]{str2});
                return false;
            }
        } else if ("com.facebook.STREAM_PUBLISH_RESTART".equals(str)) {
            Optional d2 = this.f9438f.m14453d(str2);
            if (d2.isPresent()) {
                ((PendingStory) d2.get()).a(this.f9440h.mo211a(), true);
            }
        } else {
            graphQLStory = (GraphQLStory) intent.getParcelableExtra("graphql_story");
            Result valueOf = Result.valueOf(intent.getStringExtra("extra_result"));
            if (!m14426a(str2, str3)) {
                BLog.b(f9433a, "Pending story doesn't exist with request id %s (publish_fail)", new Object[]{str2});
                return false;
            } else if (str3 == null) {
                if (valueOf == Result.EXCEPTION) {
                    ErrorDetails errorDetails = (ErrorDetails) intent.getParcelableExtra("extra_error_details");
                    if (errorDetails == null) {
                        errorDetails = new Builder().a();
                    }
                    m14424a(str2, str3, errorDetails);
                } else {
                    this.f9436d.m9715a(str2);
                    this.f9436d.m9718b(str3);
                }
                BLog.b(f9433a, "Pending story doesn't exist with request id %s (id is null)", new Object[]{str2});
                return false;
            } else {
                m14425a(str2, str3, graphQLStory, str);
            }
        }
        return true;
    }

    private void m14424a(String str, String str2, ErrorDetails errorDetails) {
        Preconditions.checkNotNull(errorDetails);
        GraphQLStory a = this.f9436d.m9712a(str, str2);
        if (a != null) {
            Optional d = this.f9438f.m14453d(a.m22334T());
            if (d.isPresent()) {
                PostParamsWrapper b = ((PendingStory) d.get()).b();
                long a2 = this.f9440h.mo211a();
                long c = b.c() * 1000;
                if (a2 - c > 2592000000L) {
                    this.f9439g.m2340a("offline_post_expired", "requestId=" + str + ", originalPostTimeMs=" + c + ", nowMs=" + a2);
                    Builder builder = new Builder();
                    builder.a = false;
                    errorDetails = builder.a("").a();
                }
                this.f9445m.m9729a(a, errorDetails.isVideoTranscodingError ? GraphQLFeedOptimisticPublishState.TRANSCODING_FAILED : GraphQLFeedOptimisticPublishState.FAILED);
                b.a(errorDetails);
                this.f9438f.m14448a(b, null);
            }
        }
    }

    private void m14425a(String str, String str2, GraphQLStory graphQLStory, String str3) {
        GraphQLStory a = this.f9436d.m9712a(str, str2);
        if (a != null) {
            boolean equals = "com.facebook.STREAM_PUBLISH_MEDIA_PROCESSING_COMPLETE".equals(str3);
            if (graphQLStory != null) {
                GraphQLStory a2 = OptimisticPostStoryBuilder.a(a, graphQLStory, str2);
                this.f9444l.f9463a.m4433a(Integer.valueOf(a2.hashCode()), this.f9444l.m14457a(a));
                this.f9445m.m9729a(a2, equals ? GraphQLFeedOptimisticPublishState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE : GraphQLFeedOptimisticPublishState.SUCCESS);
                if (this.f9443k.mo596a(ExperimentsForFeedUtilComposerAbtestModule.ak, false)) {
                    this.f9446n.m14462a(a2, null, Boolean.valueOf(true));
                }
                m14422a(this, str, str2, a2);
                this.f9435c.mo1938b(a2);
            } else if (StoryAttachmentHelper.m28037j(a) || StoryAttachmentHelper.m28039l(a) || StoryAttachmentHelper.m28040m(a)) {
                this.f9445m.m9729a(a, GraphQLFeedOptimisticPublishState.SUCCESS);
                m14423a(a, str, str2);
            } else if (OptimisticPostStoryBuilder.a(a)) {
                this.f9437e.m1651a(((FeedbackLoader) this.f9441i.get()).a(a.ai(), DataFreshnessParam.STALE_DATA_OKAY, RequestPriority.NON_INTERACTIVE, null), new 2(this, a, str, str2));
            } else {
                throw new IllegalStateException("Non-album story was not pre-fetched! requestId=" + str + ", postId=" + str2);
            }
        }
    }

    private void m14423a(GraphQLStory graphQLStory, String str, String str2) {
        GraphQLStory.Builder a = GraphQLStory.Builder.a(graphQLStory);
        GraphQLFeedback.Builder builder = new GraphQLFeedback.Builder();
        builder.A = (String) Preconditions.checkNotNull(str2);
        a.D = builder.b(true).f(false).a();
        GraphQLStory.Builder builder2 = a;
        builder2.F = SystemClock.f762a.mo211a();
        builder2 = builder2;
        builder2.P = str2;
        builder2 = builder2;
        builder2.al = OptimisticPostStoryBuilder.b(graphQLStory, str2);
        GraphQLStory a2 = builder2.a();
        m14422a(this, str, str2, a2);
        this.f9435c.mo1938b(a2);
    }

    public final void mo1933b() {
        super.mo1933b();
        this.f9435c = f9434b;
    }

    private boolean m14426a(String str, String str2) {
        if (!this.f9436d.m9722d(str) && this.f9436d.m9723e(str2) == null) {
            return false;
        }
        return true;
    }

    public static void m14422a(ComposerActivityReceiver composerActivityReceiver, String str, String str2, GraphQLStory graphQLStory) {
        if (composerActivityReceiver.f9436d.m9723e(str2) == null || !composerActivityReceiver.f9436d.m9717a(graphQLStory)) {
            composerActivityReceiver.f9436d.m9716a(str, graphQLStory);
        }
    }
}
