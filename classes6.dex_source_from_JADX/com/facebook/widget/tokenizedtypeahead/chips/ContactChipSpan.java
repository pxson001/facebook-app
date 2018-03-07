package com.facebook.widget.tokenizedtypeahead.chips;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.StringUtil;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.user.tiles.UserTileDrawableController;
import com.facebook.user.tiles.UserTileView$OnUserTileUpdatedListener;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.tokenizedtypeahead.TokenSpan;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: com.facebook.push.mqtt.ACTION_CHANNEL_STATE_CHANGED */
public class ContactChipSpan extends TokenSpan<ContactChipToken> {
    private final int f20094j;
    private final int f20095k;
    private final int f20096l;
    private final Drawable f20097m;
    private final int f20098n;
    private final int f20099o;
    public final int f20100p;
    public final TextPaint f20101q;
    public final ColorStateList f20102r;
    public final UserTileDrawableController f20103s;
    private final PlatformBitmapFactory f20104t;
    private CloseableReference<Bitmap> f20105u;
    public Drawable f20106v;
    private Rect f20107w;

    /* compiled from: com.facebook.push.mqtt.ACTION_CHANNEL_STATE_CHANGED */
    class C15091 implements UserTileView$OnUserTileUpdatedListener {
        final /* synthetic */ ContactChipSpan f20078a;

        C15091(ContactChipSpan contactChipSpan) {
            this.f20078a = contactChipSpan;
        }

        public final void mo1519a() {
            this.f20078a.f20106v = ContactChipSpan.m28750a(this.f20078a, this.f20078a.f20103s.m, this.f20078a.f20100p, this.f20078a.f20101q, this.f20078a.f20102r);
        }
    }

    /* compiled from: com.facebook.push.mqtt.ACTION_CHANNEL_STATE_CHANGED */
    public class Builder {
        private final UserTileDrawableController f20079a;
        private final PlatformBitmapFactory f20080b;
        public ContactChipToken f20081c;
        public TextPaint f20082d;
        public Resources f20083e;
        public int f20084f;
        private Integer f20085g;
        public ColorStateList f20086h;
        private Integer f20087i;
        private Integer f20088j;
        private Integer f20089k;
        private Drawable f20090l;
        private Integer f20091m;
        private Integer f20092n;
        private Boolean f20093o;

        public Builder(UserTileDrawableController userTileDrawableController, PlatformBitmapFactory platformBitmapFactory) {
            this.f20079a = userTileDrawableController;
            this.f20080b = platformBitmapFactory;
        }

        public final ContactChipSpan m28749a(Context context) {
            Preconditions.checkNotNull(this.f20081c);
            Preconditions.checkNotNull(this.f20082d);
            Preconditions.checkNotNull(this.f20083e);
            Preconditions.checkNotNull(Integer.valueOf(this.f20084f));
            ColorStateList colorStateList = this.f20086h != null ? this.f20086h : this.f20083e.getColorStateList(2131364162);
            int intValue = this.f20085g != null ? this.f20085g.intValue() : this.f20083e.getDimensionPixelSize(2131427800);
            int intValue2 = this.f20087i != null ? this.f20087i.intValue() : this.f20083e.getDimensionPixelOffset(2131427801);
            int intValue3 = this.f20088j != null ? this.f20088j.intValue() : this.f20083e.getDimensionPixelOffset(2131427802);
            int intValue4 = this.f20089k != null ? this.f20089k.intValue() : this.f20083e.getDimensionPixelOffset(2131427803);
            Drawable drawable = (this.f20081c.m22641s() && this.f20090l == null) ? this.f20083e.getDrawable(2130843686) : this.f20090l;
            TokenSpan contactChipSpan = new ContactChipSpan(this.f20081c, this.f20082d, this.f20083e, colorStateList, this.f20084f, intValue, intValue2, intValue3, intValue4, drawable, this.f20091m != null ? this.f20091m.intValue() : this.f20083e.getDimensionPixelSize(2131427805), this.f20092n != null ? this.f20092n.intValue() : this.f20083e.getDimensionPixelOffset(2131427806), this.f20093o != null ? this.f20093o.booleanValue() : false, this.f20079a, this.f20080b);
            contactChipSpan.mo1516a(context);
            return contactChipSpan;
        }
    }

    private ContactChipSpan(ContactChipToken contactChipToken, TextPaint textPaint, Resources resources, ColorStateList colorStateList, int i, int i2, int i3, int i4, int i5, Drawable drawable, int i6, int i7, boolean z, UserTileDrawableController userTileDrawableController, PlatformBitmapFactory platformBitmapFactory) {
        super(contactChipToken, resources, i, z);
        this.f20101q = textPaint;
        this.f20102r = colorStateList;
        this.f20100p = i2;
        this.f20094j = i3;
        this.f20095k = i4;
        this.f20096l = i5;
        this.f20097m = drawable;
        this.f20098n = i6;
        this.f20099o = i7;
        this.f20103s = userTileDrawableController;
        this.f20104t = platformBitmapFactory;
    }

    public final void mo1516a(Context context) {
        this.f20103s.a(context, null, 0);
        UserTileDrawableController userTileDrawableController = this.f20103s;
        userTileDrawableController.p.a(this.f20101q.getTextSize());
        this.f20103s.a(true);
        this.f20103s.a(UserTileViewParams.a(((ContactChipToken) this.f19988f).mo1523c()));
        this.f20103s.c();
        this.f20106v = m28750a(this, this.f20103s.m, this.f20100p, this.f20101q, this.f20102r);
        this.f20103s.A = new C15091(this);
    }

