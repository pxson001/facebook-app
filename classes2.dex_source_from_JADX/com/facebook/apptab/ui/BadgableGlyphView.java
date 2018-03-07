package com.facebook.apptab.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.apptab.ui.CaspianTabViewUtil.Theme;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringListener;
import com.facebook.springs.SpringSystem;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: research.facebook.com */
public class BadgableGlyphView extends View {
    protected final Rect f7157a;
    protected Drawable f7158b;
    public int f7159c;
    public boolean f7160d;
    @Inject
    CaspianTabViewUtil f7161e;
    @Inject
    GlyphColorizer f7162f;
    @Inject
    Lazy<SpringSystem> f7163g;
    private final int f7164h;
    private final int f7165i;
    private final int f7166j;
    private final int f7167k;
    private final int[] f7168l;
    private final Rect f7169m;
    private final Paint f7170n;
    private final float f7171o;
    private final SpringListener f7172p;
    private final SpringListener f7173q;
    private int f7174r;
    private int f7175s;
    private GradientDrawable f7176t;
    public float f7177u;
    private float f7178v;
    private String f7179w;
    private Spring f7180x;
    private Spring f7181y;
    private Integer f7182z;

    /* compiled from: research.facebook.com */
    class BadgeSpringListener extends SimpleSpringListener {
        final /* synthetic */ BadgableGlyphView f7197a;

        public BadgeSpringListener(BadgableGlyphView badgableGlyphView) {
            this.f7197a = badgableGlyphView;
        }

        public final void mo1160a(Spring spring) {
            this.f7197a.f7177u = (float) spring.m7821d();
            this.f7197a.invalidate();
        }

        public final void mo1161b(Spring spring) {
            if (spring.m7821d() == 0.0d) {
                this.f7197a.f7159c = 0;
            }
        }
    }

    /* compiled from: research.facebook.com */
    class SelectionSpringListener extends SimpleSpringListener {
        final /* synthetic */ BadgableGlyphView f7198a;

        public SelectionSpringListener(BadgableGlyphView badgableGlyphView) {
            this.f7198a = badgableGlyphView;
        }

        public final void mo1160a(Spring spring) {
            int i;
            this.f7198a.f7158b.setColorFilter(this.f7198a.f7161e.m7809a(spring.m7821d()));
            BadgableGlyphView badgableGlyphView = this.f7198a;
            if (this.f7198a.f7161e.f4213d == Theme.LIGHT) {
                i = -1;
            } else {
                i = -16777216;
            }
            badgableGlyphView.setBadgeOutlineColor(i);
            this.f7198a.invalidate(this.f7198a.f7157a);
        }
    }

    private static <T extends View> void m11626a(Class<T> cls, T t) {
        m11627a((Object) t, t.getContext());
    }

