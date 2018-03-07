package com.facebook.productionprompts;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.feed.inlinecomposer.v2attachment.CanRenderV2Prompt;
import com.facebook.feed.inlinecomposer.v2attachment.V2Attachment;
import com.facebook.feed.inlinecomposer.v2attachment.V2PromptUtil;
import com.facebook.inject.Assisted;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.model.ProductionPrompt;
import com.facebook.productionprompts.model.PromptDisplayReason;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: reshare_status_update */
public class ProductionPromptV2Prompt implements CanRenderV2Prompt {
    private final PromptsExperimentHelper f4493a;
    private final ProductionPrompt f4494b;
    private final Drawable f4495c;

    @Inject
    public ProductionPromptV2Prompt(@Assisted ProductionPrompt productionPrompt, V2PromptUtil v2PromptUtil, PromptsExperimentHelper promptsExperimentHelper) {
        Preconditions.checkNotNull(productionPrompt);
        this.f4494b = productionPrompt;
        this.f4495c = v2PromptUtil.a();
        this.f4493a = promptsExperimentHelper;
    }

    public final Uri m4351f() {
        return this.f4494b.e();
    }

    @Nullable
    public final String m4346a() {
        return this.f4494b.b();
    }

    @Nullable
    public final String m4347b() {
        return this.f4494b.c();
    }

    public Integer mo210c() {
        return null;
    }

    @Nullable
    public final Drawable m4349d() {
        return null;
    }

    @Nullable
    public Drawable mo211e() {
        return this.f4493a.c() ? null : this.f4495c;
    }

    public V2Attachment mo212g() {
        return null;
    }

    @Nullable
    public final PromptDisplayReason m4353h() {
        return this.f4494b.p();
    }
}
