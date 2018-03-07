package com.facebook.resources.impl.loading;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.resources.impl.loading.LanguagePackLoader.Delegate;

/* compiled from: user_left_reaction/ */
public class LanguagePackLoaderProvider extends AbstractAssistedProvider<LanguagePackLoader> {
    public final LanguagePackLoader m2734a(LanguageRequest languageRequest, Delegate delegate) {
        return new LanguagePackLoader(IdBasedSingletonScopeProvider.m1810b(this, 3834), FlattenedStringResourcesParser.m5045a((InjectorLike) this), languageRequest, delegate);
    }
}
