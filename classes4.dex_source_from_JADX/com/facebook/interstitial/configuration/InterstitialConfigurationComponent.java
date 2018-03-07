package com.facebook.interstitial.configuration;

import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.auth.component.persistent.PersistentComponent;
import com.facebook.auth.component.persistent.PersistentComponent.ComponentType;
import com.facebook.common.build.BuildConstants;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.config.background.ConfigurationComponent;
import com.facebook.crudolib.prefs.LightSharedPreferences;
import com.facebook.crudolib.prefs.LightSharedPreferencesFactory;
import com.facebook.crudolib.prefs.LightSharedPreferencesImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.analytics.InterstitialAnalyticsLogger;
import com.facebook.interstitial.api.FetchInterstitialResult;
import com.facebook.interstitial.api.FetchInterstitialsMethod;
import com.facebook.interstitial.api.FetchInterstitialsParams;
import com.facebook.interstitial.manager.InterstitialControllersHolder;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialRepository;
import com.facebook.interstitial.omnistore.InterstitialConfigurationOmnistoreSubscriber;
import com.facebook.interstitial.prefs.InterstitialPrefKeys;
import com.facebook.prefs.light.LightSharedPreferencesFactoryMethodAutoProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;
import javax.inject.Provider;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: supported_fb4a_locales */
public class InterstitialConfigurationComponent implements PersistentComponent, ConfigurationComponent {
    private final GatekeeperStoreImpl f1553a;
    public final Lazy<FetchInterstitialsMethod> f1554b;
    public final Lazy<InterstitialManager> f1555c;
    public final Lazy<InterstitialControllersHolder> f1556d;
    public final Lazy<InterstitialAnalyticsLogger> f1557e;
    public final boolean f1558f;
    private final Provider<InterstitialConfigurationOmnistoreSubscriber> f1559g;
    private final Provider<String> f1560h;
    public final FbSharedPreferences f1561i;
    private final LightSharedPreferencesFactory f1562j;
    private final Lazy<InterstitialRepository> f1563k;

    /* compiled from: supported_fb4a_locales */
    class InterstitialsBatchComponent implements BatchComponent {
        final /* synthetic */ InterstitialConfigurationComponent f1564a;
        private final boolean f1565b;

        public InterstitialsBatchComponent(InterstitialConfigurationComponent interstitialConfigurationComponent, boolean z) {
            this.f1564a = interstitialConfigurationComponent;
            this.f1565b = z;
        }

        public final Iterable<BatchOperation> mo99a() {
            Collection b;
            if (this.f1565b && this.f1564a.f1558f) {
                b = ((InterstitialControllersHolder) this.f1564a.f1556d.get()).b();
            } else {
                b = ((InterstitialControllersHolder) this.f1564a.f1556d.get()).a();
            }
            Builder a = BatchOperation.m12541a((ApiMethod) this.f1564a.f1554b.get(), new FetchInterstitialsParams(ImmutableList.copyOf(b)));
            a.f11927c = "fetch_interstititals";
            BatchOperation a2 = a.m12549a();
            HoneyClientEventFast a3 = ((InterstitialAnalyticsLogger) this.f1564a.f1557e.get()).a.a("interstitials_configuration_fetch_start", false);
            if (a3.a()) {
                a3.b();
            }
            InterstitialAnalyticsLogger interstitialAnalyticsLogger = (InterstitialAnalyticsLogger) this.f1564a.f1557e.get();
            interstitialAnalyticsLogger.b.b(FunnelRegistry.f, "nux_eligibility_start");
            interstitialAnalyticsLogger.b.b(FunnelRegistry.g, "nux_eligibility_start");
            return ImmutableList.of(a2);
        }

        public final void mo100a(Map<String, Object> map) {
            List list = (List) map.get("fetch_interstititals");
            if (list != null) {
                ((InterstitialManager) this.f1564a.f1555c.get()).a(list);
                InterstitialAnalyticsLogger interstitialAnalyticsLogger = (InterstitialAnalyticsLogger) this.f1564a.f1557e.get();
                interstitialAnalyticsLogger.b.b(FunnelRegistry.f, "nux_eligibility_finish");
                interstitialAnalyticsLogger.b.b(FunnelRegistry.g, "nux_eligibility_finish");
            }
        }
    }

