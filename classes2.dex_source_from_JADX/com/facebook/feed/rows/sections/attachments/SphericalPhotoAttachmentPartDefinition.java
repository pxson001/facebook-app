package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.photos.ui.SphericalPhotoAttachmentView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.device.yearclass.YearClass;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.feed.autoplay.DefaultVideoAutoplayManager;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.feed.ui.imageloader.FeedImageLoader.FeedImageType;
import com.facebook.graphql.model.GraphQLPhotoEncoding;
import com.facebook.graphql.model.GraphQLPhotosphereMetadata;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.StoryTextHelper;
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
import com.facebook.spherical.model.SphericalPhotoParams;
import com.facebook.spherical.model.SphericalPhotoParams.Builder;
import com.facebook.spherical.photo.CubemapsUtil;
import com.facebook.spherical.photo.CubemapsUtil.CubeMapUris;
import com.facebook.spherical.photo.PartialPanoUtil;
import com.facebook.spherical.photo.PartialPanoUtil.PanoBounds;
import com.facebook.spherical.photo.PhotoVRCastParams;
import com.facebook.spherical.photo.SphericalPhotoAnalyticsLogger;
import com.facebook.spherical.photo.abtest.ExperimentsForPhotos360AbTestModule;
import com.facebook.spherical.photo.abtest.Photos360QEHelper;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: hideInstallButton */
public class SphericalPhotoAttachmentPartDefinition<E extends HasPositionInformation & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, SphericalPhotoAttachmentView> {
    public static final ViewType f21071a = new C08401();
    public static final CallerContext f21072b = CallerContext.m9061a(SphericalPhotoAttachmentPartDefinition.class, "native_newsfeed");
    private static SphericalPhotoAttachmentPartDefinition f21073l;
    private static final Object f21074m = new Object();
    private final Photos360QEHelper f21075c;
    private final FbDraweeControllerBuilder f21076d;
    private final FeedImageLoader f21077e;
    private final BackgroundPartDefinition f21078f;
    private final PhotoAttachmentUtil f21079g;
    public final SphericalPhotoAnalyticsLogger f21080h;
    public final DefaultVideoAutoplayManager<SphericalPhotoAttachmentView> f21081i;
    private final Context f21082j;
    private final CubemapsUtil f21083k;

    /* compiled from: hideInstallButton */
    final class C08401 extends ViewType {
        C08401() {
        }

        public final View mo1995a(Context context) {
            return new SphericalPhotoAttachmentView(context);
        }
    }

