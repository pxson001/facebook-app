package com.facebook.places.pagetopics.logging;

import android.os.Parcelable;
import com.facebook.crowdsourcing.logging.CrowdsourcingContext;
import com.facebook.crowdsourcing.logging.PlaceCreationAnalyticsLogger;
import javax.inject.Inject;

/* compiled from: flyout_likers_animation_perf */
public class PlaceCategoryPickerLoggerFactory {
    private final PlaceCreationCategoryPickerLoggerProvider f14776a;

    /* compiled from: flyout_likers_animation_perf */
    public enum Type {
        NO_LOGGER,
        PLACE_CREATION_LOGGER
    }

    @Inject
    public PlaceCategoryPickerLoggerFactory(PlaceCreationCategoryPickerLoggerProvider placeCreationCategoryPickerLoggerProvider) {
        this.f14776a = placeCreationCategoryPickerLoggerProvider;
    }

    public final PlaceCategoryPickerLogger m22419a(Type type, Parcelable parcelable) {
        switch (type) {
            case PLACE_CREATION_LOGGER:
                if (!(parcelable instanceof CrowdsourcingContext)) {
                    return new PlaceCategoryPickerNoopLogger();
                }
                return new PlaceCreationCategoryPickerLogger(PlaceCreationAnalyticsLogger.m12449a(this.f14776a), (CrowdsourcingContext) parcelable);
            default:
                return new PlaceCategoryPickerNoopLogger();
        }
    }
}
