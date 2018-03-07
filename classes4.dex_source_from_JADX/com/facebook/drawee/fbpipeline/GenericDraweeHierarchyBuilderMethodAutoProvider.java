package com.facebook.drawee.fbpipeline;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: o_user_id */
public class GenericDraweeHierarchyBuilderMethodAutoProvider extends AbstractProvider<GenericDraweeHierarchyBuilder> {
    public static GenericDraweeHierarchyBuilder m6808b(InjectorLike injectorLike) {
        return GenericDraweeHierarchyBuilder.a(ResourcesMethodAutoProvider.a(injectorLike));
    }

    public Object get() {
        return GenericDraweeHierarchyBuilder.a(ResourcesMethodAutoProvider.a(this));
    }
}
