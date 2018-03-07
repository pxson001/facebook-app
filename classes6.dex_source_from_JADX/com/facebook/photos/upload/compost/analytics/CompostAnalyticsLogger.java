package com.facebook.photos.upload.compost.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: graph_search_v2_trending_awareness_unit */
public class CompostAnalyticsLogger {
    private final AnalyticsLogger f13566a;
    private final String f13567b = SafeUUIDGenerator.a().toString();

    public static CompostAnalyticsLogger m21244b(InjectorLike injectorLike) {
        return new CompostAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public CompostAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f13566a = analyticsLogger;
    }

    public final void m21249a(String str) {
        this.f13566a.a(m21245j("opening_page").b("source", str));
    }

    public final void m21246a() {
        this.f13566a.a(m21245j("show_null_state"));
    }

    public final void m21254b() {
        this.f13566a.a(m21245j("show_failure_state"));
    }

    public final void m21255b(String str) {
        this.f13566a.a(m21245j("discard_dialog_opened").b("section", str));
    }

    public final void m21259c(String str) {
        this.f13566a.a(m21245j("discard_cancelled").b("section", str));
    }

    public final void m21263d(String str) {
        this.f13566a.a(m21245j("discard").b("story_id", str));
    }

    public final void m21266e(String str) {
        this.f13566a.a(m21245j("retry").b("story_id", str));
    }

    public final void m21251a(String str, String str2) {
        this.f13566a.a(m21245j("story_menu_opened").b("section", str).b("story_id", str2));
    }

    public final void m21258c() {
        this.f13566a.a(m21245j("open_composer"));
    }

    public final void m21268f(String str) {
        this.f13566a.a(m21245j("open_permalink").b("story_id", str));
    }

    public final void m21269g(String str) {
        this.f13566a.a(m21245j("open_profile").b("user_id", str));
    }

    public final void m21250a(String str, int i, int i2) {
        this.f13566a.a(m21245j("open_draft_dialog").b("story_id", str).a("media_count", i).a("char_count", i2));
    }

    public final void m21270h(String str) {
        this.f13566a.a(m21245j("publish_draft").b("story_id", str));
    }

    public final void m21256b(String str, int i, int i2) {
        this.f13566a.a(m21245j("draft_dialog_discard").b("story_id", str).a("media_count", i).a("char_count", i2));
    }

    public final void m21260c(String str, int i, int i2) {
        this.f13566a.a(m21245j("draft_dialog_save").b("story_id", str).a("media_count", i).a("char_count", i2));
    }

    public final void m21252a(String str, String str2, int i, int i2) {
        this.f13566a.a(m21245j("open_draft").b("source", str).b("story_id", str2).a("media_count", i).a("char_count", i2));
    }

    public final void m21264d(String str, int i, int i2) {
        this.f13566a.a(m21245j("save_draft").b("story_id", str).a("media_count", i).a("char_count", i2));
    }

    public final void m21267e(String str, int i, int i2) {
        this.f13566a.a(m21245j("discard_draft").b("story_id", str).a("media_count", i).a("char_count", i2));
    }

    public final void m21271i(String str) {
        this.f13566a.a(m21245j("draft_candidate").b("session_id", str));
    }

    public final void m21257b(String str, String str2) {
        this.f13566a.a(m21245j("draft_disabled_for_content_type").b("session_id", str).b("content_type", str2));
    }

    public final void m21253a(String str, String str2, String str3) {
        this.f13566a.a(m21245j("draft_disabled_for_content_type").b("session_id", str).b("content_type", str2).b("details", str3));
    }

    public final void m21261c(String str, String str2) {
        this.f13566a.a(m21245j("draft_disabled_for_source_type").b("session_id", str).b("source_type", str2));
    }

    public final void m21247a(int i) {
        this.f13566a.a(m21245j("discard_expired").a("drafts", i));
    }

    public final void m21248a(int i, int i2, int i3) {
        this.f13566a.a(m21245j("num_rows").a("uploading", i).a("uploaded", i2).a("drafts", i3));
    }

    public final void m21265d(String str, String str2) {
        this.f13566a.a(m21245j("internet_status").b("status", str).b("trigger", str2));
    }

    public final void m21262d() {
        this.f13566a.a(m21245j("back_press"));
    }

    private HoneyClientEvent m21245j(String str) {
        HoneyClientEvent b = new HoneyClientEvent("compost").b("event", str);
        b.f = this.f13567b;
        return b;
    }
}
