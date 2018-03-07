package com.facebook.quicklog.identifiers;

/* compiled from: work_communities_param */
public class DebugUtils {
    public static String m82a(int i) {
        short s = (short) (65535 & i);
        String str;
        switch ((short) (i >> 16)) {
            case (short) 3:
                switch (s) {
                    case (short) 1:
                        str = "PERF_TEST1";
                        break;
                    case (short) 2:
                        str = "PERF_TEST2";
                        break;
                    case (short) 3:
                        str = "PERF_QUICKLOG";
                        break;
                    case (short) 4:
                        str = "PERF_SEQUENCELOG";
                        break;
                    case (short) 5:
                        str = "PERF_PERFLOG";
                        break;
                    case (short) 6:
                        str = "PERF_TEST3";
                        break;
                    case (short) 7:
                        str = "PERF_MEMORY_PROFILING";
                        break;
                    case (short) 14:
                        str = "PERF_MEMORY_TRIM";
                        break;
                    case (short) 15:
                        str = "PERF_LOST_STARTUP_EVENTS";
                        break;
                    case (short) 19:
                        str = "PERF_ELIGIBLE_FOR_INTERSTITIAL_TRIGGER";
                        break;
                    case (short) 20:
                        str = "PERF_RESTORE_INTERSTITIAL_TRIGGER_STATE";
                        break;
                    case (short) 22:
                        str = "PERF_RESTORE_LAZY_TRIGGER_IDS";
                        break;
                    case (short) 23:
                        str = "PERF_READ_TRIGGER_TOIDS";
                        break;
                    case (short) 24:
                        str = "PERF_GET_FETCH_INTERSTITIAL_RESULT";
                        break;
                    case (short) 25:
                        str = "PERF_GET_FETCH_INTERSTITIAL_RESULTS";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 5:
                switch (s) {
                    case (short) 5:
                        str = "MEDIA_GALLERY_LOAD_PHOTO_GALLERY_FROM_GALLERY_LAUNCHER";
                        break;
                    case (short) 6:
                        str = "MEDIA_GALLERY_LOAD_PHOTO_GALLERY_WITH_PHOTO_FROM_GALLERY_LAUNCHER";
                        break;
                    case (short) 7:
                        str = "MEDIA_GALLERY_LOAD_PHOTO_GALLERY_WITH_PHOTO_FROM_ACTIVITY";
                        break;
                    case (short) 8:
                        str = "MEDIA_GALLERY_LOAD_PHOTO_BY_SWIPING";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 6:
                switch (s) {
                    case (short) 9:
                        str = "EVENTS_DASHBOARD";
                        break;
                    case (short) 10:
                        str = "EVENTS_PERMALINK";
                        break;
                    case (short) 11:
                        str = "EVENTS_FEED_TTI";
                        break;
                    case (short) 12:
                        str = "EVENTS_GUEST_LIST_TTI";
                        break;
                    case (short) 13:
                        str = "EVENTS_MESSAGE_GUESTS_TTI";
                        break;
                    case (short) 14:
                        str = "EVENTS_EVENTS_DASHBOARD_CHANGED_FILTER_LOAD_MARKER";
                        break;
                    case (short) 15:
                        str = "EVENTS_EVENTS_SUGGESTIONS_LOAD_MARKER";
                        break;
                    case (short) 16:
                        str = "EVENTS_EVENT_CREATE_TTI";
                        break;
                    case (short) 17:
                        str = "EVENTS_EVENTS_COMPOSER_LAUNCH_TTI_MARKER";
                        break;
                    case (short) 18:
                        str = "EVENTS_EVENTS_DASHBOARD_TTI_MARKER";
                        break;
                    case (short) 19:
                        str = "EVENTS_EVENTS_BIRTHDAYS_TTI";
                        break;
                    case (short) 20:
                        str = "EVENTS_EVENT_INVITE_PICKER_TTI";
                        break;
                    case (short) 21:
                        str = "EVENTS_EVENT_PERMALINK_TTI_MARKER";
                        break;
                    case (short) 22:
                        str = "EVENTS_EVENTS_PERMALINK_LOAD_COVER_PHOTO_TTI";
                        break;
                    case (short) 23:
                        str = "EVENTS_EVENTS_PERMALINK_LOAD_REACTION_TTI";
                        break;
                    case (short) 24:
                        str = "EVENTS_EVENTS_DASHBOARD_REACT_NATIVE_TTI";
                        break;
                    case (short) 25:
                        str = "EVENTS_EVENTS_DASHBOARD_RN_NATIVE_APP_START_TIME";
                        break;
                    case (short) 26:
                        str = "EVENTS_EVENTS_DASHBOARD_RN_JS_APP_REQUIRE_TIME";
                        break;
                    case (short) 27:
                        str = "EVENTS_EVENTS_DASHBOARD_RN_JS_TIME";
                        break;
                    case (short) 28:
                        str = "EVENTS_EVENTS_DASHBOARD_RN_NATIVE_TIME";
                        break;
                    case (short) 29:
                        str = "EVENTS_EVENTS_DASHBOARD_RN_FETCH_RELAY_QUERY";
                        break;
                    case (short) 30:
                        str = "EVENTS_EVENTS_DASHBOARD_RN_FETCH_RELAY_CACHE";
                        break;
                    case (short) 31:
                        str = "EVENTS_EVENTS_DASHBOARD_REACT_NATIVE_TTI_WARM";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 7:
                switch (s) {
                    case (short) 11:
                        str = "SEARCH_KEYWORD_SEARCH_PERFORMANCE";
                        break;
                    case (short) 12:
                        str = "SEARCH_KEYWORD_SEARCH_RESULT_PAGE_LOAD";
                        break;
                    case (short) 13:
                        str = "SEARCH_KEYWORD_SEARCH_RESULT_PAGE_LOAD_MORE";
                        break;
                    case (short) 14:
                        str = "SEARCH_SEARCH_ENTRY";
                        break;
                    case (short) 15:
                        str = "SEARCH_GRAPH_SEARCH_RESULT_FETCH";
                        break;
                    case (short) 16:
                        str = "SEARCH_SEARCH_TYPEAHEAD";
                        break;
                    case (short) 17:
                        str = "SEARCH_SEARCH_WATERFALL";
                        break;
                    case (short) 18:
                        str = "SEARCH_SIMPLE_SEARCH_LOCAL_SUGGESTIONS_TYPEAHEAD";
                        break;
                    case (short) 19:
                        str = "SEARCH_SIMPLE_SEARCH_REMOTE_SUGGESTIONS_TYPEAHEAD";
                        break;
                    case (short) 20:
                        str = "SEARCH_SEARCH_ENTITIES_TIME_TO_DISPLAY_SUGGESTION";
                        break;
                    case (short) 21:
                        str = "SEARCH_NULL_STATE";
                        break;
                    case (short) 22:
                        str = "SEARCH_SEARCH_DB_BOOTSTRAP_LOAD";
                        break;
                    case (short) 23:
                        str = "SEARCH_SEARCH_DB_BOOTSTRAP_FETCH";
                        break;
                    case (short) 24:
                        str = "SEARCH_SEARCH_DB_BOOTSTRAP_INDEX_LOAD";
                        break;
                    case (short) 25:
                        str = "SEARCH_SEARCH_DB_BOOTSTRAP_PREFETCH_LOAD";
                        break;
                    case (short) 26:
                        str = "SEARCH_SEARCH_DB_BOOTSTRAP_DELTA_LOAD";
                        break;
                    case (short) 27:
                        str = "SEARCH_SEARCH_DB_BOOTSTRAP_RECENT_SEARCH_DELTA";
                        break;
                    case (short) 30:
                        str = "SEARCH_GRAPH_SEARCH_REMOTE_SUGGESTIONS_TYPEAHEAD";
                        break;
                    case (short) 31:
                        str = "SEARCH_GRAPH_SEARCH_LOCAL_SUGGESTIONS_TYPEAHEAD";
                        break;
                    case (short) 32:
                        str = "SEARCH_SUGGESTIONS_END_TO_END";
                        break;
                    case (short) 33:
                        str = "SEARCH_GRAPH_SEARCH_REMOTE_KEYWORD_SUGGESTIONS_TYPEAHEAD";
                        break;
                    case (short) 34:
                        str = "SEARCH_GRAPH_SEARCH_REMOTE_ENTITY_SUGGESTIONS_TYPEAHEAD";
                        break;
                    case (short) 37:
                        str = "SEARCH_SERP_SUGGESTIONS_END_TO_END";
                        break;
                    case (short) 38:
                        str = "SEARCH_KEYWORD_SEARCH_RESULT_PAGE_LOAD_BATCHED";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 8:
                switch (s) {
                    case (short) 12:
                        str = "TEST_MODULE_ONE_TEST_EVENT_ONE";
                        break;
                    case (short) 16:
                        str = "TEST_MODULE_ONE_TEST_EVENT_TWO";
                        break;
                    case (short) 17:
                        str = "TEST_MODULE_ONE_TEST_EVENT_THREE";
                        break;
                    case (short) 18:
                        str = "TEST_MODULE_ONE_TEST_EVENT_FOUR";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 9:
                switch (s) {
                    case (short) 13:
                        str = "TEST_MODULE_TWO_TEST_EVENT_TWO";
                        break;
                    case (short) 14:
                        str = "TEST_MODULE_TWO_TEST_EVENT_THREE";
                        break;
                    case (short) 15:
                        str = "TEST_MODULE_TWO_TEST_EVENT_FOUR";
                        break;
                    case (short) 19:
                        str = "TEST_MODULE_TWO_TEST_EVENT_ONE";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 10:
                switch (s) {
                    case (short) 1:
                        str = "FEED_NNF_COLD_START";
                        break;
                    case (short) 2:
                        str = "FEED_NNF_COLD_START_FIRST_RUN";
                        break;
                    case (short) 3:
                        str = "FEED_NNF_COLD_START_CACHED";
                        break;
                    case (short) 4:
                        str = "NNFWarmStart";
                        break;
                    case (short) 5:
                        str = "FEED_NNF_WARM_START_CACHED";
                        break;
                    case (short) 6:
                        str = "FEED_NNF_HOT_START";
                        break;
                    case (short) 7:
                        str = "FEED_SWITCH_TO_FEED_RELOADED";
                        break;
                    case (short) 8:
                        str = "FEED_PERMALINK_FROM_FEED_LOAD";
                        break;
                    case (short) 9:
                        str = "FEED_FEED_UNIT_VIEW_INFLATION_TAG";
                        break;
                    case (short) 10:
                        str = "FEED_PERMALINK_ON_CREATE_TO_LOAD";
                        break;
                    case (short) 11:
                        str = "FEED_DB_FEED_LOAD_STORIES";
                        break;
                    case (short) 12:
                        str = "FEED_MESSAGE_GUESTS_TTI";
                        break;
                    case (short) 13:
                        str = "FEED_COLD_START_DB_CACHE";
                        break;
                    case (short) 14:
                        str = "FEED_NAVIGATE_TO_FEED";
                        break;
                    case (short) 15:
                        str = "FEED_FRESH_FETCH";
                        break;
                    case (short) 16:
                        str = "FEED_TIME_TO_FEED_FETCH_EXECUTE_FROM_TRIGGER";
                        break;
                    case (short) 17:
                        str = "FEED_PULL_TO_REFRESH_NETWORK_TIME";
                        break;
                    case (short) 18:
                        str = "FEED_PULL_TO_REFRESH_BEFORE_EXECUTE_TIME";
                        break;
                    case (short) 19:
                        str = "FEED_WARM_TTI";
                        break;
                    case (short) 20:
                        str = "FEED_FRESH_CONTENT_START";
                        break;
                    case (short) 21:
                        str = "FEED_COLD_FRESH_CONTENT_START";
                        break;
                    case (short) 22:
                        str = "NNFColdStartTTI";
                        break;
                    case (short) 23:
                        str = "FEED_WARM_START_FROM_NETWORK";
                        break;
                    case (short) 24:
                        str = "FEED_PULL_TO_REFRESH_NETWORK";
                        break;
                    case (short) 25:
                        str = "FEED_PULL_TO_REFRESH_NETWORK_AND_RENDER";
                        break;
                    case (short) 26:
                        str = "NNFLoginToFeedTTI";
                        break;
                    case (short) 27:
                        str = "FEED_WARM_FRAGMENT_CREATE_TO_DATA_FETCHED";
                        break;
                    case (short) 28:
                        str = "FEED_COLD_FRAGMENT_CREATE_TO_DATA_FETCHED";
                        break;
                    case (short) 30:
                        str = "FEED_WARM_START";
                        break;
                    case (short) 31:
                        str = "FEED_COLD_AND_FRESH_RENDER_TIME";
                        break;
                    case (short) 32:
                        str = "FEED_COLD_AND_RENDER_TIME";
                        break;
                    case (short) 33:
                        str = "FEED_WARM_START_FROM_MEMORY";
                        break;
                    case (short) 34:
                        str = "FEED_WARM_START_FROM_DB";
                        break;
                    case (short) 35:
                        str = "FEED_WARM_AND_RENDER_TIME";
                        break;
                    case (short) 36:
                        str = "FEED_WARM_AND_FRESH_RENDER_TIME";
                        break;
                    case (short) 37:
                        str = "FEED_WARM_AND_CACHED_RENDER_TIME";
                        break;
                    case (short) 38:
                        str = "FEED_TAIL_FETCH_TIME";
                        break;
                    case (short) 39:
                        str = "FEED_VISIBLE_TAIL_FETCH_TIME";
                        break;
                    case (short) 40:
                        str = "FEED_TAIL_FETCH_NETWORK_CALL_TIME";
                        break;
                    case (short) 41:
                        str = "FEED_TAIL_FETCH_NOT_CONNECTED_CALL_TIME";
                        break;
                    case (short) 42:
                        str = "FEED_TAIL_FETCH_RENDER_TIME";
                        break;
                    case (short) 43:
                        str = "FEED_HOT_AND_RENDER_TIME";
                        break;
                    case (short) 44:
                        str = "FEED_HOT_AND_FRESH_RENDER_TIME";
                        break;
                    case (short) 45:
                        str = "FEED_HOT_AND_FRESH_RENDER_TIME_NOT_VISIBLE";
                        break;
                    case (short) 46:
                        str = "FEED_HOT_TTI";
                        break;
                    case (short) 47:
                        str = "FEED_PERMALINK_ON_CREATE_TO_LOAD_IF_NO_NAVIGATIONAL_METRICS";
                        break;
                    case (short) 48:
                        str = "FEED_PERMALINK_NOTIFICATION_LOAD";
                        break;
                    case (short) 49:
                        str = "FEED_NNF_PERMALINK_ANDROID_NOTIFICATION_WARM_LOAD";
                        break;
                    case (short) 50:
                        str = "NNFVisibleTailFetchTime";
                        break;
                    case (short) 51:
                        str = "FEED_DASH_COLD_START";
                        break;
                    case (short) 52:
                        str = "FEED_NNF_PERMALINK_ANDROID_NOTIFICATION_COLD_LOAD";
                        break;
                    case (short) 53:
                        str = "NNFBackpressToFeed";
                        break;
                    case (short) 54:
                        str = "NNFBackpressToFeedWithCreation";
                        break;
                    case (short) 55:
                        str = "FEED_NNF_CACHE_COLD_START";
                        break;
                    case (short) 56:
                        str = "FEED_NNF_HOT_TTI";
                        break;
                    case (short) 57:
                        str = "FEED_NNF_FRAGMENT_VIEW_CREATE_TAG";
                        break;
                    case (short) 58:
                        str = "FEED_NNF_FIRST_RUN_COLD_START_TAG";
                        break;
                    case (short) 59:
                        str = "FEED_NNF_COLD_AND_CACHED_RENDER_TIME";
                        break;
                    case (short) 60:
                        str = "FEED_NNF_COLD_START_CHROME_LOAD_TIME_TAG";
                        break;
                    case (short) 61:
                        str = "NNFNavigateToFeedWithCreation";
                        break;
                    case (short) 62:
                        str = "FEED_NNF_FEED_TAIL_FETCH_TIME";
                        break;
                    case (short) 63:
                        str = "FEED_NNF_FEED_TAIL_FETCH_RENDER_TIME";
                        break;
                    case (short) 64:
                        str = "FEED_NNF_FEED_PULL_TO_REFRESH_NETWORK_TIME";
                        break;
                    case (short) 65:
                        str = "NNFPullToRefreshNetworkAndRenderTime";
                        break;
                    case (short) 66:
                        str = "FEED_NNF_FEED_TAIL_FETCH_NETWORK_CALL_TIME";
                        break;
                    case (short) 67:
                        str = "FEED_NNF_FEED_TAIL_FETCH_NOT_CONNECTED_CALL_TIME";
                        break;
                    case (short) 68:
                        str = "NNFNavigateToOtherFeed";
                        break;
                    case (short) 69:
                        str = "FEED_NNF_DB_DESERIALIZE_STORY_TAG";
                        break;
                    case (short) 70:
                        str = "FEED_NNF_WARM_DATA_FETCHED_TO_FIRST_RENDER_TAG";
                        break;
                    case (short) 71:
                        str = "FEED_NNF_WARM_FRAGMENT_CREATE_TO_DATA_FETCHED_TAG";
                        break;
                    case (short) 72:
                        str = "FEED_NNF_COLD_DATA_FETCHED_TO_FIRST_RENDER_TAG";
                        break;
                    case (short) 73:
                        str = "FEED_NNF_HOT_AND_CACHED_RENDER_TIME";
                        break;
                    case (short) 74:
                        str = "FEED_NNF_HOT_AND_FRESH_RENDER_TIME_NOT_VISIBLE";
                        break;
                    case (short) 75:
                        str = "FEED_NNF_COLD_NETWORK_TTI";
                        break;
                    case (short) 76:
                        str = "FEED_COLD_NETWORK_TTI";
                        break;
                    case (short) 77:
                        str = "FEED_COLD_START_NETWORK";
                        break;
                    case (short) 78:
                        str = "FEED_NOTIFY_DATA_SET_CHANGED";
                        break;
                    case (short) 79:
                        str = "FEED_GET_VIEW";
                        break;
                    case (short) 80:
                        str = "FEED_SCROLL_LISTENERS";
                        break;
                    case (short) 81:
                        str = "FEED_NNF_COLD_NETWORK_FETCHED_TO_NEXT_RENDER";
                        break;
                    case (short) 82:
                        str = "FEED_NNF_COLD_START_DB_CACHE_TAG";
                        break;
                    case (short) 83:
                        str = "FEED_NNF_COLD_FRAGMENT_CREATE_TO_DATA_FETCHED_TAG";
                        break;
                    case (short) 84:
                        str = "FEED_NNF_COLD_FRESH_CONTENT_START_TAG";
                        break;
                    case (short) 85:
                        str = "FEED_NNF_FEED_PULL_TO_REFRESH_BEFORE_EXECUTE_TIME";
                        break;
                    case (short) 86:
                        str = "FEED_NNF_COLD_LOGIN_ACTIVITY_CREATE_TO_FRAGMENT_CREATE_TAG";
                        break;
                    case (short) 87:
                        str = "FEED_NNF_FRAGMENT_RESUME_TO_FIRST_RENDER_SUFFIX_TAG";
                        break;
                    case (short) 88:
                        str = "NNFNavigateToFeed";
                        break;
                    case (short) 89:
                        str = "FEED_NNF_SWITCH_TO_FEED_RENDER_FROM_ON_CREATE_VIEW";
                        break;
                    case (short) 90:
                        str = "FEED_NNF_COLD_MAINTAB_CREATE_TO_FEED_CREATE_TAG";
                        break;
                    case (short) 91:
                        str = "FEED_NNF_WARM_MAINTAB_CREATE_TO_FEED_CREATE_TAG";
                        break;
                    case (short) 92:
                        str = "FEED_NNF_SWITCH_TO_FEED_ON_CREATE_TO_ON_CREATE_VIEW";
                        break;
                    case (short) 93:
                        str = "FEED_NNF_FRAGMENT_CREATE_SUFFIX_TAG";
                        break;
                    case (short) 94:
                        str = "FEED_NNF_FRAGMENT_CREATE_TIME_SUFFIX_TAG";
                        break;
                    case (short) 95:
                        str = "FEED_NNF_COLD_LOGIN_ACTIVITY_END_TO_END_TAG";
                        break;
                    case (short) 96:
                        str = "FEED_NNF_COLD_LOGIN_ACTIVITY_CREATE_TAG";
                        break;
                    case (short) 97:
                        str = "FEED_NNF_WARM_LOGIN_ACTIVITY_END_TO_END_TAG";
                        break;
                    case (short) 98:
                        str = "FEED_NNF_WARM_LOGIN_ACTIVITY_CREATE_TAG";
                        break;
                    case (short) 99:
                        str = "FEED_NNF_COLD_APP_CREATE_TO_LOGIN_ACTIVITY_CREATE_TAG";
                        break;
                    case (short) 100:
                        str = "FEED_NNF_WARM_LOGIN_ACTIVITY_CREATE_TO_FRAGMENT_CREATE_TAG";
                        break;
                    case (short) 101:
                        str = "FEED_NNF_FEED_STORY_READY_1";
                        break;
                    case (short) 102:
                        str = "FEED_NNF_FEED_STORY_READY_2";
                        break;
                    case (short) 103:
                        str = "FEED_NNF_FEED_STORY_READY_3";
                        break;
                    case (short) 104:
                        str = "FEED_NNF_FEED_STORY_READY_4";
                        break;
                    case (short) 105:
                        str = "FEED_NNF_FEED_STORY_READY_5";
                        break;
                    case (short) 106:
                        str = "FEED_NNF_FEED_STORY_READY_6";
                        break;
                    case (short) 107:
                        str = "FEED_NNF_FEED_STORY_READY_7";
                        break;
                    case (short) 108:
                        str = "FEED_NNF_FEED_STORY_READY_8";
                        break;
                    case (short) 109:
                        str = "FEED_NNF_FEED_STORY_READY_9";
                        break;
                    case (short) 110:
                        str = "FEED_NNF_FEED_STORY_READY_10";
                        break;
                    case (short) 111:
                        str = "FEED_NNF_COLD_AND_FRESH_RENDER_TIME";
                        break;
                    case (short) 112:
                        str = "FEED_NNF_FRESH_FETCH_TAG";
                        break;
                    case (short) 113:
                        str = "FEED_NNF_COLD_TTI";
                        break;
                    case (short) 114:
                        str = "FEED_NNF_COLD_AND_RENDER_TIME";
                        break;
                    case (short) 115:
                        str = "FEED_NNF_TIME_TO_FEED_FETCH_EXECUTE_FROM_TRIGGER";
                        break;
                    case (short) 116:
                        str = "FEED_NNF_COLD_STATE";
                        break;
                    case (short) 117:
                        str = "FEED_NNF_WARM_STATE";
                        break;
                    case (short) 118:
                        str = "FEED_NNF_NAVIGATE_STATE";
                        break;
                    case (short) 119:
                        str = "FEED_NNF_NAVIGATE_OTHER_STATE";
                        break;
                    case (short) 120:
                        str = "FEED_NNF_OTHER_STATE";
                        break;
                    case (short) 121:
                        str = "FEED_NNF_FRESH_CONTENT_START";
                        break;
                    case (short) 122:
                        str = "FEED_BIND_VIEW";
                        break;
                    case (short) 123:
                        str = "FEED_COLD_SPLASH_SCREEN_TTI";
                        break;
                    case (short) 124:
                        str = "FEED_NNF_COLD_START_SPLASH_SCREEN_FIRST_RUN";
                        break;
                    case (short) 125:
                        str = "FEED_COLD_START_STEP";
                        break;
                    case (short) 126:
                        str = "FEED_WARM_START_STEP";
                        break;
                    case (short) 127:
                        str = "FEED_EVENTS_NETWORK_TIME";
                        break;
                    case (short) 128:
                        str = "FEED_FRIEND_LIST_FEED_NEWTORK_TIME";
                        break;
                    case (short) 129:
                        str = "FEED_GRAPH_SEARCH_NETWORK_TIME";
                        break;
                    case (short) 130:
                        str = "FEED_GROUPS_NETWORK_TIME";
                        break;
                    case (short) 131:
                        str = "FEED_HASHTAG_FEED_NETWORK_TIME";
                        break;
                    case (short) 132:
                        str = "FEED_NNF_COLD_START_NETWORK_TAG";
                        break;
                    case (short) 133:
                        str = "FEED_NNF_FRESH_START_NETWORK_TAG";
                        break;
                    case (short) 134:
                        str = "FEED_NNF_NETWORK_TIME_HEAD";
                        break;
                    case (short) 135:
                        str = "FEED_NNF_NETWORK_TIME";
                        break;
                    case (short) 136:
                        str = "FEED_NNF_NETWORK_TIME_CHUNKED_REMAINDER";
                        break;
                    case (short) 137:
                        str = "FEED_NNF_NETWORK_TIME_TAIL";
                        break;
                    case (short) 138:
                        str = "FEED_NNF_NETWORK_TIME_UNSET";
                        break;
                    case (short) 139:
                        str = "FEED_REACTION_FEED_NETWORK_TIME";
                        break;
                    case (short) 140:
                        str = "FEED_STORIES_ABOUT_PAGE_FEED_NEWTORK_TIME";
                        break;
                    case (short) 141:
                        str = "FEED_COLD_TTI_LEGACY";
                        break;
                    case (short) 142:
                        str = "FEED_PD_IS_NEEDED";
                        break;
                    case (short) 144:
                        str = "FEED_PD_PREPARE";
                        break;
                    case (short) 145:
                        str = "FEED_PD_BIND";
                        break;
                    case (short) 146:
                        str = "FEED_PD_UNBIND";
                        break;
                    case (short) 147:
                        str = "FEED_PAGE_FEED_NETWORK_TIME";
                        break;
                    case (short) 148:
                        str = "FEED_TEST_COLDSTART_TTI";
                        break;
                    case (short) 149:
                        str = "FEED_NEWSFEED_SCROLLING";
                        break;
                    case (short) 150:
                        str = "FEED_FEED_SCROLLING";
                        break;
                    case (short) 151:
                        str = "FEED_PD_GROUP_IS_NEEDED";
                        break;
                    case (short) 152:
                        str = "FEED_PD_GROUP_PREPARE";
                        break;
                    case (short) 153:
                        str = "FEED_PD_GROUP_BIND";
                        break;
                    case (short) 154:
                        str = "FEED_PD_GROUP_UNBIND";
                        break;
                    case (short) 155:
                        str = "FEED_COLD_LOAD_INLINE_COMPOSER_AFTER_LOGGED_IN";
                        break;
                    case (short) 156:
                        str = "FEED_WARM_LOAD_INLINE_COMPOSER_AFTER_LOGGED_IN";
                        break;
                    case (short) 157:
                        str = "FEED_PERMALINK_POLL_VOTE_OPTIMISTIC";
                        break;
                    case (short) 158:
                        str = "FEED_GOOD_FRIENDS_NETWORK_TIME";
                        break;
                    case (short) 159:
                        str = "FEED_TOPIC_FEED_NETWORK_TIME";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 13:
                switch (s) {
                    case (short) 1:
                        str = "BITMAPS_THUMBNAIL_MAKER";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 14:
                switch (s) {
                    case (short) 1:
                        str = "COMPOSER_COMPOSER_LAUNCH_SEQUENCE";
                        break;
                    case (short) 2:
                        str = "COMPOSER_PHOTO_LOAD";
                        break;
                    case (short) 3:
                        str = "COMPOSER_SUGGESTIONS_APPEARANCE_LAUNCH";
                        break;
                    case (short) 4:
                        str = "COMPOSER_ALBUMS_LIST_FETCH";
                        break;
                    case (short) 5:
                        str = "COMPOSER_TIME_TO_INTERACT_EXTERNAL_SHARE";
                        break;
                    case (short) 6:
                        str = "COMPOSER_TIME_TO_INTERACT_PLATFORM_SHARE";
                        break;
                    case (short) 7:
                        str = "COMPOSER_POST_DRAW";
                        break;
                    case (short) 8:
                        str = "COMPOSER_ACTION_BUTTON_PRESSED";
                        break;
                    case (short) 9:
                        str = "COMPOSER_SELECTED_PRIVACY_AVAILABLE";
                        break;
                    case (short) 10:
                        str = "COMPOSER_ATTACHMENT_THUMBNAIL_AVAILABLE";
                        break;
                    case (short) 11:
                        str = "COMPOSER_PERF_ALBUMS_LIST_FETCH";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 15:
                switch (s) {
                    case (short) 1:
                        str = "DRAWABLEHIERARCHY_DRAWABLE_HIERARCHY_CONTROLLER";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 16:
                switch (s) {
                    case (short) 1:
                        str = "ENTITY_CARDS_CARD_CONFIGURATION_WAIT_TIME";
                        break;
                    case (short) 2:
                        str = "ENTITY_CARDS_INITIAL_CARDS_LOADED";
                        break;
                    case (short) 3:
                        str = "ENTITY_CARDS_ENTITY_CARDS_SCROLL_WAITTIME";
                        break;
                    case (short) 4:
                        str = "ENTITY_CARDS_ENTITY_CARDS_PAGE_DOWNLOAD";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 17:
                switch (s) {
                    case (short) 1:
                        str = "GROUPS_FEED_FEED_TTI";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 18:
                switch (s) {
                    case (short) 1:
                        str = "IMAGEPIPELINE_ORCHESTRATOR";
                        break;
                    case (short) 2:
                        str = "IMAGEPIPELINE_STREAMED_REQUEST";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 19:
                switch (s) {
                    case (short) 1:
                        str = "PAGES_FB4A_ADMINED_FIRST_POSTS_BY_OTHERS_STORIES";
                        break;
                    case (short) 2:
                        str = "PAGES_PAGES_MANAGER_FIRST_POSTS_BY_OTHERS_STORIES";
                        break;
                    case (short) 3:
                        str = "PAGES_FB4A_PAGE_HEADER_INTERACTION";
                        break;
                    case (short) 4:
                        str = "PAGES_FB4A_ADMINED_PAGE_HEADER_INTERACTION";
                        break;
                    case (short) 5:
                        str = "PAGES_PAGES_MANAGER_HEADER_INTERACTION";
                        break;
                    case (short) 6:
                        str = "PAGES_FB4A_PAGE_SECONDARY_CARDS";
                        break;
                    case (short) 7:
                        str = "PAGES_PAGE_NEW_LIKES_SEQUENCE";
                        break;
                    case (short) 8:
                        str = "PAGES_FB4A_PAGE_FIRST_STORIES_SEQUENCE";
                        break;
                    case (short) 9:
                        str = "PAGES_FB4A_ADMINED_FIRST_STORIES";
                        break;
                    case (short) 10:
                        str = "PAGES_PAGES_MANAGER_FIRST_STORIES";
                        break;
                    case (short) 11:
                        str = "PAGES_FB4A_PAGE_FIRST_POSTS_BY_OTHERS_STORIES";
                        break;
                    case (short) 12:
                        str = "PAGES_PAGES_MANAGER_COLD_START";
                        break;
                    case (short) 13:
                        str = "PAGES_PAGES_MANAGER_COLD_START_FIRST_RUN";
                        break;
                    case (short) 14:
                        str = "PAGES_PAGES_MANAGER_WARM_START";
                        break;
                    case (short) 15:
                        str = "PAGES_PAGES_PROMOTION_TTI";
                        break;
                    case (short) 16:
                        str = "PAGES_PAGES_PROMOTION_FETCH_STORY_INSIGHTS_AND_PROMOTION";
                        break;
                    case (short) 17:
                        str = "PAGES_PAGES_PROMOTION_CREATE_AND_FETCH_STORY_PROMOTION";
                        break;
                    case (short) 18:
                        str = "PAGES_PAGES_PROMOTION_MODIFY_STORY_PROMOTION";
                        break;
                    case (short) 19:
                        str = "PAGES_PAGES_PROMOTION_FETCH_PAGE_BUDGET_RECOMMENDATION";
                        break;
                    case (short) 20:
                        str = "PAGES_DESERIALIZE_PAGE_ATTRIBUTES";
                        break;
                    case (short) 21:
                        str = "PAGES_DESERIALIZE_ALL_PAGES";
                        break;
                    case (short) 22:
                        str = "PAGES_CHROME_CREATE";
                        break;
                    case (short) 23:
                        str = "PAGES_CHROME_RESUME";
                        break;
                    case (short) 24:
                        str = "PAGES_WARM_START_TO_PAGE_VIEW_CREATED";
                        break;
                    case (short) 25:
                        str = "PAGES_COLD_START_TO_PAGE_VIEW_CREATED";
                        break;
                    case (short) 26:
                        str = "PAGES_LOGIN_TO_ALL_PAGES_LOADED_CHROME";
                        break;
                    case (short) 27:
                        str = "PAGES_DESERIALIZE_AND_COMPILE_URI_CONFIG";
                        break;
                    case (short) 28:
                        str = "PAGES_PAGES_TIME_TO_SPINNER";
                        break;
                    case (short) 29:
                        str = "PAGES_PAGES_TIME_TO_SPINNER_WITH_PROFILE";
                        break;
                    case (short) 30:
                        str = "PAGES_PAGES_TIME_TO_FETCH_START";
                        break;
                    case (short) 31:
                        str = "PAGES_PAGES_FIRST_INFLATE_DURATION";
                        break;
                    case (short) 32:
                        str = "PAGES_PAGES_FIRST_INFLATE_DURATION_WITH_PROFILE";
                        break;
                    case (short) 33:
                        str = "PAGES_PAGES_TIME_TO_PROFILE_PIC_LOWRES";
                        break;
                    case (short) 34:
                        str = "PAGES_PAGES_TIME_TO_PROFILE_PIC_HIRES";
                        break;
                    case (short) 35:
                        str = "PAGES_PAGES_TIME_TO_COVER_PHOTO";
                        break;
                    case (short) 36:
                        str = "PAGES_PAGES_JSON_PARSING";
                        break;
                    case (short) 37:
                        str = "PAGES_PAGES_JSON_PARSING_SECONDARY";
                        break;
                    case (short) 38:
                        str = "PAGES_PAGES_ACTIVITY_INSIGHTS_GRAPHS_LOAD_DURATION";
                        break;
                    case (short) 39:
                        str = "PAGES_PAGES_TIME_TO_ADMIN_TABS";
                        break;
                    case (short) 40:
                        str = "PAGES_PAGE_PRIMARY_FETCH_FROM_SERVER";
                        break;
                    case (short) 41:
                        str = "PAGES_PAGE_PRIMARY_FETCH_FROM_CACHE";
                        break;
                    case (short) 42:
                        str = "PAGES_PAGE_SECONDARY_FETCH_FROM_SERVER";
                        break;
                    case (short) 43:
                        str = "PAGES_PAGE_ADMIN_DATA_FETCH_FROM_SERVER";
                        break;
                    case (short) 44:
                        str = "PAGES_PAGE_ADMIN_DATA_FETCH_FROM_CACHE";
                        break;
                    case (short) 45:
                        str = "PAGES_PAGE_TIME_TO_PRIMARY";
                        break;
                    case (short) 46:
                        str = "PAGES_PAGE_TIME_TO_SECONDARY";
                        break;
                    case (short) 47:
                        str = "PAGES_PAGES_TIMELINE_DRAW_FIRST_CARD";
                        break;
                    case (short) 48:
                        str = "PAGES_PAGES_ACTION_SHEET_INFLATE_DURATION";
                        break;
                    case (short) 49:
                        str = "PAGES_PAGES_CONTEXT_ITEMS_HEADER_INFLATE_DURATION";
                        break;
                    case (short) 50:
                        str = "PAGES_PAGES_CONTEXT_ITEMS_INFO_CARD_INFLATE_DURATION";
                        break;
                    case (short) 51:
                        str = "PAGES_PAGES_STRUCTURED_CONTENT_INFLATE_DURATION";
                        break;
                    case (short) 52:
                        str = "PAGES_PAGES_SOCIAL_CONTEXT_INFLATE_DURATION";
                        break;
                    case (short) 53:
                        str = "PAGES_PAGES_ADMIN_SOCIAL_CONTEXT_INFLATE_DURATION";
                        break;
                    case (short) 54:
                        str = "PAGES_PAGES_REVIEWS_INFLATE_DURATION";
                        break;
                    case (short) 55:
                        str = "PAGES_PAGES_CHILD_LOCATIONS_INFLATE_DURATION";
                        break;
                    case (short) 56:
                        str = "PAGES_PAGES_FEED_STORY_INFLATE_DURATION";
                        break;
                    case (short) 57:
                        str = "PAGES_PAGES_PHOTO_TABS_INFALTE_DURATION";
                        break;
                    case (short) 58:
                        str = "PAGES_PAGES_VIDEO_TABS_INFALTE_DURATION";
                        break;
                    case (short) 59:
                        str = "PAGES_PAGES_RESERVATIONS_INFLATE_DURATION";
                        break;
                    case (short) 60:
                        str = "PAGES_PAGES_POSTS_BY_OTHERS_INFLATE_DURATION";
                        break;
                    case (short) 61:
                        str = "PAGES_PAGES_ADMIN_POSTS_BY_OTHERS_INFLATE_DURATION";
                        break;
                    case (short) 62:
                        str = "PAGES_PAGES_VERTEX_ATTRIBUTION_INFLATE_DURATION";
                        break;
                    case (short) 63:
                        str = "PAGES_PAGES_TV_AIRINGS_INFLATE_DURATION";
                        break;
                    case (short) 64:
                        str = "PAGES_PAGES_TOP_RECOMMENDATIONS_INFLATE_DURATION";
                        break;
                    case (short) 65:
                        str = "PAGES_PAGES_EVENTS_INFLATE_DURATION";
                        break;
                    case (short) 66:
                        str = "PAGES_PAGES_SUGGESTION_INFLATE_DURATION";
                        break;
                    case (short) 67:
                        str = "PAGES_PAGES_SAVED_PLACE_COLLECTION_CARD_INFLATE_DURATION";
                        break;
                    case (short) 68:
                        str = "PAGES_PAGES_SIMILAR_INFLATE_DURATION";
                        break;
                    case (short) 69:
                        str = "PAGES_PAGES_WELCOME_HOME_DURATION";
                        break;
                    case (short) 70:
                        str = "PAGES_PAGES_ACTION_SHEET_BIND_DURATION";
                        break;
                    case (short) 71:
                        str = "PAGES_PAGES_CONTEXT_ITEMS_HEADER_BIND_DURATION";
                        break;
                    case (short) 72:
                        str = "PAGES_PAGES_CONTEXT_ITEMS_INFO_CARD_BIND_DURATION";
                        break;
                    case (short) 73:
                        str = "PAGES_PAGES_STRUCTURED_CONTENT_BIND_DURATION";
                        break;
                    case (short) 74:
                        str = "PAGES_PAGES_LOCAL_CARD_BIND_DURATION";
                        break;
                    case (short) 75:
                        str = "PAGES_PAGES_SOCIAL_CONTEXT_BIND_DURATION";
                        break;
                    case (short) 76:
                        str = "PAGES_PAGES_ADMIN_SOCIAL_CONTEXT_BIND_DURATION";
                        break;
                    case (short) 77:
                        str = "PAGES_PAGES_REVIEWS_BIND_DURATION";
                        break;
                    case (short) 78:
                        str = "PAGES_PAGES_CHILD_LOCATIONS_BIND_DURATION";
                        break;
                    case (short) 79:
                        str = "PAGES_PAGES_FEED_STORY_BIND_DURATION";
                        break;
                    case (short) 80:
                        str = "PAGES_PAGES_PHOTO_TABS_BIND_DURATION";
                        break;
                    case (short) 81:
                        str = "PAGES_PAGES_VIDEO_TABS_BIND_DURATION";
                        break;
                    case (short) 82:
                        str = "PAGES_PAGES_ABOUT_CARD_BIND_DURATION";
                        break;
                    case (short) 83:
                        str = "PAGES_PAGES_POSTS_BY_OTHERS_BIND_DURATION";
                        break;
                    case (short) 84:
                        str = "PAGES_PAGES_ADMIN_POSTS_BY_OTHERS_BIND_DURATION";
                        break;
                    case (short) 85:
                        str = "PAGES_PAGES_VERTEX_ATTRIBUTION_BIND_DURATION";
                        break;
                    case (short) 86:
                        str = "PAGES_PAGES_TV_AIRINGS_BIND_DURATION";
                        break;
                    case (short) 87:
                        str = "PAGES_PAGES_EVENTS_BIND_DURATION";
                        break;
                    case (short) 88:
                        str = "PAGES_PAGES_SUGGESTIONS_BIND_DURATION";
                        break;
                    case (short) 89:
                        str = "PAGES_PAGES_SAVED_PLACE_COLLECTION_CARD_BIND_DURATION";
                        break;
                    case (short) 90:
                        str = "PAGES_PAGES_SIMILAR_CARD_BIND_DURATION";
                        break;
                    case (short) 91:
                        str = "PAGES_PAGES_WELCOME_HOME_BIND_DURATION";
                        break;
                    case (short) 92:
                        str = "PAGES_PAGES_RESERVATIONS_BIND_DURATION";
                        break;
                    case (short) 93:
                        str = "PAGES_COLD_START_TAG";
                        break;
                    case (short) 94:
                        str = "PAGES_COLD_START_TO_LOGIN_SCREEN";
                        break;
                    case (short) 95:
                        str = "PAGES_APP_ONCREATE";
                        break;
                    case (short) 96:
                        str = "PAGES_COLD_START_FROM_DEEP_LINKING";
                        break;
                    case (short) 97:
                        str = "PAGES_AUTH_TO_LOGIN_COMPLETE";
                        break;
                    case (short) 98:
                        str = "PAGES_FACEWEB_CREATE_TAG";
                        break;
                    case (short) 99:
                        str = "PAGES_PAGES_TTI";
                        break;
                    case (short) 100:
                        str = "PAGES_PAGES_FULL_LOAD";
                        break;
                    case (short) 101:
                        str = "PAGES_PAGES_PROFILE_PIC_LOAD";
                        break;
                    case (short) 102:
                        str = "PAGES_PAGE_TIME_FROM_CACHE_TO_NETWORK";
                        break;
                    case (short) 103:
                        str = "PAGES_PAGES_TIME_TO_COVER_PHOTO_LOWRES";
                        break;
                    case (short) 104:
                        str = "PAGES_PAGES_COMMERCE_CARD_INFALTE_DURATION";
                        break;
                    case (short) 105:
                        str = "PAGES_PAGES_COMMERCE_CARD_BIND_DURATION";
                        break;
                    case (short) 106:
                        str = "PAGES_PAGES_TIME_TO_PREFETCH_COVER_PHOTO";
                        break;
                    case (short) 107:
                        str = "PAGES_PAGES_TIME_TO_COVER_PHOTO_MINIPREVIEW";
                        break;
                    case (short) 108:
                        str = "PAGES_PAGES_TIME_TO_FETCH_CORE_HEADER_DATA";
                        break;
                    case (short) 109:
                        str = "PAGES_PAGES_CRITIC_REVIEWS_BIND_DURATION";
                        break;
                    case (short) 110:
                        str = "PAGES_PAGES_REVIEW_NEEDY_PLACE_CARD_INFLATE_DURATION";
                        break;
                    case (short) 111:
                        str = "PAGES_PAGES_REVIEW_NEEDY_PLACE_CARD_CRITIC_REVIEWS_BIND_DURATION";
                        break;
                    case (short) 112:
                        str = "PAGES_PAGES_CRITIC_REVIEWS_INFLATE_DURATION";
                        break;
                    case (short) 113:
                        str = "PAGES_PAGE_CALL_TO_ACTION_INFLATE_DURATION";
                        break;
                    case (short) 114:
                        str = "PAGES_PAGE_CALL_TO_ACTION_BIND_DURATION";
                        break;
                    case (short) 115:
                        str = "PAGES_PAGE_SERVICE_CARD_INFLATE_DURATION";
                        break;
                    case (short) 116:
                        str = "PAGES_PAGE_SERVICE_CARD_BIND_DURATION";
                        break;
                    case (short) 117:
                        str = "PAGES_CREATE_THREAD_LIST_METRIC_NAME";
                        break;
                    case (short) 118:
                        str = "PAGES_PAGES_WIDGET_DATA_LOAD";
                        break;
                    case (short) 119:
                        str = "PAGES_PAGES_WIDGET_CONFIG_DATA_LOAD";
                        break;
                    case (short) 122:
                        str = "PAGES_PAGE_HEADER_FETCH";
                        break;
                    case (short) 123:
                        str = "PAGES_PAGES_COVER_PHOTO_LOAD";
                        break;
                    case (short) 124:
                        str = "PAGES_PAGE_ADMIN_HEADER_FETCH";
                        break;
                    case (short) 125:
                        str = "PAGES_PAGE_SURFACE_FIRST_CARD";
                        break;
                    case (short) 126:
                        str = "PAGES_FB4A_PAGE_PRESENCE_HEADER_INTERACTION";
                        break;
                    case (short) 127:
                        str = "PAGES_FB4A_ADMINED_PAGE_PRESENCE_HEADER_INTERACTION";
                        break;
                    case (short) 128:
                        str = "PAGES_PAGE_HEADER_LOAD";
                        break;
                    case (short) 130:
                        str = "PAGES_PAGE_DATA_BATCHED_FETCH";
                        break;
                    case (short) 131:
                        str = "PAGES_PAGES_LAUNCHPOINT_TTI";
                        break;
                    case (short) 132:
                        str = "PAGES_PAGES_LAUNCHPOINT_SCROLL_LOAD";
                        break;
                    case (short) 133:
                        str = "PAGES_PAGES_LAUNCHPOINT_REFRESH";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 20:
                switch (s) {
                    case (short) 1:
                        str = "PHOTOS_UPLOAD_SEQUENCE";
                        break;
                    case (short) 2:
                        str = "PHOTOS_MEDIA_GALLERY_TTI";
                        break;
                    case (short) 3:
                        str = "PHOTOS_PANDORA_LOADING";
                        break;
                    case (short) 4:
                        str = "PHOTOS_SIMPLE_PICKER_LAUNCH";
                        break;
                    case (short) 5:
                        str = "PHOTOS_THUMBNAIL_DECODING";
                        break;
                    case (short) 6:
                        str = "PHOTOS_LOAD_SNOWFLAKE_PHOTO_GALLERY_WITH_PHOTO";
                        break;
                    case (short) 7:
                        str = "PHOTOS_CREATIVE_EDITING_APPLY_TO_FILE";
                        break;
                    case (short) 8:
                        str = "LoadPhotoGallery-MediaGallery";
                        break;
                    case (short) 9:
                        str = "LoadPhotoGalleryWithPhoto-MediaGallery";
                        break;
                    case (short) 10:
                        str = "LoadPhotoGalleryWithPhotoFromActivity-MediaGallery";
                        break;
                    case (short) 11:
                        str = "LoadPhotoBySwiping-MediaGallery";
                        break;
                    case (short) 12:
                        str = "PHOTOS_LOAD_PHOTO_GALLERY_WITH_PHOTO_FROM_SOURCE";
                        break;
                    case (short) 13:
                        str = "PHOTOS_MEDIA_LOADER_TIME_TO_RUN_TASK";
                        break;
                    case (short) 14:
                        str = "LoadPhotoGalleryWithPhotoFromSource-MediaGallery";
                        break;
                    case (short) 15:
                        str = "PHOTOS_TIME_TO_DISPLAY_FACE_BOXES_MARKER";
                        break;
                    case (short) 16:
                        str = "PHOTOS_FIRST_AVAILABLE_IMAGE_URIS_STRATEGY";
                        break;
                    case (short) 17:
                        str = "PHOTOS_PERF_APPLY_TO_FILE";
                        break;
                    case (short) 18:
                        str = "LoadPhotosFeed";
                        break;
                    case (short) 19:
                        str = "LoadPhotosFeedFromSource";
                        break;
                    case (short) 20:
                        str = "PHOTOS_PHOTOS_FEED_TTI";
                        break;
                    case (short) 21:
                        str = "PHOTOS_PROGRESS_SHOWN";
                        break;
                    case (short) 22:
                        str = "PHOTOS_PROGRESS_NOT_SHOWN";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 21:
                switch (s) {
                    case (short) 1:
                        str = "PLACES_PLACE_PICKER_TTI";
                        break;
                    case (short) 3:
                        str = "PLACES_PLACES_PICKER_RENDER_CONTENT";
                        break;
                    case (short) 5:
                        str = "PLACES_PLACES_PICKER_LOCATION_PIN_TTI";
                        break;
                    case (short) 6:
                        str = "PLACES_PLACES_PICKER_CHECKIN_BUTTON_TTI";
                        break;
                    case (short) 10:
                        str = "PLACES_PLACE_PICKER_CHECKIN_BUTTON_TO_ACTIVITY_CREATE";
                        break;
                    case (short) 11:
                        str = "PLACES_PLACE_PICKER_LOCATION_PIN_TO_ACTIVITY_CREATE";
                        break;
                    case (short) 16:
                        str = "PLACES_PLACE_PICKER_CHECKIN_BUTTON_PLACES_FETCH";
                        break;
                    case (short) 17:
                        str = "PLACES_PLACE_PICKER_LOCATION_PIN_PLACES_FETCH";
                        break;
                    case (short) 18:
                        str = "PLACES_PLACE_PICKER_LOCATION_PIN_RENDER_CONTENT";
                        break;
                    case (short) 19:
                        str = "PLACES_PLACE_PICKER_CHECKIN_BUTTON_RENDER_CONTENT";
                        break;
                    case (short) 20:
                        str = "PLACES_PLACE_PICKER_CHECKIN_BUTTON_LAUNCH";
                        break;
                    case (short) 21:
                        str = "PLACES_PLACE_PICKER_LOCATION_PIN_LAUNCH";
                        break;
                    case (short) 22:
                        str = "PLACES_ANDROID_PLACE_PICKER_TAP_ACTION_TO_CHECKIN_START";
                        break;
                    case (short) 23:
                        str = "PLACES_ANDROID_PLACE_PICKER_CHECKIN_START_TO_PLACE_FETCH_START";
                        break;
                    case (short) 24:
                        str = "PLACES_ANDROID_PLACE_PICKER_PLACE_FETCH_START_TO_PLACE_FETCH_END";
                        break;
                    case (short) 25:
                        str = "PLACES_ANDROID_PLACE_PICKER_PLACE_FETCH_END_TO_PLACES_RENDERED";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 22:
                switch (s) {
                    case (short) 1:
                        str = "PRIVACY_AUDIENCE_SELECTOR_LAUNCH";
                        break;
                    case (short) 2:
                        str = "PRIVACY_CHECKUP_COMPOSER_STEP_TTI";
                        break;
                    case (short) 3:
                        str = "PRIVACY_CHECKUP_PROFILE_STEP_TTI";
                        break;
                    case (short) 4:
                        str = "PRIVACY_CHECKUP_APPS_STEP_TTI";
                        break;
                    case (short) 5:
                        str = "PRIVACY_CHECKUP_INTRO_TTI";
                        break;
                    case (short) 6:
                        str = "PRIVACY_EDIT_STORY_PRIVACY_ROUND_TRIP";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 24:
                switch (s) {
                    case (short) 1:
                        str = "SAVED_SAVED_DASHBOARD_START";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 25:
                switch (s) {
                    case (short) 1:
                        str = "STICKERS_STICKER_KEYBOARD";
                        break;
                    case (short) 2:
                        str = "STICKERS_STICKER_POST";
                        break;
                    case (short) 3:
                        str = "STICKERS_STICKER_STORE";
                        break;
                    case (short) 4:
                        str = "STICKERS_STICKER_STORE_WITH_PACK";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 26:
                switch (s) {
                    case (short) 1:
                        str = "TIMELINE_TIMELINE_HEADER_TTI";
                        break;
                    case (short) 2:
                        str = "TIMELINE_TIMELINE_INITIAL_UNITS_WAIT_TIME";
                        break;
                    case (short) 3:
                        str = "TIMELINE_TIMELINE_LOAD_YEAR_OVERVIEW";
                        break;
                    case (short) 4:
                        str = "TIMELINE_TIMELINE_LOAD_FIRST_YEAR_OVERVIEW";
                        break;
                    case (short) 5:
                        str = "TIMELINE_TIMELINE_RENDER_CORE_HEADER";
                        break;
                    case (short) 6:
                        str = "TIMELINE_TIMELINE_RENDER_CORE_TOP_HEADER";
                        break;
                    case (short) 7:
                        str = "TIMELINE_TIMELINE_RENDER_LOWRES_TOP_HEADER";
                        break;
                    case (short) 8:
                        str = "TIMELINE_TIMELINE_RENDER_FULL_TOP_HEADER";
                        break;
                    case (short) 9:
                        str = "TIMELINE_TIMELINE_RENDER_ENTIRE_HEADER";
                        break;
                    case (short) 10:
                        str = "TIMELINE_TIMELINE_RENDER_ENTIRE_HEADER_FROM_SERVER";
                        break;
                    case (short) 11:
                        str = "TIMELINE_TIMELINE_RENDER_ENTIRE_HEADER_FROM_DISK_CACHE";
                        break;
                    case (short) 12:
                        str = "TIMELINE_TIMELINE_RENDER_ENTIRE_HEADER_FROM_RAM_CACHE";
                        break;
                    case (short) 13:
                        str = "TIMELINE_TIMELINE_RENDER_LOWRES_HEADER_FROM_SERVER";
                        break;
                    case (short) 14:
                        str = "TIMELINE_TIMELINE_RENDER_LOWRES_HEADER_FROM_DISK_CACHE";
                        break;
                    case (short) 15:
                        str = "TIMELINE_TIMELINE_RENDER_LOWRES_HEADER_FROM_RAM_CACHE";
                        break;
                    case (short) 16:
                        str = "TIMELINE_TIMELINE_FIRST_UNITS_NETWORK_FETCH";
                        break;
                    case (short) 17:
                        str = "TIMELINE_TIMELINE_LOAD_FIRST_SECTION_PLUTONIUM";
                        break;
                    case (short) 18:
                        str = "TIMELINE_TIMELINE_LOAD_FIRST_SECTION";
                        break;
                    case (short) 19:
                        str = "TIMELINE_TIMELINE_LOAD_FIRST_SECTION_FROM_SERVER";
                        break;
                    case (short) 20:
                        str = "TIMELINE_TIMELINE_LOAD_FIRST_SECTION_FROM_CACHE";
                        break;
                    case (short) 21:
                        str = "TIMELINE_TIMELINE_VISIBLE_SCROLL_FETCH_UNITS";
                        break;
                    case (short) 22:
                        str = "TIMELINE_TIMELINE_LOAD_PROFILE_PIC_PREVIEW";
                        break;
                    case (short) 23:
                        str = "TIMELINE_TIMELINE_LOAD_COVER_PHOTO_LOW_RES";
                        break;
                    case (short) 24:
                        str = "TIMELINE_TIMELINE_LOAD_COVER_PHOTO";
                        break;
                    case (short) 25:
                        str = "TIMELINE_TIMELINE_LOAD_PROFILE_PIC";
                        break;
                    case (short) 26:
                        str = "TIMELINE_TIMELINE_RENDER_LOWRES_HEADER";
                        break;
                    case (short) 27:
                        str = "TIMELINE_TIMELINE_RENDER_LOWRES_HEADER_COVERPHOTO_OPTIONAL";
                        break;
                    case (short) 28:
                        str = "TIMELINE_TIMELINE_SECTION_NETWORK_FETCH";
                        break;
                    case (short) 29:
                        str = "TIMELINE_COLLECTIONS_CURATE_FETCH_SEARCH_RESULTS";
                        break;
                    case (short) 30:
                        str = "TIMELINE_COLLECTIONS_SUMMARY_LOAD_FIRST_SECTIONS";
                        break;
                    case (short) 31:
                        str = "TIMELINE_TIMELINE_INITIAL_FETCH_UNITS";
                        break;
                    case (short) 32:
                        str = "TIMELINE_TIMELINE_SCROLL_FETCH_UNITS";
                        break;
                    case (short) 33:
                        str = "TIMELINE_TIMELINE_SECTION_HEADER_FETCH_UNITS";
                        break;
                    case (short) 34:
                        str = "TIMELINE_COLLECTIONS_COLLECTION_LOAD_FIRST_FETCHED_ITEMS";
                        break;
                    case (short) 35:
                        str = "TIMELINE_COLLECTIONS_COLLECTION_LOAD_FIRST_FETCHED_SUGGESTIONS";
                        break;
                    case (short) 36:
                        str = "TIMELINE_LIFE_EVENT_TYPE_FRAGMENT_TTI";
                        break;
                    case (short) 37:
                        str = "TIMELINE_LIFE_EVENT_TYPE_TTI";
                        break;
                    case (short) 38:
                        str = "TIMELINE_TIMELINE_START_EARLY_FETCH";
                        break;
                    case (short) 39:
                        str = "TIMELINE_TIMELINECONTEXTITEMSNETWORKFETCH";
                        break;
                    case (short) 40:
                        str = "TIMELINE_PROTILES_WAIT_TIME";
                        break;
                    case (short) 41:
                        str = "TIMELINE_PROTILES_NETWORK_FETCH";
                        break;
                    case (short) 42:
                        str = "TIMELINE_TIMELINE_CONTEXT_ITEMS_NETWORK_FETCH";
                        break;
                    case (short) 43:
                        str = "TIMELINE_COLLECTIONS_SUMMARY_LOAD_PRELIM_DATA";
                        break;
                    case (short) 44:
                        str = "TIMELINE_COLLECTIONS_SECTION_LOAD_PRELIM_DATA";
                        break;
                    case (short) 45:
                        str = "TIMELINE_COLLECTIONS_COLLECTION_LOAD_PRELIM_DATA";
                        break;
                    case (short) 46:
                        str = "TIMELINE_COLLECTIONS_SUMMARY_LOAD_ALL_SECTIONS";
                        break;
                    case (short) 47:
                        str = "TIMELINE_COLLECTIONS_SECTION_LOAD_ALL_COLLECTIONS";
                        break;
                    case (short) 48:
                        str = "TIMELINE_COLLECTIONS_COLLECTION_LOAD_COLLECTION";
                        break;
                    case (short) 49:
                        str = "TIMELINE_COLLECTIONS_SUMMARY_HAS_PRELIM_DATA";
                        break;
                    case (short) 50:
                        str = "TIMELINE_COLLECTIONS_SUMMARY_NO_PRELIM_DATA";
                        break;
                    case (short) 51:
                        str = "TIMELINE_COLLECTIONS_SECTION_HAS_PRELIM_DATA";
                        break;
                    case (short) 52:
                        str = "TIMELINE_COLLECTIONS_SECTION_NO_PRELIM_DATA";
                        break;
                    case (short) 53:
                        str = "TIMELINE_COLLECTIONS_COLLECTION_HAS_PRELIM_DATA";
                        break;
                    case (short) 54:
                        str = "TIMELINE_COLLECTIONS_COLLECTION_NO_PRELIM_DATA";
                        break;
                    case (short) 56:
                        str = "TIMELINE_COLLECTIONS_COLLECTION_LOAD_START_CURSOR_DATA";
                        break;
                    case (short) 57:
                        str = "TIMELINE_COLLECTIONS_COLLECTION_LOAD_COMPLETE_CURSOR_DATA";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 27:
                switch (s) {
                    case (short) 1:
                        str = "UBERBAR_NETWORK_RESULT_FETCH";
                        break;
                    case (short) 2:
                        str = "UBERBAR_LOCAL_RESULTS_FETCH";
                        break;
                    case (short) 3:
                        str = "UBERBAR_REMOTE_FETCH_TL_PREFETCH";
                        break;
                    case (short) 4:
                        str = "UBERBAR_REMOTE_FETCH";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 28:
                switch (s) {
                    case (short) 1:
                        str = "BROWSER_WEB_VIEW_LOAD";
                        break;
                    case (short) 2:
                        str = "BROWSER_BROWSER_CONTEXT_NETWORK_FETCH";
                        break;
                    case (short) 3:
                        str = "BROWSER_BROWSER_PIVOTS_HIDE";
                        break;
                    case (short) 4:
                        str = "BROWSER_BROWSER_PIVOTS_SHOW";
                        break;
                    case (short) 5:
                        str = "BROWSER_PERF_MARK_BROWSERFRAGMENT_INITIALIZE";
                        break;
                    case (short) 6:
                        str = "BROWSER_PERF_MARK_FIRST_WEBVIEW_INVALIDATE";
                        break;
                    case (short) 7:
                        str = "BROWSER_PERF_MARK_PAGE_FINISHED";
                        break;
                    case (short) 8:
                        str = "BROWSER_PREFETCH_CACHE_STORED";
                        break;
                    case (short) 9:
                        str = "BROWSER_PREFETCH_CACHE_USED";
                        break;
                    case (short) 10:
                        str = "BROWSER_PREFETCH_LOAD_URL";
                        break;
                    case (short) 11:
                        str = "BROWSER_PREFETCH_LOAD_URL_CACHE_HIT";
                        break;
                    case (short) 12:
                        str = "BROWSER_PREFETCH_LOAD_URL_CACHE_MISS";
                        break;
                    case (short) 13:
                        str = "BROWSER_PREFETCH_LOAD_URL_CACHE_MISS_PITY";
                        break;
                    case (short) 14:
                        str = "BROWSER_WEBVIEWLOAD_SEQUENCE_START";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 29:
                switch (s) {
                    case (short) 1:
                        str = "VIDEO_INITIALIZATION";
                        break;
                    case (short) 2:
                        str = "VIDEO_CHANNEL_VIDEO_PLAYER";
                        break;
                    case (short) 3:
                        str = "VIDEO_FULLSCREEN_TRANSITION";
                        break;
                    case (short) 4:
                        str = "VIDEO_PREFETCH_ITEM";
                        break;
                    case (short) 5:
                        str = "VIDEO_TEST_VIDEO_FETCH_PIPELINE";
                        break;
                    case (short) 6:
                        str = "VIDEO_RTMP_PLAYBACK_INITIALIZATION";
                        break;
                    case (short) 7:
                        str = "VIDEO_RTMP_PLAYBACK_CONNECTION";
                        break;
                    case (short) 8:
                        str = "VIDEO_LIVE_PLAYBACK_INITIALIZATION";
                        break;
                    case (short) 9:
                        str = "VIDEO_VIDEO_HOME_LOADING";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 30:
                switch (s) {
                    case (short) 1:
                        str = "REACTION_REACTION_OVERLAY_DISPLAY";
                        break;
                    case (short) 2:
                        str = "REACTION_REACTION_DIALOG_WAIT_TIME";
                        break;
                    case (short) 3:
                        str = "REACTION_REACTION_PLACETIPS_SUGGESTIFIER_COMBINED_FETCH_TIME";
                        break;
                    case (short) 4:
                        str = "REACTION_REACTION_PAGE_WAIT_TIME";
                        break;
                    case (short) 5:
                        str = "REACTION_REACTION_PLACETIPS_SIMPLE_FETCH_TIME";
                        break;
                    case (short) 6:
                        str = "REACTION_COMPONENT_STYLE_MAPPER";
                        break;
                    case (short) 7:
                        str = "REACTION_ATTACHMENT_STYLE_MAPPER";
                        break;
                    case (short) 8:
                        str = "REACTION_REACTION_INITIAL_NETWORK_WAIT_TIME";
                        break;
                    case (short) 9:
                        str = "REACTION_REACTION_INITIAL_RENDER_WAIT_TIME";
                        break;
                    case (short) 10:
                        str = "REACTION_PRIOR_REACTION_LOAD_TIME";
                        break;
                    case (short) 11:
                        str = "REACTION_REACTION_MULTI_ROW_RENDER_TIME";
                        break;
                    case (short) 12:
                        str = "REACTION_LOCAL_SERP_INITIAL_WAIT_TIME";
                        break;
                    case (short) 13:
                        str = "REACTION_REACTION_SPINNER_VISIBLE_TIME";
                        break;
                    case (short) 14:
                        str = "REACTION_LOCAL_SERP_INITIAL_NETWORK_WAIT_TIME";
                        break;
                    case (short) 15:
                        str = "REACTION_REACTION_INITIAL_CACHE_WAIT_TIME";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 32:
                switch (s) {
                    case (short) 1:
                        str = "GROUPS_GROUPS_STARTUP_SEQUENCE";
                        break;
                    case (short) 2:
                        str = "GROUPS_TREEHOUSE_TTPOGS";
                        break;
                    case (short) 3:
                        str = "GROUPS_TREEHOUSE_TTMALL";
                        break;
                    case (short) 4:
                        str = "GROUPS_TREEHOUSE_POST_SEARCH";
                        break;
                    case (short) 5:
                        str = "GROUPS_TREEHOUSE_TTPOGS_WARM";
                        break;
                    case (short) 6:
                        str = "GROUPS_TREEHOUSE_TTPOGS_HOT";
                        break;
                    case (short) 7:
                        str = "GROUPS_TREEHOUSE_TTPOGS_COLD";
                        break;
                    case (short) 8:
                        str = "GROUPS_TREEHOUSE_TTNOTIF_COLD";
                        break;
                    case (short) 9:
                        str = "GROUPS_TREEHOUSE_TTNOTIF_WARM";
                        break;
                    case (short) 10:
                        str = "GROUPS_TREEHOUSE_TTPERMALINK";
                        break;
                    case (short) 11:
                        str = "GROUPS_TREEHOUSE_TTMALL_COLD";
                        break;
                    case (short) 12:
                        str = "GROUPS_TREEHOUSE_TTCOMMENT";
                        break;
                    case (short) 13:
                        str = "GROUPS_TREEHOUSE_TTMALL_POST_COMPOSER";
                        break;
                    case (short) 14:
                        str = "GROUPS_TREEHOUSE_TTMALL_FRESH_STORIES";
                        break;
                    case (short) 15:
                        str = "GROUPS_TREEHOUSE_TTMALL_NEXT_STORIES";
                        break;
                    case (short) 16:
                        str = "GROUPS_GROUPS_DISCOVER_COLD";
                        break;
                    case (short) 17:
                        str = "GROUPS_TREEHOUSE_RN_PRECOMMENT";
                        break;
                    case (short) 18:
                        str = "GROUPS_TREEHOUSE_RN_GALLERY";
                        break;
                    case (short) 19:
                        str = "GROUPS_TREEHOUSE_TTMALL_CACHED_STORIES";
                        break;
                    case (short) 20:
                        str = "GROUPS_TREEHOUSE_TTMALL_APP_START";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 34:
                switch (s) {
                    case (short) 1:
                        str = "CREATIVEEDITING_CREATIVEEDITING";
                        break;
                    case (short) 2:
                        str = "CREATIVEEDITING_PERF_INIT_WITH_APPLY";
                        break;
                    case (short) 3:
                        str = "CREATIVEEDITING_PERF_INIT_NO_APPLY";
                        break;
                    case (short) 4:
                        str = "CREATIVEEDITING_IMAGE_SIMILARITY";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 35:
                switch (s) {
                    case (short) 1:
                        str = "NewLogin";
                        break;
                    case (short) 3:
                        str = "LoginToBeforeFeedFetch";
                        break;
                    case (short) 4:
                        str = "LOGIN_FETCH_LOGIN_DATA_TTI";
                        break;
                    case (short) 10:
                        str = "LOGIN_FETCH_LOGIN_COMPONENTS";
                        break;
                    case (short) 13:
                        str = "LOGIN_SILENT_LOGIN";
                        break;
                    case (short) 14:
                        str = "ColdStartNuxTTI";
                        break;
                    case (short) 16:
                        str = "LOGIN_LOAD_PERSISTENT_COMPONENTS";
                        break;
                    case (short) 17:
                        str = "LOGIN_FETCH_PERSISTENT_COMPONENTS";
                        break;
                    case (short) 18:
                        str = "LOGIN_LOGOUT";
                        break;
                    case (short) 19:
                        str = "LoginToFeedStory";
                        break;
                    case (short) 20:
                        str = "Authentication";
                        break;
                    case (short) 21:
                        str = "InterstitialPreparation";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 36:
                switch (s) {
                    case (short) 1:
                        str = "FACEWEB_CHROME_LOAD";
                        break;
                    case (short) 2:
                        str = "FACEWEB_PAGE_SESSION";
                        break;
                    case (short) 3:
                        str = "FACEWEB_PAGE_NETWORK_LOAD";
                        break;
                    case (short) 4:
                        str = "FACEWEB_PAGE_RPC_LOAD_COMPLETED";
                        break;
                    case (short) 5:
                        str = "FACEWEB_FACEWEB_PAGE_NETWORK_LOAD";
                        break;
                    case (short) 6:
                        str = "FACEWEB_FACEWEB_PAGE_SESSION";
                        break;
                    case (short) 7:
                        str = "FACEWEB_FACEWEB_PAGE_RPC_LOAD_COMPLETED";
                        break;
                    case (short) 8:
                        str = "FACEWEB_FW_FRAGMENT_CREATE";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 37:
                switch (s) {
                    case (short) 1:
                        str = "CAMERA_FLOW_ACTIVITY_CREATE";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 38:
                switch (s) {
                    case (short) 1:
                        str = "BACKGROUND_LOCATION_SETTINGS_OVERALL_TTI";
                        break;
                    case (short) 2:
                        str = "BACKGROUND_LOCATION_SETTINGS_FETCH_DATA";
                        break;
                    case (short) 3:
                        str = "BACKGROUND_LOCATION_SETTINGS_INIT";
                        break;
                    case (short) 4:
                        str = "BACKGROUND_LOCATION_SETTINGS_RENDER";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 39:
                switch (s) {
                    case (short) 1:
                        str = "BACKGROUND_TASK_RUNNER_RUN";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 40:
                switch (s) {
                    case (short) 1:
                        str = "BOOKMARK_HANDLE_OPERATION";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 43:
                switch (s) {
                    case (short) 1:
                        str = "TYPEFACE_FORCED_TYPEFACE_OVERRIDE";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 44:
                switch (s) {
                    case (short) 1:
                        str = "CONDITIONAL_WORKER_CALL";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 45:
                switch (s) {
                    case (short) 1:
                        str = "DASH_FEED_LOAD_NEWER_STORIES_SERVER";
                        break;
                    case (short) 2:
                        str = "DASH_FEED_LOAD_OLDER_STORIES_SERVER";
                        break;
                    case (short) 3:
                        str = "DASH_FEED_LOAD_OLDER_STORIES_CACHE";
                        break;
                    case (short) 4:
                        str = "DASH_FEED_LOAD_OLDER_STORIES_SERVER_PERF_MARKER";
                        break;
                    case (short) 5:
                        str = "DASH_FEED_LOAD_OLDER_STORIES_CACHE_PERF_MARKER";
                        break;
                    case (short) 6:
                        str = "DASH_FEED_LOAD_NEWER_STORIES_SERVER_PERF_MARKER";
                        break;
                    case (short) 7:
                        str = "DASH_FEED_PERF_BITMAP_SET_TIME";
                        break;
                    case (short) 8:
                        str = "DASH_FEED_GET_IMAGE_PERF_MARKER";
                        break;
                    case (short) 9:
                        str = "DASH_FEED_UPDATE_IMPORTANCE_PERF_MARKER";
                        break;
                    case (short) 10:
                        str = "DASH_FEED_RERANK_ALL_PERF_MARKER";
                        break;
                    case (short) 11:
                        str = "DASH_FEED_DASH_ACTIVITY_COLD_START";
                        break;
                    case (short) 12:
                        str = "DASH_FEED_DASH_ACTIVITY_WARM_START";
                        break;
                    case (short) 13:
                        str = "DASH_FEED_BAUBLE_SHOW";
                        break;
                    case (short) 14:
                        str = "DASH_FEED_BAUBLE_SHOW_LOGGED_OUT";
                        break;
                    case (short) 15:
                        str = "DASH_FEED_DASH_COLD_START";
                        break;
                    case (short) 16:
                        str = "DASH_FEED_LOAD_APPS_FROM_PACKAGE_MANAGER";
                        break;
                    case (short) 17:
                        str = "DASH_FEED_LOAD_SHORTCUTS_FROM_DATABASE";
                        break;
                    case (short) 18:
                        str = "DASH_FEED_DASH_ACTIVITY_NOTIFICATION_LEAVE";
                        break;
                    case (short) 19:
                        str = "DASH_FEED_DASH_ACTIVITY_MESSAGE_LEAVE";
                        break;
                    case (short) 20:
                        str = "DASH_FEED_DASH_ACTIVITY_LAUNCH_APP_LEAVE";
                        break;
                    case (short) 21:
                        str = "DASH_FEED_DASH_ACTIVITY_MESSAGES_LEAVE";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 46:
                switch (s) {
                    case (short) 1:
                        str = "PYMK_PAGINATED_PYMK_TTI";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 47:
                switch (s) {
                    case (short) 1:
                        str = "FRIENDING_LOCATION";
                        break;
                    case (short) 2:
                        str = "FRIENDING_SEARCH";
                        break;
                    case (short) 3:
                        str = "FRIENDING_PERF_LOGGING_MY_CODE_FETCH_TIME";
                        break;
                    case (short) 4:
                        str = "FRIENDING_PERF_LOGGING_CODE_SEARCH_TIME";
                        break;
                    case (short) 5:
                        str = "FRIENDING_FRIENDING_LOCATION_TTI";
                        break;
                    case (short) 6:
                        str = "FRIENDING_FRIEND_REQUESTS_HARRISON_TAB_SWITCH_TTI";
                        break;
                    case (short) 7:
                        str = "FRIENDING_NUX_ADD_FRIENDS_STEP_TTI";
                        break;
                    case (short) 8:
                        str = "FRIENDING_FRIENDS_TAB_TTI_METRIC_NAME";
                        break;
                    case (short) 9:
                        str = "FRIENDING_REQUESTS_TAB_TTI_METRIC_NAME";
                        break;
                    case (short) 10:
                        str = "FRIENDING_SEARCH_TAB_TTI_METRIC_NAME";
                        break;
                    case (short) 11:
                        str = "FRIENDING_SUGGESTIONS_TAB_TTI_METRIC_NAME";
                        break;
                    case (short) 12:
                        str = "FRIENDING_FRIENDS_TAB_DISK_LOAD_METRIC_NAME";
                        break;
                    case (short) 13:
                        str = "FRIENDING_FRIENDS_TAB_NETWORK_LOAD_METRIC_NAME";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 48:
                switch (s) {
                    case (short) 1:
                        str = "FRIENDS_NEARBY_DASHBOARD_INIT_LOCATION";
                        break;
                    case (short) 2:
                        str = "FRIENDS_NEARBY_DASHBOARD_REFRESH_LOCATION";
                        break;
                    case (short) 3:
                        str = "FRIENDS_NEARBY_DASHBOARD_FETCH_DATA";
                        break;
                    case (short) 4:
                        str = "FRIENDS_NEARBY_DASHBOARD_FETCH_DATA1";
                        break;
                    case (short) 5:
                        str = "FRIENDS_NEARBY_DASHBOARD_FETCH_DATA2";
                        break;
                    case (short) 6:
                        str = "FRIENDS_NEARBY_DASHBOARD_VIEW_RENDER";
                        break;
                    case (short) 7:
                        str = "FRIENDS_NEARBY_DASHBOARD_INIT";
                        break;
                    case (short) 8:
                        str = "FRIENDS_NEARBY_DASHBOARD_TTI";
                        break;
                    case (short) 9:
                        str = "FRIENDS_NEARBY_PING_DELETE";
                        break;
                    case (short) 10:
                        str = "FRIENDS_NEARBY_PING_WRITE";
                        break;
                    case (short) 11:
                        str = "FRIENDS_NEARBY_PING_FETCH_EXIST";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 49:
                switch (s) {
                    case (short) 1:
                        str = "GRAPHQL_TRIM_TO_MINIMUM";
                        break;
                    case (short) 2:
                        str = "GRAPHQL_TRIM_TO_NOTHING";
                        break;
                    case (short) 3:
                        str = "GRAPHQL_CONSISTENCY_MODEL_UPDATER";
                        break;
                    case (short) 4:
                        str = "GRAPHQL_CURSOR_DB_TRIM_TO_MINIMUM";
                        break;
                    case (short) 5:
                        str = "GRAPHQL_CURSOR_DB_TRIM_TO_NOTHING";
                        break;
                    case (short) 6:
                        str = "GRAPHQL_ADD_COMMENT_BLUE_SERVICE";
                        break;
                    case (short) 7:
                        str = "GRAPHQL_CURSOR_DB_VISIT_ALL";
                        break;
                    case (short) 8:
                        str = "GRAPHQL_CACHEPOLICY_NETWORK_ONLY_POLICY";
                        break;
                    case (short) 9:
                        str = "GRAPHQL_CACHEPOLICY_FETCH_AND_FILL";
                        break;
                    case (short) 10:
                        str = "GRAPHQL_CACHEPOLICY_CACHE_ONLY_POLICY";
                        break;
                    case (short) 11:
                        str = "GRAPHQL_CACHEPOLICY_DISK_CACHE_ONLY_POLICY";
                        break;
                    case (short) 12:
                        str = "GRAPHQL_PERF_MARKER_MUTATION";
                        break;
                    case (short) 13:
                        str = "GRAPHQL_PERF_MARKER_SUBSCRIPTION_PUSH";
                        break;
                    case (short) 14:
                        str = "GRAPHQL_PERF_MARKER_PUT_1000_FRIENDS";
                        break;
                    case (short) 15:
                        str = "GRAPHQL_PERF_MARKER_GET_1000_FRIENDS";
                        break;
                    case (short) 16:
                        str = "GRAPHQL_PERF_EVENT_CACHE_HIT";
                        break;
                    case (short) 17:
                        str = "GRAPHQL_PERF_EVENT_CACHE_MISS";
                        break;
                    case (short) 18:
                        str = "GRAPHQL_WAKE_LOCK_HELD";
                        break;
                    case (short) 19:
                        str = "GRAPHQL_CACHE_GET";
                        break;
                    case (short) 20:
                        str = "GRAPHQL_CACHE_PUT";
                        break;
                    case (short) 21:
                        str = "GRAPHQL_FETCH_MSG_FAIL";
                        break;
                    case (short) 22:
                        str = "GRAPHQL_PERF_MARKER_PUT_100_MAPS";
                        break;
                    case (short) 23:
                        str = "GRAPHQL_PERF_MARKER_GET_100_MAPS";
                        break;
                    case (short) 24:
                        str = "GRAPHQL_PERF_MARKER_PUT_1000_FRIENDS_WITH_EXPORTS";
                        break;
                    case (short) 25:
                        str = "GRAPHQL_PERF_MARKER_GET_1000_FRIENDS_WITH_EXPORTS";
                        break;
                    case (short) 26:
                        str = "GRAPHQL_FEEDBACK_CONSISTENCY_BENCHMARK_CACHE_READ";
                        break;
                    case (short) 27:
                        str = "GRAPHQL_CONSISTENCY_BENCHMARK_DISK_READ";
                        break;
                    case (short) 28:
                        str = "GRAPHQL_CONSISTENCY_BENCHMARK_UPDATE_FROM_CACHE";
                        break;
                    case (short) 29:
                        str = "GRAPHQL_BENCHMARK_RMT_TOGGLE_LIKE";
                        break;
                    case (short) 30:
                        str = "GRAPHQL_FETCH_FROM_DB";
                        break;
                    case (short) 31:
                        str = "GRAPHQL_UPDATE_MODEL_FROM_CACHE";
                        break;
                    case (short) 32:
                        str = "GRAPHQL_UPDATE_MODEL_FROM_CACHE_IN_PLACE";
                        break;
                    case (short) 33:
                        str = "GRAPHQL_GRAPHQL_DISK_CACHE_VISIT_ALL";
                        break;
                    case (short) 34:
                        str = "GRAPHQL_BUILD_CONSISTENCY_INDEX";
                        break;
                    case (short) 35:
                        str = "GRAPHQL_UPDATE_DB";
                        break;
                    case (short) 36:
                        str = "GRAPHQL_BENCHMARK_READ_CONSISTENT_FIELDS";
                        break;
                    case (short) 37:
                        str = "GRAPHQL_BENCHMARK_READ_CONSISTENT_FIELDS_FLATBUFFER";
                        break;
                    case (short) 38:
                        str = "GRAPHQL_GRAPHQL_READ_QUERY";
                        break;
                    case (short) 39:
                        str = "GRAPHQL_GRAPHQL_BATCH_QUERY";
                        break;
                    case (short) 40:
                        str = "GRAPHQL_GRAPHQL_BATCH_ITEM";
                        break;
                    case (short) 41:
                        str = "GRAPHQL_GRAPHQL_MUTATION";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 50:
                switch (s) {
                    case (short) 1:
                        str = "LAUNCHABLES_LOAD_APPS_FROM_PACKAGE_MANAGER";
                        break;
                    case (short) 2:
                        str = "LAUNCHABLES_LOAD_SHORTCUTS_FROM_DATABASE";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 51:
                switch (s) {
                    case (short) 1:
                        str = "LOCATION_ANY_LOCATION";
                        break;
                    case (short) 2:
                        str = "LOCATION_CITY_GRANULARITY";
                        break;
                    case (short) 3:
                        str = "LOCATION_BLOCK_GRANULARITY";
                        break;
                    case (short) 4:
                        str = "LOCATION_EXACT_GRANULARITY";
                        break;
                    case (short) 5:
                        str = "LOCATION_CLIENT_CONNECT";
                        break;
                    case (short) 6:
                        str = "LOCATION_OVERALL_TTI";
                        break;
                    case (short) 7:
                        str = "LOCATION_INIT";
                        break;
                    case (short) 8:
                        str = "LOCATION_FETCH_DATA";
                        break;
                    case (short) 9:
                        str = "LOCATION_RENDER";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 52:
                switch (s) {
                    case (short) 1:
                        str = "MEDIA_PICKER_MEDIAPICKER_LAUNCH";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 53:
                switch (s) {
                    case (short) 1:
                        str = "NOTIFICATIONS_NOTIF_GET_FROM_DISK";
                        break;
                    case (short) 2:
                        str = "NOTIFICATIONS_NOTIF_FULL_FETCH_FROM_SERVER";
                        break;
                    case (short) 3:
                        str = "NOTIFICATIONS_NOTIF_NEW_FETCH_FROM_SERVER";
                        break;
                    case (short) 4:
                        str = "NOTIFICATIONS_POLL_NOTIF";
                        break;
                    case (short) 5:
                        str = "NOTIFICATIONS_PULL_TO_REFRESH_LOAD_TIME";
                        break;
                    case (short) 6:
                        str = "NOTIFICATIONS_NOTIF_JSON_DESERIALIZE";
                        break;
                    case (short) 7:
                        str = "NOTIFICATIONS_NOTIF_LOCKSCREEN_PERMALINK_LOAD_TIME";
                        break;
                    case (short) 8:
                        str = "NOTIFICATIONS_NOTIF_PERMALINK_REFRESH_STORY_TIME";
                        break;
                    case (short) 9:
                        str = "NOTIFICATIONS_NOTIF_LIST_LOAD_TIME_COLD";
                        break;
                    case (short) 10:
                        str = "NOTIFICATIONS_NOTIF_LIST_LOAD_TIME_WARM";
                        break;
                    case (short) 13:
                        str = "NOTIFICATIONS_NOTIF_SCROLL_LOAD";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 54:
                switch (s) {
                    case (short) 1:
                        str = "THREADS_CREATE_THREAD_LIST";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 55:
                switch (s) {
                    case (short) 1:
                        str = "THREAD_LIST_CREATE_MESSAGE_VIEW";
                        break;
                    case (short) 2:
                        str = "THREAD_LIST_CREATE_THREAD_LIST";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 56:
                switch (s) {
                    case (short) 1:
                        str = "GENERAL_UI_MAIN_ACTIVITY_TO_FRAGMENT_CREATE";
                        break;
                    case (short) 2:
                        str = "GENERAL_UI_INTENT_TO_ACTIVITY_TRANSITION";
                        break;
                    case (short) 3:
                        str = "GENERAL_UI_COLD_START";
                        break;
                    case (short) 4:
                        str = "GENERAL_UI_MAIN_ACTIVITY_CREATE";
                        break;
                    case (short) 5:
                        str = "GENERAL_UI_WARM_START";
                        break;
                    case (short) 6:
                        str = "GENERAL_UI_TAB_CREATE";
                        break;
                    case (short) 7:
                        str = "GENERAL_UI_PLATFORM_DIALOG_ACTIVITY";
                        break;
                    case (short) 8:
                        str = "GENERAL_UI_MAIN_ACTIVITY_INTENT_TO_FRAGMENT_CREATE";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 57:
                switch (s) {
                    case (short) 1:
                        str = "UFI_NNF_FLYOUT_LOAD_DB_CACHE";
                        break;
                    case (short) 2:
                        str = "UFI_NNF_FLYOUT_LOAD_DB_CACHE_AND_RENDER";
                        break;
                    case (short) 3:
                        str = "UFI_NNF_FLYOUT_LOAD_NETWORK";
                        break;
                    case (short) 4:
                        str = "UFI_NNF_FLYOUT_LOAD_NETWORK_AND_RENDER";
                        break;
                    case (short) 5:
                        str = "UFI_NNF_FLYOUT_LOAD_NETWORK_WITHOUT_CACHE";
                        break;
                    case (short) 6:
                        str = "UFI_NNF_FLYOUT_LOAD_NETWORK_WITHOUT_CACHE_AND_RENDER";
                        break;
                    case (short) 7:
                        str = "UFI_NNF_FLYOUT_LOAD_COMPLETE_FLOW";
                        break;
                    case (short) 8:
                        str = "NNF_FlyoutLoadCompleteFlowAndRender";
                        break;
                    case (short) 9:
                        str = "UFI_NNF_FLYOUT_ON_CREATE_TIME";
                        break;
                    case (short) 10:
                        str = "UFI_NNF_FLYOUT_FRAGMENT_CREATE_TIME";
                        break;
                    case (short) 11:
                        str = "UFI_PHOTO_FLYOUT_LOAD_CACHED";
                        break;
                    case (short) 12:
                        str = "UFI_PHOTO_FLYOUT_LOAD_NETWORK";
                        break;
                    case (short) 13:
                        str = "UFI_DASH_FLYOUT_LOAD_CACHED";
                        break;
                    case (short) 14:
                        str = "UFI_DASH_FLYOUT_LOAD_NETWORK";
                        break;
                    case (short) 15:
                        str = "UFI_FLYOUT_NETWORK_TIME_FEEDBACK_ID";
                        break;
                    case (short) 16:
                        str = "UFI_FLYOUT_NETWORK_TIME_EXECUTOR_FEEDBACK_ID";
                        break;
                    case (short) 17:
                        str = "UFI_FLYOUT_NETWORK_TIME_PHOTO_ID";
                        break;
                    case (short) 18:
                        str = "UFI_NNF_FLYOUT_ON_CREATEVIEW_TIME";
                        break;
                    case (short) 19:
                        str = "UFI_NNF_FLYOUT_ON_VIEWCREATED_TIME";
                        break;
                    case (short) 20:
                        str = "UFI_NNF_FLYOUT_ON_ACTIVITYCRAETED_TIME";
                        break;
                    case (short) 21:
                        str = "UFI_NNF_FLYOUT_ON_RESUME_TIME";
                        break;
                    case (short) 22:
                        str = "UFI_NNF_FLYOUT_RESUME_TO_RENDER_TIME";
                        break;
                    case (short) 23:
                        str = "UFI_NNF_FLYOUT_ANIMATION_WAIT_TIME";
                        break;
                    case (short) 24:
                        str = "UFI_NNF_FLYOUT_LOAD_COMPLETE_FLOW_TO_RENDER";
                        break;
                    case (short) 25:
                        str = "UFI_LOAD_MORE_COMMENTS";
                        break;
                    case (short) 26:
                        str = "UFI_NNF_FLYOUT_ANIMATION_ADJUSTED_WAIT_TIME";
                        break;
                    case (short) 27:
                        str = "UFI_NNF_FLYOUT_RESUME_TO_ANIMATION_WAIT";
                        break;
                    case (short) 28:
                        str = "UFI_NNF_FLYOUT_ANIMATION_TO_DATA_FETCH";
                        break;
                    case (short) 29:
                        str = "UfiFuturesPostComment";
                        break;
                    case (short) 30:
                        str = "UFI_PERF_MARKER_OPTIMISTIC_COMMENT";
                        break;
                    case (short) 31:
                        str = "NNF_FlyoutLoadNetworkWithCache";
                        break;
                    case (short) 32:
                        str = "UFI_NNF_FLYOUT_BG_INFLATABLE_FEEDBACK_TOTAL_TIME";
                        break;
                    case (short) 33:
                        str = "UFI_NNF_FLYOUT_BG_INFLATION_TIME";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 58:
                switch (s) {
                    case (short) 1:
                        str = "VAULT_PERF_TIME_TO_GET_SYNCED_PHOTO_HASH_TO_FBID";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 59:
                return Facerec.a(s);
            case (short) 60:
                switch (s) {
                    case (short) 1:
                        str = "APP_TAB_LOAD_TAB_TAB";
                        break;
                    case (short) 2:
                        str = "APP_TAB_LOAD_TAB_TAB_NO_ANIM";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 61:
                switch (s) {
                    case (short) 1:
                        str = "INIT_HIGH_PRI_BG_THREAD_MARKER";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 62:
                switch (s) {
                    case (short) 1:
                        str = "FRIEND_LIST_INITIAL_LOAD_PERF_MARKER";
                        break;
                    case (short) 2:
                        str = "FRIEND_LIST_INITIAL_LOAD_ALL_TAB";
                        break;
                    case (short) 3:
                        str = "FRIEND_LIST_INITIAL_LOAD_MUTUAL_TAB";
                        break;
                    case (short) 4:
                        str = "FRIEND_LIST_INITIAL_LOAD_RECENT_TAB";
                        break;
                    case (short) 5:
                        str = "FRIEND_LIST_INITIAL_LOAD_SUGGESTIONS_TAB";
                        break;
                    case (short) 6:
                        str = "FRIEND_LIST_INITIAL_LOAD_WITH_NEW_POSTS_TAB";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 63:
                switch (s) {
                    case (short) 1:
                        str = "FRIEND_FINDER_FRIEND_FINDER_ADD_FRIENDS_TTI_MARKER";
                        break;
                    case (short) 2:
                        str = "FRIEND_FINDER_FRIEND_FINDER_UPLOAD_TIME";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 64:
                switch (s) {
                    case (short) 1:
                        str = "REGISTRATION_PERF_LOGGING_ACCOUNT_CREATION";
                        break;
                    case (short) 2:
                        str = "REGISTRATION_PERF_LOGGING_STEP_VALIDATION";
                        break;
                    case (short) 3:
                        str = "REGISTRATION_PERF_LOGGING_REGISTRATION_LOGIN";
                        break;
                    case (short) 4:
                        str = "REGISTRATION_REGISTRATION_PERCEIVED_LOGIN";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 65:
                switch (s) {
                    case (short) 1:
                        str = "MINUTIAE_ICON_PICKER_TIME_TO_INIT";
                        break;
                    case (short) 2:
                        str = "MINUTIAE_ICON_PICKER_TIME_TO_FETCH_START";
                        break;
                    case (short) 3:
                        str = "MINUTIAE_ICON_PICKER_TIME_TO_FETCH_END";
                        break;
                    case (short) 4:
                        str = "MINUTIAE_ICON_PICKER_TIME_TO_RESULTS_SHOWN";
                        break;
                    case (short) 5:
                        str = "MINUTIAE_ICON_PICKER_FETCH_TIME";
                        break;
                    case (short) 6:
                        str = "MINUTIAE_ICON_PICKER_RENDERING_TIME";
                        break;
                    case (short) 7:
                        str = "MINUTIAE_ICON_PICKER_TIME_TO_SEARCH_RESULT_SHOWN";
                        break;
                    case (short) 8:
                        str = "MINUTIAE_ICON_PICKER_TIME_TO_FETCH_END_CACHED";
                        break;
                    case (short) 9:
                        str = "MINUTIAE_ICON_PICKER_TIME_TO_RESULTS_SHOWN_CACHED";
                        break;
                    case (short) 10:
                        str = "MINUTIAE_ICON_PICKER_FETCH_TIME_CACHED";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 66:
                switch (s) {
                    case (short) 1:
                        str = "MINUTIAE_OBJECT_PICKER_TIME_TO_INIT";
                        break;
                    case (short) 2:
                        str = "MINUTIAE_OBJECT_PICKER_TIME_TO_FETCH_START";
                        break;
                    case (short) 3:
                        str = "MINUTIAE_OBJECT_PICKER_TIME_TO_FETCH_END";
                        break;
                    case (short) 4:
                        str = "MINUTIAE_OBJECT_PICKER_TIME_TO_RESULTS_SHOWN";
                        break;
                    case (short) 5:
                        str = "MINUTIAE_OBJECT_PICKER_FETCH_TIME";
                        break;
                    case (short) 6:
                        str = "MINUTIAE_OBJECT_PICKER_RENDERING_TIME";
                        break;
                    case (short) 7:
                        str = "MINUTIAE_OBJECT_PICKER_TIME_TO_SEARCH_SHOWN";
                        break;
                    case (short) 8:
                        str = "MINUTIAE_OBJECT_PICKER_TIME_TO_FETCH_END_CACHED";
                        break;
                    case (short) 9:
                        str = "MINUTIAE_OBJECT_PICKER_TIME_TO_RESULTS_SHOWN_CACHED";
                        break;
                    case (short) 10:
                        str = "MINUTIAE_OBJECT_PICKER_FETCH_TIME_CACHED";
                        break;
                    case (short) 11:
                        str = "MINUTIAE_OBJECT_PICKER_TIME_TO_SCROLL_LOAD";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 67:
                switch (s) {
                    case (short) 1:
                        str = "MINUTIAE_VERB_PICKER_TIME_TO_INIT";
                        break;
                    case (short) 2:
                        str = "MINUTIAE_VERB_PICKER_TIME_TO_FETCH_START";
                        break;
                    case (short) 3:
                        str = "MINUTIAE_VERB_PICKER_TIME_TO_FETCH_END";
                        break;
                    case (short) 4:
                        str = "MINUTIAE_VERB_PICKER_FETCH_TIME";
                        break;
                    case (short) 5:
                        str = "MINUTIAE_VERB_PICKER_RENDERING_TIME";
                        break;
                    case (short) 6:
                        str = "MINUTIAE_VERB_PICKER_ACTIVITY_TTI";
                        break;
                    case (short) 7:
                        str = "MINUTIAE_VERB_PICKER_TIME_TO_FETCH_END_CACHED";
                        break;
                    case (short) 8:
                        str = "MINUTIAE_VERB_PICKER_TIME_TO_RESULTS_SHOWN_CACHED";
                        break;
                    case (short) 9:
                        str = "MINUTIAE_VERB_PICKER_FETCH_TIME_CACHED";
                        break;
                    case (short) 10:
                        str = "MINUTIAE_VERB_PICKER_ACTIVITY_TTI_CACHED";
                        break;
                    case (short) 11:
                        str = "MINUTIAE_VERB_PICKER_TIME_TO_RESULTS_SHOWN";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 68:
                switch (s) {
                    case (short) 1:
                        str = "RESOURCES_FB_RESOURCES_LOADING_ASSET_STRINGS";
                        break;
                    case (short) 2:
                        str = "RESOURCES_FB_RESOURCES_LOADING_DOWNLOADED_STRINGS";
                        break;
                    case (short) 3:
                        str = "RESOURCES_FB_RESOURCES_DOWNLOAD_FILE";
                        break;
                    case (short) 4:
                        str = "RESOURCES_FB_RESOURCES_WAITING_ACTIVITY";
                        break;
                    case (short) 5:
                        str = "RESOURCES_WAITING_FOR_STRINGS_ACTIVITY";
                        break;
                    case (short) 6:
                        str = "RESOURCES_PARSING_ASSET_LANGUAGE_PACK";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 69:
                switch (s) {
                    case (short) 1:
                        str = "POWER_DATA_CURRENT";
                        break;
                    case (short) 2:
                        str = "POWER_DATA_HOURS_OF_USE";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 70:
                switch (s) {
                    case (short) 1:
                        str = "INCOMINGCALLVOIP_INCOMINGCALL_MAKER";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 71:
                switch (s) {
                    case (short) 1:
                        str = "CONTACTS_COLD_START";
                        break;
                    case (short) 2:
                        str = "CONTACTS_WARM_START";
                        break;
                    case (short) 3:
                        str = "CONTACTS_MAIN_ACTIVITY_CREATE";
                        break;
                    case (short) 4:
                        str = "CONTACTS_SHOW_HISTORY";
                        break;
                    case (short) 5:
                        str = "CONTACTS_DRAW_VIEW";
                        break;
                    case (short) 6:
                        str = "CONTACTS_ON_CREATE_VIEW";
                        break;
                    case (short) 7:
                        str = "CONTACTS_TAB_CREATE";
                        break;
                    case (short) 8:
                        str = "CONTACTS_INFLATE_MAIN_ACTIVITY";
                        break;
                    case (short) 9:
                        str = "CONTACTS_INJECT_MAIN_ACTIVITY";
                        break;
                    case (short) 10:
                        str = "CONTACTS_SEARCH_TIME_TO_FIRST_RESULT";
                        break;
                    case (short) 11:
                        str = "CONTACTS_LOCAL_SEARCH";
                        break;
                    case (short) 12:
                        str = "CONTACTS_REMOTE_SEARCH";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 72:
                switch (s) {
                    case (short) 1:
                        str = "BLUESERVICE_BLUESERVICETOTALOVERHEAD";
                        break;
                    case (short) 2:
                        str = "BLUESERVICE_BLUESERVICETOBINDDONE";
                        break;
                    case (short) 3:
                        str = "BLUESERVICE_BLUESERVICEWAITINQUEUE";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 74:
                switch (s) {
                    case (short) 1:
                        str = "NETWORK_PERF_HTTP_RESPONSE_BODY_READ";
                        break;
                    case (short) 2:
                        str = "NETWORK_PERF_HTTP_FLOW_TOP";
                        break;
                    case (short) 3:
                        str = "NETWORK_PERF_HTTP_REQUEST_STAGED";
                        break;
                    case (short) 4:
                        str = "NETWORK_PERF_HTTP_REQUEST_EXCHANGE";
                        break;
                    case (short) 5:
                        str = "NETWORK_PERF_HTTP_DNS_RESOLUTION";
                        break;
                    case (short) 6:
                        str = "NETWORK_PERF_HTTP_TLS_SETUP";
                        break;
                    case (short) 7:
                        str = "NETWORK_PERF_HTTP_TCP_CONNECT";
                        break;
                    case (short) 8:
                        str = "NETWORK_PERF_CDN_IMAGE_LOAD";
                        break;
                    case (short) 9:
                        str = "NETWORK_PERF_CONSECUTIVE_FAILED_REQUESTS";
                        break;
                    case (short) 10:
                        str = "NETWORK_PERF_BLACKOUT_DURATION";
                        break;
                    case (short) 11:
                        str = "NETWORK_PERF_REQUESTS";
                        break;
                    case (short) 12:
                        str = "NETWORK_PERF_RESPONSE_LENGTH";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 75:
                switch (s) {
                    case (short) 1:
                        str = "GOODWILL_THROWBACK_FEED_TTI";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 76:
                switch (s) {
                    case (short) 1:
                        str = "INTERACTION_TTI";
                        break;
                    case (short) 2:
                        str = "INTERACTION_TOUCH";
                        break;
                    case (short) 3:
                        str = "INTERACTION_INTENT_MAPPING";
                        break;
                    case (short) 4:
                        str = "INTERACTION_START_ACTIVITY";
                        break;
                    case (short) 5:
                        str = "INTERACTION_START_ACTIVITY_FOR_RESULT";
                        break;
                    case (short) 6:
                        str = "INTERACTION_ACTIVITY_ON_CREATE";
                        break;
                    case (short) 7:
                        str = "INTERACTION_ACTIVITY_ON_START";
                        break;
                    case (short) 8:
                        str = "INTERACTION_ACTIVITY_ON_RESUME";
                        break;
                    case (short) 9:
                        str = "INTERACTION_ACTIVITY_ON_PAUSE";
                        break;
                    case (short) 10:
                        str = "INTERACTION_ANIMATION";
                        break;
                    case (short) 11:
                        str = "INTERACTION_NEW_FRAGMENT";
                        break;
                    case (short) 12:
                        str = "INTERACTION_ADD_FRAGMENT";
                        break;
                    case (short) 13:
                        str = "INTERACTION_ACTIVITY_ON_STOP";
                        break;
                    case (short) 14:
                        str = "INTERACTION_LOAD_TIMELINE_HEADER";
                        break;
                    case (short) 15:
                        str = "INTERACTION_LOAD_PAGE_HEADER";
                        break;
                    case (short) 16:
                        str = "INTERACTION_LOAD_EVENT_PERMALINK";
                        break;
                    case (short) 17:
                        str = "INTERACTION_LOAD_GROUPS_FEED";
                        break;
                    case (short) 18:
                        str = "INTERACTION_LOAD_PAGE_HEADER_ADMIN";
                        break;
                    case (short) 19:
                        str = "INTERACTION_LOAD_PERMALINK";
                        break;
                    case (short) 20:
                        str = "INTERACTION_OPEN_COMPOSER";
                        break;
                    case (short) 21:
                        str = "INTERACTION_OPEN_MEDIA_PICKER";
                        break;
                    case (short) 22:
                        str = "INTERACTION_OPEN_PHOTO_GALLERY";
                        break;
                    case (short) 23:
                        str = "INTERACTION_OPEN_CHECK_IN";
                        break;
                    case (short) 24:
                        str = "INTERACTION_LOAD_WEB_VIEW";
                        break;
                    case (short) 25:
                        str = "INTERACTION_SEARCH_TYPEAHEAD";
                        break;
                    case (short) 26:
                        str = "INTERACTION_LOAD_EVENTS_DASHBOARD";
                        break;
                    case (short) 27:
                        str = "INTERACTION_OPEN_PHOTOS_FEED";
                        break;
                    case (short) 28:
                        str = "INTERACTION_TIME_TO_ACTIVITY_ON_PAUSE";
                        break;
                    case (short) 29:
                        str = "INTERACTION_TIME_TO_ACTIVITY_ON_CREATE";
                        break;
                    case (short) 30:
                        str = "INTERACTION_TIME_TO_FRAGMENT_ON_CREATE";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 77:
                switch (s) {
                    case (short) 1:
                        str = "NEGATIVE_FEEDBACK_NEGATIVE_FEEDBACK_GRAPHQL_FETCH";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 78:
                switch (s) {
                    case (short) 2:
                        str = "AUTH_GET_LOGGED_IN_USER";
                        break;
                    case (short) 3:
                        str = "SignalAuthComponentsOnAuthComplete";
                        break;
                    case (short) 4:
                        str = "AUTH_APP_ONCREATE";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 79:
                switch (s) {
                    case (short) 1:
                        str = "IMAGE_FETCH_TEST";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 83:
                switch (s) {
                    case (short) 1:
                        str = "IMAGES_FETCH_URLIMAGE_BINDMODEL_TO_RENDER";
                        break;
                    case (short) 2:
                        str = "IMAGES_FETCH_URLIMAGE_PIPELINE_EXPERIMENT";
                        break;
                    case (short) 3:
                        str = "IMAGES_FETCH_URLIMAGE_PREFETCH";
                        break;
                    case (short) 4:
                        str = "IMAGES_FETCH_URLIMAGE_NETWORK_FETCH";
                        break;
                    case (short) 5:
                        str = "IMAGES_FETCH_URLIMAGE_DOWNLOAD_AND_INSERT_INTO_CACHE";
                        break;
                    case (short) 6:
                        str = "IMAGES_FETCH_URLIMAGE_IMAGE_PROCESSING";
                        break;
                    case (short) 7:
                        str = "IMAGES_FETCH_URLIMAGE_IMAGE_PARSING";
                        break;
                    case (short) 8:
                        str = "IMAGES_FETCH_URLIMAGE_UNDERLYING_IMAGE_PARSING";
                        break;
                    case (short) 9:
                        str = "IMAGES_FETCH_URLIMAGE_BITMAP_FROM_FILE";
                        break;
                    case (short) 10:
                        str = "IMAGES_FETCH_URLIMAGE_NULL_OR_EMPTY_URI";
                        break;
                    case (short) 11:
                        str = "IMAGES_FETCH_URLIMAGE_LOG_MODE";
                        break;
                    case (short) 12:
                        str = "IMAGES_FETCH_URLIMAGE_UPDATE_IMAGE_VIEW";
                        break;
                    case (short) 13:
                        str = "IMAGES_FETCH_LOG_PARAM_NETWORK_FETCH_REQUEST_START_DELAY";
                        break;
                    case (short) 14:
                        str = "IMAGES_FETCH_LOG_PARAM_RETRY_NUMBER";
                        break;
                    case (short) 15:
                        str = "IMAGES_FETCH_LOG_PARAM_URL_BEING_FETCHED";
                        break;
                    case (short) 16:
                        str = "IMAGES_FETCH_LOG_PARAM_IMAGE_SOURCE";
                        break;
                    case (short) 17:
                        str = "IMAGES_FETCH_LOG_PARAM_IMAGE_FETCH_EXCEPTION";
                        break;
                    case (short) 18:
                        str = "IMAGES_FETCH_LOG_PARAM_OPERATION_RESULT";
                        break;
                    case (short) 19:
                        str = "IMAGES_FETCH_LOG_PARAM_STACKTRACE";
                        break;
                    case (short) 20:
                        str = "IMAGES_FETCH_LOG_PARAM_IS_SHOWN_IN_GALLERY";
                        break;
                    case (short) 21:
                        str = "IMAGES_FETCH_LOG_PARAM_IS_IMAGEVIEW_VISIBLE";
                        break;
                    case (short) 22:
                        str = "IMAGES_FETCH_LOG_PARAM_BACKGROUND_RESOURCE_ID_EXISTS";
                        break;
                    case (short) 23:
                        str = "IMAGES_FETCH_LOG_PARAM_IMAGESPEC_DRAWABLE_EXISTS";
                        break;
                    case (short) 24:
                        str = "IMAGES_FETCH_LOG_PARAM_DRAWABLE_FROM_FETCH_IMAGE_PARAMS";
                        break;
                    case (short) 25:
                        str = "IMAGES_FETCH_LOG_PARAM_IMAGESPEC_RESOURCE_ID_EXISTS";
                        break;
                    case (short) 26:
                        str = "IMAGES_FETCH_LOG_PARAM_URI_KEY";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 84:
                switch (s) {
                    case (short) 1:
                        str = "MESSENGER_SEND_MESSAGE";
                        break;
                    case (short) 2:
                        str = "MESSENGER_WARM_START";
                        break;
                    case (short) 3:
                        str = "MESSENGER_COLD_START";
                        break;
                    case (short) 4:
                        str = "MESSENGER_LUKE_WARM_START";
                        break;
                    case (short) 5:
                        str = "MESSENGER_EXTERNAL_INTENT";
                        break;
                    case (short) 6:
                        str = "MESSENGER_NAVIGATION_EVENT";
                        break;
                    case (short) 7:
                        str = "MESSENGER_NAVIGATION";
                        break;
                    case (short) 8:
                        str = "MESSENGER_THREADLIST_TO_THREADVIEW";
                        break;
                    case (short) 9:
                        str = "MESSENGER_NOTIFICATION_TO_THREAD";
                        break;
                    case (short) 10:
                        str = "MESSENGER_EXTERNAL_TO_THREADVIEW";
                        break;
                    case (short) 11:
                        str = "MESSENGER_THREADLIST_DB_FETCH";
                        break;
                    case (short) 12:
                        str = "MESSENGER_THREAD_DB_FETCH";
                        break;
                    case (short) 13:
                        str = "MESSENGER_THREAD_SERVER_FETCH";
                        break;
                    case (short) 14:
                        str = "MESSENGER_THREADLIST_SERVER_FETCH";
                        break;
                    case (short) 15:
                        str = "MESSENGER_THREADLIST_CACHE_FETCH";
                        break;
                    case (short) 16:
                        str = "MESSENGER_THREAD_CACHE_FETCH";
                        break;
                    case (short) 17:
                        str = "MESSENGER_THREAD_DATA_FETCH";
                        break;
                    case (short) 18:
                        str = "MESSENGER_THREADLIST_DATA_FETCH";
                        break;
                    case (short) 19:
                        str = "MESSENGER_FIRST_COLD_START";
                        break;
                    case (short) 20:
                        str = "MESSENGER_MAYBE_SEND_ANOTHER";
                        break;
                    case (short) 21:
                        str = "MESSENGER_THREAD_LIST_FRAGMENT_CREATE";
                        break;
                    case (short) 22:
                        str = "MESSENGER_MESSENGER_HOME_FRAGMENT_CREATE";
                        break;
                    case (short) 23:
                        str = "MESSENGER_THREAD_VIEW_FRAGMENT_CREATE";
                        break;
                    case (short) 24:
                        str = "MESSENGER_HREAD_VIEW_MESSAGES_FRAGMENT_CREATE";
                        break;
                    case (short) 25:
                        str = "MESSENGER_THREAD_VIEW_MESSAGES_FRAGMENT_CREATE";
                        break;
                    case (short) 26:
                        str = "MESSENGER_CANONICAL_PRESENCE_CHECKS";
                        break;
                    case (short) 27:
                        str = "MESSENGER_DISPLAYED_PAGE_PRESENCE_ONLINE_VALUES";
                        break;
                    case (short) 28:
                        str = "MESSENGER_CANONICAL_PRESENCE_DOUBLESTALE";
                        break;
                    case (short) 29:
                        str = "MESSENGER_CANONICAL_PRESENCE_LASTREAD_STALE_MORETHANTHRESHOLD";
                        break;
                    case (short) 30:
                        str = "MESSENGER_CANONICAL_PRESENCE_LASTREAD_STALE_LESSTHANTHRESHOLD";
                        break;
                    case (short) 31:
                        str = "MESSENGER_CANONICAL_PRESENCE_LASTSENT_STALE_LESSTHANTHRESHOLD";
                        break;
                    case (short) 32:
                        str = "MESSENGER_CANONICAL_PRESENCE_LASTSENT_STALE_MORETHANTHRESHOLD";
                        break;
                    case (short) 33:
                        str = "MESSENGER_CANONICAL_NEW_PRESENCE_PUSH";
                        break;
                    case (short) 34:
                        str = "MESSENGER_CANONICAL_NO_PRESENCE";
                        break;
                    case (short) 35:
                        str = "MESSENGER_TEST_MARKER";
                        break;
                    case (short) 36:
                        str = "MESSENGER_USER_TYPING";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 85:
                switch (s) {
                    case (short) 1:
                        str = "PRESENCE_NOW_NOW_PERF_STATUS_LIST_LOADED_FRESH";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 86:
                switch (s) {
                    case (short) 1:
                        str = "NOW_DIVEBAR_NOW_PERF_ENTER_ICON_LOADED";
                        break;
                    case (short) 2:
                        str = "NOW_DIVEBAR_NOW_PERF_STATUS_LIST_LOADED";
                        break;
                    case (short) 3:
                        str = "NOW_DIVEBAR_NOW_PERF_SUGGESTIONS_LIST_LOADED";
                        break;
                    case (short) 4:
                        str = "NOW_DIVEBAR_NOW_PERF_ICON_PICKER_LOADED";
                        break;
                    case (short) 5:
                        str = "NOW_DIVEBAR_NOW_PERF_LOCATION_PICKER_LOADED";
                        break;
                    case (short) 6:
                        str = "NOW_DIVEBAR_NOW_PERF_POST_COMPLETED";
                        break;
                    case (short) 7:
                        str = "NOW_DIVEBAR_NOW_PERF_FEED_STORY_LOADED";
                        break;
                    case (short) 8:
                        str = "NOW_DIVEBAR_NOW_PERF_ENTITY_CARD_LOADED";
                        break;
                    case (short) 9:
                        str = "NOW_DIVEBAR_NOW_PERF_STATUS_LIST_LOADED_FRESH";
                        break;
                    case (short) 10:
                        str = "NOW_DIVEBAR_NOW_PERF_SUGGESTIONS_LOAD_TIME";
                        break;
                    case (short) 11:
                        str = "NOW_DIVEBAR_NOW_PERF_PLACE_LOAD_TIME";
                        break;
                    case (short) 12:
                        str = "NOW_DIVEBAR_NOW_PERF_ICONS_LOAD_TIME";
                        break;
                    case (short) 13:
                        str = "NOW_DIVEBAR_NOW_PERF_ICON_SUGGESTIONS_LOAD_TIME";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 87:
                switch (s) {
                    case (short) 1:
                        str = "URI_MAP_URI_MAPPING";
                        break;
                    case (short) 2:
                        str = "URI_MAP_FACEWEBFALLBACK";
                        break;
                    case (short) 3:
                        str = "URI_MAP_FACEWEB_FALLBACK";
                        break;
                    case (short) 4:
                        str = "URI_MAP_GOOGLE_PLAY";
                        break;
                    case (short) 5:
                        str = "URI_MAP_FACEWEB";
                        break;
                    case (short) 6:
                        str = "URI_MAP_DEEP_LINK";
                        break;
                    case (short) 7:
                        str = "URI_MAP_URI_LOOKUP";
                        break;
                    case (short) 8:
                        str = "URI_MAP_MESSENGER";
                        break;
                    case (short) 9:
                        str = "URI_MAP_DIODE";
                        break;
                    case (short) 10:
                        str = "URI_MAP_WEBVIEW_REDIRECT";
                        break;
                    case (short) 11:
                        str = "URI_MAP_FETCH_QE_LOGIN_COMPONENT_PARSE_RESPONSE";
                        break;
                    case (short) 12:
                        str = "URI_MAP_FACEBOOK_URL";
                        break;
                    case (short) 13:
                        str = "URI_MAP_THIRD_PARTY";
                        break;
                    case (short) 14:
                        str = "URI_MAP_PREFIX_LOOKUP_FALLBACK";
                        break;
                    case (short) 15:
                        str = "URI_MAP_FACEWEB_INTENT";
                        break;
                    case (short) 16:
                        str = "URI_MAP_URI_LOOKUP_STATIC";
                        break;
                    case (short) 17:
                        str = "URI_MAP_URI_LOOKUP_FALLBACK";
                        break;
                    case (short) 18:
                        str = "URI_MAP_APP_MANAGER_INTENT";
                        break;
                    case (short) 19:
                        str = "URI_MAP_SMS_INTENT";
                        break;
                    case (short) 20:
                        str = "URI_MAP_SIGN";
                        break;
                    case (short) 21:
                        str = "URI_MAP_MULTI_BINDING";
                        break;
                    case (short) 22:
                        str = "URI_MAP_URI_LOOKUP_DFA";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 88:
                switch (s) {
                    case (short) 1:
                        str = "BACKGROUND_WORK_HANDLE_BROADCAST";
                        break;
                    case (short) 2:
                        str = "BACKGROUND_WORK_GENERIC_BACKGROUND_WORK_FROM_LOGGER";
                        break;
                    case (short) 3:
                        str = "BACKGROUND_WORK_SERVICE_ON_CREATE";
                        break;
                    case (short) 4:
                        str = "BACKGROUND_WORK_SERVICE_ON_START";
                        break;
                    case (short) 5:
                        str = "BACKGROUND_WORK_SERVICE_ON_DESTROY";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 89:
                switch (s) {
                    case (short) 1:
                        str = "MQTT_MQTT_SERVICE_START";
                        break;
                    case (short) 2:
                        str = "MQTT_MQTT_SERVICE_START_IN_MESSENGER";
                        break;
                    case (short) 3:
                        str = "MQTT_MQTT_NETWORK_RUNNABLE_CONNECT";
                        break;
                    case (short) 4:
                        str = "MQTT_MQTT_NETWORK_CONNECT";
                        break;
                    case (short) 5:
                        str = "MQTT_MQTT_MESSAGE_SENT";
                        break;
                    case (short) 6:
                        str = "MQTT_MQTT_MESSAGE_RECEIVED";
                        break;
                    case (short) 7:
                        str = "MQTT_MQTT_SERVICE_COLD_START";
                        break;
                    case (short) 8:
                        str = "MQTT_MQTT_CONNECT_RUNNABLE_DELAY";
                        break;
                    case (short) 9:
                        str = "MQTT_MQTT_CONNECTING_LATENCY";
                        break;
                    case (short) 10:
                        str = "MQTT_PRESENCE_MAP_RESET_ON_TOPIC_UNSUBSCRIBE";
                        break;
                    case (short) 11:
                        str = "MQTT_PRESENCE_TYPING";
                        break;
                    case (short) 12:
                        str = "MQTT_PRESENCE_TYPING_STALE";
                        break;
                    case (short) 13:
                        str = "MQTT_PRESENCE_MQTT_RECEIVE";
                        break;
                    case (short) 14:
                        str = "MQTT_PRESENCE_MQTT_RECEIVE_ITEM_COUNT";
                        break;
                    case (short) 15:
                        str = "MQTT_PRESENCE_MAP_RESET_ON_MQTT_DISCONNECT";
                        break;
                    case (short) 16:
                        str = "MQTT_CONNECT_MESSAGE_WITH_GET_DIFFS_POSSIBLE";
                        break;
                    case (short) 17:
                        str = "MQTT_CONNECT_MESSAGE_WITH_GET_DIFFS";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 90:
                switch (s) {
                    case (short) 1:
                        str = "AD_INTERFACES_LOAD_AD_INTERFACE";
                        break;
                    case (short) 2:
                        str = "AD_INTERFACES_CREATE";
                        break;
                    case (short) 3:
                        str = "AD_INTERFACES_PAUSE";
                        break;
                    case (short) 4:
                        str = "AD_INTERFACES_DELETE";
                        break;
                    case (short) 5:
                        str = "AD_INTERFACES_RESUME";
                        break;
                    case (short) 6:
                        str = "AD_INTERFACES_ADD_BUDGET";
                        break;
                    case (short) 7:
                        str = "AD_INTERFACES_UPDATE_AD_ACCOUNT";
                        break;
                    case (short) 8:
                        str = "AD_INTERFACES_UPDATE_BUDGET";
                        break;
                    case (short) 9:
                        str = "AD_INTERFACES_EDIT_TARGETING";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 91:
                switch (s) {
                    case (short) 1:
                        str = "HELLO_EVERYONE_TAB";
                        break;
                    case (short) 2:
                        str = "HELLO_ME_TAB";
                        break;
                    case (short) 3:
                        str = "HELLO_RECENT_TAB";
                        break;
                    case (short) 4:
                        str = "HELLO_DIALER_TAB";
                        break;
                    case (short) 5:
                        str = "HELLO_COLD_START";
                        break;
                    case (short) 6:
                        str = "HELLO_WARM_START";
                        break;
                    case (short) 7:
                        str = "HELLO_MAIN_ACTIVITY_CREATE";
                        break;
                    case (short) 8:
                        str = "HELLO_SHOW_HISTORY";
                        break;
                    case (short) 9:
                        str = "HELLO_LOCAL_SEARCH";
                        break;
                    case (short) 10:
                        str = "HELLO_SEARCH_TIME_TO_FIRST_RESULT";
                        break;
                    case (short) 11:
                        str = "HELLO_REMOTE_SEARCH";
                        break;
                    case (short) 12:
                        str = "HELLO_RECENT_TAB_SHOW_HISTORY";
                        break;
                    case (short) 13:
                        str = "HELLO_REMOTE_SEARCH_NO_LOCATION";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 92:
                switch (s) {
                    case (short) 1:
                        str = "INSTANT_ARTICLES_INSTANT_ARTICLE_LOAD";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 93:
                switch (s) {
                    case (short) 1:
                        str = "DEEP_NETWORK_DATA_GENERAL";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 94:
                switch (s) {
                    case (short) 1:
                        str = "STACKS_CAPTURE_PHOTO_TTI";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 95:
                switch (s) {
                    case (short) 1:
                        str = "DIVEBAR_DIVEBAR_SURFACE_LOAD";
                        break;
                    case (short) 2:
                        str = "DIVEBAR_DIVEBAR_SURFACE_LOAD_FRESH";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 96:
                switch (s) {
                    case (short) 1:
                        str = "OXYGENPERF_STUBLAUNCH";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 98:
                switch (s) {
                    case (short) 1:
                        str = "PHONEAPP_MARKER_SETUP_CALL_LISTENER";
                        break;
                    case (short) 2:
                        str = "PHONEAPP_MARKER_GET_TELEPHONY_MANAGER";
                        break;
                    case (short) 3:
                        str = "PHONEAPP_LOAD_SECONDARY_DEXES";
                        break;
                    case (short) 4:
                        str = "PHONEAPP_REPLACE_LINEAR_ALLOC_BUFFER";
                        break;
                    case (short) 5:
                        str = "PHONEAPP_INIT_ERROR_REPORTING";
                        break;
                    case (short) 6:
                        str = "PHONEAPP_INJECT_ME";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 99:
                switch (s) {
                    case (short) 1:
                        str = "APP_TAB_PERF_FB_FEED";
                        break;
                    case (short) 2:
                        str = "APP_TAB_PERF_FB_NOTIFICATIONS_FRIENDING_TAB";
                        break;
                    case (short) 3:
                        str = "APP_TAB_PERF_FB_FRIEND_REQUESTS_TAB";
                        break;
                    case (short) 4:
                        str = "APP_TAB_PERF_FB_MESSAGES_TAB";
                        break;
                    case (short) 5:
                        str = "APP_TAB_PERF_FB_NOTIFICATIONS_TAB";
                        break;
                    case (short) 6:
                        str = "APP_TAB_PERF_FB_BOOKMARKS";
                        break;
                    case (short) 7:
                        str = "APP_TAB_PERF_LOAD_TAB_MESSAGE";
                        break;
                    case (short) 8:
                        str = "APP_TAB_PERF_LOAD_TAB_MESSAGE_NOANIM";
                        break;
                    case (short) 9:
                        str = "APP_TAB_PERF_LOAD_NOTIFICATIONS";
                        break;
                    case (short) 10:
                        str = "APP_TAB_PERF_LOAD_TAB_NOTIFICATIONS";
                        break;
                    case (short) 11:
                        str = "APP_TAB_PERF_LOAD_TAB_NOTIFICATIONS_NOANIM";
                        break;
                    case (short) 12:
                        str = "APP_TAB_PERF_LOAD_TAB_BOOKMARK_NOANIM";
                        break;
                    case (short) 13:
                        str = "APP_TAB_PERF_LOAD_TAB_BOOKMARK";
                        break;
                    case (short) 14:
                        str = "APP_TAB_PERF_NOP_MARKER";
                        break;
                    case (short) 15:
                        str = "APP_TAB_PERF_LOAD_TAB_TODAY";
                        break;
                    case (short) 16:
                        str = "APP_TAB_PERF_LOAD_TAB_TODAY_NOANIM";
                        break;
                    case (short) 17:
                        str = "APP_TAB_PERF_LOAD_TAB_NOTIFICATIONS_FRIENDING";
                        break;
                    case (short) 18:
                        str = "APP_TAB_PERF_LOAD_TAB_NOTIFICATIONS_FRIENDING_NOANIM";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 100:
                switch (s) {
                    case (short) 1:
                        str = "EGO_LIST_VIEW_PAGINATED_GYSJ_TTI";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 102:
                switch (s) {
                    case (short) 1:
                        str = "INSTANT_SHOPPING_CATALOG_LOAD";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 104:
                switch (s) {
                    case (short) 1:
                        str = "MESSENGER_CONTENT_TRIGGERS_CONTENT_SEARCH_MEDIA_FETCH";
                        break;
                    case (short) 2:
                        str = "MESSENGER_CONTENT_TRIGGERS_CONTENT_SEARCH_INITIAL_RESULT_FETCH";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 105:
                switch (s) {
                    case (short) 1:
                        str = "APPLINKS_API_REQUEST_FAILED";
                        break;
                    case (short) 2:
                        str = "APPLINKS_KATANA_AND_WAKIZASHI_NOT_INSTALLED";
                        break;
                    case (short) 3:
                        str = "APPLINKS_URL_CLICKED";
                        break;
                    case (short) 4:
                        str = "APPLINKS_SKIPPED_BECAUSE_DATA_NOT_READY";
                        break;
                    case (short) 5:
                        str = "APPLINKS_FAILED_TO_START_INTENT";
                        break;
                    case (short) 6:
                        str = "APPLINKS_POSSIBLE_APPLINKS_URL";
                        break;
                    case (short) 7:
                        str = "APPLINKS_STARTED_INTENT_SUCCESSFULLY";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 106:
                switch (s) {
                    case (short) 1:
                        str = "DISTURBING_MEDIA_GRAPHIC_PHOTO_SHOWN_NO_WARNING";
                        break;
                    case (short) 2:
                        str = "DISTURBING_MEDIA_GRAPHIC_PHOTO_SHOWN_WITH_WARNING";
                        break;
                    case (short) 3:
                        str = "DISTURBING_MEDIA_GRAPHIC_PHOTO_WARNING_DISMISSED";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 107:
                switch (s) {
                    case (short) 1:
                        str = "PAGINATOR_NEXTCLICK";
                        break;
                    case (short) 2:
                        str = "PAGINATOR_PREVCLICK";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 108:
                switch (s) {
                    case (short) 1:
                        str = "COMMERCE_ANDROID_COMMERCE_VIEW_STOREFRONT_COLLECTION";
                        break;
                    case (short) 2:
                        str = "COMMERCE_ANDROID_COMMERCE_VIEW_STOREFRONT";
                        break;
                    case (short) 3:
                        str = "COMMERCE_ANDROID_COMMERCE_VIEW_PRODUCT_DETAILS";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 110:
                switch (s) {
                    case (short) 1:
                        str = "POWER_METRICS_PROC_CPU_USER_TIME";
                        break;
                    case (short) 2:
                        str = "POWER_METRICS_PROC_CPU_SYSTEM_TIME";
                        break;
                    case (short) 3:
                        str = "POWER_METRICS_PROC_CPU_TOTAL_TIME";
                        break;
                    case (short) 4:
                        str = "POWER_METRICS_SESSION_BATTERY_DRAIN";
                        break;
                    case (short) 5:
                        str = "POWER_METRICS_MQTT_NUM_RADIO_WAKEUPS";
                        break;
                    case (short) 6:
                        str = "POWER_METRICS_MQTT_TRAFFIC_COUNT";
                        break;
                    case (short) 7:
                        str = "POWER_METRICS_MQTT_SENT_BYTES";
                        break;
                    case (short) 8:
                        str = "POWER_METRICS_MQTT_RECEIVED_BYTES";
                        break;
                    case (short) 9:
                        str = "POWER_METRICS_LIGER_TRANSFER_DATA_SIZE";
                        break;
                    case (short) 10:
                        str = "POWER_METRICS_LIGER_LOW_POWER_TIME";
                        break;
                    case (short) 11:
                        str = "POWER_METRICS_LIGER_FULL_POWER_TIME";
                        break;
                    case (short) 12:
                        str = "POWER_METRICS_LIGER_ATTRIBUTION_DATA";
                        break;
                    case (short) 13:
                        str = "POWER_METRICS_LIGER_UP_BYTES";
                        break;
                    case (short) 14:
                        str = "POWER_METRICS_LIGER_DOWN_BYTES";
                        break;
                    case (short) 15:
                        str = "POWER_METRICS_LIGER_REQUEST_COUNT";
                        break;
                    case (short) 16:
                        str = "POWER_METRICS_LIGER_WAKEUP_COUNT";
                        break;
                    case (short) 18:
                        str = "POWER_METRICS_WAKELOCKS_HELD_TIME";
                        break;
                    case (short) 19:
                        str = "POWER_METRICS_WAKELOCKS_ACQUIRED_NUM";
                        break;
                    case (short) 20:
                        str = "POWER_METRICS_WAKELOCKS_ATTRIBUTION_DATA";
                        break;
                    case (short) 21:
                        str = "POWER_METRICS_WAKELOCKS_DISPOSED_TIME";
                        break;
                    case (short) 22:
                        str = "POWER_METRICS_LOCATION_ATTRIBUTION_DATA";
                        break;
                    case (short) 23:
                        str = "POWER_METRICS_LOCATION_COARSE_TIME_MS";
                        break;
                    case (short) 24:
                        str = "POWER_METRICS_LOCATION_MEDIUM_TIME_MS";
                        break;
                    case (short) 25:
                        str = "POWER_METRICS_LOCATION_FINE_TIME_MS";
                        break;
                    case (short) 26:
                        str = "POWER_METRICS_CHILD_CPU_USER_TIME";
                        break;
                    case (short) 27:
                        str = "POWER_METRICS_CHILD_CPU_SYSTEM_TIME";
                        break;
                    case (short) 28:
                        str = "POWER_METRICS_CHILD_CPU_TOTAL_TIME";
                        break;
                    case (short) 29:
                        str = "POWER_METRICS_CPU_ATTRIBUTION_DATA";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 111:
                switch (s) {
                    case (short) 1:
                        str = "TODAY_TODAY_TTI";
                        break;
                    case (short) 3:
                        str = "TODAY_TODAY_TAB_OPEN_TTI";
                        break;
                    case (short) 4:
                        str = "TODAY_TODAY_PULL_TO_REFRESH_TTI";
                        break;
                    case (short) 5:
                        str = "TODAY_TODAY_NOTIFICATIONS_TTI";
                        break;
                    case (short) 7:
                        str = "TODAY_TODAY_NOTIFICATIONS_PULL_TO_REFRESH_TTI";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 112:
                switch (s) {
                    case (short) 1:
                        str = "COLD_START_COLDSTART_UITHREADBLOCKEDONAPPINIT";
                        break;
                    case (short) 2:
                        str = "COLD_START_UITHREADBLOCKEDONAPPINIT";
                        break;
                    case (short) 3:
                        str = "COLD_START_GATEKEEPER_STORE_LOAD_TIME";
                        break;
                    case (short) 4:
                        str = "COLD_START_FBINJECTOR_CREATE";
                        break;
                    case (short) 5:
                        str = "COLD_START_FBINJECTOR_INJECT";
                        break;
                    case (short) 6:
                        str = "COLD_START_FBAPPIMPL_ON_CREATE";
                        break;
                    case (short) 7:
                        str = "COLD_START_CREATE_DELEGATE";
                        break;
                    case (short) 8:
                        str = "COLD_START_APP_INIT_MARKER";
                        break;
                    case (short) 9:
                        str = "COLD_START_BASE_CONTEXT_ATTACHED";
                        break;
                    case (short) 10:
                        str = "COLD_START_ENSURE_DEXS_LOADED";
                        break;
                    case (short) 11:
                        str = "COLD_START_REPLACE_LINEAR_ALLOC_BUFFER";
                        break;
                    case (short) 12:
                        str = "COLD_START_FALLBACK_REPLACE_LINEAR_ALLOC";
                        break;
                    case (short) 13:
                        str = "COLD_START_SOLOADER_INIT";
                        break;
                    case (short) 14:
                        str = "COLD_START_GET_APP_TYPE_MARKER";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 113:
                switch (s) {
                    case (short) 1:
                        str = "ENGAGEMENT_VPVS";
                        break;
                    case (short) 2:
                        str = "ENGAGEMENT_COMMENTS";
                        break;
                    case (short) 3:
                        str = "ENGAGEMENT_LIKES";
                        break;
                    case (short) 4:
                        str = "ENGAGEMENT_AD_IMPRESSIONS";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 114:
                switch (s) {
                    case (short) 2:
                        str = "FRAMES_FRAME_ASSET_DOWNLOAD";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 115:
                switch (s) {
                    case (short) 1:
                        str = "POKES_DASH_REACT_POKES_LOAD_MARK";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 118:
                switch (s) {
                    case (short) 1:
                        str = "ADS_MANAGER_HANDLE_HOST_STATE_CHANGE";
                        break;
                    case (short) 2:
                        str = "ADS_MANAGER_ANDROID_APP_RENDER";
                        break;
                    case (short) 3:
                        str = "ADS_MANAGER_COLD_START_MAIN";
                        break;
                    case (short) 4:
                        str = "ADS_MANAGER_COLD_START_LOGIN";
                        break;
                    case (short) 5:
                        str = "ADS_MANAGER_CREATION_MODAL_TTI";
                        break;
                    case (short) 6:
                        str = "ADS_MANAGER_CREATION_POST_ENGAGEMENT_TTI";
                        break;
                    case (short) 7:
                        str = "ADS_MANAGER_CREATION_LOCAL_AWARENESS_TTI";
                        break;
                    case (short) 8:
                        str = "ADS_MANAGER_CREATION_WEBSITE_CLICKS_TTI";
                        break;
                    case (short) 9:
                        str = "ADS_MANAGER_CREATION_PAGE_LIKES_TTI";
                        break;
                    case (short) 10:
                        str = "ADS_MANAGER_CREATION_VIDEO_VIEWS_TTI";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 119:
                switch (s) {
                    case (short) 1:
                        str = "REACT_NATIVE_BRIDGE_CALL_JAVA_MODULE_METHOD";
                        break;
                    case (short) 2:
                        str = "REACT_NATIVE_BRIDGE_CREATE_REACT_CONTEXT";
                        break;
                    case (short) 3:
                        str = "REACT_NATIVE_BRIDGE_PROCESS_PACKAGES";
                        break;
                    case (short) 4:
                        str = "REACT_NATIVE_BRIDGE_BUILD_NATIVE_MODULE_REGISTRY";
                        break;
                    case (short) 5:
                        str = "REACT_NATIVE_BRIDGE_BUILD_JS_MODULE_CONFIG";
                        break;
                    case (short) 6:
                        str = "REACT_NATIVE_BRIDGE_CREATE_CATALYST_INSTANCE";
                        break;
                    case (short) 7:
                        str = "REACT_NATIVE_BRIDGE_RUN_JS_BUNDLE";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 120:
                switch (s) {
                    case (short) 1:
                        str = "GROUPS_TAB_TTI";
                        break;
                    case (short) 2:
                        str = "GROUPS_TAB_GROUPS_TAB_TTI";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 121:
                switch (s) {
                    case (short) 1:
                        str = "REACT_CLASS_CREATE";
                        break;
                    case (short) 2:
                        str = "REACT_CLASS_CONSTRUCTOR";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 122:
                switch (s) {
                    case (short) 1:
                        str = "RELAY_GROUPS_INIT_FETCH_TIME";
                        break;
                    case (short) 2:
                        str = "RELAY_RELAY_PLAYGROUND_TTI";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 123:
                switch (s) {
                    case (short) 2:
                        str = "PLATFORM_PLATFORM_JSDIALOG_LAUNCH_SEQUENCE";
                        break;
                    case (short) 3:
                        str = "PLATFORM_PLATFORM_SHARE_DIALOG_LAUNCH_SEQUENCE";
                        break;
                    case (short) 4:
                        str = "PLATFORM_PLATFORM_COMPOSER_TTI";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 124:
                switch (s) {
                    case (short) 1:
                        str = "LOOM_TRACE_CREATED";
                        break;
                    case (short) 2:
                        str = "LOOM_TRACE_ABORTED";
                        break;
                    case (short) 5:
                        str = "LOOM_TRACE_UPLOAD";
                        break;
                    case (short) 6:
                        str = "loom_config";
                        break;
                    case (short) 7:
                        str = "LOOM_TRACE_FILEMAN_ERRORS";
                        break;
                    case (short) 8:
                        str = "LOOM_TRACE_FILEMAN_TRIMMED_COUNT";
                        break;
                    case (short) 9:
                        str = "LOOM_TRACE_FILEMAN_TRIMMED_AGE";
                        break;
                    case (short) 10:
                        str = "LOOM_TRACE_FILEMAN_ADDED_UPLOAD";
                        break;
                    case (short) 11:
                        str = "LOOM_DEXOPT";
                        break;
                    case (short) 13:
                        str = "LOOM_TRACE_FILEMAN_TRIMMED_LOGOUT";
                        break;
                    case (short) 14:
                        str = "LOOM_DEVICE_TYPE";
                        break;
                    case (short) 15:
                        str = "LOOM_DEVICE_BRAND";
                        break;
                    case (short) 16:
                        str = "LOOM_MANUFACTURER";
                        break;
                    case (short) 17:
                        str = "LOOM_YEAR_CLASS";
                        break;
                    case (short) 18:
                        str = "LOOM_INSTALL_LOCATION";
                        break;
                    case (short) 19:
                        str = "LOOM_OS_VER";
                        break;
                    case (short) 20:
                        str = "LOOM_CONNECTION_CLASS";
                        break;
                    case (short) 21:
                        str = "LOOM_NETWORK_TYPE";
                        break;
                    case (short) 22:
                        str = "LOOM_NETWORK_SUBTYPE";
                        break;
                    case (short) 23:
                        str = "LOOM_POWER_SAVE_MODE";
                        break;
                    case (short) 24:
                        str = "LOOM_APP_STARTED_IN_BACKGROUND";
                        break;
                    case (short) 25:
                        str = "LOOM_PERF_TEST_INFO";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 125:
                switch (s) {
                    case (short) 2:
                        str = "FBANALYTICS_ANRREPORT";
                        break;
                    case (short) 3:
                        str = "FBANALYTICS_ANRREPORT_THREADTRACES";
                        break;
                    case (short) 4:
                        str = "FBANALYTICS_ANR_DETECTED";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 129:
                switch (s) {
                    case (short) 1:
                        str = "QUICKER_EXPERIMENT_SESSIONED_STORE_INITIALIZE";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 130:
                switch (s) {
                    case (short) 1:
                        str = "REACTIONS_FETCH_REACTORS_LIST";
                        break;
                    case (short) 2:
                        str = "REACTIONS_LOAD_INPUT_DOCK";
                        break;
                    case (short) 3:
                        str = "REACTIONS_LOAD_INPUT_DOCK_WARM";
                        break;
                    case (short) 4:
                        str = "REACTIONS_LOAD_INPUT_DOCK_COLD";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 131:
                switch (s) {
                    case (short) 1:
                        str = "NOTES_NOTES_LOAD";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 133:
                switch (s) {
                    case (short) 1:
                        str = "GRAPHQL_ANDROID_CURSOR_MODELCURSOR_GET_MODEL";
                        break;
                    case (short) 2:
                        str = "GRAPHQL_ANDROID_CURSOR_MODELCURSOR_GET_MODEL_FROM_FLATTENABLE";
                        break;
                    case (short) 3:
                        str = "GRAPHQL_ANDROID_CURSOR_MODELCURSOR_GET_MODEL_RESOLVE_CONSISTENCY";
                        break;
                    case (short) 4:
                        str = "GRAPHQL_ANDROID_CURSOR_MODELCURSORLOADER_LOAD_IN_BACKGROUND";
                        break;
                    case (short) 9:
                        str = "GRAPHQL_ANDROID_CURSOR_CURSOR_DB_PUT_MULTI";
                        break;
                    case (short) 10:
                        str = "GRAPHQL_ANDROID_CURSOR_CURSOR_DB_DELETE_SESSION";
                        break;
                    case (short) 12:
                        str = "GRAPHQL_ANDROID_CURSOR_CURSOR_DB_VISIT_REFLATTEN";
                        break;
                    case (short) 13:
                        str = "GRAPHQL_ANDROID_CURSOR_CURSOR_DB_VISIT_DELTA_BUFFER";
                        break;
                    case (short) 14:
                        str = "GRAPHQL_ANDROID_CURSOR_CURSOR_DB_CTSCAN_LIKE_CONFIRMED";
                        break;
                    case (short) 15:
                        str = "GRAPHQL_ANDROID_CURSOR_CURSOR_DB_CTSCAN_LIKE_OPTIMISTIC";
                        break;
                    case (short) 16:
                        str = "GRAPHQL_ANDROID_CURSOR_VISIT_ROW";
                        break;
                    case (short) 17:
                        str = "GRAPHQL_ANDROID_CURSOR_APPLY_VISITORS";
                        break;
                    case (short) 18:
                        str = "GRAPHQL_ANDROID_CURSOR_SELECT_ROWS_WITH_TAGS";
                        break;
                    case (short) 19:
                        str = "GRAPHQL_ANDROID_CURSOR_APPLY_VISITOR";
                        break;
                    case (short) 20:
                        str = "GRAPHQL_ANDROID_CURSOR_MODELCURSORLOADER_WARM_MAPPED_FILES";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 134:
                switch (s) {
                    case (short) 1:
                        str = "CRASH_ACRA_SETUP";
                        break;
                    case (short) 2:
                        str = "CRASH_BREAKPAD_MANAGER_SETUP";
                        break;
                    case (short) 3:
                        str = "CRASH_CATCH_ME_IF_YOU_CAN_SETUP";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 136:
                switch (s) {
                    case (short) 1:
                        str = "DEXTRICKS_DEXLIBLOADER_LOAD_MAIN";
                        break;
                    case (short) 2:
                        str = "DEXTRICKS_DEXLIBLOADER_OBTAIN_RES_PROVIDER";
                        break;
                    case (short) 3:
                        str = "DEXTRICKS_DEXSTORE_LOAD_ALL";
                        break;
                    case (short) 4:
                        str = "DEXTRICKS_MANIFEST_LOAD";
                        break;
                    case (short) 5:
                        str = "DEXTRICKS_CHECK_DIRTY";
                        break;
                    case (short) 6:
                        str = "DEXTRICKS_REGEN_MISSING";
                        break;
                    case (short) 7:
                        str = "DEXTRICKS_REGEN_ALL";
                        break;
                    case (short) 8:
                        str = "DEXTRICKS_MDCL_INSTALL";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 138:
                switch (s) {
                    case (short) 1:
                        str = "COMPONENTS_CALCULATE_LAYOUT";
                        break;
                    case (short) 2:
                        str = "COMPONENTS_CREATE_LAYOUT";
                        break;
                    case (short) 3:
                        str = "COMPONENTS_CSS_LAYOUT";
                        break;
                    case (short) 4:
                        str = "COMPONENTS_COLLECT_RESULTS";
                        break;
                    case (short) 5:
                        str = "COMPONENTS_PREPARE_PART_DEFINITION";
                        break;
                    case (short) 6:
                        str = "COMPONENTS_PREPARE_MOUNT";
                        break;
                    case (short) 7:
                        str = "COMPONENTS_MOUNT";
                        break;
                    case (short) 8:
                        str = "COMPONENTS_LAYOUT_ON_MEASURE";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 139:
                switch (s) {
                    case (short) 1:
                        str = "OFFERS_LOADWALLET";
                        break;
                    case (short) 2:
                        str = "OFFERS_LOADPERMALINK";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 140:
                switch (s) {
                    case (short) 1:
                        str = "VIDEOEDITING_PERF_INIT_FROM_COMPOSER_TTI";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 141:
                switch (s) {
                    case (short) 1:
                        str = "PROC_AND_PERF_SCREEN_STATE";
                        break;
                    case (short) 3:
                        str = "PROC_AND_PERF_PROC_CPU_TIME";
                        break;
                    case (short) 4:
                        str = "PROC_AND_PERF_PROC_SW_FAULTS_MAJOR";
                        break;
                    case (short) 5:
                        str = "PROC_AND_PERF_THREAD_CPU_TIME";
                        break;
                    case (short) 6:
                        str = "PROC_AND_PERF_THREAD_SW_FAULTS_MAJOR";
                        break;
                    case (short) 7:
                        str = "PROC_AND_PERF_ATTEMPTED_CLASS_LOADS";
                        break;
                    case (short) 8:
                        str = "PROC_AND_PERF_DEX_FILE_QUERIES";
                        break;
                    case (short) 9:
                        str = "PROC_AND_PERF_PROC_THREADID";
                        break;
                    case (short) 10:
                        str = "PROC_AND_PERF_PROC_THREAD_PRI";
                        break;
                    case (short) 11:
                        str = "PROC_AND_PERF_LOADAVG_1MIN";
                        break;
                    case (short) 12:
                        str = "PROC_AND_PERF_LOADAVG_5MIN";
                        break;
                    case (short) 13:
                        str = "PROC_AND_PERF_LOADAVG_15MIN";
                        break;
                    case (short) 14:
                        str = "PROC_AND_PERF_LOADAVG_RUNNABLE_TASKS";
                        break;
                    case (short) 15:
                        str = "PROC_AND_PERF_LOADAVG_TASKS_TOTAL";
                        break;
                    case (short) 16:
                        str = "PROC_AND_PERF_LOADAVG_LAST_PID";
                        break;
                    case (short) 17:
                        str = "PROC_AND_PERF_GLOBAL_ALLOC_COUNT";
                        break;
                    case (short) 18:
                        str = "PROC_AND_PERF_GLOBAL_ALLOC_SIZE";
                        break;
                    case (short) 19:
                        str = "PROC_AND_PERF_GLOBAL_GC_INVOCATION_COUNT";
                        break;
                    case (short) 20:
                        str = "PROC_AND_PERF_PSS";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 143:
                switch (s) {
                    case (short) 1:
                        str = "CASSIE_PERFORM_QUERY";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 144:
                switch (s) {
                    case (short) 1:
                        str = "GRAPHQL_ANDROID_CONNECTION_FETCHER_CONFIGURATION_GET_REQUEST";
                        break;
                    case (short) 2:
                        str = "GRAPHQL_ANDROID_CONNECTION_FETCHER_CONFIGURATION_GET_ROWS";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 145:
                switch (s) {
                    case (short) 5:
                        str = "NOTIFICATIONS_FRIENDING_PULL_TO_REFRESH_LOAD_TIME";
                        break;
                    case (short) 9:
                        str = "NOTIFICATIONS_FRIENDING_NOTIF_LIST_LOAD_TIME_COLD";
                        break;
                    case (short) 10:
                        str = "NOTIFICATIONS_FRIENDING_NOTIF_LIST_LOAD_TIME_WARM";
                        break;
                    case (short) 11:
                        str = "NOTIFICATIONS_FRIENDING_NOTIF_SCROLL_LOAD";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 146:
                switch (s) {
                    case (short) 1:
                        str = "DISK_CONNECTION_STORE_DISKCONNECTIONSTORE_ADD_PAGE";
                        break;
                    case (short) 2:
                        str = "DISK_CONNECTION_STORE_DISKCONNECTIONSTORE_INITIALIZE";
                        break;
                    case (short) 3:
                        str = "DISK_CONNECTION_STORE_DISKCONNECTIONSTORE_REQUERY_ON_NOTIFY";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 147:
                switch (s) {
                    case (short) 1:
                        str = "PROMPTS_DATA_FETCH";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 148:
                switch (s) {
                    case (short) 1:
                        str = "LOGOUT_HANDLE_LOGOUT";
                        break;
                    case (short) 2:
                        str = "LOGOUT_BEFORE_LOGOUT";
                        break;
                    case (short) 3:
                        str = "LOGOUT_BEFORE_LOGOUT_COMPONENT";
                        break;
                    case (short) 4:
                        str = "LOGOUT_UNREGISTER_PUSH_TOKEN";
                        break;
                    case (short) 5:
                        str = "LOGOUT_UNREGISTER_PUSH_TOKEN_COMPONENT";
                        break;
                    case (short) 6:
                        str = "LOGOUT_EXPIRE_SESSION";
                        break;
                    case (short) 7:
                        str = "LOGOUT_LOGOUT_HELPER";
                        break;
                    case (short) 8:
                        str = "LOGOUT_AFTER_LOGOUT";
                        break;
                    case (short) 9:
                        str = "LOGOUT_AFTER_LOGOUT_COMPONENT";
                        break;
                    case (short) 10:
                        str = "LOGOUT_LOGOUT_COMPLETE";
                        break;
                    case (short) 11:
                        str = "LOGOUT_LOGOUT_COMPLETE_COMPONENT";
                        break;
                    case (short) 12:
                        str = "LOGOUT_CLEAR_PRIVACY_CRITICAL_KEYS";
                        break;
                    case (short) 13:
                        str = "LOGOUT_CLEAR_PRIVACY_CRITICAL_KEYS_COMPONENT";
                        break;
                    case (short) 14:
                        str = "LOGOUT_CLEAR_USER_DATA";
                        break;
                    case (short) 15:
                        str = "LOGOUT_CLEAR_USER_DATA_COMPONENT";
                        break;
                    case (short) 16:
                        str = "LOGOUT_CLEAR_USER_AUTH_DATA";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 149:
                switch (s) {
                    case (short) 1:
                        str = "GRAPHQL_ANROID_CONSISTENCY_OPTIMISTIC_OPERATION";
                        break;
                    case (short) 2:
                        str = "GRAPHQL_ANROID_CONSISTENCY_CONFIRMED_OPERATION";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 151:
                switch (s) {
                    case (short) 1:
                        str = "PAGES_LWI_PERF_FETCH_PROMOTION_FROM_SERVER";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 152:
                switch (s) {
                    case (short) 1:
                        str = "PMA_PERF_LOAD_THREADS_LIST";
                        break;
                    case (short) 3:
                        str = "PMA_PERF_PMA_OVERVIEW_LOAD";
                        break;
                    case (short) 4:
                        str = "PMA_PERF_PAGE_SWITCH_TTI";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 153:
                switch (s) {
                    case (short) 1:
                        str = "SECURITY_USE_STORAGE_KEY_LOGIN";
                        break;
                    case (short) 2:
                        str = "SECURITY_USE_STORAGE_KEY_LOGOUT";
                        break;
                    case (short) 4:
                        str = "SECURITY_USER_STORAGE_KEY_UNAVAILABLE_ENCRYPT";
                        break;
                    case (short) 5:
                        str = "SECURITY_USER_STORAGE_KEY_UNAVAILABLE_DECRYPT";
                        break;
                    case (short) 6:
                        str = "SECURITY_USE_STORAGE_KEY_SET";
                        break;
                    case (short) 7:
                        str = "SECURITY_USER_STORAGE_KEY_LOGIN_CRYPTO_UNAVAILABLE";
                        break;
                    case (short) 8:
                        str = "SECURITY_USER_STORAGE_KEY_LOGIN_INVALID_KEY";
                        break;
                    case (short) 9:
                        str = "SECURITY_USER_STORAGE_KEY_LOGIN_MISSING_KEY";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 154:
                switch (s) {
                    case (short) 1:
                        str = "PAGES_PLATFORM_TIME_TO_BOOTSTRAP";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 156:
                switch (s) {
                    case (short) 1:
                        str = "VIDEO_HOME_VIDEO_HOME_TTI";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            case (short) 157:
                switch (s) {
                    case (short) 1:
                        str = "ISNEWCONNECTION";
                        break;
                    case (short) 2:
                        str = "LIGER_NETWORK_STATS_REQUEST_HEADER_BYTES";
                        break;
                    case (short) 3:
                        str = "LIGER_NETWORK_STATS_REQUEST_BODY_BYTES";
                        break;
                    case (short) 4:
                        str = "LIGER_NETWORK_STATS_RESPONSE_HEADER_BYTES";
                        break;
                    case (short) 5:
                        str = "LIGER_NETWORK_STATS_RESPONSE_BODY_BYTES";
                        break;
                    case (short) 6:
                        str = "LIGER_NETWORK_STATS_DNS_LATENCY";
                        break;
                    case (short) 7:
                        str = "LIGER_NETWORK_STATS_TCP_LATENCY";
                        break;
                    case (short) 8:
                        str = "LIGER_NETWORK_STATS_TLS_LATENCY";
                        break;
                    case (short) 9:
                        str = "LIGER_NETWORK_STATS_RESPOSNE_BODY_BYTES_TIME";
                        break;
                    default:
                        str = "UNDEFINED_QPL_EVENT";
                        break;
                }
                return str;
            default:
                return "UNDEFINED_QPL_MODULE";
        }
    }
}
