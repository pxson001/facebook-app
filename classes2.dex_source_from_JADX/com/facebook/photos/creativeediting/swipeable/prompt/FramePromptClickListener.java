package com.facebook.photos.creativeediting.swipeable.prompt;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextFactory;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.productionprompts.common.InlineComposerPromptActionHandler;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: mobile_data_enabled */
public class FramePromptClickListener implements OnClickListener {
    private final InlineComposerPromptActionHandler f13405a;
    private final PromptActionContextFactory f13406b;
    public InlineComposerPromptSession f13407c = null;

    public static FramePromptClickListener m19771b(InjectorLike injectorLike) {
        return new FramePromptClickListener(InlineComposerPromptActionHandler.m19641b(injectorLike), PromptActionContextFactory.m19725b(injectorLike));
    }

    @Inject
    public FramePromptClickListener(InlineComposerPromptActionHandler inlineComposerPromptActionHandler, PromptActionContextFactory promptActionContextFactory) {
        this.f13405a = inlineComposerPromptActionHandler;
        this.f13406b = promptActionContextFactory;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 2085761339);
        view.setOnClickListener(null);
        Preconditions.checkNotNull(this.f13407c);
        this.f13405a.mo2620a(view, this.f13407c, this.f13406b.m19726a(this.f13407c).a());
        Logger.a(2, EntryType.UI_INPUT_END, 2053406872, a);
    }
}
