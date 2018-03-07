package com.facebook.timeline;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.api.feed.DeleteStoryMethod.Params;
import com.facebook.api.feed.DeleteStoryMethod.Params.DeleteMode;
import com.facebook.api.feed.module.Boolean_IsTagMemoizingEnabledGatekeeperAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.viewport.ViewportMonitor;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventBus;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.controller.mutation.BaseMutationCallback;
import com.facebook.controller.mutation.MutationCallback;
import com.facebook.controller.mutation.StoryMutationHelper;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.rows.core.BoundedAdapter;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.basefeedfragment.BaseFeedFragment;
import com.facebook.feed.ui.controllers.SeeMoreController;
import com.facebook.feed.ui.feedprefetch.VideoPrepareViewPreloader;
import com.facebook.feed.ui.feedprefetch.VideoPrepareViewPreloaderProvider;
import com.facebook.feed.ui.imageloader.FeedImageLoaderFactory;
import com.facebook.feed.util.DeleteStoryHelper;
import com.facebook.feed.util.event.DataSetEvents.DataSetUpdatedEventSubscriber;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.HideEvents.ChangeRendererEventSubscriber;
import com.facebook.feed.util.event.HideEvents.StoryVisibilityEvent;
import com.facebook.feed.util.event.HideEvents.StoryVisibilityEventSubscriber;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEventSubscriber;
import com.facebook.feed.util.event.ViewportViewEvents.FeedVisibilityEvent;
import com.facebook.feed.util.event.ViewportViewEvents.FeedVisibilityEventSubscriber;
import com.facebook.friends.FriendingClient;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.Feedbackable;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents.DeletePhotoEvent;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.cache.TimelineUserDataCleaner;
import com.facebook.timeline.datafetcher.TimelineGenericDataFetcher;
import com.facebook.timeline.datafetcher.TimelineStoriesDataFetcher;
import com.facebook.timeline.datafetcher.section.TimelineSectionFetchParamsHelper;
import com.facebook.timeline.event.StoryMenuEvents.BanUserClickedEvent;
import com.facebook.timeline.event.StoryMenuEvents.BanUserClickedEventSubscriber;
import com.facebook.timeline.event.StoryMenuEvents.DeleteStoryClickedEvent;
import com.facebook.timeline.event.StoryMenuEvents.DeleteStoryClickedEventSubscriber;
import com.facebook.timeline.event.StoryMenuEvents.EditStoryEventSubscriber;
import com.facebook.timeline.event.TimelineStoryEventBus;
import com.facebook.timeline.feed.events.TimelineLoadingIndicatorClickProcessor;
import com.facebook.timeline.feed.events.TimelineLoadingIndicatorClickProcessorProvider;
import com.facebook.timeline.feed.events.TimelineScrubberClickEventProcessor;
import com.facebook.timeline.feed.events.TimelineScrubberClickEventProcessorProvider;
import com.facebook.timeline.stories.TimelineStoriesController;
import com.facebook.timeline.stories.TimelineStoriesController.C17841;
import com.facebook.timeline.stories.TimelineStoriesController.C17852;
import com.facebook.timeline.units.TimelineUnitSubscriber;
import com.facebook.timeline.units.TimelineUnitSubscriberProvider;
import com.facebook.timeline.units.model.TimelineAllSectionsData;
import com.facebook.timeline.units.model.TimelineSectionData.Placeholder;
import com.facebook.timeline.units.model.TimelineSectionData.ScrollLoadTrigger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ufiservices.event.UfiEvents.LikeClickedEvent;
import com.facebook.ufiservices.event.UfiEvents.LikeClickedEventSubscriber;
import com.facebook.ufiservices.event.UfiEvents.PageLikeClickedEvent;
import com.facebook.ufiservices.event.UfiEvents.PageLikeClickedEventSubscriber;
import com.facebook.ufiservices.event.UfiEvents.SetNotifyMeEvent;
import com.facebook.ufiservices.event.UfiEvents.SetNotifyMeEventSubscriber;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.video.abtest.VideoExoplayerConfig;
import com.facebook.video.server.VideoPrefetchModelMethodAutoProvider;
import com.facebook.video.server.prefetcher.VideoPrefetchList;
import com.facebook.video.server.prefetcher.VideoPrefetchLocation;
import com.facebook.video.server.prefetcher.VideoPrefetchModel;
import com.facebook.widget.listview.BasicAdapter;
import com.facebook.widget.listview.ListViewPreloader;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.listview.ScrollingViewProxyContainer;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: gugdtawomoavdfssswsdeyevryrerabokyorddjucaprpuphpoowbgoongnyat */
public abstract class BaseTimelineFragment<TAdapter extends BasicAdapter> extends BaseFeedFragment implements AnalyticsFragment, OnScrollListener, ScrollingViewProxyContainer {
    public static final String f10170c = BaseTimelineFragment.class.getSimpleName();
    @Inject
    public volatile Provider<GraphQLStoryUtil> f10171a = UltralightRuntime.a;
    @Inject
    private VideoPrefetchModel aA;
    private VideoPrefetchList aB;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ComposerPublishServiceHelper> aC = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SeeMoreController> aD = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<StoryMutationHelper> aE = UltralightRuntime.b;
    private boolean aF = false;
    public VideoPrepareViewPreloader al;
    @Inject
    private Provider<VideoExoplayerConfig> am;
    @Inject
    @ForUiThread
    private Provider<Executor> an;
    @Inject
    private Provider<FeedEventBus> ao;
    public FbEventSubscriberListManager ap;
    @Inject
    public Provider<TimelineStoryEventBus> aq;
    public FbEventSubscriberListManager ar;
    @Inject
    public Provider<TimelineUserDataCleaner> as;
    @Inject
    private Provider<ConsumptionPhotoEventBus> at;
    @Inject
    public Provider<DeleteStoryHelper> au;
    private DeletePhotoEventSubscriber av;
    @Inject
    private TimelineScrubberClickEventProcessorProvider aw;
    private TimelineScrubberClickEventProcessor ax;
    @Inject
    private TimelineLoadingIndicatorClickProcessorProvider ay;
    private TimelineLoadingIndicatorClickProcessor az;
    @Inject
    volatile Provider<QeAccessor> f10172b = UltralightRuntime.a;
    @Inject
    private TimelineUnitSubscriberProvider f10173d;
    @Nullable
    public TimelineUnitSubscriber f10174e;
    @Inject
    public Provider<FbErrorReporter> f10175f;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FeedImageLoaderFactory> f10176g = UltralightRuntime.b;
    @Nullable
    public ListViewPreloader f10177h;
    @Inject
    private VideoPrepareViewPreloaderProvider f10178i;

