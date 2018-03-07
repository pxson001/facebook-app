package com.facebook.search.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.typeahead.BaseTypeaheadController.TypeaheadDispatchStrategy;
import com.facebook.ui.typeahead.DefaultTypeaheadDispatchStrategy;

/* compiled from: TEXT_PULL_QUOTE */
public class TypeaheadDispatchStrategyMethodAutoProvider extends AbstractProvider<TypeaheadDispatchStrategy> {
    public static DefaultTypeaheadDispatchStrategy m25836b(InjectorLike injectorLike) {
        return GraphSearchModule.m25832b(IdBasedProvider.a(injectorLike, 11514));
    }

    public Object get() {
        return GraphSearchModule.m25832b(IdBasedProvider.a(this, 11514));
    }
}
