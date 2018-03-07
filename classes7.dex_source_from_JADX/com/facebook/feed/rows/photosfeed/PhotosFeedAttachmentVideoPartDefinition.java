package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import android.graphics.PointF;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.photos.PhotoAttachmentInfo;
import com.facebook.attachments.photos.PhotoAttachmentLayoutHelper;
import com.facebook.attachments.videos.ui.InlineVideoAttachmentView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.autoplay.CenteredVideoAutoplayManager;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.photosfeed.videos.PhotosFeedInlineVideoKey;
import com.facebook.feed.rows.photosfeed.videos.PhotosFeedInlineVideoPersistentState;
import com.facebook.feed.rows.photosfeed.videos.PhotosFeedVideoViewControllerProvider;
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
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.AbstractVideoPlayerListener;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoPlayerManager;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.player.BaseInlineVideoPlayer;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;

@ContextScoped
/* compiled from: accept_place_suggestion */
public class PhotosFeedAttachmentVideoPartDefinition<E extends CanLaunchMediaGallery & HasPositionInformation & HasPersistentState> extends MultiRowSinglePartDefinition<MediaMetadata, State, E, InlineVideoAttachmentView> {
    public static final ViewType f20157a = new C17401();
    private static final CallerContext f20158b = CallerContext.a(PhotosFeedAttachmentVideoPartDefinition.class, "photos_feed");
    private static PhotosFeedAttachmentVideoPartDefinition f20159k;
    private static final Object f20160l = new Object();
    private final FbDraweeControllerBuilder f20161c;
    private final BackgroundPartDefinition f20162d;
    private final PhotoAttachmentLayoutHelper f20163e;
    private final StylingData f20164f = new StylingData(null, Builder.f().b(1).i(), Position.TOP);
    public final CenteredVideoAutoplayManager<InlineVideoAttachmentView> f20165g;
    private final PhotosFeedVideoViewControllerProvider f20166h;
    private final PhotosFeedVideoClickListenerProvider f20167i;
    private final QeAccessor f20168j;

    /* compiled from: accept_place_suggestion */
    final class C17401 extends ViewType {
        C17401() {
        }

        public final View m23298a(Context context) {
            return new InlineVideoAttachmentView(context);
        }
    }

    /* compiled from: accept_place_suggestion */
    public class OnVideoEventListener extends AbstractVideoPlayerListener {
        private final State f20144a;
        public BaseInlineVideoPlayer f20145b;

        public OnVideoEventListener(State state) {
            this.f20144a = state;
        }

        public final void m23300a(int i) {
            this.f20144a.f20153h.f20346b = true;
            this.f20144a.f20153h.m23469a(0);
        }

        public final void m23302c(EventTriggerType eventTriggerType, boolean z) {
            if (z) {
                m23299d(eventTriggerType);
            }
        }

        public final void m23301b(EventTriggerType eventTriggerType) {
            m23299d(eventTriggerType);
        }

        private void m23299d(EventTriggerType eventTriggerType) {
            if (this.f20145b == null) {
                return;
            }
            if (eventTriggerType == EventTriggerType.BY_NEWSFEED_OCCLUSION || eventTriggerType == EventTriggerType.BY_NEWSFEED_ONPAUSE || VideoPlayerManager.c(eventTriggerType)) {
                this.f20144a.f20153h.m23469a(this.f20145b.getCurrentPosition());
            }
        }
    }

    /* compiled from: accept_place_suggestion */
    public class State {
        public final DraweeController f20146a;
        public final PointF f20147b;
        public final VideoPlayerParams f20148c;
        public final ImmutableMap<String, Object> f20149d;
        public final int f20150e;
        public final int f20151f;
        public final float f20152g;
        public final PhotosFeedInlineVideoPersistentState f20153h;
        public final OnVideoEventListener f20154i = new OnVideoEventListener(this);
        public final OnClickListener f20155j;
        public final VideoViewController f20156k;

        public State(DraweeController draweeController, PointF pointF, VideoPlayerParams videoPlayerParams, ImmutableMap<String, Object> immutableMap, int i, int i2, float f, PhotosFeedInlineVideoPersistentState photosFeedInlineVideoPersistentState, VideoViewController videoViewController, OnClickListener onClickListener) {
            this.f20146a = draweeController;
            this.f20147b = pointF;
            this.f20148c = videoPlayerParams;
            this.f20149d = immutableMap;
            this.f20150e = i;
            this.f20151f = i2;
            this.f20152g = f;
            this.f20153h = photosFeedInlineVideoPersistentState;
            this.f20155j = onClickListener;
            this.f20156k = videoViewController;
        }
    }

