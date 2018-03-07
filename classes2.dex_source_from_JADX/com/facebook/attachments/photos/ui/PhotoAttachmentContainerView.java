package com.facebook.attachments.photos.ui;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.attachments.photos.ui.HasPhotoAttachment.OnPhotoClickListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomViewUtils;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: graphql_error_code */
public class PhotoAttachmentContainerView extends RelativeLayout implements HasPhotoAttachment {
    @Inject
    public PhotoAttachmentViewHelperProvider f21939a;
    public PhotoAttachmentView f21940b = ((PhotoAttachmentView) findViewById(2131565875));
    public PostPostBadge f21941c = ((PostPostBadge) findViewById(2131565876));
    public PhotoAttachmentViewHelper f21942d = this.f21939a.m29750a(this, this.f21940b, this.f21941c);

    public static void m29745a(Object obj, Context context) {
        ((PhotoAttachmentContainerView) obj).f21939a = (PhotoAttachmentViewHelperProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(PhotoAttachmentViewHelperProvider.class);
    }

    public PhotoAttachmentContainerView(Context context) {
        super(context);
        Class cls = PhotoAttachmentContainerView.class;
        m29745a((Object) this, getContext());
        setId(2131558550);
        LayoutInflater.from(getContext()).inflate(2130906186, this, true);
    }

    public void setOnPhotoClickListener(@Nullable OnPhotoClickListener onPhotoClickListener) {
        this.f21942d.f21963e = onPhotoClickListener;
    }

    public void setOnBadgeClickListener(@Nullable OnPhotoClickListener onPhotoClickListener) {
        this.f21942d.f21964f = onPhotoClickListener;
    }

    public final void mo3214a(@Nullable String str, int i) {
        this.f21942d.m29765a(str, i);
    }

    public void setController(DraweeController draweeController) {
        this.f21940b.setController(draweeController);
    }

    public void setActualImageFocusPoint(PointF pointF) {
        ((GenericDraweeHierarchy) this.f21940b.getHierarchy()).m20597a(pointF);
    }

    public void setPhotoBackground(Drawable drawable) {
        CustomViewUtils.m30286b(this.f21940b, drawable);
    }

    public void setPairedVideoUri(String str) {
    }

    public GenericDraweeView getUnderlyingDraweeView() {
        return this.f21940b;
    }

    public View getPhotoAttachmentView() {
        return this.f21940b;
    }

    public final void mo3213a(int i, int i2) {
        this.f21942d.m29763a(i, i2);
    }

    @VisibleForTesting
    public PostPostBadge getPostPostBadge() {
        return this.f21941c;
    }
}
