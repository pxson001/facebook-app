package com.facebook.productionprompts.common;

import android.content.Context;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.feed.inlinecomposer.model.InlineComposerModel;
import com.facebook.feed.inlinecomposer.v2attachment.CanRenderV2Prompt;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.ipc.productionprompts.ui.v2.C0535x865d8f2e;
import com.facebook.ipc.productionprompts.ui.v2.DelegatingPromptViewController;
import com.facebook.ipc.productionprompts.ui.v2.PromptViewController;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UserScoped
/* compiled from: mp_android_backstage_landing_page */
public class InlineComposerPromptViewController extends DelegatingPromptViewController {
    private static final Object f13297c = new Object();
    private final PromptsExperimentHelper f13298b;

    private static InlineComposerPromptViewController m19562b(InjectorLike injectorLike) {
        return new InlineComposerPromptViewController(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new C0535x865d8f2e(injectorLike)), PromptsExperimentHelper.m15312b(injectorLike));
    }

    @Inject
    public InlineComposerPromptViewController(Set<PromptViewController> set, PromptsExperimentHelper promptsExperimentHelper) {
        super(set);
        this.f13298b = promptsExperimentHelper;
    }

    public final boolean mo2616e(InlineComposerPromptSession inlineComposerPromptSession) {
        return true;
    }

    public final void mo2612a(@Nullable V2ObjectsRequiredForBinding v2ObjectsRequiredForBinding, @Nullable InlineComposerPromptSession inlineComposerPromptSession) {
        if (!this.f13298b.m15315d()) {
            super.mo2612a(v2ObjectsRequiredForBinding, inlineComposerPromptSession);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.productionprompts.common.InlineComposerPromptViewController m19561a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f13297c;	 Catch:{ all -> 0x006c }
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
        r1 = m19562b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.m1452a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f13297c;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.f724a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.productionprompts.common.InlineComposerPromptViewController) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.m1505c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.productionprompts.common.InlineComposerPromptViewController) r0;	 Catch:{  }
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
        r0 = f13297c;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.productionprompts.common.InlineComposerPromptViewController) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.productionprompts.common.InlineComposerPromptViewController.a(com.facebook.inject.InjectorLike):com.facebook.productionprompts.common.InlineComposerPromptViewController");
    }

    public final void mo2615b(@Nullable V2ObjectsRequiredForBinding v2ObjectsRequiredForBinding, @Nullable InlineComposerPromptSession inlineComposerPromptSession) {
        if (!this.f13298b.m15315d()) {
            super.mo2615b(v2ObjectsRequiredForBinding, inlineComposerPromptSession);
        }
    }

    public final void mo2614a(boolean z, @Nullable InlineComposerPromptSession inlineComposerPromptSession) {
        if (!this.f13298b.m15315d()) {
            super.mo2614a(z, inlineComposerPromptSession);
        }
    }

    public final void mo2613a(@Nullable InlineComposerPromptSession inlineComposerPromptSession) {
        if (!this.f13298b.m15315d()) {
            super.mo2613a(inlineComposerPromptSession);
        }
    }

    @Nullable
    public final CanRenderV2Prompt m19563a(InlineComposerModel inlineComposerModel, Context context) {
        return mo2617a(inlineComposerModel.f12908c, context);
    }
}
