package com.facebook.commerce.storefront.ui;

import android.net.Uri;
import com.facebook.commerce.core.intent.MerchantInfoViewData;
import com.facebook.commerce.core.ui.PageInfoView;

/* compiled from: copy */
public class StorefrontPageInfoViewBinder {
    public static void m16288a(MerchantInfoViewData merchantInfoViewData, PageInfoView pageInfoView) {
        pageInfoView.c = merchantInfoViewData.e;
        pageInfoView.a(merchantInfoViewData.a);
        pageInfoView.a(Uri.parse(merchantInfoViewData.c));
        pageInfoView.a(merchantInfoViewData.b, merchantInfoViewData.d);
    }
}
