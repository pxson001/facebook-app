package com.facebook.nearby.v2;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.location.FbLocationManagerParams.Priority;
import com.facebook.location.FbLocationOperation;
import com.facebook.location.FbLocationOperationParams;
import com.facebook.location.FbLocationOperationParams.Builder;
import com.facebook.location.ImmutableLocation;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController.GoogleLocationDialogResult;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController.OnGooglePlayServicesLocationUpsellDialogFinishedListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nearby.v2.abtest.ExperimentsForNearbyPlacesModule;
import com.facebook.nearby.v2.intent.NearbyPlacesV2IntentFragment;
import com.facebook.nearby.v2.logging.NearbyPlacesSession.EntryPoint;
import com.facebook.nearby.v2.logging.NearbyPlacesSession.ImpressionSource;
import com.facebook.nearby.v2.model.LocationStatusUtil;
import com.facebook.nearby.v2.model.LocationStatusUtil.LocationStatus;
import com.facebook.nearby.v2.model.NearbyPlacesFragmentModel;
import com.facebook.nearby.v2.model.NearbyPlacesResultListQueryTopic;
import com.facebook.nearby.v2.model.NearbyPlacesSearchDataModel;
import com.facebook.nearby.v2.resultlist.NearbyPlacesV2ResultsFragment;
import com.facebook.nearby.v2.resultlist.NearbyPlacesV2ResultsFragment.Options;
import com.facebook.nearby.v2.typeahead.NearbyPlacesTypeaheadFragment;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.runtimepermissions.AbstractRuntimePermissionsListener;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: topLoadEnd */
public class NearbyPlacesV2Fragment extends FbFragment implements AnalyticsFragment, CanHandleBackPressed, OnGooglePlayServicesLocationUpsellDialogFinishedListener {
    public static final CallerContext f798h = CallerContext.a(NearbyPlacesV2Fragment.class);
    public static final String[] f799i = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    @Inject
    FbLocationOperation f800a;
    public final FbLocationOperationParams al;
    private final OnBackStackChangedListener am;
    private boolean an;
    private boolean ao;
    private boolean ap;
    private ViewGroup aq;
    public NearbyPlacesTypeaheadFragment ar;
    public NearbyPlacesFragmentModel as;
    public ContentFragmentViewState at;
    public ActivityRuntimePermissionsManager au;
    public Options av;
    @Inject
    Provider<FbLocationOperation> f801b;
    @Inject
    TasksManager f802c;
    @Inject
    ActivityRuntimePermissionsManagerProvider f803d;
    @Inject
    public GooglePlayServicesLocationUpsellDialogController f804e;
    @Inject
    public QeAccessor f805f;
    @Inject
    LocationStatusUtil f806g;

    /* compiled from: topLoadEnd */
    class C01001 implements OnBackStackChangedListener {
        final /* synthetic */ NearbyPlacesV2Fragment f787a;

        C01001(NearbyPlacesV2Fragment nearbyPlacesV2Fragment) {
            this.f787a = nearbyPlacesV2Fragment;
        }

        public final void le_() {
            NearbyPlacesV2Fragment.av(this.f787a);
            if (this.f787a.at == ContentFragmentViewState.INTENT_VIEW_FRAGMENT) {
                this.f787a.as.b.h = null;
                NearbyPlacesV2Fragment.au(this.f787a);
            }
        }
    }

    /* compiled from: topLoadEnd */
    class C01022 implements RuntimePermissionsListener {
        final /* synthetic */ NearbyPlacesV2Fragment f789a;

        /* compiled from: topLoadEnd */
        class C01011 extends AbstractDisposableFutureCallback<ImmutableLocation> {
            final /* synthetic */ C01022 f788a;

            C01011(C01022 c01022) {
                this.f788a = c01022;
            }

            protected final void m1070a(Object obj) {
                NearbyPlacesV2Fragment.m1080a(this.f788a.f789a, (ImmutableLocation) obj);
            }

            protected final void m1071a(Throwable th) {
                NearbyPlacesV2Fragment.m1082a(this.f788a.f789a, LocationStatus.DEVICE_NON_OPTIMAL_LOCATION_SETTING);
            }
        }

