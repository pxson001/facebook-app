package com.facebook.commerce.storefront.util;

import com.facebook.commerce.core.intent.MerchantInfoViewData;
import com.facebook.common.util.StringUtil;

/* compiled from: convert_to_social_search_post */
public class CollectionViewHeaderUtil {
    public static boolean m16289a(MerchantInfoViewData merchantInfoViewData) {
        if (merchantInfoViewData == null || merchantInfoViewData.a == null || StringUtil.a(merchantInfoViewData.a)) {
            return false;
        }
        return true;
    }
}
