package com.facebook.places.create.citypicker.logger;

import com.facebook.crowdsourcing.logging.PlaceCreationAnalyticsLogger.FieldType;
import com.facebook.inject.InjectorLike;

/* compiled from: see_all_components */
public class CityPickerNoopLogger implements CityPickerLogger {
    public static CityPickerNoopLogger m3540a(InjectorLike injectorLike) {
        return new CityPickerNoopLogger();
    }

    public final void mo192a(FieldType fieldType, long j) {
    }

    public final void mo191a(long j) {
    }

    public final void mo193a(FieldType fieldType, long j, String str) {
    }
}
