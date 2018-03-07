package com.facebook.photos.base.analytics.bugreporter;

import com.facebook.bugreporter.BugReportExtraDataMapProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.reportaproblem.base.bugreport.file.BugReportBackgroundDataProvider;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: insert_mentions */
public class PhotosBugReportExtraDataMapProvider implements BugReportExtraDataMapProvider, BugReportBackgroundDataProvider {
    PhotosBugReportExtraDataCollector f12667a;

    public static PhotosBugReportExtraDataMapProvider m20072b(InjectorLike injectorLike) {
        return new PhotosBugReportExtraDataMapProvider(PhotosBugReportExtraDataCollector.m20068a(injectorLike));
    }

    @Inject
    public PhotosBugReportExtraDataMapProvider(PhotosBugReportExtraDataCollector photosBugReportExtraDataCollector) {
        this.f12667a = photosBugReportExtraDataCollector;
    }

    public final Map<String, String> m20073b() {
        return m20075d();
    }

    public final Map<String, String> m20074c() {
        return ImmutableMap.builder().b();
    }

    public final Map<String, String> m20075d() {
        return this.f12667a.m20070a();
    }
}
