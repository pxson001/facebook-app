package com.facebook.photos.sphericalphoto;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.attachments.photos.ui.SphericalPhotoAttachmentView;
import com.facebook.attachments.photos.ui.SphericalPhotoFullScreenView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.executor.GraphQLResponseParser;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.data.protocol.PhotosMetadataConversionHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.dialog.PhotoAnimationContentFragment;
import com.facebook.photos.dialog.PhotoAnimationDialogFragment;
import com.facebook.photos.dialog.PhotoAnimationDialogFragment.3;
import com.facebook.photos.galleryutil.VisibilityAnimator;
import com.facebook.photos.mediagallery.launcher.animation.DrawingRule;
import com.facebook.spherical.model.SphericalPhotoParams;
import com.facebook.spherical.photo.PartialPanoUtil.PanoBounds;
import com.facebook.spherical.photo.PhotoVRCastParams;
import com.facebook.spherical.photo.SphericalPhotoIndicatorPlugin;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: serp */
public class SphericalPhotoFragment extends PhotoAnimationContentFragment {
    @Inject
    public GraphQLSubscriptionHolder f3371a;
    private SphericalPhotoFullScreenView al;
    public SphericalPhotoFooterView am;
    private boolean an;
    public VisibilityAnimator ao;
    private PanoBounds ap;
    private boolean aq;
    @Inject
    public ViewHelperViewAnimatorFactory f3372b;
    private CallerContext f3373c;
    private ImageRequest f3374d;
    private ImageRequest f3375e;
    private PhotoVRCastParams f3376f;
    private SphericalPhotoParams f3377g;
    private SphericalPhotoAttachmentView f3378h;
    private FeedProps<GraphQLStoryAttachment> f3379i;

    /* compiled from: serp */
    class C04281 implements FutureCallback<GraphQLResult<MediaMetadata>> {
        final /* synthetic */ SphericalPhotoFragment f3370a;

        C04281(SphericalPhotoFragment sphericalPhotoFragment) {
            this.f3370a = sphericalPhotoFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null) {
                this.f3370a.am.m3307a((MediaMetadata) graphQLResult.e);
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    public static void m3309a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        SphericalPhotoFragment sphericalPhotoFragment = (SphericalPhotoFragment) obj;
        GraphQLSubscriptionHolder b = GraphQLSubscriptionHolder.b(fbInjector);
        ViewHelperViewAnimatorFactory a = ViewHelperViewAnimatorFactory.a(fbInjector);
        sphericalPhotoFragment.f3371a = b;
        sphericalPhotoFragment.f3372b = a;
    }

    public final void m3317c(Bundle bundle) {
        Class cls = SphericalPhotoFragment.class;
        m3309a((Object) this, getContext());
    }

    public final View m3312a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -265751);
        super.a(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), 2131626218)).inflate(2130907188, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1969806147, a);
        return inflate;
    }

    public final void m3314a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) this.f3379i.a;
        this.al = (SphericalPhotoFullScreenView) view.findViewById(2131567566);
        this.am = (SphericalPhotoFooterView) view.findViewById(2131567567);
        this.am.f3368y = this.f3379i.a(graphQLStoryAttachment.z() != null ? graphQLStoryAttachment.z().hO() : null);
        MediaMetadata a = PhotosMetadataConversionHelper.a(graphQLStoryAttachment.r());
        this.am.m3307a(a);
        if (this.ao == null && a.ac() != null) {
            this.ao = new VisibilityAnimator(this.am, 200, true, this.f3372b);
        }
        SphericalPhotoFullScreenView sphericalPhotoFullScreenView = this.al;
        sphericalPhotoFullScreenView.f = this;
        sphericalPhotoFullScreenView.j.o = this;
        this.al.a(this.aq);
        sphericalPhotoFullScreenView = this.al;
        boolean z = this.an;
        SphericalPhotoIndicatorPlugin sphericalPhotoIndicatorPlugin = sphericalPhotoFullScreenView.j;
        sphericalPhotoIndicatorPlugin.i = z;
        sphericalPhotoIndicatorPlugin.j = true;
        this.al.setVrCastParamsAndMaybeStartVR(this.f3376f);
        this.al.setSphericalPhotoParams(this.f3377g);
        this.al.d = this.f3374d;
        this.al.e = this.f3373c;
        this.al.a(this.ap, this.f3377g);
        this.al.x = this.f3375e;
        this.al.a(this.f3374d, this.f3373c);
        this.f3371a.a(new C04281(this), PhotosMetadataConversionHelper.a(graphQLStoryAttachment.r()).d(), this.f3371a.a(PhotosMetadataConversionHelper.a(graphQLStoryAttachment.r()), DataFreshnessResult.FROM_SERVER, 0, ImmutableSet.copyOf(GraphQLResponseParser.a(graphQLStoryAttachment.r().I()))));
    }

    public final void m3311H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -613491012);
        super.H();
        this.f3371a.d();
        this.al.h();
        this.al.g();
        if (this.f3378h != null) {
            this.f3378h.s = false;
            this.f3378h.j();
            this.f3378h.j.o();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1833643111, a);
    }

    public final void m3310G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 959211544);
        super.G();
        this.f3371a.e();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -799809728, a);
    }

    public final void aq() {
        super.aq();
        this.f3371a.a();
    }

    public final DrawingRule m3313a(Drawable drawable, Rect rect) {
        return null;
    }

    public final String as() {
        return PhotoAnimationDialogFragment.aq;
    }

    @Nullable
    public final String m3318e() {
        return ((GraphQLStoryAttachment) this.f3379i.a).r().b();
    }

    public final boolean m3316a(3 3) {
        return false;
    }

    public final void m3315a(ImageRequest imageRequest, ImageRequest imageRequest2, FeedProps<GraphQLStoryAttachment> feedProps, PhotoVRCastParams photoVRCastParams, CallerContext callerContext, SphericalPhotoAttachmentView sphericalPhotoAttachmentView, SphericalPhotoParams sphericalPhotoParams, boolean z, boolean z2, PanoBounds panoBounds) {
        this.f3374d = imageRequest;
        this.f3375e = imageRequest2;
        this.f3379i = feedProps;
        this.f3376f = photoVRCastParams;
        this.f3373c = callerContext;
        this.f3378h = sphericalPhotoAttachmentView;
        this.f3377g = sphericalPhotoParams;
        this.an = z;
        this.aq = z2;
        this.ap = panoBounds;
    }
}
