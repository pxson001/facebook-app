package com.facebook.photos.pandora.ui;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.api.ufiservices.common.FeedbackDisplayType;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.LazyListViewDelegate;
import com.facebook.feed.menu.permalink.PermalinkFeedStoryMenuHelperFactory;
import com.facebook.feed.permalink.PermalinkCommentNavigationDelegate;
import com.facebook.feed.permalink.PermalinkCommentNavigationDelegateProvider;
import com.facebook.feed.permalink.PermalinkEnvironment;
import com.facebook.feed.permalink.PermalinkEnvironmentProvider;
import com.facebook.feed.permalink.PermalinkFeedListType;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.OneItemListItemCollection;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.ui.Bindable;
import com.facebook.feedback.ui.CommentAdapter;
import com.facebook.feedback.ui.CommentAdapterFactory;
import com.facebook.feedback.ui.CommentListScrollStateController.ScrollingProxy;
import com.facebook.feedback.ui.CommentsHelper;
import com.facebook.feedback.ui.CommentsHelperProvider;
import com.facebook.feedback.ui.FeedbackController;
import com.facebook.feedback.ui.FeedbackControllerParams;
import com.facebook.feedback.ui.FeedbackControllerProvider;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironment;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironmentProvider;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLPhotosAlbumAPIType;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResponseParser;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.model.GraphQLActorCache;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLAlbum.Builder;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.ipc.profile.TimelinePhotoTabModeParams;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.photos.albums.ProfilePicCoverPhotoEditHelper;
import com.facebook.photos.albums.events.AlbumsEventBus;
import com.facebook.photos.albums.events.AlbumsEvents.AlbumTitleRenamedEventSubscriber;
import com.facebook.photos.albums.protocols.AlbumQuery.AlbumFeedbackQueryString;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.base.photos.PhotoFetchInfo;
import com.facebook.photos.base.photos.PhotoFetchInfo.FetchCause;
import com.facebook.photos.experiments.ExperimentsForPhotosExperimentsModule;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents.DeletePhotoEventSubscriber;
import com.facebook.photos.pandora.common.events.PandoraEventBus;
import com.facebook.photos.pandora.common.events.PandoraEvents.LaunchConsumptionGalleryEvent;
import com.facebook.photos.pandora.common.events.PandoraEvents.LaunchConsumptionGalleryEventSubscriber;
import com.facebook.photos.pandora.common.ui.views.PandoraBennyLoadingSpinnerView;
import com.facebook.photos.pandora.logging.PandoraSequenceLogger;
import com.facebook.photos.pandora.ui.listview.PandoraFeedListView;
import com.facebook.photos.photoset.controllers.AlbumsPermalinkOptionsControllerProvider;
import com.facebook.photos.photoset.controllers.FbPhotoPickerController;
import com.facebook.photos.photoset.controllers.PhotoSetOnActivityResultController;
import com.facebook.photos.photoset.launcher.PhotoSetConsumptionGalleryPhotoLauncher;
import com.facebook.photos.photoset.ui.permalink.AlbumPermalinkTitleBarSupplier;
import com.facebook.photos.photoset.ui.permalink.GraphQLAlbumUtils;
import com.facebook.photos.photoset.ui.permalink.futures.AlbumPermalinkFuturesGenerator;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.photos.upload.event.MediaUploadEventSubscriber;
import com.facebook.photos.upload.event.MediaUploadSuccessEvent;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ufiservices.event.UfiEvents.CommentButtonClickedEventSubscriber;
import com.facebook.ufiservices.event.UfiEvents.LikeClickedEventSubscriber;
import com.facebook.ui.futures.TasksManager;
import com.facebook.video.activity.FullscreenVideoPlayerLauncher;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.MultiAdapterListAdapter;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.Futures.ImmediateFailedCheckedFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.facebook.pages.identity.fragments.identity.PageIdentityFragment */
public class PandoraAlbumMediaSetFragment extends FbFragment implements CanHandleBackPressed {
    public static final String aM = PandoraAlbumMediaSetFragment.class.getSimpleName();
    @Inject
    Lazy<PandoraAlbumMediaSetAdapter> f17643a;
    @Inject
    GraphQLSubscriptionHolder aA;
    @Inject
    Clock aB;
    @Inject
    AbstractFbErrorReporter aC;
    @Inject
    public FbEventSubscriberListManager aD;
    @Inject
    FeedEventBus aE;
    @Inject
    FeedbackMutator aF;
    @Inject
    Provider<GraphQLActorCache> aG;
    @Inject
    FeedbackControllerProvider aH;
    @Inject
    Lazy<TasksManager> aI;
    @Inject
    Lazy<AlbumPermalinkFuturesGenerator> aJ;
    @Inject
    PermalinkFeedStoryMenuHelperFactory aK;
    @Inject
    Lazy<PagesAnalytics> aL;
    public FeedbackController aN;
    private BaseCommentsEnvironment aO;
    public CommentAdapter aP;
    public CommentsHelper aQ;
    private MultiRowAdapter aR;
    private Context aS;
    private OneItemListItemCollection aT;
    private Set<Bindable<FeedProps<GraphQLFeedback>>> aU;
    private Set<Bindable<FeedProps<GraphQLFeedback>>> aV;
    private final LaunchPhotoGalleryEventSubscriber aW = new LaunchPhotoGalleryEventSubscriber(this);
    private final AlbumTitleUpdatedEventSubscriber aX = new AlbumTitleUpdatedEventSubscriber(this);
    public PandoraBennyLoadingSpinnerView aY;
    public TextView aZ;
    @Inject
    public PandoraAlbumMediaSetPropertyHandler al;
    @Inject
    Lazy<PhotoSetOnActivityResultController> am;
    @Inject
    public AlbumsPermalinkOptionsControllerProvider an;
    @Inject
    ViewerContext ao;
    @Inject
    public Product ap;
    @Inject
    FullscreenVideoPlayerLauncher aq;
    @Inject
    Lazy<ConsumptionPhotoEventBus> ar;
    @Inject
    QeAccessor as;
    @Inject
    PermalinkCommentNavigationDelegateProvider at;
    @Inject
    BaseCommentsEnvironmentProvider au;
    @Inject
    CommentAdapterFactory av;
    @Inject
    CommentsHelperProvider aw;
    @Inject
    MultiRowAdapterBuilder ax;
    @Inject
    Lazy<PandoraFooterPartDefinition> ay;
    @Inject
    PermalinkEnvironmentProvider az;
    @Inject
    Lazy<PhotoSetConsumptionGalleryPhotoLauncher> f17644b;
    public TimelinePhotoTabModeParams ba;
    public GraphQLAlbum bb;
    public CallerContext bc;
    public ComposerTargetData bd;
    private MediaUploadSuccessBusSubscriber be;
    private ProfilePermissions bf;
    public PandoraFeedListView bg;
    public MultiAdapterListAdapter bh;
    private LazyListViewDelegate bi;
    public long bj = -1;
    public boolean bk = false;
    private PandoraAdapter bl;
    private AlbumMediaSetDataSetObserver bm = new AlbumMediaSetDataSetObserver(this);
    private final PhotoDeleteSubscriber bn = new PhotoDeleteSubscriber(this);
    @Inject
    Lazy<ProfilePicCoverPhotoEditHelper> f17645c;
    @Inject
    Lazy<PandoraEventBus> f17646d;
    @Inject
    Lazy<AlbumsEventBus> f17647e;
    @Inject
    MediaUploadEventBus f17648f;
    @Inject
    public Lazy<AlbumPermalinkTitleBarSupplier> f17649g;
    @Inject
    PandoraSequenceLogger f17650h;
    @Inject
    Lazy<FbPhotoPickerController> f17651i;

