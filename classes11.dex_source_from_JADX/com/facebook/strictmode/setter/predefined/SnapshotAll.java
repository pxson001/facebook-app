package com.facebook.strictmode.setter.predefined;

import com.facebook.strictmode.setter.StrictModeMultiSetter;

/* compiled from: NetInfo */
public class SnapshotAll extends StrictModeMultiSetter {
    public SnapshotAll() {
        super(new ThreadSnapshot(), new VmSnapshot());
    }
}
