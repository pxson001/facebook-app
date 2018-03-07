package com.facebook.photos.taggablegallery;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.photos.taggablegallery.TaggableGalleryConstants.Source;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: self_birthday_profile_pic_frame */
public class ProductionVideoGalleryActivity extends FbFragmentActivity {
    @Inject
    public Provider<GifVideoPlayerGalleryDelegate> f3409p;

    private static <T extends Context> void m3373a(Class<T> cls, T t) {
        m3374a((Object) t, (Context) t);
    }

    public static void m3374a(Object obj, Context context) {
        ((ProductionVideoGalleryActivity) obj).f3409p = IdBasedProvider.a(FbInjector.get(context), 9431);
    }

    public final void m3376b(Bundle bundle) {
        super.b(bundle);
        Class cls = ProductionVideoGalleryActivity.class;
        m3374a((Object) this, (Context) this);
        setContentView(2130907674);
        Intent intent = getIntent();
        Fragment fragment = (ProductionVideoGalleryFragment) kO_().a(2131558429);
        if (fragment == null) {
            VideoPlayerGalleryDelegate fullScreenVideoPlayerGalleryDelegate;
            VideoItem videoItem = (VideoItem) intent.getParcelableExtra("extra_video_item");
            fragment = new ProductionVideoGalleryFragment();
            if (videoItem == null || !MediaItem.a.equals(videoItem.i())) {
                fullScreenVideoPlayerGalleryDelegate = new FullScreenVideoPlayerGalleryDelegate();
            } else {
                fullScreenVideoPlayerGalleryDelegate = (VideoPlayerGalleryDelegate) this.f3409p.get();
            }
            fragment.m3383a(Source.values()[intent.getIntExtra("extra_source", 0)], intent.getStringExtra("extra_session_id"), videoItem, (Uri) intent.getParcelableExtra("extra_video_uri"), fullScreenVideoPlayerGalleryDelegate);
        }
        kO_().a().a(2131558429, fragment).b();
    }

    private void m3375a(Provider<GifVideoPlayerGalleryDelegate> provider) {
        this.f3409p = provider;
    }
}
