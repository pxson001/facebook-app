package com.facebook.pages.identity.ui.text;

import android.content.Context;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.facebook.common.util.StringUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;

/* compiled from: page_identity_follow_fail */
public class TwoStringTextView extends FbTextView {
    private CharSequence f4274a;
    private CharSequence f4275b;
    private CharSequence f4276c;
    private CharSequence f4277d;
    private boolean f4278e;
    private float f4279f;
    private float f4280g;

    public TwoStringTextView(Context context) {
        this(context, null);
    }

    public TwoStringTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TwoStringTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4278e = false;
        this.f4279f = 1.0f;
        this.f4280g = 0.0f;
    }

    public final void m5238a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.f4274a = charSequence;
        this.f4275b = charSequence2;
        if (StringUtil.a(this.f4274a)) {
            setText(this.f4275b);
            this.f4278e = false;
        } else if (StringUtil.a(this.f4275b)) {
            setText(this.f4274a);
            this.f4278e = false;
        } else {
            this.f4278e = true;
            this.f4276c = TextUtils.concat(new CharSequence[]{this.f4274a, charSequence3, this.f4275b});
            this.f4277d = TextUtils.concat(new CharSequence[]{this.f4274a, "\n", this.f4275b});
            setText(this.f4276c);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1771762583);
        if (!(i == i3 && i2 == i4)) {
            this.f4278e = true;
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -97514582, a);
    }

    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.f4279f = f2;
        this.f4280g = f;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z || this.f4278e) {
            m5237a(((i3 - i) - getCompoundPaddingLeft()) - getCompoundPaddingRight(), ((i4 - i2) - getCompoundPaddingBottom()) - getCompoundPaddingTop());
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    private void m5237a(int i, int i2) {
        if (this.f4274a != null && this.f4275b != null) {
            CharSequence text = getText();
            if (text != null && text.length() != 0 && i2 > 0 && i > 0 && ((double) getTextSize()) >= 1.0E-5d) {
                TextPaint paint = getPaint();
                int a = m5236a(text, paint, i, getTextSize());
                if (a > 1 && !(m5236a(this.f4274a, paint, i, getTextSize()) == 2 && a == 2)) {
                    setText(this.f4277d);
                }
                this.f4278e = false;
            }
        }
    }

    private int m5236a(CharSequence charSequence, TextPaint textPaint, int i, float f) {
        textPaint.setTextSize(f);
        return new StaticLayout(charSequence, textPaint, i, Alignment.ALIGN_NORMAL, this.f4279f, this.f4280g, true).getLineCount();
    }
}
