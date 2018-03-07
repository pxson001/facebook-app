package com.facebook.katana.activity.codegenerator;

import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: typeahead_delay */
public class GatedCodeGeneratorExperimentHelper {
    private final Provider<TriState> f655a;
    private final Provider<TriState> f656b;

    public static GatedCodeGeneratorExperimentHelper m1025b(InjectorLike injectorLike) {
        return new GatedCodeGeneratorExperimentHelper(IdBasedProvider.a(injectorLike, 695), IdBasedProvider.a(injectorLike, 696));
    }

    @Inject
    public GatedCodeGeneratorExperimentHelper(Provider<TriState> provider, Provider<TriState> provider2) {
        this.f655a = provider;
        this.f656b = provider2;
    }

    public final boolean m1026a() {
        return this.f656b.get() == TriState.YES;
    }

    public final boolean m1027b() {
        return this.f655a.get() == TriState.YES;
    }

    public static GatedCodeGeneratorExperimentHelper m1024a(InjectorLike injectorLike) {
        return m1025b(injectorLike);
    }
}
