package com.facebook.abtest.qe.service;

import com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCache;
import com.facebook.abtest.qe.bootstrap.data.QuickExperimentInfo;
import com.facebook.abtest.qe.bootstrap.data.QuickExperimentInfo.Builder;
import com.facebook.abtest.qe.bootstrap.db.DataSource;
import com.facebook.abtest.qe.cache.QuickExperimentMemoryCacheImpl;
import com.facebook.abtest.qe.data.QuickExperimentConfigPrefKeys;
import com.facebook.abtest.qe.db.ReadExperimentsHandler;
import com.facebook.abtest.qe.db.WriteExperimentsHandler;
import com.facebook.abtest.qe.log.RecentUIDsUtil;
import com.facebook.abtest.qe.multiprocess.QuickExperimentBroadcastManager;
import com.facebook.abtest.qe.protocol.sync.SyncMultiQuickExperimentParams;
import com.facebook.abtest.qe.protocol.sync.SyncQuickExperimentParams;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryModels.ConfigurationEdgeModel;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryModels.ConfigurationModel;
import com.facebook.abtest.qe.protocol.sync.user.SyncMultiQuickExperimentUserInfoMethod;
import com.facebook.abtest.qe.protocol.sync.user.SyncMultiQuickExperimentUserInfoResult;
import com.facebook.abtest.qe.protocol.sync.user.SyncQuickExperimentUserInfoResult;
import com.facebook.abtest.qe.sessionlessqe.SessionlessQuickExperimentConfigPrefKeys;
import com.facebook.abtest.qe.utils.LocaleUtil;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.qe.api.manager.Authority;
import com.facebook.qe.api.manager.QeManager;
import com.facebook.qe.api.manager.SyncedExperimentData;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: thumbnail_uri */
public class QuickExperimentDataMaintenanceHelper {
    private static final Class<QuickExperimentDataMaintenanceHelper> f1050a = QuickExperimentDataMaintenanceHelper.class;
    private final Provider<String> f1051b;
    private final Provider<String> f1052c;
    private final FbSharedPreferences f1053d;
    private final SyncMultiQuickExperimentUserInfoMethod f1054e;
    private final Lazy<ViewerConfigurationMethod> f1055f;
    private final Provider<Boolean> f1056g;
    public final QuickExperimentMemoryCache f1057h;
    private final WriteExperimentsHandler f1058i;
    private final QuickExperimentBroadcastManager f1059j;
    private final Clock f1060k;
    private final LocaleUtil f1061l;
    private final RecentUIDsUtil f1062m;
    private final AbstractFbErrorReporter f1063n;
    private final ReadExperimentsHandler f1064o;
    public final Lazy<QeManager> f1065p;
    private final UniqueIdForDeviceHolderImpl f1066q;
    private final Lazy<FbObjectMapper> f1067r;

    /* compiled from: thumbnail_uri */
    public class C00841 implements BatchComponent {
        final /* synthetic */ boolean f1534a;
        final /* synthetic */ QuickExperimentDataMaintenanceHelper f1535b;

        public C00841(QuickExperimentDataMaintenanceHelper quickExperimentDataMaintenanceHelper, boolean z) {
            this.f1535b = quickExperimentDataMaintenanceHelper;
            this.f1534a = z;
        }

        public final Iterable<BatchOperation> mo99a() {
            return ImmutableList.copyOf(this.f1535b.m1360b(false));
        }

        public final void mo100a(Map<String, Object> map) {
            this.f1535b.m1359a((Map) map, false);
        }
    }

