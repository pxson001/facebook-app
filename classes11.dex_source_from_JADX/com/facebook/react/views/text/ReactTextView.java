package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spanned;
import android.widget.TextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.react.uimanager.ReactCompoundView;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: RKBuildInfo */
public class ReactTextView extends TextView implements ReactCompoundView {
    private boolean f11549a;
    private int f11550b = (getGravity() & 8388615);
    private int f11551c = (getGravity() & 112);
    private boolean f11552d;

    public ReactTextView(Context context) {
        super(context);
    }

    public void setText(ReactTextUpdate reactTextUpdate) {
        this.f11549a = reactTextUpdate.f11548c;
        setText(reactTextUpdate.f11546a);
    }

    public final int m12014a(float f, float f2) {
        Spanned spanned = (Spanned) getText();
        int id = getId();
        int i = (int) f;
        int i2 = (int) f2;
        Layout layout = getLayout();
        if (layout != null) {
            i2 = layout.getLineForVertical(i2);
            int lineRight = (int) layout.getLineRight(i2);
            if (i >= ((int) layout.getLineLeft(i2)) && i <= lineRight) {
                int offsetForHorizontal = layout.getOffsetForHorizontal(i2, (float) i);
                ReactTagSpan[] reactTagSpanArr = (ReactTagSpan[]) spanned.getSpans(offsetForHorizontal, offsetForHorizontal, ReactTagSpan.class);
                if (reactTagSpanArr != null) {
                    int length = spanned.length();
                    for (i2 = 0; i2 < reactTagSpanArr.length; i2++) {
                        lineRight = spanned.getSpanStart(reactTagSpanArr[i2]);
                        int spanEnd = spanned.getSpanEnd(reactTagSpanArr[i2]);
                        if (spanEnd > offsetForHorizontal && spanEnd - lineRight <= r3) {
                            id = reactTagSpanArr[i2].f11520a;
                            length = spanEnd - lineRight;
                        }
                    }
                }
            }
        }
        return id;
    }

    public void setTextIsSelectable(boolean z) {
        this.f11552d = z;
        super.setTextIsSelectable(z);
    }

    protected boolean verifyDrawable(Drawable drawable) {
        int i = 0;
        if (this.f11549a && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class);
            int length = textInlineImageSpanArr.length;
            while (i < length) {
                if (textInlineImageSpanArr[i].mo317a() == drawable) {
                    return true;
                }
                i++;
            }
        }
        return super.verifyDrawable(drawable);
    }

    public void invalidateDrawable(Drawable drawable) {
        int i = 0;
        if (this.f11549a && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class);
            int length = textInlineImageSpanArr.length;
            while (i < length) {
                if (textInlineImageSpanArr[i].mo317a() == drawable) {
                    invalidate();
                }
                i++;
            }
        }
        super.invalidateDrawable(drawable);
    }

    public void onDetachedFromWindow() {
        int i = 0;
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 425109165);
        super.onDetachedFromWindow();
        if (this.f11549a && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class);
            int length = textInlineImageSpanArr.length;
            while (i < length) {
                textInlineImageSpanArr[i].mo319b();
                i++;
            }
        }
        LogUtils.g(1565659421, a);
    }

    public void onStartTemporaryDetach() {
        int i = 0;
        super.onStartTemporaryDetach();
        if (this.f11549a && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class);
            int length = textInlineImageSpanArr.length;
            while (i < length) {
                textInlineImageSpanArr[i].mo320c();
                i++;
            }
        }
    }

    public void onAttachedToWindow() {
        int i = 0;
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1808876537);
        super.onAttachedToWindow();
        if (this.f11549a && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class);
            int length = textInlineImageSpanArr.length;
            while (i < length) {
                textInlineImageSpanArr[i].mo321d();
                i++;
            }
        }
        LogUtils.g(29603842, a);
    }

    public void onFinishTemporaryDetach() {
        int i = 0;
        super.onFinishTemporaryDetach();
        if (this.f11549a && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class);
            int length = textInlineImageSpanArr.length;
            while (i < length) {
                textInlineImageSpanArr[i].mo322e();
                i++;
            }
        }
    }

    void setGravityHorizontal(int i) {
        if (i == 0) {
            i = this.f11550b;
        }
        setGravity(((getGravity() & -8) & -8388616) | i);
    }

    void setGravityVertical(int i) {
        if (i == 0) {
            i = this.f11551c;
        }
        setGravity((getGravity() & -113) | i);
    }
}
