package com.facebook.search.results.rows.sections.eyewitness;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.collage.CollageItem;
import com.facebook.feed.collage.CollageLayoutCalculator;
import com.facebook.feed.collage.CollageLayoutCalculatorProvider;
import com.facebook.feed.collage.StoryCollageItem;
import com.facebook.feed.collage.ui.CollageAttachmentView;
import com.facebook.feed.collage.ui.CollageAttachmentView.OnImageClickListener;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.CollageAttachmentAnimationUtil;
import com.facebook.feed.rows.sections.attachments.ui.MultistoryCollageLayoutProperties;
import com.facebook.feed.rows.sections.attachments.ui.MultistoryCollageLayoutPropertiesProvider;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.feed.ui.imageloader.FeedImageLoader.FeedImageType;
import com.facebook.feedplugins.attachments.collage.CollageAttachmentPartDefinition;
import com.facebook.feedplugins.attachments.video.VideoAttachmentDelegateProvider;
import com.facebook.feedplugins.video.FullscreenVideoLauncher;
import com.facebook.feedplugins.video.FullscreenVideoLauncherProvider;
import com.facebook.graphql.model.GraphQLStoryAttachment;
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
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder;
import com.facebook.photos.mediagallery.ui.DefaultMediaGalleryLauncher;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.google.common.base.Absent;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: QUERY */
public class SearchResultsEyewitnessCollageAttachmentPartDefinition extends MultiRowSinglePartDefinition<FeedProps<SearchResultsCollectionUnit<GraphQLStoryAttachment>>, State, HasPositionInformation, CollageAttachmentView> {
    public static final ViewType f24280a = CollageAttachmentPartDefinition.a;
    private static final CallerContext f24281b = CallerContext.a(SearchResultsEyewitnessCollageAttachmentPartDefinition.class, "graph_search_results_page");
    private static SearchResultsEyewitnessCollageAttachmentPartDefinition f24282l;
    private static final Object f24283m = new Object();
    private final FbDraweeControllerBuilder f24284c;
    private final MultistoryCollageLayoutPropertiesProvider f24285d;
    private final CollageLayoutCalculatorProvider f24286e;
    private final BackgroundPartDefinition f24287f;
    public final FeedImageLoader f24288g;
    public final MediaGalleryLauncher f24289h;
    private final MediaGalleryLauncherParamsFactory f24290i;
    private final VideoAttachmentDelegateProvider f24291j;
    private final FullscreenVideoLauncherProvider f24292k;

    /* compiled from: QUERY */
    public class State {
        public final MultistoryCollageLayoutProperties f24274a;
        public final CollageLayoutCalculator<StoryCollageItem> f24275b;
        public final ImmutableList<StoryCollageItem> f24276c;
        public final DraweeController[] f24277d;
        public final FullscreenVideoLauncher[] f24278e;
        public final OnImageClickListener<StoryCollageItem> f24279f;

        public State(MultistoryCollageLayoutProperties multistoryCollageLayoutProperties, CollageLayoutCalculator<StoryCollageItem> collageLayoutCalculator, ImmutableList<StoryCollageItem> immutableList, DraweeController[] draweeControllerArr, FullscreenVideoLauncher[] fullscreenVideoLauncherArr, OnImageClickListener<StoryCollageItem> onImageClickListener) {
            this.f24274a = multistoryCollageLayoutProperties;
            this.f24275b = collageLayoutCalculator;
            this.f24276c = immutableList;
            this.f24277d = draweeControllerArr;
            this.f24278e = fullscreenVideoLauncherArr;
            this.f24279f = onImageClickListener;
        }
    }

    private static SearchResultsEyewitnessCollageAttachmentPartDefinition m27806b(InjectorLike injectorLike) {
        return new SearchResultsEyewitnessCollageAttachmentPartDefinition(FbDraweeControllerBuilder.b(injectorLike), (MultistoryCollageLayoutPropertiesProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MultistoryCollageLayoutPropertiesProvider.class), (CollageLayoutCalculatorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CollageLayoutCalculatorProvider.class), BackgroundPartDefinition.a(injectorLike), FeedImageLoader.a(injectorLike), (MediaGalleryLauncher) DefaultMediaGalleryLauncher.m2459a(injectorLike), MediaGalleryLauncherParamsFactory.a(injectorLike), (VideoAttachmentDelegateProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoAttachmentDelegateProvider.class), (FullscreenVideoLauncherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FullscreenVideoLauncherProvider.class));
    }

