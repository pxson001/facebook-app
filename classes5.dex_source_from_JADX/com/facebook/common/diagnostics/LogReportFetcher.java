package com.facebook.common.diagnostics;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.File;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: storyId */
public class LogReportFetcher {
    private final LogcatFbSdcardLogger f2515a;
    private final Provider<Boolean> f2516b;

    public static LogReportFetcher m3639b(InjectorLike injectorLike) {
        return new LogReportFetcher(LogcatFbSdcardLogger.a(injectorLike), IdBasedProvider.a(injectorLike, 3925));
    }

    @Inject
    public LogReportFetcher(LogcatFbSdcardLogger logcatFbSdcardLogger, Provider<Boolean> provider) {
        this.f2515a = logcatFbSdcardLogger;
        this.f2516b = provider;
    }

    public final ImmutableList<File> m3640a(int i) {
        Builder builder = ImmutableList.builder();
        if (((Boolean) this.f2516b.get()).booleanValue()) {
            List a = this.f2515a.a();
            builder.b(a.subList(0, Math.min(i, a.size())));
        }
        return builder.b();
    }
}
