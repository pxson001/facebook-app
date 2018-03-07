package com.facebook.video.events;

import com.facebook.common.eventbus.TypedEvent;
import com.facebook.common.eventbus.TypedHandler;
import com.facebook.video.activity.FullScreenVideoPlayerActivity.2;

/* compiled from: composer_save_story_to_db_failed */
public class VideoFullScreenEvents {

    /* compiled from: composer_save_story_to_db_failed */
    public class EnterFullScreenEvent extends TypedEvent<Object> {
        public final /* bridge */ /* synthetic */ void m27623a(TypedHandler typedHandler) {
        }
    }

    /* compiled from: composer_save_story_to_db_failed */
    public class ExitFullScreenEvent extends TypedEvent<Handler> {
        public final void m27624a(TypedHandler typedHandler) {
            ((2) typedHandler).a();
        }
    }
}
