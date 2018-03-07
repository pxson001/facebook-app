package com.facebook.timeline.stagingground;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.util.UriUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.Assisted;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.videoeditgallery.VideoEditGalleryLaunchConfiguration;
import com.facebook.ipc.videoeditgallery.VideoEditGalleryLaunchConfiguration.Builder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativeediting.model.VideoTrimParams;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.stagingground.StagingGroundController.C10701;
import com.facebook.timeline.tempprofilepic.ExpirationDialogController;
import com.facebook.ultralight.Inject;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.creativeediting.VideoEditGalleryFragmentManager;
import com.facebook.video.creativeediting.VideoEditGalleryFragmentManager.VideoEditGalleryCallback;
import com.facebook.video.creativeediting.analytics.VideoCreativeEditingLogger;
import com.facebook.video.creativeediting.analytics.VideoEditingGalleryEntryPoint;
import com.facebook.video.creativeediting.model.VideoCreativeEditingData;
import com.facebook.video.creativeediting.utilities.VideoMetadataExtractHelper;
import com.facebook.video.engine.VideoDataSource.VideoMirroringMode;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoPlayerManager;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.plugins.OverlayImagePlugin;
import com.facebook.video.player.plugins.TrimmedVideoLoopingPlugin;
import com.facebook.video.player.plugins.VideoPlugin;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: failed to decode  */
public class StagingGroundProfileVideoController extends StagingGroundProfileMediaController {
    public VideoEditGalleryLaunchConfiguration f14868a;
    public VideoCreativeEditingData f14869b;
    public RichVideoPlayer f14870c;
    public final SecureContextHelper f14871d;
    public final IFeedIntentBuilder f14872t;
    private final VideoPlayerManager f14873u;
    public final VideoCreativeEditingLogger f14874v;
    public VideoEditGalleryFragmentManager f14875w;

    /* compiled from: failed to decode  */
    class C10912 implements OnClickListener {
        final /* synthetic */ StagingGroundProfileVideoController f14867a;

        /* compiled from: failed to decode  */
        class C10901 implements VideoEditGalleryCallback {
            final /* synthetic */ C10912 f14866a;

            C10901(C10912 c10912) {
                this.f14866a = c10912;
            }

            public final void mo1169a(VideoCreativeEditingData videoCreativeEditingData, int i) {
                this.f14866a.f14867a.f14869b = videoCreativeEditingData;
                this.f14866a.f14867a.m18744c();
            }

            public final void mo1168a(int i) {
                this.f14866a.f14867a.m18744c();
            }
        }

