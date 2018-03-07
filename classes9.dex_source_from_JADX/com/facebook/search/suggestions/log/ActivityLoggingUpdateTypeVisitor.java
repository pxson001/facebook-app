package com.facebook.search.suggestions.log;

import com.facebook.inject.InjectorLike;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit.Source;
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

/* compiled from: {SETTINGS_TOKEN} */
public class ActivityLoggingUpdateTypeVisitor extends TypeaheadSuggestionVisitorWithReturn<ActivityLogUpdateType> {

    /* compiled from: {SETTINGS_TOKEN} */
    public enum ActivityLogUpdateType {
        DO_NOT_UPDATE,
        USE_GRAPH_API,
        USE_SERP_ENDPOINT
    }

    public static ActivityLoggingUpdateTypeVisitor m221a(InjectorLike injectorLike) {
        return new ActivityLoggingUpdateTypeVisitor();
    }

    public final /* synthetic */ Object m224a(KeywordTypeaheadUnit keywordTypeaheadUnit) {
        return m222b(keywordTypeaheadUnit);
    }

    public final Object m223a(EntityTypeaheadUnit entityTypeaheadUnit) {
        return ActivityLogUpdateType.USE_GRAPH_API;
    }

    public final Object m230a(SeeMoreResultPageUnit seeMoreResultPageUnit) {
        return ActivityLogUpdateType.USE_GRAPH_API;
    }

    public final Object m233a(TrendingTypeaheadUnit trendingTypeaheadUnit) {
        return ActivityLogUpdateType.DO_NOT_UPDATE;
    }

    public static ActivityLogUpdateType m222b(KeywordTypeaheadUnit keywordTypeaheadUnit) {
        if ((keywordTypeaheadUnit.h() == null || keywordTypeaheadUnit.jI_() == ScopedEntityType.VIDEO) && keywordTypeaheadUnit.k != Source.NULL_STATE_MODULE) {
            return ActivityLogUpdateType.USE_SERP_ENDPOINT;
        }
        return ActivityLogUpdateType.DO_NOT_UPDATE;
    }

    public final Object m228a(NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit) {
        if (!nullStateSuggestionTypeaheadUnit.d) {
            return ActivityLogUpdateType.DO_NOT_UPDATE;
        }
        if (nullStateSuggestionTypeaheadUnit.z()) {
            return ActivityLogUpdateType.USE_SERP_ENDPOINT;
        }
        return ActivityLogUpdateType.USE_GRAPH_API;
    }

    public final Object m232a(ShortcutTypeaheadUnit shortcutTypeaheadUnit) {
        return ActivityLogUpdateType.USE_GRAPH_API;
    }

    public final Object m227a(NullStateSeeMoreTypeaheadUnit nullStateSeeMoreTypeaheadUnit) {
        return ActivityLogUpdateType.DO_NOT_UPDATE;
    }

    public final Object m231a(SeeMoreTypeaheadUnit seeMoreTypeaheadUnit) {
        return ActivityLogUpdateType.DO_NOT_UPDATE;
    }

    public final Object m229a(PlaceTipsTypeaheadUnit placeTipsTypeaheadUnit) {
        return ActivityLogUpdateType.USE_GRAPH_API;
    }

    public final Object m225a(NearbyTypeaheadUnit nearbyTypeaheadUnit) {
        return ActivityLogUpdateType.USE_GRAPH_API;
    }

    public final Object m226a(NullStateModuleSuggestionUnit nullStateModuleSuggestionUnit) {
        return ActivityLogUpdateType.DO_NOT_UPDATE;
    }
}
