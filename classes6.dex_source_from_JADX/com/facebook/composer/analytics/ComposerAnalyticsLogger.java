package com.facebook.composer.analytics;

import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.composer.tasks.ComposerTaskId;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.composer.model.RetrySource;
import com.facebook.ipc.composer.model.TargetType;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multiset;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: place_picker_minutiae_to_place_start */
public class ComposerAnalyticsLogger {
    private static volatile ComposerAnalyticsLogger f7778d;
    public final AnalyticsLogger f7779a;
    public final FbNetworkManager f7780b;
    private final FbDataConnectionManager f7781c;

    /* compiled from: place_picker_minutiae_to_place_start */
    public enum Events {
        SAVE_SESSION("save_draft"),
        DISCARD_SESSION("discard_draft"),
        LOAD_SAVED_SESSION("load_draft"),
        COMPOSER_TEXT_START("composer_text_start"),
        COMPOSER_TEXT_READY("composer_text_ready"),
        COMPOSER_PRIVACY_READY("composer_privacy_ready"),
        COMPOSER_OPEN_PRIVACY("composer_open_privacy"),
        COMPOSER_CHANGE_PRIVACY("composer_change_privacy"),
        COMPOSER_CANCEL_PRIVACY("composer_cancel_privacy"),
        COMPOSER_PICKS_PRIVACY_FROM_TYPEAHEAD_FILTER("composer_picks_privacy_from_typeahead_filter"),
        COMPOSER_VIDEO_TAG_CLICK("composer_video_tag_click"),
        COMPOSER_FRIEND_TAG_CLICK("composer_friend_tag_click"),
        COMPOSER_FRIEND_TAG_READY("composer_friend_tag_ready"),
        COMPOSER_FRIEND_TAG_CANCEL("composer_friend_tag_cancel"),
        COMPOSER_FRIEND_TAG("composer_friend_tag"),
        COMPOSER_FRIEND_TAG_REMOVE("composer_friend_tag_remove"),
        COMPOSER_FRIEND_TAG_FAILURE("composer_friend_tag_failure"),
        COMPOSER_FRIEND_TAG_SUGGESTIONS_SHOWN("composer_friend_tag_suggestions_shown"),
        COMPOSER_ADD_LOCATION_CLICK("composer_add_location_click"),
        COMPOSER_ADD_LOCATION_READY("composer_add_location_ready"),
        COMPOSER_ADD_LOCATION_CANCEL("composer_add_location_cancel"),
        COMPOSER_ADD_LOCATION("composer_add_location"),
        COMPOSER_ADD_LOCATION_REMOVE("composer_add_location_remove"),
        COMPOSER_ADD_LOCATION_FAILURE("composer_add_location_failure"),
        COMPOSER_ADD_LOCATION_AFTER_TAG_PEOPLE("composer_add_location_after_tag_people"),
        COMPOSER_IMPLICIT_LOCATION_CLICK("composer_implicit_location_click"),
        COMPOSER_TEXT_PASTED("composer_text_pasted"),
        COMPOSER_ATTACH_MEDIA_CLICK("intent_media"),
        COMPOSER_ATTACH_PHOTO_READY("composer_attach_photo_ready"),
        COMPOSER_ATTACH_PHOTO_CANCEL("composer_attach_photo_cancel"),
        COMPOSER_ATTACH_PHOTO("composer_attach_photo"),
        COMPOSER_ATTACH_PHOTO_REMOVE("composer_attach_photo_remove"),
        COMPOSER_ATTACH_PHOTO_FAILURE("composer_attach_photo_failure"),
        COMPOSER_OPEN_PICKER_FROM_EXIT_CONFIRMATION("composer_open_picker_from_exit_confirmation"),
        COMPOSER_ATTACH_MOVIE("composer_attach_movie"),
        COMPOSER_ATTACH_MOVIE_REMOVE("composer_attach_movie_remove"),
        COMPOSER_ATTACH_MOVIE_FAILURE("composer_attach_movie_failure"),
        COMPOSER_ATTACH_MOVIE_CANCEL("composer_attach_movie_cancel"),
        COMPOSER_SELECT_ALBUM_CLICK("composer_select_album_click"),
        COMPOSER_SELECT_ALBUM_CANCEL("composer_select_album_cancel"),
        COMPOSER_SELECT_ALBUM_CHOOSE("composer_select_album_choose"),
        COMPOSER_SELECT_ALBUM_NEW("composer_select_album_new"),
        COMPOSER_SELECT_ALBUM("composer_select_album"),
        COMPOSER_MINUTIAE_CLICK("composer_minutiae_click"),
        COMPOSER_MINUTIAE_CANCEL("composer_minutiae_cancel"),
        COMPOSER_MINUTIAE("composer_minutiae"),
        COMPOSER_MINUTIAE_REMOVE("composer_minutiae_remove"),
        COMPOSER_MINUTIAE_ICON_PICKER_UPDATE("composer_minutiae_cancel"),
        COMPOSER_MINUTIAE_ICON_PICKER_CANCEL("composer_minutiae_cancel"),
        COMPOSER_MINUTIAE_ICON_CLICKED("composer_minutiae_icon_clicked"),
        COMPOSER_PHOTO_THUMBNAIL_CLICKED("clicked_on_photo_thumbnail"),
        COMPOSER_VIDEO_THUMBNAIL_CLICKED("clicked_on_video_thumbnail"),
        COMPOSER_PUBLISH_MODE_SELECTOR_CLICK("post_options_picker_started"),
        COMPOSER_TRANSLITERATE_CLICK("composer_transliterate_click"),
        COMPOSER_FACECAST_CLICK("composer_facecast_click"),
        COMPOSER_PUBLISH_START("composer_publish_start"),
        COMPOSER_SAVED_STORY_TO_DB("composer_saved_story_to_db"),
        COMPOSER_UPDATED_STORY_IN_DB("composer_updated_story_in_db"),
        COMPOSER_SAVE_STORY_TO_DB_FAILED("composer_save_story_to_db_failed"),
        COMPOSER_DELETE_STORY_FROM_DB("composer_delete_story_from_db"),
        COMPOSER_DELETE_STORY_FROM_DB_FAILED("composer_delete_story_from_db_failed"),
        COMPOSER_POST_COMPLETED("composer_post_completed"),
        COMPOSER_DELETE_ALL_PENDING_STORIES("composer_delete_all_pending_stories"),
        COMPOSER_DELETE_ALL_PENDING_STORIES_FAILED("composer_delete_all_pending_stories_failed"),
        COMPOSER_EDIT_TAGS("composer_edit_tags"),
        COMPOSER_EDIT_CHANGE_MINUTIAE_TAG("composer_edit_change_minutiae_tag"),
        COMPOSER_EDIT_CHANGE_WITH_TAG("composer_edit_change_with_tag"),
        COMPOSER_EDIT_CHANGE_PLACE_TAG("composer_edit_change_place_tag"),
        COMPOSER_EDIT_ADD_MINUTIAE_TAG("composer_edit_add_minutiae_tag"),
        COMPOSER_EDIT_ADD_WITH_TAG("composer_edit_add_with_tag"),
        COMPOSER_EDIT_ADD_PLACE_TAG("composer_edit_add_place_tag"),
        COMPOSER_EDIT_REMOVE_MINUTIAE_TAG("composer_edit_remove_minutiae_tag"),
        COMPOSER_EDIT_REMOVE_WITH_TAG("composer_edit_remove_with_tag"),
        COMPOSER_EDIT_REMOVE_PLACE_TAG("composer_edit_remove_place_tag"),
        COMPOSER_OPENED_TARGET_SELECTOR("composer_opened_target_selector"),
        COMPOSER_POST_COMPOSITION_CLICK("post_composition_opened"),
        COMPOSER_POST_COMPOSITION_CANCEL("post_composition_closed"),
        COMPOSER_DISCARD_DIALOG_DISPLAYED("composer_discard_dialog_displayed"),
        COMPOSER_DISCARD_DIALOG_DISMISSED("composer_discard_dialog_dismissed"),
        MEME_BUSTING_SENTRY_WARNING_RECEIVED("meme_busting_sentry_warning_received"),
        MEME_BUSTING_SENTRY_WARNING_ACK("meme_busting_sentry_warning_ack"),
        MEME_BUSTING_SENTRY_WARNING_CANCEL("meme_busting_sentry_warning_cancel"),
        CHECKIN_PREVIEW_SEEN("checkin_preview_seen"),
        CHECKIN_PREVIEW_DISMISSED("checkin_preview_dismissed"),
        CHECKIN_PREVIEW_ADD_PHOTO_CLICKED("checkin_preview_add_photo_clicked");
        
