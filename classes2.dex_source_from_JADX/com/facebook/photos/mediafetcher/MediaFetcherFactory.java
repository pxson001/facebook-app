package com.facebook.photos.mediafetcher;

import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.api.ufiservices.common.FetchReactorsParamBuilderUtil;
import com.facebook.api.ufiservices.common.FetchRecentActivityParamBuilderUtil;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcher;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcherConstructionRule;
import com.facebook.photos.mediafetcher.interfaces.MediaQuery;
import com.facebook.photos.mediafetcher.query.MenuPhotosMediaQuery;
import com.facebook.photos.mediafetcher.query.MenuPhotosMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.NodesMediaQuery;
import com.facebook.photos.mediafetcher.query.NodesMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.PaginatedMediaQuery;
import com.facebook.photos.mediafetcher.query.PhotosByCategoryMediaQuery;
import com.facebook.photos.mediafetcher.query.PhotosByCategoryMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.PhotosTakenHereMediaQuery;
import com.facebook.photos.mediafetcher.query.PhotosTakenHereMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.PhotosTakenOfMediaQuery;
import com.facebook.photos.mediafetcher.query.PhotosTakenOfMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.PostedPhotosMediaQuery;
import com.facebook.photos.mediafetcher.query.PostedPhotosMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.ProfilePictureMediaQuery;
import com.facebook.photos.mediafetcher.query.ProfilePictureMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.ReactionStoryMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.SetIdMediaQuery;
import com.facebook.photos.mediafetcher.query.SetIdMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.SetTokenMediaQuery;
import com.facebook.photos.mediafetcher.query.SetTokenMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.StoryMediaQuery;
import com.facebook.photos.mediafetcher.query.StoryMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.param.CategoryQueryParam;
import com.facebook.photos.mediafetcher.query.param.IdQueryParam;
import com.facebook.photos.mediafetcher.query.param.MediaTypeQueryParam;
import com.facebook.photos.mediafetcher.query.param.MultiIdQueryParam;
import com.facebook.photos.mediafetcher.util.MediaMetadataUtil;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: groups_native_files_download */
public class MediaFetcherFactory {
    private final PaginatedGraphQLMediaFetcherProvider f21556a;
    private final PaginatedGraphQLFetcherProvider f21557b;
    private final StoryMediaQueryProvider f21558c;
    private final NodesMediaQueryProvider f21559d;
    private final ReactionStoryMediaQueryProvider f21560e;
    private final SetIdMediaQueryProvider f21561f;
    private final SetTokenMediaQueryProvider f21562g;
    private final PhotosTakenHereMediaQueryProvider f21563h;
    private final PhotosTakenOfMediaQueryProvider f21564i;
    private final PostedPhotosMediaQueryProvider f21565j;
    private final ProfilePictureMediaQueryProvider f21566k;
    private final PhotosByCategoryMediaQueryProvider f21567l;
    private final MenuPhotosMediaQueryProvider f21568m;

