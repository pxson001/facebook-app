package com.facebook.resources.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.facebook.common.util.SizeUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: contacts_people */
public class FbAutoFitTextView extends TextView {
    private Rect f5256a;
    private TextPaint f5257b;
    private int f5258c;
    private int f5259d;

    public FbAutoFitTextView(Context context) {
        super(context);
        m10161a();
    }

    public FbAutoFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10161a();
    }

    public FbAutoFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10161a();
    }

    private void m10161a() {
        this.f5256a = new Rect();
        this.f5257b = new TextPaint();
        this.f5258c = SizeUtil.b(getContext(), 8.0f);
        this.f5259d = (int) getTextSize();
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(charSequence, bufferType);
        m10163b();
    }

    public void setTextSize(float f) {
        this.f5259d = (int) f;
        m10163b();
    }

    public void setTextSize(int i, float f) {
        this.f5259d = (int) TypedValue.applyDimension(i, f, getContext().getResources().getDisplayMetrics());
        m10163b();
    }

    public void setMinTextSizeSp(float f) {
        this.f5258c = SizeUtil.b(getContext(), f);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -388708414);
        super.onSizeChanged(i, i2, i3, i4);
        if (!(i == i3 && i2 == i4)) {
            m10163b();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 364400852, a);
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        m10163b();
    }

    private void m10163b() {
        if (this.f5256a != null) {
            this.f5256a.right = (getMeasuredWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight();
            this.f5256a.bottom = (getMeasuredHeight() - getCompoundPaddingTop()) - getCompoundPaddingBottom();
            if (this.f5256a.right != 0 && this.f5256a.bottom != 0) {
                for (int i = this.f5259d; i >= this.f5258c; i--) {
                    if (m10162a(i)) {
                        super.setTextSize(0, (float) i);
                        return;
                    }
                }
                super.setTextSize(0, (float) this.f5258c);
            }
        }
    }

    @TargetApi(16)
    private boolean m10162a(int i) {
        if (VERSION.SDK_INT < 16) {
            return true;
        }
        CharSequence charSequence = getText().toString();
        this.f5257b.setTextSize((float) i);
        StaticLayout staticLayout = new StaticLayout(charSequence, this.f5257b, this.f5256a.width(), Alignment.ALIGN_CENTER, getLineSpacingMultiplier(), getLineSpacingExtra(), true);
        if (staticLayout.getLineCount() > getMaxLines()) {
            return false;
        }
        if (staticLayout.getHeight() > this.f5256a.bottom) {
            return false;
        }
        return true;
    }
}
