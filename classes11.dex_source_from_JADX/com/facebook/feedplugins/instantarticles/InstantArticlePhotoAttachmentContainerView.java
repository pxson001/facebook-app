package com.facebook.feedplugins.instantarticles;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import com.facebook.attachments.angora.AttachmentHasArticleIcon;
import com.facebook.attachments.angora.AttachmentHasTooltipAnchor;
import com.facebook.attachments.angora.InstantArticleIconView;
import com.facebook.attachments.photos.ui.PhotoAttachmentContainerView;
import com.facebook.multirow.api.ViewType;

/* compiled from: context_rows_shown_in_header */
public class InstantArticlePhotoAttachmentContainerView extends PhotoAttachmentContainerView implements AttachmentHasArticleIcon, AttachmentHasTooltipAnchor {
    public static final ViewType f7975b = new C10071();
    public InstantArticleIconView f7976c = new InstantArticleIconView(getContext());

    /* compiled from: context_rows_shown_in_header */
    final class C10071 extends ViewType {
        C10071() {
        }

        public final View m9051a(Context context) {
            return new InstantArticlePhotoAttachmentContainerView(context);
        }
    }

    public InstantArticlePhotoAttachmentContainerView(Context context) {
        super(context);
        this.f7976c.setBackgroundColor(0);
        this.f7976c.setScaleType(ScaleType.CENTER_CROP);
        this.f7976c.setId(2131558596);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131430185);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131427635);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(2131427634);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.setMargins(0, dimensionPixelSize2, dimensionPixelSize3, 0);
        layoutParams.addRule(11);
        layoutParams.addRule(21);
        layoutParams.addRule(10);
        addView(this.f7976c, layoutParams);
        getPhotoAttachmentView().setFocusable(false);
        getPhotoAttachmentView().setClickable(false);
    }

    public void setCoverPhotoArticleIconVisibility(int i) {
        this.f7976c.setVisibility(i);
    }

    public View getTooltipAnchor() {
        return this.f7976c;
    }
}
