package com.facebook.search.debug;

import android.content.Context;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.widget.Toast;
import com.facebook.abtest.qe.settings.QuickExperimentListActivity;
import com.facebook.base.activity.FbPreferenceActivity;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.inject.FbInjector;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.search.bootstrap.sync.BootstrapEntitiesLoader;
import com.facebook.search.bootstrap.sync.BootstrapKeywordsLoader;
import com.facebook.search.intent.SearchResultsIntentBuilder;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.logging.api.SearchTypeaheadSession;
import com.facebook.search.model.CachedSuggestionList;
import com.facebook.search.prefs.GraphSearchPrefKeys;
import com.facebook.search.prefs.SearchAwarenessPrefKeys;
import com.facebook.search.quickpromotion.AwarenessType;
import com.facebook.search.suggestions.nullstate.ContentDiscoveryNullStateSupplier;
import com.facebook.search.suggestions.nullstate.RecentSearchesNullStateSupplier;
import com.facebook.widget.prefs.OrcaEditTextPreference;
import com.facebook.widget.prefs.OrcaListPreference;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TimeToFirstCardDataLoadStart */
public class SearchDebugActivity extends FbPreferenceActivity {
    public static final CallerContext f21853j = CallerContext.a(SearchDebugActivity.class);
    @Inject
    RecentSearchesNullStateSupplier f21854a;
    @Inject
    ContentDiscoveryNullStateSupplier f21855b;
    @Inject
    GraphQLCacheManager f21856c;
    @Inject
    @ForUiThread
    Executor f21857d;
    @Inject
    SearchResultsIntentBuilder f21858e;
    @Inject
    FbSharedPreferences f21859f;
    @Inject
    BootstrapEntitiesLoader f21860g;
    @Inject
    BootstrapKeywordsLoader f21861h;
    @Inject
    SecureContextHelper f21862i;
    private PreferenceScreen f21863k;

    /* compiled from: TimeToFirstCardDataLoadStart */
    class C23481 implements OnPreferenceClickListener {
        final /* synthetic */ SearchDebugActivity f21841a;

        /* compiled from: TimeToFirstCardDataLoadStart */
        class C23471 implements FutureCallback<CachedSuggestionList> {
            final /* synthetic */ C23481 f21831a;

            C23471(C23481 c23481) {
                this.f21831a = c23481;
            }

            public void onSuccess(@Nullable Object obj) {
                CachedSuggestionList cachedSuggestionList = (CachedSuggestionList) obj;
                if (cachedSuggestionList != null) {
                    Toast.makeText(this.f21831a.f21841a, "Successfully Fetched " + cachedSuggestionList.a.size() + " recent searches!", 1).show();
                }
            }

            public void onFailure(Throwable th) {
                Toast.makeText(this.f21831a.f21841a, "Refresh Failed! Exception: " + th.getMessage(), 1).show();
            }
        }

        C23481(SearchDebugActivity searchDebugActivity) {
            this.f21841a = searchDebugActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            Futures.a(this.f21841a.f21854a.a(SearchDebugActivity.f21853j, GraphQLCachePolicy.d, 86400), new C23471(this), this.f21841a.f21857d);
            return true;
        }
    }

    /* compiled from: TimeToFirstCardDataLoadStart */
    class C23502 implements OnPreferenceClickListener {
        final /* synthetic */ SearchDebugActivity f21843a;

        /* compiled from: TimeToFirstCardDataLoadStart */
        class C23491 implements FutureCallback<Void> {
            final /* synthetic */ C23502 f21842a;

            C23491(C23502 c23502) {
                this.f21842a = c23502;
            }

            public void onSuccess(@Nullable Object obj) {
                Toast.makeText(this.f21842a.f21843a, "Successfully cleared recent searches cache!", 1).show();
            }

            public void onFailure(Throwable th) {
                Toast.makeText(this.f21842a.f21843a, "Cache couldn't be cleared! Exception: " + th.getMessage(), 1).show();
            }
        }

        C23502(SearchDebugActivity searchDebugActivity) {
            this.f21843a = searchDebugActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            Futures.a(this.f21843a.f21854a.e(), new C23491(this), this.f21843a.f21857d);
            return true;
        }
    }

