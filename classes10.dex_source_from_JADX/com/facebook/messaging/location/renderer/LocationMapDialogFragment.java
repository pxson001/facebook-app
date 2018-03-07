package com.facebook.messaging.location.renderer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.android.maps.model.BitmapDescriptorFactory;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.MarkerOptions;
import com.facebook.common.ui.util.ViewOrientationLockHelper;
import com.facebook.common.ui.util.ViewOrientationLockHelperProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.Lazy;
import com.facebook.location.Coordinates;
import com.facebook.location.CoordinatesBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.ExternalMapLauncher;
import com.facebook.maps.delegate.CameraUpdateFactoryDelegate;
import com.facebook.maps.delegate.MapDelegate;
import com.facebook.maps.delegate.MapFragmentDelegate;
import com.facebook.maps.delegate.OnMapReadyDelegateCallback;
import com.facebook.messaging.business.ride.gating.IsRideServiceComposerEnabled;
import com.facebook.messaging.business.ride.helper.RideOauthHelper;
import com.facebook.messaging.business.ride.utils.RideServiceParams;
import com.facebook.messaging.business.ride.utils.RideServiceParams.RideServiceParamsBuilder;
import com.facebook.messaging.fullscreendialog.FullScreenDialogFragment;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.bottomsheet.BottomSheetAdapter;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: selected_emoji */
public class LocationMapDialogFragment extends FullScreenDialogFragment {
    @Inject
    Lazy<ExternalMapLauncher> am;
    @Inject
    ViewOrientationLockHelperProvider an;
    @Inject
    @IsRideServiceComposerEnabled
    Provider<Boolean> ao;
    @Inject
    RideOauthHelper ap;
    private ViewOrientationLockHelper aq;
    public String ar;
    @Nullable
    public String as;
    public double at;
    public double au;
    @Nullable
    public ThreadKey av;

    /* compiled from: selected_emoji */
    class C04931 implements OnClickListener {
        final /* synthetic */ LocationMapDialogFragment f3016a;

