package com.facebook.privacy.checkup.service;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFields;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ShimmerFrameLayout failed to create working bitmap */
public class PrivacyCheckupAnalyticsLogger {
    public AnalyticsLogger f11080a;
    private Clock f11081b;

    /* compiled from: ShimmerFrameLayout failed to create working bitmap */
    public enum Event {
        PRIVACY_CHECKUP_INTRO_STEP_NEXT("privacy_checkup_intro_step_next"),
        PRIVACY_CHECKUP_INTRO_STEP_CONTINUE("privacy_checkup_intro_step_continue"),
        PRIVACY_CHECKUP_INTRO_STEP_CLOSE("privacy_checkup_intro_step_close"),
        PRIVACY_CHECKUP_COMPOSER_STEP_NEXT("privacy_checkup_composer_step_next"),
        PRIVACY_CHECKUP_COMPOSER_STEP_PREVIOUS("privacy_checkup_composer_step_previous"),
        PRIVACY_CHECKUP_PROFILE_STEP_NEXT("privacy_checkup_profile_step_next"),
        PRIVACY_CHECKUP_PROFILE_STEP_PREVIOUS("privacy_checkup_profile_step_previous"),
        PRIVACY_CHECKUP_APP_STEP_NEXT("privacy_checkup_app_step_next"),
        PRIVACY_CHECKUP_APP_STEP_PREVIOUS("privacy_checkup_app_step_previous"),
        PRIVACY_CHECKUP_APP_STEP_DELETE_DIALOG_EXPOSED("privacy_checkup_app_delete_dialog_exposed"),
        PRIVACY_CHECKUP_APP_STEP_DELETE_DIALOG_CANCEL("privacy_checkup_app_delete_dialog_cancel"),
        PRIVACY_CHECKUP_APP_STEP_DELETE_DIALOG_DELETE_POSTS("privacy_checkup_app_delete_dialog_delete_posts"),
        PRIVACY_CHECKUP_APP_STEP_DELETE_DIALOG_DELETE_APP_ONLY("privacy_checkup_app_delete_dialog_delete_app_only"),
        PRIVACY_CHECKUP_REVIEW_STEP_PREVIOUS("privacy_checkup_review_step_previous"),
        PRIVACY_CHECKUP_REVIEW_STEP_CLOSE("privacy_checkup_review_step_close"),
        PRIVACY_CHECKUP_WRITE_REQUEST_QUEUED("privacy_checkup_write_request_queued"),
        PRIVACY_CHECKUP_WRITE_REQUEST_SENT("privacy_checkup_write_request_sent"),
        PRIVACY_CHECKUP_WRITE_REQUEST_SUCCESS("privacy_checkup_write_request_success"),
        PRIVACY_CHECKUP_WRITE_REQUEST_FAILURE("privacy_checkup_write_request_failure"),
        PRIVACY_CHECKUP_WRITE_REQUEST_DROPPED("privacy_checkup_write_request_dropped"),
        PRIVACY_CHECKUP_WRITE_REQUEST_ON_EXIT("privacy_checkup_write_request_on_exit"),
        PRIVACY_CHECKUP_WRITE_REQUEST_FLUSH("privacy_checkup_write_request_flush"),
        PRIVACY_CHECKUP_WRITE_REQUEST_FLUSH_SUCCESS("privacy_checkup_write_request_flush_success"),
        PRIVACY_CHECKUP_WRITE_REQUEST_FLUSH_FAILURE("privacy_checkup_write_request_flush_failure"),
        PRIVACY_REVIEW_WRITE_SENT("privacy_review_write_sent"),
        PRIVACY_REVIEW_WRITE_SUCCESS("privacy_review_write_success"),
        PRIVACY_REVIEW_WRITE_FAILURE("privacy_review_write_failure"),
        PRIVACY_REVIEW_WRITE_TIMEOUT("privacy_review_write_timeout"),
        PRIVACY_REVIEW_WRITE_RETRY("privacy_review_write_retry"),
        PRIVACY_REVIEW_WRITE_EXIT_ON_FAILURE("privacy_review_write_exit_on_failure"),
        PRIVACY_REVIEW_CANCEL("privacy_review_cancel"),
        PRIVACY_REVIEW_CORE_EVENT("privacy_review_core_event");
        
