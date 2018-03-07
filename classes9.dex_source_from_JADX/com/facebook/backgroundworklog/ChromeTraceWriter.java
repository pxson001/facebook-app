package com.facebook.backgroundworklog;

import com.facebook.debug.log.BLog;
import com.google.common.base.Throwables;
import java.io.BufferedWriter;
import java.io.IOException;
import org.json.JSONObject;

/* compiled from: select_latitude */
public class ChromeTraceWriter {
    private static final Class<?> f4236a = ChromeTraceWriter.class;
    private BufferedWriter f4237b;
    private IOException f4238c;

    ChromeTraceWriter() {
    }

    public final synchronized void m4245a(BackgroundWorkEvent backgroundWorkEvent) {
        if (this.f4237b != null) {
            try {
                JSONObject d = backgroundWorkEvent.m4243d();
                JSONObject e = backgroundWorkEvent.m4244e();
                this.f4237b.write(d.toString());
                this.f4237b.write(",\n");
                this.f4237b.write(e.toString());
                this.f4237b.write(",\n");
            } catch (Throwable e2) {
                throw Throwables.propagate(e2);
            } catch (Throwable e22) {
                BLog.b(f4236a, e22, "failed writing trace event", new Object[0]);
                if (this.f4238c == null) {
                    this.f4238c = e22;
                }
            }
        }
    }
}
