package com.facebook.messaging.location.sending;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.android.maps.model.LatLng;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.location.gmsupsell.GooglePlayLocationServicesSettingsManager.LocationSettingsRequestParams;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.location.sending.LocationSendingDialogConfig.ButtonStyle;
import com.facebook.messaging.location.sending.LocationSendingDialogFragment.Listener;
import com.facebook.messaging.location.sending.LocationSendingView.ConfirmClickListener;
import com.facebook.messaging.location.sending.MapDisplayFragment.MapDisplayListener;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mMoneyPennyItemParams */
public class LocationSendingMainFragment extends FbFragment {
    @Inject
    public GooglePlayServicesLocationUpsellDialogController f11404a;
    @Nullable
    public LatLng al;
    @Nullable
    private ButtonStyle am;
    @Nullable
    public SuggestedNearbyPlacesFragment an;
    @Nullable
    public LatLng ao;
    @Nullable
    public NearbyPlace ap;
    @Inject
    public LocationGmsLsUpsellController f11405b;
    @Inject
    public AbstractFbErrorReporter f11406c;
    public Listener f11407d;
    private LocationSendingView f11408e;
    public LocationType f11409f = LocationType.UNSET;
    public MapDisplayFragment f11410g;
    @Nullable
    public Location f11411h;
    @Nullable
    public NearbyPlace f11412i;

    /* compiled from: mMoneyPennyItemParams */
    class C12651 implements ConfirmClickListener {
        final /* synthetic */ LocationSendingMainFragment f11401a;

        C12651(LocationSendingMainFragment locationSendingMainFragment) {
            this.f11401a = locationSendingMainFragment;
        }

        public final void mo436a() {
            LocationSendingMainFragment locationSendingMainFragment = this.f11401a;
            if (locationSendingMainFragment.f11409f == LocationType.UNSET) {
                SoftErrorBuilder a = SoftError.a("LocationSendingMainFragment", "Selected location is unset, this should never happen.");
                a.e = 1;
                locationSendingMainFragment.f11406c.a(a.g());
            } else if (locationSendingMainFragment.f11409f == LocationType.USER_LOCATION) {
                locationSendingMainFragment.f11407d.mo428a(new LatLng(locationSendingMainFragment.f11411h.getLatitude(), locationSendingMainFragment.f11411h.getLongitude()));
            } else if (locationSendingMainFragment.f11409f == LocationType.NEARBY_PLACE) {
                locationSendingMainFragment.f11407d.mo429a(locationSendingMainFragment.f11412i);
            } else if (locationSendingMainFragment.f11409f == LocationType.PINNED_LOCATION) {
                locationSendingMainFragment.f11407d.mo430b(locationSendingMainFragment.al);
            }
        }
    }

    /* compiled from: mMoneyPennyItemParams */
    public class C12662 implements NearbyPlaceClickListener {
        final /* synthetic */ LocationSendingMainFragment f11402a;

        public C12662(LocationSendingMainFragment locationSendingMainFragment) {
            this.f11402a = locationSendingMainFragment;
        }

        public final void mo435a(NearbyPlace nearbyPlace) {
            this.f11402a.m12016b(nearbyPlace);
        }
    }

    /* compiled from: mMoneyPennyItemParams */
    public class C12673 implements MapDisplayListener {
        final /* synthetic */ LocationSendingMainFragment f11403a;

        public C12673(LocationSendingMainFragment locationSendingMainFragment) {
            this.f11403a = locationSendingMainFragment;
        }

        public final void mo438a(Location location) {
            LocationSendingMainFragment locationSendingMainFragment = this.f11403a;
            locationSendingMainFragment.f11411h = location;
            if (locationSendingMainFragment.f11409f == LocationType.UNSET) {
                LocationSendingMainFragment.ar(locationSendingMainFragment);
            }
        }

        public final void mo437a() {
            LocationSendingMainFragment.ar(this.f11403a);
        }

        public final void mo439a(LatLng latLng) {
            LocationSendingMainFragment.m12007b(this.f11403a, latLng);
        }
    }

