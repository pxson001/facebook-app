package org.whispersystems.libsignal.logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.UnknownHostException;

/* compiled from: actn_edit_product_click */
public class Log {
    private Log() {
    }

    public static void m21752a(String str, Throwable th) {
        if (th == null) {
            String str2 = "";
            return;
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                str2 = "";
                return;
            }
        }
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        str2 = stringWriter.toString();
    }
}
