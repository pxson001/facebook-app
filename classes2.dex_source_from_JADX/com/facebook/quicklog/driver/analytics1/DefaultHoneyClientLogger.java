package com.facebook.quicklog.driver.analytics1;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.inject.Lazy;

/* compiled from: read */
public class DefaultHoneyClientLogger {
    public static String f7966d;
    public final Lazy<AnalyticsLogger> f7967a;
    public final Lazy<FbDataConnectionManager> f7968b;
    public final Lazy<FbNetworkManager> f7969c;

    public DefaultHoneyClientLogger(Lazy<AnalyticsLogger> lazy, Lazy<FbDataConnectionManager> lazy2, Lazy<FbNetworkManager> lazy3) {
        this.f7967a = lazy;
        this.f7968b = lazy2;
        this.f7969c = lazy3;
        f7966d = System.getProperty("scenario", null);
    }
}
