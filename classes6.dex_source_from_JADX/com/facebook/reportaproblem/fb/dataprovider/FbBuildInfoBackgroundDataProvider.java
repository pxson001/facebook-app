package com.facebook.reportaproblem.fb.dataprovider;

import com.facebook.common.build.SignatureType;
import com.facebook.common.manifest.AppBuildInfo;
import com.facebook.reportaproblem.base.bugreport.file.BugReportBackgroundDataProvider;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: setLegacyApiStoryId */
public class FbBuildInfoBackgroundDataProvider implements BugReportBackgroundDataProvider {
    private final AppBuildInfo f4624a;
    private final SignatureType f4625b;

    @Inject
    public FbBuildInfoBackgroundDataProvider(AppBuildInfo appBuildInfo, SignatureType signatureType) {
        this.f4624a = appBuildInfo;
        this.f4625b = signatureType;
    }

    public final Map<String, String> m7136b() {
        Map<String, String> d = Maps.d();
        d.put("Git_Hash", this.f4624a.a);
        if (this.f4625b != SignatureType.PROD) {
            d.put("Git_Branch", this.f4624a.b);
            d.put("Build_Time", this.f4624a.d);
        }
        return d;
    }
}
