package com.facebook.analytics;

import android.content.Context;
import com.facebook.analytics.samplingpolicy.AnalyticsLoggingPolicy;
import com.facebook.analytics.webmethod.AnalyticsServerResponse;
import com.facebook.analytics2.loggermodule.FbandroidAppInfoProvider;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.device_id.DeviceIdRegenerationHandler;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: task_key_update_all_save_collections */
public class NewAnalyticsSamplingPolicyConfig implements InjectableComponentWithoutContext {
    private static final String f3152a = NewAnalyticsSamplingPolicyConfig.class.getSimpleName();
    public AnalyticsLoggingPolicy f3153b;
    private ObjectMapper f3154c;
    private DeviceIdRegenerationHandler f3155d;
    public Provider<String> f3156e;
    public FbandroidAppInfoProvider f3157f;

    public static void m5315a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((NewAnalyticsSamplingPolicyConfig) obj).m5314a(AnalyticsLoggingPolicy.m2863a(injectorLike), DeviceIdRegenerationHandler.a(injectorLike), FbObjectMapperMethodAutoProvider.m6609a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4442), FbandroidAppInfoProvider.m5317b(injectorLike));
    }

    public NewAnalyticsSamplingPolicyConfig(Context context) {
        Class cls = NewAnalyticsSamplingPolicyConfig.class;
        m5315a(this, context);
    }

    @Inject
    private void m5314a(AnalyticsLoggingPolicy analyticsLoggingPolicy, DeviceIdRegenerationHandler deviceIdRegenerationHandler, ObjectMapper objectMapper, Provider<String> provider, FbandroidAppInfoProvider fbandroidAppInfoProvider) {
        this.f3153b = analyticsLoggingPolicy;
        this.f3154c = objectMapper;
        this.f3155d = deviceIdRegenerationHandler;
        this.f3156e = provider;
        this.f3157f = fbandroidAppInfoProvider;
    }

    public final void m5316a(InputStream inputStream) {
        JsonNode a = this.f3154c.m6635a(inputStream);
        if (a == null) {
            BLog.c(f3152a, "No content from Http response");
            return;
        }
        JsonNode b = a.mo709b("checksum");
        JsonNode b2 = a.mo709b("config");
        if (b == null || b2 == null) {
            BLog.c(f3152a, "Incomplete response: %s", new Object[]{a.toString()});
            return;
        }
        this.f3153b.m2872a(new AnalyticsServerResponse(b.mo719B(), b2.mo719B(), a.mo709b("app_data") == null ? null : a.mo709b("app_data").mo719B()));
        b = a.mo709b("app_data");
        if (b != null) {
            b = this.f3154c.m6636a(b.mo719B()).mo709b("pigeon_internal");
            if (b != null && b.mo709b("regenerate_deviceid") != null) {
                this.f3155d.a();
            }
        }
    }
}
