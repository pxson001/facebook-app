package com.facebook.zero.rewrite;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.zero.logging.FbZeroLogger;
import com.facebook.zero.sdk.logging.ZeroLogger;
import com.facebook.zero.sdk.rewrite.ZeroUrlRewriter;
import com.facebook.zero.sdk.token.ZeroTokenManager;
import com.facebook.zero.service.FbZeroTokenManager;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: force_emoji_color_nux */
public class FbZeroUrlRewriter extends ZeroUrlRewriter {
    public static FbZeroUrlRewriter m31801b(InjectorLike injectorLike) {
        return new FbZeroUrlRewriter(FbZeroLogger.m31813b(injectorLike), FbZeroTokenManager.m7926b(injectorLike), IdBasedProvider.m1811a(injectorLike, 4034), IdBasedProvider.m1811a(injectorLike, 4394), IdBasedProvider.m1811a(injectorLike, 4395));
    }

    @Inject
    public FbZeroUrlRewriter(ZeroLogger zeroLogger, ZeroTokenManager zeroTokenManager, Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3) {
        super(zeroLogger, zeroTokenManager, provider, provider2, provider3);
    }
}
