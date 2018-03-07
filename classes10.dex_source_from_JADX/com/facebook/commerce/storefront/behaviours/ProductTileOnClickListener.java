package com.facebook.commerce.storefront.behaviours;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceProductSectionType;
import com.facebook.commerce.core.analytics.CommerceAnalyticsEventBuilder;
import com.facebook.commerce.core.util.CommerceNavigationUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: createEventParams */
public class ProductTileOnClickListener implements OnClickListener {
    public String f15703a;
    private final Context f15704b;
    private CommerceNavigationUtil f15705c;
    private final CommerceProductSectionType f15706d;
    private final AnalyticsLogger f15707e;

    public ProductTileOnClickListener(Context context, CommerceNavigationUtil commerceNavigationUtil, AnalyticsLogger analyticsLogger, CommerceProductSectionType commerceProductSectionType) {
        this(context, commerceNavigationUtil, null, analyticsLogger, commerceProductSectionType);
    }

    public ProductTileOnClickListener(Context context, CommerceNavigationUtil commerceNavigationUtil, String str, AnalyticsLogger analyticsLogger, CommerceProductSectionType commerceProductSectionType) {
        this.f15704b = context;
        this.f15705c = commerceNavigationUtil;
        this.f15703a = str;
        this.f15707e = analyticsLogger;
        this.f15706d = commerceProductSectionType;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 56164677);
        if (StringUtil.a(this.f15703a)) {
            Logger.a(2, EntryType.UI_INPUT_END, -2040416985, a);
            return;
        }
        this.f15707e.a(CommerceAnalyticsEventBuilder.b(this.f15703a, Boolean.valueOf(false), this.f15706d));
        this.f15705c.a(this.f15703a);
        LogUtils.a(2005601180, a);
    }
}
