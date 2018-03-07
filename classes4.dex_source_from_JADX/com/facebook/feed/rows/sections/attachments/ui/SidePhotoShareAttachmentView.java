package com.facebook.feed.rows.sections.attachments.ui;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.facebook.attachments.angora.AttachmentHasClear;
import com.facebook.attachments.angora.AttachmentHasLabel;
import com.facebook.attachments.angora.AttachmentHasSideImage;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import javax.annotation.Nullable;

/* compiled from: not external file dir */
public abstract class SidePhotoShareAttachmentView extends ImageBlockLayout implements AttachmentHasClear, AttachmentHasLabel, AttachmentHasSideImage {
    private final FbDraweeView f7001h = ((FbDraweeView) getView(2131566177));
    private final TextView f7002i = ((TextView) getView(2131559571));
    private final TextView f7003j = ((TextView) getView(2131559572));

    public SidePhotoShareAttachmentView(Context context, int i) {
        super(context);
        setContentView(i);
    }

    public void setSideImageController(@Nullable DraweeController draweeController) {
        this.f7001h.setController(draweeController);
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        m7288a(this.f7002i, charSequence);
    }

    public void setContextText(@Nullable CharSequence charSequence) {
        m7288a(this.f7003j, charSequence);
    }

    public final void mo341a() {
    }

    private static void m7288a(TextView textView, CharSequence charSequence) {
        textView.setVisibility(!TextUtils.isEmpty(charSequence) ? 0 : 8);
        textView.setText(charSequence);
    }
}
