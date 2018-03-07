package com.facebook.feedplugins.instantarticles;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import com.facebook.attachments.angora.AttachmentHasArticleIcon;
import com.facebook.attachments.angora.AttachmentHasTooltipAnchor;
import com.facebook.attachments.angora.InstantArticleIconView;
import com.facebook.feedplugins.video.RichVideoAttachmentView;
import com.facebook.multirow.api.ViewType;

/* compiled from: content-type */
public class InstantArticlesRichVideoAttachmentView extends RichVideoAttachmentView implements AttachmentHasArticleIcon, AttachmentHasTooltipAnchor {
    public static final ViewType f7984c = new C10081();
    public InstantArticleIconView f7985d;

    /* compiled from: content-type */
    final class C10081 extends ViewType {
        C10081() {
        }

        public final View m9060a(Context context) {
            return new InstantArticlesRichVideoAttachmentView(context);
        }
    }

    public InstantArticlesRichVideoAttachmentView(Context context) {
        this(context, null);
    }

    private InstantArticlesRichVideoAttachmentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private InstantArticlesRichVideoAttachmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7985d = new InstantArticleIconView(getContext());
        this.f7985d.setBackgroundColor(0);
        this.f7985d.setScaleType(ScaleType.CENTER_CROP);
        this.f7985d.setId(2131558596);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131430185);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131427635);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(2131427634);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.setMargins(0, dimensionPixelSize2, dimensionPixelSize3, 0);
        layoutParams.addRule(11);
        layoutParams.addRule(21);
        layoutParams.addRule(10);
        addView(this.f7985d, layoutParams);
    }

    public void setCoverPhotoArticleIconVisibility(int i) {
        this.f7985d.setVisibility(i);
    }

    public View getTooltipAnchor() {
        return this.f7985d;
    }
}
