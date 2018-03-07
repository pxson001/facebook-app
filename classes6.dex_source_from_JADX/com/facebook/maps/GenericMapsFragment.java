package com.facebook.maps;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.android.maps.model.BitmapDescriptorFactory;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.LatLngBounds.Builder;
import com.facebook.android.maps.model.MarkerOptions;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.FindViewUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.katana.orca.FbAnalyticsConfig;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.location.gmsupsell.GooglePlayLocationServicesSettingsManager.LocationSettingsRequestParams;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController.GoogleLocationDialogResult;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController.OnGooglePlayServicesLocationUpsellDialogFinishedListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.delegate.CameraUpdateFactoryDelegate;
import com.facebook.maps.delegate.MapDelegate;
import com.facebook.maps.delegate.MapDelegate.OnMapClickListener;
import com.facebook.maps.delegate.MapDelegate.OnMyLocationChangeListener;
import com.facebook.maps.delegate.MapFragmentDelegate;
import com.facebook.maps.delegate.MarkerDelegate;
import com.facebook.maps.delegate.OnMapReadyDelegateCallback;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.titlebar.HasTitleBar;
import javax.inject.Inject;

/* compiled from: xmaGraphQL */
public class GenericMapsFragment extends FbFragment implements AnalyticsFragment, OnGooglePlayServicesLocationUpsellDialogFinishedListener, OnMyLocationChangeListener, OnMapReadyDelegateCallback {
    private static final Class<?> f184f = GenericMapsFragment.class;
    private static final String[] f185g = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    @Inject
    ExternalMapLauncher f186a;
    private double al;
    private double am;
    private LatLng an;
    public LatLng ao;
    private float ap;
    private String aq;
    private boolean ar;
    public String as = "mechanism_unknown";
    public MapFragmentDelegate at;
    @Inject
    GooglePlayServicesLocationUpsellDialogController f187b;
    @Inject
    FbLocationStatusUtil f188c;
    @Inject
    GenericMapsLogger f189d;
    @Inject
    ActivityRuntimePermissionsManagerProvider f190e;
    private String f191h;
    private String f192i;

    /* compiled from: xmaGraphQL */
    class C00251 implements OnClickListener {
        final /* synthetic */ GenericMapsFragment f175a;

