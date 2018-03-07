package com.facebook.feed.rows.sections.attachments.calltoaction.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RatingBar;
import android.widget.TextView;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AttachmentHasRating;
import com.facebook.attachments.angora.AttachmentHasSubcontext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.widget.CustomRelativeLayout;
import javax.annotation.Nullable;

/* compiled from: WAVE */
public abstract class CallToActionAttachmentViewBase extends CustomRelativeLayout implements AngoraAttachment, AttachmentHasRating, AttachmentHasSubcontext {
    protected FbDraweeView f20885b;
    protected TextView f20886c;
    protected TextView f20887d;
    protected TextView f20888e;
    protected RatingBar f20889f;

    public CallToActionAttachmentViewBase(Context context) {
        this(context, null);
    }

    public CallToActionAttachmentViewBase(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        TrackingNodes.a(this, TrackingNode.ATTACHMENT);
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.f20886c.setText(charSequence);
        this.f20886c.setVisibility(charSequence != null ? 0 : 8);
    }

    public void setContextText(@Nullable CharSequence charSequence) {
        this.f20887d.setText(charSequence);
        this.f20887d.setVisibility(charSequence != null ? 0 : 8);
    }

    public void setSubcontextText(@Nullable CharSequence charSequence) {
        this.f20888e.setText(charSequence);
        this.f20888e.setVisibility(charSequence != null ? 0 : 8);
    }

    public void setRating(float f) {
        this.f20889f.setRating(f);
    }

    public void setNumberOfStars(int i) {
        this.f20889f.setNumStars(i);
    }

    public void setShowRating(boolean z) {
        RatingBar ratingBar;
        int i = 1;
        int i2 = 0;
        if (z) {
            if (this.f20886c == null || this.f20886c.getLineCount() <= 1) {
                i = 0;
            }
            RatingBar ratingBar2 = this.f20889f;
            if (i != 0) {
                i2 = 8;
                ratingBar = ratingBar2;
            } else {
                ratingBar = ratingBar2;
            }
        } else {
            ratingBar = this.f20889f;
            i2 = 8;
        }
        ratingBar.setVisibility(i2);
    }

    public void setSideImageController(@Nullable DraweeController draweeController) {
        this.f20885b.setVisibility(draweeController != null ? 0 : 8);
        this.f20885b.setController(draweeController);
    }

    public final void m23815a() {
        setTitle(null);
        setContextText(null);
        setSubcontextText(null);
        setShowRating(false);
        setRating(0.0f);
        setNumberOfStars(0);
        setSideImageController(null);
    }
}
