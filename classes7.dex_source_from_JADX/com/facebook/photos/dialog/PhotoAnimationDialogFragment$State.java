package com.facebook.photos.dialog;

/* compiled from: live_event_comment_dialog */
public enum PhotoAnimationDialogFragment$State {
    INIT,
    ANIMATE_IN,
    ANIMATE_WAIT,
    SWIPING_IMAGE,
    SWIPING_FRAME,
    ANIMATE_OUT,
    NORMAL;

    public static boolean isSwiping(PhotoAnimationDialogFragment$State photoAnimationDialogFragment$State) {
        return photoAnimationDialogFragment$State == SWIPING_IMAGE || photoAnimationDialogFragment$State == SWIPING_FRAME;
    }
}
