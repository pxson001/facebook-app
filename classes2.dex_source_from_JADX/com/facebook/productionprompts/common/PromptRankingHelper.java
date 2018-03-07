package com.facebook.productionprompts.common;

import com.facebook.inject.InjectorLike;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.InlineComposerPromptSession.Builder;
import com.facebook.productionprompts.model.ProductionPrompt;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.facebook.productionprompts.model.PromptInfo;
import com.facebook.productionprompts.model.PromptObject;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import javax.inject.Inject;

/* compiled from: network */
public class PromptRankingHelper {
    private final ClientPromptRanker f12766a;

    /* compiled from: network */
    class C07711 implements Comparator<InlineComposerPromptSession> {
        final /* synthetic */ PromptRankingHelper f19358a;

        C07711(PromptRankingHelper promptRankingHelper) {
            this.f19358a = promptRankingHelper;
        }

        public int compare(Object obj, Object obj2) {
            InlineComposerPromptSession inlineComposerPromptSession = (InlineComposerPromptSession) obj;
            InlineComposerPromptSession inlineComposerPromptSession2 = (InlineComposerPromptSession) obj2;
            double d = 0.001d;
            double d2 = inlineComposerPromptSession.f13410b == null ? 0.001d : inlineComposerPromptSession.f13410b.f15100d;
            if (inlineComposerPromptSession.f13410b != null) {
                d = inlineComposerPromptSession2.f13410b.f15100d;
            }
            return Double.compare(d, d2);
        }
    }

    public static PromptRankingHelper m18808a(InjectorLike injectorLike) {
        return new PromptRankingHelper(ClientPromptRanker.m18762a(injectorLike));
    }

    @Inject
    public PromptRankingHelper(ClientPromptRanker clientPromptRanker) {
        this.f12766a = clientPromptRanker;
    }

    public final ImmutableList<InlineComposerPromptSession> m18812a(ImmutableList<PromptObject> immutableList, InlineComposerPromptSession inlineComposerPromptSession) {
        return m18811b(immutableList, inlineComposerPromptSession);
    }

    @VisibleForTesting
    private ImmutableList<InlineComposerPromptSession> m18811b(ImmutableList<PromptObject> immutableList, InlineComposerPromptSession inlineComposerPromptSession) {
        Collection a = Lists.m1297a(immutableList.size() + 1);
        if (inlineComposerPromptSession != null && m18809a(inlineComposerPromptSession.f13409a, (ImmutableList) immutableList)) {
            a.add(inlineComposerPromptSession);
        }
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            PromptObject promptObject = (PromptObject) immutableList.get(i);
            PromptInfo b = m18810b(promptObject);
            if (b.f15100d != 0.0d) {
                a.add(new Builder().a(promptObject).a(b).a());
            }
        }
        Collections.sort(a, new C07711(this));
        return ImmutableList.copyOf(a);
    }

    private static boolean m18809a(PromptObject promptObject, ImmutableList<PromptObject> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            PromptObject promptObject2 = (PromptObject) immutableList.get(i);
            if (!(promptObject instanceof ProductionPromptObject) || promptObject2.mo2493b().equals(promptObject.mo2493b())) {
                return true;
            }
        }
        return false;
    }

    private PromptInfo m18810b(PromptObject promptObject) {
        if (!promptObject.getClass().equals(ProductionPromptObject.class)) {
            return this.f12766a.m18764a(promptObject);
        }
        ProductionPrompt productionPrompt = ((ProductionPromptObject) promptObject).f12765a;
        return PromptInfo.m21642a(productionPrompt.o(), productionPrompt.i(), productionPrompt.n(), productionPrompt.q());
    }
}
