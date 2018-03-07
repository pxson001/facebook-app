package com.facebook.directinstall;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.uri.NativeAppDetails;
import com.facebook.common.uri.NativeAppDetails.Screenshot;
import com.facebook.common.uri.NativeUri;
import com.facebook.directinstall.appdetails.AppDetailsActivity;
import com.facebook.directinstall.experiments.DirectInstallConfig;
import com.facebook.directinstall.experiments.ExperimentsForDirectInstallExperimentsModule;
import com.facebook.directinstall.feed.InstallDialogActivity;
import com.facebook.directinstall.intent.DirectInstallAppData;
import com.facebook.directinstall.intent.DirectInstallAppData.DownloadConnectivityPolicy;
import com.facebook.directinstall.intent.DirectInstallAppDescriptor;
import com.facebook.directinstall.intent.DirectInstallAppDetails;
import com.facebook.directinstall.intent.DirectInstallAppDetails.Builder;
import com.facebook.directinstall.intent.DirectInstallAppDetails.TextWithEntities;
import com.facebook.directinstall.intent.DirectInstallIntentUtils;
import com.facebook.directinstall.logging.DirectInstallLogger;
import com.facebook.graphql.enums.GraphQLAppStoreDownloadConnectivityPolicy;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: only_me_sticky */
public class DirectInstallIntentHelper {
    public static final String f8671a = DirectInstallIntentHelper.class.getSimpleName();
    private final ObjectMapper f8672b;
    private final DirectInstallLogger f8673c;
    private final PackageManager f8674d;
    private final FbNetworkManager f8675e;
    private final DirectInstallConfig f8676f;

    /* compiled from: only_me_sticky */
    final class C05721 implements Function<Screenshot, DirectInstallAppDetails.Screenshot> {
        C05721() {
        }

        @Nullable
        public final Object apply(@Nullable Object obj) {
            Screenshot screenshot = (Screenshot) obj;
            Preconditions.checkNotNull(screenshot);
            return new DirectInstallAppDetails.Screenshot(screenshot.a, screenshot.b, screenshot.c);
        }
    }

