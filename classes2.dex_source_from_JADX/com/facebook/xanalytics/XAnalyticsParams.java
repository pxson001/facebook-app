package com.facebook.xanalytics;

import com.facebook.tigon.iface.TigonServiceHolder;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: logged_out_set_nonce */
public class XAnalyticsParams {
    public final String f16175a;
    public final String f16176b;
    public final String f16177c;
    public final String f16178d;
    public final int f16179e;
    public final int f16180f;
    public final TigonServiceHolder f16181g;

    /* compiled from: logged_out_set_nonce */
    public class Builder {
        public String f16168a;
        public String f16169b;
        public String f16170c;
        public String f16171d;
        public int f16172e = 0;
        public int f16173f = 0;
        public TigonServiceHolder f16174g = null;

        public final XAnalyticsParams m23017a() {
            return new XAnalyticsParams(this.f16168a, this.f16169b, this.f16170c, this.f16171d, this.f16172e, this.f16173f, this.f16174g);
        }
    }

    public XAnalyticsParams(String str, String str2, String str3, String str4, int i, int i2, TigonServiceHolder tigonServiceHolder) {
        this.f16175a = str;
        this.f16176b = str2;
        this.f16177c = str3;
        this.f16178d = str4;
        this.f16179e = i;
        this.f16180f = i2;
        this.f16181g = tigonServiceHolder;
    }
}
