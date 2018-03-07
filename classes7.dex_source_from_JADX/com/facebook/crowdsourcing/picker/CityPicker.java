package com.facebook.crowdsourcing.picker;

import android.content.ComponentName;
import android.content.Intent;
import android.location.Location;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.crowdsourcing.enums.SuggestEditsInputType;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.SuggestEditsField;
import com.facebook.crowdsourcing.suggestedits.data.SuggestEditsFieldMutator;
import com.facebook.crowdsourcing.suggestedits.helper.ExtractValuesHelper;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.places.create.citypicker.CityPickerFragmentFactory;
import com.facebook.places.create.citypicker.logger.CityPickerLoggerFactory.Type;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.facebook.livephotos.exoplayer.extractor.ts.PsExtractor */
public class CityPicker implements SuggestEditsPicker<SuggestEditsField> {
    private Provider<ComponentName> f17442a;

    public final Intent mo1362a(Object obj, Fragment fragment) {
        SuggestEditsField suggestEditsField = (SuggestEditsField) obj;
        Intent component = new Intent().setComponent((ComponentName) this.f17442a.get());
        component.putExtra("target_fragment", ContentFragmentType.CITY_PICKER_FRAGMENT.ordinal());
        Parcelable h = ExtractValuesHelper.m21540h(suggestEditsField);
        String str = "extra_current_location";
        if (h == null) {
            h = new Location("");
        }
        component.putExtra(str, h);
        component.putExtra("extra_logger_type", Type.NO_LOGGER);
        return component;
    }

    public final Object mo1364a(Intent intent, Object obj) {
        return SuggestEditsFieldMutator.m21497a((SuggestEditsField) obj, (CheckinPlaceModel) FlatBufferModelHelper.a(intent, CityPickerFragmentFactory.a));
    }

    @Inject
    public CityPicker(@FragmentChromeActivity Provider<ComponentName> provider) {
        this.f17442a = provider;
    }

    public final SuggestEditsInputType mo1363a() {
        return SuggestEditsInputType.CITY_PICKER;
    }
}
