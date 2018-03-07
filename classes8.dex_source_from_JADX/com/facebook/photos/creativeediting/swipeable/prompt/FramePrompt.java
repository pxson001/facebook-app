package com.facebook.photos.creativeediting.swipeable.prompt;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.feed.inlinecomposer.v2attachment.V2Attachment;
import com.facebook.feed.inlinecomposer.v2attachment.V2PromptUtil;
import com.facebook.inject.Assisted;
import com.facebook.ipc.productionprompts.ui.v2.PromptViewBindingObject;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.ProductionPrompt;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.facebook.productionprompts.model.PromptDisplayReason;
import com.facebook.productionprompts.model.PromptObject;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: spherical_photos */
public class FramePrompt implements PromptViewBindingObject {
    private final Drawable f2287a;
    private Context f2288b;
    private InlineComposerPromptSession f2289c;
    public ProductionPrompt f2290d;
    private FramePromptView f2291e;

    @Inject
    public FramePrompt(@Assisted Context context, @Assisted InlineComposerPromptSession inlineComposerPromptSession, V2PromptUtil v2PromptUtil, PromptsExperimentHelper promptsExperimentHelper) {
        this.f2288b = context;
        this.f2289c = inlineComposerPromptSession;
        PromptObject promptObject = (PromptObject) Preconditions.checkNotNull(InlineComposerPromptSession.a(inlineComposerPromptSession));
        Preconditions.checkArgument(promptObject instanceof ProductionPromptObject);
        this.f2290d = ((ProductionPromptObject) promptObject).a;
        this.f2287a = promptsExperimentHelper.c() ? null : v2PromptUtil.a();
    }

    @Nullable
    public final String m2413a() {
        return this.f2290d.b();
    }

    @Nullable
    public final String m2414b() {
        return this.f2290d.c();
    }

    @Nullable
    public final Integer m2415c() {
        return null;
    }

    @Nullable
    public final Drawable m2416d() {
        return null;
    }

    @Nullable
    public final Drawable m2417e() {
        return this.f2287a;
    }

    @Nullable
    public final Uri m2418f() {
        return this.f2290d.e();
    }

    @Nullable
    public final V2Attachment m2419g() {
        if (this.f2291e == null) {
            this.f2291e = new FramePromptView(this.f2288b);
            this.f2291e.m2426a(this.f2289c);
        }
        return this.f2291e;
    }

    @Nullable
    public final PromptDisplayReason m2420h() {
        return null;
    }
}
