package com.facebook.productionprompts;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.facebook.feed.inlinecomposer.v2attachment.V2Attachment;
import com.facebook.feed.inlinecomposer.v2attachment.V2PromptUtil;
import com.facebook.inject.Assisted;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.model.ProductionPrompt;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: reshare_photo */
public class ClipboardV2Prompt extends ProductionPromptV2Prompt {
    private final Context f4496a;
    private final ClipboardPromptV2Attachment f4497b;
    private final PromptsExperimentHelper f4498c;

    @Inject
    public ClipboardV2Prompt(@Assisted ProductionPrompt productionPrompt, Context context, V2PromptUtil v2PromptUtil, PromptsExperimentHelper promptsExperimentHelper) {
        super(productionPrompt, v2PromptUtil, promptsExperimentHelper);
        this.f4496a = context;
        this.f4498c = promptsExperimentHelper;
        this.f4497b = new ClipboardPromptV2Attachment(context);
        ClipboardPromptV2Attachment clipboardPromptV2Attachment = this.f4497b;
        clipboardPromptV2Attachment.f4482a.setText(productionPrompt.f());
    }

    public final Integer mo210c() {
        return this.f4498c.c() ? null : Integer.valueOf(this.f4496a.getResources().getColor(2131361936));
    }

    public final V2Attachment mo212g() {
        return this.f4497b;
    }

    @Nullable
    public final Drawable mo211e() {
        return null;
    }
}
