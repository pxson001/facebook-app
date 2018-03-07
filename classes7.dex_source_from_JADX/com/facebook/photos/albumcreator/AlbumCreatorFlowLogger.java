package com.facebook.photos.albumcreator;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: master */
public class AlbumCreatorFlowLogger {
    private final AnalyticsLogger f9277a;
    public String f9278b;
    private String f9279c = "";
    private boolean f9280d = false;
    private boolean f9281e = false;

    /* compiled from: master */
    public enum DialogType {
        CANCELLATION,
        NO_ALBUM_TITLE
    }

    /* compiled from: master */
    enum Event {
        ALBUM_CREATOR_OPENED("album_creator_opened"),
        ALBUM_CREATOR_CANCELLED("album_creator_cancelled"),
        ALBUM_CREATED("album_created"),
        ALBUM_CREATE_FAILED("album_create_failed"),
        ALBUM_TITLE_TEXT_ENTERED("album_title_text_entered"),
        ALBUM_DESCRIPTION_TEXT_ENTERED("album_description_text_entered"),
        ALBUM_PRIVACY_SELECTOR_OPENED("album_privacy_selector_opened"),
        ALBUM_LOCATION_CHANGED("album_location_changed"),
        ALBUM_CREATOR_DIALOG_SHOWN("album_creator_dialog_shown");
        
        private final String name;

        private Event(String str) {
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }
    }

    public static AlbumCreatorFlowLogger m11295b(InjectorLike injectorLike) {
        return new AlbumCreatorFlowLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AlbumCreatorFlowLogger(AnalyticsLogger analyticsLogger) {
        this.f9277a = analyticsLogger;
    }

    public final void m11300b(String str) {
        m11294a(m11293a(Event.ALBUM_CREATOR_OPENED).b("source", str));
    }

    public final void m11296a() {
        m11294a(m11293a(Event.ALBUM_CREATOR_CANCELLED));
    }

    public final void m11298a(boolean z) {
        m11294a(m11293a(Event.ALBUM_CREATED).a("is_untitled_album", z));
    }

    public final void m11302c(String str) {
        m11294a(m11293a(Event.ALBUM_CREATE_FAILED).b("message", str));
    }

    public final void m11299b() {
        if (!this.f9280d) {
            m11294a(m11293a(Event.ALBUM_TITLE_TEXT_ENTERED));
            this.f9280d = true;
        }
    }

    public final void m11301c() {
        if (!this.f9281e) {
            m11294a(m11293a(Event.ALBUM_DESCRIPTION_TEXT_ENTERED));
            this.f9281e = true;
        }
    }

    public final void m11303d() {
        m11294a(m11293a(Event.ALBUM_PRIVACY_SELECTOR_OPENED));
    }

    public final void m11304e() {
        m11294a(m11293a(Event.ALBUM_LOCATION_CHANGED));
    }

    public final void m11297a(DialogType dialogType) {
        m11294a(m11293a(Event.ALBUM_CREATOR_DIALOG_SHOWN).b("message", dialogType.toString()));
    }

    private void m11294a(HoneyClientEvent honeyClientEvent) {
        honeyClientEvent.c = "album_creator";
        if (!StringUtil.a(this.f9278b)) {
            honeyClientEvent.f = this.f9278b;
        }
        honeyClientEvent.b("qe_group_name", this.f9279c);
        this.f9277a.c(honeyClientEvent);
    }

    private static HoneyClientEvent m11293a(Event event) {
        return new HoneyClientEvent(event.toString());
    }
}
