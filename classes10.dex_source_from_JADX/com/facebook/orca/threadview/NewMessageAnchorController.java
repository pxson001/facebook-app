package com.facebook.orca.threadview;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUserUtil;
import com.facebook.messaging.model.threads.ThreadCustomization;
import com.facebook.messaging.notify.MessageSnippetHelper;
import com.facebook.messaging.notify.MessageSnippetHelper.IncludeSenderPrefix;
import com.facebook.widget.ViewStubHolder;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: messenger_contacts_you_may_know */
public class NewMessageAnchorController {
    private final Provider<Boolean> f7307a;
    private final MessageUserUtil f7308b;
    private final DataCache f7309c;
    private final MessageSnippetHelper f7310d;
    private String f7311e;
    private int f7312f;

    public static NewMessageAnchorController m6962b(InjectorLike injectorLike) {
        return new NewMessageAnchorController(IdBasedProvider.a(injectorLike, 4079), MessageUserUtil.a(injectorLike), DataCache.a(injectorLike), MessageSnippetHelper.b(injectorLike));
    }

    @Inject
    public NewMessageAnchorController(Provider<Boolean> provider, MessageUserUtil messageUserUtil, DataCache dataCache, MessageSnippetHelper messageSnippetHelper) {
        this.f7307a = provider;
        this.f7308b = messageUserUtil;
        this.f7309c = dataCache;
        this.f7310d = messageSnippetHelper;
    }

    final void m6964a(ViewStubHolder<NewMessageAnchorView> viewStubHolder) {
        int i = 0;
        this.f7312f = 0;
        if (viewStubHolder != null && viewStubHolder.c()) {
            i = 1;
        }
        if (i != 0) {
            ((NewMessageAnchorView) viewStubHolder.a()).m6968a();
        }
    }

    final void m6963a(Message message, ThreadCustomization threadCustomization, boolean z, ViewStubHolder<NewMessageAnchorView> viewStubHolder) {
        if (((Boolean) this.f7307a.get()).booleanValue() && message != null && !message.a.equals(this.f7311e)) {
            this.f7311e = message.a;
            boolean a = this.f7308b.a(message);
            boolean a2 = this.f7309c.a(message);
            if (a || a2 || z) {
                m6964a(viewStubHolder);
                return;
            }
            this.f7312f++;
            if (this.f7312f > 1) {
                ((NewMessageAnchorView) viewStubHolder.a()).m6969a(this.f7312f);
                return;
            }
            ((NewMessageAnchorView) viewStubHolder.a()).m6970a(this.f7310d.a(message, threadCustomization, IncludeSenderPrefix.IN_GROUP_THREADS));
        }
    }
}
