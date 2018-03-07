package com.facebook.messaging.sharing.mediapreview;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.v7.internal.widget.ViewStubCompat;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.sharing.mediapreview.MediaSharePreviewPlayableView.ErrorListener;
import com.facebook.messaging.sharing.mediapreview.MediaSharePreviewPlayableView.MediaResourceListener;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.listview.EmptyListViewItem;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: composer/?%s=<share_link>&%s=<app_id>&%s=true&%s=<in_app>&%s=null&%s=null&%s=null&%s=null&%s=<quote> */
public class MediaSharePreviewThumbnailView extends CustomFrameLayout {
    private static final CallerContext f17430b = CallerContext.a(MediaSharePreviewThumbnailView.class, "media_resource_view");
    @Inject
    public FbDraweeControllerBuilder f17431a;
    private FbDraweeView f17432c;
    public EmptyListViewItem f17433d;
    private ViewStubHolder<MediaSharePreviewPlayableView> f17434e;
    public View f17435f;
    public Type f17436g;

    /* compiled from: composer/?%s=<share_link>&%s=<app_id>&%s=true&%s=<in_app>&%s=null&%s=null&%s=null&%s=null&%s=<quote> */
    class C20731 implements MediaResourceListener {
        final /* synthetic */ MediaSharePreviewThumbnailView f17427a;

        C20731(MediaSharePreviewThumbnailView mediaSharePreviewThumbnailView) {
            this.f17427a = mediaSharePreviewThumbnailView;
        }

        public final void mo697a() {
            this.f17427a.f17433d.setVisibility(8);
        }
    }

    /* compiled from: composer/?%s=<share_link>&%s=<app_id>&%s=true&%s=<in_app>&%s=null&%s=null&%s=null&%s=null&%s=<quote> */
    class C20742 implements ErrorListener {
        final /* synthetic */ MediaSharePreviewThumbnailView f17428a;

        C20742(MediaSharePreviewThumbnailView mediaSharePreviewThumbnailView) {
            this.f17428a = mediaSharePreviewThumbnailView;
        }

        public final void mo698a() {
            this.f17428a.f17435f.setVisibility(0);
        }
    }

    /* compiled from: composer/?%s=<share_link>&%s=<app_id>&%s=true&%s=<in_app>&%s=null&%s=null&%s=null&%s=null&%s=<quote> */
    class C20753 extends BaseControllerListener {
        final /* synthetic */ MediaSharePreviewThumbnailView f17429a;

        C20753(MediaSharePreviewThumbnailView mediaSharePreviewThumbnailView) {
            this.f17429a = mediaSharePreviewThumbnailView;
        }

        public final void m17400a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            this.f17429a.f17433d.setVisibility(8);
            if (this.f17429a.f17436g == Type.PHOTO && animatable != null) {
                animatable.start();
            }
        }

        public final void m17401b(String str, Throwable th) {
            this.f17429a.f17435f.setVisibility(0);
        }
    }

    private static <T extends View> void m17407a(Class<T> cls, T t) {
        m17408a((Object) t, t.getContext());
    }

    private static void m17408a(Object obj, Context context) {
        ((MediaSharePreviewThumbnailView) obj).f17431a = FbDraweeControllerBuilder.b(FbInjector.get(context));
    }

    public MediaSharePreviewThumbnailView(Context context) {
        super(context);
        m17404a();
    }

    public MediaSharePreviewThumbnailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17404a();
    }

    public MediaSharePreviewThumbnailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17404a();
    }

    private void m17404a() {
        m17407a(MediaSharePreviewThumbnailView.class, (View) this);
        setContentView(2130905845);
        this.f17432c = (FbDraweeView) c(2131565109);
        this.f17433d = (EmptyListViewItem) c(2131565110);
        this.f17433d.a(true);
        this.f17434e = ViewStubHolder.a((ViewStubCompat) c(2131565111));
        this.f17435f = c(2131565114);
    }

    public void setData(MediaResource mediaResource) {
        m17406a(mediaResource, true);
    }

    private void m17406a(MediaResource mediaResource, boolean z) {
        int i = 0;
        this.f17436g = mediaResource.d;
        boolean z2 = this.f17436g == Type.VIDEO || this.f17436g == Type.PHOTO || this.f17436g == Type.AUDIO;
        Preconditions.checkArgument(z2);
        this.f17435f.setVisibility(8);
        if (this.f17436g == Type.PHOTO) {
            this.f17432c.setController(m17402a(mediaResource.c));
            this.f17432c.setVisibility(0);
            GenericDraweeHierarchy u = this.f17432c.a() ? (GenericDraweeHierarchy) this.f17432c.getHierarchy() : new GenericDraweeHierarchyBuilder(getResources()).u();
            if (z) {
                i = 300;
            }
            u.a(i);
        }
        if (this.f17436g == Type.VIDEO || this.f17436g == Type.AUDIO) {
            ((MediaSharePreviewPlayableView) this.f17434e.a()).f17414b = new C20731(this);
            ((MediaSharePreviewPlayableView) this.f17434e.a()).f17413a = new C20742(this);
            ((MediaSharePreviewPlayableView) this.f17434e.a()).m17397a(mediaResource, 2130905844);
        }
    }

    private DraweeController m17402a(Uri uri) {
        int dimension = (int) getResources().getDimension(2131433322);
        FbDraweeControllerBuilder a = this.f17431a.p().a(f17430b);
        ImageRequestBuilder a2 = ImageRequestBuilder.a(uri);
        a2.d = new ResizeOptions(dimension, dimension);
        return ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) a.c(a2.m())).b(this.f17432c.getController())).a(new C20753(this))).s();
    }

    private void m17405a(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f17431a = fbDraweeControllerBuilder;
    }
}
