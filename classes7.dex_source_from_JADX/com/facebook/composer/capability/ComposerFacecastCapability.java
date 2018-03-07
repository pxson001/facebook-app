package com.facebook.composer.capability;

import android.hardware.Camera;
import android.os.Build.VERSION;
import com.facebook.facecastdisplay.FacecastUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$BooleanGetter;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: createAndProcessCustomReactPackage */
public class ComposerFacecastCapability {
    public final FacecastUtil f16689a;

    /* compiled from: createAndProcessCustomReactPackage */
    public /* synthetic */ class C13191 {
        public static final /* synthetic */ int[] f16688a = new int[TargetType.values().length];

        static {
            try {
                f16688a[TargetType.UNDIRECTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f16688a[TargetType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f16688a[TargetType.EVENT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f16688a[TargetType.PAGE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static ComposerFacecastCapability m20717b(InjectorLike injectorLike) {
        return new ComposerFacecastCapability(FacecastUtil.m3107b(injectorLike));
    }

    @Inject
    public ComposerFacecastCapability(FacecastUtil facecastUtil) {
        this.f16689a = facecastUtil;
    }

    public final boolean m20719a(TargetType targetType, boolean z, boolean z2, @Nullable PublishMode publishMode, ComposerPluginGetters$BooleanGetter composerPluginGetters$BooleanGetter) {
        if ((composerPluginGetters$BooleanGetter != null && !composerPluginGetters$BooleanGetter.mo1301a()) || VERSION.SDK_INT < 19 || Camera.getNumberOfCameras() <= 0) {
            return false;
        }
        boolean l;
        switch (C13191.f16688a[targetType.ordinal()]) {
            case 1:
            case 2:
            case 3:
                l = this.f16689a.m3116l();
                break;
            case 4:
                l = this.f16689a.f2822a.a(600, false);
                break;
            default:
                l = false;
                break;
        }
        if (!l || z || z2 || publishMode != PublishMode.NORMAL) {
            return false;
        }
        return true;
    }

    public static ComposerFacecastCapability m20716a(InjectorLike injectorLike) {
        return m20717b(injectorLike);
    }

    public final boolean m20718a(TargetType targetType) {
        return m20719a(targetType, false, false, PublishMode.NORMAL, null);
    }
}
