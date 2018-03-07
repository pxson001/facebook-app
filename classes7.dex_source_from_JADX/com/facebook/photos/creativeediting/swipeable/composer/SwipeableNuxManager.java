package com.facebook.photos.creativeediting.swipeable.composer;

import android.support.annotation.Nullable;
import com.facebook.inject.Assisted;
import com.facebook.photos.creativeediting.model.SwipeableParams;
import com.facebook.photos.creativeediting.swipeable.common.SwipeEventListener;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableController.C08126;
import com.facebook.photos.creativeediting.swipeable.composer.nux.SwipeableNuxController;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: lockscreen_notifications */
public class SwipeableNuxManager implements SwipeEventListener {
    public SwipeableNuxController f9871a;
    private final C08126 f9872b;
    public ImmutableList<SwipeableNuxController> f9873c;
    private boolean f9874d;
    private boolean f9875e;

    @Inject
    public SwipeableNuxManager(@Assisted C08126 c08126) {
        this.f9872b = c08126;
    }

    public final void mo511a(@Nullable SwipeableParams swipeableParams) {
        this.f9874d = true;
    }

    public final void mo510a() {
        if (this.f9871a != null && this.f9871a.mo539c()) {
            this.f9872b.m11761a(this.f9871a.mo540d());
            this.f9871a.mo538b();
        }
    }

    public final void mo512a(boolean z) {
        if (z) {
            int size = this.f9873c.size();
            int i = 0;
            while (i < size) {
                SwipeableNuxController swipeableNuxController = (SwipeableNuxController) this.f9873c.get(i);
                if (this.f9875e || this.f9874d || !swipeableNuxController.mo537a()) {
                    i++;
                } else {
                    this.f9871a = swipeableNuxController;
                    this.f9872b.m11761a(swipeableNuxController.mo540d());
                    swipeableNuxController.mo538b();
                    this.f9875e = true;
                    return;
                }
            }
        }
    }
}
