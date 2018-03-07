package com.facebook.pages.identity.cards.photos;

import android.content.Context;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.photos.consumptiongallery.ConsumptionPhoto;
import com.facebook.photos.consumptiongallery.ConsumptionPhotoCache;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.ui.DefaultMediaGalleryLauncher;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.widget.ListViewFriendlyViewPager;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

/* compiled from: privacyHasChanged */
public class PageIdentityPhotosGallery extends ListViewFriendlyViewPager {
    public PageIdentityPhotoGalleryAdapter f3611a;
    private List<Long> f3612b;
    private List<ConsumptionPhoto> f3613c;
    private ConsumptionPhotoCache f3614d;
    public OnPhotoDisplayedListener f3615e;

    /* compiled from: privacyHasChanged */
    public interface OnPhotoDisplayedListener {
        void mo95a(String str);
    }

    /* compiled from: privacyHasChanged */
    class C04941 extends SimpleOnPageChangeListener {
        final /* synthetic */ PageIdentityPhotosGallery f3610a;

        C04941(PageIdentityPhotosGallery pageIdentityPhotosGallery) {
            this.f3610a = pageIdentityPhotosGallery;
        }

        public final void e_(int i) {
            if (this.f3610a.f3615e != null) {
                this.f3610a.f3615e.mo95a(((GraphQLPhoto) this.f3610a.f3611a.a.get(i)).K());
            }
        }
    }

    private static <T extends View> void m4649a(Class<T> cls, T t) {
        m4650a((Object) t, t.getContext());
    }

    private static void m4650a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageIdentityPhotosGallery) obj).m4648a(ConsumptionPhotoCache.a(fbInjector), new PageIdentityPhotoGalleryAdapter((Context) fbInjector.getInstance(Context.class), IdBasedSingletonScopeProvider.a(fbInjector, 610), RecyclableViewPoolManager.a(fbInjector), (MediaGalleryLauncher) DefaultMediaGalleryLauncher.a(fbInjector), MediaGalleryLauncherParamsFactory.a(fbInjector)));
    }

    public PageIdentityPhotosGallery(Context context) {
        super(context);
        m4653h();
    }

    public PageIdentityPhotosGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4653h();
    }

    private void m4653h() {
        m4649a(PageIdentityPhotosGallery.class, (View) this);
        setOnPageChangeListener(new C04941(this));
        setAdapter(this.f3611a);
    }

    @Inject
    private void m4648a(ConsumptionPhotoCache consumptionPhotoCache, PageIdentityPhotoGalleryAdapter pageIdentityPhotoGalleryAdapter) {
        this.f3614d = consumptionPhotoCache;
        this.f3611a = pageIdentityPhotoGalleryAdapter;
    }

    public void setPhotosCollections(List<GraphQLPhoto> list) {
        this.f3611a.a(list);
        m4651a((List) list);
    }

    private void m4651a(List<GraphQLPhoto> list) {
        this.f3612b = Lists.a();
        this.f3613c = Lists.a();
        if (list != null) {
            for (GraphQLPhoto graphQLPhoto : list) {
                if (!(StringUtil.a(graphQLPhoto.K()) || graphQLPhoto.L() == null || StringUtil.a(graphQLPhoto.L().b()))) {
                    this.f3612b.add(Long.valueOf(Long.parseLong(graphQLPhoto.K())));
                    ConsumptionPhoto consumptionPhoto = new ConsumptionPhoto(Long.parseLong(graphQLPhoto.K()));
                    consumptionPhoto.d = graphQLPhoto.L().b();
                    this.f3614d.a(consumptionPhoto);
                    this.f3613c.add(consumptionPhoto);
                }
            }
        }
    }

    public void setOnPhotoDisplayedListener(OnPhotoDisplayedListener onPhotoDisplayedListener) {
        this.f3615e = onPhotoDisplayedListener;
    }
}