    public static void m12006a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        LocationSendingMainFragment locationSendingMainFragment = (LocationSendingMainFragment) obj;
        GooglePlayServicesLocationUpsellDialogController b = GooglePlayServicesLocationUpsellDialogController.b(fbInjector);
        LocationGmsLsUpsellController locationGmsLsUpsellController = new LocationGmsLsUpsellController(FbLocationStatusUtil.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        locationSendingMainFragment.f11404a = b;
        locationSendingMainFragment.f11405b = locationGmsLsUpsellController;
        locationSendingMainFragment.f11406c = abstractFbErrorReporter;
    }

    public final void m12017c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = LocationSendingMainFragment.class;
        m12006a((Object) this, getContext());
        if (ao() != null) {
            this.f11404a.a(this, this.f11405b);
        }
    }

    public final View m12012a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1791219370);
        View inflate = layoutInflater.inflate(2130905129, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -702940613, a);
        return inflate;
    }

    public final void m12014a(View view, Bundle bundle) {
        super.a(view, bundle);
        m12009e();
    }

    public final void m12010G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 742790456);
        super.G();
        if (ao() != null) {
            LocationGmsLsUpsellController locationGmsLsUpsellController = this.f11405b;
            GooglePlayServicesLocationUpsellDialogController googlePlayServicesLocationUpsellDialogController = this.f11404a;
            if (locationGmsLsUpsellController.f11378a.a() != State.OKAY && locationGmsLsUpsellController.f11379b.a(ExperimentsForLocationSendingModule.f11376a, false)) {
                locationGmsLsUpsellController.f11381d = this;
                locationGmsLsUpsellController.f11380c = googlePlayServicesLocationUpsellDialogController;
                locationGmsLsUpsellController.f11380c.a(new LocationSettingsRequestParams(), "surface_location_sharing", "mechanism_location_sharing_button");
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1757268294, a);
    }

    public final void m12011I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1122581128);
        super.I();
        if (ao() != null) {
            this.f11404a.a();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -432252534, a);
    }

    private void m12009e() {
        this.f11408e = (LocationSendingView) e(2131563590);
        this.f11408e.f11416a = new C12651(this);
        as();
    }

    public final void m12013a(Fragment fragment) {
        if (fragment instanceof SuggestedNearbyPlacesFragment) {
            this.an = (SuggestedNearbyPlacesFragment) fragment;
            this.an.f11489c = new C12662(this);
        } else if (fragment instanceof MapDisplayFragment) {
            this.f11410g = (MapDisplayFragment) fragment;
            this.f11410g.f11435f = new C12673(this);
        }
    }

    public static void ar(LocationSendingMainFragment locationSendingMainFragment) {
        if (locationSendingMainFragment.f11411h != null) {
            locationSendingMainFragment.f11409f = LocationType.USER_LOCATION;
            locationSendingMainFragment.f11410g.m12045a(locationSendingMainFragment.f11411h);
            locationSendingMainFragment.f11408e.m12022a();
        }
    }

    public static void m12007b(LocationSendingMainFragment locationSendingMainFragment, LatLng latLng) {
        if (locationSendingMainFragment.f11409f != LocationType.UNSET) {
            locationSendingMainFragment.m12008c(latLng);
        }
    }

    private void m12008c(LatLng latLng) {
        this.al = latLng;
        this.f11408e.m12024b();
        this.f11409f = LocationType.PINNED_LOCATION;
        this.f11410g.m12050b();
    }

    public final void m12016b(NearbyPlace nearbyPlace) {
        this.f11409f = LocationType.NEARBY_PLACE;
        this.f11412i = nearbyPlace;
        this.f11410g.m12048a(nearbyPlace);
        this.f11408e.m12023a(nearbyPlace);
    }

    public final void m12015a(ButtonStyle buttonStyle) {
        this.am = buttonStyle;
        as();
    }

    private void as() {
        if (this.f11408e != null && this.am != null) {
            this.f11408e.setButtonStyle(this.am);
            if (this.ao != null) {
                m12008c(this.ao);
            }
            if (this.ap != null) {
                m12016b(this.ap);
            }
        }
    }
}