    /* compiled from: gugdtawomoavdfssswsdeyevryrerabokyorddjucaprpuphpoowbgoongnyat */
    public class AnonymousClass13 implements MutationCallback<FeedUnit> {
        final /* synthetic */ TimelineAllSectionsData f10154a;
        final /* synthetic */ BaseTimelineFragment f10155b;

        public AnonymousClass13(BaseTimelineFragment baseTimelineFragment, TimelineAllSectionsData timelineAllSectionsData) {
            this.f10155b = baseTimelineFragment;
            this.f10154a = timelineAllSectionsData;
        }

        public final void m10216a(Object obj) {
            this.f10154a.m12716a((FeedUnit) obj);
            this.f10155b.aC();
        }

        public final void m10217a(Object obj, ServiceException serviceException) {
            this.f10154a.m12716a((FeedUnit) obj);
            if (this.f10155b.ax() != null) {
                this.f10155b.aC();
            }
            ((AbstractFbErrorReporter) this.f10155b.f10175f.get()).a("timeline_page_like_fail", TimelineGenericDataFetcher.m10594a(serviceException));
        }

        public final /* bridge */ /* synthetic */ void m10218b(Object obj) {
        }

        public final /* bridge */ /* synthetic */ void m10219c(Object obj) {
        }
    }

    /* compiled from: gugdtawomoavdfssswsdeyevryrerabokyorddjucaprpuphpoowbgoongnyat */
    public class AnonymousClass14 extends BaseMutationCallback<FeedUnit> {
        final /* synthetic */ TimelineAllSectionsData f10156a;
        final /* synthetic */ BaseTimelineFragment f10157b;

        public AnonymousClass14(BaseTimelineFragment baseTimelineFragment, TimelineAllSectionsData timelineAllSectionsData) {
            this.f10157b = baseTimelineFragment;
            this.f10156a = timelineAllSectionsData;
        }

        public final void m10220a(Object obj) {
            this.f10156a.m12716a((FeedUnit) obj);
            this.f10157b.aC();
        }

        public final void m10221a(Object obj, ServiceException serviceException) {
            FeedUnit feedUnit = (FeedUnit) obj;
            ((AbstractFbErrorReporter) this.f10157b.f10175f.get()).a("timeline_story_notify_me_fail", serviceException);
            if (this.f10156a != null) {
                this.f10156a.m12716a(feedUnit);
            }
            if (this.f10157b.ax() != null) {
                this.f10157b.aC();
            }
        }
    }

