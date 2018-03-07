package com.facebook.photos.upload.uploaders;

import android.os.Bundle;
import android.util.Pair;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.composer.publish.protocol.PublishPostMethod;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.photos.upload.manager.UploadCrashMonitor;
import com.facebook.photos.upload.operation.MultimediaInfo;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperation.Builder;
import com.facebook.photos.upload.operation.UploadOperation.PublishMethod;
import com.facebook.photos.upload.operation.UploadOperation.Type;
import com.facebook.photos.upload.operation.UploadOperationBitrateDecider;
import com.facebook.photos.upload.operation.UploadOperationHelper;
import com.facebook.photos.upload.operation.UploadRecord;
import com.facebook.photos.upload.operation.UploadRecords;
import com.facebook.photos.upload.protocol.PhotoPublisher;
import com.facebook.photos.upload.retry.ImmediateRetryPolicy;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Semaphore;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: friends_locations_feedstory_tap_profile_pic */
public class MultimediaUploader implements MediaUploader {
    private static final String f14377f = MultimediaUploader.class.getName();
    private final MultiPhotoUploader f14378a;
    private final VideoUploader f14379b;
    private final PublishPostMethod f14380c;
    private final AbstractSingleMethodRunner f14381d;
    private final UploadCrashMonitor f14382e;
    private final Provider<ImmediateRetryPolicy> f14383g;
    private final MediaUploadCancelHandler f14384h;
    private final Clock f14385i;
    private final AbstractFbErrorReporter f14386j;
    private final UploadOperationHelper f14387k;
    private final UploadOperationBitrateDecider f14388l;
    private final PhotoPublisher f14389m;
    private final String f14390n;
    private Semaphore f14391o;

    public static MultimediaUploader m22030b(InjectorLike injectorLike) {
        return new MultimediaUploader(MultiPhotoUploader.m22023b(injectorLike), VideoUploader.m22129b(injectorLike), PublishPostMethod.m11654b(injectorLike), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), UploadCrashMonitor.a(injectorLike), IdBasedProvider.a(injectorLike, 9491), MediaUploadCancelHandler.m21997b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), UploadOperationHelper.m21582b(injectorLike), UploadOperationBitrateDecider.m21551b(injectorLike), PhotoPublisher.m21716b(injectorLike), String_LoggedInUserIdMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public MultimediaUploader(MultiPhotoUploader multiPhotoUploader, VideoUploader videoUploader, PublishPostMethod publishPostMethod, SingleMethodRunner singleMethodRunner, UploadCrashMonitor uploadCrashMonitor, Provider<ImmediateRetryPolicy> provider, MediaUploadCancelHandler mediaUploadCancelHandler, Clock clock, FbErrorReporter fbErrorReporter, UploadOperationHelper uploadOperationHelper, UploadOperationBitrateDecider uploadOperationBitrateDecider, PhotoPublisher photoPublisher, String str) {
        this.f14378a = multiPhotoUploader;
        this.f14379b = videoUploader;
        this.f14380c = publishPostMethod;
        this.f14381d = singleMethodRunner;
        this.f14382e = uploadCrashMonitor;
        this.f14383g = provider;
        this.f14384h = mediaUploadCancelHandler;
        this.f14385i = clock;
        this.f14386j = fbErrorReporter;
        this.f14387k = uploadOperationHelper;
        this.f14388l = uploadOperationBitrateDecider;
        this.f14389m = photoPublisher;
        this.f14390n = str;
    }

    public final void mo1158a() {
        this.f14378a.mo1158a();
        this.f14379b.mo1158a();
        this.f14391o = new Semaphore(0);
        this.f14384h.m21999a();
    }

    public final OperationResult mo1157a(UploadOperation uploadOperation) {
        try {
            this.f14382e.b(uploadOperation);
            OperationResult c = m22032c(uploadOperation);
            return c;
        } finally {
            this.f14382e.c(uploadOperation);
            this.f14391o = null;
        }
    }

