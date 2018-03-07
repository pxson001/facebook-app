package com.facebook.reportaproblem.fb;

import android.content.Context;
import com.facebook.inject.FbInjector;
import com.facebook.katana.reportaproblem.Fb4aReportAProblemConfig;
import com.facebook.reportaproblem.base.ReportAProblemConfig;

/* compiled from: zero_rating2/clearable/carrier_bottom_banner_data_key */
public class FbReportAProblemConfigProvider {
    private final Context f496a;

    public FbReportAProblemConfigProvider(Context context) {
        this.f496a = context;
    }

    public final ReportAProblemConfig m1027a() {
        return (ReportAProblemConfig) Fb4aReportAProblemConfig.b(FbInjector.get(this.f496a));
    }
}
