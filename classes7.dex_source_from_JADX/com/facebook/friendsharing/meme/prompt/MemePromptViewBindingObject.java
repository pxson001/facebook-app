package com.facebook.friendsharing.meme.prompt;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.feed.inlinecomposer.v2attachment.V2Attachment;
import com.facebook.ipc.productionprompts.ui.v2.PromptViewBindingObject;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.ProductionPrompt;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.facebook.productionprompts.model.PromptDisplayReason;
import com.facebook.productionprompts.model.PromptObject;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: Reset  */
public class MemePromptViewBindingObject implements PromptViewBindingObject {
    private Context f23982a;
    private ProductionPrompt f23983b;
    private MemePromptView f23984c = new MemePromptView(this.f23982a);
    private InlineComposerPromptSession f23985d;

    @VisibleForTesting
    public MemePromptViewBindingObject(Context context, InlineComposerPromptSession inlineComposerPromptSession) {
        PromptObject a = InlineComposerPromptSession.a(inlineComposerPromptSession);
        Preconditions.checkState(a instanceof ProductionPromptObject);
        this.f23982a = context;
        this.f23985d = inlineComposerPromptSession;
        this.f23983b = ((ProductionPromptObject) a).a;
    }

    @Nullable
    public final String m26099a() {
        return this.f23983b.b();
    }

    @Nullable
    public final String m26100b() {
        return this.f23983b.c();
    }

    @Nullable
    public final Integer m26101c() {
        return null;
    }

    @Nullable
    public final Drawable m26102d() {
        return null;
    }

    @Nullable
    public final Drawable m26103e() {
        return null;
    }

    @Nullable
    public final Uri m26104f() {
        return this.f23983b.e();
    }

    @Nullable
    public final V2Attachment m26105g() {
        if (this.f23984c != null) {
            this.f23984c.m26097a(this.f23985d);
        }
        return this.f23984c;
    }

    @Nullable
    public final PromptDisplayReason m26106h() {
        return null;
    }
}
