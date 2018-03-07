package com.facebook.friendsharing.suggestedcoverphotos.prompt;

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
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: ★ */
public class CoverPhotoPromptViewBindingObject implements PromptViewBindingObject {
    private final InlineComposerPromptSession f0a;
    private final ProductionPrompt f1b;
    private final CoverPhotoPromptView f2c;

    public CoverPhotoPromptViewBindingObject(Context context, InlineComposerPromptSession inlineComposerPromptSession) {
        this.f0a = inlineComposerPromptSession;
        PromptObject a = InlineComposerPromptSession.a(inlineComposerPromptSession);
        Preconditions.checkState(a instanceof ProductionPromptObject);
        this.f1b = ((ProductionPromptObject) a).a;
        this.f2c = new CoverPhotoPromptView(context);
    }

    @Nullable
    public final String m0a() {
        return this.f1b.b();
    }

    @Nullable
    public final String m1b() {
        return this.f1b.c();
    }

    @Nullable
    public final Integer m2c() {
        return null;
    }

    @Nullable
    public final Drawable m3d() {
        return null;
    }

    @Nullable
    public final Drawable m4e() {
        return null;
    }

    @Nullable
    public final Uri m5f() {
        return this.f1b.e();
    }

    @Nullable
    public final V2Attachment m6g() {
        if (this.f2c != null) {
            this.f2c.a(this.f0a);
        }
        return this.f2c;
    }

    @Nullable
    public final PromptDisplayReason m7h() {
        return null;
    }
}
