package com.facebook.crowdsourcing.logging;

/* compiled from: opt_out/ */
public enum CrowdEndpoint {
    FEATHER("android_feather"),
    MARK_DUPLICATES("android_mark_duplicates"),
    PLACE_CONTEXT_ROW_PLACE_QUESTION("page_context_row_place_question"),
    PLACE_CREATION("android_place_creation"),
    PLACE_CREATION_V2("android_place_creation_v2"),
    PLACE_CREATION_V2_WITH_FORM("android_place_creation_v2_with_form"),
    PLACE_PICKER_REPORT_DIALOG("android_place_picker_report_dialog"),
    POST_ACTION_VOTE("android_post_action_vote"),
    SUGGEST_EDITS("android_suggest_edits"),
    SUGGEST_EDITS_V2("android_suggest_edits_v2"),
    SUGGEST_PROFILE_PICTURE("android_suggest_profile_picture"),
    SUGGESTIFIER_VOTING("android_suggestifier_voting"),
    TIMELINE_REPORT_DIALOG("android_timeline_report_dialog"),
    PHONE_APP("android_phone_app");
    
    private String mEndpoint;

    private CrowdEndpoint(String str) {
        this.mEndpoint = str;
    }

    public final String getFullName() {
        return this.mEndpoint;
    }
}
