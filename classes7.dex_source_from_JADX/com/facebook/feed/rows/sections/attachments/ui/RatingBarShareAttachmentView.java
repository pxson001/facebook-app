package com.facebook.feed.rows.sections.attachments.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.attachments.angora.AttachmentHasRating;
import com.facebook.attachments.angora.AttachmentHasSubcontext;
import com.facebook.attachments.angora.actionbutton.GenericActionButtonView;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.rows.sections.attachments.calltoaction.ui.CallToActionAttachmentView;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: VIEWER_COMMERCIAL_BREAK */
public class RatingBarShareAttachmentView extends CustomLinearLayout implements AngoraAttachment, AttachmentHasLargeImage, AttachmentHasRating, AttachmentHasSubcontext {
    public static final ViewType f21085a = new C17901();
    private final FbDraweeView f21086b = ((FbDraweeView) a(2131567570));
    private final CallToActionAttachmentView f21087c = ((CallToActionAttachmentView) a(2131567571));

    /* compiled from: VIEWER_COMMERCIAL_BREAK */
    final class C17901 extends ViewType {
        C17901() {
        }

        public final View m23964a(Context context) {
            return new RatingBarShareAttachmentView(context);
        }
    }

    public RatingBarShareAttachmentView(Context context) {
        super(context);
        setContentView(2130907193);
        setOrientation(1);
        this.f21086b.setAspectRatio(1.9318181f);
        Resources resources = getResources();
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        genericDraweeHierarchyBuilder.f = resources.getDrawable(2131362786);
        this.f21086b.setHierarchy(genericDraweeHierarchyBuilder.u());
    }

    public void setLargeImageAspectRatio(float f) {
        this.f21086b.setAspectRatio(f);
    }

    public void setLargeImageController(@Nullable DraweeController draweeController) {
        this.f21086b.setVisibility(draweeController != null ? 0 : 8);
        this.f21086b.setController(draweeController);
    }

    public void setSideImageController(@Nullable DraweeController draweeController) {
        this.f21087c.setSideImageController(draweeController);
    }

    public final void m23965a() {
        this.f21087c.m23815a();
    }

    public void setActionButtonOnClickListener(OnClickListener onClickListener) {
        this.f21087c.setActionButtonOnClickListener(onClickListener);
    }

    public GenericActionButtonView getActionButton() {
        return this.f21087c.getActionButton();
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.f21087c.setTitle(charSequence);
    }

    public void setContextText(@Nullable CharSequence charSequence) {
        this.f21087c.setContextText(charSequence);
    }

    public void setRating(float f) {
        this.f21087c.setRating(f);
    }

    public void setNumberOfStars(int i) {
        this.f21087c.setNumberOfStars(i);
    }

    public void setShowRating(boolean z) {
        this.f21087c.setShowRating(z);
    }

    public void setSubcontextText(@Nullable CharSequence charSequence) {
        this.f21087c.setSubcontextText(charSequence);
    }
}
