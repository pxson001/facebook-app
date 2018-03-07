package com.facebook.rtc.logging;

import com.facebook.common.util.ExceptionUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

/* compiled from: null and empty keys are not allowed */
public class WebrtcLoggingHandler$2 implements Runnable {
    final /* synthetic */ String f7786a;
    final /* synthetic */ long f7787b;
    final /* synthetic */ WebrtcLoggingHandler f7788c;

    public WebrtcLoggingHandler$2(WebrtcLoggingHandler webrtcLoggingHandler, String str, long j) {
        this.f7788c = webrtcLoggingHandler;
        this.f7786a = str;
        this.f7787b = j;
    }

    public void run() {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        OutputStream outputStream;
        FileOutputStream fileOutputStream = null;
        try {
            WebrtcLoggingHandler.a(this.f7788c, WebrtcLoggingHandler.b(this.f7788c, this.f7786a));
            File a = WebrtcLoggingHandler.a(this.f7788c, this.f7787b, this.f7788c.J);
            try {
                this.f7788c.f();
                HashMap a2 = this.f7788c.a(this.f7787b, this.f7786a);
                OutputStream fileOutputStream2 = new FileOutputStream(a);
                try {
                    objectOutputStream = new ObjectOutputStream(fileOutputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    objectOutputStream = null;
                    outputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    throw th;
                }
                try {
                    objectOutputStream.writeObject(a2);
                    fileOutputStream2.close();
                    objectOutputStream.close();
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                objectOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th5) {
            Throwable th6 = th5;
            this.f7788c.a("Unable to save call summary: " + (th6.getMessage() == null) + " " + ExceptionUtil.a(th6));
        }
    }
}
