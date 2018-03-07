package com.facebook.nearby.places;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ConnectivityManagerMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.logging.FLog;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.SecureHashUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.IntentResolver;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nearby.analytics.NearbyBrowseAnalytics;
import com.facebook.nearby.common.SearchSuggestion;
import com.facebook.nearby.maps.NearbyMapController;
import com.facebook.nearby.model.NearbyPlaceEdgeWrapper;
import com.facebook.nearby.module.C0058x587918b9;
import com.facebook.nearby.places.NearbyPlacesAdapter.StateType;
import com.facebook.nearby.prefs.NearbyPrefKeys;
import com.facebook.nearby.protocol.SearchArea;
import com.facebook.nearby.ui.InflatedLayoutLocationSetter;
import com.facebook.nearby.utils.NearbyUriUtil;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.ui.toaster.Toaster;
import com.facebook.view.inflation.DynamicLayoutInflater;
import com.facebook.widget.listview.SplitHideableListView;
import com.facebook.widget.listview.SplitHideableListView.OnSplitHeightChangedListener;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: unknown friendship status */
public class NearbyPlacesFragment extends FbFragment implements AnalyticsFragment {
    private static final Class<?> f498a = NearbyPlacesFragment.class;
    private ViewGroup aA;
    public SplitHideableListView aB;
    public DialogFragment aC;
    public ViewGroup aD;
    private View aE;
    public String aF = null;
    public FrameLayout aG;
    public ViewGroup aH;
    private NearbyPlaceSorter aI;
    private InflatedLayoutLocationSetter aJ;
    public SecureContextHelper al;
    public FbSharedPreferences am;
    public AbstractFbErrorReporter an;
    private AnalyticsTagger ao;
    private AnalyticsLogger ap;
    public NavigationLogger aq;
    public NearbyPlacesAdapter ar;
    public NearbyMapAreaFragment as;
    public Resources at;
    public Clock au;
    private DynamicLayoutInflater av;
    private FbTitleBarSupplier aw;
    public TriState ax;
    private boolean ay;
    private TextView az;
    private SearchSuggestion f499b;
    public boolean f500c;
    public NearbyBrowseAnalytics f501d;
    public FragmentManager f502e;
    private DefaultAndroidThreadUtil f503f;
    public ConnectivityManager f504g;
    private FbUriIntentHandler f505h;
    private UriIntentMapper f506i;

    /* compiled from: unknown friendship status */
    class C00731 implements OnItemClickListener {
        final /* synthetic */ NearbyPlacesFragment f489a;

        C00731(NearbyPlacesFragment nearbyPlacesFragment) {
            this.f489a = nearbyPlacesFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Object itemAtPosition = this.f489a.aB.getItemAtPosition(i);
            if (itemAtPosition instanceof NearbyPlaceEdgeWrapper) {
                NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper = (NearbyPlaceEdgeWrapper) itemAtPosition;
                boolean asBoolean = this.f489a.ax.asBoolean(false);
                boolean z = true;
                if (nearbyPlaceEdgeWrapper.f383b == null || asBoolean) {
                    if (nearbyPlaceEdgeWrapper.m498b() <= 0) {
                        z = false;
                    }
                } else if (nearbyPlaceEdgeWrapper.f383b.l() == null) {
                    z = false;
                }
                this.f489a.f501d.m385a(nearbyPlaceEdgeWrapper.m499c(), z, this.f489a.aF);
                this.f489a.aq.a("via_nearby_result");
                List arrayList = new ArrayList();
                List list = this.f489a.ar.f486n;
                for (int i2 = 0; i2 < i - 1; i2++) {
                    arrayList.add(((NearbyPlaceEdgeWrapper) list.get(i2)).m499c());
                }
                NearbyPlacesFragment.m586a(this.f489a, nearbyPlaceEdgeWrapper, arrayList);
                return;
            }
            this.f489a.an.a("nearby_places", "got non NearbyPlaceEdgeWrapper item for index: " + i + ", item: " + itemAtPosition);
        }
    }

    /* compiled from: unknown friendship status */
    class C00742 implements OnClickListener {
        final /* synthetic */ NearbyPlacesFragment f490a;

        C00742(NearbyPlacesFragment nearbyPlacesFragment) {
            this.f490a = nearbyPlacesFragment;
        }

