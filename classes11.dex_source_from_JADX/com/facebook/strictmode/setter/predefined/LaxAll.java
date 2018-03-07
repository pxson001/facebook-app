package com.facebook.strictmode.setter.predefined;

import com.facebook.strictmode.setter.StrictModeMultiSetter;

/* compiled from: No PageId available in early fetcher */
public class LaxAll extends StrictModeMultiSetter {
    public LaxAll() {
        super(new ThreadLax(), new VmLax());
    }
}
