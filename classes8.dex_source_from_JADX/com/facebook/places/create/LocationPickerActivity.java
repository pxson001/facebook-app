package com.facebook.places.create;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.widget.TextView;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.composer.ui.titlebar.ComposerBaseTitleBar;
import com.facebook.composer.ui.titlebar.ComposerTitleBar;
import com.facebook.composer.ui.titlebar.ComposerTitleBar.StateBuilder;
import com.facebook.composer.ui.titlebar.HarrisonPlusIconType;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.common.base.Preconditions;

/* compiled from: centerVertical */
public class LocationPickerActivity extends FbFragmentActivity {
    public Location f18128p;
    private String f18129q;
    private int f18130r;
    private TextView f18131s;
    private SupportMapFragment f18132t;

    /* compiled from: centerVertical */
    class C19601 implements OnBackPressedListener {
        final /* synthetic */ LocationPickerActivity f18126a;

        C19601(LocationPickerActivity locationPickerActivity) {
            this.f18126a = locationPickerActivity;
        }

        public final void m22109a() {
            this.f18126a.onBackPressed();
        }
    }

    /* compiled from: centerVertical */
    class C19612 implements OnCameraChangeListener {
        final /* synthetic */ LocationPickerActivity f18127a;

        C19612(LocationPickerActivity locationPickerActivity) {
            this.f18127a = locationPickerActivity;
        }

        public final void m22110a(CameraPosition cameraPosition) {
            this.f18127a.f18128p.setLatitude(cameraPosition.a.a);
            this.f18127a.f18128p.setLongitude(cameraPosition.a.b);
        }
    }

    public final void m22116b(Bundle bundle) {
        setContentView(2130905123);
        this.f18128p = (Location) getIntent().getParcelableExtra("extra_location");
        this.f18129q = getIntent().getStringExtra("extra_place_name");
        this.f18130r = getIntent().getIntExtra("extra_zoom_level", 16);
        Preconditions.checkNotNull(this.f18128p);
        Preconditions.checkNotNull(this.f18129q);
        this.f18131s = (TextView) a(2131563551);
        this.f18132t = (SupportMapFragment) kO_().a(2131563552);
        m22112i();
        m22113j();
        setResult(-1, new Intent().putExtra("selected_location", this.f18128p));
    }

    private void m22112i() {
        ComposerBaseTitleBar composerBaseTitleBar = (ComposerBaseTitleBar) a(2131560528);
        composerBaseTitleBar.setOnBackPressedListener(new C19601(this));
        StateBuilder stateBuilder = new StateBuilder();
        stateBuilder.a = getResources().getString(2131235255);
        stateBuilder = stateBuilder;
        stateBuilder.d = HarrisonPlusIconType.c();
        ComposerTitleBar composerTitleBar = new ComposerTitleBar(composerBaseTitleBar, stateBuilder.a());
    }

    private void m22113j() {
        this.f18131s.setText(m22114k());
        m22115l();
    }

    private SpannableString m22114k() {
        return new StyledStringBuilder(getResources()).a(getString(2131235256, new Object[]{SafeUUIDGenerator.a().toString()})).a(SafeUUIDGenerator.a().toString(), this.f18129q, new StyleSpan(1), 33).b();
    }

    private void m22115l() {
        GoogleMap a = this.f18132t.a();
        if (a != null) {
            UiSettings e = a.e();
            e.g(false);
            e.f(false);
            e.b(false);
            e.a(false);
            a.a(CameraUpdateFactory.a(new LatLng(this.f18128p.getLatitude(), this.f18128p.getLongitude()), (float) this.f18130r));
            a.a(new C19612(this));
        }
    }
}
