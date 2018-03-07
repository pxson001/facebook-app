package com.facebook.feed.util.composer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.webkit.URLUtil;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.bitmaps.BitmapException;
import com.facebook.bitmaps.BitmapResizingParam;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.bitmaps.Dimension;
import com.facebook.bitmaps.ThumbnailMaker;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.common.time.Clock;
import com.facebook.common.unicode.CodePointRange;
import com.facebook.common.unicode.RangeConverter;
import com.facebook.common.unicode.UTF16Range;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.attachments.AttachmentUtils;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.attachments.MediaItemUtil;
import com.facebook.composer.metatext.MetaTextBuilder.ParamsBuilder;
import com.facebook.composer.metatext.MinutiaeTemplateMetaTextBuilder;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.util.ComposerUserNameUtil;
import com.facebook.feed.collage.offline.CollageLayoutModel;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.friendsharing.gif.util.GifUtil;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLRedSpaceVisibilityState;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLAggregatedEntitiesAtRange;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLCurrencyQuantity;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLEntityWithImage;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.graphql.model.GraphQLFeedTopicContent;
import com.facebook.graphql.model.GraphQLFeedTopicContent.Builder;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLHelper.4;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLImageAtRange;
import com.facebook.graphql.model.GraphQLInlineActivitiesConnection;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPageVisitsConnection;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLPrivacyScope;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLRedSpaceStoryInfo;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentStyleInfo;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLWithTagsConnection;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.conversion.GraphQLAlbumConversionHelper;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.parser.GraphQlIdParserUtil;
import com.facebook.groupcommerce.util.GraphQLProductItemAttachmentCreator;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.SharePreview;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.ipc.composer.model.OptimisticPostPrivacy;
import com.facebook.ipc.composer.model.ProductItemAttachment;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.ipc.katana.model.GeoRegion.ImplicitLocation;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.linkify.LinkifyTargetGraphQLInterfaces.LinkifyTargetGraphQL;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.photos.upload.serverprocessing.util.VideoProcessingUtil;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel.LocationModel;
import com.facebook.qe.api.QeAccessor;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import com.google.common.io.Files;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: should adjust  */
public class OptimisticPostStoryBuilder {
    private ThumbnailMaker f3801A;
    public String f3802B;
    public GraphQLFeedOptimisticPublishState f3803C;
    @Nullable
    public String f3804D;
    @Nullable
    public String f3805E;
    public RedSpaceValue f3806F;
    public String f3807G;
    @Nullable
    public ComposerShareParams f3808H;
    public boolean f3809I = false;
    public ImmutableList<GraphQLExploreFeed> f3810J;
    public boolean f3811K;
    private GraphQLLinkExtractor f3812a;
    private final Context f3813b;
    private final Clock f3814c;
    private final MinutiaeTemplateMetaTextBuilder f3815d;
    private final BitmapUtils f3816e;
    private final GraphQLProductItemAttachmentCreator f3817f;
    private final GraphQLTextWithEntities f3818g;
    private final ImmutableList<ComposerTaggedUser> f3819h;
    private final ImmutableList<MediaItem> f3820i;
    private final ImmutableList<String> f3821j;
    private final OptimisticStoryStateCache f3822k;
    private final OptimisticPostCollageChooser f3823l;
    private final Lazy<TempFileManager> f3824m;
    private final QeAccessor f3825n;
    public String f3826o;
    @Nullable
    public GraphQLAlbum f3827p;
    @Nullable
    public CheckinPlaceModel f3828q;
    @Nullable
    public ImplicitLocation f3829r;
    public GraphQLStory f3830s;
    @Nullable
    public ProductItemAttachment f3831t;
    public long f3832u;
    @Nullable
    public MinutiaeObject f3833v;
    public OptimisticPostPrivacy f3834w;
    public String f3835x;
    public String f3836y;
    private User f3837z;

    @Inject
    public OptimisticPostStoryBuilder(Context context, Clock clock, GraphQLLinkExtractor graphQLLinkExtractor, MinutiaeTemplateMetaTextBuilder minutiaeTemplateMetaTextBuilder, BitmapUtils bitmapUtils, ThumbnailMaker thumbnailMaker, GraphQLProductItemAttachmentCreator graphQLProductItemAttachmentCreator, OptimisticStoryStateCache optimisticStoryStateCache, OptimisticPostCollageChooser optimisticPostCollageChooser, Lazy<TempFileManager> lazy, QeAccessor qeAccessor, @Assisted GraphQLTextWithEntities graphQLTextWithEntities, @Assisted ImmutableList<ComposerTaggedUser> immutableList, @Assisted ImmutableList<ComposerAttachment> immutableList2) {
        this.f3813b = context;
        this.f3814c = clock;
        this.f3812a = graphQLLinkExtractor;
        this.f3815d = minutiaeTemplateMetaTextBuilder;
        this.f3816e = bitmapUtils;
        this.f3801A = thumbnailMaker;
        this.f3817f = graphQLProductItemAttachmentCreator;
        this.f3822k = optimisticStoryStateCache;
        this.f3823l = optimisticPostCollageChooser;
        this.f3824m = lazy;
        this.f3818g = graphQLTextWithEntities;
        this.f3819h = immutableList;
        this.f3820i = AttachmentUtils.e(immutableList2);
        this.f3821j = m4475c(immutableList2);
        this.f3825n = qeAccessor;
        this.f3811K = false;
    }

