package com.facebook.photos.upload.uploaders;

import com.facebook.common.time.Clock;
import com.facebook.http.protocol.ApiMethodProgressListener;
import com.facebook.http.protocol.HttpWireCallback;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.ExceptionInterpreter;
import com.facebook.photos.base.analytics.PhotoFlowLogger$ExceptionReporter;
import com.facebook.photos.base.analytics.upload.UploadBaseParams;
import com.facebook.photos.upload.event.BaseMediaUploadEvent$Status;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.photos.upload.event.VideoUploadProgressEvent;
import com.facebook.photos.upload.operation.UploadOperation;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: fs_total_custom_location_size */
public class VideoUploaderProgressListener implements ApiMethodProgressListener, HttpWireCallback {
    public final UploadOperation f14566a;
    public final DefaultPhotoFlowLogger f14567b;
    public final UploadBaseParams f14568c;
    public final MediaUploadCancelHandler f14569d;
    public final MediaUploadEventBus f14570e;
    private final Clock f14571f;
    private long f14572g = 0;
    private int f14573h = 0;
    public long f14574i = 0;
    private AtomicLong f14575j;
    public int f14576k = 0;
    public String f14577l;
    private String f14578m;
    public Map<String, ChunkProgressInfo> f14579n;
    private boolean f14580o;

    public VideoUploaderProgressListener(UploadOperation uploadOperation, DefaultPhotoFlowLogger defaultPhotoFlowLogger, UploadBaseParams uploadBaseParams, MediaUploadCancelHandler mediaUploadCancelHandler, MediaUploadEventBus mediaUploadEventBus, Clock clock) {
        this.f14566a = uploadOperation;
        this.f14567b = defaultPhotoFlowLogger;
        this.f14568c = uploadBaseParams;
        this.f14569d = mediaUploadCancelHandler;
        this.f14570e = mediaUploadEventBus;
        this.f14571f = clock;
        this.f14575j = new AtomicLong(0);
        this.f14579n = Collections.synchronizedMap(new HashMap());
        this.f14580o = false;
    }

    public final void m22164b() {
        this.f14577l = null;
        this.f14574i = 0;
        this.f14576k = 0;
        this.f14575j.set(0);
        this.f14578m = null;
        this.f14579n.clear();
    }

    public final void m22165b(long j) {
        this.f14575j.set(j);
    }

    public final void m22166c(long j) {
        this.f14574i = j;
    }

    public final synchronized void m22163a(String str, long j, long j2, long j3, int i, String str2) {
        this.f14577l = str;
        this.f14574i = j3;
        this.f14576k = i;
        this.f14578m = str2;
        this.f14579n.put(this.f14578m, new ChunkProgressInfo(j, j2));
        DefaultPhotoFlowLogger defaultPhotoFlowLogger = this.f14567b;
        UploadBaseParams uploadBaseParams = this.f14568c;
        String str3 = this.f14577l;
        int i2 = this.f14573h;
        this.f14573h = i2 + 1;
        defaultPhotoFlowLogger.m19880a(uploadBaseParams, str3, i2, j, j2, this.f14576k, str2);
    }

    public final void m22159a(ExceptionInterpreter exceptionInterpreter, VideoUploadStage videoUploadStage, ChunkUploadProgressStatus chunkUploadProgressStatus) {
        if (this.f14569d.f14351d) {
            this.f14579n.clear();
            DefaultPhotoFlowLogger defaultPhotoFlowLogger = this.f14567b;
            UploadBaseParams uploadBaseParams = this.f14568c;
            String str = this.f14577l;
            this.f14575j.get();
            defaultPhotoFlowLogger.m19882a(uploadBaseParams, str, this.f14574i, this.f14576k, chunkUploadProgressStatus);
            this.f14567b.m19854a(this.f14568c, this.f14575j.get(), this.f14574i, this.f14576k);
        } else if (exceptionInterpreter != null) {
            if (chunkUploadProgressStatus != null) {
                ChunkProgressInfo chunkProgressInfo = (ChunkProgressInfo) this.f14579n.get(chunkUploadProgressStatus.f14307h);
                if (chunkProgressInfo != null) {
                    this.f14575j.getAndAdd(-chunkProgressInfo.f14271a);
                    this.f14579n.remove(chunkUploadProgressStatus.f14307h);
                }
            }
            if (videoUploadStage == VideoUploadStage.START) {
                this.f14567b.m19868a(this.f14568c, (PhotoFlowLogger$ExceptionReporter) exceptionInterpreter, this.f14566a);
            } else if (videoUploadStage == VideoUploadStage.RECEIVE) {
                this.f14567b.m19884a(this.f14568c, this.f14577l, this.f14575j.get(), this.f14574i, this.f14576k, chunkUploadProgressStatus, (PhotoFlowLogger$ExceptionReporter) exceptionInterpreter);
            } else if (videoUploadStage == VideoUploadStage.POST) {
                this.f14567b.m19886a(this.f14568c, this.f14577l, (PhotoFlowLogger$ExceptionReporter) exceptionInterpreter, this.f14566a);
            }
        }
    }

    public final void m22157a(long j, long j2) {
        m22162a(this.f14578m, j, j2);
    }

    public final void m22155a() {
        this.f14580o = true;
    }

    public final void m22156a(long j) {
        m22161a(this.f14578m, j);
    }

    public final void m22161a(String str, long j) {
        Preconditions.checkState(this.f14580o, "Should not be receiving callbacks if notifyCallbackUsed hasn't been called");
        ChunkProgressInfo chunkProgressInfo = (ChunkProgressInfo) this.f14579n.get(str);
        if (chunkProgressInfo != null) {
            m22154b(str, chunkProgressInfo.f14271a + j, chunkProgressInfo.f14272b);
        }
    }

    public final void m22162a(String str, long j, long j2) {
        if (!this.f14580o) {
            m22154b(str, j, j2);
        }
    }

    private synchronized void m22154b(String str, long j, long j2) {
        ChunkProgressInfo chunkProgressInfo = (ChunkProgressInfo) this.f14579n.get(str);
        if (chunkProgressInfo != null) {
            long addAndGet = this.f14575j.addAndGet(j - chunkProgressInfo.f14271a);
            chunkProgressInfo.f14271a = j;
            chunkProgressInfo.f14272b = j2;
            long a = this.f14571f.a();
            if (a - this.f14572g >= 1000 || j >= j2) {
                this.f14570e.a(new VideoUploadProgressEvent(this.f14566a, BaseMediaUploadEvent$Status.UPLOADING, (int) ((((double) addAndGet) * 100.0d) / ((double) this.f14574i))));
                this.f14572g = a;
            }
        }
    }

    public final void m22160a(String str) {
        ChunkProgressInfo chunkProgressInfo = (ChunkProgressInfo) this.f14579n.get(str);
        if (chunkProgressInfo != null) {
            this.f14567b.m19883a(this.f14568c, this.f14577l, chunkProgressInfo.f14273c, chunkProgressInfo.f14271a, this.f14576k, this.f14574i, str);
        }
        this.f14579n.remove(str);
    }

    public final void m22158a(ExceptionInterpreter exceptionInterpreter) {
        this.f14567b.m19855a(this.f14568c, this.f14575j.get(), this.f14574i, this.f14576k, (PhotoFlowLogger$ExceptionReporter) exceptionInterpreter);
    }
}
