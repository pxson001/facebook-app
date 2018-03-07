package com.facebook.devicebasedlogin.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: permissions_payment_info_text */
public class NumPadView extends FrameLayout {
    private TextView f6649a;
    private TextView f6650b;
    private TextView f6651c;
    private TextView f6652d;
    private TextView f6653e;
    private TextView f6654f;
    private TextView f6655g;
    private TextView f6656h;
    private TextView f6657i;
    private TextView f6658j;
    public ImageView f6659k;
    private View f6660l;
    private View f6661m;
    private View f6662n;
    private View f6663o;
    private LinearLayout f6664p;
    private LinearLayout f6665q;
    public StringBuilder f6666r = new StringBuilder();
    public NumPadViewListener f6667s;
    private OnClickListener f6668t = null;

    /* compiled from: permissions_payment_info_text */
    class C06851 implements OnClickListener {
        final /* synthetic */ NumPadView f6648a;

        C06851(NumPadView numPadView) {
            this.f6648a = numPadView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2011685396);
            int length = this.f6648a.f6666r.length();
            if (view == this.f6648a.f6659k) {
                if (!(this.f6648a.f6666r == null || length == 0)) {
                    this.f6648a.f6666r = this.f6648a.f6666r.delete(length - 1, length);
                    NumPadView.m6966e(this.f6648a);
                }
            } else if (length < 4) {
                this.f6648a.f6666r = this.f6648a.f6666r.append(((TextView) view).getText());
                NumPadView.m6966e(this.f6648a);
            }
            LogUtils.a(1515888108, a);
        }
    }

    public NumPadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(2130905514, this, true);
        LinearLayout linearLayout = (LinearLayout) getChildAt(0);
        this.f6664p = (LinearLayout) linearLayout.getChildAt(0);
        this.f6660l = this.f6664p.getChildAt(0);
        this.f6661m = this.f6664p.getChildAt(1);
        this.f6662n = this.f6664p.getChildAt(2);
        this.f6663o = this.f6664p.getChildAt(3);
        this.f6665q = (LinearLayout) linearLayout.getChildAt(1);
        SegmentedLinearLayout segmentedLinearLayout = (SegmentedLinearLayout) this.f6665q.getChildAt(0);
        this.f6649a = (TextView) segmentedLinearLayout.getChildAt(0);
        this.f6652d = (TextView) segmentedLinearLayout.getChildAt(1);
        this.f6655g = (TextView) segmentedLinearLayout.getChildAt(2);
        segmentedLinearLayout = (SegmentedLinearLayout) this.f6665q.getChildAt(1);
        this.f6650b = (TextView) segmentedLinearLayout.getChildAt(0);
        this.f6653e = (TextView) segmentedLinearLayout.getChildAt(1);
        this.f6656h = (TextView) segmentedLinearLayout.getChildAt(2);
        this.f6658j = (TextView) segmentedLinearLayout.getChildAt(3);
        segmentedLinearLayout = (SegmentedLinearLayout) this.f6665q.getChildAt(2);
        this.f6651c = (TextView) segmentedLinearLayout.getChildAt(0);
        this.f6654f = (TextView) segmentedLinearLayout.getChildAt(1);
        this.f6657i = (TextView) segmentedLinearLayout.getChildAt(2);
        this.f6659k = (ImageView) segmentedLinearLayout.getChildAt(3);
        this.f6649a.setOnClickListener(getOnClickListener());
        this.f6650b.setOnClickListener(getOnClickListener());
        this.f6651c.setOnClickListener(getOnClickListener());
        this.f6652d.setOnClickListener(getOnClickListener());
        this.f6653e.setOnClickListener(getOnClickListener());
        this.f6654f.setOnClickListener(getOnClickListener());
        this.f6655g.setOnClickListener(getOnClickListener());
        this.f6656h.setOnClickListener(getOnClickListener());
        this.f6657i.setOnClickListener(getOnClickListener());
        this.f6658j.setOnClickListener(getOnClickListener());
        this.f6659k.setOnClickListener(getOnClickListener());
    }

    public void setNumPadViewListener(NumPadViewListener numPadViewListener) {
        this.f6667s = numPadViewListener;
    }

    public final void m6967a() {
        this.f6666r = new StringBuilder();
        m6966e(this);
    }

    public OnClickListener getOnClickListener() {
        if (this.f6668t != null) {
            return this.f6668t;
        }
        OnClickListener d = m6965d();
        this.f6668t = d;
        return d;
    }

    private OnClickListener m6965d() {
        return new C06851(this);
    }

    public static void m6966e(NumPadView numPadView) {
        numPadView.m6962a(0, numPadView.f6660l);
        numPadView.m6962a(1, numPadView.f6661m);
        numPadView.m6962a(2, numPadView.f6662n);
        numPadView.m6962a(3, numPadView.f6663o);
        if (numPadView.f6666r.length() == 4) {
            numPadView.f6667s.m6971a(numPadView.f6666r.toString());
        }
    }

    private void m6962a(int i, View view) {
        GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground();
        if (this.f6666r.length() > i) {
            gradientDrawable.setColor(-1);
        } else {
            gradientDrawable.setColor(Color.rgb(74, 109, 167));
        }
    }

    public final void m6968a(int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) this.f6664p.getLayoutParams();
        layoutParams.setMargins(i, i2, i3, i4);
        this.f6664p.setLayoutParams(layoutParams);
    }

    public final void m6969b() {
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setFillAfter(true);
        this.f6665q.startAnimation(translateAnimation);
        translateAnimation = new AlphaAnimation(0.0f, 1.0f);
        translateAnimation.setDuration(600);
        translateAnimation.setFillAfter(true);
        this.f6664p.startAnimation(translateAnimation);
    }

    public final void m6970c() {
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setFillAfter(true);
        this.f6665q.startAnimation(translateAnimation);
        translateAnimation = new AlphaAnimation(1.0f, 0.0f);
        translateAnimation.setDuration(600);
        translateAnimation.setFillAfter(true);
        this.f6664p.startAnimation(translateAnimation);
    }
}
