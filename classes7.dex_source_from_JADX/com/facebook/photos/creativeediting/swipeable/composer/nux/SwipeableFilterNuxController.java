package com.facebook.photos.creativeediting.swipeable.composer.nux;

import com.facebook.composer.prefs.ComposerPrefKeys;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.photos.creativeediting.model.SwipeableParams;
import com.facebook.photos.creativeediting.model.SwipeableParams.SwipeableItemType;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: locationY */
public class SwipeableFilterNuxController implements SwipeableNuxController {
    private final ImmutableList<SwipeableParams> f9947a;
    private final TipSeenTracker f9948b;
    private final Lazy<SwipeableFilterAnimatingNuxViewController> f9949c;

    @Inject
    public SwipeableFilterNuxController(@Assisted ImmutableList<SwipeableParams> immutableList, Lazy<SwipeableFilterAnimatingNuxViewController> lazy, TipSeenTracker tipSeenTracker) {
        boolean z = true;
        if (immutableList == null || immutableList.size() <= 1) {
            z = false;
        }
        Preconditions.checkState(z);
        this.f9947a = immutableList;
        this.f9949c = lazy;
        this.f9948b = tipSeenTracker;
        this.f9948b.a(ComposerPrefKeys.n);
    }

    public final boolean mo537a() {
        if (!this.f9948b.c()) {
            return false;
        }
        Object obj;
        ImmutableList immutableList = this.f9947a;
        SwipeableItemType swipeableItemType = SwipeableItemType.FILTER;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (((SwipeableParams) immutableList.get(i)).c == swipeableItemType) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj != null) {
            return true;
        }
        return false;
    }

    public final void mo538b() {
        this.f9948b.a();
    }

    public final boolean mo539c() {
        return false;
    }

    public final SwipeableAnimatingNuxViewController mo540d() {
        return (SwipeableAnimatingNuxViewController) this.f9949c.get();
    }
}
