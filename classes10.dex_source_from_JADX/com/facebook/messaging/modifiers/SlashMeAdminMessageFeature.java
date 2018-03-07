package com.facebook.messaging.modifiers;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.ThreadKey;
import javax.inject.Inject;

/* compiled from: save_nux_decision */
public class SlashMeAdminMessageFeature {
    private final DataCache f3280a;
    public final GatekeeperStoreImpl f3281b;
    private final Resources f3282c;

    public static SlashMeAdminMessageFeature m3203b(InjectorLike injectorLike) {
        return new SlashMeAdminMessageFeature(DataCache.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SlashMeAdminMessageFeature(DataCache dataCache, GatekeeperStoreImpl gatekeeperStoreImpl, Resources resources) {
        this.f3280a = dataCache;
        this.f3281b = gatekeeperStoreImpl;
        this.f3282c = resources;
    }

    public final boolean m3205a(Message message) {
        return m3206a(message.f);
    }

    public static SlashMeAdminMessageFeature m3202a(InjectorLike injectorLike) {
        return m3203b(injectorLike);
    }

    public final String m3207b(Message message) {
        return m3204a(message.f, message.b, message.e);
    }

    public final String m3204a(String str, ThreadKey threadKey, ParticipantInfo participantInfo) {
        if (!m3206a(str)) {
            return str;
        }
        String b = this.f3280a.b(threadKey, participantInfo);
        String replaceAll = str.substring(4).trim().replaceAll("\n+\\s*\n+", "\n");
        return this.f3282c.getString(2131241317, new Object[]{b, replaceAll});
    }

    public final boolean m3206a(String str) {
        return this.f3281b.a(266, false) && str != null && str.startsWith("/me ") && str.length() > 4;
    }
}
