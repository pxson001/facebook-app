package com.facebook.search.results.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.PartWithIsNeeded;
import com.facebook.reaction.feed.ReactionRootPartDefinition;
import com.facebook.search.results.model.SearchResultsBridge;
import com.facebook.search.results.model.unit.SearchResultsAnnotationUnit;
import com.facebook.search.results.model.unit.SearchResultsAwarenessUnit;
import com.facebook.search.results.model.unit.SearchResultsCentralWikiUnit;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.search.results.model.unit.SearchResultsComposerUnit;
import com.facebook.search.results.model.unit.SearchResultsEmptyEntityUnit;
import com.facebook.search.results.model.unit.SearchResultsEmptyUnit;
import com.facebook.search.results.model.unit.SearchResultsEntityUnit;
import com.facebook.search.results.model.unit.SearchResultsNewsContextUnit;
import com.facebook.search.results.model.unit.SearchResultsPostHeaderUnit;
import com.facebook.search.results.model.unit.SearchResultsPulseContextUnit;
import com.facebook.search.results.model.unit.SearchResultsPulseSentimentUnit;
import com.facebook.search.results.model.unit.SearchResultsPulseStoryUnit;
import com.facebook.search.results.model.unit.SearchResultsPulseTopicMetadataUnit;
import com.facebook.search.results.model.unit.SearchResultsReactionUnit;
import com.facebook.search.results.model.unit.SearchResultsResultsNoUnit;
import com.facebook.search.results.model.unit.SearchResultsSalePostUnit;
import com.facebook.search.results.model.unit.SearchResultsSeeMorePostsUnit;
import com.facebook.search.results.model.unit.SearchResultsSpellCorrectionUnit;
import com.facebook.search.results.model.unit.SearchResultsSportsUnit;
import com.facebook.search.results.model.unit.SearchResultsStoryUnit;
import com.facebook.search.results.model.unit.SearchResultsUnsupportedFeedUnit;
import com.facebook.search.results.model.unit.SearchResultsVideoUnit;
import com.facebook.search.results.model.unit.SearchResultsWayfinderUnit;
import com.facebook.search.results.model.unit.answer.SearchResultsTimeUnit;
import com.facebook.search.results.rows.sections.SearchResultsCollectionGroupPartDefinition;
import com.facebook.search.results.rows.sections.answer.SearchResultsTimeGroupPartDefinition;
import com.facebook.search.results.rows.sections.central.SearchResultsCentralEntityPhotoPartDefinition;
import com.facebook.search.results.rows.sections.central.SearchResultsCentralEntityWikiGroupPartDefinition;
import com.facebook.search.results.rows.sections.collection.SearchResultsAwarenessNodePartDefinition;
import com.facebook.search.results.rows.sections.common.SearchResultsAnnotationSelectorPartDefinition;
import com.facebook.search.results.rows.sections.common.SearchResultsPostsHeaderPartDefinition;
import com.facebook.search.results.rows.sections.composer.SearchComposerSinglePartDefinition;
import com.facebook.search.results.rows.sections.entities.SearchResultsSingleEntityNodePartDefinition;
import com.facebook.search.results.rows.sections.groupcommerce.GroupCommerceWrapperGroupPartDefinition;
import com.facebook.search.results.rows.sections.header.SearchResultsWayfinderPartDefinition;
import com.facebook.search.results.rows.sections.newscontext.SearchResultsNewsContextSelectorPartDefinition;
import com.facebook.search.results.rows.sections.noresults.SearchResultsEmptyEntityModuleGroupPartDefinition;
import com.facebook.search.results.rows.sections.noresults.SearchResultsEmptyUnitPartDefinition;
import com.facebook.search.results.rows.sections.noresults.SearchResultsNoResultsGroupPartDefinition;
import com.facebook.search.results.rows.sections.pulse.PulseContextGroupPartDefinition;
import com.facebook.search.results.rows.sections.pulse.PulseSentimentGroupPartDefinition;
import com.facebook.search.results.rows.sections.pulse.PulseStoriesGroupPartDefinition;
import com.facebook.search.results.rows.sections.seemore.SearchResultsSeeMoreGroupPartDefinition;
import com.facebook.search.results.rows.sections.spellcorrection.SearchResultsSpellCorrectionGroupPartDefinition;
import com.facebook.search.results.rows.sections.sports.SportsGroupPartDefinition;
import com.facebook.search.results.rows.sections.stories.SearchResultsStoryGroupPartDefinition;
import com.facebook.search.results.rows.sections.unsupported.UnsupportedModuleGroupPartDefinition;
import com.facebook.search.results.rows.sections.videos.topvideo.TopVideoModuleGroupPartDefinition;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ReactionOverlayDisplay */
public class SearchResultsFeedRootPartRegistry {
    private static SearchResultsFeedRootPartRegistry f23572b;
    private static final Object f23573c = new Object();
    public final Map<Class<?>, Lazy<PartWithIsNeeded<?>>> f23574a = new HashMap();

