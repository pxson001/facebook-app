package com.facebook.common.jobscheduler.compat;

import android.content.Context;
import android.content.pm.PackageItemInfo;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: messenger_media_upload_request_started */
class GmsMetadataReader {
    @GuardedBy("GmsMetadataReader.class")
    private static Boolean f7949a;

    GmsMetadataReader() {
    }

    public static synchronized boolean m8278a(Context context) {
        boolean booleanValue;
        synchronized (GmsMetadataReader.class) {
            if (f7949a == null) {
                try {
                    PackageItemInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getApplicationInfo().packageName, 128);
                    if (applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("com.google.android.gms.version")) {
                        f7949a = Boolean.FALSE;
                    } else {
                        f7949a = Boolean.TRUE;
                    }
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
            booleanValue = f7949a.booleanValue();
        }
        return booleanValue;
    }
}
