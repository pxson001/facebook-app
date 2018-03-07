package com.facebook.ipc.composer.intent;

import android.net.Uri;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.UriUtil;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActorUtil;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLPrivacyOptionsContentEdge;
import com.facebook.graphql.model.GraphQLPrivacyScope;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StoryCommerceHelper;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.groupcommerce.model.GroupCommerceCategory;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.model.ComposerCommerceInfo;
import com.facebook.ipc.composer.model.ComposerEntryPicker;
import com.facebook.ipc.composer.model.ComposerLaunchLoggingParams;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.composer.model.ProductItemAttachment;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.katana.model.GeoRegion.ImplicitLocation;
import com.facebook.ipc.media.MediaIdKey;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.data.LocalMediaData;
import com.facebook.ipc.media.data.MediaData;
import com.facebook.ipc.media.data.MediaData.Type;
import com.facebook.photos.base.media.MediaItemFactory.PhotoItemBuilder;
import com.facebook.photos.base.media.MediaItemFactory.VideoItemBuilder;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel.LocationModel;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quotes.QuoteExtractor;
import com.facebook.story.GraphQLStoryHelper;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: java.io.ObjectInputStream */
public class ComposerConfigurationFactory {
    private final QeAccessor f18706a;
    private final AbstractFbErrorReporter f18707b;
    private final ViewerContextManager f18708c;

