package com.facebook.bugreporter;

/* compiled from: android.remoteinput.results */
public enum BugReportCategory {
    NULL_CATEGORY("Not Inspected"),
    RECENTS_TAB("Recents Tab"),
    CALL_TAB("Call Tab"),
    GROUPS_TAB("Groups Tab"),
    PEOPLE_TAB("People Tab"),
    SETTINGS_TAB("Settings Tab"),
    COMPOSE_MESSAGE_FLOW("Compose Message Flow"),
    CREATE_GROUP_FLOW("Create Group Flow"),
    INVITE_FLOW("Invite Flow"),
    QUICK_CAM("QuickCam"),
    MEDIA_TRAY("Media Tray"),
    MEDIA_PICKER("Media Picker"),
    STICKERS("Stickers"),
    VOICE_CLIPS("Voice Clips"),
    P2P("P2P"),
    PLATFORM("Platform"),
    LIKE_BUTTON("Like Button"),
    VOIP_CALL("VoIP Call"),
    VIDEO_CALL("Video Call"),
    GROUP_CALL("Group Call"),
    THREAD_SETTINGS("Thread Settings"),
    MUTE_ACTION("Mute Action"),
    ADD_CONTACT("Add Contact"),
    SEARCH("Search");
    
    private final String mCategoryName;

    private BugReportCategory(String str) {
        this.mCategoryName = str;
    }

    public final String toString() {
        return this.mCategoryName;
    }
}
