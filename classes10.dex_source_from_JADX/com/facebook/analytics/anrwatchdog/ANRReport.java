package com.facebook.analytics.anrwatchdog;

import android.content.Context;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.StackTraceDumper;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.inject.ForAppContext;
import com.facebook.quicklog.QuickPerformanceLogger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.inject.Inject;

/* compiled from: emoji_message */
public class ANRReport {
    private final Context f14492a;
    private final AbstractFbErrorReporter f14493b;
    private final File f14494c;
    private final QuickPerformanceLogger f14495d;

    @Inject
    public ANRReport(@ForAppContext Context context, AbstractFbErrorReporter abstractFbErrorReporter, QuickPerformanceLogger quickPerformanceLogger) {
        this.f14492a = context;
        this.f14493b = abstractFbErrorReporter;
        this.f14495d = quickPerformanceLogger;
        this.f14494c = new File(context.getDir("traces", 0), SafeUUIDGenerator.a().toString() + ".stacktrace");
    }

    public final void m14664a() {
        this.f14495d.b(8192002);
        try {
            Throwable th;
            OutputStream fileOutputStream = new FileOutputStream(this.f14494c);
            Throwable th2 = null;
            try {
                StackTraceDumper.a(fileOutputStream);
                this.f14494c.getAbsolutePath();
                Long.valueOf(this.f14494c.length());
                this.f14493b.a();
                this.f14495d.b(8192002, (short) 2);
                fileOutputStream.close();
                return;
            } catch (Throwable th22) {
                Throwable th3 = th22;
                th22 = th;
                th = th3;
            }
            if (th22 != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                fileOutputStream.close();
            }
            throw th;
            throw th;
        } catch (IOException e) {
            this.f14495d.b(8192002, (short) 3);
            throw e;
        }
    }
}
