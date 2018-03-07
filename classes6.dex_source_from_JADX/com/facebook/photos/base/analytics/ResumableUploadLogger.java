package com.facebook.photos.base.analytics;

import android.util.Log;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.InjectorLike;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: integration_point_id=%s */
public class ResumableUploadLogger {
    private static final Class<?> f12647a = ResumableUploadLogger.class;
    private static final boolean f12648b = Log.isLoggable("ResumableUploadLogger", 3);
    private final AnalyticsLogger f12649c;

    /* compiled from: integration_point_id=%s */
    enum Event {
        FBUPLOAD_FILE_UPLOAD_STARTED("fbupload_file_upload_started"),
        FBUPLOAD_FILE_UPLOAD_SUCCEEDED("fbupload_file_upload_succeeded"),
        FBUPLOAD_FILE_UPLOAD_FAILED("fbupload_file_upload_failed"),
        RESUMABLE_UPLOAD_SUCCEEDED("resumable_upload_succeeded"),
        RESUMABLE_UPLOAD_FAILED("resumable_upload_failed");
        
        private final String mName;

        private Event(String str) {
            this.mName = str;
        }

        public final String toString() {
            return this.mName;
        }
    }

    public static ResumableUploadLogger m20004b(InjectorLike injectorLike) {
        return new ResumableUploadLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    public static ResumableUploadLogger m20000a(InjectorLike injectorLike) {
        return m20004b(injectorLike);
    }

    @Inject
    public ResumableUploadLogger(AnalyticsLogger analyticsLogger) {
        this.f12649c = analyticsLogger;
    }

    private static String m20001a(boolean z) {
        return z ? "resumable_upload" : "control";
    }

    public final void m20010a(boolean z, boolean z2, boolean z3, long j, String str) {
        m20003a(Event.FBUPLOAD_FILE_UPLOAD_STARTED, m20005b(z, z2, z3, j, str));
    }

    public final void m20008a(boolean z, boolean z2, boolean z3, int i, long j, long j2, String str) {
        Map b = m20005b(z, z2, z3, j2, str);
        b.put("duration_millis", Long.toString(j));
        b.put("num_fallbacks", Integer.toString(i));
        m20003a(Event.FBUPLOAD_FILE_UPLOAD_SUCCEEDED, b);
    }

    public final void m20009a(boolean z, boolean z2, boolean z3, int i, long j, long j2, String str, String str2) {
        Map b = m20005b(z, z2, z3, j2, str);
        b.put("error", str2);
        b.put("duration_millis", Long.toString(j));
        b.put("num_fallbacks", Integer.toString(i));
        m20003a(Event.FBUPLOAD_FILE_UPLOAD_FAILED, b);
    }

    public final void m20006a(String str, String str2, String str3, long j, long j2, long j3, String str4) {
        Map a = m20002a(str, str2, j, j2, j3, str4);
        a.put("result_handle", str3);
        m20003a(Event.RESUMABLE_UPLOAD_SUCCEEDED, a);
    }

    public final void m20007a(String str, String str2, String str3, boolean z, long j, long j2, long j3, long j4, String str4) {
        Map a = m20002a(str, str2, j2, j3, j4, str4);
        a.put("error", str3);
        a.put("is_cancellation", Boolean.toString(z));
        a.put("bytes_transferred", Long.toString(j));
        m20003a(Event.RESUMABLE_UPLOAD_FAILED, a);
    }

    private static HashMap<String, String> m20005b(boolean z, boolean z2, boolean z3, long j, String str) {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("experiment_group", m20001a(z));
        hashMap.put("using_new_chunk_flow", Boolean.toString(z2));
        hashMap.put("fallback_enabled", Boolean.toString(z3));
        hashMap.put("file_size", Long.toString(j));
        hashMap.put("waterfall_id", str);
        hashMap.put("media_type", "video");
        return hashMap;
    }

    private static HashMap<String, String> m20002a(String str, String str2, long j, long j2, long j3, String str3) {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("namespace", str);
        hashMap.put("file_key", str2);
        hashMap.put("experiment_group", m20001a(true));
        hashMap.put("duration_millis", Long.toString(j));
        hashMap.put("file_size", Long.toString(j2));
        hashMap.put("total_file_size", Long.toString(j3));
        hashMap.put("waterfall_id", str3);
        hashMap.put("media_type", "video");
        return hashMap;
    }

    private void m20003a(Event event, Map<String, String> map) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(event.toString().toLowerCase(Locale.US));
        honeyClientEvent.c = "composer";
        if (map == null) {
            map = new HashMap();
        }
        for (Entry entry : r14.entrySet()) {
            honeyClientEvent.b((String) entry.getKey(), (String) entry.getValue());
        }
        if (f12648b) {
            StringBuilder stringBuilder = new StringBuilder();
            int i = 1;
            for (Entry entry2 : r14.entrySet()) {
                String str = "%s%s:%s";
                Object[] objArr = new Object[3];
                objArr[0] = i != 0 ? "" : ", ";
                objArr[1] = entry2.getKey();
                objArr[2] = entry2.getValue();
                stringBuilder.append(StringFormatUtil.a(str, objArr));
                i = 0;
            }
        }
        this.f12649c.c(honeyClientEvent);
    }
}
