package com.facebook.productionprompts.common;

import android.content.Context;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import com.facebook.base.activity.FbPreferenceActivity;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import javax.inject.Inject;

/* compiled from: request_timeout */
public class PromptsInternalSettingsActivity extends FbPreferenceActivity {
    @Inject
    public PromptsInternalSettingsController f4510a;

    private static <T extends Context> void m4369a(Class<T> cls, T t) {
        m4370a((Object) t, (Context) t);
    }

    public static void m4370a(Object obj, Context context) {
        ((PromptsInternalSettingsActivity) obj).f4510a = PromptsInternalSettingsController.a(FbInjector.get(context));
    }

    protected final void m4372c(Bundle bundle) {
        super.c(bundle);
        Class cls = PromptsInternalSettingsActivity.class;
        m4370a((Object) this, (Context) this);
        m4365a();
    }

    protected void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1438850780);
        super.onStop();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1219847056, a);
    }

    private void m4365a() {
        PreferenceScreen createPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
        InlineComposerPromptSession inlineComposerPromptSession = this.f4510a.d;
        m4367a(createPreferenceScreen, inlineComposerPromptSession);
        m4371b(createPreferenceScreen, inlineComposerPromptSession);
        setPreferenceScreen(createPreferenceScreen);
    }

    private void m4368a(PromptsInternalSettingsController promptsInternalSettingsController) {
        this.f4510a = promptsInternalSettingsController;
    }

    private void m4367a(PreferenceScreen preferenceScreen, InlineComposerPromptSession inlineComposerPromptSession) {
        Preference preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Prompt being shown");
        preferenceScreen.addPreference(preferenceCategory);
        if (inlineComposerPromptSession != null) {
            m4366a(preferenceCategory, inlineComposerPromptSession.a.c(), true);
        }
    }

    private void m4371b(PreferenceScreen preferenceScreen, InlineComposerPromptSession inlineComposerPromptSession) {
        Preference preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Prompts that are not shown");
        preferenceScreen.addPreference(preferenceCategory);
        for (String str : this.f4510a.c()) {
            if (inlineComposerPromptSession == null || !inlineComposerPromptSession.a.c().equals(str)) {
                m4366a(preferenceCategory, str, false);
            }
        }
    }

    private void m4366a(PreferenceCategory preferenceCategory, String str, boolean z) {
        Preference preference = new Preference(this);
        preference.setTitle(str);
        preference.setSummary(m4364a(z ? "" : this.f4510a.a(str), this.f4510a.b(str)));
        preferenceCategory.addPreference(preference);
    }

    private static String m4364a(String str, InlineComposerPromptSession inlineComposerPromptSession) {
        return inlineComposerPromptSession == null ? str : str + "\n\nPrompt ID: " + inlineComposerPromptSession.a.b() + "\nTracking String: " + inlineComposerPromptSession.b.b + "\nRanking Score: " + inlineComposerPromptSession.b.d + "\nPrompt Confidence: " + inlineComposerPromptSession.b.e;
    }
}
