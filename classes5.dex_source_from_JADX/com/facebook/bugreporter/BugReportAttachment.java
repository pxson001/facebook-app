package com.facebook.bugreporter;

import android.net.Uri;
import java.io.OutputStream;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: android.speech.extra.LANGUAGE */
public class BugReportAttachment {
    public final OutputStream f10429a;
    private final Uri f10430b;

    BugReportAttachment(Uri uri, OutputStream outputStream) {
        this.f10429a = outputStream;
        this.f10430b = uri;
    }

    public final OutputStream m18526a() {
        return this.f10429a;
    }

    public final Uri m18527b() {
        return this.f10430b;
    }
}
