package com.facebook.feed.photoreminder;

import android.content.Context;
import com.facebook.feed.inlinecomposer.v2attachment.CanRenderV2Prompt;
import com.facebook.feed.photoreminder.model.PhotoReminderPromptObject;
import com.facebook.ipc.productionprompts.ui.v2.PromptViewController;
import com.facebook.productionprompts.common.V2ObjectsRequiredForBinding;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.PromptObject;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mounted */
public class PhotoReminderPromptViewController implements PromptViewController {
    private final MediaReminderUtil f13301a;
    private final Context f13302b;

    @Inject
    public PhotoReminderPromptViewController(MediaReminderUtil mediaReminderUtil, Context context) {
        this.f13301a = mediaReminderUtil;
        this.f13302b = context;
    }

    public final boolean mo2616e(InlineComposerPromptSession inlineComposerPromptSession) {
        PromptObject a = InlineComposerPromptSession.m19774a(inlineComposerPromptSession);
        return a != null && (a instanceof PhotoReminderPromptObject);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.facebook.ipc.productionprompts.ui.v2.PromptViewBindingObject mo2617a(com.facebook.productionprompts.model.InlineComposerPromptSession r5, android.content.Context r6) {
        /*
        r4 = this;
        r0 = com.facebook.productionprompts.model.InlineComposerPromptSession.m19774a(r5);
        r0 = (com.facebook.feed.photoreminder.model.PhotoReminderPromptObject) r0;
        r1 = r4.f13301a;
        r2 = r0.f12633a;
        r0 = r2;
        r3 = 1;
        r2 = r3;
        if (r2 != 0) goto L_0x0012;
    L_0x000f:
        r2 = 0;
    L_0x0010:
        r0 = r2;
        return r0;
    L_0x0012:
        r2 = r1.f12620o;
        if (r2 == 0) goto L_0x002a;
    L_0x0016:
        r2 = r1.f12620o;
        r3 = r2.b;
        r3 = r3.getContext();
        r3 = r3 instanceof android.app.Activity;
        if (r3 != 0) goto L_0x003d;
    L_0x0022:
        r3 = r6 instanceof android.app.Activity;
        if (r3 == 0) goto L_0x003d;
    L_0x0026:
        r3 = 1;
    L_0x0027:
        r2 = r3;
        if (r2 == 0) goto L_0x0031;
    L_0x002a:
        r2 = new com.facebook.feed.photoreminder.MediaReminderUtil$V2PhotoReminderPrompt;
        r2.<init>(r1, r6);
        r1.f12620o = r2;
    L_0x0031:
        r2 = r1.f12620o;
        r2.c = r0;
        r3 = r2.b;
        r3.a(r0);
        r2 = r1.f12620o;
        goto L_0x0010;
    L_0x003d:
        r3 = 0;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.photoreminder.PhotoReminderPromptViewController.a(com.facebook.productionprompts.model.InlineComposerPromptSession, android.content.Context):com.facebook.ipc.productionprompts.ui.v2.PromptViewBindingObject");
    }

    public final void mo2612a(@Nullable V2ObjectsRequiredForBinding v2ObjectsRequiredForBinding, InlineComposerPromptSession inlineComposerPromptSession) {
        if ((InlineComposerPromptSession.m19774a(inlineComposerPromptSession) instanceof PhotoReminderPromptObject) && m19585d(inlineComposerPromptSession) != null) {
            m19585d(inlineComposerPromptSession).setPromptSession(inlineComposerPromptSession);
        }
    }

    public final void mo2615b(@Nullable V2ObjectsRequiredForBinding v2ObjectsRequiredForBinding, InlineComposerPromptSession inlineComposerPromptSession) {
    }

    public final void mo2614a(boolean z, InlineComposerPromptSession inlineComposerPromptSession) {
        PromptObject a = InlineComposerPromptSession.m19774a(inlineComposerPromptSession);
        if (!z && (a instanceof PhotoReminderPromptObject) && m19585d(inlineComposerPromptSession) != null) {
            m19585d(inlineComposerPromptSession).a(((PhotoReminderPromptObject) a).f12633a);
        }
    }

    public final void mo2613a(InlineComposerPromptSession inlineComposerPromptSession) {
    }

    public final void mo2618b(InlineComposerPromptSession inlineComposerPromptSession) {
        if ((InlineComposerPromptSession.m19774a(inlineComposerPromptSession) instanceof PhotoReminderPromptObject) && m19585d(inlineComposerPromptSession) != null) {
            m19585d(inlineComposerPromptSession);
        }
    }

    public final void mo2619c(InlineComposerPromptSession inlineComposerPromptSession) {
        if ((InlineComposerPromptSession.m19774a(inlineComposerPromptSession) instanceof PhotoReminderPromptObject) && m19585d(inlineComposerPromptSession) != null) {
            m19585d(inlineComposerPromptSession);
        }
    }

    @Nullable
    private PhotoReminderV2View m19585d(InlineComposerPromptSession inlineComposerPromptSession) {
        CanRenderV2Prompt a = mo2617a(inlineComposerPromptSession, this.f13302b);
        return a == null ? null : (PhotoReminderV2View) a.mo2631g();
    }
}
