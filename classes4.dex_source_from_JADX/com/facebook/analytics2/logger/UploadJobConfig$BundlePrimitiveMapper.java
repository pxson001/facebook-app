package com.facebook.analytics2.logger;

import android.os.Bundle;
import com.facebook.analytics2.logger.UploadJobConfig.PrimitiveMapWriter;

/* compiled from: wifi_connected */
public class UploadJobConfig$BundlePrimitiveMapper implements UploadJobConfig$PrimitiveMapReader, PrimitiveMapWriter<Bundle> {
    private final Bundle f103a;

    public UploadJobConfig$BundlePrimitiveMapper(Bundle bundle) {
        this.f103a = bundle;
    }

    public final Object m108a() {
        return this.f103a;
    }

    public final String mo15a(String str, String str2) {
        return this.f103a.getString(str, str2);
    }

    public final int mo14a(String str, int i) {
        return this.f103a.getInt(str, i);
    }

    public final void a_(String str, String str2) {
        this.f103a.putString(str, str2);
    }

    public final void a_(String str, int i) {
        this.f103a.putInt(str, i);
    }
}
