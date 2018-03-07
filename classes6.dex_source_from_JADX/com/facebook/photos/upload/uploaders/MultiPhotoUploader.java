package com.facebook.photos.upload.uploaders;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Pair;
import com.facebook.bitmaps.Dimension;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.BatchMethodNotExecutedException;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.ExceptionInterpreter;
import com.facebook.photos.base.analytics.PhotoFlowLogger;
import com.facebook.photos.base.analytics.PhotoFlowLogger$ExceptionReporter;
import com.facebook.photos.base.analytics.upload.UploadBaseParams;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.photos.upload.event.MultiPhotoUploadProgressEvent;
import com.facebook.photos.upload.event.MultiPhotoUploadProgressEvent$ProgressType;
import com.facebook.photos.upload.manager.UploadCrashMonitor;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperation.Type;
import com.facebook.photos.upload.operation.UploadOperationHelper;
import com.facebook.photos.upload.operation.UploadRecord;
import com.facebook.photos.upload.operation.UploadRecords;
import com.facebook.photos.upload.protocol.MediaUploadResult;
import com.facebook.photos.upload.protocol.PhotoPublisher;
import com.facebook.photos.upload.protocol.PhotoPublisher.OrderPublishException;
import com.facebook.photos.upload.protocol.UploadPhotoParams;
import com.facebook.photos.upload.retry.ImmediateRetryPolicy;
import com.facebook.photos.upload.uploaders.DirectPhotoUploader.DirectUploadListener;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Absent;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Semaphore;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: friends_locations_feedstory_v2_tap_map */
public class MultiPhotoUploader implements MediaUploader {
    private static final Class<?> f14365a = MultiPhotoUploader.class;
    public final MediaUploadEventBus f14366b;
    private final DefaultAndroidThreadUtil f14367c;
    public final AbstractFbErrorReporter f14368d;
    private final UploadOperationHelper f14369e;
    public final Clock f14370f;
    private final PhotoPublisher f14371g;
    public final UploadCrashMonitor f14372h;
    private final Provider<ImmediateRetryPolicy> f14373i;
    private final MediaUploadCancelHandler f14374j;
    private final DirectPhotoUploader f14375k;
    private Semaphore f14376l;

    /* compiled from: friends_locations_feedstory_v2_tap_map */
    class BatchUploadException extends ReportedException {
        public BatchUploadException(ExceptionInterpreter exceptionInterpreter) {
            super(exceptionInterpreter);
        }
    }

    /* compiled from: friends_locations_feedstory_v2_tap_map */
    class UploadProgressNotifier {
        final /* synthetic */ MultiPhotoUploader f14360a;
        private final UploadOperation f14361b;
        private long f14362c;
        private long f14363d;
        private long f14364e;

        public UploadProgressNotifier(MultiPhotoUploader multiPhotoUploader, UploadOperation uploadOperation) {
            this.f14360a = multiPhotoUploader;
            this.f14361b = uploadOperation;
        }

        public final void m22013a(int i, int i2, float f) {
            long a = this.f14360a.f14370f.a();
            if (a - this.f14362c >= 200 || ((long) i) != this.f14364e) {
                int round = Math.round(((((float) (i - 1)) + Math.min(1.0f, f)) * 100.0f) / ((float) i2));
                if (((long) round) != this.f14363d || ((long) i) != this.f14364e) {
                    try {
                        this.f14360a.f14366b.a(new MultiPhotoUploadProgressEvent(this.f14361b, i, i2, MultiPhotoUploadProgressEvent$ProgressType.UPLOADING, round));
                    } catch (Throwable th) {
                        this.f14360a.f14368d.a("Upload progress notification", th);
                    }
                    this.f14362c = a;
                    this.f14363d = (long) round;
                    this.f14364e = (long) i;
                }
            }
        }
    }

