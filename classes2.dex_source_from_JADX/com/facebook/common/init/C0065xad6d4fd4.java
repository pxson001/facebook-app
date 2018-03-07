package com.facebook.common.init;

import com.facebook.common.errorreporting.memory.MemoryDumpHandler;
import com.facebook.common.process.ProcessNameMethodAutoProvider;
import com.facebook.debug.fblog.FbLogImpl;
import com.facebook.debug.fblog.LoggingModule$Initializer;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProviderLazy;
import com.facebook.orca.app.MessagesDefaultProcessDataModule$Initializer;
import com.facebook.orca.app.MessagesDefaultProcessModule$Initializer;
import com.facebook.orca.notify.MessagesNotificationServiceModule$Initializer;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class C0065xad6d4fd4 implements MultiBindIndexedProvider<INeedInit>, Provider<Set<INeedInit>> {
    private final InjectorLike f1043a;

    public C0065xad6d4fd4(InjectorLike injectorLike) {
        this.f1043a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1043a.getScopeAwareInjector(), this);
    }

    public static Lazy<Set<INeedInit>> m2126a(InjectorLike injectorLike) {
        return ProviderLazy.m1699a(new C0065xad6d4fd4(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector());
    }

    public final int size() {
        return 5;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return MemoryDumpHandler.m2288a(injector);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return new LoggingModule$Initializer(FbLogImpl.m2373a((InjectorLike) injector));
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return new MessagesDefaultProcessDataModule$Initializer(ProcessNameMethodAutoProvider.m2431b(injector));
            case 3:
                return new MessagesDefaultProcessModule$Initializer(ProcessNameMethodAutoProvider.m2431b(injector));
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return MessagesNotificationServiceModule$Initializer.m2435b(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
