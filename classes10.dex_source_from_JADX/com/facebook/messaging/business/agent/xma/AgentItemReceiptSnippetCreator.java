package com.facebook.messaging.business.agent.xma;

import android.content.Context;
import com.facebook.messaging.xma.SnippetCreator;
import com.facebook.messaging.xma.SnippetCreatorParams;
import javax.inject.Inject;

/* compiled from: thread_settings_type_for_settings */
public class AgentItemReceiptSnippetCreator implements SnippetCreator {
    private final Context f1504a;

    @Inject
    public AgentItemReceiptSnippetCreator(Context context) {
        this.f1504a = context;
    }

    public final String m1475a(SnippetCreatorParams snippetCreatorParams) {
        return this.f1504a.getString(2131241132);
    }
}
