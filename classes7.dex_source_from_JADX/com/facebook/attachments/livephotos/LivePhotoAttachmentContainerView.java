package com.facebook.attachments.livephotos;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.attachments.photos.ui.HasPhotoAttachment;
import com.facebook.attachments.photos.ui.HasPhotoAttachment.OnPhotoClickListener;
import com.facebook.attachments.photos.ui.PhotoAttachmentViewHelper;
import com.facebook.attachments.photos.ui.PhotoAttachmentViewHelperProvider;
import com.facebook.attachments.photos.ui.PostPostBadge;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.livephotos.LivePhotoView;
import com.facebook.widget.CustomViewUtils;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: crowdsourcing_feather */
public class LivePhotoAttachmentContainerView extends LivePhotoView implements HasPhotoAttachment {
    @Inject
    public PhotoAttachmentViewHelperProvider f16516e;
    public PostPostBadge f16517f = new PostPostBadge(getContext());
    public PhotoAttachmentViewHelper f16518g;

    public static void m20586a(Object obj, Context context) {
        ((LivePhotoAttachmentContainerView) obj).f16516e = (PhotoAttachmentViewHelperProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(PhotoAttachmentViewHelperProvider.class);
    }

    public LivePhotoAttachmentContainerView(Context context) {
        super(context);
        Class cls = LivePhotoAttachmentContainerView.class;
        m20586a((Object) this, getContext());
        setId(2131558550);
        getUnderlyingDraweeView().setId(2131565875);
        addView(this.f16517f);
        this.f16518g = this.f16516e.a(this, this, this.f16517f);
        Resources resources = getResources();
        Drawable drawable = resources.getDrawable(2131362786);
        AutoRotateDrawable autoRotateDrawable = new AutoRotateDrawable(resources.getDrawable(2130844043), 1000);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        genericDraweeHierarchyBuilder.f = drawable;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder2 = genericDraweeHierarchyBuilder;
        genericDraweeHierarchyBuilder2.h = resources.getDrawable(2130840253);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder3 = genericDraweeHierarchyBuilder2;
        genericDraweeHierarchyBuilder3.l = autoRotateDrawable;
        getUnderlyingDraweeView().setHierarchy(genericDraweeHierarchyBuilder3.e(ScaleType.h).u());
    }

    public void setOnPhotoClickListener(@Nullable OnPhotoClickListener onPhotoClickListener) {
        this.f16518g.e = onPhotoClickListener;
    }

    public void setOnBadgeClickListener(@Nullable OnPhotoClickListener onPhotoClickListener) {
        this.f16518g.f = onPhotoClickListener;
    }

    public final void m20588a(@Nullable String str, int i) {
        this.f16518g.a(str, i);
    }

    public void setPhotoBackground(Drawable drawable) {
        CustomViewUtils.b(this, drawable);
    }

    public void setPairedVideoUri(String str) {
        setVideoUri(str);
    }

    public final void m20587a(int i, int i2) {
        this.f16518g.a(i, i2);
    }

    public View getPhotoAttachmentView() {
        return this;
    }

    @VisibleForTesting
    public PostPostBadge getPostPostBadge() {
        return this.f16517f;
    }

    public GenericDraweeView getUnderlyingDraweeView() {
        return this.f6606i;
    }

    public void setActualImageFocusPoint(PointF pointF) {
        ((GenericDraweeHierarchy) this.f6606i.getHierarchy()).a(pointF);
    }

    public void setController(DraweeController draweeController) {
        this.f6606i.setController(draweeController);
    }
}
