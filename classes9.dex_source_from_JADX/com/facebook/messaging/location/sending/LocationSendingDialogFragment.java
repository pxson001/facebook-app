package com.facebook.messaging.location.sending;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.support.v7.internal.widget.ViewStubCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.support.v7.widget.Toolbar;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.android.maps.model.LatLng;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.common.ui.util.ViewOrientationLockHelper;
import com.facebook.common.ui.util.ViewOrientationLockHelperProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.fullscreendialog.FullScreenDialogFragment;
import com.facebook.messaging.location.sending.LocationSendingDialogConfig.ButtonStyle;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.runtimepermissions.RequestPermissionsActivity;
import com.facebook.runtimepermissions.RequestPermissionsPrefKeys;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.ViewStubHolder.OnInflateListener;
import com.facebook.widget.text.BetterTextView;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mShowPinNux */
public class LocationSendingDialogFragment extends FullScreenDialogFragment implements CanHandleBackPressed {
    public static final String[] aq = new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    @Inject
    public FbSharedPreferences am;
    @Inject
    public RuntimePermissionsUtil an;
    @Inject
    public SecureContextHelper ao;
    @Inject
    public ViewOrientationLockHelperProvider ap;
    public Listener ar;
    public MenuItem as;
    public ViewStubHolder<View> at;
    public LocationSendingMainFragment au;
    public NearbyPlacesSearchResultsFragment av;
    private ViewOrientationLockHelper aw;

    /* compiled from: mShowPinNux */
    public interface Listener {
        void mo428a(LatLng latLng);

        void mo429a(NearbyPlace nearbyPlace);

        void mo430b(LatLng latLng);
    }

    /* compiled from: mShowPinNux */
    class C12571 implements OnInflateListener<View> {
        final /* synthetic */ LocationSendingDialogFragment f11393a;

        C12571(LocationSendingDialogFragment locationSendingDialogFragment) {
            this.f11393a = locationSendingDialogFragment;
        }

        public final void m11977a(View view) {
            LocationSendingDialogFragment locationSendingDialogFragment = this.f11393a;
            ((BetterTextView) locationSendingDialogFragment.e(2131563550)).setOnClickListener(new C12593(locationSendingDialogFragment));
            locationSendingDialogFragment.as.setVisible(false);
        }
    }

    /* compiled from: mShowPinNux */
    class C12582 implements OnClickListener {
        final /* synthetic */ LocationSendingDialogFragment f11394a;

