package android.support.v4.util;

import android.util.Log;
import java.io.Writer;

/* compiled from: video_transcoding_error */
public class LogWriter extends Writer {
    private final String f268a;
    private StringBuilder f269b = new StringBuilder(128);

    public LogWriter(String str) {
        this.f268a = str;
    }

    public void close() {
        m288a();
    }

    public void flush() {
        m288a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m288a();
            } else {
                this.f269b.append(c);
            }
        }
    }

    private void m288a() {
        if (this.f269b.length() > 0) {
            Log.d(this.f268a, this.f269b.toString());
            this.f269b.delete(0, this.f269b.length());
        }
    }
}
