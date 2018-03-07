package com.facebook.localcontent.menus.admin.manager;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: unknown relative layout param =  */
public final class STATICDI_MULTIBIND_PROVIDER$PageMenuTypeHandler implements MultiBindIndexedProvider<PageMenuTypeHandler>, Provider<Set<PageMenuTypeHandler>> {
    private final InjectorLike f15116a;

    private STATICDI_MULTIBIND_PROVIDER$PageMenuTypeHandler(InjectorLike injectorLike) {
        this.f15116a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f15116a.getScopeAwareInjector(), this);
    }

    public static Set<PageMenuTypeHandler> m17559a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$PageMenuTypeHandler(injectorLike));
    }

    public final int size() {
        return 4;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new PageLinkMenuHandler((SecureContextHelper) DefaultSecureContextHelper.a(injector));
            case 1:
                return new PageNoMenuHandler(MenuVisibilityMutationHelper.m17496a(injector));
            case 2:
                return new PagePhotoMenuHandler(MenuVisibilityMutationHelper.m17496a(injector), (SecureContextHelper) DefaultSecureContextHelper.a(injector), (UriIntentMapper) Fb4aUriIntentMapper.a(injector));
            case 3:
                return new PageStructuredMenuHandler((AbstractFbErrorReporter) FbErrorReporterImpl.a(injector), MenuVisibilityMutationHelper.m17496a(injector), (SecureContextHelper) DefaultSecureContextHelper.a(injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