        public void onClick(View view) {
            boolean z;
            int a = Logger.a(2, EntryType.UI_INPUT_START, 700365044);
            NearbyBrowseAnalytics nearbyBrowseAnalytics = this.f490a.f501d;
            String str = this.f490a.aF;
            if (this.f490a.as.m555e() != null) {
                z = true;
            } else {
                z = false;
            }
            HoneyClientEventFast a2 = nearbyBrowseAnalytics.f297a.a("navigate_to_search_button", true);
            if (a2.a()) {
                a2.a("places_recommendations").a("session_id", str).a("user_location_known", z);
                a2.b();
            }
            this.f490a.am.edit().putBoolean(NearbyPrefKeys.f509c, true).commit();
            NearbyPlacesFragment.at(this.f490a);
            LogUtils.a(1182062460, a);
        }
    }

    /* compiled from: unknown friendship status */
    class C00753 implements OnSplitHeightChangedListener {
        final /* synthetic */ NearbyPlacesFragment f491a;
        private int f492b = -1;
        private int f493c = -1;

        C00753(NearbyPlacesFragment nearbyPlacesFragment) {
            this.f491a = nearbyPlacesFragment;
        }

        public final void m582a(int i) {
            LayoutParams layoutParams = (LayoutParams) this.f491a.aG.getLayoutParams();
            if (layoutParams.topMargin != i) {
                layoutParams.topMargin = i;
                this.f491a.aG.setLayoutParams(layoutParams);
            }
            if (this.f492b == -1) {
                this.f492b = i;
                this.f493c = this.f492b;
                return;
            }
            if (Math.abs(this.f492b - this.f493c) > 0) {
                NearbyPlacesFragment.aC(this.f491a);
            }
            this.f492b = i;
        }

        public final void m581a() {
            Set aq = this.f491a.as.aq();
            if (aq != null) {
                this.f491a.m594a(aq);
            }
            NearbyPlacesFragment.aC(this.f491a);
            this.f491a.as.at();
        }
    }

    /* compiled from: unknown friendship status */
    class C00764 implements FutureCallback<Void> {
        final /* synthetic */ NearbyPlacesFragment f494a;

        C00764(NearbyPlacesFragment nearbyPlacesFragment) {
            this.f494a = nearbyPlacesFragment;
        }

