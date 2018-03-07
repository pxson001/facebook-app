package com.facebook.fbui.widget.layout;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.drawee.view.DraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomViewGroup;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: messenger_audio_recorder_android */
public class ViewGroupWithDraweeView extends CustomViewGroup {
    private CallerContext f14163a;
    public FbDraweeControllerBuilder f14164b;
    @Inject
    public AnalyticsTagger f14165c;
    @Inject
    public Provider<FbDraweeControllerBuilder> f14166d;
    protected Drawable f14167e;
    public View f14168f;
    protected boolean f14169g;
    private DraweeHolder<GenericDraweeHierarchy> f14170h;

    public static void m20500a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ViewGroupWithDraweeView viewGroupWithDraweeView = (ViewGroupWithDraweeView) obj;
        AnalyticsTagger a = AnalyticsTagger.m11473a(injectorLike);
        Provider a2 = IdBasedProvider.m1811a(injectorLike, 1117);
        viewGroupWithDraweeView.f14165c = a;
        viewGroupWithDraweeView.f14166d = a2;
    }

    public ViewGroupWithDraweeView(Context context) {
        this(context, null);
    }

    public ViewGroupWithDraweeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewGroupWithDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14163a = null;
        this.f14169g = true;
        Class cls = ViewGroupWithDraweeView.class;
        m20500a(this, getContext());
    }

    protected void mo2719b() {
        if (this.f14168f != null) {
            setThumbnailController(null);
            setThumbnailDrawable(null);
        }
    }

    protected String getFeatureTag() {
        return null;
    }

    protected String getAnalyticsTag() {
        return "unknown";
    }

    public final CallerContext getCallerContext() {
        if (this.f14163a != null) {
            return this.f14163a;
        }
        this.f14163a = CallerContext.m9062a(getClass(), getAnalyticsTag(), getFeatureTag());
        return this.f14163a;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2125160777);
        super.onAttachedToWindow();
        getThumbnailDraweeHolder().m20522b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 466308487, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -104207532);
        super.onDetachedFromWindow();
        getThumbnailDraweeHolder().m20523d();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -193878870, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        getThumbnailDraweeHolder().m20523d();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        getThumbnailDraweeHolder().m20522b();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (this.f14167e == drawable && this.f14169g) || super.verifyDrawable(drawable);
    }

    public void setThumbnailController(DraweeController draweeController) {
        if (this.f14168f == null) {
            DraweeHolder thumbnailDraweeHolder = getThumbnailDraweeHolder();
            thumbnailDraweeHolder.mo3378a(draweeController);
            setThumbnailDrawable(thumbnailDraweeHolder.m20526h());
            requestLayout();
            invalidate();
        } else if (this.f14168f instanceof DraweeView) {
            ((DraweeView) this.f14168f).setController(draweeController);
        } else {
            throw new IllegalStateException("Thumbnail view is not an DraweeView");
        }
    }

    public void setThumbnailUri(Uri uri) {
        DraweeController draweeController = null;
        if (uri != null) {
            if (this.f14164b == null) {
                CallerContext callerContext;
                CallerContext b = AnalyticsTagger.m11476b(this);
                if (b == null) {
                    callerContext = getCallerContext();
                } else {
                    callerContext = b;
                }
                this.f14164b = ((FbDraweeControllerBuilder) this.f14166d.get()).m19417a(callerContext);
            }
            AbstractDraweeControllerBuilder abstractDraweeControllerBuilder = this.f14164b;
            abstractDraweeControllerBuilder.m19424b(uri);
            if (this.f14168f == null) {
                abstractDraweeControllerBuilder.m19449b(getThumbnailDraweeHolder().f14186f);
            } else if (this.f14168f instanceof DraweeView) {
                abstractDraweeControllerBuilder.m19449b(((DraweeView) this.f14168f).getController());
            }
            draweeController = abstractDraweeControllerBuilder.m19435s();
        }
        setThumbnailController(draweeController);
    }

    public void setThumbnailUri(String str) {
        setThumbnailUri(str == null ? null : Uri.parse(str));
    }

    public void setThumbnailPlaceholderDrawable(Drawable drawable) {
        GenericDraweeHierarchy genericDraweeHierarchy;
        if (this.f14168f == null) {
            genericDraweeHierarchy = (GenericDraweeHierarchy) getThumbnailDraweeHolder().m20525f();
        } else if (this.f14168f instanceof DraweeView) {
            genericDraweeHierarchy = (GenericDraweeHierarchy) ((DraweeView) this.f14168f).getHierarchy();
        } else {
            throw new IllegalStateException("Thumbnail view is not an DraweeView");
        }
        if (drawable == null) {
            drawable = new ColorDrawable(0);
        }
        genericDraweeHierarchy.m20608b(drawable);
        if (this.f14168f == null) {
            requestLayout();
            invalidate();
        }
    }

    public void setThumbnailPlaceholderResource(int i) {
        if (i > 0) {
            setThumbnailPlaceholderDrawable(getResources().getDrawable(i));
        }
    }

    public void setShowThumbnail(boolean z) {
        if (this.f14168f == null) {
            this.f14169g = z;
            requestLayout();
            invalidate();
            return;
        }
        this.f14168f.setVisibility(z ? 0 : 8);
    }

    public void setThumbnailDrawable(Drawable drawable) {
        if (this.f14168f == null && this.f14167e != drawable) {
            if (this.f14167e != null) {
                this.f14167e.setCallback(null);
            }
            this.f14167e = drawable;
            if (this.f14167e != null) {
                this.f14167e.setCallback(this);
            }
            requestLayout();
            invalidate();
        }
    }

    public void setThumbnailResource(int i) {
        if (i > 0) {
            setThumbnailDrawable(getResources().getDrawable(i));
        }
    }

    public DraweeController getController() {
        return getThumbnailDraweeHolder().f14186f;
    }

    protected DraweeHolder<GenericDraweeHierarchy> m20502e() {
        Context context = getContext();
        return DraweeHolder.m20512a(new GenericDraweeHierarchyBuilder(context.getResources()).m20571u(), context);
    }

    private DraweeHolder<GenericDraweeHierarchy> getThumbnailDraweeHolder() {
        if (this.f14170h == null) {
            this.f14170h = m20502e();
        }
        return this.f14170h;
    }
}