    /* compiled from: com.facebook.pages.identity.fragments.identity.PageIdentityFragment */
    class C18741 implements Runnable {
        final /* synthetic */ PandoraAlbumMediaSetFragment f17627a;

        C18741(PandoraAlbumMediaSetFragment pandoraAlbumMediaSetFragment) {
            this.f17627a = pandoraAlbumMediaSetFragment;
        }

        public void run() {
            AdapterDetour.a(this.f17627a.bh, -829848968);
        }
    }

    /* compiled from: com.facebook.pages.identity.fragments.identity.PageIdentityFragment */
    class C18752 implements ScrollingProxy {
        final /* synthetic */ PandoraAlbumMediaSetFragment f17628a;

        C18752(PandoraAlbumMediaSetFragment pandoraAlbumMediaSetFragment) {
            this.f17628a = pandoraAlbumMediaSetFragment;
        }

        public final int m21597a() {
            return this.f17628a.bh.a(this.f17628a.aP);
        }
    }

    /* compiled from: com.facebook.pages.identity.fragments.identity.PageIdentityFragment */
    class C18763 implements Function<GraphQLFeedback, Void> {
        final /* synthetic */ PandoraAlbumMediaSetFragment f17629a;

        C18763(PandoraAlbumMediaSetFragment pandoraAlbumMediaSetFragment) {
            this.f17629a = pandoraAlbumMediaSetFragment;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
            PandoraAlbumMediaSetFragment pandoraAlbumMediaSetFragment = this.f17629a;
            Builder a = Builder.a(this.f17629a.bb);
            a.n = graphQLFeedback;
            pandoraAlbumMediaSetFragment.bb = a.a();
            PandoraAlbumMediaSetFragment.ax(this.f17629a);
            return null;
        }
    }

    /* compiled from: com.facebook.pages.identity.fragments.identity.PageIdentityFragment */
    class C18796 implements FutureCallback<GraphQLResult<GraphQLFeedback>> {
        final /* synthetic */ PandoraAlbumMediaSetFragment f17634a;

        C18796(PandoraAlbumMediaSetFragment pandoraAlbumMediaSetFragment) {
            this.f17634a = pandoraAlbumMediaSetFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null) {
                PandoraAlbumMediaSetFragment pandoraAlbumMediaSetFragment = this.f17634a;
                Builder a = Builder.a(this.f17634a.bb);
                a.n = (GraphQLFeedback) graphQLResult.e;
                pandoraAlbumMediaSetFragment.bb = a.a();
                PandoraAlbumMediaSetFragment.ay(this.f17634a);
            }
        }

