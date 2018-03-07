package com.facebook.richdocument.view.transition.state;

/* compiled from: optimisticProfilePictureUri */
public interface MediaStateMachine {

    /* compiled from: optimisticProfilePictureUri */
    public enum Event {
        CLICK_MEDIA,
        CLICK_MAP,
        SCROLL_FINISHED,
        BACK,
        UNFOCUSED,
        CONTROLLER_PAUSE,
        AUTOPLAY
    }

    boolean mo447a(Event event);
}
