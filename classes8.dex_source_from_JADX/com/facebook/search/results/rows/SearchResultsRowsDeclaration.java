package com.facebook.search.results.rows;

import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.sections.common.EmptyPartDefinition;
import com.facebook.feed.rows.sections.common.unknown.UnknownFeedUnitPartDefinition;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.results.rows.sections.central.SearchResultsCentralEntityPhotoPartDefinition;
import com.facebook.search.results.rows.sections.central.SearchResultsCentralEntityWikiAboutTextConvertedPartDefinition;
import com.facebook.search.results.rows.sections.central.SearchResultsCentralEntityWikiReadMoreConvertedPartDefinition;
import com.facebook.search.results.rows.sections.central.SearchResultsCentralEntityWikiTitleConvertedPartDefinition;
import com.facebook.search.results.rows.sections.collection.SearchResultsArticlesItemPartDefinition;
import com.facebook.search.results.rows.sections.collection.SearchResultsAwarenessNodePartDefinition;
import com.facebook.search.results.rows.sections.collection.SearchResultsMediaGridPartDefinition;
import com.facebook.search.results.rows.sections.collection.SearchResultsSeeMoreFigPartDefinition;
import com.facebook.search.results.rows.sections.collection.SearchResultsSeeMorePartDefinition;
import com.facebook.search.results.rows.sections.commerce.CommerceListItemPartDefinition;
import com.facebook.search.results.rows.sections.commerce.CommerceProductCarouselSeeMorePartDefinition;
import com.facebook.search.results.rows.sections.commerce.CommerceProductItemPartDefinition;
import com.facebook.search.results.rows.sections.commerce.CommerceProductItemsGridRowPartDefinition;
import com.facebook.search.results.rows.sections.commerce.SearchResultsCommerceTitleTogglePartDefinition;
import com.facebook.search.results.rows.sections.common.SearchResultsAnnotationPartDefinition;
import com.facebook.search.results.rows.sections.common.SearchResultsAnnotationWithPostCountPartDefinition;
import com.facebook.search.results.rows.sections.common.SearchResultsCommonViewTypes;
import com.facebook.search.results.rows.sections.common.SearchResultsEmptyPartDefinition;
import com.facebook.search.results.rows.sections.composer.SearchComposerSinglePartDefinition;
import com.facebook.search.results.rows.sections.derp.DerpSuperDenseHeaderNoAttachmentPartDefinition;
import com.facebook.search.results.rows.sections.derp.DerpSuperDenseHeaderWithBackgroundPartDefinition;
import com.facebook.search.results.rows.sections.derp.SmallPhotoShareAttachmentWithMarginPartDefinition;
import com.facebook.search.results.rows.sections.entities.OldSearchResultsEntityLargeRowPartDefinition;
import com.facebook.search.results.rows.sections.entities.SearchResultsEntityLargeRowPartDefinition;
import com.facebook.search.results.rows.sections.entities.SearchResultsEntityPivotRowPartDefinition;
import com.facebook.search.results.rows.sections.entities.SearchResultsEntityRowFigPartDefinition;
import com.facebook.search.results.rows.sections.entities.SearchResultsEntityRowPartDefinition;
import com.facebook.search.results.rows.sections.entities.SearchResultsEntityWithFacepileLargeRowPartDefinition;
import com.facebook.search.results.rows.sections.entities.SearchResultsEntityWithFacepileRowFigPartDefinition;
import com.facebook.search.results.rows.sections.entities.SearchResultsEntityWithFacepileRowPartDefinition;
import com.facebook.search.results.rows.sections.eyewitness.SearchResultsEyewitnessCollageAttachmentPartDefinition;
import com.facebook.search.results.rows.sections.fanfavorite.GametimeFanFavoriteAfterVotingPartDefinition;
import com.facebook.search.results.rows.sections.fanfavorite.GametimeFanFavoriteBeforeVotingPartDefinition;
import com.facebook.search.results.rows.sections.header.SearchResultsTitleActionPartDefinition;
import com.facebook.search.results.rows.sections.header.SearchResultsTitlePartDefinition;
import com.facebook.search.results.rows.sections.header.SearchResultsWayfinderPartDefinition;
import com.facebook.search.results.rows.sections.local.SearchResultsPlacePartDefinition;
import com.facebook.search.results.rows.sections.local.SearchResultsPlacesMapPartDefinition;
import com.facebook.search.results.rows.sections.newscontext.SearchResultsNewsContextAttributionPartDefinition;
import com.facebook.search.results.rows.sections.newscontext.SearchResultsNewsContextFullHeightPartDefinition;
import com.facebook.search.results.rows.sections.newscontext.SearchResultsNewsContextHeaderPhotoPartDefinition;
import com.facebook.search.results.rows.sections.newscontext.SearchResultsNewsContextHeaderVideoPartDefinition;
import com.facebook.search.results.rows.sections.newscontext.SearchResultsNewsContextSummaryPartDefinition;
import com.facebook.search.results.rows.sections.newscontext.SearchResultsNewsContextTitlePartDefinition;
import com.facebook.search.results.rows.sections.noresults.SearchResultsEmptyEntityModuleBodyPartDefinition;
import com.facebook.search.results.rows.sections.noresults.SearchResultsEmptyUnitPartDefinition;
import com.facebook.search.results.rows.sections.noresults.SearchResultsNoResultsContentPartDefinition;
import com.facebook.search.results.rows.sections.pulse.PulseCommonPhraseItemPartDefinition;
import com.facebook.search.results.rows.sections.pulse.PulseCommonQuoteContentPartDefinition;
import com.facebook.search.results.rows.sections.pulse.PulseContextFooterPartDefinition;
import com.facebook.search.results.rows.sections.pulse.PulseContextHeaderPhotoConvertedPartDefinition;
import com.facebook.search.results.rows.sections.pulse.PulseContextHeaderPhotoPartDefinition;
import com.facebook.search.results.rows.sections.pulse.PulseContextHeaderTextConvertedPartDefinition;
import com.facebook.search.results.rows.sections.pulse.PulseContextHeaderTextPartDefinition;
import com.facebook.search.results.rows.sections.pulse.PulseContextSummaryConvertedPartDefinition;
import com.facebook.search.results.rows.sections.pulse.PulseContextSummaryPartDefinition;
import com.facebook.search.results.rows.sections.pulse.PulseRelatedLinksItemPartDefinition;
import com.facebook.search.results.rows.sections.pulse.PulseSentimentEmotionalItemPartDefinition;
import com.facebook.search.results.rows.sections.pulse.PulseSentimentEmotionalVerticalItemPartDefinition;
import com.facebook.search.results.rows.sections.pulsetopic.PulseTopicRelatedTopicsPartDefinition;
import com.facebook.search.results.rows.sections.relatednews.SearchResultsRelatedNewsContentPartDefinition;
import com.facebook.search.results.rows.sections.seemore.SearchResultsDividerPartDefinition;
import com.facebook.search.results.rows.sections.seemore.SearchResultsSeeMorePostsPartDefinition;
import com.facebook.search.results.rows.sections.seemore.SearchResultsSeeMoreQueryPartDefinition;
import com.facebook.search.results.rows.sections.seemore.SearchResultsSeeMoreTrendingPostsPartDefinition;
import com.facebook.search.results.rows.sections.spellcorrection.SearchResultsSpellCorrectionEscapePartDefinition;
import com.facebook.search.results.rows.sections.sports.SportsDetailPartDefinition;
import com.facebook.search.results.rows.sections.sports.SportsPhotoPartDefinition;
import com.facebook.search.results.rows.sections.stories.SearchResultsStorySnippetPartDefinition;
import com.facebook.search.results.rows.sections.unsupported.SearchResultsUnsupportedResultPartDefinition;
import com.facebook.search.results.rows.sections.videos.SearchResultsLiveVideoPagePartDefinition;
import com.facebook.search.results.rows.sections.videos.SearchResultsLiveVideoPartDefinition;
import com.facebook.search.results.rows.sections.videos.SearchResultsVideoChannelLargeRowPartDefinition;
import com.facebook.search.results.rows.sections.videos.SearchResultsVideoPartDefinition;
import com.facebook.search.results.rows.sections.videos.SearchResultsVideoPlayerPartDefinition;
import com.facebook.search.results.rows.sections.videos.SearchResultsVideosHScrollPartDefinition;
import com.facebook.search.results.rows.sections.videos.SearchResultsWebVideoPartDefinition;
import com.facebook.search.results.rows.sections.videos.inline.SearchResultsInlineVideoPagePartDefinition;
import com.facebook.search.results.rows.sections.videos.inline.SearchResultsInlineVideoPartDefinition;
import com.google.common.collect.ImmutableList;
import javax.inject.Singleton;

