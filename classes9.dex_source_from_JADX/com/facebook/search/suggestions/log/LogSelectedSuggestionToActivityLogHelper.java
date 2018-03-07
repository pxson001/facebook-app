package com.facebook.search.suggestions.log;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.loader.GraphSearchDataLoader;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit.KeywordType;
import com.facebook.search.model.NearbyTypeaheadUnit;
import com.facebook.search.model.NullStateModuleSuggestionUnit;
import com.facebook.search.model.NullStateSeeMoreTypeaheadUnit;
import com.facebook.search.model.NullStateSuggestionTypeaheadUnit;
import com.facebook.search.model.PlaceTipsTypeaheadUnit;
import com.facebook.search.model.SeeMoreResultPageUnit;
import com.facebook.search.model.SeeMoreTypeaheadUnit;
import com.facebook.search.model.ShortcutTypeaheadUnit;
import com.facebook.search.model.TrendingTypeaheadUnit;
import com.facebook.search.model.TypeaheadSuggestionVisitorWithReturn;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.model.visitor.GetTitleOfTypeaheadSuggestionVisitor;
import com.facebook.search.protocol.LogSelectedSuggestionToActivityLogParams;
import com.facebook.search.protocol.LogSelectedSuggestionToActivityLogParams.Builder;
import com.facebook.search.protocol.LogSelectedSuggestionToActivityLogParams.SearchType;
import com.facebook.search.suggestions.log.ActivityLoggingUpdateTypeVisitor.ActivityLogUpdateType;
import com.facebook.search.util.GraphSearchConfig;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: {QUICK_PROMOTION} */
public class LogSelectedSuggestionToActivityLogHelper {
    private final GatekeeperStoreImpl f136a;
    private final GraphSearchDataLoader f137b;
    private final GetTitleOfTypeaheadSuggestionVisitor f138c;
    private final Clock f139d;
    private final GetTypeForActivityLogVisitor f140e = new GetTypeForActivityLogVisitor();
    private final GetSemanticForActivityLogVisitor f141f = new GetSemanticForActivityLogVisitor(this);
    private final ActivityLoggingUpdateTypeVisitor f142g = new ActivityLoggingUpdateTypeVisitor();

    /* compiled from: {QUICK_PROMOTION} */
    public class GetSemanticForActivityLogVisitor extends TypeaheadSuggestionVisitorWithReturn<String> {
        final /* synthetic */ LogSelectedSuggestionToActivityLogHelper f135a;

        public final Object m240a(PlaceTipsTypeaheadUnit placeTipsTypeaheadUnit) {
            return placeTipsTypeaheadUnit.a.i();
        }

        public final Object m243a(ShortcutTypeaheadUnit shortcutTypeaheadUnit) {
            return shortcutTypeaheadUnit.a;
        }

        public final Object m239a(NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit) {
            return nullStateSuggestionTypeaheadUnit.a;
        }

        public final Object m236a(NearbyTypeaheadUnit nearbyTypeaheadUnit) {
            return nearbyTypeaheadUnit.a;
        }

        public final Object m234a(EntityTypeaheadUnit entityTypeaheadUnit) {
            return entityTypeaheadUnit.a;
        }

        public final Object m237a(NullStateModuleSuggestionUnit nullStateModuleSuggestionUnit) {
            return nullStateModuleSuggestionUnit.h;
        }

        public GetSemanticForActivityLogVisitor(LogSelectedSuggestionToActivityLogHelper logSelectedSuggestionToActivityLogHelper) {
            this.f135a = logSelectedSuggestionToActivityLogHelper;
        }

        public final Object m241a(SeeMoreResultPageUnit seeMoreResultPageUnit) {
            return seeMoreResultPageUnit.m();
        }

        public final Object m244a(TrendingTypeaheadUnit trendingTypeaheadUnit) {
            return trendingTypeaheadUnit.b();
        }

        public final Object m235a(KeywordTypeaheadUnit keywordTypeaheadUnit) {
            return keywordTypeaheadUnit.b();
        }

        public final Object m238a(NullStateSeeMoreTypeaheadUnit nullStateSeeMoreTypeaheadUnit) {
            return "[See More] " + nullStateSeeMoreTypeaheadUnit.toString();
        }

        public final Object m242a(SeeMoreTypeaheadUnit seeMoreTypeaheadUnit) {
            return "[See More] " + seeMoreTypeaheadUnit.toString();
        }
    }

