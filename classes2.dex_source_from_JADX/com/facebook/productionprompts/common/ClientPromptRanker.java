package com.facebook.productionprompts.common;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.graphql.enums.GraphQLPromptConfidence;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.productionprompts.graphql.C0582x78ef048a.ClientProductionPromptsModel;
import com.facebook.productionprompts.graphql.C0658x37f5d27d;
import com.facebook.productionprompts.model.PromptInfo;
import com.facebook.productionprompts.model.PromptObject;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: network_info_can_wait_req */
public class ClientPromptRanker {
    private static final String f12700a = ClientPromptRanker.class.getSimpleName();
    private static final String f12701b = GraphQLPromptConfidence.NEUTRAL.toString();
    private static ClientPromptRanker f12702e;
    private static final Object f12703f = new Object();
    private final AbstractFbErrorReporter f12704c;
    private final Map<String, PromptInfo> f12705d = new HashMap();

    private static ClientPromptRanker m18763b(InjectorLike injectorLike) {
        return new ClientPromptRanker(FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public ClientPromptRanker(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f12704c = abstractFbErrorReporter;
    }

    public final synchronized void m18765a(@Nullable ClientProductionPromptsModel clientProductionPromptsModel) {
        if (clientProductionPromptsModel != null) {
            ImmutableList a = clientProductionPromptsModel.m21629a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                C0658x37f5d27d c0658x37f5d27d = (C0658x37f5d27d) a.get(i);
                Preconditions.checkNotNull(c0658x37f5d27d.m21636k());
                if (!this.f12705d.containsKey(c0658x37f5d27d.m21636k().toString())) {
                    this.f12705d.put(c0658x37f5d27d.m21636k().toString(), PromptInfo.m21642a(c0658x37f5d27d.m21638m(), c0658x37f5d27d.m21636k().toString(), c0658x37f5d27d.m21637l(), ((GraphQLPromptConfidence) Preconditions.checkNotNull(c0658x37f5d27d.m21635j())).toString()));
                }
            }
        }
    }

    public final synchronized PromptInfo m18764a(PromptObject promptObject) {
        PromptInfo promptInfo;
        if (this.f12705d.containsKey(promptObject.mo2494c())) {
            promptInfo = (PromptInfo) this.f12705d.get(promptObject.mo2494c());
        } else {
            this.f12704c.m2350b(f12700a, StringFormatUtil.formatStrLocaleSafe("prompt type not found: %s. Client prompt types stored: %s", promptObject.mo2494c(), this.f12705d.keySet().toString()));
            promptInfo = PromptInfo.m21642a("ranking_unavailable", promptObject.mo2494c(), 0.001d, f12701b);
        }
        return promptInfo;
    }

    public static ClientPromptRanker m18762a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ClientPromptRanker b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f12703f) {
                ClientPromptRanker clientPromptRanker;
                if (a2 != null) {
                    clientPromptRanker = (ClientPromptRanker) a2.mo818a(f12703f);
                } else {
                    clientPromptRanker = f12702e;
                }
                if (clientPromptRanker == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m18763b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f12703f, b3);
                        } else {
                            f12702e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = clientPromptRanker;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
