package com.facebook.messaging.media.upload;

import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.upload.config.MediaUploadXConfig;
import com.facebook.xconfig.core.XConfigReader;
import javax.inject.Inject;

/* compiled from: location_fetcher */
public class MaxVideoSizeHelper {
    private final XConfigReader f11839a;

    public static MaxVideoSizeHelper m12454b(InjectorLike injectorLike) {
        return new MaxVideoSizeHelper(XConfigReader.a(injectorLike));
    }

    @Inject
    public MaxVideoSizeHelper(XConfigReader xConfigReader) {
        this.f11839a = xConfigReader;
    }

    public final int m12455a() {
        return this.f11839a.a(MediaUploadXConfig.e, 16777216);
    }
}
