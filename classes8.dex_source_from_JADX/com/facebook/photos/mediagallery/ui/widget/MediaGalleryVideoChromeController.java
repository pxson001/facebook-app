package com.facebook.photos.mediagallery.ui.widget;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.photos.mediagallery.ui.MediaGalleryFragment.C02866;
import com.facebook.photos.mediagallery.ui.MediaGalleryVideoPageFragment;
import com.facebook.photos.mediagallery.ui.MediaGalleryVideoPageFragment.C02891;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.VideoResolution;
import java.util.WeakHashMap;
import javax.annotation.Nullable;

@ContextScoped
/* compiled from: simplepicker_largest_grid_row_reached */
public class MediaGalleryVideoChromeController {
    private static MediaGalleryVideoChromeController f2831d;
    private static final Object f2832e = new Object();
    @Nullable
    public C02866 f2833a;
    public final WeakHashMap<MediaGalleryVideoUfiListener, Boolean> f2834b = new WeakHashMap();
    public final WeakHashMap<MediaGalleryVideoPagerListener, Boolean> f2835c = new WeakHashMap();

    private static MediaGalleryVideoChromeController m2874b() {
        return new MediaGalleryVideoChromeController();
    }

    public static MediaGalleryVideoChromeController m2873a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MediaGalleryVideoChromeController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2832e) {
                MediaGalleryVideoChromeController mediaGalleryVideoChromeController;
                if (a2 != null) {
                    mediaGalleryVideoChromeController = (MediaGalleryVideoChromeController) a2.a(f2832e);
                } else {
                    mediaGalleryVideoChromeController = f2831d;
                }
                if (mediaGalleryVideoChromeController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m2874b();
                        if (a2 != null) {
                            a2.a(f2832e, b3);
                        } else {
                            f2831d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = mediaGalleryVideoChromeController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m2876c(String str) {
        for (C02891 c02891 : this.f2834b.keySet()) {
            if (c02891 != null) {
                if (!(c02891.f2419a.f2428e == null || MediaGalleryVideoPageFragment.m2551a(c02891.f2419a, str) || !c02891.f2419a.f2428e.m())) {
                    c02891.f2419a.f2428e.b(EventTriggerType.BY_PLAYER);
                }
            }
        }
    }

    public final void m2875a(String str, boolean z) {
        for (C02891 c02891 : this.f2834b.keySet()) {
            if (c02891 != null) {
                if (c02891.f2419a.f2428e != null && MediaGalleryVideoPageFragment.m2551a(c02891.f2419a, str)) {
                    c02891.f2419a.an.d();
                    if (!(z || !MediaGalleryVideoPageFragment.m2553e(c02891.f2419a) || c02891.f2419a.f2428e.m())) {
                        c02891.f2419a.f2428e.a(EventTriggerType.BY_PLAYER);
                    }
                    if (c02891.f2419a.f2426c.f2833a != null) {
                        VideoResolution videoResolution;
                        if (c02891.f2419a.f2428e.u == null) {
                            videoResolution = VideoResolution.STANDARD_DEFINITION;
                        } else {
                            videoResolution = c02891.f2419a.f2428e.u.e();
                        }
                        C02866 c02866 = c02891.f2419a.f2426c.f2833a;
                        String str2 = c02891.f2419a.f2429f;
                        c02866.m2498a(c02891.f2419a.f2431h, videoResolution);
                    }
                }
            }
        }
    }
}
