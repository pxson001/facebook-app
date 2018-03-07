package com.facebook.productionprompts.common;

import android.util.Pair;
import com.facebook.common.time.SystemClock;
import com.facebook.feed.inlinecomposer.abtest.ExperimentsForInlineComposerTestModule;
import com.facebook.feed.photoreminder.abtest.ExperimentsForPhotoReminderAbTestModule;
import com.facebook.graphql.enums.GraphQLPromptType;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.prefs.PromptsPrefKeys;
import com.google.common.annotations.VisibleForTesting;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: netego_promote_instagram_modified_design */
public class PromptExponentialSleepHelper {
    private static final HashMap<String, Pair<PrefKey, PrefKey>> f12773d;
    @VisibleForTesting
    protected final int f12774a;
    @VisibleForTesting
    protected final int f12775b;
    @VisibleForTesting
    protected final int f12776c;
    public final FbSharedPreferences f12777e;
    private final PromptsExperimentHelper f12778f;

    static {
        HashMap hashMap = new HashMap();
        f12773d = hashMap;
        hashMap.put(GraphQLPromptType.PHOTO.toString(), new Pair(PromptsPrefKeys.f12789k, PromptsPrefKeys.f12786h));
        f12773d.put(GraphQLPromptType.PHOTO_WEEKEND.toString(), new Pair(PromptsPrefKeys.f12790l, PromptsPrefKeys.f12787i));
        f12773d.put(GraphQLPromptType.CLIPBOARD.toString(), new Pair(PromptsPrefKeys.f12791m, PromptsPrefKeys.f12788j));
    }

    @Inject
    public PromptExponentialSleepHelper(FbSharedPreferences fbSharedPreferences, PromptsExperimentHelper promptsExperimentHelper) {
        this.f12777e = fbSharedPreferences;
        this.f12778f = promptsExperimentHelper;
        this.f12774a = promptsExperimentHelper.f10219a.mo572a(ExperimentsForPhotoReminderAbTestModule.f12800c, 0);
        this.f12775b = promptsExperimentHelper.f10219a.mo572a(ExperimentsForPhotoReminderAbTestModule.f12799b, 0);
        this.f12776c = promptsExperimentHelper.f10219a.mo572a(ExperimentsForPhotoReminderAbTestModule.f12801d, 0);
    }

    @Nullable
    public static PrefKey m18818e(String str) {
        Pair pair = (Pair) f12773d.get(str);
        return (str == null || pair == null || pair.first == null) ? null : (PrefKey) pair.first;
    }

    @Nullable
    public static PrefKey m18819f(String str) {
        Pair pair = (Pair) f12773d.get(str);
        return (str == null || pair == null || pair.second == null) ? null : (PrefKey) pair.second;
    }

    @VisibleForTesting
    private Integer m18820g(String str) {
        PrefKey e = m18818e(str);
        return e == null ? null : Integer.valueOf(this.f12777e.mo276a(e, 0));
    }

    @VisibleForTesting
    private Long m18821h(String str) {
        PrefKey f = m18819f(str);
        return f == null ? null : Long.valueOf(this.f12777e.mo277a(f, SystemClock.f762a.mo211a()));
    }

    private void m18822i(String str) {
        PrefKey e = m18818e(str);
        if (e != null) {
            int intValue = m18820g(str).intValue();
            this.f12777e.edit().mo1274a(e, Math.min(intValue == 0 ? this.f12774a : intValue * this.f12776c, this.f12775b)).commit();
        }
    }

    private boolean m18823l(String str) {
        if (str == null) {
            return false;
        }
        if (str.equals(GraphQLPromptType.PHOTO.toString())) {
            return this.f12778f.f10219a.mo596a(ExperimentsForPhotoReminderAbTestModule.f12803f, false);
        }
        if (str.equals(GraphQLPromptType.CLIPBOARD.toString())) {
            return this.f12778f.f10219a.mo596a(ExperimentsForInlineComposerTestModule.f12761f, false);
        }
        return false;
    }

    private boolean m18824m(String str) {
        Long h = m18821h(str);
        Integer g = m18820g(str);
        if (h == null || g == null) {
            return false;
        }
        if (SystemClock.f762a.mo211a() < TimeUnit.MILLISECONDS.convert((long) g.intValue(), TimeUnit.HOURS) + h.longValue()) {
            return true;
        }
        return false;
    }

    public final boolean m18825a(String str) {
        return str != null && m18823l(str) && m18824m(str);
    }

    public final void m18826b(String str) {
        if (m18823l(str)) {
            PrefKey f = m18819f(str);
            if (f != null) {
                this.f12777e.edit().mo1275a(f, SystemClock.f762a.mo211a()).commit();
            }
        }
    }

    public final void m18827c(String str) {
        if (m18823l(str)) {
            m18822i(str);
        }
    }

    public final void m18828d(String str) {
        if (m18823l(str)) {
            PrefKey e = m18818e(str);
            if (e != null) {
                this.f12777e.edit().mo1274a(e, 0).commit();
            }
        }
    }
}
