package com.facebook.bugreporter;

/* compiled from: android.permission.BATTERY_STATS */
public enum BugReportSource {
    DEFAULT("FBBugReportSourceDefault"),
    FEED_STORY("FBBugReportSourceFeedStory"),
    POST_FAILURE("FBBugReportSourcePostFailure"),
    RAGE_SHAKE("FBBugReportSourceRageShake"),
    SETTINGS_REPORT_PROBLEM("FBBugReportSourceSettingsReportProblem"),
    MESSENGER_SYSTEM_MENU("MessengerSystemMenu"),
    MESSENGER_SETTINGS("MessengerSettings"),
    MESSENGER_THREAD_SETTINGS("MessengerThreadSettings"),
    MESSENGER_FAILED_TO_SEND_MESSAGE("MessengerFailedToSendMessage"),
    MESSENGER_LOCATION_SHARING("MessengerLocationSharing");
    
    private final String name;

    private BugReportSource(String str) {
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }
}
