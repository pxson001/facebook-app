package com.facebook.feedback.reactions.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.CustomViewUtils;

/* compiled from: gifts */
public class ReactionsFooterSelectionView extends CustomFrameLayout {
    private final ReactionsScrubberView f22346a;
    private final View f22347b;
    public Drawable f22348c;

    public ReactionsFooterSelectionView(Context context) {
        this(context, null);
    }

    public ReactionsFooterSelectionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ReactionsFooterSelectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(2130906726, this, true);
        this.f22346a = (ReactionsScrubberView) m16956c(2131566799);
        this.f22347b = m16956c(2131566800);
    }

    public final void m30280a(boolean z) {
        int i;
        int i2 = 0;
        ReactionsScrubberView reactionsScrubberView = this.f22346a;
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        reactionsScrubberView.setVisibility(i);
        View view = this.f22347b;
        if (!z) {
            i2 = 8;
        }
        view.setVisibility(i2);
    }

    public void setButtonContainerBackground(Drawable drawable) {
        this.f22348c = drawable;
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this) {
            CustomViewUtils.m30286b(view, i == 0 ? this.f22348c : null);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Logger.a(2, EntryType.UI_INPUT_END, 1114664305, Logger.a(2, EntryType.UI_INPUT_START, -1617706774));
        return true;
    }
}
