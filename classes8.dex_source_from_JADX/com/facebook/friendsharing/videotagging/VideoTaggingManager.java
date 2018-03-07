package com.facebook.friendsharing.videotagging;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import com.facebook.facerec.manager.ImagePipelineFaceRecManager;
import com.facebook.inject.Assisted;
import com.facebook.ipc.media.data.MediaData;
import com.facebook.ipc.media.data.MediaData.Type;
import com.facebook.ipc.media.data.MimeType;
import com.facebook.video.scrubber.GLFrameRetriever;
import com.facebook.video.scrubber.GLFrameRetrieverProvider;
import com.facebook.videocodec.base.VideoMetadata;
import com.facebook.videocodec.base.VideoMetadataExtractor;
import com.facebook.videocodec.policy.VideoMirroringMode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.File;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: ⁠ */
public class VideoTaggingManager {
    private static final String f3a = VideoTaggingManager.class.getSimpleName();
    private final AnalyticsLogger f4b;
    private final Context f5c;
    private final ImagePipelineFaceRecManager f6d;
    private final GLFrameRetrieverProvider f7e;
    private final int f8f;
    private final MonotonicClock f9g;
    private final VideoMetadataExtractor f10h;

    @Inject
    public VideoTaggingManager(AnalyticsLogger analyticsLogger, Context context, ImagePipelineFaceRecManager imagePipelineFaceRecManager, GLFrameRetrieverProvider gLFrameRetrieverProvider, @Assisted int i, MonotonicClock monotonicClock, VideoMetadataExtractor videoMetadataExtractor) {
        this.f4b = analyticsLogger;
        this.f5c = context;
        this.f6d = imagePipelineFaceRecManager;
        this.f7e = gLFrameRetrieverProvider;
        this.f8f = i;
        this.f9g = monotonicClock;
        this.f10h = videoMetadataExtractor;
    }

    public final ImmutableList<MediaData> m11a(Uri uri, String str, float f, long j) {
        long now;
        boolean z;
        int i;
        long j2;
        GLFrameRetriever a = this.f7e.a(uri, null, null, VideoMirroringMode.NONE);
        long now2 = this.f9g.now();
        long j3 = 0;
        long j4 = 0;
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        boolean z2 = false;
        long j5 = -1;
        List arrayList = new ArrayList();
        int i5 = 0;
        while (((long) i5) < j) {
            int i6 = i4 + 1;
            now = this.f9g.now();
            CloseableReference a2 = m8a(a, i5, f);
            j3 += this.f9g.now() - now;
            now = this.f9g.now();
            List a3 = this.f6d.a((Bitmap) a2.a(), 0, false);
            j4 += this.f9g.now() - now;
            if (!(a2.a() == null || a3.isEmpty())) {
                String str2 = "facedetection_" + str + "_" + i5 + ".jpg";
                if (i2 == -1) {
                    i2 = i5;
                    int size = a3.size();
                    j5 = this.f9g.now() - now2;
                    i3 = size;
                }
                z2 = true;
                try {
                    OutputStream openFileOutput = this.f5c.openFileOutput(str2, 0);
                    ((Bitmap) a2.a()).compress(CompressFormat.JPEG, 85, openFileOutput);
                    openFileOutput.close();
                } catch (Throwable e) {
                    BLog.b(f3a, "Couldn't save bitmap to file", e);
                }
                String path = this.f5c.getFileStreamPath(str2).getPath();
                arrayList.add(m9a(str2, path, ((Bitmap) a2.a()).getWidth(), ((Bitmap) a2.a()).getHeight()));
            }
            boolean z3 = z2;
            a2.close();
            if (arrayList.size() == 3) {
                now = j5;
                z = z3;
                i4 = i6;
                i = i3;
                i3 = i2;
                j2 = j3;
                break;
            }
            i5 += this.f8f;
            z2 = z3;
            i4 = i6;
        }
        now = j5;
        z = z2;
        i = i3;
        j2 = j3;
        i3 = i2;
        a.a();
        m10a(i3, i, (double) i4, z, j2, j4, this.f9g.now() - now2, now, j, uri);
        return new Builder().b(arrayList).b();
    }

    private static MediaData m9a(String str, String str2, int i, int i2) {
        MediaData.Builder a = new MediaData.Builder().a(str).a(Type.Photo).a(Uri.fromFile(new File(str2))).a(MimeType.a);
        a.f = i;
        a = a;
        a.g = i2;
        return a.a();
    }

    private void m10a(int i, int i2, double d, boolean z, long j, long j2, long j3, long j4, long j5, Uri uri) {
        long j6 = -1;
        String str = null;
        try {
            VideoMetadata a = this.f10h.a(uri);
            j6 = a.f / 1024;
            str = a.b + "x" + a.c;
        } catch (Throwable e) {
            BLog.b(f3a, "Couldn't extract VideoMetadata", e);
        }
        double d2 = (d / ((double) j2)) * 1000.0d;
        double d3 = (d / ((double) j)) * 1000.0d;
        double d4 = (d / ((double) j3)) * 1000.0d;
        NumberFormat instance = NumberFormat.getInstance(Locale.UK);
        instance.setMaximumFractionDigits(2);
        this.f4b.a(new HoneyClientEvent("video_tagging").b("dfps", instance.format(d2)).b("efps", instance.format(d3)).b("sfps", instance.format(d4)).a("face_count", i2).a("face_found", z).a("face_frame_position_ms", i).a("ttf_ms", j4).a("video_file_size_kb", j6).a("video_length_ms", j5).b("video_resolution", str).g(f3a));
    }

    private static CloseableReference<Bitmap> m8a(GLFrameRetriever gLFrameRetriever, int i, float f) {
        try {
            CloseableReference<Bitmap> a = gLFrameRetriever.a(i, f);
            if (a == null || a.a() == null) {
                return null;
            }
            return a;
        } catch (Throwable e) {
            BLog.b(f3a, "Unable to extract frame", e);
            return null;
        }
    }
}
