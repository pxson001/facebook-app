package com.facebook.commerce.publishing.adapter;

import com.facebook.commerce.core.util.CommerceCurrencyUtil;
import com.facebook.commerce.publishing.graphql.CommercePublishingGraphQLUtils;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsInterfaces.AdminCommerceProductItem;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsModels.AdminCommerceProductItemModel;
import com.facebook.commerce.publishing.graphql.FetchCommerceStoreQueryModels.CommerceStoreFieldsModel;
import com.facebook.commerce.publishing.graphql.FetchCommerceStoreQueryModels.CommerceStoreFieldsModel.CommerceMerchantSettingsModel;
import com.facebook.commerce.publishing.graphql.FetchProductCatalogQueryModels.ProductCatalogFieldsModel;
import com.facebook.commerce.publishing.graphql.FetchProductCatalogQueryModels.ProductItemEdgeModel;
import com.facebook.commerce.publishing.mutator.ProductItemPendingMutationsCache;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Currency;
import javax.annotation.Nullable;

/* compiled from: data_fetch_failed */
public class AdminShopAdapterDataProvider {
    @Nullable
    public CommerceStoreFieldsModel f15463a;
    @Nullable
    public ImmutableList<AdminCommerceProductItem> f15464b;
    @Nullable
    public ImmutableMap<String, AdminCommerceProductItem> f15465c;
    @Nullable
    public AdminShopAdapter f15466d;
    @Nullable
    public String f15467e;

    @Nullable
    public final Currency m15998b() {
        String j = m15993j();
        if (j != null) {
            return CommerceCurrencyUtil.b(j);
        }
        return null;
    }

    public final int m16000c() {
        if (this.f15463a == null) {
            return 0;
        }
        return CommercePublishingGraphQLUtils.a(this.f15463a.m());
    }

    @Nullable
    public final String m16001e() {
        if (this.f15467e != null) {
            return this.f15467e;
        }
        return m15992i();
    }

    public final boolean m16002f() {
        return (this.f15467e == null || this.f15467e.equals(m15992i())) ? false : true;
    }

    @Nullable
    private String m15992i() {
        return this.f15463a != null ? this.f15463a.l() : null;
    }

    @Nullable
    private String m15993j() {
        CommerceMerchantSettingsModel m = m15996m();
        if (m == null || m.j() == null) {
            return null;
        }
        return m.j();
    }

    public final int m16003g() {
        int size;
        int i = 0;
        ImmutableList k = m15994k();
        if (this.f15464b != null) {
            size = this.f15464b.size();
        } else {
            size = 0;
        }
        if (k != null) {
            i = k.size();
        }
        return i + size;
    }

    @Nullable
    private ImmutableList<ProductItemEdgeModel> m15994k() {
        ProductCatalogFieldsModel l = m15995l();
        if (l == null || l.j() == null || l.j().a() == null) {
            return null;
        }
        return l.j().a();
    }

    @Nullable
    public final AdminCommerceProductItemModel m15997a(int i) {
        if (this.f15464b != null) {
            if (i < this.f15464b.size()) {
                return (AdminCommerceProductItemModel) this.f15464b.get(i);
            }
            i -= this.f15464b.size();
        }
        ImmutableList k = m15994k();
        if (k == null || k.size() <= i || ((ProductItemEdgeModel) k.get(i)).a() == null) {
            return null;
        }
        AdminCommerceProductItemModel a = ((ProductItemEdgeModel) k.get(i)).a();
        if (this.f15465c.containsKey(a.cu_())) {
            return (AdminCommerceProductItemModel) this.f15465c.get(a.cu_());
        }
        return ((ProductItemEdgeModel) k.get(i)).a();
    }

    @Nullable
    private ProductCatalogFieldsModel m15995l() {
        CommerceMerchantSettingsModel m = m15996m();
        if (m == null || m.l() == null) {
            return null;
        }
        return m.l();
    }

    @Nullable
    private CommerceMerchantSettingsModel m15996m() {
        if (this.f15463a == null || this.f15463a.j() == null) {
            return null;
        }
        return this.f15463a.j();
    }

    @Nullable
    public final String m16004h() {
        CommerceMerchantSettingsModel m = m15996m();
        return m != null ? m.k() : null;
    }

    public final boolean m15999b(AdminCommerceProductItem adminCommerceProductItem) {
        return ProductItemPendingMutationsCache.a(adminCommerceProductItem) || (this.f15465c != null && this.f15465c.containsKey(adminCommerceProductItem.cu_()));
    }
}
