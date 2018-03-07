package com.facebook.abtest.qe.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.support.v7.widget.LinearLayoutCompat;
import android.widget.Toast;
import com.facebook.abtest.qe.annotations.IsUserTrustedWithQEInternals;
import com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCache;
import com.facebook.abtest.qe.bootstrap.data.BasicQuickExperimentInfo;
import com.facebook.abtest.qe.bootstrap.db.DataSource;
import com.facebook.abtest.qe.cache.QuickExperimentMemoryCacheImpl;
import com.facebook.abtest.qe.db.WriteExperimentsHandler;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryInterfaces.Configuration;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryInterfaces.ConfigurationParameterSetsConnection.Edges;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryModels.ConfigurationModel;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryModels.ConfigurationParameterSetsConnectionModel.EdgesModel;
import com.facebook.abtest.qe.settings.widget.QuickExperimentInfoPreference;
import com.facebook.base.activity.FbPreferenceActivity;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.manager.Authority;
import com.facebook.qe.api.manager.QeManager;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: top */
public class QuickExperimentViewActivity extends FbPreferenceActivity {
    @Inject
    QeManager f1833a;
    @Inject
    QuickExperimentMemoryCache f1834b;
    @Inject
    @IsUserTrustedWithQEInternals
    Provider<Boolean> f1835c;
    @Inject
    QuickExperimentUserOverride f1836d;
    @Inject
    QuickExperimentNameHelper f1837e;
    @Inject
    TasksManager f1838f;
    @DefaultExecutorService
    @Inject
    ListeningExecutorService f1839g;
    public String f1840h;
    private boolean f1841i;
    @Nullable
    public ConfigurationModel f1842j;

