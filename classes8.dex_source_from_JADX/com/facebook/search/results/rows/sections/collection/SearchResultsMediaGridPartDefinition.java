package com.facebook.search.results.rows.sections.collection;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.collage.CollageItem;
import com.facebook.feed.collage.CollageLayoutCalculator;
import com.facebook.feed.collage.CollageLayoutCalculatorProvider;
import com.facebook.feed.collage.ui.CollageAttachmentView;
import com.facebook.feed.collage.ui.CollageAttachmentView.OnImageClickListener;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.CollageAttachmentAnimationUtil;
import com.facebook.feed.rows.sections.attachments.ui.MediaCollageItem;
import com.facebook.feed.rows.sections.attachments.ui.MediaGridCollageLayoutProperties;
import com.facebook.feed.rows.sections.attachments.ui.MediaGridCollageLayoutPropertiesProvider;
import com.facebook.feed.rows.sections.attachments.ui.SingleMediaRowCollageLayoutProperties;
import com.facebook.feed.rows.sections.attachments.ui.SingleMediaRowCollageLayoutPropertiesProvider;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.feed.ui.imageloader.FeedImageLoader.FeedImageType;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.graphql.model.conversion.GraphQLNodeConversionHelper;
import com.facebook.graphql.model.conversion.GraphQLPhotoConversionHelper;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.data.protocol.PhotosMetadataConversionHelper;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.ui.DefaultMediaGalleryLauncher;
import com.facebook.search.intent.SearchResultsIntentBuilder;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.results.environment.HasFeedItemPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.entity.OldCanLogEntityNavigation;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.video.activity.FullscreenVideoPlayerLauncher;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.HashMap;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REPLY_COMMMENT_TAP */
public class SearchResultsMediaGridPartDefinition<E extends HasPositionInformation & HasContext & HasSearchResultsContext & HasFeedItemPosition & OldCanLogEntityNavigation> extends MultiRowSinglePartDefinition<FeedProps<SearchResultsCollectionUnit>, State, E, CollageAttachmentView<MediaCollageItem>> {
    public static final ViewType<CollageAttachmentView<MediaCollageItem>> f23782a = new C25391();
    private static final Optional<GraphQLGraphSearchResultsDisplayStyle> f23783b = Optional.of(GraphQLGraphSearchResultsDisplayStyle.PHOTOS);
    private static final CallerContext f23784c = CallerContext.a(SearchResultsMediaGridPartDefinition.class, "graph_search_results_page");
    private static final PaddingStyle f23785d = PaddingStyle.f;
    private static SearchResultsMediaGridPartDefinition f23786p;
    private static final Object f23787q = new Object();
    private final CollageLayoutCalculatorProvider f23788e;
    private final FbDraweeControllerBuilder f23789f;
    public final FeedImageLoader f23790g;
    public final MediaGalleryLauncher f23791h;
    private final BackgroundPartDefinition f23792i;
    private final MediaGridCollageLayoutPropertiesProvider f23793j;
    private final SingleMediaRowCollageLayoutPropertiesProvider f23794k;
    public final SearchResultsIntentBuilder f23795l;
    public final SecureContextHelper f23796m;
    public final SearchResultsLogger f23797n;
    public final FullscreenVideoPlayerLauncher f23798o;

    /* compiled from: REPLY_COMMMENT_TAP */
    final class C25391 extends ViewType<CollageAttachmentView<MediaCollageItem>> {
        C25391() {
        }

        public final View m27416a(Context context) {
            return new CollageAttachmentView(context);
        }
    }

    /* compiled from: REPLY_COMMMENT_TAP */
    public class State {
        public final DraweeController[] f23778a;
        public final CollageLayoutCalculator<MediaCollageItem> f23779b;
        public final OnImageClickListener<MediaCollageItem> f23780c;
        public final boolean f23781d;

        public State(DraweeController[] draweeControllerArr, CollageLayoutCalculator<MediaCollageItem> collageLayoutCalculator, OnImageClickListener<MediaCollageItem> onImageClickListener, boolean z) {
            this.f23778a = draweeControllerArr;
            this.f23779b = collageLayoutCalculator;
            this.f23780c = onImageClickListener;
            this.f23781d = z;
        }
    }