    public static MediaFetcherFactory m29266b(InjectorLike injectorLike) {
        return new MediaFetcherFactory((PaginatedGraphQLMediaFetcherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PaginatedGraphQLMediaFetcherProvider.class), (PaginatedGraphQLFetcherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PaginatedGraphQLFetcherProvider.class), (StoryMediaQueryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(StoryMediaQueryProvider.class), (NodesMediaQueryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(NodesMediaQueryProvider.class), (ReactionStoryMediaQueryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionStoryMediaQueryProvider.class), (SetIdMediaQueryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SetIdMediaQueryProvider.class), (SetTokenMediaQueryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SetTokenMediaQueryProvider.class), (PhotosTakenHereMediaQueryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PhotosTakenHereMediaQueryProvider.class), (PhotosTakenOfMediaQueryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PhotosTakenOfMediaQueryProvider.class), (PostedPhotosMediaQueryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PostedPhotosMediaQueryProvider.class), (ProfilePictureMediaQueryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ProfilePictureMediaQueryProvider.class), (PhotosByCategoryMediaQueryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PhotosByCategoryMediaQueryProvider.class), (MenuPhotosMediaQueryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MenuPhotosMediaQueryProvider.class));
    }

    public static MediaFetcherFactory m29264a(InjectorLike injectorLike) {
        return m29266b(injectorLike);
    }

    @Inject
    public MediaFetcherFactory(PaginatedGraphQLMediaFetcherProvider paginatedGraphQLMediaFetcherProvider, PaginatedGraphQLFetcherProvider paginatedGraphQLFetcherProvider, StoryMediaQueryProvider storyMediaQueryProvider, NodesMediaQueryProvider nodesMediaQueryProvider, ReactionStoryMediaQueryProvider reactionStoryMediaQueryProvider, SetIdMediaQueryProvider setIdMediaQueryProvider, SetTokenMediaQueryProvider setTokenMediaQueryProvider, PhotosTakenHereMediaQueryProvider photosTakenHereMediaQueryProvider, PhotosTakenOfMediaQueryProvider photosTakenOfMediaQueryProvider, PostedPhotosMediaQueryProvider postedPhotosMediaQueryProvider, ProfilePictureMediaQueryProvider profilePictureMediaQueryProvider, PhotosByCategoryMediaQueryProvider photosByCategoryMediaQueryProvider, MenuPhotosMediaQueryProvider menuPhotosMediaQueryProvider) {
        this.f21556a = paginatedGraphQLMediaFetcherProvider;
        this.f21557b = paginatedGraphQLFetcherProvider;
        this.f21558c = storyMediaQueryProvider;
        this.f21559d = nodesMediaQueryProvider;
        this.f21560e = reactionStoryMediaQueryProvider;
        this.f21561f = setIdMediaQueryProvider;
        this.f21562g = setTokenMediaQueryProvider;
        this.f21563h = photosTakenHereMediaQueryProvider;
        this.f21564i = photosTakenOfMediaQueryProvider;
        this.f21565j = postedPhotosMediaQueryProvider;
        this.f21566k = profilePictureMediaQueryProvider;
        this.f21567l = photosByCategoryMediaQueryProvider;
        this.f21568m = menuPhotosMediaQueryProvider;
    }

    public final MediaFetcher m29268a(MediaFetcherConstructionRule mediaFetcherConstructionRule, @Nullable CallerContext callerContext) {
        Preconditions.checkNotNull(mediaFetcherConstructionRule);
        return m29265a(m29267b(mediaFetcherConstructionRule, callerContext));
    }

    private MediaQuery m29267b(MediaFetcherConstructionRule mediaFetcherConstructionRule, @Nullable CallerContext callerContext) {
        Preconditions.checkNotNull(mediaFetcherConstructionRule);
        if (mediaFetcherConstructionRule.a == this.f21558c.getClass()) {
            return new StoryMediaQuery((IdQueryParam) mediaFetcherConstructionRule.b, callerContext, MediaMetadataUtil.a(this.f21558c));
        } else if (mediaFetcherConstructionRule.a == this.f21559d.getClass()) {
            return new NodesMediaQuery((MultiIdQueryParam) mediaFetcherConstructionRule.b, callerContext, MediaMetadataUtil.a(this.f21559d));
        } else if (mediaFetcherConstructionRule.a == this.f21560e.getClass()) {
            return this.f21560e.m29270a((IdQueryParam) mediaFetcherConstructionRule.b, callerContext);
        } else {
            InjectorLike injectorLike;
            if (mediaFetcherConstructionRule.a == this.f21561f.getClass()) {
                injectorLike = this.f21561f;
                return new SetIdMediaQuery((IdQueryParam) mediaFetcherConstructionRule.b, callerContext, MediaMetadataUtil.a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494));
            } else if (mediaFetcherConstructionRule.a == this.f21562g.getClass()) {
                injectorLike = this.f21562g;
                return new SetTokenMediaQuery((MediaTypeQueryParam) mediaFetcherConstructionRule.b, callerContext, MediaMetadataUtil.a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), AutomaticPhotoCaptioningUtils.m10187b(injectorLike));
            } else if (mediaFetcherConstructionRule.a == this.f21563h.getClass()) {
                return new PhotosTakenHereMediaQuery((IdQueryParam) mediaFetcherConstructionRule.b, callerContext, MediaMetadataUtil.a(this.f21563h));
            } else if (mediaFetcherConstructionRule.a == this.f21564i.getClass()) {
                return new PhotosTakenOfMediaQuery((IdQueryParam) mediaFetcherConstructionRule.b, callerContext, MediaMetadataUtil.a(this.f21564i));
            } else if (mediaFetcherConstructionRule.a == this.f21565j.getClass()) {
                return new PostedPhotosMediaQuery((IdQueryParam) mediaFetcherConstructionRule.b, callerContext, MediaMetadataUtil.a(this.f21565j));
            } else if (mediaFetcherConstructionRule.a == this.f21566k.getClass()) {
                injectorLike = this.f21566k;
                return new ProfilePictureMediaQuery((IdQueryParam) mediaFetcherConstructionRule.b, callerContext, SizeAwareImageUtil.m10234a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
            } else if (mediaFetcherConstructionRule.a == this.f21567l.getClass()) {
                injectorLike = this.f21567l;
                return new PhotosByCategoryMediaQuery((CategoryQueryParam) mediaFetcherConstructionRule.b, callerContext, FetchReactorsParamBuilderUtil.m10406a(injectorLike), FetchRecentActivityParamBuilderUtil.m10419a(injectorLike));
            } else if (mediaFetcherConstructionRule.a == this.f21568m.getClass()) {
                injectorLike = this.f21568m;
                return new MenuPhotosMediaQuery((IdQueryParam) mediaFetcherConstructionRule.b, callerContext, FetchReactorsParamBuilderUtil.m10406a(injectorLike), FetchRecentActivityParamBuilderUtil.m10419a(injectorLike));
            } else {
                throw new RuntimeException("Can not create query for rule: " + mediaFetcherConstructionRule);
            }
        }
    }

    @VisibleForTesting
    private MediaFetcher m29265a(MediaQuery mediaQuery) {
        Preconditions.checkNotNull(mediaQuery);
        if (mediaQuery instanceof PaginatedMediaQuery) {
            PaginatedMediaQuery paginatedMediaQuery = (PaginatedMediaQuery) mediaQuery;
            if (paginatedMediaQuery.b != MediaMetadata.class) {
                return this.f21557b.m29269a(paginatedMediaQuery);
            }
            InjectorLike injectorLike = this.f21556a;
            return new PaginatedGraphQLMediaFetcher(paginatedMediaQuery, DefaultAndroidThreadUtil.m1646b(injectorLike), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike), GraphQLSubscriptionHolder.m14626b(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
        }
        throw new RuntimeException("Can not create fetcher for query: " + mediaQuery.getClass());
    }
}