        C01022(NearbyPlacesV2Fragment nearbyPlacesV2Fragment) {
            this.f789a = nearbyPlacesV2Fragment;
        }

        public final void m1072a() {
            this.f789a.f800a = (FbLocationOperation) this.f789a.f801b.get();
            this.f789a.f800a.a(this.f789a.al, NearbyPlacesV2Fragment.f798h);
            this.f789a.f802c.a("nearby_places_get_location_task_key", this.f789a.f800a, new C01011(this));
        }

        public final void m1073a(String[] strArr, String[] strArr2) {
            NearbyPlacesV2Fragment.m1082a(this.f789a, LocationStatus.LOCATION_PERMISSION_OFF);
        }

        public final void m1074b() {
            NearbyPlacesV2Fragment.m1082a(this.f789a, LocationStatus.LOCATION_PERMISSION_OFF);
        }
    }

    /* compiled from: topLoadEnd */
    public class C01033 extends OnToolbarButtonListener {
        final /* synthetic */ NearbyPlacesV2Fragment f790a;

        public C01033(NearbyPlacesV2Fragment nearbyPlacesV2Fragment) {
            this.f790a = nearbyPlacesV2Fragment;
        }

        public final void m1075a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            switch (this.f790a.at) {
                case RESULT_LIST_FRAGMENT:
                    NearbyPlacesV2Fragment.m1081a(this.f790a, ContentFragmentViewState.MAP_VIEW_FRAGMENT);
                    return;
                case MAP_VIEW_FRAGMENT:
                    NearbyPlacesV2Fragment.m1081a(this.f790a, ContentFragmentViewState.RESULT_LIST_FRAGMENT);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: topLoadEnd */
    public class C01044 extends AbstractRuntimePermissionsListener {
        final /* synthetic */ NearbyPlacesV2Fragment f791a;

        public C01044(NearbyPlacesV2Fragment nearbyPlacesV2Fragment) {
            this.f791a = nearbyPlacesV2Fragment;
        }
    }

    /* compiled from: topLoadEnd */
    public /* synthetic */ class C01055 {
        public static final /* synthetic */ int[] f793b = new int[LocationStatus.values().length];

        static {
            try {
                f793b[LocationStatus.DEVICE_LOCATION_OFF.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f793b[LocationStatus.DEVICE_NON_OPTIMAL_LOCATION_SETTING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f793b[LocationStatus.LOCATION_PERMISSION_OFF.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            f792a = new int[ContentFragmentViewState.values().length];
            try {
                f792a[ContentFragmentViewState.INTENT_VIEW_FRAGMENT.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f792a[ContentFragmentViewState.RESULT_LIST_FRAGMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f792a[ContentFragmentViewState.MAP_VIEW_FRAGMENT.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* compiled from: topLoadEnd */
    public class AnimationState {
        public int f794a;
        public int f795b;
        public int f796c;
        public int f797d;

        public AnimationState(int i, int i2, int i3, int i4) {
            this.f794a = i2;
            this.f795b = i;
            this.f796c = i4;
            this.f797d = i3;
        }
    }

    /* compiled from: topLoadEnd */
    public enum ContentFragmentViewState {
        INTENT_VIEW_FRAGMENT,
        RESULT_LIST_FRAGMENT,
        MAP_VIEW_FRAGMENT
    }

    public static void m1084a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((NearbyPlacesV2Fragment) obj).m1079a(FbLocationOperation.b(fbInjector), IdBasedProvider.a(fbInjector, 2481), TasksManager.b(fbInjector), (ActivityRuntimePermissionsManagerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), GooglePlayServicesLocationUpsellDialogController.b(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), LocationStatusUtil.a(fbInjector));
    }

    public NearbyPlacesV2Fragment() {
        Builder c = FbLocationOperationParams.a(Priority.HIGH_ACCURACY).c(60000);
        c.b = 20000;
        this.al = c.a();
        this.am = new C01001(this);
        this.an = true;
        this.ao = true;
        this.at = ContentFragmentViewState.INTENT_VIEW_FRAGMENT;
        this.av = null;
    }

    public final void m1093c(Bundle bundle) {
        super.c(bundle);
        Class cls = NearbyPlacesV2Fragment.class;
        m1084a((Object) this, getContext());
        this.f804e.a(this, this);
    }

    public final void m1094d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -303165584);
        super.d(bundle);
        this.au = this.f803d.a(o());
        if (bundle != null) {
            this.an = false;
            this.as = (NearbyPlacesFragmentModel) bundle.getParcelable("nearby_places_fragment_model_state");
            this.at = (ContentFragmentViewState) bundle.getSerializable("nearby_places_fragment_view_state");
            this.an = bundle.getBoolean("nearby_places_is_initial_load", true);
        } else {
            this.an = true;
            this.as = new NearbyPlacesFragmentModel((EntryPoint) this.s.getSerializable("nearby_places_entry_point"), ImpressionSource.nearby_places, this.f806g.a(o()));
        }
        Preconditions.checkNotNull(this.as);
        Preconditions.checkNotNull(this.as.b);
        FragmentManager fragmentManager = this.D;
        this.ar = (NearbyPlacesTypeaheadFragment) fragmentManager.a("TypeaheadFragment");
        if (this.ar == null) {
            NearbyPlacesFragmentModel nearbyPlacesFragmentModel = this.as;
            Parcelable parcelable = this.as.b;
            Preconditions.checkNotNull(nearbyPlacesFragmentModel);
            NearbyPlacesTypeaheadFragment nearbyPlacesTypeaheadFragment = new NearbyPlacesTypeaheadFragment();
            nearbyPlacesTypeaheadFragment.at = nearbyPlacesFragmentModel;
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("nearby_places_search_data", parcelable);
            nearbyPlacesTypeaheadFragment.g(bundle2);
            this.ar = nearbyPlacesTypeaheadFragment;
            fragmentManager.a().a(2131564124, this.ar, "TypeaheadFragment").b();
        } else {
            this.ar.at = this.as;
        }
        this.ar.ar = this;
        if (bundle == null) {
            String string = this.s.getString("nearby_places_query_topic");
            Object string2 = this.s.getString("nearby_places_location_id");
            Object string3 = this.s.getString("nearby_places_location_name");
            if (!(TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3))) {
                this.as.b.b = false;
                this.as.b.d = string2;
                this.as.b.e = string3;
                this.as.b.h = new NearbyPlacesResultListQueryTopic(string, string);
                this.at = ContentFragmentViewState.RESULT_LIST_FRAGMENT;
            }
            m1081a(this, this.at);
        } else {
            NearbyPlacesV2ResultsFragment as = as();
            if (as != null) {
                as.a(this.as);
                as.a(this.as);
                as.a(this);
            }
            NearbyPlacesV2IntentFragment ar = ar();
            if (ar != null) {
                ar.am = this.as;
                ar.an = this.as;
                ar.al = this;
            }
        }
        LogUtils.f(-215939788, a);
    }

    public final View m1090a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -630644555);
        View inflate = layoutInflater.inflate(2130905396, viewGroup, false);
        this.aq = (ViewGroup) inflate.findViewById(2131564123);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1961004121, a);
        return inflate;
    }

    public final void m1095e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("nearby_places_fragment_model_state", this.as);
        bundle.putSerializable("nearby_places_fragment_view_state", this.at);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -161062700);
        super.mi_();
        if (this.as != null) {
            this.as.a.e();
        }
        this.D.a(this.am);
        this.as.b.a = this.f806g.a(o());
        if (this.as.b.c == null && this.as.b.a == LocationStatus.OKAY) {
            m1085a(true);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 999065108, a);
    }

    private void m1085a(boolean z) {
        if (!this.ap) {
            if (this.as.b.c == null || z) {
                this.ap = true;
                this.au.a(f799i, new C01022(this));
            }
        }
    }

    public static void m1080a(NearbyPlacesV2Fragment nearbyPlacesV2Fragment, ImmutableLocation immutableLocation) {
        nearbyPlacesV2Fragment.ap = false;
        nearbyPlacesV2Fragment.as.b.a = LocationStatus.OKAY;
        nearbyPlacesV2Fragment.as.b.a(immutableLocation.l());
        nearbyPlacesV2Fragment.m1083a(nearbyPlacesV2Fragment.as.b, nearbyPlacesV2Fragment.as.b.b);
        nearbyPlacesV2Fragment.ao = false;
    }

    public static void m1082a(NearbyPlacesV2Fragment nearbyPlacesV2Fragment, LocationStatus locationStatus) {
        boolean z;
        nearbyPlacesV2Fragment.ap = false;
        if (nearbyPlacesV2Fragment.ao || nearbyPlacesV2Fragment.as.b.f()) {
            z = true;
        } else {
            z = false;
        }
        nearbyPlacesV2Fragment.as.b.a = locationStatus;
        nearbyPlacesV2Fragment.as.b.b = false;
        nearbyPlacesV2Fragment.m1083a(nearbyPlacesV2Fragment.as.b, z);
        nearbyPlacesV2Fragment.ao = false;
    }

    private NearbyPlacesV2IntentFragment ar() {
        return (NearbyPlacesV2IntentFragment) kO_().a("IntentView");
    }

    private NearbyPlacesV2ResultsFragment as() {
        return (NearbyPlacesV2ResultsFragment) kO_().a("ResultList");
    }

    private Fragment at() {
        return kO_().a("MapView");
    }

    private void m1083a(NearbyPlacesSearchDataModel nearbyPlacesSearchDataModel, boolean z) {
        if (this.ar != null) {
            this.ar.a(nearbyPlacesSearchDataModel);
        }
        if (z) {
            switch (this.at) {
                case INTENT_VIEW_FRAGMENT:
                    NearbyPlacesV2IntentFragment ar = ar();
                    if (ar != null) {
                        ar.e();
                        return;
                    }
                    return;
                case RESULT_LIST_FRAGMENT:
                    NearbyPlacesV2ResultsFragment as = as();
                    if (as != null) {
                        as.e();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static void au(NearbyPlacesV2Fragment nearbyPlacesV2Fragment) {
        if (!nearbyPlacesV2Fragment.ar.aq()) {
            nearbyPlacesV2Fragment.ar.a(nearbyPlacesV2Fragment.as.b);
        }
    }

    public final void m1089G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1804769495);
        super.G();
        av(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1593586251, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2012466668);
        this.f802c.c("nearby_places_get_location_task_key");
        this.D.b(this.am);
        super.mj_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 84019304, a);
    }

    public final String am_() {
        return "nearby_places_fragment";
    }

    public final boolean O_() {
        if (!this.ar.aq()) {
            return false;
        }
        this.ar.ar();
        au(this);
        return true;
    }

    public static void av(NearbyPlacesV2Fragment nearbyPlacesV2Fragment) {
        nearbyPlacesV2Fragment.aw();
        String b = nearbyPlacesV2Fragment.b(2131236610);
        HasTitleBar hasTitleBar = (HasTitleBar) nearbyPlacesV2Fragment.a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.a_(b);
        }
        int i = 0;
        hasTitleBar = (HasTitleBar) nearbyPlacesV2Fragment.a(HasTitleBar.class);
        if (hasTitleBar != null) {
            TitleBarButtonSpec a;
            OnToolbarButtonListener c01033;
            switch (nearbyPlacesV2Fragment.at) {
                case MAP_VIEW_FRAGMENT:
                    i = 2131236700;
                    break;
            }
            if (i != 0) {
                TitleBarButtonSpec.Builder a2 = TitleBarButtonSpec.a();
                a2.g = nearbyPlacesV2Fragment.b(i);
                a = a2.a();
                c01033 = new C01033(nearbyPlacesV2Fragment);
            } else {
                a = TitleBarButtonSpec.b;
                c01033 = null;
            }
            hasTitleBar.a(a);
            hasTitleBar.a(c01033);
            hasTitleBar.c(true);
        }
    }

    private void aw() {
        NearbyPlacesV2IntentFragment ar = ar();
        if (ar == null || !ar.z()) {
            NearbyPlacesV2ResultsFragment as = as();
            if (as == null || !as.z()) {
                Fragment at = at();
                if (at != null && at.z()) {
                    this.at = ContentFragmentViewState.MAP_VIEW_FRAGMENT;
                    return;
                }
                return;
            }
            this.at = ContentFragmentViewState.RESULT_LIST_FRAGMENT;
            return;
        }
        this.at = ContentFragmentViewState.INTENT_VIEW_FRAGMENT;
    }

    public static void m1081a(NearbyPlacesV2Fragment nearbyPlacesV2Fragment, ContentFragmentViewState contentFragmentViewState) {
        if (!nearbyPlacesV2Fragment.m1088b(nearbyPlacesV2Fragment.m1087b(contentFragmentViewState))) {
            switch (contentFragmentViewState) {
                case INTENT_VIEW_FRAGMENT:
                    nearbyPlacesV2Fragment.aA();
                    break;
                case RESULT_LIST_FRAGMENT:
                    nearbyPlacesV2Fragment.aB();
                    break;
                case MAP_VIEW_FRAGMENT:
                    break;
                default:
                    throw new IllegalArgumentException("Invalid view state for NearbyPlaces Fragment!");
            }
            av(nearbyPlacesV2Fragment);
        }
    }

    private boolean m1088b(Fragment fragment) {
        Fragment az = az();
        return az != null && az.equals(fragment);
    }

    private Fragment az() {
        return m1087b(this.at);
    }

    private Fragment m1087b(ContentFragmentViewState contentFragmentViewState) {
        switch (contentFragmentViewState) {
            case INTENT_VIEW_FRAGMENT:
                return ar();
            case RESULT_LIST_FRAGMENT:
                return as();
            case MAP_VIEW_FRAGMENT:
                return at();
            default:
                throw new IllegalArgumentException("Invalid view state for NearbyPlaces Fragment!");
        }
    }

    private void aA() {
        Object ar = ar();
        if (ar == null) {
            NearbyPlacesFragmentModel nearbyPlacesFragmentModel = this.as;
            NearbyPlacesFragmentModel nearbyPlacesFragmentModel2 = this.as;
            Preconditions.checkNotNull(nearbyPlacesFragmentModel);
            Preconditions.checkNotNull(nearbyPlacesFragmentModel2);
            NearbyPlacesV2IntentFragment nearbyPlacesV2IntentFragment = new NearbyPlacesV2IntentFragment();
            nearbyPlacesV2IntentFragment.an = nearbyPlacesFragmentModel;
            nearbyPlacesV2IntentFragment.am = nearbyPlacesFragmentModel2;
            ar = nearbyPlacesV2IntentFragment;
        }
        ar.al = this;
        m1077a(ar, "IntentView", NearbyPlacesV2IntentFragment.class.toString(), m1086a(ar), m1076a(this.at, ContentFragmentViewState.INTENT_VIEW_FRAGMENT));
    }

    private void aB() {
        Object as = as();
        if (as == null) {
            if (this.av == null) {
                boolean a = this.f805f.a(ExperimentsForNearbyPlacesModule.f813g, false);
                boolean a2 = this.f805f.a(ExperimentsForNearbyPlacesModule.f808b, false);
                boolean a3 = this.f805f.a(ExperimentsForNearbyPlacesModule.f812f, false);
                boolean a4 = this.f805f.a(ExperimentsForNearbyPlacesModule.f809c, false);
                boolean a5 = this.f805f.a(ExperimentsForNearbyPlacesModule.f811e, false);
                boolean a6 = this.f805f.a(ExperimentsForNearbyPlacesModule.f810d, false);
                Options.Builder builder = new Options.Builder();
                builder.a = a;
                Options.Builder builder2 = builder;
                builder2.b = a2;
                builder2 = builder2;
                builder2.c = a3;
                builder2 = builder2;
                builder2.d = a4;
                builder2 = builder2;
                builder2.e = a5;
                builder2 = builder2;
                builder2.f = a6;
                this.av = builder2.a();
            }
            as = NearbyPlacesV2ResultsFragment.b(this.av);
            as.a(this.as);
            as.a(this.as);
        }
        as.a(this);
        m1077a(as, "ResultList", NearbyPlacesV2ResultsFragment.class.toString(), m1086a(as), m1076a(this.at, ContentFragmentViewState.RESULT_LIST_FRAGMENT));
    }

    private boolean m1086a(Object obj) {
        Preconditions.checkNotNull(obj, "Fragment should not be null!");
        if ((obj instanceof NearbyPlacesV2IntentFragment) && this.an) {
            return false;
        }
        if ((obj instanceof NearbyPlacesV2ResultsFragment) && (this.at == ContentFragmentViewState.RESULT_LIST_FRAGMENT || this.at == ContentFragmentViewState.MAP_VIEW_FRAGMENT)) {
            return false;
        }
        return true;
    }

    private void m1077a(Fragment fragment, String str, String str2, boolean z, AnimationState animationState) {
        Preconditions.checkNotNull(fragment);
        Preconditions.checkNotNull(str2);
        FragmentTransaction a = this.D.a();
        if (animationState != null) {
            a = a.a(animationState.f795b, animationState.f794a, animationState.f797d, animationState.f796c);
        } else {
            a = a.a(0);
        }
        m1078a(a, fragment);
        a = a.a(this.aq.getId(), fragment, str);
        if (z) {
            a = a.a(str2);
        }
        a.b();
        this.an = false;
    }

    private void m1078a(FragmentTransaction fragmentTransaction, Fragment fragment) {
        Preconditions.checkNotNull(fragmentTransaction);
        NearbyPlacesV2IntentFragment ar = ar();
        if (!(ar == null || ar == fragment)) {
            fragmentTransaction.b(ar);
        }
        NearbyPlacesV2ResultsFragment as = as();
        if (!(as == null || as == fragment)) {
            fragmentTransaction.b(as);
        }
        Fragment at = at();
        if (at != null && at != fragment) {
            fragmentTransaction.b(at);
        }
    }

    private static AnimationState m1076a(ContentFragmentViewState contentFragmentViewState, ContentFragmentViewState contentFragmentViewState2) {
        int i;
        int i2;
        int i3 = 17432577;
        int i4 = 17432576;
        if (contentFragmentViewState == ContentFragmentViewState.INTENT_VIEW_FRAGMENT && contentFragmentViewState2 == ContentFragmentViewState.RESULT_LIST_FRAGMENT) {
            i = 2130968748;
            i2 = 2130968757;
            i4 = 2130968747;
            i3 = 2130968758;
        } else if ((contentFragmentViewState == ContentFragmentViewState.RESULT_LIST_FRAGMENT || contentFragmentViewState == ContentFragmentViewState.MAP_VIEW_FRAGMENT) && contentFragmentViewState2 == ContentFragmentViewState.INTENT_VIEW_FRAGMENT) {
            i4 = 2130968747;
            i3 = 2130968758;
            i2 = 2130968758;
            i = 2130968747;
        } else if (contentFragmentViewState == ContentFragmentViewState.INTENT_VIEW_FRAGMENT && contentFragmentViewState2 == ContentFragmentViewState.INTENT_VIEW_FRAGMENT) {
            return null;
        } else {
            i2 = 17432577;
            i = 17432576;
        }
        return new AnimationState(i, i2, i4, i3);
    }

    private void m1079a(FbLocationOperation fbLocationOperation, Provider<FbLocationOperation> provider, TasksManager tasksManager, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, GooglePlayServicesLocationUpsellDialogController googlePlayServicesLocationUpsellDialogController, QeAccessor qeAccessor, LocationStatusUtil locationStatusUtil) {
        this.f800a = fbLocationOperation;
        this.f801b = provider;
        this.f802c = tasksManager;
        this.f803d = activityRuntimePermissionsManagerProvider;
        this.f804e = googlePlayServicesLocationUpsellDialogController;
        this.f805f = qeAccessor;
        this.f806g = locationStatusUtil;
    }

    public final void m1091a(GoogleLocationDialogResult googleLocationDialogResult) {
        if (googleLocationDialogResult == GoogleLocationDialogResult.DIALOG_SUCCESS) {
            m1085a(true);
        }
    }

    public final void m1092a(NearbyPlacesSearchDataModel nearbyPlacesSearchDataModel) {
        this.ar.ar();
        this.as.b = new NearbyPlacesSearchDataModel(nearbyPlacesSearchDataModel);
        if (this.at == ContentFragmentViewState.RESULT_LIST_FRAGMENT) {
            as().e();
        } else if (this.as.b.h()) {
            m1081a(this, ContentFragmentViewState.RESULT_LIST_FRAGMENT);
        }
    }
}
