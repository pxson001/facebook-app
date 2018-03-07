package com.facebook.instantarticles.model.data;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLComposedBlockType;
import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.graphql.enums.GraphQLDocumentFeedbackOptions;
import com.facebook.graphql.enums.GraphQLDocumentListStyle;
import com.facebook.graphql.enums.GraphQLDocumentWebviewPresentationStyle;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.inject.Lazy;
import com.facebook.instantarticles.model.data.impl.UfiBlockDataImpl;
import com.facebook.instantarticles.model.wrapper.InstantArticlesBlockDataHelper;
import com.facebook.qe.api.QeAccessor;
import com.facebook.richdocument.RichDocumentInfo;
import com.facebook.richdocument.ThirdPartyTrackerHandler;
import com.facebook.richdocument.abtest.ExperimentsForRichDocumentAbtestModule;
import com.facebook.richdocument.ham.HamDimensions;
import com.facebook.richdocument.logging.NativeAdsPerfInfoLogger;
import com.facebook.richdocument.logging.WebViewPerfInfoLogger;
import com.facebook.richdocument.logging.WebViewPerfInfoLogger.WebViewPerfEventInfo;
import com.facebook.richdocument.model.block.BylineInfoWrapper;
import com.facebook.richdocument.model.block.FeedbackAnnotation;
import com.facebook.richdocument.model.block.RichDocumentLogoInfoWrapper;
import com.facebook.richdocument.model.block.RichDocumentTextType;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocksImpl;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.ImageBlockData;
import com.facebook.richdocument.model.data.SlideshowBlockData;
import com.facebook.richdocument.model.data.VideoBlockData;
import com.facebook.richdocument.model.data.impl.AuthorBlockDataImpl;
import com.facebook.richdocument.model.data.impl.BaseAnnotableBlockData.BaseAnnotatableBlockBuilder;
import com.facebook.richdocument.model.data.impl.BylineBlockDataImpl;
import com.facebook.richdocument.model.data.impl.HairlineBlockDataImpl;
import com.facebook.richdocument.model.data.impl.ImageBlockDataImpl.ImageBlockDataBuilder;
import com.facebook.richdocument.model.data.impl.ListItemBlockDataImpl.ListItemBlockDataBuilder;
import com.facebook.richdocument.model.data.impl.LogoBlockDataImpl;
import com.facebook.richdocument.model.data.impl.MapBlockDataImpl.MapBlockBuilder;
import com.facebook.richdocument.model.data.impl.NativeAdBlockDataImpl;
import com.facebook.richdocument.model.data.impl.RelatedArticlesBlockDataImpl;
import com.facebook.richdocument.model.data.impl.RichDocumentTextBuilder;
import com.facebook.richdocument.model.data.impl.SlideshowBlockDataImpl.SlideshowBlockDataBuilder;
import com.facebook.richdocument.model.data.impl.TextBlockDataImpl.TextBlockDataBuilder;
import com.facebook.richdocument.model.data.impl.VideoBlockDataImpl.VideoBlockDataBuilder;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBVideo;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentAuthorEdge;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentEdge.DocumentBodyElements;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleEdgeModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentAuthorEdgeModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentAuthorModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentEdgeModel.CoverMediaModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentListItemsModel.ListElementsModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentMasterModel.RelatedArticleObjectsModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentNestedListItemModel.LModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentNestedListItemModel.LModel.EModel.NModel.NLModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentNestedListItemModel.LModel.EModel.NModel.NLModel.NLEModel.NLENModel.NLENLModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentNestedListItemModel.LModel.EModel.NModel.NLModel.NLEModel.NLENModel.NLENLModel.NLENLEModel.NLENLENModel.NLENLENLModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentRelatedArticleModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentRelatedArticlesModel.RelatedArticleObjsModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentSectionEdgeModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentSectionEdgeModel.RichDocumentSectionModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentSectionEdgeModel.RichDocumentSectionModel.Builder;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentSlideshowModel.SlideEdgesModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel;
import com.facebook.richdocument.utils.ListBlockAccessors;
import com.facebook.richdocument.view.util.RichDocumentLayoutDirection;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: video_save_video_view */
public class RichDocumentBlocksBuilder implements InjectableComponentWithoutContext {
    public static final String f484y = RichDocumentBlocksBuilder.class.getSimpleName();
    @Inject
    WebViewPerfInfoLogger f485a;
    @Inject
    NativeAdsPerfInfoLogger f486b;
    @Inject
    ThirdPartyTrackerHandler f487c;
    @Inject
    HamDimensions f488d;
    @Inject
    public AbstractFbErrorReporter f489e;
    @Inject
    public Lazy<RichDocumentInfo> f490f;
    @Inject
    Lazy<QeAccessor> f491g;
    @Inject
    RichDocumentLayoutDirection f492h;
    protected final Context f493i;
    public String f494j;
    public RichDocumentLogoInfoWrapper f495k;
    public RichDocumentText f496l;
    protected RichDocumentText f497m;
    public RichDocumentText f498n;
    protected BylineInfoWrapper f499o;
    public BlockData f500p;
    public List<BlockData> f501q = new ArrayList();
    public BlockData f502r;
    public BlockData f503s;
    public BlockData f504t;
    protected List<BlockData> f505u;
    protected List<BlockData> f506v;
    public Bundle f507w;
    protected BlockData f508x;

