package com.facebook.ui.errordialog;

import android.content.Context;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: comments_disabled_notice */
public class ErrorReportSender {
    public final Context f5475a;

    private static ErrorReportSender m10342b(InjectorLike injectorLike) {
        return new ErrorReportSender((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public ErrorReportSender(Context context) {
        this.f5475a = context;
    }
}