        C00251(GenericMapsFragment genericMapsFragment) {
            this.f175a = genericMapsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1003807040);
            if (this.f175a.f188c.a() != State.OKAY) {
                this.f175a.f187b.m74a(new LocationSettingsRequestParams(), "surface_generic_map_fragment", "mechanism_get_direction_button");
                this.f175a.as = "mechanism_get_direction_button";
                this.f175a.f189d.m163a(this.f175a.as);
            } else {
                GenericMapsFragment.ar(this.f175a);
            }
            LogUtils.a(-539904125, a);
        }
    }

    /* compiled from: xmaGraphQL */
    class C00284 implements RuntimePermissionsListener {
        final /* synthetic */ GenericMapsFragment f180a;

        C00284(GenericMapsFragment genericMapsFragment) {
            this.f180a = genericMapsFragment;
        }

        public final void mo6a() {
            this.f180a.f189d.m166c("result_succeeded");
            if (this.f180a.f188c.a() == State.OKAY) {
                GenericMapsFragment.m149e(this.f180a);
            }
        }

        public final void mo7a(String[] strArr, String[] strArr2) {
            this.f180a.f189d.m166c("result_failed");
        }

        public final void mo8b() {
            this.f180a.f189d.m166c("result_canceled");
        }
    }

    /* compiled from: xmaGraphQL */
    class C00295 implements OnMapReadyDelegateCallback {
        final /* synthetic */ GenericMapsFragment f181a;

        C00295(GenericMapsFragment genericMapsFragment) {
            this.f181a = genericMapsFragment;
        }

        public final void mo9a(MapDelegate mapDelegate) {
            GenericMapsFragment.m147b(this.f181a, mapDelegate);
        }
    }

    /* compiled from: xmaGraphQL */
    public class C00306 implements OnMapReadyDelegateCallback {
        final /* synthetic */ GenericMapsFragment f182a;

        public C00306(GenericMapsFragment genericMapsFragment) {
            this.f182a = genericMapsFragment;
        }

        public final void mo9a(MapDelegate mapDelegate) {
            GenericMapsFragment.m148c(this.f182a, mapDelegate);
        }
    }

    public static void m146a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GenericMapsFragment) obj).m145a(ExternalMapLauncher.m86a(fbInjector), GooglePlayServicesLocationUpsellDialogController.m70b(fbInjector), FbLocationStatusUtil.a(fbInjector), new GenericMapsLogger((BaseAnalyticsConfig) FbAnalyticsConfig.a(fbInjector), AnalyticsLoggerMethodAutoProvider.a(fbInjector)), (ActivityRuntimePermissionsManagerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class));
    }

    private void m145a(ExternalMapLauncher externalMapLauncher, GooglePlayServicesLocationUpsellDialogController googlePlayServicesLocationUpsellDialogController, FbLocationStatusUtil fbLocationStatusUtil, GenericMapsLogger genericMapsLogger, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider) {
        this.f186a = externalMapLauncher;
        this.f187b = googlePlayServicesLocationUpsellDialogController;
        this.f188c = fbLocationStatusUtil;
        this.f189d = genericMapsLogger;
        this.f190e = activityRuntimePermissionsManagerProvider;
    }

    public final void m156c(Bundle bundle) {
        Class cls = GenericMapsFragment.class;
        m146a(this, getContext());
        this.f187b.m73a((FbFragment) this, (OnGooglePlayServicesLocationUpsellDialogFinishedListener) this);
        super.c(bundle);
    }

    public final void m157e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("mechanism", this.as);
    }

    public final View m151a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -154700805);
        View inflate = layoutInflater.inflate(2130904585, viewGroup, false);
        Bundle bundle2 = this.s;
        this.f191h = bundle2.getString("place_name");
        this.f192i = bundle2.getString("address");
        this.al = bundle2.getDouble("latitude");
        this.am = bundle2.getDouble("longitude");
        this.an = new LatLng(this.al, this.am);
        this.ap = bundle2.getFloat("zoom");
        this.aq = bundle2.getString("curation_surface");
        if (bundle != null) {
            this.as = bundle.getString("mechanism", "mechanism_unknown");
        }
        FindViewUtil.b(inflate, 2131562516).setOnClickListener(new C00251(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1768513847, a);
        return inflate;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -845754902);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.a_(this.f191h);
            hasTitleBar.c(true);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 8819741, a);
    }

    public final void m153a(Fragment fragment) {
        super.a(fragment);
        if (fragment instanceof FbMapFragmentDelegate) {
            this.at = (MapFragmentDelegate) fragment;
            ((FbMapFragmentDelegate) fragment).m100a((OnMapReadyDelegateCallback) this);
        }
    }

    public final void mo9a(final MapDelegate mapDelegate) {
        mapDelegate.m331a(CameraUpdateFactoryDelegate.m298a(this.an, this.ap));
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.b = this.an;
        markerOptions = markerOptions;
        markerOptions.i = this.f191h;
        markerOptions = markerOptions;
        markerOptions.h = this.f192i;
        markerOptions = markerOptions;
        markerOptions.c = BitmapDescriptorFactory.a(2130841141);
        final MarkerDelegate a = mapDelegate.m326a(markerOptions);
        if (a != null) {
            a.m366d();
            mapDelegate.m333a(new OnMapClickListener(this) {
                final /* synthetic */ GenericMapsFragment f177b;

                public final void mo5a() {
                    a.m366d();
                }
            });
        }
        this.f189d.m162a();
        View e = e(2131562517);
        e.setVisibility(0);
        e.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ GenericMapsFragment f179b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1825365756);
                this.f179b.f189d.m164b();
                if (this.f179b.f188c.a() != State.OKAY) {
                    this.f179b.as = "mechanism_my_location_button";
                    this.f179b.f189d.m163a(this.f179b.as);
                    this.f179b.f187b.m74a(new LocationSettingsRequestParams(), "surface_generic_map_fragment", "mechanism_my_location_button");
                    Logger.a(2, EntryType.UI_INPUT_END, -1011155960, a);
                    return;
                }
                if (this.f179b.ao == null) {
                    GenericMapsFragment.m147b(this.f179b, mapDelegate);
                } else {
                    GenericMapsFragment.m148c(this.f179b, mapDelegate);
                }
                LogUtils.a(834327577, a);
            }
        });
        e.requestLayout();
    }

    public final void mo10a(Location location) {
        this.ao = new LatLng(location.getLatitude(), location.getLongitude());
        if (this.ar) {
            this.ar = false;
            this.at.m100a(new C00306(this));
        }
    }

    public final void m150I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -298538757);
        this.f187b.m71a();
        this.at = null;
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1444529142, a);
    }

    public final void mo1a(GoogleLocationDialogResult googleLocationDialogResult) {
        switch (googleLocationDialogResult) {
            case DIALOG_SUCCESS:
            case DIALOG_NOT_NEEDED:
                this.f189d.m165b("result_succeeded");
                break;
            case DIALOG_CANCEL:
                this.f189d.m165b("result_canceled");
                break;
            default:
                this.f189d.m165b("result_failed");
                break;
        }
        String str = this.as;
        Object obj = -1;
        switch (str.hashCode()) {
            case 27435745:
                if (str.equals("mechanism_get_direction_button")) {
                    obj = 1;
                    break;
                }
                break;
            case 570324239:
                if (str.equals("mechanism_my_location_button")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                if (googleLocationDialogResult != GoogleLocationDialogResult.DIALOG_SUCCESS && googleLocationDialogResult != GoogleLocationDialogResult.DIALOG_NOT_NEEDED) {
                    return;
                }
                if (this.f188c.a() == State.OKAY) {
                    m149e(this);
                    return;
                }
                this.f190e.a(o()).mo335a(f185g, new C00284(this));
                return;
            case 1:
                ar(this);
                return;
            default:
                BLog.b(f184f, "Unrecognized mechanism");
                return;
        }
    }

    public static void m149e(GenericMapsFragment genericMapsFragment) {
        genericMapsFragment.at.m100a(new C00295(genericMapsFragment));
    }

    public static void m147b(GenericMapsFragment genericMapsFragment, MapDelegate mapDelegate) {
        mapDelegate.m338c().m371c(false);
        mapDelegate.m336a(true);
        genericMapsFragment.ar = true;
        mapDelegate.m335a((OnMyLocationChangeListener) genericMapsFragment);
    }

    public static void m148c(GenericMapsFragment genericMapsFragment, MapDelegate mapDelegate) {
        mapDelegate.m332a(CameraUpdateFactoryDelegate.m299a(new Builder().a(genericMapsFragment.an).a(genericMapsFragment.ao).a(), genericMapsFragment.jW_().getDimensionPixelSize(2131427824)), 1500, null);
    }

    public static void ar(GenericMapsFragment genericMapsFragment) {
        genericMapsFragment.f186a.m92b(genericMapsFragment.getContext(), genericMapsFragment.aq, genericMapsFragment.al, genericMapsFragment.am, genericMapsFragment.f191h, genericMapsFragment.f192i);
    }

    public final String am_() {
        return "full_screen_map";
    }
}
