package com.facebook.attribution;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.attribution.AttributionIdUpdate.Params;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor_DefaultIdleExecutorMethodAutoProvider;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.oxygen.preloads.sdk.firstparty.attribution.AttributionContract;
import com.facebook.tools.dextr.runtime.detour.ServiceConnectionDetour;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.HashMap;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: messenger_new_user_notifications */
public class AttributionIdService extends FbIntentService {
    private static final Uri f13846a = Uri.parse("content://" + AttributionContract.f13864a);
    private AbstractFbErrorReporter f13847b;
    private Provider<String> f13848c;
    private DefaultProcessIdleExecutor f13849d;
    private AbstractSingleMethodRunner f13850e;
    private AttributionIdUpdate f13851f;
    private Clock f13852g;
    private XConfigReader f13853h;
    private PackageManager f13854i;
    private AnalyticsLogger f13855j;
    private ObjectMapper f13856k;
    private ContentResolver f13857l;

    public AttributionIdService() {
        super("AttributionIdService");
    }

    public static void m20243a(Context context, long j) {
        if (!BuildConstants.g()) {
            Intent intent = new Intent(context, AttributionIdService.class);
            intent.putExtra("user_id", j);
            try {
                context.startService(intent);
            } catch (Exception e) {
            }
        }
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -9837013);
        super.onCreate();
        Context applicationContext = getApplicationContext();
        AppInitLockHelper.m8874a(applicationContext);
        this.f13854i = applicationContext.getPackageManager();
        this.f13857l = applicationContext.getContentResolver();
        InjectorLike injectorLike = FbInjector.get(this);
        this.f13847b = FbErrorReporterImpl.m2317a(injectorLike);
        this.f13848c = IdBasedProvider.m1811a(injectorLike, 4442);
        this.f13849d = IdleExecutor_DefaultIdleExecutorMethodAutoProvider.m2724a(injectorLike);
        this.f13850e = SingleMethodRunnerImpl.m11724a(injectorLike);
        this.f13852g = SystemClockMethodAutoProvider.m1498a(injectorLike);
        this.f13853h = XConfigReader.m2681a(injectorLike);
        this.f13855j = AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike);
        this.f13856k = FbObjectMapperMethodAutoProvider.m6609a(injectorLike);
        this.f13851f = new AttributionIdUpdate(this.f13852g);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -1786887289, a);
    }

    protected final void mo2677a(Intent intent) {
        int i = 1;
        try {
            AttributionState a;
            long longExtra = intent.getLongExtra("user_id", 0);
            CharSequence charSequence = (String) this.f13848c.get();
            try {
                a = AttributionStateSerializer.m21435a(getApplicationContext());
            } catch (Exception e) {
                a = null;
            }
            int a2 = this.f13853h.m2683a(AttributionIdXConfig.f15036c, 1);
            if (a2 > 0) {
                i = a2;
            }
            if (!StringUtil.m3589a(charSequence) && Long.parseLong(charSequence) == longExtra) {
                if (a != null && a.f14988b == longExtra) {
                    if (this.f13852g.mo211a() <= (((long) i) * 3600000) + a.f14989c) {
                        return;
                    }
                }
                this.f13849d.mo269a(new 1(this, longExtra, a != null ? a.f14991e : null));
            }
        } catch (Throwable e2) {
            this.f13847b.m2343a("AttributionRefresh", "failure processing refresh", e2);
        }
    }

    private void m20242a(long j, String str) {
        Info info;
        Throwable e;
        AttributionState attributionState;
        boolean z = true;
        Context applicationContext = getApplicationContext();
        String a = UniqueIdForDeviceHolderMethodAutoProvider.m4339b(FbInjector.get(applicationContext)).m4346a();
        if (a == null) {
            this.f13847b.m2340a("uniqueIdForDevice null", "AttributionIdUpdate get uniqueIdForDevice null");
            return;
        }
        int i = 0;
        try {
            if (GooglePlayServicesUtil.m153a(applicationContext) == 0) {
                i = AdvertisingIdClient.a(applicationContext);
            }
        } catch (Throwable e2) {
            this.f13847b.m2343a(getClass().getName(), "Failure while using gms sdk to read advertising id", e2);
        }
        if (i == 0) {
            try {
                GoogleAdServiceConnection googleAdServiceConnection = new GoogleAdServiceConnection();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (ServiceConnectionDetour.a(applicationContext, intent, googleAdServiceConnection, 1, -63395141)) {
                    try {
                        GoogleAdInfo googleAdInfo = new GoogleAdInfo(googleAdServiceConnection.a());
                        info = new Info(googleAdInfo.a(), googleAdInfo.b());
                        try {
                            ServiceConnectionDetour.a(applicationContext, googleAdServiceConnection, i);
                        } catch (Exception e3) {
                            e = e3;
                            this.f13847b.m2343a(getClass().getName(), "Failure acquiring gms id via interop.", e);
                            attributionState = (AttributionState) this.f13850e.m11743a(this.f13851f, new Params(SafeUUIDGenerator.m2795a().toString(), info, z, str, a, j, m20247b()));
                            AttributionStateSerializer.m21436a(applicationContext, attributionState);
                            m20245a(attributionState.f14992f);
                        }
                        attributionState = (AttributionState) this.f13850e.m11743a(this.f13851f, new Params(SafeUUIDGenerator.m2795a().toString(), info, z, str, a, j, m20247b()));
                        AttributionStateSerializer.m21436a(applicationContext, attributionState);
                        m20245a(attributionState.f14992f);
                    } finally {
                        z = true;
                        ServiceConnectionDetour.a(applicationContext, googleAdServiceConnection, 985585925);
                    }
                }
            } catch (Throwable e22) {
                z = false;
                Throwable th = e22;
                info = i;
                e = th;
                this.f13847b.m2343a(getClass().getName(), "Failure acquiring gms id via interop.", e);
                attributionState = (AttributionState) this.f13850e.m11743a(this.f13851f, new Params(SafeUUIDGenerator.m2795a().toString(), info, z, str, a, j, m20247b()));
                AttributionStateSerializer.m21436a(applicationContext, attributionState);
                m20245a(attributionState.f14992f);
            }
        }
        z = false;
        info = i;
        try {
            attributionState = (AttributionState) this.f13850e.m11743a(this.f13851f, new Params(SafeUUIDGenerator.m2795a().toString(), info, z, str, a, j, m20247b()));
            AttributionStateSerializer.m21436a(applicationContext, attributionState);
            m20245a(attributionState.f14992f);
        } catch (Exception e4) {
        }
    }

    @Nullable
    private String m20247b() {
        Throwable e;
        Cursor query;
        try {
            query = this.f13857l.query(f13846a, null, null, null, null);
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            try {
                if (query.moveToFirst()) {
                    int columnIndex = query.getColumnIndex("attribution_json");
                    if (columnIndex < 0) {
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    }
                    String string = query.getString(columnIndex);
                    if (query == null) {
                        return string;
                    }
                    query.close();
                    return string;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    this.f13847b.m2343a(getClass().getName(), "Failure acquiring oxygen attribution.", e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (query != null) {
                        query.close();
                    }
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            this.f13847b.m2343a(getClass().getName(), "Failure acquiring oxygen attribution.", e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
    }

    private void m20245a(JsonNode jsonNode) {
        if (jsonNode != null) {
            Iterator j = jsonNode.mo714j();
            Object hashMap = new HashMap();
            while (j.hasNext()) {
                String str = (String) j.next();
                JsonNode b = jsonNode.mo709b(str);
                if (b != null && b.m5196h()) {
                    boolean z;
                    Iterator it = b.iterator();
                    while (it.hasNext()) {
                        if (m20246a(((JsonNode) it.next()).mo728s())) {
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    hashMap.put(str, Boolean.valueOf(z));
                }
            }
            if (!hashMap.keySet().isEmpty()) {
                HoneyAnalyticsEvent a = new HoneyClientEvent("app_presence").m5085a("app_presence", (JsonNode) this.f13856k.m6654a(hashMap, JsonNode.class));
                a.f3099c = "native_newsfeed";
                this.f13855j.mo526a(a);
            }
        }
    }

    private boolean m20246a(String str) {
        try {
            this.f13854i.getPackageInfo(str, 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