    public final GraphQLStory m4478a() {
        GraphQLProfile graphQLProfile;
        GraphQLTextWithEntities a;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLInlineActivitiesConnection g;
        String str;
        GraphQLRedSpaceVisibilityState graphQLRedSpaceVisibilityState;
        Preconditions.checkNotNull(this.f3834w);
        Preconditions.checkNotNull(this.f3813b);
        long parseLong = Long.parseLong(this.f3837z.d());
        GraphQLActor b = m4466b(parseLong, this.f3837z.j(), this.f3837z.x());
        if (this.f3832u == parseLong) {
            graphQLProfile = null;
        } else {
            graphQLProfile = m4451a(this.f3832u, this.f3835x, this.f3836y);
        }
        GraphQLPrivacyScope b2 = m4469b(this.f3834w);
        List b3 = m4472b(this.f3819h);
        GraphQLPlace b4 = m4468b(this.f3828q);
        GraphQLPlace a2 = m4450a(this.f3829r, b4);
        GraphQLTextWithEntities a3 = m4457a(this.f3818g);
        if (this.f3833v == null) {
            a = m4458a(this.f3818g.a(), b, (ImmutableList) b3, b4);
        } else {
            a = m4459a(this.f3818g.a(), b, b3, b4);
        }
        if (this.f3830s != null) {
            a = graphQLProfile == null ? m4456a(b) : null;
            graphQLTextWithEntities = null;
        } else if (this.f3827p != null && this.f3827p.y() != null && this.f3827p.y().a() != null) {
            a = null;
            graphQLTextWithEntities = null;
        } else if (StringUtil.c(this.f3818g.a()) || this.f3827p != null) {
            graphQLTextWithEntities = null;
        } else if (a.a() == null) {
            a = null;
            graphQLTextWithEntities = null;
        } else if (this.f3825n.a(ExperimentsForFeedUtilComposerAbtestModule.Q, false)) {
            graphQLTextWithEntities = null;
        } else {
            graphQLTextWithEntities = a;
            a = null;
        }
        GraphQLFeedTopicContent a4 = new Builder().a(this.f3810J).a();
        GraphQLEntity graphQLEntity = null;
        if (this.f3832u == Long.parseLong(this.f3837z.d()) && this.f3806F != RedSpaceValue.POST_TO_REDSPACE) {
            graphQLEntity = GraphQLHelper.b;
        }
        boolean z = this.f3827p == null && (!MediaItemUtil.e(this.f3820i) || m4476e());
        long a5 = this.f3814c.a();
        GraphQLStory.Builder b5 = new GraphQLStory.Builder().c(ImmutableList.of(b)).b(z);
        if (this.f3827p != null || MediaItemUtil.e(this.f3820i)) {
            z = false;
        } else {
            z = true;
        }
        GraphQLStory.Builder f = b5.c(z).a(a5 / 1000).a(b4).b(a2).b(a3).a(b2).e(graphQLTextWithEntities).g(a).a(graphQLProfile).a(new GraphQLWithTagsConnection.Builder().a(b3).a()).b(a5).a(graphQLEntity).b(this.f3830s).f(m4471b());
        if (this.f3833v != null) {
            g = this.f3833v.g();
        } else {
            g = null;
        }
        f = f.a(g);
        if (this.f3827p == null) {
            str = this.f3807G;
        } else {
            str = this.f3827p.u();
        }
        f = f.f(str).b(this.f3826o).e(this.f3802B);
        GraphQLRedSpaceStoryInfo.Builder builder = new GraphQLRedSpaceStoryInfo.Builder();
        if (this.f3806F == RedSpaceValue.POST_TO_REDSPACE) {
            graphQLRedSpaceVisibilityState = GraphQLRedSpaceVisibilityState.REDSPACE_ONLY;
        } else {
            graphQLRedSpaceVisibilityState = GraphQLRedSpaceVisibilityState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        GraphQLStory a6 = f.a(builder.a(graphQLRedSpaceVisibilityState).a()).a(a4).a();
        PropertyHelper.a(a6, this.f3804D);
        this.f3822k.a(a6, this.f3803C != null ? this.f3803C : GraphQLFeedOptimisticPublishState.POSTING);
        return a6;
    }

    public static GraphQLStory m4453a(GraphQLStory graphQLStory, GraphQLStory graphQLStory2, String str) {
        GraphQLTextWithEntities aH;
        GraphQLStory.Builder a = GraphQLStory.Builder.a(graphQLStory2);
        a.o = null;
        a = a;
        a.q = graphQLStory.O();
        a = a;
        a.x = graphQLStory.V();
        a = a;
        if (graphQLStory2.ai() != null) {
            str = graphQLStory2.ai();
        }
        a.P = str;
        GraphQLStory.Builder builder = a;
        if (graphQLStory2.aH() == null) {
            aH = graphQLStory.aH();
        } else {
            aH = graphQLStory2.aH();
        }
        builder.ay = aH;
        a = builder;
        a.v = graphQLStory.T();
        return a.a();
    }

    public static GraphQLStory m4452a(GraphQLStory graphQLStory, GraphQLFeedback graphQLFeedback) {
        GraphQLStory.Builder a = GraphQLStory.Builder.a(graphQLStory);
        a.D = graphQLFeedback;
        a = a;
        a.al = m4467b(graphQLStory, graphQLFeedback.j());
        return a.a();
    }

    public static GraphQLEntity m4467b(GraphQLStory graphQLStory, String str) {
        if (graphQLStory.av() == null || !GraphQLHelper.b.d().equals(graphQLStory.av().d())) {
            return null;
        }
        return GraphQLHelper.a(GraphQlIdParserUtil.a(str), GraphQLHelper.b.b());
    }

    public static boolean m4465a(GraphQLStory graphQLStory) {
        return graphQLStory != null && StoryAttachmentHelper.a(graphQLStory) && StoryAttachmentHelper.o(graphQLStory).p();
    }

    public static String m4473b(GraphQLStory graphQLStory) {
        if (m4465a(graphQLStory)) {
            return StoryAttachmentHelper.o(graphQLStory).s();
        }
        return "";
    }

    private GraphQLTextWithEntities m4456a(GraphQLActor graphQLActor) {
        String string = this.f3813b.getString(2131234666, new Object[]{graphQLActor.aa()});
        GraphQLTextWithEntities.Builder builder = new GraphQLTextWithEntities.Builder();
        builder.i = string;
        return builder.a();
    }

    private GraphQLTextWithEntities m4458a(String str, GraphQLActor graphQLActor, ImmutableList<GraphQLActor> immutableList, GraphQLPlace graphQLPlace) {
        return m4455a(this.f3813b, m4461a(this.f3813b, str, graphQLActor, immutableList, graphQLPlace), graphQLActor, immutableList, graphQLPlace, null, null, this.f3827p);
    }

    public final OptimisticPostStoryBuilder m4477a(User user) {
        Preconditions.checkNotNull(user);
        this.f3837z = user;
        return this;
    }

    private ImmutableList<GraphQLActor> m4472b(ImmutableList<ComposerTaggedUser> immutableList) {
        Preconditions.checkNotNull(immutableList);
        Collection arrayList = new ArrayList(immutableList.size());
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ComposerTaggedUser composerTaggedUser = (ComposerTaggedUser) immutableList.get(i);
            GraphQLActor b = m4466b(composerTaggedUser.a(), composerTaggedUser.b(), composerTaggedUser.c());
            if (b != null) {
                arrayList.add(b);
            }
        }
        return ImmutableList.copyOf(arrayList);
    }

