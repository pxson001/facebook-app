package com.facebook.feedplugins.greetingcard;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.view.View.MeasureSpec;
import android.widget.AbsListView.LayoutParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: debug_id */
public class GreetingCardView extends CustomFrameLayout {
    public static final CallerContext f7746a = CallerContext.a(GreetingCardView.class, "greeting_cards");
    public FbDraweeView f7747b = ((FbDraweeView) c(2131562612));
    public FbDraweeView f7748c = ((FbDraweeView) c(2131562610));
    public BetterTextView f7749d = ((BetterTextView) c(2131562613));

    public GreetingCardView(Context context) {
        super(context);
        Class cls = GreetingCardView.class;
        FbDraweeControllerBuilder.b(FbInjector.get(getContext()));
        setLayoutParams(new LayoutParams(-1, -2));
        setContentView(2130904634);
        c(2131562609).setBackgroundResource(2130840616);
        if (VERSION.SDK_INT >= 16) {
            this.f7749d.setTypeface(Typeface.create("sans-serif-light", 0));
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int round = Math.round(((float) measuredWidth) * 0.75f);
        if (round > measuredHeight) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), MeasureSpec.makeMeasureSpec(round, 1073741824));
        }
    }
}
