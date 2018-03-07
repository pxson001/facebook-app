package com.facebook.messaging.tincan.messenger;

import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.notify.MessageSnippetHelper;
import com.facebook.messaging.tincan.database.DbWriteTincanHandler;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: mSavedViewState= */
public class TincanSnippetHelper {
    private final DbWriteTincanHandler f15428a;
    private final MessageSnippetHelper f15429b;

    public static TincanSnippetHelper m21971a(InjectorLike injectorLike) {
        return new TincanSnippetHelper(DbWriteTincanHandler.m21775a(injectorLike), MessageSnippetHelper.m21978b(injectorLike));
    }

    @Inject
    public TincanSnippetHelper(DbWriteTincanHandler dbWriteTincanHandler, MessageSnippetHelper messageSnippetHelper) {
        this.f15428a = dbWriteTincanHandler;
        this.f15429b = messageSnippetHelper;
    }

    public final void m21972a(Message message) {
        String b = this.f15429b.m21984b(message);
        if (b != null) {
            this.f15428a.m21797a(message.b, b, null, null);
            return;
        }
        b = message.f.trim();
        if (b.length() > 120) {
            b = b.substring(0, 120);
        }
        Preconditions.checkNotNull(message.e.b.m5867b());
        this.f15428a.m21797a(message.b, null, b, Long.valueOf(Long.parseLong(message.e.b.m5867b())));
    }
}
