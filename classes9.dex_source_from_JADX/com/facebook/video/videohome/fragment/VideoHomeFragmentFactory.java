package com.facebook.video.videohome.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.inject.Lazy;
import com.facebook.video.videohome.prefetching.VideoHomeReactionSessionHelper;
import javax.inject.Inject;

/* compiled from: startCapture failed */
public class VideoHomeFragmentFactory implements IFragmentFactory {
    private final Lazy<VideoHomeReactionSessionHelper> f2900a;

    @Inject
    public VideoHomeFragmentFactory(Lazy<VideoHomeReactionSessionHelper> lazy) {
        this.f2900a = lazy;
    }

    public final Fragment m2804a(Intent intent) {
        String b = ((VideoHomeReactionSessionHelper) this.f2900a.get()).m3142b();
        VideoHomeHomeFragment videoHomeHomeFragment = new VideoHomeHomeFragment();
        Bundle extras = intent.getExtras();
        extras.putBoolean("ptr_enabled", true);
        if (b != null) {
            extras.putString("reaction_session_id", b);
        }
        videoHomeHomeFragment.g(extras);
        Fragment fragment = videoHomeHomeFragment;
        ((VideoHomeReactionSessionHelper) this.f2900a.get()).m3143c();
        return fragment;
    }
}
