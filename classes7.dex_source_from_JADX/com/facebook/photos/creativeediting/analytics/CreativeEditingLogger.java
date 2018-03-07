package com.facebook.photos.creativeediting.analytics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.creativecam.CreativeCamSource;
import com.facebook.photos.creativeediting.model.SwipeableParams;
import com.facebook.photos.creativeediting.model.SwipeableParams.SwipeableItemType;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mVideoEditGalleryLaunchConfiguration must be set */
public class CreativeEditingLogger {
    private final AnalyticsLogger f9527a;
    @Nullable
    public String f9528b;
    @Nullable
    private String f9529c;

    /* compiled from: mVideoEditGalleryLaunchConfiguration must be set */
    enum Event {
        COMPOSER_CROP("composer_crop"),
        COMPOSER_STICKERS_ENTER_FLOW("composer_stickers_enter_flow"),
        COMPOSER_STICKERS_ADDED_STICKER("composer_stickers_added_sticker"),
        COMPOSER_STICKERS_REMOVED_STICKER("composer_stickers_removed_sticker"),
        COMPOSER_STICKERS_ENTER_STORE("composer_stickers_enter_store"),
        COMPOSER_TEXT_ON_PHOTOS("composer_text_on_photos"),
        COMPOSER_FILTERS_IN_GALLERY("composer_filters_in_gallery"),
        COMPOSER_STICKERS_EXIT_FLOW("composer_stickers_exit_flow"),
        COMPOSER_FILTER_VIEWED("composer_filter_viewed"),
        EDITGALLERY_FILTER_VIEWED("editgallery_filter_viewed"),
        COMPOSER_FRAME_VIEWED("composer_frame_viewed"),
        EDITGALLERY_FRAME_VIEWED("editgallery_frame_viewed"),
        CREATIVECAM_FRAME_VIEWED("creativecam_frame_viewed"),
        CREATIVECAM_ENTRY("creativecam_entry"),
        CREATIVECAM_EXIT_BACK("creativecam_exit_back"),
        CREATIVECAM_EXIT_CLOSE("creativecam_exit_close"),
        CREATIVECAM_CAPTURE_PHOTO("creativecam_capture_photo"),
        CREATIVECAM_RETAKE_PHOTO("creativecam_retake_photo"),
        CREATIVECAM_CAPTURE_PHOTO_CONFIRMED("creativecam_capture_photo_confirmed"),
        CREATIVECAM_SWITCH_CAMERA_FACING("creativecam_switch_camera_facing"),
        CREATIVECAM_OPEN_SIMPLE_PICKER("creativecam_open_simple_picker");
        
        private final String name;

        private Event(String str) {
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }
    }

    /* compiled from: mVideoEditGalleryLaunchConfiguration must be set */
    enum Extras {
        ENABLED("enabled"),
        TOGGLE_COUNT("toggle_count"),
        MIN_SLIDER_VALUE("min_slider_value"),
        MAX_SLIDER_VALUE("max_slider_value"),
        FINAL_SLIDER_VALUE("final_slider_value"),
        PUBLISHED("published"),
        DELETED("deleted"),
        DURATION_MS("duration_ms"),
        CROP_EDGE_CONTROL("used_edge_control"),
        CROP_PAN_CONTROL("used_pan_control"),
        CROP_ADJUSTMENT_COUNT("crop_adjustment_count"),
        ROTATION_COUNT("rotation_count"),
        CROP_ORIGINAL_ASPECT_RATIO("original_aspect_ratio"),
        CROP_FINAL_ASPECT_RATIO("final_aspect_ratio"),
        ACCEPTED("accepted"),
        NUMBER_OF_TAGS_REMOVED("number_of_tags_removed"),
        MEDIA_ITEM_IDENTIFIER("media_item_identifier"),
        NUMBER_OF_STICKERS_ADDED("number_of_stickers_added"),
        NUMBER_OF_STICKERS_REMOVED("number_of_stickers_removed"),
        NUMBER_OF_STICKERS_MOVED("moved_stickers_count"),
        NUMBER_OF_STICKERS_RESIZED("resized_stickers_count"),
        NUMBER_OF_STICKERS_ROTATED("rotated_stickers_count"),
        STICKER_ID("sticker_id"),
        NUM_TEXT_ADDED("insertion_count"),
        NUM_TEXT_REMOVED("removal_count"),
        NUM_TEXT_MOVED("moved_text_count"),
        NUM_TEXT_RESIZED("resized_text_count"),
        NUM_TEXT_ROTATED("rotated_text_count"),
        NUM_TEXT_EDITED("edited_text_count"),
        USED_COLOR_PICKER("used_color_picker"),
        NUM_STROKES("doodle_strokes_count"),
        NUM_UNDOS("doodle_undo_count"),
        NUM_RESETS("doodle_reset_count"),
        DOODLE_USED_COLOR_PICKER("doodle_used_color_picker"),
        NUM_OF_FILTER_SWIPES("filter_swipes_in_gallery"),
        APPLIED_FILTER("applied_filter_in_gallery"),
        FILTER_NAME("filter_name"),
        CAMERA_FACING("camera_facing"),
        CREATIVECAM_SOURCE("creativecam_source"),
        SOURCE("source");
        