    /* compiled from: video_save_video_view */
    public /* synthetic */ class C00801 {
        public static final /* synthetic */ int[] f483a = new int[GraphQLDocumentElementType.values().length];

        static {
            try {
                f483a[GraphQLDocumentElementType.RICH_TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f483a[GraphQLDocumentElementType.LIST_ITEM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f483a[GraphQLDocumentElementType.MULTI_TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f483a[GraphQLDocumentElementType.PHOTO.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f483a[GraphQLDocumentElementType.VIDEO.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f483a[GraphQLDocumentElementType.SLIDESHOW.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f483a[GraphQLDocumentElementType.WEBVIEW.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f483a[GraphQLDocumentElementType.MAP.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f483a[GraphQLDocumentElementType.RELATED_ARTICLES.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f483a[GraphQLDocumentElementType.NATIVE_AD.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    public static void m593a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RichDocumentBlocksBuilder) obj).m591a(WebViewPerfInfoLogger.a(fbInjector), NativeAdsPerfInfoLogger.a(fbInjector), ThirdPartyTrackerHandler.a(fbInjector), HamDimensions.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), IdBasedLazy.a(fbInjector, 10295), IdBasedSingletonScopeProvider.b(fbInjector, 3219), RichDocumentLayoutDirection.a(fbInjector));
    }

    private void m591a(WebViewPerfInfoLogger webViewPerfInfoLogger, NativeAdsPerfInfoLogger nativeAdsPerfInfoLogger, ThirdPartyTrackerHandler thirdPartyTrackerHandler, HamDimensions hamDimensions, FbErrorReporter fbErrorReporter, Lazy<RichDocumentInfo> lazy, Lazy<QeAccessor> lazy2, RichDocumentLayoutDirection richDocumentLayoutDirection) {
        this.f485a = webViewPerfInfoLogger;
        this.f486b = nativeAdsPerfInfoLogger;
        this.f487c = thirdPartyTrackerHandler;
        this.f488d = hamDimensions;
        this.f489e = fbErrorReporter;
        this.f490f = lazy;
        this.f491g = lazy2;
        this.f492h = richDocumentLayoutDirection;
    }

    public RichDocumentBlocksBuilder(Context context) {
        this.f493i = context;
        this.f507w = new Bundle();
        Class cls = RichDocumentBlocksBuilder.class;
        m593a((Object) this, this.f493i);
    }

    public RichDocumentBlocksBuilder m605a(String str) {
        this.f494j = str;
        return this;
    }

    public RichDocumentBlocksBuilder m607b(String str) {
        this.f507w.putString("url", str);
        return this;
    }

    public RichDocumentBlocksBuilder m598a(int i) {
        this.f507w.putInt("version", i);
        return this;
    }

    public RichDocumentBlocksBuilder m609c(String str) {
        this.f507w.putString("title", str);
        return this;
    }

    public RichDocumentBlocksBuilder m606b(RichDocumentText richDocumentText) {
        this.f497m = richDocumentText;
        return this;
    }

    public final RichDocumentBlocksBuilder m602a(CoverMediaModel coverMediaModel) {
        if (coverMediaModel != null) {
            BaseAnnotatableBlockBuilder baseAnnotatableBlockBuilder;
            switch (coverMediaModel.b().g()) {
                case -752141604:
                    if (m595a(coverMediaModel.ig_())) {
                        VideoBlockDataBuilder videoBlockDataBuilder = new VideoBlockDataBuilder(coverMediaModel.ig_(), coverMediaModel.p(), coverMediaModel.t(), coverMediaModel.u(), coverMediaModel.v());
                        videoBlockDataBuilder.g = true;
                        videoBlockDataBuilder = videoBlockDataBuilder;
                        videoBlockDataBuilder.b = coverMediaModel.o();
                        baseAnnotatableBlockBuilder = videoBlockDataBuilder;
                        baseAnnotatableBlockBuilder.c = coverMediaModel.g();
                        baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
                        baseAnnotatableBlockBuilder.d = coverMediaModel.m();
                        baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
                        baseAnnotatableBlockBuilder.a = coverMediaModel.s();
                        baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
                        baseAnnotatableBlockBuilder.b = coverMediaModel.r();
                        this.f500p = (VideoBlockData) baseAnnotatableBlockBuilder.a(coverMediaModel.ie_(), coverMediaModel.c(), coverMediaModel.d()).a(coverMediaModel.k(), coverMediaModel.j()).a(coverMediaModel.l()).b();
                        break;
                    }
                    break;
                case 1061619013:
                    String str = this.f494j;
                    ImageBlockDataBuilder imageBlockDataBuilder = new ImageBlockDataBuilder(coverMediaModel.n(), coverMediaModel.p());
                    imageBlockDataBuilder.g = str;
                    imageBlockDataBuilder = imageBlockDataBuilder;
                    imageBlockDataBuilder.e = true;
                    baseAnnotatableBlockBuilder = imageBlockDataBuilder;
                    baseAnnotatableBlockBuilder.c = coverMediaModel.g();
                    baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
                    baseAnnotatableBlockBuilder.d = coverMediaModel.m();
                    baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
                    baseAnnotatableBlockBuilder.a = coverMediaModel.s();
                    baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
                    baseAnnotatableBlockBuilder.b = coverMediaModel.r();
                    this.f500p = (ImageBlockData) baseAnnotatableBlockBuilder.a(coverMediaModel.ie_(), coverMediaModel.c(), coverMediaModel.d()).a(coverMediaModel.k(), coverMediaModel.j()).a(coverMediaModel.l()).b();
                    break;
                case 1114739273:
                    if (m596a(coverMediaModel.q())) {
                        SlideshowBlockDataBuilder slideshowBlockDataBuilder = new SlideshowBlockDataBuilder(InstantArticlesBlockDataHelper.m613a(coverMediaModel.q().a(), this.f493i, coverMediaModel.p()), coverMediaModel.p());
                        slideshowBlockDataBuilder.c = true;
                        baseAnnotatableBlockBuilder = slideshowBlockDataBuilder;
                        baseAnnotatableBlockBuilder.c = coverMediaModel.g();
                        baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
                        baseAnnotatableBlockBuilder.d = coverMediaModel.m();
                        baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
                        baseAnnotatableBlockBuilder.a = coverMediaModel.s();
                        baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
                        baseAnnotatableBlockBuilder.b = coverMediaModel.r();
                        this.f500p = (SlideshowBlockData) baseAnnotatableBlockBuilder.a(coverMediaModel.ie_(), coverMediaModel.c(), coverMediaModel.d()).a(coverMediaModel.k(), coverMediaModel.j()).a(coverMediaModel.l()).b();
                        break;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Cover media type " + coverMediaModel.if_() + " is not supported");
            }
        }
        return this;
    }

    public final RichDocumentBlocksBuilder m601a(DocumentBodyElements documentBodyElements) {
        if (documentBodyElements != null) {
            ImmutableList a = documentBodyElements.a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                RichDocumentSectionModel a2 = ((RichDocumentSectionEdgeModel) a.get(i)).a();
                if (a2 != null) {
                    m604a(a2, this.f493i);
                }
            }
        }
        return this;
    }

    public RichDocumentBlocksBuilder m604a(RichDocumentSectionModel richDocumentSectionModel, Context context) {
        switch (C00801.f483a[richDocumentSectionModel.k().ordinal()]) {
            case 1:
                if (!(richDocumentSectionModel == null || richDocumentSectionModel.l() == null || StringUtil.c(richDocumentSectionModel.l().d()))) {
                    int i;
                    if (richDocumentSectionModel.l().a() == GraphQLComposedBlockType.BLOCKQUOTE) {
                        i = 17;
                    } else if (richDocumentSectionModel.l().a() == GraphQLComposedBlockType.CODE) {
                        i = 18;
                    } else {
                        i = 3;
                    }
                    this.f501q.add(new TextBlockDataBuilder(i, richDocumentSectionModel.l()).a(richDocumentSectionModel.r()).b());
                    break;
                }
            case 2:
                m597b(richDocumentSectionModel, context);
                break;
            case 3:
                m592a(richDocumentSectionModel);
                break;
            case 4:
                if (!(richDocumentSectionModel.n() == null || richDocumentSectionModel.n().c() == null)) {
                    this.f501q.add(InstantArticlesBlockDataHelper.m614a(richDocumentSectionModel, this.f494j));
                    break;
                }
            case 5:
                if (m595a(richDocumentSectionModel.ig_())) {
                    this.f501q.add(InstantArticlesBlockDataHelper.m615a(richDocumentSectionModel));
                    break;
                }
                break;
            case 6:
                if (m596a(richDocumentSectionModel.B())) {
                    List list = this.f501q;
                    SlideshowBlockDataBuilder slideshowBlockDataBuilder = new SlideshowBlockDataBuilder(InstantArticlesBlockDataHelper.m613a(richDocumentSectionModel.B().a(), this.f493i, richDocumentSectionModel.z()), richDocumentSectionModel.z());
                    slideshowBlockDataBuilder.c = richDocumentSectionModel.g();
                    BaseAnnotatableBlockBuilder baseAnnotatableBlockBuilder = slideshowBlockDataBuilder;
                    baseAnnotatableBlockBuilder.d = richDocumentSectionModel.u();
                    baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
                    baseAnnotatableBlockBuilder.a = richDocumentSectionModel.D();
                    baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
                    baseAnnotatableBlockBuilder.b = richDocumentSectionModel.C();
                    list.add((SlideshowBlockData) baseAnnotatableBlockBuilder.a(richDocumentSectionModel.d(), richDocumentSectionModel.b(), richDocumentSectionModel.c()).a(richDocumentSectionModel.p(), richDocumentSectionModel.o()).a(richDocumentSectionModel.r()).b());
                    break;
                }
                break;
            case 7:
                String string = this.f507w.getString("url");
                if (richDocumentSectionModel.H() != GraphQLDocumentWebviewPresentationStyle.TRACKER) {
                    if (!(StringUtil.a(richDocumentSectionModel.ik_()) && StringUtil.a(richDocumentSectionModel.q()))) {
                        WebViewPerfInfoLogger webViewPerfInfoLogger = this.f485a;
                        CharSequence r = richDocumentSectionModel.r();
                        int size = this.f501q.size();
                        GraphQLDocumentWebviewPresentationStyle H = richDocumentSectionModel.H();
                        if (!StringUtil.c(r)) {
                            webViewPerfInfoLogger.a.put(r, new WebViewPerfEventInfo(size, H));
                        }
                        this.f501q.add(InstantArticlesBlockDataHelper.m617b(richDocumentSectionModel, string));
                        break;
                    }
                } else if (StringUtil.c(richDocumentSectionModel.q())) {
                    if (!StringUtil.c(richDocumentSectionModel.ik_())) {
                        this.f487c.a(richDocumentSectionModel.ik_(), richDocumentSectionModel.r());
                        break;
                    }
                } else {
                    this.f487c.b(richDocumentSectionModel.q(), richDocumentSectionModel.r());
                    break;
                }
                break;
            case 8:
                this.f501q.add(new MapBlockBuilder(richDocumentSectionModel.v(), richDocumentSectionModel.w(), richDocumentSectionModel.il_(), richDocumentSectionModel.z()).a(richDocumentSectionModel.r()).b());
                break;
            case 9:
                m590a(context, richDocumentSectionModel);
                break;
            case 10:
                this.f486b.a(richDocumentSectionModel.r());
                this.f501q.add(new NativeAdBlockDataImpl(richDocumentSectionModel.r()));
                break;
        }
        return this;
    }

    private void m590a(Context context, RichDocumentSectionModel richDocumentSectionModel) {
        RelatedArticleObjsModel A = richDocumentSectionModel.A();
        if (A != null) {
            String string = context.getString(2131237708);
            RichDocumentTextBuilder richDocumentTextBuilder = new RichDocumentTextBuilder();
            richDocumentTextBuilder.a = string;
            RichDocumentTextBuilder richDocumentTextBuilder2 = richDocumentTextBuilder;
            List list = this.f501q;
            TextBlockDataBuilder textBlockDataBuilder = new TextBlockDataBuilder(20, richDocumentTextBuilder2.a());
            textBlockDataBuilder.b = RichDocumentTextType.RELATED_ARTICLES_HEADER;
            list.add(textBlockDataBuilder.c());
            ImmutableList a = A.a();
            for (int i = 0; i < a.size(); i++) {
                this.f501q.add(new RelatedArticlesBlockDataImpl((RelatedArticleEdgeModel) a.get(i), i + 1, this.f494j));
            }
            this.f501q.add(new HairlineBlockDataImpl(21));
        }
    }

    public final RichDocumentBlocksBuilder m600a(GraphQLDocumentFeedbackOptions graphQLDocumentFeedbackOptions, GraphQLFeedback graphQLFeedback) {
        boolean a = ((QeAccessor) this.f491g.get()).a(ExperimentsForRichDocumentAbtestModule.j, false);
        FeedbackAnnotation a2 = FeedbackAnnotation.a(graphQLDocumentFeedbackOptions, graphQLFeedback, this.f492h);
        if (a2 != null && a) {
            this.f508x = new UfiBlockDataImpl(a2);
        }
        return this;
    }

    public final RichDocumentBlocksBuilder m599a(Resources resources, List<? extends RichDocumentAuthorEdge> list, long j) {
        List arrayList = new ArrayList();
        if (!(list == null || list.isEmpty())) {
            Iterator it;
            if (((RichDocumentInfo) this.f490f.get()).g != null && ((RichDocumentInfo) this.f490f.get()).g.t()) {
                this.f506v = new ArrayList();
                String string = resources.getString(2131237722);
                RichDocumentTextBuilder richDocumentTextBuilder = new RichDocumentTextBuilder();
                richDocumentTextBuilder.a = string;
                RichDocumentTextBuilder richDocumentTextBuilder2 = richDocumentTextBuilder;
                List list2 = this.f506v;
                TextBlockDataBuilder textBlockDataBuilder = new TextBlockDataBuilder(16, richDocumentTextBuilder2.a());
                textBlockDataBuilder.b = RichDocumentTextType.AUTHORS_CONTRIBUTORS_HEADER;
                list2.add(textBlockDataBuilder.c());
                it = list.iterator();
                while (it.hasNext()) {
                    this.f506v.add(new AuthorBlockDataImpl(((RichDocumentAuthorEdgeModel) it.next()).a()));
                }
            }
            it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((RichDocumentAuthorEdgeModel) it.next()).a());
            }
        }
        this.f499o = new BylineInfoWrapper(arrayList, j);
        return this;
    }

    public final RichDocumentBlocksBuilder m603a(@Nullable RelatedArticleObjectsModel relatedArticleObjectsModel, String str, Resources resources) {
        if (relatedArticleObjectsModel != null) {
            ImmutableList<RichDocumentRelatedArticleModel> a = relatedArticleObjectsModel.a();
            if (!a.isEmpty()) {
                this.f505u = new ArrayList();
                String string = resources.getString(2131237707, new Object[]{str});
                RichDocumentTextBuilder richDocumentTextBuilder = new RichDocumentTextBuilder();
                richDocumentTextBuilder.a = string;
                RichDocumentTextBuilder richDocumentTextBuilder2 = richDocumentTextBuilder;
                List list = this.f505u;
                TextBlockDataBuilder textBlockDataBuilder = new TextBlockDataBuilder(19, richDocumentTextBuilder2.a());
                textBlockDataBuilder.b = RichDocumentTextType.RELATED_ARTICLES_HEADER;
                list.add(textBlockDataBuilder.c());
                int i = 0;
                for (RichDocumentRelatedArticleModel relatedArticlesBlockDataImpl : a) {
                    i++;
                    this.f505u.add(new RelatedArticlesBlockDataImpl(relatedArticlesBlockDataImpl, i, this.f494j));
                }
            }
        }
        return this;
    }

    protected static boolean m595a(FBVideo fBVideo) {
        return (fBVideo == null || fBVideo.m() == null || fBVideo.g() == 0) ? false : true;
    }

    private static boolean m596a(SlideEdgesModel slideEdgesModel) {
        return slideEdgesModel != null && CollectionUtil.b(slideEdgesModel.a());
    }

    private void m594a(Object obj, GraphQLDocumentListStyle graphQLDocumentListStyle, int i, Context context) {
        int size;
        if (obj instanceof ListElementsModel) {
            size = ((ImmutableList) ListBlockAccessors.f(obj)).size();
        } else if (obj instanceof LModel) {
            size = ((ImmutableList) ListBlockAccessors.f(obj)).size();
        } else if (obj instanceof NLModel) {
            size = ((ImmutableList) ListBlockAccessors.f(obj)).size();
        } else if (obj instanceof NLENLModel) {
            size = ((ImmutableList) ListBlockAccessors.f(obj)).size();
        } else if (obj instanceof NLENLENLModel) {
            size = ((ImmutableList) ListBlockAccessors.f(obj)).size();
        } else {
            size = 0;
        }
        int i2 = size;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5;
            Object a = ListBlockAccessors.a(obj, i4);
            GraphQLDocumentElementType b = ListBlockAccessors.b(a);
            if (b == GraphQLDocumentElementType.RICH_TEXT) {
                boolean z;
                List list = this.f501q;
                Context context2 = this.f493i;
                RichDocumentText c = ListBlockAccessors.c(a);
                if (graphQLDocumentListStyle == GraphQLDocumentListStyle.ORDERED) {
                    z = true;
                } else {
                    z = false;
                }
                int i6 = i3 + 1;
                ListItemBlockDataBuilder listItemBlockDataBuilder = new ListItemBlockDataBuilder(context2, c, z, i3);
                listItemBlockDataBuilder.a = i;
                list.add(listItemBlockDataBuilder.c());
                i5 = i6;
            } else {
                if (b == GraphQLDocumentElementType.LIST_ITEM) {
                    m594a(ListBlockAccessors.e(a), ListBlockAccessors.d(a), i + 1, context);
                }
                i5 = i3;
            }
            i3 = i5;
        }
    }

    private void m597b(RichDocumentSectionModel richDocumentSectionModel, Context context) {
        m594a(richDocumentSectionModel.s(), richDocumentSectionModel.t(), 0, context);
    }

    private void m592a(RichDocumentSectionModel richDocumentSectionModel) {
        richDocumentSectionModel = richDocumentSectionModel;
        ImmutableList L = richDocumentSectionModel.L();
        int size = L.size();
        for (int i = 0; i < size; i++) {
            RichDocumentTextModel richDocumentTextModel = (RichDocumentTextModel) L.get(i);
            if (!(richDocumentTextModel == null || StringUtil.c(richDocumentTextModel.d()))) {
                Builder builder = new Builder();
                builder.a = richDocumentSectionModel.I();
                builder.b = richDocumentSectionModel.b();
                builder.c = richDocumentSectionModel.J();
                builder.d = richDocumentSectionModel.d();
                builder.e = richDocumentSectionModel.ik_();
                builder.f = richDocumentSectionModel.K();
                builder.g = richDocumentSectionModel.L();
                builder.h = richDocumentSectionModel.M();
                builder.i = richDocumentSectionModel.il_();
                builder.j = richDocumentSectionModel.j();
                builder.k = richDocumentSectionModel.k();
                builder.l = richDocumentSectionModel.N();
                builder.m = richDocumentSectionModel.O();
                builder.n = richDocumentSectionModel.m();
                builder.o = richDocumentSectionModel.o();
                builder.p = richDocumentSectionModel.p();
                builder.q = richDocumentSectionModel.q();
                builder.r = richDocumentSectionModel.r();
                builder.s = richDocumentSectionModel.P();
                builder.t = richDocumentSectionModel.t();
                builder.u = richDocumentSectionModel.Q();
                builder.v = richDocumentSectionModel.v();
                builder.w = richDocumentSectionModel.w();
                builder.x = richDocumentSectionModel.x();
                builder.y = richDocumentSectionModel.R();
                builder.z = richDocumentSectionModel.S();
                builder.A = richDocumentSectionModel.z();
                builder.B = richDocumentSectionModel.T();
                builder.C = richDocumentSectionModel.U();
                builder.D = richDocumentSectionModel.V();
                builder.E = richDocumentSectionModel.W();
                builder.F = richDocumentSectionModel.X();
                builder.G = richDocumentSectionModel.E();
                builder.H = richDocumentSectionModel.F();
                builder.I = richDocumentSectionModel.G();
                builder.J = richDocumentSectionModel.H();
                Builder builder2 = builder;
                builder2.l = richDocumentTextModel;
                builder2.g = null;
                this.f501q.add(new TextBlockDataBuilder(richDocumentTextModel).c());
            }
        }
    }

    public RichDocumentBlocksImpl m608b() {
        Object arrayList = new ArrayList();
        Collection arrayList2 = new ArrayList();
        Resources resources = this.f493i.getResources();
        if (this.f500p != null) {
            arrayList.add(this.f500p);
        }
        if (this.f495k != null) {
            arrayList.add(new LogoBlockDataImpl(this.f495k.b, this.f495k.c, this.f495k.a));
        }
        if (!(this.f496l == null || StringUtil.a(this.f496l.d()))) {
            TextBlockDataBuilder textBlockDataBuilder = new TextBlockDataBuilder(this.f496l);
            textBlockDataBuilder.b = RichDocumentTextType.KICKER;
            arrayList.add(textBlockDataBuilder.c());
        }
        if (!(this.f497m == null || StringUtil.a(this.f497m.d()))) {
            textBlockDataBuilder = new TextBlockDataBuilder(this.f497m);
            textBlockDataBuilder.b = RichDocumentTextType.TITLE;
            arrayList.add(textBlockDataBuilder.c());
        }
        if (!(this.f498n == null || StringUtil.a(this.f498n.d()))) {
            textBlockDataBuilder = new TextBlockDataBuilder(this.f498n);
            textBlockDataBuilder.b = RichDocumentTextType.SUBTITLE;
            arrayList.add(textBlockDataBuilder.c());
        }
        if (this.f499o != null) {
            Collection arrayList3 = new ArrayList();
            for (RichDocumentAuthorModel authorBlockDataImpl : this.f499o.a) {
                arrayList3.add(new AuthorBlockDataImpl(authorBlockDataImpl));
            }
            arrayList.add(new BylineBlockDataImpl(ImmutableList.copyOf(arrayList3), this.f499o.b));
        }
        if (!(this.f502r == null && this.f503s == null)) {
            arrayList2.add(new HairlineBlockDataImpl(resources.getColor(2131363476), this.f488d.b(2131558651), resources.getDimensionPixelSize(2131431843)));
        }
        if (this.f502r != null) {
            arrayList2.add(this.f502r);
        }
        if (this.f503s != null) {
            arrayList2.add(this.f503s);
        }
        if (this.f504t != null) {
            arrayList2.add(this.f504t);
        }
        RichDocumentBlocksImpl richDocumentBlocksImpl = new RichDocumentBlocksImpl(this.f494j);
        richDocumentBlocksImpl.a(arrayList);
        richDocumentBlocksImpl.a(this.f501q);
        richDocumentBlocksImpl.a(arrayList2);
        richDocumentBlocksImpl.a(this.f506v);
        ((RichDocumentInfo) this.f490f.get()).h = arrayList.size() + this.f501q.size();
        if (this.f508x != null) {
            richDocumentBlocksImpl.c.add(this.f508x);
        }
        richDocumentBlocksImpl.a(this.f505u);
        richDocumentBlocksImpl.b.putAll(this.f507w);
        return richDocumentBlocksImpl;
    }
}
