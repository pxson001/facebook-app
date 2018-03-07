package com.facebook.apptab.state.abtest;

import com.facebook.abtest.qe.bootstrap.registry.QuickExperimentSpecification;
import com.facebook.abtest.qe.bootstrap.registry.QuickExperimentSpecificationBuilder;
import com.facebook.abtest.qe.bootstrap.registry.QuickExperimentSpecificationHolder;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: last_full_upload_success_timestamp */
public class NavMemoryExperimentSpecificationHolder implements QuickExperimentSpecificationHolder {
    private final ImmutableSet<QuickExperimentSpecification> f9580a;

    @Inject
    public NavMemoryExperimentSpecificationHolder() {
        QuickExperimentSpecificationBuilder newBuilder = QuickExperimentSpecification.newBuilder();
        newBuilder.f9571a = "android_memory_nav_tests";
        this.f9580a = ImmutableSet.of(newBuilder.m9953a(NavMemoryExperiment.class).m9952a());
    }

    public final ImmutableSet<QuickExperimentSpecification> mo765a() {
        return this.f9580a;
    }
}
