package com.facebook.feed.tooltip;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.util.event.StoryEvents$PhotoClickedEvent;
import com.facebook.feedplugins.saved.nux.SavedPhotoTooltipTrigger;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.photos.galleryutil.events.C0423xe259026e;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents$MediaGalleryFragmentVisibilityChangeEvent;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: photo_resize */
public class PhotoReturnDetector {
    private static PhotoReturnDetector f10018h;
    private static final Object f10019i = new Object();
    private final ConsumptionPhotoEventBus f10020a;
    public final List<Listener> f10021b = new ArrayList();
    private final PhotoGalleryFragmentVisibilityChangeEventSubscriber f10022c = new PhotoGalleryFragmentVisibilityChangeEventSubscriber(this);
    public final MonotonicClock f10023d;
    @Nullable
    public StoryEvents$PhotoClickedEvent f10024e;
    public long f10025f;
    private GatekeeperStoreImpl f10026g;

    /* compiled from: photo_resize */
    class PhotoGalleryFragmentVisibilityChangeEventSubscriber extends C0423xe259026e {
        final /* synthetic */ PhotoReturnDetector f10027a;

        public PhotoGalleryFragmentVisibilityChangeEventSubscriber(PhotoReturnDetector photoReturnDetector) {
            this.f10027a = photoReturnDetector;
        }

        public final void mo650b(FbEvent fbEvent) {
            if (!((ConsumptionPhotoEvents$MediaGalleryFragmentVisibilityChangeEvent) fbEvent).f14047a) {
                this.f10027a.m15069c();
            }
        }
    }

    private static PhotoReturnDetector m15065b(InjectorLike injectorLike) {
        return new PhotoReturnDetector(ConsumptionPhotoEventBus.m14866a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike));
    }

    @Inject
    public PhotoReturnDetector(ConsumptionPhotoEventBus consumptionPhotoEventBus, GatekeeperStoreImpl gatekeeperStoreImpl, MonotonicClock monotonicClock) {
        this.f10023d = monotonicClock;
        this.f10020a = consumptionPhotoEventBus;
        this.f10026g = gatekeeperStoreImpl;
    }

    private boolean m15066d() {
        return this.f10026g.m2189a(800, false);
    }

    public static PhotoReturnDetector m15064a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotoReturnDetector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f10019i) {
                PhotoReturnDetector photoReturnDetector;
                if (a2 != null) {
                    photoReturnDetector = (PhotoReturnDetector) a2.mo818a(f10019i);
                } else {
                    photoReturnDetector = f10018h;
                }
                if (photoReturnDetector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m15065b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f10019i, b3);
                        } else {
                            f10018h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = photoReturnDetector;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final void m15067a() {
        if (m15066d()) {
            this.f10020a.m4568a(this.f10022c);
        }
    }

    public final void m15068b() {
        if (m15066d()) {
            this.f10020a.m4569b(this.f10022c);
        }
    }

    protected final void m15069c() {
        if (m15066d() && this.f10024e != null) {
            for (SavedPhotoTooltipTrigger a : this.f10021b) {
                a.m20132a(this.f10024e, this.f10023d.now() - this.f10025f);
            }
            this.f10024e = null;
            this.f10025f = 0;
        }
    }
}
