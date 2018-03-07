package com.facebook.feedplugins.musicstory;

import android.net.Uri;
import com.facebook.base.fragment.FbFragment;
import com.facebook.feedplugins.musicstory.MusicPlaybackPartDefinition.C10171;
import com.facebook.feedplugins.musicstory.albums.AlbumSharePartDefinition.PersistentAlbumState;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: composer_location_pin_clicked_stats */
public class PlaybackVisibilityRunnable implements Runnable {
    public final C10171 f8187a;
    public Uri f8188b;
    public int f8189c;
    public PersistentAlbumState f8190d;
    public WeakReference<FbFragment> f8191e;

    public PlaybackVisibilityRunnable(C10171 c10171) {
        this.f8187a = (C10171) Preconditions.checkNotNull(c10171);
    }

    public final void m9184a(Uri uri, @Nullable PersistentAlbumState persistentAlbumState, @Nullable FbFragment fbFragment, int i) {
        this.f8188b = (Uri) Preconditions.checkNotNull(uri);
        this.f8191e = new WeakReference(fbFragment);
        this.f8189c = i;
        this.f8190d = persistentAlbumState;
        if (this.f8187a.m9146c(this.f8188b) != null) {
            m9183b(this.f8187a.m9146c(this.f8188b));
        }
    }

    public void run() {
        SimpleMusicStoryView c = this.f8187a.m9146c(this.f8188b);
        if (c != null) {
            if (this.f8187a.f8139a.f8167b.m9173c(this.f8188b)) {
                Object obj;
                C10171 c10171;
                Uri uri;
                if (!(c.getParent() == null || c.getWindowToken() == null || !c.isShown())) {
                    Object obj2;
                    if (this.f8191e == null || this.f8191e.get() == null || ((FbFragment) this.f8191e.get()).D()) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        obj = null;
                        if (obj == null) {
                            c10171 = this.f8187a;
                            uri = this.f8188b;
                            c10171.f8139a.f8167b.m9175e(uri);
                            c10171.f8139a.f8168c.remove(uri);
                            if (c.f8209e != null) {
                                c.f8209e.m9228b();
                                c.m9194b();
                                c.setPlayButtonVisibility(0);
                            }
                        }
                        obj = (this.f8190d != null || this.f8189c == this.f8190d.f8262a) ? null : 1;
                        if (obj == null) {
                            m9183b(c);
                            return;
                        }
                        return;
                    }
                }
                obj = 1;
                if (obj == null) {
                    if (this.f8190d != null) {
                    }
                    if (obj == null) {
                        m9183b(c);
                        return;
                    }
                    return;
                }
                c10171 = this.f8187a;
                uri = this.f8188b;
                c10171.f8139a.f8167b.m9175e(uri);
                c10171.f8139a.f8168c.remove(uri);
                if (c.f8209e != null) {
                    c.f8209e.m9228b();
                    c.m9194b();
                    c.setPlayButtonVisibility(0);
                }
            }
        }
    }

    private void m9183b(SimpleMusicStoryView simpleMusicStoryView) {
        simpleMusicStoryView.postDelayed(this, 500);
    }
}
