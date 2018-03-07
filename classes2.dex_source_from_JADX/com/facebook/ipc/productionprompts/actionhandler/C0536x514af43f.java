package com.facebook.ipc.productionprompts.actionhandler;

import com.facebook.feed.photoreminder.PhotoReminderPromptActionHandler;
import com.facebook.friendsharing.souvenirs.prompt.SouvenirPromptActionHandler;
import com.facebook.friendsharing.souvenirs.util.SouvenirsLogger;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.productionprompts.ProductionPromptsPromptActionHandler;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class C0536x514af43f implements MultiBindIndexedProvider<PromptActionHandler>, Provider<Set<PromptActionHandler>> {
    private final InjectorLike f13340a;

    public C0536x514af43f(InjectorLike injectorLike) {
        this.f13340a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f13340a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 3;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return PhotoReminderPromptActionHandler.m19655b((InjectorLike) injector);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return new SouvenirPromptActionHandler(SouvenirsLogger.m19617b((InjectorLike) injector), JsonPluginConfigSerializer.m18629b(injector), IdBasedSingletonScopeProvider.m1810b(injector, 849), IdBasedLazy.m1808a(injector, 2090), IdBasedSingletonScopeProvider.m1810b(injector, 2089));
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return ProductionPromptsPromptActionHandler.m19682b((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
