package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.api.story.FetchSingleStoryParams.FetchType;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.attachments.photos.PhotoAttachmentLayoutHelper;
import com.facebook.attachments.photos.launcherhelper.PhotoGalleryLauncherHelper;
import com.facebook.attachments.photos.ui.HasPhotoAttachment;
import com.facebook.attachments.videos.ui.FullscreenVideoAttachmentView;
import com.facebook.attachments.videos.ui.InlineVideoAttachmentView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.drawee.view.DraweeView;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.feed.analytics.vpvlogging.VpvEventHelper;
import com.facebook.feed.fragment.generatedenvironments.HasPrefetcherImplProvider;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.OneItemListItemCollection;
import com.facebook.feed.rows.adapter.api.ListItemCollectionEndProvider;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.rows.photosfeed.PhotosFeedEventSubscriptions.LikeClickSubscriber;
import com.facebook.feed.rows.photosfeed.PhotosFeedEventSubscriptions.LikeUpdatedEventSubscriber;
import com.facebook.feed.rows.photosfeed.PhotosFeedEventSubscriptions.ReactionUpdatedSubscriber;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherFactory;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherWrapper;
import com.facebook.feed.util.StoryEventSubscriberManager;
import com.facebook.feedback.ui.RootFeedbackEventSubscriber;
import com.facebook.feedback.ui.RootFeedbackEventSubscriberProvider;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.data.protocol.PhotosMetadataConversionHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.dialog.PhotoAnimationContentFragment;
import com.facebook.photos.dialog.PhotoAnimationDialogFragment;
import com.facebook.photos.dialog.PhotoAnimationDialogFragment$3;
import com.facebook.photos.dialog.util.PhotosDialogPerfUtil;
import com.facebook.photos.dialog.util.PhotosDialogPerfUtil.FragmentPerfMarkerConfig;
import com.facebook.photos.galleryutil.GlobalOnLayoutHelper;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.photos.mediafetcher.MediaFetcherFactory;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcher;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcher.MediaFetcherListener;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcher.Status;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcherConstructionRule;
import com.facebook.photos.mediagallery.abtest.ExperimentsForMediaGalleryAbTestModule;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParamProvider;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParams;
import com.facebook.photos.mediagallery.launcher.animation.DrawingRule;
import com.facebook.photos.mediagallery.util.MediaMetadataParcelUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ufiservices.data.FeedbackLoader;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.listview.BaseProxyOnScrollListener;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.listview.MultiAdapterListAdapter;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.LayoutManagerWithKeepAttachedHack;
import com.facebook.widget.recyclerview.RecyclerViewProxy;
import com.facebook.widget.viewdiagnostics.ViewDiagnosticsWrapper;
import com.google.common.base.Absent;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: aPosition */
public class PhotosFeedFragment extends PhotoAnimationContentFragment implements AnalyticsFragment {
    private static final CallerContext aA = CallerContext.a(PhotosFeedFragment.class, "photos_feed");
    private static final PhotosFeedTTISequence aB = new PhotosFeedTTISequence();
    @Inject
    MultipleRowsStoriesRecycleCallback f20232a;
    public MediaFetcher aC;
    public ScrollingViewProxy aD;
    private MultiAdapterListAdapter aE;
    public MultiRowAdapter aF;
    public MultiRowAdapter aG;
    public FrameRateLogger aH;
    private OneItemListItemCollection aI = new OneItemListItemCollection();
    public FeedProps<GraphQLStory> aJ;
    private RootFeedbackEventSubscriber aK;
    private PhotosFeedEventSubscriptions aL;
    public MediaMetadataListCollection aM = new MediaMetadataListCollection();
    private PhotosFeedListener aN = new PhotosFeedListener(this);
    private OnGlobalLayoutListener aO;
    public PhotoAnimationDialogFragment$3 aP;
    public int aQ;
    private MultiRowImagePrefetcherWrapper aR;
    private BaseProxyOnScrollListener aS;
    private long aT;
    public boolean aU;
    @Inject
    StoryEventSubscriberManager al;
    @Inject
    RootFeedbackEventSubscriberProvider am;
    @Inject
    MediaFetcherFactory an;
    @Inject
    CanLaunchMediaGalleryImplProvider ao;
    @Inject
    Lazy<MediaMetadataParcelUtil> ap;
    @Inject
    PhotoAttachmentLayoutHelper aq;
    @Inject
    @CustomSnowFlakeBackgroundColor
    Provider<Integer> ar;
    @Inject
    Resources as;
    @Inject
    MultiRowImagePrefetcherFactory at;
    @Inject
    HasPrefetcherImplProvider au;
    @Inject
    AbstractFbErrorReporter av;
    @Inject
    VpvEventHelper aw;
    @Inject
    Clock ax;
    @Inject
    PhotosDialogPerfUtil ay;
    @Inject
    QeAccessor az;
    @Inject
    FrameRateLoggerProvider f20233b;
    @Inject
    public FeedbackLoader f20234c;
    @Inject
    public TasksManager f20235d;
    @Inject
    FeedStoryMutator f20236e;
    @Inject
    MultiRowAdapterBuilder f20237f;
    @Inject
    DefaultPhotosFeedPartDefinitionResolver f20238g;
    @Inject
    PhotosFeedEnvironmentProvider f20239h;
    @Inject
    PhotosFeedEventSubscriptionsProvider f20240i;

