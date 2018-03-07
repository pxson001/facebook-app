package com.facebook.abtest.qe.bootstrap.registry;

import com.facebook.abtest.qe.bootstrap.framework.BaseQuickExperiment;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.Nonnull;

/* compiled from: last_partial_download_time */
public class QuickExperimentSpecificationBuilder {
    public String f9571a = null;
    Set<Class<? extends BaseQuickExperiment>> f9572b = Sets.a();
    public boolean f9573c;

    QuickExperimentSpecificationBuilder() {
    }

    public final QuickExperimentSpecificationBuilder m9953a(@Nonnull Class<? extends BaseQuickExperiment> cls) {
        this.f9572b.add(cls);
        return this;
    }

    public final QuickExperimentSpecification m9952a() {
        return new QuickExperimentSpecification(this);
    }
}
