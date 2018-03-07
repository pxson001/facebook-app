package com.facebook.feed.rows.views;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import com.facebook.fbui.widget.text.TextLayoutView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.accessibility.ClickableSpanAccessibilityDelegator;
import com.google.common.base.Preconditions;

/* compiled from: friendrequests */
public class AccessibleTextLayoutView extends TextLayoutView implements SupportsCopyStoryText, ClickableSpanAccessibilityDelegator {
    private CopyStoryTextListenerController f23068a;
    private TextAccessibilityHelper f23069b;

    public AccessibleTextLayoutView(Context context) {
        this(context, null);
    }

    public AccessibleTextLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23069b = new TextAccessibilityHelper(this);
        this.f23068a = new CopyStoryTextListenerController(getContext());
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        return (AccessibilityNodeProvider) this.f23069b.f23062b;
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.f23069b.m31215a(motionEvent)) {
            return true;
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    public int getTotalPaddingLeft() {
        return getPaddingLeft();
    }

    public int getTotalPaddingTop() {
        return getPaddingTop();
    }

    public float getTextSize() {
        Layout layout = getLayout();
        if (layout == null) {
            return 0.0f;
        }
        float textSize = layout.getPaint().getTextSize();
        Preconditions.checkArgument(textSize > 0.0f);
        return textSize;
    }

    public void setCopyTextGestureListener(CopyStoryTextListener copyStoryTextListener) {
        this.f23068a.setCopyTextGestureListener(copyStoryTextListener);
    }

    public final void iD_() {
        this.f23068a.iD_();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -423345420);
        boolean z = this.f23068a.m26959a(motionEvent) && super.onTouchEvent(motionEvent);
        LogUtils.a(-317019310, a);
        return z;
    }
}
