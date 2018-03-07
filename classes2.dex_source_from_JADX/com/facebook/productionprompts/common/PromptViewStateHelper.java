package com.facebook.productionprompts.common;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLPromptConfidence;
import com.facebook.inject.InjectorLike;
import com.facebook.productionprompts.abtest.ProductionPromptsGatekeepers;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.PromptViewState;
import com.facebook.productionprompts.model.PromptViewState$Visibility;
import com.facebook.productionprompts.prefs.PromptsPrefKeys;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: netstats connection lost */
public class PromptViewStateHelper {
    public final PromptSleepHelper f12767a;
    public final PersistentHiddenStateHelper f12768b;
    public final GatekeeperStoreImpl f12769c;

    public static PromptViewStateHelper m18813a(InjectorLike injectorLike) {
        return new PromptViewStateHelper(PromptSleepHelper.m18816b(injectorLike), PersistentHiddenStateHelper.m18839a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public PromptViewStateHelper(PromptSleepHelper promptSleepHelper, PersistentHiddenStateHelper persistentHiddenStateHelper, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f12767a = promptSleepHelper;
        this.f12768b = persistentHiddenStateHelper;
        this.f12769c = gatekeeperStoreImpl;
    }

    public final ImmutableList<InlineComposerPromptSession> m18814a(ImmutableList<InlineComposerPromptSession> immutableList, InlineComposerPromptSession inlineComposerPromptSession) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            InlineComposerPromptSession inlineComposerPromptSession2 = (InlineComposerPromptSession) immutableList.get(i);
            if (inlineComposerPromptSession != inlineComposerPromptSession2) {
                boolean z;
                Object obj;
                String c = inlineComposerPromptSession2.f13409a.mo2494c();
                String b = inlineComposerPromptSession2.f13409a.mo2493b();
                String str = inlineComposerPromptSession2.f13410b.f15101e;
                PersistentHiddenStateHelper persistentHiddenStateHelper = this.f12768b;
                if (Strings.isNullOrEmpty(b)) {
                    z = false;
                } else {
                    z = b.equals(persistentHiddenStateHelper.f12823a.mo278a(PromptsPrefKeys.f12797s, null));
                }
                if (!(z || this.f12767a.m18817d(c))) {
                    z = false;
                    if (str != null && this.f12769c.m2189a(ProductionPromptsGatekeepers.f13529c, false) && (str.equals(GraphQLPromptConfidence.LOW.toString()) || str.equals(GraphQLPromptConfidence.VERY_LOW.toString()))) {
                        z = true;
                    }
                    if (!z) {
                        obj = null;
                        if (obj != null) {
                            builder.m1069c(new InlineComposerPromptSession.Builder(inlineComposerPromptSession2).a(new PromptViewState(PromptViewState$Visibility.MINIMIZED, false)).a());
                        }
                    }
                }
                obj = 1;
                if (obj != null) {
                    builder.m1069c(new InlineComposerPromptSession.Builder(inlineComposerPromptSession2).a(new PromptViewState(PromptViewState$Visibility.MINIMIZED, false)).a());
                }
            }
            builder.m1069c(inlineComposerPromptSession2);
        }
        return builder.m1068b();
    }
}
