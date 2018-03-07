package com.facebook.productionprompts.common;

import com.facebook.feed.photoreminder.abtest.PhotoReminderGatekeepers;
import com.facebook.graphql.enums.GraphQLPromptType;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.productionprompts.abtest.ClipboardPromptsGatekeepers;
import com.facebook.productionprompts.abtest.ExperimentsForProductionPromptsAbtestModule;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import javax.inject.Inject;

/* compiled from: netego_promote_instagram_new_design */
public class PromptSleepHelper {
    public final PromptExponentialSleepHelper f12770a;
    public final PromptAccumulateSleepHelper f12771b;
    public final PromptsExperimentHelper f12772c;

    public static PromptSleepHelper m18816b(InjectorLike injectorLike) {
        return new PromptSleepHelper(new PromptExponentialSleepHelper(FbSharedPreferencesImpl.m1826a(injectorLike), PromptsExperimentHelper.m15312b(injectorLike)), new PromptAccumulateSleepHelper(FbSharedPreferencesImpl.m1826a(injectorLike), PromptsExperimentHelper.m15312b(injectorLike)), PromptsExperimentHelper.m15312b(injectorLike));
    }

    @Inject
    public PromptSleepHelper(PromptExponentialSleepHelper promptExponentialSleepHelper, PromptAccumulateSleepHelper promptAccumulateSleepHelper, PromptsExperimentHelper promptsExperimentHelper) {
        this.f12770a = promptExponentialSleepHelper;
        this.f12771b = promptAccumulateSleepHelper;
        this.f12772c = promptsExperimentHelper;
    }

    public static PromptSleepHelper m18815a(InjectorLike injectorLike) {
        return m18816b(injectorLike);
    }

    public final boolean m18817d(String str) {
        boolean z;
        if (str == null) {
            z = false;
        } else if (str.equals(GraphQLPromptType.PHOTO.toString())) {
            r2 = this.f12772c;
            r3 = false;
            if (r2.f10219a.mo596a(ExperimentsForProductionPromptsAbtestModule.f13412a, false) || r2.f10220b.f10222a.m2189a(PhotoReminderGatekeepers.f13995c, false)) {
                r3 = true;
            }
            z = r3;
        } else if (str.equals(GraphQLPromptType.CLIPBOARD.toString())) {
            r2 = this.f12772c;
            r3 = false;
            if (r2.f10219a.mo596a(ExperimentsForProductionPromptsAbtestModule.f13413b, false) || r2.f10221c.m2189a(ClipboardPromptsGatekeepers.a, false)) {
                r3 = true;
            }
            z = r3;
        } else {
            z = true;
        }
        if (z) {
            return false;
        }
        if (this.f12770a.m18825a(str) || this.f12771b.m18836a(str)) {
            return true;
        }
        return false;
    }
}
