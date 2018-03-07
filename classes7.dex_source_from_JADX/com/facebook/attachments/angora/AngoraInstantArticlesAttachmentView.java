package com.facebook.attachments.angora;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.multirow.api.ViewType;
import javax.annotation.Nullable;

/* compiled from: videoDelete */
public class AngoraInstantArticlesAttachmentView extends AngoraAttachmentView implements AttachmentHasArticleIcon, AttachmentHasTooltipAnchor {
    public static final ViewType f632c = new C00601();
    private final InstantArticleIconView f633e;

    /* compiled from: videoDelete */
    final class C00601 extends ViewType {
        C00601() {
        }

        public final View m722a(Context context) {
            return new AngoraInstantArticlesAttachmentView(context);
        }
    }

    public AngoraInstantArticlesAttachmentView(Context context) {
        this(context, null);
    }

    private AngoraInstantArticlesAttachmentView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private AngoraInstantArticlesAttachmentView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 2130903248);
        this.f633e = (InstantArticleIconView) a(2131559577);
    }

    public void setLargeImageAspectRatio(float f) {
        super.setLargeImageAspectRatio(f);
        this.f633e.setAspectRatio(f);
    }

    public void setLargeImageController(@Nullable DraweeController draweeController) {
        super.setLargeImageController(draweeController);
        if (this.f633e.getVisibility() == 0) {
            this.f633e.setVisibility(0);
            this.f633e.setController(draweeController);
            return;
        }
        this.f633e.setVisibility(8);
    }

    public void setCoverPhotoArticleIconVisibility(int i) {
        this.f633e.setVisibility(i);
    }

    public View getTooltipAnchor() {
        return this.f633e;
    }
}