        C04931(LocationMapDialogFragment locationMapDialogFragment) {
            this.f3016a = locationMapDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1785491909);
            this.f3016a.a();
            Logger.a(2, EntryType.UI_INPUT_END, 455269459, a);
        }
    }

    /* compiled from: selected_emoji */
    public class C04942 implements OnMenuItemClickListener {
        final /* synthetic */ LocationMapDialogFragment f3017a;

        public C04942(LocationMapDialogFragment locationMapDialogFragment) {
            this.f3017a = locationMapDialogFragment;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            LocationMapDialogFragment.aq(this.f3017a);
            return true;
        }
    }

    /* compiled from: selected_emoji */
    public class C04953 implements OnMenuItemClickListener {
        final /* synthetic */ LocationMapDialogFragment f3018a;

        public C04953(LocationMapDialogFragment locationMapDialogFragment) {
            this.f3018a = locationMapDialogFragment;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            Preconditions.checkNotNull(this.f3018a.av);
            RideOauthHelper rideOauthHelper = this.f3018a.ap;
            RideServiceParamsBuilder newBuilder = RideServiceParams.newBuilder();
            newBuilder.a = "location_message_map_view";
            newBuilder = newBuilder;
            newBuilder.c = this.f3018a.as;
            newBuilder = newBuilder;
            CoordinatesBuilder newBuilder2 = Coordinates.newBuilder();
            newBuilder2.a = Double.valueOf(this.f3018a.at);
            newBuilder2 = newBuilder2;
            newBuilder2.b = Double.valueOf(this.f3018a.au);
            newBuilder.g = newBuilder2.d();
            newBuilder = newBuilder;
            newBuilder.b = this.f3018a.av;
            rideOauthHelper.a(newBuilder.j());
            return true;
        }
    }

    /* compiled from: selected_emoji */
    public class LocationDetailsViewClickListener implements OnClickListener {
        final /* synthetic */ LocationMapDialogFragment f3019a;

        public LocationDetailsViewClickListener(LocationMapDialogFragment locationMapDialogFragment) {
            this.f3019a = locationMapDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -442184163);
            if (LocationMapDialogFragment.as(this.f3019a)) {
                LocationMapDialogFragment locationMapDialogFragment = this.f3019a;
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(locationMapDialogFragment.getContext());
                BottomSheetAdapter bottomSheetAdapter = new BottomSheetAdapter(locationMapDialogFragment.getContext());
                bottomSheetAdapter.e(2131230965).setIcon(2130841364).setOnMenuItemClickListener(new C04942(locationMapDialogFragment));
                bottomSheetAdapter.e(2131230976).setIcon(2130841431).setOnMenuItemClickListener(new C04953(locationMapDialogFragment));
                bottomSheetDialog.a(bottomSheetAdapter);
                bottomSheetDialog.show();
            } else {
                LocationMapDialogFragment.aq(this.f3019a);
            }
            LogUtils.a(1511578498, a);
        }
    }

    /* compiled from: selected_emoji */
    public class MapCallback implements OnMapReadyDelegateCallback {
        final /* synthetic */ LocationMapDialogFragment f3020a;

        public MapCallback(LocationMapDialogFragment locationMapDialogFragment) {
            this.f3020a = locationMapDialogFragment;
        }

        public final void m2987a(MapDelegate mapDelegate) {
            LatLng latLng = new LatLng(this.f3020a.at, this.f3020a.au);
            mapDelegate.a(true);
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.b = latLng;
            markerOptions = markerOptions;
            markerOptions.c = BitmapDescriptorFactory.a(2130841461);
            mapDelegate.a(markerOptions.a(0.5f, 1.0f));
            mapDelegate.a(CameraUpdateFactoryDelegate.a(latLng, 14.0f));
        }
    }

    public static LocationMapDialogFragment m2989a(String str, @Nullable String str2, double d, double d2, @Nullable ThreadKey threadKey) {
        LocationMapDialogFragment locationMapDialogFragment = new LocationMapDialogFragment();
        Bundle a = m2988a(str, str2, d, d2);
        a.putParcelable("threadKey", threadKey);
        locationMapDialogFragment.g(a);
        return locationMapDialogFragment;
    }

    private static Bundle m2988a(String str, @Nullable String str2, double d, double d2) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("description", str2);
        bundle.putDouble("latitude", d);
        bundle.putDouble("longitude", d2);
        return bundle;
    }

    public final void m2991a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -127910579);
        super.a(bundle);
        FbInjector.a(LocationMapDialogFragment.class, this);
        Bundle bundle2 = this.s;
        this.ar = bundle2.getString("title");
        this.as = bundle2.getString("description");
        this.at = bundle2.getDouble("latitude", 0.0d);
        this.au = bundle2.getDouble("longitude", 0.0d);
        this.av = (ThreadKey) bundle2.getParcelable("threadKey");
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1439148830, a);
    }

    public final View m2990a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -831188047);
        View inflate = layoutInflater.inflate(2130905120, viewGroup, false);
        LocationMapDetailsView locationMapDetailsView = (LocationMapDetailsView) inflate.findViewById(2131563545);
        if (as(this)) {
            i = 2130837530;
        } else {
            i = 2130841364;
        }
        locationMapDetailsView.m2986a(this.ar, this.as, i);
        locationMapDetailsView.setOnClickListener(new LocationDetailsViewClickListener(this));
        Toolbar toolbar = (Toolbar) inflate.findViewById(2131563543);
        toolbar.setTitle(2131240247);
        toolbar.setNavigationOnClickListener(new C04931(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 195082863, a);
        return inflate;
    }

    public final void m2993a(View view, @Nullable Bundle bundle) {
        this.aq = this.an.a(view);
        this.aq.a();
    }

    public final void m2992a(Fragment fragment) {
        super.a(fragment);
        if (fragment instanceof MapFragmentDelegate) {
            ((MapFragmentDelegate) fragment).a(new MapCallback(this));
        }
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 395123590);
        super.mY_();
        this.aq.b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1404845484, a);
    }

    public static void aq(LocationMapDialogFragment locationMapDialogFragment) {
        ((ExternalMapLauncher) locationMapDialogFragment.am.get()).b(locationMapDialogFragment.getContext(), "messenger_location_map_view", locationMapDialogFragment.at, locationMapDialogFragment.au, locationMapDialogFragment.ar, null);
    }

    public static boolean as(LocationMapDialogFragment locationMapDialogFragment) {
        return ((Boolean) locationMapDialogFragment.ao.get()).booleanValue() && locationMapDialogFragment.av != null;
    }
}