    private static GraphQLProfile m4451a(long j, String str, String str2) {
        Preconditions.checkArgument(j != 0);
        if (str == null || str2 == null) {
            return null;
        }
        GraphQLImage a = GraphQLHelper.a(str2, 0, 0);
        GraphQLProfile.Builder builder = new GraphQLProfile.Builder();
        builder.G = String.valueOf(j);
        builder.Q = str;
        builder.ae = a;
        builder.aE = new GraphQLObjectType(2645995);
        return builder.a();
    }

    private static GraphQLActor m4466b(long j, String str, String str2) {
        Preconditions.checkArgument(j != 0);
        if (str == null || str2 == null) {
            return null;
        }
        GraphQLImage a = GraphQLHelper.a(str2, 0, 0);
        GraphQLActor.Builder builder = new GraphQLActor.Builder();
        builder.B = String.valueOf(j);
        builder.V = str;
        builder.ad = a;
        builder.aH = new GraphQLObjectType(2645995);
        return builder.a();
    }

    private GraphQLPlace m4468b(CheckinPlaceModel checkinPlaceModel) {
        double d = 0.0d;
        if (checkinPlaceModel == null) {
            return null;
        }
        double a;
        LocationModel cg_ = checkinPlaceModel.cg_();
        GraphQLObjectType graphQLObjectType = new GraphQLObjectType(2479791);
        GraphQLPlace.Builder builder = new GraphQLPlace.Builder();
        builder.q = checkinPlaceModel.cf_();
        builder = builder.c(checkinPlaceModel.j());
        builder.X = graphQLObjectType;
        GraphQLPlace.Builder builder2 = builder;
        GraphQLLocation.Builder builder3 = new GraphQLLocation.Builder();
        if (cg_ != null) {
            a = cg_.a();
        } else {
            a = 0.0d;
        }
        builder3.d = a;
        GraphQLLocation.Builder builder4 = builder3;
        if (cg_ != null) {
            d = cg_.b();
        }
        builder4.e = d;
        builder2.s = builder4.a();
        builder = builder2;
        builder.S = this.f3812a.a(graphQLObjectType, checkinPlaceModel.cf_());
        builder = builder;
        builder.x = new GraphQLPageVisitsConnection.Builder().a();
        return builder.a();
    }

    private static GraphQLPlace m4450a(ImplicitLocation implicitLocation, GraphQLPlace graphQLPlace) {
        if (implicitLocation == null || graphQLPlace != null) {
            return null;
        }
        GraphQLPlace.Builder builder = new GraphQLPlace.Builder();
        builder.q = String.valueOf(implicitLocation.pageId);
        return builder.c(implicitLocation.label).a();
    }

