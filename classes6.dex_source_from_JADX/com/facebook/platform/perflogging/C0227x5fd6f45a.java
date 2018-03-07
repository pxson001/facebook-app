package com.facebook.platform.perflogging;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.platform.composer.logging.PlatformComposerPerformanceLogger.PlatformComposerLaunchSequenceDefinition;
import com.facebook.platform.webdialogs.PlatformWebDialogsLaunchSequenceDefinition;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: target_profile_pic_url */
public final class C0227x5fd6f45a implements MultiBindIndexedProvider<AbstractPlatformLaunchSequenceDefinition>, Provider<Set<AbstractPlatformLaunchSequenceDefinition>> {
    private final InjectorLike f4114a;

    public C0227x5fd6f45a(InjectorLike injectorLike) {
        this.f4114a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f4114a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return PlatformComposerLaunchSequenceDefinition.a(injector);
            case 1:
                return PlatformWebDialogsLaunchSequenceDefinition.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