    private static void m11627a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BadgableGlyphView) obj).m11625a(CaspianTabViewUtil.m7806a(injectorLike), GlyphColorizer.m11486a(injectorLike), IdBasedLazy.m1808a(injectorLike, 3433));
    }

    public BadgableGlyphView(Context context) {
        this(context, null);
    }

    public BadgableGlyphView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BadgableGlyphView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7157a = new Rect();
        this.f7168l = new int[2];
        this.f7169m = new Rect();
        this.f7172p = new BadgeSpringListener(this);
        this.f7173q = new SelectionSpringListener(this);
        m11626a(BadgableGlyphView.class, (View) this);
        Resources resources = context.getResources();
        this.f7164h = resources.getDimensionPixelSize(2131428120);
        this.f7165i = resources.getDimensionPixelSize(2131428121);
        this.f7166j = resources.getDimensionPixelSize(2131428122);
        this.f7167k = resources.getDimensionPixelSize(2131428124);
        this.f7176t = (GradientDrawable) resources.getDrawable(2130843535);
        this.f7170n = new Paint();
        this.f7170n.setTextSize((float) resources.getDimensionPixelSize(2131428123));
        this.f7170n.setColor(-1);
        this.f7170n.setTypeface(CustomFontHelper.m11813a(context, FontFamily.ROBOTO, FontWeight.BOLD, this.f7170n.getTypeface()));
        this.f7170n.setAntiAlias(true);
        this.f7170n.setTextAlign(Align.CENTER);
        this.f7171o = ((this.f7170n.descent() - this.f7170n.ascent()) / 2.0f) - this.f7170n.descent();
    }

    private void m11625a(CaspianTabViewUtil caspianTabViewUtil, GlyphColorizer glyphColorizer, Lazy<SpringSystem> lazy) {
        this.f7161e = caspianTabViewUtil;
        this.f7162f = glyphColorizer;
        this.f7163g = lazy;
    }

    public void setBadgeOutlineColor(int i) {
        if (this.f7182z == null || this.f7182z.intValue() != i) {
            this.f7182z = Integer.valueOf(i);
            this.f7176t.mutate();
            this.f7176t.setStroke((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()), i);
        }
    }

    public void setBadgeColor(int i) {
        this.f7176t.mutate();
        this.f7176t.setColor(i);
    }

    public void setSelected(boolean z) {
        getSelectionSpring().m7818b(z ? 1.0d : 0.0d);
    }

    public void setSelectionPercentage(float f) {
        getSelectionSpring().m7818b((double) f).m7813a((double) f).m7830l();
    }

    public final void m11628a(Drawable drawable, int i) {
        drawable.setColorFilter(this.f7162f.m11488a(i));
        setGlyphImage(drawable);
    }

    public void setGlyphImage(Drawable drawable) {
        this.f7158b = drawable;
        int i = this.f7174r;
        int i2 = this.f7175s;
        this.f7174r = this.f7158b.getIntrinsicWidth();
        this.f7175s = this.f7158b.getIntrinsicHeight();
        if (!(this.f7174r == i && this.f7175s == i2)) {
            requestLayout();
        }
        this.f7158b.setCallback(this);
    }

    public void setTabIconImageResource(int i) {
        setGlyphImage(getResources().getDrawable(i));
    }

    public void setUnreadCount(int i) {
        if (this.f7159c != i) {
            Spring a;
            if (i > 0) {
                if (this.f7159c <= 0) {
                    a = getBadgeSpring().m7813a(0.0d);
                    a.f4216c = false;
                    a.m7818b(1.0d);
                } else {
                    getBadgeSpring().m7820c(5.0d);
                }
                this.f7159c = i;
            } else {
                a = getBadgeSpring();
                a.f4216c = true;
                a.m7818b(0.0d);
            }
            requestLayout();
        }
    }

    public int getUnreadCount() {
        return this.f7159c;
    }

    public void setUseSmallUnreadCountCap(boolean z) {
        this.f7160d = z;
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int i3 = size / 2;
        int i4 = size2 / 2;
        this.f7157a.left = i3 - (this.f7174r / 2);
        this.f7157a.right = i3 + (this.f7174r / 2);
        this.f7157a.top = i4 - (this.f7175s / 2);
        this.f7157a.bottom = i4 + (this.f7175s / 2);
        if (this.f7159c > 0) {
            int i5;
            CaspianTabViewUtil caspianTabViewUtil = this.f7161e;
            i4 = this.f7159c;
            boolean z = this.f7160d;
            if (z) {
                i5 = 9;
            } else {
                i5 = 99;
            }
            String valueOf = i4 > i5 ? z ? caspianTabViewUtil.f4211b : caspianTabViewUtil.f4212c : String.valueOf(i4);
            this.f7179w = valueOf;
            i3 = Math.max(this.f7166j * 2, ((int) this.f7170n.measureText(this.f7179w)) + this.f7167k) / 2;
            this.f7168l[0] = this.f7157a.right + this.f7164h;
            this.f7168l[1] = this.f7157a.top + this.f7165i;
            this.f7169m.left = this.f7168l[0] - i3;
            this.f7169m.top = this.f7168l[1] - this.f7166j;
            this.f7169m.right = i3 + this.f7168l[0];
            this.f7169m.bottom = this.f7168l[1] + this.f7166j;
            this.f7178v = ((float) this.f7168l[1]) + this.f7171o;
        }
        setMeasuredDimension(size, size2);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f7158b.setBounds(this.f7157a);
        this.f7158b.draw(canvas);
        if (this.f7177u > 0.0f && !Strings.isNullOrEmpty(this.f7179w)) {
            float f = 40.0f - (this.f7177u * 40.0f);
            canvas.save();
            canvas.scale(this.f7177u, this.f7177u, (float) this.f7168l[0], (float) this.f7168l[1]);
            canvas.rotate(f, (float) this.f7168l[0], (float) this.f7168l[1]);
            this.f7176t.setBounds(this.f7169m);
            this.f7176t.draw(canvas);
            canvas.drawText(this.f7179w, (float) this.f7168l[0], this.f7178v, this.f7170n);
            canvas.restore();
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
        if (drawable == this.f7158b) {
            invalidate(drawable.getBounds());
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return this.f7158b == drawable || super.verifyDrawable(drawable);
    }

    private synchronized Spring getBadgeSpring() {
        Spring spring;
        if (this.f7181y != null) {
            spring = this.f7181y;
        } else {
            this.f7181y = ((SpringSystem) this.f7163g.get()).m7838a().m7814a(SpringConfig.m7843b(13.0d, 15.0d)).m7813a(0.0d).m7818b(0.0d).m7824e(0.01d).m7822d(1.0d).m7830l();
            this.f7181y.m7815a(this.f7172p);
            spring = this.f7181y;
        }
        return spring;
    }

    private synchronized Spring getSelectionSpring() {
        Spring spring;
        if (this.f7180x != null) {
            spring = this.f7180x;
        } else {
            this.f7180x = ((SpringSystem) this.f7163g.get()).m7838a().m7814a(SpringConfig.m7842a(40.0d, 4.0d)).m7813a(0.0d).m7818b(0.0d).m7830l().m7824e(0.01d).m7822d(0.2d).m7816a(true);
            this.f7180x.m7815a(this.f7173q);
            spring = this.f7180x;
        }
        return spring;
    }
}
