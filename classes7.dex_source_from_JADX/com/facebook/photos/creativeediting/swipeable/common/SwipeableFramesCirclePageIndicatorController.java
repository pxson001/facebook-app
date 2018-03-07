package com.facebook.photos.creativeediting.swipeable.common;

import com.facebook.photos.creativeediting.model.SwipeableParams;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: mConnectedWifi */
public class SwipeableFramesCirclePageIndicatorController {
    public final SwipeableFramesHScrollCirclePageIndicator f9759a;
    public ImmutableList<SwipeableParams> f9760b;
    public final SwipeEventListener f9761c = new C08051(this);

    /* compiled from: mConnectedWifi */
    class C08051 implements SwipeEventListener {
        final /* synthetic */ SwipeableFramesCirclePageIndicatorController f9758a;

        C08051(SwipeableFramesCirclePageIndicatorController swipeableFramesCirclePageIndicatorController) {
            this.f9758a = swipeableFramesCirclePageIndicatorController;
        }

        public final void mo511a(@Nullable SwipeableParams swipeableParams) {
            Preconditions.checkNotNull(this.f9758a.f9760b, "Call refreshCirclePageIndicator before registering the SwipeEventListener.");
            int indexOf = this.f9758a.f9760b.indexOf(swipeableParams);
            this.f9758a.f9759a.a(indexOf, Math.min(indexOf, 9), true);
        }

        public final void mo510a() {
        }

        public final void mo512a(boolean z) {
        }
    }

    public SwipeableFramesCirclePageIndicatorController(SwipeableFramesHScrollCirclePageIndicator swipeableFramesHScrollCirclePageIndicator) {
        this.f9759a = (SwipeableFramesHScrollCirclePageIndicator) Preconditions.checkNotNull(swipeableFramesHScrollCirclePageIndicator);
        this.f9759a.setMaxCircles(10);
    }

    public final void m11700a(boolean z, ImmutableList<SwipeableParams> immutableList, String str) {
        this.f9760b = immutableList;
        if (this.f9760b == null || this.f9760b.size() <= 1) {
            this.f9759a.setVisibility(8);
            return;
        }
        this.f9759a.setVisibility(0);
        this.f9759a.setFillFirstCircle(z);
        this.f9759a.setCount(this.f9760b.size());
        int i = 0;
        while (i < this.f9760b.size()) {
            if (((SwipeableParams) this.f9760b.get(i)).b.equals(str)) {
                break;
            }
            i++;
        }
        i = 0;
        this.f9759a.a(i, i, false);
    }
}