    public static InterstitialConfigurationComponent m1771b(InjectorLike injectorLike) {
        return new InterstitialConfigurationComponent(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 2354), IdBasedSingletonScopeProvider.b(injectorLike, 2360), IdBasedLazy.a(injectorLike, 2358), IdBasedSingletonScopeProvider.b(injectorLike, 2353), ProductMethodAutoProvider.b(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 2362), IdBasedProvider.a(injectorLike, 4442), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), LightSharedPreferencesFactoryMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2361));
    }

    @Inject
    public InterstitialConfigurationComponent(GatekeeperStore gatekeeperStore, Lazy<FetchInterstitialsMethod> lazy, Lazy<InterstitialManager> lazy2, Lazy<InterstitialControllersHolder> lazy3, Lazy<InterstitialAnalyticsLogger> lazy4, Product product, Provider<InterstitialConfigurationOmnistoreSubscriber> provider, Provider<String> provider2, FbSharedPreferences fbSharedPreferences, LightSharedPreferencesFactory lightSharedPreferencesFactory, Lazy<InterstitialRepository> lazy5) {
        boolean z;
        this.f1553a = gatekeeperStore;
        this.f1554b = lazy;
        this.f1555c = lazy2;
        this.f1556d = lazy3;
        this.f1557e = lazy4;
        if (product != Product.FB4A || BuildConstants.j) {
            z = false;
        } else {
            z = true;
        }
        this.f1558f = z;
        this.f1559g = provider;
        this.f1560h = provider2;
        this.f1561i = fbSharedPreferences;
        this.f1562j = lightSharedPreferencesFactory;
        this.f1563k = lazy5;
    }

    public final void mo94a() {
        boolean z = false;
        if (this.f1558f) {
            LightSharedPreferencesImpl f = m1772f();
            Editor edit = this.f1561i.edit();
            if (m1770a(f, edit) || f.a("data_stored", false)) {
                z = true;
            }
            edit.putBoolean(InterstitialPrefKeys.f, z);
            edit.commit();
        }
    }

    public final boolean cn_() {
        if (this.f1558f) {
            return this.f1561i.a(InterstitialPrefKeys.f, false);
        }
        return false;
    }

    public final BatchComponent mo95c() {
        return new InterstitialsBatchComponent(this, true);
    }

    public final void mo97d() {
        if (this.f1558f) {
            LightSharedPreferences.Editor b = m1772f().b();
            b.a();
            Collection<String> b2 = ((InterstitialControllersHolder) this.f1556d.get()).b();
            if (!b2.isEmpty()) {
                for (String str : b2) {
                    Object a = this.f1561i.a(InterstitialPrefKeys.a(str), null);
                    if (!TextUtils.isEmpty(a)) {
                        b.a(str, a);
                        PrefKey b3 = InterstitialPrefKeys.b(str);
                        if (this.f1561i.a(b3)) {
                            b.a("last_impression/" + str, this.f1561i.a(b3, 0));
                        }
                    }
                }
            }
            b.a("data_stored", true);
            b.b();
        }
    }

    public final ComponentType mo98e() {
        return ComponentType.OTHER;
    }

    public final BatchComponent mo101b() {
        if (this.f1553a.a(272, false)) {
            return null;
        }
        return new InterstitialsBatchComponent(this, false);
    }

    public final long co_() {
        return 7200000;
    }

    private boolean m1770a(LightSharedPreferencesImpl lightSharedPreferencesImpl, Editor editor) {
        Collection<String> b = ((InterstitialControllersHolder) this.f1556d.get()).b();
        if (b.isEmpty()) {
            return true;
        }
        List arrayList = new ArrayList(b.size());
        Map hashMap = new HashMap(b.size());
        for (String str : b) {
            Object a = lightSharedPreferencesImpl.a(str, null);
            if (!TextUtils.isEmpty(a)) {
                try {
                    Parcelable parcelable;
                    JSONObject jSONObject = new JSONObject(a);
                    int i = jSONObject.getInt("rank");
                    String optString = jSONObject.optString("nux_id");
                    long j = jSONObject.getLong("fetchTimeMs");
                    if (TextUtils.isEmpty(jSONObject.optString("nux_data"))) {
                        parcelable = null;
                    } else {
                        parcelable = ((InterstitialRepository) this.f1563k.get()).a(jSONObject.getString("nux_data"), str);
                    }
                    arrayList.add(new FetchInterstitialResult(i, optString, parcelable, j));
                    String str2 = "last_impression/" + str;
                    if (lightSharedPreferencesImpl.a(str2)) {
                        hashMap.put(str, Long.valueOf(lightSharedPreferencesImpl.a(str2, 0)));
                    }
                } catch (JSONException e) {
                }
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        ((InterstitialManager) this.f1555c.get()).a(arrayList);
        if (!hashMap.isEmpty()) {
            for (Entry entry : hashMap.entrySet()) {
                editor.a(InterstitialPrefKeys.b((String) entry.getKey()), ((Long) entry.getValue()).longValue());
            }
        }
        return true;
    }

    private LightSharedPreferencesImpl m1772f() {
        return this.f1562j.a("interstitial_" + ((String) this.f1560h.get()));
    }
}
