package com.facebook.feedplugins.attachments.collage;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.attachments.photos.PostpostTaggingUtil;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.content.SecureContextHelper;
import com.facebook.datasensitivity.pref.DataSensitivitySettingsPrefUtil;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneController.FeatureType;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.DegradableDraweeController;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.collage.CollageLayoutCalculator;
import com.facebook.feed.collage.CollageLayoutCalculatorProvider;
import com.facebook.feed.collage.CollageLayoutProperties;
import com.facebook.feed.collage.CollagePaddingHelper;
import com.facebook.feed.collage.DataSavingsCollageLayoutPropertiesProvider;
import com.facebook.feed.collage.DefaultCollageLayoutPropertiesProvider;
import com.facebook.feed.collage.PhotoGridProperties;
import com.facebook.feed.collage.StoryCollageItem;
import com.facebook.feed.collage.ui.CollageAttachmentView;
import com.facebook.feed.collage.ui.CollageAttachmentView.OnImageClickListener;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.rows.photosfeed.SnowflakeLauncherHelper;
import com.facebook.feed.rows.qe.ExperimentsForMultiRowQEModule;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyleUtil;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.feed.video.FeedFullScreenParams;
import com.facebook.feed.video.FullScreenVideoPlayerHost;
import com.facebook.feed.video.ImmersiveVideoPlayer;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsInterfaces.SouvenirsDetailsFields;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsDetailsFieldsModel;
import com.facebook.friendsharing.souvenirs.protocols.SouvenirsConversionHelper;
import com.facebook.friendsharing.souvenirs.util.SouvenirsElementHelper;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.mediagallery.abtest.ExperimentsForMediaGalleryAbTestModule;
import com.facebook.photos.warning.ObjectionableContentController;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.toaster.ClickableToastBuilder;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalyticsRequiredInfo;
import com.facebook.video.analytics.VideoAnalyticsRequiredInfo.Builder;
import com.facebook.video.analytics.VideoFeedStoryInfo;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: groups_tab */
public class CollageAttachmentPartDefinition<E extends HasFeedListType & HasImageLoadListener & HasPositionInformation & HasPrefetcher & HasInvalidate> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, CollageAttachmentView> {
    public static final ViewType f21522a = new C08521();
    private static final CallerContext f21523b = CallerContext.m9065b(CollageAttachmentPartDefinition.class, "newsfeed_story_attachment_photo_grid_view", "native_newsfeed");
    private static final CallerContext f21524c = CallerContext.m9065b(CollageAttachmentPartDefinition.class, "newsfeed_story_attachment_photo_feed_prefetch", "native_newsfeed");
    private static CollageAttachmentPartDefinition f21525y;
    private static final Object f21526z = new Object();
    private final FbDraweeControllerBuilder f21527d;
    private final BackgroundPartDefinition f21528e;
    private final CollageLayoutCalculatorProvider f21529f;
    public final Lazy<CollageMediaGalleryLaunchHelper> f21530g;
    public final FeedImageLoader f21531h;
    public final SnowflakeLauncherHelper f21532i;
    private final DefaultCollageLayoutPropertiesProvider f21533j;
    private final DataSavingsCollageLayoutPropertiesProvider f21534k;
    private final PostpostTaggingUtil f21535l;
    private final PhotoGridProperties f21536m;
    private final DialtoneController f21537n;
    public final QeAccessor f21538o;
    private final OptimisticStoryStateCache f21539p;
    private final CollagePaddingHelper f21540q;
    public final Lazy<NetworkMonitor> f21541r;
    public final Lazy<ClickableToastBuilder> f21542s;
    public final Lazy<SecureContextHelper> f21543t;
    private final AutomaticPhotoCaptioningUtils f21544u;
    private final DataSensitivitySettingsPrefUtil f21545v;
    private final ObjectionableContentController f21546w;
    public final FbDataConnectionManager f21547x;

