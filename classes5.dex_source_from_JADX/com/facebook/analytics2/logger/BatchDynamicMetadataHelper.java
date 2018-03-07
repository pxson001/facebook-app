package com.facebook.analytics2.logger;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.analytics.NewAnalyticsSamplingPolicyConfig;
import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.crudolib.params.ParamsCollectionPool;
import com.facebook.crudolib.params.ParamsJsonEncoder;
import com.facebook.infer.annotation.Assertions;
import java.io.Writer;
import javax.annotation.Nullable;

/* compiled from: thread_stack */
class BatchDynamicMetadataHelper {
    private final ParamsCollectionPool f1974a;
    private final RequestInfo f1975b;
    @Nullable
    private final Config f1976c;

    /* compiled from: thread_stack */
    class Config {
        private final NewAnalyticsSamplingPolicyConfig f1971a;

        public Config(NewAnalyticsSamplingPolicyConfig newAnalyticsSamplingPolicyConfig) {
            this.f1971a = (NewAnalyticsSamplingPolicyConfig) Assertions.b(newAnalyticsSamplingPolicyConfig);
        }

        public final void m2636a(ParamsCollectionMap paramsCollectionMap) {
            paramsCollectionMap.a("config_checksum", this.f1971a.b.a());
            NewAnalyticsSamplingPolicyConfig newAnalyticsSamplingPolicyConfig = this.f1971a;
            paramsCollectionMap.a("config_version", "v2");
        }

        public final void m2637b(ParamsCollectionMap paramsCollectionMap) {
            paramsCollectionMap.a("uid", (String) this.f1971a.e.get());
            paramsCollectionMap.a("app_ver", this.f1971a.f.b());
        }
    }

    /* compiled from: thread_stack */
    class RequestInfo {
        private final Context f1972a;
        private final String f1973b;

        public RequestInfo(Context context, String str) {
            this.f1972a = context.getApplicationContext();
            this.f1973b = str;
        }

        public final void m2638a(ParamsCollectionMap paramsCollectionMap) {
            paramsCollectionMap.a("tier", this.f1973b);
            paramsCollectionMap.a("sent_time", Double.valueOf(((double) System.currentTimeMillis()) / 1000.0d));
            String networkOperatorName = ((TelephonyManager) this.f1972a.getSystemService("phone")).getNetworkOperatorName();
            String str = "carrier";
            if (TextUtils.isEmpty(networkOperatorName)) {
                networkOperatorName = "n/a";
            }
            paramsCollectionMap.a(str, networkOperatorName);
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f1972a.getSystemService("connectivity")).getActiveNetworkInfo();
            paramsCollectionMap.a("conn", activeNetworkInfo != null ? activeNetworkInfo.getTypeName() : "none");
        }
    }

    public BatchDynamicMetadataHelper(Context context, ParamsCollectionPool paramsCollectionPool, String str, @Nullable NewAnalyticsSamplingPolicyConfig newAnalyticsSamplingPolicyConfig) {
        this.f1974a = paramsCollectionPool;
        this.f1975b = new RequestInfo(context, str);
        this.f1976c = newAnalyticsSamplingPolicyConfig != null ? new Config(newAnalyticsSamplingPolicyConfig) : null;
    }

    public final void m2639a(Writer writer) {
        ParamsCollectionMap b = this.f1974a.b();
        try {
            this.f1975b.m2638a(b);
            if (this.f1976c != null) {
                this.f1976c.m2636a(b);
            }
            ParamsJsonEncoder.a().b(writer, b);
        } finally {
            b.a();
        }
    }

    public final void m2640b(Writer writer) {
        ParamsCollectionMap b = this.f1974a.b();
        try {
            this.f1975b.m2638a(b.b("request_info"));
            if (this.f1976c != null) {
                ParamsCollectionMap b2 = b.b("config");
                this.f1976c.m2636a(b2);
                this.f1976c.m2637b(b2);
            }
            ParamsJsonEncoder.a().b(writer, b);
        } finally {
            b.a();
        }
    }
}
