package com.facebook.payments.ui;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.text.BetterTextView;

/* compiled from: structured_menu_viewer */
public class SingleItemInfoView extends PaymentsComponentLinearLayout {
    private final FbDraweeView f1987a;
    private final BetterTextView f1988b;
    private final BetterTextView f1989c;
    private final BetterTextView f1990d;
    private SingleItemInfoViewParams f1991e;

    public SingleItemInfoView(Context context) {
        this(context, null);
    }

    public SingleItemInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SingleItemInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130907123);
        setOrientation(0);
        this.f1987a = (FbDraweeView) a(2131562510);
        this.f1988b = (BetterTextView) a(2131559636);
        this.f1989c = (BetterTextView) a(2131562884);
        this.f1990d = (BetterTextView) a(2131567477);
    }

    public void setViewParams(SingleItemInfoViewParams singleItemInfoViewParams) {
        this.f1991e = singleItemInfoViewParams;
        if (StringUtil.a(this.f1991e.f1992a)) {
            this.f1987a.setVisibility(8);
        } else {
            this.f1987a.a(Uri.parse(this.f1991e.f1992a), CallerContext.a(SingleItemInfoView.class));
            this.f1987a.setVisibility(0);
            LayoutParams layoutParams = this.f1987a.getLayoutParams();
            layoutParams.width = Math.round(this.f1991e.f1993b);
            layoutParams.height = Math.round(this.f1991e.f1993b);
            this.f1987a.setLayoutParams(layoutParams);
        }
        m2220a(this.f1988b, this.f1991e.f1994c);
        m2220a(this.f1989c, this.f1991e.f1995d);
        m2220a(this.f1990d, this.f1991e.f1996e);
    }

    private static void m2220a(BetterTextView betterTextView, String str) {
        if (StringUtil.a(str)) {
            betterTextView.setVisibility(8);
            return;
        }
        betterTextView.setText(str);
        betterTextView.setVisibility(0);
    }
}
