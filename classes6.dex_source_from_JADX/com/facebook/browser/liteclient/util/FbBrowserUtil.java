package com.facebook.browser.liteclient.util;

import android.text.TextUtils;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Product;
import com.facebook.config.versioninfo.AppVersionInfo;

/* compiled from: product_catalog */
public class FbBrowserUtil {
    public static String m10492a(Product product, AppVersionInfo appVersionInfo) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" [");
        stringBuilder.append(StringFormatUtil.formatStrLocaleSafe("%s/%s;%s/%s;", "FB_IAB", m10493a(product.name()), "FBAV", m10493a(appVersionInfo.a())));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static String m10493a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return StringUtil.e(str).replace("/", "-").replace(";", "-");
    }
}