        public final String eventName;

        private Event(String str) {
            this.eventName = str;
        }
    }

    /* compiled from: ShimmerFrameLayout failed to create working bitmap */
    public enum PhotoCheckupEvent {
        PHOTO_CHECKUP_BULK_EDIT_ACCEPTED("user_bulk_accepted"),
        PHOTO_CHECKUP_BULK_EDIT_REJECTED("user_bulk_rejected");
        
        public final String eventName;

        private PhotoCheckupEvent(String str) {
            this.eventName = str;
        }
    }

    /* compiled from: ShimmerFrameLayout failed to create working bitmap */
    public enum ReviewType {
        PROFILE_PHOTO_CHECKUP("fb4a_profile_photo_checkup");
        
        public final String reviewType;

        private ReviewType(String str) {
            this.reviewType = str;
        }
    }

    public static PrivacyCheckupAnalyticsLogger m11461b(InjectorLike injectorLike) {
        return new PrivacyCheckupAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PrivacyCheckupAnalyticsLogger(AnalyticsLogger analyticsLogger, Clock clock) {
        this.f11080a = analyticsLogger;
        this.f11081b = clock;
    }

    public static HoneyClientEvent m11460a(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "privacy_checkup";
        return honeyClientEvent;
    }

    public final void m11462a(Event event) {
        this.f11080a.a(m11460a(event.eventName));
    }

    public final void m11468a(String str, String str2, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Long l) {
        HoneyClientEvent b = new HoneyClientEvent(Event.PRIVACY_REVIEW_CORE_EVENT.eventName).b("review_type", "id_backed_privacy_checkup").b("review_id", str).b("review_event", str2);
        if (num != null) {
            b.a("current_step", num);
        }
        if (num2 != null) {
            b.a("from_step", num2);
        }
        if (num3 != null) {
            b.a("num_retries", num3);
        }
        if (num4 != null) {
            b.a("num_failures", num4);
        }
        if (l != null) {
            b.a("round_trip_time", l);
        }
        this.f11080a.a(b);
    }

    public final void m11466a(String str, String str2) {
        this.f11080a.a(new HoneyClientEvent(Event.PRIVACY_REVIEW_CORE_EVENT.eventName).b("review_type", str).b("review_event", str2));
    }

    public final void m11464a(Event event, long j, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i4 + i5;
        HoneyClientEvent a = m11460a(event.eventName);
        a.a("session_id", j);
        a.a("num_waiting_items", i);
        a.a("num_inflight_items", i2);
        a.a("num_logging_items", i3);
        a.a("num_total_writes", i8);
        a.a("num_total_logging_writes", i4);
        a.a("num_total_mutation_writes", i5);
        a.a("num_total_batch_requests_sent", i6);
        a.a("num_inflight_requests_cancelled_for_flush", i7);
        this.f11080a.a(a);
    }

    public final void m11465a(Event event, Integer num, @Nullable Long l) {
        HoneyClientEvent a = m11460a(event.eventName);
        a.a("num_items", num);
        if (l != null) {
            a.a("roundtrip_time", l);
        }
        this.f11080a.a(a);
    }

    public final void m11467a(String str, String str2, @Nullable PrivacyOptionFields privacyOptionFields) {
        HoneyClientEvent a = m11460a(Event.PRIVACY_CHECKUP_WRITE_REQUEST_QUEUED.eventName);
        a.b("fbid", str);
        a.b("action", str2);
        if (privacyOptionFields != null) {
            a.b("toValue", PrivacyOptionHelper.a(privacyOptionFields).toString());
        }
        this.f11080a.a(a);
    }

    public final void m11463a(Event event, int i, int i2, int i3, @Nullable Long l) {
        HoneyClientEvent a = m11460a(event.eventName);
        a.a("num_failures", i);
        a.a("num_timeouts", i2);
        a.a("num_retries", i3);
        if (l != null) {
            a.a("round_trip_time", l);
        }
        this.f11080a.a(a);
    }
}
