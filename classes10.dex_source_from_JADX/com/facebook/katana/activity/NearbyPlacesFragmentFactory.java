package com.facebook.katana.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.common.util.TriState;
import com.facebook.nearby.places.NearbyPlacesFragment;
import com.facebook.nearby.v2.NearbyPlacesV2Fragment;
import com.facebook.nearby.v2.logging.NearbyPlacesSession.EntryPoint;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: SDK */
public class NearbyPlacesFragmentFactory implements IFragmentFactory {
    private final Provider<TriState> f24291a;

    @Inject
    public NearbyPlacesFragmentFactory(Provider<TriState> provider) {
        this.f24291a = provider;
    }

    public final Fragment m25592a(Intent intent) {
        Object obj = null;
        if (((TriState) this.f24291a.get()).equals(TriState.YES)) {
            Object stringExtra;
            Object stringExtra2;
            Serializable serializable = EntryPoint.UNKNOWN;
            if (intent.hasExtra("nearby_places_entry")) {
                serializable = (EntryPoint) intent.getSerializableExtra("nearby_places_entry");
            }
            if (intent.hasExtra("nearby_places_query_topic") && intent.hasExtra("nearby_places_location_id") && intent.hasExtra("nearby_places_location_name")) {
                stringExtra = intent.getStringExtra("nearby_places_query_topic");
                stringExtra2 = intent.getStringExtra("nearby_places_location_id");
                obj = intent.getStringExtra("nearby_places_location_name");
            } else {
                stringExtra2 = null;
                stringExtra = null;
            }
            NearbyPlacesV2Fragment nearbyPlacesV2Fragment = new NearbyPlacesV2Fragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("nearby_places_entry_point", serializable);
            if (!(TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || TextUtils.isEmpty(obj))) {
                bundle.putString("nearby_places_query_topic", stringExtra);
                bundle.putString("nearby_places_location_id", stringExtra2);
                bundle.putString("nearby_places_location_name", obj);
            }
            nearbyPlacesV2Fragment.g(bundle);
            return nearbyPlacesV2Fragment;
        }
        Fragment nearbyPlacesFragment = new NearbyPlacesFragment();
        nearbyPlacesFragment.g(intent.getExtras());
        return nearbyPlacesFragment;
    }
}
