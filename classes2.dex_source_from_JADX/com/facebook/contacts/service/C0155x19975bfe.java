package com.facebook.contacts.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.broadcast.FbBroadcastManagerType;
import com.facebook.common.init.INeedInitForBroadcastReceiverRegistration;
import com.facebook.contacts.cache.DynamicContactDataCache;
import com.facebook.content.FacebookOnlyIntentActionFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import javax.inject.Inject;

/* compiled from: total_unseen_stories_below */
public class C0155x19975bfe extends INeedInitForBroadcastReceiverRegistration<ContactChatContextRefresher> {
    private final FacebookOnlyIntentActionFactory f2311a;

    protected void onReceive(Context context, Intent intent, Object obj) {
        ContactChatContextRefresher contactChatContextRefresher = (ContactChatContextRefresher) obj;
        if (intent.getAction().equals(this.f2311a.m4497a("NEARBY_FRIENDS_SETTINGS_CHANGED_ACTION"))) {
            if (contactChatContextRefresher.d.m2189a(905, false)) {
                ((DynamicContactDataCache) contactChatContextRefresher.b.get()).b();
            }
            if (contactChatContextRefresher.d.m2189a(905, false)) {
                BlueServiceOperationFactoryDetour.a(contactChatContextRefresher.c, "sync_chat_context", Bundle.EMPTY, ErrorPropagation.BY_EXCEPTION, ContactChatContextRefresher.a, -689089041).mo3452a();
            }
        }
    }

    @Inject
    public C0155x19975bfe(Lazy<ContactChatContextRefresher> lazy, FacebookOnlyIntentActionFactory facebookOnlyIntentActionFactory) {
        super(FbBroadcastManagerType.CROSS_APP, (Lazy) lazy, facebookOnlyIntentActionFactory.m4497a("NEARBY_FRIENDS_SETTINGS_CHANGED_ACTION"));
        this.f2311a = facebookOnlyIntentActionFactory;
    }
}
