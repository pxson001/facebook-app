package com.facebook.composer.capability;

import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$BooleanGetter;

/* compiled from: createCatalystInstance */
public class ComposerCheckinCapability {
    public static ComposerCheckinCapability m20714a(InjectorLike injectorLike) {
        return new ComposerCheckinCapability();
    }

    public static boolean m20715a(boolean z, boolean z2, ComposerPluginGetters$BooleanGetter composerPluginGetters$BooleanGetter) {
        if (z) {
            return z2;
        }
        if (composerPluginGetters$BooleanGetter != null) {
            return composerPluginGetters$BooleanGetter.mo1301a();
        }
        return true;
    }
}