        public void onSuccess(Object obj) {
            this.f494a.m601f();
            this.f494a.as.az = true;
            this.f494a.as.m551b(this.f494a.au.a(), true);
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: unknown friendship status */
    public class LocationSourcesDialogFragment extends DialogFragment {
        public NearbyBrowseAnalytics al;
        public SecureContextHelper am;

        /* compiled from: unknown friendship status */
        class C00771 implements DialogInterface.OnClickListener {
            final /* synthetic */ LocationSourcesDialogFragment f495a;

            C00771(LocationSourcesDialogFragment locationSourcesDialogFragment) {
                this.f495a = locationSourcesDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                HoneyClientEventFast a = this.f495a.al.f297a.a("opened_location_setting", true);
                if (a.a()) {
                    a.a("places_recommendations");
                    a.b();
                }
                Context context = this.f495a.getContext();
                SecureContextHelper secureContextHelper = this.f495a.am;
                Intent intent = null;
                if (IntentResolver.a(context, "android.settings.LOCATION_SOURCE_SETTINGS")) {
                    intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                } else if (IntentResolver.a(context, "android.settings.SETTINGS")) {
                    intent = new Intent("android.settings.SETTINGS");
                }
                Intent intent2 = intent;
                if (intent2 == null) {
                    Toaster.a(context, context.getResources().getString(2131236624));
                } else {
                    secureContextHelper.b(intent2, context);
                }
            }
        }

        /* compiled from: unknown friendship status */
        class C00782 implements DialogInterface.OnClickListener {
            final /* synthetic */ LocationSourcesDialogFragment f496a;

            C00782(LocationSourcesDialogFragment locationSourcesDialogFragment) {
                this.f496a = locationSourcesDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                ((NearbyPlacesFragment) this.f496a.t).m602i();
                dialogInterface.dismiss();
            }
        }

        public void onCancel(DialogInterface dialogInterface) {
            ((NearbyPlacesFragment) this.t).m602i();
        }

        public final void m583a(Fragment fragment, int i) {
            if (fragment instanceof NearbyPlacesFragment) {
                super.a(fragment, i);
                NearbyPlacesFragment nearbyPlacesFragment = (NearbyPlacesFragment) fragment;
                this.al = nearbyPlacesFragment.f501d;
                this.am = nearbyPlacesFragment.al;
                return;
            }
            throw new IllegalArgumentException("Target fragment must be of type NearbyPlacesFragment");
        }

        public final Dialog m584c(Bundle bundle) {
            Builder builder = new Builder(getContext());
            builder.a(2131236625);
            builder.b(2131236627);
            builder.a(2131236637, new C00771(this));
            builder.b(2131236638, new C00782(this));
            HoneyClientEventFast a = this.al.f297a.a("viewed_with_location_off", true);
            if (a.a()) {
                a.a("places_recommendations");
                a.b();
            }
            return builder.a();
        }
    }

    /* compiled from: unknown friendship status */
    public class NetworkErrorDialogFragment extends DialogFragment {

        /* compiled from: unknown friendship status */
        class C00791 implements DialogInterface.OnClickListener {
            final /* synthetic */ NetworkErrorDialogFragment f497a;

            C00791(NetworkErrorDialogFragment networkErrorDialogFragment) {
                this.f497a = networkErrorDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }

        public final Dialog m585c(Bundle bundle) {
            Builder builder = new Builder(getContext());
            builder.a(2131236616);
            builder.b(2131236617);
            builder.a(2131230756, new C00791(this));
            return builder.a();
        }
    }

    public final void m596c(Bundle bundle) {
        super.c(bundle);
        InjectorLike an = an();
        this.ao = AnalyticsTagger.a(an);
        this.aI = NearbyPlaceSorter.m565a(an);
    }

    public final void m598d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1590386980);
        super.d(bundle);
        if (bundle != null) {
            this.f499b = (SearchSuggestion) bundle.getParcelable("currentSearchSuggestion");
            this.f500c = bundle.getBoolean("wasSearchButtonNuxShown");
        }
        if (this.f499b == null && ao() != null && ao().getIntent() != null && ao().getIntent().hasExtra("result_place_search_suggestion")) {
            this.f499b = (SearchSuggestion) ao().getIntent().getParcelableExtra("result_place_search_suggestion");
        }
        FbInjector an = an();
        this.f502e = this.D;
        this.f501d = NearbyBrowseAnalytics.m376b(an);
        this.f503f = DefaultAndroidThreadUtil.b(an);
        this.f504g = ConnectivityManagerMethodAutoProvider.b(an);
        this.f505h = FbUriIntentHandler.a(an);
        this.f506i = (UriIntentMapper) Fb4aUriIntentMapper.a(an);
        this.aJ = InflatedLayoutLocationSetter.m1064b(an);
        this.at = ResourcesMethodAutoProvider.a(an);
        this.al = (SecureContextHelper) DefaultSecureContextHelper.a(an);
        this.am = (FbSharedPreferences) FbSharedPreferencesImpl.a(an);
        this.an = (AbstractFbErrorReporter) FbErrorReporterImpl.a(an);
        this.au = (Clock) SystemClockMethodAutoProvider.a(an);
        this.av = DynamicLayoutInflater.b(an);
        this.ap = AnalyticsLoggerMethodAutoProvider.a(an);
        this.aq = NavigationLogger.a(an);
        this.aw = (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(an);
        this.ax = C0058x587918b9.m518b(an);
        this.aB = (SplitHideableListView) e(2131564084);
        this.aB.setOnItemClickListener(new C00731(this));
        this.aG = (FrameLayout) e(2131564083);
        View inflate = b(bundle).inflate(2130905378, this.aB, false);
        Fragment a2 = s().a("nearbyMapAreaFragment");
        if (a2 == null) {
            this.as = new NearbyMapAreaFragment();
            if (this.s != null) {
                this.as.g(this.s);
            }
            s().a().b(2131564064, this.as, "nearbyMapAreaFragment").b();
        } else {
            this.as = (NearbyMapAreaFragment) a2;
        }
        this.aE = inflate;
        this.aB.setExpandableHeader(this.aE);
        this.aH = (ViewGroup) e(2131564081);
        this.as.au = this.f499b;
        this.as.aP = this;
        this.az = (TextView) e(2131564087);
        this.aA = (ViewGroup) e(2131564085);
        this.aA.setOnClickListener(new C00742(this));
        this.ar = new NearbyPlacesAdapter(this.aJ, this.an, this.av, getContext());
        this.aB.setAdapter(this.ar);
        this.aB.h = new C00753(this);
        this.aD = (ViewGroup) e(2131564088);
        if (this.f499b != null) {
            this.az.setText(this.f499b.a);
        } else if (NearbyUriUtil.m1068a(ao(), this)) {
            this.az.setText(2131236607);
        }
        Fragment a3 = this.f502e.a("locationServicesDialog");
        if (a3 != null) {
            a3.a(this, 0);
        }
        LogUtils.f(1548374067, a);
    }

    public final void m599e() {
        if (this.y && this.f502e.a("locationServicesDialog") == null) {
            this.aH.setVisibility(0);
            this.aC = new LocationSourcesDialogFragment();
            this.aC.a(this, 0);
            this.aC.a(this.f502e, "locationServicesDialog");
        }
    }

    public final View m592a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1982412269);
        View inflate = layoutInflater.inflate(2130905384, viewGroup, false);
        this.ao.a(inflate, "nearby_places", this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -561242776, a);
        return inflate;
    }

