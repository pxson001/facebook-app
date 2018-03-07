package com.facebook.reviews.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: Tip returned a PendingIntent that was cancelled */
public class BarChart extends CustomLinearLayout {
    @Inject
    public NumberTruncationUtil f21715a;
    private int f21716b = 0;
    private int f21717c = 0;
    private int f21718d = 0;
    private int f21719e;
    private int f21720f;
    private int f21721g;
    private int f21722h;
    private int f21723i;
    private int f21724j;
    private int f21725k;
    private int f21726l;
    private boolean f21727m;
    private boolean f21728n;
    private ArrayList<BarChartItem> f21729o;

    /* compiled from: Tip returned a PendingIntent that was cancelled */
    public class BarChartItem {
        public final int f21712a;
        public final SpannableString f21713b;
        public final int f21714c;

        public BarChartItem(int i, SpannableString spannableString, int i2) {
            this.f21712a = i;
            this.f21713b = spannableString;
            this.f21714c = i2;
        }

        public final int m25218a() {
            return this.f21712a;
        }

        public final SpannableString m25219b() {
            return this.f21713b;
        }

        public final int m25220c() {
            return this.f21714c;
        }
    }

    private static <T extends View> void m25224a(Class<T> cls, T t) {
        m25225a((Object) t, t.getContext());
    }

    private static void m25225a(Object obj, Context context) {
        ((BarChart) obj).f21715a = NumberTruncationUtil.a(FbInjector.get(context));
    }

    private void m25223a(NumberTruncationUtil numberTruncationUtil) {
        this.f21715a = numberTruncationUtil;
    }

    public BarChart(Context context) {
        super(context);
        m25222a(context, null);
    }

    public BarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25222a(context, attributeSet);
    }

    private void m25222a(Context context, AttributeSet attributeSet) {
        m25224a(BarChart.class, (View) this);
        this.f21729o = Lists.a();
        setOrientation(1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BarChart);
        this.f21719e = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f21720f = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f21721g = obtainStyledAttributes.getColor(2, 0);
        this.f21722h = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        this.f21723i = obtainStyledAttributes.getResourceId(4, 0);
        this.f21724j = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.f21725k = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.f21726l = obtainStyledAttributes.getInteger(8, 0);
        this.f21727m = obtainStyledAttributes.getBoolean(5, false);
        obtainStyledAttributes.recycle();
        this.f21728n = false;
    }

    public final void m25227a(BarChartItem barChartItem) {
        Object obj;
        Object obj2 = 1;
        this.f21729o.add(barChartItem);
        if (barChartItem.f21714c > this.f21716b) {
            this.f21716b = barChartItem.f21714c;
            obj = 1;
        } else {
            obj = null;
        }
        int a = m25221a(barChartItem.f21713b);
        if (a > this.f21717c) {
            this.f21717c = a;
            obj = 1;
        }
        a = m25221a(new SpannableString(this.f21715a.a(this.f21716b)));
        if (a > this.f21718d) {
            this.f21718d = a;
        } else {
            obj2 = obj;
        }
        if (obj2 != null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof BarChartItemView) {
                    ((BarChartItemView) childAt).m25232a((BarChartItem) this.f21729o.get(i), this.f21716b, this.f21717c, this.f21718d, this.f21723i);
                }
            }
        }
        BarChartItemView barChartItemView = new BarChartItemView(getContext());
        barChartItemView.m25232a(barChartItem, this.f21716b, this.f21717c, this.f21718d, this.f21723i);
        addView(barChartItemView);
        setBarCharItemViewStyle(barChartItemView);
    }

    public final void m25226a() {
        this.f21729o.clear();
        removeAllViews();
        this.f21717c = 0;
        this.f21716b = 0;
    }

    public void setBarAnimationEnabled(boolean z) {
        this.f21728n = z;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof BarChartItemView) {
                ((BarChartItemView) childAt).f21739j = this.f21728n;
            }
        }
    }

    private void setBarCharItemViewStyle(BarChartItemView barChartItemView) {
        barChartItemView.setValueVisibility(this.f21727m ? 0 : 8);
        barChartItemView.setLabelTextsize(this.f21720f);
        barChartItemView.setLabelTextColor(this.f21721g);
        barChartItemView.setLabelBarSpacing(this.f21722h);
        barChartItemView.setBarHeight(this.f21724j);
        barChartItemView.f21737h = this.f21725k;
        barChartItemView.f21739j = this.f21728n;
        barChartItemView.f21740k = this.f21726l;
        LayoutParams layoutParams = barChartItemView.getLayoutParams();
        layoutParams.height = this.f21719e;
        barChartItemView.setLayoutParams(layoutParams);
    }

    private int m25221a(SpannableString spannableString) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, (float) this.f21720f);
        textView.setText(spannableString);
        textView.measure(0, 0);
        return textView.getMeasuredWidth() + getResources().getDimensionPixelSize(2131430078);
    }
}
