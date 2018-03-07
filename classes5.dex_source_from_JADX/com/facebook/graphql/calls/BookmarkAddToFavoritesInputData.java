package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: region_key */
public final class BookmarkAddToFavoritesInputData extends GraphQlMutationCallInput {

    /* compiled from: region_key */
    public enum Source implements JsonSerializable {
        OTHER("other"),
        WILDE_PROFILE_MORE("wilde_profile_more"),
        FB4A_PROFILE_MORE("fb4a_profile_more"),
        FINCH_MORE("finch_more"),
        PAGE_HEADER("page_header"),
        PAGE_SETTING("page_setting"),
        PAGE_SETTING_MOBILE("page_setting_mobile"),
        PAGE_AYMT_MEGAPHONE("page_aymt_megaphone"),
        UNIT_TEST("unit_test"),
        WILDE_GROUPS_TAB("wilde_groups_tab"),
        WILDE_GROUPS_TAB_MENU("wilde_groups_tab_menu"),
        WILDE_GROUP_PROFILE_MORE("wilde_group_profile_more"),
        WILDE_GROUP_PROFILE_UPSELL("wilde_group_profile_upsell"),
        FB4A_GROUPS_TAB("fb4a_groups_tab"),
        FB4A_GROUPS_TAB_MENU("fb4a_groups_tab_menu"),
        FB4A_GROUP_PROFILE_MORE("fb4a_group_profile_more"),
        FB4A_GROUP_PROFILE_UPSELL("fb4a_group_profile_upsell"),
        TREEHOUSE_IOS_GROUPS_TAB("treehouse_ios_groups_tab"),
        TREEHOUSE_IOS_GROUPS_TAB_MENU("treehouse_ios_groups_tab_menu"),
        TREEHOUSE_GROUP_PROFILE_MORE("treehouse_group_profile_more"),
        TREEHOUSE_ANDROID_GROUPS_TAB("treehouse_android_groups_tab"),
        TREEHOUSE_ANDROID_GROUPS_TAB_MENU("treehouse_android_groups_tab_menu"),
        TREEHOUSE_ANDROID_GROUP_PROFILE_MORE("treehouse_android_group_profile_more"),
        KOSHIEN_LANDING_PAGE("koshien_landing_page"),
        PAGE_CREATION("page_creation");
        
        protected final String serverValue;

        private Source(String str) {
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

    public final BookmarkAddToFavoritesInputData m4313a(String str) {
        a("actor_id", str);
        return this;
    }

    public final BookmarkAddToFavoritesInputData m4314b(String str) {
        a("favorited_bookmark_id", str);
        return this;
    }

    public final BookmarkAddToFavoritesInputData m4312a(Source source) {
        a("source", source);
        return this;
    }
}
