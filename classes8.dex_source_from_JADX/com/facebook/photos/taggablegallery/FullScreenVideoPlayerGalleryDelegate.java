package com.facebook.photos.taggablegallery;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.player.FullScreenParams;
import com.facebook.video.player.FullScreenVideoPlayer;

/* compiled from: sent_code_email */
public class FullScreenVideoPlayerGalleryDelegate implements VideoPlayerGalleryDelegate {
    FullScreenVideoPlayer f3390a;

    public final View mo179a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(2130907673, viewGroup, false);
        this.f3390a = (FullScreenVideoPlayer) inflate.findViewById(2131565235);
        this.f3390a.ap = false;
        return inflate;
    }

    public final ViewGroup mo180a() {
        return this.f3390a;
    }

    public final void mo182b() {
        this.f3390a.q();
    }

    public final void mo183c() {
        this.f3390a.r();
    }

    public final void mo181a(Uri uri) {
        FullScreenParams a = new FullScreenParams(uri, 0, EventTriggerType.BY_USER, ImageRequest.a(uri)).a(PlayerOrigin.MEDIA_PICKER);
        this.f3390a.bringToFront();
        this.f3390a.a(a);
    }
}
