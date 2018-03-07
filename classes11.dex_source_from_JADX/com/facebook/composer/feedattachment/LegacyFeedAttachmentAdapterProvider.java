package com.facebook.composer.feedattachment;

import android.content.Context;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ui.futures.TasksManager;

/* compiled from: got_result */
public class LegacyFeedAttachmentAdapterProvider extends AbstractAssistedProvider<LegacyFeedAttachmentAdapter> {
    public final LegacyFeedAttachmentAdapter m7922a(ComposerFeedAttachmentController composerFeedAttachmentController) {
        return new LegacyFeedAttachmentAdapter(TasksManager.b(this), (Context) getInstance(Context.class), composerFeedAttachmentController);
    }
}
