package com.facebook.reviews.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.reviews.ui.BarChart.BarChartItem;
import com.facebook.ui.animations.WidthAnimation;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import javax.inject.Inject;

/* compiled from: Timestamp didn't belong to any timerange!  This shouldn't be possible! */
public class BarChartItemView extends CustomLinearLayout {
    @Inject
    RTLUtil f21730a;
    @Inject
    GlyphColorizer f21731b;
    @Inject
    NumberTruncationUtil f21732c;
    private TextView f21733d;
    private View f21734e;
    private TextView f21735f;
    private int f21736g;
    public int f21737h;
    private int f21738i = 0;
    public boolean f21739j;
    public int f21740k;
    private float f21741l;

    private static <T extends View> void m25230a(Class<T> cls, T t) {
        m25231a((Object) t, t.getContext());
    }

    private static void m25231a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((BarChartItemView) obj).m25229a(RTLUtil.a(fbInjector), GlyphColorizer.a(fbInjector), NumberTruncationUtil.a(fbInjector));
    }

    private void m25229a(RTLUtil rTLUtil, GlyphColorizer glyphColorizer, NumberTruncationUtil numberTruncationUtil) {
        this.f21730a = rTLUtil;
        this.f21731b = glyphColorizer;
        this.f21732c = numberTruncationUtil;
    }

    public BarChartItemView(Context context) {
        super(context);
        m25228a();
    }

    private void m25228a() {
        m25230a(BarChartItemView.class, (View) this);
        setContentView(2130903386);
        this.f21733d = (TextView) a(2131559907);
        this.f21734e = a(2131559908);
        this.f21735f = (TextView) a(2131559909);
        this.f21739j = false;
        this.f21740k = 0;
        this.f21741l = 0.0f;
    }

    public final void m25232a(BarChartItem barChartItem, int i, int i2, int i3, int i4) {
        float f;
        CharSequence a;
        this.f21733d.setText(barChartItem.f21713b);
        this.f21733d.setWidth(i2);
        if (i == 0) {
            f = 0.0f;
        } else {
            f = ((float) barChartItem.f21714c) / ((float) i);
        }
        this.f21741l = f;
        this.f21736g = i3;
        CustomViewUtils.b(this.f21734e, this.f21731b.a(i4, barChartItem.f21712a, false));
        TextView textView = this.f21735f;
        if (barChartItem.f21714c > 0) {
            a = this.f21732c.a(barChartItem.f21714c);
        } else {
            a = null;
        }
        textView.setText(a);
    }

    public void setLabelTextsize(int i) {
        this.f21733d.setTextSize(0, (float) i);
    }

    public void setLabelTextColor(int i) {
        this.f21733d.setTextColor(i);
    }

    public void setValueVisibility(int i) {
        this.f21735f.setVisibility(i);
    }

    public void setLabelBarSpacing(int i) {
        LayoutParams layoutParams = (LayoutParams) this.f21733d.getLayoutParams();
        LayoutParams layoutParams2 = (LayoutParams) this.f21735f.getLayoutParams();
        if (this.f21730a.a()) {
            layoutParams.leftMargin = i;
            layoutParams2.rightMargin = i;
        } else {
            layoutParams.rightMargin = i;
            layoutParams2.leftMargin = i;
        }
        this.f21733d.setLayoutParams(layoutParams);
        this.f21735f.setLayoutParams(layoutParams2);
        if (this.f21735f.getVisibility() == 0) {
            i *= 2;
        }
        this.f21738i = i;
    }

    public void setBarHeight(int i) {
        ViewGroup.LayoutParams layoutParams = this.f21734e.getLayoutParams();
        layoutParams.height = i;
        this.f21734e.setLayoutParams(layoutParams);
    }

    public void setBarMinWidth(int i) {
        this.f21737h = i;
    }

    public void setBarAnimationEnabled(boolean z) {
        this.f21739j = z;
    }

    public void setBarAnimationTime(int i) {
        this.f21740k = i;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f21741l != 0.0f && z) {
            WidthAnimation widthAnimation = new WidthAnimation(this.f21734e, this.f21737h, Math.max(Math.round(((float) (((getWidth() - this.f21733d.getWidth()) - (this.f21735f.getVisibility() == 0 ? this.f21736g : 0)) - this.f21738i)) * this.f21741l), this.f21737h));
            widthAnimation.setDuration(this.f21739j ? (long) this.f21740k : 0);
            startAnimation(widthAnimation);
        }
    }
}
