package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.photos.PhotoAttachmentInfo;
import com.facebook.attachments.photos.PhotoAttachmentLayoutHelper;
import com.facebook.attachments.videos.ui.FullscreenVideoAttachmentView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
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
import com.facebook.photos.mediagallery.abtest.ExperimentsForMediaGalleryAbTestModule;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: accessibilityComponentType */
public class PhotosFeedAttachmentStaticVideoPartDefinition<E extends CanLaunchMediaGallery & HasPositionInformation & HasPersistentState> extends MultiRowSinglePartDefinition<MediaMetadata, State, E, FullscreenVideoAttachmentView> {
    public static final ViewType f20123a = new C17391();
    public static final CallerContext f20124b = CallerContext.a(PhotosFeedAttachmentVideoPartDefinition.class, "photos_feed");
    private static PhotosFeedAttachmentStaticVideoPartDefinition f20125i;
    private static final Object f20126j = new Object();
    public final FbDraweeControllerBuilder f20127c;
    private final BackgroundPartDefinition f20128d;
    private final PhotoAttachmentLayoutHelper f20129e;
    private final StylingData f20130f = new StylingData(null, Builder.f().b(1).i(), Position.TOP);
    private final PhotosFeedVideoClickListenerProvider f20131g;
    private final QeAccessor f20132h;

    /* compiled from: accessibilityComponentType */
    final class C17391 extends ViewType {
        C17391() {
        }

        public final View m23281a(Context context) {
            return new FullscreenVideoAttachmentView(context);
        }
    }

    /* compiled from: accessibilityComponentType */
    public class State {
        public final DraweeController f20117a;
        public final PointF f20118b;
        public final int f20119c;
        public final int f20120d;
        public final float f20121e;
        public final OnClickListener f20122f;

        public State(DraweeController draweeController, PointF pointF, int i, int i2, float f, OnClickListener onClickListener) {
            this.f20117a = draweeController;
            this.f20118b = pointF;
            this.f20119c = i;
            this.f20120d = i2;
            this.f20121e = f;
            this.f20122f = onClickListener;
        }
    }

    private static PhotosFeedAttachmentStaticVideoPartDefinition m23283b(InjectorLike injectorLike) {
        return new PhotosFeedAttachmentStaticVideoPartDefinition(FbDraweeControllerBuilder.b(injectorLike), BackgroundPartDefinition.a(injectorLike), PhotoAttachmentLayoutHelper.a(injectorLike), (PhotosFeedVideoClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PhotosFeedVideoClickListenerProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m23285a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        float f;
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        CanLaunchMediaGallery canLaunchMediaGallery = (CanLaunchMediaGallery) anyEnvironment;
        subParts.a(this.f20128d, this.f20130f);
        GraphQLMedia a = PhotosMetadataConversionHelper.a(mediaMetadata);
        GraphQLImage T = a.T();
        PointF a2 = PhotoAttachmentLayoutHelper.a(a);
        ImageRequest m = ImageRequestBuilder.a(ImageUtil.a(T)).m();
        DraweeController s = ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f20127c.a(f20124b).a(true)).c(m)).r().s();
        PhotoAttachmentInfo c = this.f20129e.c(a);
        int i = c.g;
        int i2 = c.h;
        float f2 = (float) i;
        float f3 = (float) i2;
        if (f2 > 0.0f) {
            f = f3 / f2;
        } else {
            f = 1.0f;
        }
        return new State(s, a2, i, i2, f, this.f20131g.m23465a(mediaMetadata, this.f20132h.a(ExperimentsForMediaGalleryAbTestModule.f10690n, false), canLaunchMediaGallery, m));
    }

    public final /* bridge */ /* synthetic */ void m23286a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1746793979);
        State state = (State) obj2;
        FullscreenVideoAttachmentView fullscreenVideoAttachmentView = (FullscreenVideoAttachmentView) view;
        fullscreenVideoAttachmentView.setOnClickListener(state.f20122f);
        fullscreenVideoAttachmentView.setCoverController(state.f20117a);
        fullscreenVideoAttachmentView.a(state.f20119c, state.f20120d);
        fullscreenVideoAttachmentView.b(state.f20119c, state.f20120d);
        Logger.a(8, EntryType.MARK_POP, -620271090, a);
    }

    public final boolean m23287a(Object obj) {
        return ((MediaMetadata) obj).J() && !this.f20132h.a(ExperimentsForNewsFeedAbTestModule.G, false);
    }

    public final void m23288b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((FullscreenVideoAttachmentView) view).setOnClickListener(null);
    }

    public static PhotosFeedAttachmentStaticVideoPartDefinition m23282a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedAttachmentStaticVideoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20126j) {
                PhotosFeedAttachmentStaticVideoPartDefinition photosFeedAttachmentStaticVideoPartDefinition;
                if (a2 != null) {
                    photosFeedAttachmentStaticVideoPartDefinition = (PhotosFeedAttachmentStaticVideoPartDefinition) a2.a(f20126j);
                } else {
                    photosFeedAttachmentStaticVideoPartDefinition = f20125i;
                }
                if (photosFeedAttachmentStaticVideoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23283b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20126j, b3);
                        } else {
                            f20125i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedAttachmentStaticVideoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PhotosFeedAttachmentStaticVideoPartDefinition(FbDraweeControllerBuilder fbDraweeControllerBuilder, BackgroundPartDefinition backgroundPartDefinition, PhotoAttachmentLayoutHelper photoAttachmentLayoutHelper, PhotosFeedVideoClickListenerProvider photosFeedVideoClickListenerProvider, QeAccessor qeAccessor) {
        this.f20127c = fbDraweeControllerBuilder;
        this.f20128d = backgroundPartDefinition;
        this.f20129e = photoAttachmentLayoutHelper;
        this.f20131g = photosFeedVideoClickListenerProvider;
        this.f20132h = qeAccessor;
    }

    public final ViewType m23284a() {
        return f20123a;
    }
}