@Singleton
/* compiled from: ReactRouteName */
public class SearchResultsRowsDeclaration implements FeedRowSupportDeclaration {
    private static final ImmutableList<ViewType> f23587a = ImmutableList.of(SearchResultsCommonViewTypes.f24003a, SearchResultsCommonViewTypes.f24005c, SearchResultsTitlePartDefinition.f24411a, SearchResultsTitleActionPartDefinition.f24397a, SearchResultsEntityPivotRowPartDefinition.f24192a, SearchResultsEmptyPartDefinition.f24007a, SearchResultsSeeMorePartDefinition.f23838a, SearchResultsSeeMoreFigPartDefinition.f23828a, SearchResultsSeeMoreQueryPartDefinition.f24990a, SearchResultsStorySnippetPartDefinition.f25088a, SearchResultsDividerPartDefinition.f24968a, SearchResultsAnnotationPartDefinition.f23986a, new ViewType[]{SearchResultsAnnotationWithPostCountPartDefinition.f23996a, SearchResultsSeeMorePostsPartDefinition.f24978a, SearchResultsSeeMoreTrendingPostsPartDefinition.f24999a, SearchResultsArticlesItemPartDefinition.f23720a, SearchResultsEntityRowPartDefinition.f24219a, SearchResultsEntityRowFigPartDefinition.f24209a, SearchResultsEntityLargeRowPartDefinition.f24183a, OldSearchResultsEntityLargeRowPartDefinition.f24132a, SearchResultsEntityWithFacepileRowPartDefinition.f24250a, SearchResultsEntityWithFacepileLargeRowPartDefinition.f24231a, SearchResultsEntityWithFacepileRowFigPartDefinition.f24240a, SearchResultsVideoChannelLargeRowPartDefinition.f25168a, SearchResultsMediaGridPartDefinition.f23782a, SearchResultsEyewitnessCollageAttachmentPartDefinition.f24280a, SearchResultsSpellCorrectionEscapePartDefinition.f25011a, SearchResultsEmptyUnitPartDefinition.f24696a, SearchResultsNoResultsContentPartDefinition.f24702a, SearchResultsVideoPartDefinition.f25207a, SearchResultsWebVideoPartDefinition.f25258a, SearchResultsPlacesMapPartDefinition.f24609a, SearchResultsPlacePartDefinition.f24591a, SearchResultsUnsupportedResultPartDefinition.f25097a, EmptyPartDefinition.a, UnknownFeedUnitPartDefinition.a, SearchResultsRelatedNewsContentPartDefinition.f24950a, SearchResultsNewsContextHeaderPhotoPartDefinition.f24642a, SearchResultsNewsContextHeaderVideoPartDefinition.f24646a, SearchResultsNewsContextTitlePartDefinition.f24668a, SearchResultsNewsContextSummaryPartDefinition.f24662a, SearchResultsNewsContextAttributionPartDefinition.f24617a, SearchResultsNewsContextFullHeightPartDefinition.f24625a, SportsDetailPartDefinition.f25035a, SportsPhotoPartDefinition.f25071a, SearchComposerSinglePartDefinition.f24052a, GametimeFanFavoriteBeforeVotingPartDefinition.f24309a, GametimeFanFavoriteAfterVotingPartDefinition.f24298a, PulseContextFooterPartDefinition.f24797a, PulseContextHeaderPhotoPartDefinition.f24836a, PulseContextHeaderTextPartDefinition.f24851a, PulseContextSummaryPartDefinition.f24862a, PulseCommonPhraseItemPartDefinition.f24720a, PulseCommonQuoteContentPartDefinition.f24731a, PulseRelatedLinksItemPartDefinition.f24870a, PulseSentimentEmotionalItemPartDefinition.f24900a, PulseSentimentEmotionalVerticalItemPartDefinition.f24908a, PulseTopicRelatedTopicsPartDefinition.f24934a, SearchResultsCentralEntityPhotoPartDefinition.f23633a, SearchResultsEmptyEntityModuleBodyPartDefinition.f24687a, SearchResultsVideosHScrollPartDefinition.f25241a, SearchResultsLiveVideoPagePartDefinition.f25128a, SearchResultsLiveVideoPartDefinition.f25137a, SearchResultsInlineVideoPagePartDefinition.f25286a, SearchResultsInlineVideoPartDefinition.f25291a, SearchResultsVideoPlayerPartDefinition.f25228a, SearchResultsAwarenessNodePartDefinition.f23730a, SearchResultsWayfinderPartDefinition.f24427a, CommerceListItemPartDefinition.f23878a, CommerceProductItemPartDefinition.f23930a, CommerceProductCarouselSeeMorePartDefinition.f23908a, CommerceProductItemsGridRowPartDefinition.f23945a, SearchResultsCommerceTitleTogglePartDefinition.f23976a, PulseContextSummaryConvertedPartDefinition.f24857a, PulseContextHeaderTextConvertedPartDefinition.f24845a, PulseContextHeaderPhotoConvertedPartDefinition.f24821a, SearchResultsCentralEntityWikiTitleConvertedPartDefinition.f23695a, SearchResultsCentralEntityWikiAboutTextConvertedPartDefinition.f23643a, SearchResultsCentralEntityWikiReadMoreConvertedPartDefinition.f23680a, DerpSuperDenseHeaderWithBackgroundPartDefinition.f24081a, DerpSuperDenseHeaderNoAttachmentPartDefinition.f24072a, SmallPhotoShareAttachmentWithMarginPartDefinition.f24093a});
    private static volatile SearchResultsRowsDeclaration f23588b;

    public static com.facebook.search.results.rows.SearchResultsRowsDeclaration m27251a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f23588b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.search.results.rows.SearchResultsRowsDeclaration.class;
        monitor-enter(r1);
        r0 = f23588b;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m27250a();	 Catch:{ all -> 0x0034 }
        f23588b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f23588b;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.rows.SearchResultsRowsDeclaration.a(com.facebook.inject.InjectorLike):com.facebook.search.results.rows.SearchResultsRowsDeclaration");
    }

    private static SearchResultsRowsDeclaration m27250a() {
        return new SearchResultsRowsDeclaration();
    }

    public final void m27252a(ListItemRowController listItemRowController) {
        int size = f23587a.size();
        for (int i = 0; i < size; i++) {
            listItemRowController.a((ViewType) f23587a.get(i));
        }
    }
}
