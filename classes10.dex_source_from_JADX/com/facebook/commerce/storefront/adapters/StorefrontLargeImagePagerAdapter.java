package com.facebook.commerce.storefront.adapters;

import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceProductSectionType;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.CommerceStoreFragmentModel.CommerceCollectionsModel;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.CommerceStoreFragmentModel.CommerceCollectionsModel.CollectionProductItemsModel.EdgesModel;
import com.facebook.commerce.core.util.CommerceCurrencyUtil;
import com.facebook.commerce.core.util.CommerceNavigationUtil;
import com.facebook.commerce.storefront.behaviours.ProductTileOnClickListener;
import com.facebook.commerce.storefront.ui.StorefrontLargeHScrollCorexItem;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.util.StringUtil;

/* compiled from: create_group_thread */
public class StorefrontLargeImagePagerAdapter extends PagerAdapter {
    public AbstractFbErrorReporter f15679a;
    private final CommerceNavigationUtil f15680b;
    private final AnalyticsLogger f15681c;
    public CommerceCollectionsModel f15682d;

    public StorefrontLargeImagePagerAdapter(CommerceNavigationUtil commerceNavigationUtil, AbstractFbErrorReporter abstractFbErrorReporter, AnalyticsLogger analyticsLogger) {
        this.f15680b = commerceNavigationUtil;
        this.f15679a = abstractFbErrorReporter;
        this.f15681c = analyticsLogger;
    }

    public final int m16138b() {
        return (this.f15682d == null || this.f15682d.j() == null || this.f15682d.j().j().isEmpty()) ? 0 : this.f15682d.j().j().size();
    }

    public final Object m16135a(ViewGroup viewGroup, int i) {
        Uri uri;
        StorefrontLargeHScrollCorexItem storefrontLargeHScrollCorexItem = new StorefrontLargeHScrollCorexItem(viewGroup.getContext());
        storefrontLargeHScrollCorexItem.setLayoutParams(new LayoutParams(-1, -1));
        if (i < 0 || i > b()) {
            uri = null;
        } else {
            String a;
            if (b() > i && this.f15682d.j().j().asList().get(i) != null) {
                EdgesModel edgesModel = (EdgesModel) this.f15682d.j().j().get(i);
                if (edgesModel.a().n() != null) {
                    a = edgesModel.a().n().a();
                    if (a != null) {
                        this.f15679a.a("commerce_storefront_limage_adapter", "getHScrollLargeImageUri: image uri is null");
                        uri = null;
                    } else {
                        uri = Uri.parse(a);
                    }
                }
            }
            a = null;
            if (a != null) {
                uri = Uri.parse(a);
            } else {
                this.f15679a.a("commerce_storefront_limage_adapter", "getHScrollLargeImageUri: image uri is null");
                uri = null;
            }
        }
        storefrontLargeHScrollCorexItem.f15841b.a(uri, StorefrontLargeHScrollCorexItem.f15840a);
        storefrontLargeHScrollCorexItem.f15843d.setText(m16132e(i));
        storefrontLargeHScrollCorexItem.f15842c.setText(m16133f(i));
        viewGroup.addView(storefrontLargeHScrollCorexItem);
        storefrontLargeHScrollCorexItem.setOnClickListener(new ProductTileOnClickListener(viewGroup.getContext(), this.f15680b, ((EdgesModel) this.f15682d.j().j().get(i)).a().l(), this.f15681c, CommerceProductSectionType.STOREFRONT_BANNER));
        return storefrontLargeHScrollCorexItem;
    }

    public final void m16136a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public final boolean m16137a(View view, Object obj) {
        return view == obj;
    }

    public final int m16134a(Object obj) {
        return -2;
    }

    private String m16132e(int i) {
        if (i < 0 || i > b()) {
            return null;
        }
        String c;
        String str = "";
        if (b() > i && this.f15682d.j().j().asList().get(i) != null) {
            EdgesModel edgesModel = (EdgesModel) this.f15682d.j().j().get(i);
            if (edgesModel.a().c() != null) {
                c = edgesModel.a().c();
                if (StringUtil.a(c)) {
                    return c;
                }
                this.f15679a.a("commerce_storefront_limage_adapter", "getHScrollItemDescription: item description is null");
                return null;
            }
        }
        c = str;
        if (StringUtil.a(c)) {
            return c;
        }
        this.f15679a.a("commerce_storefront_limage_adapter", "getHScrollItemDescription: item description is null");
        return null;
    }

    private String m16133f(int i) {
        if (i < 0 || i > b()) {
            return null;
        }
        String a;
        String str = "";
        if (b() > i && this.f15682d.j().j().asList().get(i) != null) {
            EdgesModel edgesModel = (EdgesModel) this.f15682d.j().j().get(i);
            if (edgesModel.a().j() != null) {
                a = CommerceCurrencyUtil.a(edgesModel.a().j());
                if (StringUtil.a(a)) {
                    return a;
                }
                this.f15679a.a("commerce_storefront_limage_adapter", "getHscrollItemPrice: item price is null");
                return null;
            }
        }
        a = str;
        if (StringUtil.a(a)) {
            return a;
        }
        this.f15679a.a("commerce_storefront_limage_adapter", "getHscrollItemPrice: item price is null");
        return null;
    }
}
