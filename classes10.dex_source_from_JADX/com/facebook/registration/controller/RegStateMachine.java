package com.facebook.registration.controller;

import com.facebook.registration.constants.RegFragmentState;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: layout_manager_state */
public abstract class RegStateMachine {
    public Map<RegFragmentState, RegTransition> f8722a = new EnumMap(RegFragmentState.class);

    public abstract RegTransition mo381a(boolean z, boolean z2);

    public final RegTransition m8729c() {
        return mo381a(false, false);
    }
}
