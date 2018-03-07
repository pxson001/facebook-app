package com.facebook.common.negativefeedback;

/* compiled from: rid */
public enum NegativeFeedbackExperienceLocation {
    MESSENGER("messenger"),
    MESSENGER_CONTACT_DETAILS("messenger_contact_details"),
    MESSENGER_THREAD_ACTION_PANEL("messenger_thread_action_panel"),
    NEWSFEED("feed"),
    TIMELINE("profile"),
    TIMELINE_SELF("profile_self"),
    TIMELINE_SOMEONE_ELSE("profile_someone_else"),
    PAGE_REVIEW("page_review"),
    PAGE_TIMELINE("page"),
    PERMALINK("permalink"),
    PHOTO_VIEWER("photo_viewer"),
    VIDEO_CHANNEL("video_channel"),
    FULLSCREEN_VIDEO_PLAYER("fullscreen_video_player"),
    GROUP("group"),
    EVENT("event"),
    APP_INVITES_FEED("app_invites_feed"),
    SEARCH_RESULTS("search_results"),
    THROWBACK("throwback"),
    UNKNOWN("unknown"),
    A_PLACE_FOR("a_place_for"),
    FUNDRAISER_PERSON_TO_CHARITY("fundraiser_person_to_charity");
    
    private final String location;

    private NegativeFeedbackExperienceLocation(String str) {
        this.location = str;
    }

    public final String stringValueOf() {
        return this.location;
    }
}