    public static MultiPhotoUploader m22023b(InjectorLike injectorLike) {
        return new MultiPhotoUploader(DefaultAndroidThreadUtil.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), UploadOperationHelper.m21582b(injectorLike), MediaUploadEventBus.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), PhotoPublisher.m21716b(injectorLike), UploadCrashMonitor.a(injectorLike), IdBasedProvider.a(injectorLike, 9491), MediaUploadCancelHandler.m21997b(injectorLike), DirectPhotoUploader.m21990b(injectorLike));
    }

    @Inject
    public MultiPhotoUploader(AndroidThreadUtil androidThreadUtil, FbErrorReporter fbErrorReporter, UploadOperationHelper uploadOperationHelper, MediaUploadEventBus mediaUploadEventBus, Clock clock, PhotoPublisher photoPublisher, UploadCrashMonitor uploadCrashMonitor, Provider<ImmediateRetryPolicy> provider, MediaUploadCancelHandler mediaUploadCancelHandler, DirectPhotoUploader directPhotoUploader) {
        this.f14367c = androidThreadUtil;
        this.f14368d = fbErrorReporter;
        this.f14369e = uploadOperationHelper;
        this.f14366b = mediaUploadEventBus;
        this.f14370f = clock;
        this.f14371g = photoPublisher;
        this.f14372h = uploadCrashMonitor;
        this.f14373i = provider;
        this.f14374j = mediaUploadCancelHandler;
        this.f14375k = directPhotoUploader;
    }

    public final void mo1158a() {
        this.f14376l = new Semaphore(0);
        this.f14374j.m21999a();
    }

    public final boolean mo1159b() {
        if (this.f14376l != null) {
            this.f14376l.release();
        }
        return this.f14374j.m22005c();
    }

    public final OperationResult mo1157a(UploadOperation uploadOperation) {
        try {
            if (!uploadOperation.m21521Z()) {
                this.f14372h.a(uploadOperation);
            }
            OperationResult b = m22022b(uploadOperation);
            return b;
        } finally {
            if (!uploadOperation.m21521Z()) {
                this.f14372h.d(uploadOperation);
            }
            this.f14376l = null;
        }
    }

    private OperationResult m22022b(UploadOperation uploadOperation) {
        PhotoFlowLogger$ExceptionReporter a;
        this.f14367c.b();
        Preconditions.checkNotNull(uploadOperation);
        Preconditions.checkNotNull(uploadOperation.m21508M());
        UploadRecords u = uploadOperation.m21546u();
        Map c = Maps.c();
        List a2 = Lists.a();
        List<UploadPhotoParams> a3 = this.f14369e.m21586a(uploadOperation);
        Preconditions.checkNotNull(a3);
        DefaultPhotoFlowLogger a4 = this.f14369e.m21584a(uploadOperation, this.f14370f.a());
        UploadBaseParams j = a4.m19944j("2.0");
        final UploadProgressNotifier uploadProgressNotifier = new UploadProgressNotifier(this, uploadOperation);
        final List a5 = Lists.a();
        Collection a6 = Lists.a();
        for (UploadPhotoParams uploadPhotoParams : a3) {
            String N = uploadPhotoParams.m21805N();
            UploadRecord a7 = u != null ? u.m21599a(N) : null;
            if (a7 == null || m22020a(a7)) {
                a6.add(uploadPhotoParams);
            } else {
                c.put(N, a7);
                a5.add(uploadPhotoParams);
                if (a7.isRawUpload) {
                    uploadPhotoParams.m21813b(true);
                    uploadPhotoParams.m21809a(a7.fbid);
                    a2.add(uploadPhotoParams);
                }
                this.f14372h.a(N, a7);
            }
        }
        final Map map = c;
        DirectUploadListener c09271 = new DirectUploadListener(this) {
            final /* synthetic */ MultiPhotoUploader f14358d;

            public final void mo1155a(int i, int i2, float f) {
                uploadProgressNotifier.m22013a(a5.size() + i, a5.size() + i2, f);
            }

            public final void mo1156a(UploadPhotoParams uploadPhotoParams, UploadRecord uploadRecord) {
                this.f14358d.f14372h.a(uploadPhotoParams.m21805N(), uploadRecord);
                map.put(uploadPhotoParams.m21805N(), uploadRecord);
            }
        };
        ImmediateRetryPolicy immediateRetryPolicy = (ImmediateRetryPolicy) this.f14373i.get();
        immediateRetryPolicy.mo1150a(uploadOperation.m21541i());
        immediateRetryPolicy.mo1149a(this.f14376l);
        try {
            m22024c(uploadOperation);
            this.f14375k.m21994a(a6, c09271, this.f14374j, a4, j, uploadOperation, immediateRetryPolicy);
            this.f14374j.m22004b("before publish");
            try {
                UploadPhotoParams uploadPhotoParams2 = (UploadPhotoParams) a3.get(0);
                uploadPhotoParams2.m21809a(((UploadRecord) c.get(((UploadPhotoParams) a3.get(0)).m21805N())).fbid);
                MediaUploadResult a8 = m22016a(uploadOperation, a4, immediateRetryPolicy, uploadPhotoParams2, m22018a((List) a3, c), (List) a3, a2);
                a4.m19916b(j, uploadOperation);
                Bundle b = m22021b(a3, c);
                new Bundle(1).putParcelable("graphql_story", (Parcelable) a8.f13990b.orNull());
                return OperationResult.a(a8.f13989a, new Pair[]{Pair.create("fbids", b), Pair.create("graphql_story", new Bundle(1))});
            } catch (CancellationException e) {
                a4.m19875a(j, uploadOperation, c.size(), uploadOperation.m21545t());
                throw e;
            } catch (Exception e2) {
                a = m22014a(e2);
                a4.m19874a(j, uploadOperation, c.size(), 0, false, a);
                throw new PartialUploadException(a, c);
            }
        } catch (CancellationException e3) {
            a4.m19875a(j, uploadOperation, c.size(), uploadOperation.m21545t());
            throw e3;
        } catch (Exception e22) {
            if (e22 instanceof ReportedException) {
                a = (ReportedException) e22;
            } else {
                a = new BatchUploadException(m22014a(e22));
            }
            a4.m19874a(j, uploadOperation, c.size(), a3.size() - c.size(), true, a);
            m22019a(c, u);
            throw new PartialUploadException(a.m21708h(), c);
        }
    }

    @VisibleForTesting
    private MediaUploadResult m22016a(UploadOperation uploadOperation, PhotoFlowLogger photoFlowLogger, ImmediateRetryPolicy immediateRetryPolicy, UploadPhotoParams uploadPhotoParams, ImmutableList<Long> immutableList, List<UploadPhotoParams> list, List<UploadPhotoParams> list2) {
        ReportedException reportedException;
        String d;
        Object obj;
        CharSequence a;
        Object obj2;
        int i = 0;
        String str = null;
        Object obj3 = null;
        String str2 = null;
        while (obj3 == null) {
            try {
                return m22015a(uploadOperation, (DefaultPhotoFlowLogger) photoFlowLogger, uploadPhotoParams, (ImmutableList) immutableList, (List) list, (List) list2, i);
            } catch (ReportedException e) {
                reportedException = e;
                if (reportedException.m21708h().m19959a() instanceof BatchMethodNotExecutedException) {
                    d = reportedException.m21708h().mo1090d();
                    obj = !StringUtil.a(d, str2) ? 1 : null;
                } else {
                    obj = null;
                    d = str2;
                }
                if (obj == null) {
                    immediateRetryPolicy.mo1147a(reportedException.m21708h());
                }
                if (reportedException.m21708h().m19959a() instanceof OrderPublishException) {
                    a = ((OrderPublishException) reportedException.m21708h().m19959a()).m21709a();
                    if (StringUtil.a(a)) {
                        obj2 = obj3;
                    } else {
                        if (obj3 == null) {
                            i = 0;
                        }
                        obj2 = 1;
                    }
                } else {
                    Object obj4 = str;
                    obj2 = obj3;
                }
                if (!this.f14374j.m22007e()) {
                    if (obj == null) {
                        i++;
                        if (i > immediateRetryPolicy.mo1151b()) {
                        }
                    }
                    CharSequence charSequence = a;
                    obj3 = obj2;
                    str2 = d;
                }
                this.f14374j.m22001a("Publish cancelled at attempt #" + (i + 1));
                throw reportedException;
            }
        }
        return m22017a(uploadOperation, photoFlowLogger, immutableList, str, i);
    }

    private MediaUploadResult m22015a(UploadOperation uploadOperation, PhotoFlowLogger photoFlowLogger, UploadPhotoParams uploadPhotoParams, ImmutableList<Long> immutableList, List<UploadPhotoParams> list, List<UploadPhotoParams> list2, int i) {
        switch (uploadOperation.m21505J()) {
            case SINGLE_PHOTO:
                return this.f14371g.m21717a(uploadOperation, (DefaultPhotoFlowLogger) photoFlowLogger, uploadPhotoParams, i);
            case STATUS:
                return this.f14371g.m21718a(uploadOperation, (DefaultPhotoFlowLogger) photoFlowLogger, (ImmutableList) immutableList, (List) list, (List) list2, i);
            case TARGET:
            case EDIT_POST:
                return this.f14371g.m21719a(uploadOperation, photoFlowLogger, immutableList, list, list2, Long.toString(uploadOperation.m21497B()), uploadOperation.m21513R(), i, uploadOperation.m21505J());
            case PHOTO_REVIEW:
                return this.f14371g.m21721a(uploadOperation, (DefaultPhotoFlowLogger) photoFlowLogger, (List) immutableList, (List) list, (List) list2, i);
            case PROFILE_PIC:
                return this.f14371g.m21725b(uploadOperation, (DefaultPhotoFlowLogger) photoFlowLogger, uploadPhotoParams, i);
            case COVER_PHOTO:
                return this.f14371g.m21728c(uploadOperation, photoFlowLogger, uploadPhotoParams, i);
            case LIFE_EVENT:
                return this.f14371g.m21720a(uploadOperation, (DefaultPhotoFlowLogger) photoFlowLogger, (List) immutableList, (List) list2, i);
            case PLACE_PHOTO:
                return this.f14371g.m21727b(uploadOperation, (List) immutableList, (DefaultPhotoFlowLogger) photoFlowLogger, i);
            case MENU_PHOTO:
                return this.f14371g.m21724a(uploadOperation, (List) immutableList, (DefaultPhotoFlowLogger) photoFlowLogger, i);
            case PRODUCT_IMAGE:
                return this.f14371g.m21726b(uploadOperation, immutableList);
            case MULTIMEDIA:
                return new MediaUploadResult(String.valueOf(uploadPhotoParams.m21831v()), Absent.withType());
            case SLIDESHOW:
                return this.f14371g.m21723a(uploadOperation, (List) immutableList);
            default:
                throw new RuntimeException("Unsupported publish method " + uploadOperation.m21505J());
        }
    }

    private MediaUploadResult m22017a(UploadOperation uploadOperation, PhotoFlowLogger photoFlowLogger, ImmutableList<Long> immutableList, String str, int i) {
        switch (uploadOperation.f13792o) {
            case STATUS:
                return this.f14371g.m21722a(uploadOperation, photoFlowLogger, true, true, str, immutableList, i);
            case TARGET:
                return this.f14371g.m21722a(uploadOperation, photoFlowLogger, false, uploadOperation.f13795r != Type.ALBUM, str, immutableList, i);
            default:
                throw new RuntimeException("Unsupported reorder method " + uploadOperation.f13792o);
        }
    }

    @VisibleForTesting
    private boolean m22020a(UploadRecord uploadRecord) {
        return this.f14370f.a() - uploadRecord.uploadTime > 72000000;
    }

    @VisibleForTesting
    private void m22019a(Map<String, UploadRecord> map, UploadRecords uploadRecords) {
        if (uploadRecords != null) {
            Iterator it = uploadRecords.m21600a().entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                String str = (String) entry.getKey();
                if (!(map.containsKey(str) || m22020a((UploadRecord) entry.getValue()))) {
                    map.put(str, entry.getValue());
                }
            }
        }
    }

    private static ImmutableList<Long> m22018a(List<UploadPhotoParams> list, Map<String, UploadRecord> map) {
        Builder builder = ImmutableList.builder();
        for (UploadPhotoParams N : list) {
            builder.c(Long.valueOf(((UploadRecord) map.get(N.m21805N())).fbid));
        }
        return builder.b();
    }

    private static Bundle m22021b(List<UploadPhotoParams> list, Map<String, UploadRecord> map) {
        Bundle bundle = new Bundle();
        for (UploadPhotoParams uploadPhotoParams : list) {
            bundle.putLong(uploadPhotoParams.m21815d(), ((UploadRecord) map.get(uploadPhotoParams.m21805N())).fbid);
        }
        return bundle;
    }

    private ExceptionInterpreter m22014a(Exception exception) {
        if (exception instanceof RuntimeException) {
            this.f14368d.a(f14365a.getSimpleName(), "Wrapping " + exception.getClass().getSimpleName(), exception);
        }
        return ReportedException.m21701a(exception);
    }

    private void m22024c(UploadOperation uploadOperation) {
        String str = uploadOperation.f13793p;
        Dimension c = UploadOperationHelper.m21583c(uploadOperation);
        ImmutableList immutableList = uploadOperation.f13778a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            MediaItem mediaItem = (MediaItem) immutableList.get(i);
            if (!mediaItem.p()) {
                String e = mediaItem.e();
                if ((e == null || !new File(e).isFile()) && !this.f14375k.m21995a(str, e, c)) {
                    throw new MissingMediaFileException(e);
                }
            }
        }
    }
}
