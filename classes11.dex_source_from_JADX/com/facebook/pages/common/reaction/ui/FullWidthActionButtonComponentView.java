package com.facebook.pages.common.reaction.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.facebook.resources.ui.FbButton;
import com.facebook.widget.CustomViewUtils;

/* compiled from: section_tracking */
public class FullWidthActionButtonComponentView extends FrameLayout {
    public final FbButton f2139a = ((FbButton) findViewById(2131562425));

    public FullWidthActionButtonComponentView(Context context) {
        super(context);
        View.inflate(context, 2130904548, this);
    }

    public final void m3164a(String str, String str2, String str3, String str4, OnClickListener onClickListener) {
        this.f2139a.setOnClickListener(onClickListener);
        this.f2139a.setText(str);
        this.f2139a.setTextColor(Color.parseColor("#" + str3));
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#" + str2));
        gradientDrawable.setStroke(3, Color.parseColor("#" + str4));
        CustomViewUtils.b(this.f2139a, gradientDrawable);
    }
}
