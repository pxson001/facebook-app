package com.facebook.livephotos.exoplayer.upstream;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.livephotos.exoplayer.util.Assertions;

/* compiled from: overall_upload_finish */
public final class DefaultUriDataSource implements UriDataSource {
    private final UriDataSource f7664a;
    private final UriDataSource f7665b;
    private final UriDataSource f7666c;
    private final UriDataSource f7667d;
    private UriDataSource f7668e;

    public DefaultUriDataSource(Context context, TransferListener transferListener, String str) {
        this(context, transferListener, str, false);
    }

    private DefaultUriDataSource(Context context, TransferListener transferListener, String str, boolean z) {
        this(context, transferListener, new DefaultHttpDataSource(str, null, transferListener, 8000, 8000, z));
    }

    private DefaultUriDataSource(Context context, TransferListener transferListener, UriDataSource uriDataSource) {
        this.f7664a = (UriDataSource) Assertions.m9293a((Object) uriDataSource);
        this.f7665b = new FileDataSource(transferListener);
        this.f7666c = new AssetDataSource(context, transferListener);
        this.f7667d = new ContentDataSource(context, transferListener);
    }

    public final long mo441a(DataSpec dataSpec) {
        Assertions.m9297b(this.f7668e == null);
        String scheme = dataSpec.f7634a.getScheme();
        Object scheme2 = dataSpec.f7634a.getScheme();
        if (TextUtils.isEmpty(scheme2) || scheme2.equals("file")) {
            scheme2 = 1;
        } else {
            scheme2 = null;
        }
        if (scheme2 != null) {
            if (dataSpec.f7634a.getPath().startsWith("/android_asset/")) {
                this.f7668e = this.f7666c;
            } else {
                this.f7668e = this.f7665b;
            }
        } else if ("asset".equals(scheme)) {
            this.f7668e = this.f7666c;
        } else if ("content".equals(scheme)) {
            this.f7668e = this.f7667d;
        } else {
            this.f7668e = this.f7664a;
        }
        return this.f7668e.mo441a(dataSpec);
    }

    public final int mo440a(byte[] bArr, int i, int i2) {
        return this.f7668e.mo440a(bArr, i, i2);
    }

    public final void mo442a() {
        if (this.f7668e != null) {
            try {
                this.f7668e.mo442a();
            } finally {
                this.f7668e = null;
            }
        }
    }
}
