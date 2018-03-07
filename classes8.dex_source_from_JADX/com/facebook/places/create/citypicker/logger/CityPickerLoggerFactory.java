package com.facebook.places.create.citypicker.logger;

import android.os.Parcelable;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.crowdsourcing.logging.CrowdsourcingContext;
import com.facebook.crowdsourcing.logging.CrowdsourcingSession;
import javax.inject.Inject;

/* compiled from: see_all_friend_requests */
public class CityPickerLoggerFactory {
    private final CityPickerPlaceCreationLoggerProvider f3607a;

    /* compiled from: see_all_friend_requests */
    public enum Type {
        NO_LOGGER,
        PLACE_CREATION_LOGGER
    }

    @Inject
    public CityPickerLoggerFactory(CityPickerPlaceCreationLoggerProvider cityPickerPlaceCreationLoggerProvider) {
        this.f3607a = cityPickerPlaceCreationLoggerProvider;
    }

    public final CityPickerLogger m3539a(Type type, Parcelable parcelable) {
        switch (type) {
            case PLACE_CREATION_LOGGER:
                if (!(parcelable instanceof CrowdsourcingContext)) {
                    return new CityPickerNoopLogger();
                }
                CityPickerPlaceCreationLoggerProvider cityPickerPlaceCreationLoggerProvider = this.f3607a;
                return new CityPickerPlaceCreationLogger(AnalyticsLoggerMethodAutoProvider.a(cityPickerPlaceCreationLoggerProvider), CrowdsourcingSession.a(cityPickerPlaceCreationLoggerProvider), (CrowdsourcingContext) parcelable);
            default:
                return new CityPickerNoopLogger();
        }
    }
}
