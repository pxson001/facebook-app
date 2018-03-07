package com.facebook.photos.taggablegallery;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.facebook.inject.FbInjector;
import com.facebook.photos.base.photos.Photo;
import com.facebook.photos.photogallery.PhotoView;
import com.facebook.photos.photogallery.PhotoViewFactory;
import com.facebook.photos.photogallery.ZoomableViewPager;
import com.facebook.photos.tagging.store.TaggableLocalMediaUtil;
import com.facebook.widget.CustomViewGroup;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: sendPageLikeInviteParams */
public class PhotoGallery extends CustomViewGroup {
    @Inject
    public TaggableLocalMediaUtil f3396a;
    private ZoomableViewPager f3397b;
    private SimplePagerAdapter f3398c;
    public TaggableGalleryPhotoSource f3399d;
    public PhotoViewFactory f3400e;
    public Set<EventListener> f3401f;
    public Photo f3402g;
    public PhotoView f3403h;
    public int f3404i = 0;

    /* compiled from: sendPageLikeInviteParams */
    class C04301 implements OnPageChangeListener {
        final /* synthetic */ PhotoGallery f3394a;

        C04301(PhotoGallery photoGallery) {
            this.f3394a = photoGallery;
        }

        public final void e_(int i) {
            this.f3394a.f3404i = i;
        }

        public final void m3340a(int i, float f, int i2) {
        }

        public final void m3341b(int i) {
        }
    }

    /* compiled from: sendPageLikeInviteParams */
    public interface EventListener {
        void mo187a();

        void mo188a(PhotoView photoView, int i);

        void mo189b(PhotoView photoView, int i);
    }

    /* compiled from: sendPageLikeInviteParams */
    class SimplePagerAdapter extends PagerAdapter {
        final /* synthetic */ PhotoGallery f3395a;

        public SimplePagerAdapter(PhotoGallery photoGallery) {
            this.f3395a = photoGallery;
        }

        public final Object m3346a(ViewGroup viewGroup, int i) {
            PhotoGalleryContent a = this.f3395a.f3399d.mo185a(i);
            this.f3395a.f3396a.a(a.f3407a);
            PhotoView a2 = this.f3395a.f3400e.a(a.f3407a.f, viewGroup.getContext(), a.f3408b);
            a2.setTag(Integer.valueOf(i));
            viewGroup.addView(a2);
            for (EventListener a3 : this.f3395a.f3401f) {
                a3.mo188a(a2, i);
            }
            return a2;
        }

        public final void m3347a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public final void m3350b(ViewGroup viewGroup, int i, Object obj) {
            if (obj == null) {
                this.f3395a.f3402g = null;
                this.f3395a.f3403h = null;
                return;
            }
            PhotoView photoView = (PhotoView) obj;
            this.f3395a.f3403h = photoView;
            if (photoView.b()) {
                photoView.c.setPlaceHolderResourceId(2130838291);
                photoView.c.setPlaceHolderScaleType(ScaleType.MATRIX);
            }
            if (photoView.b != this.f3395a.f3402g) {
                this.f3395a.f3402g = photoView.b;
                for (EventListener b : this.f3395a.f3401f) {
                    b.mo189b(photoView, i);
                }
            }
        }

        public final int m3345a(Object obj) {
            return -2;
        }

        public final int m3349b() {
            return this.f3395a.f3399d != null ? this.f3395a.f3399d.mo184a() : 0;
        }

        public final boolean m3348a(View view, Object obj) {
            return view == obj;
        }
    }

    private static <T extends View> void m3357a(Class<T> cls, T t) {
        m3358a((Object) t, t.getContext());
    }

    private static void m3358a(Object obj, Context context) {
        ((PhotoGallery) obj).f3396a = TaggableLocalMediaUtil.a(FbInjector.get(context));
    }

    public PhotoGallery(Context context) {
        super(context);
        m3362d();
    }

    public PhotoGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3362d();
    }

    private void m3362d() {
        m3357a(PhotoGallery.class, (View) this);
        setContentView(2130907371);
        this.f3397b = (ZoomableViewPager) findViewById(2131562217);
        this.f3397b.setPageMargin(20);
        this.f3397b.setOnPageChangeListener(new C04301(this));
        this.f3398c = new SimplePagerAdapter(this);
        this.f3397b.setAdapter(this.f3398c);
        this.f3401f = Sets.a();
    }

    public final void m3365a(TaggableGalleryPhotoSource taggableGalleryPhotoSource, PhotoViewFactory photoViewFactory, int i) {
        this.f3399d = taggableGalleryPhotoSource;
        this.f3400e = photoViewFactory;
        m3363a();
        this.f3397b.a(i, false);
    }

    public final void m3363a() {
        for (EventListener a : this.f3401f) {
            a.mo187a();
        }
        this.f3402g = null;
        this.f3398c.kR_();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m3363a();
    }

    public final void m3366b() {
        this.f3397b.g();
    }

    public final void m3367c() {
        this.f3397b.h();
    }

    public final void m3364a(EventListener eventListener) {
        this.f3401f.add(eventListener);
    }

    public View getCurrentPhotoView() {
        return this.f3397b.findViewWithTag(Integer.valueOf(this.f3404i));
    }

    public Photo getCurrentPhoto() {
        return this.f3402g;
    }

    public int getCurrentPosition() {
        return this.f3397b.k;
    }

    public static int m3351a(PhotoView photoView) {
        return ((Integer) photoView.getTag()).intValue();
    }

    public List<PhotoView> getPhotoViewsInPager() {
        List<PhotoView> a = Lists.a();
        for (int i = 0; i < this.f3397b.getChildCount(); i++) {
            PhotoView photoView = (PhotoView) this.f3397b.getChildAt(i);
            if (this.f3403h == null || Math.abs(m3351a(this.f3403h) - m3351a(photoView)) <= 1) {
                a.add(photoView);
            }
        }
        return a;
    }

    private void m3356a(TaggableLocalMediaUtil taggableLocalMediaUtil) {
        this.f3396a = taggableLocalMediaUtil;
    }
}
