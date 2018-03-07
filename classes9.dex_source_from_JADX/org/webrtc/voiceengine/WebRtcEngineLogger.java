package org.webrtc.voiceengine;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: after_time_ms */
public class WebRtcEngineLogger {
    public int f21206a = 0;
    public WebRtcEngineLoggerDelegate f21207b = null;

    WebRtcEngineLogger(WebRtcEngineLoggerDelegate webRtcEngineLoggerDelegate) {
        this.f21207b = webRtcEngineLoggerDelegate;
    }

    @DoNotStrip
    public void setNativeTraceLevel(int i) {
        this.f21206a = i;
    }

    protected final void m21642a(String str, Object... objArr) {
        m21640a(2, str, objArr);
    }

    protected final void m21643b(String str, Object... objArr) {
        m21640a(32, str, objArr);
    }

    protected final void m21644c(String str, Object... objArr) {
        m21640a(64, str, objArr);
    }

    protected final void m21641a(String str, Throwable th) {
        if (64 >= this.f21206a) {
            if (th == null || th.getMessage() == null) {
                this.f21207b.mo928a(64, str);
                return;
            }
            this.f21207b.mo928a(64, StringFormatUtil.formatStrLocaleSafe("%s (%s)", str, th.getMessage()));
        }
    }

    private void m21640a(int i, String str, Object... objArr) {
        if (i >= this.f21206a) {
            this.f21207b.mo928a(i, StringFormatUtil.a(str, objArr));
        }
    }
}
