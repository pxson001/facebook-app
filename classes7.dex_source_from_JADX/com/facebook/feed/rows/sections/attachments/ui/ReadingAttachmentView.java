package com.facebook.feed.rows.sections.attachments.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.attachments.angora.AttachmentHasClear;
import com.facebook.attachments.angora.actionbutton.GenericActionButtonView;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: VIEW VIDEOS */
public class ReadingAttachmentView extends CustomFrameLayout implements AttachmentHasButton, AttachmentHasClear {
    private final FbDraweeView f21088a = ((FbDraweeView) c(2131566804));
    private final TextView f21089b = ((TextView) c(2131566805));
    private final TextView f21090c = ((TextView) c(2131566806));
    private final GenericActionButtonView f21091d = ((GenericActionButtonView) c(2131559573));

    public ReadingAttachmentView(Context context) {
        super(context);
        setContentView(2130906731);
        TrackingNodes.a(this, TrackingNode.ATTACHMENT);
    }

    public void setSideImageController(@Nullable DraweeController draweeController) {
        this.f21088a.setVisibility(draweeController != null ? 0 : 8);
        this.f21088a.setController(draweeController);
    }

    public void setText(@Nullable CharSequence charSequence) {
        m23966a(this.f21089b, charSequence);
    }

    public void setLikesCountText(@Nullable CharSequence charSequence) {
        m23966a(this.f21090c, charSequence);
    }

    public void setActionButtonOnClickListener(OnClickListener onClickListener) {
        this.f21091d.a.setOnClickListener(onClickListener);
    }

    public GenericActionButtonView getActionButton() {
        return this.f21091d;
    }

    public final void m23967a() {
        this.f21091d.a();
    }

    private static void m23966a(TextView textView, @Nullable CharSequence charSequence) {
        textView.setVisibility(!TextUtils.isEmpty(charSequence) ? 0 : 8);
        textView.setText(charSequence);
    }
}
