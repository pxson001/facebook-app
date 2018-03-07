package com.facebook.reaction.ui.recyclerview;

import android.view.MotionEvent;
import android.view.View;
import com.facebook.fbui.draggable.Direction;
import com.facebook.fbui.draggable.HorizontalScrollAwareView;
import com.facebook.reaction.ui.welcomeheader.ReactionWelcomeHeaderView;

/* compiled from: Unimplemented filter  */
public class ReactionHeaderTouchDelegateView extends View implements HorizontalScrollAwareView {
    public View f21174a;
    public boolean f21175b;
    public boolean f21176c = false;

    public ReactionHeaderTouchDelegateView(View view) {
        super(view.getContext());
        this.f21174a = view;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f21174a.getMeasuredWidth(), this.f21174a instanceof ReactionWelcomeHeaderView ? ((ReactionWelcomeHeaderView) this.f21174a).getContentViewHeight() : this.f21174a.getMeasuredHeight());
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f21175b) {
            motionEvent.offsetLocation(0.0f, (float) getTop());
        }
        return this.f21174a.dispatchTouchEvent(motionEvent);
    }

    public final boolean m24799a(Direction direction, int i, int i2) {
        return this.f21176c;
    }
}
