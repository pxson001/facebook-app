package com.facebook.bugreporter;

import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.placetips.settings.ui.PlaceTipsSettingsRageShakeItem;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: transaction_status_display */
public final class STATICDI_MULTIBIND_PROVIDER$RageShakeActionItem implements MultiBindIndexedProvider<RageShakeActionItem>, Provider<Set<RageShakeActionItem>> {
    private final InjectorLike f10663a;

    private STATICDI_MULTIBIND_PROVIDER$RageShakeActionItem(InjectorLike injectorLike) {
        this.f10663a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f10663a.getScopeAwareInjector(), this);
    }

    public static Set<RageShakeActionItem> m18685a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$RageShakeActionItem(injectorLike));
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new PlaceTipsSettingsRageShakeItem(IdBasedProvider.a(injector, 640), IdBasedProvider.a(injector, 4262), (SecureContextHelper) DefaultSecureContextHelper.a(injector), (UriIntentMapper) Fb4aUriIntentMapper.a(injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
