package com.facebook.photos.base.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: instant_messaging */
public class TaggablePhotoGalleryFlowLogger {
    public String f12655a;
    private final AnalyticsLogger f12656b;

    /* compiled from: instant_messaging */
    enum Event {
        LAUNCH_GALLERY("photo_picker_gallery_view_photo"),
        CLOSE_GALLERY_PICKER("photo_picker_gallery_return_to_grid"),
        CLOSE_GALLERY_COMPOSER("photo_picker_gallery_return_to_composer"),
        ROTATE_PHOTO("photo_picker_gallery_rotate_photo"),
        ENTER_TAGGING_MODE("intent_photo_tag"),
        EXIT_TAGGING_MODE("photo_picker_gallery_exiting_tagging_mode"),
        TAG_ON_FACE_BOX("found_face_photo_tag"),
        TYPE_AHEAD_OPEN("photo_picker_type_ahead_open"),
        NO_FACE_PHOTO_TAG("no_face_photo_tag"),
        ADD_TAG_SUCCESS("add_photo_tag"),
        REMOVE_TAG("photo_picker_gallery_remove_tag"),
        START_TYPING("photo_picker_start_typing"),
        LAUNCH_FRIEND_TAGGER("composer_friend_tagger"),
        SWIPE_PHOTOS("photo_picker_galley_swipe_photos");
        
        private final String name;

        private Event(String str) {
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }
    }

    public static TaggablePhotoGalleryFlowLogger m20052b(InjectorLike injectorLike) {
        return new TaggablePhotoGalleryFlowLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    public static TaggablePhotoGalleryFlowLogger m20050a(InjectorLike injectorLike) {
        return m20052b(injectorLike);
    }

    @Inject
    public TaggablePhotoGalleryFlowLogger(AnalyticsLogger analyticsLogger) {
        this.f12656b = analyticsLogger;
    }

    private void m20051a(HoneyClientEvent honeyClientEvent) {
        honeyClientEvent.c = "composer";
        if (!StringUtil.a(this.f12655a)) {
            honeyClientEvent.f = this.f12655a;
        }
        this.f12656b.c(honeyClientEvent);
    }

    public final void m20053a() {
        m20051a(m20049a(Event.LAUNCH_GALLERY));
    }

    public final void m20055b() {
        m20051a(m20049a(Event.CLOSE_GALLERY_PICKER));
    }

    public final void m20056c() {
        m20051a(m20049a(Event.CLOSE_GALLERY_COMPOSER));
    }

    public final void m20057d() {
        m20051a(m20049a(Event.ROTATE_PHOTO));
    }

    public final void m20058e() {
        m20051a(m20049a(Event.ENTER_TAGGING_MODE));
    }

    public final void m20059f() {
        m20051a(m20049a(Event.EXIT_TAGGING_MODE));
    }

    public final void m20060g() {
        m20051a(m20049a(Event.TAG_ON_FACE_BOX));
    }

    public final void m20061h() {
        m20051a(m20049a(Event.TYPE_AHEAD_OPEN));
    }

    public final void m20062i() {
        m20051a(m20049a(Event.START_TYPING));
    }

    public final void m20063j() {
        m20051a(m20049a(Event.ADD_TAG_SUCCESS));
    }

    public final void m20064k() {
        m20051a(m20049a(Event.REMOVE_TAG));
    }

    public final void m20065l() {
        m20051a(m20049a(Event.LAUNCH_FRIEND_TAGGER));
    }

    public final void m20054a(int i, int i2) {
        m20051a(m20049a(Event.SWIPE_PHOTOS).a("photo_picker_swipes_to_left_count", i).a("photo_picker_swipes_to_right_count", i2));
    }

    private static HoneyClientEvent m20049a(Event event) {
        return new HoneyClientEvent(event.toString());
    }
}
