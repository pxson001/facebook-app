package com.facebook.search.results.model.specification;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPhrasesAnalysisItem;
import com.facebook.graphql.model.GraphQLQuotesAnalysisItem;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.search.results.model.SearchResultsBridge;
import com.facebook.search.results.model.SportsTeam;
import com.facebook.search.results.model.specification.matchers.DisplayStyleMatcher;
import com.facebook.search.results.model.specification.matchers.DisplayStyleMatchers;
import com.facebook.search.results.model.specification.matchers.MultiDisplayStyleMatcher;
import com.facebook.search.results.model.unit.SearchResultsAnnotationUnit;
import com.facebook.search.results.model.unit.SearchResultsCentralWikiUnit;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.search.results.model.unit.SearchResultsComposerUnit;
import com.facebook.search.results.model.unit.SearchResultsEmptyEntityUnit;
import com.facebook.search.results.model.unit.SearchResultsEmptyUnit;
import com.facebook.search.results.model.unit.SearchResultsEntityPivotUnit;
import com.facebook.search.results.model.unit.SearchResultsEntityUnit;
import com.facebook.search.results.model.unit.SearchResultsNewsContextUnit;
import com.facebook.search.results.model.unit.SearchResultsProductItemUnit;
import com.facebook.search.results.model.unit.SearchResultsPulseContextUnit;
import com.facebook.search.results.model.unit.SearchResultsPulseSentimentUnit;
import com.facebook.search.results.model.unit.SearchResultsPulseStoryUnit;
import com.facebook.search.results.model.unit.SearchResultsPulseTopicMetadataUnit;
import com.facebook.search.results.model.unit.SearchResultsReactionUnit;
import com.facebook.search.results.model.unit.SearchResultsSalePostUnit;
import com.facebook.search.results.model.unit.SearchResultsSeeMorePostsUnit;
import com.facebook.search.results.model.unit.SearchResultsSportsUnit;
import com.facebook.search.results.model.unit.SearchResultsStoryUnit;
import com.facebook.search.results.model.unit.SearchResultsVideoUnit;
import com.facebook.search.results.model.unit.answer.SearchResultsTimeUnit;
import com.google.common.collect.ImmutableSet;
import com.google.inject.TypeLiteral;

