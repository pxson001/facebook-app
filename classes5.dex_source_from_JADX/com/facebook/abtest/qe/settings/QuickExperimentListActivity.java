package com.facebook.abtest.qe.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import android.text.format.DateUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.abtest.qe.annotations.IsUserTrustedWithQEInternals;
import com.facebook.abtest.qe.bootstrap.utils.ExperimentData;
import com.facebook.abtest.qe.bootstrap.utils.QuickExperimentUtil;
import com.facebook.abtest.qe.data.QuickExperimentConfigPrefKeys;
import com.facebook.base.activity.FbPreferenceActivity;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.widget.prefs.OrcaEditTextPreference;
import com.facebook.widget.prefs.OrcaListPreferenceWithSummaryValue;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: topicIds */
public class QuickExperimentListActivity extends FbPreferenceActivity {
    public static final Class<?> f1797i = QuickExperimentListActivity.class;
    @Inject
    QuickExperimentUtil f1798a;
    @Inject
    @IsUserTrustedWithQEInternals
    Provider<Boolean> f1799b;
    @Inject
    FbSharedPreferences f1800c;
    @Inject
    SecureContextHelper f1801d;
    @Inject
    QuickExperimentNameHelper f1802e;
    @Inject
    Clock f1803f;
    @DefaultExecutorService
    @Inject
    ListeningExecutorService f1804g;
    @Inject
    @ForUiThread
    ScheduledExecutorService f1805h;
    private Preference f1806j;
    private ScheduledFuture f1807k;
    private OnSharedPreferenceChangeListener f1808l = new C01071(this);
    private String f1809m = "";
    @Nullable
    public ImmutableList<ExperimentData> f1810n;

    /* compiled from: topicIds */
    class C01071 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ QuickExperimentListActivity f1782a;

        C01071(QuickExperimentListActivity quickExperimentListActivity) {
            this.f1782a = quickExperimentListActivity;
        }

