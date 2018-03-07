package com.facebook.cache.disk;

import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.imagepipeline.module.FileCache_MainImageFileCacheMethodAutoProvider;
import com.facebook.imagepipeline.module.FileCache_ProfileThumbnailImageFileCacheMethodAutoProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.audio.playback.FileCache_AudioFileCacheMethodAutoProvider;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: transaction_status_display */
public final class STATICDI_MULTIBIND_PROVIDER$FileCache implements MultiBindIndexedProvider<FileCache>, Provider<Set<FileCache>> {
    private final InjectorLike f10777a;

    public STATICDI_MULTIBIND_PROVIDER$FileCache(InjectorLike injectorLike) {
        this.f10777a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f10777a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 3;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return FileCache_MainImageFileCacheMethodAutoProvider.a(injector);
            case 1:
                return FileCache_ProfileThumbnailImageFileCacheMethodAutoProvider.m23078a(injector);
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return FileCache_AudioFileCacheMethodAutoProvider.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
