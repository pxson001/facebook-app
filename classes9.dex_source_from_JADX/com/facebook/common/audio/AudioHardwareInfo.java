package com.facebook.common.audio;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tablet.Boolean_IsTabletMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: qpEntryPoint */
public class AudioHardwareInfo {
    public final boolean f5965a;
    public final boolean f5966b;
    public final boolean f5967c;

    public static AudioHardwareInfo m6298a(InjectorLike injectorLike) {
        return new AudioHardwareInfo(Boolean_IsTabletMethodAutoProvider.a(injectorLike), Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(54, false)), Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(53, false)));
    }

    @Inject
    public AudioHardwareInfo(Boolean bool, Boolean bool2, Boolean bool3) {
        this.f5965a = bool.booleanValue();
        this.f5966b = bool2.booleanValue();
        this.f5967c = bool3.booleanValue();
    }
}
