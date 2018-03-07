package com.facebook.photos.creativeediting.swipeable.composer.nux;

import com.facebook.common.time.SystemClock;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.FramePack;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FramePackModel;
import com.facebook.photos.creativeediting.swipeable.common.FramePrefsManager;
import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: loadingState */
public class SwipeableFrameNuxController implements SwipeableNuxController {
    private final Lazy<SwipeableFrameAnimatingNuxViewController> f9951a;
    private final FramePrefsManager f9952b;
    private final FramePackModel f9953c;
    private final long f9954d = SystemClock.a.a();
    public Set<String> f9955e;
    public boolean f9956f;

    @Inject
    public SwipeableFrameNuxController(@Assisted FramePack framePack, Lazy<SwipeableFrameAnimatingNuxViewController> lazy, FramePrefsManager framePrefsManager) {
        this.f9951a = lazy;
        this.f9952b = framePrefsManager;
        this.f9953c = framePack;
        if (this.f9954d - 1209600000 > this.f9952b.f9748a.a(FramePrefsManager.f9747c, 0)) {
            this.f9956f = true;
            return;
        }
        if (framePack.g() > this.f9952b.m11677a()) {
            this.f9955e = new HashSet();
            ImmutableList c = framePack.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                this.f9955e.add(((FrameModel) c.get(i)).c());
            }
        }
    }

    public final boolean mo537a() {
        return this.f9956f;
    }

    public final void mo538b() {
        this.f9952b.m11678a(this.f9953c.g());
        this.f9952b.m11679b(this.f9954d);
        this.f9956f = false;
    }

    public final boolean mo539c() {
        return false;
    }

    public final SwipeableAnimatingNuxViewController mo540d() {
        return (SwipeableAnimatingNuxViewController) this.f9951a.get();
    }
}
