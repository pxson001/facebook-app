package com.facebook.graphql.executor;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: feed_pyml */
public class ShimmedMutationMethodProvider extends AbstractAssistedProvider<ShimmedMutationMethod> {
    public final ShimmedMutationMethod m12458a(String str, boolean z) {
        return new ShimmedMutationMethod(str, z, FbObjectMapperMethodAutoProvider.a(this));
    }
}
