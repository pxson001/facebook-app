package com.facebook.common.diagnostics;

import android.content.Context;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: storyAttachment */
public class LogReportSender {
    private final Context f2517a;
    private final SecureContextHelper f2518b;
    private final LogReportFetcher f2519c;

    private static LogReportSender m3641b(InjectorLike injectorLike) {
        return new LogReportSender((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), LogReportFetcher.m3639b(injectorLike));
    }

    @Inject
    public LogReportSender(Context context, SecureContextHelper secureContextHelper, LogReportFetcher logReportFetcher) {
        this.f2517a = context;
        this.f2518b = secureContextHelper;
        this.f2519c = logReportFetcher;
    }
}
