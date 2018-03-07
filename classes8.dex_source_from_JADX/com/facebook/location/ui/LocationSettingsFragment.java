package com.facebook.location.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.backgroundlocation.settings.read.BackgroundLocationSettingsReadGraphQL.LocationHistoryEnabledQueryString;
import com.facebook.backgroundlocation.settings.read.BackgroundLocationSettingsReadGraphQLModels.LocationHistoryEnabledQueryModel;
import com.facebook.backgroundlocation.settings.write.BackgroundLocationUpdateSettingsParams;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.location.FbLocationConstants;
import com.facebook.location.FbLocationStatus;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.location.gmsupsell.GooglePlayLocationServicesSettingsManager.LocationSettingsRequestParams;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController;
import com.facebook.location.gmsupsell.SimpleLocationUpsellDialogFinishedListener;
import com.facebook.location.ui.LocationSettingsPerfLogger.Marker;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.runtimepermissions.AbstractRuntimePermissionsListener;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.today.prefs.TodayPrefKeys;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.BetterSwitch;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.OnDispatchDrawListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

@UriMatchPatterns(fragment = ContentFragmentType.LOCATION_SETTINGS_FRAGMENT)
/* compiled from: displayContactInfo */
public class LocationSettingsFragment extends FbFragment implements AnalyticsFragment {
    public static final Class<?> f15266a = LocationSettingsFragment.class;
    private static final CallerContext f15267b = CallerContext.a(LocationSettingsFragment.class);
    public BetterSwitch aA;
    private TextView aB;
    private TextView aC;
    private View aD;
    private ViewGroup aE;
    private LocationSettingsOffView aF;
    private ViewGroup aG;
    private View aH;
    private View aI;
    private View aJ;
    private View aK;
    public boolean aL;
    public TriState aM = TriState.UNSET;
    public TriState aN = TriState.UNSET;
    public FbLocationStatus aO;
    public boolean aP;
    private final OnClickListener aQ = new C16641(this);
    private final OnCheckedChangeListener aR = new C16652(this);
    public SecureContextHelper al;
    private boolean am;
    public boolean an;
    private boolean ao;
    private ImmutableList<LocationSetting> ap;
    public LocationSettingsAnalyticsLogger aq;
    public LocationSettingsPerfLogger ar;
    public UriIntentMapper as;
    private ActivityRuntimePermissionsManagerProvider at;
    public ActivityRuntimePermissionsManager au;
    public GooglePlayServicesLocationUpsellDialogController av;
    private SimpleLocationUpsellDialogFinishedListener aw;
    private ViewGroup ax;
    private ViewGroup ay;
    private ImageBlockLayout az;
    private Clock f15268c;
    private TasksManager<Task> f15269d;
    private GraphQLQueryExecutor f15270e;
    private DefaultBlueServiceOperationFactory f15271f;
    private FbLocationStatusUtil f15272g;
    public FbSharedPreferences f15273h;
    public Toaster f15274i;

    /* compiled from: displayContactInfo */
    class C16641 implements OnClickListener {
        final /* synthetic */ LocationSettingsFragment f15254a;

