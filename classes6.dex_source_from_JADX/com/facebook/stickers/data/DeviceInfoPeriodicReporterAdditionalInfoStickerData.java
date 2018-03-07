package com.facebook.stickers.data;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.reporters.periodic.DeviceInfoPeriodicReporterAdditionalInfo;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: empty resized file */
public class DeviceInfoPeriodicReporterAdditionalInfoStickerData implements DeviceInfoPeriodicReporterAdditionalInfo {
    private final StickersFileUtil f16484a;
    private final MoreFileUtils f16485b;
    private final Provider<Boolean> f16486c;

    private static DeviceInfoPeriodicReporterAdditionalInfoStickerData m23954b(InjectorLike injectorLike) {
        return new DeviceInfoPeriodicReporterAdditionalInfoStickerData(StickersFileUtil.a(injectorLike), MoreFileUtils.a(injectorLike), IdBasedProvider.a(injectorLike, 4342));
    }

    @Inject
    public DeviceInfoPeriodicReporterAdditionalInfoStickerData(StickersFileUtil stickersFileUtil, MoreFileUtils moreFileUtils, Provider<Boolean> provider) {
        this.f16484a = stickersFileUtil;
        this.f16485b = moreFileUtils;
        this.f16486c = provider;
    }

    public final void m23955a(HoneyClientEvent honeyClientEvent) {
        long j = 0;
        File a = this.f16484a.a();
        if (a != null) {
            j = this.f16485b.d(a);
        }
        honeyClientEvent.a("sticker_disk_cache_size", j);
        honeyClientEvent.a("can_save_sticker_assets_to_disk", this.f16486c.get());
    }
}
