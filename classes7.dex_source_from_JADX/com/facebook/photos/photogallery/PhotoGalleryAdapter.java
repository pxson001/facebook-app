package com.facebook.photos.photogallery;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.http.interfaces.RequestUpdateCache;
import com.facebook.photos.base.photos.Photo;
import com.facebook.photos.base.photos.PhotoFetchInfo.FetchCause;
import com.facebook.photos.grid.UrlImageGridAdapterImmutablePhotoSource;

/* compiled from: is_all_seen_refresh_enabled */
public class PhotoGalleryAdapter extends PagerAdapter {
    private final RequestUpdateCache<Integer> f10850a = new RequestUpdateCache(b());
    private int f10851b = -1;
    private UrlImageGridAdapterImmutablePhotoSource f10852c;
    private PhotoViewFactory f10853d;
    public PhotoGalleryAdapterListener f10854e;

    /* compiled from: is_all_seen_refresh_enabled */
    public interface PhotoGalleryAdapterListener {
        void mo611a();
    }

    public PhotoGalleryAdapter(UrlImageGridAdapterImmutablePhotoSource urlImageGridAdapterImmutablePhotoSource, PhotoViewFactory photoViewFactory) {
        this.f10852c = urlImageGridAdapterImmutablePhotoSource;
        this.f10853d = photoViewFactory;
    }

    public final Object m12877a(ViewGroup viewGroup, int i) {
        PhotoView a = this.f10853d.m12895a(m12875a(i), viewGroup.getContext(), null);
        a.setTag(Integer.valueOf(i));
        ((ViewPager) viewGroup).addView(a, 0);
        return a;
    }

    public final void m12878a(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
    }

    public final void m12883b(ViewGroup viewGroup, int i, Object obj) {
        if (this.f10851b != i) {
            m12876a(i - 1, FetchCause.PREFETCH);
            m12876a(i + 1, FetchCause.PREFETCH);
            m12876a(i, FetchCause.USER_INITIATED);
            this.f10851b = i;
        }
    }

    private Photo m12875a(int i) {
        UrlImageGridAdapterImmutablePhotoSource urlImageGridAdapterImmutablePhotoSource = this.f10852c;
        FetchCause fetchCause = FetchCause.PREFETCH;
        this.f10850a.a(Integer.valueOf(i), null);
        return (Photo) this.f10852c.a.get(i);
    }

    private void m12876a(int i, FetchCause fetchCause) {
        this.f10850a.a(Integer.valueOf(i), fetchCause.getMetadataRecommendedRequestPriority());
    }

    public final int m12881b() {
        return this.f10852c.a.size();
    }

    public final boolean m12880a(View view, Object obj) {
        return view == ((View) obj);
    }

    public final void m12882b(ViewGroup viewGroup) {
        if (this.f10854e != null) {
            this.f10854e.mo611a();
        }
    }

    public final void m12879a(PhotoGalleryAdapterListener photoGalleryAdapterListener) {
        this.f10854e = photoGalleryAdapterListener;
    }
}
