package com.facebook.omnistore.module;

import com.facebook.inject.AbstractDefaultScopeLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;

/* compiled from: text_only_name */
public final class C0159xcf0f5b1d extends AbstractDefaultScopeLazy {
    public C0159xcf0f5b1d(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return Boolean_OmnistoreDontDeleteDbOnOpenErrorGatekeeperAutoProvider.createInstance__java_lang_Boolean__com_facebook_omnistore_module_OmnistoreDontDeleteDbOnOpenError__INJECTED_BY_TemplateInjector(injectorLike);
    }

    public static Lazy<Boolean> getLazy(InjectorLike injectorLike) {
        return new C0159xcf0f5b1d(injectorLike);
    }
}
