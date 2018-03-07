package com.facebook.friendsharing.meme.prompt;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.inject.Assisted;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextFactory;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.productionprompts.common.InlineComposerPromptActionHandler;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: Roboto */
public class MemePromptClickListener implements OnClickListener {
    private final InlineComposerPromptActionHandler f23954a;
    private final PromptActionContextFactory f23955b;
    private InlineComposerPromptSession f23956c = null;

    @Inject
    public MemePromptClickListener(@Assisted InlineComposerPromptSession inlineComposerPromptSession, InlineComposerPromptActionHandler inlineComposerPromptActionHandler, PromptActionContextFactory promptActionContextFactory) {
        this.f23956c = inlineComposerPromptSession;
        this.f23954a = inlineComposerPromptActionHandler;
        this.f23955b = promptActionContextFactory;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1961628531);
        view.setOnClickListener(null);
        Preconditions.checkNotNull(this.f23956c);
        this.f23954a.a(view, this.f23956c, this.f23955b.a(this.f23956c).a());
        Logger.a(2, EntryType.UI_INPUT_END, -26715678, a);
    }
}
