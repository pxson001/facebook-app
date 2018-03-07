package com.facebook.search.logging.api;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nullable;

/* compiled from: event_time */
public class SearchResultsSource {
    public static SearchResultsSource f15876A = new SearchResultsSource("reaction_unit");
    public static SearchResultsSource f15877B = new SearchResultsSource("null_state_nudge");
    public static SearchResultsSource f15878C = new SearchResultsSource("search_quick_promotion");
    public static SearchResultsSource f15879D = new SearchResultsSource("search_ad");
    public static SearchResultsSource f15880E = new SearchResultsSource("ss_see_more_link");
    public static SearchResultsSource f15881F = new SearchResultsSource("ss_see_more_button");
    public static SearchResultsSource f15882G = new SearchResultsSource("timeline_featured_content");
    public static SearchResultsSource f15883H = new SearchResultsSource("unknown");
    public static final ImmutableSet<SearchResultsSource> f15884I = ImmutableSet.of(f15881F, f15880E, f15898m);
    private static final ImmutableMap<String, SearchResultsSource> f15885J = new Builder().b("graph_search_v2_typeahead_keyword_suggestion", f15886a).b("graph_search_v2_single_state_suggestion", f15887b).b("graph_search_v2_typeahead_search_button", f15888c).b("graph_search_v2_typeahead_echo", f15889d).b("graph_search_v2_typeahead_escape", f15890e).b("graph_search_v2_null_state_keyword_recent_searches", f15891f).b("graph_search_v2_null_state_trending", f15892g).b("graph_search_v2_pulse", f15893h).b("graph_search_v2_feed_trending_module", f15894i).b("graph_search_v2_discreet_filter", f15895j).b("graph_search_v2_related_news_module", f15896k).b("graph_search_v2_results_page_see_more", f15897l).b("simple_search_module_see_more", f15898m).b("graph_search_v2_trending_story", f15899n).b("graph_search_v2_hashtag", f15900o).b("graph_search_v2_spelling_correction_escape", f15901p).b("graph_search_native_url", f15902q).b("graph_search_v2_trending_awareness_unit", f15903r).b("graph_search_v2_pulse_phrase_click", f15904s).b("graph_search_v2_pull_to_refresh", f15905t).b("graph_search_v2_central_photo_unit", f15906u).b("graph_search_v2_null_state_module", f15907v).b("graph_search_v2_trending_chain_pivot", f15908w).b("place_tips", f15910y).b("posts_content_module_row", f15911z).b("reaction_unit", f15876A).b("null_state_nudge", f15877B).b("search_quick_promotion", f15878C).b("search_ad", f15879D).b("ss_see_more_link", f15880E).b("ss_see_more_button", f15881F).b("timeline_featured_content", f15882G).b("unknown", f15883H).b();
    public static SearchResultsSource f15886a = new SearchResultsSource("graph_search_v2_typeahead_keyword_suggestion");
    public static SearchResultsSource f15887b = new SearchResultsSource("graph_search_v2_single_state_suggestion");
    public static SearchResultsSource f15888c = new SearchResultsSource("graph_search_v2_typeahead_search_button");
    public static SearchResultsSource f15889d = new SearchResultsSource("graph_search_v2_typeahead_echo");
    public static SearchResultsSource f15890e = new SearchResultsSource("graph_search_v2_typeahead_escape");
    public static SearchResultsSource f15891f = new SearchResultsSource("graph_search_v2_null_state_keyword_recent_searches");
    public static SearchResultsSource f15892g = new SearchResultsSource("graph_search_v2_null_state_trending");
    public static SearchResultsSource f15893h = new SearchResultsSource("graph_search_v2_pulse");
    public static SearchResultsSource f15894i = new SearchResultsSource("graph_search_v2_feed_trending_module");
    public static SearchResultsSource f15895j = new SearchResultsSource("graph_search_v2_discreet_filter");
    public static SearchResultsSource f15896k = new SearchResultsSource("graph_search_v2_related_news_module");
    public static SearchResultsSource f15897l = new SearchResultsSource("graph_search_v2_results_page_see_more");
    public static SearchResultsSource f15898m = new SearchResultsSource("simple_search_module_see_more");
    public static SearchResultsSource f15899n = new SearchResultsSource("graph_search_v2_trending_story");
    public static SearchResultsSource f15900o = new SearchResultsSource("graph_search_v2_hashtag");
    public static SearchResultsSource f15901p = new SearchResultsSource("graph_search_v2_spelling_correction_escape");
    public static SearchResultsSource f15902q = new SearchResultsSource("graph_search_native_url");
    public static SearchResultsSource f15903r = new SearchResultsSource("graph_search_v2_trending_awareness_unit");
    public static SearchResultsSource f15904s = new SearchResultsSource("graph_search_v2_pulse_phrase_click");
    public static SearchResultsSource f15905t = new SearchResultsSource("graph_search_v2_pull_to_refresh");
    public static SearchResultsSource f15906u = new SearchResultsSource("graph_search_v2_central_photo_unit");
    public static SearchResultsSource f15907v = new SearchResultsSource("graph_search_v2_null_state_module");
    public static SearchResultsSource f15908w = new SearchResultsSource("graph_search_v2_trending_chain_pivot");
    public static SearchResultsSource f15909x = new SearchResultsSource("places_grammar_module_map");
    public static SearchResultsSource f15910y = new SearchResultsSource("place_tips");
    public static SearchResultsSource f15911z = new SearchResultsSource("posts_content_module_row");
    private final String f15912K;

    @Nullable
    public static SearchResultsSource m23544a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        SearchResultsSource searchResultsSource = (SearchResultsSource) f15885J.get(str);
        return searchResultsSource == null ? new SearchResultsSource(str) : searchResultsSource;
    }

    private SearchResultsSource(String str) {
        this.f15912K = str;
    }

    public String toString() {
        return this.f15912K;
    }
}