    public static ComposerConfigurationFactory m26271b(InjectorLike injectorLike) {
        return new ComposerConfigurationFactory(QeInternalImplMethodAutoProvider.m3744a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), ViewerContextManagerProvider.m2496b(injectorLike));
    }

    public static ComposerConfigurationFactory m26263a(InjectorLike injectorLike) {
        return m26271b(injectorLike);
    }

    @Inject
    public ComposerConfigurationFactory(QeAccessor qeAccessor, AbstractFbErrorReporter abstractFbErrorReporter, ViewerContextManager viewerContextManager) {
        this.f18706a = qeAccessor;
        this.f18707b = abstractFbErrorReporter;
        this.f18708c = viewerContextManager;
    }

    private static boolean m26278d(ComposerSourceType composerSourceType) {
        return composerSourceType == ComposerSourceType.FEED || composerSourceType == ComposerSourceType.FEED_INLINE || composerSourceType == ComposerSourceType.GROUP || composerSourceType == ComposerSourceType.TIMELINE || composerSourceType == ComposerSourceType.STORY_CALL_TO_ACTION || composerSourceType == ComposerSourceType.REACTION || composerSourceType == ComposerSourceType.COMPOST || composerSourceType == ComposerSourceType.EVENT;
    }

    @Deprecated
    public static Builder m26258a(ComposerSourceType composerSourceType) {
        return ComposerConfiguration.newBuilder().setComposerType(ComposerType.STATUS).setSourceType(composerSourceType).setUseOptimisticPosting(m26278d(composerSourceType));
    }

    public static Builder m26256a(ComposerSourceSurface composerSourceSurface, String str) {
        boolean z;
        boolean z2 = true;
        Preconditions.checkArgument(composerSourceSurface != ComposerSourceSurface.UNKNOWN);
        if (StringUtil.m3599c((CharSequence) str)) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        Builder launchLoggingParams = m26258a(ComposerSourceType.UNKNOWN).setLaunchLoggingParams(ComposerLaunchLoggingParams.newBuilder().setSourceSurface(composerSourceSurface).setEntryPointDescription(str).a());
        if (composerSourceSurface == ComposerSourceSurface.NEWSFEED || composerSourceSurface == ComposerSourceSurface.GROUP_FEED || composerSourceSurface == ComposerSourceSurface.TIMELINE || composerSourceSurface == ComposerSourceSurface.REACTION || composerSourceSurface == ComposerSourceSurface.COMPOST) {
            z = true;
        } else {
            z = false;
        }
        return launchLoggingParams.setUseOptimisticPosting(z);
    }

    public static Builder m26257a(ComposerSourceSurface composerSourceSurface, String str, String str2, ComposerTargetData composerTargetData, ImmutableList<GroupCommerceCategory> immutableList) {
        Builder initialTargetData = m26256a(composerSourceSurface, str).setComposerType(ComposerType.SELL).setHideKeyboardIfReachedMinimumHeight(true).setCommerceInfo(ComposerCommerceInfo.newBuilder().setCurrencyCode(str2).a()).setInitialTargetData(composerTargetData);
        if (immutableList != null) {
            initialTargetData.setGroupCommerceCategories(immutableList);
        }
        return initialTargetData;
    }

    public static Builder m26262a(ComposerSourceType composerSourceType, boolean z, long j, String str, CurationMechanism curationMechanism, CurationSurface curationSurface) {
        ComposerTargetData.Builder builder = new ComposerTargetData.Builder(j, TargetType.PAGE_RECOMMENDATION);
        builder.c = str;
        return ComposerConfiguration.newBuilder().setSourceType(composerSourceType).setIsEdit(z).setInitialTargetData(builder.a()).setOgMechanism(curationMechanism).setOgSurface(curationSurface).setComposerType(ComposerType.RECOMMENDATION).setDisableMentions(true).setDisableFriendTagging(true).setDisablePhotos(true);
    }

    public static Builder m26269b(ComposerSourceType composerSourceType) {
        return ComposerConfiguration.newBuilder().setComposerType(ComposerType.LIFE_EVENT).setLaunchLoggingParams(ComposerLaunchLoggingParams.newBuilder().setEntryPicker(ComposerEntryPicker.LIFE_EVENT_TYPE_PICKER).a()).setSourceType(composerSourceType).setDisableMentions(true);
    }

    public static Builder m26274c(ComposerSourceType composerSourceType) {
        return ComposerConfiguration.newBuilder().setComposerType(ComposerType.STATUS).setSourceType(composerSourceType).setUseOptimisticPosting(m26278d(composerSourceType));
    }

    public final Builder m26279a(ComposerSourceType composerSourceType, String str, String str2, String str3, boolean z, ImmutableList<GraphQLExploreFeed> immutableList) {
        if (!this.f18706a.mo596a(ExperimentsForComposerAbTestModule.k, false)) {
            z = false;
        }
        return ComposerConfiguration.newBuilder().setLegacyApiStoryId((String) Preconditions.checkNotNull(str)).setStoryId(str2).setCacheId(str3).setComposerType(ComposerType.STATUS).setIsEdit(true).setIsEditTagEnabled(z).setSourceType(composerSourceType).setTopics(immutableList).setUseOptimisticPosting(composerSourceType == ComposerSourceType.FEED);
    }

    public static Builder m26255a() {
        return ComposerConfiguration.newBuilder().setComposerType(ComposerType.STATUS).setSourceType(ComposerSourceType.PAGE).setDisableAttachToAlbum(true);
    }

    public static Builder m26261a(ComposerSourceType composerSourceType, ComposerShareParams composerShareParams) {
        return ComposerConfiguration.newBuilder().setComposerType(ComposerType.SHARE).setSourceType(composerSourceType).setInitialShareParams(composerShareParams);
    }

    public static Builder m26270b(ComposerSourceType composerSourceType, ComposerShareParams composerShareParams) {
        return ComposerConfiguration.newBuilder().setComposerType(ComposerType.SHARE).setSourceType(composerSourceType).setInitialShareParams(composerShareParams);
    }

    public static Builder m26260a(ComposerSourceType composerSourceType, @Nullable GraphQLStory graphQLStory, ComposerShareParams composerShareParams) {
        return ComposerConfiguration.newBuilder().setComposerType(ComposerType.SHARE).setSourceType(composerSourceType).setAttachedStory(graphQLStory).setUseOptimisticPosting(m26278d(composerSourceType)).setAllowsRedSpaceToggle(true).setInitialShareParams(composerShareParams);
    }

    public static Builder m26275c(ComposerSourceType composerSourceType, ComposerShareParams composerShareParams) {
        GraphQLStory graphQLStory = null;
        GraphQLEntity graphQLEntity = composerShareParams.shareable;
        Preconditions.checkNotNull(graphQLEntity);
        if (GraphQLHelper.m22445a(graphQLEntity) != 2479791) {
            GraphQLStory.Builder builder = new GraphQLStory.Builder();
            builder.X = graphQLEntity.m22571x();
            graphQLStory = builder.a();
        }
        return m26260a(composerSourceType, graphQLStory, composerShareParams);
    }

    public static Builder m26259a(ComposerSourceType composerSourceType, long j) {
        return m26275c(composerSourceType, ComposerShareParams.Builder.a(GraphQLHelper.m22452a(String.valueOf(j), 2479791)).b());
    }

    public static void m26268a(GraphQLStory graphQLStory, Builder builder) {
        if (graphQLStory.aR() != null && graphQLStory.aR().m24957a() != null && !graphQLStory.aR().m24957a().isEmpty()) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            List a = graphQLStory.aR().m24957a();
            for (int i = 0; i < a.size(); i++) {
                builder2.m1069c(m26264a((GraphQLActor) a.get(i)));
            }
            builder.setInitialTaggedUsers(builder2.m1068b());
        }
    }

    public final void m26280a(GraphQLStory graphQLStory, Builder builder, boolean z) {
        String str = null;
        if (z) {
            builder.setIsEditPrivacyEnabled(graphQLStory.m22332R());
            builder.setEditPostFeatureCapabilities(graphQLStory.aS());
        }
        if (m26276c(graphQLStory)) {
            builder.setComposerType(ComposerType.SELL);
            GraphQLNode z2 = StoryCommerceHelper.a(graphQLStory).m23987z();
            String a = z2.fs() != null ? z2.fs().mo2911a() : null;
            if (z2.db() != null) {
                str = z2.db().mo2911a();
            }
            Long valueOf = Long.valueOf(Long.parseLong(z2.ec().m23886n()) / 100);
            String k = z2.ec().m23883k();
            builder.setIsEdit(z).setCommerceInfo(ComposerCommerceInfo.newBuilder().setCurrencyCode(k).a()).setProductItemAttachment(new ProductItemAttachment.Builder().a(StoryAttachmentHelper.m28042o(graphQLStory).m23964A()).b(a).c(str).a(valueOf).d(k).a());
        }
        ComposerTargetData d = m26277d(graphQLStory);
        builder.setInitialTargetData(d);
        if (d.a()) {
            builder.setInitialPageData(ComposerPageData.newBuilder().setPostAsPageViewerContext(this.f18708c.mo217d()).a());
        }
        if (StoryHierarchyHelper.m27435b(graphQLStory) != null) {
            builder.setInitialText(StoryHierarchyHelper.m27435b(graphQLStory));
        }
        GraphQLPrivacyScope c = GraphQLStoryHelper.m10201c(graphQLStory);
        if (!(c == null || c.m23519p() == null || c.m23519p().m27676a() == null || c.m23519p().m27676a().isEmpty() || ((GraphQLPrivacyOptionsContentEdge) c.m23519p().m27676a().get(0)).j() == null)) {
            builder.setInitialPrivacyOverride(((GraphQLPrivacyOptionsContentEdge) c.m23519p().m27676a().get(0)).j());
        }
        if (!(graphQLStory.aR() == null || graphQLStory.aR().m24957a() == null || graphQLStory.aR().m24957a().isEmpty())) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (GraphQLActor a2 : graphQLStory.aR().m24957a()) {
                try {
                    builder2.m1069c(m26264a(a2));
                } catch (NumberFormatException e) {
                }
            }
            builder.setInitialTaggedUsers(builder2.m1068b());
        }
        CheckinPlaceModel a3 = m26266a(graphQLStory);
        if (a3 != null) {
            builder.setInitialLocationInfo(ComposerLocationInfo.newBuilder().b(a3).b());
        } else {
            ImplicitLocation b = m26272b(graphQLStory);
            if (b != null) {
                builder.setInitialLocationInfo(ComposerLocationInfo.newBuilder().a(b).b());
            }
        }
        MinutiaeObject a4 = MinutiaeObject.a(graphQLStory);
        if (a4 != null) {
            builder.setMinutiaeObjectTag(a4);
        }
        if (a4 == null || !a4.h()) {
            m26273b(graphQLStory, builder, z);
        }
    }

    @Nullable
    private static CheckinPlaceModel m26266a(GraphQLStory graphQLStory) {
        CheckinPlaceModel checkinPlaceModel = null;
        double d = -200.0d;
        GraphQLPlace Y = graphQLStory.m22339Y();
        if (Y != null) {
            double a;
            if (GraphQLHelper.m22517m(graphQLStory)) {
                GraphQLLocation z = Y.m24173z();
                a = z.mo2957a();
                d = z.mo2958b();
            } else {
                a = -200.0d;
            }
            try {
                checkinPlaceModel = new CheckinPlaceModel.Builder().a(Y.m24171x()).b(Y.m24126B()).a(new LocationModel.Builder().a(a).b(d).a()).a();
            } catch (NumberFormatException e) {
            }
        }
        return checkinPlaceModel;
    }

    @Nullable
    private static ImplicitLocation m26272b(GraphQLStory graphQLStory) {
        GraphQLPlace ae = graphQLStory.ae();
        if (ae == null) {
            return null;
        }
        return ImplicitLocation.a(ae.m24126B(), Long.parseLong(ae.m24171x())).a();
    }

    private static ComposerTaggedUser m26264a(GraphQLActor graphQLActor) {
        ComposerTaggedUser.Builder a = ComposerTaggedUser.a(Long.parseLong(graphQLActor.m23765H()));
        a.b = graphQLActor.aa();
        a = a;
        a.c = GraphQLHelper.m22471a(graphQLActor);
        return a.a();
    }

    private static boolean m26276c(GraphQLStory graphQLStory) {
        return (StoryAttachmentHelper.m28042o(graphQLStory) == null || StoryAttachmentHelper.m28042o(graphQLStory).m23984w() == null || !StoryAttachmentHelper.m28042o(graphQLStory).m23984w().contains(GraphQLStoryAttachmentStyle.GROUP_SELL_PRODUCT_ITEM)) ? false : true;
    }

    private static ComposerTargetData m26277d(GraphQLStory graphQLStory) {
        ComposerTargetData.Builder builder;
        if (graphQLStory != null && graphQLStory.aJ() != null && graphQLStory.aJ().m23000j() != null) {
            TargetType targetType;
            String b;
            long parseLong = Long.parseLong(graphQLStory.aJ().m22999b());
            switch (graphQLStory.aJ().m23000j().m22301g()) {
                case 2479791:
                    targetType = TargetType.PAGE;
                    break;
                case 2645995:
                    targetType = TargetType.USER;
                    break;
                case 67338874:
                    targetType = TargetType.EVENT;
                    break;
                case 69076575:
                    targetType = TargetType.GROUP;
                    break;
                default:
                    targetType = TargetType.OTHER;
                    break;
            }
            builder = new ComposerTargetData.Builder(parseLong, targetType);
            builder.c = graphQLStory.aJ().m22987U();
            builder = builder;
            GraphQLProfile aJ = graphQLStory.aJ();
            if (GraphQLHelper.m22483a(aJ)) {
                b = aJ.ai().mo2924b();
            } else {
                b = "";
            }
            builder.d = b;
            return builder.a();
        } else if (graphQLStory == null || !CollectionUtil.m29343b(graphQLStory.m22349b()) || ((GraphQLActor) graphQLStory.m22349b().get(0)).m23790b() == null || ((GraphQLActor) graphQLStory.m22349b().get(0)).m23790b().m22301g() != 2479791) {
            return new ComposerTargetData.Builder().a();
        } else {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLStory.m22349b().get(0);
            ComposerTargetData.Builder builder2 = new ComposerTargetData.Builder(Long.parseLong(graphQLActor.m23765H()), TargetType.PAGE);
            builder2.c = GraphQLActorUtil.m29707a(graphQLActor);
            builder2 = builder2;
            builder2.d = GraphQLActorUtil.m29709c(graphQLActor);
            builder = builder2;
            builder.f = true;
            return builder.a();
        }
    }

    private void m26273b(GraphQLStory graphQLStory, Builder builder, boolean z) {
        String str = null;
        if (z) {
            builder.setCanViewerEditPostMedia(graphQLStory.m22331Q());
        }
        try {
            ComposerShareParams composerShareParams;
            if (StoryAttachmentHelper.m28029a(graphQLStory)) {
                GraphQLStoryAttachment o = StoryAttachmentHelper.m28042o(graphQLStory);
                if (!GraphQLStoryAttachmentUtil.m28049a(o, GraphQLStoryAttachmentStyle.MINUTIAE_UNIT)) {
                    if (StoryAttachmentHelper.m28030b(graphQLStory) || StoryAttachmentHelper.m28037j(graphQLStory)) {
                        List x = o.m23985x();
                        if (x.isEmpty()) {
                            builder.setInitialAttachments(ComposerAttachment.a(ImmutableList.of(m26265a(o.m23979r())), ImmutableList.of(GraphQLHelper.f15767h)));
                            return;
                        }
                        Collection arrayList = new ArrayList();
                        ImmutableList.Builder builder2 = ImmutableList.builder();
                        for (int i = 0; i < x.size(); i++) {
                            GraphQLMedia r = ((GraphQLStoryAttachment) x.get(i)).m23979r();
                            MediaItem a = m26265a(r);
                            if (a != null) {
                                Object obj;
                                arrayList.add(a);
                                if (r.az() == null) {
                                    obj = GraphQLHelper.f15767h;
                                } else {
                                    obj = r.az();
                                }
                                builder2.m1069c(obj);
                            }
                        }
                        builder.setInitialAttachments(ComposerAttachment.a(arrayList, builder2.m1068b()));
                    } else {
                        ComposerShareParams composerShareParams2;
                        GraphQLTextWithEntities r2 = GraphQLStoryAttachmentUtil.m28067r(o);
                        GraphQLTextWithEntities n = o.m23975n();
                        GraphQLMedia r3 = o.m23979r();
                        String a2 = QuoteExtractor.a(o);
                        String nullToEmpty = Strings.nullToEmpty(o.m23966C());
                        if (r2 == null || n == null) {
                            composerShareParams2 = null;
                        } else {
                            SharePreview.Builder c = new SharePreview.Builder().a(o.m23964A()).b(r2.mo2911a()).c(n.mo2911a());
                            if (!(r3 == null || r3.m24440S() == null)) {
                                str = r3.m24440S().mo2924b();
                            }
                            composerShareParams2 = ComposerShareParams.Builder.a(nullToEmpty).c(a2).a(c.d(str).a()).b();
                        }
                        composerShareParams = composerShareParams2;
                    }
                } else {
                    return;
                }
            } else if (graphQLStory.m22326L() != null) {
                GraphQLEntity av = graphQLStory.m22326L().av();
                composerShareParams = ComposerShareParams.Builder.a(av).a(SharePreview.a(graphQLStory.m22326L())).b();
            }
            builder.setInitialShareParams(composerShareParams);
        } catch (Throwable th) {
            this.f18707b.m2343a("composer_edit_intent", "Edit post attachment preview error " + m26267a(graphQLStory, graphQLStory.av()), th);
        }
    }

    private static MediaItem m26265a(GraphQLMedia graphQLMedia) {
        if (graphQLMedia == null || graphQLMedia.m24441T() == null) {
            return null;
        }
        float c = ((float) graphQLMedia.m24441T().mo2925c()) / ((float) graphQLMedia.m24441T().mo2923a());
        long parseLong = Long.parseLong(graphQLMedia.m24452b());
        if (Strings.isNullOrEmpty(graphQLMedia.aO())) {
            String uri;
            Uri parse = Uri.parse(graphQLMedia.m24441T().mo2924b());
            PhotoItemBuilder photoItemBuilder = new PhotoItemBuilder();
            LocalMediaData.Builder builder = new LocalMediaData.Builder();
            builder.d = parseLong;
            LocalMediaData.Builder builder2 = builder;
            MediaData.Builder builder3 = new MediaData.Builder();
            if (UriUtil.m18788a(parse)) {
                uri = parse.toString();
            } else {
                uri = parse.getPath();
            }
            MediaData.Builder a = builder3.a(new MediaIdKey(uri, parseLong).toString()).a(parse);
            a.h = c;
            photoItemBuilder.f = builder2.a(a.a(Type.Photo).a()).a();
            return photoItemBuilder.a();
        }
        VideoItemBuilder videoItemBuilder = new VideoItemBuilder();
        videoItemBuilder.g = parseLong;
        videoItemBuilder.j.d = parseLong;
        videoItemBuilder = videoItemBuilder.b(graphQLMedia.aO());
        videoItemBuilder.c = graphQLMedia.m24441T().mo2924b();
        videoItemBuilder = videoItemBuilder;
        videoItemBuilder.i.h = c;
        return videoItemBuilder.a();
    }

    private static String m26267a(GraphQLStory graphQLStory, GraphQLEntity graphQLEntity) {
        return "Story id: " + (graphQLStory != null ? graphQLStory.m22350c() : "") + ", shareable id " + (graphQLEntity != null ? graphQLEntity.mo2906d() : "");
    }
}
