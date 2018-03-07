package com.facebook.search.constants;

/* compiled from: session_blob */
public class SearchResultsFeedDataLoaderParams {

    /* compiled from: session_blob */
    public enum SearchExperience {
        I18N_POST_SEARCH_EXPANSION("i18n_post_search_expansion"),
        I18N_POST_SEARCH_USER_EXPANSION("i18n_post_search_user_expansion"),
        CELEBRITY("celebrity"),
        CELEBRITY_TOP_MEDIA("celebrity_top_media"),
        DENSE_RESULT_PAGE("dense_result_page"),
        POST_SETS("post_sets"),
        DISAMBIGUATION_TABLE_OF_CONTENTS_POST_MODULE("disambiguation_table_of_contents_post_module"),
        DISAMBIGUATION_NON_BLENDER_ENTITY_MODULES("disambiguation_non_blender_entity_modules"),
        DISAMBIGUATION_MULTIPLE_POSTS_PER_MODULE("disambiguation_multiple_posts_per_module"),
        DISAMBIGUATION_INFINITE_SCROLL("infinite_disambiguation_serp"),
        DISAMBIGUATION_SEND_EMPTY_MODULES("disambiguation_send_empty_modules"),
        DISAMBIGUATION_HIDE_LOW_QUALITY_ENTITY_MODULES("disambiguation_hide_low_quality_entity_modules"),
        FAST_FILTERS("FAST_FILTERS"),
        FILTERS("FILTERS"),
        ATTACHED_HEADERS("attached_headers"),
        TRENDING_FINITE_SERP("trending_finite_serp");
        
        public final String serverValue;

        private SearchExperience(String str) {
            this.serverValue = str;
        }
    }
}
