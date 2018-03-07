package com.facebook.groups.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.api.feed.FeedFetchContext;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.api.feed.data.LegacyFeedUnitUpdater;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.api.feed.service.GraphPostService;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.caspian.ui.standardheader.StandardHeaderViewHelper;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.foreach.RandomAccessList;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.locale.Locales;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.FindViewUtil;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.composer.sell.GroupCommerceSellComposerIntercept;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.controller.connectioncontroller.ConnectionControllerBuilder;
import com.facebook.controller.connectioncontroller.ConnectionControllerBuilderProvider;
import com.facebook.controller.connectioncontroller.common.ConnectionCachePolicy;
import com.facebook.controller.connectioncontroller.common.ConnectionController;
import com.facebook.controller.connectioncontroller.common.ConnectionListener;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation.LocationType;
import com.facebook.controller.connectioncontroller.common.ConnectionOrder;
import com.facebook.controller.connectioncontroller.common.ConnectionState;
import com.facebook.controller.connectioncontroller.common.ListViewConnectionListener;
import com.facebook.controller.connectioncontroller.common.MutationControllerManager;
import com.facebook.controller.mutation.LegacyFeedUnitStoreUpdater;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.dialtone.common.DialtoneStateChangedListener;
import com.facebook.dracula.api.DraculaHelper;
import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaRuntime;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.GenericNotificationBanner;
import com.facebook.feed.ui.GenericNotificationBanner.NotificationBannerType;
import com.facebook.feed.ui.basefeedfragment.BaseFeedFragment;
import com.facebook.feed.util.composer.ComposerActivityReceiver;
import com.facebook.feed.util.composer.OfflinePostLoader;
import com.facebook.feed.util.composer.OfflinePostLoader.Listener;
import com.facebook.feed.util.composer.OptimisticPostStoryBuilder;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.HideEvents.StoryDeleteEvent;
import com.facebook.feed.util.event.HideEvents.StoryDeleteEventSubscriber;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.enums.GraphQLGroupContentRestrictionReason;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupPostStatus;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryCommerceHelper;
import com.facebook.groupcommerce.util.GroupCommerceComposerHelper;
import com.facebook.groups.abtest.GroupsExperimentalFeatures;
import com.facebook.groups.create.coverphoto.GroupsCoverPhotoHandler;
import com.facebook.groups.create.coverphoto.event.GroupCoverPhotoUpdateEvent;
import com.facebook.groups.create.coverphoto.event.GroupCoverPhotoUpdateEventBus;
import com.facebook.groups.create.coverphoto.event.GroupCoverPhotoUpdateEventSubscriber;
import com.facebook.groups.feed.controller.BridgeConnectionController;
import com.facebook.groups.feed.controller.GroupsConnectionConfiguration;
import com.facebook.groups.feed.controller.GroupsFeedController;
import com.facebook.groups.feed.controller.GroupsFeedControllerResponder;
import com.facebook.groups.feed.controller.GroupsFeedPager;
import com.facebook.groups.feed.controller.GroupsFeedPager.PagerListener;
import com.facebook.groups.feed.controller.GroupsFeedPagerProtocol;
import com.facebook.groups.feed.controller.GroupsListViewController;
import com.facebook.groups.feed.controller.GroupsListViewController.1;
import com.facebook.groups.feed.controller.GroupsListViewController.2;
import com.facebook.groups.feed.controller.GroupsListViewController.3;
import com.facebook.groups.feed.controller.HoistedStoriesCollectionWrapper;
import com.facebook.groups.feed.controller.MergingStickyHeaderAdapter;
import com.facebook.groups.feed.controller.SearchAwarenessGroupsPillController;
import com.facebook.groups.feed.controller.SearchAwarenessGroupsPillControllerProvider;
import com.facebook.groups.feed.data.GroupsFeedConsistencySync;
import com.facebook.groups.feed.data.GroupsFeedConsistencySyncProvider;
import com.facebook.groups.feed.data.GroupsFeedHeaderFetcher;
import com.facebook.groups.feed.data.GroupsFeedPinStoryController;
import com.facebook.groups.feed.data.GroupsFeedPinStoryController.GroupsPinDataChangeListener;
import com.facebook.groups.feed.data.GroupsGraphSearchHelper;
import com.facebook.groups.feed.data.PinState;
import com.facebook.groups.feed.data.ViewerStatusCache;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQL;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQL.FetchGroupInformationString;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.DraculaImplementation;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel.Builder;
import com.facebook.groups.feed.protocol.FetchGroupsStoriesMallIdsMethod;
import com.facebook.groups.feed.protocol.FetchGroupsStoriesMallIdsMethodProvider;
import com.facebook.groups.feed.protocol.GroupsFeedTypeValueParams;
import com.facebook.groups.feed.protocol.GroupsFeedTypeValueParams.GroupsFeedTypes;
import com.facebook.groups.feed.rows.BaseGroupsMultiRowAdapterFactory;
import com.facebook.groups.feed.rows.GroupsFeedListType;
import com.facebook.groups.feed.rows.partdefinitions.HidePinnedStoryPartDefinition;
import com.facebook.groups.feed.ui.GroupsEnvironment.MenuType;
import com.facebook.groups.feed.ui.contextual.GroupsContextItemsHelper;
import com.facebook.groups.feed.ui.partdefinitions.FB4AGroupsFeedRootPartDefinitionFactory;
import com.facebook.groups.feed.ui.partdefinitions.GroupsGraphQLStorySelectorPartDefinition;
import com.facebook.groups.logging.GroupsSequenceLogger;
import com.facebook.groups.protocol.GroupInformationInterfaceFactory;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.InterstitialStartHelper;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ProductItemAttachment;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quickpromotion.ui.QuickPromotionFooterController;
import com.facebook.quickpromotion.ui.QuickPromotionFooterFragment;
import com.facebook.quickpromotion.ui.QuickPromotionFragment;
import com.facebook.quickpromotion.ui.QuickPromotionFragment.QuickPromotionFragmentHost;
import com.facebook.quickpromotion.ui.QuickPromotionFragmentFactory;
import com.facebook.quickpromotion.ui.QuickPromotionInterstitialController;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQueryProvider;
import com.facebook.search.interfaces.GraphSearchTitleSupport;
import com.facebook.search.logging.SearchAwarenessLogger;
import com.facebook.search.quickpromotion.ScopedSearchGroupsNuxController;
import com.facebook.search.titlebar.GraphSearchIntentLauncher;
import com.facebook.search.util.GraphSearchConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.tablet.abtest.SideshowCompatibleContainer;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.LazyView;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.listview.ScrollingViewProxyContainer;
import com.facebook.widget.titlebar.FadingContentFragmentController;
import com.facebook.widget.titlebar.FadingContentView;
import com.facebook.widget.titlebar.FadingContentViewProvider;
import com.facebook.widget.titlebar.FadingFbTitleBar;
import com.facebook.widget.titlebar.FadingTitlebarContent;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@GraphSearchTitleSupport
/* compiled from: TimelineContextualInfoAdapter.unknownRenderingStyle */
public class GroupsFeedFragment extends BaseFeedFragment implements AnalyticsFragmentWithExtraData, DialtoneStateChangedListener, GroupsFeedControllerResponder, QuickPromotionFragmentHost, GraphSearchQueryProvider, SideshowCompatibleContainer, ScrollingViewProxyContainer, FadingContentViewProvider {
    public static final String aY = GroupsFeedFragment.class.getName();
    @Inject
    GroupsSequenceLogger f22149a;
    @Inject
    Provider<ViewerContext> aA;
    @Inject
    Locales aB;
    @Inject
    GraphQLSubscriptionHolder aC;
    @Inject
    BaseGroupsMultiRowAdapterFactory aD;
    @Inject
    FB4AGroupsFeedRootPartDefinitionFactory aE;
    @Inject
    Lazy<GroupsGraphQLStorySelectorPartDefinition> aF;
    @Inject
    Lazy<HidePinnedStoryPartDefinition> aG;
    @Inject
    GroupsEnvironmentProvider aH;
    @Inject
    public GroupsCoverPhotoHandler aI;
    @Inject
    GraphSearchConfig aJ;
    @Inject
    @ForUiThread
    public Handler aK;
    @Inject
    GroupsInlineComposerActionOptionController aL;
    @Inject
    SecureContextHelper aM;
    @Inject
    @IsGroupCommerceNewDeleteInterceptEnabled
    Provider<Boolean> aN;
    @Inject
    @IsGroupCommercePurposeModalEnabled
    Provider<Boolean> aO;
    @Inject
    Provider<GraphPostService> aP;
    @Inject
    FbUriIntentHandler aQ;
    @Inject
    DialtoneController aR;
    @Inject
    GroupCoverPhotoUpdateEventBus aS;
    @Inject
    OptimisticStoryStateCache aT;
    @Inject
    QeAccessor aU;
    @Inject
    SearchAwarenessGroupsPillControllerProvider aV;
    @Inject
    public GraphSearchIntentLauncher aW;
    @Inject
    GroupsExperimentalFeatures aX;
    public String aZ;
    @Inject
    GroupsFeedConsistencySyncProvider al;
    @Inject
    GroupsFeedController am;
    @Inject
    ConnectionControllerBuilderProvider an;
    @Inject
    GroupsListViewController ao;
    @Inject
    GroupsConnectionConfiguration ap;
    @Inject
    BridgeConnectionController aq;
    @Inject
    public ComposerLauncher ar;
    @Inject
    TasksManager as;
    @Inject
    InterstitialStartHelper at;
    @Inject
    QuickPromotionFragmentFactory au;
    @Inject
    public InterstitialManager av;
    @Inject
    ReactionSessionManager aw;
    @Inject
    GroupsPlutoniumHeaderAdapterProvider ax;
    @Inject
    FeedEventBus ay;
    @Inject
    public FbTitleBarSupplier az;
    @Inject
    GroupsFeedHeaderFetcher f22150b;
    public MultiRowAdapter bA;
    private boolean bB = true;
    public boolean bC = false;
    public boolean bD = false;
    public final FutureCallback<GraphQLResult<FetchGroupInformationModel>> bE = new C31861(this);
    private String ba;
    private ArrayList<String> bb;
    private GroupsPlutoniumHeaderAdapter bc;
    private FeedType bd;
    public GroupsFeedConsistencySync be;
    private View bf;
    private QuickPromotionFooterFragment bg;
    private boolean bh = false;
    private GroupsPinDataChangeListener bi;
    private ViewGroup bj;
    private Listener bk;
    private FadingContentFragmentController bl;
    private StoryDeleteEventSubscriber bm;
    private StoryDeleteEventSubscriber bn;
    public Runnable bo;
    public boolean bp;
    private HoistedStoriesCollectionWrapper bq;
    private Context br;
    public boolean bs;
    public boolean bt;
    private GroupCoverPhotoUpdateEventSubscriber bu;
    private ConnectionListener<GraphQLFeedUnitEdge> bv;
    private ConnectionController<GraphQLFeedUnitEdge, Boolean> bw;
    public SearchAwarenessGroupsPillController bx;
    private OnScrollListener by;
    public FetchGroupInformationModel bz;
    @Inject
    public ComposerActivityReceiver f22151c;
    @Inject
    AbstractFbErrorReporter f22152d;
    @Inject
    OfflinePostLoader f22153e;
    @Inject
    GroupsFeedPagerProtocol f22154f;
    @Inject
    ComposerPublishServiceHelper f22155g;
    @Inject
    GroupsFeedPinStoryController f22156h;
    @Inject
    FetchGroupsStoriesMallIdsMethodProvider f22157i;

