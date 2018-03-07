package com.facebook.messaging.quickcam;

import android.content.res.Resources;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.quickcam.QuickCamAsync;
import com.facebook.inject.InjectorLike;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: deltaPaymentNoOp */
public class QuickCamEventLogger {
    public final AnalyticsLogger f16498a;
    private final NavigationLogger f16499b;
    private final Resources f16500c;

    public static QuickCamEventLogger m16529a(InjectorLike injectorLike) {
        return new QuickCamEventLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), NavigationLogger.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public QuickCamEventLogger(AnalyticsLogger analyticsLogger, NavigationLogger navigationLogger, Resources resources) {
        this.f16498a = analyticsLogger;
        this.f16499b = navigationLogger;
        this.f16500c = resources;
    }

    public final void m16531a(QuickCamAsync quickCamAsync) {
        this.f16499b.b("quickcam_popup", "fullscreen", "enter_fullscreen_button", m16530b(quickCamAsync, false, false, false, false, null, null));
    }

    public final void m16533b(QuickCamAsync quickCamAsync) {
        this.f16499b.b("quickcam_popup", "fullscreen", "enter_fullscreen_swipe", m16530b(quickCamAsync, true, false, false, false, null, null));
    }

    public final void m16534c(QuickCamAsync quickCamAsync) {
        this.f16499b.b("quickcam_popup", "fullscreen", "leave_fullscreen_button", m16530b(quickCamAsync, true, false, false, false, null, null));
    }

    public final void m16535d(QuickCamAsync quickCamAsync) {
        this.f16499b.b("quickcam_popup", "fullscreen", "leave_fullscreen_swipe", m16530b(quickCamAsync, false, false, false, false, null, null));
    }

    public final void m16532a(QuickCamAsync quickCamAsync, boolean z, boolean z2, boolean z3, boolean z4, String str, String str2) {
        this.f16499b.b("quickcam_popup", "button", "send_from_insta", m16530b(quickCamAsync, z, z2, z3, z4, str, str2));
    }

    private Map<String, Object> m16530b(QuickCamAsync quickCamAsync, boolean z, boolean z2, boolean z3, boolean z4, String str, String str2) {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("camera_direction", quickCamAsync.m6388h() ? "front" : "back");
        hashMap.put("landscape", Boolean.valueOf(this.f16500c.getConfiguration().orientation == 2));
        hashMap.put("fullscreen", Boolean.valueOf(z));
        hashMap.put("text_editing_present", Boolean.valueOf(z2));
        hashMap.put("sticker_editing_present", Boolean.valueOf(z3));
        hashMap.put("doodle_editing_present", Boolean.valueOf(z4));
        hashMap.put("present_sticker_ids", str);
        hashMap.put("present_sticker_pack_ids", str2);
        return hashMap;
    }
}
