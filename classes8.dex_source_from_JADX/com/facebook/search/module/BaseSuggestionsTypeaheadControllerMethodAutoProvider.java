package com.facebook.search.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.search.suggestions.BaseSuggestionsTypeaheadController;

/* compiled from: TEXT_SUBTITLE */
public class BaseSuggestionsTypeaheadControllerMethodAutoProvider extends AbstractProvider<BaseSuggestionsTypeaheadController> {
    public static BaseSuggestionsTypeaheadController m25827b(InjectorLike injectorLike) {
        return GraphSearchModule.m25831a(IdBasedProvider.a(injectorLike, 10871));
    }

    public Object get() {
        return GraphSearchModule.m25831a(IdBasedProvider.a(this, 10871));
    }
}
