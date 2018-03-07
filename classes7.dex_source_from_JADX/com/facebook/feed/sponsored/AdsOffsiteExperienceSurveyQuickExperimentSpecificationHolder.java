package com.facebook.feed.sponsored;

import com.facebook.abtest.qe.bootstrap.registry.QuickExperimentSpecification;
import com.facebook.abtest.qe.bootstrap.registry.QuickExperimentSpecificationBuilder;
import com.facebook.abtest.qe.bootstrap.registry.QuickExperimentSpecificationHolder;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: Typing_Indicator_Cell_Shown_With_Text */
public class AdsOffsiteExperienceSurveyQuickExperimentSpecificationHolder implements QuickExperimentSpecificationHolder {
    private final ImmutableSet<QuickExperimentSpecification> f21677a;

    public static AdsOffsiteExperienceSurveyQuickExperimentSpecificationHolder m24254a(InjectorLike injectorLike) {
        return new AdsOffsiteExperienceSurveyQuickExperimentSpecificationHolder();
    }

    @Inject
    public AdsOffsiteExperienceSurveyQuickExperimentSpecificationHolder() {
        QuickExperimentSpecificationBuilder newBuilder = QuickExperimentSpecification.newBuilder();
        newBuilder.a = "android_ad_offsite_experience_survey";
        this.f21677a = ImmutableSet.of(newBuilder.a(AdsOffsiteExperienceSurveyQuickExperiment.class).a());
    }

    public final ImmutableSet<QuickExperimentSpecification> m24255a() {
        return this.f21677a;
    }
}
