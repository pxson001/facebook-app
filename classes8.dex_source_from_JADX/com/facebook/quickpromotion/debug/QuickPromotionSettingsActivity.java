package com.facebook.quickpromotion.debug;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.widget.Toast;
import com.facebook.base.activity.FbPreferenceActivity;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.Operation;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.api.FetchInterstitialsParams;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialControllersHolder;
import com.facebook.interstitial.manager.InterstitialControllersHolderImpl;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.quickpromotion.annotations.ActionLimitValidator;
import com.facebook.quickpromotion.annotations.ContextualFilterValidator;
import com.facebook.quickpromotion.annotations.DefinitionValidator;
import com.facebook.quickpromotion.controller.QuickPromotionController;
import com.facebook.quickpromotion.filter.QuickPromotionCounters;
import com.facebook.quickpromotion.filter.QuickPromotionCounters$CounterType;
import com.facebook.quickpromotion.filter.QuickPromotionFilterClauseChecker;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition$FilterClause;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.facebook.quickpromotion.prefs.QuickPromotionPrefKeys;
import com.facebook.quickpromotion.prefs.QuickPromotionPrefKeys.PromotionForceMode;
import com.facebook.quickpromotion.validators.QuickPromotionActionLimitValidator;
import com.facebook.quickpromotion.validators.QuickPromotionContextualFilterValidator;
import com.facebook.quickpromotion.validators.QuickPromotionDefinitionValidator;
import com.facebook.quickpromotion.validators.QuickPromotionValidator;
import com.facebook.quickpromotion.validators.QuickPromotionValidatorResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.widget.prefs.OrcaCheckBoxPreference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: referenced_sticker_data */
public class QuickPromotionSettingsActivity extends FbPreferenceActivity {
    @Inject
    InterstitialManager f4652a;
    @Inject
    @DefinitionValidator
    QuickPromotionValidator f4653b;
    @Inject
    @ContextualFilterValidator
    QuickPromotionValidator f4654c;
    @Inject
    @ActionLimitValidator
    QuickPromotionValidator f4655d;
    @Inject
    DefaultBlueServiceOperationFactory f4656e;
    @Inject
    QuickPromotionCounters f4657f;
    @Inject
    ObjectMapper f4658g;
    @Inject
    @ForUiThread
    Executor f4659h;
    @Inject
    FbSharedPreferences f4660i;
    @Inject
    InterstitialControllersHolder f4661j;
    @Inject
    QuickPromotionFilterClauseChecker f4662k;
    public Map<String, String> f4663l;
    private PromotionForceMode[] f4664m = PromotionForceMode.values();

    /* compiled from: referenced_sticker_data */
    class C06131 implements OnPreferenceClickListener {
        final /* synthetic */ QuickPromotionSettingsActivity f4633a;

        C06131(QuickPromotionSettingsActivity quickPromotionSettingsActivity) {
            this.f4633a = quickPromotionSettingsActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f4633a.f4660i.edit().b(QuickPromotionPrefKeys.f4762f).commit();
            this.f4633a.f4660i.edit().b(QuickPromotionPrefKeys.f4761e).commit();
            Toast.makeText(this.f4633a, "Delay reset", 1).show();
            return true;
        }
    }

    /* compiled from: referenced_sticker_data */
    class C06142 implements OnPreferenceClickListener {
        final /* synthetic */ QuickPromotionSettingsActivity f4634a;

        C06142(QuickPromotionSettingsActivity quickPromotionSettingsActivity) {
            this.f4634a = quickPromotionSettingsActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f4634a.f4660i.edit().b(QuickPromotionPrefKeys.f4763g).commit();
            Toast.makeText(this.f4634a, "Reset Force Modes", 1).show();
            this.f4634a.m4495a();
            return true;
        }
    }

    private static <T extends Context> void m4500a(Class<T> cls, T t) {
        m4501a((Object) t, (Context) t);
    }

