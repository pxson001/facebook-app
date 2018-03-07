package com.facebook.directinstall.feed;

import com.facebook.common.util.TriState;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: onActivityCreate  */
public class DirectInstallExperiments {
    private final Provider<TriState> f8749a;
    private final Provider<TriState> f8750b;

    @Inject
    public DirectInstallExperiments(Provider<TriState> provider, Provider<TriState> provider2) {
        this.f8749a = provider;
        this.f8750b = provider2;
    }
}