    private static GraphQLPrivacyScope m4469b(OptimisticPostPrivacy optimisticPostPrivacy) {
        Preconditions.checkNotNull(optimisticPostPrivacy);
        GraphQLPrivacyScope.Builder c = new GraphQLPrivacyScope.Builder().c(optimisticPostPrivacy.c);
        c.i = optimisticPostPrivacy.d;
        return c.a();
    }

    private GraphQLTextWithEntities m4455a(Context context, String str, GraphQLActor graphQLActor, List<GraphQLActor> list, @Nullable GraphQLPlace graphQLPlace, @Nullable MinutiaeObject minutiaeObject, @Nullable List<GraphQLImageAtRange> list2, @Nullable GraphQLAlbum graphQLAlbum) {
        List a = m4463a(context, str, (List) list);
        List a2 = Lists.a(new LinkifyTargetGraphQL[]{LinkifyTargetBuilder.a(graphQLActor)});
        for (GraphQLActor a3 : list) {
            a2.add(LinkifyTargetBuilder.a(a3));
        }
        if (graphQLPlace != null) {
            a2.add(LinkifyTargetBuilder.a(graphQLPlace));
        }
        if (minutiaeObject != null) {
            LinkifyTargetGraphQL e = minutiaeObject.e();
            if (!(e == null || Strings.isNullOrEmpty(e.d()))) {
                a2.add(e);
            }
        }
        List a4 = m4464a(str, a2);
        if (!(graphQLAlbum == null || graphQLAlbum.E() == null || graphQLAlbum.E().a() == null || graphQLAlbum.y() != null)) {
            a4.add(GraphQLHelper.a(GraphQLAlbumConversionHelper.a(graphQLAlbum), RangeConverter.a(str, new UTF16Range(str.indexOf(graphQLAlbum.E().a()), graphQLAlbum.E().a().length()))));
        }
        return GraphQLHelper.a(str, a4, list2, a);
    }

    private List<GraphQLEntityAtRange> m4464a(String str, List<LinkifyTargetGraphQL> list) {
        List<GraphQLEntityAtRange> a = Lists.a();
        if (str == null) {
            return a;
        }
        HashMap c = Maps.c();
        for (LinkifyTargetGraphQL linkifyTargetGraphQL : list) {
            int indexOf;
            if (linkifyTargetGraphQL != null) {
                indexOf = str.indexOf(linkifyTargetGraphQL.C_(), c.containsKey(linkifyTargetGraphQL.C_()) ? ((Integer) c.get(linkifyTargetGraphQL.C_())).intValue() + 1 : 0);
            } else {
                indexOf = -1;
            }
            if (indexOf != -1) {
                GraphQLEntity graphQLEntity;
                if (linkifyTargetGraphQL == null) {
                    graphQLEntity = null;
                } else {
                    graphQLEntity = GraphQLHelper.a(linkifyTargetGraphQL.d(), linkifyTargetGraphQL.b().g());
                }
                a.add(GraphQLHelper.a(graphQLEntity, RangeConverter.a(str, new UTF16Range(indexOf, linkifyTargetGraphQL.C_().length()))));
                c.put(linkifyTargetGraphQL.C_(), Integer.valueOf(indexOf));
            }
        }
        return a;
    }

    private List<GraphQLAggregatedEntitiesAtRange> m4463a(Context context, String str, List<GraphQLActor> list) {
        List<GraphQLAggregatedEntitiesAtRange> a = Lists.a();
        String a2 = m4462a(context, (List) list);
        if (!(a2 == null || str.indexOf(a2) == -1)) {
            CodePointRange a3 = RangeConverter.a(str, new UTF16Range(str.indexOf(a2), a2.length()));
            GraphQLAggregatedEntitiesAtRange.Builder builder = new GraphQLAggregatedEntitiesAtRange.Builder();
            builder.f = a3.a;
            builder = builder;
            builder.e = a3.b;
            GraphQLAggregatedEntitiesAtRange.Builder builder2 = builder;
            builder2.d = list.size() - 1;
            builder2 = builder2;
            builder2.g = ImmutableListHelper.a(Lists.a(list.subList(1, list.size()), new 4()));
            a.add(builder2.a());
        }
        return a;
    }

