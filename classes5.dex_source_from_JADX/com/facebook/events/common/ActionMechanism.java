package com.facebook.events.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: ZZ) */
public enum ActionMechanism implements Parcelable {
    DASHBOARD_HEADER("dashboard_header"),
    DASHBOARD_FAB("dashboard_fab"),
    DASHBOARD_ROW_INLINE_ACTIONS("inline_actions"),
    DASHBOARD_ROW_GUEST_STATUS("guest_status"),
    PERMALINK_ACTION_BAR("permalink_action_bar"),
    PERMALINK_DRAFT_BANNER("draft_banner"),
    PERMALINK_RELATIONSHIP_BAR("permalink_relationship_bar"),
    PAGE_UPCOMING_EVENTS_CARD("upcoming_card"),
    PAGE_EVENT_LIST_SUBSCRIBE_BUTTON("page_events_list_subscribe_button"),
    PAGES_SURFACE_EVENTS_TAB("page_surface_events_tab"),
    PAGES_ACTION_BAR("page_action_bar"),
    DASHBOARD_SUGGESTIONS_CARD("suggestions_card"),
    DASHBOARD_SUBSCRIPTIONS_CARD("subscriptions_card"),
    PERMALINK_EVENTS_CAROUSEL("events_carousel"),
    EVENTS_LIST("events_list"),
    EVENT_CREATE("event_create"),
    GROUP_PERMALINK_ACTIONS("group_permalink_actions"),
    SEARCH_RESULT_ACTIONS("search_result_actions"),
    EVENT_CHAINING("event_chaining"),
    FEED_ATTACHMENT("feed_attachment"),
    PLACE_TIPS("place_tips"),
    REACTION_ATTACHMENT("reaction_attachment"),
    PERMALINK("permalink"),
    GUEST_LIST_EDIT_GUEST_RSVP("guest_list_edit_guest_rsvp"),
    HEADER("header"),
    CHECKIN_COMPOSER("checkin_composer"),
    BUY_TICKETS_CTA("buy_tickets_cta"),
    PERMALINK_CONTEXT_ROW("permalink_context_row"),
    EVENT_TIPS("event_tips"),
    REACTION_EVENT_ROW_COMPONENT("reaction_event_row_component"),
    BUY_TICKETS_FLOW("buy_tickets_flow"),
    EVENT_PROMPT_ACTION_BUTTON("event_prompt_action_button"),
    CANCEL_EVENT_FLOW("cancel_event_flow"),
    PAGE_CREATE_DIALOG("page_create_dialog"),
    USER_CREATE_DIALOG("user_create_dialog");
    
    public static final Creator<ActionMechanism> CREATOR = null;
    private String mName;

    /* compiled from: ZZ) */
    final class C11191 implements Creator<ActionMechanism> {
        C11191() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return ActionMechanism.valueOf(parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new ActionMechanism[i];
        }
    }

    static {
        CREATOR = new C11191();
    }

    private ActionMechanism(String str) {
        this.mName = str;
    }

    public final String toString() {
        return this.mName;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name());
    }
}
