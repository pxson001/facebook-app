package com.facebook.omnistore.module;

import com.facebook.inject.AbstractDefaultScopeProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Provider;

/* compiled from: text_list */
public final class C0168xe6091f9a extends AbstractDefaultScopeProvider {
    C0168xe6091f9a(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return Boolean_OmnistoreDontDeleteDbOnOpenErrorGatekeeperAutoProvider.createInstance__java_lang_Boolean__com_facebook_omnistore_module_OmnistoreDontDeleteDbOnOpenError__INJECTED_BY_TemplateInjector(injectorLike);
    }

    public static Provider<Boolean> getProvider(InjectorLike injectorLike) {
        return new C0168xe6091f9a(injectorLike);
    }
}
