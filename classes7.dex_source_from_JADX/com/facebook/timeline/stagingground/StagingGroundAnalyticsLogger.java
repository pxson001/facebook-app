package com.facebook.timeline.stagingground;

import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: fav_photos_add_prompt_impression */
public class StagingGroundAnalyticsLogger {
    public final AnalyticsLogger f14714a;
    public final String f14715b;

    @Inject
    public StagingGroundAnalyticsLogger(AnalyticsLogger analyticsLogger, @Assisted String str) {
        this.f14714a = analyticsLogger;
        this.f14715b = str;
    }

    public final void m18647a(String str, String str2, String str3) {
        m18646b("staging_ground_enter", str, str2, str3);
    }

    public final void m18649b(String str, String str2, String str3) {
        m18646b("staging_ground_tap_edit_button", str, str2, str3);
    }

    public final void m18650c(String str, String str2, String str3) {
        m18646b("staging_ground_tap_make_temporary", str, str2, str3);
    }

    public final void m18651d(String str, String str2, String str3) {
        m18646b("staging_ground_cancel_edit", str, str2, str3);
    }

    public final void m18652e(String str, String str2, String str3) {
        m18646b("staging_ground_tap_cancel", str, str2, str3);
    }

    private void m18646b(String str, String str2, String str3, String str4) {
        HoneyClientEventFast a = this.f14714a.a(str, false);
        if (a.a()) {
            a.a(this.f14715b);
            a.a("heisman_composer_session_id", str2);
            a.a("picture_id", str3);
            a.a("profile_pic_frame_id", str4);
            a.b();
        }
    }

    public final void m18648a(String str, String str2, String str3, String str4, String str5, long j) {
        HoneyClientEventFast a = this.f14714a.a("staging_ground_tap_use", false);
        if (a.a()) {
            a.a(this.f14715b);
            a.a("heisman_composer_session_id", str);
            a.a("picture_id", str2);
            a.a("profile_pic_frame_id", str3);
            a.a("use_cropping", str4);
            a.a("enter_cropping", str5);
            a.a("expiration_time_duration", j);
            a.b();
        }
    }
}
