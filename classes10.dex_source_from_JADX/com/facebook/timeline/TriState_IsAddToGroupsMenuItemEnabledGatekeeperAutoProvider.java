package com.facebook.timeline;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: groups_seeds_composer_create_chat */
public class TriState_IsAddToGroupsMenuItemEnabledGatekeeperAutoProvider extends AbstractProvider<TriState> {
    public Object get() {
        return GatekeeperStoreImplMethodAutoProvider.a(this).a(605);
    }
}
