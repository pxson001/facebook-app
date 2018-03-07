package com.facebook.slideshow.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mediaSessionId */
public class SlideshowLogger {
    private final AnalyticsLogger f9006a;
    @Nullable
    public String f9007b;

    /* compiled from: mediaSessionId */
    enum Event {
        PICKER_NUX_SEEN("slideshow_picker_nux_seen"),
        PICKER_NUX_DISMISS("slideshow_picker_nux_dismissed"),
        SLIDESHOW_SELECTED("intent_slideshow"),
        SLIDESHOW_DESELECTED("cancel_slideshow"),
        SLIDESHOW_PREVIEW_SEEN("slideshow_preview_seen"),
        SLIDESHOW_PREVIEW_PLAY("slideshow_preview_play"),
        SLIDESHOW_PREVIEW_STOP("slideshow_preview_stop"),
        SLIDESHOW_PREVIEW_REORDER("slideshow_preview_reorder"),
        SLIDESHOW_PREVIEW_SAVED("slideshow_preview_save"),
        SLIDESHOW_REMOVED("slideshow_removed"),
        SLIDESHOW_POSTED("post_slideshow");
        
        private final String name;

        private Event(String str) {
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }
    }

    public static SlideshowLogger m10725b(InjectorLike injectorLike) {
        return new SlideshowLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SlideshowLogger(AnalyticsLogger analyticsLogger) {
        this.f9006a = analyticsLogger;
    }

    public static SlideshowLogger m10723a(InjectorLike injectorLike) {
        return m10725b(injectorLike);
    }

    public final void m10728a(String str, int i) {
        this.f9007b = str;
        m10724a(m10722a(Event.SLIDESHOW_POSTED).a("photo_count", i));
    }

    public final void m10726a() {
        m10724a(m10722a(Event.PICKER_NUX_SEEN));
    }

    public final void m10729b() {
        m10724a(m10722a(Event.PICKER_NUX_DISMISS));
    }

    public final void m10731c() {
        m10724a(m10722a(Event.SLIDESHOW_SELECTED));
    }

    public final void m10732d() {
        m10724a(m10722a(Event.SLIDESHOW_DESELECTED));
    }

    public final void m10730b(String str) {
        m10724a(m10722a(Event.SLIDESHOW_PREVIEW_SEEN).b("source", str));
    }

    public final void m10733e() {
        m10724a(m10722a(Event.SLIDESHOW_PREVIEW_PLAY));
    }

    public final void m10734f() {
        m10724a(m10722a(Event.SLIDESHOW_PREVIEW_STOP));
    }

    public final void m10735g() {
        m10724a(m10722a(Event.SLIDESHOW_PREVIEW_REORDER));
    }

    public final void m10727a(int i) {
        m10724a(m10722a(Event.SLIDESHOW_PREVIEW_SAVED).a("photo_count", i));
    }

    public final void m10736h() {
        m10724a(m10722a(Event.SLIDESHOW_REMOVED));
    }

    private void m10724a(HoneyClientEvent honeyClientEvent) {
        honeyClientEvent.c = "slideshow";
        if (!StringUtil.a(this.f9007b)) {
            honeyClientEvent.f = this.f9007b;
        }
        this.f9006a.a(honeyClientEvent);
    }

    private static HoneyClientEvent m10722a(Event event) {
        return new HoneyClientEvent(event.toString());
    }
}
