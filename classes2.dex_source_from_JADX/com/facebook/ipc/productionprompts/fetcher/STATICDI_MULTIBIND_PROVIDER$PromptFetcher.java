package com.facebook.ipc.productionprompts.fetcher;

import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.executors.Executor_SameThreadExecutorMethodAutoProvider;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.photoreminder.PhotoReminderPromptFetcher;
import com.facebook.friendsharing.souvenirs.prompt.SouvenirPromptFetcher;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.productionprompts.ClipboardPromptsPromptFetcher;
import com.facebook.productionprompts.ProductionPromptsPromptFetcher;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$PromptFetcher implements MultiBindIndexedProvider<PromptFetcher>, Provider<Set<PromptFetcher>> {
    private final InjectorLike f12588a;

    public STATICDI_MULTIBIND_PROVIDER$PromptFetcher(InjectorLike injectorLike) {
        this.f12588a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f12588a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 4;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return PhotoReminderPromptFetcher.m18672b(injector);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return new SouvenirPromptFetcher(IdBasedSingletonScopeProvider.m1810b(injector, 2088), IdBasedSingletonScopeProvider.m1810b(injector, 2089), IdBasedLazy.m1808a(injector, 6722), QeInternalImplMethodAutoProvider.m3744a(injector), SystemClockMethodAutoProvider.m1498a(injector), C0055x2995691a.m1881a(injector), Executor_SameThreadExecutorMethodAutoProvider.m1812a(injector), QuickPerformanceLoggerMethodAutoProvider.m2859a(injector));
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return ClipboardPromptsPromptFetcher.m18741c(injector);
            case 3:
                return ProductionPromptsPromptFetcher.m18748b(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
