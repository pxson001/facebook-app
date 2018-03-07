package com.facebook.fbtrace;

import com.facebook.common.util.TriState;
import com.facebook.xconfig.core.XConfigReader;
import java.util.Random;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: foreground_location_config */
public class FbTraceSampler {
    public final Provider<TriState> f23441a;
    public final XConfigReader f23442b;
    public final Random f23443c;

    @Inject
    public FbTraceSampler(Provider<TriState> provider, XConfigReader xConfigReader, Random random) {
        this.f23441a = provider;
        this.f23442b = xConfigReader;
        this.f23443c = random;
    }
}
