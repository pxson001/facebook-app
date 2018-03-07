package com.facebook.feed.inlinecomposer.multirow;

import com.facebook.feed.inlinecomposer.model.InlineComposerModel;
import com.facebook.feed.inlinecomposer.model.InlineComposerModelBuilder;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import javax.annotation.Nullable;

/* compiled from: android_groups_new_member_exp_cta_imp */
public class InlineComposerMultiRowInjectedFeedAdapter$2 {
    final /* synthetic */ InlineComposerMultiRowInjectedFeedAdapter f19246a;

    InlineComposerMultiRowInjectedFeedAdapter$2(InlineComposerMultiRowInjectedFeedAdapter inlineComposerMultiRowInjectedFeedAdapter) {
        this.f19246a = inlineComposerMultiRowInjectedFeedAdapter;
    }

    public final void m22754a(@Nullable InlineComposerPromptSession inlineComposerPromptSession) {
        InlineComposerModelBuilder inlineComposerModelBuilder = new InlineComposerModelBuilder((InlineComposerModel) this.f19246a.a.a(0));
        inlineComposerModelBuilder.c = inlineComposerPromptSession;
        this.f19246a.a.a = inlineComposerModelBuilder.a();
        this.f19246a.q.run();
    }
}