    private String m4460a(Context context, String str, GraphQLActor graphQLActor, String str2) {
        if (this.f3825n.a(ExperimentsForFeedUtilComposerAbtestModule.Q, false) && !StringUtil.c(str) && this.f3827p == null) {
            SpannableStringBuilder a = ComposerUserNameUtil.m2087a(graphQLActor.aa());
            a.append(" ");
            if (str2 != null) {
                a.append(str2);
            }
            str2 = a.toString();
        }
        int c;
        if (this.f3827p != null) {
            if (this.f3827p.y() != null && this.f3827p.y().a() != null) {
                return this.f3827p.y().a();
            }
            int d = MediaItemUtil.d(this.f3820i);
            c = MediaItemUtil.c(this.f3820i);
            if (MediaItemUtil.a(this.f3820i)) {
                return context.getResources().getQuantityString(2131689599, c, new Object[]{graphQLActor.aa(), this.f3827p.E().a(), Integer.valueOf(c)});
            } else if (!MediaItemUtil.b(this.f3820i)) {
                return context.getResources().getQuantityString(2131689598, d, new Object[]{graphQLActor.aa(), this.f3827p.E().a(), Integer.valueOf(d)});
            } else if (d == 1) {
                return context.getResources().getQuantityString(2131689600, c, new Object[]{graphQLActor.aa(), this.f3827p.E().a(), Integer.valueOf(c)});
            } else {
                return context.getResources().getQuantityString(2131689601, c, new Object[]{graphQLActor.aa(), this.f3827p.E().a(), Integer.valueOf(d), Integer.valueOf(c)});
            }
        } else if (!StringUtil.c(str)) {
            return StringUtil.c(str2) ? null : str2;
        } else {
            c = MediaItemUtil.c(this.f3820i);
            int d2 = MediaItemUtil.d(this.f3820i);
            if (this.f3820i.isEmpty()) {
                if (StringUtil.a(str2)) {
                    return graphQLActor.aa();
                }
                return context.getString(2131234663, new Object[]{graphQLActor.aa(), str2});
            } else if (MediaItemUtil.a((MediaItem) this.f3820i.get(0))) {
                if (str2 == null) {
                    return context.getString(2131234664, new Object[]{graphQLActor.aa()});
                }
                return context.getString(2131234665, new Object[]{graphQLActor.aa(), str2});
            } else if (MediaItemUtil.a(this.f3820i)) {
                if (str2 == null) {
                    return context.getResources().getQuantityString(2131689594, c, new Object[]{graphQLActor.aa(), Integer.valueOf(c)});
                }
                return context.getResources().getQuantityString(2131689595, c, new Object[]{graphQLActor.aa(), Integer.valueOf(c), str2});
            } else if (MediaItemUtil.b(this.f3820i)) {
                if (str2 == null) {
                    if (d2 == 1) {
                        return context.getResources().getQuantityString(2131689590, c, new Object[]{graphQLActor.aa(), Integer.valueOf(c)});
                    }
                    return context.getResources().getQuantityString(2131689591, c, new Object[]{graphQLActor.aa(), Integer.valueOf(d2), Integer.valueOf(c)});
                } else if (d2 == 1) {
                    return context.getResources().getQuantityString(2131689592, c, new Object[]{graphQLActor.aa(), Integer.valueOf(c), str2});
                } else {
                    return context.getResources().getQuantityString(2131689593, c, new Object[]{graphQLActor.aa(), Integer.valueOf(d2), Integer.valueOf(c), str2});
                }
            } else if (str2 == null) {
                return context.getResources().getQuantityString(2131689596, this.f3820i.size(), new Object[]{graphQLActor.aa(), Integer.valueOf(this.f3820i.size())});
            } else {
                return context.getResources().getQuantityString(2131689597, this.f3820i.size(), new Object[]{graphQLActor.aa(), str2, Integer.valueOf(this.f3820i.size())});
            }
        }
    }

    private String m4461a(Context context, String str, GraphQLActor graphQLActor, List<GraphQLActor> list, GraphQLPlace graphQLPlace) {
        String str2;
        if (list.size() <= 0) {
            str2 = null;
        } else if (list.size() == 1) {
            str2 = ((GraphQLActor) list.get(0)).aa();
        } else if (list.size() == 2) {
            str2 = context.getString(2131234658, new Object[]{((GraphQLActor) list.get(0)).aa(), ((GraphQLActor) list.get(1)).aa()});
        } else {
            str2 = context.getString(2131234659, new Object[]{((GraphQLActor) list.get(0)).aa(), m4462a(context, (List) list)});
        }
        if (str2 != null && graphQLPlace != null) {
            str2 = context.getString(2131234662, new Object[]{str2, graphQLPlace.B()});
        } else if (str2 != null && graphQLPlace == null) {
            str2 = context.getString(2131234660, new Object[]{str2});
        } else if (str2 != null || graphQLPlace == null) {
            str2 = null;
        } else {
            str2 = context.getString(2131234661, new Object[]{graphQLPlace.B()});
        }
        return m4460a(context, str, graphQLActor, str2);
    }

