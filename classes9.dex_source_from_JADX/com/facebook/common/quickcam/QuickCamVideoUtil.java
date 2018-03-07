package com.facebook.common.quickcam;

import android.graphics.RectF;
import android.net.Uri;
import com.facebook.common.tempfile.BackingFileResolver;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.facebook.ui.media.attachments.MediaResourceHelper;
import com.facebook.video.qtfaststart.QTFastStart;
import com.facebook.videocodec.base.VideoOperationProgressListener;
import com.facebook.videocodec.policy.AbstractVideoResizingPolicy;
import com.facebook.videocodec.policy.VideoMirroringMode;
import com.facebook.videocodec.policy.VideoResizingPolicy;
import com.facebook.videocodec.prober.VideoProbeResult;
import com.facebook.videocodec.prober.VideoProber;
import com.facebook.videocodec.resizer.VideoResizeResult;
import com.facebook.videocodec.resizer.VideoResizer;
import com.facebook.videocodec.resizer.VideoResizerParams;
import com.facebook.videocodec.resizer.VideoResizerParamsBuilder;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.IOException;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: promote_product_promotion_key */
public class QuickCamVideoUtil {
    public static final RectF f6108a = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    private final MediaResourceHelper f6109b;
    private final BackingFileResolver f6110c;
    public final TempFileManager f6111d;
    private final VideoResizer f6112e;
    private final QTFastStart f6113f;
    private final VideoProber f6114g;

    /* compiled from: promote_product_promotion_key */
    class C06361 implements VideoOperationProgressListener {
        final /* synthetic */ QuickCamVideoUtil f6107a;

        C06361(QuickCamVideoUtil quickCamVideoUtil) {
            this.f6107a = quickCamVideoUtil;
        }

        public final void m6454a(double d) {
        }

        public final void m6453a() {
        }
    }

    /* compiled from: promote_product_promotion_key */
    public enum OrientationTag {
        LANDSCAPE("landscape"),
        PORTRAIT("portrait"),
        UNDEFINED("unknown");
        
        private final String mTag;

        private OrientationTag(String str) {
            this.mTag = str;
        }

        public final String getTag() {
            return this.mTag;
        }
    }

    public static QuickCamVideoUtil m6455a(InjectorLike injectorLike) {
        return new QuickCamVideoUtil(MediaResourceHelper.a(injectorLike), BackingFileResolver.a(injectorLike), TempFileManager.a(injectorLike), VideoResizer.a(injectorLike), QTFastStart.m19994a(injectorLike), VideoProber.m19997b(injectorLike));
    }

    @Inject
    public QuickCamVideoUtil(MediaResourceHelper mediaResourceHelper, BackingFileResolver backingFileResolver, TempFileManager tempFileManager, VideoResizer videoResizer, QTFastStart qTFastStart, VideoProber videoProber) {
        this.f6109b = mediaResourceHelper;
        this.f6110c = backingFileResolver;
        this.f6111d = tempFileManager;
        this.f6112e = videoResizer;
        this.f6113f = qTFastStart;
        this.f6114g = videoProber;
    }

    public final File m6458a(@Nonnull Uri uri, Source source, RectF rectF, AbstractVideoResizingPolicy abstractVideoResizingPolicy, String str, OrientationTag orientationTag) {
        MediaResourceBuilder a = MediaResource.a();
        a.a = uri;
        a = a;
        a.b = Type.VIDEO;
        a = a;
        a.c = source;
        a = a;
        a.p = true;
        a = a;
        a.o = rectF;
        File file = ((VideoResizeResult) FutureDetour.a(m6456a(this.f6109b.b(a.a("device_orientation", orientationTag.getTag()).C()), abstractVideoResizingPolicy), -605634387)).a;
        File a2 = this.f6111d.a(str, ".mp4", Privacy.PREFER_SDCARD);
        QTFastStart.m19995a(file, a2);
        File file2 = a2;
        if (file2.length() == 0) {
            file2.delete();
            return file;
        }
        file.delete();
        return file2;
    }

    private ListenableFuture<VideoResizeResult> m6456a(MediaResource mediaResource, VideoResizingPolicy videoResizingPolicy) {
        File file;
        VideoMirroringMode videoMirroringMode;
        try {
            file = this.f6110c.a(mediaResource.c, Privacy.PREFER_SDCARD).a;
        } catch (IOException e) {
            e.printStackTrace();
            file = new File(mediaResource.c.getPath());
        } catch (Exception e2) {
            e2.printStackTrace();
            file = new File(mediaResource.c.getPath());
        }
        File a = this.f6111d.a("media_upload", m6457a(this.f6114g.m19998a(file)), Privacy.PREFER_SDCARD);
        VideoResizerParamsBuilder a2 = VideoResizerParams.newBuilder().a(file).b(a).a(videoResizingPolicy).a(mediaResource.q).a(mediaResource.s).b(mediaResource.t).a(new C06361(this));
        if (mediaResource.e == Source.QUICKCAM_FRONT) {
            videoMirroringMode = VideoMirroringMode.MIRROR_HORIZONTALLY;
        } else {
            videoMirroringMode = VideoMirroringMode.NONE;
        }
        return this.f6112e.a(a2.a(videoMirroringMode).o());
    }

    private static String m6457a(VideoProbeResult videoProbeResult) {
        if (!videoProbeResult.f20421a.isPresent()) {
            return ".mp4";
        }
        String str = (String) videoProbeResult.f20421a.get();
        if (str.equals("audio/3gpp") || str.equals("audio/amr-wb")) {
            return ".3gp";
        }
        return ".mp4";
    }
}
