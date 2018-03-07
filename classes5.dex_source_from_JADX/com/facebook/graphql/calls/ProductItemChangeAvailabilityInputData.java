package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: previous_visibility */
public final class ProductItemChangeAvailabilityInputData extends GraphQlMutationCallInput {

    /* compiled from: previous_visibility */
    public enum ProductAvailability implements JsonSerializable {
        IN_STOCK("IN_STOCK"),
        OUT_OF_STOCK("OUT_OF_STOCK");
        
        protected final String serverValue;

        private ProductAvailability(String str) {
            this.serverValue = str;
        }

        public final String toString() {
            return this.serverValue;
        }

        public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.b(this.serverValue);
        }

        public final void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
            throw new UnsupportedOperationException("Serialization infrastructure does not support type serialization.");
        }
    }

    /* compiled from: previous_visibility */
    public enum Surface implements JsonSerializable {
        POPOVER_PERMALINK("POPOVER_PERMALINK"),
        EMAIL("EMAIL"),
        GROUP_MEGAPHONE("GROUP_MEGAPHONE"),
        QUICK_PROMOTION("QUICK_PROMOTION"),
        GROUP_MODAL_NUX("GROUP_MODAL_NUX"),
        GROUP_MALL_YOUR_RECENT_ACTIVITY("GROUP_MALL_YOUR_RECENT_ACTIVITY"),
        GROUP_MALL_YOUR_RECENT_ACTIVITY_RHC("GROUP_MALL_YOUR_RECENT_ACTIVITY_RHC"),
        GROUP_MALL_YOUR_RECENT_ACTIVITY_FILTER("GROUP_MALL_YOUR_RECENT_ACTIVITY_FILTER"),
        YOUR_POSTS("YOUR_POSTS"),
        YOUR_POSTS_RHC("YOUR_POSTS_RHC"),
        YOUR_POSTS_PAGE("YOUR_POSTS_PAGE"),
        YOUR_POSTS_PAGE_OTHER_GROUPS("YOUR_POSTS_PAGE_OTHER_GROUPS"),
        FOR_SALE_HOVERCARD("FOR_SALE_HOVERCARD"),
        FOR_SALE_CONTEXT_ITEM("FOR_SALE_CONTEXT_ITEM"),
        RECOMMENDATION_BADGE("RECOMMENDATION_BADGE"),
        TARGET_USER_FOR_SALE_POSTS("TARGET_USER_FOR_SALE_POSTS"),
        SELLER_PROFILE("SELLER_PROFILE"),
        GROUP_POST_CHEVRON("GROUP_POST_CHEVRON"),
        FEED_POST_CHEVRON("FEED_POST_CHEVRON"),
        ADMIN_SETTING_PAGE("ADMIN_SETTING_PAGE"),
        SCRIPTS("SCRIPTS"),
        CRT_SCRIPTS("CRT_SCRIPTS"),
        TESTS("TESTS"),
        DELETE_INTERCEPT("DELETE_INTERCEPT"),
        INTERN_CONSOLE("INTERN_CONSOLE"),
        GROUP_MALL("GROUP_MALL"),
        BROWSE_CATEGORIES("BROWSE_CATEGORIES"),
        CATEGORY_MALL("CATEGORY_MALL"),
        GROUP_SEARCH("GROUP_SEARCH"),
        GROUP_MALL_SELL_COMPOSER("GROUP_MALL_SELL_COMPOSER"),
        FORSALE_ISLAND("FORSALE_ISLAND"),
        CROSS_GROUP_FORSALE_ISLAND("CROSS_GROUP_FORSALE_ISLAND"),
        PRODUCT_MALL("PRODUCT_MALL"),
        MESSAGE_PERMALINK("MESSAGE_PERMALINK"),
        FEED_STORY("FEED_STORY"),
        GROUP_COMPOSER("GROUP_COMPOSER"),
        UNKNOWN("UNKNOWN"),
        DIRECT_LINK("DIRECT_LINK"),
        GROUP_MALL_HEADER_NAV("GROUP_MALL_HEADER_NAV"),
        GROUP_MALL_ISLAND_NAV("GROUP_MALL_ISLAND_NAV"),
        YOUR_POSTS_ISLAND_NAV("YOUR_POSTS_ISLAND_NAV"),
        MARK_AS_SOLD_REMINDER("MARK_AS_SOLD_REMINDER"),
        RIGHT_HAND_COLUMN_CATEGORY_SHOWALL("RIGHT_HAND_COLUMN_CATEGORY_SHOWALL"),
        YOUR_POSTS_UNSOLD_NOTIFICATION("YOUR_POSTS_UNSOLD_NOTIFICATION"),
        RIGHT_HAND_COLUMN("RIGHT_HAND_COLUMN"),
        SAVED_SEARCH_NOTIF("SAVED_SEARCH_NOTIF"),
        CLEANER("CLEANER"),
        PURPOSE_TRIGGER("PURPOSE_TRIGGER"),
        PURPOSE_BACKFILL("PURPOSE_BACKFILL"),
        HIGH_CONFIDENCE_SALE_SCRIPT("HIGH_CONFIDENCE_SALE_SCRIPT"),
        EDIT_GROUP_SETTINGS_DESKTOP("EDIT_GROUP_SETTINGS_DESKTOP"),
        EDIT_GROUP_SETTINGS_MOBILE("EDIT_GROUP_SETTINGS_MOBILE"),
        MAYBE_FOR_SALE_SCRIPT("MAYBE_FOR_SALE_SCRIPT"),
        LANDING_PAGE_BOOKMARK("LANDING_PAGE_BOOKMARK"),
        LANDING_PAGE_SUGGESTED_GROUPS("LANDING_PAGE_SUGGESTED_GROUPS"),
        LANDING_PAGE_SUGGESTED_GROUPS_CARD("LANDING_PAGE_SUGGESTED_GROUPS_CARD"),
        LANDING_PAGE_SUGGESTED_GROUPS_MAP("LANDING_PAGE_SUGGESTED_GROUPS_MAP"),
        LANDING_PAGE_YOUR_POSTS("LANDING_PAGE_YOUR_POSTS"),
        LANDING_PAGE_YOUR_GROUPS("LANDING_PAGE_YOUR_GROUPS"),
        LANDING_PAGE_YOUR_SALES_RHC("LANDING_PAGE_YOUR_SALES_RHC"),
        LANDING_PAGE_AD("LANDING_PAGE_AD"),
        LANDING_PAGE_MOBILE("LANDING_PAGE_MOBILE"),
        EGO_SGNY("EGO_SGNY"),
        GROUPS_BROWSER("GROUPS_BROWSER"),
        LOW_QUALITY_GROUP_SELL_CLEAN_SCRIPT("LOW_QUALITY_GROUP_SELL_CLEAN_SCRIPT"),
        GROUPS_YOU_SHOULD_JOIN("GROUPS_YOU_SHOULD_JOIN"),
        PRODUCT_DETAIL("PRODUCT_DETAIL"),
        MARKETPLACE_YOUR_POSTS("MARKETPLACE_YOUR_POSTS"),
        MARKETPLACE_UPSELL_DIALOG("MARKETPLACE_UPSELL_DIALOG"),
        AUTO_STRUCTURE_SCRIPT("AUTO_STRUCTURE_SCRIPT"),
        MARKETPLACE_GALLERY("MARKETPLACE_GALLERY"),
        MARKETPLACE_GYSJ("MARKETPLACE_GYSJ"),
        CROSS_GROUP_FEED("CROSS_GROUP_FEED"),
        BUY_AND_SELL_SEARCH_RESULTS("BUY_AND_SELL_SEARCH_RESULTS"),
        XGROUP_ITEMS_FOR_SALE_NOTIFICATION("XGROUP_ITEMS_FOR_SALE_NOTIFICATION"),
        GROUP_COMMERCE_RN_PDP("GROUP_COMMERCE_RN_PDP");
        
        protected final String serverValue;

        private Surface(String str) {
            this.serverValue = str;
        }

        public final String toString() {
            return this.serverValue;
        }

        public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.b(this.serverValue);
        }

        public final void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
            throw new UnsupportedOperationException("Serialization infrastructure does not support type serialization.");
        }
    }
}