        C10912(StagingGroundProfileVideoController stagingGroundProfileVideoController) {
            this.f14867a = stagingGroundProfileVideoController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -795853575);
            this.f14867a.f14870c.b(EventTriggerType.BY_PLAYER);
            this.f14867a.f14874v.m19550a(this.f14867a.f14821g.toString(), VideoEditingGalleryEntryPoint.PROFILE_VIDEO, this.f14867a.f14827m);
            VideoEditGalleryFragmentManager videoEditGalleryFragmentManager = this.f14867a.f14875w;
            Builder builder = new Builder(this.f14867a.f14868a);
            builder.f6191c = this.f14867a.f14869b;
            videoEditGalleryFragmentManager.m19478a(builder.m8068a(), this.f14867a.f14821g, new C10901(this), VideoEditingGalleryEntryPoint.PROFILE_VIDEO, null);
            Logger.a(2, EntryType.UI_INPUT_END, -890665773, a);
        }
    }

    @Inject
    public StagingGroundProfileVideoController(Context context, AbstractFbErrorReporter abstractFbErrorReporter, Executor executor, SecureContextHelper secureContextHelper, IFeedIntentBuilder iFeedIntentBuilder, VideoPlayerManager videoPlayerManager, VideoCreativeEditingLogger videoCreativeEditingLogger, @Assisted StagingGroundAnalyticsLogger stagingGroundAnalyticsLogger, QeAccessor qeAccessor) {
        super(context, abstractFbErrorReporter, executor, stagingGroundAnalyticsLogger, qeAccessor);
        this.f14871d = secureContextHelper;
        this.f14872t = iFeedIntentBuilder;
        this.f14873u = videoPlayerManager;
        this.f14874v = videoCreativeEditingLogger;
    }

    public final void mo1158a(FbFragmentActivity fbFragmentActivity, Bundle bundle, StagingGroundLaunchConfig stagingGroundLaunchConfig) {
        super.mo1158a(fbFragmentActivity, bundle, stagingGroundLaunchConfig);
        this.f14868a = (VideoEditGalleryLaunchConfiguration) fbFragmentActivity.getIntent().getExtras().getParcelable("extra_video_edit_gallery_launch_settings");
        if (stagingGroundLaunchConfig.f14786r && this.f14868a == null) {
            BLog.b(StagingGroundActivity.class, "mVideoEditGalleryLaunchConfiguration must be set");
            fbFragmentActivity.finish();
            return;
        }
        VideoCreativeEditingData videoCreativeEditingData;
        StagingGroundProfileVideoController stagingGroundProfileVideoController;
        if (bundle != null && bundle.getParcelable("videoCreativeEditingDataKey") != null) {
            videoCreativeEditingData = (VideoCreativeEditingData) bundle.getParcelable("videoCreativeEditingDataKey");
            stagingGroundProfileVideoController = this;
        } else if (stagingGroundLaunchConfig.f14783o != null) {
            videoCreativeEditingData = stagingGroundLaunchConfig.f14783o;
            stagingGroundProfileVideoController = this;
        } else {
            videoCreativeEditingData = new VideoCreativeEditingData.Builder().a();
            stagingGroundProfileVideoController = this;
        }
        stagingGroundProfileVideoController.f14869b = videoCreativeEditingData;
        this.f14875w = new VideoEditGalleryFragmentManager(fbFragmentActivity.kO_());
    }

    public final void mo1154a() {
    }

    public final void mo1159a(C10701 c10701) {
        c10701.m18653a();
    }

    public final void mo1157a(View view) {
        this.f14870c = (RichVideoPlayer) ((ViewStub) view.findViewById(2131567604)).inflate().findViewById(2131567605);
    }

    public final void mo1161b() {
        m18744c();
    }

    public final void m18744c() {
        VideoMirroringMode videoMirroringMode;
        this.f14870c.i();
        this.f14870c.a(new VideoPlugin(this.f14829o));
        this.f14870c.a(new TrimmedVideoLoopingPlugin(this.f14829o));
        this.f14870c.a(new OverlayImagePlugin(this.f14829o));
        this.f14870c.setPlayerOrigin(PlayerOrigin.PROFILE_VIDEO_PREVIEW);
        this.f14870c.setShouldCropToFit(true);
        this.f14873u.e();
        Uri uri = this.f14821g;
        VideoCreativeEditingData videoCreativeEditingData = this.f14869b;
        VideoDataSourceBuilder videoDataSourceBuilder = new VideoDataSourceBuilder();
        videoDataSourceBuilder.a = uri;
        videoDataSourceBuilder = videoDataSourceBuilder;
        videoDataSourceBuilder.f = StreamSourceType.FROM_LOCAL_STORAGE;
        VideoDataSourceBuilder videoDataSourceBuilder2 = videoDataSourceBuilder;
        if (videoCreativeEditingData == null || !videoCreativeEditingData.h()) {
            videoMirroringMode = VideoMirroringMode.NONE;
        } else {
            videoMirroringMode = VideoMirroringMode.MIRROR_HORIZONTALLY;
        }
        videoDataSourceBuilder2.h = videoMirroringMode;
        VideoPlayerParamsBuilder a = new VideoPlayerParamsBuilder().a(videoDataSourceBuilder2.i());
        a.g = true;
        a = a;
        a.b = "staging_ground_" + uri.toString().hashCode();
        VideoPlayerParams m = a.m();
        int i = 0;
        int i2 = -1;
        if (videoCreativeEditingData != null) {
            VideoTrimParams a2 = videoCreativeEditingData.a();
            if (a2 != null && a2.isTrimSpecified) {
                i = a2.videoTrimStartTimeMs;
                i2 = a2.videoTrimEndTimeMs;
            }
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(uri.getPath());
        float b = VideoMetadataExtractHelper.m19610b(mediaMetadataRetriever);
        mediaMetadataRetriever.release();
        RichVideoPlayerParams.Builder builder = new RichVideoPlayerParams.Builder();
        builder.a = m;
        builder.a("TrimStartPosition", Integer.valueOf(i)).a("TrimEndPosition", Integer.valueOf(i2)).a("VideoAspectRatioKey", Double.valueOf((double) b));
        if (videoCreativeEditingData != null) {
            Uri a3 = UriUtil.a(videoCreativeEditingData.f());
            if (a3 != null) {
                builder.a("OverlayImageParamsKey", a3);
            }
        }
        this.f14870c.a(builder.b());
        this.f14870c.a(this.f14869b.c(), EventTriggerType.BY_PLAYER);
        this.f14870c.a(EventTriggerType.BY_PLAYER);
    }

    public final OnToolbarButtonListener mo1153a(final FbFragmentActivity fbFragmentActivity, final ExpirationDialogController expirationDialogController) {
        return new OnToolbarButtonListener(this) {
            final /* synthetic */ StagingGroundProfileVideoController f14865c;

            public final void m18728a(View view, TitleBarButtonSpec titleBarButtonSpec) {
                Bundle extras = fbFragmentActivity.getIntent().getExtras();
                Intent b = this.f14865c.f14872t.b(fbFragmentActivity, FBLinks.aW);
                b.putExtra("session_id", this.f14865c.f14827m);
                b.putExtra("video_edit_data", this.f14865c.f14869b);
                b.putExtra("video_caption", this.f14865c.f14828n);
                b.putExtra("video_model", extras.getParcelable("video_model"));
                b.putExtra("video_expiration", expirationDialogController.m18773a());
                this.f14865c.f14871d.a(b, 2, fbFragmentActivity);
            }
        };
    }

    public final void mo1162b(View view) {
    }

    public final OnClickListener mo1152a(FbFragmentActivity fbFragmentActivity) {
        return new C10912(this);
    }

    public final boolean mo1163d() {
        return false;
    }

    @Nullable
    public final String mo1164e() {
        return null;
    }

    public final DialogInterface.OnClickListener mo1160b(FbFragmentActivity fbFragmentActivity) {
        return null;
    }

    public final void mo1155a(Activity activity, int i, int i2, Intent intent) {
        if (i == 2 && i2 == -1) {
            activity.setResult(-1);
            activity.finish();
        }
    }

    public final void mo1156a(Bundle bundle) {
        super.mo1156a(bundle);
        bundle.putParcelable("videoCreativeEditingDataKey", this.f14869b);
    }

    public final void mo1165f() {
        this.f14870c.a(EventTriggerType.BY_PLAYER);
    }

    public final void mo1166g() {
        this.f14870c.b(EventTriggerType.BY_PLAYER);
    }

    @StringRes
    public final int mo1167h() {
        return 2131237852;
    }
}
