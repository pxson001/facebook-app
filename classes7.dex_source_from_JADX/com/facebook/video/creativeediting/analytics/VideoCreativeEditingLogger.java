package com.facebook.video.creativeediting.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: dtse */
public class VideoCreativeEditingLogger {
    public final AnalyticsLogger f15536a;

    /* compiled from: dtse */
    public enum CreativeToolsParams {
        ORIGINAL_LENGTH("original_length"),
        TRIMMED_LENGTH("trimmed_length"),
        IS_MUTED("is_muted"),
        ROTATION("rotation"),
        LEFT_HANDLE_MOVES("left_handle_moves"),
        RIGHT_HANDLE_MOVES("right_handle_moves"),
        LEFT_HANDLE_ZOOM_INS("left_handle_zoom_ins"),
        RIGHT_HANDLE_ZOOM_INS("right_handle_zoom_ins"),
        SCRUBBER_MOVES("scrubber_moves"),
        AUDIO_BUTTON_CLICKS("audio_button_clicks");
        
        private final String name;

        private CreativeToolsParams(String str) {
            this.name = str;
        }

        public final String getParamKey() {
            return this.name;
        }
    }

    /* compiled from: dtse */
    public enum Params {
        VIDEO_ITEM_IDENTIFIER("asset_id"),
        SESSION_ID("external_session_id"),
        ENTRY_POINT("source"),
        ENTRY_ACTION("entry_action");
        
        private final String name;

        private Params(String str) {
            this.name = str;
        }

        public final String getParamKey() {
            return this.name;
        }
    }

    public static VideoCreativeEditingLogger m19548b(InjectorLike injectorLike) {
        return new VideoCreativeEditingLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    public static VideoCreativeEditingLogger m19546a(InjectorLike injectorLike) {
        return m19548b(injectorLike);
    }

    @Inject
    public VideoCreativeEditingLogger(AnalyticsLogger analyticsLogger) {
        this.f15536a = analyticsLogger;
    }

    public final void m19549a(String str, ComposerEntryPoint composerEntryPoint, String str2) {
        HoneyClientEvent b = m19547b(str, VideoEditingGalleryEntryPoint.COMPOSER, str2);
        b.b(Params.ENTRY_ACTION.getParamKey(), composerEntryPoint.getParamKey());
        this.f15536a.a(b);
    }

    public final void m19550a(String str, VideoEditingGalleryEntryPoint videoEditingGalleryEntryPoint, String str2) {
        this.f15536a.a(m19547b(str, videoEditingGalleryEntryPoint, str2));
    }

    private static HoneyClientEvent m19547b(String str, VideoEditingGalleryEntryPoint videoEditingGalleryEntryPoint, String str2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("video_editing_entry");
        honeyClientEvent.c = "video_editing_module";
        return honeyClientEvent.b(Params.VIDEO_ITEM_IDENTIFIER.getParamKey(), str).b(Params.ENTRY_POINT.getParamKey(), videoEditingGalleryEntryPoint.getParamKey()).b(Params.SESSION_ID.getParamKey(), str2);
    }

    public final void m19551a(String str, String str2, VideoEditingGalleryEntryPoint videoEditingGalleryEntryPoint, int i, int i2, boolean z, int i3) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("video_editing_exit");
        honeyClientEvent.c = "video_editing_module";
        this.f15536a.a(honeyClientEvent.b(Params.VIDEO_ITEM_IDENTIFIER.getParamKey(), str).b(Params.SESSION_ID.getParamKey(), str2).b(Params.ENTRY_POINT.getParamKey(), videoEditingGalleryEntryPoint.getParamKey()).a(CreativeToolsParams.ORIGINAL_LENGTH.getParamKey(), i).a(CreativeToolsParams.TRIMMED_LENGTH.getParamKey(), i2).a(CreativeToolsParams.IS_MUTED.getParamKey(), z).a(CreativeToolsParams.ROTATION.getParamKey(), i3));
    }

    public final void m19552b(String str, String str2, VideoEditingGalleryEntryPoint videoEditingGalleryEntryPoint, int i, int i2, boolean z, int i3) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("video_editing_cancel");
        honeyClientEvent.c = "video_editing_module";
        this.f15536a.a(honeyClientEvent.b(Params.VIDEO_ITEM_IDENTIFIER.getParamKey(), str).b(Params.SESSION_ID.getParamKey(), str2).b(Params.ENTRY_POINT.getParamKey(), videoEditingGalleryEntryPoint.getParamKey()).a(CreativeToolsParams.ORIGINAL_LENGTH.getParamKey(), i).a(CreativeToolsParams.TRIMMED_LENGTH.getParamKey(), i2).a(CreativeToolsParams.IS_MUTED.getParamKey(), z).a(CreativeToolsParams.ROTATION.getParamKey(), i3));
    }
}