    public static void m4501a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((QuickPromotionSettingsActivity) obj).m4496a(InterstitialManager.a(injectorLike), (QuickPromotionValidator) QuickPromotionDefinitionValidator.b(injectorLike), (QuickPromotionValidator) QuickPromotionContextualFilterValidator.m4741a(injectorLike), (QuickPromotionValidator) QuickPromotionActionLimitValidator.b(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), QuickPromotionCounters.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (InterstitialControllersHolder) InterstitialControllersHolderImpl.b(injectorLike), QuickPromotionFilterClauseChecker.m4587b(injectorLike));
    }

    private void m4496a(InterstitialManager interstitialManager, QuickPromotionValidator quickPromotionValidator, QuickPromotionValidator quickPromotionValidator2, QuickPromotionValidator quickPromotionValidator3, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, QuickPromotionCounters quickPromotionCounters, ObjectMapper objectMapper, Executor executor, FbSharedPreferences fbSharedPreferences, InterstitialControllersHolder interstitialControllersHolder, QuickPromotionFilterClauseChecker quickPromotionFilterClauseChecker) {
        this.f4652a = interstitialManager;
        this.f4653b = quickPromotionValidator;
        this.f4654c = quickPromotionValidator2;
        this.f4655d = quickPromotionValidator3;
        this.f4656e = defaultBlueServiceOperationFactory;
        this.f4657f = quickPromotionCounters;
        this.f4658g = objectMapper;
        this.f4659h = executor;
        this.f4660i = fbSharedPreferences;
        this.f4661j = interstitialControllersHolder;
        this.f4662k = quickPromotionFilterClauseChecker;
    }

    public final void m4508c(Bundle bundle) {
        super.c(bundle);
        Class cls = QuickPromotionSettingsActivity.class;
        m4501a((Object) this, (Context) this);
        Builder builder = ImmutableMap.builder();
        for (String a : this.f4661j.a()) {
            InterstitialController a2 = this.f4661j.a(a);
            if (a2 instanceof QuickPromotionController) {
                QuickPromotionController quickPromotionController = (QuickPromotionController) a2;
                builder.b(quickPromotionController.g(), quickPromotionController.b());
            }
        }
        this.f4663l = builder.b();
        m4495a();
    }

    private void m4495a() {
        PreferenceScreen createPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
        OrcaCheckBoxPreference orcaCheckBoxPreference = new OrcaCheckBoxPreference(this);
        orcaCheckBoxPreference.a(QuickPromotionPrefKeys.f4758b);
        orcaCheckBoxPreference.setTitle("Enable Dev Mode");
        orcaCheckBoxPreference.setSummary("Disables hardcoded interstitial delays");
        orcaCheckBoxPreference.setDefaultValue(Boolean.valueOf(false));
        createPreferenceScreen.addPreference(orcaCheckBoxPreference);
        Preference preference = new Preference(this);
        preference.setTitle("Global Filter Options");
        preference.setIntent(new Intent(this, QuickPromotionFiltersActivity.class));
        createPreferenceScreen.addPreference(preference);
        preference = new Preference(this);
        preference.setTitle("Triggers Firing Page");
        preference.setSummary("Tapping a trigger will show the eligible QP Interstitial");
        preference.setIntent(new Intent(this, QuickPromotionTriggersActivity.class));
        createPreferenceScreen.addPreference(preference);
        preference = new PreferenceCategory(this);
        createPreferenceScreen.addPreference(preference);
        preference.setTitle("Refresh & Reset");
        createPreferenceScreen.addPreference(m4502b());
        preference = new Preference(this);
        preference.setTitle("Reset Interstitial and Action Delays");
        preference.setOnPreferenceClickListener(new C06131(this));
        createPreferenceScreen.addPreference(preference);
        preference = new Preference(this);
        preference.setTitle("Reset All Force Modes to Default");
        preference.setOnPreferenceClickListener(new C06142(this));
        createPreferenceScreen.addPreference(preference);
        for (Entry entry : this.f4663l.entrySet()) {
            Preference preferenceCategory = new PreferenceCategory(this);
            createPreferenceScreen.addPreference(preferenceCategory);
            preferenceCategory.setTitle((CharSequence) entry.getKey());
            QuickPromotionController quickPromotionController = (QuickPromotionController) this.f4652a.a((String) entry.getValue());
            if (quickPromotionController != null) {
                Preference preference2;
                for (final QuickPromotionDefinition quickPromotionDefinition : quickPromotionController.h()) {
                    preference2 = new Preference(this);
                    preference2.setTitle(quickPromotionDefinition.promotionId + " " + this.f4664m[this.f4660i.a(QuickPromotionPrefKeys.m4651c(quickPromotionDefinition.promotionId), PromotionForceMode.DEFAULT.ordinal())].getStatusCaption());
                    boolean z = this.f4654c.a(quickPromotionDefinition, null).f4871c && this.f4655d.a(quickPromotionDefinition, null).f4871c && !quickPromotionDefinition.isExposureHoldout;
                    preference2.setSummary(StringFormatUtil.a("Title: %s\nContent: %s\nEligible?: %s", new Object[]{quickPromotionDefinition.title, quickPromotionDefinition.content, Boolean.valueOf(z)}));
                    preference2.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
                        final /* synthetic */ QuickPromotionSettingsActivity f4636b;

                        public boolean onPreferenceClick(Preference preference) {
                            this.f4636b.m4499a(quickPromotionDefinition);
                            return true;
                        }
                    });
                    preferenceCategory.addPreference(preference2);
                }
                for (QuickPromotionDefinition quickPromotionDefinition2 : quickPromotionController.i()) {
                    QuickPromotionValidatorResult a;
                    preference2 = new Preference(this);
                    preference2.setTitle(quickPromotionDefinition2.promotionId);
                    QuickPromotionValidatorResult a2 = this.f4653b.a(quickPromotionDefinition2, null);
                    if (a2.f4871c) {
                        a = quickPromotionController.a(quickPromotionDefinition2, null);
                    } else {
                        a = a2;
                    }
                    preference2.setSummary(StringFormatUtil.a("Invalid: %s", new Object[]{a.f4875g.orNull()}));
                    preferenceCategory.addPreference(preference2);
                }
            }
        }
        setPreferenceScreen(createPreferenceScreen);
    }

    private void m4499a(final QuickPromotionDefinition quickPromotionDefinition) {
        String str;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.a(quickPromotionDefinition.promotionId + " " + this.f4664m[this.f4660i.a(QuickPromotionPrefKeys.m4651c(quickPromotionDefinition.promotionId), PromotionForceMode.DEFAULT.ordinal())].getStatusCaption());
        StringBuilder stringBuilder = new StringBuilder("[\n");
        for (ContextualFilter contextualFilter : quickPromotionDefinition.d()) {
            stringBuilder.append(StringFormatUtil.a("{type: %s, value: %s}\n", new Object[]{contextualFilter.a(), contextualFilter.value}));
        }
        stringBuilder.append("]");
        QuickPromotionValidatorResult a = this.f4654c.a(quickPromotionDefinition, null);
        String str2 = "false";
        if (a.f4871c) {
            a = this.f4655d.a(quickPromotionDefinition, null);
            if (a.f4871c) {
                str2 = quickPromotionDefinition.isExposureHoldout ? "false. Is in exposure holdout." : "true";
            } else if (a.f4873e.isPresent()) {
                str2 = StringFormatUtil.a("false.\nFailed Counter: %s", new Object[]{((QuickPromotionCounters$CounterType) a.f4873e.get()).getReadableName()});
            }
        } else if (a.f4872d.isPresent()) {
            str2 = StringFormatUtil.a("false.\nFailed filter: %s, value: %s", new Object[]{((ContextualFilter) a.f4872d.get()).a(), ((ContextualFilter) a.f4872d.get()).value});
        } else if (a.f4874f.isPresent()) {
            Map a2 = this.f4662k.m4588a(quickPromotionDefinition, (QuickPromotionDefinition$FilterClause) a.f4874f.get());
            StringBuilder stringBuilder2 = new StringBuilder("false.\nFailed filter clause. Contextual Filter Results:\n");
            for (Entry key : a2.entrySet()) {
                ContextualFilter contextualFilter2 = (ContextualFilter) key.getKey();
                stringBuilder2.append(StringFormatUtil.a("result: %b, filter: %s, value: %s \n", new Object[]{((Entry) r5.next()).getValue(), contextualFilter2.a(), contextualFilter2.value}));
            }
            str2 = stringBuilder2.toString();
        }
        String str3 = "Title: %s\n\nContent: %s\n\nMax Impressions: %s\nLocal Impressions: %s\n\nPrimary Action Limit: %s\nLocal Count: %s\n\nSecondary Action Limit: %s\nLocal Count: %s\n\nPriority: %s\n\nSocial Context:%s\n\nEligible?: %s\n\nTriggers: %s\n\nFilters: %s\n\nImage: %s";
        Object[] objArr = new Object[14];
        objArr[0] = quickPromotionDefinition.title;
        objArr[1] = quickPromotionDefinition.content;
        objArr[2] = Integer.valueOf(quickPromotionDefinition.maxImpressions);
        objArr[3] = Integer.valueOf(this.f4657f.c(quickPromotionDefinition, QuickPromotionCounters$CounterType.IMPRESSION));
        if (quickPromotionDefinition.primaryAction == null) {
            str = "null";
        } else {
            str = Integer.valueOf(quickPromotionDefinition.primaryAction.limit);
        }
        objArr[4] = str;
        objArr[5] = Integer.valueOf(this.f4657f.c(quickPromotionDefinition, QuickPromotionCounters$CounterType.PRIMARY_ACTION));
        if (quickPromotionDefinition.secondaryAction == null) {
            str = "null";
        } else {
            str = Integer.valueOf(quickPromotionDefinition.secondaryAction.limit);
        }
        objArr[6] = str;
        objArr[7] = Integer.valueOf(this.f4657f.c(quickPromotionDefinition, QuickPromotionCounters$CounterType.SECONDARY_ACTION));
        objArr[8] = Long.valueOf(quickPromotionDefinition.priority);
        if (quickPromotionDefinition.socialContext == null) {
            str = "null";
        } else {
            str = quickPromotionDefinition.socialContext.text;
        }
        objArr[9] = str;
        objArr[10] = str2;
        objArr[11] = Joiner.on(",").join(quickPromotionDefinition.a());
        objArr[12] = stringBuilder;
        if (quickPromotionDefinition.imageParams == null) {
            str2 = "null";
        } else {
            str2 = StringFormatUtil.a("{\n height: %d,\n width %d,\n scale: %f,\n name: %s,\n url: %s\n}", new Object[]{Integer.valueOf(quickPromotionDefinition.imageParams.height), Integer.valueOf(quickPromotionDefinition.imageParams.width), Float.valueOf(quickPromotionDefinition.imageParams.scale), quickPromotionDefinition.imageParams.name, quickPromotionDefinition.imageParams.uri});
        }
        objArr[13] = str2;
        builder.b(StringFormatUtil.a(str3, objArr));
        builder.a("Reset Counters", new OnClickListener(this) {
            final /* synthetic */ QuickPromotionSettingsActivity f4638b;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f4638b.m4507c(quickPromotionDefinition);
            }
        });
        builder.b("JSON", new OnClickListener(this) {
            final /* synthetic */ QuickPromotionSettingsActivity f4640b;

            public void onClick(DialogInterface dialogInterface, int i) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this.f4640b);
                try {
                    builder.b(this.f4640b.f4658g.h().a(quickPromotionDefinition));
                } catch (IOException e) {
                    Writer stringWriter = new StringWriter();
                    e.printStackTrace(new PrintWriter(stringWriter));
                    builder.b(stringWriter.toString());
                }
                builder.a().show();
            }
        });
        builder.c("Force Mode Options", new OnClickListener(this) {
            final /* synthetic */ QuickPromotionSettingsActivity f4642b;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f4642b.m4505b(quickPromotionDefinition);
            }
        });
        builder.a().show();
    }

    private void m4505b(final QuickPromotionDefinition quickPromotionDefinition) {
        int i = 0;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.a("Force Mode Options");
        final CharSequence[] charSequenceArr = new CharSequence[this.f4664m.length];
        PromotionForceMode[] promotionForceModeArr = this.f4664m;
        int length = promotionForceModeArr.length;
        int i2 = 0;
        while (i < length) {
            charSequenceArr[i2] = promotionForceModeArr[i].getActionCaption();
            i2++;
            i++;
        }
        builder.a(charSequenceArr, this.f4660i.a(QuickPromotionPrefKeys.m4651c(quickPromotionDefinition.promotionId), PromotionForceMode.DEFAULT.ordinal()), new OnClickListener(this) {
            final /* synthetic */ QuickPromotionSettingsActivity f4645c;

            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(this.f4645c.getApplicationContext(), charSequenceArr[i], 0).show();
                this.f4645c.f4660i.edit().a(QuickPromotionPrefKeys.m4651c(quickPromotionDefinition.promotionId), i).commit();
                this.f4645c.m4495a();
            }
        });
        builder.a().show();
    }

    private void m4507c(final QuickPromotionDefinition quickPromotionDefinition) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.a("Reset Counters");
        final int length = QuickPromotionCounters$CounterType.values().length;
        final boolean[] zArr = new boolean[length];
        CharSequence[] charSequenceArr = new CharSequence[length];
        for (int i = 0; i < length; i++) {
            charSequenceArr[i] = QuickPromotionCounters$CounterType.values()[i].getReadableName();
        }
        boolean[] zArr2 = new boolean[length];
        OnMultiChoiceClickListener c06208 = new OnMultiChoiceClickListener(this) {
            final /* synthetic */ QuickPromotionSettingsActivity f4647b;

            public void onClick(DialogInterface dialogInterface, int i, boolean z) {
                zArr[i] = true;
            }
        };
        builder.a.u = charSequenceArr;
        builder.a.I = c06208;
        builder.a.E = zArr2;
        builder.a.F = true;
        builder.a("GO!", new OnClickListener(this) {
            final /* synthetic */ QuickPromotionSettingsActivity f4651d;

            public void onClick(DialogInterface dialogInterface, int i) {
                for (int i2 = 0; i2 < length; i2++) {
                    if (zArr[i2]) {
                        QuickPromotionCounters quickPromotionCounters = this.f4651d.f4657f;
                        QuickPromotionDefinition quickPromotionDefinition = quickPromotionDefinition;
                        quickPromotionCounters.a.d(QuickPromotionCounters.a(QuickPromotionCounters$CounterType.values()[i2]), quickPromotionDefinition.promotionId);
                    }
                }
            }
        });
        builder.a().show();
    }

    private Preference m4502b() {
        Preference preference = new Preference(this);
        preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ QuickPromotionSettingsActivity f4632a;

            /* compiled from: referenced_sticker_data */
            class C06121 implements FutureCallback<OperationResult> {
                final /* synthetic */ AnonymousClass10 f4631a;

                C06121(AnonymousClass10 anonymousClass10) {
                    this.f4631a = anonymousClass10;
                }

                public void onSuccess(Object obj) {
                    this.f4631a.f4632a.m4495a();
                }

                public void onFailure(Throwable th) {
                    Toast.makeText(this.f4631a.f4632a, "Refresh failed", 1).show();
                }
            }

            {
                this.f4632a = r1;
            }

            public boolean onPreferenceClick(Preference preference) {
                FetchInterstitialsParams fetchInterstitialsParams = new FetchInterstitialsParams(ImmutableList.copyOf(this.f4632a.f4663l.values()));
                Bundle bundle = new Bundle();
                bundle.putParcelable("fetchAndUpdateInterstitialsParams", fetchInterstitialsParams);
                Operation a = BlueServiceOperationFactoryDetour.a(this.f4632a.f4656e, "interstitials_fetch_and_update", bundle, 839461796);
                a.a(new DialogBasedProgressIndicator(this.f4632a, "Fetching Promotions..."));
                Futures.a(a.a(), new C06121(this), this.f4632a.f4659h);
                return true;
            }
        });
        preference.setTitle("Refresh Quick Promotion Interstitial Data");
        return preference;
    }
}
