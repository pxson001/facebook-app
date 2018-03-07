package com.facebook.resources.impl.loading;

import com.facebook.common.file.MoreFileUtils;
import com.facebook.inject.Lazy;
import com.facebook.resources.impl.FbResourcesLogger;
import com.facebook.resources.impl.loading.LanguagePackLoader.Delegate;
import java.io.File;
import java.io.InputStream;
import javax.inject.Inject;

/* compiled from: thread_suggestion/ */
public class DownloadableLanguagePackLoaderDelegate implements Delegate {
    private final FbResourcesLogger f3030a;
    private final Lazy<LanguagePackDownloader> f3031b;
    private final LanguageFileResolver f3032c;
    private final MoreFileUtils f3033d;
    private final LanguageFilesCleaner f3034e;

    @Inject
    public DownloadableLanguagePackLoaderDelegate(FbResourcesLogger fbResourcesLogger, Lazy<LanguagePackDownloader> lazy, LanguageFileResolver languageFileResolver, MoreFileUtils moreFileUtils, LanguageFilesCleaner languageFilesCleaner) {
        this.f3030a = fbResourcesLogger;
        this.f3031b = lazy;
        this.f3032c = languageFileResolver;
        this.f3033d = moreFileUtils;
        this.f3034e = languageFilesCleaner;
    }

    public final InputStream mo691a(LanguageRequest languageRequest) {
        this.f3034e.m5041a();
        File a = this.f3032c.m5022a(languageRequest);
        if (!a.exists()) {
            ((LanguagePackDownloader) this.f3031b.get()).a(languageRequest, a);
        }
        return MoreFileUtils.m5028a(a);
    }

    public final void mo692a() {
        this.f3030a.m2753d();
    }

    public final void mo693b() {
        this.f3030a.m2755e();
    }

    public final void mo695c() {
        this.f3030a.m2757f();
    }

    public final void mo694b(LanguageRequest languageRequest) {
        this.f3032c.m5022a(languageRequest).delete();
    }
}
