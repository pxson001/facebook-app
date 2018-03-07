package com.facebook.video.videohome.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.device.ScreenUtil;
import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.calls.VideoChannelSetPinStateInputData.Surface;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLResult.Builder;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.topics.data.TopicListFetcher;
import com.facebook.topics.protocol.TopicFavoritesQuery.VideoTopicListString;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.VideoTopicListModel;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.video.analytics.VideoAnalytics.CacheStatus;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.TTIType;
import com.facebook.video.engine.ExitFullScreenResult;
import com.facebook.video.videohome.adapter.VideoHomeGuideAdapter;
import com.facebook.video.videohome.adapter.VideoHomeGuideAdapterProvider;
import com.facebook.video.videohome.adapter.viewholders.DefaultTopicClickListener;
import com.facebook.video.videohome.adapter.viewholders.DefaultTopicClickListenerProvider;
import com.facebook.video.videohome.logging.VideoHomeLoggingUtils;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.recyclerview.BetterGridLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import javax.inject.Inject;

/* compiled from: ssn_last_four */
public class VideoHomeGuideFragment extends FbFragment implements AnalyticsFragment {
    @Inject
    public DefaultTopicClickListenerProvider f2908a;
    @Inject
    Toaster al;
    @Inject
    TopicListFetcher am;
    public BetterRecyclerView an;
    public AbstractDisposableFutureCallback<GraphQLResult<VideoTopicListModel>> ao;
    public GridLayoutManager ap;
    public Intent aq;
    public LoadingIndicatorView ar;
    public OnDrawListener as;
    public VideoTopicListModel at;
    public VideoHomeGuideAdapter au;
    public DefaultTopicClickListener av;
    public String aw;
    @Inject
    public Fb4aTitleBarSupplier f2909b;
    @Inject
    AbstractFbErrorReporter f2910c;
    @Inject
    public GraphQLSubscriptionHolder f2911d;
    @Inject
    MonotonicClock f2912e;
    @Inject
    VideoHomeGuideAdapterProvider f2913f;
    @Inject
    VideoHomeLoggingUtils f2914g;
    @Inject
    public ScreenUtil f2915h;
    @Inject
    TasksManager f2916i;

    /* compiled from: ssn_last_four */
    public class C02681 extends AbstractDisposableFutureCallback {
        final /* synthetic */ VideoHomeGuideFragment f2901a;

        public C02681(VideoHomeGuideFragment videoHomeGuideFragment) {
            this.f2901a = videoHomeGuideFragment;
        }

        protected final void m2805a(Object obj) {
            Activity ao = this.f2901a.ao();
            if (ao != null) {
                ao.setResult(-1);
            }
        }

        protected final void m2806a(Throwable th) {
            this.f2901a.al.a(new ToastBuilder(this.f2901a.b(2131237324)));
            this.f2901a.f2910c.a(getClass().getSimpleName(), "Failed to pin/unpin topic", th);
        }
    }

    /* compiled from: ssn_last_four */
    public class C02692 implements FullscreenTransitionListener {
        final /* synthetic */ VideoHomeGuideFragment f2902a;

        public C02692(VideoHomeGuideFragment videoHomeGuideFragment) {
            this.f2902a = videoHomeGuideFragment;
        }

        public final void m2807a(ExitFullScreenResult exitFullScreenResult) {
        }
    }

    /* compiled from: ssn_last_four */
    class C02703 extends SpanSizeLookup {
        final /* synthetic */ VideoHomeGuideFragment f2903b;

        C02703(VideoHomeGuideFragment videoHomeGuideFragment) {
            this.f2903b = videoHomeGuideFragment;
        }

        public final int m2808a(int i) {
            VideoHomeGuideFragment videoHomeGuideFragment = this.f2903b;
            int i2 = videoHomeGuideFragment.ap.c;
            if (videoHomeGuideFragment.au.m2643e(i) != 0) {
                i2 = 1;
            }
            return i2;
        }
    }

    /* compiled from: ssn_last_four */
    class C02714 implements RetryClickedListener {
        final /* synthetic */ VideoHomeGuideFragment f2904a;