    private static SearchResultsMediaGridPartDefinition m27422b(InjectorLike injectorLike) {
        return new SearchResultsMediaGridPartDefinition((CollageLayoutCalculatorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CollageLayoutCalculatorProvider.class), FbDraweeControllerBuilder.b(injectorLike), FeedImageLoader.a(injectorLike), (MediaGalleryLauncher) DefaultMediaGalleryLauncher.m2459a(injectorLike), BackgroundPartDefinition.a(injectorLike), (MediaGridCollageLayoutPropertiesProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MediaGridCollageLayoutPropertiesProvider.class), (SingleMediaRowCollageLayoutPropertiesProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SingleMediaRowCollageLayoutPropertiesProvider.class), SearchResultsIntentBuilder.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), SearchResultsLogger.m25460a(injectorLike), FullscreenVideoPlayerLauncher.m11255b(injectorLike));
    }

    public static SearchResultsMediaGridPartDefinition m27419a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsMediaGridPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23787q) {
                SearchResultsMediaGridPartDefinition searchResultsMediaGridPartDefinition;
                if (a2 != null) {
                    searchResultsMediaGridPartDefinition = (SearchResultsMediaGridPartDefinition) a2.a(f23787q);
                } else {
                    searchResultsMediaGridPartDefinition = f23786p;
                }
                if (searchResultsMediaGridPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27422b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23787q, b3);
                        } else {
                            f23786p = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsMediaGridPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Object m27425a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        boolean z = false;
        SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) feedProps.a;
        subParts.a(this.f23792i, new StylingData(null, f23785d, Position.MIDDLE));
        Builder builder = ImmutableList.builder();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < searchResultsCollectionUnit.f23463d.size(); i++) {
            Flattenable a;
            GraphQLNode graphQLNode = (GraphQLNode) searchResultsCollectionUnit.f23463d.get(i);
            if (graphQLNode.j().g() != 82650203) {
                GraphQLPhoto c = GraphQLNodeConversionHelper.c(graphQLNode);
                if (c != null) {
                    a = GraphQLPhotoConversionHelper.a(c);
                } else {
                }
            } else if (graphQLNode.bv() == null || StoryAttachmentHelper.o(graphQLNode.bv()) == null) {
                a = null;
            } else {
                a = StoryAttachmentHelper.o(graphQLNode.bv()).r();
            }
            if (!(a == null || graphQLNode.dp() == null)) {
                builder.c(feedProps.a(a));
                hashMap.put(graphQLNode.dp(), graphQLNode);
            }
        }
        boolean b = m27423b(searchResultsCollectionUnit);
        ImmutableList b2 = builder.b();
        CollageLayoutCalculator a2 = this.f23788e.a(b ? new SingleMediaRowCollageLayoutProperties(b2) : new MediaGridCollageLayoutProperties(b2));
        OnImageClickListener a3 = m27418a(hashMap, b2, searchResultsCollectionUnit, hasPositionInformation);
        DraweeController[] a4 = m27421a(a2, this.f23790g, this.f23789f);
        if (b && b2.size() >= 3) {
            z = true;
        }
        return new State(a4, a2, a3, z);
    }

    public final void m27428b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        CollageAttachmentView collageAttachmentView = (CollageAttachmentView) view;
        collageAttachmentView.a();
        collageAttachmentView.l = 0;
        collageAttachmentView.u = null;
    }

    public static boolean m27420a(FeedProps<SearchResultsCollectionUnit> feedProps) {
        SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) feedProps.a;
        return searchResultsCollectionUnit.m27154o().equals(Optional.of(GraphQLNode.class)) && !searchResultsCollectionUnit.f23463d.isEmpty() && (searchResultsCollectionUnit.f23460a.equals(f23783b) || searchResultsCollectionUnit.mo1321k() == GraphQLGraphSearchResultRole.TOPIC_MEDIA);
    }

    @Inject
    public SearchResultsMediaGridPartDefinition(CollageLayoutCalculatorProvider collageLayoutCalculatorProvider, FbDraweeControllerBuilder fbDraweeControllerBuilder, FeedImageLoader feedImageLoader, MediaGalleryLauncher mediaGalleryLauncher, BackgroundPartDefinition backgroundPartDefinition, MediaGridCollageLayoutPropertiesProvider mediaGridCollageLayoutPropertiesProvider, SingleMediaRowCollageLayoutPropertiesProvider singleMediaRowCollageLayoutPropertiesProvider, SearchResultsIntentBuilder searchResultsIntentBuilder, SecureContextHelper secureContextHelper, SearchResultsLogger searchResultsLogger, FullscreenVideoPlayerLauncher fullscreenVideoPlayerLauncher) {
        this.f23796m = secureContextHelper;
        this.f23795l = searchResultsIntentBuilder;
        this.f23788e = collageLayoutCalculatorProvider;
        this.f23789f = fbDraweeControllerBuilder;
        this.f23790g = feedImageLoader;
        this.f23791h = mediaGalleryLauncher;
        this.f23792i = backgroundPartDefinition;
        this.f23793j = mediaGridCollageLayoutPropertiesProvider;
        this.f23794k = singleMediaRowCollageLayoutPropertiesProvider;
        this.f23797n = searchResultsLogger;
        this.f23798o = fullscreenVideoPlayerLauncher;
    }

    public final ViewType<CollageAttachmentView<MediaCollageItem>> m27424a() {
        return f23782a;
    }

    private OnImageClickListener<MediaCollageItem> m27418a(HashMap<String, GraphQLNode> hashMap, ImmutableList<FeedProps<GraphQLMedia>> immutableList, SearchResultsCollectionUnit<?> searchResultsCollectionUnit, E e) {
        final SearchResultsCollectionUnit<?> searchResultsCollectionUnit2 = searchResultsCollectionUnit;
        final E e2 = e;
        final ImmutableList<FeedProps<GraphQLMedia>> immutableList2 = immutableList;
        final HashMap<String, GraphQLNode> hashMap2 = hashMap;
        return new OnImageClickListener<MediaCollageItem>(this) {
            final /* synthetic */ SearchResultsMediaGridPartDefinition f23777e;

            public final void m27417a(CollageAttachmentView collageAttachmentView, CollageItem collageItem, int i) {
                MediaCollageItem mediaCollageItem = (MediaCollageItem) collageItem;
                if (SearchResultsMediaGridPartDefinition.m27423b(searchResultsCollectionUnit2) && i == 2) {
                    this.f23777e.f23797n.m25483a(((HasSearchResultsContext) e2).mo1248s(), searchResultsCollectionUnit2.mo1321k(), (String) searchResultsCollectionUnit2.mo1322l().orNull(), (GraphQLGraphSearchResultsDisplayStyle) searchResultsCollectionUnit2.f23460a.orNull(), ((HasFeedItemPosition) e2).mo1245a(searchResultsCollectionUnit2), Math.min(searchResultsCollectionUnit2.f23463d.size(), 3), (GraphQLObjectType) searchResultsCollectionUnit2.f23465f.orNull());
                    this.f23777e.f23796m.a(this.f23777e.f23795l.a(searchResultsCollectionUnit2.mo1331n(), (String) searchResultsCollectionUnit2.mo1329f().get(), (String) searchResultsCollectionUnit2.mo1330m().get(), null, SearchResultsSource.u, ((HasSearchResultsContext) e2).mo1248s().f23369d), ((HasContext) e2).getContext());
                } else if (mediaCollageItem.b().j().g() == 82650203) {
                    this.f23777e.f23798o.m11256a(GraphQLMediaConversionHelper.b(mediaCollageItem.b()), ((HasContext) e2).getContext(), PlayerOrigin.RESULTS_PAGE_MIXED_MEDIA);
                } else {
                    ImageRequest a = this.f23777e.f23790g.a(mediaCollageItem.b(), FeedImageType.Photo);
                    Builder builder = ImmutableList.builder();
                    int size = immutableList2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        FeedProps feedProps = (FeedProps) immutableList2.get(i2);
                        GraphQLMedia graphQLMedia = (GraphQLMedia) feedProps.a;
                        if (!(graphQLMedia.j() == null || graphQLMedia.j().g() == 82650203)) {
                            builder.c(PhotosMetadataConversionHelper.a((GraphQLMedia) feedProps.a));
                        }
                    }
                    ImmutableList b = builder.b();
                    Preconditions.checkNotNull(b);
                    MediaGalleryLauncherParamsFactory.Builder builder2 = new MediaGalleryLauncherParamsFactory.Builder(MediaGalleryLauncherParamsFactory.d(b));
                    builder2.a(b);
                    this.f23777e.f23791h.a(collageAttachmentView.getContext(), builder2.a(((GraphQLMedia) ((FeedProps) immutableList2.get(i)).a).b()).a(FullscreenGallerySource.SEARCH_PHOTOS_GRID_MODULE).a(a).b(), CollageAttachmentAnimationUtil.a(collageAttachmentView, a, i));
                    ((OldCanLogEntityNavigation) e2).mo1251b((GraphQLNode) hashMap2.get(((GraphQLMedia) ((FeedProps) immutableList2.get(i)).a).b()));
                }
            }
        };
    }

    private static DraweeController[] m27421a(CollageLayoutCalculator<MediaCollageItem> collageLayoutCalculator, FeedImageLoader feedImageLoader, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        ImmutableList a = collageLayoutCalculator.a();
        FbDraweeControllerBuilder r = fbDraweeControllerBuilder.a(f23784c).r();
        DraweeController[] draweeControllerArr = new DraweeController[a.size()];
        for (int i = 0; i < a.size(); i++) {
            draweeControllerArr[i] = ((FbDraweeControllerBuilder) r.c(feedImageLoader.a(((MediaCollageItem) a.get(i)).b(), FeedImageType.Photo))).s();
        }
        return draweeControllerArr;
    }

    public static boolean m27423b(SearchResultsCollectionUnit<?> searchResultsCollectionUnit) {
        return searchResultsCollectionUnit.mo1321k() == GraphQLGraphSearchResultRole.PROMOTED_ENTITY_MEDIA;
    }
}
