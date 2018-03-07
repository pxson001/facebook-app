package com.facebook.events.permalink;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.analytics.tagging.CurrentModuleHolder;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.events.gating.EventPermalinkBazingaHelper;
import javax.inject.Inject;

/* compiled from: cannotReplyReason */
public class EventsPermalinkFragmentFactory implements IFragmentFactory {
    private final CurrentModuleHolder f17891a;
    private final EventPermalinkBazingaHelper f17892b;

    @Inject
    public EventsPermalinkFragmentFactory(CurrentModuleHolder currentModuleHolder, EventPermalinkBazingaHelper eventPermalinkBazingaHelper) {
        this.f17891a = currentModuleHolder;
        this.f17892b = eventPermalinkBazingaHelper;
    }

    public final Fragment m18305a(Intent intent) {
        Bundle extras;
        String a;
        if (1 != 0) {
            extras = intent.getExtras();
            a = this.f17891a.a("unknown");
            EventPermalinkBazingaFragment eventPermalinkBazingaFragment = new EventPermalinkBazingaFragment();
            if (a != null) {
                extras.putString("extra_ref_module", a.toString());
            }
            eventPermalinkBazingaFragment.g(extras);
            return eventPermalinkBazingaFragment;
        }
        extras = intent.getExtras();
        a = this.f17891a.a("unknown");
        EventPermalinkFragment eventPermalinkFragment = new EventPermalinkFragment();
        if (a != null) {
            extras.putString("extra_ref_module", a);
        }
        eventPermalinkFragment.g(extras);
        return eventPermalinkFragment;
    }
}
