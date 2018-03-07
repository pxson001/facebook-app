package com.facebook.messaging.doodle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.facebook.common.ui.util.ViewPositionUtil;
import com.facebook.common.util.MathUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.CustomViewUtils;

/* compiled from: onNextPersistedRelayQuery */
public class CaptionEditorView extends CustomFrameLayout {
    private final GestureDetector f7804a;
    public final InputMethodManager f7805b;
    public CaptionEditText f7806c;
    public boolean f7807d;

    /* compiled from: onNextPersistedRelayQuery */
    class OnEditTextGestureListener extends SimpleOnGestureListener {
        final /* synthetic */ CaptionEditorView f7803a;

        public OnEditTextGestureListener(CaptionEditorView captionEditorView) {
            this.f7803a = captionEditorView;
        }

        public boolean onDown(MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 0) {
                this.f7803a.f7807d = ViewPositionUtil.a(motionEvent, this.f7803a.f7806c);
            }
            return false;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (this.f7803a.f7806c.getParent() == null) {
                this.f7803a.m9422a(Math.min(motionEvent.getY(), (float) (this.f7803a.getMeasuredHeight() - this.f7803a.f7806c.getLineHeight())));
            } else if (this.f7803a.f7807d) {
                return false;
            } else {
                if (this.f7803a.f7806c.isFocused()) {
                    this.f7803a.m9432g();
                } else {
                    CharSequence text = this.f7803a.f7806c.getText();
                    if (StringUtil.c(text)) {
                        if (!StringUtil.a(text)) {
                            this.f7803a.f7806c.setText("");
                        }
                        this.f7803a.removeView(this.f7803a.f7806c);
                        this.f7803a.m9422a(Math.min(motionEvent.getY(), (float) (this.f7803a.getMeasuredHeight() - this.f7803a.f7806c.getLineHeight())));
                        return true;
                    }
                    this.f7803a.f7806c.requestFocus();
                    this.f7803a.f7805b.showSoftInput(this.f7803a.f7806c, 0, null);
                    return false;
                }
            }
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (this.f7803a.f7807d && !this.f7803a.f7806c.isFocused()) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f7803a.f7806c.getLayoutParams();
                marginLayoutParams.topMargin = (int) (((float) marginLayoutParams.topMargin) - f2);
                marginLayoutParams.topMargin = MathUtil.a(marginLayoutParams.topMargin, 0, (this.f7803a.getHeight() - this.f7803a.f7806c.getHeight()) - (this.f7803a.getPaddingBottom() * 2));
                this.f7803a.f7806c.setLayoutParams(marginLayoutParams);
                this.f7803a.m9432g();
            }
            return true;
        }
    }

    public CaptionEditorView(Context context) {
        this(context, null);
    }

    public CaptionEditorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CaptionEditorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7804a = new GestureDetector(context, new OnEditTextGestureListener(this));
        this.f7805b = (InputMethodManager) context.getSystemService("input_method");
        this.f7806c = new CaptionEditText(context);
        this.f7806c.setTextColor(getResources().getColor(2131361920));
        this.f7806c.setGravity(1);
        this.f7806c.setMaxEms(120);
        this.f7806c.setSingleLine(false);
        this.f7806c.setShadowLayer(3.0f, 0.0f, 2.0f, getResources().getColor(2131362283));
        CustomViewUtils.b(this.f7806c, null);
        setFocusableInTouchMode(true);
        setEnabled(false);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f7806c.setEnabled(z);
        if (!z) {
            m9432g();
        }
    }

    public final boolean m9428a() {
        return this.f7806c.isFocused();
    }

    public final void m9429b() {
        if (this.f7806c == null || this.f7806c.getParent() == null) {
            m9427h();
            return;
        }
        CharSequence text = this.f7806c.getText();
        if (StringUtil.c(text)) {
            if (!StringUtil.a(text)) {
                this.f7806c.setText("");
            }
            removeView(this.f7806c);
            m9427h();
            return;
        }
        this.f7806c.requestFocus();
        this.f7805b.showSoftInput(this.f7806c, 0, null);
    }

    private void m9427h() {
        m9422a(((float) (getMeasuredHeight() - this.f7806c.getLineHeight())) / 2.0f);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1202606220);
        if (isEnabled()) {
            this.f7804a.onTouchEvent(motionEvent);
            LogUtils.a(1933652481, a);
            return true;
        }
        Logger.a(2, EntryType.UI_INPUT_END, 2024672699, a);
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            return this.f7804a.onTouchEvent(motionEvent);
        }
        return false;
    }

    public final void m9430e() {
        removeView(this.f7806c);
    }

    public final boolean m9431f() {
        return this.f7806c.getVisibility() == 0 && !StringUtil.a(this.f7806c.getText());
    }

    public final void m9432g() {
        this.f7805b.hideSoftInputFromWindow(getWindowToken(), 0);
        requestFocus();
    }

    private void m9422a(float f) {
        if (this.f7806c.getParent() == null) {
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 49);
            layoutParams.topMargin = ((int) f) - (this.f7806c.getLineHeight() / 2);
            addView(this.f7806c, layoutParams);
            this.f7806c.requestFocus();
            this.f7805b.showSoftInput(this.f7806c, 0, null);
        }
    }
}
