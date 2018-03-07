package com.facebook.productionprompts.common;

import com.facebook.feed.inlinecomposer.abtest.ExperimentsForInlineComposerTestModule;
import com.facebook.feed.photoreminder.abtest.ExperimentsForPhotoReminderAbTestModule;
import com.facebook.graphql.enums.GraphQLPromptType;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.prefs.PromptsPrefKeys;
import com.google.common.annotations.VisibleForTesting;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: netego_promote_instagram_friend_count_75 */
public class PromptAccumulateSleepHelper {
    private static final HashMap<String, PrefKey> f12818a;
    private final FbSharedPreferences f12819b;
    private final PromptsExperimentHelper f12820c;

    static {
        HashMap hashMap = new HashMap();
        f12818a = hashMap;
        hashMap.put(GraphQLPromptType.PHOTO.toString(), PromptsPrefKeys.f12792n);
        f12818a.put(GraphQLPromptType.PHOTO_WEEKEND.toString(), PromptsPrefKeys.f12793o);
        f12818a.put(GraphQLPromptType.CLIPBOARD.toString(), PromptsPrefKeys.f12794p);
    }

    @Inject
    public PromptAccumulateSleepHelper(FbSharedPreferences fbSharedPreferences, PromptsExperimentHelper promptsExperimentHelper) {
        this.f12819b = fbSharedPreferences;
        this.f12820c = promptsExperimentHelper;
    }

    @Nullable
    private static PrefKey m18831d(String str) {
        return str == null ? null : (PrefKey) f12818a.get(str);
    }

    @VisibleForTesting
    private Integer m18832e(String str) {
        PrefKey d = m18831d(str);
        return d == null ? null : Integer.valueOf(this.f12819b.mo276a(d, 0));
    }

    @VisibleForTesting
    private void m18833f(String str) {
        PrefKey d = m18831d(str);
        if (d != null) {
            this.f12819b.edit().mo1274a(d, 0).commit();
        }
    }

    private void m18834g(String str) {
        PrefKey d = m18831d(str);
        if (d != null) {
            this.f12819b.edit().mo1274a(d, m18832e(str).intValue() + 1).commit();
        }
    }

    private boolean m18835h(String str) {
        if (str == null) {
            return false;
        }
        if (str.equals(GraphQLPromptType.PHOTO.toString())) {
            return this.f12820c.f10219a.mo596a(ExperimentsForPhotoReminderAbTestModule.f12802e, false);
        }
        if (str.equals(GraphQLPromptType.CLIPBOARD.toString())) {
            return this.f12820c.f10219a.mo596a(ExperimentsForInlineComposerTestModule.f12759d, false);
        }
        return false;
    }

    public final boolean m18836a(String str) {
        Integer e = m18832e(str);
        return str != null && e != null && m18835h(str) && e.intValue() >= 3;
    }

    public final void m18837b(String str) {
        if (m18835h(str)) {
            m18834g(str);
        }
    }

    public final void m18838c(String str) {
        if (m18835h(str)) {
            m18833f(str);
        }
    }
}