    /* compiled from: gugdtawomoavdfssswsdeyevryrerabokyorddjucaprpuphpoowbgoongnyat */
    public class AnonymousClass15 implements MutationCallback<FeedUnit> {
        final /* synthetic */ TimelineAllSectionsData f10158a;
        final /* synthetic */ BaseTimelineFragment f10159b;

        public AnonymousClass15(BaseTimelineFragment baseTimelineFragment, TimelineAllSectionsData timelineAllSectionsData) {
            this.f10159b = baseTimelineFragment;
            this.f10158a = timelineAllSectionsData;
        }

        public final void m10222a(Object obj) {
            this.f10159b.au().m12716a((FeedUnit) obj);
            TimelineStoriesDataFetcher av = this.f10159b.av();
            if (av != null) {
                av.m10727f();
            }
        }

        public final void m10223a(Object obj, ServiceException serviceException) {
            FeedUnit feedUnit = (FeedUnit) obj;
            if (this.f10158a != null) {
                this.f10158a.m12716a(feedUnit);
            }
            TimelineStoriesDataFetcher av = this.f10159b.av();
            if (av != null) {
                av.m10727f();
            }
            ((AbstractFbErrorReporter) this.f10159b.f10175f.get()).a("timeline_story_like_fail", TimelineGenericDataFetcher.m10594a(serviceException));
        }

        public final /* bridge */ /* synthetic */ void m10224b(Object obj) {
        }

        public final /* bridge */ /* synthetic */ void m10225c(Object obj) {
        }
    }

    /* compiled from: gugdtawomoavdfssswsdeyevryrerabokyorddjucaprpuphpoowbgoongnyat */
    public class C14901 extends SetNotifyMeEventSubscriber {
        final /* synthetic */ BaseTimelineFragment f10160a;

        public C14901(BaseTimelineFragment baseTimelineFragment) {
            this.f10160a = baseTimelineFragment;
        }

        public final void m10226b(FbEvent fbEvent) {
            SetNotifyMeEvent setNotifyMeEvent = (SetNotifyMeEvent) fbEvent;
            BaseTimelineFragment baseTimelineFragment = this.f10160a;
            ((StoryMutationHelper) baseTimelineFragment.aE.get()).a(setNotifyMeEvent.a, setNotifyMeEvent.h, "timeline_story_notify_me", "native_timeline", new AnonymousClass14(baseTimelineFragment, baseTimelineFragment.au()));
        }
    }

    /* compiled from: gugdtawomoavdfssswsdeyevryrerabokyorddjucaprpuphpoowbgoongnyat */
    public class C14912 extends LikeClickedEventSubscriber {
        final /* synthetic */ BaseTimelineFragment f10161a;

        public C14912(BaseTimelineFragment baseTimelineFragment) {
            this.f10161a = baseTimelineFragment;
        }

        public final void m10227b(FbEvent fbEvent) {
            LikeClickedEvent likeClickedEvent = (LikeClickedEvent) fbEvent;
            BaseTimelineFragment baseTimelineFragment = this.f10161a;
            TimelineAllSectionsData au = baseTimelineFragment.au();
            Feedbackable a = au.m12712a(likeClickedEvent.a, likeClickedEvent.b);
            if (a == null || a.l() == null || !(a instanceof GraphQLStory)) {
                String str = a == null ? "oldUnit" : "feedback";
                ((AbstractFbErrorReporter) baseTimelineFragment.f10175f.get()).a("timeline_story_like_fail_no_" + str, "Could not find a unit in SectionData to modify. " + str + " is null.");
                return;
            }
            ((StoryMutationHelper) baseTimelineFragment.aE.get()).a(FeedProps.c((GraphQLStory) a), likeClickedEvent.d, likeClickedEvent.f, baseTimelineFragment.am_(), baseTimelineFragment.aB(), new AnonymousClass15(baseTimelineFragment, au));
        }
    }

    /* compiled from: gugdtawomoavdfssswsdeyevryrerabokyorddjucaprpuphpoowbgoongnyat */
    public class C14923 extends PageLikeClickedEventSubscriber {
        final /* synthetic */ BaseTimelineFragment f10162a;

        public C14923(BaseTimelineFragment baseTimelineFragment) {
            this.f10162a = baseTimelineFragment;
        }

