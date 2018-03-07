package com.facebook.backgroundlocation.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.backgroundlocation.nux.BackgroundLocationOnePageNuxActivity;
import com.facebook.backgroundlocation.privacypicker.BackgroundLocationPrivacyPickerOptionsAdapter;
import com.facebook.backgroundlocation.privacypicker.graphql.BackgroundLocationPrivacyPickerGraphQLModels.BackgroundLocationPrivacyPickerOptionEdgeModel;
import com.facebook.backgroundlocation.privacypicker.graphql.BackgroundLocationPrivacyPickerGraphQLModels.BackgroundLocationPrivacyPickerOptionModel;
import com.facebook.backgroundlocation.settings.BackgroundLocationSettingsPerfLogger.Marker;
import com.facebook.backgroundlocation.settings.graphql.BackgroundLocationSettingsGraphQL.LocationSharingPrivacyOptionsQueryString;
import com.facebook.backgroundlocation.settings.graphql.BackgroundLocationSettingsGraphQLModels.LocationSharingPrivacyOptionsQueryModel;
import com.facebook.backgroundlocation.settings.graphql.BackgroundLocationSettingsGraphQLModels.LocationSharingPrivacyOptionsQueryModel.LocationSharingModel.UpsellModel.FriendsSharingLocationConnectionModel;
import com.facebook.backgroundlocation.settings.write.BackgroundLocationUpdateSettingsParams;
import com.facebook.backgroundlocation.upsell.BackgroundLocationUpsellView;
import com.facebook.backgroundlocation.upsell.BackgroundLocationUpsellView.ButtonListener;
import com.facebook.backgroundlocation.upsell.graphql.BackgroundLocationUpsellGraphQLInterfaces.BackgroundLocationUpsellProfile;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.bugreporter.BugReportFlowStartParams;
import com.facebook.bugreporter.BugReporter;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.popover.PopoverSpinner;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationConstants;
import com.facebook.location.FbLocationStatus;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.location.gmsupsell.GooglePlayLocationServicesSettingsManager.LocationSettingsRequestParams;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController;
import com.facebook.location.gmsupsell.SimpleLocationUpsellDialogFinishedListener;
import com.facebook.location.ui.LocationSettingsOffView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.runtimepermissions.AbstractRuntimePermissionsListener;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.OnDispatchDrawListener;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UriMatchPatterns
/* compiled from: dialog_message */
public class BackgroundLocationSettingsActivity extends FbFragmentActivity implements AnalyticsActivity {
    public static final CallerContext f15009p = CallerContext.a(BackgroundLocationSettingsActivity.class);
    private ImageBlockLayout f15010A;
    private ImageBlockLayout f15011B;
    private ImageBlockLayout f15012C;
    private View f15013D;
    private BackgroundLocationUpsellView f15014E;
    private View f15015F;
    private View f15016G;
    private View f15017H;
    private TextView f15018I;
    private TextView f15019J;
    public Toaster f15020K;
    public BackgroundLocationPrivacyPickerOptionModel f15021L;
    public BackgroundLocationPrivacyPickerOptionModel f15022M;
    private BackgroundLocationPrivacyPickerOptionModel f15023N;
    private BackgroundLocationPrivacyPickerOptionModel f15024O;
    public boolean f15025P;
    public BackgroundLocationPrivacyPickerOptionsAdapter f15026Q;
    private SecureContextHelper f15027R;
    private AbstractFbErrorReporter f15028S;
    private FbLocationStatusUtil f15029T;
    public BugReporter f15030U;
    private GatekeeperStoreImpl f15031V;
    public BackgroundLocationSettingsAnalyticsLogger f15032W;
    public BackgroundLocationSettingsPerfLogger f15033X;
    private ActivityRuntimePermissionsManagerProvider f15034Y;
    private ActivityRuntimePermissionsManager f15035Z;
    private GooglePlayServicesLocationUpsellDialogController aa;
    private SimpleLocationUpsellDialogFinishedListener ab;
    private QeAccessor ac;
    public TriState ad = TriState.UNSET;
    public State ae;
    public boolean af;
    private final OnClickListener ag = new C20841(this);
    private final OnCheckedChangeListener ah = new C20852(this);
    private final OnItemSelectedListener ai = new C20863(this);
    private final ButtonListener aj = new C20874(this);
    private TasksManager<Task> f15036q;
    public GraphQLQueryExecutor f15037r;
    public DefaultBlueServiceOperationFactory f15038s;
    private LocationSettingsOffView f15039t;
    private CompoundButton f15040u;
    private PopoverSpinner f15041v;
    private TextView f15042w;
    private TextView f15043x;
    private TextView f15044y;
    private TextView f15045z;

