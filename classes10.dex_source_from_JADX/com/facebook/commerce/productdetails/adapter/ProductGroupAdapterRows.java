package com.facebook.commerce.productdetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.commerce.core.util.CommerceMerchantUtil;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel.CommerceMerchantSettingsModel;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel.GroupModel.ProductItemsEdgeModel.NodesModel;
import com.facebook.commerce.productdetails.ui.insightsandpromotion.ProductGroupsPromotionInteractionsView;
import com.facebook.commerce.productdetails.ui.merchantpageinfo.ProductGroupMerchantPageInfoView;
import com.facebook.commerce.productdetails.ui.morefromshop.ProductGroupMoreFromShopView;
import com.facebook.commerce.productdetails.ui.termsandpolicies.ProductGroupTermsAndPoliciesView;
import com.facebook.commerce.productdetails.ui.userinteractions.ProductGroupUserInteractionsView;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLCommerceProductVisibility;
import com.facebook.graphql.enums.GraphQLCommerceUIProductDetailSectionType;
import com.facebook.groups.staticadapter.StaticAdapter.ViewType;
import com.google.common.collect.ImmutableList;

/* compiled from: delete_message_request_dialog */
public class ProductGroupAdapterRows {
    static final ProductGroupViewType<ProductGroupMerchantPageInfoView> f15126a = new C21041();
    static final ProductGroupViewType<ProductGroupsPromotionInteractionsView> f15127b = new C21052();
    static final ProductGroupViewType<ProductGroupUserInteractionsView> f15128c = new C21063();
    static final ProductGroupViewType<ProductGroupMoreFromShopView> f15129d = new C21074();
    static final ProductGroupViewType<ProductGroupTermsAndPoliciesView> f15130e = new C21085();
    public static final ImmutableList<? extends ProductGroupViewType<? extends View>> f15131f = ImmutableList.of(f15126a, f15127b, f15128c, f15129d, f15130e);

    /* compiled from: delete_message_request_dialog */
    public interface ProductGroupViewType<V extends View> extends ViewType<V> {
        GraphQLCommerceUIProductDetailSectionType mo756a();

        boolean mo757a(FetchProductGroupQueryModel fetchProductGroupQueryModel);
    }

    /* compiled from: delete_message_request_dialog */
    final class C21041 implements ProductGroupViewType<ProductGroupMerchantPageInfoView> {
        C21041() {
        }

        public final boolean mo757a(FetchProductGroupQueryModel fetchProductGroupQueryModel) {
            return fetchProductGroupQueryModel != null;
        }

        public final GraphQLCommerceUIProductDetailSectionType mo756a() {
            return GraphQLCommerceUIProductDetailSectionType.MERCHANT_PAGE_INFO;
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new ProductGroupMerchantPageInfoView(viewGroup.getContext());
        }
    }

    /* compiled from: delete_message_request_dialog */
    final class C21052 implements ProductGroupViewType<ProductGroupsPromotionInteractionsView> {
        C21052() {
        }

        public final boolean mo757a(FetchProductGroupQueryModel fetchProductGroupQueryModel) {
            CommerceMerchantSettingsModel l = fetchProductGroupQueryModel.m15814l();
            if (l == null) {
                return false;
            }
            boolean a = CommerceMerchantUtil.a(l.m15697a(), l.m15702k());
            boolean z;
            if (fetchProductGroupQueryModel.m15815m() == GraphQLCommerceProductVisibility.VISIBLE) {
                z = true;
            } else {
                z = false;
            }
            if (a && r2) {
                return true;
            }
            return false;
        }

        public final GraphQLCommerceUIProductDetailSectionType mo756a() {
            return GraphQLCommerceUIProductDetailSectionType.INSIGHTS_AND_PROMOTION;
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new ProductGroupsPromotionInteractionsView(viewGroup.getContext());
        }
    }

    /* compiled from: delete_message_request_dialog */
    final class C21063 implements ProductGroupViewType<ProductGroupUserInteractionsView> {
        C21063() {
        }

        public final boolean mo757a(FetchProductGroupQueryModel fetchProductGroupQueryModel) {
            if (fetchProductGroupQueryModel == null || fetchProductGroupQueryModel.m15819q() == null || fetchProductGroupQueryModel.m15819q().m15751j() == null || fetchProductGroupQueryModel.m15819q().m15751j().m15746a() == null || fetchProductGroupQueryModel.m15819q().m15751j().m15746a().isEmpty()) {
                return false;
            }
            ImmutableList k;
            int size;
            int i;
            if (fetchProductGroupQueryModel.m15819q().m15752k() != null) {
                k = fetchProductGroupQueryModel.m15819q().m15752k();
                size = k.size();
                for (i = 0; i < size; i++) {
                    if (StringUtil.a((String) k.get(i))) {
                        return false;
                    }
                }
            }
            k = fetchProductGroupQueryModel.m15819q().m15751j().m15746a();
            size = k.size();
            for (i = 0; i < size; i++) {
                NodesModel nodesModel = (NodesModel) k.get(i);
                if (nodesModel == null || nodesModel.m15735l() == null) {
                    return false;
                }
            }
            return true;
        }

        public final GraphQLCommerceUIProductDetailSectionType mo756a() {
            return GraphQLCommerceUIProductDetailSectionType.USER_INTERACTIONS;
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new ProductGroupUserInteractionsView(viewGroup.getContext());
        }
    }

    /* compiled from: delete_message_request_dialog */
    final class C21074 implements ProductGroupViewType<ProductGroupMoreFromShopView> {
        C21074() {
        }

        public final boolean mo757a(FetchProductGroupQueryModel fetchProductGroupQueryModel) {
            return (fetchProductGroupQueryModel == null || fetchProductGroupQueryModel.m15824v() == null || fetchProductGroupQueryModel.m15824v().m15803a() == null || fetchProductGroupQueryModel.m15824v().m15803a().isEmpty() || ProductGroupMoreFromShopView.m15916a(fetchProductGroupQueryModel.m15824v()).isEmpty()) ? false : true;
        }

        public final GraphQLCommerceUIProductDetailSectionType mo756a() {
            return GraphQLCommerceUIProductDetailSectionType.MORE_FROM_SHOP;
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new ProductGroupMoreFromShopView(viewGroup.getContext());
        }
    }

    /* compiled from: delete_message_request_dialog */
    final class C21085 implements ProductGroupViewType<ProductGroupTermsAndPoliciesView> {
        C21085() {
        }

        public final boolean mo757a(FetchProductGroupQueryModel fetchProductGroupQueryModel) {
            if (fetchProductGroupQueryModel == null || fetchProductGroupQueryModel.m15814l() == null || CommerceMerchantUtil.a(fetchProductGroupQueryModel.m15814l().m15697a()) || StringUtil.a(fetchProductGroupQueryModel.m15814l().m15703l())) {
                return false;
            }
            return true;
        }

        public final GraphQLCommerceUIProductDetailSectionType mo756a() {
            return GraphQLCommerceUIProductDetailSectionType.POLICIES;
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new ProductGroupTermsAndPoliciesView(viewGroup.getContext());
        }
    }
}
