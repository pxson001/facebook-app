package com.facebook.messaging.media.upload;

import java.util.HashMap;
import java.util.Map;

/* compiled from: lifetime */
public class ResumableUploadMetricsBuilder {
    private final Map<String, String> f12022a = new HashMap();

    /* compiled from: lifetime */
    public enum UploadStatus {
        START_UPLOAD,
        FILE_KEY_COMPUTED,
        UPLOAD_STARTED,
        TIMED_OUT_UPLOAD,
        USER_CANCELLED,
        VIDEO_UPLOAD_COMPLETED,
        TIMED_OUT_POST_PROCESS,
        VIDEO_POST_PROCESS_COMPLETED
    }

    public ResumableUploadMetricsBuilder() {
        this.f12022a.put("num_fetching_offset", "0");
        this.f12022a.put("num_send_bytes", "0");
    }

    public final void m12563a(UploadStatus uploadStatus) {
        this.f12022a.put("upload_state", uploadStatus.toString());
    }

    public final void m12562a(long j) {
        this.f12022a.put("media_size", Long.toString(j));
    }

    public final void m12564a(String str, String str2) {
        this.f12022a.put("upload_fail_exception", str);
        this.f12022a.put("upload_fail_cause", str2);
    }

    public final void m12561a() {
        this.f12022a.put("num_fetching_offset", Long.toString(Long.valueOf(Long.parseLong((String) this.f12022a.get("num_fetching_offset"))).longValue() + 1));
    }

    public final void m12565b() {
        this.f12022a.put("num_send_bytes", Long.toString(Long.valueOf(Long.parseLong((String) this.f12022a.get("num_send_bytes"))).longValue() + 1));
    }

    public final Map<String, String> m12566c() {
        return this.f12022a;
    }
}
