package com.facebook.strictmode.setter;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

/* compiled from: No campaign ID passed in */
public class StrictModeMultiSetter implements StrictModeSetter {
    private final List<StrictModeSetter> f12990a;

    public StrictModeMultiSetter(StrictModeSetter... strictModeSetterArr) {
        this(Lists.a(strictModeSetterArr));
    }

    private StrictModeMultiSetter(List<StrictModeSetter> list) {
        this.f12990a = new ArrayList(list);
    }

    public void set() {
        for (StrictModeSetter strictModeSetter : this.f12990a) {
            strictModeSetter.set();
        }
    }
}
