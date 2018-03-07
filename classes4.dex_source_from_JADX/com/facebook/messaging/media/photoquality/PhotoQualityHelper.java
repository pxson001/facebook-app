package com.facebook.messaging.media.photoquality;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.bandwidth.MediaBandwidthManager;
import com.facebook.messaging.media.photoquality.PhotoQualityUploadPrefs.FullQualitySendSetting;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.ui.media.attachments.MediaResource;
import javax.inject.Inject;

/* compiled from: mCampaignId */
public class PhotoQualityHelper {
    public final GatekeeperStoreImpl f8754a;
    private final MediaBandwidthManager f8755b;
    private final PhotoQualityServiceHandler f8756c;
    private final Resources f8757d;
    private final FbSharedPreferences f8758e;

    public static PhotoQualityHelper m9074b(InjectorLike injectorLike) {
        return new PhotoQualityHelper(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), MediaBandwidthManager.m9026a(injectorLike), PhotoQualityServiceHandler.m9079a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public PhotoQualityHelper(GatekeeperStoreImpl gatekeeperStoreImpl, MediaBandwidthManager mediaBandwidthManager, PhotoQualityServiceHandler photoQualityServiceHandler, Resources resources, FbSharedPreferences fbSharedPreferences) {
        this.f8754a = gatekeeperStoreImpl;
        this.f8755b = mediaBandwidthManager;
        this.f8756c = photoQualityServiceHandler;
        this.f8757d = resources;
        this.f8758e = fbSharedPreferences;
    }

    public final int m9075a() {
        if (m9078b()) {
            return 10000;
        }
        return 2048;
    }

    public static PhotoQualityHelper m9072a(InjectorLike injectorLike) {
        return m9074b(injectorLike);
    }

    public final PhotoQuality m9076a(ThreadKey threadKey) {
        if (m9078b()) {
            return PhotoQuality.a;
        }
        if (threadKey != null && this.f8754a.a(296, false)) {
            PhotoQuality photoQuality;
            PhotoQualityServiceHandler photoQualityServiceHandler = this.f8756c;
            PhotoQualityServiceHandler.m9081c(photoQualityServiceHandler, threadKey);
            PhotoQualityCacheItem photoQualityCacheItem = (PhotoQualityCacheItem) photoQualityServiceHandler.f8767h.a(threadKey);
            if (photoQualityCacheItem != null) {
                photoQuality = photoQualityCacheItem.a;
            } else {
                photoQuality = null;
            }
            PhotoQuality photoQuality2 = photoQuality;
            if (photoQuality2 != null && photoQuality2.b > 0) {
                return photoQuality2;
            }
        }
        return new PhotoQuality(Math.min(2048, Math.max(960, Math.max(this.f8757d.getDisplayMetrics().heightPixels, this.f8757d.getDisplayMetrics().widthPixels))));
    }

    public final PhotoQuality m9077b(ThreadKey threadKey) {
        if (threadKey != null && this.f8754a.a(296, false)) {
            PhotoQuality photoQuality;
            PhotoQualityCacheItem photoQualityCacheItem = (PhotoQualityCacheItem) this.f8756c.f8767h.a(threadKey);
            if (photoQualityCacheItem != null) {
                photoQuality = photoQualityCacheItem.b;
            } else {
                photoQuality = null;
            }
            PhotoQuality photoQuality2 = photoQuality;
            if (photoQuality2 != null && photoQuality2.b > 0) {
                return photoQuality2;
            }
        }
        return new PhotoQuality(720);
    }

    public static int m9071a(int i) {
        return Math.min(Math.max((int) ((-0.015625f * ((float) (i - 960))) + 85.0f), 55), 95);
    }

    public final boolean m9078b() {
        if (this.f8754a.a(226, false)) {
            int parseInt = Integer.parseInt(this.f8758e.a(PhotoQualityUploadPrefs.f8771b, String.valueOf(FullQualitySendSetting.NEVER.value)));
            if (this.f8755b.m9034c() && parseInt == FullQualitySendSetting.WIFI_ONLY.value) {
                return true;
            }
        }
        return false;
    }

    public static boolean m9073a(MediaResource mediaResource) {
        return mediaResource.p <= 25000000 && mediaResource.k * mediaResource.j <= 50000000;
    }
}
