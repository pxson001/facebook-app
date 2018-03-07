package com.facebook.widget.recyclerview;

import android.view.MotionEvent;
import com.facebook.storygallerysurvey.fragment.StoryGallerySurveyWithStoryFragment.5;
import com.facebook.widget.recyclerview.BetterRecyclerView.OnInterceptTouchEventListener;

/* compiled from: read_receipts */
class RecyclerViewProxy$5 implements OnInterceptTouchEventListener {
    final /* synthetic */ 5 f6137a;
    final /* synthetic */ RecyclerViewProxy f6138b;

    RecyclerViewProxy$5(RecyclerViewProxy recyclerViewProxy, 5 5) {
        this.f6138b = recyclerViewProxy;
        this.f6137a = 5;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f6137a.a(motionEvent);
    }
}