    public static QuickExperimentDataMaintenanceHelper m1355b(InjectorLike injectorLike) {
        return new QuickExperimentDataMaintenanceHelper(IdBasedProvider.a(injectorLike, 4442), IdBasedProvider.a(injectorLike, 4437), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), SyncMultiQuickExperimentUserInfoMethod.m1361a(injectorLike), IdBasedLazy.a(injectorLike, 4566), IdBasedProvider.a(injectorLike, 3870), (QuickExperimentMemoryCache) QuickExperimentMemoryCacheImpl.a(injectorLike), WriteExperimentsHandler.m1369a(injectorLike), QuickExperimentBroadcastManager.m1382a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), LocaleUtil.a(injectorLike), RecentUIDsUtil.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ReadExperimentsHandler.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3219), UniqueIdForDeviceHolderMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 572));
    }

    @Inject
    public QuickExperimentDataMaintenanceHelper(Provider<String> provider, Provider<String> provider2, FbSharedPreferences fbSharedPreferences, SyncMultiQuickExperimentUserInfoMethod syncMultiQuickExperimentUserInfoMethod, Lazy<ViewerConfigurationMethod> lazy, Provider<Boolean> provider3, QuickExperimentMemoryCache quickExperimentMemoryCache, WriteExperimentsHandler writeExperimentsHandler, QuickExperimentBroadcastManager quickExperimentBroadcastManager, Clock clock, LocaleUtil localeUtil, RecentUIDsUtil recentUIDsUtil, FbErrorReporter fbErrorReporter, ReadExperimentsHandler readExperimentsHandler, Lazy<QeManager> lazy2, UniqueIdForDeviceHolder uniqueIdForDeviceHolder, Lazy<FbObjectMapper> lazy3) {
        this.f1051b = provider;
        this.f1052c = provider2;
        this.f1053d = fbSharedPreferences;
        this.f1054e = syncMultiQuickExperimentUserInfoMethod;
        this.f1055f = lazy;
        this.f1056g = provider3;
        this.f1057h = quickExperimentMemoryCache;
        this.f1058i = writeExperimentsHandler;
        this.f1059j = quickExperimentBroadcastManager;
        this.f1060k = clock;
        this.f1061l = localeUtil;
        this.f1062m = recentUIDsUtil;
        this.f1063n = fbErrorReporter;
        this.f1064o = readExperimentsHandler;
        this.f1065p = lazy2;
        this.f1066q = uniqueIdForDeviceHolder;
        this.f1067r = lazy3;
    }

    @VisibleForTesting
    private static QuickExperimentInfo m1349a(@Nullable SyncQuickExperimentUserInfoResult syncQuickExperimentUserInfoResult, String str) {
        if (syncQuickExperimentUserInfoResult == null) {
            return null;
        }
        String str2 = syncQuickExperimentUserInfoResult.f1120e;
        if (Strings.isNullOrEmpty(str2)) {
            str2 = "";
        }
        Builder h = new Builder().e(syncQuickExperimentUserInfoResult.f1116a).f(syncQuickExperimentUserInfoResult.f1117b).g(str2).c(syncQuickExperimentUserInfoResult.f1118c).d(syncQuickExperimentUserInfoResult.f1119d).h(str);
        h.g = syncQuickExperimentUserInfoResult.m1387f();
        return h.a();
    }

    public final Collection<BatchOperation> m1360b(boolean z) {
        String str;
        boolean z2 = true;
        String str2 = (String) this.f1052c.get();
        if (z) {
            String a = this.f1066q.a();
            Preconditions.checkState(a != null, "Device Id must be available");
            str = a;
        } else {
            str = (String) this.f1051b.get();
            if (str == null || str2 == null) {
                z2 = false;
            }
            Preconditions.checkState(z2, "UID an UID Hash must be available");
        }
        m1353a(str2, z);
        return m1356b(str, z);
    }

    private void m1353a(String str, boolean z) {
        if (z) {
            m1352a(SessionlessQuickExperimentConfigPrefKeys.f13088b, SessionlessQuickExperimentConfigPrefKeys.f13089c);
            return;
        }
        m1352a(QuickExperimentConfigPrefKeys.f12799c, QuickExperimentConfigPrefKeys.f12800d);
        Editor edit = this.f1053d.edit();
        edit.a(QuickExperimentConfigPrefKeys.f12798b, RecentUIDsUtil.a(RecentUIDsUtil.a(str, this.f1062m.a())));
        edit.commit();
    }

    private void m1352a(PrefKey prefKey, PrefKey prefKey2) {
        Editor edit = this.f1053d.edit();
        edit.a(prefKey, this.f1060k.a());
        edit.a(prefKey2, LocaleUtil.a());
        edit.commit();
    }

    private ArrayList<BatchOperation> m1356b(String str, boolean z) {
        Iterable e;
        ArrayList<BatchOperation> a = Lists.a();
        SyncMultiQuickExperimentParams.Builder builder = new SyncMultiQuickExperimentParams.Builder();
        builder.f1104a = str;
        builder = builder;
        builder.f1107d = z;
        SyncMultiQuickExperimentParams.Builder builder2 = builder;
        if (z) {
            e = ((QeManager) this.f1065p.get()).e();
        } else {
            e = ((QeManager) this.f1065p.get()).d();
        }
        ImmutableSet b = ImmutableSet.builder().b(e).b();
        if (b.isEmpty()) {
            return a;
        }
        ImmutableList.Builder builder3 = ImmutableList.builder();
        Iterator it = b.iterator();
        while (it.hasNext()) {
            String str2;
            String str3 = (String) it.next();
            if (z) {
                str2 = null;
            } else {
                String c;
                if (((QeManager) this.f1065p.get()).b(str3)) {
                    c = ((QeManager) this.f1065p.get()).c(Authority.ASSIGNED, str3);
                } else {
                    QuickExperimentInfo a2 = this.f1057h.a(str3, DataSource.FROM_SERVER);
                    c = a2 == null ? null : a2.b;
                }
                str2 = c;
            }
            if (str2 == null) {
                str2 = "";
            }
            builder2.f1105b.c(new SyncQuickExperimentParams(str3, str2));
            if (((Boolean) this.f1056g.get()).booleanValue()) {
                builder3.c("qe_" + str3);
            }
        }
        ApiMethod apiMethod = this.f1054e;
        builder2.f1106c = builder2.f1105b.b();
        a.add(m1350a("sync_user_experiments", apiMethod, (Object) new SyncMultiQuickExperimentParams(builder2)));
        if (!z && ((Boolean) this.f1056g.get()).booleanValue()) {
            a.add(m1350a("sync_meta", (ApiMethod) this.f1055f.get(), builder3.b()));
        }
        return a;
    }

    private static <K, V> BatchOperation m1350a(String str, ApiMethod<K, V> apiMethod, K k) {
        BatchOperation.Builder a = BatchOperation.m12541a(apiMethod, k);
        a.f11927c = str;
        return a.m12549a();
    }

    private void m1354a(Map<String, SyncQuickExperimentUserInfoResult> map, Map<String, String> map2, boolean z) {
        Map hashMap = new HashMap();
        String a = LocaleUtil.a();
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList.Builder builder2 = ImmutableList.builder();
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            QuickExperimentInfo a2 = m1349a((SyncQuickExperimentUserInfoResult) entry.getValue(), a);
            if (a2 != null) {
                if (((QeManager) this.f1065p.get()).b(str)) {
                    builder2.c(a2);
                } else {
                    builder.c(a2);
                }
                hashMap.put(str, (String) map2.remove(str));
            }
        }
        for (String a3 : map2.keySet()) {
            QuickExperimentInfo a4 = this.f1057h.a(a3, DataSource.FROM_SERVER);
            if (a4 != null) {
                Builder h = new Builder().e(a4.a).f(a4.e).g(a4.b).c(a4.c).d(a4.d).h(a);
                h.g = a4.g;
                builder.c(h.a());
            }
        }
        Collection b = builder.b();
        ((QeManager) this.f1065p.get()).a(m1351a(builder2.b()), z);
        this.f1058i.m1373a(b, Iterables.b(hashMap.entrySet(), map2.entrySet()), DataSource.FROM_SERVER);
        m1358a();
    }

    public final void m1358a() {
        if (((Boolean) this.f1056g.get()).booleanValue()) {
            this.f1057h.c();
        } else {
            this.f1057h.b();
        }
        this.f1059j.m1384a(false);
    }

    private static Map<String, SyncedExperimentData> m1351a(Collection<QuickExperimentInfo> collection) {
        Map<String, SyncedExperimentData> hashMap = new HashMap();
        for (QuickExperimentInfo quickExperimentInfo : collection) {
            hashMap.put(quickExperimentInfo.a, quickExperimentInfo);
        }
        return hashMap;
    }

    public final void m1359a(Map<String, Object> map, boolean z) {
        Map map2;
        Map hashMap = new HashMap();
        SyncMultiQuickExperimentUserInfoResult syncMultiQuickExperimentUserInfoResult = (SyncMultiQuickExperimentUserInfoResult) map.get("sync_user_experiments");
        if (syncMultiQuickExperimentUserInfoResult == null) {
            map2 = hashMap;
        } else {
            ArrayList arrayList = syncMultiQuickExperimentUserInfoResult.f1123a;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                SyncQuickExperimentUserInfoResult syncQuickExperimentUserInfoResult = (SyncQuickExperimentUserInfoResult) arrayList.get(i);
                if (syncQuickExperimentUserInfoResult != null) {
                    hashMap.put(syncQuickExperimentUserInfoResult.f1116a, syncQuickExperimentUserInfoResult);
                }
            }
            map2 = hashMap;
        }
        m1354a(map2, m1357b((Map) map), z);
    }

    private Map<String, String> m1357b(Map<String, Object> map) {
        Map<String, String> hashMap = new HashMap();
        ImmutableList immutableList = (ImmutableList) map.get("sync_meta");
        if (immutableList == null) {
            return hashMap;
        }
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ConfigurationEdgeModel configurationEdgeModel = (ConfigurationEdgeModel) immutableList.get(i);
            if (!(configurationEdgeModel.a() == null || configurationEdgeModel.a().o() == null)) {
                ConfigurationModel a;
                ConfigurationModel a2 = configurationEdgeModel.a();
                if (configurationEdgeModel.a().o().startsWith("qe_")) {
                    a = ConfigurationModel.Builder.a(configurationEdgeModel.a()).a(configurationEdgeModel.a().o().substring(3)).a();
                } else {
                    a = a2;
                }
                try {
                    hashMap.put(a.o(), ((FbObjectMapper) this.f1067r.get()).a(a));
                } catch (Throwable e) {
                    this.f1063n.a("qe_write_json_failed", "node name: " + configurationEdgeModel.a().o(), e);
                }
            }
        }
        return hashMap;
    }
}
