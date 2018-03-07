package com.facebook.omnistore.logger;

import com.facebook.inject.AbstractSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Provider;

/* compiled from: text_content */
public final class C0156x62481eac extends AbstractSingletonScopeProvider {
    C0156x62481eac(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return FbOmnistoreErrorReporter.getInstance__com_facebook_omnistore_logger_FbOmnistoreErrorReporter__INJECTED_BY_TemplateInjector(injectorLike);
    }

    public static Provider<FbOmnistoreErrorReporter> getProvider(InjectorLike injectorLike) {
        return new C0156x62481eac(injectorLike);
    }

    public static Lazy<FbOmnistoreErrorReporter> getLazy(InjectorLike injectorLike) {
        return new C0156x62481eac(injectorLike);
    }
}
