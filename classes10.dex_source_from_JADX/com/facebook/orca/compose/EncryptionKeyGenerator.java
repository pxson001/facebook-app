package com.facebook.orca.compose;

import android.annotation.SuppressLint;
import com.facebook.common.random.SecureRandomFix;
import com.facebook.inject.InjectorLike;
import java.security.SecureRandom;
import javax.inject.Inject;

/* compiled from: orca_composer_texts_sent_since_video_feature */
public class EncryptionKeyGenerator {
    private final SecureRandomFix f5501a;
    private final SecureRandom f5502b = new SecureRandom();

    public static EncryptionKeyGenerator m5111a(InjectorLike injectorLike) {
        return new EncryptionKeyGenerator(SecureRandomFix.a(injectorLike));
    }

    @Inject
    @SuppressLint({"TrulyRandom"})
    public EncryptionKeyGenerator(SecureRandomFix secureRandomFix) {
        this.f5501a = secureRandomFix;
    }

    public final byte[] m5112a() {
        this.f5501a.a();
        byte[] bArr = new byte[32];
        this.f5502b.nextBytes(bArr);
        return bArr;
    }
}
