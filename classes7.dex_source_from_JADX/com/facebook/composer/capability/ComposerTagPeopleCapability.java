package com.facebook.composer.capability;

import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$BooleanGetter;

/* compiled from: core_glyph */
public class ComposerTagPeopleCapability {
    public static ComposerTagPeopleCapability m20735a(InjectorLike injectorLike) {
        return new ComposerTagPeopleCapability();
    }

    public static boolean m20736a(TargetType targetType, boolean z, boolean z2, boolean z3, boolean z4, ComposerPluginGetters$BooleanGetter composerPluginGetters$BooleanGetter) {
        if (z4) {
            return false;
        }
        if (targetType == TargetType.PAGE && z3) {
            return false;
        }
        if (z) {
            return z2;
        }
        if (composerPluginGetters$BooleanGetter != null) {
            return composerPluginGetters$BooleanGetter.mo1301a();
        }
        return true;
    }
}