    /* compiled from: dialog_message */
    class C20841 implements OnClickListener {
        final /* synthetic */ BackgroundLocationSettingsActivity f15000a;

        C20841(BackgroundLocationSettingsActivity backgroundLocationSettingsActivity) {
            this.f15000a = backgroundLocationSettingsActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -659059200);
            Preconditions.checkState(FbLocationStatus.b(this.f15000a.ae));
            if (this.f15000a.ae == State.LOCATION_DISABLED) {
                this.f15000a.f15021L;
            } else {
                this.f15000a.f15038s;
            }
            LogUtils.a(-484165970, a);
        }
    }

    /* compiled from: dialog_message */
    class C20852 implements OnCheckedChangeListener {
        final /* synthetic */ BackgroundLocationSettingsActivity f15001a;

        C20852(BackgroundLocationSettingsActivity backgroundLocationSettingsActivity) {
            this.f15001a = backgroundLocationSettingsActivity;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.f15001a.f15032W.f15047a.a(BackgroundLocationSettingsAnalyticsLogger.m15503a("friends_nearby_settings_toggle").a("is_on", z));
            if (z) {
                BackgroundLocationSettingsActivity.m15501z(this.f15001a);
            } else {
                BackgroundLocationSettingsActivity.m15427A(this.f15001a);
            }
        }
    }

    /* compiled from: dialog_message */
    class C20863 implements OnItemSelectedListener {
        final /* synthetic */ BackgroundLocationSettingsActivity f15002a;

        C20863(BackgroundLocationSettingsActivity backgroundLocationSettingsActivity) {
            this.f15002a = backgroundLocationSettingsActivity;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            BackgroundLocationSettingsActivity.m15455c(this.f15002a, this.f15002a.f15026Q.m15297a(i));
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* compiled from: dialog_message */
    class C20874 implements ButtonListener {
        final /* synthetic */ BackgroundLocationSettingsActivity f15003a;

        C20874(BackgroundLocationSettingsActivity backgroundLocationSettingsActivity) {
            this.f15003a = backgroundLocationSettingsActivity;
        }

        public final void mo750a(BackgroundLocationUpsellView backgroundLocationUpsellView) {
            BackgroundLocationSettingsAnalyticsLogger backgroundLocationSettingsAnalyticsLogger = this.f15003a.f15032W;
            String designName = backgroundLocationUpsellView.getDesignName();
            int i = backgroundLocationUpsellView.f15069a;
            HoneyClientEvent a = BackgroundLocationSettingsAnalyticsLogger.m15503a("friends_nearby_settings_upsell_click");
            a.b("design_name", designName);
            a.a("total_friends_sharing", i);
            backgroundLocationSettingsAnalyticsLogger.f15047a.a(a);
            this.f15003a.f15020K;
        }
    }

    /* compiled from: dialog_message */
    class C20885 implements OnClickListener {
        final /* synthetic */ BackgroundLocationSettingsActivity f15004a;

        C20885(BackgroundLocationSettingsActivity backgroundLocationSettingsActivity) {
            this.f15004a = backgroundLocationSettingsActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1190597883);
            this.f15004a.finish();
            Logger.a(2, EntryType.UI_INPUT_END, -1070163806, a);
        }
    }

    /* compiled from: dialog_message */
    class C20896 implements OnClickListener {
        final /* synthetic */ BackgroundLocationSettingsActivity f15005a;

        C20896(BackgroundLocationSettingsActivity backgroundLocationSettingsActivity) {
            this.f15005a = backgroundLocationSettingsActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 286501757);
            this.f15005a.f15032W.f15047a.a(BackgroundLocationSettingsAnalyticsLogger.m15503a("friends_nearby_settings_location_settings"));
            this.f15005a.f15033X;
            Logger.a(2, EntryType.UI_INPUT_END, -1950994155, a);
        }
    }

    /* compiled from: dialog_message */
    class C20907 implements OnClickListener {
        final /* synthetic */ BackgroundLocationSettingsActivity f15006a;

        C20907(BackgroundLocationSettingsActivity backgroundLocationSettingsActivity) {
            this.f15006a = backgroundLocationSettingsActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1221275661);
            this.f15006a.f15032W.f15047a.a(BackgroundLocationSettingsAnalyticsLogger.m15503a("friends_nearby_settings_learn_more"));
            BackgroundLocationSettingsActivity.m15483o(this.f15006a);
            Logger.a(2, EntryType.UI_INPUT_END, 1696498919, a);
        }
    }

    /* compiled from: dialog_message */
    class C20918 implements OnClickListener {
        final /* synthetic */ BackgroundLocationSettingsActivity f15007a;

        C20918(BackgroundLocationSettingsActivity backgroundLocationSettingsActivity) {
            this.f15007a = backgroundLocationSettingsActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -65559929);
            this.f15007a.f15032W.f15047a.a(BackgroundLocationSettingsAnalyticsLogger.m15503a("friends_nearby_settings_manage_location_services"));
            Preconditions.checkState(FbLocationStatus.b(this.f15007a.ae));
            if (this.f15007a.ae == State.LOCATION_DISABLED) {
                this.f15007a.m15487q();
            } else {
                this.f15007a.f15038s;
            }
            LogUtils.a(1091847244, a);
        }
    }

    /* compiled from: dialog_message */
    class C20929 implements OnClickListener {
        final /* synthetic */ BackgroundLocationSettingsActivity f15008a;

        C20929(BackgroundLocationSettingsActivity backgroundLocationSettingsActivity) {
            this.f15008a = backgroundLocationSettingsActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1450744137);
            this.f15008a.f15032W.f15047a.a(BackgroundLocationSettingsAnalyticsLogger.m15503a("friends_nearby_settings_invite_friends"));
            this.f15008a.m15477l();
            Logger.a(2, EntryType.UI_INPUT_END, 2006240067, a);
        }
    }

    /* compiled from: dialog_message */
    enum Task {
        LOCATION_SHARING_PRIVACY_WRITING,
        LOCATION_SHARING_PRIVACY_READING
    }

    private static <T extends Context> void m15444a(Class<T> cls, T t) {
        m15445a((Object) t, (Context) t);
    }

    public static void m15445a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BackgroundLocationSettingsActivity) obj).m15443a(GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), Toaster.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), FbLocationStatusUtil.a(injectorLike), BugReporter.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), BackgroundLocationSettingsAnalyticsLogger.m15504a(injectorLike), BackgroundLocationSettingsPerfLogger.m15506b(injectorLike), (ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), GooglePlayServicesLocationUpsellDialogController.b(injectorLike), SimpleLocationUpsellDialogFinishedListener.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public static void m15497v(BackgroundLocationSettingsActivity backgroundLocationSettingsActivity) {
        final GraphQlQueryString locationSharingPrivacyOptionsQueryString = new LocationSharingPrivacyOptionsQueryString();
        locationSharingPrivacyOptionsQueryString.a("n_upsell_results", Integer.valueOf(11));
        locationSharingPrivacyOptionsQueryString.a("image_scale", GraphQlQueryDefaults.a());
        locationSharingPrivacyOptionsQueryString.a("image_size", Integer.valueOf(64));
        backgroundLocationSettingsActivity.m15432F();
        backgroundLocationSettingsActivity.f15036q.a(Task.LOCATION_SHARING_PRIVACY_READING, new Callable<ListenableFuture<GraphQLResult<LocationSharingPrivacyOptionsQueryModel>>>(backgroundLocationSettingsActivity) {
            final /* synthetic */ BackgroundLocationSettingsActivity f14989b;

            public Object call() {
                return this.f14989b.f15037r.a(GraphQLRequest.a(locationSharingPrivacyOptionsQueryString));
            }
        }, new AbstractDisposableFutureCallback<GraphQLResult<LocationSharingPrivacyOptionsQueryModel>>(backgroundLocationSettingsActivity) {
            final /* synthetic */ BackgroundLocationSettingsActivity f14990a;

            {
                this.f14990a = r1;
            }

            protected final void m15420a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (!this.f14990a.af) {
                    this.f14990a.f15033X.m15508b(Marker.FETCH_DATA);
                    this.f14990a.f15033X.m15507a(Marker.RENDER);
                }
                this.f14990a.m15441a((LocationSharingPrivacyOptionsQueryModel) graphQLResult.e);
            }

            protected final void m15421a(Throwable th) {
                if (!this.f14990a.af) {
                    this.f14990a.f15033X.m15509c(Marker.FETCH_DATA);
                    this.f14990a.f15033X.m15509c(Marker.OVERALL_TTI);
                    this.f14990a.af = true;
                }
                BackgroundLocationSettingsActivity.m15433G(this.f14990a);
            }
        });
    }

    @Inject
    private void m15443a(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, SecureContextHelper secureContextHelper, Toaster toaster, AbstractFbErrorReporter abstractFbErrorReporter, FbLocationStatusUtil fbLocationStatusUtil, BugReporter bugReporter, GatekeeperStoreImpl gatekeeperStoreImpl, BackgroundLocationSettingsAnalyticsLogger backgroundLocationSettingsAnalyticsLogger, BackgroundLocationSettingsPerfLogger backgroundLocationSettingsPerfLogger, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, GooglePlayServicesLocationUpsellDialogController googlePlayServicesLocationUpsellDialogController, SimpleLocationUpsellDialogFinishedListener simpleLocationUpsellDialogFinishedListener, QeAccessor qeAccessor) {
        this.f15031V = gatekeeperStoreImpl;
        this.f15036q = tasksManager;
        this.f15037r = graphQLQueryExecutor;
        this.f15038s = defaultBlueServiceOperationFactory;
        this.f15027R = secureContextHelper;
        this.f15020K = toaster;
        this.f15028S = abstractFbErrorReporter;
        this.f15029T = fbLocationStatusUtil;
        this.f15030U = bugReporter;
        this.f15032W = backgroundLocationSettingsAnalyticsLogger;
        this.f15033X = backgroundLocationSettingsPerfLogger;
        this.f15034Y = activityRuntimePermissionsManagerProvider;
        this.aa = googlePlayServicesLocationUpsellDialogController;
        this.ab = simpleLocationUpsellDialogFinishedListener;
        this.ac = qeAccessor;
    }

    protected final void m15502b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = BackgroundLocationSettingsActivity.class;
        m15445a((Object) this, (Context) this);
        this.f15035Z = this.f15034Y.a(this);
        this.aa.a(this, this.ab);
        setContentView(2130903350);
        FbTitleBarUtil.b(this);
        Optional c = c(2131558563);
        if (c.isPresent()) {
            FbTitleBar fbTitleBar = (FbTitleBar) c.get();
            fbTitleBar.setTitle(2131239358);
            fbTitleBar.a(new C20885(this));
        }
        this.af = false;
        this.f15033X.m15507a(Marker.OVERALL_TTI);
        this.f15033X.m15507a(Marker.INIT);
        this.f15015F = a(2131559837);
        this.f15016G = a(2131559822);
        this.f15013D = a(2131559839);
        this.f15014E = (BackgroundLocationUpsellView) a(2131559840);
        this.f15017H = a(2131559834);
        this.f15018I = (TextView) a(2131559835);
        this.f15019J = (TextView) a(2131559836);
        m15475k();
        m15473j();
        m15480m();
        m15482n();
    }

    public void onResume() {
        Object obj = 1;
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -448607571);
        super.onResume();
        if (!this.af) {
            this.f15033X.m15508b(Marker.INIT);
            this.f15033X.m15507a(Marker.FETCH_DATA);
        }
        Object obj2 = (this.ae == null || this.ae == State.OKAY) ? 1 : null;
        this.ae = this.f15029T.a();
        if (this.ae != State.OKAY) {
            obj = null;
        }
        if (this.ad == TriState.YES && obj2 != null && r2 == null) {
            m15430D();
        }
        m15497v(this);
        m15499x();
        LogUtils.c(-1034461678, a);
    }

    public void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 760298426);
        super.onPause();
        this.af = true;
        this.f15036q.c();
        BackgroundLocationSettingsPerfLogger backgroundLocationSettingsPerfLogger = this.f15033X;
        for (Marker marker : Marker.values()) {
            backgroundLocationSettingsPerfLogger.f15048a.b(marker.eventId, marker.markerName);
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -791434270, a);
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -586843601);
        this.aa.a();
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 417774443, a);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            m15449b(i2);
        }
    }

    private void m15473j() {
        this.f15039t = (LocationSettingsOffView) a(2131559823);
        this.f15010A = (ImageBlockLayout) a(2131559831);
        this.f15045z = (TextView) a(2131559830);
        this.f15039t.setButtonListener(this.ag);
        this.f15010A.setOnClickListener(new C20896(this));
    }

    private void m15475k() {
        this.f15040u = (CompoundButton) a(2131559825);
        this.f15041v = (PopoverSpinner) a(2131559826);
        this.f15042w = (TextView) a(2131559827);
        this.f15043x = (TextView) a(2131559828);
        this.f15044y = (TextView) a(2131559829);
        this.f15045z = (TextView) a(2131559830);
        this.f15041v.setPopoverDimAmount(0.5f);
        this.f15041v.setOnItemSelectedListener(this.ai);
        this.f15043x.setOnClickListener(new C20907(this));
        this.f15044y.setOnClickListener(new C20918(this));
    }

    private void m15477l() {
        Intent intent = new Intent();
        intent.setData(Uri.parse(FBLinks.cS));
        this.f15027R.a(intent, this);
    }

    private void m15480m() {
        this.f15012C = (ImageBlockLayout) a(2131559832);
        this.f15012C.setOnClickListener(new C20929(this));
    }

    private void m15482n() {
        this.f15011B = (ImageBlockLayout) a(2131559833);
        if (this.f15031V.a(518, false)) {
            this.f15011B.setVisibility(0);
            this.f15011B.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ BackgroundLocationSettingsActivity f14986a;

                {
                    this.f14986a = r1;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -438359400);
                    this.f14986a.f15032W.f15047a.a(BackgroundLocationSettingsAnalyticsLogger.m15503a("friends_nearby_settings_report_problem"));
                    this.f14986a.f15030U.a(BugReportFlowStartParams.newBuilder().a(this.f14986a).a());
                    Logger.a(2, EntryType.UI_INPUT_END, -1130323010, a);
                }
            });
            return;
        }
        this.f15011B.setVisibility(8);
    }

    public static void m15483o(BackgroundLocationSettingsActivity backgroundLocationSettingsActivity) {
        backgroundLocationSettingsActivity.f15027R.a(new Intent("android.intent.action.VIEW", new Builder().scheme(FBLinks.a).authority("faceweb").path("f").appendQueryParameter("href", "/tour/locationsharing/learnmore").build()), backgroundLocationSettingsActivity);
    }

    public static void m15486p(BackgroundLocationSettingsActivity backgroundLocationSettingsActivity) {
        Intent intent = new Intent();
        intent.setData(Uri.parse(FBLinks.cZ));
        backgroundLocationSettingsActivity.f15027R.a(intent, backgroundLocationSettingsActivity);
    }

    private void m15487q() {
        this.f15027R.b(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), this);
    }

    public static void m15490r(BackgroundLocationSettingsActivity backgroundLocationSettingsActivity) {
        backgroundLocationSettingsActivity.f15035Z.a(FbLocationConstants.a, new AbstractRuntimePermissionsListener(backgroundLocationSettingsActivity) {
            final /* synthetic */ BackgroundLocationSettingsActivity f14987a;

            {
                this.f14987a = r1;
            }
        });
    }

    public static void m15492s(BackgroundLocationSettingsActivity backgroundLocationSettingsActivity) {
        backgroundLocationSettingsActivity.aa.a(new LocationSettingsRequestParams(), "surface_nearby_friends_settings", "mechanism_turn_on_button");
    }

    public static void m15494t(BackgroundLocationSettingsActivity backgroundLocationSettingsActivity) {
        Intent intent = new Intent(backgroundLocationSettingsActivity, BackgroundLocationOnePageNuxActivity.class);
        intent.putExtra("source", "settings_upsell");
        backgroundLocationSettingsActivity.f15027R.a(intent, 1, backgroundLocationSettingsActivity);
    }

    private void m15449b(int i) {
        if (i == 1 || i == 2) {
            m15497v(this);
        }
    }

    private boolean m15496u() {
        return this.f15029T.a() == State.OKAY;
    }

    private void m15441a(LocationSharingPrivacyOptionsQueryModel locationSharingPrivacyOptionsQueryModel) {
        Object obj = 1;
        this.f15025P = locationSharingPrivacyOptionsQueryModel.m15544a().m15531a();
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList a = locationSharingPrivacyOptionsQueryModel.m15546b().m15538a().m15321a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            BackgroundLocationPrivacyPickerOptionEdgeModel backgroundLocationPrivacyPickerOptionEdgeModel = (BackgroundLocationPrivacyPickerOptionEdgeModel) a.get(i);
            BackgroundLocationPrivacyPickerOptionModel c = backgroundLocationPrivacyPickerOptionEdgeModel.m15308c();
            boolean a2 = backgroundLocationPrivacyPickerOptionEdgeModel.m15306a();
            boolean b = backgroundLocationPrivacyPickerOptionEdgeModel.m15307b();
            if (a2) {
                this.f15021L = c;
            }
            if (b) {
                this.f15022M = c;
            }
            if ("{\"value\":\"ALL_FRIENDS\"}".equals(c.m15316c())) {
                this.f15023N = c;
            }
            if (m15461d(c)) {
                this.f15024O = c;
            } else {
                builder.c(c);
            }
        }
        if (this.f15023N == null || this.f15024O == null || this.f15021L == null) {
            this.f15028S.a("background_location_settings", "Must have Friends, Only Me, and current selection in the privacy setting options");
            m15433G(this);
            return;
        }
        Object obj2 = (m15498w() || !locationSharingPrivacyOptionsQueryModel.m15544a().m15532b()) ? null : 1;
        if (this.ad == TriState.UNSET) {
            obj = null;
        }
        if (obj2 != null) {
            FriendsSharingLocationConnectionModel a3 = locationSharingPrivacyOptionsQueryModel.m15544a().m15533c().m15525a();
            m15438a(a3.m15517a(), a3.m15521b());
            m15429C();
        } else {
            this.f15026Q = new BackgroundLocationPrivacyPickerOptionsAdapter();
            this.f15026Q.m15299a(builder.b());
            this.f15041v.setAdapter(this.f15026Q);
            m15451b(this, this.f15021L);
            m15428B();
        }
        if (obj == null && !m15496u() && m15498w()) {
            m15430D();
        }
    }

    public static void m15451b(BackgroundLocationSettingsActivity backgroundLocationSettingsActivity, BackgroundLocationPrivacyPickerOptionModel backgroundLocationPrivacyPickerOptionModel) {
        boolean z = true;
        boolean u = backgroundLocationSettingsActivity.m15496u();
        boolean z2 = backgroundLocationSettingsActivity.f15025P;
        boolean w = backgroundLocationSettingsActivity.m15498w();
        boolean z3 = w && u;
        backgroundLocationSettingsActivity.m15469g(w);
        backgroundLocationSettingsActivity.f15040u.setEnabled(u);
        backgroundLocationSettingsActivity.ad = TriState.valueOf(w);
        backgroundLocationSettingsActivity.m15452b(w);
        backgroundLocationSettingsActivity.m15456c(u);
        backgroundLocationSettingsActivity.m15465f(backgroundLocationSettingsActivity.f15026Q.f14851a.indexOf(backgroundLocationPrivacyPickerOptionModel));
        backgroundLocationSettingsActivity.m15458d(backgroundLocationSettingsActivity.m15435a(w, u));
        backgroundLocationSettingsActivity.m15460d(u);
        if (u) {
            z = false;
        }
        backgroundLocationSettingsActivity.m15464e(z);
        backgroundLocationSettingsActivity.m15467f(z3);
        if (!u && !w) {
            backgroundLocationSettingsActivity.m15500y();
        } else if (z2) {
            backgroundLocationSettingsActivity.m15462e(2131239366);
        } else {
            backgroundLocationSettingsActivity.m15462e(2131239367);
        }
    }

    private void m15438a(int i, ImmutableList<? extends BackgroundLocationUpsellProfile> immutableList) {
        this.f15014E.m15573a(i, immutableList, this.aj);
    }

    private boolean m15498w() {
        return this.f15025P && !m15461d(this.f15021L);
    }

    private void m15499x() {
        boolean b = FbLocationStatus.b(this.ae);
        this.f15039t.setVisibility(b ? 0 : 8);
        if (b) {
            int i = this.ae == State.LOCATION_DISABLED ? 2131239372 : 2131239373;
            int i2 = this.ae == State.LOCATION_DISABLED ? 2131239374 : 2131239375;
            this.f15039t.setDescriptionText(i);
            this.f15039t.setButtonText(i2);
        }
    }

    private void m15452b(boolean z) {
        this.f15041v.setVisibility(z ? 0 : 8);
    }

    private void m15456c(boolean z) {
        this.f15041v.setEnabled(z);
    }

    private void m15458d(int i) {
        this.f15042w.setText(i);
    }

    private int m15435a(boolean z, boolean z2) {
        if (z && z2) {
            return 2131239359;
        }
        if (z2) {
            return 2131239361;
        }
        Preconditions.checkState(FbLocationStatus.b(this.ae));
        if (this.ae == State.LOCATION_DISABLED) {
            if (z) {
                return 2131239360;
            }
            return 2131239362;
        } else if (z) {
            return 2131239363;
        } else {
            return 2131239364;
        }
    }

    private void m15460d(boolean z) {
        this.f15043x.setVisibility(z ? 0 : 8);
    }

    private void m15464e(boolean z) {
        this.f15044y.setVisibility(z ? 0 : 8);
        if (z) {
            Preconditions.checkState(FbLocationStatus.b(this.ae));
            this.f15044y.setText(this.ae == State.LOCATION_DISABLED ? 2131239365 : 2131239375);
        }
    }

    private void m15467f(boolean z) {
        this.f15012C.setVisibility(z ? 0 : 8);
    }

    private void m15462e(int i) {
        this.f15045z.setVisibility(0);
        this.f15045z.setText(i);
    }

    private void m15500y() {
        this.f15045z.setVisibility(8);
    }

    public static void m15501z(BackgroundLocationSettingsActivity backgroundLocationSettingsActivity) {
        BackgroundLocationPrivacyPickerOptionModel backgroundLocationPrivacyPickerOptionModel = backgroundLocationSettingsActivity.f15022M;
        if (backgroundLocationPrivacyPickerOptionModel == null || m15461d(backgroundLocationPrivacyPickerOptionModel)) {
            backgroundLocationPrivacyPickerOptionModel = backgroundLocationSettingsActivity.f15023N;
        }
        backgroundLocationSettingsActivity.m15442a(BackgroundLocationUpdateSettingsParams.a(true, backgroundLocationPrivacyPickerOptionModel.m15316c()), backgroundLocationPrivacyPickerOptionModel);
    }

    public static void m15427A(BackgroundLocationSettingsActivity backgroundLocationSettingsActivity) {
        backgroundLocationSettingsActivity.m15442a(BackgroundLocationUpdateSettingsParams.a(backgroundLocationSettingsActivity.f15024O.m15316c()), backgroundLocationSettingsActivity.f15024O);
    }

    public static void m15455c(BackgroundLocationSettingsActivity backgroundLocationSettingsActivity, BackgroundLocationPrivacyPickerOptionModel backgroundLocationPrivacyPickerOptionModel) {
        backgroundLocationSettingsActivity.m15442a(BackgroundLocationUpdateSettingsParams.a(backgroundLocationPrivacyPickerOptionModel.m15316c()), backgroundLocationPrivacyPickerOptionModel);
    }

    private void m15442a(final BackgroundLocationUpdateSettingsParams backgroundLocationUpdateSettingsParams, final BackgroundLocationPrivacyPickerOptionModel backgroundLocationPrivacyPickerOptionModel) {
        final DialogFragment a = ProgressDialogFragment.a(2131230739, true, false, true);
        a.a(kO_(), "write_privacy_setting_progress");
        this.f15036q.a(Task.LOCATION_SHARING_PRIVACY_WRITING, new Callable<ListenableFuture<OperationResult>>(this) {
            final /* synthetic */ BackgroundLocationSettingsActivity f14992b;

            public Object call() {
                Bundle bundle = new Bundle();
                bundle.putParcelable("BackgroundLocationUpdateSettingsParams", backgroundLocationUpdateSettingsParams);
                return BlueServiceOperationFactoryDetour.a(this.f14992b.f15038s, "background_location_update_settings", bundle, ErrorPropagation.BY_EXCEPTION, BackgroundLocationSettingsActivity.f15009p, 1818221335).a();
            }
        }, new AbstractDisposableFutureCallback<OperationResult>(this) {
            final /* synthetic */ BackgroundLocationSettingsActivity f14996d;

            protected final void m15422a(Object obj) {
                if (backgroundLocationUpdateSettingsParams.a.isPresent()) {
                    this.f14996d.f15025P = ((Boolean) backgroundLocationUpdateSettingsParams.a.get()).booleanValue();
                }
                if (BackgroundLocationSettingsActivity.m15461d(backgroundLocationPrivacyPickerOptionModel)) {
                    this.f14996d.f15022M = this.f14996d.f15021L;
                } else {
                    this.f14996d.f15022M = null;
                }
                this.f14996d.f15021L = backgroundLocationPrivacyPickerOptionModel;
                BackgroundLocationSettingsActivity.m15451b(this.f14996d, this.f14996d.f15021L);
                a.a();
            }

            protected final void m15423a(Throwable th) {
                BackgroundLocationSettingsActivity.m15451b(this.f14996d, this.f14996d.f15021L);
                a.a();
                this.f14996d.f15020K.b(new ToastBuilder(2131230758));
            }
        });
    }

    public static boolean m15461d(BackgroundLocationPrivacyPickerOptionModel backgroundLocationPrivacyPickerOptionModel) {
        return backgroundLocationPrivacyPickerOptionModel.m15316c().equals("{\"value\":\"SELF\"}");
    }

    private void m15469g(boolean z) {
        this.f15040u.setOnCheckedChangeListener(null);
        this.f15040u.setChecked(z);
        this.f15040u.setOnCheckedChangeListener(this.ah);
    }

    private void m15465f(int i) {
        this.f15041v.setSelection(i);
    }

    private void m15428B() {
        m15431E();
        this.f15015F.setVisibility(8);
        this.f15017H.setVisibility(8);
        this.f15016G.setVisibility(0);
        this.f15013D.setVisibility(8);
    }

    private void m15429C() {
        m15431E();
        this.f15015F.setVisibility(8);
        this.f15017H.setVisibility(8);
        this.f15016G.setVisibility(8);
        this.f15013D.setVisibility(0);
    }

    private void m15430D() {
        new AlertDialog.Builder(this).b(2131239371).a(2131230726, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ BackgroundLocationSettingsActivity f14997a;

            {
                this.f14997a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).b();
    }

    private void m15431E() {
        m15434H().a(new OnDispatchDrawListener(this) {
            final /* synthetic */ BackgroundLocationSettingsActivity f14998a;

            {
                this.f14998a = r1;
            }

            public final boolean m15424a() {
                if (!this.f14998a.af) {
                    this.f14998a.f15033X.m15508b(Marker.RENDER);
                    this.f14998a.f15033X.m15508b(Marker.OVERALL_TTI);
                    this.f14998a.af = true;
                }
                return true;
            }
        });
    }

    private void m15432F() {
        this.f15017H.setVisibility(8);
        this.f15016G.setVisibility(8);
        this.f15013D.setVisibility(8);
        this.f15015F.setVisibility(0);
    }

    public static void m15433G(BackgroundLocationSettingsActivity backgroundLocationSettingsActivity) {
        backgroundLocationSettingsActivity.m15446a(backgroundLocationSettingsActivity.getString(2131230758), backgroundLocationSettingsActivity.getString(2131230764));
    }

    private void m15446a(String str, String str2) {
        this.f15016G.setVisibility(8);
        this.f15013D.setVisibility(8);
        this.f15015F.setVisibility(8);
        this.f15017H.setVisibility(0);
        this.f15018I.setText(str);
        this.f15019J.setText(str2);
        this.f15017H.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BackgroundLocationSettingsActivity f14999a;

            {
                this.f14999a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 54154276);
                this.f14999a.ad = TriState.UNSET;
                BackgroundLocationSettingsActivity.m15497v(this.f14999a);
                Logger.a(2, EntryType.UI_INPUT_END, 71981162, a);
            }
        });
    }

    private CustomLinearLayout m15434H() {
        return (CustomLinearLayout) a(2131559838);
    }

    public final String am_() {
        return "friends_nearby_settings";
    }
}
