package com.facebook.ipc.productionprompts.ui.v2;

import com.facebook.feed.inlinecomposer.v2attachment.CanRenderV2Prompt;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: missing_config */
public final class PromptPartDefinitionProps {
    public final InlineComposerPromptSession f13441a;
    public final CacheableEntity f13442b;
    public final CanRenderV2Prompt f13443c;

    public PromptPartDefinitionProps(InlineComposerPromptSession inlineComposerPromptSession, CacheableEntity cacheableEntity, CanRenderV2Prompt canRenderV2Prompt) {
        this.f13441a = inlineComposerPromptSession;
        this.f13442b = cacheableEntity;
        this.f13443c = canRenderV2Prompt;
    }
}
