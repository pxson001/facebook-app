package com.facebook.widget.tokenizedtypeahead;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.facebook.common.util.StringUtil;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: com.facebook.samples.privacy.MainFragment */
public class BaseTokenSpan extends TokenSpan<BaseToken> {
    private final int f19992j;
    private final int f19993k;
    private final int f19994l;
    private final TextPaint f19995m;
    @Nullable
    private final Integer f19996n;
    private final Drawable f19997o;
    private final Resources f19998p;
    private Drawable f19999q;

    /* compiled from: com.facebook.samples.privacy.MainFragment */
    public class Builder {
        public BaseToken f19975a;
        public TextPaint f19976b;
        public Resources f19977c;
        private Integer f19978d;
        public Drawable f19979e;
        private Integer f19980f;
        private Boolean f19981g;
        public Integer f19982h;

        public final Builder m28681a(int i) {
            this.f19978d = Integer.valueOf(i);
            return this;
        }

        public final Builder m28684b(int i) {
            this.f19980f = Integer.valueOf(i);
            return this;
        }

        public final Builder m28682a(boolean z) {
            this.f19981g = Boolean.valueOf(z);
            return this;
        }

        public final BaseTokenSpan m28683a(Context context) {
            boolean booleanValue;
            Preconditions.checkNotNull(this.f19975a);
            Preconditions.checkNotNull(this.f19976b);
            Preconditions.checkNotNull(this.f19977c);
            Preconditions.checkNotNull(this.f19978d);
            int dimensionPixelOffset = this.f19975a.mo1187e() > 0 ? this.f19977c.getDimensionPixelOffset(2131427789) : 0;
            int intValue = this.f19980f != null ? this.f19980f.intValue() : this.f19977c.getDimensionPixelOffset(2131427787);
            int dimensionPixelOffset2 = this.f19977c.getDimensionPixelOffset(2131427788);
            if (this.f19981g != null) {
                booleanValue = this.f19981g.booleanValue();
            } else {
                booleanValue = false;
            }
            TokenSpan baseTokenSpan = new BaseTokenSpan(this.f19975a, this.f19976b, this.f19977c, this.f19979e, this.f19982h, this.f19978d.intValue(), intValue, dimensionPixelOffset2, dimensionPixelOffset, booleanValue);
            baseTokenSpan.mo1516a(context);
            return baseTokenSpan;
        }
    }

    private BaseTokenSpan(BaseToken baseToken, TextPaint textPaint, Resources resources, Drawable drawable, @Nullable Integer num, int i, int i2, int i3, int i4, boolean z) {
        super(baseToken, resources, i, z);
        this.f19995m = textPaint;
        this.f19998p = resources;
        this.f19997o = drawable;
        this.f19996n = num;
        this.f19992j = i2;
        this.f19993k = i3;
        this.f19994l = i4;
    }

    public final void mo1516a(Context context) {
        this.f19999q = m28691a(this.f19995m, this.f19996n, this.f19998p, this.f19997o);
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, @Nullable FontMetricsInt fontMetricsInt) {
        TextPaint textPaint = (TextPaint) paint;
        if (fontMetricsInt != null) {
            textPaint.getFontMetricsInt(fontMetricsInt);
            fontMetricsInt.top -= this.f19993k;
            fontMetricsInt.bottom += this.f19993k;
            fontMetricsInt.ascent = fontMetricsInt.top;
            fontMetricsInt.descent = fontMetricsInt.bottom;
        }
        return this.f19999q.getBounds().width();
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        int i6 = i5 - this.f19999q.getBounds().bottom;
        canvas.translate(f, (float) i6);
        this.f19987e.offsetTo((int) f, i6);
        this.f19999q.draw(canvas);
        canvas.restore();
    }

    private Drawable m28691a(TextPaint textPaint, @Nullable Integer num, Resources resources, Drawable drawable) {
        Bitmap a;
        int i;
        if (drawable == null) {
            drawable = resources.getDrawable(2130843687);
        }
        if (((BaseToken) this.f19988f).m22640r() && ((BaseToken) this.f19988f).mo1187e() > 0) {
            a = m28690a(-1);
        } else if (num != null && ((BaseToken) this.f19988f).mo1187e() > 0) {
            a = m28690a(num.intValue());
        } else if (((BaseToken) this.f19988f).mo1187e() > 0) {
            a = BitmapFactory.decodeResource(resources, ((BaseToken) this.f19988f).mo1187e());
        } else {
            a = null;
        }
        if (a == null) {
            i = 0;
        } else {
            i = a.getWidth() + this.f19994l;
        }
        float measureText = ((float) ((this.f19990h - i) - (this.f19992j * 2))) - textPaint.measureText(" ");
        if (measureText < 0.0f) {
            throw new IllegalStateException("Space available to draw display name can not be negative");
        }
        String str;
        if (StringUtil.a(((BaseToken) this.f19988f).mo1185b())) {
            str = "";
        } else {
            CharSequence string;
            if (this.f19991i) {
                string = resources.getString(2131230928, new Object[]{((BaseToken) this.f19988f).mo1185b()});
            } else {
                string = ((BaseToken) this.f19988f).mo1185b();
            }
            str = TextUtils.ellipsize(string, textPaint, measureText, TruncateAt.END).toString();
        }
        int measureText2 = (int) ((textPaint.measureText(str) + ((float) i)) + ((float) (this.f19992j * 2)));
        int measureText3 = (int) (((float) measureText2) + textPaint.measureText(" "));
        FontMetricsInt fontMetricsInt = textPaint.getFontMetricsInt();
        int i2 = (fontMetricsInt.bottom - fontMetricsInt.top) + (this.f19993k * 2);
        Bitmap createBitmap = Bitmap.createBitmap(measureText3, i2, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(0);
        drawable.setBounds(0, 0, measureText2, i2);
        drawable.draw(canvas);
        if (a != null) {
            measureText2 = a.getHeight();
            Matrix matrix = new Matrix();
            matrix.setTranslate((float) this.f19992j, ((float) (i2 - measureText2)) / 2.0f);
            canvas.drawBitmap(a, matrix, textPaint);
            a.recycle();
        }
        canvas.drawText(str, (float) (i + this.f19992j), (float) ((i2 - this.f19993k) - fontMetricsInt.bottom), textPaint);
        Drawable bitmapDrawable = new BitmapDrawable(resources, createBitmap);
        this.f19987e.set(this.f19987e.left, this.f19987e.top, this.f19987e.left + measureText3, this.f19987e.top + i2);
        bitmapDrawable.setBounds(0, 0, measureText3, i2);
        return bitmapDrawable;
    }

    private Bitmap m28690a(int i) {
        Drawable drawable = this.f19998p.getDrawable(((BaseToken) this.f19988f).mo1187e());
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.setColorFilter(i, Mode.SRC_ATOP);
        drawable.draw(canvas);
        return createBitmap;
    }
}
