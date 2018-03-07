package com.facebook.video.creativeediting;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import com.facebook.ipc.videoeditgallery.VideoEditGalleryLaunchConfiguration;
import com.facebook.photos.editgallery.animations.AnimationParam;
import com.facebook.video.creativeediting.analytics.VideoEditingGalleryEntryPoint;
import com.facebook.video.creativeediting.model.VideoCreativeEditingData;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: failed to de-serialize model */
public class VideoEditGalleryFragmentManager {
    private static final String f15440a = VideoEditGalleryFragmentManager.class.getSimpleName();
    private final AtomicBoolean f15441b = new AtomicBoolean(false);
    private FragmentManager f15442c;
    private WeakReference<VideoEditGalleryFragment> f15443d = new WeakReference(null);

    /* compiled from: failed to de-serialize model */
    public interface VideoEditGalleryCallback {
        void mo1168a(int i);

        void mo1169a(VideoCreativeEditingData videoCreativeEditingData, int i);
    }

    public VideoEditGalleryFragmentManager(FragmentManager fragmentManager) {
        this.f15442c = fragmentManager;
    }

    public final void m19478a(VideoEditGalleryLaunchConfiguration videoEditGalleryLaunchConfiguration, Uri uri, VideoEditGalleryCallback videoEditGalleryCallback, VideoEditingGalleryEntryPoint videoEditingGalleryEntryPoint, AnimationParam animationParam) {
        Preconditions.checkNotNull(videoEditGalleryLaunchConfiguration);
        Preconditions.checkNotNull(videoEditGalleryCallback);
        if (!this.f15441b.getAndSet(true)) {
            if (this.f15442c.a(f15440a) != null) {
                this.f15441b.set(false);
                return;
            }
            VideoEditGalleryFragment videoEditGalleryFragment = new VideoEditGalleryFragment();
            videoEditGalleryFragment.m19452a(videoEditGalleryLaunchConfiguration, uri, videoEditGalleryCallback, animationParam, videoEditingGalleryEntryPoint);
            this.f15442c.a().a(videoEditGalleryFragment, f15440a).b();
            this.f15442c.b();
            this.f15441b.set(false);
            this.f15443d = new WeakReference(videoEditGalleryFragment);
        }
    }

    public final void m19479a(VideoEditGalleryCallback videoEditGalleryCallback) {
        this.f15443d = new WeakReference(this.f15442c.a(f15440a));
        if (this.f15443d.get() != null) {
            ((VideoEditGalleryFragment) this.f15443d.get()).as = videoEditGalleryCallback;
        }
    }
}
