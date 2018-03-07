package com.facebook.xconfig.core;

import com.facebook.contextual.ContextualResolverMethodAutoProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.loom.module.LoomConfigProvider;
import com.facebook.rtc.voicemail.RtcVoicemailConfigSyncListener;
import com.facebook.rtc.voicemail.VoicemailHandler;
import com.facebook.trace.DebugTraceXConfigListener;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$XConfigSyncListener implements MultiBindIndexedProvider<XConfigSyncListener>, Provider<Set<XConfigSyncListener>> {
    private final InjectorLike f1622a;

    public STATICDI_MULTIBIND_PROVIDER$XConfigSyncListener(InjectorLike injectorLike) {
        this.f1622a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1622a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 4;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return ContextualResolverMethodAutoProvider.m1955a(injector);
            case 1:
                return LoomConfigProvider.m11505a((InjectorLike) injector);
            case 2:
                return new RtcVoicemailConfigSyncListener(VoicemailHandler.m9510a((InjectorLike) injector));
            case 3:
                return DebugTraceXConfigListener.m9755a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
