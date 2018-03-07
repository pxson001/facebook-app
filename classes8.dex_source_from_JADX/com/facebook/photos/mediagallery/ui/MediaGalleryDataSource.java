package com.facebook.photos.mediagallery.ui;

import android.content.Context;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import java.util.Map;
import javax.inject.Inject;

@ContextScoped
/* compiled from: snap_max_velocity */
public class MediaGalleryDataSource {
    private static MediaGalleryDataSource f2360d;
    private static final Object f2361e = new Object();
    public Map<String, Subscriber> f2362a = Maps.c();
    public ImmutableList<MediaMetadata> f2363b = RegularImmutableList.a;
    public final DefaultAndroidThreadUtil f2364c;

    /* compiled from: snap_max_velocity */
    public interface Subscriber {
        void mo118a(MediaMetadata mediaMetadata);
    }

    private static MediaGalleryDataSource m2474b(InjectorLike injectorLike) {
        return new MediaGalleryDataSource(DefaultAndroidThreadUtil.b(injectorLike));
    }

    @Inject
    public MediaGalleryDataSource(DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f2364c = defaultAndroidThreadUtil;
    }

    public static MediaGalleryDataSource m2473a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MediaGalleryDataSource b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2361e) {
                MediaGalleryDataSource mediaGalleryDataSource;
                if (a2 != null) {
                    mediaGalleryDataSource = (MediaGalleryDataSource) a2.a(f2361e);
                } else {
                    mediaGalleryDataSource = f2360d;
                }
                if (mediaGalleryDataSource == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2474b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2361e, b3);
                        } else {
                            f2360d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = mediaGalleryDataSource;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m2476a(String str, Subscriber subscriber) {
        this.f2364c.a();
        this.f2362a.put(str, subscriber);
        if (this.f2363b != null) {
            int size = this.f2363b.size();
            for (int i = 0; i < size; i++) {
                MediaMetadata mediaMetadata = (MediaMetadata) this.f2363b.get(i);
                if (mediaMetadata.d().equals(str)) {
                    subscriber.mo118a(mediaMetadata);
                    return;
                }
            }
        }
    }

    public final void m2475a(String str) {
        this.f2364c.a();
        this.f2362a.remove(Preconditions.checkNotNull(str));
    }
}
