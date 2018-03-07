package com.facebook.friendsharing.souvenirs.layout;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: ReactionMoreAttachmentsQuery */
public class SouvenirValidator {
    private final Provider<SouvenirLayoutCreator> f24050a;

    private static SouvenirValidator m26153b(InjectorLike injectorLike) {
        return new SouvenirValidator(IdBasedProvider.a(injectorLike, 6716));
    }

    @Inject
    public SouvenirValidator(Provider<SouvenirLayoutCreator> provider) {
        this.f24050a = provider;
    }
}