        public final void m10228b(FbEvent fbEvent) {
            PageLikeClickedEvent pageLikeClickedEvent = (PageLikeClickedEvent) fbEvent;
            BaseTimelineFragment baseTimelineFragment = this.f10162a;
            TimelineAllSectionsData au = baseTimelineFragment.au();
            Feedbackable a = au.m12712a(((FeedUnit) pageLikeClickedEvent.a.a).g(), pageLikeClickedEvent.c);
            if (a == null) {
                ((AbstractFbErrorReporter) baseTimelineFragment.f10175f.get()).a("timeline_page_like_fail", "Could not find a unit in SectionData to modify");
            } else if (a instanceof GraphQLStory) {
                FeedProps feedProps;
                GraphQLStory graphQLStory = (GraphQLStory) a;
                if (pageLikeClickedEvent.a.a == graphQLStory) {
                    feedProps = pageLikeClickedEvent.a;
                } else {
                    feedProps = FeedProps.c(graphQLStory);
                }
                ((StoryMutationHelper) baseTimelineFragment.aE.get()).a(pageLikeClickedEvent.b, feedProps, null, baseTimelineFragment.am_(), "newsfeed_ufi", null, true, new AnonymousClass13(baseTimelineFragment, au));
            } else {
                ((AbstractFbErrorReporter) baseTimelineFragment.f10175f.get()).a("timeline_page_like_fail", "Found unit is not a story");
            }
        }
    }

    /* compiled from: gugdtawomoavdfssswsdeyevryrerabokyorddjucaprpuphpoowbgoongnyat */
    public class C14934 extends DataSetUpdatedEventSubscriber {
        final /* synthetic */ BaseTimelineFragment f10163a;

        public C14934(BaseTimelineFragment baseTimelineFragment) {
            this.f10163a = baseTimelineFragment;
        }

        public final void m10229b(FbEvent fbEvent) {
            TimelineStoriesDataFetcher av = this.f10163a.av();
            if (av != null) {
                av.m10727f();
            }
        }
    }

    /* compiled from: gugdtawomoavdfssswsdeyevryrerabokyorddjucaprpuphpoowbgoongnyat */
    public class C14945 extends StoryVisibilityEventSubscriber {
        final /* synthetic */ BaseTimelineFragment f10164a;

        public C14945(BaseTimelineFragment baseTimelineFragment) {
            this.f10164a = baseTimelineFragment;
        }

        public final void m10230b(FbEvent fbEvent) {
            StoryVisibilityEvent storyVisibilityEvent = (StoryVisibilityEvent) fbEvent;
            this.f10164a.au().m12724a(storyVisibilityEvent.a, storyVisibilityEvent.b, storyVisibilityEvent.c, storyVisibilityEvent.d);
            this.f10164a.aC();
        }
    }

    /* compiled from: gugdtawomoavdfssswsdeyevryrerabokyorddjucaprpuphpoowbgoongnyat */
    public class C14956 extends ChangeRendererEventSubscriber {
        final /* synthetic */ BaseTimelineFragment f10165a;

        public C14956(BaseTimelineFragment baseTimelineFragment) {
            this.f10165a = baseTimelineFragment;
        }

        public final void m10231b(FbEvent fbEvent) {
            this.f10165a.aC();
        }
    }

    /* compiled from: gugdtawomoavdfssswsdeyevryrerabokyorddjucaprpuphpoowbgoongnyat */
    public class C14967 extends FeedUnitMutatedEventSubscriber {
        final /* synthetic */ BaseTimelineFragment f10166a;

        public C14967(BaseTimelineFragment baseTimelineFragment) {
            this.f10166a = baseTimelineFragment;
        }

        public final void m10232b(FbEvent fbEvent) {
            this.f10166a.au().m12716a(((FeedUnitMutatedEvent) fbEvent).a);
            this.f10166a.aC();
        }
    }

    /* compiled from: gugdtawomoavdfssswsdeyevryrerabokyorddjucaprpuphpoowbgoongnyat */
    public class C14978 extends FeedVisibilityEventSubscriber {
        final /* synthetic */ BaseTimelineFragment f10167a;

        public C14978(BaseTimelineFragment baseTimelineFragment) {
            this.f10167a = baseTimelineFragment;
        }

        public final void m10233b(FbEvent fbEvent) {
            FeedVisibilityEvent feedVisibilityEvent = (FeedVisibilityEvent) fbEvent;
            ViewportMonitor ay = this.f10167a.ay();
            ScrollingViewProxy n = this.f10167a.n();
            if (ay != null && n != null) {
                if (feedVisibilityEvent.a) {
                    ay.a(n);
                } else {
                    ay.c(n);
                }
            }
        }
    }