        C12582(LocationSendingDialogFragment locationSendingDialogFragment) {
            this.f11394a = locationSendingDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1390960853);
            this.f11394a.a();
            Logger.a(2, EntryType.UI_INPUT_END, 492516680, a);
        }
    }

    /* compiled from: mShowPinNux */
    public class C12593 implements OnClickListener {
        final /* synthetic */ LocationSendingDialogFragment f11395a;

        public C12593(LocationSendingDialogFragment locationSendingDialogFragment) {
            this.f11395a = locationSendingDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -53163766);
            LocationSendingDialogFragment locationSendingDialogFragment = this.f11395a;
            Intent intent = new Intent(locationSendingDialogFragment.getContext(), RequestPermissionsActivity.class);
            intent.putExtra("extra_permissions", LocationSendingDialogFragment.aq);
            locationSendingDialogFragment.ao.a(intent, 1654, locationSendingDialogFragment);
            Logger.a(2, EntryType.UI_INPUT_END, 1230718584, a);
        }
    }

    /* compiled from: mShowPinNux */
    public class C12604 implements OnActionExpandListener {
        final /* synthetic */ LocationSendingDialogFragment f11396a;

        public C12604(LocationSendingDialogFragment locationSendingDialogFragment) {
            this.f11396a = locationSendingDialogFragment;
        }

        public final boolean m11978a(MenuItem menuItem) {
            LocationSendingDialogFragment locationSendingDialogFragment = this.f11396a;
            if (locationSendingDialogFragment.av == null) {
                NearbyPlacesSearchResultsFragment nearbyPlacesSearchResultsFragment = new NearbyPlacesSearchResultsFragment();
                locationSendingDialogFragment.s().a().a(2131563586, nearbyPlacesSearchResultsFragment).b(nearbyPlacesSearchResultsFragment).b();
                locationSendingDialogFragment.s().b();
            }
            locationSendingDialogFragment.s().a().b(locationSendingDialogFragment.au).c(locationSendingDialogFragment.av).b();
            return true;
        }

        public final boolean m11979b(MenuItem menuItem) {
            LocationSendingDialogFragment locationSendingDialogFragment = this.f11396a;
            locationSendingDialogFragment.s().a().b(locationSendingDialogFragment.av).c(locationSendingDialogFragment.au).b();
            return true;
        }
    }

    /* compiled from: mShowPinNux */
    public class C12615 implements OnQueryTextListener {
        final /* synthetic */ LocationSendingDialogFragment f11397a;

        public C12615(LocationSendingDialogFragment locationSendingDialogFragment) {
            this.f11397a = locationSendingDialogFragment;
        }

        public final boolean m11980a(String str) {
            return true;
        }

        public final boolean m11981b(String str) {
            if (LocationSendingDialogFragment.ay(this.f11397a)) {
                this.f11397a.av.m12075a(str);
            }
            return true;
        }
    }

    /* compiled from: mShowPinNux */
    public class C12626 implements Listener {
        final /* synthetic */ LocationSendingDialogFragment f11398a;

        public C12626(LocationSendingDialogFragment locationSendingDialogFragment) {
            this.f11398a = locationSendingDialogFragment;
        }

        public final void mo428a(LatLng latLng) {
            if (this.f11398a.ar != null) {
                this.f11398a.ar.mo428a(latLng);
            }
            this.f11398a.b();
        }

        public final void mo430b(LatLng latLng) {
            if (this.f11398a.ar != null) {
                this.f11398a.ar.mo430b(latLng);
            }
            this.f11398a.b();
        }

        public final void mo429a(NearbyPlace nearbyPlace) {
            if (this.f11398a.ar != null) {
                this.f11398a.ar.mo429a(nearbyPlace);
            }
            this.f11398a.b();
        }
    }

    /* compiled from: mShowPinNux */
    public class C12637 implements NearbyPlaceClickListener {
        final /* synthetic */ LocationSendingDialogFragment f11399a;

        public C12637(LocationSendingDialogFragment locationSendingDialogFragment) {
            this.f11399a = locationSendingDialogFragment;
        }

        public final void mo435a(NearbyPlace nearbyPlace) {
            LocationSendingDialogFragment locationSendingDialogFragment = this.f11399a;
            locationSendingDialogFragment.au.m12016b(nearbyPlace);
            locationSendingDialogFragment.as.collapseActionView();
        }
    }

    /* compiled from: mShowPinNux */
    class C12648 implements OnKeyListener {
        final /* synthetic */ LocationSendingDialogFragment f11400a;

        C12648(LocationSendingDialogFragment locationSendingDialogFragment) {
            this.f11400a = locationSendingDialogFragment;
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            Object obj;
            LocationSendingDialogFragment locationSendingDialogFragment = this.f11400a;
            boolean z = true;
            if (keyEvent.getAction() == 1 && i == 4) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null || !locationSendingDialogFragment.O_()) {
                z = false;
            }
            return z;
        }
    }

    public static void m11988a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        LocationSendingDialogFragment locationSendingDialogFragment = (LocationSendingDialogFragment) obj;
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector);
        RuntimePermissionsUtil b = RuntimePermissionsUtil.b(fbInjector);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        ViewOrientationLockHelperProvider viewOrientationLockHelperProvider = (ViewOrientationLockHelperProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ViewOrientationLockHelperProvider.class);
        locationSendingDialogFragment.am = fbSharedPreferences;
        locationSendingDialogFragment.an = b;
        locationSendingDialogFragment.ao = secureContextHelper;
        locationSendingDialogFragment.ap = viewOrientationLockHelperProvider;
    }

    public static LocationSendingDialogFragment m11987a(LocationSendingDialogConfig locationSendingDialogConfig) {
        Bundle bundle = new Bundle();
        locationSendingDialogConfig.f11389b.a(bundle);
        if (locationSendingDialogConfig.f11388a != null) {
            bundle.putString("button_style", locationSendingDialogConfig.f11388a.name());
        }
        if (locationSendingDialogConfig.f11390c != null) {
            bundle.putParcelable("initial_pinned_location", locationSendingDialogConfig.f11390c);
        } else if (locationSendingDialogConfig.f11391d != null) {
            bundle.putParcelable("initial_nearby_place", locationSendingDialogConfig.f11391d);
        }
        bundle.putBoolean("show_dismiss_button", locationSendingDialogConfig.f11392e);
        LocationSendingDialogFragment locationSendingDialogFragment = new LocationSendingDialogFragment();
        locationSendingDialogFragment.g(bundle);
        return locationSendingDialogFragment;
    }

    public final void m11993a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1608638634);
        super.a(bundle);
        Class cls = LocationSendingDialogFragment.class;
        m11988a((Object) this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -468133920, a);
    }

    public final View m11991a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 112326898);
        View inflate = layoutInflater.cloneInContext(new ContextThemeWrapper(layoutInflater.getContext(), d())).inflate(2130905128, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1860454291, a);
        return inflate;
    }

    public final void m11995a(View view, @Nullable Bundle bundle) {
        this.aw = this.ap.a(this.T);
        this.aw.a();
        this.at = ViewStubHolder.a((ViewStubCompat) e(2131563587));
        this.at.c = new C12571(this);
        Toolbar toolbar = (Toolbar) view.findViewById(2131563543);
        toolbar.setTitle(2131240247);
        if (this.s == null || !this.s.getBoolean("show_dismiss_button", true)) {
            toolbar.setNavigationIcon(null);
        } else {
            toolbar.setNavigationOnClickListener(new C12582(this));
        }
        toolbar.a(2131820591);
        this.as = toolbar.getMenu().findItem(2131568656);
        MenuItemCompat.a(this.as, new C12604(this));
        SearchView searchView = (SearchView) this.as.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint(b(2131241011));
        searchView.mOnQueryChangeListener = new C12615(this);
        if (this.an.a(aq)) {
            aw();
        } else {
            this.at.f();
        }
    }

    public final void m11994a(Fragment fragment) {
        if (fragment instanceof LocationSendingMainFragment) {
            this.au = (LocationSendingMainFragment) fragment;
            this.au.f11407d = new C12626(this);
        } else if (fragment instanceof NearbyPlacesSearchResultsFragment) {
            this.av = (NearbyPlacesSearchResultsFragment) fragment;
            this.av.f11477d = new C12637(this);
        }
    }

    public final Dialog m11996c(Bundle bundle) {
        Dialog c = super.c(bundle);
        c.setOnKeyListener(new C12648(this));
        return c;
    }

    public final boolean O_() {
        if (!ay(this)) {
            return super.O_();
        }
        this.as.collapseActionView();
        return true;
    }

    public final void m11992a(int i, int i2, Intent intent) {
        if (i == 1654 && i2 == -1) {
            Integer num = (Integer) ((HashMap) intent.getSerializableExtra("extra_permission_results")).get(aq[0]);
            if (num != null) {
                switch (num.intValue()) {
                    case 0:
                        this.at.e();
                        this.as.setVisible(true);
                        return;
                    case 1:
                        this.am.edit().putBoolean(RequestPermissionsPrefKeys.f20405d, false).commit();
                        return;
                    case 2:
                        if (this.am.a(RequestPermissionsPrefKeys.f20405d, false)) {
                            this.an.b();
                        } else {
                            this.am.edit().putBoolean(RequestPermissionsPrefKeys.f20405d, true).commit();
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public final void m11989G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 563059715);
        super.G();
        if (s().a("main_location_sending") == null && this.an.a(aq)) {
            aw();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 286895041, a);
    }

    public final void m11990I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -993139136);
        super.I();
        this.aw.b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2072796829, a);
    }

    public static boolean ay(LocationSendingDialogFragment locationSendingDialogFragment) {
        return locationSendingDialogFragment.av != null && locationSendingDialogFragment.av.z();
    }

    private void aw() {
        Bundle bundle = this.s;
        ButtonStyle valueOf = ButtonStyle.valueOf(bundle.getString("button_style", ButtonStyle.SEND.name()));
        LocationSendingMainFragment locationSendingMainFragment = new LocationSendingMainFragment();
        locationSendingMainFragment.m12015a(valueOf);
        LatLng latLng = (LatLng) bundle.getParcelable("initial_pinned_location");
        if (latLng != null) {
            locationSendingMainFragment.ao = latLng;
        }
        NearbyPlace nearbyPlace = (NearbyPlace) bundle.getParcelable("initial_nearby_place");
        if (nearbyPlace != null) {
            locationSendingMainFragment.ap = nearbyPlace;
        }
        s().a().a(2131563586, locationSendingMainFragment, "main_location_sending").b();
    }
}
