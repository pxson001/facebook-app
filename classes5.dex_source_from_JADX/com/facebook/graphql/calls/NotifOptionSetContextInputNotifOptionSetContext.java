package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.util.List;

/* compiled from: product_item_attachment */
public final class NotifOptionSetContextInputNotifOptionSetContext extends GraphQlCallInput {

    /* compiled from: product_item_attachment */
    public enum ClientActionTypes implements JsonSerializable {
        HIDE("HIDE"),
        UNSUB("UNSUB"),
        MODSUB("MODSUB"),
        SHOW_MORE("SHOW_MORE"),
        MARK_AS_READ("MARK_AS_READ"),
        MARK_AS_UNREAD("MARK_AS_UNREAD"),
        SETTINGS("SETTINGS"),
        OPEN_SUB_PAGE("OPEN_SUB_PAGE"),
        OPEN_ACTION_SHEET("OPEN_ACTION_SHEET"),
        SERVER_ACTION("SERVER_ACTION"),
        TURN_OFF("TURN_OFF"),
        REPORT_BUG("REPORT_BUG"),
        OPEN_GROUP_SETTING("OPEN_GROUP_SETTING"),
        OPEN_EVENT_SETTING("OPEN_EVENT_SETTING"),
        OPEN_GROUP_DASHBOARD("OPEN_GROUP_DASHBOARD"),
        OPEN_EVENT_DASHBOARD("OPEN_EVENT_DASHBOARD"),
        OPEN_DEVICE_PUSH_SETTINGS("OPEN_DEVICE_PUSH_SETTINGS"),
        OPEN_SOUNDS_SETTING("OPEN_SOUNDS_SETTING");
        
        protected final String serverValue;

        private ClientActionTypes(String str) {
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

    /* compiled from: product_item_attachment */
    public final class SupportedDisplayStyles extends GraphQlCallInput {

        /* compiled from: product_item_attachment */
        public enum OptionDisplayStyles implements JsonSerializable {
            BASIC_MENU("BASIC_MENU"),
            SWIPE_MENU_OPTION("SWIPE_MENU_OPTION"),
            POPUP_MENU_OPTION("POPUP_MENU_OPTION"),
            SLIDE_MENU_OPTION("SLIDE_MENU_OPTION"),
            CHEVRON_MENU_OPTION("CHEVRON_MENU_OPTION"),
            PROFILE_IMAGE_OPTION("PROFILE_IMAGE_OPTION"),
            ACTION_SHEET_OPTION("ACTION_SHEET_OPTION"),
            PROFILE_IMAGE_WITH_CHECK_OPTION("PROFILE_IMAGE_WITH_CHECK_OPTION"),
            H_SCROLL_PROFILE("H_SCROLL_PROFILE"),
            SELECTOR_MENU_OPTION("SELECTOR_MENU_OPTION"),
            RADIO_BUTTON("RADIO_BUTTON"),
            SQUARE_RADIO_BUTTON("SQUARE_RADIO_BUTTON"),
            PLAIN_CHECK("PLAIN_CHECK"),
            BLUE_CIRCLE_BUTTON("BLUE_CIRCLE_BUTTON"),
            TOGGLE_ON("TOGGLE_ON"),
            TOGGLE_OFF("TOGGLE_OFF"),
            WASH_TEXTS("WASH_TEXTS"),
            TEXT_WITH_BUTTON("TEXT_WITH_BUTTON");
            
            protected final String serverValue;

            private OptionDisplayStyles(String str) {
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

        /* compiled from: product_item_attachment */
        public enum OptionSetDisplayStyle implements JsonSerializable {
            SWIPE_MENU("SWIPE_MENU"),
            LONGPRESS_MENU("LONGPRESS_MENU"),
            FLYOUT_MENU("FLYOUT_MENU"),
            CHEVRON_MENU("CHEVRON_MENU"),
            RICH_NOTIF_ACTIONS("RICH_NOTIF_ACTIONS"),
            ACTION_SHEET_MENU("ACTION_SHEET_MENU"),
            SETTING_PAGE_SECTION("SETTING_PAGE_SECTION"),
            MENU_SECTION_WITH_INDEPENDENT_ROWS("MENU_SECTION_WITH_INDEPENDENT_ROWS"),
            SINGLE_SELECTOR("SINGLE_SELECTOR"),
            MULTI_SELECTOR("MULTI_SELECTOR"),
            H_SCROLL("H_SCROLL"),
            TOGGLE("TOGGLE"),
            MENU_SECTION_WITH_REMOVABLE_ROWS("MENU_SECTION_WITH_REMOVABLE_ROWS");
            
            protected final String serverValue;

            private OptionSetDisplayStyle(String str) {
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

        public final SupportedDisplayStyles m4464a(OptionSetDisplayStyle optionSetDisplayStyle) {
            a("option_set_display_style", optionSetDisplayStyle);
            return this;
        }

        public final SupportedDisplayStyles m4465a(List<OptionDisplayStyles> list) {
            a("option_display_styles", list);
            return this;
        }
    }
}
