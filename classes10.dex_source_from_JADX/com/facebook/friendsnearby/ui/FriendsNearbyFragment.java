package com.facebook.friendsnearby.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.backgroundlocation.privacypicker.graphql.BackgroundLocationPrivacyPickerGraphQLModels.BackgroundLocationPrivacyPickerOptionModel;
import com.facebook.backgroundlocation.reporting.BackgroundLocationReportingUpdateParams;
import com.facebook.backgroundlocation.settings.write.BackgroundLocationUpdateSettingsParams;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.bookmark.BookmarkManager;
import com.facebook.bookmark.client.BookmarkClient;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureUtils;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.uri.FBLinksUtil.ListHelper;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.FacebookOnlyIntentActionFactory;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.debug.log.BLog;
import com.facebook.entitycards.intent.EntityCardsIntentHelper;
import com.facebook.entitycards.intent.EntityCardsIntentHelper.EntityRange;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.UserBlockedEventSubscriber;
import com.facebook.friendsnearby.ExperimentsForFriendsNearbyModule;
import com.facebook.friendsnearby.entitycards.FriendsNearbyEntityCardsLauncher;
import com.facebook.friendsnearby.entitycards.model.SimpleUser;
import com.facebook.friendsnearby.model.DashboardModel;
import com.facebook.friendsnearby.model.FriendsNearbyDataUtil;
import com.facebook.friendsnearby.model.FriendsNearbyInviteRow;
import com.facebook.friendsnearby.model.FriendsNearbyInviteRow.InviteState;
import com.facebook.friendsnearby.model.FriendsNearbyMoreSectionLoader;
import com.facebook.friendsnearby.model.FriendsNearbyMoreSectionLoader.C29241;
import com.facebook.friendsnearby.model.FriendsNearbyMoreSectionLoaderProvider;
import com.facebook.friendsnearby.model.FriendsNearbyNewDataHolder;
import com.facebook.friendsnearby.model.FriendsNearbyNewListRow;
import com.facebook.friendsnearby.model.FriendsNearbyOutgoingPingRow;
import com.facebook.friendsnearby.model.FriendsNearbyRow;
import com.facebook.friendsnearby.model.FriendsNearbySearchLoader;
import com.facebook.friendsnearby.model.FriendsNearbySearchLoader.C29251;
import com.facebook.friendsnearby.model.FriendsNearbySearchLoader.C29262;
import com.facebook.friendsnearby.model.FriendsNearbySearchLoader.PageState;
import com.facebook.friendsnearby.model.FriendsNearbySearchLoaderProvider;
import com.facebook.friendsnearby.model.FriendsNearbySection;
import com.facebook.friendsnearby.model.FriendsNearbySectionLoader;
import com.facebook.friendsnearby.model.FriendsNearbySectionLoader.C29291;
import com.facebook.friendsnearby.model.FriendsNearbySectionLoaderProvider;
import com.facebook.friendsnearby.model.FriendsNearbySelfRow;
import com.facebook.friendsnearby.model.FriendsNearbyTask;
import com.facebook.friendsnearby.model.UpsellModel;
import com.facebook.friendsnearby.model.pings.FriendsNearbyPingsDataHolder;
import com.facebook.friendsnearby.mqtt.FriendsNearbyMqttPushHandler;
import com.facebook.friendsnearby.perf.FriendsNearbyDashboardPerfLogger;
import com.facebook.friendsnearby.perf.FriendsNearbyDashboardPerfLogger.Marker;
import com.facebook.friendsnearby.pingdialog.LocationPingParams;
import com.facebook.friendsnearby.pingdialog.ui.LocationPingDialog;
import com.facebook.friendsnearby.pingdialog.ui.LocationPingDialogCreator;
import com.facebook.friendsnearby.pingdialog.ui.LocationPingDialogFragment;
import com.facebook.friendsnearby.server.FriendsNearbyDeleteInviteParams;
import com.facebook.friendsnearby.server.FriendsNearbyInviteParams;
import com.facebook.friendsnearby.server.FriendsNearbyNewQuery;
import com.facebook.friendsnearby.server.FriendsNearbyNewQuery.FriendsNearbyMoreInSectionQueryString;
import com.facebook.friendsnearby.server.FriendsNearbyNewQuery.FriendsNearbySearchQueryString;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryInterfaces.FriendsNearbyContactsTab;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryInterfaces.FriendsNearbyLocationSharingFields;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryInterfaces.FriendsNearbyLocationSharingQuery.PrivacySettings;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyContactsTabModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyContactsTabModel.ContactsTabsModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyContactsTabModel.ContactsTabsModel.NodesModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyLocationSharingFieldsModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyLocationSharingFieldsModel.NearbyFriendsRegionModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyLocationSharingQueryModel.PrivacySettingsModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbySectionsPageFieldsModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyViewerInfoModel;
import com.facebook.friendsnearby.server.FriendsNearbyServiceHandler;
import com.facebook.friendsnearby.ui.FriendsNearbyDashboardAnalyticsLogger.ImpressionType;
import com.facebook.friendsnearby.ui.FriendsNearbyFragmentStates.DataLoadListener;
import com.facebook.friendsnearby.ui.FriendsNearbyFragmentStates.FriendsNearbyFragmentState;
import com.facebook.friendsnearby.ui.FriendsNearbyListAdapter.C29711;
import com.facebook.friendsnearby.ui.FriendsNearbyMapFragment.C29731;
import com.facebook.friendsnearby.ui.FriendsNearbyMapFragment.MapState;
import com.facebook.friendsnearby.ui.FriendsNearbyMapFragment.VisibleArea;
import com.facebook.friendsnearby.ui.FriendsNearbyRowView.OnClickListener;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.Listener;
import com.facebook.ipc.feed.PermalinkStoryIdParams;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.location.FbLocationManagerParams.Priority;
import com.facebook.location.FbLocationOperation;
import com.facebook.location.FbLocationOperationParams;
import com.facebook.location.FbLocationOperationParams.Builder;
import com.facebook.location.FbLocationStatus;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.FbLocationStatusMonitor;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.location.ImmutableLocation;
import com.facebook.location.LocationSignalDataPackage;
import com.facebook.location.gmsupsell.GooglePlayLocationServicesSettingsManager.LocationSettingsRequestParams;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController;
import com.facebook.location.gmsupsell.SimpleLocationUpsellDialogFinishedListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rapidfeedback.RapidFeedbackController;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.animations.BaseAnimatorListener;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.widget.OnDispatchDrawListener;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.SplitHideableListView;
import com.facebook.widget.listview.SplitHideableListView.OnSplitHeightChangedListener;
import com.facebook.widget.listview.StickyHeader;
import com.facebook.widget.refreshableview.RefreshableViewContainerLike;
import com.facebook.widget.refreshableview.RefreshableViewContainerLike.OnRefreshListener;
import com.facebook.widget.text.BetterButton;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: X.509 */
public class FriendsNearbyFragment extends FbFragment implements AnalyticsFragment, CanHandleBackPressed, OnClickListener {
    public static final Class<?> f20913a = FriendsNearbyFragment.class;
    public static final CallerContext f20914b = CallerContext.b(FriendsNearbyFragment.class, "nearby_friends");
    public static final FbLocationOperationParams f20915c;
    public static final FbLocationOperationParams f20916d;
    public static final String[] f20917e = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    private FriendingEventBus aA;
    public BookmarkManager aB;
    public FacebookOnlyIntentActionFactory aC;
    private GlyphColorizer aD;
    public FriendsNearbyDashboardVisitCounter aE;
    public ZeroDialogController aF;
    public RapidFeedbackController aG;
    private FriendsNearbyDashboardActionButtonHandler aH;
    private ViewPermalinkIntentFactory aI;
    private GatekeeperStoreImpl aJ;
    public AppStateManager aK;
    public final Set<FriendsNearbyMoreSectionLoader> aL = Sets.a();
    public FriendsNearbyMapFragment aM;
    public EditText aN;
    public View aO;
    public View aP;
    public BetterButton aQ;
    private RefreshableViewContainerLike aR;
    public SplitHideableListView aS;
    private ViewGroup aT;
    public FriendsNearbyFeatureDisabledView aU;
    public TextView aV;
    private View aW;
    private TextView aX;
    private FriendsNearbyErrorScreenView aY;
    private FriendsNearbyLocationDisabledView aZ;
    public AbstractFbErrorReporter al;
    public SecureContextHelper am;
    public UpsellModel an;
    public FriendsNearbyDataUtil ao;
    public FriendsNearbyDashboardAnalyticsLogger ap;
    public Clock aq;
    public FriendsNearbyDashboardPerfLogger ar;
    private InputMethodManager as;
    private FriendsNearbyEntityCardsLauncher at;
    public FriendsNearbySearchLoader au;
    private FriendsNearbyMoreSectionLoaderProvider av;
    public FriendsNearbySectionLoader aw;
    private QeAccessor ax;
    private LocationPingDialogCreator ay;
    private Provider<FbLocationOperation> az;
    public final FriendsNearbyFragmentState bA = new LocationLoadingRefreshState(this);
    public final FriendsNearbyFragmentState bB = new LocationPermissionNotGrantedState(this);
    public final FriendsNearbyFragmentState bC = new LocationDisabledState(this);
    public final FriendsNearbyFragmentState bD = new DataLoading1State(this);
    public final FriendsNearbyFragmentState bE = new DataLoading2State(this);
    public final FriendsNearbyFragmentState bF = new DataLoadingPullRefreshState(this);
    public final FriendsNearbyFragmentState bG = new NewDataLoad1SucceededState(this);
    public final FriendsNearbyFragmentState bH = new NewDataLoad2SucceededState(this);
    public final FriendsNearbyFragmentState bI = new DataLoadFailedState(this);
    public final FriendsNearbyFragmentState bJ = new ShowUpsellState(this);
    public final FriendsNearbyFragmentState bK = new ShowUpsellAndRedirectToNuxState(this);
    public MapState bL = MapState.HEADER;
    public FriendsNearbyFragmentState bM;
    private final UserBlockedEventSubscriber bN = new C29561(this);
    public final AnonymousClass21 bO = new Object(this) {
        final /* synthetic */ FriendsNearbyFragment f20853a;

        {
            this.f20853a = r1;
        }

        public final void m21746a(FriendsNearbySection friendsNearbySection) {
            m21744c(friendsNearbySection);
            this.f20853a.aS.setSelection(0);
        }

        public final void m21747b(FriendsNearbySection friendsNearbySection) {
            m21744c(friendsNearbySection);
        }

        public final void m21745a() {
            this.f20853a.ba.m20879a(FriendsNearbySection.f20519c);
            FriendsNearbyFragment.aQ(this.f20853a);
            FriendsNearbyFragment.aO(this.f20853a);
        }

        private void m21744c(FriendsNearbySection friendsNearbySection) {
            this.f20853a.ba.m20879a(friendsNearbySection);
            FriendsNearbyFragment.aQ(this.f20853a);
            FriendsNearbyFragment.aO(this.f20853a);
        }
    };
    public FriendsNearbyNewDataHolder ba;
    private FriendsNearbyListAdapter bb;
    private boolean bc = true;
    public Optional<ImmutableLocation> bd;
    public long be;
    public boolean bf;
    public boolean bg;
    public boolean bh;
    public int bi;
    public boolean bj;
    public ObjectAnimator bk;
    public ObjectAnimator bl;
    private ObjectAnimator bm;
    private ObjectAnimator bn;
    public String bo;
    public FriendsNearbyViewerInfoModel bp;
    public String bq;
    public NearbyFriendsRegionModel br;
    private BaseFbBroadcastManager bs;
    private NearbyFriendsLiveUpdateReceiver bt;
    private SelfRegistrableReceiverImpl bu;
    private ActivityRuntimePermissionsManagerProvider bv;
    public ActivityRuntimePermissionsManager bw;
    public GooglePlayServicesLocationUpsellDialogController bx;
    private SimpleLocationUpsellDialogFinishedListener by;
    public final FriendsNearbyFragmentState bz = new LocationLoadingInitState(this);
    public TasksManager<FriendsNearbyTask> f20918f;
    public FbLocationStatusUtil f20919g;
    public DefaultBlueServiceOperationFactory f20920h;
    public Toaster f20921i;