        private final String name;

        private Extras(String str) {
            this.name = str;
        }

        public final String getParamKey() {
            return this.name;
        }
    }

    /* compiled from: mVideoEditGalleryLaunchConfiguration must be set */
    public class LoggingParameters implements Parcelable {
        public static final Creator<LoggingParameters> CREATOR = new C07751();
        public boolean f9514a;
        public int f9515b;
        public boolean f9516c = false;
        public boolean f9517d = false;
        public long f9518e;
        public boolean f9519f = false;
        public boolean f9520g = false;
        public int f9521h = 0;
        public int f9522i = 0;
        public float f9523j = 0.0f;
        public float f9524k = 0.0f;
        public boolean f9525l = false;
        public int f9526m = 0;

        /* compiled from: mVideoEditGalleryLaunchConfiguration must be set */
        final class C07751 implements Creator<LoggingParameters> {
            C07751() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new LoggingParameters(parcel);
            }

            public final Object[] newArray(int i) {
                return new LoggingParameters[i];
            }
        }

        public LoggingParameters(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.f9514a = parcel.readInt() == 1;
            this.f9515b = parcel.readInt();
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.f9516c = z;
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.f9517d = z;
            this.f9518e = parcel.readLong();
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.f9519f = z;
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.f9520g = z;
            this.f9521h = parcel.readInt();
            this.f9522i = parcel.readInt();
            this.f9523j = parcel.readFloat();
            this.f9524k = parcel.readFloat();
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.f9525l = z2;
            this.f9526m = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            parcel.writeInt(this.f9514a ? 1 : 0);
            parcel.writeInt(this.f9515b);
            if (this.f9516c) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (this.f9517d) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeLong(this.f9518e);
            if (this.f9519f) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (this.f9520g) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeInt(this.f9521h);
            parcel.writeInt(this.f9522i);
            parcel.writeFloat(this.f9523j);
            parcel.writeFloat(this.f9524k);
            if (!this.f9525l) {
                i3 = 0;
            }
            parcel.writeInt(i3);
            parcel.writeInt(this.f9526m);
        }
    }

    public static CreativeEditingLogger m11468b(InjectorLike injectorLike) {
        return new CreativeEditingLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    public static CreativeEditingLogger m11466a(InjectorLike injectorLike) {
        return m11468b(injectorLike);
    }

    public final void m11478a(SwipeableParams swipeableParams) {
        Object obj;
        String event;
        if (swipeableParams.c == SwipeableItemType.FRAME) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            event = Event.EDITGALLERY_FRAME_VIEWED.toString();
        } else {
            event = Event.EDITGALLERY_FILTER_VIEWED.toString();
        }
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(event);
        honeyClientEvent.c = "composer";
        m11467a(honeyClientEvent.b(Extras.FILTER_NAME.getParamKey(), swipeableParams.b));
    }

    public final void m11484b(SwipeableParams swipeableParams) {
        Object obj;
        String event;
        if (swipeableParams.c == SwipeableItemType.FRAME) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            event = Event.COMPOSER_FRAME_VIEWED.toString();
        } else {
            event = Event.COMPOSER_FILTER_VIEWED.toString();
        }
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(event);
        honeyClientEvent.c = "composer";
        m11467a(honeyClientEvent.b(Extras.FILTER_NAME.getParamKey(), swipeableParams.b));
    }

    @Inject
    public CreativeEditingLogger(AnalyticsLogger analyticsLogger) {
        this.f9527a = analyticsLogger;
    }

    public final void m11480a(String str, String str2) {
        this.f9528b = str;
        this.f9529c = str2;
    }

    public final void m11479a(String str) {
        this.f9528b = str;
    }

    public final void m11477a(TextOnPhotosLoggingParams textOnPhotosLoggingParams) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.COMPOSER_TEXT_ON_PHOTOS.toString());
        honeyClientEvent.c = "composer";
        m11467a(honeyClientEvent.a(Extras.NUM_TEXT_ADDED.getParamKey(), textOnPhotosLoggingParams.f9579g - textOnPhotosLoggingParams.f9577e.size()).a(Extras.NUM_TEXT_REMOVED.getParamKey(), textOnPhotosLoggingParams.f9580h).a(Extras.NUM_TEXT_RESIZED.getParamKey(), textOnPhotosLoggingParams.f9576d.size()).a(Extras.NUM_TEXT_MOVED.getParamKey(), textOnPhotosLoggingParams.f9575c.size()).a(Extras.NUM_TEXT_ROTATED.getParamKey(), textOnPhotosLoggingParams.f9578f.size()).a(Extras.NUM_TEXT_EDITED.getParamKey(), textOnPhotosLoggingParams.f9577e.size()).a(Extras.USED_COLOR_PICKER.getParamKey(), textOnPhotosLoggingParams.f9573a).a(Extras.ACCEPTED.getParamKey(), textOnPhotosLoggingParams.f9574b));
    }

    public final void m11475a(DoodleOnPhotosLoggingParams doodleOnPhotosLoggingParams) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.COMPOSER_TEXT_ON_PHOTOS.toString());
        honeyClientEvent.c = "composer";
        m11467a(honeyClientEvent.a(Extras.NUM_STROKES.getParamKey(), doodleOnPhotosLoggingParams.f9564c).a(Extras.NUM_UNDOS.getParamKey(), doodleOnPhotosLoggingParams.f9565d).a(Extras.NUM_RESETS.getParamKey(), doodleOnPhotosLoggingParams.f9566e).a(Extras.DOODLE_USED_COLOR_PICKER.getParamKey(), doodleOnPhotosLoggingParams.f9562a).a(Extras.ACCEPTED.getParamKey(), doodleOnPhotosLoggingParams.f9563b));
    }

    public final void m11476a(StickersOnPhotosLoggingParams stickersOnPhotosLoggingParams) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.COMPOSER_STICKERS_EXIT_FLOW.toString());
        honeyClientEvent.c = "composer";
        m11467a(honeyClientEvent.a(Extras.NUMBER_OF_STICKERS_ADDED.getParamKey(), stickersOnPhotosLoggingParams.f9571e).a(Extras.NUMBER_OF_STICKERS_REMOVED.getParamKey(), stickersOnPhotosLoggingParams.f9572f).a(Extras.NUMBER_OF_STICKERS_RESIZED.getParamKey(), stickersOnPhotosLoggingParams.f9569c.size()).a(Extras.NUMBER_OF_STICKERS_MOVED.getParamKey(), stickersOnPhotosLoggingParams.f9568b.size()).a(Extras.NUMBER_OF_STICKERS_ROTATED.getParamKey(), stickersOnPhotosLoggingParams.f9570d.size()).a(Extras.ACCEPTED.getParamKey(), stickersOnPhotosLoggingParams.f9567a));
    }

    public final void m11471a(int i, String str, boolean z) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.COMPOSER_FILTERS_IN_GALLERY.toString());
        honeyClientEvent.c = "composer";
        m11467a(honeyClientEvent.a(Extras.NUM_OF_FILTER_SWIPES.getParamKey(), i).b(Extras.APPLIED_FILTER.getParamKey(), str).a(Extras.ACCEPTED.getParamKey(), z));
    }

    public final void m11474a(LoggingParameters loggingParameters) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.COMPOSER_CROP.toString());
        honeyClientEvent.c = "composer";
        m11467a(honeyClientEvent.a(Extras.CROP_EDGE_CONTROL.getParamKey(), loggingParameters.f9519f).a(Extras.CROP_PAN_CONTROL.getParamKey(), loggingParameters.f9520g).a(Extras.CROP_ADJUSTMENT_COUNT.getParamKey(), loggingParameters.f9521h).a(Extras.ROTATION_COUNT.getParamKey(), loggingParameters.f9522i).a(Extras.CROP_ORIGINAL_ASPECT_RATIO.getParamKey(), (double) loggingParameters.f9523j).a(Extras.CROP_FINAL_ASPECT_RATIO.getParamKey(), (double) loggingParameters.f9524k).a(Extras.ACCEPTED.getParamKey(), loggingParameters.f9525l).a(Extras.NUMBER_OF_TAGS_REMOVED.getParamKey(), loggingParameters.f9526m));
    }

    public final void m11469a() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.COMPOSER_STICKERS_ENTER_FLOW.toString());
        honeyClientEvent.c = "composer";
        m11467a(honeyClientEvent);
    }

    public final void m11470a(int i, int i2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.COMPOSER_STICKERS_EXIT_FLOW.toString());
        honeyClientEvent.c = "composer";
        m11467a(honeyClientEvent.a(Extras.NUMBER_OF_STICKERS_ADDED.getParamKey(), i).a(Extras.NUMBER_OF_STICKERS_REMOVED.getParamKey(), i2));
    }

    public final void m11485b(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.COMPOSER_STICKERS_ADDED_STICKER.toString());
        honeyClientEvent.c = "composer";
        m11467a(honeyClientEvent.b(Extras.STICKER_ID.getParamKey(), str));
    }

    public final void m11488c(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.COMPOSER_STICKERS_REMOVED_STICKER.toString());
        honeyClientEvent.c = "composer";
        m11467a(honeyClientEvent.b(Extras.STICKER_ID.getParamKey(), str));
    }

    public final void m11481b() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.COMPOSER_STICKERS_ENTER_STORE.toString());
        honeyClientEvent.c = "composer";
        m11467a(honeyClientEvent);
    }

    public final void m11473a(CreativeCamSource creativeCamSource, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.CREATIVECAM_FRAME_VIEWED.toString());
        honeyClientEvent.c = "composer";
        m11467a(honeyClientEvent.b(Extras.FILTER_NAME.getParamKey(), str).a(Extras.CREATIVECAM_SOURCE.getParamKey(), creativeCamSource));
    }

    public final void m11472a(CreativeCamSource creativeCamSource) {
        HoneyClientEvent a = new HoneyClientEvent(Event.CREATIVECAM_ENTRY.toString()).a(Extras.CREATIVECAM_SOURCE.getParamKey(), creativeCamSource);
        a.c = "composer";
        m11467a(a);
    }

    public final void m11482b(CreativeCamSource creativeCamSource) {
        HoneyClientEvent a = new HoneyClientEvent(Event.CREATIVECAM_EXIT_BACK.toString()).a(Extras.CREATIVECAM_SOURCE.getParamKey(), creativeCamSource);
        a.c = "composer";
        m11467a(a);
    }

    public final void m11486c(CreativeCamSource creativeCamSource) {
        HoneyClientEvent a = new HoneyClientEvent(Event.CREATIVECAM_EXIT_CLOSE.toString()).a(Extras.CREATIVECAM_SOURCE.getParamKey(), creativeCamSource);
        a.c = "composer";
        m11467a(a);
    }

    public final void m11489d(CreativeCamSource creativeCamSource) {
        HoneyClientEvent a = new HoneyClientEvent(Event.CREATIVECAM_CAPTURE_PHOTO.toString()).a(Extras.CREATIVECAM_SOURCE.getParamKey(), creativeCamSource);
        a.c = "composer";
        m11467a(a);
    }

    public final void m11490e(CreativeCamSource creativeCamSource) {
        HoneyClientEvent a = new HoneyClientEvent(Event.CREATIVECAM_RETAKE_PHOTO.toString()).a(Extras.CREATIVECAM_SOURCE.getParamKey(), creativeCamSource);
        a.c = "composer";
        m11467a(a);
    }

    public final void m11483b(CreativeCamSource creativeCamSource, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.CREATIVECAM_CAPTURE_PHOTO_CONFIRMED.toString());
        honeyClientEvent.c = "composer";
        m11467a(honeyClientEvent.b(Extras.SOURCE.getParamKey(), str).a(Extras.CREATIVECAM_SOURCE.getParamKey(), creativeCamSource));
    }

    public final void m11487c(CreativeCamSource creativeCamSource, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.CREATIVECAM_SWITCH_CAMERA_FACING.toString());
        honeyClientEvent.c = "composer";
        m11467a(honeyClientEvent.b(Extras.CAMERA_FACING.getParamKey(), str).a(Extras.CREATIVECAM_SOURCE.getParamKey(), creativeCamSource));
    }

    public final void m11491f(CreativeCamSource creativeCamSource) {
        HoneyClientEvent a = new HoneyClientEvent(Event.CREATIVECAM_OPEN_SIMPLE_PICKER.toString()).a(Extras.CREATIVECAM_SOURCE.getParamKey(), creativeCamSource);
        a.c = "composer";
        m11467a(a);
    }

    private void m11467a(HoneyClientEvent honeyClientEvent) {
        if (!StringUtil.a(this.f9528b)) {
            honeyClientEvent.f = this.f9528b;
        }
        if (!StringUtil.a(this.f9529c)) {
            honeyClientEvent.b(Extras.MEDIA_ITEM_IDENTIFIER.getParamKey(), this.f9529c);
        }
        this.f9527a.a(honeyClientEvent);
    }
}
