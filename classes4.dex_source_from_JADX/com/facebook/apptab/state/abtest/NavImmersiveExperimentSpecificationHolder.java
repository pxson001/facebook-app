package com.facebook.apptab.state.abtest;

import com.facebook.abtest.qe.bootstrap.registry.QuickExperimentSpecification;
import com.facebook.abtest.qe.bootstrap.registry.QuickExperimentSpecificationBuilder;
import com.facebook.abtest.qe.bootstrap.registry.QuickExperimentSpecificationHolder;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: last_location_update_age_ms */
public class NavImmersiveExperimentSpecificationHolder implements QuickExperimentSpecificationHolder {
    private final ImmutableSet<QuickExperimentSpecification> f9579a;

    @Inject
    public NavImmersiveExperimentSpecificationHolder() {
        QuickExperimentSpecificationBuilder newBuilder = QuickExperimentSpecification.newBuilder();
        newBuilder.f9571a = "immersive_views_11_06";
        this.f9579a = ImmutableSet.of(newBuilder.m9953a(NavImmersiveExperiment.class).m9952a());
    }

    public final ImmutableSet<QuickExperimentSpecification> mo765a() {
        return this.f9579a;
    }
}
