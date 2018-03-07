package com.google.common.hash;

import com.google.common.annotations.Beta;
import java.nio.charset.Charset;
import javax.annotation.CheckReturnValue;

@Beta
/* compiled from: stopServiceDelayed got exception  */
public interface Hasher extends PrimitiveSink {
    @CheckReturnValue
    HashCode mo116a();

    Hasher mo120a(int i);

    Hasher mo121a(long j);

    Hasher mo126a(CharSequence charSequence, Charset charset);

    Hasher mo122b(byte[] bArr);
}
