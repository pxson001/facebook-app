package com.facebook.feedplugins.socialgood;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: bridgeStartupTime */
public class FundraiserPageAttachmentHeaderView extends CustomRelativeLayout {
    public static final CallerContext f9461a = CallerContext.a(FundraiserPageAttachmentHeaderView.class);
    public FbTextView f9462b = ((FbTextView) a(2131562462));
    public FbTextView f9463c = ((FbTextView) a(2131562463));
    public FbDraweeView f9464d;
    public FbDraweeView f9465e;

    public FundraiserPageAttachmentHeaderView(Context context) {
        super(context);
        setContentView(2130904563);
        this.f9463c.setTextSize(0, (float) getResources().getDimensionPixelSize(2131434658));
        this.f9464d = (FbDraweeView) a(2131562460);
        this.f9465e = (FbDraweeView) a(2131562461);
        Resources resources = getResources();
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        genericDraweeHierarchyBuilder.f = resources.getDrawable(2131361934);
        this.f9464d.setHierarchy(genericDraweeHierarchyBuilder.f(resources.getDrawable(2130840522)).e(ScaleType.h).u());
        genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        genericDraweeHierarchyBuilder.f = resources.getDrawable(2131364018);
        this.f9465e.setHierarchy(genericDraweeHierarchyBuilder.e(ScaleType.b).f(resources.getDrawable(2130840525)).u());
    }

    public final void m10003a(boolean z, String str, CharSequence charSequence) {
        int color;
        if (z) {
            color = getResources().getColor(2131364016);
            m10001a(this.f9462b);
            m10001a(this.f9463c);
        } else {
            color = getResources().getColor(2131364017);
            m10002b(this.f9462b);
            m10002b(this.f9463c);
        }
        this.f9462b.setText(str);
        this.f9462b.setTextColor(color);
        this.f9462b.setVisibility(0);
        CharSequence spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
        this.f9463c.setText(spannableStringBuilder);
        this.f9463c.setVisibility(0);
    }

    private void m10001a(TextView textView) {
        textView.setShadowLayer(2.0f, 1.0f, 1.0f, getResources().getColor(2131364019));
    }

    private void m10002b(TextView textView) {
        textView.setShadowLayer(0.0f, 0.0f, 0.0f, getResources().getColor(2131364019));
    }
}