    /* compiled from: aPosition */
    class C17431 implements Function<GraphQLFeedback, Void> {
        final /* synthetic */ PhotosFeedFragment f20221a;

        C17431(PhotosFeedFragment photosFeedFragment) {
            this.f20221a = photosFeedFragment;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
            FeedStoryMutator feedStoryMutator = this.f20221a.f20236e;
            PhotosFeedFragment.m23362a(this.f20221a, FeedStoryMutator.a((GraphQLStory) this.f20221a.aJ.a, graphQLFeedback));
            return null;
        }
    }

    /* compiled from: aPosition */
    class C17442 implements Function<GraphQLStory, Void> {
        final /* synthetic */ PhotosFeedFragment f20222a;

        C17442(PhotosFeedFragment photosFeedFragment) {
            this.f20222a = photosFeedFragment;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            PhotosFeedFragment.m23362a(this.f20222a, (GraphQLStory) obj);
            return null;
        }
    }

    /* compiled from: aPosition */
    class C17453 implements AnimationParamProvider {
        final /* synthetic */ PhotosFeedFragment f20223a;

        C17453(PhotosFeedFragment photosFeedFragment) {
            this.f20223a = photosFeedFragment;
        }

        @Nullable
        public final AnimationParams mo47a(String str) {
            int b = PhotosFeedFragment.m23369b(this.f20223a, str);
            if (b < 0) {
                return null;
            }
            View g = PhotosFeedFragment.m23370g(this.f20223a, b);
            if (g != null) {
                return new AnimationParams(PhotoGalleryLauncherHelper.m895a(g), ImageRequest.a(this.f20223a.aM.m23227b(b).g().b()));
            }
            return null;
        }
    }

    /* compiled from: aPosition */
    class C17464 implements Callable<FeedProps<GraphQLStory>> {
        final /* synthetic */ PhotosFeedFragment f20224a;

        C17464(PhotosFeedFragment photosFeedFragment) {
            this.f20224a = photosFeedFragment;
        }

        public Object call() {
            return this.f20224a.aJ;
        }
    }

    /* compiled from: aPosition */
    class C17475 implements Runnable {
        final /* synthetic */ PhotosFeedFragment f20225a;

        C17475(PhotosFeedFragment photosFeedFragment) {
            this.f20225a = photosFeedFragment;
        }

        public void run() {
            PhotosFeedFragment.ax(this.f20225a);
        }
    }

