package com.facebook.timeline.profilevideo.logging;

/* compiled from: mPlaceTipWelcomeHeader */
public enum ProfileVideoEvent {
    CALL_TO_ACTION_BUTTON_IMPRESSION("profile_video_android_call_to_action_button_impression"),
    CALL_TO_ACTION_BUTTON_CLICKED("profile_video_android_call_to_action_button_clicked"),
    NUX_MAIN_BUTTON_CLICKED("profile_video_android_nux_main_button_clicked"),
    VIDEO_CAMERA_OPEN("profile_video_android_video_camera_open"),
    TAKE_VIDEO("profile_video_android_take_video_with_camera"),
    DEEP_LINK_BUTTON_CLICKED("profile_video_android_deep_link_button_clicked"),
    DEEP_LINK_FLOW_SUCCESS("profile_video_android_deep_link_flow_success"),
    DEEP_LINK_FLOW_CANCELED("profile_video_android_deep_link_flow_canceled"),
    OPEN_GALLERY("profile_video_android_open_video_gallery"),
    EXISTING_VIDEO("profile_video_android_chose_existing_video"),
    INVALID_VIDEO("profile_video_android_invalid_video"),
    VIDEO_TOO_LONG("profile_video_android_video_chosen_too_long"),
    VIDEO_TOO_SMALL("profile_video_android_video_too_small"),
    PREVIEW_OPENED("profile_video_android_preview_opened"),
    SCRUBBER_OPENED("profile_video_android_scrubber_opened"),
    CAMERA_CLOSED("profile_video_android_camera_closed"),
    PREVIEW_CLOSED("profile_video_android_preview_closed"),
    SCRUBBER_CLOSED("profile_video_android_scrubber_closed"),
    UPLOAD_STARTED("profile_video_android_upload_started"),
    USER_CREATION_FINISHED("profile_video_android_user_creation_flow_finished");
    
    private String mEventName;

    private ProfileVideoEvent(String str) {
        this.mEventName = str;
    }

    public final String getEventName() {
        return this.mEventName;
    }
}