    public final void mo1520a() {
        this.f20103s.d();
        this.f20105u.close();
        this.f20105u = null;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, @Nullable FontMetricsInt fontMetricsInt) {
        TextPaint textPaint = (TextPaint) paint;
        if (fontMetricsInt != null) {
            textPaint.getFontMetricsInt(fontMetricsInt);
            float height = (((float) this.f20106v.getBounds().height()) - ((float) (fontMetricsInt.bottom - fontMetricsInt.top))) / 2.0f;
            fontMetricsInt.top = (int) (((float) fontMetricsInt.top) - height);
            fontMetricsInt.bottom = (int) (height + ((float) fontMetricsInt.bottom));
            fontMetricsInt.ascent = fontMetricsInt.top;
            fontMetricsInt.descent = fontMetricsInt.bottom;
        }
        return this.f20106v.getBounds().width();
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        int i6 = i5 - this.f20106v.getBounds().bottom;
        canvas.translate(f, (float) i6);
        this.f19987e.offsetTo((int) f, i6);
        this.f20106v.draw(canvas);
        canvas.restore();
    }

    public static Drawable m28750a(@Nullable ContactChipSpan contactChipSpan, Drawable drawable, int i, TextPaint textPaint, ColorStateList colorStateList) {
        int i2;
        int i3 = i + contactChipSpan.f20096l;
        boolean s = ((ContactChipToken) contactChipSpan.f19988f).m22641s();
        if (s && contactChipSpan.f20107w == null) {
            contactChipSpan.f20107w = new Rect();
        }
        if (s) {
            i2 = contactChipSpan.f20098n + (contactChipSpan.f20099o * 2);
        } else {
            i2 = contactChipSpan.f20094j;
        }
        float measureText = ((float) (((contactChipSpan.f19990h - i3) - contactChipSpan.f20096l) - i2)) - textPaint.measureText(" ");
        if (measureText < 0.0f) {
            throw new IllegalStateException("Space available to draw display name can not be negative");
        }
        String str = "";
        CharSequence b = ((ContactChipToken) contactChipSpan.f19988f).mo1185b();
        if (!StringUtil.a(b)) {
            if (contactChipSpan.f19991i) {
                b = contactChipSpan.f19989g.getString(2131230928, new Object[]{b});
            }
            str = TextUtils.ellipsize(b, textPaint, measureText, TruncateAt.END).toString();
        }
        int measureText2 = (int) ((textPaint.measureText(str) + ((float) i3)) + ((float) i2));
        int measureText3 = (int) (((float) measureText2) + textPaint.measureText(" "));
        FontMetricsInt fontMetricsInt = textPaint.getFontMetricsInt();
        int i4 = i + (contactChipSpan.f20095k * 2);
        Bitmap bitmap = null;
        if (contactChipSpan.f20105u != null) {
            bitmap = (Bitmap) contactChipSpan.f20105u.a();
            if (!(bitmap.getWidth() == measureText3 && bitmap.getHeight() == i4)) {
                contactChipSpan.f20105u.close();
                contactChipSpan.f20105u = null;
            }
        }
        if (contactChipSpan.f20105u == null) {
            contactChipSpan.f20105u = contactChipSpan.f20104t.a(measureText3, i4, Config.ARGB_8888);
            bitmap = (Bitmap) contactChipSpan.f20105u.a();
        }
        bitmap.setHasAlpha(true);
        Canvas canvas = new Canvas(bitmap);
        float min = ((float) Math.min(measureText3, i4)) / 2.0f;
        Paint paint = new Paint();
        paint.setColor(colorStateList.getColorForState(contactChipSpan.m28689c(), contactChipSpan.f19989g.getColor(2131362255)));
        canvas.drawRoundRect(new RectF(0.0f, (float) contactChipSpan.f20095k, (float) measureText2, (float) (contactChipSpan.f20095k + i)), min, min, paint);
        if (drawable != null) {
            drawable.setBounds(0, contactChipSpan.f20095k, i, contactChipSpan.f20095k + i);
            drawable.draw(canvas);
        }
        canvas.drawText(str, (float) i3, (float) (((i4 - fontMetricsInt.ascent) / 2) - contactChipSpan.f20095k), textPaint);
        if (s) {
            i2 = (measureText2 - i2) + contactChipSpan.f20099o;
            int i5 = (i4 - contactChipSpan.f20098n) / 2;
            contactChipSpan.f20107w.set(i2, i5, contactChipSpan.f20098n + i2, contactChipSpan.f20098n + i5);
            contactChipSpan.f20097m.setBounds(contactChipSpan.f20107w);
            contactChipSpan.f20097m.setAlpha(136);
            contactChipSpan.f20097m.draw(canvas);
        }
        Drawable bitmapDrawable = new BitmapDrawable(contactChipSpan.f19989g, bitmap);
        contactChipSpan.f19987e.set(contactChipSpan.f19987e.left, contactChipSpan.f19987e.top, contactChipSpan.f19987e.left + measureText3, contactChipSpan.f19987e.top + i4);
        bitmapDrawable.setBounds(0, 0, measureText3, i4);
        bitmapDrawable.setAlpha(((ContactChipToken) contactChipSpan.f19988f).mo1195a() ? 255 : 128);
        return bitmapDrawable;
    }

    public final void mo1521b(Rect rect) {
        if (!((ContactChipToken) this.f19988f).f15075a || this.f20107w == null) {
            rect.setEmpty();
        } else {
            rect.set(this.f20107w);
        }
    }
}
