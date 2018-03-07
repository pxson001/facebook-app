package com.facebook.composer.controller;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.Getter;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: header_scale */
public class ComposerTitleGenerator {
    private final Resources f6323a;
    private final Boolean f6324b;

    /* compiled from: header_scale */
    /* synthetic */ class C07921 {
        static final /* synthetic */ int[] f6322a = new int[TargetType.values().length];

        static {
            try {
                f6322a[TargetType.UNDIRECTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6322a[TargetType.USER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6322a[TargetType.PAGE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6322a[TargetType.GROUP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static ComposerTitleGenerator m7751b(InjectorLike injectorLike) {
        return new ComposerTitleGenerator(ResourcesMethodAutoProvider.a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ComposerTitleGenerator(Resources resources, Boolean bool) {
        this.f6323a = resources;
        this.f6324b = bool;
    }

    public final String m7752a(Getter<String> getter, ComposerConfiguration composerConfiguration, ComposerTargetData composerTargetData) {
        return m7753a(getter, composerConfiguration, composerTargetData, false, null);
    }

    public final String m7753a(Getter<String> getter, ComposerConfiguration composerConfiguration, ComposerTargetData composerTargetData, boolean z, @Nullable RedSpaceValue redSpaceValue) {
        if (getter != null && getter.a() != null) {
            return (String) getter.a();
        }
        if (composerConfiguration.isEdit()) {
            return this.f6323a.getString(2131234527);
        }
        switch (C07921.f6322a[composerTargetData.targetType.ordinal()]) {
            case 1:
                if (!composerConfiguration.getAllowsRedSpaceToggle() && redSpaceValue == RedSpaceValue.POST_TO_REDSPACE) {
                    return this.f6323a.getString(2131234525);
                }
                if (composerConfiguration.getComposerType() == ComposerType.SHARE) {
                    return this.f6323a.getString(this.f6324b.booleanValue() ? 2131234537 : 2131234536);
                }
                Resources resources;
                int i;
                if (z) {
                    resources = this.f6323a;
                    i = 2131234760;
                } else {
                    resources = this.f6323a;
                    i = this.f6324b.booleanValue() ? 2131234524 : 2131234523;
                }
                return resources.getString(i);
            case 2:
                if (redSpaceValue == RedSpaceValue.POST_TO_REDSPACE) {
                    return composerTargetData.targetName;
                }
                return this.f6323a.getString(2131234613, new Object[]{composerTargetData.targetName});
            case 3:
                if (composerTargetData.actsAsTarget) {
                    return this.f6323a.getString(2131234611, new Object[]{composerTargetData.targetName});
                }
                return this.f6323a.getString(2131234619, new Object[]{composerTargetData.targetName});
            case 4:
                return this.f6323a.getString(2131234618, new Object[]{composerTargetData.targetName});
            default:
                return composerTargetData.targetName;
        }
    }

    public static ComposerTitleGenerator m7750a(InjectorLike injectorLike) {
        return m7751b(injectorLike);
    }
}
