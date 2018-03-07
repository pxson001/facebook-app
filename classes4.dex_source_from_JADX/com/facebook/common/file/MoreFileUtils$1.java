package com.facebook.common.file;

import com.google.common.io.ByteSource;
import java.io.InputStream;

/* compiled from: fbandroid_cold_start */
class MoreFileUtils$1 extends ByteSource {
    final /* synthetic */ InputStream f11975a;
    final /* synthetic */ MoreFileUtils f11976b;

    MoreFileUtils$1(MoreFileUtils moreFileUtils, InputStream inputStream) {
        this.f11976b = moreFileUtils;
        this.f11975a = inputStream;
    }

    public final InputStream mo846a() {
        return this.f11975a;
    }
}