    /* compiled from: TimeToFirstCardDataLoadStart */
    class C23523 implements OnPreferenceClickListener {
        final /* synthetic */ SearchDebugActivity f21845a;

        /* compiled from: TimeToFirstCardDataLoadStart */
        class C23511 implements FutureCallback<Void> {
            final /* synthetic */ C23523 f21844a;

            C23511(C23523 c23523) {
                this.f21844a = c23523;
            }

            public void onSuccess(@Nullable Object obj) {
                Toast.makeText(this.f21844a.f21845a, "Successfully cleared null state searches cache!", 1).show();
            }

            public void onFailure(Throwable th) {
                Toast.makeText(this.f21844a.f21845a, "Cache couldn't be cleared! Exception: " + th.getMessage(), 1).show();
            }
        }

        C23523(SearchDebugActivity searchDebugActivity) {
            this.f21845a = searchDebugActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            Futures.a(SearchDebugActivity.m25332f(this.f21845a), new C23511(this), this.f21845a.f21857d);
            return true;
        }
    }

    /* compiled from: TimeToFirstCardDataLoadStart */
    class C23534 implements OnPreferenceChangeListener {
        final /* synthetic */ SearchDebugActivity f21846a;

        C23534(SearchDebugActivity searchDebugActivity) {
            this.f21846a = searchDebugActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            if (!Strings.isNullOrEmpty((String) obj)) {
                this.f21846a.startActivity(this.f21846a.f21858e.a(SearchTypeaheadSession.a, (String) obj, "Injected ID", SearchResultsSource.g));
            }
            return true;
        }
    }

    /* compiled from: TimeToFirstCardDataLoadStart */
    class C23545 implements OnPreferenceChangeListener {
        final /* synthetic */ SearchDebugActivity f21847a;

        C23545(SearchDebugActivity searchDebugActivity) {
            this.f21847a = searchDebugActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            if (!Strings.isNullOrEmpty((String) obj)) {
                this.f21847a.startActivity(this.f21847a.f21858e.b(SearchTypeaheadSession.a, "Injected Pulse Title", (String) obj, SearchResultsSource.h));
            }
            return true;
        }
    }

    /* compiled from: TimeToFirstCardDataLoadStart */
    class C23556 implements OnPreferenceClickListener {
        final /* synthetic */ SearchDebugActivity f21848a;

        C23556(SearchDebugActivity searchDebugActivity) {
            this.f21848a = searchDebugActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f21848a.f21859f.a(ImmutableSet.of(GraphSearchPrefKeys.b));
            this.f21848a.f21860g.a();
            return true;
        }
    }

    /* compiled from: TimeToFirstCardDataLoadStart */
    class C23567 implements OnPreferenceClickListener {
        final /* synthetic */ SearchDebugActivity f21849a;

        C23567(SearchDebugActivity searchDebugActivity) {
            this.f21849a = searchDebugActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f21849a.f21859f.a(ImmutableSet.of(GraphSearchPrefKeys.c));
            this.f21849a.f21861h.a();
            return true;
        }
    }

    /* compiled from: TimeToFirstCardDataLoadStart */
    class C23578 implements OnPreferenceClickListener {
        final /* synthetic */ SearchDebugActivity f21850a;

        C23578(SearchDebugActivity searchDebugActivity) {
            this.f21850a = searchDebugActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f21850a.f21859f.edit().a(SearchAwarenessPrefKeys.b("4084")).a(SearchAwarenessPrefKeys.a("4084")).commit();
            Toast.makeText(this.f21850a.getApplicationContext(), "Successfully reset state.  Don't forget to kill the app!", 0).show();
            return true;
        }
    }

    private static <T extends Context> void m25325a(Class<T> cls, T t) {
        m25326a((Object) t, (Context) t);
    }

