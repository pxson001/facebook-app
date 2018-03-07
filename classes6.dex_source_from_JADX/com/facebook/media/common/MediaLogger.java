package com.facebook.media.common;

import android.graphics.RectF;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.Assisted;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.photos.base.analytics.ExceptionInterpreter;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.Event;
import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: keywords_commerce(%s) */
public class MediaLogger {
    private final AnalyticsLogger f11824a;
    private String f11825b;
    private String f11826c;
    private String f11827d;

    @Inject
    public MediaLogger(@Assisted MediaType mediaType, @Assisted String str, @Assisted String str2, AnalyticsLogger analyticsLogger) {
        boolean z;
        boolean z2 = true;
        Preconditions.checkArgument(!StringUtil.a(str), "Invalid waterfall ID");
        if (StringUtil.a(str2)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z, "Invalid source tag");
        if (mediaType == MediaType.UNKNOWN) {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "Must be known media type");
        if (mediaType == MediaType.PHOTO) {
            this.f11827d = "photo";
        } else if (mediaType == MediaType.VIDEO) {
            this.f11827d = "video";
        }
        this.f11825b = str;
        this.f11826c = str2;
        this.f11824a = analyticsLogger;
    }

    public final void m18783a() {
        m18780a(Event.MEDIA_UPLOAD_START, m18782f());
    }

    public final void m18792a(String str) {
        Map f = m18782f();
        f.put("fbid", str);
        m18780a(Event.MEDIA_UPLOAD_SUCCESS, f);
    }

    public final void m18791a(Exception exception) {
        Map f = m18782f();
        m18781a(f, exception);
        m18780a(Event.MEDIA_UPLOAD_FAILURE, f);
    }

    public final void m18799b() {
        m18780a(Event.MEDIA_UPLOAD_CANCEL, m18782f());
    }

    public final void m18803c() {
        m18780a(Event.MEDIA_UPLOAD_INIT_START, m18782f());
    }

    public final void m18801b(String str) {
        Map f = m18782f();
        f.put("upload_session_id", str);
        m18780a(Event.MEDIA_UPLOAD_INIT_SUCCESS, f);
    }

    public final void m18800b(Exception exception) {
        Map f = m18782f();
        m18781a(f, exception);
        m18780a(Event.MEDIA_UPLOAD_INIT_FAILURE, f);
    }

    public final void m18806d() {
        m18780a(Event.MEDIA_UPLOAD_INIT_CANCEL, m18782f());
    }

    public final void m18796a(String str, long j, long j2, String str2) {
        Map f = m18782f();
        f.put("upload_session_id", str);
        f.put("chunk_offset", Long.toString(j));
        f.put("chunk_size", Long.toString(j2));
        f.put("video_chunk_id", str2);
        m18780a(Event.MEDIA_UPLOAD_CHUNK_TRANSFER_START, f);
    }

    public final void m18794a(String str, long j, long j2, int i, String str2) {
        Map f = m18782f();
        f.put("upload_session_id", str);
        f.put("chunk_offset", Long.toString(j));
        f.put("auto_retry_count", Integer.toString(i));
        f.put("bytes", Long.toString(j2));
        f.put("video_chunk_id", str2);
        m18780a(Event.MEDIA_UPLOAD_CHUNK_TRANSFER_SUCCESS, f);
    }

    public final void m18795a(String str, long j, long j2, int i, String str2, Exception exception) {
        Map f = m18782f();
        f.put("upload_session_id", str);
        f.put("sent_bytes", Long.toString(j));
        f.put("total_bytes", Long.toString(j2));
        f.put("auto_retry_count", Integer.toString(i));
        f.put("video_chunk_id", str2);
        m18781a(f, exception);
        m18780a(Event.MEDIA_UPLOAD_CHUNK_TRANSFER_FAILURE, f);
    }

    public final void m18802b(String str, long j, long j2, int i, String str2) {
        Map f = m18782f();
        f.put("upload_session_id", str);
        f.put("sent_bytes", Long.toString(j));
        f.put("total_bytes", Long.toString(j2));
        f.put("auto_retry_count", Integer.toString(i));
        f.put("video_chunk_id", str2);
        m18780a(Event.MEDIA_UPLOAD_CHUNK_TRANSFER_CANCEL, f);
    }

    public final void m18805c(String str) {
        Map f = m18782f();
        f.put("upload_session_id", str);
        m18780a(Event.MEDIA_POST_START, f);
    }

    public final void m18807d(String str) {
        Map f = m18782f();
        f.put("upload_session_id", str);
        m18780a(Event.MEDIA_POST_SUCCESS, f);
    }

    public final void m18797a(String str, Exception exception) {
        Map f = m18782f();
        f.put("upload_session_id", str);
        m18781a(f, exception);
        m18780a(Event.MEDIA_POST_FAILURE, f);
    }

    public final void m18787a(int i, boolean z, int i2, int i3, boolean z2, int i4, RectF rectF) {
        m18788a(i, z, i2, i3, z2, i4, rectF, -1, -1, -1, -1);
    }

    public final void m18788a(int i, boolean z, int i2, int i3, boolean z2, int i4, RectF rectF, int i5, int i6, int i7, int i8) {
        Map f = m18782f();
        f.put("specified_transcode_bit_rate", Integer.toString(i));
        f.put("is_video_trim", Boolean.toString(z));
        if (z) {
            f.put("video_trim_start_time_ms", Integer.toString(i2));
            f.put("video_trim_end_time_ms", Integer.toString(i3));
        }
        f.put("is_video_muted", Boolean.toString(z2));
        f.put("video_output_rotation_angle", Integer.toString(i4));
        if (rectF != null) {
            f.put("video_crop_rectangle", m18778a(rectF));
        }
        m18779a(i5, i6, i7, i8, f);
        m18780a(Event.MEDIA_UPLOAD_PROCESS_START, f);
    }

