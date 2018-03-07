package com.facebook.attachments.angora;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.dialtone.DialtoneController.FeatureType;
import com.facebook.drawee.fbpipeline.DegradableDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.multirow.api.ViewType;
import javax.annotation.Nullable;

/* compiled from: feed_e2e_load_success */
public class AngoraAttachmentView extends GenericAttachmentView implements AttachmentHasLargeImage, AttachmentHasPlayIcon {
    public static final ViewType f11887a = new C05751();
    public static final ViewType f11888b = new C05762();
    private final CoverPhotoWithPlayIconView f11889c;
    private final ImageBlockLayout f11890e;
    private final Drawable f11891f;
    private boolean f11892g;
    public boolean f11893h;

    /* compiled from: feed_e2e_load_success */
    final class C05751 extends ViewType {
        C05751() {
        }

        public final View m12501a(Context context) {
            return new AngoraAttachmentView(context);
        }
    }

    /* compiled from: feed_e2e_load_success */
    final class C05762 extends ViewType {
        C05762() {
        }

        public final View m12502a(Context context) {
            return new AngoraAttachmentView(context, null, 0, 2130903246);
        }
    }

    public AngoraAttachmentView(Context context) {
        this(context, null);
    }

    public AngoraAttachmentView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AngoraAttachmentView(Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 2130903246);
    }

    protected AngoraAttachmentView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f11889c = (CoverPhotoWithPlayIconView) a(2131559574);
        this.f11890e = (ImageBlockLayout) a(2131559575);
        this.f11891f = getResources().getDrawable(2130841522);
    }

    public void setLargeImageAspectRatio(float f) {
        this.f11889c.setAspectRatio(f);
    }

    public void setLargeImageController(@Nullable DraweeController draweeController) {
        this.f11889c.setVisibility(draweeController != null ? 0 : 8);
        if ((draweeController instanceof DegradableDraweeController) && this.f11893h) {
            ((DegradableDraweeController) draweeController).m4727a(0, FeatureType.LINK);
        }
        this.f11889c.setController(draweeController);
    }

    public void setCoverPhotoPlayIconVisibility(int i) {
        this.f11889c.f13753d = i == 0;
    }

    public void setSidePhotoPlayIconVisibility(int i) {
        boolean z = i == 0;
        this.f11892g = z;
        this.f11890e.setOverlayDrawable(z ? this.f11891f : null);
    }

    public final void mo341a() {
        super.mo341a();
        this.f11893h = false;
        setOnClickListener(null);
        setLargeImageController(null);
        setCoverPhotoPlayIconVisibility(8);
        setSidePhotoPlayIconVisibility(8);
    }

    public void setIsLinkAttachment(boolean z) {
        this.f11893h = z;
    }
}
