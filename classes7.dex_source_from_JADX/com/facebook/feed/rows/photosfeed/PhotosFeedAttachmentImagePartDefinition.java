package com.facebook.feed.rows.photosfeed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.attachments.photos.GraphQLMediaRequestHelper;
import com.facebook.attachments.photos.PhotoAttachmentInfo;
import com.facebook.attachments.photos.PhotoAttachmentLayoutHelper;
import com.facebook.attachments.photos.ui.HasPhotoAttachment;
import com.facebook.attachments.photos.ui.PhotoAttachmentContainerView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.qe.ExperimentsForMultiRowQEModule;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.photos.data.protocol.PhotosMetadataConversionHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.galleryutil.GalleryVisibilityState;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.CustomViewUtils;
import javax.inject.Inject;

@ContextScoped
/* compiled from: action_bar_target_type */
public class PhotosFeedAttachmentImagePartDefinition<E extends CanLaunchMediaGallery & HasPositionInformation & HasPrefetcher, V extends View & HasPhotoAttachment> extends MultiRowSinglePartDefinition<MediaMetadata, State, E, V> {
    public static final ViewType f20064a = new C17341();
    public static final CallerContext f20065b = CallerContext.a(PhotosFeedAttachmentImagePartDefinition.class, "photos_feed");
    private static PhotosFeedAttachmentImagePartDefinition f20066h;
    private static final Object f20067i = new Object();
    public final FbDraweeControllerBuilder f20068c;
    private final BackgroundPartDefinition f20069d;
    private final GalleryVisibilityState f20070e;
    private final PhotoAttachmentLayoutHelper f20071f;
    private final QeAccessor f20072g;

    /* compiled from: action_bar_target_type */
    final class C17341 extends ViewType {
        C17341() {
        }

        public final View m23245a(Context context) {
            return new PhotoAttachmentContainerView(context);
        }
    }

    /* compiled from: action_bar_target_type */
    class OnPhotoClickListener implements com.facebook.attachments.photos.ui.HasPhotoAttachment.OnPhotoClickListener {
        private final MediaMetadata f20057a;
        private final ImageRequest f20058b;
        private final CanLaunchMediaGallery f20059c;

        public OnPhotoClickListener(MediaMetadata mediaMetadata, ImageRequest imageRequest, CanLaunchMediaGallery canLaunchMediaGallery) {
            this.f20057a = mediaMetadata;
            this.f20058b = imageRequest;
            this.f20059c = canLaunchMediaGallery;
        }

        @SuppressLint({"DeprecatedClass"})
        public final <T extends View & HasPhotoAttachment> void m23246a(T t, boolean z, int i) {
            this.f20059c.mo1483a(this.f20057a, this.f20058b, z, i);
        }
    }

    /* compiled from: action_bar_target_type */
    public class State {
        public final DraweeController f20060a;
        public final PointF f20061b;
        public final PhotoAttachmentInfo f20062c;
        public final OnPhotoClickListener f20063d;

        public State(DraweeController draweeController, PointF pointF, PhotoAttachmentInfo photoAttachmentInfo, OnPhotoClickListener onPhotoClickListener) {
            this.f20060a = draweeController;
            this.f20061b = pointF;
            this.f20062c = photoAttachmentInfo;
            this.f20063d = onPhotoClickListener;
        }
    }