    /* compiled from: {QUICK_PROMOTION} */
    class GetTypeForActivityLogVisitor extends TypeaheadSuggestionVisitorWithReturn<String> {
        public final Object m254a(ShortcutTypeaheadUnit shortcutTypeaheadUnit) {
            return shortcutTypeaheadUnit.c.toString();
        }

        public final Object m245a(EntityTypeaheadUnit entityTypeaheadUnit) {
            return entityTypeaheadUnit.c.toString();
        }

        public final Object m252a(SeeMoreResultPageUnit seeMoreResultPageUnit) {
            return seeMoreResultPageUnit.n();
        }

        public final Object m255a(TrendingTypeaheadUnit trendingTypeaheadUnit) {
            return "trending_topic";
        }

        public final Object m250a(NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit) {
            return nullStateSuggestionTypeaheadUnit.z() ? "keyword" : nullStateSuggestionTypeaheadUnit.c.toString();
        }

        public final Object m249a(NullStateSeeMoreTypeaheadUnit nullStateSeeMoreTypeaheadUnit) {
            return "[See More] " + nullStateSeeMoreTypeaheadUnit.toString();
        }

        public final Object m253a(SeeMoreTypeaheadUnit seeMoreTypeaheadUnit) {
            return "[See More] " + seeMoreTypeaheadUnit.toString();
        }

        public final Object m251a(PlaceTipsTypeaheadUnit placeTipsTypeaheadUnit) {
            return "place";
        }

        public final Object m246a(KeywordTypeaheadUnit keywordTypeaheadUnit) {
            if (keywordTypeaheadUnit.g == KeywordType.local) {
                return "local";
            }
            if (keywordTypeaheadUnit.g == KeywordType.local_category) {
                return "local_category";
            }
            return "keyword";
        }

        public final Object m247a(NearbyTypeaheadUnit nearbyTypeaheadUnit) {
            return "nearby";
        }

        public final Object m248a(NullStateModuleSuggestionUnit nullStateModuleSuggestionUnit) {
            return "null_state_module_suggestion";
        }
    }

    public static LogSelectedSuggestionToActivityLogHelper m256b(InjectorLike injectorLike) {
        return new LogSelectedSuggestionToActivityLogHelper(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), GraphSearchDataLoader.a(injectorLike), GetTitleOfTypeaheadSuggestionVisitor.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public LogSelectedSuggestionToActivityLogHelper(GatekeeperStoreImpl gatekeeperStoreImpl, GraphSearchDataLoader graphSearchDataLoader, GetTitleOfTypeaheadSuggestionVisitor getTitleOfTypeaheadSuggestionVisitor, Clock clock) {
        this.f136a = gatekeeperStoreImpl;
        this.f137b = graphSearchDataLoader;
        this.f138c = getTitleOfTypeaheadSuggestionVisitor;
        this.f139d = clock;
    }

    public final void m257a(@Nullable GraphSearchQuery graphSearchQuery, TypeaheadUnit typeaheadUnit, String str) {
        ActivityLogUpdateType activityLogUpdateType = (ActivityLogUpdateType) typeaheadUnit.a(this.f142g);
        if (activityLogUpdateType != ActivityLogUpdateType.DO_NOT_UPDATE) {
            SearchType searchType;
            boolean z;
            if (GraphSearchConfig.b(graphSearchQuery)) {
                searchType = SearchType.VIDEO_SEARCH;
            } else if (this.f136a.a(SearchAbTestGatekeepers.f, false)) {
                searchType = SearchType.GRAPH_SEARCH;
            } else {
                searchType = SearchType.SIMPLE_SEARCH;
            }
            Builder builder = new Builder();
            builder.c = (String) typeaheadUnit.a(this.f138c);
            builder = builder;
            builder.b = (String) typeaheadUnit.a(this.f140e);
            builder = builder;
            builder.d = (String) typeaheadUnit.a(this.f141f);
            Builder builder2 = builder;
            builder2.a = str;
            builder2 = builder2;
            builder2.e = this.f139d.a() / 1000;
            builder2 = builder2;
            builder2.f = searchType;
            builder2 = builder2;
            if (activityLogUpdateType == ActivityLogUpdateType.USE_SERP_ENDPOINT) {
                z = true;
            } else {
                z = false;
            }
            builder2.g = z;
            this.f137b.a(new LogSelectedSuggestionToActivityLogParams(builder2));
        }
    }
}
