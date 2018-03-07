package com.facebook.abtest.qe.bootstrap.registry;

import com.facebook.abtest.qe.bootstrap.framework.BaseQuickExperiment;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;

/* compiled from: last_phone_address_book_update */
public class QuickExperimentSpecification {
    public final String f9568a;
    public final boolean f9569b;
    private ImmutableSet<Class<? extends BaseQuickExperiment>> f9570c;

    QuickExperimentSpecification(QuickExperimentSpecificationBuilder quickExperimentSpecificationBuilder) {
        boolean z;
        String str = quickExperimentSpecificationBuilder.f9571a;
        Preconditions.checkNotNull(str, "You have to supply a name for your QuickExperimentSpecification");
        if (str.contains(" ")) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z, "Invalid name: \"%s\" - experiment names may not contain spaces", new Object[]{str});
        this.f9568a = str;
        this.f9570c = ImmutableSet.copyOf(quickExperimentSpecificationBuilder.f9572b);
        this.f9569b = quickExperimentSpecificationBuilder.f9573c;
    }

    public static QuickExperimentSpecificationBuilder newBuilder() {
        return new QuickExperimentSpecificationBuilder();
    }

    public final synchronized ImmutableSet<Class<? extends BaseQuickExperiment>> m9951a() {
        return this.f9570c;
    }
}