    /* compiled from: only_me_sticky */
    public /* synthetic */ class C05732 {
        public static final /* synthetic */ int[] f8670a = new int[GraphQLAppStoreDownloadConnectivityPolicy.values().length];

        static {
            try {
                f8670a[GraphQLAppStoreDownloadConnectivityPolicy.WIFI_FORCE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8670a[GraphQLAppStoreDownloadConnectivityPolicy.WIFI_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    @Inject
    public DirectInstallIntentHelper(ObjectMapper objectMapper, DirectInstallLogger directInstallLogger, PackageManager packageManager, FbNetworkManager fbNetworkManager, DirectInstallConfig directInstallConfig) {
        this.f8672b = objectMapper;
        this.f8673c = directInstallLogger;
        this.f8674d = packageManager;
        this.f8675e = fbNetworkManager;
        this.f8676f = directInstallConfig;
    }

    public final Intent m12476a(Context context, NativeUri nativeUri) {
        Object obj;
        if (nativeUri.d != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        return m12471a(context, nativeUri.d, nativeUri.e, nativeUri.c);
    }

    @VisibleForTesting
    private Intent m12471a(Context context, NativeAppDetails nativeAppDetails, String str, ImmutableMap<String, Object> immutableMap) {
        if (!nativeAppDetails.a()) {
            this.f8673c.m12560a(nativeAppDetails, "application_data_not_valid");
            return null;
        } else if (m12475a(nativeAppDetails.e)) {
            this.f8673c.m12562b("neko_di_app_already_installed", nativeAppDetails, null);
            return null;
        } else if (!this.f8675e.d()) {
            this.f8673c.m12560a(nativeAppDetails, "network_not_connected");
            return null;
        } else if (this.f8676f.f8746a.a(ExperimentsForDirectInstallExperimentsModule.f8748b, false)) {
            this.f8673c.m12561a("dialogs", nativeAppDetails, immutableMap);
            return m12472a(InstallDialogActivity.class, context, nativeAppDetails, str, immutableMap);
        } else if (!this.f8676f.m12522b()) {
            return null;
        } else {
            this.f8673c.m12561a("app_details", nativeAppDetails, immutableMap);
            return m12472a(AppDetailsActivity.class, context, nativeAppDetails, str, immutableMap);
        }
    }

    private Intent m12472a(Class cls, Context context, NativeAppDetails nativeAppDetails, String str, ImmutableMap<String, Object> immutableMap) {
        Intent intent = new Intent(context, cls);
        DirectInstallIntentUtils.m12553a(intent, m12473a(nativeAppDetails));
        DirectInstallIntentUtils.m12555a(intent, str);
        Map hashMap = new HashMap();
        if (immutableMap != null) {
            hashMap.putAll(immutableMap);
        }
        ArrayNode arrayNode = (ArrayNode) hashMap.get("tracking");
        if (arrayNode != null) {
            hashMap.remove("tracking");
            try {
                hashMap.put("tracking", this.f8672b.a(arrayNode));
            } catch (JsonProcessingException e) {
            }
        }
        DirectInstallIntentUtils.m12554a(intent, ImmutableMap.copyOf(hashMap));
        return intent;
    }

    @VisibleForTesting
    private boolean m12475a(String str) {
        PackageInfo packageInfo = null;
        if (str != null) {
            try {
                packageInfo = this.f8674d.getPackageInfo(str, 0);
            } catch (NameNotFoundException e) {
                return false;
            }
        }
        if (packageInfo != null) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    private static DirectInstallAppData m12473a(NativeAppDetails nativeAppDetails) {
        DownloadConnectivityPolicy downloadConnectivityPolicy;
        switch (C05732.f8670a[nativeAppDetails.t.ordinal()]) {
            case 1:
                downloadConnectivityPolicy = DownloadConnectivityPolicy.WifiForce;
                break;
            case 2:
                downloadConnectivityPolicy = DownloadConnectivityPolicy.WifiOnly;
                break;
            default:
                downloadConnectivityPolicy = DownloadConnectivityPolicy.Any;
                break;
        }
        DownloadConnectivityPolicy downloadConnectivityPolicy2 = downloadConnectivityPolicy;
        DirectInstallAppDescriptor directInstallAppDescriptor = new DirectInstallAppDescriptor(nativeAppDetails.e, nativeAppDetails.k, nativeAppDetails.g, nativeAppDetails.c, nativeAppDetails.l);
        Builder builder = new Builder();
        builder.f8778a = nativeAppDetails.a;
        builder = builder;
        builder.f8779b = nativeAppDetails.b;
        builder = builder;
        builder.f8785h = nativeAppDetails.m;
        builder = builder;
        builder.f8781d = nativeAppDetails.h;
        builder = builder;
        builder.f8780c = nativeAppDetails.f;
        builder = builder;
        builder.f8786i = nativeAppDetails.p;
        builder = builder;
        builder.f8787j = nativeAppDetails.q;
        builder = builder;
        builder.f8784g = nativeAppDetails.j;
        builder = builder;
        builder.f8790m = m12474a(nativeAppDetails.u);
        builder = builder;
        builder.f8791n = m12474a(nativeAppDetails.v);
        Builder builder2 = builder;
        if (nativeAppDetails.w instanceof TextWithEntities) {
            builder2.f8788k = (TextWithEntities) nativeAppDetails.w;
        }
        if (nativeAppDetails.x instanceof TextWithEntities) {
            builder2.f8789l = (TextWithEntities) nativeAppDetails.x;
        }
        DirectInstallAppData.Builder builder3 = new DirectInstallAppData.Builder(directInstallAppDescriptor, builder2.m12543a(), downloadConnectivityPolicy2);
        builder3.f8766f = nativeAppDetails.o;
        builder3 = builder3;
        builder3.f8765e = nativeAppDetails.r;
        builder3 = builder3;
        builder3.f8764d = nativeAppDetails.i;
        return builder3.m12532a();
    }

    private static ImmutableList<DirectInstallAppDetails.Screenshot> m12474a(ImmutableList<Screenshot> immutableList) {
        return ImmutableList.copyOf(Lists.a(immutableList, new C05721()));
    }
}