    /* compiled from: gugdtawomoavdfssswsdeyevryrerabokyorddjucaprpuphpoowbgoongnyat */
    public class C14989 implements FutureCallback<GraphQLStory> {
        final /* synthetic */ BaseTimelineFragment f10168a;

        public C14989(BaseTimelineFragment baseTimelineFragment) {
            this.f10168a = baseTimelineFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLStory graphQLStory = (GraphQLStory) obj;
            this.f10168a.at().m12716a((FeedUnit) graphQLStory);
            if (this.f10168a.f10174e != null) {
                this.f10168a.f10174e.m12702a(graphQLStory);
            }
            this.f10168a.aC();
        }

        public void onFailure(Throwable th) {
            ((AbstractFbErrorReporter) this.f10168a.f10175f.get()).a("timeline_see_more_fail", "Failed to fetch aggregated substories");
        }
    }

    /* compiled from: gugdtawomoavdfssswsdeyevryrerabokyorddjucaprpuphpoowbgoongnyat */
    class DeletePhotoEventSubscriber extends com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents.DeletePhotoEventSubscriber {
        final /* synthetic */ BaseTimelineFragment f10169a;

        public DeletePhotoEventSubscriber(BaseTimelineFragment baseTimelineFragment) {
            this.f10169a = baseTimelineFragment;
        }

        public final void m10234b(FbEvent fbEvent) {
            DeletePhotoEvent deletePhotoEvent = (DeletePhotoEvent) fbEvent;
            Feedbackable a = this.f10169a.au().m12712a(deletePhotoEvent.a, deletePhotoEvent.b);
            if (a != null && (a instanceof GraphQLStory) && ((DeleteStoryHelper) this.f10169a.au.get()).a((GraphQLStory) a, String.valueOf(deletePhotoEvent.c))) {
                this.f10169a.au().m12724a(deletePhotoEvent.a, deletePhotoEvent.b, null, StoryVisibility.GONE);
                ((DeleteStoryHelper) this.f10169a.au.get()).a((GraphQLStory) a, deletePhotoEvent.d ? DeleteMode.LOCAL_AND_SERVER : DeleteMode.LOCAL_ONLY);
                this.f10169a.aC();
            }
        }
    }

    private static <T extends InjectableComponentWithContext> void m10235a(Class<T> cls, T t) {
        m10236a((Object) t, t.getContext());
    }

