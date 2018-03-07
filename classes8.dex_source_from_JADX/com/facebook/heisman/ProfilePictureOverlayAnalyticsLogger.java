package com.facebook.heisman;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.heisman.swipeable.ProfilePictureOverlaySwipeableFramesLogController;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: vertical_constraint */
public class ProfilePictureOverlayAnalyticsLogger {
    private static volatile ProfilePictureOverlayAnalyticsLogger f615b;
    @Inject
    public AnalyticsLogger f616a;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: vertical_constraint */
    public @interface PhotoSource {
    }

    public static com.facebook.heisman.ProfilePictureOverlayAnalyticsLogger m653a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f615b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.heisman.ProfilePictureOverlayAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f615b;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m657b(r0);	 Catch:{ all -> 0x0035 }
        f615b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f615b;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.heisman.ProfilePictureOverlayAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.heisman.ProfilePictureOverlayAnalyticsLogger");
    }

    private static ProfilePictureOverlayAnalyticsLogger m657b(InjectorLike injectorLike) {
        ProfilePictureOverlayAnalyticsLogger profilePictureOverlayAnalyticsLogger = new ProfilePictureOverlayAnalyticsLogger();
        profilePictureOverlayAnalyticsLogger.f616a = AnalyticsLoggerMethodAutoProvider.a(injectorLike);
        return profilePictureOverlayAnalyticsLogger;
    }

    public final void m665a(String str, @Nullable String str2, String str3, String str4) {
        m655a("heisman_open_selfie_camera", "heisman_composer_session_id", str, "tracking", str2, "heisman_entry_point", str3, "profile_pic_frame_id", str4);
    }

    public final void m662a(@Nullable String str, @Nullable String str2) {
        m654a("heisman_navigate_to_page_sponsor", "tracking", str, "profile_pic_frame_id", str2);
    }

    public final void m668b(String str, String str2) {
        m658b("heisman_cancel_camera", str, str2);
    }

    public final void m670c(String str, String str2) {
        m658b("heisman_return_to_camera", str, str2);
    }

    public final void m671d(String str, String str2) {
        m658b("heisman_photo_taken", str, str2);
    }

    public final void m672e(String str, String str2) {
        m654a("heisman_open_pivot", "heisman_composer_session_id", str, "heisman_entry_point", str2);
    }

    public final void m673f(String str, String str2) {
        m659b("goodwill_throwback_share_composer_open_birthday_frame", "heisman_composer_session_id", str, "heisman_entry_point", str2);
    }

    public final void m661a(String str) {
        m660g("heisman_open_pivot_from_camera", str);
    }

    public final void m667b(String str) {
        m660g("heisman_select_page_from_pivot", str);
    }

    public final void m669c(String str) {
        m660g("heisman_cancel_pivot", str);
    }

    private void m660g(String str, String str2) {
        String str3 = "heisman_composer_session_id";
        HoneyClientEventFast a = this.f616a.a(str, false);
        if (a.a()) {
            a.a("profile_picture_overlay");
            a.a(str3, str2);
            a.b();
        }
    }

    public final void m666a(String str, String str2, boolean z, String str3) {
        m655a("heisman_existing_photo_selected", "heisman_composer_session_id", str, "picture_id", str2, "current_profile_picture", z ? "1" : "0", "profile_pic_frame_id", str3);
    }

    public final void m663a(String str, String str2, ProfilePictureOverlaySwipeableFramesLogController profilePictureOverlaySwipeableFramesLogController, @Nullable String str3, String str4, String str5) {
        m656a("heisman_profile_picture_set", "heisman_composer_session_id", str, "profile_pic_frame_id", str2, "num_left_swipes", String.valueOf(profilePictureOverlaySwipeableFramesLogController.c()), "num_right_swipes", String.valueOf(profilePictureOverlaySwipeableFramesLogController.d()), "num_swipe_direction_changes", String.valueOf(profilePictureOverlaySwipeableFramesLogController.e()), "num_swipeable_frames", String.valueOf(profilePictureOverlaySwipeableFramesLogController.b()), "overlay_source_media_id", str3, "media_type", "photo", "heisman_photo_source", str4, "heisman_entry_point", str5);
    }

    public final void m664a(String str, String str2, @Nullable String str3) {
        m655a("heisman_profile_picture_set", "heisman_composer_session_id", str, "profile_pic_frame_id", str2, "overlay_source_media_id", str3, "media_type", "video");
    }

    private void m658b(String str, String str2, String str3) {
        m654a(str, "heisman_composer_session_id", str2, "profile_pic_frame_id", str3);
    }

    private void m654a(String str, String str2, String str3, String str4, String str5) {
        HoneyClientEventFast a = this.f616a.a(str, false);
        if (a.a()) {
            a.a("profile_picture_overlay");
            a.a(str2, str3);
            a.a(str4, str5);
            a.b();
        }
    }

    private void m655a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        HoneyClientEventFast a = this.f616a.a(str, false);
        if (a.a()) {
            a.a("profile_picture_overlay");
            a.a(str2, str3);
            a.a(str4, str5);
            a.a(str6, str7);
            a.a(str8, str9);
            a.b();
        }
    }

    private void m656a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21) {
        HoneyClientEventFast a = this.f616a.a(str, false);
        if (a.a()) {
            a.a("profile_picture_overlay");
            a.a(str2, str3);
            a.a(str4, str5);
            a.a(str6, str7);
            a.a(str8, str9);
            a.a(str10, str11);
            a.a(str12, str13);
            a.a(str14, str15);
            a.a(str16, str17);
            a.a(str18, str19);
            a.a(str20, str21);
            a.b();
        }
    }

    private void m659b(String str, String str2, String str3, String str4, String str5) {
        HoneyClientEventFast a = this.f616a.a(str, false);
        if (a.a()) {
            a.a("profile_picture_overlay_birthday");
            a.a(str2, str3);
            a.a(str4, str5);
            a.b();
        }
    }
}
