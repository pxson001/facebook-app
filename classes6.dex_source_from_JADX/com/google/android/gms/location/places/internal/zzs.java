package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.internal.PlaceImpl.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class zzs extends zzu implements Place {
    private boolean f6593c;
    private final zzp f6594d;
    private final String f6595e;

    public zzs(DataHolder dataHolder, int i, Context context) {
        super(dataHolder, i);
        this.f6594d = context != null ? zzp.m9102a(context) : null;
        this.f6593c = m9007a("place_is_logging_enabled", false);
        this.f6595e = m9004a("place_id", "");
    }

    private CharSequence m9108d() {
        m9113h("getAddress");
        return m9004a("place_address", "");
    }

    private String m9109e() {
        m9113h("getId");
        return this.f6595e;
    }

    private float m9110f() {
        m9113h("getLevelNumber");
        return m9001a("place_level_number", 0.0f);
    }

    private Locale m9111g() {
        m9113h("getLocale");
        Object a = m9004a("place_locale", "");
        return !TextUtils.isEmpty(a) ? new Locale(a) : Locale.getDefault();
    }

    private CharSequence m9112h() {
        m9113h("getName");
        return m9004a("place_name", "");
    }

    private void m9113h(String str) {
        if (this.f6593c && this.f6594d != null) {
            this.f6594d.m9105a(this.f6595e, str);
        }
    }

    private CharSequence m9114i() {
        m9113h("getPhoneNumber");
        return m9004a("place_phone_number", "");
    }

    private List<Integer> m9115j() {
        m9113h("getPlaceTypes");
        return m9006a("place_types", Collections.emptyList());
    }

    private int m9116k() {
        m9113h("getPriceLevel");
        return m9002a("place_price_level", -1);
    }

    private float m9117l() {
        m9113h("getRating");
        return m9001a("place_rating", -1.0f);
    }

    private LatLngBounds m9118m() {
        m9113h("getViewport");
        return (LatLngBounds) m9003a("place_viewport", LatLngBounds.CREATOR);
    }

    private Uri m9119n() {
        m9113h("getWebsiteUri");
        String a = m9004a("place_website_uri", null);
        return a == null ? null : Uri.parse(a);
    }

    private boolean m9120o() {
        m9113h("isPermanentlyClosed");
        return m9007a("place_is_permanently_closed", false);
    }

    public final Object m9121a() {
        zza com_google_android_gms_location_places_internal_PlaceImpl_zza = new zza();
        com_google_android_gms_location_places_internal_PlaceImpl_zza.f6516s = this.f6593c;
        com_google_android_gms_location_places_internal_PlaceImpl_zza = com_google_android_gms_location_places_internal_PlaceImpl_zza;
        this.f6593c = false;
        com_google_android_gms_location_places_internal_PlaceImpl_zza.f6512o = m9108d().toString();
        com_google_android_gms_location_places_internal_PlaceImpl_zza = com_google_android_gms_location_places_internal_PlaceImpl_zza;
        com_google_android_gms_location_places_internal_PlaceImpl_zza.f6515r = m9008b("place_attributions", Collections.emptyList());
        com_google_android_gms_location_places_internal_PlaceImpl_zza = com_google_android_gms_location_places_internal_PlaceImpl_zza;
        com_google_android_gms_location_places_internal_PlaceImpl_zza.f6499b = m9109e();
        com_google_android_gms_location_places_internal_PlaceImpl_zza = com_google_android_gms_location_places_internal_PlaceImpl_zza;
        com_google_android_gms_location_places_internal_PlaceImpl_zza.f6507j = m9120o();
        com_google_android_gms_location_places_internal_PlaceImpl_zza = com_google_android_gms_location_places_internal_PlaceImpl_zza;
        com_google_android_gms_location_places_internal_PlaceImpl_zza.f6502e = mo491b();
        com_google_android_gms_location_places_internal_PlaceImpl_zza = com_google_android_gms_location_places_internal_PlaceImpl_zza;
        com_google_android_gms_location_places_internal_PlaceImpl_zza.f6503f = m9110f();
        com_google_android_gms_location_places_internal_PlaceImpl_zza = com_google_android_gms_location_places_internal_PlaceImpl_zza;
        com_google_android_gms_location_places_internal_PlaceImpl_zza.f6501d = m9112h().toString();
        com_google_android_gms_location_places_internal_PlaceImpl_zza = com_google_android_gms_location_places_internal_PlaceImpl_zza;
        com_google_android_gms_location_places_internal_PlaceImpl_zza.f6513p = m9114i().toString();
        com_google_android_gms_location_places_internal_PlaceImpl_zza = com_google_android_gms_location_places_internal_PlaceImpl_zza;
        com_google_android_gms_location_places_internal_PlaceImpl_zza.f6509l = m9116k();
        com_google_android_gms_location_places_internal_PlaceImpl_zza = com_google_android_gms_location_places_internal_PlaceImpl_zza;
        com_google_android_gms_location_places_internal_PlaceImpl_zza.f6508k = m9117l();
        com_google_android_gms_location_places_internal_PlaceImpl_zza = com_google_android_gms_location_places_internal_PlaceImpl_zza;
        com_google_android_gms_location_places_internal_PlaceImpl_zza.f6511n = m9115j();
        com_google_android_gms_location_places_internal_PlaceImpl_zza = com_google_android_gms_location_places_internal_PlaceImpl_zza;
        com_google_android_gms_location_places_internal_PlaceImpl_zza.f6504g = m9118m();
        com_google_android_gms_location_places_internal_PlaceImpl_zza = com_google_android_gms_location_places_internal_PlaceImpl_zza;
        com_google_android_gms_location_places_internal_PlaceImpl_zza.f6506i = m9119n();
        PlaceImpl a = com_google_android_gms_location_places_internal_PlaceImpl_zza.m8979a();
        a.f6540x = m9111g();
        a.f6541y = this.f6594d;
        return a;
    }

    public final LatLng mo491b() {
        m9113h("getLatLng");
        return (LatLng) m9003a("place_lat_lng", LatLng.CREATOR);
    }
}
