package com.facebook.search.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.calls.SearchQueryInputQueryArguments.FilteredQueryArguments.Filters;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.enums.GraphQLGraphSearchSpellerConfidence;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.inject.InjectorLike;
import com.facebook.search.logging.api.SearchResultsAnalytics;
import com.facebook.search.logging.api.SearchResultsAnalytics.ExitAction;
import com.facebook.search.logging.api.SearchResultsAnalytics.InlineActionName;
import com.facebook.search.logging.api.SearchResultsAnalytics.InlineActionType;
import com.facebook.search.logging.api.SearchResultsAnalytics.PageType;
import com.facebook.search.logging.api.SearchResultsAnalytics.ResultsState;
import com.facebook.search.logging.api.SearchResultsAnalytics.StoryAction;
import com.facebook.search.logging.api.SearchTypeaheadSession;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.search.results.model.contract.SearchResultsContext;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;
import com.facebook.search.util.SearchPivotData;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: The drawable ( */
public class SearchResultsLogger {
    private static final Class<?> f21955a = SearchResultsLogger.class;
    public static final ImmutableMap<GraphQLFriendshipStatus, Event> f21956b = ImmutableMap.of(GraphQLFriendshipStatus.OUTGOING_REQUEST, Event.INLINE_FRIEND_REQUEST, GraphQLFriendshipStatus.CAN_REQUEST, Event.INLINE_FRIEND_REQUEST_CANCEL, GraphQLFriendshipStatus.INCOMING_REQUEST, Event.INLINE_FRIEND_REQUEST_CONFIRM, GraphQLFriendshipStatus.ARE_FRIENDS, Event.INLINE_ACTION_MESSAGE);
    private static volatile SearchResultsLogger f21957d;
    public final AnalyticsLogger f21958c;

    /* compiled from: The drawable ( */
    public enum Event {
        RESULTS_LOADED("search"),
        RESULTS_PAGED("graph_search_results_paged"),
        ERROR("graph_search_results_error"),
        RESULTS_FILTER("graph_search_results_filter"),
        MODULE_IMPRESSION("module_impression"),
        INLINE_ACTION("inline_action"),
        ITEM_TAPPED("graph_search_results_item_tapped"),
        PULL_TO_REFRESH("graph_search_results_pull_to_refresh"),
        ITEM_IN_MODULE_TAPPED("graph_search_results_item_in_module_tapped"),
        SEE_MORE_ON_MODULE_TAPPED("graph_search_results_see_more_on_module_tapped"),
        SEE_MORE_POSTS_TAPPED("graph_search_results_see_more_posts_tapped"),
        CLICK("click"),
        VIEW_PORT_VIEWS("view_port_views_on_search_results"),
        COMMERCE_CAROUSEL_INTERACTION("commerce_carousel_interaction"),
        PLACE_SAVE_INTERACTION("inline_action_save_click"),
        PLACE_MAP_INTERACTION("graph_search_results_map_tapped"),
        INLINE_FRIEND_REQUEST("inline_friend_request"),
        INLINE_FRIEND_REQUEST_CANCEL("inline_cancel_friend_request"),
        INLINE_FRIEND_REQUEST_CONFIRM("inline_confirm_friend_request"),
        INLINE_ACTION_MESSAGE("inline_action_message"),
        INLINE_PAGE_LIKE("inline_page_like_request"),
        INLINE_GROUP_JOIN("inline_action_join_group_click"),
        INLINE_EVENT_JOIN("inline_action_join_event_click");
        
        final String name;

        private Event(String str) {
            this.name = str;
        }
    }

    public static com.facebook.search.logging.SearchResultsLogger m25460a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f21957d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.logging.SearchResultsLogger.class;
        monitor-enter(r1);
        r0 = f21957d;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m25464b(r0);	 Catch:{ all -> 0x0035 }
        f21957d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21957d;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.logging.SearchResultsLogger.a(com.facebook.inject.InjectorLike):com.facebook.search.logging.SearchResultsLogger");
    }

    private static SearchResultsLogger m25464b(InjectorLike injectorLike) {
        return new SearchResultsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SearchResultsLogger(AnalyticsLogger analyticsLogger) {
        this.f21958c = analyticsLogger;
    }

    public static Map<String, Object> m25462a(String str) {
        Map hashMap = new HashMap();
        hashMap.put("search_ts_token", str);
        return hashMap;
    }

    public final void m25475a(SearchResultsContext searchResultsContext, int i, @Nullable ImmutableList<Filters> immutableList, GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, @Nullable String str, GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle, @Nullable GraphQLObjectType graphQLObjectType, @Nullable String str2, int i2) {
        HoneyClientEvent a = m25459a(Event.MODULE_IMPRESSION, (SearchResultsMutableContext) searchResultsContext).a("results_module_display_style", graphQLGraphSearchResultsDisplayStyle).a("results_module_role", graphQLGraphSearchResultRole).b("results_module_extra_logging", str).b("results_module_result_type", SearchResultsAnalytics.a(graphQLObjectType)).b("results_module_semantic", str2).a("results_module_index", i).a("results_module_items_count", i2);
        if (!(immutableList == null || immutableList.isEmpty())) {
            a.b("applied_filters", m25461a((ImmutableList) immutableList));
        }
        this.f21958c.a(a);
        if (BLog.b(3)) {
            String str3 = a.d;
            a.u();
        }
    }

    public final void m25472a(SearchResultsMutableContext searchResultsMutableContext, int i, GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, @Nullable String str) {
        HoneyClientEvent a = m25459a(Event.MODULE_IMPRESSION, searchResultsMutableContext).a("results_module_role", graphQLGraphSearchResultRole).b("results_module_extra_logging", str).a("results_module_index", i);
        this.f21958c.a(a);
        if (BLog.b(3)) {
            String str2 = a.d;
            a.u();
        }
    }

    public final void m25485a(SearchResultsContext searchResultsContext, ImmutableList<SearchResultsFeedUnitImpression> immutableList) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            SearchResultsFeedUnitImpression searchResultsFeedUnitImpression = (SearchResultsFeedUnitImpression) immutableList.get(i);
            ObjectNode a = new ObjectNode(JsonNodeFactory.a).a("results_module_index", searchResultsFeedUnitImpression.f21948a).a("vpvd_start_time", searchResultsFeedUnitImpression.f21949b).a("vpvd_time_delta", searchResultsFeedUnitImpression.f21950c);
            if (searchResultsFeedUnitImpression.f21952e != null) {
                a.a("results_module_role", searchResultsFeedUnitImpression.f21952e.toString());
            }
            if (searchResultsFeedUnitImpression.f21954g != null) {
                a.a("results_module_extra_logging", searchResultsFeedUnitImpression.f21954g);
            }
            if (searchResultsFeedUnitImpression.f21953f != null) {
                a.a("results_module_result_type", searchResultsFeedUnitImpression.f21953f.toString().toLowerCase());
            }
            if (!searchResultsFeedUnitImpression.f21951d.isEmpty()) {
                ArrayNode arrayNode2 = new ArrayNode(JsonNodeFactory.a);
                ImmutableList immutableList2 = searchResultsFeedUnitImpression.f21951d;
                int size2 = immutableList2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    arrayNode2.h((String) immutableList2.get(i2));
                }
                a.c("entity_ids", arrayNode2);
            }
            arrayNode.a(a);
        }
        HoneyClientEvent a2 = m25459a(Event.VIEW_PORT_VIEWS, (SearchResultsMutableContext) searchResultsContext).a("viewport_views", arrayNode);
        this.f21958c.a(a2);
        if (BLog.b(3)) {
            String str = a2.d;
            a2.u();
        }
    }

    public final void m25473a(SearchResultsMutableContext searchResultsMutableContext, int i, GraphQLGraphSearchSpellerConfidence graphQLGraphSearchSpellerConfidence, String str, String str2) {
        HoneyClientEvent b = m25459a(Event.MODULE_IMPRESSION, searchResultsMutableContext).a("results_module_index", i).b("results_module_type", "speller").a("speller_confidence", graphQLGraphSearchSpellerConfidence).b("corrected_query_title", str).b("corrected_query_function", str2);
        this.f21958c.a(b);
        if (BLog.b(3)) {
            String str3 = b.d;
            b.u();
        }
    }

    public final void m25470a(SearchResultsMutableContext searchResultsMutableContext, int i, int i2, @Nullable ResultsState resultsState, @Nullable PageType pageType) {
        m25469a(searchResultsMutableContext, i, i2, 0, null, resultsState, pageType);
    }

    public final void m25469a(SearchResultsContext searchResultsContext, int i, int i2, int i3, @Nullable ImmutableList<Filters> immutableList, @Nullable ResultsState resultsState, @Nullable PageType pageType) {
        HoneyClientEvent a = m25459a(i == 0 ? Event.RESULTS_LOADED : Event.RESULTS_PAGED, (SearchResultsMutableContext) searchResultsContext).a("page_number", i).a("results_count", i2).b("search_ts_token", searchResultsContext.f23370e).a("page_type", pageType);
        if (!(immutableList == null || immutableList.isEmpty())) {
            a.b("applied_filters", m25461a((ImmutableList) immutableList));
        }
        if (i3 > 0) {
            a.a("retry_count", i3);
        }
        if (resultsState != null) {
            a.a("results_state", resultsState.ordinal());
        }
        if (!(searchResultsContext.f23368c == null || searchResultsContext.f23368c == GraphQLGraphSearchResultRole.UNSET_OR_UNRECOGNIZED_ENUM_VALUE)) {
            a.a("source_module_role", searchResultsContext.f23368c);
        }
        this.f21958c.a(a);
        if (BLog.b(3)) {
            String str = a.d;
            a.u();
        }
    }

    public final void m25471a(SearchResultsMutableContext searchResultsMutableContext, int i, int i2, @Nullable String str) {
        HoneyClientEvent b = m25459a(Event.ERROR, searchResultsMutableContext).a("page_number", i).b("search_ts_token", searchResultsMutableContext.f23370e).b("error", str);
        if (i2 > 0) {
            b.a("retry_count", i2);
        }
        this.f21958c.a(b);
        if (BLog.b(3)) {
            String str2 = b.d;
            b.u();
        }
    }

    public final void m25468a(SearchResultsMutableContext searchResultsMutableContext) {
        HoneyClientEvent b = m25459a(Event.RESULTS_FILTER, searchResultsMutableContext).b("filter_action_type", "filter_button_tapped");
        this.f21958c.a(b);
        if (BLog.b(3)) {
            String str = b.d;
            b.u();
        }
    }

    public final void m25488b(SearchResultsContext searchResultsContext, @Nullable ImmutableList<Filters> immutableList) {
        HoneyClientEvent b = m25459a(Event.RESULTS_FILTER, (SearchResultsMutableContext) searchResultsContext).b("filter_action_type", "apply_button_tapped");
        if (!(immutableList == null || immutableList.isEmpty())) {
            b.b("applied_filters", m25461a((ImmutableList) immutableList));
        }
        this.f21958c.a(b);
        if (BLog.b(3)) {
            String str = b.d;
            b.u();
        }
    }

    public final void m25480a(SearchResultsContext searchResultsContext, Filters filters, @Nullable ImmutableList<Filters> immutableList) {
        HoneyClientEvent b = m25459a(Event.RESULTS_FILTER, (SearchResultsMutableContext) searchResultsContext).b("filter_action_type", "filter_cleared");
        b.b("cleared_filter", m25461a(ImmutableList.of(filters)));
        if (!(immutableList == null || immutableList.isEmpty())) {
            b.b("applied_filters", m25461a((ImmutableList) immutableList));
        }
        this.f21958c.a(b);
        if (BLog.b(3)) {
            String str = b.d;
            b.u();
        }
    }

    public final void m25476a(SearchResultsMutableContext searchResultsMutableContext, int i, String str) {
        HoneyClientEvent b = m25459a(Event.ITEM_TAPPED, searchResultsMutableContext).a("tapped_result_position", i).b("tapped_result_entity_id", str);
        this.f21958c.a(b);
        if (BLog.b(3)) {
            String str2 = b.d;
            b.u();
        }
    }

    public final void m25484a(SearchResultsMutableContext searchResultsMutableContext, InlineActionType inlineActionType, InlineActionName inlineActionName, @Nullable String str, @Nullable GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, @Nullable GraphQLObjectType graphQLObjectType, @Nullable String str2) {
        HoneyClientEvent b = m25459a(Event.INLINE_ACTION, searchResultsMutableContext).a("inline_action_type", inlineActionType).a("inline_action_name", inlineActionName).b("tapped_result_entity_id", str).a("results_module_role", graphQLGraphSearchResultRole).b("results_module_result_type", SearchResultsAnalytics.a(graphQLObjectType)).b("results_module_extra_logging", str2);
        this.f21958c.a(b);
        if (BLog.b(3)) {
            String str3 = b.d;
            b.u();
        }
    }

    @Deprecated
    public final void m25466a(GraphQLNode graphQLNode, SearchResultsMutableContext searchResultsMutableContext, @Nullable GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, @Nullable String str) {
        Event event = null;
        switch (graphQLNode.j() != null ? graphQLNode.j().g() : 0) {
            case 2479791:
                if (graphQLNode.bP()) {
                    event = Event.INLINE_PAGE_LIKE;
                    break;
                }
                break;
            case 2645995:
                GraphQLFriendshipStatus cU = graphQLNode.cU();
                if (cU != null) {
                    event = (Event) f21956b.get(cU);
                    break;
                }
                break;
            case 67338874:
                if (graphQLNode.je() == GraphQLEventGuestStatus.GOING) {
                    event = Event.INLINE_EVENT_JOIN;
                    break;
                }
                break;
            case 69076575:
                if (graphQLNode.ji() == GraphQLGroupJoinState.REQUESTED) {
                    event = Event.INLINE_GROUP_JOIN;
                    break;
                }
                break;
        }
        m25463a(event, graphQLNode.dp(), searchResultsMutableContext, graphQLGraphSearchResultRole, str);
    }

    @Deprecated
    public final void m25486a(NodeModel nodeModel, SearchResultsMutableContext searchResultsMutableContext, @Nullable GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, @Nullable String str) {
        Event event = null;
        switch (nodeModel.m9745b() != null ? nodeModel.m9745b().g() : 0) {
            case 2479791:
                if (nodeModel.m9758s()) {
                    event = Event.INLINE_PAGE_LIKE;
                    break;
                }
                break;
            case 2645995:
                GraphQLFriendshipStatus w = nodeModel.m9762w();
                if (w != null) {
                    event = (Event) f21956b.get(w);
                    break;
                }
                break;
            case 67338874:
                if (nodeModel.aw() == GraphQLEventGuestStatus.GOING) {
                    event = Event.INLINE_EVENT_JOIN;
                    break;
                }
                break;
            case 69076575:
                if (nodeModel.ax() == GraphQLGroupJoinState.REQUESTED) {
                    event = Event.INLINE_GROUP_JOIN;
                    break;
                }
                break;
        }
        m25463a(event, nodeModel.mo572C(), searchResultsMutableContext, graphQLGraphSearchResultRole, str);
    }

    @Deprecated
    private void m25463a(Event event, String str, SearchResultsMutableContext searchResultsMutableContext, @Nullable GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, @Nullable String str2) {
        if (event != null) {
            HoneyClientEvent b = m25459a(event, searchResultsMutableContext).a("results_module_role", graphQLGraphSearchResultRole).b("results_module_extra_logging", str2).b("tapped_result_entity_id", str);
            this.f21958c.a(b);
            if (BLog.b(3)) {
                String str3 = b.d;
                b.u();
            }
        }
    }

    public final void m25482a(SearchResultsMutableContext searchResultsMutableContext, GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, @Nullable String str, int i, int i2, int i3, String str2, String str3) {
        HoneyClientEvent b = m25459a(Event.ITEM_IN_MODULE_TAPPED, searchResultsMutableContext).b("tapped_result_entity_id", str3).a("results_module_role", graphQLGraphSearchResultRole).b("results_module_extra_logging", str).a("tapped_result_position", i).a("tapped_result_sub_position", i2).a("results_module_items_count", i3).b("results_module_result_type", str2);
        this.f21958c.a(b);
        if (BLog.b(3)) {
            String str4 = b.d;
            b.u();
        }
    }

    public final void m25487b(SearchResultsMutableContext searchResultsMutableContext, int i, GraphQLGraphSearchSpellerConfidence graphQLGraphSearchSpellerConfidence, String str, String str2) {
        HoneyClientEvent b = m25459a(Event.ITEM_TAPPED, searchResultsMutableContext).a("tapped_result_position", i).b("results_module_type", "speller").a("speller_confidence", graphQLGraphSearchSpellerConfidence).b("corrected_query_title", str).b("corrected_query_function", str2);
        this.f21958c.a(b);
        if (BLog.b(3)) {
            String str3 = b.d;
            b.u();
        }
    }

    public final void m25474a(SearchResultsMutableContext searchResultsMutableContext, int i, StoryAction storyAction, @Nullable String str) {
        HoneyClientEvent b = m25459a(Event.ITEM_TAPPED, searchResultsMutableContext).a("tapped_result_position", i).a("action", storyAction).a("results_module_role", GraphQLGraphSearchResultRole.GLOBAL_SHARE_METADATA).b("results_module_extra_logging", str);
        this.f21958c.a(b);
        if (BLog.b(3)) {
            String str2 = b.d;
            b.u();
        }
    }

    public final void m25479a(SearchResultsMutableContext searchResultsMutableContext, int i, boolean z, @Nullable String str) {
        HoneyClientEvent b = m25459a(Event.ITEM_TAPPED, searchResultsMutableContext).a("tapped_result_position", i).b("results_module_type", "wiki_card").a("results_module_role", GraphQLGraphSearchResultRole.WIKIPEDIA_CARD).a("is_expanding", z).b("results_module_extra_logging", str);
        this.f21958c.a(b);
        if (BLog.b(3)) {
            String str2 = b.d;
            b.u();
        }
    }

    public final void m25477a(SearchResultsMutableContext searchResultsMutableContext, int i, String str, StoryAction storyAction, @Nullable GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, @Nullable String str2) {
        HoneyClientEvent b = m25459a(Event.ITEM_TAPPED, searchResultsMutableContext).a("action", storyAction).a("tapped_result_position", i).b("tapped_result_entity_id", str).a("results_module_role", graphQLGraphSearchResultRole).b("results_module_extra_logging", str2);
        this.f21958c.a(b);
        if (BLog.b(3)) {
            String str3 = b.d;
            b.u();
        }
    }

    public final void m25478a(SearchResultsMutableContext searchResultsMutableContext, int i, String str, String str2, String str3) {
        HoneyClientEvent b = m25459a(Event.ITEM_TAPPED, searchResultsMutableContext).b("results_module_type", "trending_awareness").a("tapped_result_position", i).b("target_query", str).b("target_query_function", str2).b("trending_awareness_tap_target", str3);
        this.f21958c.a(b);
        if (BLog.b(3)) {
            String str4 = b.d;
            b.u();
        }
    }

    public final void m25483a(SearchResultsMutableContext searchResultsMutableContext, GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, @Nullable String str, GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle, int i, int i2, GraphQLObjectType graphQLObjectType) {
        HoneyClientEvent b = m25459a(Event.SEE_MORE_ON_MODULE_TAPPED, searchResultsMutableContext).a("results_module_role", graphQLGraphSearchResultRole).b("results_module_extra_logging", str).a("results_module_display_style", graphQLGraphSearchResultsDisplayStyle).a("results_module_items_count", i2).a("tapped_result_position", i).b("results_module_result_type", SearchResultsAnalytics.a(graphQLObjectType));
        this.f21958c.a(b);
        if (BLog.b(3)) {
            String str2 = b.d;
            b.u();
        }
    }

    public final void m25481a(SearchResultsMutableContext searchResultsMutableContext, GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, @Nullable String str, int i) {
        HoneyClientEvent a = m25459a(Event.SEE_MORE_POSTS_TAPPED, searchResultsMutableContext).a("results_module_role", graphQLGraphSearchResultRole).b("results_module_extra_logging", str).a("tapped_result_position", i);
        this.f21958c.a(a);
        if (BLog.b(3)) {
            String str2 = a.d;
            a.u();
        }
    }

    public final void m25467a(SearchTypeaheadSession searchTypeaheadSession, ExitAction exitAction) {
        HoneyClientEvent a = m25458a(Event.CLICK, searchTypeaheadSession).a("action", exitAction);
        this.f21958c.a(a);
        if (BLog.b(3)) {
            String str = a.d;
            a.u();
        }
    }

    public static HoneyClientEvent m25459a(Event event, SearchResultsMutableContext searchResultsMutableContext) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(event.name);
        honeyClientEvent.c = "browse";
        return honeyClientEvent.a("results_source", searchResultsMutableContext.f23367b).b("typeahead_sid", searchResultsMutableContext.f23369d.b).b("candidate_result_sid", searchResultsMutableContext.f23369d.c).b("filter_type", SearchResultsAnalytics.a(searchResultsMutableContext.m27098l())).b("query", searchResultsMutableContext.mo1211a()).b("query_function", searchResultsMutableContext.mo1212b()).b("results_vertical", searchResultsMutableContext.m27102v().mo596l()).b("post_search_intent_log", searchResultsMutableContext.f23384s).b("session_id", searchResultsMutableContext.m27102v().mo595k());
    }

    private static String m25461a(ImmutableList<Filters> immutableList) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Filters filters = (Filters) immutableList.get(i);
            if (filters.b().get("name") != null) {
                ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
                for (Entry entry : filters.b().entrySet()) {
                    Object obj;
                    if (entry.getValue() == null || "name".equals(entry.getKey()) || "action".equals(entry.getKey())) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        objectNode2.a((String) entry.getKey(), entry.getValue().toString());
                    }
                }
                objectNode.c((String) filters.b().get("name"), objectNode2);
            }
        }
        return objectNode.toString();
    }

    public static ArrayNode m25465b(ImmutableList<SearchPivotData> immutableList) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            SearchPivotData searchPivotData = (SearchPivotData) immutableList.get(i);
            arrayNode.a(new ObjectNode(JsonNodeFactory.a).a("query", searchPivotData.f8923a).a("query_function", searchPivotData.f8924b));
        }
        return arrayNode;
    }

    public static HoneyClientEvent m25458a(Event event, SearchTypeaheadSession searchTypeaheadSession) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(event.name);
        honeyClientEvent.c = "browse";
        return honeyClientEvent.b("typeahead_sid", searchTypeaheadSession.b).b("candidate_result_sid", searchTypeaheadSession.c);
    }
}