    public final void m18804c(Exception exception) {
        m18786a(-1, -1, -1, -1, exception);
    }

    public final void m18786a(int i, int i2, int i3, int i4, Exception exception) {
        Map f = m18782f();
        m18781a(f, exception);
        m18779a(i, i2, i3, i4, f);
        m18780a(Event.MEDIA_UPLOAD_PROCESS_FAILURE, f);
    }

    public final void m18808e() {
        m18784a(-1, -1, -1, -1);
    }

    public final void m18784a(int i, int i2, int i3, int i4) {
        Map f = m18782f();
        m18779a(i, i2, i3, i4, f);
        m18780a(Event.MEDIA_UPLOAD_PROCESS_CANCEL, f);
    }

    public final void m18793a(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2, long j3) {
        m18785a(i, i2, i3, i4, i5, i6, i7, i8, j2, j3, -1, -1, -1, -1);
    }

    public final void m18785a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2, int i9, int i10, int i11, int i12) {
        Map f = m18782f();
        f.put("source_width", Integer.toString(i));
        f.put("source_height", Integer.toString(i2));
        f.put("source_bit_rate", Integer.toString(i3));
        f.put("source_frame_rate", Integer.toString(i4));
        f.put("target_width", Integer.toString(i5));
        f.put("target_height", Integer.toString(i6));
        if (j > 0) {
            f.put("original_file_size", Long.toString(j));
        }
        f.put("bytes", Long.toString(j2));
        f.put("target_bit_rate", Integer.toString(i7));
        f.put("target_frame_rate", Integer.toString(i8));
        m18779a(i9, i10, i11, i12, f);
        m18780a(Event.MEDIA_UPLOAD_PROCESS_SUCCESS, f);
    }

    private static void m18779a(int i, int i2, int i3, int i4, Map<String, String> map) {
        if (i >= 0) {
            map.put("segment_id", Integer.toString(i));
            map.put("segment_type", Integer.toString(i2));
            map.put("segment_start_time", Integer.toString(i3));
            map.put("segment_end_time", Integer.toString(i4));
        }
    }

    public final void m18789a(long j) {
        Map f = m18782f();
        f.put("original_file_size", Long.toString(j));
        m18780a(Event.MEDIA_UPLOAD_ATTEMPT_VIDEO_RESIZE_CHECK_START, f);
    }

    public final void m18790a(long j, long j2, boolean z, int i, int i2) {
        Map f = m18782f();
        f.put("original_file_size", Long.toString(j));
        f.put("estimated_resized_file_size", Long.toString(j2));
        f.put("attempt_video_resize", Boolean.toString(z));
        f.put("estimated_video_bit_rate", Integer.toString(i));
        f.put("estimated_audio_bit_rate", Integer.toString(i2));
        m18780a(Event.MEDIA_UPLOAD_ATTEMPT_VIDEO_RESIZE_CHECK_SUCCESS, f);
    }

    public final void m18798a(boolean z) {
        Map f = m18782f();
        f.put("attempt_video_resize", Boolean.toString(z));
        m18780a(Event.MEDIA_UPLOAD_ATTEMPT_VIDEO_RESIZE_CHECK_SKIPPED, f);
    }

    private Map<String, String> m18782f() {
        Map hashMap = new HashMap();
        hashMap.put("version", "m1.0");
        hashMap.put("media_type", this.f11827d);
        hashMap.put("client_tag", this.f11826c);
        return hashMap;
    }

    private static void m18781a(Map<String, String> map, Exception exception) {
        if (exception != null) {
            ExceptionInterpreter exceptionInterpreter = new ExceptionInterpreter(exception, true);
            CharSequence c = exceptionInterpreter.mo1089c();
            if (!StringUtil.a(c)) {
                map.put("ex_type", c);
            }
            c = exceptionInterpreter.mo1090d();
            if (!StringUtil.a(c)) {
                map.put("ex_msg", c);
            }
            int e = exceptionInterpreter.mo1091e();
            if (e != -1) {
                map.put("ex_code", Integer.toString(e));
            }
            e = exceptionInterpreter.mo1092f();
            if (e != -1) {
                map.put("http_status_code", Integer.toString(e));
            }
            c = exceptionInterpreter.mo1093g();
            if (!StringUtil.a(c)) {
                map.put("error_type", c);
            }
            CharSequence b = exceptionInterpreter.mo1088b();
            if (!StringUtil.a(b)) {
                map.put("ex_inner_msg", b);
            }
        }
    }

    private void m18780a(Event event, Map<String, String> map) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(event.toString().toLowerCase());
        honeyClientEvent.c = "composer";
        if (!StringUtil.a(this.f11825b)) {
            honeyClientEvent.f = this.f11825b;
        }
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                honeyClientEvent.b((String) entry.getKey(), (String) entry.getValue());
            }
        }
        this.f11824a.a(honeyClientEvent);
    }

    private static String m18778a(RectF rectF) {
        if (rectF == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(rectF.left);
        stringBuilder.append(',');
        stringBuilder.append(rectF.top);
        stringBuilder.append(',');
        stringBuilder.append(rectF.right);
        stringBuilder.append(',');
        stringBuilder.append(rectF.bottom);
        return stringBuilder.toString();
    }
}