    private static SearchResultsFeedRootPartRegistry m27241b(InjectorLike injectorLike) {
        return new SearchResultsFeedRootPartRegistry(IdBasedLazy.a(injectorLike, 10609), IdBasedLazy.a(injectorLike, 10760), IdBasedLazy.a(injectorLike, 10796), IdBasedLazy.a(injectorLike, 10669), IdBasedLazy.a(injectorLike, 10758), IdBasedLazy.a(injectorLike, 10757), IdBasedLazy.a(injectorLike, 10750), IdBasedLazy.a(injectorLike, 10771), IdBasedLazy.a(injectorLike, 10784), IdBasedLazy.a(injectorLike, 10783), IdBasedLazy.a(injectorLike, 9857), IdBasedLazy.a(injectorLike, 10674), IdBasedLazy.a(injectorLike, 10616), IdBasedLazy.a(injectorLike, 10791), IdBasedLazy.a(injectorLike, 10801), IdBasedLazy.a(injectorLike, 10799), IdBasedLazy.a(injectorLike, 10831), IdBasedLazy.a(injectorLike, 10667), IdBasedLazy.a(injectorLike, 10621), IdBasedLazy.a(injectorLike, 10804), IdBasedLazy.a(injectorLike, 10700), IdBasedLazy.a(injectorLike, 10627), IdBasedLazy.a(injectorLike, 10711), IdBasedLazy.a(injectorLike, 10635), IdBasedLazy.a(injectorLike, 10618), IdBasedLazy.a(injectorLike, 10722));
    }

    public static SearchResultsFeedRootPartRegistry m27239a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsFeedRootPartRegistry b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23573c) {
                SearchResultsFeedRootPartRegistry searchResultsFeedRootPartRegistry;
                if (a2 != null) {
                    searchResultsFeedRootPartRegistry = (SearchResultsFeedRootPartRegistry) a2.a(f23573c);
                } else {
                    searchResultsFeedRootPartRegistry = f23572b;
                }
                if (searchResultsFeedRootPartRegistry == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27241b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23573c, b3);
                        } else {
                            f23572b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsFeedRootPartRegistry;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsFeedRootPartRegistry(Lazy<SearchResultsBridgePartDefinition> lazy, Lazy<SearchResultsNoResultsGroupPartDefinition> lazy2, Lazy<SearchResultsSpellCorrectionGroupPartDefinition> lazy3, Lazy<SearchResultsPostsHeaderPartDefinition> lazy4, Lazy<SearchResultsEmptyUnitPartDefinition> lazy5, Lazy<SearchResultsEmptyEntityModuleGroupPartDefinition> lazy6, Lazy<SearchResultsNewsContextSelectorPartDefinition> lazy7, Lazy<PulseContextGroupPartDefinition> lazy8, Lazy<PulseStoriesGroupPartDefinition> lazy9, Lazy<PulseSentimentGroupPartDefinition> lazy10, Lazy<ReactionRootPartDefinition> lazy11, Lazy<SearchComposerSinglePartDefinition> lazy12, Lazy<SearchResultsCollectionGroupPartDefinition> lazy13, Lazy<SearchResultsSeeMoreGroupPartDefinition> lazy14, Lazy<SearchResultsStoryGroupPartDefinition> lazy15, Lazy<SportsGroupPartDefinition> lazy16, Lazy<TopVideoModuleGroupPartDefinition> lazy17, Lazy<SearchResultsAnnotationSelectorPartDefinition> lazy18, Lazy<SearchResultsCentralEntityPhotoPartDefinition> lazy19, Lazy<UnsupportedModuleGroupPartDefinition> lazy20, Lazy<SearchResultsSingleEntityNodePartDefinition> lazy21, Lazy<SearchResultsCentralEntityWikiGroupPartDefinition> lazy22, Lazy<GroupCommerceWrapperGroupPartDefinition> lazy23, Lazy<SearchResultsAwarenessNodePartDefinition> lazy24, Lazy<SearchResultsTimeGroupPartDefinition> lazy25, Lazy<SearchResultsWayfinderPartDefinition> lazy26) {
        m27240a(SearchResultsBridge.class, lazy);
        m27240a(SearchResultsResultsNoUnit.class, lazy2);
        m27240a(SearchResultsSpellCorrectionUnit.class, lazy3);
        m27240a(SearchResultsPostHeaderUnit.class, lazy4);
        m27240a(SearchResultsEmptyUnit.class, lazy5);
        m27240a(SearchResultsEmptyEntityUnit.class, lazy6);
        m27240a(SearchResultsNewsContextUnit.class, lazy7);
        m27240a(SearchResultsPulseContextUnit.class, lazy8);
        m27240a(SearchResultsPulseStoryUnit.class, lazy9);
        m27240a(SearchResultsPulseSentimentUnit.class, lazy10);
        m27240a(SearchResultsReactionUnit.class, lazy11);
        m27240a(SearchResultsComposerUnit.class, lazy12);
        m27240a(SearchResultsCollectionUnit.class, lazy13);
        m27240a(SearchResultsSportsUnit.class, lazy16);
        m27240a(SearchResultsSeeMorePostsUnit.class, lazy14);
        m27240a(SearchResultsStoryUnit.class, lazy15);
        m27240a(SearchResultsEntityUnit.class, lazy21);
        m27240a(SearchResultsVideoUnit.class, lazy17);
        m27240a(SearchResultsAnnotationUnit.class, lazy18);
        m27240a(SearchResultsPulseTopicMetadataUnit.class, lazy19);
        m27240a(SearchResultsCentralWikiUnit.class, lazy22);
        m27240a(SearchResultsSalePostUnit.class, lazy23);
        m27240a(SearchResultsUnsupportedFeedUnit.class, lazy20);
        m27240a(SearchResultsAwarenessUnit.class, lazy24);
        m27240a(SearchResultsTimeUnit.class, lazy25);
        m27240a(SearchResultsWayfinderUnit.class, lazy26);
    }

    private <T> void m27240a(Class<? extends T> cls, Lazy<PartWithIsNeeded<? extends T>> lazy) {
        this.f23574a.put(cls, lazy);
    }
}
