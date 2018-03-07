package com.facebook.ufiservices.qe;

import com.facebook.abtest.qe.bootstrap.registry.QuickExperimentSpecification;
import com.facebook.abtest.qe.bootstrap.registry.QuickExperimentSpecificationBuilder;
import com.facebook.abtest.qe.bootstrap.registry.QuickExperimentSpecificationHolder;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: last_blacklist_synced_time */
public class UfiServicesQuickExperimentSpecificationHolder implements QuickExperimentSpecificationHolder {
    private final ImmutableSet<QuickExperimentSpecification> f9599a;

    @Inject
    public UfiServicesQuickExperimentSpecificationHolder() {
        QuickExperimentSpecificationBuilder newBuilder = QuickExperimentSpecification.newBuilder();
        newBuilder.f9571a = "fb4a_per_attachment_truncation";
        this.f9599a = ImmutableSet.of(newBuilder.m9953a(PerAttachmentMessageTruncatorQuickExperiment.class).m9952a());
    }

    public final ImmutableSet<QuickExperimentSpecification> mo765a() {
        return this.f9599a;
    }
}
