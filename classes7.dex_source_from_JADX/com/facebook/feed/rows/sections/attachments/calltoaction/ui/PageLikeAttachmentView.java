package com.facebook.feed.rows.sections.attachments.calltoaction.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.attachments.angora.AttachmentHasClear;
import com.facebook.attachments.angora.AttachmentHasLabel;
import com.facebook.attachments.angora.actionbutton.GenericActionButtonView;
import com.facebook.feed.rows.sections.header.ui.HasClickableProfileImage;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: WATCHING_LIVE */
public class PageLikeAttachmentView extends CustomLinearLayout implements AttachmentHasButton, AttachmentHasClear, AttachmentHasLabel, HasClickableProfileImage {
    private View f20900a = a(2131568374);
    private TextView f20901b = ((TextView) a(2131568375));
    private TextView f20902c = ((TextView) a(2131568376));
    private GenericActionButtonView f20903d = ((GenericActionButtonView) a(2131568377));

    public PageLikeAttachmentView(Context context) {
        super(context);
        setContentView(2130907693);
        TrackingNodes.a(this.f20900a, TrackingNode.ATTACHMENT);
        TrackingNodes.a(this.f20903d, TrackingNode.ACTION_ICON);
    }

    public void setProfileImageOnClickListener(OnClickListener onClickListener) {
        this.f20900a.setOnClickListener(onClickListener);
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.f20901b.setText(charSequence);
        this.f20901b.setVisibility(charSequence != null ? 0 : 8);
    }

    public void setContextText(@Nullable CharSequence charSequence) {
        this.f20902c.setText(charSequence);
        this.f20902c.setVisibility(charSequence != null ? 0 : 8);
    }

    public void setActionButtonOnClickListener(OnClickListener onClickListener) {
        this.f20903d.setOnClickListener(onClickListener);
    }

    public GenericActionButtonView getActionButton() {
        return this.f20903d;
    }

    public final void m23821a() {
    }
}
