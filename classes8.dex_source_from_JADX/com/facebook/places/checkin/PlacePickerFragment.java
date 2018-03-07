package com.facebook.places.checkin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.checkin.abtest.ExperimentsForCheckinAbTestModule;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.invariants.Invariants;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.analytics.ComposerAnalyticsLogger.Events;
import com.facebook.composer.minutiae.protocol.MinutiaeVerbsFetcher;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.crowdsourcing.logging.CrowdEndpoint;
import com.facebook.crowdsourcing.logging.SuggestEditsAnalyticsLogger;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fbui.popover.PopoverMenuWindow.OnMenuItemClickListener;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.fql.FqlHelper;
import com.facebook.fql.FqlHelper.Field;
import com.facebook.fql.FqlHelper.Table;
import com.facebook.funnellogger.FunnelLogger;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.enums.GraphQLCheckinPlaceResultsContext;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.katana.model.GeoRegion;
import com.facebook.ipc.katana.model.GeoRegion.ImplicitLocation;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController.GoogleLocationDialogResult;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController.OnGooglePlayServicesLocationUpsellDialogFinishedListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.places.checkin.adapter.SelectAtTagAdapter;
import com.facebook.places.checkin.adapter.SelectAtTagRowSection;
import com.facebook.places.checkin.analytics.PlacePickerAnalytics;
import com.facebook.places.checkin.analytics.PlacePickerSessionData;
import com.facebook.places.checkin.analytics.PlacesPerformanceLogger;
import com.facebook.places.checkin.ipc.CheckinComposerEntryPoint;
import com.facebook.places.checkin.ipc.PlacePickerConfiguration;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.places.checkin.location.LocationPresenter;
import com.facebook.places.checkin.models.FlagType;
import com.facebook.places.checkin.models.RowType;
import com.facebook.places.checkin.models.SearchResults;
import com.facebook.places.checkin.protocol.FetchNearbyRegionsRunner;
import com.facebook.places.checkin.protocol.FetchNearbyRegionsRunner.1;
import com.facebook.places.checkin.protocol.FlagPlaceMethodRunner;
import com.facebook.places.checkin.protocol.PlacePickerCache;
import com.facebook.places.checkin.protocol.PlacePickerFetchParams;
import com.facebook.places.checkin.protocol.PlacePickerFetcher;
import com.facebook.places.checkin.protocol.PlacePickerFetcher.3;
import com.facebook.places.checkin.protocol.PlacePickerFetcher.View;
import com.facebook.places.checkin.ui.CheckinNiemController;
import com.facebook.places.checkin.ui.CheckinNiemControllerProvider;
import com.facebook.places.checkin.ui.CheckinNiemPerfTestControllerProvider;
import com.facebook.places.checkin.ui.PlacesListContainer;
import com.facebook.places.common.MockDeps;
import com.facebook.places.create.home.HomeActivityEntryFlow;
import com.facebook.places.create.home.HomeActivityIntentBuilder;
import com.facebook.places.create.home.HomeActivityLogger;
import com.facebook.places.create.home.HomeActivityLoggerData;
import com.facebook.places.create.home.HomeCreationActivity;
import com.facebook.places.features.PlacesFeatures;
import com.facebook.places.future.SimpleExecutor;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.places.suggestions.MarkAsDuplicatesActivity;
import com.facebook.places.suggestions.PlaceSuggestionsIntentBuilder;
import com.facebook.places.suggestions.common.CrowdsourcingSource;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.compat.fbrelativelayout.FbRelativeLayout;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.ui.titlebar.Fb4aTitleBar.OnActionButtonClickListener;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.LazyView;
import com.facebook.widget.LazyView.OnInflateRunner;
import com.facebook.widget.OnDispatchDrawListener;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.text.SoftKeyboardStateAwareEditText;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: click_comment_button */
public class PlacePickerFragment extends FbFragment implements TextWatcher, OnItemClickListener, OnItemLongClickListener, OnGooglePlayServicesLocationUpsellDialogFinishedListener, View {
    public static final Class<?> aG = PlacePickerFragment.class;
    @Nullable
    public CheckinPlaceModel f17970a;
    @Inject
    MinutiaeVerbsFetcher aA;
    @Inject
    public GooglePlayServicesLocationUpsellDialogController aB;
    @Inject
    public GlyphColorizer aC;
    @Inject
    public FunnelLoggerImpl aD;
    @Inject
    PerfTestConfig aE;
    @Inject
    public QeAccessor aF;
    public PlacePickerConfiguration aH;
    private ImplicitLocation aI;
    public String aJ = "";
    public PlacesListContainer aK;
    public BetterListView aL;
    public SoftKeyboardStateAwareEditText aM;
    private android.view.View aN;
    public Fb4aTitleBar aO;
    public final Handler aP = new Handler();
    public boolean aQ = false;
    public DialogFragment aR;
    public CheckinNiemController aS;
    public CheckinComposerEntryPoint aT;
    public RefreshAction aU = RefreshAction.NONE;
    public CrowdsourcingEditState aV;
    public FbRelativeLayout aW;
    public LazyView<FbRelativeLayout> aX;
    public final Runnable aY = new C19381(this);
    public final C19392 aZ = new C19392(this);
    @Inject
    Lazy<FlagPlaceMethodRunner> al;
    @Inject
    Toaster am;
    @Inject
    public AnalyticsTagger an;
    @Inject
    PlacesFeatures ao;
    @Inject
    public SimpleExecutor ap;
    @Inject
    public Lazy<PlaceSuggestionsIntentBuilder> aq;
    @Inject
    public HomeActivityLogger ar;
    @Inject
    Product as;
    @Inject
    public PlacesPerformanceLogger at;
    @Inject
    public UriIntentMapper au;
    @Inject
    public PlacePickerFetcher av;
    @Inject
    public SuggestEditsAnalyticsLogger aw;
    @Inject
    @IsWorkBuild
    Boolean ax;
    @Inject
    public CheckinNiemControllerProvider ay;
    @Inject
    public CheckinNiemPerfTestControllerProvider az;
    @Inject
    public SelectAtTagAdapter f17971b;
    @Inject
    public LocationPresenter f17972c;
    @Inject
    public PlacePickerNavController f17973d;
    @Inject
    public SecureContextHelper f17974e;
    @Inject
    ComposerAnalyticsLogger f17975f;
    @Inject
    AbstractFbErrorReporter f17976g;
    @Inject
    public Lazy<FetchNearbyRegionsRunner> f17977h;
    @Inject
    public PlacePickerAnalytics f17978i;

    /* compiled from: click_comment_button */
    class C19381 implements Runnable {
        final /* synthetic */ PlacePickerFragment f17960a;

        C19381(PlacePickerFragment placePickerFragment) {
            this.f17960a = placePickerFragment;
        }

        public void run() {
            PlacePickerFragment.m21917g(this.f17960a, 0);
        }
    }

    /* compiled from: click_comment_button */
    public class C19392 {
        final /* synthetic */ PlacePickerFragment f17961a;

        C19392(PlacePickerFragment placePickerFragment) {
            this.f17961a = placePickerFragment;
        }

        public final void m21899a() {
            if (PlacePickerFragment.aA(this.f17961a) != null) {
                PlacePickerFragment.m21917g(this.f17961a, 8);
                this.f17961a.aL.setSelection(this.f17961a.aL.getHeaderViewsCount() - 1);
            }
        }

        public final void m21900b() {
            if (PlacePickerFragment.aA(this.f17961a) != null) {
                HandlerDetour.b(this.f17961a.aP, this.f17961a.aY, 400, -1578349187);
            }
        }
    }

