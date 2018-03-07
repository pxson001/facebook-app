package com.facebook.timeline.profilevideo.playback;

import android.net.Uri;
import android.view.View.OnClickListener;
import com.facebook.caspian.ui.standardheader.ProfileVideoView;
import com.facebook.photos.creativeediting.model.VideoTrimParams;
import com.facebook.timeline.profilevideo.playback.protocol.FetchProfileVideoGraphQLModels.ProfileVideoHeaderFieldsModel;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.creativeediting.model.VideoCreativeEditingData;
import com.facebook.video.engine.VideoDataSource.VideoMirroringMode;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.RichVideoPlayerParams.Builder;
import com.facebook.video.player.plugins.ICoverView;
import javax.annotation.Nullable;

/* compiled from: mMajor */
public class ProfileVideoViewBinder {
    public static void m11153a(ProfileVideoView profileVideoView, ProfileVideoHeaderFieldsModel profileVideoHeaderFieldsModel, float f, ICoverView iCoverView, OnClickListener onClickListener, @Nullable VideoCreativeEditingData videoCreativeEditingData) {
        VideoMirroringMode videoMirroringMode;
        profileVideoView.g();
        VideoDataSourceBuilder videoDataSourceBuilder = new VideoDataSourceBuilder();
        videoDataSourceBuilder.a = Uri.parse(profileVideoHeaderFieldsModel.c());
        videoDataSourceBuilder = videoDataSourceBuilder;
        videoDataSourceBuilder.f = StreamSourceType.FROM_STREAM;
        VideoDataSourceBuilder videoDataSourceBuilder2 = videoDataSourceBuilder;
        if (videoCreativeEditingData == null || !videoCreativeEditingData.h()) {
            videoMirroringMode = VideoMirroringMode.NONE;
        } else {
            videoMirroringMode = VideoMirroringMode.MIRROR_HORIZONTALLY;
        }
        videoDataSourceBuilder2.h = videoMirroringMode;
        VideoPlayerParamsBuilder a = new VideoPlayerParamsBuilder().a(videoDataSourceBuilder2.i());
        a.b = profileVideoHeaderFieldsModel.b();
        a = a;
        a.g = true;
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
        Builder builder = new Builder();
        builder.a = m;
        RichVideoPlayerParams b = builder.a("TrimStartPosition", Integer.valueOf(i)).a("TrimEndPosition", Integer.valueOf(i2)).a("VideoAspectRatioKey", Double.valueOf((double) f)).b();
        profileVideoView.setOnClickListener(onClickListener);
        profileVideoView.i.setCoverView(iCoverView);
        profileVideoView.a(b);
        profileVideoView.a(EventTriggerType.BY_PLAYER);
    }
}
