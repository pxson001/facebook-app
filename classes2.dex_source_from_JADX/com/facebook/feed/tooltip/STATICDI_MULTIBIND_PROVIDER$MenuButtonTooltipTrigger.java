package com.facebook.feed.tooltip;

import com.facebook.feedplugins.saved.nux.SavedOnlyMeShareTooltipTrigger;
import com.facebook.feedplugins.saved.nux.SavedPhotoTooltipTrigger;
import com.facebook.feedplugins.saved.nux.SavedPostTooltipTrigger;
import com.facebook.feedplugins.saved.nux.SavedQuickReturnTooltipTrigger;
import com.facebook.feedplugins.saved.nux.SavedVideoQuickReturnTooltipTrigger;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$MenuButtonTooltipTrigger implements MultiBindIndexedProvider<MenuButtonTooltipTrigger>, Provider<Set<MenuButtonTooltipTrigger>> {
    private final InjectorLike f9750a;

    public STATICDI_MULTIBIND_PROVIDER$MenuButtonTooltipTrigger(InjectorLike injectorLike) {
        this.f9750a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f9750a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 5;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return SavedOnlyMeShareTooltipTrigger.m20116a((InjectorLike) injector);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return SavedPhotoTooltipTrigger.m20130a((InjectorLike) injector);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return SavedPostTooltipTrigger.m20137a((InjectorLike) injector);
            case 3:
                return SavedQuickReturnTooltipTrigger.m20146a((InjectorLike) injector);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return SavedVideoQuickReturnTooltipTrigger.m20154a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