    /* compiled from: groups_tab */
    final class C08521 extends ViewType {
        C08521() {
        }

        public final View mo1995a(Context context) {
            return new CollageAttachmentView(context);
        }
    }

    private static CollageAttachmentPartDefinition m29247b(InjectorLike injectorLike) {
        return new CollageAttachmentPartDefinition(FbDraweeControllerBuilder.m19409a(injectorLike), (CollageLayoutCalculatorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CollageLayoutCalculatorProvider.class), BackgroundPartDefinition.m19135a(injectorLike), FeedImageLoader.m28808a(injectorLike), IdBasedLazy.m1808a(injectorLike, 6175), SnowflakeLauncherHelper.m29260a(injectorLike), (DefaultCollageLayoutPropertiesProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DefaultCollageLayoutPropertiesProvider.class), (DataSavingsCollageLayoutPropertiesProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DataSavingsCollageLayoutPropertiesProvider.class), PostpostTaggingUtil.m28760a(injectorLike), PhotoGridProperties.m28821a(injectorLike), DialtoneControllerImpl.m8272a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), OptimisticStoryStateCache.m9726a(injectorLike), CollagePaddingHelper.m29278a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 587), IdBasedLazy.m1808a(injectorLike, 3585), IdBasedSingletonScopeProvider.m1810b(injectorLike, 968), AutomaticPhotoCaptioningUtils.m10186a(injectorLike), DataSensitivitySettingsPrefUtil.m8604a(injectorLike), ObjectionableContentController.m27812a(injectorLike), FbDataConnectionManager.m3787a(injectorLike));
    }

    public static CollageAttachmentPartDefinition m29238a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CollageAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21526z) {
                CollageAttachmentPartDefinition collageAttachmentPartDefinition;
                if (a2 != null) {
                    collageAttachmentPartDefinition = (CollageAttachmentPartDefinition) a2.mo818a(f21526z);
                } else {
                    collageAttachmentPartDefinition = f21525y;
                }
                if (collageAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m29247b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21526z, b3);
                        } else {
                            f21525y = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = collageAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    private void m29243a(FeedProps<GraphQLStoryAttachment> feedProps, State state, CollageAttachmentView collageAttachmentView) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
        if (this.f21537n.mo1231j() && (state.a instanceof DegradableDraweeController) && ((DegradableDraweeController) state.a).e) {
            int size;
            if (graphQLStoryAttachment.m23987z() == null || graphQLStoryAttachment.m23987z().ew() == null) {
                size = state.c.size() + state.g;
            } else {
                size = graphQLStoryAttachment.m23987z().ew().m24477a();
            }
            ((DegradableDraweeController) state.a).a(size, FeatureType.PHOTO);
            collageAttachmentView.a(state.b, state.a);
        } else {
            collageAttachmentView.a(state.b, state.d);
            collageAttachmentView.u = state.f;
            collageAttachmentView.l = state.g;
            m29248b(feedProps, state, collageAttachmentView);
        }
        collageAttachmentView.r = state.h;
        collageAttachmentView.b();
    }

    public final boolean m29253a(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
        if (m29256b((FeedProps) feedProps)) {
            return this.f21536m.m28830f(graphQLStoryAttachment) && this.f21538o.mo596a(ExperimentsForComposerAbTestModule.S, false);
        } else {
            return this.f21536m.m28830f(graphQLStoryAttachment);
        }
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PaddingStyle paddingStyle;
        FeedProps feedProps = (FeedProps) obj;
        HasFeedListType hasFeedListType = (HasFeedListType) anyEnvironment;
        SinglePartDefinition singlePartDefinition = this.f21528e;
        FeedProps e = AttachmentProps.m28715e(feedProps);
        CollagePaddingHelper collagePaddingHelper = this.f21540q;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) hasFeedListType;
        Object obj2 = null;
        if (AttachmentProps.m28714c(feedProps) != null) {
            FeedProps e2 = AttachmentProps.m28715e(feedProps);
            if (e2 != null && collagePaddingHelper.f21574c.m9602m(e2) > 0) {
                obj2 = 1;
            }
        }
        if (obj2 == null) {
            paddingStyle = PaddingStyle.f13076f;
        } else if (collagePaddingHelper.f21572a.mo596a(ExperimentsForNewsFeedAbTestModule.ai, false)) {
            paddingStyle = BackgroundStyleUtil.a(feedProps, collagePaddingHelper.f21573b, hasPositionInformation);
        } else {
            paddingStyle = PaddingStyle.f13076f;
        }
        subParts.mo2756a(singlePartDefinition, new StylingData(e, paddingStyle));
        return m29237a(feedProps, hasFeedListType);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        CollageAttachmentView collageAttachmentView = (CollageAttachmentView) view;
        collageAttachmentView.a();
        collageAttachmentView.u = null;
        collageAttachmentView.l = 0;
        collageAttachmentView.a(0, 0, null, 0);
        collageAttachmentView.c();
    }

    @Inject
    public CollageAttachmentPartDefinition(FbDraweeControllerBuilder fbDraweeControllerBuilder, CollageLayoutCalculatorProvider collageLayoutCalculatorProvider, BackgroundPartDefinition backgroundPartDefinition, FeedImageLoader feedImageLoader, Lazy<CollageMediaGalleryLaunchHelper> lazy, SnowflakeLauncherHelper snowflakeLauncherHelper, DefaultCollageLayoutPropertiesProvider defaultCollageLayoutPropertiesProvider, DataSavingsCollageLayoutPropertiesProvider dataSavingsCollageLayoutPropertiesProvider, PostpostTaggingUtil postpostTaggingUtil, PhotoGridProperties photoGridProperties, DialtoneController dialtoneController, QeAccessor qeAccessor, OptimisticStoryStateCache optimisticStoryStateCache, CollagePaddingHelper collagePaddingHelper, Lazy<NetworkMonitor> lazy2, Lazy<ClickableToastBuilder> lazy3, Lazy<SecureContextHelper> lazy4, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils, DataSensitivitySettingsPrefUtil dataSensitivitySettingsPrefUtil, ObjectionableContentController objectionableContentController, FbDataConnectionManager fbDataConnectionManager) {
        this.f21527d = fbDraweeControllerBuilder;
        this.f21528e = backgroundPartDefinition;
        this.f21529f = collageLayoutCalculatorProvider;
        this.f21530g = lazy;
        this.f21531h = feedImageLoader;
        this.f21532i = snowflakeLauncherHelper;
        this.f21533j = defaultCollageLayoutPropertiesProvider;
        this.f21534k = dataSavingsCollageLayoutPropertiesProvider;
        this.f21535l = postpostTaggingUtil;
        this.f21536m = photoGridProperties;
        this.f21537n = dialtoneController;
        this.f21538o = qeAccessor;
        this.f21539p = optimisticStoryStateCache;
        this.f21540q = collagePaddingHelper;
        this.f21541r = lazy2;
        this.f21542s = lazy3;
        this.f21543t = lazy4;
        this.f21544u = automaticPhotoCaptioningUtils;
        this.f21545v = dataSensitivitySettingsPrefUtil;
        this.f21546w = objectionableContentController;
        this.f21547x = fbDataConnectionManager;
    }

    public final ViewType mo2547a() {
        return f21522a;
    }

    private State m29237a(FeedProps<GraphQLStoryAttachment> feedProps, E e) {
        CollageLayoutProperties a;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.m19804a();
        FeedListType c = e.mo2446c();
        if (this.f21545v.m8609b(false)) {
            a = this.f21534k.m29277a(feedProps);
        } else {
            a = this.f21533j.m29276a(feedProps);
        }
        CollageLayoutCalculator a2 = this.f21529f.m29258a(a);
        ImmutableList a3 = a2.a();
        int size = a3.size();
        String[] strArr = new String[size];
        HashSet hashSet = new HashSet();
        DraweeController[] draweeControllerArr = new DraweeController[size];
        ImageRequest[] imageRequestArr = new ImageRequest[size];
        AbstractDraweeControllerBuilder a4 = this.f21527d.m19417a(f21523b);
        for (int i = 0; i < size; i++) {
            Object obj;
            GraphQLStoryAttachment graphQLStoryAttachment2 = (GraphQLStoryAttachment) ((StoryCollageItem) a3.get(i)).c().m19804a();
            if (!(graphQLStoryAttachment2.m23979r() == null || graphQLStoryAttachment2.m23979r().m24452b() == null)) {
                hashSet.add(graphQLStoryAttachment2.m23979r().m24452b());
            }
            GraphQLMedia r = graphQLStoryAttachment2.m23979r();
            ImageRequest a5 = this.f21531h.m28816a((FeedProps) feedProps, graphQLStoryAttachment2);
            if (a5 == null) {
                obj = null;
            } else {
                a5 = ImageRequestBuilder.m18777a(a5).m18784b(true).m18782a(m29239a(this, (HasFeedListType) e, r)).m18785m();
            }
            a4.m19452c(obj);
            a4.m19456d(this.f21531h.m28820b((FeedProps) feedProps, graphQLStoryAttachment2));
            ((HasPrefetcher) e).mo2434a(obj, f21523b);
            imageRequestArr[i] = obj;
            Object s = a4.m19435s();
            if (obj != null) {
                ((HasImageLoadListener) e).mo2426a(s, AttachmentProps.m28712a((FeedProps) feedProps).mo2507g(), obj);
            }
            draweeControllerArr[i] = s;
            strArr[i] = m29240a(graphQLStoryAttachment2);
        }
        if (this.f21538o.mo596a(ExperimentsForMultiRowQEModule.f5940x, false)) {
            m29245a(graphQLStoryAttachment, (HasFeedListType) e, hashSet);
        }
        int i2 = 0;
        SouvenirsDetailsFieldsModel souvenirsDetailsFieldsModel = null;
        GraphQLObjectType j = graphQLStoryAttachment.m23987z() == null ? null : graphQLStoryAttachment.m23987z().m23390j();
        if (j != null && j.m22301g() == 1814734639) {
            souvenirsDetailsFieldsModel = SouvenirsConversionHelper.a(graphQLStoryAttachment.m23987z());
            i2 = (SouvenirsElementHelper.b(souvenirsDetailsFieldsModel, false) - a3.size()) + 1;
        } else if (graphQLStoryAttachment.m23987z() != null && graphQLStoryAttachment.m23987z().ew() != null) {
            i2 = (graphQLStoryAttachment.m23987z().ew().m24477a() - a3.size()) + 1;
        } else if (graphQLStoryAttachment.m23985x() != null) {
            i2 = (graphQLStoryAttachment.m23985x().size() - a3.size()) + 1;
        }
        DraweeController draweeController = null;
        if (this.f21537n.mo1231j()) {
            draweeController = this.f21527d.m19417a(f21523b).m19434r().m19435s();
        }
        return new State(a2, a3, draweeControllerArr, draweeController, imageRequestArr, m29233a(feedProps, c, m29256b((FeedProps) feedProps), a3, imageRequestArr, i2, e, souvenirsDetailsFieldsModel), i2, strArr);
    }

    private void m29245a(GraphQLStoryAttachment graphQLStoryAttachment, E e, HashSet<String> hashSet) {
        int a = this.f21538o.mo572a(ExperimentsForMultiRowQEModule.f5941y, 10);
        ImmutableList x = graphQLStoryAttachment.m23985x();
        int size = x.size();
        int i = 0;
        while (i < size) {
            int i2;
            GraphQLMedia r = ((GraphQLStoryAttachment) x.get(i)).m23979r();
            if (r == null || r.m24452b() == null || r.an() || hashSet.contains(r.m24452b())) {
                i2 = a;
            } else {
                Object obj;
                ImageRequest a2;
                ConnectionQuality c = this.f21547x.m3801c();
                if (ConnectionQuality.POOR == c || ConnectionQuality.UNKNOWN == c) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    if (r.m24446Y() != null) {
                        a2 = ImageRequest.m18796a(r.m24446Y().mo2924b());
                    }
                    a2 = null;
                } else {
                    if (r.m24447Z() != null) {
                        a2 = ImageRequest.m18796a(r.m24447Z().mo2924b());
                    }
                    a2 = null;
                }
                if (a2 != null) {
                    ((HasPrefetcher) e).mo2434a(a2, f21524c);
                }
                i2 = a - 1;
                if (i2 <= 0) {
                    return;
                }
            }
            i++;
            a = i2;
        }
    }

    private String m29240a(GraphQLStoryAttachment graphQLStoryAttachment) {
        return this.f21544u.m10188a() ? graphQLStoryAttachment.m23979r().m24454k() : null;
    }

    private OnImageClickListener<StoryCollageItem> m29233a(FeedProps<GraphQLStoryAttachment> feedProps, FeedListType feedListType, boolean z, ImmutableList<StoryCollageItem> immutableList, ImageRequest[] imageRequestArr, int i, E e, @Nullable SouvenirsDetailsFields souvenirsDetailsFields) {
        if (z) {
            return null;
        }
        if (feedListType.mo2419a() == FeedListName.REACTION) {
            return m29236a((FeedProps) feedProps, imageRequestArr, FullscreenGallerySource.REACTION_FEED_STORY_PHOTO_ALBUM, false);
        }
        if (souvenirsDetailsFields != null) {
            return m29234a((FeedProps) feedProps, (SouvenirsDetailsFieldsModel) souvenirsDetailsFields);
        }
        return m29235a((FeedProps) feedProps, (ImmutableList) immutableList, imageRequestArr, i, feedListType, (HasFeedListType) e);
    }

    private void m29248b(FeedProps<GraphQLStoryAttachment> feedProps, State state, CollageAttachmentView collageAttachmentView) {
        int i;
        if (m29246a(state)) {
            i = 0;
        } else {
            int size = state.c.size();
            int i2 = 0;
            i = 0;
            for (int i3 = 0; i3 < state.c.size(); i3++) {
                GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((StoryCollageItem) state.c.get(i3)).a.f13444a;
                i2 += this.f21535l.m28767a(graphQLStoryAttachment.m23979r());
                if (this.f21535l.m28770b(feedProps, graphQLStoryAttachment.m23979r())) {
                    size = Math.min(size, i3);
                    i = true;
                }
            }
            if (i != 0) {
                collageAttachmentView.a(1, i2, m29236a((FeedProps) feedProps, state.e, FullscreenGallerySource.NEWSFEED, true), size);
            }
        }
        if (i == 0) {
            collageAttachmentView.a(0, 0, null, 0);
        }
    }

    private static boolean m29246a(State state) {
        ImmutableList immutableList = state.c;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (((StoryCollageItem) immutableList.get(i)).a()) {
                return true;
            }
        }
        return false;
    }

    private OnImageClickListener<StoryCollageItem> m29236a(FeedProps<GraphQLStoryAttachment> feedProps, ImageRequest[] imageRequestArr, FullscreenGallerySource fullscreenGallerySource, boolean z) {
        return new 2(this, feedProps, imageRequestArr, fullscreenGallerySource, z);
    }

    private OnImageClickListener<StoryCollageItem> m29235a(FeedProps<GraphQLStoryAttachment> feedProps, ImmutableList<StoryCollageItem> immutableList, ImageRequest[] imageRequestArr, int i, FeedListType feedListType, E e) {
        return new 3(this, immutableList, i, feedProps, imageRequestArr, e, feedListType);
    }

    private OnImageClickListener<StoryCollageItem> m29234a(FeedProps<GraphQLStoryAttachment> feedProps, SouvenirsDetailsFields souvenirsDetailsFields) {
        return new 5(this, (String) Preconditions.checkNotNull(souvenirsDetailsFields.b()), AttachmentProps.m28715e(feedProps));
    }

    private void m29241a(CollageAttachmentView collageAttachmentView, GraphQLMedia graphQLMedia, FeedProps<GraphQLStoryAttachment> feedProps, ImageRequest[] imageRequestArr, FullscreenGallerySource fullscreenGallerySource, int i) {
        if (this.f21538o.mo596a(ExperimentsForMediaGalleryAbTestModule.l, false)) {
            ((CollageMediaGalleryLaunchHelper) this.f21530g.get()).a(collageAttachmentView, i, feedProps, imageRequestArr[i], fullscreenGallerySource, false, true);
            return;
        }
        m29242a(collageAttachmentView, GraphQLMediaConversionHelper.b(graphQLMedia));
    }

    private static void m29242a(CollageAttachmentView collageAttachmentView, GraphQLVideo graphQLVideo) {
        Activity activity = (Activity) ContextUtils.m2500a(collageAttachmentView.getContext(), Activity.class);
        if (activity != null) {
            FeedProps feedProps;
            ArrayNode arrayNode;
            ImmersiveVideoPlayer k = ((FullScreenVideoPlayerHost) activity).mo798k();
            if (graphQLVideo == null || graphQLVideo.m24097z() == null) {
                feedProps = null;
            } else {
                feedProps = FeedProps.m19802c(graphQLVideo.m24097z()).m19803a(StoryAttachmentHelper.m28042o(graphQLVideo.m24097z()));
            }
            FeedProps feedProps2 = feedProps;
            if (feedProps2 == null || feedProps2.f13444a == null) {
                arrayNode = null;
            } else {
                arrayNode = TrackableFeedProps.m27451a(feedProps2);
            }
            VideoAnalyticsRequiredInfo a = new Builder(graphQLVideo.m24060J()).a();
            VideoFeedStoryInfo.Builder builder = new VideoFeedStoryInfo.Builder(arrayNode);
            builder.b = EventTriggerType.BY_USER;
            VideoFeedStoryInfo.Builder builder2 = builder;
            builder2.d = false;
            FeedFullScreenParams feedFullScreenParams = new FeedFullScreenParams(a, builder2.a(), ImageRequest.m18796a(graphQLVideo.m24062L().mo2924b()), graphQLVideo, feedProps2);
            feedFullScreenParams.a(PlayerOrigin.COLLAGE_MIXED_MEDIA);
            k.a(feedFullScreenParams);
        }
    }

    public static boolean m29249d(CollageAttachmentPartDefinition collageAttachmentPartDefinition) {
        return collageAttachmentPartDefinition.f21538o.mo593a(Liveness.Live, ExposureLogging.Off, ExperimentsForMediaGalleryAbTestModule.m, false);
    }

    public final boolean m29256b(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStory c = AttachmentProps.m28714c(feedProps);
        if (c == null) {
            return false;
        }
        if (StoryAttachmentHelper.m28038k(c) || StoryAttachmentHelper.m28041n(c) || !this.f21539p.m9730b(AttachmentProps.m28714c(feedProps))) {
            return true;
        }
        return false;
    }

    @Nullable
    public static Postprocessor m29239a(CollageAttachmentPartDefinition collageAttachmentPartDefinition, HasFeedListType hasFeedListType, GraphQLMedia graphQLMedia) {
        return (collageAttachmentPartDefinition.f21546w.m27823a(graphQLMedia) && hasFeedListType.mo2446c().mo2419a() == FeedListName.FEED) ? collageAttachmentPartDefinition.f21546w.m27824b() : null;
    }
}
