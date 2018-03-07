package com.facebook.messaging.momentsinvite.ui;

import android.content.Context;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.messaging.xma.SnippetCreator;
import com.facebook.messaging.xma.SnippetCreatorParams;
import javax.inject.Inject;

/* compiled from: itemSellerInfo */
public class MomentsInviteSnippetCreator implements SnippetCreator {
    private final Context f12338a;
    private final GatekeeperStoreImpl f12339b;

    @Inject
    public MomentsInviteSnippetCreator(Context context, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f12338a = context;
        this.f12339b = gatekeeperStoreImpl;
    }

    public final String m12805a(SnippetCreatorParams snippetCreatorParams) {
        return MomentsInviteDataConverter.m12800a(snippetCreatorParams.b, this.f12338a.getResources(), this.f12339b).e;
    }
}
