package com.facebook.productionprompts.common.v3;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.productionprompts.common.views.HasPromptTitleBar;
import com.facebook.widget.text.BetterTextView;

/* compiled from: request_privacy */
public class OverlappingImageBlockLayout extends ImageBlockLayout implements HasPromptTitleBar {
    private final BetterTextView f4511h;
    private final BetterTextView f4512i;
    private final OverlappingImageView f4513j;

    public OverlappingImageBlockLayout(Context context) {
        this(context, null);
    }

    private OverlappingImageBlockLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private OverlappingImageBlockLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905944);
        setGravity(16);
        setThumbnailGravity(16);
        this.f4513j = (OverlappingImageView) getView(2131565299);
        this.f4513j.setRotateDegree(10);
        this.f4513j.m4376a(getResources().getColor(2131361920), getResources().getDimensionPixelSize(2131430428));
        this.f4511h = (BetterTextView) getView(2131565300);
        this.f4512i = (BetterTextView) getView(2131565301);
    }

    public BetterTextView getPromptTitleView() {
        return this.f4511h;
    }

    public BetterTextView getPromptSubtitleView() {
        return this.f4512i;
    }

    public final void m4373a(ImageHolder imageHolder, ImageHolder imageHolder2) {
        this.f4513j.m4377a(imageHolder, imageHolder2);
    }
}
