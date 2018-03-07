package com.facebook.photos.base.analytics;

import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.base.analytics.LoggingTypes.SourceType;
import com.facebook.photos.base.analytics.LoggingTypes.UploadMethodType;
import com.facebook.photos.base.analytics.LoggingTypes.UploadType;
import com.facebook.photos.base.analytics.LoggingTypes.VideoProductType;
import com.facebook.photos.base.analytics.PhotoFlowLogger.UploadInfo;
import com.facebook.photos.base.analytics.bugreporter.PhotosBugReportExtraDataCollector;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.Event;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.TagScreen;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.TagSource;
import com.facebook.photos.base.analytics.photostab.PhotosOfLoadingParams;
import com.facebook.photos.base.analytics.photostab.PhotosTabBaseParams;
import com.facebook.photos.base.analytics.photostab.PhotosUploadedBaseParams;
import com.facebook.photos.base.analytics.upload.PublishStageBaseParams;
import com.facebook.photos.base.analytics.upload.PublishStageBaseParams.Builder;
import com.facebook.photos.base.analytics.upload.UploadBaseParams;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.uploaders.ChunkUploadProgressStatus;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import org.json.JSONObject;

/* compiled from: internationalPhoneNumber */
public class DefaultPhotoFlowLogger implements PhotoLoggingConstants {
    private static final Class<?> f12578b = DefaultPhotoFlowLogger.class;
    private static final boolean f12579c = Log.isLoggable("PhotoFlowLogger", 3);
    private long f12580A;
    private boolean f12581B;
    public int f12582C;
    private long f12583D;
    private final Provider<String> f12584E;
    public final SequenceLoggerPhotoFlowHandler f12585F;
    private final FbDataConnectionManager f12586G;
    PhotosBugReportExtraDataCollector f12587a;
    private final AnalyticsLogger f12588d;
    private final AbstractFbErrorReporter f12589e;
    private final FbNetworkManager f12590f;
    public final MonotonicClock f12591g;
    private final Lazy<AppStateManager> f12592h;
    private String f12593i;
    public String f12594j;
    public String f12595k;
    public String f12596l;
    public String f12597m;
    private int f12598n = -1;
    private String f12599o = "";
    private final String f12600p;
    public String f12601q;
    public long f12602r;
    private long f12603s;
    private long f12604t;
    private long f12605u;
    private long f12606v;
    private long f12607w;
    private long f12608x;
    private long f12609y;
    private long f12610z;