    private static SphericalPhotoAttachmentPartDefinition m28801b(InjectorLike injectorLike) {
        return new SphericalPhotoAttachmentPartDefinition(FeedImageLoader.m28808a(injectorLike), Photos360QEHelper.m28837a(injectorLike), DefaultVideoAutoplayManager.m26570a(injectorLike), FbDraweeControllerBuilder.m19410b(injectorLike), BackgroundPartDefinition.m19135a(injectorLike), PhotoAttachmentUtil.m28776b(injectorLike), SphericalPhotoAnalyticsLogger.m28846b(injectorLike), (Context) injectorLike.getInstance(Context.class), new CubemapsUtil(Photos360QEHelper.m28837a(injectorLike)));
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1159592017);
        State state = (State) obj2;
        SphericalPhotoAttachmentView sphericalPhotoAttachmentView = (SphericalPhotoAttachmentView) view;
        sphericalPhotoAttachmentView.setPreviewPhotoDraweeController(state.a);
        sphericalPhotoAttachmentView.a(state.b, f21072b);
        sphericalPhotoAttachmentView.setSphericalPhotoParams(state.f);
        if (sphericalPhotoAttachmentView.b(state.b, f21072b)) {
            this.f21081i.m26572a(sphericalPhotoAttachmentView, state.c);
            sphericalPhotoAttachmentView.setOnClickListener(state.d);
            sphericalPhotoAttachmentView.setVrCastParamsAndMaybeStartVR(state.e);
            sphericalPhotoAttachmentView.a(state.g, state.f);
        }
        Logger.a(8, EntryType.MARK_POP, 1461993722, a);
    }

    public final boolean m28805a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).f13444a;
        if (graphQLStoryAttachment == null || graphQLStoryAttachment.m23979r() == null || graphQLStoryAttachment.m23979r().aI() == null || graphQLStoryAttachment.m23979r().aI().size() <= 0 || !this.f21075c.f21102a.mo596a(ExperimentsForPhotos360AbTestModule.f, false)) {
            return false;
        }
        return true;
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        SphericalPhotoAttachmentView sphericalPhotoAttachmentView = (SphericalPhotoAttachmentView) view;
        sphericalPhotoAttachmentView.setPreviewPhotoDraweeController(null);
        sphericalPhotoAttachmentView.h();
        if (!sphericalPhotoAttachmentView.n) {
            HandlerDetour.b(SphericalPhotoAttachmentView.k, sphericalPhotoAttachmentView.y, 80, 1397784860);
            sphericalPhotoAttachmentView.n = true;
        }
    }

    public static SphericalPhotoAttachmentPartDefinition m28798a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SphericalPhotoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21074m) {
                SphericalPhotoAttachmentPartDefinition sphericalPhotoAttachmentPartDefinition;
                if (a2 != null) {
                    sphericalPhotoAttachmentPartDefinition = (SphericalPhotoAttachmentPartDefinition) a2.mo818a(f21074m);
                } else {
                    sphericalPhotoAttachmentPartDefinition = f21073l;
                }
                if (sphericalPhotoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28801b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21074m, b3);
                        } else {
                            f21073l = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = sphericalPhotoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public SphericalPhotoAttachmentPartDefinition(FeedImageLoader feedImageLoader, Photos360QEHelper photos360QEHelper, DefaultVideoAutoplayManager defaultVideoAutoplayManager, FbDraweeControllerBuilder fbDraweeControllerBuilder, BackgroundPartDefinition backgroundPartDefinition, PhotoAttachmentUtil photoAttachmentUtil, SphericalPhotoAnalyticsLogger sphericalPhotoAnalyticsLogger, Context context, CubemapsUtil cubemapsUtil) {
        this.f21077e = feedImageLoader;
        this.f21075c = photos360QEHelper;
        this.f21081i = defaultVideoAutoplayManager;
        this.f21076d = fbDraweeControllerBuilder;
        this.f21078f = backgroundPartDefinition;
        this.f21079g = photoAttachmentUtil;
        this.f21080h = sphericalPhotoAnalyticsLogger;
        this.f21082j = context;
        this.f21083k = cubemapsUtil;
    }

    public final ViewType mo2547a() {
        return f21071a;
    }

    private State m28797a(SubParts<E> subParts, FeedProps<GraphQLStoryAttachment> feedProps, E e) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.m19804a();
        subParts.mo2756a(this.f21078f, new StylingData(AttachmentProps.m28715e(feedProps), this.f21079g.m28777a(feedProps, e)));
        Object a = this.f21077e.m28817a(graphQLStoryAttachment.m23979r(), FeedImageType.Photo);
        ((HasPrefetcher) e).mo2434a(a, f21072b);
        Object s = ((FbDraweeControllerBuilder) this.f21076d.m19417a(f21072b).m19452c(a)).m19435s();
        CubeMapUris a2 = this.f21083k.m28852a(graphQLStoryAttachment, YearClass.m30095a(this.f21082j));
        ImageRequest m = ImageRequestBuilder.m18776a(Uri.parse(a2.a())).m18785m();
        ImageRequest m2 = ImageRequestBuilder.m18776a(Uri.parse(a2.b())).m18785m();
        GraphQLStory c = AttachmentProps.m28714c(feedProps);
        PhotoVRCastParams photoVRCastParams = new PhotoVRCastParams(a2.c(), StoryActorHelper.m27492b(c) != null ? StoryActorHelper.m27492b(c).aa() : "", StoryTextHelper.m31226a(c));
        SphericalPhotoParams a3 = m28799a(graphQLStoryAttachment);
        PanoBounds a4 = PartialPanoUtil.a(graphQLStoryAttachment);
        return new State(s, m, m28800b(graphQLStoryAttachment), m28796a(m, m2, feedProps, photoVRCastParams, a3, a4), photoVRCastParams, a3, a4);
    }

    private static SphericalPhotoParams m28799a(GraphQLStoryAttachment graphQLStoryAttachment) {
        ImmutableList aI = graphQLStoryAttachment.m23979r().aI();
        int size = aI.size();
        int i = 0;
        while (i < size) {
            GraphQLPhotoEncoding graphQLPhotoEncoding = (GraphQLPhotoEncoding) aI.get(i);
            if (!graphQLPhotoEncoding.m27593l().equals("cubestrip") || graphQLPhotoEncoding.m27594m() == null) {
                i++;
            } else {
                GraphQLPhotosphereMetadata m = graphQLPhotoEncoding.m27594m();
                Builder builder = new Builder();
                builder.a = m.j();
                builder = builder;
                builder.b = m.l();
                builder = builder;
                builder.c = m.a();
                builder = builder;
                builder.d = m.k();
                builder = builder;
                builder.e = m.m();
                builder = builder;
                builder.f = m.n();
                builder = builder;
                builder.g = m.o();
                builder = builder;
                builder.h = m.p();
                return builder.a();
            }
        }
        return new Builder().a();
    }

    private VideoViewController<SphericalPhotoAttachmentView> m28800b(GraphQLStoryAttachment graphQLStoryAttachment) {
        return graphQLStoryAttachment != null ? new 2(this, graphQLStoryAttachment.m23979r().m24452b()) : null;
    }

    private OnClickListener m28796a(ImageRequest imageRequest, ImageRequest imageRequest2, FeedProps<GraphQLStoryAttachment> feedProps, PhotoVRCastParams photoVRCastParams, SphericalPhotoParams sphericalPhotoParams, PanoBounds panoBounds) {
        return new 3(this, imageRequest, imageRequest2, feedProps, photoVRCastParams, sphericalPhotoParams, panoBounds);
    }
}
