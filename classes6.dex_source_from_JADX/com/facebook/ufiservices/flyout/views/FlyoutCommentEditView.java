package com.facebook.ufiservices.flyout.views;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.ufiservices.ui.CommentEditView;

/* compiled from: customReplyAction */
public class FlyoutCommentEditView extends CommentEditView {
    public FlyoutCommentEditView(Context context) {
        this(context, null);
    }

    public FlyoutCommentEditView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlyoutCommentEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131428729);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131428720);
        setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Rect rect = new Rect();
        this.f18181g.getHitRect(rect);
        if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            motionEvent.offsetLocation((float) (-rect.left), (float) (-rect.top));
            boolean dispatchTouchEvent = this.f18181g.dispatchTouchEvent(motionEvent);
            motionEvent.offsetLocation((float) rect.left, (float) rect.top);
            if (dispatchTouchEvent) {
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