    /* compiled from: top */
    /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] f1819a = new int[Authority.values().length];

        static {
            try {
                f1819a[Authority.ASSIGNED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1819a[Authority.OVERRIDE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1819a[Authority.EFFECTIVE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: top */
    class C01181 implements Callable<Configuration> {
        final /* synthetic */ QuickExperimentViewActivity f1820a;

        C01181(QuickExperimentViewActivity quickExperimentViewActivity) {
            this.f1820a = quickExperimentViewActivity;
        }

        public Object call() {
            return this.f1820a.f1834b.a(this.f1820a.f1840h);
        }
    }

    /* compiled from: top */
    class C01192 extends AbstractDisposableFutureCallback<Configuration> {
        final /* synthetic */ QuickExperimentViewActivity f1821a;

        C01192(QuickExperimentViewActivity quickExperimentViewActivity) {
            this.f1821a = quickExperimentViewActivity;
        }

        protected final void m2507a(Object obj) {
            this.f1821a.f1842j = (ConfigurationModel) obj;
            QuickExperimentViewActivity.m2529d(this.f1821a);
        }

        protected final void m2508a(Throwable th) {
            throw Throwables.propagate(th);
        }
    }

    /* compiled from: top */
    class C01203 implements Function<Edges, String> {
        final /* synthetic */ QuickExperimentViewActivity f1822a;

        C01203(QuickExperimentViewActivity quickExperimentViewActivity) {
            this.f1822a = quickExperimentViewActivity;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            EdgesModel edgesModel = (EdgesModel) obj;
            if (edgesModel == null || edgesModel.m2420a() == null) {
                return "";
            }
            return edgesModel.m2420a().m2414a();
        }
    }

    /* compiled from: top */
    class C01214 implements OnPreferenceChangeListener {
        final /* synthetic */ QuickExperimentViewActivity f1823a;

        C01214(QuickExperimentViewActivity quickExperimentViewActivity) {
            this.f1823a = quickExperimentViewActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            if ("<Unset Override>".equals(obj)) {
                this.f1823a.m2520a(preference.getKey());
            } else if ("<Remove From Experiment>".equals(obj)) {
                this.f1823a.m2526b(preference.getKey());
            } else {
                this.f1823a.m2521a(preference.getKey(), (String) obj);
            }
            return true;
        }
    }

    /* compiled from: top */
    class C01225 implements OnPreferenceClickListener {
        final /* synthetic */ QuickExperimentViewActivity f1824a;

        C01225(QuickExperimentViewActivity quickExperimentViewActivity) {
            this.f1824a = quickExperimentViewActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            Toast.makeText(this.f1824a, "The meta data for this experiment is not fetched yet, please sync manually via the sync button on experiment list.", 10000).show();
            return true;
        }
    }

    /* compiled from: top */
    class C01269 extends AbstractDisposableFutureCallback<Void> {
        final /* synthetic */ QuickExperimentViewActivity f1832a;

        C01269(QuickExperimentViewActivity quickExperimentViewActivity) {
            this.f1832a = quickExperimentViewActivity;
        }

        protected final void m2509a(Object obj) {
            QuickExperimentViewActivity.m2529d(this.f1832a);
        }

        protected final void m2510a(Throwable th) {
            throw Throwables.propagate(th);
        }
    }

    private static <T extends Context> void m2518a(Class<T> cls, T t) {
        m2519a((Object) t, (Context) t);
    }

    public static void m2519a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((QuickExperimentViewActivity) obj).m2517a((QeManager) QeInternalImplMethodAutoProvider.a(injectorLike), (QuickExperimentMemoryCache) QuickExperimentMemoryCacheImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 3870), QuickExperimentUserOverride.m2501a(injectorLike), QuickExperimentNameHelper.m2486a(injectorLike), TasksManager.b(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    private void m2517a(QeManager qeManager, QuickExperimentMemoryCache quickExperimentMemoryCache, Provider<Boolean> provider, QuickExperimentUserOverride quickExperimentUserOverride, QuickExperimentNameHelper quickExperimentNameHelper, TasksManager tasksManager, ListeningExecutorService listeningExecutorService) {
        this.f1833a = qeManager;
        this.f1834b = quickExperimentMemoryCache;
        this.f1835c = provider;
        this.f1836d = quickExperimentUserOverride;
        this.f1837e = quickExperimentNameHelper;
        this.f1838f = tasksManager;
        this.f1839g = listeningExecutorService;
    }

    public static Intent m2511a(Context context, String str) {
        return new Intent(context, QuickExperimentViewActivity.class).putExtra("experiment_name", str);
    }

    public final void mo472c(Bundle bundle) {
        super.mo472c(bundle);
        Class cls = QuickExperimentViewActivity.class;
        m2519a((Object) this, (Context) this);
        if (((Boolean) this.f1835c.get()).booleanValue()) {
            this.f1840h = ((Intent) Preconditions.checkNotNull(getIntent())).getStringExtra("experiment_name");
            this.f1841i = this.f1833a.b(this.f1840h);
            m2514a();
            return;
        }
        finish();
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1886898574);
        this.f1838f.c();
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1865383517, a);
    }

    private void m2514a() {
        this.f1838f.a("read_experiment_metainfo", this.f1839g.a(new C01181(this)), new C01192(this));
    }

    private ExperimentInfo m2512a(Authority authority) {
        if (this.f1841i) {
            return m2528c(authority);
        }
        return m2523b(authority);
    }

    private ExperimentInfo m2523b(Authority authority) {
        BasicQuickExperimentInfo a;
        boolean z;
        String str;
        Map map;
        switch (AnonymousClass10.f1819a[authority.ordinal()]) {
            case 1:
                a = this.f1834b.a(this.f1840h, DataSource.FROM_SERVER);
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                a = this.f1834b.a(this.f1840h, DataSource.FROM_USER);
                break;
            case 3:
                a = this.f1834b.b(this.f1840h);
                break;
            default:
                throw new IllegalArgumentException();
        }
        if (a == null || !a.c) {
            z = false;
        } else {
            z = true;
        }
        if (a == null || a.e == null) {
            str = "local_default_group";
        } else {
            str = a.e;
        }
        if (a == null) {
            map = null;
        } else {
            map = a.g;
        }
        if (map == null) {
            map = Collections.emptyMap();
        }
        return new ExperimentInfo(this.f1840h, str, z, map);
    }

    private ExperimentInfo m2528c(Authority authority) {
        String b = this.f1833a.b(authority, this.f1840h);
        if (b == null) {
            b = "local_default_group";
        }
        boolean a = this.f1833a.a(authority, this.f1840h);
        Map d = this.f1833a.d(authority, this.f1840h);
        if (d == null) {
            d = Collections.emptyMap();
        }
        return new ExperimentInfo(this.f1840h, b, a, d);
    }

    private boolean m2527b() {
        if (this.f1841i) {
            return this.f1833a.c(this.f1840h);
        }
        return this.f1834b.a(this.f1840h, DataSource.FROM_USER) == this.f1834b.b(this.f1840h);
    }

    public static void m2529d(QuickExperimentViewActivity quickExperimentViewActivity) {
        int i = 0;
        PreferenceScreen createPreferenceScreen = quickExperimentViewActivity.getPreferenceManager().createPreferenceScreen(quickExperimentViewActivity);
        ExperimentInfo a = quickExperimentViewActivity.m2512a(Authority.ASSIGNED);
        ExperimentInfo a2 = quickExperimentViewActivity.m2512a(Authority.OVERRIDE);
        ExperimentInfo a3 = quickExperimentViewActivity.m2512a(Authority.EFFECTIVE);
        boolean z = a.f1779c;
        boolean z2 = a2.f1779c;
        boolean b = quickExperimentViewActivity.m2527b();
        Preference quickExperimentInfoPreference = new QuickExperimentInfoPreference(quickExperimentViewActivity);
        if (z || !z2) {
            z = false;
        } else {
            z = true;
        }
        quickExperimentInfoPreference.f1845b = a3;
        quickExperimentInfoPreference.f1846c = b;
        quickExperimentInfoPreference.f1847d = z;
        createPreferenceScreen.addPreference(quickExperimentInfoPreference);
        Preference preferenceCategory = new PreferenceCategory(quickExperimentViewActivity);
        preferenceCategory.setTitle("Settings");
        createPreferenceScreen.addPreference(preferenceCategory);
        Preference preference = new Preference(quickExperimentViewActivity);
        preference.setTitle("Server Assigned Group");
        if (a == null || a.f1778b.equals("local_default_group")) {
            preference.setSummary("Not In Any Group");
        } else {
            preference.setSummary(QuickExperimentNameHelper.m2487a(a.f1778b));
        }
        preference.setKey(a3.f1777a);
        preferenceCategory.addPreference(preference);
        if (quickExperimentViewActivity.f1842j != null) {
            List a4;
            String str;
            Preference listPreference = new ListPreference(quickExperimentViewActivity);
            listPreference.setTitle("Client Overwrite");
            ArrayList a5 = Lists.a();
            if (quickExperimentViewActivity.f1842j.l_() != null) {
                a4 = Lists.a(Lists.a(quickExperimentViewActivity.f1842j.l_().m2425a(), new C01203(quickExperimentViewActivity)));
            } else {
                Object obj = a5;
            }
            a4.add(0, "<Unset Override>");
            a4.add(1, "<Remove From Experiment>");
            int size = a4.size();
            CharSequence[] charSequenceArr = new String[size];
            CharSequence[] charSequenceArr2 = new String[size];
            while (i < size) {
                str = (String) a4.get(i);
                charSequenceArr[i] = str;
                charSequenceArr2[i] = QuickExperimentNameHelper.m2487a(str);
                i++;
            }
            listPreference.setEntries(charSequenceArr2);
            listPreference.setEntryValues(charSequenceArr);
            str = "";
            if (a2 != null && a2.f1779c) {
                str = a2.f1778b;
            }
            listPreference.setValue(str);
            listPreference.setDefaultValue(str);
            listPreference.setSummary(QuickExperimentNameHelper.m2487a(str));
            listPreference.setKey(quickExperimentViewActivity.f1840h);
            listPreference.setOnPreferenceChangeListener(new C01214(quickExperimentViewActivity));
            preferenceCategory.addPreference(listPreference);
        } else {
            preference = new Preference(quickExperimentViewActivity);
            preference.setTitle("Client Overwrite");
            preference.setSummary("Config data is not available.");
            preference.setOnPreferenceClickListener(new C01225(quickExperimentViewActivity));
            preferenceCategory.addPreference(preference);
        }
        quickExperimentViewActivity.setPreferenceScreen(createPreferenceScreen);
    }

    private void m2520a(final String str) {
        m2522a("clear_override", new Callable<Void>(this) {
            final /* synthetic */ QuickExperimentViewActivity f1826b;

            public Object call() {
                QuickExperimentUserOverride quickExperimentUserOverride = this.f1826b.f1836d;
                String str = str;
                if (quickExperimentUserOverride.f1818e.b(str)) {
                    quickExperimentUserOverride.f1818e.d(str);
                } else {
                    WriteExperimentsHandler writeExperimentsHandler = quickExperimentUserOverride.f1815b;
                    DataSource dataSource = DataSource.FROM_USER;
                    writeExperimentsHandler.c.a().delete("experiments", WriteExperimentsHandler.b, new String[]{str, dataSource.dbName});
                    quickExperimentUserOverride.f1814a.c();
                    quickExperimentUserOverride.f1816c.a(false);
                }
                return null;
            }
        });
    }

    private void m2521a(final String str, final String str2) {
        m2522a("update_override", new Callable<Void>(this) {
            final /* synthetic */ QuickExperimentViewActivity f1829c;

            public Object call() {
                this.f1829c.f1836d.m2505a(str, str2);
                return null;
            }
        });
    }

    private void m2526b(final String str) {
        m2522a("remove_from_experiment", new Callable<Void>(this) {
            final /* synthetic */ QuickExperimentViewActivity f1831b;

            public Object call() {
                this.f1831b.f1836d.m2506b(str);
                return null;
            }
        });
    }

    private void m2522a(String str, Callable<Void> callable) {
        this.f1838f.a(str, this.f1839g.a(callable), new C01269(this));
    }
}