    private GraphQLTextWithEntities m4459a(String str, GraphQLActor graphQLActor, @Nonnull List<GraphQLActor> list, GraphQLPlace graphQLPlace) {
        String str2;
        MinutiaeTemplateMetaTextBuilder minutiaeTemplateMetaTextBuilder = this.f3815d;
        ParamsBuilder paramsBuilder = new ParamsBuilder();
        if (list.isEmpty()) {
            str2 = null;
        } else {
            str2 = ((GraphQLActor) list.get(0)).aa();
        }
        ParamsBuilder b = paramsBuilder.m1373b(str2);
        b.f1296e = list.size();
        b = b;
        b.f1297f = false;
        b = b;
        b.f1298g = true;
        b = b;
        b.f1293b = this.f3828q;
        b = b;
        b.f1292a = this.f3833v;
        SpannableStringBuilder a = minutiaeTemplateMetaTextBuilder.mo56a(b.m1371a());
        String a2 = m4460a(this.f3813b, str, graphQLActor, a.toString());
        Uri[] uriArr = (Uri[]) a.getSpans(0, a.length(), Uri.class);
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Uri uri : uriArr) {
            int indexOf = a2.indexOf(a.toString());
            int spanStart = a.getSpanStart(uri) + indexOf;
            indexOf += a.getSpanEnd(uri);
            GraphQLImageAtRange.Builder builder2 = new GraphQLImageAtRange.Builder();
            builder2.e = indexOf - spanStart;
            GraphQLImageAtRange.Builder builder3 = builder2;
            builder3.f = spanStart;
            builder3 = builder3;
            GraphQLEntityWithImage.Builder builder4 = new GraphQLEntityWithImage.Builder();
            builder4.e = GraphQLHelper.a(uri.toString(), 0, 0);
            builder3.d = builder4.a();
            builder.c(builder3.a());
        }
        return m4455a(this.f3813b, a2, graphQLActor, list, graphQLPlace, this.f3833v, builder.b(), this.f3827p);
    }

    private GraphQLTextWithEntities m4457a(GraphQLTextWithEntities graphQLTextWithEntities) {
        if (this.f3831t != null) {
            return null;
        }
        if (this.f3827p != null && this.f3827p.y() != null && this.f3827p.y().a() != null) {
            return GraphQLHelper.a(this.f3827p.y().a(), null, null, null);
        }
        if (StringUtil.c(graphQLTextWithEntities.a()) || this.f3827p != null) {
            return null;
        }
        return graphQLTextWithEntities;
    }

    private static String m4462a(Context context, List<GraphQLActor> list) {
        if (list.size() <= 2) {
            return null;
        }
        return context.getResources().getQuantityString(2131689589, list.size() - 1, new Object[]{Integer.valueOf(list.size() - 1)});
    }

    private static GraphQLStoryAttachment m4454a(ImmutableList<GraphQLStoryAttachmentStyle> immutableList, GraphQLMedia graphQLMedia, GraphQLStoryAttachmentStyleInfo graphQLStoryAttachmentStyleInfo) {
        GraphQLStoryAttachment.Builder builder = new GraphQLStoryAttachment.Builder();
        builder.k = true;
        builder = builder;
        builder.g = "unknown";
        builder = builder;
        builder.l = graphQLMedia;
        builder = builder;
        builder.d = RegularImmutableList.a;
        builder = builder;
        builder.q = immutableList;
        builder = builder;
        if (graphQLStoryAttachmentStyleInfo != null) {
            builder.p = ImmutableList.of(graphQLStoryAttachmentStyleInfo);
        }
        return builder.a();
    }

    private static GraphQLImage m4448a(GraphQLImage graphQLImage, int i) {
        int c = graphQLImage.c();
        int a = graphQLImage.a();
        if (c == 0 || a == 0) {
            return GraphQLImage.Builder.a(graphQLImage).a();
        }
        if (c > a) {
            int i2 = (a * i) / c;
            c = i;
            i = i2;
        } else {
            c = (c * i) / a;
        }
        GraphQLImage.Builder a2 = GraphQLImage.Builder.a(graphQLImage);
        a2.h = c;
        GraphQLImage.Builder builder = a2;
        builder.d = i;
        return builder.a();
    }

    private GraphQLMedia m4449a(MediaItem mediaItem, String str) {
        GraphQLImage a;
        GraphQLImage a2;
        int dimensionPixelSize;
        int i = 1;
        GraphQLImage graphQLImage = null;
        int a3;
        if (mediaItem.m() == MediaType.PHOTO || MediaItem.a.equals(mediaItem.i())) {
            Uri f;
            if (mediaItem.m() == MediaType.PHOTO && URLUtil.isValidUrl(str)) {
                f = mediaItem.f();
            } else {
                f = Uri.fromFile(new File(str));
            }
            if (StringUtil.a(str)) {
                str = mediaItem.e();
            }
            a3 = this.f3816e.a(this.f3813b, f);
            if (a3 == -1) {
                a3 = 0;
            }
            Dimension a4 = BitmapUtils.a(str);
            a = new GraphQLImage.Builder().b(f.toString()).b(a3 % 180 == 0 ? a4.b : a4.a).a(a3 % 180 == 0 ? a4.a : a4.b).a();
            graphQLImage = m4448a(a, 512);
            a2 = m4448a(a, 320);
        } else if (mediaItem.m() == MediaType.VIDEO) {
            dimensionPixelSize = this.f3813b.getResources().getDimensionPixelSize(2131429617);
            VideoItem videoItem = (VideoItem) mediaItem;
            float k = videoItem.k();
            if (k == Float.NaN || k <= 0.0f) {
                a3 = dimensionPixelSize;
            } else {
                a3 = (int) (((float) dimensionPixelSize) / k);
            }
            if (videoItem.s() != null) {
                str = videoItem.s().toString();
            } else if (str.equals(mediaItem.e())) {
                Bitmap a5 = this.f3801A.a(mediaItem, new BitmapResizingParam(mediaItem.g(), dimensionPixelSize));
                File a6 = ((TempFileManager) this.f3824m.get()).a("FB_V_" + Files.b(mediaItem.e()) + "_", "." + CompressFormat.JPEG.name(), Privacy.REQUIRE_PRIVATE);
                str = Uri.fromFile(a6).toString();
                a3 = (a5.getHeight() * dimensionPixelSize) / a5.getWidth();
                try {
                    BitmapUtils.a(a5, CompressFormat.JPEG, 80, a6);
                } catch (BitmapException e) {
                }
            } else {
                Dimension a7 = BitmapUtils.a(Uri.parse(str).getPath());
                if (a7.b > 0 && a7.a > 0) {
                    a3 = (a7.a * dimensionPixelSize) / a7.b;
                }
            }
            a = new GraphQLImage.Builder().b(str).b(dimensionPixelSize).a(a3).a();
            a2 = null;
        } else {
            a2 = null;
            a = null;
        }
        dimensionPixelSize = m4447a(mediaItem);
        GraphQLMedia.Builder e2 = new GraphQLMedia.Builder().b(a).c(graphQLImage).i(a2).a(new GraphQLObjectType(dimensionPixelSize)).e(a != null ? a.a() : 1);
        if (a != null) {
            i = a.c();
        }
        e2 = e2.r(i);
        if (MediaItem.a.equals(mediaItem.i())) {
            e2.a(a).c(a);
        }
        if (dimensionPixelSize == 82650203 && mediaItem.f() != null) {
            e2.j(mediaItem.f().toString());
        }
        return e2.a();
    }

    private static int m4447a(MediaItem mediaItem) {
        if (mediaItem.m() == MediaType.VIDEO) {
            return MediaItem.a.equals(mediaItem.i()) ? 1756296650 : 82650203;
        } else {
            return 77090322;
        }
    }

    @Nullable
    private ImmutableList<GraphQLStoryAttachment> m4474c() {
        boolean z = true;
        if (this.f3820i.isEmpty()) {
            return null;
        }
        boolean z2;
        int i;
        CollageLayoutModel a;
        if (this.f3821j.size() == this.f3820i.size()) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2);
        ImmutableList.Builder builder = ImmutableList.builder();
        for (i = 0; i < this.f3820i.size(); i++) {
            builder.c(m4449a((MediaItem) this.f3820i.get(i), (String) this.f3821j.get(i)));
        }
        ImmutableList b = builder.b();
        boolean z3 = this.f3809I && this.f3820i.size() > 1;
        if (z3) {
            a = this.f3823l.m4446a(b);
        } else {
            a = null;
        }
        ImmutableList.Builder builder2 = ImmutableList.builder();
        for (i = 0; i < this.f3820i.size(); i++) {
            GraphQLStoryAttachmentStyleInfo a2;
            if (z3) {
                a2 = OptimisticPostCollageChooser.m4444a(a, i);
            } else {
                a2 = null;
            }
            MediaItem mediaItem = (MediaItem) this.f3820i.get(i);
            ImmutableList of = mediaItem.m() == MediaType.VIDEO ? MediaItem.a.equals(mediaItem.i()) ? ImmutableList.of(GraphQLStoryAttachmentStyle.ANIMATED_IMAGE_SHARE, GraphQLStoryAttachmentStyle.VIDEO) : ImmutableList.of(GraphQLStoryAttachmentStyle.VIDEO) : ImmutableList.of(GraphQLStoryAttachmentStyle.PHOTO);
            builder2.c(m4454a(of, (GraphQLMedia) b.get(i), a2));
        }
        if (this.f3827p == null && this.f3820i.size() == 1) {
            return builder2.b();
        }
        String str = "";
        if (!(this.f3827p == null || this.f3827p.x() == null)) {
            str = this.f3827p.x().b();
        }
        if (MediaItemUtil.e(this.f3820i)) {
            return builder2.b();
        }
        Object obj;
        GraphQLStoryAttachment.Builder builder3 = new GraphQLStoryAttachment.Builder();
        builder3.k = true;
        builder3 = builder3;
        if (this.f3827p == null) {
            z = false;
        }
        builder3.j = z;
        builder3 = builder3;
        builder3.m = str;
        GraphQLStoryAttachment.Builder builder4 = builder3;
        builder4.g = "unknown";
        builder4 = builder4;
        builder4.l = null;
        builder4 = builder4;
        builder4.d = RegularImmutableList.a;
        builder3 = builder4;
        if (this.f3811K) {
            obj = GraphQLStoryAttachmentStyle.SLIDESHOW;
        } else {
            obj = GraphQLStoryAttachmentStyle.ALBUM;
        }
        builder3.q = ImmutableList.of(obj);
        builder4 = builder3;
        builder4.r = builder2.b();
        return ImmutableList.of(builder4.a());
    }

    @Nullable
    private static GraphQLStoryAttachment m4470b(@Nullable ComposerShareParams composerShareParams) {
        GraphQLImage graphQLImage = null;
        int i = 200;
        if (composerShareParams == null || composerShareParams.sharePreview == null) {
            return null;
        }
        SharePreview sharePreview = composerShareParams.sharePreview;
        if (!StringUtil.a(sharePreview.imageUrl)) {
            int i2;
            GraphQLImage.Builder builder = new GraphQLImage.Builder();
            builder.g = sharePreview.imageUrl;
            GraphQLImage.Builder builder2 = builder;
            if (sharePreview.imageHeight < 200) {
                i2 = 200;
            } else {
                i2 = sharePreview.imageHeight;
            }
            builder2.d = i2;
            builder = builder2;
            if (sharePreview.imageWidth >= 200) {
                i = sharePreview.imageWidth;
            }
            builder.h = i;
            graphQLImage = builder.a();
        }
        GraphQLMedia.Builder builder3 = new GraphQLMedia.Builder();
        builder3.T = graphQLImage;
        GraphQLMedia a = builder3.a();
        GraphQLTextWithEntities.Builder builder4 = new GraphQLTextWithEntities.Builder();
        builder4.i = sharePreview.subTitle;
        GraphQLTextWithEntities a2 = builder4.a();
        GraphQLTextWithEntities.Builder builder5 = new GraphQLTextWithEntities.Builder();
        builder5.i = sharePreview.summary;
        GraphQLTextWithEntities a3 = builder5.a();
        GraphQLStoryAttachment.Builder builder6 = new GraphQLStoryAttachment.Builder();
        builder6.h = a2;
        GraphQLStoryAttachment.Builder builder7 = builder6;
        builder7.l = a;
        GraphQLStoryAttachment.Builder builder8 = builder7;
        builder8.o = a3;
        builder8 = builder8;
        builder8.q = ImmutableList.of(GraphQLStoryAttachmentStyle.SHARE, GraphQLStoryAttachmentStyle.FALLBACK);
        builder8 = builder8;
        builder8.u = sharePreview.title;
        return builder8.a();
    }

    @Nullable
    private ImmutableList<GraphQLStoryAttachment> m4471b() {
        Object obj;
        if (this.f3831t == null) {
            obj = null;
        } else {
            ProductItemAttachment productItemAttachment = this.f3831t;
            GraphQLCurrencyQuantity graphQLCurrencyQuantity = null;
            if (productItemAttachment.a()) {
                GraphQLCurrencyQuantity.Builder builder = new GraphQLCurrencyQuantity.Builder();
                builder.i = String.valueOf(productItemAttachment.price.longValue() * 100);
                builder = builder;
                builder.f = productItemAttachment.currencyCode;
                graphQLCurrencyQuantity = builder.a();
            }
            GraphQLTextWithEntities a = GraphQLHelper.a(productItemAttachment.description);
            GraphQLTextWithEntities a2 = GraphQLHelper.a(productItemAttachment.pickupDeliveryInfo);
            GraphQLNode.Builder builder2 = new GraphQLNode.Builder();
            builder2.dr = a;
            GraphQLNode.Builder builder3 = builder2;
            builder3.kQ = new GraphQLObjectType(638661096);
            builder3 = builder3;
            builder3.gh = a2;
            builder3 = builder3;
            builder3.eC = graphQLCurrencyQuantity;
            GraphQLNode a3 = builder3.a();
            ImmutableList of = ImmutableList.of(GraphQLStoryAttachmentStyle.GROUP_SELL_PRODUCT_ITEM, GraphQLStoryAttachmentStyle.FALLBACK);
            GraphQLStoryAttachment.Builder builder4 = new GraphQLStoryAttachment.Builder();
            builder4.q = of;
            GraphQLStoryAttachment.Builder builder5 = builder4;
            builder5.u = productItemAttachment.title;
            builder5 = builder5;
            builder5.t = a3;
            GraphQLStoryAttachment a4 = builder5.a();
        }
        Object obj2 = obj;
        ImmutableList c = m4474c();
        GraphQLStoryAttachment b = GifUtil.m5794b(this.f3808H);
        GraphQLStoryAttachment b2 = m4470b(this.f3808H);
        if (obj2 == null && c == null && b == null && b2 == null) {
            return null;
        }
        ImmutableList.Builder builder6 = ImmutableList.builder();
        if (obj2 != null) {
            builder6.c(obj2);
        }
        if (c != null) {
            builder6.b(c);
        }
        if (b != null) {
            builder6.c(b);
        }
        if (b2 != null) {
            builder6.c(b2);
        }
        return builder6.b();
    }

    private boolean m4476e() {
        return MediaItemUtil.e(this.f3820i) && VideoProcessingUtil.a(this.f3825n);
    }

    private static ImmutableList<String> m4475c(ImmutableList<ComposerAttachment> immutableList) {
        ImmutableList.Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ComposerAttachment composerAttachment = (ComposerAttachment) immutableList.get(i);
            if (composerAttachment.b() != null) {
                if (composerAttachment.a() && composerAttachment.b().m() == MediaType.PHOTO && composerAttachment.e() != null) {
                    if (composerAttachment.e().p() != null) {
                        builder.c(composerAttachment.e().p().getPath());
                    } else if (composerAttachment.e().o() != null) {
                        builder.c(composerAttachment.e().o().getPath());
                    } else {
                        builder.c(composerAttachment.b().e());
                    }
                } else if (!composerAttachment.a() || composerAttachment.b().m() != MediaType.VIDEO || composerAttachment.f() == null) {
                    builder.c(composerAttachment.b().e());
                } else if (composerAttachment.f().d() != null) {
                    builder.c(composerAttachment.f().d());
                } else {
                    builder.c(composerAttachment.b().e());
                }
            }
        }
        return builder.b();
    }
}
