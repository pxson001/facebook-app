package com.facebook.photos.mediagallery.ui;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.facebook.common.util.StringUtil;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.mediagallery.util.ModifiableFragmentStatePagerAdapter;
import com.facebook.photos.mediagallery.util.WarmupImageHelper;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: snap_high_range */
public class MediaGalleryPagerAdapter extends ModifiableFragmentStatePagerAdapter {
    private final MediaGalleryDataSource f2409a;
    private final Optional<WarmupImageHelper> f2410b;
    @Nullable
    private final String f2411c;
    @Nullable
    private final Uri f2412d;
    private final boolean f2413e;
    private final boolean f2414f;
    private final int f2415g;
    private final String f2416h;
    private final String f2417i;

    public MediaGalleryPagerAdapter(FragmentManager fragmentManager, MediaGalleryDataSource mediaGalleryDataSource, Optional<WarmupImageHelper> optional, @Nullable String str, @Nullable Uri uri, boolean z, boolean z2, int i, @Nullable String str2, @Nullable String str3) {
        super(fragmentManager);
        this.f2409a = mediaGalleryDataSource;
        this.f2410b = optional;
        this.f2411c = str;
        this.f2412d = uri;
        this.f2413e = z;
        this.f2414f = z2;
        this.f2415g = i;
        this.f2416h = str2;
        this.f2417i = str3;
    }

    public final Fragment m2540a(int i) {
        MediaMetadata e = m2544e(i);
        if (this.f2414f && e.J()) {
            Preconditions.checkNotNull(e);
            MediaGalleryVideoPageFragment mediaGalleryVideoPageFragment = new MediaGalleryVideoPageFragment();
            mediaGalleryVideoPageFragment.f2429f = e.d();
            return mediaGalleryVideoPageFragment;
        } else if (this.f2413e) {
            return MediaGalleryDraweePageFragment.m2482a(e, this.f2411c, this.f2412d, this.f2415g, this.f2416h, this.f2417i);
        } else {
            e = m2544e(i);
            Optional optional = this.f2410b;
            int i2 = this.f2415g;
            String str = this.f2416h;
            String str2 = this.f2417i;
            Preconditions.checkNotNull(e);
            MediaGalleryPageFragment mediaGalleryPageFragment = new MediaGalleryPageFragment();
            mediaGalleryPageFragment.f2407h = e.d();
            mediaGalleryPageFragment.f2406g = optional;
            mediaGalleryPageFragment.an = str;
            mediaGalleryPageFragment.am = i2;
            mediaGalleryPageFragment.ao = str2;
            return mediaGalleryPageFragment;
        }
    }

    public final int m2539a(Object obj) {
        String a = ((FragmentWithMediaId) obj).mo117a();
        ImmutableList immutableList = this.f2409a.f2363b;
        for (int i = 0; i < immutableList.size(); i++) {
            if (a.equals(((MediaMetadata) immutableList.get(i)).d())) {
                return i;
            }
        }
        return -2;
    }

    public final int m2542b() {
        return this.f2409a.f2363b.size();
    }

    public final MediaMetadata m2544e(int i) {
        return (MediaMetadata) this.f2409a.f2363b.get(i);
    }

    public final String m2543b(int i) {
        return m2544e(i).d();
    }

    public final boolean m2541a(Object obj, int i) {
        if (i >= b()) {
            return false;
        }
        return StringUtil.a(((FragmentWithMediaId) obj).mo117a(), m2544e(i).d());
    }
}
