package com.facebook.productionprompts.common.v3;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.productionprompts.common.views.HasPromptTitleBar;
import com.facebook.widget.text.BetterTextView;
import com.google.common.annotations.VisibleForTesting;

/* compiled from: request_params */
public class ProductionPromptSmallView extends ImageBlockLayout implements HasPromptTitleBar {
    private final FbDraweeView f4522h;
    private final BetterTextView f4523i;
    private final BetterTextView f4524j;
    public final BetterTextView f4525k;

    public ProductionPromptSmallView(Context context) {
        this(context, null);
    }

    private ProductionPromptSmallView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ProductionPromptSmallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130906424);
        this.f4522h = (FbDraweeView) getView(2131565299);
        this.f4523i = (BetterTextView) getView(2131565300);
        this.f4524j = (BetterTextView) getView(2131565301);
        this.f4525k = (BetterTextView) getView(2131566332);
        setGravity(16);
        setThumbnailGravity(16);
    }

    public final void m4378a(Uri uri, CallerContext callerContext) {
        this.f4522h.a(uri, callerContext);
    }

    public BetterTextView getPromptTitleView() {
        return this.f4523i;
    }

    public BetterTextView getPromptSubtitleView() {
        return this.f4524j;
    }

    @VisibleForTesting
    View getCallToActionView() {
        return this.f4525k;
    }
}
