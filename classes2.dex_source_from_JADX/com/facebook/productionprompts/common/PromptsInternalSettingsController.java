package com.facebook.productionprompts.common;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: network_info_egress_max */
public class PromptsInternalSettingsController {
    private static final Object f12628e = new Object();
    public final AnalyticsLogger f12629a;
    public final Provider<TriState> f12630b;
    public final HashMap<String, PromptInternalSettingsModel> f12631c = new HashMap();
    public InlineComposerPromptSession f12632d;

    /* compiled from: network_info_egress_max */
    public class PromptInternalSettingsModel {
        public InlineComposerPromptSession f15117a;
        public String f15118b;
    }

    private static PromptsInternalSettingsController m18720b(InjectorLike injectorLike) {
        return new PromptsInternalSettingsController(IdBasedProvider.m1811a(injectorLike, 640), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike));
    }

    @Inject
    public PromptsInternalSettingsController(Provider<TriState> provider, AnalyticsLogger analyticsLogger) {
        this.f12630b = provider;
        this.f12629a = analyticsLogger;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.productionprompts.common.PromptsInternalSettingsController m18718a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.m1499a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.mo191b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.m1454a(r1);
        r4 = r3.m8951b();	 Catch:{ all -> 0x006c }
        r1 = f12628e;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.f724a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.m8952c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.m1504b(r1);	 Catch:{  }
        r6 = r0.m1455a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.m1474e();	 Catch:{ all -> 0x0062 }
        r1 = m18720b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.m1452a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f12628e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.f724a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.productionprompts.common.PromptsInternalSettingsController) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.m1505c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.productionprompts.common.PromptsInternalSettingsController) r0;	 Catch:{  }
        r3.m8952c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.m1452a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.m1505c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.m8952c();
        throw r0;
    L_0x0071:
        r0 = f12628e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.productionprompts.common.PromptsInternalSettingsController) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.productionprompts.common.PromptsInternalSettingsController.a(com.facebook.inject.InjectorLike):com.facebook.productionprompts.common.PromptsInternalSettingsController");
    }

    public final void m18725a(String str, String str2) {
        m18721c(str).f15118b = str2;
    }

    private void m18719a(String str, InlineComposerPromptSession inlineComposerPromptSession) {
        m18721c(str).f15117a = inlineComposerPromptSession;
    }

    private PromptInternalSettingsModel m18721c(String str) {
        PromptInternalSettingsModel promptInternalSettingsModel = (PromptInternalSettingsModel) this.f12631c.get(str);
        if (promptInternalSettingsModel != null) {
            return promptInternalSettingsModel;
        }
        promptInternalSettingsModel = new PromptInternalSettingsModel();
        this.f12631c.put(str, promptInternalSettingsModel);
        return promptInternalSettingsModel;
    }

    public final Set<String> m18727c() {
        return this.f12631c.keySet();
    }

    public final String m18723a(String str) {
        PromptInternalSettingsModel promptInternalSettingsModel = (PromptInternalSettingsModel) this.f12631c.get(str);
        return promptInternalSettingsModel == null ? "" : promptInternalSettingsModel.f15118b;
    }

    public final InlineComposerPromptSession m18726b(String str) {
        PromptInternalSettingsModel promptInternalSettingsModel = (PromptInternalSettingsModel) this.f12631c.get(str);
        return promptInternalSettingsModel == null ? null : promptInternalSettingsModel.f15117a;
    }

    public final void m18724a(ImmutableList<InlineComposerPromptSession> immutableList) {
        if (!immutableList.isEmpty()) {
            InlineComposerPromptSession inlineComposerPromptSession = (InlineComposerPromptSession) immutableList.get(0);
            this.f12632d = inlineComposerPromptSession;
            m18725a(inlineComposerPromptSession.f13409a.mo2494c(), "This prompt is being shown");
        }
        m18722c((ImmutableList) immutableList);
        if (this.f12630b.get() == TriState.YES) {
            for (String str : m18727c()) {
                String a = m18723a(str);
                boolean z = a != null && a.equals("This prompt is being shown");
                InlineComposerPromptSession b = m18726b(str);
                HoneyAnalyticsEvent a2 = new HoneyClientEvent("composer_prompt_not_displayed_reason").m5090b("prompt_type", str).m5090b("reason", a).m5087a("shown", z);
                if (b != null) {
                    a2.m5090b("prompt_id", b.f13409a.mo2493b());
                }
                this.f12629a.mo526a(a2);
            }
        }
    }

    private void m18722c(ImmutableList<InlineComposerPromptSession> immutableList) {
        for (int i = 1; i < immutableList.size(); i++) {
            Object obj;
            String c = ((InlineComposerPromptSession) immutableList.get(i)).f13409a.mo2494c();
            m18719a(c, (InlineComposerPromptSession) immutableList.get(i));
            PromptInternalSettingsModel promptInternalSettingsModel = (PromptInternalSettingsModel) this.f12631c.get(c);
            if (promptInternalSettingsModel == null || promptInternalSettingsModel.f15118b == null) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                m18725a(c, "Other prompt has higher priority");
            }
        }
    }
}
