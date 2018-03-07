package com.facebook.feedback.reactions.ui.anim;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: setGlobalKillSwitchForContactsUpload */
public class ReactionsAnimationManager {
    private ImmutableMap<ReactionsAnimationType, Provider<? extends ReactionsAnimationTransformer>> f3964a;
    private Map<ReactionsAnimationType, ReactionsAnimationTransformer> f3965b = new HashMap();

    private static ReactionsAnimationManager m4620b(InjectorLike injectorLike) {
        return new ReactionsAnimationManager(IdBasedProvider.a(injectorLike, 6106), IdBasedProvider.a(injectorLike, 6104));
    }

    @Inject
    public ReactionsAnimationManager(Provider<ThrobAnimationTransformer> provider, Provider<BlinkAnimationTransformer> provider2) {
        Builder builder = ImmutableMap.builder();
        builder.b(ReactionsAnimationType.THROB, provider);
        builder.b(ReactionsAnimationType.BLINK, provider2);
        this.f3964a = builder.b();
    }

    public final ReactionsAnimationTransformer m4621a(ReactionsAnimationType reactionsAnimationType) {
        return (ReactionsAnimationTransformer) this.f3965b.get(reactionsAnimationType);
    }

    public final void m4622a() {
        for (ReactionsAnimationTransformer a : this.f3965b.values()) {
            a.mo182a();
        }
    }
}