        C16641(LocationSettingsFragment locationSettingsFragment) {
            this.f15254a = locationSettingsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -147634581);
            Preconditions.checkState(FbLocationStatus.b(this.f15254a.aO.a));
            if (this.f15254a.aO.a == State.LOCATION_DISABLED) {
                this.f15254a.av.a(new LocationSettingsRequestParams(), "surface_location_settings", "mechanism_turn_on_button");
            } else {
                LocationSettingsFragment locationSettingsFragment = this.f15254a;
                locationSettingsFragment.au.a(FbLocationConstants.a, new AbstractRuntimePermissionsListener(locationSettingsFragment) {
                    final /* synthetic */ LocationSettingsFragment f15248a;

                    {
                        this.f15248a = r1;
                    }
                });
            }
            LogUtils.a(1983994887, a);
        }
    }

    /* compiled from: displayContactInfo */
    class C16652 implements OnCheckedChangeListener {
        final /* synthetic */ LocationSettingsFragment f15255a;

        C16652(LocationSettingsFragment locationSettingsFragment) {
            this.f15255a = locationSettingsFragment;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z || !this.f15255a.aL) {
                this.f15255a.aq.m17687a(z);
                LocationSettingsFragment.m17696a(this.f15255a, z);
                return;
            }
            LocationSettingsFragment locationSettingsFragment = this.f15255a;
            new Builder(locationSettingsFragment.getContext()).b(2131239613).a(2131230726, new DialogInterface.OnClickListener(locationSettingsFragment) {
                final /* synthetic */ LocationSettingsFragment f15251a;

                {
                    this.f15251a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f15251a.aq.m17687a(false);
                    LocationSettingsFragment.m17696a(this.f15251a, false);
                }
            }).b(2131230727, new DialogInterface.OnClickListener(locationSettingsFragment) {
                final /* synthetic */ LocationSettingsFragment f15250a;

                {
                    this.f15250a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    LocationSettingsFragment.m17700h(this.f15250a, true);
                }
            }).a(new OnCancelListener(locationSettingsFragment) {
                final /* synthetic */ LocationSettingsFragment f15249a;

                {
                    this.f15249a = r1;
                }

                public void onCancel(DialogInterface dialogInterface) {
                    LocationSettingsFragment.m17700h(this.f15249a, true);
                }
            }).b();
        }
    }

    /* compiled from: displayContactInfo */
    class C16663 implements OnClickListener {
        final /* synthetic */ LocationSettingsFragment f15256a;

        C16663(LocationSettingsFragment locationSettingsFragment) {
            this.f15256a = locationSettingsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 924415619);
            LocationSettingsAnalyticsLogger locationSettingsAnalyticsLogger = this.f15256a.aq;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("location_settings_learn_more");
            honeyClientEvent.c = "background_location";
            locationSettingsAnalyticsLogger.f15247a.a(honeyClientEvent);
            LocationSettingsFragment locationSettingsFragment = this.f15256a;
            Uri build = new Uri.Builder().scheme("fb").authority("faceweb").path("f").appendQueryParameter("href", "/settings/location/learnmore").build();
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(build);
            locationSettingsFragment.al.a(intent, locationSettingsFragment.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, 794464327, a);
        }
    }

    /* compiled from: displayContactInfo */
    class C16674 implements OnClickListener {
        final /* synthetic */ LocationSettingsFragment f15257a;

        C16674(LocationSettingsFragment locationSettingsFragment) {
            this.f15257a = locationSettingsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1447080901);
            this.f15257a.aM = TriState.UNSET;
            LocationSettingsFragment.m17695a(this.f15257a, DisplayState.LOADING);
            LocationSettingsFragment.ar(this.f15257a);
            LocationSettingsFragment.at(this.f15257a);
            Logger.a(2, EntryType.UI_INPUT_END, -39311552, a);
        }
    }

    /* compiled from: displayContactInfo */
    class C16685 implements OnClickListener {
        final /* synthetic */ LocationSettingsFragment f15258a;

        C16685(LocationSettingsFragment locationSettingsFragment) {
            this.f15258a = locationSettingsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -510167795);
            Intent intent = new Intent();
            intent.setData(Uri.parse(FBLinks.cU));
            this.f15258a.al.a(intent, this.f15258a.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, 1954103181, a);
        }
    }

    /* compiled from: displayContactInfo */
    class C16696 implements OnClickListener {
        final /* synthetic */ LocationSettingsFragment f15259a;

        C16696(LocationSettingsFragment locationSettingsFragment) {
            this.f15259a = locationSettingsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1747698619);
            this.f15259a.al.a(this.f15259a.as.a(this.f15259a.getContext(), FBLinks.da).putExtra("extra_from_uri", FBLinks.cZ), this.f15259a.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, 583777396, a);
        }
    }

    /* compiled from: displayContactInfo */
    class C16707 extends AbstractDisposableFutureCallback<GraphQLResult<LocationHistoryEnabledQueryModel>> {
        final /* synthetic */ LocationSettingsFragment f15260a;

        C16707(LocationSettingsFragment locationSettingsFragment) {
            this.f15260a = locationSettingsFragment;
        }

        protected final void m17689a(Object obj) {
            boolean z;
            boolean z2;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            boolean z3 = false;
            if (!this.f15260a.aP) {
                this.f15260a.ar.m17712b(Marker.FETCH_DATA);
                this.f15260a.ar.m17711a(Marker.RENDER);
                LocationSettingsFragment locationSettingsFragment = this.f15260a;
                ((CustomFrameLayout) locationSettingsFragment.T).a(new OnDispatchDrawListener(locationSettingsFragment) {
                    final /* synthetic */ LocationSettingsFragment f15253a;

                    {
                        this.f15253a = r1;
                    }

                    public final boolean m17688a() {
                        if (!this.f15253a.aP) {
                            this.f15253a.ar.m17712b(Marker.RENDER);
                            this.f15253a.ar.m17712b(Marker.OVERALL_TTI);
                            this.f15253a.aP = true;
                        }
                        return true;
                    }
                });
            }
            this.f15260a.aL = ((LocationHistoryEnabledQueryModel) graphQLResult.e).m12561a().m12568a();
            boolean j = ((LocationHistoryEnabledQueryModel) graphQLResult.e).m12561a().m12569j();
            if (((LocationHistoryEnabledQueryModel) graphQLResult.e).m12561a().m12570k()) {
                z = false;
            } else {
                z = true;
            }
            boolean av = LocationSettingsFragment.av(this.f15260a);
            if (this.f15260a.aM != TriState.UNSET) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f15260a.aM = TriState.valueOf(j);
            this.f15260a.aN = TriState.valueOf(z);
            LocationSettingsFragment.m17700h(this.f15260a, j);
            LocationSettingsFragment locationSettingsFragment2 = this.f15260a;
            if (j && av) {
                z = true;
            } else {
                z = false;
            }
            LocationSettingsFragment.m17699b(locationSettingsFragment2, z);
            LocationSettingsFragment.m17697a(this.f15260a, j, av);
            LocationSettingsFragment.m17695a(this.f15260a, DisplayState.CONTENT);
            BetterSwitch betterSwitch = this.f15260a.aA;
            if (j || av) {
                z3 = true;
            }
            betterSwitch.setEnabled(z3);
            if (!(z2 || av || !j)) {
                LocationSettingsFragment.aB(this.f15260a);
            }
            LocationSettingsFragment.as(this.f15260a);
        }

        protected final void m17690a(Throwable th) {
            BLog.a(LocationSettingsFragment.f15266a, "Failed to load location history setting", th);
            if (!this.f15260a.aP) {
                this.f15260a.ar.m17713c(Marker.FETCH_DATA);
                this.f15260a.ar.m17713c(Marker.OVERALL_TTI);
                this.f15260a.aP = true;
            }
            LocationSettingsFragment.m17695a(this.f15260a, DisplayState.ERROR);
        }
    }

    /* compiled from: displayContactInfo */
    enum DisplayState {
        CONTENT,
        LOADING,
        ERROR
    }

    /* compiled from: displayContactInfo */
    enum Task {
        LOAD_HISTORY_SETTING,
        SAVE_HISTORY_SETTING
    }

    public static void m17698a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((LocationSettingsFragment) obj).m17693a((Clock) SystemClockMethodAutoProvider.a(injectorLike), TasksManager.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), DefaultBlueServiceOperationFactory.a(injectorLike), FbLocationStatusUtil.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), Toaster.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 706), IdBasedProvider.a(injectorLike, 4264), IdBasedProvider.a(injectorLike, 707), LocationServicesLocationSetting.m17678a(injectorLike), WifiLocationSetting.m17714a(injectorLike), GooglePlayServicesLocationSetting.m17672a(injectorLike), LocationSettingsAnalyticsLogger.m17684a(injectorLike), LocationSettingsPerfLogger.m17710a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), (ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), GooglePlayServicesLocationUpsellDialogController.a(injectorLike), SimpleLocationUpsellDialogFinishedListener.a(injectorLike));
    }

    @Inject
    private void m17693a(Clock clock, TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, BlueServiceOperationFactory blueServiceOperationFactory, FbLocationStatusUtil fbLocationStatusUtil, FbSharedPreferences fbSharedPreferences, Toaster toaster, SecureContextHelper secureContextHelper, Provider<TriState> provider, Provider<Boolean> provider2, Provider<TriState> provider3, LocationServicesLocationSetting locationServicesLocationSetting, WifiLocationSetting wifiLocationSetting, GooglePlayServicesLocationSetting googlePlayServicesLocationSetting, LocationSettingsAnalyticsLogger locationSettingsAnalyticsLogger, LocationSettingsPerfLogger locationSettingsPerfLogger, UriIntentMapper uriIntentMapper, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, GooglePlayServicesLocationUpsellDialogController googlePlayServicesLocationUpsellDialogController, SimpleLocationUpsellDialogFinishedListener simpleLocationUpsellDialogFinishedListener) {
        this.f15269d = tasksManager;
        this.f15270e = graphQLQueryExecutor;
        this.f15271f = blueServiceOperationFactory;
        this.f15272g = fbLocationStatusUtil;
        this.f15273h = fbSharedPreferences;
        this.f15274i = toaster;
        this.al = secureContextHelper;
        this.am = ((TriState) provider.get()).asBoolean(false);
        this.an = ((Boolean) provider2.get()).booleanValue();
        this.ao = ((TriState) provider3.get()).asBoolean(false);
        this.ap = ImmutableList.of(locationServicesLocationSetting, wifiLocationSetting, googlePlayServicesLocationSetting);
        this.aq = locationSettingsAnalyticsLogger;
        this.ar = locationSettingsPerfLogger;
        this.f15268c = clock;
        this.as = uriIntentMapper;
        this.at = activityRuntimePermissionsManagerProvider;
        this.av = googlePlayServicesLocationUpsellDialogController;
        this.aw = simpleLocationUpsellDialogFinishedListener;
    }

    public final void m17706c(Bundle bundle) {
        super.c(bundle);
        Class cls = LocationSettingsFragment.class;
        m17698a((Object) this, getContext());
        this.au = this.at.a(o());
        this.av.a(this, this.aw);
        this.aP = false;
        this.ar.m17711a(Marker.OVERALL_TTI);
        this.ar.m17711a(Marker.INIT);
    }

    public final View m17704a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1958992025);
        super.a(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(2130905133, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -542013111, a);
        return inflate;
    }

    public final void m17705a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.ax = (ViewGroup) e(2131563597);
        this.ay = (ViewGroup) e(2131563598);
        this.az = (ImageBlockLayout) e(2131563604);
        this.aA = (BetterSwitch) e(2131563605);
        this.aB = (TextView) e(2131563607);
        this.aC = (TextView) e(2131563609);
        this.aD = e(2131563606);
        this.aE = (ViewGroup) e(2131563610);
        this.aF = (LocationSettingsOffView) e(2131563612);
        this.aG = (ViewGroup) e(2131563613);
        this.aH = e(2131563614);
        this.aI = e(2131563615);
        this.aJ = e(2131563600);
        this.aK = e(2131563602);
        as(this);
    }

    public final void m17707d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -254518061);
        super.d(bundle);
        this.aF.setButtonListener(this.aQ);
        this.aC.setOnClickListener(new C16663(this));
        this.aI.setOnClickListener(new C16674(this));
        this.aJ.setOnClickListener(new C16685(this));
        this.aK.setOnClickListener(new C16696(this));
        if (!this.aP) {
            this.ar.m17712b(Marker.INIT);
            this.ar.m17711a(Marker.FETCH_DATA);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -807260332, a);
    }

    public final void m17701G() {
        boolean z = true;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1330864432);
        super.G();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131239605);
        }
        boolean z2 = this.aO == null || av(this);
        this.aO = this.f15272g.b();
        boolean av = av(this);
        if (this.aM == TriState.YES && z2 && !av) {
            aB(this);
        }
        aq();
        BetterSwitch betterSwitch = this.aA;
        z2 = this.aM == TriState.YES || av;
        betterSwitch.setEnabled(z2);
        if (!(this.aM.asBoolean(false) && av)) {
            z = false;
        }
        m17699b(this, z);
        DisplayState displayState = DisplayState.CONTENT;
        if (this.am) {
            displayState = DisplayState.LOADING;
            ar(this);
        }
        at(this);
        m17695a(this, displayState);
        LogUtils.f(-181890893, a);
    }

    public final void m17702H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1569117532);
        super.H();
        this.aP = true;
        LocationSettingsPerfLogger locationSettingsPerfLogger = this.ar;
        for (Marker marker : Marker.values()) {
            locationSettingsPerfLogger.f15277a.b(marker.markerId, marker.markerName);
        }
        this.f15269d.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -927187681, a);
    }

    public final void m17703I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -261392374);
        this.av.a();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2136454369, a);
    }

    private void aq() {
        ViewGroup viewGroup;
        int i = 0;
        this.ax.removeAllViews();
        if (av(this)) {
            this.ax.addView(this.ay);
            this.ax.addView(this.aE);
            aw();
            viewGroup = this.aG;
        } else {
            int i2;
            this.ax.addView(this.aE);
            this.ax.addView(this.ay);
            aw();
            if (FbLocationStatus.b(this.aO.a)) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            ViewGroup viewGroup2 = this.aG;
            if (i2 != 0) {
                viewGroup = viewGroup2;
            } else {
                i = 8;
                viewGroup = viewGroup2;
            }
        }
        viewGroup.setVisibility(i);
    }

    public static void ar(LocationSettingsFragment locationSettingsFragment) {
        Preconditions.checkState(locationSettingsFragment.am);
        locationSettingsFragment.aN = TriState.UNSET;
        locationSettingsFragment.f15269d.a(Task.LOAD_HISTORY_SETTING, locationSettingsFragment.f15270e.a(GraphQLRequest.a(new LocationHistoryEnabledQueryString())), new C16707(locationSettingsFragment));
    }

    public static void m17696a(LocationSettingsFragment locationSettingsFragment, final boolean z) {
        final DialogFragment a = ProgressDialogFragment.a(2131230739, true, false, true);
        a.a(locationSettingsFragment.kO_(), "save_setting_progress");
        Bundle bundle = new Bundle();
        bundle.putParcelable("BackgroundLocationUpdateSettingsParams", BackgroundLocationUpdateSettingsParams.a(z, "{\"value\":\"SELF\"}"));
        locationSettingsFragment.f15269d.a(Task.SAVE_HISTORY_SETTING, BlueServiceOperationFactoryDetour.a(locationSettingsFragment.f15271f, "background_location_update_settings", bundle, ErrorPropagation.BY_EXCEPTION, f15267b, 1338071693).a(), new AbstractDisposableFutureCallback<OperationResult>(locationSettingsFragment) {
            final /* synthetic */ LocationSettingsFragment f15263c;

            protected final void m17691a(Object obj) {
                boolean z = false;
                if (!z) {
                    this.f15263c.aL = false;
                }
                this.f15263c.aM = TriState.valueOf(z);
                boolean av = LocationSettingsFragment.av(this.f15263c);
                LocationSettingsFragment locationSettingsFragment = this.f15263c;
                boolean z2 = z && av;
                LocationSettingsFragment.m17699b(locationSettingsFragment, z2);
                BetterSwitch betterSwitch = this.f15263c.aA;
                if (z || av) {
                    z = true;
                }
                betterSwitch.setEnabled(z);
                LocationSettingsFragment.m17697a(this.f15263c, z, av);
                a.a();
                this.f15263c.f15273h.edit().putBoolean(TodayPrefKeys.f, true).commit();
            }

            protected final void m17692a(Throwable th) {
                boolean z = false;
                boolean z2 = !z;
                LocationSettingsFragment.m17700h(this.f15263c, z2);
                boolean av = LocationSettingsFragment.av(this.f15263c);
                BetterSwitch betterSwitch = this.f15263c.aA;
                if (z2 || av) {
                    z = true;
                }
                betterSwitch.setEnabled(z);
                LocationSettingsFragment.m17697a(this.f15263c, z2, av);
                a.a();
                this.f15263c.f15274i.b(new ToastBuilder(2131230758));
            }
        });
    }

    public static void as(LocationSettingsFragment locationSettingsFragment) {
        int i;
        int i2 = 0;
        boolean z = locationSettingsFragment.ao;
        Object obj = null;
        if (locationSettingsFragment.an) {
            Bundle bundle = locationSettingsFragment.s;
            int i3;
            if (bundle == null) {
                i3 = 1;
            } else if (!FBLinks.da.equals(bundle.getString("extra_from_uri"))) {
                i3 = 1;
            }
        }
        Object obj2 = obj;
        boolean z2 = locationSettingsFragment.am;
        int i4 = (z || obj2 != null || z2) ? 1 : 0;
        View view = locationSettingsFragment.aJ;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
        view = locationSettingsFragment.aK;
        if (obj2 != null) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
        ImageBlockLayout imageBlockLayout = locationSettingsFragment.az;
        if (z2) {
            i = 0;
        } else {
            i = 8;
        }
        imageBlockLayout.setVisibility(i);
        View view2 = locationSettingsFragment.aD;
        if (z2) {
            i = 0;
        } else {
            i = 8;
        }
        view2.setVisibility(i);
        ViewGroup viewGroup = locationSettingsFragment.ay;
        if (i4 == 0) {
            i2 = 8;
        }
        viewGroup.setVisibility(i2);
    }

    public static void at(LocationSettingsFragment locationSettingsFragment) {
        locationSettingsFragment.aG.removeAllViews();
        int size = locationSettingsFragment.ap.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            final LocationSetting locationSetting = (LocationSetting) locationSettingsFragment.ap.get(i);
            if (locationSetting.mo913a()) {
                LocationSettingRowView locationSettingRowView = new LocationSettingRowView(locationSettingsFragment.getContext());
                locationSettingRowView.f15244a.setText(locationSetting.mo914b());
                locationSettingRowView.f15245b.setText(locationSetting.mo915c());
                locationSettingRowView.setOnClickListener(new OnClickListener(locationSettingsFragment) {
                    final /* synthetic */ LocationSettingsFragment f15265b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 804534958);
                        LocationSettingsFragment.m17694a(this.f15265b, locationSetting);
                        Logger.a(2, EntryType.UI_INPUT_END, 2069949464, a);
                    }
                });
                locationSettingsFragment.aG.addView(locationSettingRowView);
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
        locationSettingsFragment.aE.setVisibility(obj != null ? 0 : 8);
    }

    public static void m17694a(LocationSettingsFragment locationSettingsFragment, LocationSetting locationSetting) {
        try {
            locationSetting.mo917e().send();
            locationSettingsFragment.aq.m17686a(locationSetting.mo916d());
        } catch (Throwable e) {
            BLog.a(f15266a, "Tip returned a PendingIntent that was cancelled", e);
            m17695a(locationSettingsFragment, DisplayState.ERROR);
        }
    }

    public static void m17695a(LocationSettingsFragment locationSettingsFragment, DisplayState displayState) {
        int i;
        int i2 = 0;
        ViewGroup viewGroup = locationSettingsFragment.ax;
        if (displayState == DisplayState.CONTENT) {
            i = 0;
        } else {
            i = 8;
        }
        viewGroup.setVisibility(i);
        View view = locationSettingsFragment.aH;
        if (displayState == DisplayState.LOADING) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
        View view2 = locationSettingsFragment.aI;
        if (displayState != DisplayState.ERROR) {
            i2 = 8;
        }
        view2.setVisibility(i2);
    }

    public static boolean av(LocationSettingsFragment locationSettingsFragment) {
        return locationSettingsFragment.aO.a == State.OKAY;
    }

    private void aw() {
        boolean b = FbLocationStatus.b(this.aO.a);
        this.aF.setVisibility(b ? 0 : 8);
        if (b) {
            int i = this.aO.a == State.LOCATION_DISABLED ? 2131239617 : 2131239618;
            int i2 = this.aO.a == State.LOCATION_DISABLED ? 2131239619 : 2131239620;
            this.aF.setDescriptionText(i);
            this.aF.setButtonText(i2);
        }
    }

    public static void m17699b(LocationSettingsFragment locationSettingsFragment, boolean z) {
        locationSettingsFragment.az.setThumbnailResource(z ? 2130841117 : 2130841116);
    }

    public static void m17700h(LocationSettingsFragment locationSettingsFragment, boolean z) {
        locationSettingsFragment.aA.setOnCheckedChangeListener(null);
        locationSettingsFragment.aA.setChecked(z);
        locationSettingsFragment.aA.setOnCheckedChangeListener(locationSettingsFragment.aR);
    }

    public static void m17697a(LocationSettingsFragment locationSettingsFragment, boolean z, boolean z2) {
        locationSettingsFragment.aB.setVisibility(z2 ? 8 : 0);
        if (!z2) {
            Preconditions.checkState(FbLocationStatus.b(locationSettingsFragment.aO.a));
            int i = z ? locationSettingsFragment.aO.a == State.LOCATION_DISABLED ? 2131239615 : 2131239621 : locationSettingsFragment.aO.a == State.LOCATION_DISABLED ? 2131239616 : 2131239622;
            locationSettingsFragment.aB.setText(i);
        }
    }

    public static void aB(LocationSettingsFragment locationSettingsFragment) {
        new Builder(locationSettingsFragment.getContext()).b(2131239614).a(2131230726, new DialogInterface.OnClickListener(locationSettingsFragment) {
            final /* synthetic */ LocationSettingsFragment f15252a;

            {
                this.f15252a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).b();
    }

    public final String am_() {
        return "location_settings";
    }
}
