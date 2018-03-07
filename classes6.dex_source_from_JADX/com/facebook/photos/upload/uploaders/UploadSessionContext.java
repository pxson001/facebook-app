package com.facebook.photos.upload.uploaders;

import android.graphics.RectF;
import com.facebook.fbuploader.FbUploader.FbUploadJobHandle;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.upload.UploadBaseParams;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadPartitionInfo;
import com.facebook.photos.upload.operation.UploadRecord;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.videocodec.base.VideoMetadata;
import com.facebook.videocodec.policy.HighRateVideoResizingPolicy;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: friends_locations_feedstory_scroll_left */
public class UploadSessionContext {
    List<UploadPartitionInfo> f14447A;
    UploadRecord f14448B;
    int f14449C;
    VideoMetadata f14450D;
    boolean f14451E;
    boolean f14452F;
    HighRateVideoResizingPolicy f14453G;
    public boolean f14454H;
    public int f14455I;
    public boolean f14456J;
    public boolean f14457K;
    public int f14458L;
    public int f14459M;
    public RectF f14460N;
    boolean f14461O;
    long f14462P;
    long f14463Q;
    long f14464R;
    ArrayList<FbUploadJobHandle> f14465S;
    TranscodeSettings f14466T;
    public volatile UploadOperation f14467a;
    Long f14468b = Long.valueOf(-1);
    ApiMethodRunnerParams f14469c = null;
    String f14470d = Long.toString(this.f14468b.longValue());
    String f14471e = "-1";
    String f14472f = "";
    Map<String, UploadRecord> f14473g = new HashMap();
    VideoUploaderProgressListener f14474h;
    boolean f14475i;
    String f14476j = "";
    String f14477k = "";
    long f14478l = 0;
    long f14479m = -1;
    boolean f14480n = false;
    SettableFuture<Boolean> f14481o;
    String f14482p;
    long f14483q;
    int f14484r;
    int f14485s;
    long f14486t;
    long f14487u;
    Exception f14488v;
    VideoUploadStage f14489w;
    DefaultPhotoFlowLogger f14490x;
    SegmentedUploadItem f14491y;
    UploadBaseParams f14492z;

    public UploadSessionContext(UploadOperation uploadOperation) {
        this.f14467a = uploadOperation;
        this.f14481o = SettableFuture.f();
        this.f14482p = "";
        this.f14483q = 0;
        this.f14484r = -1;
        this.f14485s = -1;
        this.f14486t = 0;
        this.f14487u = 0;
        this.f14488v = null;
        this.f14489w = VideoUploadStage.START;
        this.f14490x = null;
        this.f14491y = null;
        this.f14492z = null;
        this.f14448B = null;
        this.f14450D = null;
        this.f14453G = null;
        this.f14454H = false;
        this.f14455I = 0;
        this.f14456J = false;
        this.f14457K = false;
        this.f14458L = -1;
        this.f14459M = -2;
        this.f14460N = null;
        if (!uploadOperation.f13777Z) {
            m22075a(true);
        }
        this.f14447A = new ArrayList();
        this.f14449C = 0;
        this.f14461O = false;
        this.f14462P = 5;
        this.f14463Q = 5;
        this.f14465S = new ArrayList();
    }

    public final void m22075a(boolean z) {
        FutureDetour.a(this.f14481o, Boolean.valueOf(z), 844353235);
    }

    public final String m22073a() {
        Preconditions.checkState(this.f14482p != null);
        return this.f14482p + "_transcode";
    }

    public final String m22074a(long j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f14467a.f13793p);
        stringBuilder.append("_");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("_");
        stringBuilder.append(j);
        stringBuilder.append("_");
        int i = this.f14449C;
        this.f14449C = i + 1;
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    public final Map<String, String> m22076b() {
        Map<String, String> hashMap = new HashMap();
        if (this.f14450D != null) {
            if (this.f14450D.f5488i != null) {
                hashMap.put("location", this.f14450D.f5488i);
            }
            if (this.f14450D.f5489j != null) {
                hashMap.put("date", this.f14450D.f5489j);
            }
            if (this.f14450D.f5480a != -1) {
                hashMap.put("durationMs", Long.toString(this.f14450D.f5480a));
            }
        }
        return hashMap;
    }
}
