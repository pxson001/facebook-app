package com.facebook.reaction;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.ReactionModule.C20601;
import com.facebook.reaction.composer.ReactionComposerManagerProvider;

/* compiled from: c40276bfaad85ecc1f0b0b65fc2a4aeb */
public class ReactionComposerManagerProviderMethodAutoProvider extends AbstractProvider<ReactionComposerManagerProvider> {
    public static C20601 m22509a(InjectorLike injectorLike) {
        return ReactionModule.m22517a((ReactionComposerManagerImplProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionComposerManagerImplProvider.class));
    }

    public Object get() {
        return ReactionModule.m22517a((ReactionComposerManagerImplProvider) getOnDemandAssistedProviderForStaticDi(ReactionComposerManagerImplProvider.class));
    }
}
