package com.facebook.zero.sdk.rewrite;

import android.net.Uri;
import com.facebook.zero.sdk.logging.ZeroLogger;
import com.facebook.zero.sdk.token.AbstractZeroTokenManager;
import com.facebook.zero.sdk.token.ZeroTokenManager;
import com.google.common.collect.ImmutableList;
import java.net.URI;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: for nux_id  */
public class ZeroUrlRewriter {
    public static final ImmutableList<ZeroUrlRewriteRule> f23493a = ImmutableList.of(new ZeroUrlRewriteRule("^(https?)://(api\\.([0-9a-zA-Z\\.-]*)?facebook\\.com(:?[0-9]{0,5}))($|\\?.*$|\\/.*$)", "$1://b-$2$5"), new ZeroUrlRewriteRule("^(https?)://(graph\\.([0-9a-zA-Z\\.-]*)?facebook\\.com(:?[0-9]{0,5}))($|\\?.*$|\\/.*$)", "$1://b-$2$5"), new ZeroUrlRewriteRule("^(https?)://(free|m|mobile|d|b-m)\\.([0-9a-zA-Z\\.-]*)?facebook\\.com(:?[0-9]{0,5})($|\\?.*$|\\/.*$)", "$1://m.$3facebook.com$4$5"), new ZeroUrlRewriteRule("^(https?)://(www|web|z-m-www)\\.([0-9a-zA-Z\\.-]*)?facebook\\.com(:?[0-9]{0,5})($|\\?.*$|\\/.*$)", "$1://www.$3facebook.com$4$5"));
    private static final Class<?> f23494b = ZeroUrlRewriter.class;
    private final ZeroLogger f23495c;
    public final AbstractZeroTokenManager f23496d;
    private final Provider<Boolean> f23497e;
    private final Provider<Boolean> f23498f;
    private final Provider<Boolean> f23499g;
    private final ImmutableList<ZeroUrlRewriteRule> f23500h = ImmutableList.of(new ZeroUrlRewriteRule("^https?://b-(graph|api)\\.facebook\\.com.*$", ""));

    @Inject
    public ZeroUrlRewriter(ZeroLogger zeroLogger, ZeroTokenManager zeroTokenManager, Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3) {
        this.f23495c = zeroLogger;
        this.f23496d = zeroTokenManager;
        this.f23497e = provider;
        this.f23498f = provider2;
        this.f23499g = provider3;
    }

    public final URI m31804a(URI uri) {
        String uri2 = uri.toString();
        String a = m31803a(uri2);
        return uri2.equals(a) ? uri : URI.create(a);
    }

    public final Uri m31802a(Uri uri) {
        String uri2 = uri.toString();
        String a = m31803a(uri2);
        return uri2.equals(a) ? uri : Uri.parse(a);
    }

    public final String m31803a(String str) {
        int i;
        int i2 = 0;
        if (!((Boolean) this.f23497e.get()).booleanValue()) {
            this.f23495c.mo3438b(str, null);
            if (!(((Boolean) this.f23498f.get()).booleanValue() || ((Boolean) this.f23499g.get()).booleanValue())) {
                this.f23495c.mo3436a(str, this.f23496d.mo1186i());
                return str;
            }
        }
        ImmutableList f = this.f23496d.m7965f();
        int size = this.f23500h.size();
        for (i = 0; i < size; i++) {
            if (((ZeroUrlRewriteRule) this.f23500h.get(i)).m31808a(str)) {
                return str;
            }
        }
        if (f != null) {
            i = f.size();
            while (i2 < i) {
                ZeroUrlRewriteRule zeroUrlRewriteRule = (ZeroUrlRewriteRule) f.get(i2);
                if (zeroUrlRewriteRule.m31808a(str)) {
                    String b = zeroUrlRewriteRule.m31810b(str);
                    this.f23495c.mo3435a(str, b, this.f23496d.mo1186i());
                    return b;
                }
                i2++;
            }
        }
        this.f23495c.mo3436a(str, this.f23496d.mo1186i());
        return str;
    }

    public final boolean m31805b(Uri uri) {
        boolean z;
        String uri2 = uri.toString();
        ImmutableList f = this.f23496d.m7965f();
        int size = f.size();
        for (int i = 0; i < size; i++) {
            if (((ZeroUrlRewriteRule) f.get(i)).m31808a(uri2)) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }
}
