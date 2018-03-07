package com.facebook.commerce.core.analytics;

/* compiled from: privacy_options_client_cached_no_privacy_json */
public class CommerceAnalytics {

    /* compiled from: privacy_options_client_cached_no_privacy_json */
    public enum CommerceAnalyticsKey {
        COLLECTION_ID("collection_id"),
        CONTAINER_TYPE("container_type"),
        EVENT("event"),
        EVENTS("events"),
        LOGGER_CREATION_TIME("logger_creation_time"),
        LOGGING_START_TIME("logging_start_time"),
        LOGGING_STOP_TIME("logging_stop_time"),
        LOGGING_EVENT_TIME("logging_event_time"),
        PRODUCT_ID("product_id"),
        PAGE_ID("page_id"),
        REF_ID("ref_id"),
        REF_TYPE("ref_type"),
        SECTION_TYPE("section_type"),
        SESSION_ID("session_id");
        
        public final String value;

        private CommerceAnalyticsKey(String str) {
            this.value = str;
        }
    }

    /* compiled from: privacy_options_client_cached_no_privacy_json */
    public enum CommerceEvent {
        PRODUCT_ITEM_CLICK("commerce_collection_item_click"),
        COLLECTION_LOAD_TIME("commerce_collection_load_time"),
        VIEW_PAGE_STORE_ENTRYPOINT("commerce_view_page_store_entry_point"),
        VIEW_PRODUCT_STOREFRONT("commerce_view_product_store_front"),
        VIEW_PRODUCT_COLLECTION("commerce_view_product_collection"),
        VIEW_PRODUCT_DETAILS("commerce_view_product_details");
        
        public final String value;

        private CommerceEvent(String str) {
            this.value = str;
        }
    }

    /* compiled from: privacy_options_client_cached_no_privacy_json */
    public enum CommerceModule {
        COMMERCE_DETAILS_PAGE("commerce_details_page"),
        COMMERCE_STOREFRONT("commerce_store_front"),
        COMMERCE_NEWS_FEED("commerce_news_feed");
        
        public final String value;

        private CommerceModule(String str) {
            this.value = str;
        }
    }

    /* compiled from: privacy_options_client_cached_no_privacy_json */
    public enum CommerceProductSectionType {
        PAGE_STOREFRONT_ENTRY_GRID("page_storefront_entry_grid"),
        COLLECTION_GRID("collection_grid"),
        STOREFRONT_BANNER("storefront_banner"),
        STOREFRONT_COLLECTION("storefront_collection"),
        STOREFRONT_COLLECTION_HEADER("storefront_collection_header"),
        PRODUCT_DETAILS_PAGE("product_details_checkout_button");
        
        public final String value;

        private CommerceProductSectionType(String str) {
            this.value = str;
        }
    }

    /* compiled from: privacy_options_client_cached_no_privacy_json */
    public enum CommerceRefType {
        SHARE("share"),
        PAGE("page"),
        SHOPPING("shopping"),
        BOOKMARKS("bookmarks"),
        GLOBAL_SEARCH("global_search"),
        UNKNOWN("unknown");
        
        public final String value;

        private CommerceRefType(String str) {
            this.value = str;
        }
    }

    /* compiled from: privacy_options_client_cached_no_privacy_json */
    public enum CommerceSubEvent {
        DID_OPEN_STOREFRONT_FROM_PAGE_HEADER("did_open_store_front_from_page_header"),
        EXIT_COLLECTION_OPENED("exit_collection_opened"),
        RECOMMENDED_PRODUCT_OPENED("recommended_product_opened"),
        MESSAGE_TO_BUY_CLICK("message_to_buy_tapped");
        
        public final String value;

        private CommerceSubEvent(String str) {
            this.value = str;
        }
    }

    public static int m10500a(CommerceRefType commerceRefType) {
        switch (commerceRefType) {
            case SHARE:
                return 1;
            case PAGE:
                return 6;
            case SHOPPING:
                return 12;
            case BOOKMARKS:
                return 32;
            case GLOBAL_SEARCH:
                return 34;
            default:
                return 0;
        }
    }
}
