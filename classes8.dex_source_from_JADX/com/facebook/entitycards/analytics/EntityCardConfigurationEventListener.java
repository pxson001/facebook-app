package com.facebook.entitycards.analytics;

/* compiled from: initial_network_load_time */
public interface EntityCardConfigurationEventListener {

    /* compiled from: initial_network_load_time */
    public enum CardConfigDataType {
        PREVIEW,
        FINAL
    }

    /* compiled from: initial_network_load_time */
    public enum CardSurfaceConfigEvent {
        BEGIN_CARD_CONFIG("ec_config_begin"),
        CARD_RECYCLED("ec_card_recycled"),
        COVER_PHOTO("ec_config_cover_photo"),
        PROFILE_PICTURE("ec_config_profile_picture"),
        ACTION_BAR("ec_config_action_bar"),
        CONTEXT_ROWS("ec_config_context_rows");
        
        public final String name;

        private CardSurfaceConfigEvent(String str) {
            this.name = str;
        }
    }

    /* compiled from: initial_network_load_time */
    public enum EventStatus {
        SUCCEEDED,
        FAILED
    }

    void mo769a(CardConfigDataType cardConfigDataType);

    void mo770a(CardSurfaceConfigEvent cardSurfaceConfigEvent, EventStatus eventStatus, String str);
}