    private static boolean m22031b(UploadOperation uploadOperation) {
        ImmutableList immutableList = uploadOperation.f13778a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (((MediaItem) immutableList.get(i)).m().equals(MediaType.PHOTO)) {
                return true;
            }
        }
        return false;
    }

    private OperationResult m22032c(UploadOperation uploadOperation) {
        OperationResult a;
        Bundle bundle;
        ImmediateRetryPolicy immediateRetryPolicy = (ImmediateRetryPolicy) this.f14383g.get();
        immediateRetryPolicy.mo1150a(uploadOperation.m21541i());
        immediateRetryPolicy.mo1149a(this.f14391o);
        UploadRecords u = uploadOperation.m21546u();
        UploadRecord a2 = u != null ? u.m21599a(uploadOperation.m21509N()) : null;
        Map c = Maps.c();
        if (!(a2 == null || a2.multimediaInfo == null)) {
            c.putAll(a2.multimediaInfo.videoPathToWaterfallId);
        }
        if (m22031b(uploadOperation)) {
            a = this.f14378a.mo1157a(uploadOperation);
            if (!a.b()) {
                return OperationResult.a(a.c());
            }
            Bundle bundle2 = (Bundle) a.b("fbids");
            if (uploadOperation.m21505J() == PublishMethod.SLIDESHOW) {
                return a;
            }
            bundle = bundle2;
        } else {
            bundle = new Bundle();
        }
        int size = uploadOperation.m21548x().size();
        for (int i = 0; i < size; i++) {
            MediaItem mediaItem = (MediaItem) uploadOperation.m21548x().get(i);
            if (mediaItem.m().equals(MediaType.VIDEO)) {
                UploadRecord a3 = u != null ? u.m21599a(mediaItem.e()) : null;
                if (a3 != null && a3.fbid > 0) {
                    bundle.putLong(mediaItem.e(), a3.fbid);
                } else if (Strings.isNullOrEmpty(mediaItem.q())) {
                    String str;
                    Builder builder = new Builder(uploadOperation);
                    if (c.containsKey(mediaItem.e())) {
                        str = (String) c.get(mediaItem.e());
                    } else {
                        str = SafeUUIDGenerator.a().toString();
                        c.put(mediaItem.e(), str);
                        this.f14382e.a(uploadOperation.m21509N(), new UploadRecord(new MultimediaInfo(ImmutableMap.copyOf(c))));
                    }
                    builder.m21464a(ImmutableList.of(mediaItem));
                    builder.m21465a(str);
                    builder.m21471b(uploadOperation.m21509N());
                    builder.m21452a(bundle.size());
                    builder.m21468b(size);
                    ImmutableList y = uploadOperation.m21549y();
                    if (!(y == null || y.isEmpty())) {
                        Bundle bundle3 = (Bundle) y.get(i);
                        builder.m21473c(this.f14388l.m21553a(bundle3));
                        builder.m21470b(ImmutableList.of(bundle3));
                    }
                    builder.m21461a(Type.VIDEO);
                    this.f14379b.mo1158a();
                    a = this.f14379b.mo1157a(builder.m21467a());
                    if (!a.b()) {
                        return OperationResult.a(a.c());
                    }
                    long parseLong = Long.parseLong(a.f());
                    this.f14382e.a(mediaItem.e(), new UploadRecord(parseLong, this.f14385i.a(), false));
                    bundle.putLong(mediaItem.e(), parseLong);
                } else {
                    continue;
                }
            }
        }
        ImmutableList y2 = uploadOperation.m21549y();
        ImmutableList.Builder builder2 = ImmutableList.builder();
        ImmutableList.Builder builder3 = ImmutableList.builder();
        ImmutableList.Builder builder4 = ImmutableList.builder();
        Iterable arrayList = new ArrayList();
        Iterable arrayList2 = new ArrayList();
        ImmutableList x = uploadOperation.m21548x();
        int size2 = x.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size2) {
            mediaItem = (MediaItem) x.get(i2);
            Object obj = null;
            if (y2 != null) {
                bundle3 = (Bundle) y2.get(i3);
                bundle3.setClassLoader(getClass().getClassLoader());
                obj = bundle3.getString("caption");
            }
            if (obj == null) {
                obj = "";
            }
            if (bundle.containsKey(mediaItem.e())) {
                builder2.c(String.valueOf(bundle.getLong(mediaItem.e())));
                arrayList.add(obj);
            } else if (Strings.isNullOrEmpty(mediaItem.q())) {
                this.f14386j.b(f14377f, "Couldn't find fbid for media");
            } else {
                builder4.c(mediaItem.q());
                arrayList2.add(obj);
            }
            i2++;
            i3++;
        }
        builder3.b(arrayList2).b(arrayList);
        this.f14384h.m22004b("before multimedia publish");
        return m22029a(uploadOperation, builder2.b(), builder3.b(), builder4.b(), bundle, immediateRetryPolicy, m22033d(uploadOperation));
    }

    private OperationResult m22029a(UploadOperation uploadOperation, ImmutableList<String> immutableList, ImmutableList<String> immutableList2, ImmutableList<String> immutableList3, Bundle bundle, ImmediateRetryPolicy immediateRetryPolicy, boolean z) {
        int i = 0;
        PublishPostParams.Builder b = this.f14387k.m21587b(uploadOperation);
        b.a(immutableList).c(immutableList2).b(immutableList3).b(uploadOperation.m21516U());
        PublishPostParams a = b.a();
        do {
            try {
                OperationResult a2 = m22028a(uploadOperation, a, bundle, z);
                immediateRetryPolicy.mo1146a();
                return a2;
            } catch (Exception e) {
                immediateRetryPolicy.mo1148a(e);
                if (this.f14384h.m22007e()) {
                    break;
                }
                i++;
                if (i > immediateRetryPolicy.mo1151b()) {
                }
                this.f14384h.m22001a("Publish cancelled at attempt #" + (i + 1));
                throw e;
            }
        } while (i > immediateRetryPolicy.mo1151b());
        this.f14384h.m22001a("Publish cancelled at attempt #" + (i + 1));
        throw e;
    }

    private OperationResult m22028a(UploadOperation uploadOperation, PublishPostParams publishPostParams, Bundle bundle, boolean z) {
        String str = (String) this.f14381d.a(this.f14380c, publishPostParams);
        Bundle bundle2 = new Bundle();
        for (String str2 : bundle.keySet()) {
            bundle2.putString(str2, String.valueOf(bundle.getLong(str2)));
        }
        if (z) {
            ImmutableList.Builder builder = ImmutableList.builder();
            ImmutableList immutableList = publishPostParams.mediaFbIds;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                builder.c(Long.valueOf(Long.parseLong((String) immutableList.get(i))));
            }
            UploadOperation uploadOperation2 = uploadOperation;
            this.f14389m.m21722a(uploadOperation2, this.f14387k.m21584a(uploadOperation, this.f14385i.a()), true, false, str, builder.b(), 0);
        }
        return OperationResult.a(str, new Pair[]{Pair.create("fbids", bundle2)});
    }

    public final boolean mo1159b() {
        if (this.f14391o != null) {
            this.f14391o.release();
        }
        return this.f14378a.mo1159b() && this.f14379b.mo1159b() && this.f14384h.m22005c();
    }

    @VisibleForTesting
    private boolean m22033d(UploadOperation uploadOperation) {
        if (uploadOperation.f13783f == Long.parseLong(this.f14390n) || uploadOperation.f13797t != -1 || uploadOperation.m21532c() <= 1) {
            return false;
        }
        return true;
    }
}
