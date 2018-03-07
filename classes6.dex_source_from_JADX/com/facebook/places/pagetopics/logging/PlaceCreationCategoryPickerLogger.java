package com.facebook.places.pagetopics.logging;

import com.facebook.crowdsourcing.logging.CrowdsourcingContext;
import com.facebook.crowdsourcing.logging.PlaceCreationAnalyticsLogger;
import com.facebook.crowdsourcing.logging.PlaceCreationAnalyticsLogger.FieldType;
import com.facebook.inject.Assisted;
import com.facebook.ipc.model.PageTopic;
import javax.inject.Inject;

/* compiled from: flowable_taggable_activity */
public class PlaceCreationCategoryPickerLogger implements PlaceCategoryPickerLogger {
    private final PlaceCreationAnalyticsLogger f14777a;
    private final CrowdsourcingContext f14778b;

    @Inject
    public PlaceCreationCategoryPickerLogger(PlaceCreationAnalyticsLogger placeCreationAnalyticsLogger, @Assisted CrowdsourcingContext crowdsourcingContext) {
        this.f14777a = placeCreationAnalyticsLogger;
        this.f14778b = crowdsourcingContext;
    }

    public final void mo1174a(PageTopic pageTopic, String str) {
        this.f14777a.m12455a(this.f14778b, FieldType.PLACE_CATEGORY, pageTopic.id, str);
    }

    public final void mo1173a(PageTopic pageTopic) {
        this.f14777a.m12453a(this.f14778b, pageTopic.id);
    }

    public final void mo1175a(String str) {
        this.f14777a.m12456a(this.f14778b, FieldType.PLACE_CATEGORY, str);
    }

    public final void mo1176b(PageTopic pageTopic) {
        this.f14777a.m12460b(this.f14778b, pageTopic.id);
    }
}