        public final void m2462a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            if (prefKey.equals(QuickExperimentConfigPrefKeys.f)) {
                this.f1782a.m2473a(false);
            }
        }
    }

    /* compiled from: topicIds */
    class C01082 implements Callable<ImmutableList<ExperimentData>> {
        final /* synthetic */ QuickExperimentListActivity f1783a;

        C01082(QuickExperimentListActivity quickExperimentListActivity) {
            this.f1783a = quickExperimentListActivity;
        }

        public Object call() {
            return this.f1783a.f1798a.m2365a();
        }
    }

    /* compiled from: topicIds */
    class C01126 implements OnPreferenceChangeListener {
        final /* synthetic */ QuickExperimentListActivity f1792a;

        C01126(QuickExperimentListActivity quickExperimentListActivity) {
            this.f1792a = quickExperimentListActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            return this.f1792a.m2474a(preference, obj == null ? "" : String.valueOf(obj));
        }
    }

    /* compiled from: topicIds */
    class C01148 implements OnPreferenceClickListener {
        final /* synthetic */ QuickExperimentListActivity f1795a;

        C01148(QuickExperimentListActivity quickExperimentListActivity) {
            this.f1795a = quickExperimentListActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            QuickExperimentListActivity.m2484f(this.f1795a);
            return true;
        }
    }

    /* compiled from: topicIds */
    class C01159 implements Runnable {
        final /* synthetic */ QuickExperimentListActivity f1796a;

        C01159(QuickExperimentListActivity quickExperimentListActivity) {
            this.f1796a = quickExperimentListActivity;
        }

        public void run() {
            QuickExperimentListActivity.m2483e(this.f1796a);
        }
    }

    /* compiled from: topicIds */
    enum FilterOption {
        SHOW_ALL_EXPERIMENTS("Show all experiments"),
        EXPERIMENTS_IM_IN("Show experiments I'm in"),
        EXPERIMENTS_I_OVERRODE("Show experiments I overrode");
        
        private final String key;

        private FilterOption(String str) {
            this.key = str;
        }

        public final String getKey() {
            return this.key;
        }

        public final String getValue() {
            return name();
        }
    }

    private static <T extends Context> void m2471a(Class<T> cls, T t) {
        m2472a((Object) t, (Context) t);
    }

    public static void m2472a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((QuickExperimentListActivity) obj).m2468a(QuickExperimentUtil.m2363a(injectorLike), IdBasedProvider.a(injectorLike, 3870), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), QuickExperimentNameHelper.m2486a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    private void m2468a(QuickExperimentUtil quickExperimentUtil, Provider<Boolean> provider, FbSharedPreferences fbSharedPreferences, SecureContextHelper secureContextHelper, QuickExperimentNameHelper quickExperimentNameHelper, Clock clock, ListeningExecutorService listeningExecutorService, ScheduledExecutorService scheduledExecutorService) {
        this.f1798a = quickExperimentUtil;
        this.f1799b = provider;
        this.f1800c = fbSharedPreferences;
        this.f1801d = secureContextHelper;
        this.f1802e = quickExperimentNameHelper;
        this.f1803f = clock;
        this.f1804g = listeningExecutorService;
        this.f1805h = scheduledExecutorService;
    }

    public static Intent m2463a(Context context) {
        return new Intent(context, QuickExperimentListActivity.class);
    }

    public final void mo472c(Bundle bundle) {
        super.mo472c(bundle);
        Class cls = QuickExperimentListActivity.class;
        m2472a((Object) this, (Context) this);
        if (!m2482d()) {
            finish();
        }
    }

    private void m2473a(final boolean z) {
        Futures.a(this.f1804g.a(new C01082(this)), new FutureCallback<ImmutableList<ExperimentData>>(this) {
            final /* synthetic */ QuickExperimentListActivity f1785b;

            public void onSuccess(@Nullable Object obj) {
                this.f1785b.f1810n = (ImmutableList) obj;
                this.f1785b.m2481b(z);
            }

            public void onFailure(Throwable th) {
                BLog.b(QuickExperimentListActivity.f1797i, "Could not cache experiments for QE list activity", th);
                this.f1785b.f1810n = null;
                this.f1785b.m2481b(z);
            }
        }, this.f1805h);
    }

    private void m2481b(boolean z) {
        PreferenceScreen createPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
        m2466a((PreferenceGroup) createPreferenceScreen);
        m2467a(createPreferenceScreen);
        m2478b(createPreferenceScreen);
        FilterOption b = m2476b();
        Preference preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Experiments");
        createPreferenceScreen.addPreference(preferenceCategory);
        if (this.f1810n != null) {
            int i;
            int size = this.f1810n.size();
            for (i = 0; i < size; i++) {
                final ExperimentData experimentData = (ExperimentData) this.f1810n.get(i);
                if ((experimentData.isInExperiment || experimentData.m2361d() || b == FilterOption.SHOW_ALL_EXPERIMENTS) && (experimentData.m2361d() || b != FilterOption.EXPERIMENTS_I_OVERRODE)) {
                    String toLowerCase = QuickExperimentNameHelper.m2487a(experimentData.name).toLowerCase(Locale.getDefault());
                    CharSequence toLowerCase2 = this.f1809m.toLowerCase(Locale.getDefault());
                    if (experimentData.name.toLowerCase(Locale.getDefault()).contains(toLowerCase2) || toLowerCase.contains(toLowerCase2)) {
                        Preference preference = new Preference(this);
                        preference.setTitle(QuickExperimentNameHelper.m2487a(experimentData.name));
                        if (experimentData.isInExperiment) {
                            preference.setSummary(QuickExperimentNameHelper.m2487a(experimentData.m2360c()));
                        } else {
                            preference.setSummary("<Not In Experiment>");
                        }
                        preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
                            final /* synthetic */ QuickExperimentListActivity f1787b;

                            public boolean onPreferenceClick(Preference preference) {
                                this.f1787b.f1801d.a(QuickExperimentViewActivity.m2511a(this.f1787b, experimentData.name), this.f1787b);
                                return true;
                            }
                        });
                        preferenceCategory.addPreference(preference);
                    }
                }
            }
            if (createPreferenceScreen.getPreferenceCount() == 0) {
                Preference preference2 = new Preference(this);
                preference2.setTitle("No experiment data has been downloaded yet.");
                createPreferenceScreen.addPreference(preference2);
            }
            setPreferenceScreen(createPreferenceScreen);
            if (z) {
                final int a = this.f1800c.a(QuickExperimentConfigPrefKeys.g, 0);
                i = this.f1800c.a(QuickExperimentConfigPrefKeys.h, 0);
                final ListView listView = getListView();
                listView.clearFocus();
                listView.post(new Runnable(this) {
                    final /* synthetic */ QuickExperimentListActivity f1791d;

                    public void run() {
                        listView.setSelectionFromTop(a, i);
                    }
                });
            }
        }
    }

    private void m2467a(PreferenceScreen preferenceScreen) {
        final Preference orcaEditTextPreference = new OrcaEditTextPreference(this);
        orcaEditTextPreference.setText(this.f1809m);
        orcaEditTextPreference.setTitle("Search for Experiments");
        m2477b(orcaEditTextPreference, orcaEditTextPreference.getText());
        orcaEditTextPreference.getEditText().setSelectAllOnFocus(true);
        orcaEditTextPreference.setOnPreferenceChangeListener(new C01126(this));
        EditText editText = orcaEditTextPreference.getEditText();
        editText.setImeOptions(6);
        editText.setSingleLine();
        editText.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ QuickExperimentListActivity f1794b;

            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 && (i != 0 || keyEvent.getAction() != 0)) {
                    return false;
                }
                String charSequence = textView.getText().toString();
                orcaEditTextPreference.getDialog().dismiss();
                return this.f1794b.m2474a(orcaEditTextPreference, charSequence);
            }
        });
        preferenceScreen.addPreference(orcaEditTextPreference);
    }

    private boolean m2474a(Preference preference, String str) {
        m2477b(preference, str);
        if (!this.f1809m.equals(str)) {
            this.f1809m = str;
            m2481b(false);
        }
        return true;
    }

    private static void m2477b(Preference preference, String str) {
        preference.setSummary(Strings.isNullOrEmpty(str) ? "Show only some experiments" : "Showing only: " + str);
    }

    private void m2478b(PreferenceScreen preferenceScreen) {
        Preference orcaListPreferenceWithSummaryValue = new OrcaListPreferenceWithSummaryValue(this);
        orcaListPreferenceWithSummaryValue.m10585a(QuickExperimentConfigPrefKeys.f);
        orcaListPreferenceWithSummaryValue.setTitle("Filter Experiments");
        orcaListPreferenceWithSummaryValue.setDefaultValue(FilterOption.SHOW_ALL_EXPERIMENTS.getValue());
        CharSequence[] charSequenceArr = new CharSequence[FilterOption.values().length];
        CharSequence[] charSequenceArr2 = new CharSequence[FilterOption.values().length];
        for (int i = 0; i < FilterOption.values().length; i++) {
            FilterOption filterOption = FilterOption.values()[i];
            charSequenceArr[i] = filterOption.getKey();
            charSequenceArr2[i] = filterOption.getValue();
        }
        orcaListPreferenceWithSummaryValue.setEntries(charSequenceArr);
        orcaListPreferenceWithSummaryValue.setEntryValues(charSequenceArr2);
        preferenceScreen.addPreference(orcaListPreferenceWithSummaryValue);
    }

    private FilterOption m2476b() {
        return FilterOption.valueOf(this.f1800c.a(QuickExperimentConfigPrefKeys.f, FilterOption.EXPERIMENTS_IM_IN.name()));
    }

    private boolean m2482d() {
        return ((Boolean) this.f1799b.get()).booleanValue();
    }

    private void m2466a(PreferenceGroup preferenceGroup) {
        this.f1806j = new Preference(this);
        this.f1806j.setTitle("Sync Quick Experiments Now");
        this.f1806j.setOnPreferenceClickListener(new C01148(this));
        preferenceGroup.addPreference(this.f1806j);
        m2483e(this);
    }

    public static void m2483e(QuickExperimentListActivity quickExperimentListActivity) {
        if (quickExperimentListActivity.f1807k != null) {
            quickExperimentListActivity.f1807k.cancel(true);
            quickExperimentListActivity.f1807k = null;
        }
        quickExperimentListActivity.f1806j.setSummary("Last sync was " + DateUtils.formatElapsedTime((quickExperimentListActivity.f1803f.a() - quickExperimentListActivity.f1800c.a(QuickExperimentConfigPrefKeys.c, -1)) / 1000) + " ago");
        quickExperimentListActivity.f1807k = quickExperimentListActivity.f1805h.schedule(new C01159(quickExperimentListActivity), 1, TimeUnit.SECONDS);
    }

    public static void m2484f(QuickExperimentListActivity quickExperimentListActivity) {
        QuickExperimentSyncDialogFragment quickExperimentSyncDialogFragment = new QuickExperimentSyncDialogFragment();
        quickExperimentSyncDialogFragment.aq = new Object(quickExperimentListActivity) {
            final /* synthetic */ QuickExperimentListActivity f1781a;

            {
                this.f1781a = r1;
            }

            public final void m2461a() {
                this.f1781a.m2473a(false);
            }
        };
        quickExperimentSyncDialogFragment.a(quickExperimentListActivity.m2273c(), "qe_refresh");
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1771798518);
        super.onResume();
        m2473a(true);
        this.f1800c.a(QuickExperimentConfigPrefKeys.f, this.f1808l);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -129277093, a);
    }

    protected void onPause() {
        int firstVisiblePosition;
        int i = 0;
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 815146059);
        super.onPause();
        if (this.f1807k != null) {
            this.f1807k.cancel(true);
            this.f1807k = null;
        }
        this.f1800c.b(QuickExperimentConfigPrefKeys.f, this.f1808l);
        View childAt = getListView().getChildAt(0);
        if (childAt != null) {
            firstVisiblePosition = getListView().getFirstVisiblePosition();
            i = childAt.getTop();
        } else {
            firstVisiblePosition = 0;
        }
        this.f1800c.edit().a(QuickExperimentConfigPrefKeys.g, firstVisiblePosition).a(QuickExperimentConfigPrefKeys.h, i).commit();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 2074170508, a);
    }
}
