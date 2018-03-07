package com.facebook.messaging.media.upload.segmented;

import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForNonUiThread;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.tempfile.BackingFileResolver;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.Assisted;
import com.facebook.media.transcode.SegmentedMediaTranscodeResult;
import com.facebook.media.transcode.SegmentedMediaTranscoder;
import com.facebook.media.transcode.SegmentedTranscodeItemInfo;
import com.facebook.media.transcode.video.VideoTranscodeParameters;
import com.facebook.messaging.media.upload.MediaUploadEvents;
import com.facebook.messaging.media.upload.segmented.PerformStreamUploadMethod.Params;
import com.facebook.messaging.media.upload.segmented.PerformStreamUploadMethod.SegmentType;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: last_selected_ride_type */
public class VideoSegmentTranscodeUploadOperation {
    public static final Class<?> f12111j = VideoSegmentTranscodeUploadOperation.class;
    public static final CallerContext f12112r = CallerContext.a(VideoSegmentTranscodeUploadHandler.class, "video_transcode_upload");
    @Inject
    ApiMethodRunnerImpl f12113a;
    @Inject
    BackingFileResolver f12114b;
    @Inject
    SegmentedMediaTranscoder f12115c;
    @ForNonUiThread
    @Inject
    ExecutorService f12116d;
    @Inject
    @LocalBroadcast
    BaseFbBroadcastManager f12117e;
    @Inject
    StartStreamUploadMethod f12118f;
    @Inject
    PerformStreamUploadMethod f12119g;
    @Inject
    EndStreamUploadMethod f12120h;
    @Inject
    CancelStreamUploadMethod f12121i;
    public MediaResource f12122k;
    private Long f12123l;
    public String f12124m;
    public String f12125n = "";
    public boolean f12126o;
    public boolean f12127p;
    private List<VideoSegmentTranscodeUploadItem> f12128q;

    private void m12630a(VideoSegmentTranscodeUploadItem videoSegmentTranscodeUploadItem, CountDownLatch countDownLatch) {
        if (videoSegmentTranscodeUploadItem.f12102c) {
            this.f12123l = Long.valueOf(this.f12123l.longValue() + videoSegmentTranscodeUploadItem.f12103d);
            countDownLatch.countDown();
            return;
        }
        SegmentType segmentType = SegmentType.UnKnown;
        if (videoSegmentTranscodeUploadItem.f12100a.a == SegmentedTranscodeItemInfo.SegmentType.Audio) {
            segmentType = SegmentType.Audio;
        } else if (videoSegmentTranscodeUploadItem.f12100a.a == SegmentedTranscodeItemInfo.SegmentType.Video) {
            segmentType = SegmentType.Video;
        }
        final String str = this.f12122k.o;
        final long longValue = this.f12123l.longValue();
        this.f12123l = Long.valueOf(this.f12123l.longValue() + videoSegmentTranscodeUploadItem.m12628d());
        final File a = this.f12114b.a(videoSegmentTranscodeUploadItem.f12101b.b.f());
        final VideoSegmentTranscodeUploadItem videoSegmentTranscodeUploadItem2 = videoSegmentTranscodeUploadItem;
        final CountDownLatch countDownLatch2 = countDownLatch;
        ExecutorDetour.a(this.f12116d, new Runnable(this) {
            final /* synthetic */ VideoSegmentTranscodeUploadOperation f12110g;

            public void run() {
                try {
                    this.f12110g.f12113a.a(this.f12110g.f12119g, new Params(this.f12110g.f12125n, segmentType, a, longValue, str), null, VideoSegmentTranscodeUploadOperation.f12112r);
                    videoSegmentTranscodeUploadItem2.m12625a(true);
                } catch (Throwable e) {
                    BLog.b(VideoSegmentTranscodeUploadOperation.f12111j, e, "Upload failed at transfer stage with sessionId %s and streamId %s", new Object[]{this.f12110g.f12124m, this.f12110g.f12125n});
                } finally {
                    countDownLatch2.countDown();
                }
            }
        }, -1392203332);
    }

    @Inject
    public VideoSegmentTranscodeUploadOperation(@Assisted MediaResource mediaResource) {
        this.f12122k = mediaResource;
        this.f12128q = new ArrayList();
    }

