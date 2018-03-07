package com.facebook.places.create.citypicker;

import android.content.Intent;
import android.location.Location;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.places.create.citypicker.logger.CityPickerLoggerFactory.Type;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;

/* compiled from: see_more_session_id */
public class CityPickerFragmentFactory implements IFragmentFactory {
    public static String f3559a = "extra_selected_city";

    /* compiled from: see_more_session_id */
    class CitySelectedListener implements com.facebook.places.create.citypicker.NewCityPickerFragment.CitySelectedListener {
        public final void mo190a(NewCityPickerFragment newCityPickerFragment, CheckinPlaceModel checkinPlaceModel, boolean z) {
            Intent intent = new Intent();
            FlatBufferModelHelper.a(intent, CityPickerFragmentFactory.f3559a, checkinPlaceModel);
            newCityPickerFragment.ao().setResult(-1, intent);
            newCityPickerFragment.ao().onBackPressed();
        }
    }

    public final Fragment m3483a(Intent intent) {
        Type type = (Type) intent.getSerializableExtra("extra_logger_type");
        return NewCityPickerFragment.m3493a((Location) intent.getParcelableExtra("extra_current_location"), false, false, new CitySelectedListener(), false, type != null ? type : Type.NO_LOGGER, intent.getParcelableExtra("extra_logger_params"));
    }
}
