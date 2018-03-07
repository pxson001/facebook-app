package com.facebook.privacy.service;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: significant_motion */
public class PrivacyAnalyticsLogger {
    public final AnalyticsLogger f2186a;

    /* compiled from: significant_motion */
    public enum Events {
        COMPOSER_OPTIONS_FETCHED("composer_options_fetched"),
        COMPOSER_OPTIONS_REQUEST_RESULT("composer_options_request_result"),
        STICKY_PRIVACY_CHANGED_BY_FETCH("sticky_changed_by_fetch"),
        PRIVACY_CHANGE_IGNORED_ON_FETCH("composer_privacy_ignored_on_fetch"),
        BLOCK_FOR_CACHED_COMPOSER_OPTIONS("block_for_cached_composer_options"),
        PRIVACY_OPTION_COMPARE_MATCH("privacy_options_compare_match"),
        EDIT_PRIVACY_OPEN("edit_privacy_open"),
        EDIT_PRIVACY_CANCEL("edit_privacy_cancel"),
        EDIT_PRIVACY_RETURNED("edit_privacy_returned"),
        EDIT_PRIVACY_SAVED("edit_privacy_saved"),
        EDIT_PRIVACY_SAVE_FAILED("edit_privacy_save_failed"),
        EDIT_STORY_PRIVACY_OPEN("edit_story_privacy_open"),
        EDIT_STORY_PRIVACY_CANCEL("edit_story_privacy_cancel"),
        EDIT_STORY_PRIVACY_DISCARD("edit_story_privacy_discard"),
        EDIT_STORY_PRIVACY_SAVED("edit_story_privacy_saved"),
        EDIT_STORY_PRIVACY_SAVE_FAILED("edit_story_privacy_save_failed"),
        INLINE_PRIVACY_SURVEY_HIDE_TO_DEDUP("inline_privacy_survey_hide_to_dedup");
        
        public final String eventName;

        private Events(String str) {
            this.eventName = str;
        }
    }

    public static PrivacyAnalyticsLogger m2365b(InjectorLike injectorLike) {
        return new PrivacyAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PrivacyAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f2186a = analyticsLogger;
    }

    public static HoneyClientEvent m2363a(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "privacy";
        return honeyClientEvent;
    }

    public final void m2367a(Events events) {
        this.f2186a.a(m2363a(events.eventName));
    }

    public final void m2368a(String str, String str2) {
        this.f2186a.a(m2364a("privacy_education_manually_expanded", str, str2));
    }

    public final void m2370b(String str, String str2) {
        this.f2186a.a(m2364a("privacy_education_seen_after_collapsed", str, str2));
    }

    private HoneyClientEvent m2364a(String str, String str2, String str3) {
        return m2363a(str).b("surface", str2).b("education_type", str3);
    }

    public final void m2366a(int i) {
        this.f2186a.a(m2363a("privacy_selector_specific_friends_open").a("num_inclusions", i));
    }

    public final void m2369b(int i) {
        this.f2186a.a(m2363a("privacy_selector_specific_friends_close").a("num_inclusions", i));
    }
}
