package com.facebook.friendsharing.suggestedcoverphotos.prompt;

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

/* compiled from: ProfileOverlayPagesByImageOverlayQuery */
public class CoverPhotoPromptClickListener implements OnClickListener {
    private final InlineComposerPromptSession f24313a;
    private final InlineComposerPromptActionHandler f24314b;
    private final PromptActionContextFactory f24315c;

    @Inject
    public CoverPhotoPromptClickListener(@Assisted InlineComposerPromptSession inlineComposerPromptSession, InlineComposerPromptActionHandler inlineComposerPromptActionHandler, PromptActionContextFactory promptActionContextFactory) {
        this.f24313a = (InlineComposerPromptSession) Preconditions.checkNotNull(inlineComposerPromptSession);
        this.f24314b = inlineComposerPromptActionHandler;
        this.f24315c = promptActionContextFactory;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -619785016);
        view.setOnClickListener(null);
        this.f24314b.a(view, this.f24313a, this.f24315c.a(this.f24313a).a());
        Logger.a(2, EntryType.UI_INPUT_END, -587687885, a);
    }
}