    /* compiled from: click_comment_button */
    public class C19403 implements FutureCallback<ImmutableList<GeoRegion>> {
        final /* synthetic */ PlacePickerFragment f17962a;

        public C19403(PlacePickerFragment placePickerFragment) {
            this.f17962a = placePickerFragment;
        }

        public void onSuccess(Object obj) {
            PlacePickerFragment.m21907a(this.f17962a, (ImmutableList) obj);
        }

        public void onFailure(Throwable th) {
            BLog.b(PlacePickerFragment.aG, "Error while get nearby regions", th);
        }
    }

    /* compiled from: click_comment_button */
    class C19414 implements OnClickListener {
        final /* synthetic */ PlacePickerFragment f17963a;

        C19414(PlacePickerFragment placePickerFragment) {
            this.f17963a = placePickerFragment;
        }

        public void onClick(android.view.View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 944675193);
            if (this.f17963a.aH.y != null) {
                this.f17963a.f17973d.m21952b(this.f17963a.aH.y);
                Logger.a(2, EntryType.UI_INPUT_END, 669264712, a);
                return;
            }
            this.f17963a.f17973d.m21951b(this.f17963a.aH.a);
            LogUtils.a(-1419984783, a);
        }
    }

    /* compiled from: click_comment_button */
    class C19425 implements OnGlobalLayoutListener {
        final /* synthetic */ PlacePickerFragment f17964a;

        C19425(PlacePickerFragment placePickerFragment) {
            this.f17964a = placePickerFragment;
        }

        public void onGlobalLayout() {
            CustomViewUtils.a(this.f17964a.aW, this);
            this.f17964a.aL.setPadding(0, 0, 0, this.f17964a.aW.getHeight());
        }
    }

    /* compiled from: click_comment_button */
    class C19436 implements OnDispatchDrawListener {
        final /* synthetic */ PlacePickerFragment f17965a;

        C19436(PlacePickerFragment placePickerFragment) {
            this.f17965a = placePickerFragment;
        }

        public final boolean m21901a() {
            if (this.f17965a.mx_()) {
                PlacesPerformanceLogger placesPerformanceLogger = this.f17965a.at;
                placesPerformanceLogger.f.a(this.f17965a.o());
            }
            return true;
        }
    }

    /* compiled from: click_comment_button */
    public class C19457 implements OnInflateRunner {
        final /* synthetic */ PlacePickerFragment f17967a;

        /* compiled from: click_comment_button */
        class C19441 implements OnClickListener {
            final /* synthetic */ C19457 f17966a;

            C19441(C19457 c19457) {
                this.f17966a = c19457;
            }

            public void onClick(android.view.View view) {
                boolean z;
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1467569496);
                PlacePickerAnalytics placePickerAnalytics = this.f17966a.f17967a.f17978i;
                if (this.f17966a.f17967a.aH.a != null) {
                    z = true;
                } else {
                    z = false;
                }
                placePickerAnalytics.b(z);
                KeyboardUtils.a(this.f17966a.f17967a.o());
                this.f17966a.f17967a.aA.a(null);
                PlacePickerNavController placePickerNavController = this.f17966a.f17967a.f17973d;
                Intent intent = new Intent();
                intent.putExtra("extra_xed_location", true);
                if (placePickerNavController.f17980b.l != null) {
                    intent.putExtra("media_id", placePickerNavController.f17980b.l);
                }
                if (placePickerNavController.f17980b.j != null) {
                    intent.putExtra("launcher_type", placePickerNavController.f17980b.j);
                }
                placePickerNavController.f17979a.m21924a(-1, intent);
                LogUtils.a(1056512199, a);
            }
        }

        public C19457(PlacePickerFragment placePickerFragment) {
            this.f17967a = placePickerFragment;
        }

        public final void m21902a(android.view.View view) {
            view.findViewById(2131565969).setOnClickListener(new C19441(this));
        }
    }

    /* compiled from: click_comment_button */
    public class C19468 implements OnClickListener {
        final /* synthetic */ PlacePickerFragment f17968a;

        public C19468(PlacePickerFragment placePickerFragment) {
            this.f17968a = placePickerFragment;
        }

        public void onClick(android.view.View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -876006266);
            this.f17968a.o().onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 186489913, a);
        }
    }

    /* compiled from: click_comment_button */
    public class C19479 implements OnActionButtonClickListener {
        final /* synthetic */ PlacePickerFragment f17969a;

        public C19479(PlacePickerFragment placePickerFragment) {
            this.f17969a = placePickerFragment;
        }

        public final void m21903a(android.view.View view) {
            PlacePickerFragment placePickerFragment = this.f17969a;
            if (placePickerFragment.aV == null) {
                PopoverMenuWindow popoverMenuWindow = new PopoverMenuWindow(placePickerFragment.getContext());
                popoverMenuWindow.b(2131820588);
                popoverMenuWindow.c(view);
                popoverMenuWindow.p = new OnMenuItemClickListener(placePickerFragment) {
                    final /* synthetic */ PlacePickerFragment f17943a;

                    {
                        this.f17943a = r1;
                    }

                    public final boolean m21896a(MenuItem menuItem) {
                        PlacePickerFragment placePickerFragment = this.f17943a;
                        PlacePickerFragment placePickerFragment2 = this.f17943a;
                        PlacePickerFragment.m21905a(placePickerFragment, PlacePickerFragment.m21916e(menuItem));
                        return true;
                    }
                };
                popoverMenuWindow.d();
                return;
            }
            PlacePickerFragment.m21905a(placePickerFragment, null);
        }
    }

    /* compiled from: click_comment_button */
    public enum ContextMenuEndpoint {
        SUGGEST_EDITS,
        REPORT_DUPLICATES,
        FLAG
    }

    /* compiled from: click_comment_button */
    public enum ContextMenuEntrypoint {
        LONG_PRESS,
        EDIT_MENU
    }

    /* compiled from: click_comment_button */
    public enum CrowdsourcingEditState {
        SUGGEST_EDITS,
        REPORT_DUPLICATES,
        INAPPROPRIATE_CONTENT,
        NOT_A_PUBLIC_PLACE
    }

    /* compiled from: click_comment_button */
    public enum RefreshAction {
        NONE,
        PTR,
        QUERY,
        NIEM_CLICKED
    }

    public static void m21910a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PlacePickerFragment) obj).m21908a(SelectAtTagAdapter.m21976a(injectorLike), LocationPresenter.m22009a(injectorLike), PlacePickerNavController.m21934a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), ComposerAnalyticsLogger.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedLazy.a(injectorLike, 9530), PlacePickerAnalytics.a(injectorLike), IdBasedLazy.a(injectorLike, 9532), Toaster.a(injectorLike), AnalyticsTagger.a(injectorLike), PlacesFeatures.a(injectorLike), SimpleExecutor.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 9575), HomeActivityLogger.m22237a(injectorLike), ProductMethodAutoProvider.a(injectorLike), PlacesPerformanceLogger.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), PlacePickerFetcher.a(injectorLike), SuggestEditsAnalyticsLogger.a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), (CheckinNiemControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CheckinNiemControllerProvider.class), (CheckinNiemPerfTestControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CheckinNiemPerfTestControllerProvider.class), MinutiaeVerbsFetcher.a(injectorLike), GooglePlayServicesLocationUpsellDialogController.a(injectorLike), GlyphColorizer.a(injectorLike), FunnelLoggerImpl.a(injectorLike), PerfTestConfig.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    private void m21908a(SelectAtTagAdapter selectAtTagAdapter, LocationPresenter locationPresenter, PlacePickerNavController placePickerNavController, SecureContextHelper secureContextHelper, ComposerAnalyticsLogger composerAnalyticsLogger, FbErrorReporter fbErrorReporter, Lazy<FetchNearbyRegionsRunner> lazy, PlacePickerAnalytics placePickerAnalytics, Lazy<FlagPlaceMethodRunner> lazy2, Toaster toaster, AnalyticsTagger analyticsTagger, PlacesFeatures placesFeatures, SimpleExecutor simpleExecutor, Lazy<PlaceSuggestionsIntentBuilder> lazy3, HomeActivityLogger homeActivityLogger, Product product, PlacesPerformanceLogger placesPerformanceLogger, UriIntentMapper uriIntentMapper, PlacePickerFetcher placePickerFetcher, SuggestEditsAnalyticsLogger suggestEditsAnalyticsLogger, Boolean bool, CheckinNiemControllerProvider checkinNiemControllerProvider, CheckinNiemPerfTestControllerProvider checkinNiemPerfTestControllerProvider, MinutiaeVerbsFetcher minutiaeVerbsFetcher, GooglePlayServicesLocationUpsellDialogController googlePlayServicesLocationUpsellDialogController, GlyphColorizer glyphColorizer, FunnelLogger funnelLogger, PerfTestConfig perfTestConfig, QeAccessor qeAccessor) {
        this.f17971b = selectAtTagAdapter;
        this.f17972c = locationPresenter;
        this.f17973d = placePickerNavController;
        this.f17974e = secureContextHelper;
        this.f17975f = composerAnalyticsLogger;
        this.f17976g = fbErrorReporter;
        this.f17977h = lazy;
        this.f17978i = placePickerAnalytics;
        this.al = lazy2;
        this.am = toaster;
        this.an = analyticsTagger;
        this.ao = placesFeatures;
        this.ap = simpleExecutor;
        this.aq = lazy3;
        this.ar = homeActivityLogger;
        this.as = product;
        this.at = placesPerformanceLogger;
        this.au = uriIntentMapper;
        this.av = placePickerFetcher;
        this.aw = suggestEditsAnalyticsLogger;
        this.ax = bool;
        this.ay = checkinNiemControllerProvider;
        this.az = checkinNiemPerfTestControllerProvider;
        this.aA = minutiaeVerbsFetcher;
        this.aB = googlePlayServicesLocationUpsellDialogController;
        this.aC = glyphColorizer;
        this.aD = funnelLogger;
        this.aE = perfTestConfig;
        this.aF = qeAccessor;
    }

    public void afterTextChanged(Editable editable) {
        this.aJ = editable == null ? "" : editable.toString();
        this.f17978i.j = jW_().getConfiguration().orientation;
        this.f17978i.d(this.aJ);
        this.at.a();
        if (this.f17971b != null) {
            SelectAtTagAdapter selectAtTagAdapter = this.f17971b;
            String str = this.aJ;
            selectAtTagAdapter.f18006d = str.toLowerCase(selectAtTagAdapter.f18005c);
            selectAtTagAdapter.f18008f.f18027g = str;
            selectAtTagAdapter.f18010h.f18001d = str;
            selectAtTagAdapter.f18012j.f18040g = str;
            this.aU = RefreshAction.QUERY;
            PlacePickerFetchParams placePickerFetchParams = new PlacePickerFetchParams();
            placePickerFetchParams.a = this.aJ;
            placePickerFetchParams = placePickerFetchParams;
            placePickerFetchParams.c = this.aH.p;
            placePickerFetchParams = placePickerFetchParams;
            placePickerFetchParams.b = this.f17972c.f18060h;
            placePickerFetchParams = placePickerFetchParams;
            placePickerFetchParams.d = this.f17972c.f18058f;
            placePickerFetchParams = placePickerFetchParams;
            placePickerFetchParams.g = this.aT;
            placePickerFetchParams = placePickerFetchParams;
            placePickerFetchParams.f = this.aH.b;
            placePickerFetchParams = placePickerFetchParams;
            placePickerFetchParams.e = this.aH.u;
            placePickerFetchParams = placePickerFetchParams;
            PlacePickerFetcher placePickerFetcher = this.av;
            if (placePickerFetcher.k != null) {
                HandlerDetour.a(placePickerFetcher.h, placePickerFetcher.k);
            }
            placePickerFetcher.k = new 3(placePickerFetcher, placePickerFetchParams);
            HandlerDetour.b(placePickerFetcher.h, placePickerFetcher.k, 300, -1650539777);
            placePickerFetcher.j.a();
            if (SearchType.EVENT == this.aH.p) {
                if (StringUtil.c(this.aJ)) {
                    this.f17971b.f18011i.f18044b = null;
                } else {
                    Object a = a(2131235207, new Object[]{StringUtil.c(this.aJ.trim().toLowerCase(Locale.getDefault()))});
                    SelectAtTagAdapter selectAtTagAdapter2 = this.f17971b;
                    Preconditions.checkState(!StringUtil.a(a));
                    selectAtTagAdapter2.f18011i.f18044b = a;
                }
            }
            au();
            if (StringUtil.a(this.aJ)) {
                this.aS.m22056g();
                return;
            }
            CheckinNiemController checkinNiemController = this.aS;
            if (checkinNiemController.m22061m() && checkinNiemController.mo1082j() && checkinNiemController.mo1083k()) {
                checkinNiemController.m22053c().mo1072a();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void au() {
        /*
        r5 = this;
        r0 = com.facebook.places.checkin.ipc.SearchType.EVENT;
        r1 = r5.aH;
        r2 = r1.p;
        r1 = r2;
        if (r0 == r1) goto L_0x0018;
    L_0x0009:
        r0 = com.facebook.places.checkin.ipc.SearchType.PLACE_TIPS_APP;
        r1 = r5.aH;
        r2 = r1.p;
        r1 = r2;
        if (r0 == r1) goto L_0x0018;
    L_0x0012:
        r0 = r5.as;
        r1 = com.facebook.config.application.Product.PAA;
        if (r0 != r1) goto L_0x0019;
    L_0x0018:
        return;
    L_0x0019:
        r0 = r5.aJ;
        r0 = com.facebook.common.util.StringUtil.c(r0);
        if (r0 != 0) goto L_0x0043;
    L_0x0021:
        r0 = r5.f17972c;
        r2 = r0.f18058f;
        r0 = r2;
        if (r0 != 0) goto L_0x004e;
    L_0x0028:
        r0 = r5.f17972c;
        r2 = r0.f18060h;
        if (r2 == 0) goto L_0x0056;
    L_0x002e:
        r3 = r2.hasAccuracy();
        if (r3 == 0) goto L_0x0056;
    L_0x0034:
        r3 = r2.getAccuracy();
        r4 = 1132068864; // 0x437a0000 float:250.0 double:5.593163344E-315;
        r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1));
        if (r3 >= 0) goto L_0x0056;
    L_0x003e:
        r3 = 1;
    L_0x003f:
        r2 = r3;
        r0 = r2;
        if (r0 != 0) goto L_0x004e;
    L_0x0043:
        r0 = r5.f17971b;
        r2 = r0.f18010h;
        r3 = 0;
        r2.f18000c = r3;
    L_0x004a:
        r5.m21922a();
        goto L_0x0018;
    L_0x004e:
        r0 = r5.f17971b;
        r2 = r0.f18010h;
        r3 = 1;
        r2.f18000c = r3;
        goto L_0x004a;
    L_0x0056:
        r3 = 0;
        goto L_0x003f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.checkin.PlacePickerFragment.au():void");
    }

    public final void m21929b() {
        if (this.aS != null) {
            this.aS.m22055f();
        }
        m21922a();
    }

    public final void m21928a(SearchResults searchResults) {
        m21912b(searchResults);
        this.f17978i.a(this.aL.getLastVisiblePosition() - this.aL.getFirstVisiblePosition());
        if (searchResults.b.isEmpty()) {
            aM();
        }
        m21922a();
    }

    private void m21912b(SearchResults searchResults) {
        if (searchResults == null) {
            searchResults = new SearchResults();
        }
        List list = searchResults.b;
        if (list == null) {
            list = new ArrayList();
        }
        searchResults.b = searchResults.a;
        if (!(this.aH.m == null || this.aH.m.a == null || this.aH.m.a.c() == GraphQLCheckinPlaceResultsContext.NORMAL)) {
            ImmutableList a = this.aH.m.a.a();
            ImmutableList b = this.aH.m.a.b();
            List arrayList = new ArrayList();
            if (a != null) {
                for (CheckinPlaceModel checkinPlaceModel : searchResults.a) {
                    if (checkinPlaceModel.cf_() != null && a.contains(checkinPlaceModel.cf_())) {
                        arrayList.add(checkinPlaceModel);
                    }
                }
            }
            if (b != null) {
                for (CheckinPlaceModel checkinPlaceModel2 : searchResults.a) {
                    if (checkinPlaceModel2.l() != null && b.contains(checkinPlaceModel2.l())) {
                        arrayList.add(checkinPlaceModel2);
                    }
                }
            }
            searchResults.b = arrayList;
        }
        if (!(this.aH.e == null || !this.f17971b.isEmpty() || r0.isEmpty())) {
            this.f17975f.a(Events.COMPOSER_ADD_LOCATION_READY, this.aH.e);
        }
        this.f17978i.g = searchResults;
        SelectAtTagAdapter selectAtTagAdapter = this.f17971b;
        SearchType searchType = this.aH.p;
        selectAtTagAdapter.f18008f.f18033m = searchType;
        selectAtTagAdapter.f18012j.f18041h = searchType;
        BaseAdapter baseAdapter = this.f17971b;
        baseAdapter.f18007e = searchResults;
        SelectAtTagRowSection selectAtTagRowSection = baseAdapter.f18008f;
        Location location = baseAdapter.f18004b;
        String str = baseAdapter.f18006d;
        selectAtTagRowSection.f18025e = searchResults;
        selectAtTagRowSection.f18026f = location;
        selectAtTagRowSection.f18027g = str;
        baseAdapter.f18009g.f17996b = baseAdapter.f18007e;
        baseAdapter.f18012j.f18039f = baseAdapter.f18007e;
        AdapterDetour.a(baseAdapter, 319533683);
        this.aL.setSelectionAfterHeaderView();
        m21922a();
        ay();
    }

    public static void m21907a(PlacePickerFragment placePickerFragment, ImmutableList immutableList) {
        if (!(placePickerFragment.ao.a() || immutableList == null || (SearchType.CHECKIN != placePickerFragment.aH.p && SearchType.EVENT == placePickerFragment.aH.p))) {
            placePickerFragment.aI = GeoRegion.a(immutableList);
            placePickerFragment.f17973d.f17982d = placePickerFragment.aI;
        }
        placePickerFragment.az();
        placePickerFragment.au();
    }

    private void ax() {
        if (this.ar.f18301e == null) {
            HomeActivityLoggerData homeActivityLoggerData = new HomeActivityLoggerData();
            PlacePickerSessionData z = this.f17978i.z();
            Preconditions.checkNotNull(z);
            homeActivityLoggerData.f18304c = z.b;
            homeActivityLoggerData.f18305d = z.a;
            homeActivityLoggerData.f18306e = z.c;
            this.ar.f18301e = homeActivityLoggerData;
        }
    }

    private void ay() {
        if (this.f17971b.getCount() > 0 && this.f17971b.getItemViewType(0) == RowType.AddHome.ordinal()) {
            ax();
            this.ar.m22242a(this.f17971b.f18007e.c, this.f17971b.f18007e.d);
        }
    }

    private void az() {
        if (!this.f17973d.m21954c() && !this.aH.f) {
            CharSequence aA = aA(this);
            if (this.aW != null && aA == null) {
                m21917g(this, 8);
            } else if (aA != null) {
                this.aW = (FbRelativeLayout) this.aX.a();
                TextView textView = (TextView) this.aW.findViewById(2131565968);
                textView.setText(aA);
                textView.setOnClickListener(new C19414(this));
                FbDraweeView fbDraweeView = (FbDraweeView) this.aW.findViewById(2131565967);
                if (this.aH.a == null || this.aH.a.o() == null || this.aH.a.o().a() == null) {
                    fbDraweeView.setVisibility(8);
                } else {
                    Uri parse = Uri.parse(this.aH.a.o().a());
                    fbDraweeView.setVisibility(0);
                    fbDraweeView.a(parse, CallerContext.a(PlacePickerFragment.class));
                }
                m21917g(this, 0);
            }
        }
    }

    @Nullable
    public static String aA(PlacePickerFragment placePickerFragment) {
        if (placePickerFragment.aH.a != null) {
            boolean z;
            if (placePickerFragment.aH.k == null) {
                z = true;
            } else {
                z = false;
            }
            Invariants.a(z);
            return placePickerFragment.a(2131235214, new Object[]{placePickerFragment.aH.a.j()});
        } else if (placePickerFragment.aH.y != null) {
            return placePickerFragment.a(2131235214, new Object[]{placePickerFragment.aH.y});
        } else if (placePickerFragment.aH.k != null) {
            return placePickerFragment.aH.k;
        } else {
            if (placePickerFragment.aI == null || placePickerFragment.aH.p == SearchType.CHECKIN || placePickerFragment.aH.p == SearchType.EVENT || placePickerFragment.aH.p == SearchType.PLACE_TIPS_EMPLOYEE_SETTINGS) {
                return null;
            }
            return placePickerFragment.aI.label;
        }
    }

    public static void m21917g(PlacePickerFragment placePickerFragment, int i) {
        if (placePickerFragment.aW != null && i != placePickerFragment.aW.getVisibility()) {
            int height;
            placePickerFragment.aW.setVisibility(i);
            if (placePickerFragment.aW.getVisibility() != 8) {
                height = placePickerFragment.aW.getHeight();
                if (height == 0) {
                    placePickerFragment.aW.getViewTreeObserver().addOnGlobalLayoutListener(new C19425(placePickerFragment));
                }
            } else {
                height = 0;
            }
            placePickerFragment.aL.setPadding(0, 0, 0, height);
        }
    }

    private void m21909a(HomeActivityEntryFlow homeActivityEntryFlow) {
        ax();
        if (homeActivityEntryFlow == HomeActivityEntryFlow.PLACE_PICKER) {
            this.ar.m22244b(this.f17971b.f18007e.c, this.f17971b.f18007e.d);
        }
        HomeActivityIntentBuilder homeActivityIntentBuilder = new HomeActivityIntentBuilder(ao());
        HomeActivityLoggerData homeActivityLoggerData = this.ar.f18301e;
        Location location = this.f17972c.f18060h;
        boolean z = homeActivityEntryFlow == HomeActivityEntryFlow.PLACE_PICKER || homeActivityEntryFlow == HomeActivityEntryFlow.PLACE_CREATION;
        Preconditions.checkArgument(z);
        Intent intent = new Intent(homeActivityIntentBuilder.f18295a, HomeCreationActivity.class);
        intent.putExtra("map_location", location);
        intent.putExtra("home_creation_logger_data", homeActivityLoggerData);
        intent.putExtra("home_activity_entry_flow", homeActivityEntryFlow.ordinal());
        this.f17974e.a(intent, 7, this);
    }

    public void onItemClick(AdapterView<?> adapterView, android.view.View view, int i, long j) {
        if (i >= adapterView.getAdapter().getCount()) {
            this.f17976g.a("SelectAtTagActivity", "Clicking outside of adapter bounds");
            return;
        }
        int itemViewType = this.f17971b.getItemViewType(i);
        if (this.aV != null) {
            if (itemViewType != RowType.SelectAtTagRow.ordinal()) {
                this.am.a(new ToastBuilder(2131235321));
                return;
            }
            m21911a(this.aV, (CheckinPlaceModel) adapterView.getAdapter().getItem(i), ContextMenuEntrypoint.EDIT_MENU);
            m21905a(this, null);
        } else if (itemViewType == RowType.AddHome.ordinal()) {
            m21909a(HomeActivityEntryFlow.PLACE_PICKER);
        } else if (itemViewType == RowType.AddPlace.ordinal()) {
            this.f17978i.c();
            Intent a = this.au.a(ao(), FBLinks.dY);
            a.putExtra("android.intent.extra.SUBJECT", StringUtil.c(this.aM.getText().toString().trim().toLowerCase(Locale.getDefault())));
            a.putExtra("place_picker_session_data", this.f17978i.z());
            a.putExtra("extra_location", this.f17972c.f18060h);
            this.f17974e.a(a, 1, this);
        } else if (itemViewType == RowType.UseAsText.ordinal()) {
            KeyboardUtils.a(o());
            this.f17973d.m21953c(this.aJ);
        } else if (itemViewType == RowType.TextOnlyRow.ordinal()) {
            this.f17978i.f(this.f17971b.f18012j.m22002e());
            this.f17973d.m21952b((String) this.f17971b.getItem(i));
        } else {
            CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) adapterView.getAdapter().getItem(i);
            this.aA.a(checkinPlaceModel.cf_());
            this.f17978i.g = ((SelectAtTagAdapter) adapterView.getAdapter()).f18007e;
            this.f17973d.m21947a(checkinPlaceModel);
            this.aD.b(FunnelRegistry.o, "place_picked");
        }
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, android.view.View view, int i, long j) {
        if (adapterView.getAdapter().getItemViewType(i) != RowType.SelectAtTagRow.ordinal()) {
            return false;
        }
        CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) adapterView.getAdapter().getItem(i);
        if (checkinPlaceModel == null) {
            return false;
        }
        if (m21914b(checkinPlaceModel)) {
            return false;
        }
        adapterView.performHapticFeedback(0, 2);
        if (!m21914b(checkinPlaceModel) && this.aV == null) {
            this.f17970a = checkinPlaceModel;
            String cf_ = this.f17970a.cf_();
            ContextMenuEntrypoint contextMenuEntrypoint = ContextMenuEntrypoint.LONG_PRESS;
            Optional fromNullable = Optional.fromNullable(cf_);
            this.aw.a(m21904a(contextMenuEntrypoint, ContextMenuEndpoint.FLAG), fromNullable);
            this.aw.a(m21904a(contextMenuEntrypoint, ContextMenuEndpoint.REPORT_DUPLICATES), fromNullable);
            this.aw.a(m21904a(contextMenuEntrypoint, ContextMenuEndpoint.SUGGEST_EDITS), fromNullable);
            android.view.View e = e(2131565970);
            e.setOnCreateContextMenuListener(this);
            o().openContextMenu(e);
        }
        this.f17978i.k();
        return true;
    }

    public final void m21923a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (!this.f17973d.m21949a(i, i2, intent) && i2 == -1) {
            switch (i) {
                case 1:
                    if (intent.getBooleanExtra("create_home_from_place_creation", false)) {
                        m21909a(HomeActivityEntryFlow.PLACE_CREATION);
                        return;
                    } else if (intent.hasExtra("extra_place")) {
                        CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) FlatBufferModelHelper.a(intent, "extra_place");
                        this.f17978i.a(checkinPlaceModel);
                        this.f17973d.m21951b(checkinPlaceModel);
                        return;
                    } else if (intent.hasExtra("selected_existing_place")) {
                        this.f17973d.m21951b((CheckinPlaceModel) FlatBufferModelHelper.a(intent, "selected_existing_place"));
                        return;
                    } else {
                        return;
                    }
                case 2:
                    Toaster.a(o(), 2131237625);
                    return;
                case 7:
                    this.f17973d.m21951b((CheckinPlaceModel) FlatBufferModelHelper.a(intent, "extra_place"));
                    return;
                default:
                    return;
            }
        }
    }

    @Deprecated
    public final void m21922a() {
        if (this.y) {
            Object obj;
            Object obj2;
            Object obj3;
            if (!this.f17972c.f18059g || this.aU == RefreshAction.QUERY) {
                obj3 = null;
            } else {
                obj3 = 1;
            }
            PlacePickerFetcher placePickerFetcher = this.av;
            if (placePickerFetcher.k != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null || placePickerFetcher.f.a() || placePickerFetcher.c.g.a()) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 != null || r0 != null) {
                this.aK.m22086e();
            } else if (this.aK.getListViewCount() == 0) {
                this.aK.m22083a();
                this.aS.m22055f();
                aM();
            } else {
                this.aK.m22085b();
            }
        }
    }

    public final void m21927a(GoogleLocationDialogResult googleLocationDialogResult) {
        if (this.aS != null) {
            this.aS.m22050a(googleLocationDialogResult);
        }
    }

    public final void m21931c(Bundle bundle) {
        Object obj;
        super.c(bundle);
        Class cls = PlacePickerFragment.class;
        m21910a((Object) this, getContext());
        PlacesPerformanceLogger placesPerformanceLogger = this.at;
        placesPerformanceLogger.f.o(getClass().getSimpleName());
        this.aB.a(this, this);
        MockDeps.a(this);
        this.aH = (PlacePickerConfiguration) aN().getParcelableExtra("place_picker_configuration");
        Preconditions.checkNotNull(this.aH);
        this.f17972c.f18057e = this;
        if (this.aH.o != null) {
            LocationPresenter locationPresenter = this.f17972c;
            locationPresenter.f18060h = this.aH.o.a("preset_search_location");
            locationPresenter.f18058f = true;
        }
        if (this.aH.d != null) {
            this.f17972c.f18061i.f18049e = this.aH.d.a("composer_location");
        }
        ComposerConfiguration composerConfiguration = this.aH.c;
        if ((!this.aH.i || this.aH.w) && (composerConfiguration == null || !composerConfiguration.getInitialLocationInfo().d())) {
            obj = null;
        } else {
            obj = 1;
        }
        if (composerConfiguration == null) {
            this.aT = CheckinComposerEntryPoint.Other;
        } else if (!composerConfiguration.getInitialAttachments().isEmpty()) {
            this.aT = CheckinComposerEntryPoint.Photo;
        } else if (obj != null) {
            this.aT = CheckinComposerEntryPoint.Checkin;
        } else {
            this.aT = CheckinComposerEntryPoint.Status;
        }
        this.av.j = this;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -613985978);
        super.mi_();
        this.f17972c.m22013b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1946961344, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1372255204);
        LocationPresenter.m22012n(this.f17972c);
        this.ap.c();
        this.av.a();
        super.mj_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -976115362, a);
    }

    public final void m21920I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 974813861);
        super.I();
        this.aD.b(FunnelRegistry.o);
        CheckinNiemController checkinNiemController = this.aS;
        if (checkinNiemController.f18102s != null) {
            checkinNiemController.f18102s.c();
        }
        PlacePickerFetcher.i(this.av);
        this.aP.removeCallbacksAndMessages(null);
        this.aB.a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1297230457, a);
    }

    public final android.view.View m21921a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1245422759);
        android.view.View inflate = layoutInflater.inflate(2130906253, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 23869818, a);
        return inflate;
    }

    public final void m21926a(android.view.View view, Bundle bundle) {
        this.aK = (PlacesListContainer) e(2131565977);
        ((ViewStub) view.findViewById(2131565972)).inflate();
        this.aO = (Fb4aTitleBar) ((ViewStub) view.findViewById(2131565971)).inflate();
        this.aM = (SoftKeyboardStateAwareEditText) e(2131565980);
        this.aL = this.aK.f18113b;
        this.aX = new LazyView((ViewStub) e(2131565978), new C19457(this));
        this.aO.setTitle(this.aT == CheckinComposerEntryPoint.Checkin ? 2131235147 : 2131235148);
        this.aO.a(new C19468(this));
        this.aM.setHint(2131235176);
        this.aM.b = this.aZ;
        PlacePickerNavController placePickerNavController = this.f17973d;
        PlacePickerConfiguration placePickerConfiguration = this.aH;
        placePickerNavController.f17979a = this;
        placePickerNavController.f17980b = placePickerConfiguration;
        this.f17973d.m21948a(this.aH.e);
        this.f17973d.m21946a(bundle);
        aG();
        if (this.aH.p != null) {
            this.f17973d.f17990l = this.aH.p;
        }
        this.an.a(this.aL, "tag_places_view", this);
        if (this.aH.p != null) {
            this.f17978i.f = this.aH.p;
        }
        this.f17978i.t = this.f17972c.f18055c.b().b.asList();
        if (!(this.aH.p == SearchType.CHECKIN || this.aH.k == null)) {
            this.aJ = this.aH.k;
            this.aM.setText(this.aH.k);
        }
        if (PerfTestConfigBase.i) {
            this.aS = this.az.m22078a(e(2131565970), o(), this, this.aB);
        } else {
            this.aS = this.ay.m22063a(e(2131565970), o(), this, this.aB);
        }
        if (bundle == null) {
            aJ();
        } else {
            this.f17970a = (CheckinPlaceModel) FlatBufferModelHelper.a(bundle, "current_context_menu_place");
            m21905a(this, (CrowdsourcingEditState) bundle.getSerializable("crowdsourcing_edit_state"));
            this.ar.f18301e = (HomeActivityLoggerData) bundle.getParcelable("home_creation_logger_data");
            this.aJ = bundle.getString("search_text");
            this.aM.setText(this.aJ);
            Editable editableText = this.aM.getEditableText();
            if (editableText.length() > 0) {
                afterTextChanged(editableText);
            }
            this.f17978i.a(bundle.getBundle("analytics_bundle"));
        }
        if (this.aH.m != null) {
            this.f17978i.k = this.aH.m.suggestionMechanism;
        }
        this.aO.a(new C19436(this));
    }

    public static void m21905a(PlacePickerFragment placePickerFragment, CrowdsourcingEditState crowdsourcingEditState) {
        boolean z;
        placePickerFragment.aV = crowdsourcingEditState;
        BaseAdapter baseAdapter = placePickerFragment.f17971b;
        if (crowdsourcingEditState != null) {
            z = true;
        } else {
            z = false;
        }
        if (baseAdapter.f18017o != z) {
            baseAdapter.f18017o = z;
            baseAdapter.f18008f.f18030j = z;
            AdapterDetour.a(baseAdapter, -783912741);
        }
        Optional f = placePickerFragment.f(2131565974);
        if (crowdsourcingEditState != null) {
            Optional optional;
            String string;
            if (f.isPresent()) {
                optional = f;
            } else {
                optional = Optional.of((FbTextView) ((ViewStub) placePickerFragment.e(2131565973)).inflate());
            }
            ((FbTextView) optional.get()).setVisibility(0);
            FbTextView fbTextView = (FbTextView) optional.get();
            switch (placePickerFragment.aV) {
                case SUGGEST_EDITS:
                    string = placePickerFragment.jW_().getString(2131235189);
                    break;
                case REPORT_DUPLICATES:
                    string = placePickerFragment.jW_().getString(2131235191);
                    break;
                case INAPPROPRIATE_CONTENT:
                    string = placePickerFragment.jW_().getString(2131235192);
                    break;
                case NOT_A_PUBLIC_PLACE:
                    string = placePickerFragment.jW_().getString(2131235194);
                    break;
                default:
                    string = "";
                    break;
            }
            fbTextView.setText(string);
            m21917g(placePickerFragment, 8);
        } else if (f.isPresent()) {
            ((FbTextView) f.get()).setVisibility(8);
            placePickerFragment.az();
        }
    }

    public static CrowdsourcingEditState m21916e(@Nullable MenuItem menuItem) {
        if (menuItem == null) {
            return null;
        }
        if (menuItem.getItemId() == 2131568687) {
            return CrowdsourcingEditState.SUGGEST_EDITS;
        }
        if (menuItem.getItemId() == 2131568688) {
            return CrowdsourcingEditState.REPORT_DUPLICATES;
        }
        if (menuItem.getItemId() == 2131568689) {
            return CrowdsourcingEditState.INAPPROPRIATE_CONTENT;
        }
        if (menuItem.getItemId() == 2131568690) {
            return CrowdsourcingEditState.NOT_A_PUBLIC_PLACE;
        }
        return null;
    }

    private void aG() {
        this.aL.a(new OnDrawListener(this) {
            final /* synthetic */ PlacePickerFragment f17945a;

            /* compiled from: click_comment_button */
            class C19371 implements Runnable {
                final /* synthetic */ AnonymousClass11 f17944a;

                C19371(AnonymousClass11 anonymousClass11) {
                    this.f17944a = anonymousClass11;
                }

                public void run() {
                    PlacePickerFragment.aH(this.f17944a.f17945a);
                }
            }

            {
                this.f17945a = r1;
            }

            public final boolean gD_() {
                if (this.f17945a.aL.getCount() > 0) {
                    PlacesPerformanceLogger placesPerformanceLogger = this.f17945a.at;
                    placesPerformanceLogger.e.b(1376262, (short) 2);
                    placesPerformanceLogger.e.b(1376261, (short) 2);
                    placesPerformanceLogger.e.b(1376281, (short) 2);
                    placesPerformanceLogger.f.b("OpenCheckIn");
                } else {
                    this.f17945a.at.a();
                }
                HandlerDetour.a(this.f17945a.aP, new C19371(this), 1751606382);
                return true;
            }
        });
        this.aL.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ PlacePickerFragment f17946a;

            {
                this.f17946a = r1;
            }

            public void onScrollStateChanged(AbsListView absListView, int i) {
                this.f17946a.f17978i.d();
                this.f17946a.f17978i.a(this.f17946a.aL.getFirstVisiblePosition(), this.f17946a.aL.getLastVisiblePosition());
                PlacePickerFragment.m21915d(this.f17946a, absListView);
            }

            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.aL.setOnItemClickListener(this);
        if (aK()) {
            this.aL.setOnItemLongClickListener(this);
        }
        this.aL.setAdapter(this.f17971b);
        m21922a();
    }

    public static void aH(PlacePickerFragment placePickerFragment) {
        if (placePickerFragment.aK() && placePickerFragment.aO.getPrimaryButtonSpec() == null) {
            Builder a = TitleBarButtonSpec.a();
            a.b = placePickerFragment.aC.a(2130840013, -1);
            a = a;
            a.j = placePickerFragment.jW_().getString(2131235188);
            placePickerFragment.aO.setPrimaryButton(a.a());
            placePickerFragment.aO.setActionButtonOnClickListener(new C19479(placePickerFragment));
        }
        placePickerFragment.aK.m22084a(new OnRefreshListener(placePickerFragment) {
            final /* synthetic */ PlacePickerFragment f17947a;

            {
                this.f17947a = r1;
            }

            public final void m21897a() {
                this.f17947a.aU = RefreshAction.PTR;
                this.f17947a.f17978i.j();
                PlacePickerFragment.aQ(this.f17947a);
            }
        });
        if (!((placePickerFragment.aH.g && placePickerFragment.aF.a(ExperimentsForCheckinAbTestModule.a, false)) || placePickerFragment.f17972c.f18060h == null || placePickerFragment.f17972c.f18058f)) {
            Location location = placePickerFragment.f17972c.f18060h;
            FetchNearbyRegionsRunner fetchNearbyRegionsRunner = (FetchNearbyRegionsRunner) placePickerFragment.f17977h.get();
            placePickerFragment.ap.a(fetchNearbyRegionsRunner.g.a(new 1(fetchNearbyRegionsRunner, FqlHelper.a("nearby_regions").a(new Field[]{FetchNearbyRegionsRunner.a, FetchNearbyRegionsRunner.b, FetchNearbyRegionsRunner.c}).a(Table.GEO_REGION).a(FetchNearbyRegionsRunner.d.a(location.getLatitude()).a(FetchNearbyRegionsRunner.e.a(location.getLongitude())).a(FetchNearbyRegionsRunner.b.a("city"))))), new C19403(placePickerFragment));
        }
        if (placePickerFragment.aH.t) {
            placePickerFragment.aM();
        }
    }

    private void aJ() {
        this.aD.a(FunnelRegistry.o);
        this.f17978i.d = this.aH.e;
        this.f17978i.e = aN().getStringExtra("place_picker_session_id");
        this.f17978i.j = jW_().getConfiguration().orientation;
        this.f17978i.a();
    }

    public final void m21932d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1905292486);
        super.d(bundle);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1547776471, a);
    }

    public static void m21915d(PlacePickerFragment placePickerFragment, android.view.View view) {
        ((InputMethodManager) placePickerFragment.o().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public final void m21924a(int i, Intent intent) {
        o().setResult(i, intent);
        o().finish();
    }

    public final void aq() {
        Builder a = TitleBarButtonSpec.a();
        a.g = b(2131235217);
        a = a;
        a.q = true;
        this.aO.setPrimaryButton(a.a());
        this.aO.setActionButtonOnClickListener(new OnActionButtonClickListener(this) {
            final /* synthetic */ PlacePickerFragment f17948a;

            {
                this.f17948a = r1;
            }

            public final void m21898a(android.view.View view) {
                Preconditions.checkArgument(this.f17948a.f17973d.m21954c());
                this.f17948a.f17973d.m21950b();
            }
        });
    }

    private boolean aK() {
        return (this.ax.booleanValue() || this.aH.h) ? false : true;
    }

    public static void m21906a(PlacePickerFragment placePickerFragment, CheckinPlaceModel checkinPlaceModel, FlagType flagType, ContextMenuEntrypoint contextMenuEntrypoint) {
        placePickerFragment.aQ = true;
        placePickerFragment.aR = ProgressDialogFragment.a(2131230757, true, false);
        placePickerFragment.aR.a(placePickerFragment.kO_(), null);
        FlagPlaceMethodRunner flagPlaceMethodRunner = (FlagPlaceMethodRunner) placePickerFragment.al.get();
        placePickerFragment.ap.a(flagPlaceMethodRunner.c.a(new FlagPlaceMethodRunner.1(flagPlaceMethodRunner, checkinPlaceModel, flagType, m21904a(contextMenuEntrypoint, ContextMenuEndpoint.FLAG), CrowdEndpoint.PLACE_PICKER_REPORT_DIALOG)), new FutureCallback<Void>(placePickerFragment) {
            final /* synthetic */ PlacePickerFragment f17949a;

            {
                this.f17949a = r1;
            }

            public void onSuccess(Object obj) {
                Invariants.a(this.f17949a.aQ);
                this.f17949a.aR.a();
                this.f17949a.am.b(new ToastBuilder(2131237624));
                this.f17949a.aQ = false;
            }

            public void onFailure(Throwable th) {
                Invariants.a(this.f17949a.aQ);
                this.f17949a.aR.a();
                this.f17949a.am.b(new ToastBuilder(2131237626));
                this.f17949a.aQ = false;
                BLog.b(PlacePickerFragment.aG, "Could not flag place", th);
            }
        });
    }

    private void m21913b(CheckinPlaceModel checkinPlaceModel, ContextMenuEntrypoint contextMenuEntrypoint) {
        Intent intent = new Intent(o(), MarkAsDuplicatesActivity.class);
        List a = Lists.a();
        for (int i = 0; i < this.f17971b.getCount(); i++) {
            if (this.f17971b.getItemViewType(i) == RowType.SelectAtTagRow.ordinal()) {
                CheckinPlaceModel checkinPlaceModel2 = (CheckinPlaceModel) this.f17971b.getItem(i);
                if (!(checkinPlaceModel2.cf_().equals(checkinPlaceModel.cf_()) || checkinPlaceModel2.m() == GraphQLPlaceType.EVENT)) {
                    a.add(checkinPlaceModel2);
                }
            }
        }
        FlatBufferModelHelper.a(intent, "duplicate_place", checkinPlaceModel);
        FlatBufferModelHelper.a(intent, "extra_place_list", a);
        intent.putExtra("entry_point", m21904a(contextMenuEntrypoint, ContextMenuEndpoint.REPORT_DUPLICATES));
        this.f17974e.a(intent, o());
    }

    public void onCreateContextMenu(ContextMenu contextMenu, android.view.View view, ContextMenuInfo contextMenuInfo) {
        o().getMenuInflater().inflate(2131820588, contextMenu);
    }

    public final boolean m21930b(MenuItem menuItem) {
        CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) Preconditions.checkNotNull(this.f17970a);
        this.f17970a = null;
        return m21911a(m21916e(menuItem), checkinPlaceModel, ContextMenuEntrypoint.LONG_PRESS);
    }

    private boolean m21911a(@Nullable CrowdsourcingEditState crowdsourcingEditState, final CheckinPlaceModel checkinPlaceModel, final ContextMenuEntrypoint contextMenuEntrypoint) {
        if (CrowdsourcingEditState.SUGGEST_EDITS.equals(crowdsourcingEditState)) {
            this.f17974e.a(((PlaceSuggestionsIntentBuilder) this.aq.get()).m3591a(Long.parseLong(checkinPlaceModel.cf_()), checkinPlaceModel.j(), null, CrowdsourcingSource.COMPOSER_EDIT, m21904a(contextMenuEntrypoint, ContextMenuEndpoint.SUGGEST_EDITS)), 2, this);
        } else if (CrowdsourcingEditState.REPORT_DUPLICATES.equals(crowdsourcingEditState)) {
            m21913b(checkinPlaceModel, contextMenuEntrypoint);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            if (CrowdsourcingEditState.INAPPROPRIATE_CONTENT.equals(crowdsourcingEditState)) {
                builder.a(2131235192).b(2131235193).a(2131230735, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ PlacePickerFragment f17952c;

                    public void onClick(DialogInterface dialogInterface, int i) {
                        PlacePickerFragment.m21906a(this.f17952c, checkinPlaceModel, FlagType.OFFENSIVE, contextMenuEntrypoint);
                    }
                });
            } else if (CrowdsourcingEditState.NOT_A_PUBLIC_PLACE.equals(crowdsourcingEditState)) {
                builder.a(2131235194).b(2131235195).a(2131230735, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ PlacePickerFragment f17955c;

                    public void onClick(DialogInterface dialogInterface, int i) {
                        PlacePickerFragment.m21906a(this.f17955c, checkinPlaceModel, FlagType.NOT_PUBLIC, contextMenuEntrypoint);
                    }
                });
            } else {
                this.f17976g.a("SelectAtTagActivity", "Selected menu item not valid.");
                return false;
            }
            builder.b(2131230736, null);
            builder.b();
        }
        return true;
    }

    public final void m21918G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 228476279);
        super.G();
        this.aM.addTextChangedListener(this);
        m21907a(this, null);
        if (this.aS.m22061m() || this.aS.m22054e()) {
            if (this.aS.m22054e()) {
                this.at.a();
            }
            this.aS.m22056g();
        }
        PlacesPerformanceLogger placesPerformanceLogger = this.at;
        placesPerformanceLogger.f.p(getClass().getSimpleName());
        m21922a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1272167263, a);
    }

    public final void m21925a(@Nullable Location location) {
        SelectAtTagAdapter selectAtTagAdapter = this.f17971b;
        selectAtTagAdapter.f18004b = location;
        selectAtTagAdapter.f18008f.f18026f = location;
        if (location != null) {
            this.f17978i.a(location);
        } else {
            this.f17978i.r = true;
            this.at.a();
        }
        PlacePickerFetchParams placePickerFetchParams = new PlacePickerFetchParams();
        placePickerFetchParams.a = this.aM.getText().toString();
        placePickerFetchParams = placePickerFetchParams;
        placePickerFetchParams.c = this.aH.p;
        placePickerFetchParams = placePickerFetchParams;
        placePickerFetchParams.b = location;
        placePickerFetchParams = placePickerFetchParams;
        placePickerFetchParams.d = this.f17972c.f18058f;
        placePickerFetchParams = placePickerFetchParams;
        placePickerFetchParams.g = this.aT;
        placePickerFetchParams = placePickerFetchParams;
        placePickerFetchParams.f = this.aH.b;
        placePickerFetchParams = placePickerFetchParams;
        placePickerFetchParams.e = this.aH.u;
        PlacePickerFetchParams placePickerFetchParams2 = placePickerFetchParams;
        PlacePickerFetcher placePickerFetcher = this.av;
        boolean z = this.aU == RefreshAction.PTR || this.aU == RefreshAction.NIEM_CLICKED;
        placePickerFetcher.a(placePickerFetchParams2, z);
        au();
    }

    public final void m21919H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1379733713);
        super.H();
        this.at.a();
        this.aM.removeTextChangedListener(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1735928921, a);
    }

    public final void m21933e(Bundle bundle) {
        super.e(bundle);
        FlatBufferModelHelper.a(bundle, "previously_selected_location", this.f17973d.f17992n);
        bundle.putString("search_text", this.aJ);
        FlatBufferModelHelper.a(bundle, "current_context_menu_place", this.f17970a);
        bundle.putParcelable("home_creation_logger_data", this.ar.f18301e);
        bundle.putBundle("analytics_bundle", this.f17978i.y());
        bundle.putSerializable("crowdsourcing_edit_state", this.aV);
    }

    public final void kh_() {
        if (!this.f17972c.m22016h()) {
            this.f17978i.i();
        }
        this.aS.m22056g();
        aO();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.aN == null) {
            this.aN = ((ViewStub) e(2131565981)).inflate();
            this.aN.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ PlacePickerFragment f17956a;

                {
                    this.f17956a = r1;
                }

                public void onClick(android.view.View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 791491989);
                    PlacePickerFragment placePickerFragment = this.f17956a;
                    if (placePickerFragment.aM != null && placePickerFragment.aM.getText().length() > 0) {
                        placePickerFragment.aM.setText("");
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, 11796114, a);
                }
            });
        }
        if (this.aM.getText().toString().isEmpty()) {
            this.aN.setVisibility(8);
        } else {
            this.aN.setVisibility(0);
        }
    }

    private void aM() {
        this.aM.requestFocus();
        ((InputMethodManager) o().getSystemService("input_method")).showSoftInput(this.aM, 0);
    }

    public static boolean m21914b(CheckinPlaceModel checkinPlaceModel) {
        return checkinPlaceModel.b() != null && checkinPlaceModel.b().g() == 67338874;
    }

    private Intent aN() {
        return o().getIntent();
    }

    private void aO() {
        if (StringUtil.a(this.aM.getText()) && !this.f17972c.m22016h()) {
            aM();
        }
    }

    public static void aQ(PlacePickerFragment placePickerFragment) {
        PlacePickerCache placePickerCache = placePickerFragment.av.c.d;
        placePickerCache.a.a();
        placePickerCache.b.clear();
        placePickerFragment.f17972c.m22014e();
        placePickerFragment.m21922a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.crowdsourcing.logging.CrowdEntryPoint m21904a(com.facebook.places.checkin.PlacePickerFragment.ContextMenuEntrypoint r2, com.facebook.places.checkin.PlacePickerFragment.ContextMenuEndpoint r3) {
        /*
        r0 = com.facebook.places.checkin.PlacePickerFragment.AnonymousClass19.f17959c;
        r1 = r3.ordinal();
        r0 = r0[r1];
        switch(r0) {
            case 1: goto L_0x000d;
            case 2: goto L_0x0018;
            case 3: goto L_0x0023;
            default: goto L_0x000b;
        };
    L_0x000b:
        r0 = 0;
    L_0x000c:
        return r0;
    L_0x000d:
        r0 = com.facebook.places.checkin.PlacePickerFragment.AnonymousClass19.f17958b;
        r1 = r2.ordinal();
        r0 = r0[r1];
        switch(r0) {
            case 1: goto L_0x0032;
            case 2: goto L_0x0035;
            default: goto L_0x0018;
        };
    L_0x0018:
        r0 = com.facebook.places.checkin.PlacePickerFragment.AnonymousClass19.f17958b;
        r1 = r2.ordinal();
        r0 = r0[r1];
        switch(r0) {
            case 1: goto L_0x0038;
            case 2: goto L_0x003b;
            default: goto L_0x0023;
        };
    L_0x0023:
        r0 = com.facebook.places.checkin.PlacePickerFragment.AnonymousClass19.f17958b;
        r1 = r2.ordinal();
        r0 = r0[r1];
        switch(r0) {
            case 1: goto L_0x002f;
            case 2: goto L_0x003e;
            default: goto L_0x002e;
        };
    L_0x002e:
        goto L_0x000b;
    L_0x002f:
        r0 = com.facebook.crowdsourcing.logging.CrowdEntryPoint.PLACE_PICKER_LONG_PRESS;
        goto L_0x000c;
    L_0x0032:
        r0 = com.facebook.crowdsourcing.logging.CrowdEntryPoint.PLACE_PICKER_LONG_PRESS_SUGGEST_EDITS;
        goto L_0x000c;
    L_0x0035:
        r0 = com.facebook.crowdsourcing.logging.CrowdEntryPoint.PLACE_PICKER_EDIT_MENU_SUGGEST_EDITS;
        goto L_0x000c;
    L_0x0038:
        r0 = com.facebook.crowdsourcing.logging.CrowdEntryPoint.PLACE_PICKER_LONG_PRESS_REPORT_DUPLICATES;
        goto L_0x000c;
    L_0x003b:
        r0 = com.facebook.crowdsourcing.logging.CrowdEntryPoint.PLACE_PICKER_EDIT_MENU_REPORT_DUPLICATES;
        goto L_0x000c;
    L_0x003e:
        r0 = com.facebook.crowdsourcing.logging.CrowdEntryPoint.PLACE_PICKER_EDIT_MENU;
        goto L_0x000c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.checkin.PlacePickerFragment.a(com.facebook.places.checkin.PlacePickerFragment$ContextMenuEntrypoint, com.facebook.places.checkin.PlacePickerFragment$ContextMenuEndpoint):com.facebook.crowdsourcing.logging.CrowdEntryPoint");
    }
}