    /* compiled from: aPosition */
    class C17486 implements ListItemCollectionEndProvider {
        final /* synthetic */ PhotosFeedFragment f20226a;

        C17486(PhotosFeedFragment photosFeedFragment) {
            this.f20226a = photosFeedFragment;
        }

        public final boolean m23351a() {
            if (this.f20226a.aC == null || !this.f20226a.aU) {
                return false;
            }
            if (this.f20226a.aC.mo599d() || this.f20226a.aC.f10543e == Status.LOADING) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: aPosition */
    class C17497 extends BaseProxyOnScrollListener {
        final /* synthetic */ PhotosFeedFragment f20227a;

        C17497(PhotosFeedFragment photosFeedFragment) {
            this.f20227a = photosFeedFragment;
        }

        public final void m23352a(ScrollingViewProxy scrollingViewProxy, int i) {
            if (i == 0 && this.f20227a.aH.q) {
                this.f20227a.aH.b();
            } else if (i != 0 && !this.f20227a.aH.q) {
                this.f20227a.aH.a();
            }
        }

        public final void m23353a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            PhotosFeedFragment photosFeedFragment = this.f20227a;
            if (photosFeedFragment.aG.s_(i - photosFeedFragment.aF.getCount()) + 1 >= this.f20227a.aQ - 5 && this.f20227a.aC != null && this.f20227a.aC.mo599d()) {
                this.f20227a.aC.m12400a(20);
            }
        }
    }

    /* compiled from: aPosition */
    public class C17508 extends AbstractDisposableFutureCallback<GraphQLResult<GraphQLStory>> {
        final /* synthetic */ PhotosFeedFragment f20228a;

        public C17508(PhotosFeedFragment photosFeedFragment) {
            this.f20228a = photosFeedFragment;
        }

        protected final void m23354a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null) {
                m23355a(new NullPointerException("Fetched story was non-existent"));
                return;
            }
            PhotosFeedFragment.m23362a(this.f20228a, this.f20228a.f20236e.a((GraphQLStory) graphQLResult.e));
        }