    private static PhotosFeedAttachmentImagePartDefinition m23249b(InjectorLike injectorLike) {
        return new PhotosFeedAttachmentImagePartDefinition(FbDraweeControllerBuilder.b(injectorLike), BackgroundPartDefinition.a(injectorLike), PhotoAttachmentLayoutHelper.a(injectorLike), GalleryVisibilityState.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m23251a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        CanLaunchMediaGallery canLaunchMediaGallery = (CanLaunchMediaGallery) anyEnvironment;
        subParts.a(this.f20069d, new StylingData(null, Builder.f().b(1).i(), Position.MIDDLE));
        GraphQLMedia a = PhotosMetadataConversionHelper.a(mediaMetadata);
        GraphQLImage T = a.T();
        PointF a2 = PhotoAttachmentLayoutHelper.a(a);
        ImageRequest a3 = ImageRequest.a(ImageUtil.a(T));
        if (this.f20072g.a(ExperimentsForMultiRowQEModule.v, false)) {
            ((HasPrefetcher) canLaunchMediaGallery).a(a3, f20065b);
        }
        OnPhotoClickListener onPhotoClickListener = new OnPhotoClickListener(mediaMetadata, a3, canLaunchMediaGallery);
        ((FbDraweeControllerBuilder) this.f20068c.a(f20065b).a(true)).r();
        GraphQLMediaRequestHelper.a(a, a.T() != null ? a.T() : a.S(), this.f20068c);
        return new State(this.f20068c.s(), a2, this.f20071f.c(a), onPhotoClickListener);
    }

    public final /* bridge */ /* synthetic */ void m23252a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -923887929);
        m23248a((MediaMetadata) obj, (State) obj2, view);
        Logger.a(8, EntryType.MARK_POP, 1288302966, a);
    }

    public final boolean m23253a(Object obj) {
        return !((MediaMetadata) obj).J();
    }

    public final void m23254b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        GenericDraweeView underlyingDraweeView = ((HasPhotoAttachment) view).getUnderlyingDraweeView();
        underlyingDraweeView.setController(null);
        CustomViewUtils.b(underlyingDraweeView, null);
        ((HasPhotoAttachment) view).setOnPhotoClickListener(null);
    }

    public static PhotosFeedAttachmentImagePartDefinition m23247a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedAttachmentImagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20067i) {
                PhotosFeedAttachmentImagePartDefinition photosFeedAttachmentImagePartDefinition;
                if (a2 != null) {
                    photosFeedAttachmentImagePartDefinition = (PhotosFeedAttachmentImagePartDefinition) a2.a(f20067i);
                } else {
                    photosFeedAttachmentImagePartDefinition = f20066h;
                }
                if (photosFeedAttachmentImagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23249b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20067i, b3);
                        } else {
                            f20066h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedAttachmentImagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PhotosFeedAttachmentImagePartDefinition(FbDraweeControllerBuilder fbDraweeControllerBuilder, BackgroundPartDefinition backgroundPartDefinition, PhotoAttachmentLayoutHelper photoAttachmentLayoutHelper, GalleryVisibilityState galleryVisibilityState, QeAccessor qeAccessor) {
        this.f20068c = fbDraweeControllerBuilder;
        this.f20069d = backgroundPartDefinition;
        this.f20071f = photoAttachmentLayoutHelper;
        this.f20070e = galleryVisibilityState;
        this.f20072g = qeAccessor;
        galleryVisibilityState.a();
    }

    public final ViewType m23250a() {
        return f20064a;
    }

    private void m23248a(MediaMetadata mediaMetadata, State state, V v) {
        GenericDraweeView underlyingDraweeView = ((HasPhotoAttachment) v).getUnderlyingDraweeView();
        CustomViewUtils.b(underlyingDraweeView, null);
        underlyingDraweeView.setController(state.f20060a);
        PhotoAttachmentInfo photoAttachmentInfo = state.f20062c;
        LayoutParams layoutParams = underlyingDraweeView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = photoAttachmentInfo.g;
            layoutParams.height = photoAttachmentInfo.h;
            underlyingDraweeView.setLayoutParams(layoutParams);
        }
        ((GenericDraweeHierarchy) underlyingDraweeView.getHierarchy()).a(state.f20061b);
        ((HasPhotoAttachment) v).a(0, 0);
        ((HasPhotoAttachment) v).setOnPhotoClickListener(state.f20063d);
        ((HasPhotoAttachment) v).a(mediaMetadata.d(), this.f20070e.c);
    }
}