        public void onFailure(Throwable th) {
            this.f17634a.aC.a(PandoraAlbumMediaSetFragment.aM, "Failed on GraphQLSubscription callback");
        }
    }

    /* compiled from: com.facebook.pages.identity.fragments.identity.PageIdentityFragment */
    public class C18807 extends LikeClickedEventSubscriber {
        final /* synthetic */ PandoraAlbumMediaSetFragment f17635a;

        public C18807(PandoraAlbumMediaSetFragment pandoraAlbumMediaSetFragment) {
            this.f17635a = pandoraAlbumMediaSetFragment;
        }

        public final void m21599b(FbEvent fbEvent) {
            GraphQLFeedback a = this.f17635a.aF.a(this.f17635a.bb.t(), ((GraphQLActorCacheImpl) this.f17635a.aG.get()).a(), !this.f17635a.bb.t().y_());
            FeedbackController feedbackController = this.f17635a.aN;
            GraphQLFeedback t = this.f17635a.bb.t();
            FeedbackLoggingParams.Builder builder = new FeedbackLoggingParams.Builder();
            builder.c = "album_permalink";
            builder = builder;
            builder.b = "permalink_ufi";
            builder = builder;
            builder.d = FeedbackDisplayType.STORY_PERMALINK;
            feedbackController.a(t, builder.a());
            PandoraAlbumMediaSetFragment pandoraAlbumMediaSetFragment = this.f17635a;
            Builder a2 = Builder.a(this.f17635a.bb);
            a2.n = a;
            pandoraAlbumMediaSetFragment.bb = a2.a();
            this.f17635a.aw();
        }
    }

    /* compiled from: com.facebook.pages.identity.fragments.identity.PageIdentityFragment */
    public class C18818 extends CommentButtonClickedEventSubscriber {
        final /* synthetic */ PandoraAlbumMediaSetFragment f17636a;

        public C18818(PandoraAlbumMediaSetFragment pandoraAlbumMediaSetFragment) {
            this.f17636a = pandoraAlbumMediaSetFragment;
        }

        public final void m21600b(FbEvent fbEvent) {
            this.f17636a.aQ.f();
        }
    }

    /* compiled from: com.facebook.pages.identity.fragments.identity.PageIdentityFragment */
    class C18829 implements Callable<ListenableFuture<GraphQLResult<GraphQLAlbum>>> {
        final /* synthetic */ PandoraAlbumMediaSetFragment f17637a;

        C18829(PandoraAlbumMediaSetFragment pandoraAlbumMediaSetFragment) {
            this.f17637a = pandoraAlbumMediaSetFragment;
        }

        public Object call() {
            ImmediateFailedCheckedFuture a;
            AlbumPermalinkFuturesGenerator albumPermalinkFuturesGenerator = (AlbumPermalinkFuturesGenerator) this.f17637a.aJ.get();
            String u = this.f17637a.bb.u();
            if (Strings.isNullOrEmpty(u)) {
                a = Futures.a(new RuntimeException("album Node ID cannot be null."));
            } else {
                GraphQlQueryString albumFeedbackQueryString = new AlbumFeedbackQueryString();
                albumFeedbackQueryString.a("node_id", u).a("max_comments", Integer.valueOf(25)).a("profile_image_size", GraphQLStoryHelper.a()).a("fetch_reshare_counts", Boolean.valueOf(albumPermalinkFuturesGenerator.f17899e.a(ExperimentsForFeedbackTestModule.T, false)));
                albumPermalinkFuturesGenerator.f17898d.a(albumFeedbackQueryString);
                albumPermalinkFuturesGenerator.f17898d.b(albumFeedbackQueryString);
                a = ((GraphQLQueryExecutor) albumPermalinkFuturesGenerator.f17895a.get()).a(GraphQLRequest.a(albumFeedbackQueryString).a(GraphQLCachePolicy.c));
            }
            return a;
        }
    }

    /* compiled from: com.facebook.pages.identity.fragments.identity.PageIdentityFragment */
    class AlbumMediaSetDataSetObserver extends DataSetObserver {
        final /* synthetic */ PandoraAlbumMediaSetFragment f17638a;

        public AlbumMediaSetDataSetObserver(PandoraAlbumMediaSetFragment pandoraAlbumMediaSetFragment) {
            this.f17638a = pandoraAlbumMediaSetFragment;
        }

        public void onChanged() {
            if (this.f17638a.hn_() && this.f17638a.m21619b() != null) {
                PandoraAlbumMediaSetFragment pandoraAlbumMediaSetFragment = this.f17638a;
                if (1 == 0) {
                    this.f17638a.aZ.setVisibility(0);
                }
                pandoraAlbumMediaSetFragment = this.f17638a;
                Builder a = Builder.a(this.f17638a.m21619b().f17623x);
                a.n = this.f17638a.bb.t();
                pandoraAlbumMediaSetFragment.bb = a.a();
                if (this.f17638a.bb.q() != null) {
                    this.f17638a.m21617a(this.f17638a.bb);
                }
                this.f17638a.aY.setVisibility(8);
            }
        }
    }

    /* compiled from: com.facebook.pages.identity.fragments.identity.PageIdentityFragment */
    class AlbumTitleUpdatedEventSubscriber extends AlbumTitleRenamedEventSubscriber {
        final /* synthetic */ PandoraAlbumMediaSetFragment f17639a;

        public AlbumTitleUpdatedEventSubscriber(PandoraAlbumMediaSetFragment pandoraAlbumMediaSetFragment) {
            this.f17639a = pandoraAlbumMediaSetFragment;
        }

        public final void m21601b(FbEvent fbEvent) {
            this.f17639a.m21619b().m21587a(this.f17639a.bb, this.f17639a.bd, null, this.f17639a.s.getBoolean("disable_adding_photos_to_albums", false), this.f17639a.bj, this.f17639a.bk);
        }
    }

    /* compiled from: com.facebook.pages.identity.fragments.identity.PageIdentityFragment */
    class LaunchPhotoGalleryEventSubscriber extends LaunchConsumptionGalleryEventSubscriber {
        final /* synthetic */ PandoraAlbumMediaSetFragment f17640a;

        public LaunchPhotoGalleryEventSubscriber(PandoraAlbumMediaSetFragment pandoraAlbumMediaSetFragment) {
            this.f17640a = pandoraAlbumMediaSetFragment;
        }

        public final void m21602b(FbEvent fbEvent) {
            LaunchConsumptionGalleryEvent launchConsumptionGalleryEvent = (LaunchConsumptionGalleryEvent) fbEvent;
            boolean z = false;
            PhotoFetchInfo photoFetchInfo = new PhotoFetchInfo(FetchCause.USER_INITIATED, this.f17640a.bc);
            if (((FbPhotoPickerController) this.f17640a.f17651i.get()).f17782a) {
                ((ProfilePicCoverPhotoEditHelper) this.f17640a.f17645c.get()).a(Long.parseLong(launchConsumptionGalleryEvent.f17374a), launchConsumptionGalleryEvent.f17375b, this.f17640a, photoFetchInfo, false);
            } else if (((FbPhotoPickerController) this.f17640a.f17651i.get()).f17783b) {
                ((ProfilePicCoverPhotoEditHelper) this.f17640a.f17645c.get()).a(Long.parseLong(launchConsumptionGalleryEvent.f17374a), launchConsumptionGalleryEvent.f17375b, this.f17640a, photoFetchInfo, true);
            } else if (this.f17640a.ba != null && this.f17640a.ba.c() && launchConsumptionGalleryEvent.f17378e != null) {
                ((ProfilePicCoverPhotoEditHelper) this.f17640a.f17645c.get()).a(launchConsumptionGalleryEvent.f17378e, this.f17640a.ao());
            } else if (this.f17640a.ba == null || !this.f17640a.ba.d() || launchConsumptionGalleryEvent.f17378e == null) {
                if (launchConsumptionGalleryEvent.f17379f != null) {
                    z = true;
                }
                if (z) {
                    this.f17640a.aq.m11256a(launchConsumptionGalleryEvent.f17379f, this.f17640a.getContext(), PlayerOrigin.VIDEO_ALBUM_PERMALINK);
                } else {
                    PandoraAlbumMediaSetFragment.m21607a(this.f17640a, launchConsumptionGalleryEvent.f17374a, launchConsumptionGalleryEvent.f17375b);
                }
                if (this.f17640a.bk) {
                    ((PagesAnalytics) this.f17640a.aL.get()).a(this.f17640a.bj, "album_detail_view", z);
                }
            } else {
                ((ProfilePicCoverPhotoEditHelper) this.f17640a.f17645c.get()).a(launchConsumptionGalleryEvent.f17378e, this.f17640a.o(), Long.parseLong(this.f17640a.ao.mUserId));
            }
        }
    }

    /* compiled from: com.facebook.pages.identity.fragments.identity.PageIdentityFragment */
    class MediaUploadSuccessBusSubscriber extends MediaUploadEventSubscriber<MediaUploadSuccessEvent> {
        final /* synthetic */ PandoraAlbumMediaSetFragment f17641a;

        public MediaUploadSuccessBusSubscriber(PandoraAlbumMediaSetFragment pandoraAlbumMediaSetFragment) {
            this.f17641a = pandoraAlbumMediaSetFragment;
        }

        public final void m21604b(FbEvent fbEvent) {
            MediaUploadSuccessEvent mediaUploadSuccessEvent = (MediaUploadSuccessEvent) fbEvent;
            if (this.f17641a.m21619b() != null) {
                GraphQLAlbum graphQLAlbum = this.f17641a.m21619b().f17623x;
                if (PandoraAlbumMediaSetFragment.m21609f(graphQLAlbum) == 67338874) {
                    String str;
                    if (graphQLAlbum == null || graphQLAlbum.x() == null) {
                        str = null;
                    } else {
                        str = graphQLAlbum.x().b();
                    }
                    String str2 = str;
                    if (Strings.isNullOrEmpty(str2) || mediaUploadSuccessEvent.a.f != Long.parseLong(str2)) {
                        return;
                    }
                } else if (mediaUploadSuccessEvent.a.f != Long.parseLong(this.f17641a.bb.u())) {
                    return;
                }
                this.f17641a.m21619b().m21432c();
            }
        }

        public final Class<MediaUploadSuccessEvent> m21603a() {
            return MediaUploadSuccessEvent.class;
        }
    }

    /* compiled from: com.facebook.pages.identity.fragments.identity.PageIdentityFragment */
    class PhotoDeleteSubscriber extends DeletePhotoEventSubscriber {
        final /* synthetic */ PandoraAlbumMediaSetFragment f17642a;

        public PhotoDeleteSubscriber(PandoraAlbumMediaSetFragment pandoraAlbumMediaSetFragment) {
            this.f17642a = pandoraAlbumMediaSetFragment;
        }

        public final void m21605b(FbEvent fbEvent) {
            if (this.f17642a.m21619b() != null) {
                this.f17642a.m21619b().m21432c();
            }
        }
    }

    public static void m21608a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PandoraAlbumMediaSetFragment) obj).m21606a(IdBasedLazy.a(injectorLike, 9397), IdBasedLazy.a(injectorLike, 9409), IdBasedLazy.a(injectorLike, 9245), IdBasedSingletonScopeProvider.b(injectorLike, 9375), IdBasedSingletonScopeProvider.b(injectorLike, 9247), MediaUploadEventBus.a(injectorLike), IdBasedLazy.a(injectorLike, 9411), PandoraSequenceLogger.m21549a(injectorLike), IdBasedLazy.a(injectorLike, 9406), PandoraAlbumMediaSetPropertyHandler.m21622a(injectorLike), IdBasedLazy.a(injectorLike, 9408), (AlbumsPermalinkOptionsControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AlbumsPermalinkOptionsControllerProvider.class), ViewerContextMethodAutoProvider.a(injectorLike), ProductMethodAutoProvider.a(injectorLike), FullscreenVideoPlayerLauncher.m11253a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2971), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (PermalinkCommentNavigationDelegateProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PermalinkCommentNavigationDelegateProvider.class), (BaseCommentsEnvironmentProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BaseCommentsEnvironmentProvider.class), CommentAdapterFactory.a(injectorLike), (CommentsHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CommentsHelperProvider.class), MultiRowAdapterBuilder.a(injectorLike), IdBasedLazy.a(injectorLike, 9399), (PermalinkEnvironmentProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PermalinkEnvironmentProvider.class), GraphQLSubscriptionHolder.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), FbEventSubscriberListManager.a(injectorLike), FeedEventBus.a(injectorLike), FeedbackMutator.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 262), (FeedbackControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedbackControllerProvider.class), IdBasedLazy.a(injectorLike, 3561), IdBasedSingletonScopeProvider.b(injectorLike, 9414), PermalinkFeedStoryMenuHelperFactory.m14017a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 8930));
    }

    private void m21606a(Lazy<PandoraAlbumMediaSetAdapter> lazy, Lazy<PhotoSetConsumptionGalleryPhotoLauncher> lazy2, Lazy<ProfilePicCoverPhotoEditHelper> lazy3, Lazy<PandoraEventBus> lazy4, Lazy<AlbumsEventBus> lazy5, MediaUploadEventBus mediaUploadEventBus, Lazy<AlbumPermalinkTitleBarSupplier> lazy6, PandoraSequenceLogger pandoraSequenceLogger, Lazy<FbPhotoPickerController> lazy7, AlbumMediaSetPropertyHandler albumMediaSetPropertyHandler, Lazy<PhotoSetOnActivityResultController> lazy8, AlbumsPermalinkOptionsControllerProvider albumsPermalinkOptionsControllerProvider, ViewerContext viewerContext, Product product, FullscreenVideoPlayerLauncher fullscreenVideoPlayerLauncher, Lazy<ConsumptionPhotoEventBus> lazy9, QeAccessor qeAccessor, PermalinkCommentNavigationDelegateProvider permalinkCommentNavigationDelegateProvider, BaseCommentsEnvironmentProvider baseCommentsEnvironmentProvider, CommentAdapterFactory commentAdapterFactory, CommentsHelperProvider commentsHelperProvider, MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<PandoraFooterPartDefinition> lazy10, PermalinkEnvironmentProvider permalinkEnvironmentProvider, GraphQLSubscriptionHolder graphQLSubscriptionHolder, Clock clock, FbErrorReporter fbErrorReporter, FbEventSubscriberListManager fbEventSubscriberListManager, FeedEventBus feedEventBus, FeedbackMutator feedbackMutator, Provider<GraphQLActorCache> provider, FeedbackControllerProvider feedbackControllerProvider, Lazy<TasksManager> lazy11, Lazy<AlbumPermalinkFuturesGenerator> lazy12, PermalinkFeedStoryMenuHelperFactory permalinkFeedStoryMenuHelperFactory, Lazy<PagesAnalytics> lazy13) {
        this.f17643a = lazy;
        this.f17644b = lazy2;
        this.f17645c = lazy3;
        this.f17646d = lazy4;
        this.f17647e = lazy5;
        this.f17648f = mediaUploadEventBus;
        this.f17649g = lazy6;
        this.f17650h = pandoraSequenceLogger;
        this.f17651i = lazy7;
        this.al = albumMediaSetPropertyHandler;
        this.am = lazy8;
        this.an = albumsPermalinkOptionsControllerProvider;
        this.ao = viewerContext;
        this.ap = product;
        this.aq = fullscreenVideoPlayerLauncher;
        this.ar = lazy9;
        this.as = qeAccessor;
        this.at = permalinkCommentNavigationDelegateProvider;
        this.au = baseCommentsEnvironmentProvider;
        this.av = commentAdapterFactory;
        this.aw = commentsHelperProvider;
        this.ax = multiRowAdapterBuilder;
        this.ay = lazy10;
        this.az = permalinkEnvironmentProvider;
        this.aA = graphQLSubscriptionHolder;
        this.aB = clock;
        this.aC = fbErrorReporter;
        this.aD = fbEventSubscriberListManager;
        this.aE = feedEventBus;
        this.aF = feedbackMutator;
        this.aG = provider;
        this.aH = feedbackControllerProvider;
        this.aI = lazy11;
        this.aJ = lazy12;
        this.aK = permalinkFeedStoryMenuHelperFactory;
        this.aL = lazy13;
    }

    public void m21621c(@Nullable Bundle bundle) {
        List list;
        super.c(bundle);
        Class cls = PandoraAlbumMediaSetFragment.class;
        m21608a((Object) this, getContext());
        e(true);
        this.be = new MediaUploadSuccessBusSubscriber(this);
        this.bb = (GraphQLAlbum) FlatBufferModelHelper.a(this.s, "extra_album_selected");
        this.bc = (CallerContext) this.s.getParcelable("extra_caller_context");
        this.ba = (TimelinePhotoTabModeParams) this.s.getParcelable("extra_photo_tab_mode_params");
        this.bj = this.s.getLong("owner_id", -1);
        this.bk = this.s.getBoolean("is_page", false);
        this.bi = HasScrollListenerSupportImpl.a();
        if (this.ao.mIsPageContext) {
            this.bd = (ComposerTargetData) this.s.getParcelable("extra_composer_target_data");
            if (this.bd == null) {
                ComposerTargetData.Builder builder = new ComposerTargetData.Builder(Long.parseLong(this.ao.mUserId), TargetType.PAGE);
                builder.f = true;
                this.bd = builder.a();
            }
            List stringArrayList = this.s.getStringArrayList("extra_pages_admin_permissions");
            if (stringArrayList != null) {
                this.bf = new ProfilePermissions(stringArrayList);
                list = stringArrayList;
            } else {
                list = stringArrayList;
            }
        } else {
            if (this.bd == null) {
                this.bd = (ComposerTargetData) this.s.getParcelable("extra_composer_target_data");
            }
            list = null;
        }
        this.bl = new PandoraAdapter(m21619b());
        ImmutableList.Builder builder2 = ImmutableList.builder();
        builder2.c(this.bl);
        if (aA()) {
            this.aN = this.aH.a(FeedbackControllerParams.a);
            Runnable c18741 = new C18741(this);
            PermalinkCommentNavigationDelegate a = this.at.a(az());
            this.aO = this.au.a(az(), a, c18741);
            this.aP = this.av.a(a, this.aO, null);
            this.aT = new OneItemListItemCollection();
            PermalinkEnvironment a2 = PermalinkEnvironmentProvider.a(getContext(), PermalinkFeedListType.a, this.bi, this.aK, c18741);
            MultiRowAdapterBuilder.Builder a3 = this.ax.a(this.ay, this.aT);
            a3.f = a2;
            this.aR = a3.e();
            builder2.c(this.aR);
            this.aQ = this.aw.a(this, this.aP, this.aO, new C18752(this), new C18763(this));
            builder2.c(this.aP);
            this.aU = Sets.a(new Bindable[]{this.aQ});
            this.aV = Sets.a(new Bindable[]{this.aQ});
            aB();
            this.aD.a(new C18807(this));
            this.aD.a(new C18818(this));
            if (this.bb.t() == null) {
                aE();
            }
        }
        this.bh = MultiAdapterListAdapter.a(builder2.b());
        m21619b().m21587a(this.bb, this.bd, list, this.s.getBoolean("disable_adding_photos_to_albums", false), this.bj, this.bk);
        m21619b().registerDataSetObserver(this.bm);
    }

    public View m21614a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 369150138);
        this.f17650h.m21551a("InflateAlbumMediaSetFragment");
        View inflate = LayoutInflater.from(az()).inflate(2130903232, viewGroup, false);
        this.f17650h.m21553b("InflateAlbumMediaSetFragment");
        this.bg = (PandoraFeedListView) inflate.findViewById(2131558482);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 491196618, a);
        return inflate;
    }

    public final void m21616a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.bg.setAdapter(this.bh);
        this.bg.f17748a = this.bl;
        this.bi.a(this.bg);
        if (aA()) {
            this.aQ.a(view, new ListViewProxy(this.bg));
            aw();
        }
        this.f17650h.m21551a("SpinnerAlbumMediaSetFragment");
        this.aY = (PandoraBennyLoadingSpinnerView) view.findViewById(2131559548);
        if (1 != 0) {
            this.aY.setVisibility(8);
            this.f17650h.m21553b("SpinnerAlbumMediaSetFragment");
        }
        this.aZ = (TextView) view.findViewById(2131559549);
    }

    public final void m21611G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1868176881);
        super.G();
        ((PandoraEventBus) this.f17646d.get()).a(this.aW);
        ((AlbumsEventBus) this.f17647e.get()).a(this.aX);
        this.f17648f.a(this.be);
        ((ConsumptionPhotoEventBus) this.ar.get()).a(this.bn);
        if (aA()) {
            this.aQ.d();
            this.aA.e();
            this.aD.a(this.aE);
        }
        if (this.bb != null) {
            m21617a(this.bb);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -35183824, a);
    }

    public final void m21612H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 602978131);
        super.H();
        ((PandoraEventBus) this.f17646d.get()).b(this.aW);
        ((AlbumsEventBus) this.f17647e.get()).b(this.aX);
        ((ProfilePicCoverPhotoEditHelper) this.f17645c.get()).a();
        this.f17648f.b(this.be);
        ((ConsumptionPhotoEventBus) this.ar.get()).b(this.bn);
        if (aA()) {
            this.aQ.c();
            this.aA.d();
            this.aD.b(this.aE);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -95905770, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -310357464);
        if (m21619b() != null) {
            try {
                m21619b().unregisterDataSetObserver(this.bm);
            } catch (IllegalStateException e) {
                this.aC.a(aM, "onDestoryView " + e.getMessage());
            }
        }
        if (aA()) {
            this.aQ.a();
        }
        super.mY_();
        LogUtils.f(733465995, a);
    }

    public final void m21613I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1722728290);
        if (m21619b() != null) {
            m21619b().m21437i();
            m21618a(null);
        }
        if (aA()) {
            this.aR.jc_();
            this.aQ.b();
            this.aP.jc_();
            this.aA.a();
        }
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1431171309, a);
    }

    public boolean O_() {
        if (aA() && this.aQ != null && this.aQ.a(az())) {
            return true;
        }
        if (m21619b() != null) {
            m21619b().m21437i();
            m21618a(null);
        }
        return false;
    }

    public final void m21615a(int i, int i2, Intent intent) {
        if (aA()) {
            this.aQ.a(i, i2, intent);
        }
        if (i == 4 && i2 == -1) {
            m21619b().f17623x = (GraphQLAlbum) FlatBufferModelHelper.a(intent, "Updated_ALBUM");
            AdapterDetour.a(m21619b(), -1195771343);
        } else if (((PhotoSetOnActivityResultController) this.am.get()).m21764a(ao(), i, i2, intent)) {
            Object obj;
            if (this.ap == Product.PAA && (i == 2000 || i == 2001)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                ao().onBackPressed();
            } else {
                ao().finish();
            }
        } else {
            super.a(i, i2, intent);
        }
    }

    protected PandoraAlbumMediaSetAdapter m21619b() {
        return (PandoraAlbumMediaSetAdapter) this.f17643a.get();
    }

    protected void m21618a(final PandoraAlbumMediaSetAdapter pandoraAlbumMediaSetAdapter) {
        this.f17643a = new Lazy<PandoraAlbumMediaSetAdapter>(this) {
            final /* synthetic */ PandoraAlbumMediaSetFragment f17631b;

            public Object get() {
                return pandoraAlbumMediaSetAdapter;
            }
        };
    }

    public static void m21607a(PandoraAlbumMediaSetFragment pandoraAlbumMediaSetFragment, String str, Uri uri) {
        if (!Strings.isNullOrEmpty(str) && pandoraAlbumMediaSetFragment.m21619b() != null) {
            ((PhotoSetConsumptionGalleryPhotoLauncher) pandoraAlbumMediaSetFragment.f17644b.get()).m21767a(pandoraAlbumMediaSetFragment.ao(), pandoraAlbumMediaSetFragment.bb, str, uri, pandoraAlbumMediaSetFragment.m21619b().f17457i.m21444d(), FullscreenGallerySource.ALBUM_PERMALINK, false);
        }
    }

    protected void m21617a(final GraphQLAlbum graphQLAlbum) {
        PandoraAlbumMediaSetPropertyHandler pandoraAlbumMediaSetPropertyHandler = this.al;
        if (1 != 0 && graphQLAlbum.k() != GraphQLPhotosAlbumAPIType.PROFILE && graphQLAlbum.k() != GraphQLPhotosAlbumAPIType.WALL && graphQLAlbum.k() != GraphQLPhotosAlbumAPIType.COVER && graphQLAlbum.k() != GraphQLPhotosAlbumAPIType.MOBILE && graphQLAlbum.k() != GraphQLPhotosAlbumAPIType.APP && m21620b(graphQLAlbum)) {
            TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
            a.i = 2130837574;
            a = a;
            a.j = getContext().getResources().getString(2131234357);
            TitleBarButtonSpec a2 = a.a();
            C18785 c18785 = new OnToolbarButtonListener(this) {
                final /* synthetic */ PandoraAlbumMediaSetFragment f17633b;

                public final void m21598a(View view, TitleBarButtonSpec titleBarButtonSpec) {
                    this.f17633b.an.m21756a(graphQLAlbum).m21755a(view, this.f17633b.ao(), this.f17633b, this.f17633b.as(), false);
                }
            };
            FbTitleBar fbTitleBar = ((AlbumPermalinkTitleBarSupplier) this.f17649g.get()).f17823a;
            if (fbTitleBar != null) {
                fbTitleBar.setTitle(jW_().getString(2131236719));
                fbTitleBar.setButtonSpecs(ImmutableList.of(a2));
                fbTitleBar.setOnToolbarButtonListener(c18785);
            }
        }
    }

    public static int m21609f(GraphQLAlbum graphQLAlbum) {
        if (graphQLAlbum == null || graphQLAlbum.x() == null || graphQLAlbum.x().j() == null) {
            return 0;
        }
        return graphQLAlbum.x().j().g();
    }

    public final boolean m21620b(GraphQLAlbum graphQLAlbum) {
        if (m21609f(graphQLAlbum) != 2479791) {
            return GraphQLAlbumUtils.m21793b(graphQLAlbum, this.ao.mUserId);
        }
        boolean z;
        if (GraphQLAlbumUtils.m21793b(graphQLAlbum, this.ao.mUserId) || GraphQLAlbumUtils.m21792a(graphQLAlbum, this.ao.mUserId)) {
            z = true;
        } else {
            z = false;
        }
        if (this.bf == null) {
            return z;
        }
        if (z && this.bf.a(Permission.EDIT_PROFILE)) {
            return true;
        }
        return false;
    }

    public final boolean as() {
        boolean z = (this.bb == null || this.bb.u() == null || this.bb.D() == null || this.bb.E() == null || this.bb.B() == null || this.bb.B().H() == null || this.bb.B().b() == null) ? false : true;
        return z && !this.ao.mIsPageContext && this.as.a(ExperimentsForPhotosExperimentsModule.c, false);
    }

    private void aw() {
        Object c = this.bb.t() != null ? FeedProps.c(this.bb.t()) : null;
        for (Bindable a : this.aU) {
            a.a(c);
        }
        this.aT.a = this.bb.t();
        this.aR.notifyDataSetChanged();
        aB();
    }

    public static void ax(PandoraAlbumMediaSetFragment pandoraAlbumMediaSetFragment) {
        for (Bindable a : pandoraAlbumMediaSetFragment.aV) {
            a.a(FeedProps.c(pandoraAlbumMediaSetFragment.bb.t()));
        }
        pandoraAlbumMediaSetFragment.aB();
    }

    public static void ay(PandoraAlbumMediaSetFragment pandoraAlbumMediaSetFragment) {
        pandoraAlbumMediaSetFragment.aT.a = pandoraAlbumMediaSetFragment.bb.t();
        pandoraAlbumMediaSetFragment.aR.notifyDataSetChanged();
        pandoraAlbumMediaSetFragment.aB();
    }

    private Context az() {
        if (this.aS == null) {
            this.aS = new ContextThemeWrapper(getContext(), 2131626110);
        }
        return this.aS;
    }

    private boolean aA() {
        return this.as.a(ExperimentsForPhotosExperimentsModule.a, false);
    }

    private void aB() {
        if (this.bb.t() != null) {
            this.aA.a(new C18796(this), this.bb.t().z_(), this.aA.a(this.bb.t(), DataFreshnessResult.FROM_SERVER, this.aB.a(), ImmutableSet.copyOf(GraphQLResponseParser.a(this.bb.t()))));
        }
    }

    private void aE() {
        ((TasksManager) this.aI.get()).a(StringFormatUtil.a("refetchAlbumDetails_%s", new Object[]{this.bb.u()}), new C18829(this), new AbstractDisposableFutureCallback<GraphQLResult<GraphQLAlbum>>(this) {
            final /* synthetic */ PandoraAlbumMediaSetFragment f17626a;

            {
                this.f17626a = r1;
            }

            protected final void m21595a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult != null && graphQLResult.e != null) {
                    Builder a = Builder.a(this.f17626a.bb);
                    a.n = ((GraphQLAlbum) graphQLResult.e).t();
                    Builder builder = a;
                    this.f17626a.bb = builder.a();
                    this.f17626a.aw();
                }
            }

            protected final void m21596a(Throwable th) {
                this.f17626a.aC.a(PandoraAlbumMediaSetFragment.aM, "Failed on fetch album feedback");
            }
        });
    }
}
