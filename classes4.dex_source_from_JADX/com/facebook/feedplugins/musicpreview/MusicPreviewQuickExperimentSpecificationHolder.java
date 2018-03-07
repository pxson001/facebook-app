package com.facebook.feedplugins.musicpreview;

import com.facebook.abtest.qe.bootstrap.registry.QuickExperimentSpecification;
import com.facebook.abtest.qe.bootstrap.registry.QuickExperimentSpecificationBuilder;
import com.facebook.abtest.qe.bootstrap.registry.QuickExperimentSpecificationHolder;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: last_fetch_locale */
public class MusicPreviewQuickExperimentSpecificationHolder implements QuickExperimentSpecificationHolder {
    private final ImmutableSet<QuickExperimentSpecification> f9581a;

    @Inject
    public MusicPreviewQuickExperimentSpecificationHolder() {
        QuickExperimentSpecificationBuilder newBuilder = QuickExperimentSpecification.newBuilder();
        newBuilder.f9571a = "music_preview";
        this.f9581a = ImmutableSet.of(newBuilder.m9953a(MusicPreviewQuickExperiment.class).m9952a());
    }

    public final ImmutableSet<QuickExperimentSpecification> mo765a() {
        return this.f9581a;
    }
}