    public static DefaultPhotoFlowLogger m19829b(InjectorLike injectorLike) {
        return new DefaultPhotoFlowLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), FbNetworkManager.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 476), IdBasedProvider.a(injectorLike, 4465), PhotosBugReportExtraDataCollector.m20068a(injectorLike), String_LoggedInUserIdMethodAutoProvider.b(injectorLike), new SequenceLoggerPhotoFlowHandler((SequenceLogger) SequenceLoggerImpl.a(injectorLike)), FbDataConnectionManager.a(injectorLike));
    }

    public final void m19844a(PhotosTabBaseParams photosTabBaseParams) {
        HashMap c = Maps.c();
        c.put("relationship_type", photosTabBaseParams.f12676a);
        c.put("profile_id", photosTabBaseParams.f12677b);
        c.put("tab_name", photosTabBaseParams.f12678c);
        c.put("prev_tab_name", photosTabBaseParams.f12679d);
        Map map = c;
        m19819a(Event.PHOTOS_TAB_NAV, map, (String) map.get(photosTabBaseParams.f12677b));
    }

    public final void m19843a(PhotosOfLoadingParams photosOfLoadingParams) {
        HashMap c = Maps.c();
        c.put("relationship_type", photosOfLoadingParams.f12672a);
        c.put("profile_id", photosOfLoadingParams.f12673b);
        c.put("viewer_id", photosOfLoadingParams.f12674c);
        c.put("photos_of_user", photosOfLoadingParams.f12675d);
        Map map = c;
        m19819a(Event.PHOTOS_OF_LOADING_SECTIONS, map, (String) map.get(photosOfLoadingParams.f12673b));
    }

    public final void m19845a(PhotosUploadedBaseParams photosUploadedBaseParams) {
        HashMap c = Maps.c();
        c.put("relationship_type", photosUploadedBaseParams.f12680a);
        c.put("profile_id", photosUploadedBaseParams.f12681b);
        c.put("viewer_id", photosUploadedBaseParams.f12682c);
        c.put("photos_uploaded", photosUploadedBaseParams.f12683d);
        Map map = c;
        m19819a(Event.PHOTOS_UPLOADED_LOADING, map, (String) map.get(photosUploadedBaseParams.f12681b));
    }

    public static DefaultPhotoFlowLogger m19815a(InjectorLike injectorLike) {
        return m19829b(injectorLike);
    }

    public final void m19850a(UploadBaseParams uploadBaseParams, int i, SourceType sourceType, String str, long j, long j2, long j3) {
        uploadBaseParams.f12699c = sourceType;
        Map a = uploadBaseParams.m20077a();
        a.put("photo_index", Integer.toString(i));
        if (!StringUtil.a(str)) {
            a.put("extension", str);
        }
        if (j > 0) {
            a.put("original_file_size", Long.toString(j));
        }
        if (j2 > 0) {
            a.put("bytes", Long.toString(j2));
        }
        if (j3 > 0) {
            a.put("video_duration", Float.toString(((float) j3) / 1000.0f));
        }
        m19819a(Event.MEDIA_UPLOAD_START, a, null);
        this.f12605u = this.f12591g.now();
    }

    public final void m19864a(UploadBaseParams uploadBaseParams, SourceType sourceType) {
        uploadBaseParams.f12699c = sourceType;
        Map a = uploadBaseParams.m20077a();
        m19832b((HashMap) a, this.f12605u);
        m19819a(Event.MEDIA_UPLOAD_CANCEL, a, null);
        uploadBaseParams.f12699c = SourceType.UNKNOWN;
    }

    public final void m19865a(UploadBaseParams uploadBaseParams, SourceType sourceType, long j, int i) {
        uploadBaseParams.f12699c = sourceType;
        Map a = uploadBaseParams.m20077a();
        a.put("fbid", Long.toString(j));
        a.put("auto_retry_count", Integer.toString(i));
        m19832b((HashMap) a, this.f12605u);
        m19819a(Event.MEDIA_UPLOAD_SUCCESS, a, null);
        uploadBaseParams.f12699c = SourceType.UNKNOWN;
    }

    public final void m19866a(UploadBaseParams uploadBaseParams, SourceType sourceType, PhotoFlowLogger$ExceptionReporter photoFlowLogger$ExceptionReporter) {
        uploadBaseParams.f12699c = sourceType;
        Map a = uploadBaseParams.m20077a();
        m19824a((HashMap) a, photoFlowLogger$ExceptionReporter);
        m19832b((HashMap) a, this.f12605u);
        m19819a(Event.MEDIA_UPLOAD_FAILURE, a, null);
        uploadBaseParams.f12699c = SourceType.UNKNOWN;
    }

    @Inject
    public DefaultPhotoFlowLogger(AnalyticsLogger analyticsLogger, FbErrorReporter fbErrorReporter, FbNetworkManager fbNetworkManager, MonotonicClock monotonicClock, Lazy<AppStateManager> lazy, Provider<String> provider, PhotosBugReportExtraDataCollector photosBugReportExtraDataCollector, String str, SequenceLoggerPhotoFlowHandler sequenceLoggerPhotoFlowHandler, FbDataConnectionManager fbDataConnectionManager) {
        this.f12588d = analyticsLogger;
        this.f12589e = fbErrorReporter;
        this.f12590f = fbNetworkManager;
        this.f12591g = monotonicClock;
        this.f12592h = lazy;
        this.f12594j = null;
        this.f12584E = provider;
        this.f12587a = photosBugReportExtraDataCollector;
        this.f12600p = str;
        this.f12585F = sequenceLoggerPhotoFlowHandler;
        this.f12586G = fbDataConnectionManager;
    }

    private static void m19824a(HashMap<String, String> hashMap, PhotoFlowLogger$ExceptionReporter photoFlowLogger$ExceptionReporter) {
        if (photoFlowLogger$ExceptionReporter != null) {
            m19826a((HashMap) hashMap, photoFlowLogger$ExceptionReporter.mo1089c(), photoFlowLogger$ExceptionReporter.mo1090d(), photoFlowLogger$ExceptionReporter.mo1091e(), photoFlowLogger$ExceptionReporter.mo1092f(), photoFlowLogger$ExceptionReporter.mo1093g(), photoFlowLogger$ExceptionReporter.mo1088b());
        }
    }

    private static void m19826a(HashMap<String, String> hashMap, String str, String str2, int i, int i2, String str3, String str4) {
        if (!StringUtil.a(str)) {
            hashMap.put("ex_type", str);
        }
        if (!StringUtil.a(str2)) {
            hashMap.put("ex_msg", str2);
        }
        if (i != -1) {
            hashMap.put("ex_code", Integer.toString(i));
        }
        if (i2 != -1) {
            hashMap.put("http_status_code", Integer.toString(i2));
        }
        if (!StringUtil.a(str3)) {
            hashMap.put("error_type", str3);
        }
        if (!StringUtil.a(str4)) {
            hashMap.put("ex_inner_msg", str4);
        }
    }

    public final String m19838a() {
        return this.f12594j;
    }

    public final void m19891a(String str) {
        this.f12594j = str;
        this.f12585F.f12654c.f12650a = str;
    }

    public final void m19918b(@Nullable String str) {
        this.f12595k = str;
    }

    public final void m19840a(int i, boolean z) {
        this.f12598n = i;
        if (z) {
            Map c = Maps.c();
            c.put("camera_index", Integer.toString(this.f12598n));
            m19819a(Event.CAMERA_SOURCE_SELECT, c, null);
        }
    }

    public final void m19903a(boolean z) {
        this.f12581B = z;
    }

    private void m19819a(Event event, Map<String, String> map, @Nullable String str) {
        m19820a(event, (Map) map, this.f12594j, str);
    }

    private void m19818a(Event event, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 1;
        for (Entry entry : map.entrySet()) {
            String str = "%s%s:%s";
            Object[] objArr = new Object[3];
            objArr[0] = i != 0 ? "" : ", ";
            objArr[1] = entry.getKey();
            objArr[2] = entry.getValue();
            stringBuilder.append(StringFormatUtil.a(str, objArr));
            i = 0;
        }
    }

    private void m19820a(Event event, Map<String, String> map, String str, @Nullable String str2) {
        Map c;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(event.toString().toLowerCase(Locale.US));
        honeyClientEvent.c = "composer";
        if (map == null) {
            c = Maps.c();
        }
        c.put("reachability_status", this.f12590f.p());
        if (this.f12595k != null) {
            c.put("batch_type", this.f12595k);
        }
        if (!StringUtil.a(this.f12601q)) {
            c.put("custom_tags", this.f12601q);
        }
        for (Entry entry : c.entrySet()) {
            honeyClientEvent.b((String) entry.getKey(), (String) entry.getValue());
        }
        if (!StringUtil.a(str)) {
            honeyClientEvent.f = str;
        }
        if (!StringUtil.a(str2)) {
            honeyClientEvent.j(str2);
        }
        if (f12579c) {
            m19818a(event, c);
        }
        honeyClientEvent.a("funnel_event_enabled", false);
        this.f12588d.a(honeyClientEvent);
        if (event.isUploadEvent()) {
            this.f12587a.m20071a(event, str, c);
        }
    }

    public final void m19937e(String str) {
        Map c = Maps.c();
        c.put("composer_type", str);
        m19819a(Event.LAUNCHED_MULTIPICKER, c, null);
    }

    public final void m19904a(boolean z, int i, TagSource tagSource, TagScreen tagScreen) {
        Map c = Maps.c();
        c.put("is_text", z ? "true" : "false");
        c.put("ex_tag_screen", tagScreen.name());
        c.put("tag_src", tagSource.name());
        c.put("ex_tag_index", Integer.toString(i));
        c.put("ex_tag_text_length", Integer.toString(this.f12582C));
        if (i >= 0) {
            m19832b((HashMap) c, this.f12583D);
        }
        m19819a(Event.TAG_CREATED, c, null);
    }

    public final void m19842a(TagScreen tagScreen) {
        Map c = Maps.c();
        c.put("ex_tag_screen", tagScreen.name());
        m19819a(Event.TAG_DELETED, c, null);
    }

    public final void m19905b() {
        m19819a(Event.COMPOSER_TAGGING_CANCEL, null, null);
    }

    public final void m19919b(boolean z) {
        Map c = Maps.c();
        c.put("tagging_edit_tag_suggestion", Boolean.toString(z));
        m19819a(Event.COMPOSER_EDIT_TAG_SUGGESTION, c, null);
    }

    public final void m19940f(String str) {
        Map c = Maps.c();
        c.put("composer_button_target", str);
        m19819a(Event.COMPOSER_BUTTON_CLICKED, c, null);
    }

    public final void m19920c() {
        m19819a(Event.COMPOSER_SUBMIT_VIDEO, m19830b("2.1", UploadType.VIDEO, UploadMethodType.CHUNKED), null);
    }

    public final void m19930d() {
        m19819a(Event.COMPOSER_ATTACHMENT_REMOVED, null, null);
    }

    public final void m19935e() {
        m19819a(Event.COMPOSER_ADD_ATTACHMENT_BUTTON_PRESSED, null, null);
    }

    public final void m19841a(Uri uri) {
        m19827a(false, uri);
    }

    public final void m19908b(Uri uri) {
        m19827a(true, uri);
    }

    private void m19827a(boolean z, Uri uri) {
        Map c = Maps.c();
        if (uri != null) {
            c.put("uri", uri.getPath());
        }
        c.put("has_video", z ? "true" : "false");
        m19819a(Event.PICKED_MEDIA, c, null);
    }

    public final void m19941g(String str) {
        Map c = Maps.c();
        c.put("camera_flow", str);
        m19819a(Event.CAMERA_FLOW, c, null);
    }

    public final void m19942h(String str) {
        this.f12593i = str;
        Map c = Maps.c();
        c.put("camera_ref", this.f12593i);
        m19819a(Event.CAMERA_START, c, null);
    }

    public final void m19902a(String str, boolean z) {
        this.f12599o = str;
        if (z) {
            Map c = Maps.c();
            c.put("camera_flash", this.f12599o);
            m19819a(Event.CAMERA_FLASH, c, null);
        }
    }

    public final void m19906b(int i) {
        Map c = Maps.c();
        c.put("size", Integer.toString(i));
        c.put("layout_orientation", this.f12596l);
        c.put("device_orientation", this.f12597m);
        c.put("camera_index", String.valueOf(this.f12598n));
        c.put("camera_flash", this.f12599o);
        c.put("camera_ref", this.f12593i);
        m19819a(Event.CAMERA_TAKE_PHOTO, c, null);
    }

    public final void m19938f() {
        m19819a(Event.CAMERA_LOADING, Maps.c(), null);
    }

    public final void m19907b(long j) {
        float f = ((float) j) / 1000.0f;
        Map c = Maps.c();
        c.put("load_time", Float.toString(f));
        m19819a(Event.CAMERA_DONE_LOADING, c, null);
    }

    public final void m19839a(float f, int i, int i2, int i3, int i4) {
        Map c = Maps.c();
        c.put("session_time", Float.toString(f));
        c.put("camera_ref", this.f12593i);
        c.put("picture_count", Integer.toString(i));
        c.put("touch_to_focus_count", Integer.toString(i2));
        c.put("last_second_autofocus_count", Integer.toString(i3));
        c.put("face_detection_autofocus_count", Integer.toString(i4));
        m19819a(Event.CAMERA_STOPPED, c, null);
    }

    public final void m19929c(boolean z) {
        Map c = Maps.c();
        c.put("video_recording_success", z ? "1" : "0");
        m19819a(Event.CAMERA_VIDEO_RECORDER_STOPPED, c, null);
    }

    public final void m19943i(String str) {
        Map c = Maps.c();
        c.put("close_reason", str);
        m19819a(Event.CAMERA_CLOSING, c, null);
    }

    public final void m19900a(String str, Exception exception) {
        if (exception == null) {
            BLog.b("CameraException", str);
        } else {
            BLog.b("CameraException", str + ": " + exception.toString());
        }
        Map c = Maps.c();
        c.put("ex_msg", str);
        if (exception != null) {
            c.put("ex_type", exception.toString());
        }
        c.put("layout_orientation", this.f12596l);
        c.put("device_orientation", this.f12597m);
        c.put("camera_index", String.valueOf(this.f12598n));
        c.put("camera_flash", this.f12599o);
        c.put("product", Build.PRODUCT);
        c.put("device", Build.DEVICE);
        c.put("board", Build.BOARD);
        c.put("manufacturer", Build.MANUFACTURER);
        c.put("brand", Build.BRAND);
        c.put("model", Build.MODEL);
        m19820a(Event.CAMERA_EXCEPTION, c, null, null);
        if (this.f12589e != null) {
            this.f12589e.a("CameraException", str + " Layout:" + this.f12596l + " Device:" + this.f12597m + " Camera:" + this.f12598n + " Flash:" + this.f12599o, exception);
        }
    }

    public final void m19892a(String str, UploadType uploadType, UploadMethodType uploadMethodType, VideoProductType videoProductType, String str2, int i, int i2, String str3, String str4, int i3) {
        Map b = m19830b(str, uploadType, uploadMethodType);
        if (!videoProductType.value.equals(VideoProductType.NOT_RELEVANT.value)) {
            b.put("video_product_type", videoProductType.value);
        }
        if (!StringUtil.a(str2)) {
            b.put("target_type", str2);
        }
        b.put("media_attachment_count", Integer.toString(i));
        b.put("tags_user", Integer.toString(i2));
        if (!StringUtil.a(str3)) {
            b.put("composer_set_privacy", str3);
        }
        if (!StringUtil.a(str4)) {
            b.put("target_id", str4);
        }
        b.put("upload_queue_size", Integer.toString(i3));
        m19819a(Event.MEDIA_UPLOAD_FLOW_START, b, null);
        this.f12585F.m20025b();
    }

    public final void m19898a(String str, UploadType uploadType, UploadMethodType uploadMethodType, UploadOperation uploadOperation, PhotoFlowLogger$ExceptionReporter photoFlowLogger$ExceptionReporter, long j) {
        Map b = m19830b(str, uploadType, uploadMethodType);
        b.put("multi_success", "0");
        m19825a((HashMap) b, uploadOperation);
        m19824a((HashMap) b, photoFlowLogger$ExceptionReporter);
        m19823a((HashMap) b, j);
        m19819a(Event.MEDIA_UPLOAD_FLOW_CANCEL, b, null);
        this.f12585F.m20027c();
    }

    public final void m19897a(String str, UploadType uploadType, UploadMethodType uploadMethodType, UploadOperation uploadOperation, int i, boolean z, PhotoFlowLogger$ExceptionReporter photoFlowLogger$ExceptionReporter, long j) {
        Map b = m19830b(str, uploadType, uploadMethodType);
        m19825a((HashMap) b, uploadOperation);
        b.put("multi_success", Integer.toString(i));
        b.put("may_auto_retry", Boolean.toString(z));
        m19824a((HashMap) b, photoFlowLogger$ExceptionReporter);
        m19823a((HashMap) b, j);
        m19819a(Event.MEDIA_UPLOAD_FLOW_GIVEUP, b, null);
        this.f12585F.m20029d();
    }

    public final void m19894a(String str, UploadType uploadType, UploadMethodType uploadMethodType, UploadOperation uploadOperation, int i, PhotoFlowLogger$ExceptionReporter photoFlowLogger$ExceptionReporter, long j) {
        Map b = m19830b(str, uploadType, uploadMethodType);
        m19825a((HashMap) b, uploadOperation);
        b.put("multi_success", Integer.toString(i));
        m19824a((HashMap) b, photoFlowLogger$ExceptionReporter);
        m19823a((HashMap) b, j);
        m19819a(Event.MEDIA_UPLOAD_FLOW_FATAL, b, null);
        this.f12585F.m20031e();
    }

    public final void m19875a(UploadBaseParams uploadBaseParams, UploadOperation uploadOperation, int i, PhotoFlowLogger$ExceptionReporter photoFlowLogger$ExceptionReporter) {
        Map a = uploadBaseParams.m20077a();
        m19825a((HashMap) a, uploadOperation);
        a.put("multi_success", Integer.toString(i));
        m19824a((HashMap) a, photoFlowLogger$ExceptionReporter);
        m19832b((HashMap) a, this.f12602r);
        m19819a(Event.MEDIA_UPLOAD_FLOW_CANCEL, a, null);
        this.f12585F.m20027c();
    }

    public final void m19871a(UploadBaseParams uploadBaseParams, UploadOperation uploadOperation) {
        Map a = uploadBaseParams.m20077a();
        m19825a((HashMap) a, uploadOperation);
        m19832b((HashMap) a, this.f12603s);
        m19819a(Event.MEDIA_UPLOAD_BATCH_SUCCESS, a, null);
    }

    public final void m19873a(UploadBaseParams uploadBaseParams, UploadOperation uploadOperation, int i, int i2, PhotoFlowLogger$ExceptionReporter photoFlowLogger$ExceptionReporter) {
        Map a = uploadBaseParams.m20077a();
        m19825a((HashMap) a, uploadOperation);
        a.put("multi_success", Integer.toString(i));
        a.put("multi_fail", Integer.toString(i2));
        m19824a((HashMap) a, photoFlowLogger$ExceptionReporter);
        m19832b((HashMap) a, this.f12603s);
        m19819a(Event.MEDIA_UPLOAD_BATCH_FAILURE, a, null);
    }

    public final void m19896a(String str, UploadType uploadType, UploadMethodType uploadMethodType, UploadOperation uploadOperation, int i, String str2, long j) {
        Map b = m19830b(str, uploadType, uploadMethodType);
        m19825a((HashMap) b, uploadOperation);
        if (i >= 0) {
            b.put("multi_success", Integer.toString(i));
        }
        if (!StringUtil.a(str2)) {
            b.put("error_code", str2);
        }
        if (j >= 0) {
            m19823a((HashMap) b, j);
        }
        m19819a(Event.MEDIA_UPLOAD_ATTEMPT_INCOMPLETE, b, null);
    }

    public final void m19867a(UploadBaseParams uploadBaseParams, PhotoFlowLogger$ExceptionReporter photoFlowLogger$ExceptionReporter) {
        Map a = uploadBaseParams.m20077a();
        m19826a((HashMap) a, photoFlowLogger$ExceptionReporter.mo1089c(), photoFlowLogger$ExceptionReporter.mo1090d(), photoFlowLogger$ExceptionReporter.mo1091e(), photoFlowLogger$ExceptionReporter.mo1092f(), photoFlowLogger$ExceptionReporter.mo1093g(), photoFlowLogger$ExceptionReporter.mo1088b());
        m19819a(Event.MEDIA_UPLOAD_DIAGNOSTIC, a, null);
    }

    public final void m19901a(String str, String str2, String str3, int i, int i2, String str4) {
        Map a = m19944j(str).m20077a();
        m19826a((HashMap) a, str2, str3, i, i2, str4, null);
        m19819a(Event.MEDIA_UPLOAD_DIAGNOSTIC, a, null);
    }

    public final void m19899a(String str, UploadType uploadType, UploadMethodType uploadMethodType, UploadOperation uploadOperation, boolean z, long j, String str2, boolean z2) {
        Map b = m19830b(str, uploadType, uploadMethodType);
        m19825a((HashMap) b, uploadOperation);
        b.put("retry", z ? "auto_retry" : "user_retry");
        b.put("gcm_based_network_retry", Boolean.toString(z2));
        m19823a((HashMap) b, j);
        if (!StringUtil.a(str2)) {
            b.put("error_code", str2);
        }
        m19819a(Event.MEDIA_UPLOAD_ATTEMPT_RETRY, b, null);
    }

    public final void m19916b(UploadBaseParams uploadBaseParams, UploadOperation uploadOperation) {
        Map a = uploadBaseParams.m20077a();
        m19825a((HashMap) a, uploadOperation);
        m19832b((HashMap) a, this.f12602r);
        m19819a(Event.MEDIA_UPLOAD_FLOW_SUCCESS, a, null);
        this.f12585F.m20032f();
    }

    public final void m19874a(UploadBaseParams uploadBaseParams, UploadOperation uploadOperation, int i, int i2, boolean z, PhotoFlowLogger$ExceptionReporter photoFlowLogger$ExceptionReporter) {
        Map a = uploadBaseParams.m20077a();
        m19825a((HashMap) a, uploadOperation);
        a.put("multi_success", Integer.toString(i));
        a.put("multi_fail", Integer.toString(i2));
        m19824a((HashMap) a, photoFlowLogger$ExceptionReporter);
        m19832b((HashMap) a, this.f12602r);
        a.put("upload_fail", Boolean.toString(z));
        m19819a(Event.MEDIA_UPLOAD_ATTEMPT_FAILURE, a, null);
    }

    public final void m19928c(UploadBaseParams uploadBaseParams, UploadOperation uploadOperation) {
        Map a = uploadBaseParams.m20077a();
        m19825a((HashMap) a, uploadOperation);
        a.put("media_attachment_count", Integer.toString(1));
        m19819a(Event.MEDIA_UPLOAD_FLOW_SUCCESS, a, null);
        this.f12585F.m20032f();
    }

    public final void m19921c(int i) {
        Map c = Maps.c();
        c.put("media_attachment_count", Integer.toString(i));
        m19819a(Event.EXTERNAL_PHOTO, c, null);
    }

    public final void m19922c(Uri uri) {
        Map c = Maps.c();
        if (uri != null) {
            c.put("uri", uri.getPath());
        }
        m19819a(Event.EXTERNAL_VIDEO, c, null);
    }

    private UploadBaseParams m19816a(String str, UploadType uploadType, UploadMethodType uploadMethodType) {
        return new UploadBaseParams(str, uploadType, uploadMethodType, (String) this.f12584E.get());
    }

    public final UploadBaseParams m19944j(String str) {
        return m19816a(str, UploadType.PHOTO, UploadMethodType.NOT_RELEVANT);
    }

    public final UploadBaseParams m19837a(String str, UploadMethodType uploadMethodType) {
        return m19816a(str, UploadType.VIDEO, uploadMethodType);
    }

    private HashMap<String, String> m19830b(String str, UploadType uploadType, UploadMethodType uploadMethodType) {
        return m19816a(str, uploadType, uploadMethodType).m20077a();
    }

    public final PublishStageBaseParams m19836a(String str, int i, int i2, int i3, int i4) {
        Builder builder = new Builder();
        builder.f12684a = str;
        builder = builder;
        builder.f12685b = i;
        builder = builder;
        builder.f12686c = i2;
        builder = builder;
        builder.f12687d = 0;
        builder = builder;
        builder.f12688e = i3;
        builder = builder;
        builder.f12689f = i4;
        return new PublishStageBaseParams(builder);
    }

    public final void m19934d(UploadBaseParams uploadBaseParams, UploadOperation uploadOperation) {
        Map a = uploadBaseParams.m20077a();
        m19825a((HashMap) a, uploadOperation);
        m19819a(Event.MEDIA_UPLOAD_BATCH_START, a, null);
        this.f12603s = this.f12591g.now();
    }

    public final void m19872a(UploadBaseParams uploadBaseParams, UploadOperation uploadOperation, int i) {
        Map a = uploadBaseParams.m20077a();
        m19825a((HashMap) a, uploadOperation);
        a.put("multi_success", Integer.toString(i));
        m19832b((HashMap) a, this.f12603s);
        m19819a(Event.MEDIA_UPLOAD_BATCH_CANCEL, a, null);
    }

    public final void m19849a(UploadBaseParams uploadBaseParams, int i, SourceType sourceType) {
        m19821a(uploadBaseParams, i, sourceType, null);
    }

    private void m19821a(UploadBaseParams uploadBaseParams, int i, SourceType sourceType, String str) {
        m19850a(uploadBaseParams, i, sourceType, str, 0, 0, 0);
    }

    public final void m19846a(UploadBaseParams uploadBaseParams) {
        m19819a(Event.MEDIA_UPLOAD_HASH_COMPUTE_START, uploadBaseParams.m20077a(), null);
        this.f12585F.m20040n();
    }

    public final void m19861a(UploadBaseParams uploadBaseParams, long j, String str) {
        Map a = uploadBaseParams.m20077a();
        a.put("hash_file_size", Long.toString(j));
        a.put("extra_hash", str);
        m19819a(Event.MEDIA_UPLOAD_HASH_COMPUTE_END, a, null);
        this.f12585F.m20041o();
    }

    public final void m19858a(UploadBaseParams uploadBaseParams, long j, long j2, boolean z) {
        Map a = uploadBaseParams.m20077a();
        a.put("hash_file_size", Long.toString(j));
        a.put("bytes", Long.toString(j2));
        a.put("transcode_success", Boolean.toString(z));
        m19819a(Event.MEDIA_UPLOAD_HASH_COMPUTE_SKIPPED, a, null);
    }

    public final void m19888a(UploadBaseParams uploadBaseParams, String str, String str2) {
        Map a = uploadBaseParams.m20077a();
        a.put("spherical_projection_type", str);
        a.put("spherical_stereo_mode", str2);
        m19819a(Event.MEDIA_UPLOAD_ATTEMPT_PRESERVE_SPHERICAL_METADATA, a, null);
    }

    public final void m19914b(UploadBaseParams uploadBaseParams, PhotoFlowLogger$ExceptionReporter photoFlowLogger$ExceptionReporter) {
        Map a = uploadBaseParams.m20077a();
        m19831b((HashMap) a);
        m19824a((HashMap) a, photoFlowLogger$ExceptionReporter);
        m19819a(Event.MEDIA_UPLOAD_ATTEMPT_GET_METADATA_FAILURE, a, null);
    }

    public final void m19889a(UploadBaseParams uploadBaseParams, String str, String str2, boolean z) {
        Map a = uploadBaseParams.m20077a();
        m19831b((HashMap) a);
        a.put("video_original_file_path", str);
        a.put("video_uploaded_file_path", str2);
        a.put("transcode_success", Boolean.toString(z));
        m19819a(Event.MEDIA_UPLOAD_MISSING_ORIGINAL_MEDIA_FILE, a, null);
    }

    public final void m19881a(UploadBaseParams uploadBaseParams, String str, long j) {
        Map a = uploadBaseParams.m20077a();
        if (!StringUtil.a(str)) {
            a.put("extension", str);
        }
        a.put("original_file_size", Long.toString(j));
        m19819a(Event.MEDIA_UPLOAD_ATTEMPT_VIDEO_RESIZE_CHECK_START, a, null);
    }

    public final void m19863a(UploadBaseParams uploadBaseParams, long j, boolean z, PhotoFlowLogger$ExceptionReporter photoFlowLogger$ExceptionReporter) {
        Map a = uploadBaseParams.m20077a();
        a.put("original_file_size", Long.toString(j));
        a.put("attempt_video_resize", Boolean.toString(z));
        m19831b((HashMap) a);
        m19824a((HashMap) a, photoFlowLogger$ExceptionReporter);
        m19819a(Event.MEDIA_UPLOAD_ATTEMPT_VIDEO_RESIZE_CHECK_FAILURE, a, null);
    }

    public final void m19853a(UploadBaseParams uploadBaseParams, long j, int i, boolean z, boolean z2, int i2, int i3, int i4) {
        Map a = uploadBaseParams.m20077a();
        a.put("original_file_size", Long.toString(j));
        a.put("estimated_resized_file_size", Integer.toString(i));
        a.put("attempt_video_resize", Boolean.toString(z));
        a.put("higher_quality_transcode", Boolean.toString(z2));
        a.put("specified_transcode_bit_rate", Integer.toString(i2));
        a.put("estimated_video_bit_rate", Integer.toString(i3));
        a.put("estimated_audio_bit_rate", Integer.toString(i4));
        m19819a(Event.MEDIA_UPLOAD_ATTEMPT_VIDEO_RESIZE_CHECK_SUCCESS, a, null);
    }

    public final void m19862a(UploadBaseParams uploadBaseParams, long j, boolean z) {
        Map a = uploadBaseParams.m20077a();
        a.put("original_file_size", Long.toString(j));
        a.put("attempt_video_resize", Boolean.toString(z));
        m19819a(Event.MEDIA_UPLOAD_ATTEMPT_VIDEO_RESIZE_CHECK_SKIPPED, a, null);
    }

    public final void m19851a(UploadBaseParams uploadBaseParams, long j) {
        Map a = uploadBaseParams.m20077a();
        a.put("video_resized_file_size", Long.toString(j));
        m19819a(Event.MEDIA_UPLOAD_PROCESS_FOUND_EXISTING_FILE, a, null);
    }

    public final void m19857a(UploadBaseParams uploadBaseParams, long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, long j5, long j6) {
        Map a = uploadBaseParams.m20077a();
        a.put("video_transcode_flow_count", Long.toString(j));
        a.put("video_transcode_start_count", Long.toString(j2));
        a.put("video_transcode_success_count", Long.toString(j3));
        a.put("video_transcode_fail_count", Long.toString(j4));
        a.put("video_transcode_is_segmented", Boolean.toString(z));
        a.put("video_requested_server_settings", Boolean.toString(z2));
        a.put("video_server_settings_available", Boolean.toString(z3));
        a.put("server_specified_transcode_bitrate", Long.toString(j5));
        a.put("server_specified_transcode_dimension", Long.toString(j6));
        m19819a(Event.MEDIA_UPLOAD_PROCESS_READ_PERSISTED_TRANSCODE_INFO, a, null);
    }

    public final void m19913b(UploadBaseParams uploadBaseParams, long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, long j5, long j6) {
        Map a = uploadBaseParams.m20077a();
        a.put("video_transcode_flow_count", Long.toString(j));
        a.put("video_transcode_start_count", Long.toString(j2));
        a.put("video_transcode_success_count", Long.toString(j3));
        a.put("video_transcode_fail_count", Long.toString(j4));
        a.put("video_transcode_is_segmented", Boolean.toString(z));
        a.put("video_requested_server_settings", Boolean.toString(z2));
        a.put("video_server_settings_available", Boolean.toString(z3));
        a.put("server_specified_transcode_bitrate", Long.toString(j5));
        a.put("server_specified_transcode_dimension", Long.toString(j6));
        m19819a(Event.MEDIA_UPLOAD_PROCESS_CHECKPOINT_PERSISTED_TRANSCODE_INFO, a, null);
    }

    public final void m19911b(UploadBaseParams uploadBaseParams, long j) {
        Map a = uploadBaseParams.m20077a();
        a.put("video_transcode_success_count", Long.toString(j));
        m19819a(Event.MEDIA_UPLOAD_PROCESS_MISSING_EXISTING_FILE, a, null);
    }

    public final void m19909b(UploadBaseParams uploadBaseParams) {
        m19834c(uploadBaseParams.m20077a());
    }

    public final void m19890a(UploadBaseParams uploadBaseParams, boolean z, int i, String str, boolean z2, int i2, int i3, boolean z3, int i4, RectF rectF, long j) {
        HashMap a = uploadBaseParams.m20077a();
        a.put("higher_quality_transcode", Boolean.toString(z));
        a.put("specified_transcode_bit_rate", Integer.toString(i));
        a.put("video_transcode_profile", str);
        a.put("is_video_trim", Boolean.toString(z2));
        if (z2) {
            a.put("video_trim_start_time_ms", Integer.toString(i2));
            a.put("video_trim_end_time_ms", Integer.toString(i3));
        }
        a.put("is_video_muted", Boolean.toString(z3));
        a.put("video_output_rotation_angle", Integer.toString(i4));
        if (rectF != null) {
            a.put("video_crop_rectangle", m19817a(rectF));
        }
        a.put("video_transcode_immediate_retry_count", Long.toString(j));
        m19834c(a);
    }

    private static String m19817a(RectF rectF) {
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

    public final void m19847a(UploadBaseParams uploadBaseParams, int i, long j) {
        Map a = uploadBaseParams.m20077a();
        m19831b((HashMap) a);
        a.put("num_total_segments", Integer.toString(i));
        a.put("video_duration", Float.toString(((float) j) / 1000.0f));
        m19819a(Event.MEDIA_UPLOAD_SEGMENTED_TRANSCODE_START, a, null);
    }

    public final void m19926c(UploadBaseParams uploadBaseParams, PhotoFlowLogger$ExceptionReporter photoFlowLogger$ExceptionReporter) {
        Map a = uploadBaseParams.m20077a();
        m19831b((HashMap) a);
        m19824a((HashMap) a, photoFlowLogger$ExceptionReporter);
        m19832b((HashMap) a, this.f12604t);
        m19819a(Event.MEDIA_UPLOAD_PROCESS_FAILURE, a, null);
        this.f12585F.m20024a(photoFlowLogger$ExceptionReporter.mo1089c(), photoFlowLogger$ExceptionReporter.mo1090d());
    }

    public final void m19848a(UploadBaseParams uploadBaseParams, int i, long j, int i2, int i3, int i4, int i5) {
        Map a = uploadBaseParams.m20077a();
        m19831b((HashMap) a);
        a.put("num_total_segments", Integer.toString(i));
        a.put("video_duration", Float.toString(((float) j) / 1000.0f));
        a.put("segment_id", Integer.toString(i2));
        a.put("segment_type", Integer.toString(i3));
        a.put("segment_start_time", Integer.toString(i4));
        a.put("segment_end_time", Integer.toString(i5));
        m19819a(Event.MEDIA_UPLOAD_SEGMENTED_TRANSCODE_FAILURE, a, null);
    }

    public final void m19923c(UploadBaseParams uploadBaseParams) {
        Map a = uploadBaseParams.m20077a();
        m19831b((HashMap) a);
        m19832b((HashMap) a, this.f12604t);
        m19819a(Event.MEDIA_UPLOAD_PROCESS_CANCEL, a, null);
        this.f12585F.m20034h();
    }

    public final void m19879a(UploadBaseParams uploadBaseParams, String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2, long j3) {
        Map a = uploadBaseParams.m20077a();
        m19831b((HashMap) a);
        a.put("source_width", Integer.toString(i));
        a.put("source_height", Integer.toString(i2));
        a.put("source_bit_rate", Integer.toString(i3));
        a.put("source_frame_rate", Integer.toString(i4));
        a.put("target_width", Integer.toString(i5));
        a.put("target_height", Integer.toString(i6));
        if (j2 > 0) {
            a.put("original_file_size", Long.toString(j2));
        }
        a.put("bytes", Long.toString(j3));
        a.put("target_bit_rate", Integer.toString(i7));
        a.put("target_frame_rate", Integer.toString(i8));
        m19832b((HashMap) a, this.f12604t);
        m19819a(Event.MEDIA_UPLOAD_PROCESS_SUCCESS, a, null);
        this.f12585F.m20023a(str, i, i2, i3, i4, i5, i6, i7, i8, j);
    }

    public final void m19910b(UploadBaseParams uploadBaseParams, int i, long j) {
        Map a = uploadBaseParams.m20077a();
        m19831b((HashMap) a);
        a.put("num_total_segments", Integer.toString(i));
        a.put("video_duration", Float.toString(((float) j) / 1000.0f));
        m19819a(Event.MEDIA_UPLOAD_SEGMENTED_TRANSCODE_SUCCESS, a, null);
    }

    public final void m19852a(UploadBaseParams uploadBaseParams, long j, int i) {
        Map a = uploadBaseParams.m20077a();
        a.put("original_file_size", Long.toString(j));
        a.put("specified_transcode_bit_rate", Integer.toString(i));
        m19819a(Event.MEDIA_UPLOAD_PROCESS_SKIPPED, a, null);
    }

    public final void m19856a(UploadBaseParams uploadBaseParams, long j, long j2, long j3, long j4, boolean z) {
        Map a = uploadBaseParams.m20077a();
        a.put("video_transcode_flow_count", Long.toString(j));
        a.put("video_transcode_start_count", Long.toString(j2));
        a.put("video_transcode_success_count", Long.toString(j3));
        a.put("video_transcode_fail_count", Long.toString(j4));
        a.put("video_transcode_is_segmented", Boolean.toString(z));
        m19819a(Event.MEDIA_UPLOAD_PROCESS_OMITTED_TOO_MANY_FAILURES, a, null);
    }

    public final void m19878a(UploadBaseParams uploadBaseParams, String str) {
        Map a = uploadBaseParams.m20077a();
        m19831b((HashMap) a);
        a.put("extra_hash", str);
        m19819a(Event.MEDIA_UPLOAD_TRANSFER_SKIP, a, null);
        this.f12585F.m20039m();
    }

    public final void m19912b(UploadBaseParams uploadBaseParams, long j, int i) {
        this.f12606v = this.f12591g.now();
        Map a = uploadBaseParams.m20077a();
        m19831b((HashMap) a);
        a.put("bytes", Long.toString(j));
        a.put("auto_retry_count", Integer.toString(i));
        m19819a(Event.MEDIA_UPLOAD_TRANSFER_START, a, null);
        this.f12585F.m20035i();
    }

    public final void m19925c(UploadBaseParams uploadBaseParams, long j, int i) {
        Map a = uploadBaseParams.m20077a();
        m19831b((HashMap) a);
        a.put("bytes", Long.toString(j));
        a.put("auto_retry_count", Integer.toString(i));
        m19832b((HashMap) a, this.f12606v);
        m19819a(Event.MEDIA_UPLOAD_TRANSFER_SUCCESS, a, null);
        this.f12585F.m20038l();
    }

    public final void m19855a(UploadBaseParams uploadBaseParams, long j, long j2, int i, PhotoFlowLogger$ExceptionReporter photoFlowLogger$ExceptionReporter) {
        Map a = uploadBaseParams.m20077a();
        m19831b((HashMap) a);
        a.put("sent_bytes", Long.toString(j));
        a.put("total_bytes", Long.toString(j2));
        a.put("auto_retry_count", Integer.toString(i));
        m19824a((HashMap) a, photoFlowLogger$ExceptionReporter);
        m19832b((HashMap) a, this.f12606v);
        m19819a(Event.MEDIA_UPLOAD_TRANSFER_FAILURE, a, null);
        this.f12585F.m20036j();
    }

    public final void m19854a(UploadBaseParams uploadBaseParams, long j, long j2, int i) {
        Map a = uploadBaseParams.m20077a();
        m19831b((HashMap) a);
        a.put("sent_bytes", Long.toString(j));
        a.put("total_bytes", Long.toString(j2));
        a.put("auto_retry_count", Integer.toString(i));
        m19832b((HashMap) a, this.f12606v);
        m19819a(Event.MEDIA_UPLOAD_TRANSFER_CANCEL, a, null);
        this.f12585F.m20037k();
    }

    public final void m19877a(UploadBaseParams uploadBaseParams, UploadInfo uploadInfo, Map<String, String> map, String str, String str2) {
        this.f12608x = this.f12591g.now();
        Map a = uploadBaseParams.m20077a();
        m19825a((HashMap) a, (UploadOperation) uploadInfo);
        if (!map.isEmpty()) {
            a.put("video_metadata", new JSONObject(map).toString());
        }
        a.put("video_original_file_path", str);
        a.put("mime_type", str2);
        m19819a(Event.MEDIA_UPLOAD_INIT_START, a, null);
        this.f12585F.m20042p();
    }

    public final void m19859a(UploadBaseParams uploadBaseParams, long j, UploadOperation uploadOperation) {
        Map a = uploadBaseParams.m20077a();
        m19825a((HashMap) a, uploadOperation);
        a.put("upload_session_id", Long.toString(j));
        m19832b((HashMap) a, this.f12608x);
        m19819a(Event.MEDIA_UPLOAD_INIT_SUCCESS, a, null);
        this.f12585F.m20044r();
    }

    public final void m19868a(UploadBaseParams uploadBaseParams, PhotoFlowLogger$ExceptionReporter photoFlowLogger$ExceptionReporter, UploadOperation uploadOperation) {
        Map a = uploadBaseParams.m20077a();
        m19824a((HashMap) a, photoFlowLogger$ExceptionReporter);
        m19825a((HashMap) a, uploadOperation);
        m19832b((HashMap) a, this.f12608x);
        m19819a(Event.MEDIA_UPLOAD_INIT_FAILURE, a, null);
        this.f12585F.m20026b(photoFlowLogger$ExceptionReporter.mo1089c(), photoFlowLogger$ExceptionReporter.mo1090d());
    }

    public final void m19936e(UploadBaseParams uploadBaseParams, UploadOperation uploadOperation) {
        Map a = uploadBaseParams.m20077a();
        m19825a((HashMap) a, uploadOperation);
        m19832b((HashMap) a, this.f12608x);
        m19819a(Event.MEDIA_UPLOAD_INIT_CANCEL, a, null);
        this.f12585F.m20043q();
    }

    public final void m19880a(UploadBaseParams uploadBaseParams, String str, int i, long j, long j2, int i2, String str2) {
        this.f12609y = this.f12591g.now();
        Map a = uploadBaseParams.m20077a();
        a.put("chunk_offset", Long.toString(j));
        a.put("chunk_size", Long.toString(j2));
        a.put("auto_retry_count", Integer.toString(i2));
        a.put("upload_session_id", str);
        a.put("video_chunk_id", str2);
        a.put("is_using_fbuploader", Boolean.toString(this.f12581B));
        m19822a((HashMap) a);
        m19819a(Event.MEDIA_UPLOAD_CHUNK_TRANSFER_START, a, null);
        this.f12585F.m20022a(i, j, j2, i2);
    }

    public final void m19882a(UploadBaseParams uploadBaseParams, String str, long j, int i, ChunkUploadProgressStatus chunkUploadProgressStatus) {
        Map a = uploadBaseParams.m20077a();
        a.put("sent_bytes", Long.toString(j));
        a.put("total_bytes", Long.toString(j));
        a.put("auto_retry_count", Integer.toString(i));
        a.put("upload_session_id", str);
        if (chunkUploadProgressStatus != null) {
            a.put("video_chunk_id", chunkUploadProgressStatus.f14307h);
        }
        a.put("is_using_fbuploader", Boolean.toString(this.f12581B));
        m19832b((HashMap) a, this.f12609y);
        m19822a((HashMap) a);
        m19819a(Event.MEDIA_UPLOAD_CHUNK_TRANSFER_CANCEL, a, null);
        this.f12585F.m20045s();
    }

    public final void m19884a(UploadBaseParams uploadBaseParams, String str, long j, long j2, int i, ChunkUploadProgressStatus chunkUploadProgressStatus, PhotoFlowLogger$ExceptionReporter photoFlowLogger$ExceptionReporter) {
        Map a = uploadBaseParams.m20077a();
        a.put("sent_bytes", Long.toString(j));
        a.put("total_bytes", Long.toString(j2));
        a.put("auto_retry_count", Integer.toString(i));
        a.put("upload_session_id", str);
        if (chunkUploadProgressStatus != null) {
            a.put("chunk_offset", Long.toString(chunkUploadProgressStatus.m21959b()));
            a.put("chunk_size", Long.toString(chunkUploadProgressStatus.m21960c()));
            a.put("immediate_retry_count", Long.toString(chunkUploadProgressStatus.m21961d()));
            a.put("upload_speed_previous", Float.toString(chunkUploadProgressStatus.f14303d));
            a.put("upload_speed_updated", Float.toString(chunkUploadProgressStatus.m21963f()));
            a.put("video_chunk_id", chunkUploadProgressStatus.m21958a());
        }
        a.put("is_using_fbuploader", Boolean.toString(this.f12581B));
        m19824a((HashMap) a, photoFlowLogger$ExceptionReporter);
        m19832b((HashMap) a, this.f12609y);
        m19822a((HashMap) a);
        m19819a(Event.MEDIA_UPLOAD_CHUNK_TRANSFER_FAILURE, a, null);
        this.f12585F.m20028c(photoFlowLogger$ExceptionReporter.mo1089c(), photoFlowLogger$ExceptionReporter.mo1090d());
    }

    public final void m19883a(UploadBaseParams uploadBaseParams, String str, long j, long j2, int i, long j3, String str2) {
        Map a = uploadBaseParams.m20077a();
        a.put("bytes", Long.toString(j2));
        a.put("chunk_offset", Long.toString(j));
        a.put("auto_retry_count", Integer.toString(i));
        a.put("transfer_progress", Float.toString(m19828b(j3, j, j2)));
        a.put("chunk_bandwidth", Long.toString(m19813a(j2, m19835d(this.f12609y))));
        a.put("estimated_total_time", Long.toString(m19814a(j3, j2, m19835d(this.f12609y))));
        a.put("upload_session_id", str);
        a.put("video_chunk_id", str2);
        a.put("is_using_fbuploader", Boolean.toString(this.f12581B));
        m19832b((HashMap) a, this.f12609y);
        this.f12610z = this.f12591g.now();
        m19822a((HashMap) a);
        m19819a(Event.MEDIA_UPLOAD_CHUNK_TRANSFER_SUCCESS, a, null);
        this.f12585F.m20046t();
    }

    public final void m19885a(UploadBaseParams uploadBaseParams, String str, long j, long j2, long j3, int i, ChunkUploadProgressStatus chunkUploadProgressStatus) {
        Map a = uploadBaseParams.m20077a();
        a.put("chunk_offset", Long.toString(j));
        a.put("chunk_bytes", Long.toString(j2));
        a.put("chunk_size", Long.toString(j3));
        a.put("auto_retry_count", Integer.toString(i));
        a.put("upload_session_id", str);
        a.put("is_using_fbuploader", Boolean.toString(this.f12581B));
        m19832b((HashMap) a, this.f12610z);
        if (chunkUploadProgressStatus != null) {
            a.put("chunk_offset", Long.toString(chunkUploadProgressStatus.m21959b()));
            a.put("chunk_size", Long.toString(chunkUploadProgressStatus.m21960c()));
            a.put("immediate_retry_count", Long.toString(chunkUploadProgressStatus.m21961d()));
            a.put("upload_speed_previous", Float.toString(chunkUploadProgressStatus.m21962e()));
            a.put("upload_speed_updated", Float.toString(chunkUploadProgressStatus.m21963f()));
            a.put("chunk_offset_updated", Long.toString(chunkUploadProgressStatus.m21964g()));
            a.put("chunk_size_updated", Long.toString(chunkUploadProgressStatus.m21965h()));
            a.put("video_chunk_id", chunkUploadProgressStatus.m21958a());
        }
        m19819a(Event.MEDIA_UPLOAD_CHUNK_TRANSFER_RESPONSE, a, null);
    }

    public final void m19887a(UploadBaseParams uploadBaseParams, String str, UploadOperation uploadOperation) {
        Map a = uploadBaseParams.m20077a();
        m19825a((HashMap) a, uploadOperation);
        a.put("upload_session_id", str);
        this.f12580A = this.f12591g.now();
        m19819a(Event.MEDIA_POST_START, a, null);
        this.f12585F.m20047u();
    }

    public final void m19917b(UploadBaseParams uploadBaseParams, String str, UploadOperation uploadOperation) {
        Map a = uploadBaseParams.m20077a();
        m19825a((HashMap) a, uploadOperation);
        a.put("upload_session_id", str);
        m19832b((HashMap) a, this.f12580A);
        m19819a(Event.MEDIA_POST_SUCCESS, a, null);
        this.f12585F.m20048v();
    }

    public final void m19886a(UploadBaseParams uploadBaseParams, String str, PhotoFlowLogger$ExceptionReporter photoFlowLogger$ExceptionReporter, UploadOperation uploadOperation) {
        Map a = uploadBaseParams.m20077a();
        m19825a((HashMap) a, uploadOperation);
        a.put("upload_session_id", str);
        m19824a((HashMap) a, photoFlowLogger$ExceptionReporter);
        m19832b((HashMap) a, this.f12580A);
        m19819a(Event.MEDIA_POST_FAILURE, a, null);
        this.f12585F.m20030d(photoFlowLogger$ExceptionReporter.mo1089c(), photoFlowLogger$ExceptionReporter.mo1090d());
    }

    public final void m19869a(UploadBaseParams uploadBaseParams, PublishStageBaseParams publishStageBaseParams) {
        Map a = uploadBaseParams.m20077a();
        publishStageBaseParams.m20076a(a);
        m19819a(Event.MEDIA_PUBLISH_START, a, null);
        this.f12607w = this.f12591g.now();
    }

    public final void m19915b(UploadBaseParams uploadBaseParams, PublishStageBaseParams publishStageBaseParams) {
        Map a = uploadBaseParams.m20077a();
        publishStageBaseParams.m20076a(a);
        m19832b((HashMap) a, this.f12607w);
        m19819a(Event.MEDIA_PUBLISH_SENT, a, null);
    }

    public final void m19927c(UploadBaseParams uploadBaseParams, PublishStageBaseParams publishStageBaseParams) {
        Map a = uploadBaseParams.m20077a();
        publishStageBaseParams.m20076a(a);
        m19832b((HashMap) a, this.f12607w);
        m19819a(Event.MEDIA_PUBLISH_RECEIVED, a, null);
    }

    public final void m19933d(UploadBaseParams uploadBaseParams, PublishStageBaseParams publishStageBaseParams) {
        Map a = uploadBaseParams.m20077a();
        publishStageBaseParams.m20076a(a);
        m19832b((HashMap) a, this.f12607w);
        m19819a(Event.MEDIA_PUBLISH_SUCCESS, a, null);
    }

    public final void m19870a(UploadBaseParams uploadBaseParams, PublishStageBaseParams publishStageBaseParams, PhotoFlowLogger$ExceptionReporter photoFlowLogger$ExceptionReporter) {
        Map a = uploadBaseParams.m20077a();
        publishStageBaseParams.m20076a(a);
        m19824a((HashMap) a, photoFlowLogger$ExceptionReporter);
        m19832b((HashMap) a, this.f12607w);
        m19819a(Event.MEDIA_PUBLISH_FAILURE, a, null);
    }

    public final void m19931d(UploadBaseParams uploadBaseParams) {
        m19819a(Event.MEDIA_UPLOAD_CHECKPOINT_FAILURE, uploadBaseParams.m20077a(), null);
    }

    public final void m19876a(UploadBaseParams uploadBaseParams, UploadOperation uploadOperation, String str) {
        Map a = uploadBaseParams.m20077a();
        m19825a((HashMap) a, uploadOperation);
        a.put("restarted_operation_source", str);
        m19819a(Event.MEDIA_UPLOAD_RESTART, a, null);
    }

    public final void m19893a(String str, UploadType uploadType, UploadMethodType uploadMethodType, UploadOperation uploadOperation) {
        Map b = m19830b(str, uploadType, uploadMethodType);
        m19825a((HashMap) b, uploadOperation);
        m19819a(Event.MEDIA_UPLOAD_RESTART_FAILURE, b, null);
    }

    public final void m19939f(UploadBaseParams uploadBaseParams, UploadOperation uploadOperation) {
        Map a = uploadBaseParams.m20077a();
        m19825a((HashMap) a, uploadOperation);
        m19819a(Event.MEDIA_UPLOAD_INIT_CONTEXT, a, null);
    }

    public final void m19924c(UploadBaseParams uploadBaseParams, long j) {
        Map a = uploadBaseParams.m20077a();
        a.put("upload_session_id", Long.toString(j));
        m19819a(Event.MEDIA_UPLOAD_CANCEL_REQUEST_START, a, null);
    }

    public final void m19932d(UploadBaseParams uploadBaseParams, long j) {
        Map a = uploadBaseParams.m20077a();
        a.put("upload_session_id", Long.toString(j));
        m19819a(Event.MEDIA_UPLOAD_CANCEL_REQUEST_SUCCESS, a, null);
    }

    public final void m19860a(UploadBaseParams uploadBaseParams, long j, Exception exception) {
        Map a = uploadBaseParams.m20077a();
        a.put("upload_session_id", Long.toString(j));
        m19824a((HashMap) a, new ExceptionInterpreter(exception, true));
        m19819a(Event.MEDIA_UPLOAD_CANCEL_REQUEST_FAILURE, a, null);
    }

    public final void m19895a(String str, UploadType uploadType, UploadMethodType uploadMethodType, UploadOperation uploadOperation, int i, String str2) {
        Map b = m19830b(str, uploadType, uploadMethodType);
        m19825a((HashMap) b, uploadOperation);
        b.put("upload_retry_loop_uuid", str2);
        b.put("upload_manager_queue_count", Integer.toString(i));
        m19819a(Event.MEDIA_UPLOAD_RETRY_QUEUE_CHECK, b, null);
    }

    private void m19825a(HashMap<String, String> hashMap, UploadInfo uploadInfo) {
        if (uploadInfo != null) {
            boolean z;
            String str = uploadInfo.f13784g;
            if (!StringUtil.a(str)) {
                hashMap.put("target_type", str);
            }
            hashMap.put("media_attachment_count", Integer.toString(uploadInfo.m21532c()));
            hashMap.put("auto_retry_count", Integer.toString(uploadInfo.m21535d()));
            hashMap.put("interrupted_count", Integer.toString(uploadInfo.m21538f()));
            hashMap.put("current_auto_retry_count", Integer.toString(uploadInfo.m21539g()));
            hashMap.put("extra_hasfailed_retrymightwork", Boolean.toString(uploadInfo.m21540h()));
            hashMap.put("extra_op_may_auto_retry", Boolean.toString(uploadInfo.m21542k()));
            hashMap.put("extra_hasfailed_network_error", Boolean.toString(uploadInfo.m21541i()));
            str = "extra_hasfailed_nonnetwork_error";
            if (uploadInfo.f13756E == null || uploadInfo.f13756E.f13691a) {
                z = false;
            } else {
                z = true;
            }
            hashMap.put(str, Boolean.toString(z));
            hashMap.put("extra_nonnetwork_error_count", Integer.toString(uploadInfo.f13755D.f13814i));
            hashMap.put("extra_last_user_attempt_time", Long.toString(uploadInfo.f13755D.f13807b));
            hashMap.put("extra_last_auto_retry_attempt_time", Long.toString(uploadInfo.m21543n()));
            if (uploadInfo.m21522a() == UploadType.VIDEO) {
                hashMap.put("attempt_number", Integer.toString(uploadInfo.m21537e()));
            } else {
                hashMap.put("manual_retry_count", Integer.toString(uploadInfo.m21537e()));
            }
            if (uploadInfo.f13763L != null) {
                hashMap.put("parent_op", uploadInfo.f13763L);
            }
        }
        m19831b((HashMap) hashMap);
    }

    private static long m19813a(long j, long j2) {
        return j2 > 0 ? (long) (((float) j) / (((float) j2) / 1000.0f)) : 0;
    }

    private static long m19814a(long j, long j2, long j3) {
        long a = m19813a(j2, j3);
        if (a > 0) {
            return j / a;
        }
        return 0;
    }

    private void m19822a(HashMap<String, String> hashMap) {
        hashMap.put("connection_manager_bandwidth_quality", this.f12586G.b().toString());
        hashMap.put("connection_manager_guessed_bandwidth_quality", this.f12586G.c().toString());
        hashMap.put("connection_manager_bandwidth_kbps", Long.toString(Math.round(this.f12586G.e())));
        hashMap.put("connection_manager_latency_quality", this.f12586G.d().toString());
        hashMap.put("connection_manager_rtt_ms", Long.toString(Math.round(this.f12586G.f())));
    }

    private static void m19823a(HashMap<String, String> hashMap, long j) {
        hashMap.put("dt", Long.toString(m19833c(j)));
    }

    private static long m19833c(long j) {
        Object obj = (j < 0 || j >= 1356998400) ? null : 1;
        return obj != null ? j : -1;
    }

    private void m19832b(HashMap<String, String> hashMap, long j) {
        m19823a((HashMap) hashMap, this.f12591g.now() - j);
    }

    private long m19835d(long j) {
        return m19833c(this.f12591g.now() - j);
    }

    private void m19831b(HashMap<String, String> hashMap) {
        hashMap.put("app_state", ((AppStateManager) this.f12592h.get()).j() ? "background" : "foreground");
    }

    private void m19834c(HashMap<String, String> hashMap) {
        m19831b((HashMap) hashMap);
        m19819a(Event.MEDIA_UPLOAD_PROCESS_START, (Map) hashMap, null);
        this.f12604t = this.f12591g.now();
        this.f12585F.m20033g();
    }

    private static float m19828b(long j, long j2, long j3) {
        if (j <= 0) {
            return 0.0f;
        }
        return ((float) (j2 + j3)) / ((float) j);
    }
}