        protected final void m23355a(Throwable th) {
        }
    }

    /* compiled from: aPosition */
    public class C17519 implements OnGlobalLayoutListener {
        final /* synthetic */ PhotosFeedFragment f20229a;

        public C17519(PhotosFeedFragment photosFeedFragment) {
            this.f20229a = photosFeedFragment;
        }

        public void onGlobalLayout() {
            ImmutableList immutableList = this.f20229a.aM.f20045a;
            if (immutableList != null && this.f20229a.aJ != null && this.f20229a.aD.C()) {
                if (immutableList.size() == 0) {
                    this.f20229a.av.a("PhotosFeedFragment_emptyMediaMetadataList", StringFormatUtil.formatStrLocaleSafe("GraphQLStory Id is %s", ((GraphQLStory) this.f20229a.aJ.a).c()));
                    return;
                }
                CustomViewUtils.a(this.f20229a.aD.ix_(), this);
                int i = this.f20229a.s.getInt("starting_index");
                this.f20229a.aD.a(PhotosFeedFragment.m23360a(this.f20229a, i, PhotosFeedFragment.m23358a(this.f20229a, PhotosMetadataConversionHelper.a(this.f20229a.aM.m23227b(i))), 0));
            }
        }
    }

    /* compiled from: aPosition */
    class PhotosFeedListener implements MediaFetcherListener<MediaMetadata> {
        final /* synthetic */ PhotosFeedFragment f20230a;

        public PhotosFeedListener(PhotosFeedFragment photosFeedFragment) {
            this.f20230a = photosFeedFragment;
        }

        public final void mo1488a(ImmutableList<MediaMetadata> immutableList) {
            this.f20230a.aM.f20045a = immutableList;
            this.f20230a.aQ = this.f20230a.aM.m23225a();
            PhotosFeedFragment.ax(this.f20230a);
        }

        public final void mo1487a(Status status) {
        }
    }

    /* compiled from: aPosition */
    public class PhotosFeedMediaGalleryScrollListener {
        public final /* synthetic */ PhotosFeedFragment f20231a;

        public PhotosFeedMediaGalleryScrollListener(PhotosFeedFragment photosFeedFragment) {
            this.f20231a = photosFeedFragment;
        }
    }

    /* compiled from: aPosition */
    final class PhotosFeedTTISequence extends AbstractSequenceDefinition {
        public PhotosFeedTTISequence() {
            super(1310740, "PhotosFeedTTI");
        }
    }

    /* compiled from: aPosition */
    public enum Tasks {
        FETCH_STORY
    }

    private static <T extends InjectableComponentWithContext> void m23366a(Class<T> cls, T t) {
        m23367a((Object) t, t.getContext());
    }

    private static void m23367a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PhotosFeedFragment) obj).m23361a(MultipleRowsStoriesRecycleCallback.a(injectorLike), (FrameRateLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class), FeedbackLoader.a(injectorLike), TasksManager.a(injectorLike), FeedStoryMutator.a(injectorLike), MultiRowAdapterBuilder.a(injectorLike), DefaultPhotosFeedPartDefinitionResolver.m23208a(injectorLike), (PhotosFeedEnvironmentProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PhotosFeedEnvironmentProvider.class), (PhotosFeedEventSubscriptionsProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PhotosFeedEventSubscriptionsProvider.class), StoryEventSubscriberManager.m24938a(injectorLike), (RootFeedbackEventSubscriberProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RootFeedbackEventSubscriberProvider.class), MediaFetcherFactory.a(injectorLike), (CanLaunchMediaGalleryImplProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CanLaunchMediaGalleryImplProvider.class), IdBasedLazy.a(injectorLike, 9371), PhotoAttachmentLayoutHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 4414), ResourcesMethodAutoProvider.a(injectorLike), MultiRowImagePrefetcherFactory.a(injectorLike), (HasPrefetcherImplProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(HasPrefetcherImplProvider.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), VpvEventHelper.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), PhotosDialogPerfUtil.m12025a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public static PhotosFeedFragment m23359a(FeedProps<GraphQLStoryAttachment> feedProps, int i, String str, MediaFetcherFactory mediaFetcherFactory, MediaFetcherConstructionRule mediaFetcherConstructionRule, MediaFetcherConstructionRule mediaFetcherConstructionRule2) {
        PhotosFeedFragment photosFeedFragment = new PhotosFeedFragment();
        Bundle bundle = new Bundle();
        GraphQLStory c = AttachmentProps.c(feedProps);
        bundle.putString("story_id", c.c());
        bundle.putString("story_cache_id", c.g());
        bundle.putInt("starting_index", i);
        bundle.putString("starting_media_id", str);
        bundle.putParcelable("media_fetcher_rule", mediaFetcherConstructionRule);
        bundle.putParcelable("gallery_fetcher_rule", mediaFetcherConstructionRule2);
        if (c.aJ() != null) {
            bundle.putString("target_id", c.aJ().b());
        }
        if (!(c.aJ() == null || c.aJ().j() == null)) {
            bundle.putInt("target_type", c.aJ().j().g());
        }
        photosFeedFragment.g(bundle);
        photosFeedFragment.m23365a(mediaFetcherFactory, (FeedProps) feedProps);
        return photosFeedFragment;
    }

    public final View m23375a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1439023235);
        this.ay.m12037e();
        View inflate = layoutInflater.inflate(2130906751, viewGroup, false);
        CustomViewUtils.b(inflate, new ColorDrawable(this.as.getColor(((Integer) this.ar.get()).intValue())));
        this.ay.m12038f();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2143427609, a);
        return inflate;
    }

    public final void m23380c(@Nullable Bundle bundle) {
        super.c(bundle);
        m23366a(PhotosFeedFragment.class, (InjectableComponentWithContext) this);
        this.aH = this.f20233b.a(Boolean.valueOf(false), "photos_feed_scroll_perf", Absent.withType());
        this.aK = this.am.m5222a(new C17431(this), null, null, null, null);
        this.aL = this.f20240i.m23347a(new C17442(this));
        AnimationParamProvider c17453 = new C17453(this);
        this.aR = this.at.a();
        Bundle mt_ = mt_();
        Callable c17464 = new C17464(this);
        PhotosFeedEnvironment a = this.f20239h.m23341a(getContext(), PhotosFeedListType.m23383b(), this.ao.m23201a(getContext(), this.aM, new PhotosFeedMediaGalleryScrollListener(this), c17453, (MediaFetcherConstructionRule) mt_.getParcelable("gallery_fetcher_rule"), mt_.getInt("target_type"), mt_.getString("target_id"), this.az.a(ExperimentsForMediaGalleryAbTestModule.f10690n, false), c17464), new C17475(this), c17464, this.au.a(this.aR));
        Builder a2 = this.f20237f.a(this.f20238g.m23210a(), this.aI);
        a2.f = a;
        this.aF = a2.e();
        C17486 c17486 = new C17486(this);
        Builder a3 = this.f20237f.a(this.f20238g.m23211b(), this.aM);
        a3.f = a;
        this.aG = a3.a(c17486).e();
        this.aR.a(this.aG.f());
        this.aE = MultiAdapterListAdapter.b(new FbListAdapter[]{this.aF, this.aG});
        this.aS = au();
        if (bundle != null) {
            this.aN.mo1488a(((MediaMetadataParcelUtil) this.ap.get()).m12811a(bundle.getParcelableArrayList("photos_feed_extra_media"), true));
        }
        if (this.aJ == null) {
            m23368a(mt_.getString("story_id"), mt_.getString("story_cache_id"));
        } else {
            m23362a(this, (GraphQLStory) this.aJ.a());
        }
        m23364a(this.an);
    }

    private BaseProxyOnScrollListener au() {
        return new C17497(this);
    }

    public final void m23382e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelableArrayList("photos_feed_extra_media", ((MediaMetadataParcelUtil) this.ap.get()).m12812a(this.aM.f20045a, true));
        bundle.putInt("photos_feed_list_visible_index", this.aD.q());
        View f = this.aD.f(0);
        bundle.putInt("photos_feed_list_offset", f == null ? 0 : f.getTop() - this.aD.g());
    }

    @Nullable
    public final String mo1495e() {
        return null;
    }

    public final void m23372G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1996983740);
        super.G();
        this.al.m24941b();
        this.aR.a(this.aD);
        this.aD.b(this.aR.a());
        this.aD.b(this.aS);
        this.aw.a();
        this.aT = this.ax.a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -46782427, a);
    }

    public final void m23373H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1958310033);
        super.H();
        StoryEventSubscriberManager storyEventSubscriberManager = this.al;
        storyEventSubscriberManager.f22335a.b(storyEventSubscriberManager.f22336b);
        this.aR.b();
        this.aD.c(this.aR.a());
        this.aD.c(this.aS);
        this.aw.a(this.aJ == null ? null : TrackableFeedProps.a(this.aJ), this.ax.a() - this.aT, am_());
        LogUtils.f(110661726, a);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        aw();
        m23364a(this.an);
        this.aF.a(configuration);
        this.aG.a(configuration);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1037651322);
        super.mY_();
        if (this.aE != null) {
            this.aE.jc_();
        }
        CustomViewUtils.a(this.aD.ix_(), this.aO);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1776447173, a);
    }

    public final void m23374I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 380138087);
        super.I();
        this.aL.f20209b.m5065a();
        this.aK.mo234a();
        this.f20235d.c(Tasks.FETCH_STORY);
        aq();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1318656759, a);
    }

    public final void aq() {
        super.aq();
        aw();
    }

    public final String as() {
        return PhotoAnimationDialogFragment.am;
    }

    public final boolean mo1491a(PhotoAnimationDialogFragment$3 photoAnimationDialogFragment$3) {
        this.aP = photoAnimationDialogFragment$3;
        return true;
    }

    public final String am_() {
        return "photos_feed";
    }

    public final FragmentPerfMarkerConfig at() {
        return new FragmentPerfMarkerConfig(aB, "OpenPhotosFeed", 1310738);
    }

    public final void m23377a(View view, Bundle bundle) {
        BetterRecyclerView betterRecyclerView = (BetterRecyclerView) e(2131560701);
        betterRecyclerView.setLayoutManager(new LayoutManagerWithKeepAttachedHack(betterRecyclerView));
        this.aD = new RecyclerViewProxy(betterRecyclerView);
        this.aD.a(this.aE);
        this.aD.a(this.f20232a.a());
        if (bundle != null) {
            final int i = bundle.getInt("photos_feed_list_visible_index");
            final int i2 = bundle.getInt("photos_feed_list_offset");
            this.aO = new OnGlobalLayoutListener(this) {
                final /* synthetic */ PhotosFeedFragment f20220c;

                public void onGlobalLayout() {
                    if (this.f20220c.aM.f20045a != null) {
                        this.f20220c.aU = true;
                        CustomViewUtils.a(this.f20220c.aD.ix_(), this);
                        this.f20220c.aD.d(i, i2);
                    }
                }
            };
        } else {
            this.aO = new C17519(this);
        }
        this.aD.ix_().getViewTreeObserver().addOnGlobalLayoutListener(this.aO);
        this.ay.m12033a(true);
    }

    @Nullable
    public final DrawingRule mo1489a(Drawable drawable, Rect rect) {
        DraweeView g = m23370g(this, this.s.getInt("starting_index"));
        if (g == null) {
            return null;
        }
        return DrawingRule.m12761a(g);
    }

    private void m23365a(MediaFetcherFactory mediaFetcherFactory, FeedProps<GraphQLStoryAttachment> feedProps) {
        this.aJ = AttachmentProps.e(feedProps);
        m23363a((GraphQLStoryAttachment) feedProps.a);
        m23364a(mediaFetcherFactory);
        ax(this);
    }

    private void m23363a(GraphQLStoryAttachment graphQLStoryAttachment) {
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList x = graphQLStoryAttachment.x();
        int size = x.size();
        for (int i = 0; i < size; i++) {
            GraphQLStoryAttachment graphQLStoryAttachment2 = (GraphQLStoryAttachment) x.get(i);
            GraphQLMedia.Builder a = GraphQLMedia.Builder.a(graphQLStoryAttachment2.r());
            a.ay = graphQLStoryAttachment2.n();
            builder.c(PhotosMetadataConversionHelper.a(a.a()));
        }
        this.aM.f20045a = builder.b();
        this.aQ = this.aM.m23225a();
    }

    @Nullable
    public static DraweeView m23370g(PhotosFeedFragment photosFeedFragment, int i) {
        View a = ViewDiagnosticsWrapper.a(photosFeedFragment.aD.c(m23371h(photosFeedFragment, i)));
        if (a instanceof HasPhotoAttachment) {
            return ((HasPhotoAttachment) a).getUnderlyingDraweeView();
        }
        if (a instanceof InlineVideoAttachmentView) {
            return ((InlineVideoAttachmentView) a).a.getCoverImage();
        }
        if (a instanceof FullscreenVideoAttachmentView) {
            return ((FullscreenVideoAttachmentView) a).b;
        }
        if (a == null) {
            return null;
        }
        AbstractFbErrorReporter abstractFbErrorReporter = photosFeedFragment.av;
        String str = "PhotosFeedFragment_incorrectPhotoAttachmentView";
        String str2 = "Looking for startingPhotoIndex of %s, headerAdapter has size of %s, feedAdapter has size of %s, feedAdapter.translateFeedEdgeIndexToFirstRow(photoIndex) is %s,View is %s, GraphQLStory Id is %s";
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(photosFeedFragment.aF.getCount());
        objArr[2] = Integer.valueOf(photosFeedFragment.aG.getCount());
        objArr[3] = Integer.valueOf(photosFeedFragment.aG.t_(i));
        objArr[4] = a;
        objArr[5] = photosFeedFragment.aJ == null ? null : ((GraphQLStory) photosFeedFragment.aJ.a).c();
        abstractFbErrorReporter.a(str, StringFormatUtil.a(str2, objArr));
        return null;
    }

    private void aw() {
        if (this.aC != null) {
            this.aC.m12405b(this.aN);
            this.aC.mo598c();
            this.aC = null;
        }
    }

    private void m23364a(MediaFetcherFactory mediaFetcherFactory) {
        if (this.aC == null) {
            this.aC = mediaFetcherFactory.a((MediaFetcherConstructionRule) this.s.getParcelable("media_fetcher_rule"), aA);
            this.aC.m12402a(this.aN);
            if (this.aC.mo599d()) {
                this.aC.mo597a(20, Optional.fromNullable(this.s.getString("starting_media_id")));
                this.aQ = 20;
            }
        }
    }

    public static void m23362a(PhotosFeedFragment photosFeedFragment, GraphQLStory graphQLStory) {
        photosFeedFragment.aJ = photosFeedFragment.aJ == null ? FeedProps.c(graphQLStory) : photosFeedFragment.aJ.b(graphQLStory);
        photosFeedFragment.aL.m23345a(graphQLStory);
        if (!photosFeedFragment.al.f22337c) {
            StoryEventSubscriberManager storyEventSubscriberManager = photosFeedFragment.al;
            PhotosFeedEventSubscriptions photosFeedEventSubscriptions = photosFeedFragment.aL;
            storyEventSubscriberManager.m24940a(new LikeClickSubscriber(photosFeedEventSubscriptions), new ReactionUpdatedSubscriber(photosFeedEventSubscriptions), new LikeUpdatedEventSubscriber(photosFeedEventSubscriptions));
        }
        photosFeedFragment.aI.a = graphQLStory;
        photosFeedFragment.aK.m5220a(GraphQLHelper.f(graphQLStory));
        photosFeedFragment.m23363a(StoryAttachmentHelper.o(graphQLStory));
        ax(photosFeedFragment);
    }

    public static void ax(PhotosFeedFragment photosFeedFragment) {
        if (photosFeedFragment.aE != null) {
            AdapterDetour.a(photosFeedFragment.aE, 1234439331);
        }
    }

    private void m23368a(String str, String str2) {
        GraphQLStory a = this.f20234c.a(str, FetchType.GRAPHQL_DEFAULT, str2, CommentOrderType.DEFAULT_ORDER, false);
        if (a == null) {
            this.f20235d.a(Tasks.FETCH_STORY, this.f20234c.a(str, FetchType.GRAPHQL_DEFAULT, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA), new C17508(this));
        } else {
            m23362a(this, a);
        }
    }

    public static int m23358a(PhotosFeedFragment photosFeedFragment, GraphQLMedia graphQLMedia) {
        return Math.round(((float) (photosFeedFragment.aD.e() - photosFeedFragment.aq.c(graphQLMedia).h)) / 2.0f);
    }

    public static int m23371h(PhotosFeedFragment photosFeedFragment, int i) {
        return photosFeedFragment.aF.getCount() + photosFeedFragment.aG.t_(i);
    }

    public static Runnable m23360a(PhotosFeedFragment photosFeedFragment, final int i, final int i2, final int i3) {
        return new Runnable(photosFeedFragment) {
            final /* synthetic */ PhotosFeedFragment f20217d;

            public void run() {
                if (this.f20217d.aD.C()) {
                    this.f20217d.aD.d(PhotosFeedFragment.m23371h(this.f20217d, i), i2);
                    m23349a(false);
                    return;
                }
                m23348a();
            }

            private void m23348a() {
                if (i3 < 3) {
                    this.f20217d.aD.a(PhotosFeedFragment.m23360a(this.f20217d, i, i2, i3 + 1));
                    return;
                }
                this.f20217d.av.a("PhotosFeedFragment_inconsistentAdapterViewCountThreshold", StringFormatUtil.formatStrLocaleSafe("GraphQLStory Id is %s", ((GraphQLStory) this.f20217d.aJ.a).c()));
                m23349a(true);
            }

            private void m23349a(final boolean z) {
                GlobalOnLayoutHelper.a(this.f20217d.aD.ix_(), new Runnable(this) {
                    final /* synthetic */ AnonymousClass10 f20213b;

                    public void run() {
                        if (this.f20213b.f20217d.aP != null) {
                            this.f20213b.f20217d.aP.m11986a(z);
                        }
                    }
                });
            }
        };
    }

    public static int m23369b(PhotosFeedFragment photosFeedFragment, String str) {
        ImmutableList immutableList = photosFeedFragment.aM.f20045a;
        int size = immutableList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (((MediaMetadata) immutableList.get(i2)).d().equals(str)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private void m23361a(MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, FrameRateLoggerProvider frameRateLoggerProvider, FeedbackLoader feedbackLoader, TasksManager tasksManager, FeedStoryMutator feedStoryMutator, MultiRowAdapterBuilder multiRowAdapterBuilder, PhotosFeedPartDefinitionResolver photosFeedPartDefinitionResolver, PhotosFeedEnvironmentProvider photosFeedEnvironmentProvider, PhotosFeedEventSubscriptionsProvider photosFeedEventSubscriptionsProvider, StoryEventSubscriberManager storyEventSubscriberManager, RootFeedbackEventSubscriberProvider rootFeedbackEventSubscriberProvider, MediaFetcherFactory mediaFetcherFactory, CanLaunchMediaGalleryImplProvider canLaunchMediaGalleryImplProvider, Lazy<MediaMetadataParcelUtil> lazy, PhotoAttachmentLayoutHelper photoAttachmentLayoutHelper, Provider<Integer> provider, Resources resources, MultiRowImagePrefetcherFactory multiRowImagePrefetcherFactory, HasPrefetcherImplProvider hasPrefetcherImplProvider, FbErrorReporter fbErrorReporter, VpvEventHelper vpvEventHelper, Clock clock, PhotosDialogPerfUtil photosDialogPerfUtil, QeAccessor qeAccessor) {
        this.f20232a = multipleRowsStoriesRecycleCallback;
        this.f20233b = frameRateLoggerProvider;
        this.f20234c = feedbackLoader;
        this.f20235d = tasksManager;
        this.f20236e = feedStoryMutator;
        this.f20237f = multiRowAdapterBuilder;
        this.f20238g = photosFeedPartDefinitionResolver;
        this.f20239h = photosFeedEnvironmentProvider;
        this.f20240i = photosFeedEventSubscriptionsProvider;
        this.al = storyEventSubscriberManager;
        this.am = rootFeedbackEventSubscriberProvider;
        this.an = mediaFetcherFactory;
        this.ao = canLaunchMediaGalleryImplProvider;
        this.ap = lazy;
        this.aq = photoAttachmentLayoutHelper;
        this.ar = provider;
        this.as = resources;
        this.at = multiRowImagePrefetcherFactory;
        this.au = hasPrefetcherImplProvider;
        this.av = fbErrorReporter;
        this.aw = vpvEventHelper;
        this.ax = clock;
        this.ay = photosDialogPerfUtil;
        this.az = qeAccessor;
    }

    public final void mo1490a(ConsumptionPhotoEventBus consumptionPhotoEventBus, boolean z, int i) {
        this.aU = z;
    }
}
