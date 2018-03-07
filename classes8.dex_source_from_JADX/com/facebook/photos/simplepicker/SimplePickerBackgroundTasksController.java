package com.facebook.photos.simplepicker;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.TimeConversions;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.Assisted;
import com.facebook.ipc.media.SupportedMediaType;
import com.facebook.ipc.photos.PhotosContract;
import com.facebook.photos.local.MediaCursorUtil;
import com.facebook.photos.prefs.PhotosPrefKeys;
import com.facebook.photos.simplepicker.controller.SimplePickerDataLoadUtil;
import com.facebook.photos.simplepicker.logging.MediaStatsLoggingManager;
import com.facebook.photos.simplepicker.logging.SimplePickerAssetLogger;
import com.facebook.photos.simplepicker.nux.SimplePickerNuxManager;
import com.facebook.photos.tagging.store.TaggableLocalMediaUtil;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: similar_places */
public class SimplePickerBackgroundTasksController {
    private final int f2868a = 3;
    private final long f2869b = 259200;
    public final ExecutorService f2870c;
    public final Executor f2871d;
    public final TaggableLocalMediaUtil f2872e;
    public final SimplePickerNuxManager f2873f;
    public final SimplePickerDataLoadUtil f2874g;
    public final GatekeeperStoreImpl f2875h;
    public FbSharedPreferences f2876i;
    public final MediaCursorUtil f2877j;
    public final MediaStatsLoggingManager f2878k;
    public final Clock f2879l;

    /* compiled from: similar_places */
    public class C03681 implements Runnable {
        final /* synthetic */ SimplePickerBackgroundTasksController f2861a;

        public C03681(SimplePickerBackgroundTasksController simplePickerBackgroundTasksController) {
            this.f2861a = simplePickerBackgroundTasksController;
        }

        public void run() {
            TaggableLocalMediaUtil taggableLocalMediaUtil = this.f2861a.f2872e;
            String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("%s <= %s AND %s > 0", "image_hash", Long.valueOf(((Clock) taggableLocalMediaUtil.c.get()).a() - TimeUnit.MILLISECONDS.convert(7, TimeUnit.DAYS)), "image_hash");
            Uri uri = ((PhotosContract) taggableLocalMediaUtil.a.get()).d;
            ContentProviderClient acquireContentProviderClient = ((ContentResolver) taggableLocalMediaUtil.b.get()).acquireContentProviderClient(uri);
            if (acquireContentProviderClient != null) {
                ((ContentResolver) taggableLocalMediaUtil.b.get()).delete(uri, formatStrLocaleSafe, null);
                acquireContentProviderClient.release();
            }
        }
    }

    /* compiled from: similar_places */
    public class C03692 implements Runnable {
        final /* synthetic */ SimplePickerBackgroundTasksController f2862a;

        public C03692(SimplePickerBackgroundTasksController simplePickerBackgroundTasksController) {
            this.f2862a = simplePickerBackgroundTasksController;
        }

        public void run() {
            this.f2862a.f2872e.c();
        }
    }

    /* compiled from: similar_places */
    public class C03703 implements Runnable {
        final /* synthetic */ SimplePickerBackgroundTasksController f2863a;

        public C03703(SimplePickerBackgroundTasksController simplePickerBackgroundTasksController) {
            this.f2863a = simplePickerBackgroundTasksController;
        }

        public void run() {
            this.f2863a.f2878k.m3165a();
        }
    }

    /* compiled from: similar_places */
    public class C03714 implements Runnable {
        final /* synthetic */ long f2864a;
        final /* synthetic */ SimplePickerBackgroundTasksController f2865b;

        public C03714(SimplePickerBackgroundTasksController simplePickerBackgroundTasksController, long j) {
            this.f2865b = simplePickerBackgroundTasksController;
            this.f2864a = j;
        }

        public void run() {
            SimplePickerDataLoadUtil simplePickerDataLoadUtil = this.f2865b.f2874g;
            Cursor a = simplePickerDataLoadUtil.f3130d.a(SupportedMediaType.VIDEO_ONLY, null);
            Cursor a2 = simplePickerDataLoadUtil.f3130d.a(SupportedMediaType.ALL, null);
            SimplePickerAssetLogger simplePickerAssetLogger = simplePickerDataLoadUtil.f3135i;
            int count = a.getCount();
            int count2 = a2.getCount();
            if (simplePickerAssetLogger.f3185c) {
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("composer_asset_count");
                honeyClientEvent.b("reachability_status", simplePickerAssetLogger.f3184b.p());
                honeyClientEvent.a("num_video_assets", count);
                honeyClientEvent.a("num_assets", count2);
                simplePickerAssetLogger.f3183a.a(honeyClientEvent);
                simplePickerAssetLogger.f3185c = false;
            }
            a.close();
            a2.close();
            this.f2865b.f2876i.edit().a(PhotosPrefKeys.h, this.f2864a).commit();
        }
    }

    /* compiled from: similar_places */
    public class C03735 implements Runnable {
        final /* synthetic */ SimplePickerBackgroundTasksController f2867a;

        /* compiled from: similar_places */
        class C03721 implements Runnable {
            final /* synthetic */ C03735 f2866a;

            C03721(C03735 c03735) {
                this.f2866a = c03735;
            }

            public void run() {
                this.f2866a.f2867a.f2873f.m3184c();
            }
        }

        public C03735(SimplePickerBackgroundTasksController simplePickerBackgroundTasksController) {
            this.f2867a = simplePickerBackgroundTasksController;
        }

        public void run() {
            if (TimeConversions.m(this.f2867a.f2879l.a()) - this.f2867a.f2877j.a() <= 259200) {
                ExecutorDetour.a(this.f2867a.f2871d, new C03721(this), 699639776);
            }
        }
    }

    @Inject
    public SimplePickerBackgroundTasksController(ExecutorService executorService, Executor executor, @Assisted SimplePickerNuxManager simplePickerNuxManager, TaggableLocalMediaUtil taggableLocalMediaUtil, SimplePickerDataLoadUtil simplePickerDataLoadUtil, GatekeeperStoreImpl gatekeeperStoreImpl, FbSharedPreferences fbSharedPreferences, MediaCursorUtil mediaCursorUtil, MediaStatsLoggingManager mediaStatsLoggingManager, Clock clock) {
        this.f2870c = executorService;
        this.f2871d = executor;
        this.f2872e = taggableLocalMediaUtil;
        this.f2873f = simplePickerNuxManager;
        this.f2874g = simplePickerDataLoadUtil;
        this.f2875h = gatekeeperStoreImpl;
        this.f2876i = fbSharedPreferences;
        this.f2877j = mediaCursorUtil;
        this.f2878k = mediaStatsLoggingManager;
        this.f2879l = clock;
    }
}
