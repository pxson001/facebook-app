package com.facebook.fig.attachment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AttachmentHasArticleIcon;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.attachments.angora.AttachmentHasPlayIcon;
import com.facebook.attachments.angora.AttachmentHasRating;
import com.facebook.attachments.angora.AttachmentHasSubcontext;
import com.facebook.attachments.angora.AttachmentHasTooltipAnchor;
import com.facebook.attachments.angora.actionbutton.GenericActionButtonView;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.dialtone.DialtoneController.FeatureType;
import com.facebook.dialtone.common.IsDialtonePhotoFeatureEnabled;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.fbpipeline.DegradableDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.fbui.feed.attachment.AttachmentView;
import com.facebook.fbui.textcachewarmer.FbTextLayoutCacheWarmer;
import com.facebook.fbui.widget.layout.ImageBlockLayout.LayoutParams;
import com.facebook.feed.rows.sections.header.ui.HasClickableProfileImage;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.multirow.api.ViewType;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: privacy_scope */
public class FIGAttachmentView extends AttachmentView implements AngoraAttachment, AttachmentHasArticleIcon, AttachmentHasLargeImage, AttachmentHasPlayIcon, AttachmentHasRating, AttachmentHasSubcontext, AttachmentHasTooltipAnchor, HasClickableProfileImage {
    public static final ViewType f4166h = new 1();
    @Inject
    public AnalyticsTagger f4167i;
    @Inject
    @IsDialtonePhotoFeatureEnabled
    public Provider<Boolean> f4168j;
    @Inject
    public FbTextLayoutCacheWarmer f4169k;
    @Inject
    public FbZeroFeatureVisibilityHelper f4170l;
    private boolean f4171m;
    public boolean f4172n;

    public static void m4710a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FIGAttachmentView fIGAttachmentView = (FIGAttachmentView) obj;
        AnalyticsTagger a = AnalyticsTagger.a(fbInjector);
        Provider a2 = IdBasedProvider.a(fbInjector, 3959);
        FbTextLayoutCacheWarmer a3 = FbTextLayoutCacheWarmer.a(fbInjector);
        FbZeroFeatureVisibilityHelper a4 = FbZeroFeatureVisibilityHelper.a(fbInjector);
        fIGAttachmentView.f4167i = a;
        fIGAttachmentView.f4168j = a2;
        fIGAttachmentView.f4169k = a3;
        fIGAttachmentView.f4170l = a4;
    }

    public FIGAttachmentView(Context context) {
        this(context, null);
    }

    private FIGAttachmentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FIGAttachmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4171m = false;
        Class cls = FIGAttachmentView.class;
        m4710a(this, getContext());
        this.f4167i.a(this, "newsfeed_angora_attachment_view", getClass());
        TrackingNodes.a(this, TrackingNode.ATTACHMENT);
        FbTextLayoutCacheWarmer fbTextLayoutCacheWarmer = this.f4169k;
        this.f4197p.a(fbTextLayoutCacheWarmer);
        this.f4198q.a(fbTextLayoutCacheWarmer);
        this.f4199r.a(fbTextLayoutCacheWarmer);
        this.f4171m = ((Boolean) this.f4168j.get()).booleanValue();
        Object genericActionButtonView = new GenericActionButtonView(context);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.b = true;
        genericActionButtonView.setLayoutParams(layoutParams);
        addView(genericActionButtonView);
    }

    public final void mo341a() {
        m4720b();
        setShowThumbnail(false);
        this.f4172n = false;
        View view = this.a;
        if (view != null && (view instanceof GenericActionButtonView)) {
            ((GenericActionButtonView) view).m14490a();
        }
    }

    public void setSideImageController(@Nullable DraweeController draweeController) {
        setThumbnailController(draweeController);
        setShowThumbnail(draweeController != null);
    }

    public void setLargeImageAspectRatio(float f) {
        if (this.f4171m) {
            f = 1.9318181f;
        }
        if (this.f4196o != f) {
            this.f4196o = f;
            requestLayout();
            invalidate();
        }
    }

    public void setLargeImageController(@Nullable DraweeController draweeController) {
        if ((draweeController instanceof DegradableDraweeController) && this.f4172n) {
            ((DegradableDraweeController) draweeController).m4727a(0, FeatureType.LINK);
        }
        setCoverDrawableController(draweeController);
    }

    protected final DraweeHolder<GenericDraweeHierarchy> m4712e() {
        Context context = getContext();
        Resources resources = context.getResources();
        Drawable colorDrawable = new ColorDrawable(-1973013);
        AutoRotateDrawable autoRotateDrawable = new AutoRotateDrawable(resources.getDrawable(2130844043), 1000);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        genericDraweeHierarchyBuilder.f = colorDrawable;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder2 = genericDraweeHierarchyBuilder;
        genericDraweeHierarchyBuilder2.l = autoRotateDrawable;
        return DraweeHolder.a(genericDraweeHierarchyBuilder2.u(), context);
    }

    protected final DraweeHolder<GenericDraweeHierarchy> mo342f() {
        Context context = getContext();
        Resources resources = context.getResources();
        Drawable colorDrawable = new ColorDrawable(-1973013);
        AutoRotateDrawable autoRotateDrawable = new AutoRotateDrawable(resources.getDrawable(2130844043), 1000);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        genericDraweeHierarchyBuilder.f = colorDrawable;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder2 = genericDraweeHierarchyBuilder;
        genericDraweeHierarchyBuilder2.l = autoRotateDrawable;
        return DraweeHolder.a(genericDraweeHierarchyBuilder2.u(), context);
    }

    protected float getDefaultCoverDrawableAspectRatio() {
        return 1.9318181f;
    }

    public void setCoverPhotoPlayIconVisibility(int i) {
        boolean z;
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z != this.f4206y) {
            if (z && this.f4203v == null) {
                this.f4203v = getResources().getDrawable(2130840027);
            }
            this.f4206y = z;
            requestLayout();
            invalidate();
        }
    }

    public void setSidePhotoPlayIconVisibility(int i) {
        boolean z;
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z != this.f4207z) {
            if (z && this.f4204w == null) {
                this.f4204w = getResources().getDrawable(2130839996);
            }
            this.f4207z = z;
            setOverlayDrawable(z ? this.f4204w : null);
        }
    }

    public void setNumberOfStars(int i) {
    }

    public void setCoverPhotoArticleIconVisibility(int i) {
        if (!this.f4170l.a(ZeroFeatureKey.EXTERNAL_URLS_INTERSTITIAL)) {
            boolean z;
            Drawable drawable = getResources().getDrawable(2130840803);
            if (this.f4184J != drawable) {
                this.f4184J = drawable;
                if (this.f4185K) {
                    requestLayout();
                    invalidate();
                }
            }
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            if (this.f4185K != z) {
                this.f4185K = z;
                if (z) {
                    requestLayout();
                }
                invalidate();
            }
        }
    }

    public View getTooltipAnchor() {
        return null;
    }

    public void setProfileImageOnClickListener(OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.f4197p.a(charSequence);
        requestLayout();
        invalidate();
    }

    public void setContextText(@Nullable CharSequence charSequence) {
        this.f4198q.a(charSequence);
        requestLayout();
        invalidate();
    }

    public void setSubcontextText(@Nullable CharSequence charSequence) {
        this.f4199r.a(charSequence);
        requestLayout();
        invalidate();
    }

    public GenericActionButtonView getActionButton() {
        return (GenericActionButtonView) this.a;
    }

    public void setActionButtonOnClickListener(OnClickListener onClickListener) {
        View view = this.a;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }
}
