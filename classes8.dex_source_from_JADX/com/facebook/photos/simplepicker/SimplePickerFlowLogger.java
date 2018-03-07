package com.facebook.photos.simplepicker;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import javax.inject.Inject;

/* compiled from: showed_soft_input */
public class SimplePickerFlowLogger {
    public String f2880a;
    private AnalyticsLogger f2881b;

    /* compiled from: showed_soft_input */
    enum Event {
        LAUNCHED("photo_picker_open"),
        FRAGMENT_CREATED("photo_picker_fragment_created"),
        CANCELLED("photo_picker_cancel"),
        RETURN_TO_COMPOSER("photo_picker_to_composer"),
        MEDIA_ITEM_SELECTED_IN_GRID("photo_picker_grid_select_photo"),
        MEDIA_ITEM_SELECTED_IN_GALLERY("photo_picker_gallery_select_photo"),
        MEDIA_ITEM_DESELECTED("photo_picker_grid_deselect_photo"),
        CAMERA_OPENED("photo_picker_start_camera"),
        CAMERA_CANCELLED("photo_picker_camera_cancelled"),
        CAMERA_MEDIA_CAPTURED("photo_picker_camera_media_captured"),
        USE_SELECTED_ITEMS("grid_tap_compose_button"),
        LARGEST_GRID_ROW_REACHED("simplepicker_largest_grid_row_reached"),
        MEDIA_STORE_SIZE("simplepicker_media_store_size"),
        NUM_NEW_PHOTOS("simplepicker_num_new_photos"),
        PICKER_CREATIVECAM_START_FRAMES_DOWNLOAD("picker_creativecam_start_frames_download"),
        PICKER_CREATIVECAM_IMPRESSION("picker_creativecam_impression"),
        PICKER_CREATIVECAM_FRAMES_DOWNLOAD_FAILED("picker_creativecam_frames_download_failed");
        
        private final String name;

        private Event(String str) {
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }
    }

    public static SimplePickerFlowLogger m2934b(InjectorLike injectorLike) {
        return new SimplePickerFlowLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    public static SimplePickerFlowLogger m2932a(InjectorLike injectorLike) {
        return m2934b(injectorLike);
    }

    @Inject
    public SimplePickerFlowLogger(AnalyticsLogger analyticsLogger) {
        this.f2881b = analyticsLogger;
    }

    public final void m2937a(SimplePickerSource simplePickerSource, long j) {
        m2933a(m2931a(Event.LAUNCHED).b("source", simplePickerSource.toString()).a("target_id", j));
    }

    public final void m2935a() {
        m2933a(m2931a(Event.CANCELLED));
    }

    public final void m2939b() {
        m2933a(m2931a(Event.RETURN_TO_COMPOSER));
    }

    public final void m2940b(String str) {
        m2933a(m2931a(Event.MEDIA_ITEM_SELECTED_IN_GALLERY).b("media_type", str));
    }

    public final void m2938a(String str, int i) {
        m2933a(m2931a(Event.MEDIA_ITEM_SELECTED_IN_GRID).b("media_type", str).a("index", i));
    }

    public final void m2942c(String str) {
        m2933a(m2931a(Event.MEDIA_ITEM_DESELECTED).b("media_type", str));
    }

    public final void m2944d(String str) {
        m2933a(m2931a(Event.CAMERA_OPENED).b("media_type", str));
    }

    public final void m2945e(String str) {
        m2933a(m2931a(Event.CAMERA_CANCELLED).b("media_type", str));
    }

    public final void m2946f(String str) {
        m2933a(m2931a(Event.CAMERA_MEDIA_CAPTURED).b("media_type", str));
    }

    public final void m2936a(int i) {
        m2933a(m2931a(Event.USE_SELECTED_ITEMS).b("photo_selected_count", Integer.toString(i)));
    }

    public final void m2947g(String str) {
        m2933a(m2931a(Event.PICKER_CREATIVECAM_IMPRESSION).b("framepack_id", str));
    }

    public final void m2941c() {
        m2933a(m2931a(Event.PICKER_CREATIVECAM_START_FRAMES_DOWNLOAD));
    }

    public final void m2943d() {
        m2933a(m2931a(Event.PICKER_CREATIVECAM_FRAMES_DOWNLOAD_FAILED));
    }

    private void m2933a(HoneyClientEvent honeyClientEvent) {
        honeyClientEvent.c = "composer";
        if (!StringUtil.a(this.f2880a)) {
            honeyClientEvent.f = this.f2880a;
        }
        this.f2881b.c(honeyClientEvent);
    }

    private static HoneyClientEvent m2931a(Event event) {
        return new HoneyClientEvent(event.toString());
    }
}
