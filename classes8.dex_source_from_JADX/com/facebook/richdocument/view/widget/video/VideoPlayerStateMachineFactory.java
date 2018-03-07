package com.facebook.richdocument.view.widget.video;

import com.facebook.richdocument.view.transition.MediaTransitionState.PresentationMode;
import com.facebook.richdocument.view.widget.video.VideoPlayerStateMachine.VideoPlayerState;

/* compiled from: null_state_group_type */
public class VideoPlayerStateMachineFactory {
    public static final VideoPlayerState f7748a = new VideoPlayerState(PresentationMode.COLLAPSED, false, true);
    public static final VideoPlayerState f7749b = new VideoPlayerState(PresentationMode.COLLAPSED, true, false);
    public static final VideoPlayerState f7750c = new VideoPlayerState(PresentationMode.COLLAPSED, false, false);
    public static final VideoPlayerState f7751d = new VideoPlayerState(PresentationMode.EXPANDED, false, true);
    public static final VideoPlayerState f7752e = new VideoPlayerState(PresentationMode.EXPANDED, true, false);
    public static final VideoPlayerState f7753f = new VideoPlayerState(PresentationMode.EXPANDED, true, true);
}