    /* compiled from: TimelineContextualInfoAdapter.unknownRenderingStyle */
    class C31861 implements FutureCallback<GraphQLResult<FetchGroupInformationModel>> {
        final /* synthetic */ GroupsFeedFragment f22138a;

        C31861(GroupsFeedFragment groupsFeedFragment) {
            this.f22138a = groupsFeedFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            final GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.d() != null) {
                C31851 c31851 = new Object(this) {
                    final /* synthetic */ C31861 f22124b;

                    public final void m23228a(String str) {
                        this.f22124b.f22138a.f22152d.a("dracula_npe_11331948", this.f22124b.f22138a.aZ + ": " + graphQLResult.freshness + ", " + str);
                    }
                };
                C31851 a = DraculaHelper.a();
                DraculaHelper.a(c31851);
                try {
                    GroupsFeedFragment.m23260a(this.f22138a, (FetchGroupInformationModel) graphQLResult.d());
                } finally {
                    DraculaHelper.a(a);
                }
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: TimelineContextualInfoAdapter.unknownRenderingStyle */
    class C31872 implements GroupsPinDataChangeListener {
        final /* synthetic */ GroupsFeedFragment f22139a;

        C31872(GroupsFeedFragment groupsFeedFragment) {
            this.f22139a = groupsFeedFragment;
        }

        public final void m23241b() {
            this.f22139a.bA.notifyDataSetChanged();
        }

        public final void m23240a() {
            this.f22139a.m23284e();
            GroupsFeedFragment.m23267h(this.f22139a, true);
        }
    }

    /* compiled from: TimelineContextualInfoAdapter.unknownRenderingStyle */
    class C31883 implements Listener {
        final /* synthetic */ GroupsFeedFragment f22140a;

        C31883(GroupsFeedFragment groupsFeedFragment) {
            this.f22140a = groupsFeedFragment;
        }

        public final void m23242a() {
        }

        public final void m23244b() {
            this.f22140a.bA.notifyDataSetChanged();
        }

        public final boolean m23243a(long j, GraphQLStory graphQLStory) {
            return GroupsFeedFragment.m23263a(this.f22140a, j, graphQLStory);
        }
    }

    /* compiled from: TimelineContextualInfoAdapter.unknownRenderingStyle */
    class C31894 extends GroupCoverPhotoUpdateEventSubscriber {
        final /* synthetic */ GroupsFeedFragment f22141a;

        C31894(GroupsFeedFragment groupsFeedFragment) {
            this.f22141a = groupsFeedFragment;
        }

        public final /* synthetic */ void m23246b(FbEvent fbEvent) {
            m23245a((GroupCoverPhotoUpdateEvent) fbEvent);
        }

        public final void m23245a(GroupCoverPhotoUpdateEvent groupCoverPhotoUpdateEvent) {
            if (this.f22141a.aZ.equals(groupCoverPhotoUpdateEvent.a)) {
                this.f22141a.bt = true;
                if (this.f22141a.z()) {
                    GroupsFeedFragment.aX(this.f22141a);
                }
            }
        }
    }

    /* compiled from: TimelineContextualInfoAdapter.unknownRenderingStyle */
    public class C31905 extends ListViewConnectionListener<GraphQLFeedUnitEdge> {
        final /* synthetic */ GroupsFeedFragment f22142a;

        public final void m23250b(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
            if (connectionLocation.c == LocationType.INITIAL || connectionLocation.c == LocationType.BEFORE) {
                this.f22142a.ao.k.setRefreshing(false);
            }
        }

        public C31905(GroupsFeedFragment groupsFeedFragment) {
            this.f22142a = groupsFeedFragment;
        }

        public final void m23247a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
        }

        public final void m23248a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, Throwable th) {
        }

        public final void m23249a(boolean z) {
            GroupsFeedFragment.aP(this.f22142a);
        }
    }

    /* compiled from: TimelineContextualInfoAdapter.unknownRenderingStyle */
    public class C31916 implements OnClickListener {
        final /* synthetic */ GroupsFeedFragment f22143a;

        public C31916(GroupsFeedFragment groupsFeedFragment) {
            this.f22143a = groupsFeedFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f22143a.aQ.a(this.f22143a.getContext(), "https://www.facebook.com/help/148233965247823#What-are-login-approvals?-How-do-I-turn-this-setting-on");
        }
    }

    /* compiled from: TimelineContextualInfoAdapter.unknownRenderingStyle */
    public class C31927 implements OnClickListener {
        final /* synthetic */ GroupsFeedFragment f22144a;

