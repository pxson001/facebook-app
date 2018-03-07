package com.facebook.photos.base.media;

import com.facebook.common.random.SecureRandom_FixedSecureRandomMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import java.security.SecureRandom;
import javax.inject.Inject;

/* compiled from: initial_tagged_users */
public class TemporaryPhotoItemIDGenerator {
    SecureRandom f12740a;

    private static TemporaryPhotoItemIDGenerator m20119b(InjectorLike injectorLike) {
        return new TemporaryPhotoItemIDGenerator(SecureRandom_FixedSecureRandomMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public TemporaryPhotoItemIDGenerator(SecureRandom secureRandom) {
        this.f12740a = secureRandom;
    }
}
