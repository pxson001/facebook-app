package com.facebook.commerce.core.util;

import android.content.res.Resources;
import com.facebook.commerce.core.ui.NoticeView.NoticeLevel;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.graphql.enums.GraphQLCommerceProductVisibility;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: posts */
public class ProductApprovalUtils {
    private final Resources f7562a;

    /* compiled from: posts */
    /* synthetic */ class C04511 {
        static final /* synthetic */ int[] f7561a = new int[GraphQLCommerceProductVisibility.values().length];

        static {
            try {
                f7561a[GraphQLCommerceProductVisibility.PRODUCT_IN_REVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7561a[GraphQLCommerceProductVisibility.PRODUCT_REJECTED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f7561a[GraphQLCommerceProductVisibility.PRODUCT_NOT_PUBLISHED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f7561a[GraphQLCommerceProductVisibility.MERCHANT_NOT_ENABLED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f7561a[GraphQLCommerceProductVisibility.MERCHANT_NOT_APPROVED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static ProductApprovalUtils m10697a(InjectorLike injectorLike) {
        return new ProductApprovalUtils(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ProductApprovalUtils(Resources resources) {
        this.f7562a = resources;
    }

    @Nullable
    public static NoticeLevel m10696a(GraphQLCommerceProductVisibility graphQLCommerceProductVisibility) {
        if (graphQLCommerceProductVisibility == null || graphQLCommerceProductVisibility == GraphQLCommerceProductVisibility.VISIBLE || graphQLCommerceProductVisibility == GraphQLCommerceProductVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            return null;
        }
        return graphQLCommerceProductVisibility == GraphQLCommerceProductVisibility.PRODUCT_REJECTED ? NoticeLevel.WARN : NoticeLevel.NOTIFY;
    }

    @Nullable
    public final String m10698b(GraphQLCommerceProductVisibility graphQLCommerceProductVisibility) {
        if (graphQLCommerceProductVisibility == null) {
            return null;
        }
        switch (C04511.f7561a[graphQLCommerceProductVisibility.ordinal()]) {
            case 1:
                return this.f7562a.getString(2131234797);
            case 2:
                return this.f7562a.getString(2131234799);
            default:
                return null;
        }
    }

    @Nullable
    public final String m10699c(GraphQLCommerceProductVisibility graphQLCommerceProductVisibility) {
        if (graphQLCommerceProductVisibility == null) {
            return null;
        }
        switch (C04511.f7561a[graphQLCommerceProductVisibility.ordinal()]) {
            case 1:
                return this.f7562a.getString(2131234798);
            case 2:
                return this.f7562a.getString(2131234800);
            case 3:
                return this.f7562a.getString(2131234802);
            case 4:
                return this.f7562a.getString(2131234804);
            case 5:
                return this.f7562a.getString(2131234803);
            default:
                return null;
        }
    }
}