/* compiled from: RicDocumentAdapter.onCreateViewHolder#forPhoto */
public interface SearchResultsSupportDeclaration {
    public static final SearchResultsSingleRoleSpecification<SearchResultsCollectionUnit<GraphQLNode>> f23407A = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.RELATED_TOPICS, DisplayStyleMatchers.m27129a(GraphQLGraphSearchResultsDisplayStyle.PAGES), new TypeLiteral<SearchResultsCollectionUnit<GraphQLNode>>() {
    });
    public static final SearchResultsSingleRoleSpecification<SearchResultsPulseTopicMetadataUnit> f23408B = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.TOPIC_METADATA, DisplayStyleMatchers.m27129a(GraphQLGraphSearchResultsDisplayStyle.PAGES), new TypeLiteral<SearchResultsPulseTopicMetadataUnit>() {
    });
    public static final SearchResultsSpecification<SearchResultsReactionUnit> f23409C = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.REACTION_UNIT, DisplayStyleMatchers.f23447a, new TypeLiteral<SearchResultsReactionUnit>() {
    });
    public static final SearchResultsSpecification<SearchResultsCollectionUnit<GraphQLNode>> f23410D = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.NEWS_MODULE, DisplayStyleMatchers.f23447a, new TypeLiteral<SearchResultsCollectionUnit<GraphQLNode>>() {
    });
    public static final SearchResultsSingleRoleSpecification<SearchResultsSeeMorePostsUnit> f23411E = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.SEE_MORE_PIVOT, DisplayStyleMatchers.f23447a, new TypeLiteral<SearchResultsSeeMorePostsUnit>() {
    });
    public static final SearchResultsSpecification<SearchResultsCollectionUnit<GraphQLNode>> f23412F = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.SPORT_LINKS, DisplayStyleMatchers.m27129a(GraphQLGraphSearchResultsDisplayStyle.WEB), new TypeLiteral<SearchResultsCollectionUnit<GraphQLNode>>() {
    });
    public static final SearchResultsSingleRoleSpecification<SearchResultsVideoUnit> f23413G = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.SPORT_VIDEO, new MultiDisplayStyleMatcher(ImmutableSet.of(GraphQLGraphSearchResultsDisplayStyle.AGGREGATED_STORIES, GraphQLGraphSearchResultsDisplayStyle.STORIES)), new TypeLiteral<SearchResultsVideoUnit>() {
    });
    public static final SearchResultsSpecification<SearchResultsSportsUnit> f23414H = new SearchResultsSpecification(ImmutableSet.of(GraphQLGraphSearchResultRole.SPORT_ENTRY, GraphQLGraphSearchResultRole.SPORT_MODULE), DisplayStyleMatchers.f23447a, new TypeLiteral<SearchResultsSportsUnit>() {
    });
    public static final SearchResultsSpecification<SearchResultsStoryUnit> f23415I = new SearchResultsSpecification(ImmutableSet.of(GraphQLGraphSearchResultRole.NEWS_SOCIAL, GraphQLGraphSearchResultRole.NEWS_KEY_VOICES), DisplayStyleMatchers.f23447a, new TypeLiteral<SearchResultsStoryUnit>() {
    });
    public static final SearchResultsSpecification<SearchResultsStoryUnit> f23416J = new SearchResultsSpecification(ImmutableSet.of(GraphQLGraphSearchResultRole.NONE, GraphQLGraphSearchResultRole.PUBLIC_POSTS, GraphQLGraphSearchResultRole.MY_POSTS, GraphQLGraphSearchResultRole.FEED_POSTS, GraphQLGraphSearchResultRole.MAIN_MODULE, GraphQLGraphSearchResultRole.TOP_MAIN_MODULE, new GraphQLGraphSearchResultRole[]{GraphQLGraphSearchResultRole.POST_SET, GraphQLGraphSearchResultRole.POSTS_SET_TOPIC_1, GraphQLGraphSearchResultRole.POSTS_SET_TOPIC_2, GraphQLGraphSearchResultRole.POSTS_SET_TOPIC_3, GraphQLGraphSearchResultRole.POSTS_SET_CELEBRITIES, GraphQLGraphSearchResultRole.POSTS_SET_CELEBRITIES_MENTION, GraphQLGraphSearchResultRole.POSTS_SET_COMMENTARY, GraphQLGraphSearchResultRole.POSTS_SET_ENGAGEMENT, GraphQLGraphSearchResultRole.POSTS_SET_EXPERIENTIAL, GraphQLGraphSearchResultRole.POSTS_SET_FEATURED, GraphQLGraphSearchResultRole.POSTS_SET_GOVERNMENT, GraphQLGraphSearchResultRole.POSTS_SET_HOW_TO, GraphQLGraphSearchResultRole.POSTS_SET_LOCATION, GraphQLGraphSearchResultRole.POSTS_SET_MINUTIAE, GraphQLGraphSearchResultRole.POSTS_SET_RECENT_TOP, GraphQLGraphSearchResultRole.POSTS_SET_RECIPES, GraphQLGraphSearchResultRole.POSTS_SET_RELATED_AUTHORS, GraphQLGraphSearchResultRole.POSTS_SET_REVIEWS, GraphQLGraphSearchResultRole.POSTS_SET_REVIEWS_PEOPLE, GraphQLGraphSearchResultRole.POSTS_SET_VITAL_AUTHORS, GraphQLGraphSearchResultRole.GRAMMAR, GraphQLGraphSearchResultRole.GRAMMAR_QUERY_ENTITY_MODULE}), DisplayStyleMatchers.m27129a(GraphQLGraphSearchResultsDisplayStyle.STORIES), new TypeLiteral<SearchResultsStoryUnit>() {
    });
    public static final SearchResultsSingleRoleSpecification<SearchResultsTimeUnit> f23417K = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.TIME, DisplayStyleMatchers.m27129a(GraphQLGraphSearchResultsDisplayStyle.PAGES), new TypeLiteral<SearchResultsTimeUnit>() {
    });
    public static final SearchResultsSpecification<SearchResultsCollectionUnit<GraphQLNode>> f23418L = new SearchResultsSpecification(ImmutableSet.of(GraphQLGraphSearchResultRole.GRAMMAR, GraphQLGraphSearchResultRole.GRAMMAR_QUERY_ENTITY_MODULE, GraphQLGraphSearchResultRole.NONE, GraphQLGraphSearchResultRole.OPTIONAL), (DisplayStyleMatcher) new MultiDisplayStyleMatcher(ImmutableSet.of(GraphQLGraphSearchResultsDisplayStyle.APPS, GraphQLGraphSearchResultsDisplayStyle.EVENTS, GraphQLGraphSearchResultsDisplayStyle.GROUPS, GraphQLGraphSearchResultsDisplayStyle.PAGES, GraphQLGraphSearchResultsDisplayStyle.PLACES, GraphQLGraphSearchResultsDisplayStyle.PHOTOS, new GraphQLGraphSearchResultsDisplayStyle[]{GraphQLGraphSearchResultsDisplayStyle.USERS})), new TypeLiteral<SearchResultsCollectionUnit<GraphQLNode>>() {
    });
    public static final SearchResultsSingleRoleSpecification<SearchResultsCollectionUnit<GraphQLNode>> f23419M = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.TOPIC_MEDIA, DisplayStyleMatchers.f23447a, new TypeLiteral<SearchResultsCollectionUnit<GraphQLNode>>() {
    });
    public static final SearchResultsSingleRoleSpecification<SearchResultsVideoUnit> f23420N = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.NEWS_TOP_VIDEO, DisplayStyleMatchers.f23447a, new TypeLiteral<SearchResultsVideoUnit>() {
    });
    public static final SearchResultsSpecification<SearchResultsAnnotationUnit> f23421a = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.SECTION_HEADER, DisplayStyleMatchers.f23447a, new C25171());
    public static final SearchResultsSpecification<SearchResultsCollectionUnit<GraphQLNode>> f23422b = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.NEWS_PUBLISHERS, DisplayStyleMatchers.m27129a(GraphQLGraphSearchResultsDisplayStyle.WEB), new C25182());
    public static final SearchResultsSpecification<SearchResultsBridge> f23423c = new SearchResultsSpecification(GraphQLGraphSearchResultRole.VIDEOS_LIVE, DisplayStyleMatchers.f23447a, new C25193());
    public static final SearchResultsSpecification<SearchResultsBridge> f23424d = new SearchResultsSpecification(ImmutableSet.of(GraphQLGraphSearchResultRole.GRAMMAR, GraphQLGraphSearchResultRole.NONE), DisplayStyleMatchers.m27129a(GraphQLGraphSearchResultsDisplayStyle.VIDEOS), new C25204());
    public static final SearchResultsSpecification<SearchResultsCollectionUnit<GraphQLNode>> f23425e = new SearchResultsSpecification(ImmutableSet.of(GraphQLGraphSearchResultRole.PROMOTED_ENTITY_MEDIA), DisplayStyleMatchers.f23447a, new C25215());
    public static final SearchResultsSpecification<SearchResultsCentralWikiUnit> f23426f = new SearchResultsSpecification(ImmutableSet.of(GraphQLGraphSearchResultRole.WIKIPEDIA_CARD), DisplayStyleMatchers.f23447a, new C25226());
    public static final SearchResultsSpecification<SearchResultsEntityUnit> f23427g = new SearchResultsSpecification(ImmutableSet.of(GraphQLGraphSearchResultRole.CENTRAL), DisplayStyleMatchers.f23447a, new C25237());
    public static final SearchResultsSpecification<SearchResultsEntityUnit> f23428h = new SearchResultsSpecification(GraphQLGraphSearchResultRole.NAVIGATIONAL_LINKS, DisplayStyleMatchers.m27129a(GraphQLGraphSearchResultsDisplayStyle.WEB), new C25248());
    public static final SearchResultsSpecification<SearchResultsCollectionUnit<SearchResultsProductItemUnit>> f23429i = new SearchResultsSpecification(ImmutableSet.of(GraphQLGraphSearchResultRole.COMMERCE_B2C, GraphQLGraphSearchResultRole.COMMERCE_C2C, GraphQLGraphSearchResultRole.COMMERCE_COMBINED), DisplayStyleMatchers.f23447a, new C25259());
    public static final SearchResultsSpecification<SearchResultsEmptyUnit> f23430j = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.EMPTY_CARD, DisplayStyleMatchers.f23447a, new TypeLiteral<SearchResultsEmptyUnit>() {
    });
    public static final SearchResultsSpecification<SearchResultsEmptyEntityUnit> f23431k = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.EMPTY_ENTITY, DisplayStyleMatchers.f23447a, new TypeLiteral<SearchResultsEmptyEntityUnit>() {
    });
    public static final SearchResultsSpecification<SearchResultsCollectionUnit<GraphQLNode>> f23432l = new SearchResultsSpecification(ImmutableSet.of(GraphQLGraphSearchResultRole.ENTITY_APPS, GraphQLGraphSearchResultRole.ENTITY_EVENTS, GraphQLGraphSearchResultRole.ENTITY_GROUPS, GraphQLGraphSearchResultRole.ENTITY_PAGES, GraphQLGraphSearchResultRole.ENTITY_PLACES, GraphQLGraphSearchResultRole.ENTITY_USER, new GraphQLGraphSearchResultRole[0]), DisplayStyleMatchers.f23447a, new TypeLiteral<SearchResultsCollectionUnit<GraphQLNode>>() {
    });
    public static final SearchResultsSpecification<SearchResultsCollectionUnit<SearchResultsEntityPivotUnit>> f23433m = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.ENTITY_PIVOTS, DisplayStyleMatchers.f23447a, new TypeLiteral<SearchResultsCollectionUnit<SearchResultsEntityPivotUnit>>() {
    });
    public static final SearchResultsSingleRoleSpecification<SearchResultsSalePostUnit> f23434n = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.NONE, DisplayStyleMatchers.m27129a(GraphQLGraphSearchResultsDisplayStyle.SALE_POST), new TypeLiteral<SearchResultsSalePostUnit>() {
    });
    public static final SearchResultsSingleRoleSpecification<SearchResultsComposerUnit> f23435o = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.PREFILLED_COMPOSER, DisplayStyleMatchers.f23447a, new TypeLiteral<SearchResultsComposerUnit>() {
    });
    public static final SearchResultsSpecification<SearchResultsCollectionUnit<SportsTeam>> f23436p = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.GAMETIME_FAN_FAVORITE, DisplayStyleMatchers.f23447a, new TypeLiteral<SearchResultsCollectionUnit<SportsTeam>>() {
    });
    public static final SearchResultsSingleRoleSpecification<SearchResultsNewsContextUnit> f23437q = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.NEWS_CONTEXT, DisplayStyleMatchers.f23447a, new TypeLiteral<SearchResultsNewsContextUnit>() {
    });
    public static final SearchResultsSpecification<SearchResultsCollectionUnit<GraphQLStoryAttachment>> f23438r = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.NEWS_EYEWITNESSES, DisplayStyleMatchers.f23447a, new TypeLiteral<SearchResultsCollectionUnit<GraphQLStoryAttachment>>() {
    });
    public static final SearchResultsSpecification<SearchResultsCollectionUnit<GraphQLStory>> f23439s = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.POSTS, DisplayStyleMatchers.f23447a, new TypeLiteral<SearchResultsCollectionUnit<GraphQLStory>>() {
    });
    public static final SearchResultsSpecification<SearchResultsCollectionUnit<GraphQLNode>> f23440t = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.POSTS_CONTENTS, DisplayStyleMatchers.m27129a(GraphQLGraphSearchResultsDisplayStyle.QUERY), new TypeLiteral<SearchResultsCollectionUnit<GraphQLNode>>() {
    });
    public static final SearchResultsSingleRoleSpecification<SearchResultsPulseContextUnit> f23441u = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.GLOBAL_SHARE_METADATA, DisplayStyleMatchers.f23447a, new TypeLiteral<SearchResultsPulseContextUnit>() {
    });
    public static final SearchResultsSpecification<SearchResultsCollectionUnit<GraphQLNode>> f23442v = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.RELATED_SHARES, DisplayStyleMatchers.f23447a, new TypeLiteral<SearchResultsCollectionUnit<GraphQLNode>>() {
    });
    public static final SearchResultsSpecification<SearchResultsCollectionUnit<GraphQLPhrasesAnalysisItem>> f23443w = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.COMMON_PHRASES, DisplayStyleMatchers.f23447a, new TypeLiteral<SearchResultsCollectionUnit<GraphQLPhrasesAnalysisItem>>() {
    });
    public static final SearchResultsSpecification<SearchResultsCollectionUnit<GraphQLQuotesAnalysisItem>> f23444x = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.COMMON_QUOTES, DisplayStyleMatchers.f23447a, new TypeLiteral<SearchResultsCollectionUnit<GraphQLQuotesAnalysisItem>>() {
    });
    public static final SearchResultsSingleRoleSpecification<SearchResultsPulseSentimentUnit> f23445y = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.EMOTIONAL_ANALYSIS, DisplayStyleMatchers.f23447a, new TypeLiteral<SearchResultsPulseSentimentUnit>() {
    });
    public static final SearchResultsSingleRoleSpecification<SearchResultsPulseStoryUnit> f23446z = new SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole.GLOBAL_SHARE_POSTS, DisplayStyleMatchers.m27129a(GraphQLGraphSearchResultsDisplayStyle.STORIES), new TypeLiteral<SearchResultsPulseStoryUnit>() {
    });

    /* compiled from: RicDocumentAdapter.onCreateViewHolder#forPhoto */
    final class C25171 extends TypeLiteral<SearchResultsAnnotationUnit> {
        C25171() {
        }
    }

    /* compiled from: RicDocumentAdapter.onCreateViewHolder#forPhoto */
    final class C25182 extends TypeLiteral<SearchResultsCollectionUnit<GraphQLNode>> {
        C25182() {
        }
    }

    /* compiled from: RicDocumentAdapter.onCreateViewHolder#forPhoto */
    final class C25193 extends TypeLiteral<SearchResultsBridge> {
        C25193() {
        }
    }

    /* compiled from: RicDocumentAdapter.onCreateViewHolder#forPhoto */
    final class C25204 extends TypeLiteral<SearchResultsBridge> {
        C25204() {
        }
    }

    /* compiled from: RicDocumentAdapter.onCreateViewHolder#forPhoto */
    final class C25215 extends TypeLiteral<SearchResultsCollectionUnit<GraphQLNode>> {
        C25215() {
        }
    }

    /* compiled from: RicDocumentAdapter.onCreateViewHolder#forPhoto */
    final class C25226 extends TypeLiteral<SearchResultsCentralWikiUnit> {
        C25226() {
        }
    }

    /* compiled from: RicDocumentAdapter.onCreateViewHolder#forPhoto */
    final class C25237 extends TypeLiteral<SearchResultsEntityUnit> {
        C25237() {
        }
    }

    /* compiled from: RicDocumentAdapter.onCreateViewHolder#forPhoto */
    final class C25248 extends TypeLiteral<SearchResultsEntityUnit> {
        C25248() {
        }
    }

    /* compiled from: RicDocumentAdapter.onCreateViewHolder#forPhoto */
    final class C25259 extends TypeLiteral<SearchResultsCollectionUnit<SearchResultsProductItemUnit>> {
        C25259() {
        }
    }
}