    private static PhotosFeedAttachmentVideoPartDefinition m23307b(InjectorLike injectorLike) {
        return new PhotosFeedAttachmentVideoPartDefinition(FbDraweeControllerBuilder.b(injectorLike), BackgroundPartDefinition.a(injectorLike), PhotoAttachmentLayoutHelper.a(injectorLike), CenteredVideoAutoplayManager.a(injectorLike), (PhotosFeedVideoViewControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PhotosFeedVideoViewControllerProvider.class), (PhotosFeedVideoClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PhotosFeedVideoClickListenerProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m23310a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1723232710);
        State state = (State) obj2;
        InlineVideoAttachmentView inlineVideoAttachmentView = (InlineVideoAttachmentView) view;
        inlineVideoAttachmentView.b.a(state.f20155j, inlineVideoAttachmentView);
        inlineVideoAttachmentView.b.a(PlayerOrigin.FEED, false, state.f20148c, state.f20149d);
        inlineVideoAttachmentView.b.setCoverController(state.f20146a);
        inlineVideoAttachmentView.b.a(state.f20150e, state.f20151f);
        inlineVideoAttachmentView.b.b(state.f20150e, state.f20151f);
        inlineVideoAttachmentView.c = state.f20152g;
        BaseInlineVideoPlayer baseInlineVideoPlayer = inlineVideoAttachmentView.a;
        state.f20154i.f20145b = baseInlineVideoPlayer;
        baseInlineVideoPlayer.a(state.f20150e, state.f20151f);
        ((GenericDraweeHierarchy) baseInlineVideoPlayer.getCoverImage().getHierarchy()).a(state.f20147b);
        baseInlineVideoPlayer.setVideoListener(state.f20154i);
        baseInlineVideoPlayer.g();
        this.f20165g.a(inlineVideoAttachmentView, state.f20156k);
        Logger.a(8, EntryType.MARK_POP, 2115288271, a);
    }

    public final boolean m23311a(Object obj) {
        return ((MediaMetadata) obj).J() && this.f20168j.a(ExperimentsForNewsFeedAbTestModule.G, false);
    }

    public final void m23312b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        InlineVideoAttachmentView inlineVideoAttachmentView = (InlineVideoAttachmentView) view;
        inlineVideoAttachmentView.b.b();
        inlineVideoAttachmentView.a.setVideoListener(null);
        state.f20154i.f20145b = null;
        inlineVideoAttachmentView.setOnClickListener(null);
    }

    public static PhotosFeedAttachmentVideoPartDefinition m23306a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedAttachmentVideoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20160l) {
                PhotosFeedAttachmentVideoPartDefinition photosFeedAttachmentVideoPartDefinition;
                if (a2 != null) {
                    photosFeedAttachmentVideoPartDefinition = (PhotosFeedAttachmentVideoPartDefinition) a2.a(f20160l);
                } else {
                    photosFeedAttachmentVideoPartDefinition = f20159k;
                }
                if (photosFeedAttachmentVideoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23307b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20160l, b3);
                        } else {
                            f20159k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedAttachmentVideoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PhotosFeedAttachmentVideoPartDefinition(FbDraweeControllerBuilder fbDraweeControllerBuilder, BackgroundPartDefinition backgroundPartDefinition, PhotoAttachmentLayoutHelper photoAttachmentLayoutHelper, CenteredVideoAutoplayManager centeredVideoAutoplayManager, PhotosFeedVideoViewControllerProvider photosFeedVideoViewControllerProvider, PhotosFeedVideoClickListenerProvider photosFeedVideoClickListenerProvider, QeAccessor qeAccessor) {
        this.f20161c = fbDraweeControllerBuilder;
        this.f20162d = backgroundPartDefinition;
        this.f20163e = photoAttachmentLayoutHelper;
        this.f20165g = centeredVideoAutoplayManager;
        this.f20166h = photosFeedVideoViewControllerProvider;
        this.f20167i = photosFeedVideoClickListenerProvider;
        this.f20168j = qeAccessor;
    }

    public final ViewType m23308a() {
        return f20157a;
    }

    private State m23305a(SubParts<E> subParts, MediaMetadata mediaMetadata, E e) {
        subParts.a(this.f20162d, this.f20164f);
        GraphQLMedia a = PhotosMetadataConversionHelper.a(mediaMetadata);
        GraphQLImage T = a.T();
        PointF a2 = PhotoAttachmentLayoutHelper.a(a);
        ImageRequest m = ImageRequestBuilder.a(ImageUtil.a(T)).m();
        DraweeController a3 = m23304a(m);
        PhotoAttachmentInfo c = this.f20163e.c(a);
        VideoPlayerParams m2 = VideoPlayerParams.newBuilder().a(VideoDataSource.newBuilder().a(StreamSourceType.FROM_STREAM).a(Uri.parse(mediaMetadata.Q())).i()).a(mediaMetadata.d()).a(mediaMetadata.P()).m();
        int e2 = c.e();
        int f = c.f();
        float a4 = m23303a((float) e2, (float) f);
        PhotosFeedInlineVideoPersistentState photosFeedInlineVideoPersistentState = (PhotosFeedInlineVideoPersistentState) ((HasPersistentState) e).a(new PhotosFeedInlineVideoKey(mediaMetadata), new CacheableEntityWrapper(mediaMetadata.d()));
        return new State(a3, a2, m2, new ImmutableMap.Builder().b("VideoAspectRatioKey", Double.valueOf((double) a4)).b(), e2, f, a4, photosFeedInlineVideoPersistentState, this.f20166h.m23474a(mediaMetadata.d(), photosFeedInlineVideoPersistentState), this.f20167i.m23465a(mediaMetadata, this.f20168j.a(ExperimentsForMediaGalleryAbTestModule.f10690n, false), e, m));
    }

    private static float m23303a(float f, float f2) {
        return f2 > 0.0f ? f / f2 : 1.0f;
    }

    private DraweeController m23304a(ImageRequest imageRequest) {
        return ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f20161c.a(f20158b).a(true)).c(imageRequest)).r().s();
    }
}
