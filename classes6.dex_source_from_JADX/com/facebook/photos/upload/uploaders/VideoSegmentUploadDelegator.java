package com.facebook.photos.upload.uploaders;

import android.util.Pair;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.InterpretedException;
import com.facebook.photos.base.analytics.upload.UploadBaseParams;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.photos.upload.manager.UploadCrashMonitor;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadRecord;
import com.facebook.photos.upload.protocol.UploadVideoChunkReceiveMethod;
import com.facebook.photos.upload.protocol.UploadVideoChunkReceiveParams;
import com.facebook.photos.upload.protocol.UploadVideoChunkReceiveResponse;
import com.facebook.photos.upload.retry.ImmediateRetryPolicy;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: friend_suggestion_send */
public class VideoSegmentUploadDelegator {
    private final AbstractSingleMethodRunner f14494a;
    private final UploadVideoChunkReceiveMethod f14495b;
    private final MonotonicClock f14496c;
    private final MediaUploadEventBus f14497d;
    private VideoUploaderExceptionHandler f14498e;

    public static VideoSegmentUploadDelegator m22080a(InjectorLike injectorLike) {
        return new VideoSegmentUploadDelegator((AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), UploadVideoChunkReceiveMethod.m21844a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), MediaUploadEventBus.a(injectorLike));
    }

    @Inject
    public VideoSegmentUploadDelegator(AbstractSingleMethodRunner abstractSingleMethodRunner, UploadVideoChunkReceiveMethod uploadVideoChunkReceiveMethod, MonotonicClock monotonicClock, MediaUploadEventBus mediaUploadEventBus) {
        this.f14494a = abstractSingleMethodRunner;
        this.f14495b = uploadVideoChunkReceiveMethod;
        this.f14496c = monotonicClock;
        this.f14497d = mediaUploadEventBus;
    }

    public final void m22081a(UploadOperation uploadOperation, UploadSessionContext uploadSessionContext, String str, DefaultPhotoFlowLogger defaultPhotoFlowLogger, ImmediateRetryPolicy immediateRetryPolicy, SegmentedUploadItem segmentedUploadItem, UploadBaseParams uploadBaseParams, VideoUploadStateParams videoUploadStateParams, MediaUploadCancelHandler mediaUploadCancelHandler, UploadCrashMonitor uploadCrashMonitor, VideoUploaderExceptionHandler videoUploaderExceptionHandler) {
        Object obj;
        Exception e;
        UploadVideoChunkReceiveResponse uploadVideoChunkReceiveResponse;
        ChunkUploadProgressStatus a;
        Pair a2;
        int i;
        ChunkUploadProgressStatus a3;
        UploadRecord uploadRecord;
        this.f14498e = videoUploaderExceptionHandler;
        uploadSessionContext.f14474h.m22165b(uploadSessionContext.f14486t);
        Preconditions.checkArgument(segmentedUploadItem != null);
        long j = uploadSessionContext.f14486t;
        UploadAssetSegment a4 = segmentedUploadItem.m22065a(uploadSessionContext.f14486t);
        long j2 = 0;
        long j3 = j;
        while (uploadSessionContext.f14486t < uploadSessionContext.f14478l && a4 != null) {
            UploadVideoChunkReceiveResponse uploadVideoChunkReceiveResponse2 = null;
            long j4 = 0;
            Object obj2 = null;
            String str2 = "";
            UploadAssetSegment uploadAssetSegment = a4;
            while (true) {
                try {
                    str2 = uploadSessionContext.m22074a(uploadSessionContext.f14486t);
                    uploadSessionContext.f14474h.m22163a(uploadSessionContext.f14470d, uploadSessionContext.f14486t, uploadSessionContext.f14487u, uploadSessionContext.f14478l, uploadOperation.m21535d(), str2);
                    UploadVideoChunkReceiveResponse uploadVideoChunkReceiveResponse3 = (UploadVideoChunkReceiveResponse) this.f14494a.a(this.f14495b, new UploadVideoChunkReceiveParams(uploadSessionContext.f14468b.longValue(), uploadSessionContext.f14486t, uploadSessionContext.f14487u, uploadOperation.m21497B(), uploadOperation.m21509N(), uploadAssetSegment.f14440a, str, videoUploadStateParams.f14509a, false, 0, 0, uploadAssetSegment, null), uploadSessionContext.f14469c);
                    try {
                        videoUploadStateParams.m22105a(j4, uploadSessionContext.f14487u, this.f14496c.now(), this.f14496c.now());
                        VideoUploaderSlowNetworkHandler.m22167a(uploadOperation, this.f14497d, uploadSessionContext.f14478l, videoUploadStateParams.f14509a);
                        mediaUploadCancelHandler.m22001a("after chunk video");
                        obj = 1;
                    } catch (Exception e2) {
                        e = e2;
                        obj = obj2;
                        uploadVideoChunkReceiveResponse = uploadVideoChunkReceiveResponse3;
                        videoUploadStateParams.m22104a(j4);
                        a = videoUploadStateParams.m22103a(uploadSessionContext, str2);
                        uploadSessionContext.f14488v = e;
                        a2 = this.f14498e.m22146a(e, uploadSessionContext.f14489w, j4, a);
                        if (a2 != null) {
                            uploadSessionContext.f14486t = (long) ((Integer) a2.first).intValue();
                            uploadSessionContext.f14487u = (long) ((Integer) a2.second).intValue();
                            if (uploadSessionContext.f14486t != uploadSessionContext.f14478l) {
                                uploadVideoChunkReceiveResponse = new UploadVideoChunkReceiveResponse((long) ((Integer) a2.first).intValue(), (long) ((Integer) a2.second).intValue());
                                uploadSessionContext.f14474h.m22160a(str2);
                                i = 1;
                                a4 = uploadAssetSegment;
                                uploadVideoChunkReceiveResponse2 = uploadVideoChunkReceiveResponse;
                            } else if (uploadSessionContext.f14487u == 0) {
                                obj2 = obj;
                                a4 = m22079a(uploadSessionContext, segmentedUploadItem);
                                uploadVideoChunkReceiveResponse2 = uploadVideoChunkReceiveResponse;
                            }
                            if (obj2 != null) {
                                j4++;
                                if (j4 <= ((long) immediateRetryPolicy.mo1151b())) {
                                    break;
                                }
                                uploadAssetSegment = a4;
                            } else {
                                break;
                            }
                            mediaUploadCancelHandler.m22001a("after chunk video retries");
                            if (obj2 != null) {
                            }
                            if (uploadVideoChunkReceiveResponse2 == null) {
                                immediateRetryPolicy.mo1146a();
                                a3 = videoUploadStateParams.m22103a(uploadSessionContext, str2);
                                uploadSessionContext.f14486t = uploadVideoChunkReceiveResponse2.m21861a();
                                uploadSessionContext.f14487u = uploadVideoChunkReceiveResponse2.m21862b() - uploadVideoChunkReceiveResponse2.m21861a();
                                if (uploadSessionContext.f14487u == 0) {
                                    a4 = m22079a(uploadSessionContext, segmentedUploadItem);
                                }
                                a3.f14305f = uploadSessionContext.f14486t;
                                a3.f14306g = uploadSessionContext.f14487u;
                                defaultPhotoFlowLogger.m19885a(uploadBaseParams, uploadSessionContext.f14470d, uploadSessionContext.f14486t, uploadSessionContext.f14487u, uploadSessionContext.f14487u, uploadOperation.m21535d(), a3);
                                if (uploadSessionContext.f14486t == j3) {
                                    j3 = uploadSessionContext.f14486t;
                                    uploadRecord = new UploadRecord(uploadSessionContext.f14486t, uploadSessionContext.f14486t + uploadSessionContext.f14487u, false);
                                    uploadSessionContext.f14473g.put(uploadSessionContext.f14470d, uploadRecord);
                                    uploadCrashMonitor.a(uploadSessionContext.f14470d, uploadRecord);
                                    j4 = 0;
                                    j = j3;
                                } else {
                                    j4 = 1 + j2;
                                    if (j4 > 2) {
                                        j = j3;
                                    } else {
                                        throw new InterpretedException("Transfer chunk failure", true);
                                    }
                                }
                                j2 = j4;
                                j3 = j;
                            } else {
                                throw new NullPointerException();
                            }
                        }
                        obj2 = obj;
                        a4 = uploadAssetSegment;
                        uploadVideoChunkReceiveResponse2 = uploadVideoChunkReceiveResponse;
                        if (obj2 != null) {
                            break;
                        }
                        j4++;
                        if (j4 <= ((long) immediateRetryPolicy.mo1151b())) {
                            break;
                        }
                        uploadAssetSegment = a4;
                        mediaUploadCancelHandler.m22001a("after chunk video retries");
                        if (obj2 != null) {
                        }
                        if (uploadVideoChunkReceiveResponse2 == null) {
                            throw new NullPointerException();
                        }
                        immediateRetryPolicy.mo1146a();
                        a3 = videoUploadStateParams.m22103a(uploadSessionContext, str2);
                        uploadSessionContext.f14486t = uploadVideoChunkReceiveResponse2.m21861a();
                        uploadSessionContext.f14487u = uploadVideoChunkReceiveResponse2.m21862b() - uploadVideoChunkReceiveResponse2.m21861a();
                        if (uploadSessionContext.f14487u == 0) {
                            a4 = m22079a(uploadSessionContext, segmentedUploadItem);
                        }
                        a3.f14305f = uploadSessionContext.f14486t;
                        a3.f14306g = uploadSessionContext.f14487u;
                        defaultPhotoFlowLogger.m19885a(uploadBaseParams, uploadSessionContext.f14470d, uploadSessionContext.f14486t, uploadSessionContext.f14487u, uploadSessionContext.f14487u, uploadOperation.m21535d(), a3);
                        if (uploadSessionContext.f14486t == j3) {
                            j4 = 1 + j2;
                            if (j4 > 2) {
                                throw new InterpretedException("Transfer chunk failure", true);
                            }
                            j = j3;
                        } else {
                            j3 = uploadSessionContext.f14486t;
                            uploadRecord = new UploadRecord(uploadSessionContext.f14486t, uploadSessionContext.f14486t + uploadSessionContext.f14487u, false);
                            uploadSessionContext.f14473g.put(uploadSessionContext.f14470d, uploadRecord);
                            uploadCrashMonitor.a(uploadSessionContext.f14470d, uploadRecord);
                            j4 = 0;
                            j = j3;
                        }
                        j2 = j4;
                        j3 = j;
                    }
                    try {
                        uploadSessionContext.f14474h.m22160a(str2);
                        obj2 = 1;
                        uploadVideoChunkReceiveResponse2 = uploadVideoChunkReceiveResponse3;
                        a4 = uploadAssetSegment;
                    } catch (Exception e3) {
                        e = e3;
                        uploadVideoChunkReceiveResponse = uploadVideoChunkReceiveResponse3;
                        videoUploadStateParams.m22104a(j4);
                        a = videoUploadStateParams.m22103a(uploadSessionContext, str2);
                        uploadSessionContext.f14488v = e;
                        a2 = this.f14498e.m22146a(e, uploadSessionContext.f14489w, j4, a);
                        if (a2 != null) {
                            uploadSessionContext.f14486t = (long) ((Integer) a2.first).intValue();
                            uploadSessionContext.f14487u = (long) ((Integer) a2.second).intValue();
                            if (uploadSessionContext.f14486t != uploadSessionContext.f14478l) {
                                uploadVideoChunkReceiveResponse = new UploadVideoChunkReceiveResponse((long) ((Integer) a2.first).intValue(), (long) ((Integer) a2.second).intValue());
                                uploadSessionContext.f14474h.m22160a(str2);
                                i = 1;
                                a4 = uploadAssetSegment;
                                uploadVideoChunkReceiveResponse2 = uploadVideoChunkReceiveResponse;
                            } else if (uploadSessionContext.f14487u == 0) {
                                obj2 = obj;
                                a4 = m22079a(uploadSessionContext, segmentedUploadItem);
                                uploadVideoChunkReceiveResponse2 = uploadVideoChunkReceiveResponse;
                            }
                            if (obj2 != null) {
                                j4++;
                                if (j4 <= ((long) immediateRetryPolicy.mo1151b())) {
                                    break;
                                }
                                uploadAssetSegment = a4;
                            } else {
                                break;
                            }
                            mediaUploadCancelHandler.m22001a("after chunk video retries");
                            if (obj2 != null) {
                            }
                            if (uploadVideoChunkReceiveResponse2 == null) {
                                immediateRetryPolicy.mo1146a();
                                a3 = videoUploadStateParams.m22103a(uploadSessionContext, str2);
                                uploadSessionContext.f14486t = uploadVideoChunkReceiveResponse2.m21861a();
                                uploadSessionContext.f14487u = uploadVideoChunkReceiveResponse2.m21862b() - uploadVideoChunkReceiveResponse2.m21861a();
                                if (uploadSessionContext.f14487u == 0) {
                                    a4 = m22079a(uploadSessionContext, segmentedUploadItem);
                                }
                                a3.f14305f = uploadSessionContext.f14486t;
                                a3.f14306g = uploadSessionContext.f14487u;
                                defaultPhotoFlowLogger.m19885a(uploadBaseParams, uploadSessionContext.f14470d, uploadSessionContext.f14486t, uploadSessionContext.f14487u, uploadSessionContext.f14487u, uploadOperation.m21535d(), a3);
                                if (uploadSessionContext.f14486t == j3) {
                                    j3 = uploadSessionContext.f14486t;
                                    uploadRecord = new UploadRecord(uploadSessionContext.f14486t, uploadSessionContext.f14486t + uploadSessionContext.f14487u, false);
                                    uploadSessionContext.f14473g.put(uploadSessionContext.f14470d, uploadRecord);
                                    uploadCrashMonitor.a(uploadSessionContext.f14470d, uploadRecord);
                                    j4 = 0;
                                    j = j3;
                                } else {
                                    j4 = 1 + j2;
                                    if (j4 > 2) {
                                        j = j3;
                                    } else {
                                        throw new InterpretedException("Transfer chunk failure", true);
                                    }
                                }
                                j2 = j4;
                                j3 = j;
                            } else {
                                throw new NullPointerException();
                            }
                        }
                        obj2 = obj;
                        a4 = uploadAssetSegment;
                        uploadVideoChunkReceiveResponse2 = uploadVideoChunkReceiveResponse;
                        if (obj2 != null) {
                            break;
                        }
                        j4++;
                        if (j4 <= ((long) immediateRetryPolicy.mo1151b())) {
                            break;
                        }
                        uploadAssetSegment = a4;
                        mediaUploadCancelHandler.m22001a("after chunk video retries");
                        if (obj2 != null) {
                        }
                        if (uploadVideoChunkReceiveResponse2 == null) {
                            throw new NullPointerException();
                        }
                        immediateRetryPolicy.mo1146a();
                        a3 = videoUploadStateParams.m22103a(uploadSessionContext, str2);
                        uploadSessionContext.f14486t = uploadVideoChunkReceiveResponse2.m21861a();
                        uploadSessionContext.f14487u = uploadVideoChunkReceiveResponse2.m21862b() - uploadVideoChunkReceiveResponse2.m21861a();
                        if (uploadSessionContext.f14487u == 0) {
                            a4 = m22079a(uploadSessionContext, segmentedUploadItem);
                        }
                        a3.f14305f = uploadSessionContext.f14486t;
                        a3.f14306g = uploadSessionContext.f14487u;
                        defaultPhotoFlowLogger.m19885a(uploadBaseParams, uploadSessionContext.f14470d, uploadSessionContext.f14486t, uploadSessionContext.f14487u, uploadSessionContext.f14487u, uploadOperation.m21535d(), a3);
                        if (uploadSessionContext.f14486t == j3) {
                            j4 = 1 + j2;
                            if (j4 > 2) {
                                throw new InterpretedException("Transfer chunk failure", true);
                            }
                            j = j3;
                        } else {
                            j3 = uploadSessionContext.f14486t;
                            uploadRecord = new UploadRecord(uploadSessionContext.f14486t, uploadSessionContext.f14486t + uploadSessionContext.f14487u, false);
                            uploadSessionContext.f14473g.put(uploadSessionContext.f14470d, uploadRecord);
                            uploadCrashMonitor.a(uploadSessionContext.f14470d, uploadRecord);
                            j4 = 0;
                            j = j3;
                        }
                        j2 = j4;
                        j3 = j;
                    }
                } catch (Exception e4) {
                    e = e4;
                    uploadVideoChunkReceiveResponse = uploadVideoChunkReceiveResponse2;
                    obj = obj2;
                    videoUploadStateParams.m22104a(j4);
                    a = videoUploadStateParams.m22103a(uploadSessionContext, str2);
                    uploadSessionContext.f14488v = e;
                    a2 = this.f14498e.m22146a(e, uploadSessionContext.f14489w, j4, a);
                    if (a2 != null) {
                        uploadSessionContext.f14486t = (long) ((Integer) a2.first).intValue();
                        uploadSessionContext.f14487u = (long) ((Integer) a2.second).intValue();
                        if (uploadSessionContext.f14486t != uploadSessionContext.f14478l) {
                            uploadVideoChunkReceiveResponse = new UploadVideoChunkReceiveResponse((long) ((Integer) a2.first).intValue(), (long) ((Integer) a2.second).intValue());
                            uploadSessionContext.f14474h.m22160a(str2);
                            i = 1;
                            a4 = uploadAssetSegment;
                            uploadVideoChunkReceiveResponse2 = uploadVideoChunkReceiveResponse;
                        } else if (uploadSessionContext.f14487u == 0) {
                            obj2 = obj;
                            a4 = m22079a(uploadSessionContext, segmentedUploadItem);
                            uploadVideoChunkReceiveResponse2 = uploadVideoChunkReceiveResponse;
                        }
                        if (obj2 != null) {
                            j4++;
                            if (j4 <= ((long) immediateRetryPolicy.mo1151b())) {
                                break;
                            }
                            uploadAssetSegment = a4;
                        } else {
                            break;
                        }
                        mediaUploadCancelHandler.m22001a("after chunk video retries");
                        if (obj2 != null) {
                        }
                        if (uploadVideoChunkReceiveResponse2 == null) {
                            immediateRetryPolicy.mo1146a();
                            a3 = videoUploadStateParams.m22103a(uploadSessionContext, str2);
                            uploadSessionContext.f14486t = uploadVideoChunkReceiveResponse2.m21861a();
                            uploadSessionContext.f14487u = uploadVideoChunkReceiveResponse2.m21862b() - uploadVideoChunkReceiveResponse2.m21861a();
                            if (uploadSessionContext.f14487u == 0) {
                                a4 = m22079a(uploadSessionContext, segmentedUploadItem);
                            }
                            a3.f14305f = uploadSessionContext.f14486t;
                            a3.f14306g = uploadSessionContext.f14487u;
                            defaultPhotoFlowLogger.m19885a(uploadBaseParams, uploadSessionContext.f14470d, uploadSessionContext.f14486t, uploadSessionContext.f14487u, uploadSessionContext.f14487u, uploadOperation.m21535d(), a3);
                            if (uploadSessionContext.f14486t == j3) {
                                j3 = uploadSessionContext.f14486t;
                                uploadRecord = new UploadRecord(uploadSessionContext.f14486t, uploadSessionContext.f14486t + uploadSessionContext.f14487u, false);
                                uploadSessionContext.f14473g.put(uploadSessionContext.f14470d, uploadRecord);
                                uploadCrashMonitor.a(uploadSessionContext.f14470d, uploadRecord);
                                j4 = 0;
                                j = j3;
                            } else {
                                j4 = 1 + j2;
                                if (j4 > 2) {
                                    j = j3;
                                } else {
                                    throw new InterpretedException("Transfer chunk failure", true);
                                }
                            }
                            j2 = j4;
                            j3 = j;
                        } else {
                            throw new NullPointerException();
                        }
                    }
                    obj2 = obj;
                    a4 = uploadAssetSegment;
                    uploadVideoChunkReceiveResponse2 = uploadVideoChunkReceiveResponse;
                    if (obj2 != null) {
                        break;
                    }
                    j4++;
                    if (j4 <= ((long) immediateRetryPolicy.mo1151b())) {
                        break;
                    }
                    uploadAssetSegment = a4;
                    mediaUploadCancelHandler.m22001a("after chunk video retries");
                    if (obj2 != null) {
                    }
                    if (uploadVideoChunkReceiveResponse2 == null) {
                        throw new NullPointerException();
                    }
                    immediateRetryPolicy.mo1146a();
                    a3 = videoUploadStateParams.m22103a(uploadSessionContext, str2);
                    uploadSessionContext.f14486t = uploadVideoChunkReceiveResponse2.m21861a();
                    uploadSessionContext.f14487u = uploadVideoChunkReceiveResponse2.m21862b() - uploadVideoChunkReceiveResponse2.m21861a();
                    if (uploadSessionContext.f14487u == 0) {
                        a4 = m22079a(uploadSessionContext, segmentedUploadItem);
                    }
                    a3.f14305f = uploadSessionContext.f14486t;
                    a3.f14306g = uploadSessionContext.f14487u;
                    defaultPhotoFlowLogger.m19885a(uploadBaseParams, uploadSessionContext.f14470d, uploadSessionContext.f14486t, uploadSessionContext.f14487u, uploadSessionContext.f14487u, uploadOperation.m21535d(), a3);
                    if (uploadSessionContext.f14486t == j3) {
                        j4 = 1 + j2;
                        if (j4 > 2) {
                            throw new InterpretedException("Transfer chunk failure", true);
                        }
                        j = j3;
                    } else {
                        j3 = uploadSessionContext.f14486t;
                        uploadRecord = new UploadRecord(uploadSessionContext.f14486t, uploadSessionContext.f14486t + uploadSessionContext.f14487u, false);
                        uploadSessionContext.f14473g.put(uploadSessionContext.f14470d, uploadRecord);
                        uploadCrashMonitor.a(uploadSessionContext.f14470d, uploadRecord);
                        j4 = 0;
                        j = j3;
                    }
                    j2 = j4;
                    j3 = j;
                }
                if (obj2 != null) {
                    break;
                }
                j4++;
                if (j4 <= ((long) immediateRetryPolicy.mo1151b())) {
                    break;
                }
                uploadAssetSegment = a4;
            }
            mediaUploadCancelHandler.m22001a("after chunk video retries");
            if (obj2 != null && uploadSessionContext.f14488v != null) {
                throw uploadSessionContext.f14488v;
            } else if (uploadVideoChunkReceiveResponse2 == null) {
                throw new NullPointerException();
            } else {
                immediateRetryPolicy.mo1146a();
                a3 = videoUploadStateParams.m22103a(uploadSessionContext, str2);
                uploadSessionContext.f14486t = uploadVideoChunkReceiveResponse2.m21861a();
                uploadSessionContext.f14487u = uploadVideoChunkReceiveResponse2.m21862b() - uploadVideoChunkReceiveResponse2.m21861a();
                if (uploadSessionContext.f14487u == 0) {
                    a4 = m22079a(uploadSessionContext, segmentedUploadItem);
                }
                a3.f14305f = uploadSessionContext.f14486t;
                a3.f14306g = uploadSessionContext.f14487u;
                defaultPhotoFlowLogger.m19885a(uploadBaseParams, uploadSessionContext.f14470d, uploadSessionContext.f14486t, uploadSessionContext.f14487u, uploadSessionContext.f14487u, uploadOperation.m21535d(), a3);
                if (uploadSessionContext.f14486t == j3) {
                    j4 = 1 + j2;
                    if (j4 > 2) {
                        throw new InterpretedException("Transfer chunk failure", true);
                    }
                    j = j3;
                } else {
                    j3 = uploadSessionContext.f14486t;
                    uploadRecord = new UploadRecord(uploadSessionContext.f14486t, uploadSessionContext.f14486t + uploadSessionContext.f14487u, false);
                    uploadSessionContext.f14473g.put(uploadSessionContext.f14470d, uploadRecord);
                    uploadCrashMonitor.a(uploadSessionContext.f14470d, uploadRecord);
                    j4 = 0;
                    j = j3;
                }
                j2 = j4;
                j3 = j;
            }
        }
    }

    private static UploadAssetSegment m22079a(UploadSessionContext uploadSessionContext, SegmentedUploadItem segmentedUploadItem) {
        long j = 5242880;
        UploadAssetSegment a = segmentedUploadItem.m22065a(uploadSessionContext.f14486t);
        if (a != null) {
            long j2 = a.f14445f - a.f14444e;
            if (j2 <= 5242880) {
                j = j2;
            }
            uploadSessionContext.f14487u = j;
        }
        return a;
    }
}