    public static void m25326a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((SearchDebugActivity) obj).m25324a(RecentSearchesNullStateSupplier.a(fbInjector), ContentDiscoveryNullStateSupplier.a(fbInjector), GraphQLCacheManager.a(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), SearchResultsIntentBuilder.a(fbInjector), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), BootstrapEntitiesLoader.a(fbInjector), BootstrapKeywordsLoader.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector));
    }

    private void m25324a(RecentSearchesNullStateSupplier recentSearchesNullStateSupplier, ContentDiscoveryNullStateSupplier contentDiscoveryNullStateSupplier, GraphQLCacheManager graphQLCacheManager, Executor executor, SearchResultsIntentBuilder searchResultsIntentBuilder, FbSharedPreferences fbSharedPreferences, BootstrapEntitiesLoader bootstrapEntitiesLoader, BootstrapKeywordsLoader bootstrapKeywordsLoader, SecureContextHelper secureContextHelper) {
        this.f21854a = recentSearchesNullStateSupplier;
        this.f21855b = contentDiscoveryNullStateSupplier;
        this.f21856c = graphQLCacheManager;
        this.f21857d = executor;
        this.f21858e = searchResultsIntentBuilder;
        this.f21859f = fbSharedPreferences;
        this.f21860g = bootstrapEntitiesLoader;
        this.f21861h = bootstrapKeywordsLoader;
        this.f21862i = secureContextHelper;
    }

    public final void m25346c(Bundle bundle) {
        super.c(bundle);
        Class cls = SearchDebugActivity.class;
        m25326a((Object) this, (Context) this);
        this.f21863k = getPreferenceManager().createPreferenceScreen(this);
        Preference preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Trending Topics");
        this.f21863k.addPreference(preferenceCategory);
        this.f21863k.addPreference(m25333g());
        this.f21863k.addPreference(m25334h());
        this.f21863k.addPreference(m25331e());
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Recent Searches");
        this.f21863k.addPreference(preferenceCategory);
        this.f21863k.addPreference(m25327b());
        this.f21863k.addPreference(m25330d());
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Bootstrap");
        this.f21863k.addPreference(preferenceCategory);
        this.f21863k.addPreference(m25335i());
        this.f21863k.addPreference(m25336j());
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Search Awareness and Education");
        this.f21863k.addPreference(preferenceCategory);
        this.f21863k.addPreference(m25337k());
        this.f21863k.addPreference(m25338l());
        this.f21863k.addPreference(m25340n());
        this.f21863k.addPreference(m25341o());
        this.f21863k.addPreference(m25342p());
        this.f21863k.addPreference(m25343q());
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Misc");
        this.f21863k.addPreference(preferenceCategory);
        this.f21863k.addPreference(m25344r());
        this.f21863k.addPreference(m25345s());
        setPreferenceScreen(this.f21863k);
    }

    private Preference m25327b() {
        Preference preference = new Preference(this);
        preference.setTitle("Fetch Recent Searches");
        preference.setSummary("Force fetches the list of recent searches in null state");
        preference.setOnPreferenceClickListener(new C23481(this));
        return preference;
    }

    private Preference m25330d() {
        Preference preference = new Preference(this);
        preference.setTitle("Clear Recent Searches Cache");
        preference.setSummary("Clears all memory and disk caches holding recent searches");
        preference.setOnPreferenceClickListener(new C23502(this));
        return preference;
    }

    private Preference m25331e() {
        Preference preference = new Preference(this);
        preference.setTitle("Clear Null State Searches Cache");
        preference.setSummary("Clears all memory and disk caches holding Null State searches");
        preference.setOnPreferenceClickListener(new C23523(this));
        return preference;
    }

    public static ListenableFuture m25332f(SearchDebugActivity searchDebugActivity) {
        searchDebugActivity.f21855b.b();
        return searchDebugActivity.f21856c.a(Sets.a(new String[]{"null_state_module_cache_tag"}));
    }

    private Preference m25333g() {
        OrcaEditTextPreference orcaEditTextPreference = new OrcaEditTextPreference(this);
        orcaEditTextPreference.setTitle("Load Trending Topic ID");
        orcaEditTextPreference.setSummary("Load news search for a specified ID");
        orcaEditTextPreference.a(GraphSearchPrefKeys.e);
        orcaEditTextPreference.setDefaultValue(this.f21859f.a(GraphSearchPrefKeys.e, null));
        orcaEditTextPreference.setOnPreferenceChangeListener(new C23534(this));
        return orcaEditTextPreference;
    }

    private Preference m25334h() {
        OrcaEditTextPreference orcaEditTextPreference = new OrcaEditTextPreference(this);
        orcaEditTextPreference.setTitle("Load Pulse URL");
        orcaEditTextPreference.setSummary("Load Pulse content modules for a specified link/article");
        orcaEditTextPreference.a(GraphSearchPrefKeys.f);
        orcaEditTextPreference.setDefaultValue(this.f21859f.a(GraphSearchPrefKeys.f, null));
        orcaEditTextPreference.setOnPreferenceChangeListener(new C23545(this));
        return orcaEditTextPreference;
    }

    private Preference m25335i() {
        Preference preference = new Preference(this);
        preference.setTitle("Refresh Bootstrap Entities");
        preference.setSummary("Force fetches bootstrap entities");
        preference.setOnPreferenceClickListener(new C23556(this));
        return preference;
    }

    private Preference m25336j() {
        Preference preference = new Preference(this);
        preference.setTitle("Refresh Bootstrap Keywords");
        preference.setSummary("Force fetches bootstrap keywords");
        preference.setOnPreferenceClickListener(new C23567(this));
        return preference;
    }

    private Preference m25337k() {
        Preference preference = new Preference(this);
        preference.setTitle("Reset Tutorial Nux");
        preference.setSummary("Clears the preferences flag which disables tutorial nux");
        preference.setOnPreferenceClickListener(new C23578(this));
        return preference;
    }

    private Preference m25338l() {
        final Preference preference = new Preference(this);
        m25328b(preference, m25339m(this));
        preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ SearchDebugActivity f21852b;

            public boolean onPreferenceClick(Preference preference) {
                boolean z = !SearchDebugActivity.m25339m(this.f21852b);
                this.f21852b.f21859f.edit().putBoolean(SearchAwarenessPrefKeys.g, z).commit();
                Toast.makeText(this.f21852b.getApplicationContext(), "Updated Tutorial Nux Debug Mode.  Don't forget to kill the app!", 0).show();
                SearchDebugActivity.m25328b(preference, z);
                return true;
            }
        });
        return preference;
    }

    public static void m25328b(Preference preference, boolean z) {
        preference.setTitle(z ? "Disable Tutorial Nux Debug Mode" : "Enable Tutorial Nux Debug Mode");
        preference.setSummary(z ? "Use prod rate-limiting and caching policies\nDebug Mode currently ENABLED" : "Use debug rate-limiting and caching policies\nDebug mode currently DISABLED");
    }

    public static boolean m25339m(SearchDebugActivity searchDebugActivity) {
        return searchDebugActivity.f21859f.a(SearchAwarenessPrefKeys.g, false);
    }

    private Preference m25340n() {
        Preference preference = new Preference(this);
        preference.setTitle("Test Tutorial Nux Configuration");
        preference.setSummary("Allows user to test a configuration of Tutorial Nux");
        preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ SearchDebugActivity f21832a;

            {
                this.f21832a = r1;
            }

            public boolean onPreferenceClick(Preference preference) {
                this.f21832a.f21862i.a(SearchAwarenessTutorialNuxDebugActivity.m25299a(this.f21832a), this.f21832a);
                return true;
            }
        });
        return preference;
    }

    private Preference m25341o() {
        Preference preference = new Preference(this);
        preference.setTitle("Reset Awareness Opt-Outs");
        preference.setSummary("Clears device flags for opting out of each type of awareness unit");
        preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ SearchDebugActivity f21833a;

            {
                this.f21833a = r1;
            }

            public boolean onPreferenceClick(Preference preference) {
                Editor edit = this.f21833a.f21859f.edit();
                for (AwarenessType name : AwarenessType.values()) {
                    PrefKey c = SearchAwarenessPrefKeys.c(name.name());
                    if (this.f21833a.f21859f.a(c, false)) {
                        edit.a(c);
                    }
                }
                edit.commit();
                Toast.makeText(this.f21833a.getApplicationContext(), "Reset all awareness opt-out flags", 0).show();
                return true;
            }
        });
        return preference;
    }

    private Preference m25342p() {
        Preference preference = new Preference(this);
        preference.setTitle("Reset Learning Nux State");
        preference.setSummary("Clears stored client data for Learning Nux.  Does NOT reset server state.");
        preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ SearchDebugActivity f21834a;

            {
                this.f21834a = r1;
            }

            public boolean onPreferenceClick(Preference preference) {
                this.f21834a.f21859f.edit().a(SearchAwarenessPrefKeys.e).putBoolean(SearchAwarenessPrefKeys.f, true).commit();
                Toast.makeText(this.f21834a.getApplicationContext(), "Reset stored client data for Learning Nux.", 0).show();
                return true;
            }
        });
        return preference;
    }

    private Preference m25343q() {
        Preference preference = new Preference(this);
        preference.setTitle("Reset Search Spotlight State");
        preference.setSummary("Clears stored client data for Search Spotlight.  Does NOT reset server state.");
        preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ SearchDebugActivity f21835a;

            {
                this.f21835a = r1;
            }

            public boolean onPreferenceClick(Preference preference) {
                this.f21835a.f21859f.edit().a(SearchAwarenessPrefKeys.h).commit();
                Toast.makeText(this.f21835a.getApplicationContext(), "Reset stored client data for Search Spotlight.", 0).show();
                return true;
            }
        });
        return preference;
    }

    private Preference m25344r() {
        final PrefKey prefKey = GraphSearchPrefKeys.j;
        final AnonymousClass14 anonymousClass14 = new OrcaListPreference(this, this) {
            final /* synthetic */ SearchDebugActivity f21837b;

            protected boolean persistString(String str) {
                Editor edit = this.f21837b.f21859f.edit();
                boolean z = true;
                switch (str.hashCode()) {
                    case -2119061546:
                        if (str.equals("simple search")) {
                            z = true;
                            break;
                        }
                        break;
                    case 111442729:
                        if (str.equals("unset")) {
                            z = false;
                            break;
                        }
                        break;
                    case 594428200:
                        if (str.equals("post search")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        edit.a(prefKey);
                        break;
                    case true:
                        edit.putBoolean(prefKey, false);
                        break;
                    case true:
                        edit.putBoolean(prefKey, true);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown selection: " + str);
                }
                edit.commit();
                return true;
            }

            protected String getPersistedString(String str) {
                if (this.f21837b.f21859f.a(prefKey)) {
                    return this.f21837b.f21859f.a(prefKey, false) ? "post search" : "simple search";
                } else {
                    return "unset";
                }
            }

            public void setSummary(CharSequence charSequence) {
                if (charSequence.length() == 0) {
                    charSequence = "Current Override: " + getPersistedString("unset");
                }
                super.setSummary(charSequence);
            }
        };
        anonymousClass14.setTitle("Enable/Disable Post Search");
        anonymousClass14.setEntries(new CharSequence[]{"Force Post Search", "Force Simple Search", "Unset Override"});
        anonymousClass14.setEntryValues(new CharSequence[]{"post search", "simple search", "unset"});
        anonymousClass14.setDialogTitle("Override Post Search GK");
        anonymousClass14.setSummary("");
        anonymousClass14.a(prefKey);
        anonymousClass14.setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
            final /* synthetic */ SearchDebugActivity f21839b;

            public boolean onPreferenceChange(Preference preference, Object obj) {
                anonymousClass14.setSummary("Current Override: " + obj);
                return true;
            }
        });
        return anonymousClass14;
    }

    private Preference m25345s() {
        Preference preference = new Preference(this);
        preference.setTitle("Quick Experiment");
        preference.setSummary("Shortcut to QE Page");
        preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ SearchDebugActivity f21840a;

            {
                this.f21840a = r1;
            }

            public boolean onPreferenceClick(Preference preference) {
                this.f21840a.startActivity(QuickExperimentListActivity.a(this.f21840a));
                return true;
            }
        });
        return preference;
    }
}