    @Nullable
    public final synchronized String m12633a() {
        String str;
        boolean z;
        if (this.f12122k != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        VideoItem a = VideoSegmentTranscodeUploadHelper.m12621a(this.f12122k);
        Preconditions.checkNotNull(a);
        if (this.f12128q.isEmpty()) {
            for (SegmentedTranscodeItemInfo videoSegmentTranscodeUploadItem : this.f12115c.a(a)) {
                this.f12128q.add(new VideoSegmentTranscodeUploadItem(videoSegmentTranscodeUploadItem));
            }
            this.f12125n = (String) this.f12113a.a(this.f12118f, new StartStreamUploadMethod.Params(this.f12122k, m12636c()), null, f12112r);
        }
        CountDownLatch countDownLatch = new CountDownLatch(this.f12128q.size());
        m12631k();
        int i = 0;
        while (i < this.f12128q.size()) {
            if (((VideoSegmentTranscodeUploadItem) this.f12128q.get(i)).m12626b() == null || this.f12114b.a(((VideoSegmentTranscodeUploadItem) this.f12128q.get(i)).m12626b().b().f()) == null) {
                SegmentedMediaTranscodeResult a2 = m12629a(a, ((VideoSegmentTranscodeUploadItem) this.f12128q.get(i)).m12622a());
                if (a2 == null || !a2.a()) {
                    BLog.b(f12111j, "Upload failed with at transcoding stage with sessionId %s and streamId %s", new Object[]{this.f12124m, this.f12125n});
                    throw new Throwable("Segment transcode failed at %d segment " + Integer.toString(i));
                }
                ((VideoSegmentTranscodeUploadItem) this.f12128q.get(i)).m12624a(a2);
                ((VideoSegmentTranscodeUploadItem) this.f12128q.get(i)).m12623a(Long.valueOf(this.f12114b.a(a2.b().f()).length()).longValue());
            }
            m12630a((VideoSegmentTranscodeUploadItem) this.f12128q.get(i), countDownLatch);
            this.f12117e.a(MediaUploadEvents.m12490b(this.f12122k, ((double) (i + 1)) / ((double) this.f12128q.size())));
            i++;
        }
        try {
            Object obj;
            countDownLatch.await(30, TimeUnit.MINUTES);
            for (VideoSegmentTranscodeUploadItem c : this.f12128q) {
                if (!c.m12627c()) {
                    obj = null;
                    break;
                }
            }
            int i2 = 1;
            if (obj == null) {
                BLog.b(f12111j, "Upload failed final waiting stage with sessionId %s and streamId %s", new Object[]{this.f12124m, this.f12125n});
                str = null;
            } else {
                this.f12117e.a(MediaUploadEvents.m12489b(this.f12122k));
                str = (String) this.f12113a.a(this.f12120h, new EndStreamUploadMethod.Params(this.f12124m, this.f12125n), null, f12112r);
                this.f12117e.a(MediaUploadEvents.m12491c(this.f12122k));
                this.f12117e.a(MediaUploadEvents.m12492d(this.f12122k));
                this.f12126o = true;
            }
        } catch (Throwable e) {
            BLog.b(f12111j, e, "Upload failed with at end stage with sessionId %s and streamId %s", new Object[]{this.f12124m, this.f12125n});
            str = null;
        }
        return str;
    }

    private SegmentedMediaTranscodeResult m12629a(VideoItem videoItem, SegmentedTranscodeItemInfo segmentedTranscodeItemInfo) {
        try {
            return (SegmentedMediaTranscodeResult) FutureDetour.a(this.f12115c.a(m12636c(), videoItem, segmentedTranscodeItemInfo, new VideoTranscodeParameters(), "video_transcode_upload"), 322146606);
        } catch (Throwable e) {
            BLog.b(f12111j, e, "Upload failed at transcoding stage with sessionId %s and streamId %s", new Object[]{this.f12124m, this.f12125n});
            throw e;
        }
    }

    final void m12634a(ApiMethodRunnerImpl apiMethodRunnerImpl, BackingFileResolver backingFileResolver, SegmentedMediaTranscoder segmentedMediaTranscoder, ExecutorService executorService, BaseFbBroadcastManager baseFbBroadcastManager, StartStreamUploadMethod startStreamUploadMethod, PerformStreamUploadMethod performStreamUploadMethod, EndStreamUploadMethod endStreamUploadMethod, CancelStreamUploadMethod cancelStreamUploadMethod) {
        this.f12113a = apiMethodRunnerImpl;
        this.f12114b = backingFileResolver;
        this.f12115c = segmentedMediaTranscoder;
        this.f12116d = executorService;
        this.f12117e = baseFbBroadcastManager;
        this.f12118f = startStreamUploadMethod;
        this.f12119g = performStreamUploadMethod;
        this.f12120h = endStreamUploadMethod;
        this.f12121i = cancelStreamUploadMethod;
    }

    private void m12631k() {
        this.f12123l = Long.valueOf(0);
        this.f12126o = false;
        this.f12127p = false;
    }

    private void m12632l() {
        Preconditions.checkNotNull(this.f12125n);
        if (!this.f12127p && !this.f12126o) {
            try {
                this.f12126o = false;
                this.f12113a.a(this.f12121i, new CancelStreamUploadMethod.Params(this.f12124m, this.f12125n), null, f12112r);
                this.f12127p = true;
            } catch (Throwable e) {
                BLog.b(f12111j, e, "Cancel upload failed with sessionId %s and streamId %s", new Object[]{this.f12124m, this.f12125n});
            }
        }
    }

    public final void m12635b() {
        m12632l();
    }

    protected void finalize() {
        try {
            m12635b();
        } finally {
            super.finalize();
        }
    }

    public final String m12636c() {
        if (StringUtil.a(this.f12124m)) {
            this.f12124m = SafeUUIDGenerator.a().toString();
        }
        return this.f12124m;
    }

    @Nullable
    public final ImmutableList<VideoSegmentTranscodeUploadItem> m12637e() {
        return ImmutableList.copyOf(this.f12128q);
    }
}