    /* compiled from: X.509 */
    class C29561 extends UserBlockedEventSubscriber {
        final /* synthetic */ FriendsNearbyFragment f20850a;

        C29561(FriendsNearbyFragment friendsNearbyFragment) {
            this.f20850a = friendsNearbyFragment;
        }

        public final void m21743b(FbEvent fbEvent) {
            this.f20850a.bf = true;
        }
    }

    /* compiled from: X.509 */
    public class AnonymousClass24 {
        public final /* synthetic */ DataLoadListener f20861a;
        public final /* synthetic */ FriendsNearbyFragment f20862b;

        public AnonymousClass24(FriendsNearbyFragment friendsNearbyFragment, DataLoadListener dataLoadListener) {
            this.f20862b = friendsNearbyFragment;
            this.f20861a = dataLoadListener;
        }
    }

    /* compiled from: X.509 */
    public class AnonymousClass25 implements Callable<ListenableFuture<OperationResult>> {
        final /* synthetic */ ImmutableLocation f20863a;
        final /* synthetic */ FriendsNearbyFragment f20864b;

        public AnonymousClass25(FriendsNearbyFragment friendsNearbyFragment, ImmutableLocation immutableLocation) {
            this.f20864b = friendsNearbyFragment;
            this.f20863a = immutableLocation;
        }