    public final void m600e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("currentSearchSuggestion", this.f499b);
        bundle.putBoolean("wasSearchButtonNuxShown", this.f500c);
    }

    public final void m589G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 537073325);
        super.G();
        if (au()) {
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1834835455, a);
            return;
        }
        this.aH.setVisibility(0);
        if (this.ar.f486n.isEmpty()) {
            Collection aq = this.as.aq();
            if (aq == null) {
                m601f();
            } else {
                List arrayList = new ArrayList(aq);
                if (!this.ay) {
                    arrayList = this.aI.m567a(arrayList);
                }
                arrayList = NearbyPlaceSorter.m566c(this.aI.m567a(arrayList));
                m588b(arrayList);
                this.ar.m579a(arrayList, this.as.m555e());
            }
        }
        LogUtils.f(-89992052, a);
    }

    public final void m590H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 96305578);
        super.H();
        if (this.aC != null) {
            this.aC.b();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1913970907, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1911015329);
        super.mi_();
        ((FbTitleBar) this.aw.get()).setTitle(2131236610);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -553999761, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1939665043);
        ((FbTitleBar) this.aw.get()).setTitle(null);
        super.mj_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1790243459, a);
    }

    public final void m601f() {
        az();
        BaseAdapter baseAdapter = this.ar;
        baseAdapter.f487o = StateType.LOADING_PLACES;
        AdapterDetour.a(baseAdapter, 1554004488);
    }

    public final void m602i() {
        az();
        BaseAdapter baseAdapter = this.ar;
        baseAdapter.f487o = StateType.DETECT_LOCATION_FAILED;
        AdapterDetour.a(baseAdapter, -1883431675);
    }

    public final void m591I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 675456772);
        super.I();
        if (this.as != null) {
            this.as.aP = null;
            this.as.av();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -263480446, a);
    }

    public final void m594a(Set<NearbyPlaceEdgeWrapper> set) {
        m587a(this.aI.m567a(new ArrayList(set)));
    }

    public final void m595a(Set<NearbyPlaceEdgeWrapper> set, List<NearbyPlaceEdgeWrapper> list) {
        Set hashSet = new HashSet(set);
        List arrayList = new ArrayList();
        for (NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper : list) {
            if (hashSet.remove(nearbyPlaceEdgeWrapper)) {
                arrayList.add(nearbyPlaceEdgeWrapper);
            }
        }
        m587a(arrayList);
    }

    private void m587a(List<NearbyPlaceEdgeWrapper> list) {
        List c = NearbyPlaceSorter.m566c(list);
        if (!(this.am.a(NearbyPrefKeys.f509c, false) || this.f500c)) {
            this.f500c = true;
            this.aD.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130968676));
            this.aD.setVisibility(0);
        }
        m588b(c);
        this.ar.m579a(c, this.as.m555e());
        if (c.isEmpty()) {
            az();
            return;
        }
        this.aB.setDivider(this.at.getDrawable(2131361860));
        this.aB.setDividerHeight((int) TypedValue.applyDimension(1, 1.0f, this.at.getDisplayMetrics()));
    }

    public final String am_() {
        return "nearby_places";
    }

    public static void at(NearbyPlacesFragment nearbyPlacesFragment) {
        aC(nearbyPlacesFragment);
        Intent a = nearbyPlacesFragment.f506i.a(nearbyPlacesFragment.getContext(), FBLinks.bq);
        if (a == null) {
            FLog.a(f498a, "Failed resolving nearby search uri");
            throw new RuntimeException("Missing binding for nearby search URI");
        }
        a.putExtra("user_location", nearbyPlacesFragment.as.m555e());
        NearbyMapAreaFragment nearbyMapAreaFragment = nearbyPlacesFragment.as;
        Location b = nearbyMapAreaFragment.aB.f378l.b();
        NearbyMapController nearbyMapController = nearbyMapAreaFragment.aB;
        a.putExtra("search_area", new SearchArea(b, (int) Math.floor((double) Math.min(nearbyMapController.m476d().distanceTo(nearbyMapController.f378l.au()) / 2.0f, nearbyMapController.m476d().distanceTo(nearbyMapController.f378l.av()) / 2.0f))));
        a.putExtra("user_defined_search_location", nearbyPlacesFragment.as.aA);
        nearbyPlacesFragment.a(a, 1);
    }

    public final void m593a(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 1) {
            ListenableFuture a;
            this.f499b = (SearchSuggestion) intent.getParcelableExtra("result_place_search_suggestion");
            this.as.au = this.f499b;
            this.az.setText(this.f499b.a);
            DefaultAndroidThreadUtil defaultAndroidThreadUtil = this.f503f;
            NearbyMapAreaFragment nearbyMapAreaFragment = this.as;
            if (nearbyMapAreaFragment.au == null || nearbyMapAreaFragment.au.c == null) {
                a = Futures.a(null);
            } else {
                a = nearbyMapAreaFragment.aB.m465a(NearbyMapAreaFragment.m530a(nearbyMapAreaFragment.au.c));
            }
            defaultAndroidThreadUtil.a(a, new C00764(this));
        }
    }

    public final void m597d() {
        az();
        this.ar.m580c();
    }

    public final void m603j() {
        az();
        BaseAdapter baseAdapter = this.ar;
        baseAdapter.f487o = StateType.DEFAULT_SERVICE_ERROR;
        AdapterDetour.a(baseAdapter, -1155397027);
    }

    public static void m586a(NearbyPlacesFragment nearbyPlacesFragment, NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper, List list) {
        Parcelable e = nearbyPlacesFragment.as.m555e();
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.af, nearbyPlaceEdgeWrapper.m499c());
        String b = SecureHashUtil.b(nearbyPlaceEdgeWrapper.m499c() + nearbyPlacesFragment.au.a());
        if (e != null) {
            nearbyPlacesFragment.f501d.m383a(nearbyPlaceEdgeWrapper.m499c(), nearbyPlacesFragment.aF, b, e.getLatitude(), e.getLongitude(), e.getAccuracy(), list);
        } else {
            nearbyPlacesFragment.f501d.m384a(nearbyPlaceEdgeWrapper.m499c(), nearbyPlacesFragment.aF, b, list);
        }
        Bundle bundle = new Bundle();
        ModelBundle.b(bundle, nearbyPlaceEdgeWrapper.m499c(), nearbyPlaceEdgeWrapper.m504h(), nearbyPlaceEdgeWrapper.m508m());
        bundle.putParcelable("extra_user_location", e);
        if (!nearbyPlacesFragment.f505h.a(nearbyPlacesFragment.getContext(), formatStrLocaleSafe, bundle)) {
            FLog.b(f498a, "Failed navigating to page id = %s ", new Object[]{nearbyPlaceEdgeWrapper.m499c()});
        }
    }

    private boolean au() {
        Object obj;
        NetworkInfo activeNetworkInfo = this.f504g.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            return false;
        }
        if (this.y && this.f502e.a("networkErrorDialog") == null) {
            this.aC = new NetworkErrorDialogFragment();
            this.aC.a(this.f502e, "networkErrorDialog");
        }
        az();
        this.ar.m580c();
        return true;
    }

    private void az() {
        this.aB.setDivider(null);
        this.aB.setDividerHeight(0);
    }

    public static void aC(NearbyPlacesFragment nearbyPlacesFragment) {
        nearbyPlacesFragment.f500c = true;
        if (nearbyPlacesFragment.aD.getVisibility() == 0) {
            nearbyPlacesFragment.aD.startAnimation(AnimationUtils.loadAnimation(nearbyPlacesFragment.getContext(), 2130968677));
            nearbyPlacesFragment.aD.setVisibility(8);
        }
    }

    private void m588b(List<NearbyPlaceEdgeWrapper> list) {
        Object obj;
        for (NearbyPlaceEdgeWrapper e : list) {
            if (!StringUtil.a(e.m501e())) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj != null) {
            this.ar = new NearbyPlacesAdapter(this.aJ, this.an, this.av, getContext());
            this.aB.setAdapter(this.ar);
        }
    }
}
