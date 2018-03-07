package com.facebook.commerce.storefront.ui;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.CommerceProductItemModel;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.CommerceStoreFragmentModel.CommerceCollectionsModel;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.CommerceStoreFragmentModel.CommerceCollectionsModel.CollectionProductItemsModel.EdgesModel;
import com.facebook.commerce.core.util.CommerceNavigationUtil;
import com.facebook.commerce.storefront.adapters.StorefrontLargeImagePagerAdapter;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.ListViewFriendlyViewPager;
import com.facebook.widget.viewpageindicator.CirclePageIndicator;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: could_not_create_intent_for_notification */
public class FeaturedProductCollectionView extends CustomFrameLayout {
    @Inject
    public CommerceNavigationUtil f15778a;
    @Inject
    public AbstractFbErrorReporter f15779b;
    @Inject
    public AnalyticsLogger f15780c;
    private StorefrontLargeImagePagerAdapter f15781d;
    private ListViewFriendlyViewPager f15782e;
    private CirclePageIndicator f15783f;
    private boolean f15784g;

    private static <T extends View> void m16261a(Class<T> cls, T t) {
        m16262a((Object) t, t.getContext());
    }

    private static void m16262a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FeaturedProductCollectionView featuredProductCollectionView = (FeaturedProductCollectionView) obj;
        CommerceNavigationUtil a = CommerceNavigationUtil.a(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        AnalyticsLogger a2 = AnalyticsLoggerMethodAutoProvider.a(fbInjector);
        featuredProductCollectionView.f15778a = a;
        featuredProductCollectionView.f15779b = abstractFbErrorReporter;
        featuredProductCollectionView.f15780c = a2;
    }

    public FeaturedProductCollectionView(Context context) {
        super(context);
        m16260a();
    }

    public FeaturedProductCollectionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m16260a();
    }

    public FeaturedProductCollectionView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16260a();
    }

    private void m16260a() {
        m16261a(FeaturedProductCollectionView.class, (View) this);
        setContentView(2130907246);
        this.f15782e = (ListViewFriendlyViewPager) c(2131567678);
        this.f15783f = (CirclePageIndicator) c(2131567679);
        m16263b();
        this.f15781d = new StorefrontLargeImagePagerAdapter(this.f15778a, this.f15779b, this.f15780c);
        this.f15782e.setAdapter(this.f15781d);
        this.f15783f.setViewPager(this.f15782e);
    }

    public final void m16264a(@Nullable CommerceCollectionsModel commerceCollectionsModel, @Nullable String str) {
        StorefrontLargeImagePagerAdapter storefrontLargeImagePagerAdapter = this.f15781d;
        storefrontLargeImagePagerAdapter.f15682d = commerceCollectionsModel;
        storefrontLargeImagePagerAdapter.kR_();
        if (!this.f15784g) {
            setProductItem(str);
        }
    }

    public void setProductItem(@Nullable String str) {
        int i;
        StorefrontLargeImagePagerAdapter storefrontLargeImagePagerAdapter = this.f15781d;
        if (str == null) {
            i = -1;
        } else {
            i = 0;
            while (i < storefrontLargeImagePagerAdapter.b()) {
                CommerceProductItemModel commerceProductItemModel;
                if (storefrontLargeImagePagerAdapter.f15682d == null || storefrontLargeImagePagerAdapter.f15682d.j() == null || storefrontLargeImagePagerAdapter.f15682d.j().j().isEmpty()) {
                    commerceProductItemModel = null;
                } else {
                    commerceProductItemModel = ((EdgesModel) storefrontLargeImagePagerAdapter.f15682d.j().j().get(i)).a();
                }
                CommerceProductItemModel commerceProductItemModel2 = commerceProductItemModel;
                if (commerceProductItemModel2 != null && str.equals(commerceProductItemModel2.l())) {
                    break;
                }
                i++;
            }
            i = -1;
        }
        int i2 = i;
        if (i2 >= 0) {
            this.f15782e.setCurrentItem(i2);
            this.f15784g = true;
        }
    }

    private void m16263b() {
        Point point = new Point();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getSize(point);
        this.f15782e.b((int) (((float) point.x) / 1.0f), true);
    }
}
