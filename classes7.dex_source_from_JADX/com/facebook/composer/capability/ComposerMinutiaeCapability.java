package com.facebook.composer.capability;

import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$BooleanGetter;
import javax.inject.Inject;

/* compiled from: crash_id */
public class ComposerMinutiaeCapability {
    public final Product f16693a;

    /* compiled from: crash_id */
    public /* synthetic */ class C13201 {
        public static final /* synthetic */ int[] f16692a = new int[TargetType.values().length];

        static {
            try {
                f16692a[TargetType.UNDIRECTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f16692a[TargetType.USER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f16692a[TargetType.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f16692a[TargetType.PAGE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f16692a[TargetType.EVENT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static ComposerMinutiaeCapability m20723b(InjectorLike injectorLike) {
        return new ComposerMinutiaeCapability(ProductMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public ComposerMinutiaeCapability(Product product) {
        this.f16693a = product;
    }

    public final boolean m20724a(TargetType targetType, boolean z, boolean z2, boolean z3, ComposerPluginGetters$BooleanGetter composerPluginGetters$BooleanGetter) {
        if (z3) {
            return false;
        }
        if (composerPluginGetters$BooleanGetter != null && !composerPluginGetters$BooleanGetter.mo1301a()) {
            return false;
        }
        if (z) {
            return z2;
        }
        boolean z4 = true;
        switch (C13201.f16692a[targetType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            case 5:
                if (this.f16693a == Product.PAA) {
                    z4 = false;
                    break;
                }
                break;
            default:
                z4 = false;
                break;
        }
        return z4;
    }

    public static ComposerMinutiaeCapability m20722a(InjectorLike injectorLike) {
        return m20723b(injectorLike);
    }
}
