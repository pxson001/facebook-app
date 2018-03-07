package com.facebook.entitycards.analytics;

/* compiled from: initial_card */
public class EntityCardsAnalytics {

    /* compiled from: initial_card */
    public enum DismissalReason {
        SWIPE_DOWN("swipe_down"),
        BACK_BUTTON_TAP("back_button_tap"),
        USER_BLOCKED("user_blocked"),
        PAGER_TAP("pager_tap");
        
        public final String name;

        private DismissalReason(String str) {
            this.name = str;
        }
    }

    /* compiled from: initial_card */
    public enum Events {
        ENTITY_CARDS_IMPRESSION("ec_impression"),
        TAP("tap"),
        ENTITY_CARDS_DISPLAYED("ec_entity_cards_displayed"),
        ENTITY_CARDS_DISMISSED("ec_entity_cards_dismissed"),
        ENTITY_CARDS_PAGE_DOWNLOAD("ec_cards_page_download"),
        ENTITY_CARDS_NAVIGATED_TO_ENTITY("ec_navigated_to_entity");
        
        public final String name;

        private Events(String str) {
            this.name = str;
        }
    }

    /* compiled from: initial_card */
    public enum TapSurfaces {
        HEADER("header"),
        ACTION_BAR("action_bar"),
        CONTEXT_ITEM("context_item"),
        DEFAULT_ACTION("default_action"),
        UNKNOWN("unknown");
        
        public final String name;

        private TapSurfaces(String str) {
            this.name = str;
        }
    }
}