        C02714(VideoHomeGuideFragment videoHomeGuideFragment) {
            this.f2904a = videoHomeGuideFragment;
        }

        public final void m2809a() {
            this.f2904a.ar.a();
            VideoHomeGuideFragment.av(this.f2904a);
        }
    }

    /* compiled from: ssn_last_four */
    public class C02736 extends AbstractDisposableFutureCallback<GraphQLResult<VideoTopicListModel>> {
        final /* synthetic */ VideoHomeGuideFragment f2907a;

        public C02736(VideoHomeGuideFragment videoHomeGuideFragment) {
            this.f2907a = videoHomeGuideFragment;
        }

        protected final void m2810a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null) {
                VideoHomeGuideFragment.aw(this.f2907a);
            } else {
                VideoHomeGuideFragment.m2815b(this.f2907a, (VideoTopicListModel) graphQLResult.e);
            }
        }

        protected final void m2811a(Throwable th) {
            VideoHomeGuideFragment.aw(this.f2907a);
        }
    }

    public static void m2813a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((VideoHomeGuideFragment) obj).m2812a((DefaultTopicClickListenerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(DefaultTopicClickListenerProvider.class), Fb4aTitleBarSupplier.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), GraphQLSubscriptionHolder.b(fbInjector), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(fbInjector), (VideoHomeGuideAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(VideoHomeGuideAdapterProvider.class), VideoHomeLoggingUtils.a(fbInjector), ScreenUtil.a(fbInjector), TasksManager.b(fbInjector), Toaster.b(fbInjector), TopicListFetcher.b(fbInjector));
    }

    public static void av(VideoHomeGuideFragment videoHomeGuideFragment) {
        GraphQLRequest a = GraphQLRequest.a(new VideoTopicListString()).a(900).a(GraphQLCachePolicy.a);
        a.b = true;
        videoHomeGuideFragment.f2916i.a("QUERY_TOPIC_FEEDS_FAVORITES_KEY", videoHomeGuideFragment.f2911d.a(a, videoHomeGuideFragment.ao, "topic_list_model"), videoHomeGuideFragment.ao);
    }

    private void m2812a(DefaultTopicClickListenerProvider defaultTopicClickListenerProvider, Fb4aTitleBarSupplier fb4aTitleBarSupplier, AbstractFbErrorReporter abstractFbErrorReporter, GraphQLSubscriptionHolder graphQLSubscriptionHolder, MonotonicClock monotonicClock, VideoHomeGuideAdapterProvider videoHomeGuideAdapterProvider, VideoHomeLoggingUtils videoHomeLoggingUtils, ScreenUtil screenUtil, TasksManager tasksManager, Toaster toaster, TopicListFetcher topicListFetcher) {
        this.f2908a = defaultTopicClickListenerProvider;
        this.f2909b = fb4aTitleBarSupplier;
        this.f2910c = abstractFbErrorReporter;
        this.f2911d = graphQLSubscriptionHolder;
        this.f2912e = monotonicClock;
        this.f2913f = videoHomeGuideAdapterProvider;
        this.f2914g = videoHomeLoggingUtils;
        this.f2915h = screenUtil;
        this.f2916i = tasksManager;
        this.al = toaster;
        this.am = topicListFetcher;
    }

    public final void m2821c(Bundle bundle) {
        super.c(bundle);
        Class cls = VideoHomeGuideFragment.class;
        m2813a((Object) this, getContext());
        Bundle extras = ao().getIntent().getExtras();
        if (extras != null) {
            this.aw = extras.getString("reaction_session_id");
        }
        this.av = this.f2908a.m2653a(new C02681(this), getContext(), this.aw, PlayerOrigin.VIDEO_HOME_GUIDE, Surface.VIDEO_HOME_GUIDE, new C02692(this));
        this.au = new VideoHomeGuideAdapter(this.av);
        this.ao = new C02736(this);
        Object a = FlatBufferModelHelper.a(bundle, "topic_list_model_key");
        if (!(a instanceof VideoTopicListModel) || ((VideoTopicListModel) a).a().isEmpty()) {
            this.aq = ao().getIntent();
            final long longExtra = this.aq.getLongExtra("guide_fragment_tti_marker_extra", 0);
            this.as = new OnDrawListener(this) {
                final /* synthetic */ VideoHomeGuideFragment f2906b;

                public final boolean gD_() {
                    this.f2906b.f2914g.a(PlayerOrigin.VIDEO_HOME_GUIDE, TTIType.GUIDE_LOADING, CacheStatus.NOT_PREFETCHED, this.f2906b.f2912e.now() - longExtra);
                    this.f2906b.as = null;
                    return true;
                }
            };
            av(this);
            return;
        }
        this.at = (VideoTopicListModel) a;
        m2815b(this, this.at);
        VideoTopicListModel videoTopicListModel = this.at;
        Builder builder = new Builder();
        builder.k = videoTopicListModel;
        this.f2911d.a(this.ao, "topic_list_model", builder.a());
    }

    public final View m2819a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -599698252);
        View inflate = layoutInflater.inflate(2130907715, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1860878374, a);
        return inflate;
    }

    public final void m2820a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        Fb4aTitleBar fb4aTitleBar = this.f2909b.a;
        fb4aTitleBar.setTitle(2131237307);
        fb4aTitleBar.setSearchButtonVisible(false);
        this.ar = (LoadingIndicatorView) e(2131568424);
        this.ar.k = 0;
        if (this.at == null) {
            this.ar.a();
        }
        m2814b(view);
    }

    public void onConfigurationChanged(Configuration configuration) {
        au();
        super.onConfigurationChanged(configuration);
    }

    public final void m2816G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1012567287);
        super.G();
        this.f2911d.e();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2008391623, a);
    }

    public final void m2822e(Bundle bundle) {
        if (this.at != null) {
            FlatBufferModelHelper.a(bundle, "topic_list_model_key", this.at);
        }
    }

    public final void m2817H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -866982366);
        this.f2911d.d();
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 411965735, a);
    }

    public final void m2818I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 254449205);
        this.f2911d.a();
        this.f2916i.c();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 87883615, a);
    }

    public final String am_() {
        return "video_home_guide";
    }

    private void m2814b(View view) {
        this.an = (BetterRecyclerView) view.findViewById(2131559427);
        this.ap = new BetterGridLayoutManager(getContext(), at());
        this.ap.h = new C02703(this);
        this.an.setLayoutManager(this.ap);
        this.an.setAdapter(this.au);
    }

    private int at() {
        return (int) ((0 == 1 ? (float) this.f2915h.d() : (float) this.f2915h.c()) / jW_().getDimension(2131431523));
    }

    private void au() {
        if (this.ap != null) {
            this.ap.a(at());
            this.an.setLayoutManager(this.ap);
        }
    }

    public static void m2815b(VideoHomeGuideFragment videoHomeGuideFragment, VideoTopicListModel videoTopicListModel) {
        if (!videoTopicListModel.a().isEmpty()) {
            videoHomeGuideFragment.at = videoTopicListModel;
            if (!(videoHomeGuideFragment.aq.getLongExtra("guide_fragment_tti_marker_extra", 0) == 0 || videoHomeGuideFragment.an == null || videoHomeGuideFragment.as == null)) {
                videoHomeGuideFragment.an.a(videoHomeGuideFragment.as);
            }
            VideoHomeGuideAdapter videoHomeGuideAdapter = videoHomeGuideFragment.au;
            videoHomeGuideAdapter.f2749a = videoHomeGuideFragment.at;
            videoHomeGuideAdapter.notifyDataSetChanged();
            if (videoHomeGuideFragment.ar != null) {
                videoHomeGuideFragment.ar.b();
            }
        } else if (videoHomeGuideFragment.hn_() && videoHomeGuideFragment.ar != null) {
            videoHomeGuideFragment.ar.a(videoHomeGuideFragment.jW_().getString(2131237318), null);
        }
    }

    public static void aw(VideoHomeGuideFragment videoHomeGuideFragment) {
        if (videoHomeGuideFragment.hn_() && videoHomeGuideFragment.ar != null) {
            videoHomeGuideFragment.ar.a(videoHomeGuideFragment.jW_().getString(2131230811), new C02714(videoHomeGuideFragment));
        }
    }
}
