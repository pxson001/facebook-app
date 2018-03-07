package com.facebook.attachments.photos.ui;

import android.graphics.PointF;
import android.view.View;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import javax.annotation.Nullable;

/* compiled from: graphql_error */
public interface HasPhotoAttachment {

    /* compiled from: graphql_error */
    public interface OnPhotoClickListener {
        <V extends View & HasPhotoAttachment> void mo3222a(V v, boolean z, int i);
    }

    void mo3213a(int i, int i2);

    void mo3214a(@Nullable String str, int i);

    View getPhotoAttachmentView();

    GenericDraweeView getUnderlyingDraweeView();

    void setActualImageFocusPoint(PointF pointF);

    void setController(DraweeController draweeController);

    void setOnBadgeClickListener(@Nullable OnPhotoClickListener onPhotoClickListener);

    void setOnPhotoClickListener(@Nullable OnPhotoClickListener onPhotoClickListener);

    void setPairedVideoUri(String str);
}