        public Object call() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("BackgroundLocationReportingUpdateParams", new BackgroundLocationReportingUpdateParams(ImmutableList.of(new LocationSignalDataPackage(this.f20863a, Boolean.valueOf(this.f20864b.aK.l())))));
            return BlueServiceOperationFactoryDetour.a(this.f20864b.f20920h, "background_location_update", bundle, ErrorPropagation.BY_EXCEPTION, FriendsNearbyFragment.f20914b, -1660319365).a();
        }
    }

    /* compiled from: X.509 */
    public class AnonymousClass27 extends AbstractDisposableFutureCallback<OperationResult> {
        final /* synthetic */ DialogFragment f20866a;
        final /* synthetic */ FriendsNearbyFragment f20867b;

        public AnonymousClass27(FriendsNearbyFragment friendsNearbyFragment, DialogFragment dialogFragment) {
            this.f20867b = friendsNearbyFragment;
            this.f20866a = dialogFragment;
        }

        protected final void m21756a(Object obj) {
            this.f20866a.a();
            this.f20867b.bM.mo943q();
        }

        protected final void m21757a(Throwable th) {
            this.f20866a.a();
            this.f20867b.f20921i.a(new ToastBuilder(2131230758));
        }
    }

    /* compiled from: X.509 */
    class C29572 implements ActionReceiver {
        final /* synthetic */ FriendsNearbyFragment f20871a;

        C29572(FriendsNearbyFragment friendsNearbyFragment) {
            this.f20871a = friendsNearbyFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1641982422);
            if (broadcastReceiverLike.isInitialStickyBroadcast()) {
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1217717806, a);
                return;
            }
            this.f20871a.ba.m20876a();
            FriendsNearbyFragment.m21864b(this.f20871a, this.f20871a.bz);
            LogUtils.e(2109344806, a);
        }
    }

    /* compiled from: X.509 */
    class C29616 extends OnRefreshListener {
        final /* synthetic */ FriendsNearbyFragment f20890a;

        C29616(FriendsNearbyFragment friendsNearbyFragment) {
            this.f20890a = friendsNearbyFragment;
        }

        public final void m21765b(boolean z) {
            FriendsNearbyFragment friendsNearbyFragment = this.f20890a;
            friendsNearbyFragment.aS.setEmptyView(null);
            friendsNearbyFragment.aV.setVisibility(8);
            if (z) {
                this.f20890a.ap.m21721o();
                this.f20890a.bM.mo935d();
            }
        }
    }

    /* compiled from: X.509 */
    public class C29649 implements OnScrollListener {
        public final /* synthetic */ FriendsNearbyFragment f20895a;
        private boolean f20896b;

        C29649(FriendsNearbyFragment friendsNearbyFragment) {
            this.f20895a = friendsNearbyFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            switch (i) {
                case 1:
                case 2:
                    this.f20895a.ap.m21720n();
                    FriendsNearbyFragment.aE(this.f20895a);
                    return;
                default:
                    return;
            }
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            boolean z = i + i2 > i3 + -3;
            if (z != this.f20896b) {
                this.f20896b = z;
                if (z) {
                    if (this.f20895a.au.f20545h == PageState.HAS_MORE) {
                        FriendsNearbySearchLoader friendsNearbySearchLoader = this.f20895a.au;
                        AnonymousClass21 anonymousClass21 = this.f20895a.bO;
                        PageState pageState;
                        if (friendsNearbySearchLoader.f20545h == PageState.COMPLETE || friendsNearbySearchLoader.f20545h == PageState.ERROR || friendsNearbySearchLoader.f20545h == PageState.LOADING) {
                            pageState = friendsNearbySearchLoader.f20545h;
                        } else {
                            friendsNearbySearchLoader.f20545h = PageState.LOADING;
                            FriendsNearbySearchQueryString d = FriendsNearbyNewQuery.m21170d();
                            d.a("cursor", friendsNearbySearchLoader.f20546i).a("pic_size", friendsNearbySearchLoader.f20543f).a("searchText", friendsNearbySearchLoader.f20547j).a("order", FriendsNearbySearchLoader.f20539b).a("count", "20");
                            friendsNearbySearchLoader.f20540c.a(FriendsNearbyTask.f20576j, friendsNearbySearchLoader.f20541d.a(GraphQLRequest.a(d)), new C29262(friendsNearbySearchLoader, anonymousClass21));
                            pageState = friendsNearbySearchLoader.f20545h;
                        }
                        FriendsNearbyFragment.aN(this.f20895a);
                    }
                }
            }
        }
    }

    /* compiled from: X.509 */
    abstract class BaseFriendsNearbyFragmentState extends FriendsNearbyFragmentState {
        final /* synthetic */ FriendsNearbyFragment f20897a;

        public BaseFriendsNearbyFragmentState(FriendsNearbyFragment friendsNearbyFragment) {
            this.f20897a = friendsNearbyFragment;
        }

        public final void mo927a() {
            this.f20897a.ar.m21028c(Marker.DASHBOARD_TTI);
            this.f20897a.bf = true;
            FriendsNearbyFragment.m21864b(this.f20897a, this.f20897a.bB);
        }

        public final void mo928b() {
            this.f20897a.ar.m21028c(Marker.DASHBOARD_TTI);
            this.f20897a.bf = true;
            FriendsNearbyFragment.m21864b(this.f20897a, this.f20897a.bC);
        }

        public final void mo934c() {
            this.f20897a.ap.m21712f();
            FriendsNearbyFragment friendsNearbyFragment = this.f20897a;
            friendsNearbyFragment.bf = true;
            Intent intent = new Intent();
            intent.setData(Uri.parse(FBLinks.cU));
            friendsNearbyFragment.am.a(intent, friendsNearbyFragment.getContext());
        }

        public void mo935d() {
        }
    }

    /* compiled from: X.509 */
    class DataLoadFailedState extends BaseFriendsNearbyFragmentState {
        final /* synthetic */ FriendsNearbyFragment f20898b;

        public DataLoadFailedState(FriendsNearbyFragment friendsNearbyFragment) {
            this.f20898b = friendsNearbyFragment;
            super(friendsNearbyFragment);
        }

        public final void mo936e() {
            this.f20898b.ba.m20876a();
            FriendsNearbyFragment.aM(this.f20898b);
            FriendsNearbyFragment.m21852a(this.f20898b, 2131241998, 2131241999, 2131230765);
            this.f20898b.ap.m21701a(ImpressionType.ERROR);
        }

        public final void mo937f() {
            FriendsNearbyFragment.m21864b(this.f20898b, this.f20898b.bA);
        }
    }

    /* compiled from: X.509 */
    class DataLoading1State extends BaseFriendsNearbyFragmentState {
        final /* synthetic */ FriendsNearbyFragment f20899b;

        public DataLoading1State(FriendsNearbyFragment friendsNearbyFragment) {
            this.f20899b = friendsNearbyFragment;
            super(friendsNearbyFragment);
        }

        public final void mo936e() {
            FriendsNearbyFragment.aR(this.f20899b);
            FriendsNearbyFragment.aS(this.f20899b);
            FriendsNearbyFragment.aT(this.f20899b);
            FriendsNearbyFragment.m21853a(this.f20899b, (DataLoadListener) this);
        }

        public final void mo929g() {
            FriendsNearbyFragment.m21868c(this.f20899b, this.f20899b.b(2131230739));
        }

        public final void mo930h() {
            this.f20899b.bf = false;
            FriendsNearbyFragment.m21864b(this.f20899b, this.f20899b.bG);
        }

        public final void mo931i() {
            this.f20899b.ar.m21028c(Marker.DASHBOARD_TTI);
            FriendsNearbyFragment.m21864b(this.f20899b, this.f20899b.bK);
        }

        public final void mo932j() {
            this.f20899b.ar.m21028c(Marker.DASHBOARD_TTI);
            FriendsNearbyFragment.m21864b(this.f20899b, this.f20899b.bI);
        }

        public final void mo933k() {
            this.f20899b.ar.m21028c(Marker.DASHBOARD_TTI);
            if (this.f20899b.an.f20588e == null) {
                FriendsNearbyFragment.m21864b(this.f20899b, this.f20899b.bK);
            } else {
                FriendsNearbyFragment.m21864b(this.f20899b, this.f20899b.bJ);
            }
        }
    }

    /* compiled from: X.509 */
    class DataLoading2State extends BaseFriendsNearbyFragmentState {
        final /* synthetic */ FriendsNearbyFragment f20900b;

        public DataLoading2State(FriendsNearbyFragment friendsNearbyFragment) {
            this.f20900b = friendsNearbyFragment;
            super(friendsNearbyFragment);
        }

        public final void mo936e() {
            FriendsNearbyFragment friendsNearbyFragment = this.f20900b;
            friendsNearbyFragment.ar.m21026a(Marker.DASHBOARD_FETCH_DATA2);
            FriendsNearbyFragment.aN(friendsNearbyFragment);
            FriendsNearbySectionLoader friendsNearbySectionLoader = friendsNearbyFragment.aw;
            String str = friendsNearbyFragment.bo;
            Optional optional = friendsNearbyFragment.bd;
            AnonymousClass24 anonymousClass24 = new AnonymousClass24(friendsNearbyFragment, this);
            friendsNearbySectionLoader.f20560a.a(FriendsNearbyTask.f20572f, friendsNearbySectionLoader.f20562c.a(friendsNearbySectionLoader.f20563d.m20948a(str, optional)), new C29291(friendsNearbySectionLoader, anonymousClass24));
        }

        public final void mo930h() {
            this.f20900b.bf = false;
            FriendsNearbyFragment.m21864b(this.f20900b, this.f20900b.bH);
        }

        public final void mo931i() {
            FriendsNearbyFragment.m21864b(this.f20900b, this.f20900b.bK);
        }

        public final void mo932j() {
            FriendsNearbyFragment.m21864b(this.f20900b, this.f20900b.bI);
        }

        public final void mo933k() {
            FriendsNearbyFragment.m21864b(this.f20900b, this.f20900b.bJ);
        }

        public final void mo935d() {
            FriendsNearbyFragment.aM(this.f20900b);
        }
    }

    /* compiled from: X.509 */
    class DataLoadingPullRefreshState extends BaseFriendsNearbyFragmentState {
        final /* synthetic */ FriendsNearbyFragment f20901b;

        public DataLoadingPullRefreshState(FriendsNearbyFragment friendsNearbyFragment) {
            this.f20901b = friendsNearbyFragment;
            super(friendsNearbyFragment);
        }

        public final void mo929g() {
        }

        public final void mo936e() {
            FriendsNearbyFragment.m21853a(this.f20901b, (DataLoadListener) this);
        }

        public final void mo930h() {
            this.f20901b.bf = false;
            FriendsNearbyFragment.m21864b(this.f20901b, this.f20901b.bG);
        }

        public final void mo931i() {
            FriendsNearbyFragment.m21864b(this.f20901b, this.f20901b.bK);
        }

        public final void mo932j() {
            FriendsNearbyFragment.m21864b(this.f20901b, this.f20901b.bI);
        }

        public final void mo933k() {
            FriendsNearbyFragment.m21864b(this.f20901b, this.f20901b.bJ);
        }
    }

    /* compiled from: X.509 */
    class LocationDisabledState extends BaseFriendsNearbyFragmentState {
        final /* synthetic */ FriendsNearbyFragment f20902b;

        public LocationDisabledState(FriendsNearbyFragment friendsNearbyFragment) {
            this.f20902b = friendsNearbyFragment;
            super(friendsNearbyFragment);
        }

        public final void mo936e() {
            this.f20902b.ba.m20876a();
            FriendsNearbyFragment.aM(this.f20902b);
            FriendsNearbyFragment.aT(this.f20902b);
            FriendsNearbyFragment.m21865b(this.f20902b, this.f20902b.b(2131242001));
            this.f20902b.ap.m21701a(ImpressionType.LOCATION_DISABLED);
        }

        public final void mo938l() {
            this.f20902b.bx.a(new LocationSettingsRequestParams(), "surface_nearby_friends", "mechanism_turn_on_button");
        }

        public final void mo939m() {
            FriendsNearbyFragment.m21858a(this.f20902b, true);
        }
    }

    /* compiled from: X.509 */
    class LocationLoadingInitState extends BaseFriendsNearbyFragmentState {
        final /* synthetic */ FriendsNearbyFragment f20903b;

        public LocationLoadingInitState(FriendsNearbyFragment friendsNearbyFragment) {
            this.f20903b = friendsNearbyFragment;
            super(friendsNearbyFragment);
        }

        public final void mo936e() {
            this.f20903b.ar.m21027b(Marker.DASHBOARD_INIT);
            FriendsNearbyFragment.aR(this.f20903b);
            FriendsNearbyFragment.aS(this.f20903b);
            FriendsNearbyFragment.aT(this.f20903b);
            FriendsNearbyFragment.m21856a(this.f20903b, (FriendsNearbyFragmentState) this, FriendsNearbyFragment.f20915c, Marker.DASHBOARD_INIT_LOCATION);
        }

        public final void mo940n() {
            FriendsNearbyFragment.m21868c(this.f20903b, this.f20903b.b(2131241997));
        }

        public final void mo941o() {
            FriendsNearbyFragment.m21864b(this.f20903b, this.f20903b.bD);
        }
    }

    /* compiled from: X.509 */
    class LocationLoadingRefreshState extends BaseFriendsNearbyFragmentState {
        final /* synthetic */ FriendsNearbyFragment f20904b;

        public LocationLoadingRefreshState(FriendsNearbyFragment friendsNearbyFragment) {
            this.f20904b = friendsNearbyFragment;
            super(friendsNearbyFragment);
        }

        public final void mo936e() {
            this.f20904b.ar.m21027b(Marker.DASHBOARD_INIT);
            FriendsNearbyFragment.aR(this.f20904b);
            FriendsNearbyFragment.aS(this.f20904b);
            FriendsNearbyFragment.aT(this.f20904b);
            FriendsNearbyFragment.m21856a(this.f20904b, (FriendsNearbyFragmentState) this, FriendsNearbyFragment.f20916d, Marker.DASHBOARD_REFRESH_LOCATION);
        }

        public final void mo940n() {
            FriendsNearbyFragment.m21868c(this.f20904b, this.f20904b.b(2131241997));
        }

        public final void mo941o() {
            FriendsNearbyFragment.m21864b(this.f20904b, this.f20904b.bF);
        }
    }

    /* compiled from: X.509 */
    class LocationPermissionNotGrantedState extends BaseFriendsNearbyFragmentState {
        final /* synthetic */ FriendsNearbyFragment f20906b;

        /* compiled from: X.509 */
        class C29651 implements RuntimePermissionsListener {
            final /* synthetic */ LocationPermissionNotGrantedState f20905a;

            C29651(LocationPermissionNotGrantedState locationPermissionNotGrantedState) {
                this.f20905a = locationPermissionNotGrantedState;
            }

            public final void m21826a() {
                FriendsNearbyFragment.m21864b(this.f20905a.f20906b, this.f20905a.f20906b.bz);
            }

            public final void m21827a(String[] strArr, String[] strArr2) {
                this.f20905a.f20906b.bf = true;
            }

            public final void m21828b() {
                this.f20905a.f20906b.bf = true;
            }
        }

        public LocationPermissionNotGrantedState(FriendsNearbyFragment friendsNearbyFragment) {
            this.f20906b = friendsNearbyFragment;
            super(friendsNearbyFragment);
        }

        public final void mo936e() {
            this.f20906b.ba.m20876a();
            FriendsNearbyFragment.aM(this.f20906b);
            FriendsNearbyFragment.aT(this.f20906b);
            FriendsNearbyFragment.m21865b(this.f20906b, this.f20906b.b(2131242002));
            this.f20906b.ap.m21701a(ImpressionType.LOCATION_DISABLED);
        }

        public final void mo938l() {
            this.f20906b.bw.a(FriendsNearbyFragment.f20917e, new C29651(this));
        }

        public final void mo939m() {
            FriendsNearbyFragment.m21858a(this.f20906b, true);
        }
    }

    /* compiled from: X.509 */
    class NearbyFriendsLiveUpdateReceiver implements ActionReceiver {
        final /* synthetic */ FriendsNearbyFragment f20907a;

        public NearbyFriendsLiveUpdateReceiver(FriendsNearbyFragment friendsNearbyFragment) {
            this.f20907a = friendsNearbyFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 862980450);
            UserKey userKey = (UserKey) intent.getParcelableExtra("user_id");
            String stringExtra = intent.getStringExtra("user_nearby_context");
            String stringExtra2 = intent.getStringExtra("user_meta_context");
            ImmutableLocation immutableLocation = (ImmutableLocation) intent.getParcelableExtra("user_location");
            if (!(userKey == null || stringExtra == null || stringExtra2 == null || immutableLocation == null)) {
                this.f20907a.ba.m20883a(userKey.b(), stringExtra, stringExtra2, immutableLocation);
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 965777190, a);
        }
    }

    /* compiled from: X.509 */
    class NewDataLoad1SucceededState extends BaseFriendsNearbyFragmentState {
        final /* synthetic */ FriendsNearbyFragment f20909b;

        /* compiled from: X.509 */
        class C29661 implements Listener {
            final /* synthetic */ NewDataLoad1SucceededState f20908a;

            C29661(NewDataLoad1SucceededState newDataLoad1SucceededState) {
                this.f20908a = newDataLoad1SucceededState;
            }

            public final void m21833a(Object obj) {
                FriendsNearbyFragment.aM(this.f20908a.f20909b);
                FriendsNearbyFragment.bb(this.f20908a.f20909b);
                FriendsNearbyFragment.m21864b(this.f20908a.f20909b, this.f20908a.f20909b.bE);
            }

            public final void m21832a() {
                NewDataLoad1SucceededState.m21834s(this.f20908a);
            }
        }

        public NewDataLoad1SucceededState(FriendsNearbyFragment friendsNearbyFragment) {
            this.f20909b = friendsNearbyFragment;
            super(friendsNearbyFragment);
        }

        public final void mo936e() {
            this.f20909b.ar.m21026a(Marker.DASHBOARD_VIEW_RENDER);
            this.f20909b.bj = true;
            if (!this.f20909b.ba.m20896j()) {
                FriendsNearbyFragment.aU(this.f20909b);
            } else if (FriendsNearbyFragment.aF(this.f20909b)) {
                this.f20909b.aF.a(ZeroFeatureKey.VIEW_MAP_INTERSTITIAL, this.f20909b.jW_().getString(2131232927), new C29661(this));
                this.f20909b.aF.a(ZeroFeatureKey.VIEW_MAP_INTERSTITIAL, this.f20909b.kO_());
            } else {
                m21834s(this);
            }
        }

        public final void mo937f() {
            FriendsNearbyFragment.aK(this.f20909b);
            this.f20909b.ap.m21714h();
        }

        public final void mo935d() {
            FriendsNearbyFragment.aM(this.f20909b);
        }

        public static void m21834s(NewDataLoad1SucceededState newDataLoad1SucceededState) {
            FriendsNearbyFragment.aM(newDataLoad1SucceededState.f20909b);
            FriendsNearbyFragment.aG(newDataLoad1SucceededState.f20909b);
            FriendsNearbyFragment.m21864b(newDataLoad1SucceededState.f20909b, newDataLoad1SucceededState.f20909b.bE);
        }
    }

    /* compiled from: X.509 */
    class NewDataLoad2SucceededState extends BaseFriendsNearbyFragmentState {
        final /* synthetic */ FriendsNearbyFragment f20910b;

        public NewDataLoad2SucceededState(FriendsNearbyFragment friendsNearbyFragment) {
            this.f20910b = friendsNearbyFragment;
            super(friendsNearbyFragment);
        }

        public final void mo936e() {
            FriendsNearbyFragment.aM(this.f20910b);
            if (this.f20910b.ba.m20896j()) {
                this.f20910b.ap.m21701a(ImpressionType.FRIENDSLIST);
                FriendsNearbyDashboardVisitCounter friendsNearbyDashboardVisitCounter = this.f20910b.aE;
                friendsNearbyDashboardVisitCounter.f20826c.edit().a(FriendsNearbyDashboardVisitCounter.f20823b, friendsNearbyDashboardVisitCounter.m21729c() + 1).commit();
                if (this.f20910b.aE.m21729c() >= 3) {
                    this.f20910b.aG.a("1520621328229529", this.f20910b.getContext());
                }
            } else {
                FriendsNearbyFragment.aU(this.f20910b);
            }
            if (this.f20910b.aN.hasFocus()) {
                FriendsNearbyFragment.m21857a(this.f20910b, this.f20910b.aN.getText());
            }
        }

        public final void mo935d() {
            if (this.f20910b.ba.m20895i()) {
                FriendsNearbyFragment.aM(this.f20910b);
            } else {
                FriendsNearbyFragment.m21864b(this.f20910b, this.f20910b.bA);
            }
        }

        public final void mo937f() {
            FriendsNearbyFragment.aK(this.f20910b);
            this.f20910b.ap.m21714h();
        }
    }

    /* compiled from: X.509 */
    class ShowUpsellAndRedirectToNuxState extends BaseFriendsNearbyFragmentState {
        final /* synthetic */ FriendsNearbyFragment f20911b;

        public ShowUpsellAndRedirectToNuxState(FriendsNearbyFragment friendsNearbyFragment) {
            this.f20911b = friendsNearbyFragment;
            super(friendsNearbyFragment);
        }

        public final void mo936e() {
            if (this.f20911b.bg) {
                FriendsNearbyFragment.aR(this.f20911b);
                FriendsNearbyFragment.aS(this.f20911b);
                FriendsNearbyFragment.aM(this.f20911b);
                FriendsNearbyFragment.m21866b(this.f20911b, true);
                return;
            }
            this.f20911b.bf = true;
            FriendsNearbyFragment friendsNearbyFragment = this.f20911b;
            friendsNearbyFragment.bg = true;
            FriendsNearbyFragment.m21858a(friendsNearbyFragment, false);
        }

        public final void mo942p() {
            FriendsNearbyFragment.m21858a(this.f20911b, false);
        }

        public final void mo943q() {
            FriendsNearbyFragment.aT(this.f20911b);
            FriendsNearbyFragment.m21864b(this.f20911b, this.f20911b.bD);
        }
    }

    /* compiled from: X.509 */
    class ShowUpsellState extends BaseFriendsNearbyFragmentState {
        final /* synthetic */ FriendsNearbyFragment f20912b;

        public ShowUpsellState(FriendsNearbyFragment friendsNearbyFragment) {
            this.f20912b = friendsNearbyFragment;
            super(friendsNearbyFragment);
        }

        public final void mo936e() {
            FriendsNearbyFragment.aR(this.f20912b);
            FriendsNearbyFragment.aS(this.f20912b);
            FriendsNearbyFragment.aM(this.f20912b);
            FriendsNearbyFragment.m21866b(this.f20912b, false);
            this.f20912b.ap.m21713g();
        }

        public final void mo944r() {
            FriendsNearbyFragment.m21858a(this.f20912b, false);
        }

        public final void mo942p() {
            BackgroundLocationPrivacyPickerOptionModel backgroundLocationPrivacyPickerOptionModel;
            FriendsNearbyFeatureDisabledView friendsNearbyFeatureDisabledView = this.f20912b.aU;
            Preconditions.checkNotNull(friendsNearbyFeatureDisabledView.f20838i);
            int selectedItemPosition = friendsNearbyFeatureDisabledView.f20835f.getSelectedItemPosition();
            if (selectedItemPosition == -1) {
                backgroundLocationPrivacyPickerOptionModel = null;
            } else {
                backgroundLocationPrivacyPickerOptionModel = friendsNearbyFeatureDisabledView.f20838i.m15297a(selectedItemPosition);
            }
            BackgroundLocationPrivacyPickerOptionModel backgroundLocationPrivacyPickerOptionModel2 = backgroundLocationPrivacyPickerOptionModel;
            if (backgroundLocationPrivacyPickerOptionModel2 != null) {
                FriendsNearbyFragment friendsNearbyFragment = this.f20912b;
                Bundle bundle = new Bundle();
                bundle.putParcelable("BackgroundLocationUpdateSettingsParams", BackgroundLocationUpdateSettingsParams.a(true, backgroundLocationPrivacyPickerOptionModel2.m15316c()));
                DialogFragment a = ProgressDialogFragment.a(2131230739, true, false, true);
                a.a(friendsNearbyFragment.kO_(), "turn_on_progress");
                friendsNearbyFragment.f20918f.a(FriendsNearbyTask.f20578l, BlueServiceOperationFactoryDetour.a(friendsNearbyFragment.f20920h, "background_location_update_settings", bundle, ErrorPropagation.BY_EXCEPTION, FriendsNearbyFragment.f20914b, 966178382).a(), new AnonymousClass27(friendsNearbyFragment, a));
                this.f20912b.ap.m21723q();
            }
        }

        public final void mo943q() {
            FriendsNearbyFragment.aT(this.f20912b);
            FriendsNearbyFragment.m21864b(this.f20912b, this.f20912b.bD);
        }
    }

    public static void m21860a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FriendsNearbyFragment) obj).m21851a((Clock) SystemClockMethodAutoProvider.a(injectorLike), TasksManager.a(injectorLike), FbLocationStatusUtil.a(injectorLike), Toaster.a(injectorLike), DefaultBlueServiceOperationFactory.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IdBasedLazy.a(injectorLike, 6737), FriendsNearbyDataUtil.m20822a(injectorLike), (FriendsNearbyListAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FriendsNearbyListAdapterProvider.class), FriendsNearbyDashboardAnalyticsLogger.m21698a(injectorLike), FriendsNearbyDashboardPerfLogger.m21025a(injectorLike), FriendingEventBus.a(injectorLike), InputMethodManagerMethodAutoProvider.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), FriendsNearbyEntityCardsLauncher.m20814a(injectorLike), (FriendsNearbySearchLoaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FriendsNearbySearchLoaderProvider.class), (FriendsNearbyMoreSectionLoaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FriendsNearbyMoreSectionLoaderProvider.class), (FriendsNearbySectionLoaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FriendsNearbySectionLoaderProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), LocationPingDialogCreator.m21113a(injectorLike), IdBasedProvider.a(injectorLike, 2481), (BookmarkManager) BookmarkClient.a(injectorLike), FacebookOnlyIntentActionFactory.a(injectorLike), GlyphColorizer.a(injectorLike), (ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), GooglePlayServicesLocationUpsellDialogController.a(injectorLike), SimpleLocationUpsellDialogFinishedListener.a(injectorLike), FriendsNearbyDashboardVisitCounter.m21726a(injectorLike), (ZeroDialogController) FbZeroDialogController.a(injectorLike), RapidFeedbackController.a(injectorLike), FriendsNearbyDashboardActionButtonHandler.m21695a(injectorLike), ViewPermalinkIntentFactory.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), AppStateManager.a(injectorLike));
    }

    static {
        Builder a = FbLocationOperationParams.a(Priority.HIGH_ACCURACY);
        a.b = 900000;
        a = a;
        a.c = 1200.0f;
        a = a;
        a.d = 1000;
        f20915c = a.a();
        a = FbLocationOperationParams.a(Priority.HIGH_ACCURACY);
        a.b = 120000;
        a = a;
        a.c = 100.0f;
        a = a;
        a.d = 1500;
        f20916d = a.a();
    }

    @Inject
    private void m21851a(Clock clock, TasksManager tasksManager, FbLocationStatusUtil fbLocationStatusUtil, Toaster toaster, BlueServiceOperationFactory blueServiceOperationFactory, FbErrorReporter fbErrorReporter, SecureContextHelper secureContextHelper, Lazy<FriendsNearbyNewDataHolder> lazy, FriendsNearbyDataUtil friendsNearbyDataUtil, FriendsNearbyListAdapterProvider friendsNearbyListAdapterProvider, FriendsNearbyDashboardAnalyticsLogger friendsNearbyDashboardAnalyticsLogger, FriendsNearbyDashboardPerfLogger friendsNearbyDashboardPerfLogger, FriendingEventBus friendingEventBus, InputMethodManager inputMethodManager, FbBroadcastManager fbBroadcastManager, FriendsNearbyEntityCardsLauncher friendsNearbyEntityCardsLauncher, FriendsNearbySearchLoaderProvider friendsNearbySearchLoaderProvider, FriendsNearbyMoreSectionLoaderProvider friendsNearbyMoreSectionLoaderProvider, FriendsNearbySectionLoaderProvider friendsNearbySectionLoaderProvider, QeAccessor qeAccessor, LocationPingDialogCreator locationPingDialogCreator, Provider<FbLocationOperation> provider, BookmarkManager bookmarkManager, FacebookOnlyIntentActionFactory facebookOnlyIntentActionFactory, GlyphColorizer glyphColorizer, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, GooglePlayServicesLocationUpsellDialogController googlePlayServicesLocationUpsellDialogController, SimpleLocationUpsellDialogFinishedListener simpleLocationUpsellDialogFinishedListener, FriendsNearbyDashboardVisitCounter friendsNearbyDashboardVisitCounter, ZeroDialogController zeroDialogController, RapidFeedbackController rapidFeedbackController, FriendsNearbyDashboardActionButtonHandler friendsNearbyDashboardActionButtonHandler, ViewPermalinkIntentFactory viewPermalinkIntentFactory, GatekeeperStore gatekeeperStore, AppStateManager appStateManager) {
        this.aq = clock;
        this.f20920h = blueServiceOperationFactory;
        this.f20918f = tasksManager;
        this.f20919g = fbLocationStatusUtil;
        this.f20921i = toaster;
        this.al = fbErrorReporter;
        this.am = secureContextHelper;
        this.ao = friendsNearbyDataUtil;
        this.bb = friendsNearbyListAdapterProvider.m21920a(this, this);
        this.ap = friendsNearbyDashboardAnalyticsLogger;
        this.ar = friendsNearbyDashboardPerfLogger;
        this.aA = friendingEventBus;
        this.as = inputMethodManager;
        this.bs = fbBroadcastManager;
        this.at = friendsNearbyEntityCardsLauncher;
        this.au = friendsNearbySearchLoaderProvider.m20955a(this.f20918f);
        this.av = friendsNearbyMoreSectionLoaderProvider;
        this.aw = friendsNearbySectionLoaderProvider.m20974a(this.f20918f);
        this.ax = qeAccessor;
        this.ay = locationPingDialogCreator;
        this.az = provider;
        this.ba = (FriendsNearbyNewDataHolder) lazy.get();
        this.aB = bookmarkManager;
        this.aC = facebookOnlyIntentActionFactory;
        this.aD = glyphColorizer;
        this.bv = activityRuntimePermissionsManagerProvider;
        this.bx = googlePlayServicesLocationUpsellDialogController;
        this.by = simpleLocationUpsellDialogFinishedListener;
        this.aE = friendsNearbyDashboardVisitCounter;
        this.aF = zeroDialogController;
        this.aG = rapidFeedbackController;
        this.aH = friendsNearbyDashboardActionButtonHandler;
        this.aI = viewPermalinkIntentFactory;
        this.aJ = gatekeeperStore;
        this.aK = appStateManager;
    }

    public final void m21878c(Bundle bundle) {
        super.c(bundle);
        Class cls = FriendsNearbyFragment.class;
        m21860a((Object) this, getContext());
        if (bundle != null) {
            this.bg = bundle.getBoolean("redirected_to_nux");
        }
        this.ar.m21026a(Marker.DASHBOARD_TTI);
        this.ar.m21026a(Marker.DASHBOARD_INIT);
        FriendsNearbyListAdapter friendsNearbyListAdapter = this.bb;
        FriendsNearbyNewDataHolder friendsNearbyNewDataHolder = this.ba;
        if (friendsNearbyListAdapter.f20935e != friendsNearbyNewDataHolder) {
            friendsNearbyListAdapter.f20935e = friendsNearbyNewDataHolder;
            friendsNearbyNewDataHolder.m20878a(new C29711(friendsNearbyListAdapter));
        }
        this.bt = new NearbyFriendsLiveUpdateReceiver(this);
        this.bu = this.bs.a().a(FriendsNearbyMqttPushHandler.a, this.bt).a(FbLocationStatusMonitor.a, new C29572(this)).a();
        this.bu.b();
        this.aA.a(this.bN);
        this.ap.m21705b(this.s.getString("source"));
        this.aB.a(582602945087149L, 0);
    }

    public final View m21873a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2137960608);
        View inflate = layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), 2131626598)).inflate(2130904524, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 963905093, a);
        return inflate;
    }

    public final void m21872I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 664681572);
        this.f20918f.c();
        this.au.f20540c.c(FriendsNearbyTask.f20576j);
        for (FriendsNearbyMoreSectionLoader friendsNearbyMoreSectionLoader : this.aL) {
            friendsNearbyMoreSectionLoader.f20478d.c(FriendsNearbyTask.f20575i);
        }
        this.aL.clear();
        FriendsNearbyDashboardPerfLogger friendsNearbyDashboardPerfLogger = this.ar;
        for (Marker marker : Marker.values()) {
            friendsNearbyDashboardPerfLogger.f20612a.b(marker.markerId, marker.markerName);
        }
        if (this.bu != null) {
            this.bu.c();
        }
        this.aA.b(this.bN);
        this.bx.a();
        super.I();
        LogUtils.f(-1647203495, a);
    }

    public final void m21879d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -472403370);
        super.d(bundle);
        this.bw = this.bv.a(o());
        this.bx.a(this, this.by);
        this.aN = (EditText) e(2131562355);
        this.aN.setText("");
        this.aN.clearComposingText();
        this.aO = e(2131562354);
        this.aP = e(2131562356);
        this.aQ = (BetterButton) e(2131562357);
        this.aR = (RefreshableViewContainerLike) e(2131562358);
        this.aS = (SplitHideableListView) e(2131562359);
        this.aV = (TextView) e(2131562360);
        this.aU = (FriendsNearbyFeatureDisabledView) e(2131562361);
        this.aW = e(2131562362);
        this.aX = (TextView) FindViewUtil.b(this.aW, 2131562363);
        this.aY = (FriendsNearbyErrorScreenView) e(2131562364);
        this.aZ = (FriendsNearbyLocationDisabledView) e(2131562365);
        this.bf = true;
        this.be = 0;
        m21869n(bundle);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1708664104, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1083569428);
        super.mY_();
        this.bw = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 463910776, a);
    }

    public final void m21870G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2063349027);
        super.G();
        FriendsNearbyDashboardAnalyticsLogger friendsNearbyDashboardAnalyticsLogger = this.ap;
        long j = friendsNearbyDashboardAnalyticsLogger.f20818c;
        long now = friendsNearbyDashboardAnalyticsLogger.f20817b.now();
        if (now == 0 || now - j > 300000) {
            friendsNearbyDashboardAnalyticsLogger.f20818c = now;
            friendsNearbyDashboardAnalyticsLogger.f20819d = ImpressionType.UNKNOWN;
            friendsNearbyDashboardAnalyticsLogger.f20820e = false;
            friendsNearbyDashboardAnalyticsLogger.f20821f = false;
        }
        aV();
        if (this.bf || this.aq.a() - this.be > 300000) {
            this.ba.m20876a();
            m21859a(this.bz);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1269562111, a);
    }

    public final void m21871H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1962103177);
        super.H();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.a_("");
            hasTitleBar.kg_();
        }
        aE(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2106369758, a);
    }

    public final void m21880e(Bundle bundle) {
        super.e(bundle);
        bundle.putBoolean("redirected_to_nux", this.bg);
    }

    public final boolean O_() {
        if (bd()) {
            this.aN.setText("");
            this.aN.clearComposingText();
            this.aN.clearFocus();
            this.aQ.setVisibility(0);
            aG(this);
            return true;
        } else if (this.aM == null) {
            return false;
        } else {
            boolean z;
            FriendsNearbyMapFragment friendsNearbyMapFragment = this.aM;
            if (friendsNearbyMapFragment.aw == MapState.EXPANDED) {
                friendsNearbyMapFragment.f20978h.m21725s();
                FriendsNearbyMapFragment.m21942a(friendsNearbyMapFragment, MapState.HEADER, null);
                z = true;
            } else {
                z = false;
            }
            return z;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.bL == MapState.HEADER) {
            this.bh = true;
        }
    }

    public final void aq() {
        ba();
        this.aM = null;
        this.bc = false;
        this.ba.m20884a(true);
    }

    public final VisibleArea m21874a(MapState mapState) {
        VisibleArea visibleArea;
        long h;
        switch (mapState) {
            case HEADER:
                int i;
                h = this.aS.h();
                this.bn.setDuration(h).start();
                this.bl.setDuration(h).start();
                int dimensionPixelSize = jW_().getDimensionPixelSize(2131434233);
                int height = this.aN.getHeight();
                StickyHeader stickyHeader = this.aS.r;
                if (stickyHeader.c == null) {
                    i = 0;
                } else {
                    i = stickyHeader.c.e(stickyHeader.a.getFirstVisiblePosition());
                }
                visibleArea = new VisibleArea(0, height + i, 0, this.aS.getHeight() - dimensionPixelSize, h);
                break;
            case EXPANDED:
                h = this.aS.g();
                this.bm.setDuration(h).start();
                this.bk.setDuration(h).start();
                visibleArea = new VisibleArea(0, 0, 0, 0, h);
                break;
            default:
                throw new IllegalArgumentException("Invalid map state: " + mapState);
        }
        this.bL = mapState;
        aV();
        return visibleArea;
    }

    public final void m21876a(FriendsNearbySection friendsNearbySection, FriendsNearbyMoreRowView friendsNearbyMoreRowView) {
        final String g = friendsNearbySection.mo922g();
        this.ap.m21707c(g);
        if (this.ax.a(ExperimentsForFriendsNearbyModule.f20447a, false)) {
            friendsNearbyMoreRowView.m21976a();
            friendsNearbySection.a(true);
            this.ba.m20881a(g, friendsNearbySection);
            friendsNearbyMoreRowView.m21977b();
            return;
        }
        final FriendsNearbyMoreSectionLoader a = this.av.m20860a(g, friendsNearbySection.f20520b, this.f20918f);
        this.aL.add(a);
        friendsNearbyMoreRowView.m21976a();
        ImmutableSet d = this.ba.m20890d();
        final FriendsNearbySection friendsNearbySection2 = friendsNearbySection;
        final FriendsNearbyMoreRowView friendsNearbyMoreRowView2 = friendsNearbyMoreRowView;
        C29583 c29583 = new Object(this) {
            public final /* synthetic */ FriendsNearbyFragment f20883e;

            public final void m21760a(ImmutableList<FriendsNearbyRow> immutableList) {
                friendsNearbySection2.mo921a(immutableList);
                friendsNearbySection2.f20520b = null;
                this.f20883e.ba.m20881a(g, friendsNearbySection2);
                friendsNearbyMoreRowView2.m21977b();
                this.f20883e.aL.remove(a);
            }
        };
        if (c29583 != null) {
            GraphQlQueryString friendsNearbyMoreInSectionQueryString = new FriendsNearbyMoreInSectionQueryString();
            friendsNearbyMoreInSectionQueryString.a("set_items_cursor", a.f20477c).a("pic_size", a.f20480f).a("set_items_fetch_count", "1000").a("more_section_id", a.f20476b);
            a.f20478d.a(FriendsNearbyTask.f20575i, a.f20479e.a(GraphQLRequest.a(friendsNearbyMoreInSectionQueryString)), new C29241(a, c29583, d));
        }
    }

    public final void mo945a(FriendsNearbyRow friendsNearbyRow) {
        String a = friendsNearbyRow.mo908a();
        String e = friendsNearbyRow.mo916e();
        Preconditions.checkNotNull(e);
        if (e.startsWith("check_in")) {
            a = e.split(":")[1];
            PermalinkStoryIdParams.Builder builder = new PermalinkStoryIdParams.Builder();
            builder.a = a;
            this.am.a(this.aI.a(builder.a()), getContext());
        } else if ((friendsNearbyRow instanceof FriendsNearbySelfRow) || !this.at.f20452a.a("friends_nearby")) {
            this.ap.m21704a(a, false);
            Intent intent = new Intent();
            intent.setData(Uri.parse(StringFormatUtil.a(FBLinks.aX, new Object[]{a})));
            this.am.a(intent, ao());
        } else {
            String str;
            ImmutableList of;
            FriendsNearbySection d = this.ba.m20889d(friendsNearbyRow.mo920i());
            if (d == null) {
                str = "";
            } else {
                str = d.a();
            }
            e = str;
            d = this.ba.m20889d(friendsNearbyRow.mo920i());
            if (d == null) {
                String a2 = friendsNearbyRow.mo908a();
                getContext();
                of = ImmutableList.of(new SimpleUser(a2, friendsNearbyRow.mo913c(), m21850a(friendsNearbyRow.mo911b())));
            } else {
                ImmutableList.Builder builder2 = new ImmutableList.Builder();
                for (FriendsNearbyRow friendsNearbyRow2 : d.e()) {
                    String a3 = friendsNearbyRow2.mo908a();
                    getContext();
                    builder2.c(new SimpleUser(a3, friendsNearbyRow2.mo913c(), m21850a(friendsNearbyRow2.mo911b())));
                }
                of = builder2.b();
            }
            m21863a(a, e, of);
        }
    }

    public static String m21850a(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }

    public final void mo946a(FriendsNearbyRowView friendsNearbyRowView, FriendsNearbyRow friendsNearbyRow) {
        String a = friendsNearbyRow.mo908a();
        if (friendsNearbyRow instanceof FriendsNearbySelfRow) {
            this.ap.m21706c();
            this.aH.m21697a(friendsNearbyRowView.a, s(), this.ap.f20818c, this.br, this.bd);
        } else if ((friendsNearbyRow instanceof FriendsNearbyNewListRow) || (friendsNearbyRow instanceof FriendsNearbyOutgoingPingRow)) {
            this.ap.m21703a(a);
            if (this.aJ.a(999, false)) {
                String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.R, a);
                Intent intent = new Intent();
                intent.setData(Uri.parse(formatStrLocaleSafe));
                intent.addFlags(268435456);
                this.am.a(intent, getContext());
                return;
            }
            m21862a(a, friendsNearbyRow.mo920i());
        } else if (friendsNearbyRow instanceof FriendsNearbyInviteRow) {
            FriendsNearbyInviteRow friendsNearbyInviteRow = (FriendsNearbyInviteRow) friendsNearbyRow;
            InviteState inviteState = friendsNearbyInviteRow.f20471e;
            if (inviteState == InviteState.NOT_INVITED) {
                this.ap.m21715i();
                m21861a(a, friendsNearbyRowView, friendsNearbyInviteRow);
            } else if (inviteState == InviteState.INVITED) {
                this.ap.m21716j();
                m21867b(a, friendsNearbyRowView, friendsNearbyInviteRow);
            }
        } else {
            throw new IllegalArgumentException("Unknown action button behavior for " + friendsNearbyRow.getClass().getSimpleName());
        }
    }

    private void m21861a(String str, final FriendsNearbyRowView friendsNearbyRowView, final FriendsNearbyInviteRow friendsNearbyInviteRow) {
        friendsNearbyInviteRow.f20471e = InviteState.INVITING;
        friendsNearbyRowView.m21987g();
        this.f20918f.a((FriendsNearbyTask) FriendsNearbyTask.f20579m.a("_" + str), BlueServiceOperationFactoryDetour.a(this.f20920h, "send_invite", FriendsNearbyServiceHandler.m21686a("friendsNearbyInviteParams", new FriendsNearbyInviteParams(str)), -541693483).a(), new AbstractDisposableFutureCallback<OperationResult>(this) {
            final /* synthetic */ FriendsNearbyFragment f20886c;

            protected final void m21761a(Object obj) {
                friendsNearbyInviteRow.f20471e = InviteState.INVITED;
                friendsNearbyRowView.m21987g();
            }

            protected final void m21762a(Throwable th) {
                friendsNearbyInviteRow.f20471e = InviteState.NOT_INVITED;
                friendsNearbyRowView.m21987g();
                this.f20886c.f20921i.b(new ToastBuilder(this.f20886c.a(2131242013, new Object[]{friendsNearbyInviteRow.f20470d})));
            }
        });
    }

    private void m21867b(String str, final FriendsNearbyRowView friendsNearbyRowView, final FriendsNearbyInviteRow friendsNearbyInviteRow) {
        friendsNearbyInviteRow.f20471e = InviteState.UNINVITING;
        friendsNearbyRowView.m21987g();
        this.f20918f.a((FriendsNearbyTask) FriendsNearbyTask.f20580n.a("_" + str), BlueServiceOperationFactoryDetour.a(this.f20920h, "delete_invite", FriendsNearbyServiceHandler.m21686a("friendsNearbyDeleteInviteParams", new FriendsNearbyDeleteInviteParams(str)), 731061721).a(), new AbstractDisposableFutureCallback<OperationResult>(this) {
            final /* synthetic */ FriendsNearbyFragment f20889c;

            protected final void m21763a(Object obj) {
                friendsNearbyInviteRow.f20471e = InviteState.NOT_INVITED;
                friendsNearbyRowView.m21987g();
            }

            protected final void m21764a(Throwable th) {
                friendsNearbyInviteRow.f20471e = InviteState.INVITED;
                friendsNearbyRowView.m21987g();
                this.f20889c.f20921i.b(new ToastBuilder(this.f20889c.a(2131242014, new Object[]{friendsNearbyInviteRow.f20470d})));
            }
        });
    }

    public static void m21864b(FriendsNearbyFragment friendsNearbyFragment, FriendsNearbyFragmentState friendsNearbyFragmentState) {
        if (friendsNearbyFragment.y) {
            friendsNearbyFragment.m21859a(friendsNearbyFragmentState);
            return;
        }
        friendsNearbyFragment.ar.m21028c(Marker.DASHBOARD_TTI);
        friendsNearbyFragment.bf = true;
    }

    public static void az(FriendsNearbyFragment friendsNearbyFragment) {
        friendsNearbyFragment.aS.setEmptyView(friendsNearbyFragment.aV);
    }

    private void m21869n(Bundle bundle) {
        this.aR.setOnRefreshListener(new C29616(this));
        aD();
        this.aS.setStickyHeaderEnabled(true);
        final View inflate = b(bundle).inflate(2130904528, this.aS, false);
        inflate.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FriendsNearbyFragment f20892b;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                MotionEvent obtain;
                if (inflate.getTop() != 0) {
                    obtain = MotionEvent.obtain(motionEvent);
                    obtain.setLocation(motionEvent.getX(), motionEvent.getY() + ((float) inflate.getTop()));
                } else {
                    obtain = motionEvent;
                }
                if (this.f20892b.aM != null) {
                    this.f20892b.aM.T.dispatchTouchEvent(obtain);
                }
                if (obtain != motionEvent) {
                    obtain.recycle();
                }
                return true;
            }
        });
        this.aS.setExpandableHeader(inflate);
        this.aT = (ViewGroup) b(bundle).inflate(2130904529, this.aS, false);
        this.aS.addFooterView(this.aT, null, false);
        inflate = b(bundle).inflate(2130904527, this.aS, false);
        this.aS.addFooterView(inflate, null, false);
        this.aS.setAdapter(this.bb);
        this.aS.setBroadcastInteractionChanges(true);
        this.aS.h = new OnSplitHeightChangedListener(this) {
            final /* synthetic */ FriendsNearbyFragment f20894b;

            public final void m21767a(int i) {
                int i2 = 0;
                if (this.f20894b.bh || this.f20894b.bi != this.f20894b.aS.getHeight()) {
                    if (this.f20894b.aM != null) {
                        this.f20894b.aM.m21957a(this.f20894b.bL);
                    }
                    this.f20894b.bh = false;
                }
                this.f20894b.bi = this.f20894b.aS.getHeight();
                if (this.f20894b.aS.getChildCount() >= 2 && this.f20894b.aS.isAtBottom()) {
                    i2 = this.f20894b.aS.getHeight() - this.f20894b.aS.getChildAt(this.f20894b.aS.getChildCount() - 2).getBottom();
                }
                LayoutParams layoutParams = inflate.getLayoutParams();
                if (i2 != layoutParams.height) {
                    layoutParams.height = i2;
                    inflate.requestLayout();
                }
            }

            public final void m21766a() {
            }
        };
        this.aS.a(new C29649(this));
        this.aS.a(new OnDrawListener(this) {
            final /* synthetic */ FriendsNearbyFragment f20839a;

            {
                this.f20839a = r1;
            }

            public final boolean gD_() {
                if (!this.f20839a.bj) {
                    return false;
                }
                this.f20839a.ar.m21027b(Marker.DASHBOARD_VIEW_RENDER);
                this.f20839a.ar.m21027b(Marker.DASHBOARD_TTI);
                return true;
            }
        });
        this.aY.a(new OnDispatchDrawListener(this) {
            final /* synthetic */ FriendsNearbyFragment f20840a;

            {
                this.f20840a = r1;
            }

            public final boolean m21739a() {
                if (!this.f20840a.bj) {
                    return false;
                }
                this.f20840a.ar.m21027b(Marker.DASHBOARD_VIEW_RENDER);
                this.f20840a.ar.m21027b(Marker.DASHBOARD_TTI);
                return true;
            }
        });
        this.aO.post(new Runnable(this) {
            final /* synthetic */ FriendsNearbyFragment f20841a;

            {
                this.f20841a = r1;
            }

            public void run() {
                FriendsNearbyFragment friendsNearbyFragment = this.f20841a;
                int height = friendsNearbyFragment.aO.getHeight();
                friendsNearbyFragment.bl = ObjectAnimator.ofFloat(friendsNearbyFragment.aO, "translationY", new float[]{(float) (-height), 0.0f});
                friendsNearbyFragment.bl.addListener(new BaseAnimatorListener(friendsNearbyFragment) {
                    final /* synthetic */ FriendsNearbyFragment f20846a;

                    {
                        this.f20846a = r1;
                    }

                    public void onAnimationStart(Animator animator) {
                        this.f20846a.aO.setVisibility(0);
                    }
                });
                friendsNearbyFragment.bk = ObjectAnimator.ofFloat(friendsNearbyFragment.aO, "translationY", new float[]{0.0f, (float) (-height)});
                friendsNearbyFragment.bk.addListener(new BaseAnimatorListener(friendsNearbyFragment) {
                    final /* synthetic */ FriendsNearbyFragment f20847a;

                    {
                        this.f20847a = r1;
                    }

                    public void onAnimationEnd(Animator animator) {
                        this.f20847a.aO.setVisibility(4);
                    }
                });
            }
        });
        this.aQ.setCompoundDrawablesWithIntrinsicBounds(this.aD.a(2130839877, jW_().getColor(2131361917)), null, null, null);
        this.aQ.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ FriendsNearbyFragment f20842a;

            {
                this.f20842a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 224888284);
                this.f20842a.ap.m21717k();
                FriendsNearbyFragment.aK(this.f20842a);
                Logger.a(2, EntryType.UI_INPUT_END, -1568079515, a);
            }
        });
        this.aN.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ FriendsNearbyFragment f20843a;

            {
                this.f20843a = r1;
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                this.f20843a.ap.m21719m();
                FriendsNearbyFragment.m21857a(this.f20843a, (CharSequence) editable);
            }
        });
        this.aN.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ FriendsNearbyFragment f20844a;

            {
                this.f20844a = r1;
            }

            public void onFocusChange(View view, boolean z) {
                if (z) {
                    FriendsNearbyFragment friendsNearbyFragment = this.f20844a;
                    friendsNearbyFragment.ap.m21718l();
                    friendsNearbyFragment.aQ.setVisibility(8);
                    FriendsNearbyFragment.aG(friendsNearbyFragment);
                    friendsNearbyFragment.aS.setSelection(0);
                    FriendsNearbyFragment.m21857a(this.f20844a, this.f20844a.aN.getText());
                }
            }
        });
        this.ba.m20878a(new FriendsNearbyNewDataHolder.Listener(this) {
            final /* synthetic */ FriendsNearbyFragment f20845a;

            {
                this.f20845a = r1;
            }

            public final void mo924a() {
            }

            public final void mo926b() {
                if (this.f20845a.ba.m20895i()) {
                    FriendsNearbyFragment.az(this.f20845a);
                    this.f20845a.aV.setText(this.f20845a.a(2131242015, new Object[]{this.f20845a.aN.getText()}));
                }
            }

            public final void mo925a(String str) {
            }
        });
        aG(this);
    }

    public static void m21857a(FriendsNearbyFragment friendsNearbyFragment, CharSequence charSequence) {
        CharSequence charSequence2;
        if (StringUtil.c(charSequence)) {
            friendsNearbyFragment.ba.m20879a(FriendsNearbySection.f20519c);
            aQ(friendsNearbyFragment);
        } else {
            friendsNearbyFragment.aP.setVisibility(0);
        }
        FriendsNearbySearchLoader friendsNearbySearchLoader = friendsNearbyFragment.au;
        if (StringUtil.c(charSequence)) {
            charSequence2 = "";
        } else {
            charSequence2 = charSequence.toString();
        }
        ImmutableSet d = friendsNearbyFragment.ba.m20890d();
        AnonymousClass21 anonymousClass21 = friendsNearbyFragment.bO;
        if (!charSequence2.equals(friendsNearbySearchLoader.f20547j)) {
            friendsNearbySearchLoader.f20546i = null;
            friendsNearbySearchLoader.f20540c.c();
            friendsNearbySearchLoader.f20547j = charSequence2;
            friendsNearbySearchLoader.f20545h = PageState.INITIAL;
            friendsNearbySearchLoader.f20548k = ImmutableList.builder();
            friendsNearbySearchLoader.f20544g = d;
            if (!StringUtil.c(charSequence2)) {
                FriendsNearbySearchQueryString d2 = FriendsNearbyNewQuery.m21170d();
                d2.a("searchText", friendsNearbySearchLoader.f20547j).a("pic_size", friendsNearbySearchLoader.f20543f).a("order", FriendsNearbySearchLoader.f20539b).a("count", "20");
                friendsNearbySearchLoader.f20540c.a(FriendsNearbyTask.f20576j, friendsNearbySearchLoader.f20541d.a(GraphQLRequest.a(d2)), new C29251(friendsNearbySearchLoader, anonymousClass21));
            }
        }
    }

    private void aD() {
        final View c = this.aR.c();
        this.bn = ObjectAnimator.ofFloat(c, "alpha", new float[]{0.0f, 1.0f});
        this.bn.addListener(new BaseAnimatorListener(this) {
            final /* synthetic */ FriendsNearbyFragment f20849b;

            public void onAnimationStart(Animator animator) {
                c.setVisibility(0);
            }
        });
        this.bm = ObjectAnimator.ofFloat(c, "alpha", new float[]{1.0f, 0.0f});
        this.bm.addListener(new BaseAnimatorListener(this) {
            final /* synthetic */ FriendsNearbyFragment f20852b;

            public void onAnimationEnd(Animator animator) {
                c.setVisibility(8);
            }
        });
    }

    public static void aE(FriendsNearbyFragment friendsNearbyFragment) {
        friendsNearbyFragment.as.hideSoftInputFromWindow(friendsNearbyFragment.T.getWindowToken(), 0);
    }

    private void m21859a(FriendsNearbyFragmentState friendsNearbyFragmentState) {
        this.bM = friendsNearbyFragmentState;
        this.bM.mo936e();
    }

    public static boolean aF(FriendsNearbyFragment friendsNearbyFragment) {
        if (!friendsNearbyFragment.bc || friendsNearbyFragment.bd() || friendsNearbyFragment.ba == null || friendsNearbyFragment.ba.m20892e() == null || friendsNearbyFragment.ba.m20892e().e() == null || friendsNearbyFragment.ba.m20892e().e().isEmpty()) {
            return false;
        }
        return true;
    }

    public static void aG(FriendsNearbyFragment friendsNearbyFragment) {
        if (!aF(friendsNearbyFragment)) {
            friendsNearbyFragment.ba();
        } else if (friendsNearbyFragment.aM != null) {
            friendsNearbyFragment.aS.j();
            FriendsNearbyMapFragment friendsNearbyMapFragment = friendsNearbyFragment.aM;
            FriendsNearbyNewDataHolder friendsNearbyNewDataHolder = friendsNearbyFragment.ba;
            if (friendsNearbyMapFragment.aC != friendsNearbyNewDataHolder) {
                friendsNearbyMapFragment.aC = friendsNearbyNewDataHolder;
                friendsNearbyNewDataHolder.m20878a(new C29731(friendsNearbyMapFragment));
            }
        }
    }

    public static void m21856a(FriendsNearbyFragment friendsNearbyFragment, final FriendsNearbyFragmentState friendsNearbyFragmentState, FbLocationOperationParams fbLocationOperationParams, final Marker marker) {
        ImmutableLocation immutableLocation = null;
        Preconditions.checkNotNull(friendsNearbyFragmentState);
        friendsNearbyFragmentState.mo940n();
        FbLocationOperation fbLocationOperation = (FbLocationOperation) friendsNearbyFragment.az.get();
        friendsNearbyFragment.ar.m21026a(marker);
        fbLocationOperation.a(fbLocationOperationParams, f20914b);
        if (fbLocationOperation.isDone()) {
            Throwable th;
            try {
                immutableLocation = (ImmutableLocation) FutureUtils.b(fbLocationOperation);
                th = null;
            } catch (ExecutionException e) {
                th = e.getCause();
            }
            if (immutableLocation == null) {
                m21855a(friendsNearbyFragment, friendsNearbyFragmentState, marker, th);
                return;
            } else {
                m21854a(friendsNearbyFragment, friendsNearbyFragmentState, marker, immutableLocation);
                return;
            }
        }
        friendsNearbyFragment.f20918f.a(FriendsNearbyTask.f20574h, fbLocationOperation, new AbstractDisposableFutureCallback<ImmutableLocation>(friendsNearbyFragment) {
            final /* synthetic */ FriendsNearbyFragment f20856c;

            protected final void m21748a(Object obj) {
                FriendsNearbyFragment.m21854a(this.f20856c, friendsNearbyFragmentState, marker, (ImmutableLocation) obj);
            }

            protected final void m21749a(Throwable th) {
                FriendsNearbyFragment.m21855a(this.f20856c, friendsNearbyFragmentState, marker, th);
            }
        });
    }

    public static void m21854a(FriendsNearbyFragment friendsNearbyFragment, FriendsNearbyFragmentState friendsNearbyFragmentState, Marker marker, ImmutableLocation immutableLocation) {
        friendsNearbyFragment.ar.m21027b(marker);
        friendsNearbyFragment.bd = Optional.of(immutableLocation);
        friendsNearbyFragmentState.mo941o();
    }

    public static void m21855a(FriendsNearbyFragment friendsNearbyFragment, FriendsNearbyFragmentState friendsNearbyFragmentState, Marker marker, Throwable th) {
        friendsNearbyFragment.ar.m21028c(marker);
        BLog.b(f20913a, "Failed to get location", th);
        friendsNearbyFragment.bd = Absent.INSTANCE;
        friendsNearbyFragmentState.mo941o();
    }

    public static void m21853a(FriendsNearbyFragment friendsNearbyFragment, final DataLoadListener dataLoadListener) {
        ImmutableList immutableList;
        dataLoadListener.mo929g();
        friendsNearbyFragment.ar.m21026a(Marker.DASHBOARD_FETCH_DATA1);
        CharSequence string = friendsNearbyFragment.s.getString("fbid");
        if (string == null) {
            immutableList = ListHelper.a;
        } else if ("[]".equals(string)) {
            immutableList = ListHelper.a;
        } else {
            immutableList = ImmutableList.copyOf(Splitter.on(',').trimResults().omitEmptyStrings().split(string));
        }
        friendsNearbyFragment.aw.m20973a(immutableList, friendsNearbyFragment.f20919g.a(), friendsNearbyFragment.bd, new Object(friendsNearbyFragment) {
            public final /* synthetic */ FriendsNearbyFragment f20858b;
            public final FriendsNearbyFragmentState f20859c = this.f20858b.bM;
            public boolean f20860d = false;

            public final void m21752a(DashboardModel dashboardModel) {
                this.f20858b.ba.m20877a(dashboardModel);
                Optional optional = dashboardModel.f20460a;
                if (optional.isPresent()) {
                    this.f20858b.bp = (FriendsNearbyViewerInfoModel) optional.get();
                    this.f20858b.bq = this.f20858b.bp.m21522d().b();
                }
                m21751b(dashboardModel.f20463d);
                m21750a(dashboardModel.f20461b, dashboardModel.f20462c);
            }

            public final void m21753b(DashboardModel dashboardModel) {
                this.f20858b.ba.m20886b(dashboardModel);
                m21751b(dashboardModel.f20463d);
                m21750a(dashboardModel.f20461b, dashboardModel.f20462c);
            }

            private void m21750a(Optional<FriendsNearbyLocationSharingFields> optional, Optional<PrivacySettings> optional2) {
                if (optional.isPresent()) {
                    boolean z;
                    Object obj;
                    FriendsNearbyLocationSharingFieldsModel friendsNearbyLocationSharingFieldsModel = (FriendsNearbyLocationSharingFieldsModel) optional.get();
                    this.f20858b.br = friendsNearbyLocationSharingFieldsModel.m21323g();
                    this.f20858b.an = new UpsellModel(this.f20858b.ao, friendsNearbyLocationSharingFieldsModel, (PrivacySettingsModel) optional2.orNull());
                    FriendsNearbyDataUtil friendsNearbyDataUtil = this.f20858b.ao;
                    if (friendsNearbyLocationSharingFieldsModel == null || !friendsNearbyLocationSharingFieldsModel.m21322d()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    boolean z2 = z;
                    friendsNearbyDataUtil = this.f20858b.ao;
                    if (friendsNearbyLocationSharingFieldsModel == null || !friendsNearbyLocationSharingFieldsModel.m21321c()) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj == null || !z2) {
                        FriendsNearbyDataUtil friendsNearbyDataUtil2 = this.f20858b.ao;
                        if (friendsNearbyLocationSharingFieldsModel == null || (!friendsNearbyLocationSharingFieldsModel.no_() && (!friendsNearbyLocationSharingFieldsModel.nn_() || friendsNearbyDataUtil2.m20828f(friendsNearbyLocationSharingFieldsModel) <= 0))) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj != null) {
                            dataLoadListener.mo931i();
                        } else {
                            dataLoadListener.mo933k();
                        }
                    } else {
                        State a = this.f20858b.f20919g.a();
                        if (a == State.OKAY) {
                            this.f20860d = true;
                        } else if (a == State.PERMISSION_DENIED && FbLocationStatus.b(a)) {
                            dataLoadListener.mo927a();
                        } else {
                            dataLoadListener.mo928b();
                        }
                    }
                    FriendsNearbyFragment friendsNearbyFragment = this.f20858b;
                    Intent intent = new Intent(friendsNearbyFragment.aC.a("BACKGROUND_LOCATION_REPORTING_SETTINGS_REQUEST_REFRESH_ACTION"));
                    intent.putExtra("expected_location_history_setting", z2);
                    friendsNearbyFragment.getContext().sendBroadcast(intent);
                }
            }

            private void m21751b(Optional<FriendsNearbyContactsTab> optional) {
                if (optional.isPresent()) {
                    String str;
                    FriendsNearbyFragment friendsNearbyFragment = this.f20858b;
                    FriendsNearbyDataUtil friendsNearbyDataUtil = this.f20858b.ao;
                    ContactsTabsModel a = ((FriendsNearbyContactsTabModel) optional.get()).m21186a();
                    if (a == null) {
                        str = null;
                    } else if (a.m21181a().isEmpty()) {
                        str = null;
                    } else {
                        FriendsNearbySectionsPageFieldsModel a2 = ((NodesModel) a.m21181a().get(0)).m21176a();
                        if (a2 == null) {
                            str = null;
                        } else {
                            DefaultPageInfoFields b = a2.m21510b();
                            str = b == null ? null : b.a();
                        }
                    }
                    friendsNearbyFragment.bo = str;
                }
            }
        });
    }

    public static void m21858a(FriendsNearbyFragment friendsNearbyFragment, boolean z) {
        Intent intent = new Intent();
        intent.setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe(FBLinks.cT, "dashboard:" + friendsNearbyFragment.s.getString("source"), Boolean.valueOf(false), Boolean.valueOf(z))));
        friendsNearbyFragment.am.a(intent, friendsNearbyFragment.getContext());
    }

    public static void aK(FriendsNearbyFragment friendsNearbyFragment) {
        friendsNearbyFragment.bf = true;
        Intent intent = new Intent();
        intent.setData(Uri.parse(StringFormatUtil.a(FBLinks.cS, new Object[]{"-1", "-1"})));
        friendsNearbyFragment.am.a(intent, friendsNearbyFragment.getContext());
    }

    private void m21863a(String str, String str2, ImmutableList<SimpleUser> immutableList) {
        this.ap.m21704a(str, true);
        Activity ao = ao();
        if (ao != null) {
            FriendsNearbyEntityCardsLauncher friendsNearbyEntityCardsLauncher = this.at;
            ImmutableList a = FriendsNearbyEntityCardsLauncher.m20815a((ImmutableList) immutableList);
            EntityRange a2 = EntityCardsIntentHelper.a(a, str);
            List a3 = Lists.a();
            for (int i = a2.d; i <= a2.e; i++) {
                a3.add(FriendsNearbyEntityCardsLauncher.m20813a((SimpleUser) immutableList.get(i)));
            }
            Bundle bundle = new Bundle();
            FlatBufferModelHelper.a(bundle, "preliminary_entities", a3);
            bundle.putString("extra_friending_location_name", FriendingLocation.NEARBY_FRIENDS.name());
            bundle.putString("extra_friend_request_make_ref", FriendRequestMakeRef.NEARBY_FRIENDS.name());
            friendsNearbyEntityCardsLauncher.f20452a.a(ao, "friends_nearby", Absent.INSTANCE, a, str, str2, bundle);
        }
    }

    private void m21862a(final String str, String str2) {
        User c = this.ba.m20888c(str);
        if (c == null) {
            this.al.a("friends_nearby_ping_failed", "target user " + str + " information cannot be fetched in section " + str2);
            return;
        }
        LocationPingDialog a;
        if (this.ba.f20506x) {
            LocationPingParams locationPingParams;
            FriendsNearbyNewDataHolder friendsNearbyNewDataHolder = this.ba;
            friendsNearbyNewDataHolder.f20486d.a();
            FriendsNearbyPingsDataHolder friendsNearbyPingsDataHolder = friendsNearbyNewDataHolder.f20494l;
            if (friendsNearbyPingsDataHolder.f20590b.containsKey(str)) {
                locationPingParams = ((FriendsNearbyOutgoingPingRow) friendsNearbyPingsDataHolder.f20590b.get(str)).f20527d;
            } else {
                locationPingParams = null;
            }
            a = LocationPingDialogFragment.m21122a(c, locationPingParams, false);
        } else {
            a = LocationPingDialogFragment.m21122a(c, null, true);
        }
        a.mo923a(new Object(this) {
            public final /* synthetic */ FriendsNearbyFragment f20869b;
        });
        a.a(s(), "ping_dialog");
    }

    public static void m21868c(FriendsNearbyFragment friendsNearbyFragment, String str) {
        int i = 0;
        if (friendsNearbyFragment.bL == MapState.EXPANDED) {
            HasTitleBar hasTitleBar = (HasTitleBar) friendsNearbyFragment.a(HasTitleBar.class);
            if (hasTitleBar != null) {
                hasTitleBar.y_(2131241996);
                TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
                a.i = 2130840483;
                hasTitleBar.a(a.a());
            }
        }
        friendsNearbyFragment.aX.setText(str);
        boolean isEmpty = friendsNearbyFragment.bb.isEmpty();
        friendsNearbyFragment.aW.setVisibility(isEmpty ? 0 : 8);
        RefreshableViewContainerLike refreshableViewContainerLike = friendsNearbyFragment.aR;
        if (isEmpty) {
            i = 4;
        }
        refreshableViewContainerLike.setHeaderVisibility(i);
        if (isEmpty) {
            friendsNearbyFragment.aR.d();
        } else {
            friendsNearbyFragment.aR.e();
        }
    }

    public static void aM(FriendsNearbyFragment friendsNearbyFragment) {
        friendsNearbyFragment.aV();
        friendsNearbyFragment.aW.setVisibility(8);
        friendsNearbyFragment.aR.f();
        friendsNearbyFragment.aR.setHeaderVisibility(0);
    }

    public static void aN(FriendsNearbyFragment friendsNearbyFragment) {
        for (int i = 0; i < friendsNearbyFragment.aT.getChildCount(); i++) {
            friendsNearbyFragment.aT.getChildAt(i).setVisibility(0);
        }
    }

    public static void aO(FriendsNearbyFragment friendsNearbyFragment) {
        for (int i = 0; i < friendsNearbyFragment.aT.getChildCount(); i++) {
            friendsNearbyFragment.aT.getChildAt(i).setVisibility(8);
        }
    }

    public static void aQ(FriendsNearbyFragment friendsNearbyFragment) {
        friendsNearbyFragment.aP.setVisibility(8);
    }

    public static void m21852a(FriendsNearbyFragment friendsNearbyFragment, int i, int i2, int i3) {
        friendsNearbyFragment.aY.setVisibility(0);
        friendsNearbyFragment.aY.setTitle(i);
        friendsNearbyFragment.aY.setSubtitle(i2);
        friendsNearbyFragment.aY.m21731a(i3, new View.OnClickListener(friendsNearbyFragment) {
            final /* synthetic */ FriendsNearbyFragment f20870a;

            {
                this.f20870a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1841102960);
                if ((this.f20870a.bM instanceof DataLoadFailedState) || (this.f20870a.bM instanceof NewDataLoad1SucceededState) || (this.f20870a.bM instanceof NewDataLoad2SucceededState)) {
                    this.f20870a.bM.mo937f();
                } else {
                    this.f20870a.al.a("friends_nearby_error_button_handle_failed", "error button is tapped in abnormal fragment state: " + this.f20870a.bM.getClass().toString());
                }
                LogUtils.a(-636327370, a);
            }
        });
    }

    public static void aR(FriendsNearbyFragment friendsNearbyFragment) {
        friendsNearbyFragment.aY.setVisibility(8);
    }

    public static void m21865b(FriendsNearbyFragment friendsNearbyFragment, CharSequence charSequence) {
        friendsNearbyFragment.aZ.m21925a(friendsNearbyFragment.an.f20586c, friendsNearbyFragment.an.f20585b);
        friendsNearbyFragment.aZ.m21927b(charSequence, new View.OnClickListener(friendsNearbyFragment) {
            final /* synthetic */ FriendsNearbyFragment f20872a;

            {
                this.f20872a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1880609260);
                this.f20872a.bM.mo938l();
                Logger.a(2, EntryType.UI_INPUT_END, 2051709179, a);
            }
        });
        friendsNearbyFragment.aZ.m21926a(friendsNearbyFragment.b(2131242000), new View.OnClickListener(friendsNearbyFragment) {
            final /* synthetic */ FriendsNearbyFragment f20873a;

            {
                this.f20873a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 949761471);
                this.f20873a.bM.mo939m();
                Logger.a(2, EntryType.UI_INPUT_END, 1376109021, a);
            }
        });
        friendsNearbyFragment.aZ.setVisibility(0);
    }

    public static void aS(FriendsNearbyFragment friendsNearbyFragment) {
        friendsNearbyFragment.aZ.setVisibility(8);
    }

    public static void m21866b(FriendsNearbyFragment friendsNearbyFragment, boolean z) {
        ImmutableList immutableList;
        CharSequence charSequence = null;
        friendsNearbyFragment.aU.m21736a(friendsNearbyFragment.an.f20586c, friendsNearbyFragment.an.f20585b);
        FriendsNearbyFeatureDisabledView friendsNearbyFeatureDisabledView = friendsNearbyFragment.aU;
        if (z) {
            immutableList = null;
        } else {
            immutableList = friendsNearbyFragment.an.f20588e;
        }
        friendsNearbyFeatureDisabledView.setPrivacyPicker(immutableList);
        FriendsNearbyFeatureDisabledView friendsNearbyFeatureDisabledView2 = friendsNearbyFragment.aU;
        if (!z) {
            charSequence = friendsNearbyFragment.b(2131242000);
        }
        friendsNearbyFeatureDisabledView2.m21737a(charSequence, new View.OnClickListener(friendsNearbyFragment) {
            final /* synthetic */ FriendsNearbyFragment f20874a;

            {
                this.f20874a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -338643604);
                this.f20874a.bM.mo944r();
                Logger.a(2, EntryType.UI_INPUT_END, -1703841861, a);
            }
        });
        friendsNearbyFragment.aU.m21738b(friendsNearbyFragment.b(z ? 2131230747 : 2131230748), new View.OnClickListener(friendsNearbyFragment) {
            final /* synthetic */ FriendsNearbyFragment f20875a;

            {
                this.f20875a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 456550324);
                this.f20875a.bM.mo942p();
                Logger.a(2, EntryType.UI_INPUT_END, 1028903839, a);
            }
        });
        friendsNearbyFragment.aU.setVisibility(0);
    }

    public static void aT(FriendsNearbyFragment friendsNearbyFragment) {
        friendsNearbyFragment.aU.setVisibility(8);
    }

    public static void aU(FriendsNearbyFragment friendsNearbyFragment) {
        friendsNearbyFragment.ap.m21701a(ImpressionType.INVITE);
        m21852a(friendsNearbyFragment, 2131242016, 2131242017, 2131242018);
    }

    private void aV() {
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131241996);
            String b;
            TitleBarButtonSpec.Builder a;
            TitleBarButtonSpec.Builder builder;
            if (this.bL == MapState.HEADER) {
                b = b(2131241988);
                a = TitleBarButtonSpec.a();
                a.j = b;
                builder = a;
                builder.i = 2130838001;
                hasTitleBar.a(builder.a());
                hasTitleBar.a(new OnToolbarButtonListener(this) {
                    final /* synthetic */ FriendsNearbyFragment f20876a;

                    {
                        this.f20876a = r1;
                    }

                    public final void m21758a(View view, TitleBarButtonSpec titleBarButtonSpec) {
                        this.f20876a.bM.mo934c();
                    }
                });
            } else if (this.bL == MapState.EXPANDED) {
                b = b(2131241989);
                a = TitleBarButtonSpec.a();
                a.j = b;
                builder = a;
                builder.i = 2130840483;
                hasTitleBar.a(builder.a());
                hasTitleBar.a(new OnToolbarButtonListener(this) {
                    final /* synthetic */ FriendsNearbyFragment f20877a;

                    {
                        this.f20877a = r1;
                    }

                    public final void m21759a(View view, TitleBarButtonSpec titleBarButtonSpec) {
                        this.f20877a.ap.m21722p();
                        this.f20877a.bM.mo935d();
                    }
                });
            }
        }
    }

    private void ba() {
        this.aS.i();
    }

    public static void bb(FriendsNearbyFragment friendsNearbyFragment) {
        TracerDetour.a("FriendsNearbyFragment.setupMap", 2095988816);
        try {
            if (friendsNearbyFragment.aM == null) {
                friendsNearbyFragment.aM = friendsNearbyFragment.bc();
                friendsNearbyFragment.aM.m21956a(friendsNearbyFragment);
                friendsNearbyFragment.aM.m21958a((OnClickListener) friendsNearbyFragment);
                friendsNearbyFragment.s().a().b(2131562352, friendsNearbyFragment.aM, "map_fragment").b();
            }
            aG(friendsNearbyFragment);
        } finally {
            TracerDetour.a(1467680164);
        }
    }

    private FriendsNearbyMapFragment bc() {
        Fragment a = s().a("map_fragment");
        if (a == null) {
            return new FriendsNearbyMapFragment();
        }
        return (FriendsNearbyMapFragment) a;
    }

    public final String am_() {
        return "friends_nearby";
    }

    private boolean bd() {
        return this.aN.hasFocus();
    }
}