        public final String name;

        private Events(String str) {
            this.name = str;
        }
    }

    public static com.facebook.composer.analytics.ComposerAnalyticsLogger m11140a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7778d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.composer.analytics.ComposerAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f7778d;	 Catch:{ all -> 0x003a }
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
        r0 = m11141b(r0);	 Catch:{ all -> 0x0035 }
        f7778d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7778d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.analytics.ComposerAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.composer.analytics.ComposerAnalyticsLogger");
    }

    private static ComposerAnalyticsLogger m11141b(InjectorLike injectorLike) {
        return new ComposerAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), FbNetworkManager.a(injectorLike), FbDataConnectionManager.a(injectorLike));
    }

    public final void m11147a(String str, ComposerConfiguration composerConfiguration, TargetType targetType, long j, boolean z, @Nullable String str2, ImmutableMap<String, Integer> immutableMap, String str3, boolean z2, String str4) {
        String str5;
        ComposerAnalyticsEventBuilder r = new ComposerAnalyticsEventBuilder("composer_entry").m11124h(str).m11128j(this.f7781c.c().name()).m11102a(composerConfiguration.getSourceType()).m11103a(composerConfiguration.getComposerType()).m11100a(composerConfiguration.getLaunchLoggingParams().getEntryPicker()).m11101a(composerConfiguration.getLaunchLoggingParams().getSourceSurface()).m11115c(composerConfiguration.getLaunchLoggingParams().getEntryPointDescription()).m11126i(this.f7780b.p()).m11129k(composerConfiguration.getExternalRefName()).m11105a((ImmutableMap) immutableMap).m11130l(str3).m11104a(targetType).m11099a(j).m11131m(z).m11138u(str2).m11107a(z2).m11135r(str4);
        if (composerConfiguration.getInitialShareParams() == null || composerConfiguration.getInitialShareParams().shareable == null) {
            str5 = null;
        } else {
            str5 = composerConfiguration.getInitialShareParams().shareable.d();
        }
        this.f7779a.a(r.m11136s(str5).m11139y());
    }

    public final void m11154a(String str, RetrySource retrySource) {
        ComposerAnalyticsEventBuilder i = new ComposerAnalyticsEventBuilder("composer_post_retry").m11124h(str).m11126i(this.f7780b.p());
        i.f7777a.a("retry_source", retrySource);
        this.f7779a.a(i.f7777a);
    }

    public final void m11152a(String str, ComposerType composerType, String str2, String str3, int i) {
        this.f7779a.a(new ComposerAnalyticsEventBuilder("composer_post_success").m11126i(this.f7780b.p()).m11111b(str3).m11124h(str).m11103a(composerType).m11118d(str2).m11098a(i).f7777a);
        m11143a(Events.COMPOSER_POST_COMPLETED, str);
    }

    public final void m11153a(String str, ComposerType composerType, String str2, String str3, String str4, ServiceException serviceException, int i) {
        ComposerAnalyticsEventBuilder i2 = new ComposerAnalyticsEventBuilder("composer_post_failure").m11126i(this.f7780b.p());
        i2.f7777a.b("error_code", serviceException.errorCode.toString());
        i2 = i2;
        i2.f7777a.b("error_message", str4);
        ComposerAnalyticsEventBuilder d = i2.m11111b(str3).m11124h(str).m11103a(composerType).m11098a(i).m11118d(str2);
        Bundle bundle = serviceException.result.d;
        if (bundle != null) {
            d.f7777a.b("exception_message", (String) bundle.get("originalExceptionMessage"));
            d.f7777a.b("exception_stack", (String) bundle.get("originalExceptionStack"));
        }
        this.f7779a.a(d.f7777a);
    }

    public final void m11151a(String str, ComposerType composerType, String str2, int i, boolean z) {
        this.f7779a.a(new ComposerAnalyticsEventBuilder("composer_post_cancel").m11126i(this.f7780b.p()).m11124h(str).m11103a(composerType).m11118d(str2).m11098a(i).m11127i(z).f7777a);
    }

    public final void m11150a(String str, ComposerType composerType, double d, float f) {
        ComposerAnalyticsEventBuilder a = new ComposerAnalyticsEventBuilder("composer_pause").m11126i(this.f7780b.p()).m11124h(str).m11103a(composerType);
        a.f7777a.a("scroll_percent", d);
        a = a;
        a.f7777a.a("min_aspect_ratio", (double) f);
        this.f7779a.a(a.f7777a);
    }

    public final void m11155a(String str, ImmutableList<String> immutableList, ImmutableList<String> immutableList2, boolean z, boolean z2) {
        ComposerAnalyticsEventBuilder h = new ComposerAnalyticsEventBuilder("composer_media_picker_selection_change").m11124h(str);
        ArrayNode b = JsonNodeFactory.a.b();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            b.h((String) immutableList.get(i));
        }
        h.f7777a.a(z ? "video_items_added" : "photo_items_added", b);
        h.m11110b(immutableList2, z2);
        this.f7779a.a(h.f7777a);
    }

    public final void m11146a(String str, long j) {
        ComposerAnalyticsEventBuilder h = new ComposerAnalyticsEventBuilder("composer_first_character_typed").m11124h(str);
        h.f7777a.a("written_time", j);
        this.f7779a.a(h.f7777a);
    }

    public final void m11157a(String str, String str2) {
        ComposerAnalyticsEventBuilder h = new ComposerAnalyticsEventBuilder("text_only_place_posted").m11124h(str);
        h.f7777a.b("text_only_name", str2);
        this.f7779a.a(h.f7777a);
    }

    public final void m11160c(String str) {
        this.f7779a.a(new ComposerAnalyticsEventBuilder("composer_selectable_privacy_pill_clicked").m11124h(str).f7777a);
    }

    @Inject
    public ComposerAnalyticsLogger(AnalyticsLogger analyticsLogger, FbNetworkManager fbNetworkManager, FbDataConnectionManager fbDataConnectionManager) {
        this.f7779a = analyticsLogger;
        this.f7780b = fbNetworkManager;
        this.f7781c = fbDataConnectionManager;
    }

    public final void m11142a(Events events) {
        AnalyticsLogger analyticsLogger = this.f7779a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(events.name);
        honeyClientEvent.c = "composer";
        analyticsLogger.a(honeyClientEvent);
    }

    public final void m11143a(Events events, String str) {
        AnalyticsLogger analyticsLogger = this.f7779a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(events.name);
        honeyClientEvent.c = "composer";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.f = str;
        analyticsLogger.a(honeyClientEvent);
    }

    public final void m11158a(String str, String str2, boolean z) {
        ComposerAnalyticsEventBuilder composerAnalyticsEventBuilder;
        if (z) {
            composerAnalyticsEventBuilder = new ComposerAnalyticsEventBuilder("remove_video");
            composerAnalyticsEventBuilder.m11110b(ImmutableList.of(str2), true);
        } else {
            composerAnalyticsEventBuilder = new ComposerAnalyticsEventBuilder("remove_photo");
            composerAnalyticsEventBuilder.m11110b(ImmutableList.of(str2), false);
        }
        composerAnalyticsEventBuilder.m11124h(str);
        this.f7779a.a(composerAnalyticsEventBuilder.f7777a);
    }

    public final void m11156a(String str, ImmutableMap<String, Integer> immutableMap, String str2, ComposerSourceType composerSourceType, ComposerType composerType, long j, int i, boolean z, @Nullable String str3, boolean z2) {
        ComposerAnalyticsEventBuilder p = ComposerAnalyticsEventBuilder.m11097h().m11124h(str).m11126i(this.f7780b.p()).m11105a((ImmutableMap) immutableMap).m11130l(str2).m11102a(composerSourceType).m11103a(composerType).m11099a(j).m11117d(i).m11127i(z).m11133p(str3);
        p.f7777a.a("is_saving_draft", z2);
        this.f7779a.a(p.m11139y());
    }

    public final void m11145a(String str, int i, long j, long j2, Multiset<ComposerTaskId> multiset, boolean z, ComposerType composerType, int i2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, ImmutableMap<String, Integer> immutableMap, String str2, int i3) {
        this.f7779a.a(ComposerAnalyticsEventBuilder.m11097h().m11124h(str).m11126i(this.f7780b.p()).m11108b(i).m11099a(j).m11109b(j).m11114c(j2).m11106a((Multiset) multiset).m11112b(z).m11103a(composerType).m11113c(i2).m11119d(z2).m11121e(z3).m11122f(z4).m11123g(z5).m11125h(z6).m11105a((ImmutableMap) immutableMap).m11130l(str2).m11117d(i3).m11139y());
    }

    public final void m11148a(String str, ComposerSourceType composerSourceType, ComposerType composerType, TargetType targetType, long j, long j2, int i, Multiset<ComposerTaskId> multiset, boolean z, boolean z2) {
        this.f7779a.a(ComposerAnalyticsEventBuilder.m11095b().m11124h(str).m11126i(this.f7780b.p()).m11102a(composerSourceType).m11103a(composerType).m11104a(targetType).m11099a(j).m11114c(j2).m11108b(i).m11106a((Multiset) multiset).m11112b(z).m11116c(z2).m11139y());
    }

    public final void m11149a(String str, ComposerSourceType composerSourceType, ComposerType composerType, TargetType targetType, long j, Multiset<ComposerTaskId> multiset, ImmutableMap<String, Integer> immutableMap, String str2, int i, boolean z, String str3, int i2, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this.f7779a.a(ComposerAnalyticsEventBuilder.m11096c().m11124h(str).m11126i(this.f7780b.p()).m11102a(composerSourceType).m11103a(composerType).m11104a(targetType).m11099a(j).m11106a((Multiset) multiset).m11105a((ImmutableMap) immutableMap).m11130l(str2).m11117d(i).m11127i(z).m11132n(str3).m11120e(i2).m11133p(str4).m11134q(str5).m11137t(str6).m11139y());
    }

    public final void m11144a(Events events, String str, long j, ComposerType composerType) {
        this.f7779a.a(new ComposerAnalyticsEventBuilder(events.name).m11124h(str).m11099a(j).m11103a(composerType).f7777a);
    }

    public final void m11159b(Events events, String str, long j, ComposerType composerType) {
        boolean z = Events.COMPOSER_DISCARD_DIALOG_DISPLAYED.equals(events) || Events.COMPOSER_DISCARD_DIALOG_DISMISSED.equals(events);
        Preconditions.checkArgument(z, events.name + " is not a discard dialog event");
        this.f7779a.a(new ComposerAnalyticsEventBuilder(events.name).m11124h(str).m11099a(j).m11103a(composerType).f7777a);
    }
}
