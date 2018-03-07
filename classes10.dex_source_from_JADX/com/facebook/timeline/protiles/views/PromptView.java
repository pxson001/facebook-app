package com.facebook.timeline.protiles.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.fbui.widget.text.BadgeTextView;
import com.facebook.fbui.widget.text.BadgeTextView.BadgePlacement;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: fb.com/inv?r= */
public class PromptView extends BadgeTextView {
    @Inject
    public RTLUtil f12399a;

    public static void m12446a(Object obj, Context context) {
        ((PromptView) obj).f12399a = RTLUtil.a(FbInjector.get(context));
    }

    public PromptView(Context context) {
        this(context, null);
    }

    private PromptView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Class cls = PromptView.class;
        m12446a(this, getContext());
        setBackgroundResource(2130843637);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131429869);
        setPadding(getResources().getDimensionPixelSize(2131429870), dimensionPixelSize, getResources().getDimensionPixelSize(2131429871), dimensionPixelSize);
        setGravity(16);
        setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131429872));
        Drawable a = this.f12399a.a(2130838066);
        if (this.f12399a.a()) {
            setCompoundDrawablesWithIntrinsicBounds(a, null, null, null);
        } else {
            setCompoundDrawablesWithIntrinsicBounds(null, null, a, null);
        }
        setTextAppearance(context, 2131625431);
        a(context, 2131625432);
        setBadgeBackground(2130843640);
        setBadgePlacement(BadgePlacement.AWAY_FROM_TEXT);
    }
}
