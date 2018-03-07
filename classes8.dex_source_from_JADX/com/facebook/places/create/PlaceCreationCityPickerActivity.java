package com.facebook.places.create;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.places.create.citypicker.NewCityPickerFragment;
import com.facebook.places.create.citypicker.logger.CityPickerLoggerFactory.Type;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;

/* compiled from: cc */
public class PlaceCreationCityPickerActivity extends BasePlaceCreationActivity {

    /* compiled from: cc */
    class CitySelectedListener implements com.facebook.places.create.citypicker.NewCityPickerFragment.CitySelectedListener {
        public final void mo190a(NewCityPickerFragment newCityPickerFragment, CheckinPlaceModel checkinPlaceModel, boolean z) {
            FragmentActivity o = newCityPickerFragment.o();
            Intent intent = new Intent();
            FlatBufferModelHelper.a(intent, "picked_city", checkinPlaceModel);
            intent.putExtra("is_currently_there", z);
            o.setResult(-1, intent);
            o.finish();
        }
    }

    protected final String mo1087i() {
        return getString(2131235265);
    }

    protected final void mo1086b(Bundle bundle) {
        super.mo1086b(bundle);
        if (kO_().a(2131558429) == null) {
            kO_().a().b(2131558429, NewCityPickerFragment.m3493a((Location) getIntent().getParcelableExtra("current_location"), false, true, new CitySelectedListener(), false, Type.PLACE_CREATION_LOGGER, getIntent().getParcelableExtra("crowdsourcing_context"))).b();
        }
    }
}