        public C31927(GroupsFeedFragment groupsFeedFragment) {
            this.f22144a = groupsFeedFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: TimelineContextualInfoAdapter.unknownRenderingStyle */
    public class C31938 {
        public final /* synthetic */ GroupsFeedFragment f22145a;

        public C31938(GroupsFeedFragment groupsFeedFragment) {
            this.f22145a = groupsFeedFragment;
        }
    }

    /* compiled from: TimelineContextualInfoAdapter.unknownRenderingStyle */
    class C31949 implements PagerListener {
        final /* synthetic */ GroupsFeedFragment f22146a;

        C31949(GroupsFeedFragment groupsFeedFragment) {
            this.f22146a = groupsFeedFragment;
        }

        public final void m23251a() {
            GroupsFeedFragment.aP(this.f22146a);
            GroupsFeedFragment.aS(this.f22146a);
        }

        public final void m23253b() {
            this.f22146a.f22149a.a();
            this.f22146a.am.f();
        }

        public final void m23254b(boolean z) {
            this.f22146a.be.a(z);
        }

        public final void m23252a(boolean z) {
            this.f22146a.am.b(z);
        }
    }

    /* compiled from: TimelineContextualInfoAdapter.unknownRenderingStyle */
    class StoryDeleteSubscriber extends StoryDeleteEventSubscriber {
        final /* synthetic */ GroupsFeedFragment f22147a;

        public StoryDeleteSubscriber(GroupsFeedFragment groupsFeedFragment) {
            this.f22147a = groupsFeedFragment;
        }

        public final void m23255b(FbEvent fbEvent) {
            GraphQLStory a = GroupsFeedFragment.m23257a(this.f22147a, (StoryDeleteEvent) fbEvent);
            if (a != null) {
                GroupsFeedFragment.m23259a(this.f22147a, a);
            }
        }
    }

    /* compiled from: TimelineContextualInfoAdapter.unknownRenderingStyle */
    class UnsoldStoryDeleteSubscriber extends StoryDeleteEventSubscriber {
        final /* synthetic */ GroupsFeedFragment f22148a;

        public UnsoldStoryDeleteSubscriber(GroupsFeedFragment groupsFeedFragment) {
            this.f22148a = groupsFeedFragment;
        }

        public final void m23256b(FbEvent fbEvent) {
            GraphQLStory a = GroupsFeedFragment.m23257a(this.f22148a, (StoryDeleteEvent) fbEvent);
            if (a != null && StoryCommerceHelper.d(a)) {
                GroupsFeedFragment.aO(this.f22148a);
            }
        }
    }

    public static void m23262a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((GroupsFeedFragment) obj).m23261a(GroupsSequenceLogger.a(injectorLike), GroupsFeedHeaderFetcher.a(injectorLike), ComposerActivityReceiver.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), OfflinePostLoader.a(injectorLike), GroupsFeedPagerProtocol.a(injectorLike), ComposerPublishServiceHelper.a(injectorLike), GroupsFeedPinStoryController.a(injectorLike), (FetchGroupsStoriesMallIdsMethodProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FetchGroupsStoriesMallIdsMethodProvider.class), (GroupsFeedConsistencySyncProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GroupsFeedConsistencySyncProvider.class), GroupsFeedController.a(injectorLike), (ConnectionControllerBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ConnectionControllerBuilderProvider.class), GroupsListViewController.a(injectorLike), GroupsConnectionConfiguration.a(injectorLike), BridgeConnectionController.a(injectorLike), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), TasksManager.a(injectorLike), InterstitialStartHelper.a(injectorLike), QuickPromotionFragmentFactory.a(injectorLike), InterstitialManager.a(injectorLike), ReactionSessionManager.a(injectorLike), (GroupsPlutoniumHeaderAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GroupsPlutoniumHeaderAdapterProvider.class), FeedEventBus.a(injectorLike), (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(injectorLike), IdBasedProvider.a(injectorLike, 372), Locales.a(injectorLike), GraphQLSubscriptionHolder.a(injectorLike), BaseGroupsMultiRowAdapterFactory.a(injectorLike), FB4AGroupsFeedRootPartDefinitionFactory.m23506a(injectorLike), IdBasedLazy.a(injectorLike, 7002), IdBasedLazy.a(injectorLike, 6987), (GroupsEnvironmentProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GroupsEnvironmentProvider.class), GroupsCoverPhotoHandler.a(injectorLike), GraphSearchConfig.a(injectorLike), Handler_ForUiThreadMethodAutoProvider.a(injectorLike), GroupsInlineComposerActionOptionController.m23344a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 4016), IdBasedProvider.a(injectorLike, 4017), IdBasedProvider.a(injectorLike, 216), FbUriIntentHandler.a(injectorLike), (DialtoneController) DialtoneControllerImpl.a(injectorLike), GroupCoverPhotoUpdateEventBus.a(injectorLike), OptimisticStoryStateCache.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (SearchAwarenessGroupsPillControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchAwarenessGroupsPillControllerProvider.class), GraphSearchIntentLauncher.a(injectorLike), GroupsExperimentalFeatures.a(injectorLike));
    }

    private void m23261a(GroupsSequenceLogger groupsSequenceLogger, GroupsFeedHeaderFetcher groupsFeedHeaderFetcher, ComposerActivityReceiver composerActivityReceiver, FbErrorReporter fbErrorReporter, OfflinePostLoader offlinePostLoader, GroupsFeedPagerProtocol groupsFeedPagerProtocol, ComposerPublishServiceHelper composerPublishServiceHelper, GroupsFeedPinStoryController groupsFeedPinStoryController, FetchGroupsStoriesMallIdsMethodProvider fetchGroupsStoriesMallIdsMethodProvider, GroupsFeedConsistencySyncProvider groupsFeedConsistencySyncProvider, GroupsFeedController groupsFeedController, ConnectionControllerBuilderProvider connectionControllerBuilderProvider, GroupsListViewController groupsListViewController, GroupsConnectionConfiguration groupsConnectionConfiguration, BridgeConnectionController bridgeConnectionController, ComposerLauncher composerLauncher, TasksManager tasksManager, InterstitialStartHelper interstitialStartHelper, QuickPromotionFragmentFactory quickPromotionFragmentFactory, InterstitialManager interstitialManager, ReactionSessionManager reactionSessionManager, GroupsPlutoniumHeaderAdapterProvider groupsPlutoniumHeaderAdapterProvider, FeedEventBus feedEventBus, FbTitleBarSupplier fbTitleBarSupplier, Provider<ViewerContext> provider, Locales locales, GraphQLSubscriptionHolder graphQLSubscriptionHolder, BaseGroupsMultiRowAdapterFactory baseGroupsMultiRowAdapterFactory, FB4AGroupsFeedRootPartDefinitionFactory fB4AGroupsFeedRootPartDefinitionFactory, Lazy<GroupsGraphQLStorySelectorPartDefinition> lazy, Lazy<HidePinnedStoryPartDefinition> lazy2, GroupsEnvironmentProvider groupsEnvironmentProvider, GroupsCoverPhotoHandler groupsCoverPhotoHandler, GraphSearchConfig graphSearchConfig, Handler handler, GroupsInlineComposerActionOptionController groupsInlineComposerActionOptionController, SecureContextHelper secureContextHelper, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<GraphPostService> provider4, FbUriIntentHandler fbUriIntentHandler, DialtoneController dialtoneController, GroupCoverPhotoUpdateEventBus groupCoverPhotoUpdateEventBus, OptimisticStoryStateCache optimisticStoryStateCache, QeAccessor qeAccessor, SearchAwarenessGroupsPillControllerProvider searchAwarenessGroupsPillControllerProvider, GraphSearchIntentLauncher graphSearchIntentLauncher, GroupsExperimentalFeatures groupsExperimentalFeatures) {
        this.f22149a = groupsSequenceLogger;
        this.f22150b = groupsFeedHeaderFetcher;
        this.f22151c = composerActivityReceiver;
        this.f22152d = fbErrorReporter;
        this.f22153e = offlinePostLoader;
        this.f22154f = groupsFeedPagerProtocol;
        this.f22155g = composerPublishServiceHelper;
        this.f22156h = groupsFeedPinStoryController;
        this.f22157i = fetchGroupsStoriesMallIdsMethodProvider;
        this.al = groupsFeedConsistencySyncProvider;
        this.am = groupsFeedController;
        this.an = connectionControllerBuilderProvider;
        this.ao = groupsListViewController;
        this.ap = groupsConnectionConfiguration;
        this.aq = bridgeConnectionController;
        this.ar = composerLauncher;
        this.as = tasksManager;
        this.at = interstitialStartHelper;
        this.au = quickPromotionFragmentFactory;
        this.av = interstitialManager;
        this.aw = reactionSessionManager;
        this.ax = groupsPlutoniumHeaderAdapterProvider;
        this.ay = feedEventBus;
        this.az = fbTitleBarSupplier;
        this.aA = provider;
        this.aB = locales;
        this.aC = graphQLSubscriptionHolder;
        this.aD = baseGroupsMultiRowAdapterFactory;
        this.aE = fB4AGroupsFeedRootPartDefinitionFactory;
        this.aF = lazy;
        this.aG = lazy2;
        this.aH = groupsEnvironmentProvider;
        this.aI = groupsCoverPhotoHandler;
        this.aJ = graphSearchConfig;
        this.aK = handler;
        this.aL = groupsInlineComposerActionOptionController;
        this.aM = secureContextHelper;
        this.aN = provider2;
        this.aO = provider3;
        this.aP = provider4;
        this.aQ = fbUriIntentHandler;
        this.aR = dialtoneController;
        this.aS = groupCoverPhotoUpdateEventBus;
        this.aT = optimisticStoryStateCache;
        this.aU = qeAccessor;
        this.aV = searchAwarenessGroupsPillControllerProvider;
        this.aW = graphSearchIntentLauncher;
        this.aX = groupsExperimentalFeatures;
    }

    public final void iw_() {
    }

    public final void b_(boolean z) {
        if (!z) {
            this.bA.notifyDataSetChanged();
        }
    }

    public static GraphQLStory m23257a(GroupsFeedFragment groupsFeedFragment, StoryDeleteEvent storyDeleteEvent) {
        if (groupsFeedFragment.av()) {
            return null;
        }
        FeedUnitCollection g = ((BridgeConnectionController) groupsFeedFragment.bw).g();
        if (g == null) {
            return null;
        }
        String a = storyDeleteEvent.a();
        String b = storyDeleteEvent.b();
        if (a == null && b != null) {
            return g.b(b);
        }
        if (a != null) {
            for (GraphQLFeedUnitEdge c : g.a(a)) {
                FeedUnit c2 = c.c();
                if (c2 instanceof GraphQLStory) {
                    return (GraphQLStory) c2;
                }
            }
        }
        return null;
    }

    public final void m23282c(@Nullable Bundle bundle) {
        long uptimeMillis = SystemClock.uptimeMillis();
        Class cls = GroupsFeedFragment.class;
        m23262a((Object) this, getContext());
        this.f22149a.a(uptimeMillis);
        this.bB = true;
        this.ar.a(1756, ao());
        this.aR.a(this);
        this.br = getContext();
        this.aZ = (String) this.s.get("group_feed_id");
        this.ba = (String) this.s.get("group_feed_title");
        this.bb = this.s.getStringArrayList("group_feed_hoisted_story_ids");
        this.bd = new FeedType(new GroupsFeedTypeValueParams(this.aZ, GroupsFeedTypes.GroupsFeed, this.bb), Name.o);
        this.bi = new C31872(this);
        this.bk = new C31883(this);
        au();
        aw();
        this.bm = new UnsoldStoryDeleteSubscriber(this);
        this.ay.a(this.bm);
        this.bn = new StoryDeleteSubscriber(this);
        this.ay.a(this.bn);
        this.bu = new C31894(this);
        this.aS.a(this.bu);
        super.c(bundle);
    }

    public final void m23285e(Bundle bundle) {
        super.e(bundle);
        bundle.putBoolean("update_cover_photo_key", this.bt);
    }

    public final ContentFragmentType m23283d() {
        return ContentFragmentType.GROUP_ALBUM_FRAGMENT;
    }

    private void au() {
        this.f22154f.a(this.bd, 10, 3);
        if (av()) {
            GroupsConnectionConfiguration groupsConnectionConfiguration = this.ap;
            FeedType feedType = this.bd;
            groupsConnectionConfiguration.b = feedType;
            groupsConnectionConfiguration.c = new FeedFetchContext(((GroupsFeedTypeValueParams) feedType.f).a, null);
        }
    }

    private boolean av() {
        return this.aU.a(ExperimentsForGroupsFeedUiModule.f22013c, false);
    }

    private void aw() {
        if (av()) {
            MutationControllerManager mutationControllerManager = new MutationControllerManager(ImmutableList.of(new LegacyFeedUnitStoreUpdater()));
            ConnectionControllerBuilder a = this.an.a("/group/" + this.aZ, this.ap);
            a.f = ConnectionCachePolicy.MEMORY_DISK;
            a = a;
            a.i = true;
            a = a;
            a.j = mutationControllerManager;
            this.bw = a.a();
        } else {
            BridgeConnectionController bridgeConnectionController = this.aq;
            bridgeConnectionController.b.a(bridgeConnectionController);
            this.bw = this.aq;
        }
        this.bv = new C31905(this);
        this.bw.a(this.bv);
    }

    private void az() {
        if (!aD()) {
            Intent intent;
            QuickPromotionFragment quickPromotionFragment = null;
            QuickPromotionFooterController quickPromotionFooterController = (QuickPromotionFooterController) this.av.a(QuickPromotionFooterController.b, QuickPromotionFooterController.class);
            if (quickPromotionFooterController == null) {
                intent = null;
            } else {
                intent = quickPromotionFooterController.a(getContext());
            }
            Intent intent2 = intent;
            if (intent2 == null || this.bg == null || !this.bg.b(intent2)) {
                if (intent2 != null) {
                    quickPromotionFragment = this.au.a(intent2);
                }
                if (quickPromotionFragment instanceof QuickPromotionFooterFragment) {
                    this.bg = (QuickPromotionFooterFragment) quickPromotionFragment;
                    s().a().b(2131562763, this.bg).b();
                    this.bf.setVisibility(0);
                    return;
                }
                aC();
                return;
            }
            this.bg.ay();
        }
    }

    private boolean aA() {
        boolean z;
        if (this.bz != null) {
            DraculaReturnValue b = this.bz.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, i, null, 0);
        } else {
            z = false;
        }
        if (z && ((Boolean) this.aO.get()).booleanValue() && !this.bs && !GroupCommerceComposerHelper.a(GroupInformationInterfaceFactory.a(this.bz))) {
            FetchGroupInformationModel fetchGroupInformationModel = this.bz;
            Object obj = (fetchGroupInformationModel == null || fetchGroupInformationModel.v() == null || !"for_sale".equalsIgnoreCase(fetchGroupInformationModel.v().a())) ? null : 1;
            if (obj != null && GraphQLGroupAdminType.ADMIN == this.bz.n()) {
                return true;
            }
        }
        return false;
    }

    private void aC() {
        if (this.bg != null) {
            s().a().a(this.bg).b();
            this.bg = null;
        }
        this.bf.setVisibility(8);
    }

    public final void c_(boolean z) {
        if (z) {
            aC();
        }
    }

    private boolean aD() {
        QuickPromotionInterstitialController quickPromotionInterstitialController = (QuickPromotionInterstitialController) this.av.a(new InterstitialTrigger(Action.GROUP_MALL_VIEW), QuickPromotionInterstitialController.class);
        if (quickPromotionInterstitialController == null) {
            return false;
        }
        Intent a = quickPromotionInterstitialController.a(getContext());
        if (a == null) {
            return false;
        }
        this.av.a().a(quickPromotionInterstitialController.b());
        this.aM.a(a, getContext());
        return true;
    }

    public final View m23272a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -874550831);
        if (bundle != null) {
            this.bt = bundle.getBoolean("update_cover_photo_key");
        }
        this.bj = (ViewGroup) layoutInflater.inflate(2130904711, viewGroup, false);
        this.bf = FindViewUtil.b(this.bj, 2131562763);
        aI();
        aM();
        aJ();
        aG();
        m23267h(this, false);
        View view = this.bj;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 394984424, a);
        return view;
    }

    private void aG() {
        String str = this.aZ;
        String str2 = this.ba;
        Builder builder = new Builder();
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(1024);
        int a = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int a2 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int b = flatBufferBuilder.b(null);
        int a3 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int a4 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int a5 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int a6 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int a7 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int a8 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int b2 = flatBufferBuilder.b(str);
        int b3 = flatBufferBuilder.b(str2);
        int a9 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int b4 = flatBufferBuilder.b(null);
        int e = flatBufferBuilder.e(null);
        int a10 = flatBufferBuilder.a(null);
        int a11 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        flatBufferBuilder.c(19);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, a4);
        flatBufferBuilder.a(5, 0, 0);
        flatBufferBuilder.b(6, a5);
        flatBufferBuilder.b(7, a6);
        flatBufferBuilder.b(8, a7);
        flatBufferBuilder.b(9, a8);
        flatBufferBuilder.a(10, false);
        flatBufferBuilder.b(11, b2);
        flatBufferBuilder.a(12, false);
        flatBufferBuilder.b(13, b3);
        flatBufferBuilder.b(14, a9);
        flatBufferBuilder.b(15, b4);
        flatBufferBuilder.b(16, e);
        flatBufferBuilder.b(17, a10);
        flatBufferBuilder.b(18, a11);
        DraculaReturnValue a12 = DraculaReturnValue.a(flatBufferBuilder, 291056794);
        builder.a(a12.a, a12.b, a12.c);
        builder.a(this.aZ);
        m23260a(this, builder.a());
    }

    private void aH() {
        LegacyFeedUnitStoreUpdater legacyFeedUnitStoreUpdater;
        GroupsListViewController groupsListViewController = this.ao;
        View view = this.bj;
        ConnectionController connectionController = this.bw;
        groupsListViewController.h = view;
        groupsListViewController.i = this;
        groupsListViewController.j = connectionController;
        groupsListViewController.k = (FbSwipeRefreshLayout) groupsListViewController.h.findViewById(2131561342);
        groupsListViewController.k.e = new 1(groupsListViewController);
        BetterListView betterListView = (BetterListView) groupsListViewController.h.findViewById(2131558776);
        groupsListViewController.l = new ListViewProxy(betterListView);
        groupsListViewController.l.b(0);
        groupsListViewController.l.k();
        groupsListViewController.l.b(false);
        groupsListViewController.l.d(true);
        groupsListViewController.l.f(view.findViewById(16908292));
        groupsListViewController.l.b(new 2(groupsListViewController));
        3 3 = new 3(groupsListViewController);
        FbBaseAdapter l = groupsListViewController.i.l();
        groupsListViewController.m = groupsListViewController.i.a(3, groupsListViewController.i.a(betterListView));
        if (l != null) {
            groupsListViewController.l.a(new MergingStickyHeaderAdapter(l, (BaseAdapter) groupsListViewController.m));
        } else {
            groupsListViewController.l.a(groupsListViewController.m);
        }
        groupsListViewController.l.a(groupsListViewController.a.a());
        groupsListViewController.j.a(3, Boolean.FALSE);
        Preconditions.checkNotNull(groupsListViewController.j.e());
        MutationControllerManager e = groupsListViewController.j.e();
        Class cls = LegacyFeedUnitStoreUpdater.class;
        int size = e.a.size();
        for (int i = 0; i < size; i++) {
            legacyFeedUnitStoreUpdater = (LegacyFeedUnitStoreUpdater) e.a.get(i);
            if (cls.isInstance(legacyFeedUnitStoreUpdater)) {
                break;
            }
        }
        legacyFeedUnitStoreUpdater = null;
        LegacyFeedUnitUpdater legacyFeedUnitUpdater = (LegacyFeedUnitUpdater) legacyFeedUnitStoreUpdater;
        groupsListViewController.d.a(legacyFeedUnitUpdater, null);
        groupsListViewController.e.a(legacyFeedUnitUpdater, null);
        groupsListViewController.c.a(legacyFeedUnitUpdater, null);
        groupsListViewController.b.a(legacyFeedUnitUpdater, null);
        groupsListViewController.f.a(legacyFeedUnitUpdater, null);
        groupsListViewController.g.a(legacyFeedUnitUpdater, null);
        if (this.az.get() != null && !this.bh) {
            aU();
        }
    }

    private void aI() {
        if (av()) {
            aH();
            return;
        }
        BridgeConnectionController bridgeConnectionController = (BridgeConnectionController) this.bw;
        bridgeConnectionController.a.a();
        bridgeConnectionController.a.a(this.f22154f, new C31949(this), 1000, 5, this.f22149a);
        FeedUnitCollection feedUnitCollection = bridgeConnectionController.a.c;
        GroupsFeedController groupsFeedController = this.am;
        View view = this.bj;
        GroupsFeedPager groupsFeedPager = bridgeConnectionController.a;
        AnonymousClass10 anonymousClass10 = new OnDrawListener(this) {
            final /* synthetic */ GroupsFeedFragment f22125a;

            {
                this.f22125a = r1;
            }

            public final boolean gD_() {
                return this.f22125a.f22149a.m().booleanValue();
            }
        };
        GroupsFeedListType groupsFeedListType = GroupsFeedListType.a;
        groupsFeedController.a(view, groupsFeedPager, feedUnitCollection, this, this, false, anonymousClass10);
        if (!(this.az.get() == null || this.bh)) {
            aU();
        }
        this.f22156h.a(feedUnitCollection.a, this.bi, PinState.Pin);
        this.f22151c.a(new ComposerActivityReceiver.Listener(this) {
            final /* synthetic */ GroupsFeedFragment f22132a;

            {
                this.f22132a = r1;
            }

            public final boolean m23235a(long j, GraphQLStory graphQLStory) {
                return GroupsFeedFragment.m23263a(this.f22132a, j, graphQLStory);
            }

            public final void m23234a(GraphQLStory graphQLStory) {
                this.f22132a.nt_();
                if (StoryCommerceHelper.b(graphQLStory)) {
                    GroupsFeedFragment.aN(this.f22132a);
                }
            }

            public final void m23237b(GraphQLStory graphQLStory) {
                if (GroupsFeedFragment.aT(this.f22132a)) {
                    this.f22132a.ay.a(new StoryDeleteEvent(FeedProps.c(graphQLStory)));
                } else {
                    this.f22132a.nt_();
                }
                if (this.f22132a.aT.a(graphQLStory) == GraphQLFeedOptimisticPublishState.SUCCESS) {
                    GroupsFeedFragment groupsFeedFragment = this.f22132a;
                    if (GroupsFeedFragment.aT(groupsFeedFragment) && !GraphQLHelper.l(graphQLStory)) {
                        FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(groupsFeedFragment.getContext());
                        fbAlertDialogBuilder.a(2131237988);
                        fbAlertDialogBuilder.b(2131237987);
                        fbAlertDialogBuilder.a(2131237986, null);
                        fbAlertDialogBuilder.a().show();
                    }
                    if (GroupsFeedFragment.aT(groupsFeedFragment)) {
                        GroupsFeedFragment.m23267h(groupsFeedFragment, true);
                    }
                }
            }

            public final void m23233a() {
                this.f22132a.nt_();
                this.f22132a.f22152d.a("groups_optimistic_post_failed", "Failed to post to profile " + this.f22132a.aZ);
            }

            public final void m23236b() {
                this.f22132a.m23284e();
            }
        }, feedUnitCollection.d);
        this.f22153e.a(this.bk, feedUnitCollection.d);
    }

    private void aJ() {
        if (aL()) {
            LazyView lazyView = this.aU.a(ExperimentsForSearchAbTestModule.aq, false) ? new LazyView((ViewStub) this.bj.findViewById(2131567257)) : new LazyView((ViewStub) this.bj.findViewById(2131567258));
            SearchAwarenessGroupsPillControllerProvider searchAwarenessGroupsPillControllerProvider = this.aV;
            this.bx = new SearchAwarenessGroupsPillController(lazyView, this.am, this.bj.getContext(), new Object(this) {
                public final /* synthetic */ GroupsFeedFragment f22126a;

                {
                    this.f22126a = r1;
                }
            }, SearchAwarenessLogger.b(searchAwarenessGroupsPillControllerProvider), (QeAccessor) QeInternalImplMethodAutoProvider.a(searchAwarenessGroupsPillControllerProvider), SpringSystem.b(searchAwarenessGroupsPillControllerProvider), ViewHelperViewAnimatorFactory.a(searchAwarenessGroupsPillControllerProvider));
            this.by = new OnScrollListener(this) {
                final /* synthetic */ GroupsFeedFragment f22127a;

                {
                    this.f22127a = r1;
                }

                public final void m23229a(ScrollingViewProxy scrollingViewProxy, int i) {
                }

                public final void m23230a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
                    this.f22127a.bx.m23104a(i);
                }
            };
            m23290n().b(this.by);
        }
    }

    private void aK() {
        if (aL()) {
            this.bx.m23107h();
        }
    }

    private boolean aL() {
        return this.aU.a(ExperimentsForSearchAbTestModule.ap, false) && !av();
    }

    public final ScrollingViewProxy m23290n() {
        if (av()) {
            return this.ao.l;
        }
        return this.am.A;
    }

    private void aM() {
        if (!av()) {
            FeedUnitCollection g = ((BridgeConnectionController) this.bw).g();
            this.be = this.al.a(this.bd, new FetchGroupsStoriesMallIdsMethod(this.bd, DbFeedHomeStoriesHandler.a(this.f22157i)), g, this.bi);
        }
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1365969327);
        super.mi_();
        aQ();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -156351335, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1518316472);
        super.mj_();
        if (this.bo != null) {
            HandlerDetour.a(this.aK, this.bo);
        }
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.a(null);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -954190083, a);
    }

    public final void m23275a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        this.am.b(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 301:
                    final Uri uri = ((EditGalleryIpcBundle) intent.getParcelableExtra(EditGalleryIpcBundle.a)).b;
                    this.aI.a(this.aZ, uri, new FutureCallback<String>(this) {
                        final /* synthetic */ GroupsFeedFragment f22129b;

                        public void onSuccess(Object obj) {
                            this.f22129b.m23284e();
                            GroupsFeedFragment.m23267h(this.f22129b, true);
                            File file = new File(uri.getPath());
                            if (file.exists()) {
                                file.delete();
                            }
                        }

                        public void onFailure(Throwable th) {
                        }
                    });
                    return;
                case 1756:
                    if (intent.getBooleanExtra("extra_is_composer_intercept_sell", false)) {
                        m23264b(intent);
                        return;
                    }
                    this.f22155g.c(intent);
                    if (this.bq != null) {
                        HoistedStoriesCollectionWrapper hoistedStoriesCollectionWrapper = this.bq;
                        if (null != null || hoistedStoriesCollectionWrapper.c == null) {
                            hoistedStoriesCollectionWrapper.c = null;
                        } else {
                            hoistedStoriesCollectionWrapper.c.clear();
                        }
                        hoistedStoriesCollectionWrapper.b();
                        this.bb.clear();
                    }
                    this.bA.notifyDataSetChanged();
                    this.aw.a(((PublishPostParams) intent.getParcelableExtra("publishPostParams")).composerSessionId);
                    return;
                case 1991:
                    GraphQLAlbum graphQLAlbum = (GraphQLAlbum) FlatBufferModelHelper.a(intent, "extra_album");
                    DraculaReturnValue b = this.bz.b();
                    MutableFlatBuffer mutableFlatBuffer = b.a;
                    int i3 = b.b;
                    int i4 = b.c;
                    String u = graphQLAlbum.u();
                    String gW_ = this.bz.gW_();
                    String k = mutableFlatBuffer.k(i3, 13);
                    Context context = getContext();
                    GroupsInlineComposerActionOptionController.f22232a.a(GroupsInlineComposerActionOptionController.f22236e.m24255b(u, gW_, k), context);
                    return;
                default:
                    return;
            }
        }
    }

    public final void m23270H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 379267440);
        super.H();
        if (this.bo != null) {
            HandlerDetour.a(this.aK, this.bo);
        }
        this.bB = false;
        this.f22149a.a();
        this.aC.d();
        aK();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1117064346, a);
    }

    public final void m23271I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 666573506);
        super.I();
        if (this.bo != null) {
            HandlerDetour.a(this.aK, this.bo);
        }
        this.ay.b(this.bm);
        this.ay.b(this.bn);
        this.aS.b(this.bu);
        this.aR.b(this);
        this.aC.a();
        this.bw.b(this.bv);
        BridgeConnectionController bridgeConnectionController = this.aq;
        bridgeConnectionController.b.b(bridgeConnectionController);
        if (aL()) {
            m23290n().c(this.by);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -383921233, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -512846660);
        super.mY_();
        this.f22156h.a();
        this.f22151c.b();
        this.bA.jc_();
        if (this.be != null) {
            this.be.a();
        }
        this.bw.b();
        this.as.c();
        if (this.bc != null) {
            GroupsPlutoniumHeaderAdapter groupsPlutoniumHeaderAdapter = this.bc;
            if (groupsPlutoniumHeaderAdapter.f22362j != null) {
                groupsPlutoniumHeaderAdapter.f22362j.mo988a();
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -437587215, a);
    }

    public final boolean m23279a(FbNetworkManager fbNetworkManager, GenericNotificationBanner genericNotificationBanner) {
        int i = 0;
        if (this.am.e() != null) {
            if (fbNetworkManager.d()) {
                genericNotificationBanner.a();
            } else {
                boolean z;
                NotificationBannerType notificationBannerType;
                if (this.bz != null) {
                    DraculaReturnValue b = this.bz.b();
                    MutableFlatBuffer mutableFlatBuffer = b.a;
                    int i2 = b.b;
                    int i3 = b.c;
                    z = !DraculaRuntime.a(mutableFlatBuffer, i2, null, 0);
                } else {
                    z = false;
                }
                if (z && (this.bz.q() == GraphQLGroupPostStatus.CAN_POST_AFTER_APPROVAL || this.bz.q() == GraphQLGroupPostStatus.CAN_POST_WITHOUT_APPROVAL)) {
                    i = 1;
                }
                if (i != 0) {
                    notificationBannerType = NotificationBannerType.YOU_CAN_STILL_POST;
                } else {
                    notificationBannerType = NotificationBannerType.NO_CONNECTION;
                }
                genericNotificationBanner.a(notificationBannerType);
            }
        }
        return true;
    }

    public final void nt_() {
        aP(this);
    }

    public final void m23293r() {
        if (this.bq != null) {
            this.bq.b();
        }
    }

    public static void aN(GroupsFeedFragment groupsFeedFragment) {
        groupsFeedFragment.m23265g(1);
    }

    public static void aO(GroupsFeedFragment groupsFeedFragment) {
        groupsFeedFragment.m23265g(-1);
    }

    private void m23265g(int i) {
        boolean z;
        if (this.bz == null) {
            z = true;
        } else {
            DraculaReturnValue b = this.bz.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i2 = b.b;
            int i3 = b.c;
            z = DraculaRuntime.a(mutableFlatBuffer, i2, null, 0);
        }
        if (z) {
            z = true;
        } else {
            b = this.bz.b();
            mutableFlatBuffer = b.a;
            i2 = b.b;
            i3 = b.c;
            z = DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(i2, 6), null, 0);
        }
        if (!z) {
            b = this.bz.b();
            mutableFlatBuffer = b.a;
            i2 = b.b;
            i3 = b.c;
            int j = mutableFlatBuffer.j(mutableFlatBuffer.g(i2, 6), 0);
            b = this.bz.b();
            MutableFlatBuffer mutableFlatBuffer2 = b.a;
            int i4 = b.b;
            i3 = b.c;
            i2 = mutableFlatBuffer2.j(mutableFlatBuffer2.g(i4, 6), 1);
            b = this.bz.b();
            MutableFlatBuffer mutableFlatBuffer3 = b.a;
            int i5 = b.b;
            i3 = b.c;
            i3 = mutableFlatBuffer3.g(i5, 6);
            mutableFlatBuffer3.j(i3, 0);
            i3 = mutableFlatBuffer3.j(i3, 1);
            j += i;
            if (i2 != -1) {
                i3 = i2 + i;
            }
            DraculaReturnValue b2 = this.bz.b();
            mutableFlatBuffer3 = b2.a;
            i5 = b2.b;
            i2 = b2.c;
            i5 = mutableFlatBuffer3.g(i5, 1);
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(1024);
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, j, 0);
            flatBufferBuilder.a(1, i3, 0);
            b = DraculaReturnValue.a(flatBufferBuilder, -2017261931);
            m23258a(b.a, b.b, b.c, mutableFlatBuffer3, i5, -694926303);
        }
    }

    private void m23258a(@Nullable MutableFlatBuffer mutableFlatBuffer, @Nullable int i, @Nullable int i2, @Nullable MutableFlatBuffer mutableFlatBuffer2, @Nullable int i3, @Nullable int i4) {
        String str = this.aZ;
        String str2 = this.ba;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(1024);
        int a = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int a2 = DraculaImplementation.a(mutableFlatBuffer2, i3, i4, flatBufferBuilder);
        int b = flatBufferBuilder.b(null);
        int a3 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int a4 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int a5 = DraculaImplementation.a(mutableFlatBuffer, i, i2, flatBufferBuilder);
        int a6 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int a7 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int a8 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int b2 = flatBufferBuilder.b(str);
        int b3 = flatBufferBuilder.b(str2);
        int a9 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int b4 = flatBufferBuilder.b(null);
        int e = flatBufferBuilder.e(null);
        int a10 = flatBufferBuilder.a(null);
        int a11 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        flatBufferBuilder.c(19);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, a4);
        flatBufferBuilder.a(5, 0, 0);
        flatBufferBuilder.b(6, a5);
        flatBufferBuilder.b(7, a6);
        flatBufferBuilder.b(8, a7);
        flatBufferBuilder.b(9, a8);
        flatBufferBuilder.a(10, false);
        flatBufferBuilder.b(11, b2);
        flatBufferBuilder.a(12, false);
        flatBufferBuilder.b(13, b3);
        flatBufferBuilder.b(14, a9);
        flatBufferBuilder.b(15, b4);
        flatBufferBuilder.b(16, e);
        flatBufferBuilder.b(17, a10);
        flatBufferBuilder.b(18, a11);
        DraculaReturnValue a12 = DraculaReturnValue.a(flatBufferBuilder, 291056794);
        m23260a(this, Builder.a(this.bz).a(a12.a, a12.b, a12.c).a());
    }

    public static void m23259a(GroupsFeedFragment groupsFeedFragment, GraphQLStory graphQLStory) {
        boolean z;
        if (groupsFeedFragment.bz == null) {
            z = true;
        } else {
            DraculaReturnValue b = groupsFeedFragment.bz.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            z = DraculaRuntime.a(mutableFlatBuffer, i, null, 0);
        }
        if (!z) {
            boolean z2;
            b = groupsFeedFragment.bz.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            i2 = mutableFlatBuffer.g(i, 1);
            if (graphQLStory == null || DraculaRuntime.a(mutableFlatBuffer, i2, null, 0)) {
                z2 = true;
            } else {
                z2 = DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(i2, 0), null, 0);
            }
            int i3 = z2 ? 1 : mutableFlatBuffer.k(mutableFlatBuffer.g(i2, 0), 1) == null ? 1 : 0;
            if (i3 != 0) {
                i3 = 0;
            } else {
                String k = mutableFlatBuffer.k(mutableFlatBuffer.g(i2, 0), 1);
                for (GraphQLStoryAttachment graphQLStoryAttachment : graphQLStory.x()) {
                    if (graphQLStoryAttachment.r() != null && k.equals(graphQLStoryAttachment.r().b())) {
                        i3 = 1;
                        break;
                    }
                }
                i3 = 0;
            }
            if (i3 != 0) {
                b = groupsFeedFragment.bz.b();
                MutableFlatBuffer mutableFlatBuffer2 = b.a;
                int i4 = b.b;
                i2 = b.c;
                groupsFeedFragment.m23258a(mutableFlatBuffer2, mutableFlatBuffer2.g(i4, 6), -2017261931, null, 0, 0);
            }
        }
    }

    public final void m23286f() {
        if (this.T != null) {
            m23267h(this, true);
        }
    }

    public static void aP(GroupsFeedFragment groupsFeedFragment) {
        if (groupsFeedFragment.av()) {
            groupsFeedFragment.ao.m.notifyDataSetChanged();
            return;
        }
        groupsFeedFragment.m23293r();
        groupsFeedFragment.am.h();
    }

    public final void m23278a(boolean z, boolean z2) {
        boolean z3;
        boolean z4 = true;
        if (this.br != null) {
            boolean z5;
            if (z2) {
                Context context = this.br;
                int i = 0;
                if (VERSION.SDK_INT >= 17) {
                    int i2 = 0;
                    if (Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0) {
                        i2 = 1;
                    }
                    i = i2;
                } else if (System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0) {
                    i = 1;
                }
                if (i == 0) {
                    z5 = true;
                    z3 = z5;
                }
            }
            z5 = false;
            z3 = z5;
        } else {
            z3 = z2;
        }
        GroupsPlutoniumHeaderAdapter groupsPlutoniumHeaderAdapter = this.bc;
        FetchGroupInformationModel fetchGroupInformationModel = this.bz;
        if (aV()) {
            z4 = false;
        }
        groupsPlutoniumHeaderAdapter.m23433a(fetchGroupInformationModel, z4, z, z3, false);
    }

    public final void m23280b(boolean z) {
        m23267h(this, z);
    }

    public final FeedEnvironment m23273a(BetterListView betterListView) {
        return this.aH.m23223a(MenuType.NORMAL, getContext(), GroupsFeedListType.a, new Runnable(this) {
            final /* synthetic */ GroupsFeedFragment f22130a;

            {
                this.f22130a = r1;
            }

            public void run() {
                this.f22130a.bA.notifyDataSetChanged();
            }
        }, HasScrollListenerSupportImpl.a(betterListView), this.bw.e());
    }

    public final MultiRowAdapter m23274a(ListItemCollection<FeedEdge> listItemCollection, FeedEnvironment feedEnvironment) {
        ListItemCollection listItemCollection2;
        if (this.bb == null || this.bb.isEmpty() || this.aX.a()) {
            this.bq = null;
            ListItemCollection<FeedEdge> listItemCollection3 = listItemCollection;
        } else {
            this.bq = new HoistedStoriesCollectionWrapper(listItemCollection, this.bb);
            listItemCollection2 = this.bq;
        }
        this.bA = this.aD.a(listItemCollection2, this.aE.m23508a(this.aF, this.aG), feedEnvironment, this.bw, av());
        return this.bA;
    }

    @Nullable
    public final FbBaseAdapter m23288l() {
        GroupsPlutoniumHeaderAdapterProvider groupsPlutoniumHeaderAdapterProvider = this.ax;
        this.bc = new GroupsPlutoniumHeaderAdapter(IdBasedSingletonScopeProvider.b(groupsPlutoniumHeaderAdapterProvider, 494), IdBasedSingletonScopeProvider.b(groupsPlutoniumHeaderAdapterProvider, 968), IdBasedSingletonScopeProvider.b(groupsPlutoniumHeaderAdapterProvider, 7045), new Object(this) {
            final /* synthetic */ GroupsFeedFragment f22131a;

            {
                this.f22131a = r1;
            }

            public final void m23232a(boolean z) {
                GroupsFeedFragment.m23267h(this.f22131a, true);
                if (!z) {
                    this.f22131a.m23284e();
                }
            }

            public final void m23231a(FetchGroupInformationModel fetchGroupInformationModel, FetchGroupInformationModel fetchGroupInformationModel2) {
                if (this.f22131a.o() != null && fetchGroupInformationModel == this.f22131a.bz) {
                    Object obj = (fetchGroupInformationModel2.p().equals(GraphQLGroupJoinState.CAN_JOIN) || fetchGroupInformationModel2.p().equals(GraphQLGroupJoinState.CAN_REQUEST)) ? 1 : null;
                    if (fetchGroupInformationModel.p().equals(GraphQLGroupJoinState.MEMBER) && obj != null) {
                        this.f22131a.o().onBackPressed();
                    } else if (obj == null || fetchGroupInformationModel.x() == null || fetchGroupInformationModel2.x() != null) {
                        GroupsFeedFragment.m23260a(this.f22131a, fetchGroupInformationModel2);
                    } else {
                        this.f22131a.o().onBackPressed();
                    }
                }
            }
        }, (QeAccessor) QeInternalImplMethodAutoProvider.a(groupsPlutoniumHeaderAdapterProvider), new GroupsContextItemsHelper(IdBasedProvider.a(groupsPlutoniumHeaderAdapterProvider, 6994), ViewerStatusCache.a(groupsPlutoniumHeaderAdapterProvider)), GroupsFeedMegaphoneControllerProvider.m23302b(groupsPlutoniumHeaderAdapterProvider), InterstitialManager.a(groupsPlutoniumHeaderAdapterProvider), (Context) groupsPlutoniumHeaderAdapterProvider.getInstance(Context.class));
        return this.bc;
    }

    @Nullable
    public final FbBaseAdapter m23289m() {
        return null;
    }

    private void m23264b(Intent intent) {
        ComposerConfiguration a = GroupCommerceComposerHelper.a(GroupInformationInterfaceFactory.a(this.bz), this.aB).a();
        String stringExtra = intent.getStringExtra("extra_is_composer_intercept_status");
        List a2 = GroupCommerceSellComposerIntercept.a(Currency.getInstance(a.getCommerceInfo().getCurrencyCode()).getSymbol(this.aB.a()), stringExtra);
        ProductItemAttachment.Builder builder = new ProductItemAttachment.Builder();
        builder.d = stringExtra;
        ProductItemAttachment.Builder builder2 = builder;
        builder2.f = a.getCommerceInfo().getCurrencyCode();
        builder = builder2;
        if (a2.size() == 1) {
            builder.e = Long.valueOf(Long.parseLong((String) a2.get(0)));
        }
        this.ar.a(null, ComposerConfiguration.a(a).setInitialAttachments(ImmutableList.copyOf(intent.getParcelableArrayListExtra("extra_is_composer_intercept_attachments"))).setProductItemAttachment(builder.a()).a(), 1756, (Activity) getContext());
    }

    public static boolean m23263a(GroupsFeedFragment groupsFeedFragment, long j, GraphQLStory graphQLStory) {
        return String.valueOf(j).equals(groupsFeedFragment.aZ) || (OptimisticPostStoryBuilder.a(graphQLStory) && OptimisticPostStoryBuilder.b(graphQLStory) != null && OptimisticPostStoryBuilder.b(graphQLStory).equals(groupsFeedFragment.aZ));
    }

    public static void m23260a(GroupsFeedFragment groupsFeedFragment, FetchGroupInformationModel fetchGroupInformationModel) {
        boolean z;
        boolean z2;
        if (fetchGroupInformationModel == null) {
            groupsFeedFragment.f22152d.a(aY, "Update group header with null value. Looks wrong.");
        }
        if (groupsFeedFragment.bz == null) {
            z = true;
        } else {
            DraculaReturnValue b = groupsFeedFragment.bz.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            z = DraculaRuntime.a(mutableFlatBuffer, i, null, 0);
        }
        z = z;
        groupsFeedFragment.bz = fetchGroupInformationModel;
        if (!z || groupsFeedFragment.bz == null) {
            z = false;
        } else {
            b = groupsFeedFragment.bz.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            if (DraculaRuntime.a(mutableFlatBuffer, i, null, 0)) {
                z = false;
            } else {
                z = true;
            }
        }
        if (z && groupsFeedFragment.bz.p() == GraphQLGroupJoinState.MEMBER) {
            ImmutableList copyOf;
            b = groupsFeedFragment.bz.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            RandomAccessList g = mutableFlatBuffer.g(i, 16, GraphQLGroupContentRestrictionReason.class);
            if (g != null) {
                copyOf = ImmutableList.copyOf(g);
            } else {
                copyOf = RegularImmutableList.a;
            }
            z = copyOf.contains(GraphQLGroupContentRestrictionReason.LOGIN_APPROVALS_REQUIRED);
        } else {
            z = false;
        }
        if (z) {
            AlertDialog.Builder builder = new AlertDialog.Builder(groupsFeedFragment.getContext());
            builder.a(groupsFeedFragment.b(2131237990));
            builder.b(groupsFeedFragment.b(2131237991));
            builder.a(groupsFeedFragment.jW_().getString(2131237992), new C31916(groupsFeedFragment));
            builder.b(groupsFeedFragment.b(2131237986), new C31927(groupsFeedFragment));
            builder.a().show();
        }
        GroupsPlutoniumHeaderAdapter groupsPlutoniumHeaderAdapter = groupsFeedFragment.bc;
        if (groupsFeedFragment.aV()) {
            z2 = false;
        } else {
            z2 = true;
        }
        groupsPlutoniumHeaderAdapter.m23433a(fetchGroupInformationModel, z2, groupsFeedFragment.am.I, false, false);
        if (fetchGroupInformationModel != null) {
            groupsFeedFragment.aQ();
        }
        if (groupsFeedFragment.aA()) {
            GroupsSuggestPurposeDialogFragment groupsSuggestPurposeDialogFragment = new GroupsSuggestPurposeDialogFragment();
            groupsSuggestPurposeDialogFragment.an = groupsFeedFragment.bz.gW_();
            groupsSuggestPurposeDialogFragment.am = new C31938(groupsFeedFragment);
            groupsSuggestPurposeDialogFragment.a(groupsFeedFragment.kO_(), "SUGGEST_PURPOSE_DIALOG");
            groupsFeedFragment.bs = true;
        }
    }

    private void aQ() {
        boolean z;
        if (this.bz == null) {
            z = true;
        } else {
            DraculaReturnValue b = this.bz.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            z = DraculaRuntime.a(mutableFlatBuffer, i, null, 0);
        }
        if (!z && mx_()) {
            if (this.aJ.f(m23292q())) {
                b = this.bz.b();
                mutableFlatBuffer = b.a;
                i = b.b;
                i2 = b.c;
                ((FadingFbTitleBar) this.az.get()).setTitleHint(a(2131237409, new Object[]{mutableFlatBuffer.k(i, 13)}));
                return;
            }
            HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
            if (hasTitleBar != null) {
                DraculaReturnValue b2 = this.bz.b();
                mutableFlatBuffer = b2.a;
                i = b2.b;
                int i3 = b2.c;
                hasTitleBar.a_(mutableFlatBuffer.k(i, 13));
                hasTitleBar.kg_();
            }
        }
    }

    public static void m23267h(GroupsFeedFragment groupsFeedFragment, boolean z) {
        if (groupsFeedFragment.getContext() != null) {
            final GraphQLCachePolicy graphQLCachePolicy = z ? GroupsFeedHeaderFetcher.a : GraphQLCachePolicy.a;
            final boolean z2 = groupsFeedFragment.bB;
            if (groupsFeedFragment.bB) {
                groupsFeedFragment.f22149a.c();
                groupsFeedFragment.f22149a.b();
                groupsFeedFragment.bB = false;
            }
            groupsFeedFragment.as.a("fetch_groups_header", new Callable<ListenableFuture<GraphQLResult<FetchGroupInformationModel>>>(groupsFeedFragment) {
                final /* synthetic */ GroupsFeedFragment f22134b;

                public Object call() {
                    GroupsFeedHeaderFetcher groupsFeedHeaderFetcher = this.f22134b.f22150b;
                    String str = this.f22134b.aZ;
                    GraphQLCachePolicy graphQLCachePolicy = graphQLCachePolicy;
                    int b = StandardHeaderViewHelper.b(groupsFeedHeaderFetcher.e.c(), this.f22134b.jW_().getConfiguration().orientation);
                    int i = b / 2;
                    FetchGroupInformationString a = FetchGroupInformationGraphQL.a();
                    a.a("group_id", str).a("first_members", "8").a("profile_picture_size", Integer.valueOf(i)).a("cover_photo_width", Integer.valueOf(groupsFeedHeaderFetcher.e.c())).a("cover_photo_height", Integer.valueOf(b)).a("plutonium_enabled", Boolean.valueOf(true)).a("automatic_photo_captioning_enabled", Boolean.toString(groupsFeedHeaderFetcher.f.a())).a("card_image_width", Integer.valueOf(groupsFeedHeaderFetcher.g.getDimensionPixelOffset(2131432061))).a(true);
                    GraphQLQueryFuture a2 = groupsFeedHeaderFetcher.b.a(GraphQLRequest.a(a).a(graphQLCachePolicy).a(604800));
                    groupsFeedHeaderFetcher.c.a(a2, new GroupsFeedHeaderFetcher.1(groupsFeedHeaderFetcher, str));
                    return a2;
                }
            }, new AbstractDisposableFutureCallback<GraphQLResult<FetchGroupInformationModel>>(groupsFeedFragment) {
                final /* synthetic */ GroupsFeedFragment f22136b;

                protected final void m23238a(Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    if (graphQLResult.freshness == DataFreshnessResult.FROM_SERVER) {
                        this.f22136b.f22149a.g();
                        this.f22136b.f22149a.e();
                    } else {
                        this.f22136b.f22149a.d();
                        this.f22136b.f22149a.f();
                    }
                    this.f22136b.bC = false;
                    GroupsFeedFragment.m23260a(this.f22136b, (FetchGroupInformationModel) graphQLResult.e);
                    GroupsFeedFragment groupsFeedFragment = this.f22136b;
                    if (!groupsFeedFragment.bp) {
                        groupsFeedFragment.bp = true;
                        ScopedSearchGroupsNuxController scopedSearchGroupsNuxController = (ScopedSearchGroupsNuxController) groupsFeedFragment.av.a("3747", ScopedSearchGroupsNuxController.class);
                        if (scopedSearchGroupsNuxController != null) {
                            scopedSearchGroupsNuxController.c = ((FadingFbTitleBar) groupsFeedFragment.az.get()).getSearchEditText();
                            scopedSearchGroupsNuxController.d = Boolean.valueOf(GroupCommerceComposerHelper.a(GroupInformationInterfaceFactory.a(groupsFeedFragment.bz))).booleanValue();
                            scopedSearchGroupsNuxController.e = groupsFeedFragment.m23292q();
                            groupsFeedFragment.bo = new Runnable(groupsFeedFragment) {
                                final /* synthetic */ GroupsFeedFragment f22137a;

                                {
                                    this.f22137a = r1;
                                }

                                public void run() {
                                    this.f22137a.at.a(this.f22137a.getContext(), new InterstitialTrigger(Action.GROUP_SCOPED_SEARCH), InterstitialController.class, null);
                                }
                            };
                            HandlerDetour.b(groupsFeedFragment.aK, groupsFeedFragment.bo, 1000, -16770658);
                        }
                    }
                    if (graphQLResult.freshness != DataFreshnessResult.FROM_SERVER) {
                        if (z2) {
                            this.f22136b.f22149a.c();
                        }
                        this.f22136b.bD = true;
                        GroupsFeedFragment.aS(this.f22136b);
                        return;
                    }
                    this.f22136b.aC.a(this.f22136b.bE, this.f22136b.aZ, graphQLResult);
                }

                protected final void m23239a(Throwable th) {
                    this.f22136b.f22149a.j();
                    if (this.f22136b.bz != null) {
                        GroupsFeedFragment.m23260a(this.f22136b, this.f22136b.bz);
                    }
                    if (this.f22136b.bC) {
                        this.f22136b.f22152d.a(GroupsFeedFragment.aY, "Failed to fetch group header.");
                        return;
                    }
                    this.f22136b.bC = true;
                    GroupsFeedFragment.m23267h(this.f22136b, true);
                }
            });
        }
    }

    public static void aS(GroupsFeedFragment groupsFeedFragment) {
        ConnectionState d = groupsFeedFragment.bw.d();
        ConnectionLocation c = d.c();
        boolean z;
        if (d.d() > 0 || !(c.d || c.c == LocationType.INITIAL)) {
            z = true;
        } else {
            z = false;
        }
        if (groupsFeedFragment.bD && r0) {
            groupsFeedFragment.bD = false;
            m23267h(groupsFeedFragment, true);
        }
    }

    public final void m23276a(View view) {
    }

    public static boolean aT(GroupsFeedFragment groupsFeedFragment) {
        return groupsFeedFragment.bz != null && groupsFeedFragment.bz.q() == GraphQLGroupPostStatus.CAN_POST_AFTER_APPROVAL;
    }

    public final void m23269G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -641713224);
        this.bA.notifyDataSetChanged();
        az();
        this.aC.e();
        aX(this);
        super.G();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1198885086, a);
    }

    public final String am_() {
        return "group_feed";
    }

    public final Map<String, Object> m23281c() {
        Object obj = this.aZ;
        if (obj == null) {
            obj = this.s.getString("group_feed_id");
        }
        if (obj == null) {
            return null;
        }
        return ImmutableBiMap.b("group_id", obj);
    }

    public final void m23284e() {
        this.am.i();
    }

    public final void m23277a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        this.am.a(str, fileDescriptor, printWriter, strArr);
    }

    private void aU() {
        FadingTitlebarContent fadingTitlebarContent = (FadingTitlebarContent) a(FadingTitlebarContent.class);
        if (this.bl == null && fadingTitlebarContent != null) {
            this.bl = new FadingContentFragmentController();
            this.bl.a(this, (FadingFbTitleBar) this.az.get(), m23290n(), fadingTitlebarContent, true, true);
        }
    }

    private View m23266h(int i) {
        return av() ? this.ao.l.d().getChildAt(i) : this.am.e().getChildAt(i);
    }

    public final FadingContentView m23287j() {
        return (FadingContentView) m23266h(0);
    }

    public final boolean mk_() {
        View h = m23266h(0);
        if (h != null) {
            return h instanceof FadingContentView;
        }
        return false;
    }

    public final int ml_() {
        Integer valueOf = Integer.valueOf(m23266h(0).getTop());
        if (valueOf == null) {
            return 0;
        }
        return valueOf.intValue();
    }

    public final void m23291p() {
        this.bh = true;
    }

    public final GraphSearchQuery m23292q() {
        return m23268i(this, false);
    }

    public static GraphSearchQuery m23268i(GroupsFeedFragment groupsFeedFragment, boolean z) {
        return GroupsGraphSearchHelper.b(groupsFeedFragment.bz, groupsFeedFragment.aZ, z, groupsFeedFragment.aJ);
    }

    private boolean aV() {
        return this.bf != null && this.bf.getVisibility() == 0;
    }

    public static void aX(GroupsFeedFragment groupsFeedFragment) {
        if (groupsFeedFragment.bt) {
            groupsFeedFragment.bt = false;
            m23267h(groupsFeedFragment, true);
        }
    }
}