    public final /* bridge */ /* synthetic */ void m27809a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1252979354);
        State state = (State) obj2;
        CollageAttachmentView collageAttachmentView = (CollageAttachmentView) view;
        collageAttachmentView.a(state.f24275b, state.f24277d);
        collageAttachmentView.u = state.f24279f;
        Logger.a(8, EntryType.MARK_POP, -2032097020, a);
    }

    public final boolean m27810a(Object obj) {
        return MultistoryCollageLayoutProperties.a(m27805a((SearchResultsCollectionUnit) ((FeedProps) obj).a));
    }

    public final void m27811b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        CollageAttachmentView collageAttachmentView = (CollageAttachmentView) view;
        collageAttachmentView.a();
        collageAttachmentView.u = null;
    }

    public static SearchResultsEyewitnessCollageAttachmentPartDefinition m27804a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsEyewitnessCollageAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24283m) {
                SearchResultsEyewitnessCollageAttachmentPartDefinition searchResultsEyewitnessCollageAttachmentPartDefinition;
                if (a2 != null) {
                    searchResultsEyewitnessCollageAttachmentPartDefinition = (SearchResultsEyewitnessCollageAttachmentPartDefinition) a2.a(f24283m);
                } else {
                    searchResultsEyewitnessCollageAttachmentPartDefinition = f24282l;
                }
                if (searchResultsEyewitnessCollageAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27806b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24283m, b3);
                        } else {
                            f24282l = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsEyewitnessCollageAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsEyewitnessCollageAttachmentPartDefinition(FbDraweeControllerBuilder fbDraweeControllerBuilder, MultistoryCollageLayoutPropertiesProvider multistoryCollageLayoutPropertiesProvider, CollageLayoutCalculatorProvider collageLayoutCalculatorProvider, BackgroundPartDefinition backgroundPartDefinition, FeedImageLoader feedImageLoader, MediaGalleryLauncher mediaGalleryLauncher, MediaGalleryLauncherParamsFactory mediaGalleryLauncherParamsFactory, VideoAttachmentDelegateProvider videoAttachmentDelegateProvider, FullscreenVideoLauncherProvider fullscreenVideoLauncherProvider) {
        this.f24284c = fbDraweeControllerBuilder;
        this.f24285d = multistoryCollageLayoutPropertiesProvider;
        this.f24286e = collageLayoutCalculatorProvider;
        this.f24287f = backgroundPartDefinition;
        this.f24288g = feedImageLoader;
        this.f24289h = mediaGalleryLauncher;
        this.f24290i = mediaGalleryLauncherParamsFactory;
        this.f24291j = videoAttachmentDelegateProvider;
        this.f24292k = fullscreenVideoLauncherProvider;
    }

    public final ViewType m27807a() {
        return f24280a;
    }

    private State m27803a(SubParts<HasPositionInformation> subParts, FeedProps<SearchResultsCollectionUnit<GraphQLStoryAttachment>> feedProps) {
        int i = 0;
        SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) feedProps.a;
        subParts.a(this.f24287f, new StylingData(feedProps, PaddingStyle.g));
        MultistoryCollageLayoutProperties a = this.f24285d.a(m27805a(searchResultsCollectionUnit));
        CollageLayoutCalculator a2 = this.f24286e.a(a);
        ImmutableList a3 = a.a();
        int size = a3 != null ? a3.size() : 0;
        DraweeController[] draweeControllerArr = new DraweeController[size];
        FullscreenVideoLauncher[] fullscreenVideoLauncherArr = new FullscreenVideoLauncher[size];
        FbDraweeControllerBuilder r = this.f24284c.a(f24281b).r();
        while (i < size) {
            FeedProps c = ((StoryCollageItem) a3.get(i)).c();
            FeedImageType a4 = a.a((GraphQLStoryAttachment) c.a());
            r.c(this.f24288g.a(((GraphQLStoryAttachment) c.a()).r(), a4));
            draweeControllerArr[i] = r.s();
            if (a4 == FeedImageType.Video) {
                fullscreenVideoLauncherArr[i] = this.f24292k.a(this.f24291j.a(c, Absent.withType()));
            }
            i++;
        }
        return new State(a, a2, a3, draweeControllerArr, fullscreenVideoLauncherArr, m27802a(fullscreenVideoLauncherArr, a3, a));
    }

    private OnImageClickListener<StoryCollageItem> m27802a(final FullscreenVideoLauncher[] fullscreenVideoLauncherArr, final ImmutableList<StoryCollageItem> immutableList, final MultistoryCollageLayoutProperties multistoryCollageLayoutProperties) {
        return new OnImageClickListener<StoryCollageItem>(this) {
            final /* synthetic */ SearchResultsEyewitnessCollageAttachmentPartDefinition f24273d;

            public final void m27801a(CollageAttachmentView collageAttachmentView, CollageItem collageItem, int i) {
                if (((StoryCollageItem) collageItem).a()) {
                    SearchResultsEyewitnessCollageAttachmentPartDefinition searchResultsEyewitnessCollageAttachmentPartDefinition = this.f24273d;
                    fullscreenVideoLauncherArr[i].m14736a(collageAttachmentView);
                    return;
                }
                Builder a;
                searchResultsEyewitnessCollageAttachmentPartDefinition = this.f24273d;
                ImmutableList immutableList = immutableList;
                MultistoryCollageLayoutProperties multistoryCollageLayoutProperties = multistoryCollageLayoutProperties;
                GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((StoryCollageItem) immutableList.get(i)).a.a;
                Preconditions.checkNotNull(graphQLStoryAttachment.r());
                ImageRequest a2 = FeedImageLoader.a(searchResultsEyewitnessCollageAttachmentPartDefinition.f24288g.b(graphQLStoryAttachment.r(), multistoryCollageLayoutProperties.a(graphQLStoryAttachment)));
                if (graphQLStoryAttachment.t() != null) {
                    a = MediaGalleryLauncherParamsFactory.b(graphQLStoryAttachment.t()).a(graphQLStoryAttachment.r().b()).a(a2);
                } else {
                    a = MediaGalleryLauncherParamsFactory.a(graphQLStoryAttachment);
                }
                a.a(FullscreenGallerySource.SEARCH_EYEWITNESS_MODULE);
                searchResultsEyewitnessCollageAttachmentPartDefinition.f24289h.a(collageAttachmentView.getContext(), a.b(), CollageAttachmentAnimationUtil.a(collageAttachmentView, a2, i));
            }
        };
    }

    private static ImmutableList<FeedProps<GraphQLStoryAttachment>> m27805a(SearchResultsCollectionUnit<GraphQLStoryAttachment> searchResultsCollectionUnit) {
        FeedProps c = FeedProps.c(searchResultsCollectionUnit);
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList immutableList = searchResultsCollectionUnit.f23463d;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.c(c.a((GraphQLStoryAttachment) immutableList.get(i)));
        }
        return builder.b();
    }
}
