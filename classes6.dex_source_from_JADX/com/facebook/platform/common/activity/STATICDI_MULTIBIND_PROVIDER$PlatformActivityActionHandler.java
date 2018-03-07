package com.facebook.platform.common.activity;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.katana.platform.FeedDialogActionExecutorProvider;
import com.facebook.katana.platform.FeedDialogActionHandler;
import com.facebook.katana.platform.LegacyShareDialogActionExecutorProvider;
import com.facebook.katana.platform.LegacyShareDialogActionHandler;
import com.facebook.katana.platform.OpenGraphActionDialogActionExecutorProvider;
import com.facebook.katana.platform.OpenGraphActionDialogActionHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: target_profile_pic_url */
public final class STATICDI_MULTIBIND_PROVIDER$PlatformActivityActionHandler implements MultiBindIndexedProvider<PlatformActivityActionHandler>, Provider<Set<PlatformActivityActionHandler>> {
    private final InjectorLike f4073a;

    public STATICDI_MULTIBIND_PROVIDER$PlatformActivityActionHandler(InjectorLike injectorLike) {
        this.f4073a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f4073a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 3;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new FeedDialogActionHandler((FeedDialogActionExecutorProvider) injector.getOnDemandAssistedProviderForStaticDi(FeedDialogActionExecutorProvider.class));
            case 1:
                return new LegacyShareDialogActionHandler((LegacyShareDialogActionExecutorProvider) injector.getOnDemandAssistedProviderForStaticDi(LegacyShareDialogActionExecutorProvider.class));
            case 2:
                return new OpenGraphActionDialogActionHandler((OpenGraphActionDialogActionExecutorProvider) injector.getOnDemandAssistedProviderForStaticDi(OpenGraphActionDialogActionExecutorProvider.class), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
