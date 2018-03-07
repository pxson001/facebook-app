package com.facebook.strictmode.setter.predefined;

import com.facebook.strictmode.setter.StrictModeMultiSetter;

/* compiled from: NewsFeedCacheSynchronizer */
public class PenaltyLogAll extends StrictModeMultiSetter {
    public PenaltyLogAll() {
        super(new ThreadPenaltyLog(), new VmPenaltyLog());
    }
}
