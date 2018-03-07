package com.facebook.messaging.composershortcuts;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: messages_offline_threading_id_index */
public class OverflowComposerShortcutItemView extends CustomFrameLayout {
    public RecyclerView f10109a = ((RecyclerView) c(2131565297));
    public LinearLayoutManager f10110b = new LinearLayoutManager(getContext());

    public OverflowComposerShortcutItemView(Context context) {
        super(context);
        setContentView(2130905942);
        this.f10110b.b(0);
        this.f10109a.setLayoutManager(this.f10110b);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Rect rect = new Rect();
        this.f10109a.getHitRect(rect);
        if (this.f10110b.l() == 0 && rect.contains((int) motionEvent.getX(), (int) motionEvent.getY()) && ((float) this.f10109a.getChildAt(0).getLeft()) > motionEvent.getX()) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
