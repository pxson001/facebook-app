package com.facebook.ufiservices.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.ufiservices.source.UFISource;

/* compiled from: neko_install_reminder */
public class UFISource_UFISourceTargetMethodAutoProvider extends AbstractProvider<UFISource> {
    public Object get() {
        return UFISource.FEED;
    }
}