    private static void m10236a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((BaseTimelineFragment) obj).m10237a(IdBasedSingletonScopeProvider.a(fbInjector, 2198), IdBasedSingletonScopeProvider.a(fbInjector, 3219), (TimelineUnitSubscriberProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(TimelineUnitSubscriberProvider.class), IdBasedSingletonScopeProvider.a(fbInjector, 494), IdBasedLazy.a(fbInjector, 6085), (VideoPrepareViewPreloaderProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(VideoPrepareViewPreloaderProvider.class), IdBasedProvider.a(fbInjector, 3637), IdBasedSingletonScopeProvider.a(fbInjector, 3863), IdBasedSingletonScopeProvider.a(fbInjector, 1756), IdBasedSingletonScopeProvider.a(fbInjector, 11217), IdBasedSingletonScopeProvider.a(fbInjector, 11155), IdBasedSingletonScopeProvider.a(fbInjector, 2971), IdBasedProvider.a(fbInjector, 6089), (TimelineScrubberClickEventProcessorProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(TimelineScrubberClickEventProcessorProvider.class), (TimelineLoadingIndicatorClickProcessorProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(TimelineLoadingIndicatorClickProcessorProvider.class), VideoPrefetchModelMethodAutoProvider.a(fbInjector), IdBasedLazy.a(fbInjector, 5272), IdBasedLazy.a(fbInjector, 1740), IdBasedLazy.a(fbInjector, 986));
    }

    public abstract TimelineContext aA();

    public abstract String aB();

    protected abstract TimelineAllSectionsData at();

    @Nullable
    protected abstract TimelineStoriesDataFetcher av();

    protected abstract TAdapter ax();

    protected abstract ViewportMonitor ay();

    protected abstract FriendingClient az();

    protected abstract int mo472g(int i);

    public final TimelineAllSectionsData au() {
        return at();
    }

    private TimelineAllSectionsData aI() {
        return at();
    }

    @Nullable
    protected final TimelineStoriesDataFetcher aw() {
        return av();
    }

    public final void aC() {
        if (ax() != null) {
            ax().notifyDataSetChanged();
        }
    }

    public void mo469c(@Nullable Bundle bundle) {
        TracerDetour.a("BaseTimelineFragment.onFragmentCreate", -1866852120);
        try {
            super.c(bundle);
            TracerDetour.a("BaseTimelineFragment.onFragmentCreate.injectMe", 1398263196);
            try {
                Class cls = BaseTimelineFragment.class;
                m10235a(cls, (InjectableComponentWithContext) this);
                TracerDetour.a(cls);
                this.av = new DeletePhotoEventSubscriber(this);
                this.aB = this.aA.a(VideoPrefetchLocation.TIMELINE);
            } finally {
                TracerDetour.a(653940611);
            }
        } finally {
            TracerDetour.a(1378887647);
        }
    }

    protected final void aD() {
        TracerDetour.a("BaseTimelineFragment.setupImagePrefetchingForStories", 1099757821);
        try {
            ScrollingViewProxy n = n();
            BasicAdapter ax = ax();
            if (n == null || ax == null) {
                TracerDetour.a(2075900189);
                return;
            }
            this.f10177h = ((FeedImageLoaderFactory) this.f10176g.get()).a(n, ax);
            TracerDetour.a(-586682956);
        } catch (Throwable th) {
            TracerDetour.a(76064243);
        }
    }

    protected final void aE() {
        TracerDetour.a("BaseTimelineFragment.setupVideoPrefetchingForStories", 103399574);
        try {
            ScrollingViewProxy n = n();
            BasicAdapter ax = ax();
            if (n == null || ax == null) {
                TracerDetour.a(445080732);
                return;
            }
            if (((VideoExoplayerConfig) this.am.get()).x) {
                this.al = this.f10178i.a(n, ax);
            }
            TracerDetour.a(-86561976);
        } catch (Throwable th) {
            TracerDetour.a(960830722);
        }
    }

    protected final void m10242a(@Nullable TimelineStoriesController timelineStoriesController) {
        this.ap = new FbEventSubscriberListManager();
        this.ap.a(new C14901(this));
        this.ap.a(new C14912(this));
        this.ap.a(new C14923(this));
        this.ap.a(new C14934(this));
        this.ap.a(new C14945(this));
        this.ap.a(new C14956(this));
        this.ap.a(new C14967(this));
        this.ap.a(new C14978(this));
        ((SeeMoreController) this.aD.get()).c = new C14989(this);
        this.ap.a(((SeeMoreController) this.aD.get()).b);
        this.ar = new FbEventSubscriberListManager();
        if (timelineStoriesController != null) {
            FbEventSubscriberListManager fbEventSubscriberListManager = this.ar;
            fbEventSubscriberListManager.a(new C17841(timelineStoriesController, timelineStoriesController.f12731a.d));
            fbEventSubscriberListManager.a(new C17852(timelineStoriesController, timelineStoriesController.f12731a.d));
        }
        this.ar.a(new BanUserClickedEventSubscriber(this, aA().d) {
            final /* synthetic */ BaseTimelineFragment f10151a;

            public final void m10213b(FbEvent fbEvent) {
                BanUserClickedEvent banUserClickedEvent = (BanUserClickedEvent) fbEvent;
                this.f10151a.au().m12723a(banUserClickedEvent.c, null, StoryVisibility.DISAPPEARING, banUserClickedEvent.d.getMeasuredHeight());
                this.f10151a.aC();
                this.f10151a.az().a(banUserClickedEvent.a, banUserClickedEvent.b);
                ((TimelineUserDataCleaner) this.f10151a.as.get()).a("BanUser");
            }
        });
        this.ar.a(new DeleteStoryClickedEventSubscriber(this, aA().d) {
            final /* synthetic */ BaseTimelineFragment f10152a;

            public final void m10214b(FbEvent fbEvent) {
                DeleteStoryClickedEvent deleteStoryClickedEvent = (DeleteStoryClickedEvent) fbEvent;
                TimelineStoriesDataFetcher av = this.f10152a.av();
                if (av != null) {
                    av.m10721a(deleteStoryClickedEvent.a, deleteStoryClickedEvent.b, deleteStoryClickedEvent.c);
                }
                BaseTimelineFragment baseTimelineFragment = this.f10152a;
                ((DeleteStoryHelper) baseTimelineFragment.au.get()).a(new Params(deleteStoryClickedEvent.a, null, deleteStoryClickedEvent.c, DeleteMode.LOCAL_ONLY));
                this.f10152a.au().m12723a(deleteStoryClickedEvent.b, deleteStoryClickedEvent.a, StoryVisibility.GONE, deleteStoryClickedEvent.d.getMeasuredHeight());
                this.f10152a.aC();
            }
        });
        this.ar.a(new EditStoryEventSubscriber(this, aA().d) {
            final /* synthetic */ BaseTimelineFragment f10153a;

            public final void m10215b(FbEvent fbEvent) {
                TimelineStoriesDataFetcher aw = this.f10153a.aw();
                if (aw != null) {
                    aw.m10717a();
                }
            }
        });
        aK();
        TimelineUnitSubscriberProvider timelineUnitSubscriberProvider = this.f10173d;
        this.f10174e = new TimelineUnitSubscriber(au(), av(), Boolean_IsTagMemoizingEnabledGatekeeperAutoProvider.b(timelineUnitSubscriberProvider), IdBasedProvider.a(timelineUnitSubscriberProvider, 2169));
        aI().f12769h = this.f10174e;
    }

    private void m10237a(Provider<GraphQLStoryUtil> provider, Provider<QeAccessor> provider2, TimelineUnitSubscriberProvider timelineUnitSubscriberProvider, Provider<FbErrorReporter> provider3, com.facebook.inject.Lazy<FeedImageLoaderFactory> lazy, VideoPrepareViewPreloaderProvider videoPrepareViewPreloaderProvider, Provider<VideoExoplayerConfig> provider4, Provider<Executor> provider5, Provider<FeedEventBus> provider6, Provider<TimelineStoryEventBus> provider7, Provider<TimelineUserDataCleaner> provider8, Provider<ConsumptionPhotoEventBus> provider9, Provider<DeleteStoryHelper> provider10, TimelineScrubberClickEventProcessorProvider timelineScrubberClickEventProcessorProvider, TimelineLoadingIndicatorClickProcessorProvider timelineLoadingIndicatorClickProcessorProvider, VideoPrefetchModel videoPrefetchModel, com.facebook.inject.Lazy<ComposerPublishServiceHelper> lazy2, com.facebook.inject.Lazy<SeeMoreController> lazy3, com.facebook.inject.Lazy<StoryMutationHelper> lazy4) {
        this.f10171a = provider;
        this.f10172b = provider2;
        this.f10173d = timelineUnitSubscriberProvider;
        this.f10175f = provider3;
        this.f10176g = lazy;
        this.f10178i = videoPrepareViewPreloaderProvider;
        this.am = provider4;
        this.an = provider5;
        this.ao = provider6;
        this.aq = provider7;
        this.as = provider8;
        this.at = provider9;
        this.au = provider10;
        this.aw = timelineScrubberClickEventProcessorProvider;
        this.ay = timelineLoadingIndicatorClickProcessorProvider;
        this.aA = videoPrefetchModel;
        this.aC = lazy2;
        this.aD = lazy3;
        this.aE = lazy4;
    }

    public void mo456a(ScrollingViewProxy scrollingViewProxy, int i) {
    }

    public final void m10241a(int i, int i2, int i3) {
        int g = mo472g(i);
        int g2 = mo472g((i + i2) - 1);
        if (g >= 0 || g2 >= 0) {
            mo468b(g, g2, i3 - (i + i2));
        }
    }

    protected void mo468b(int i, int i2, int i3) {
        ScrollLoadTrigger scrollLoadTrigger;
        TimelineAllSectionsData at = at();
        int i4 = (i2 - i) + 1;
        int aF = aF();
        int max = Math.max(i, 0);
        while (max < at.m12710a() && max < (i + i4) + aF) {
            Object a = at.m12715a(max);
            if (a instanceof ScrollLoadTrigger) {
                scrollLoadTrigger = (ScrollLoadTrigger) a;
                break;
            }
            max++;
        }
        scrollLoadTrigger = null;
        ScrollLoadTrigger scrollLoadTrigger2 = scrollLoadTrigger;
        if (scrollLoadTrigger2 != null) {
            at.m12720a((Placeholder) scrollLoadTrigger2);
            aC();
            TimelineStoriesDataFetcher av = av();
            if (av != null) {
                av.m10720a(TimelineSectionFetchParamsHelper.m10748a(scrollLoadTrigger2));
            }
        }
    }

    protected final int aF() {
        return ((QeAccessor) this.f10172b.get()).a(ExperimentsForTimelineAbTestModule.be, 7);
    }

    public void mo453G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1458174282);
        TracerDetour.a("BaseTimelineFragment.onResume", 407410851);
        try {
            super.G();
            if (this.aF) {
                aK();
                this.aF = false;
            }
            ((ConsumptionPhotoEventBus) this.at.get()).a(this.av);
            this.ax = this.aw.m11308a(at(), av(), aA(), ax());
            this.ax.m11307a();
            this.az = this.ay.m11304a(av());
            this.az.m11303a();
            ((FeedImageLoaderFactory) this.f10176g.get()).a().a();
            this.aB.a(true);
        } finally {
            TracerDetour.a(123054620);
            LogUtils.f(-1665966166, a);
        }
    }

    private void aK() {
        if (this.ap != null) {
            this.ap.a((FbEventBus) this.ao.get());
        }
        if (this.ar != null) {
            this.ar.a((FbEventBus) this.aq.get());
        }
    }

    public void mo454H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1701889636);
        if (this.ap != null) {
            this.ap.b((FbEventBus) this.ao.get());
        }
        if (this.ar != null) {
            this.ar.b((FbEventBus) this.aq.get());
        }
        this.aF = true;
        ((ConsumptionPhotoEventBus) this.at.get()).b(this.av);
        as();
        if (this.ax != null) {
            TimelineScrubberClickEventProcessor timelineScrubberClickEventProcessor = this.ax;
            Preconditions.checkState(timelineScrubberClickEventProcessor.f11173h != null, "Trying to stop TimelineScrubberClickEventProcessor that was not started");
            timelineScrubberClickEventProcessor.f11172g.a(timelineScrubberClickEventProcessor.f11173h);
            timelineScrubberClickEventProcessor.f11173h = null;
        }
        if (this.az != null) {
            TimelineLoadingIndicatorClickProcessor timelineLoadingIndicatorClickProcessor = this.az;
            Preconditions.checkState(timelineLoadingIndicatorClickProcessor.f11163c != null, "Trying to stop TimelineLoadingIndicatorClickProcessor that was not started");
            timelineLoadingIndicatorClickProcessor.f11162b.a(timelineLoadingIndicatorClickProcessor.f11163c);
            timelineLoadingIndicatorClickProcessor.f11163c = null;
        }
        this.aB.a(false);
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -628518065, a);
    }

    public final void aq() {
        ar();
        super.aq();
    }

    public void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -431181982);
        super.mY_();
        if (this.f10177h != null) {
            this.f10177h.a();
        }
        if (this.al != null) {
            this.al.a();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2003163813, a);
    }

    public void mo457a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
        if (this.y) {
            int max = Math.max(0, i);
            int min = Math.min(max + i2, scrollingViewProxy.s());
            for (int i4 = max; i4 < min; i4++) {
                FeedUnit feedUnit;
                FeedUnit g = scrollingViewProxy.g(i4);
                if (!(g instanceof BoundedAdapter) || ((BoundedAdapter) g).c() == null) {
                    feedUnit = g;
                } else {
                    feedUnit = ((BoundedAdapter) g).c();
                }
                this.f10171a.get();
                if ((feedUnit instanceof GraphQLStory) && GraphQLStoryUtil.n((GraphQLStory) feedUnit)) {
                    break;
                }
            }
        }
        m10241a(i, i2, i3);
    }

    public void mo455I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1700861523);
        if (this.f10174e != null) {
            TimelineUnitSubscriber timelineUnitSubscriber = this.f10174e;
            if (timelineUnitSubscriber.f12757e != null) {
                timelineUnitSubscriber.f12757e.a();
            }
        }
        TimelineAllSectionsData aI = aI();
        if (aI != null) {
            aI.f12769h = null;
        }
        aI = at();
        if (aI != null) {
            aI.m12725a(true);
        }
        ((SeeMoreController) this.aD.get()).b();
        this.aB.b();
        this.aB = null;
        this.f10174e = null;
        this.ap = null;
        this.f10177h = null;
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1564384383, a);
    }

    public void onConfigurationChanged(Configuration configuration) {
        ((FeedImageLoaderFactory) this.f10176g.get()).a.a();
    }

    protected final void ar() {
        if (this.f10174e != null) {
            TimelineUnitSubscriber timelineUnitSubscriber = this.f10174e;
            if (timelineUnitSubscriber.f12757e != null) {
                timelineUnitSubscriber.f12757e.e();
            }
        }
    }

    protected final void as() {
        if (this.f10174e != null) {
            TimelineUnitSubscriber timelineUnitSubscriber = this.f10174e;
            if (timelineUnitSubscriber.f12757e != null) {
                timelineUnitSubscriber.f12757e.d();
            }
        }
    }

    protected final ComposerPublishServiceHelper aG() {
        return (ComposerPublishServiceHelper) this.aC.get();
    }

    public String am_() {
        return "native_timeline";
    }
}
