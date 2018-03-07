package com.facebook.backstage.consumption.audience;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.awesomizer.ui.AwesomizerGridItemView;
import com.facebook.resources.ui.FbTextView;

/* compiled from: rr */
public class PrivacySettingsItemView extends AwesomizerGridItemView {
    private final FbDraweeView f4674b;
    private final FbTextView f4675c;
    private final Drawable f4676d;

    public PrivacySettingsItemView(Context context) {
        this(context, null);
    }

    public PrivacySettingsItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4676d = getResources().getDrawable(2130838055);
        this.f4674b = (FbDraweeView) FindViewUtil.b(this, 2131559791);
        this.f4675c = (FbTextView) FindViewUtil.b(this, 2131559793);
        this.f4675c.setTextColor(getResources().getColor(17170443));
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (isSelected()) {
            int right = (int) (((float) this.f4674b.getRight()) * 0.9f);
            this.f4676d.setBounds(right, this.f4674b.getHeight() - this.f4676d.getIntrinsicHeight(), this.f4676d.getIntrinsicWidth() + right, this.f4674b.getHeight());
            this.f4676d.draw(canvas);
        }
    }
}
