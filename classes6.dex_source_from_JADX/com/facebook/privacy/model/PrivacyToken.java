package com.facebook.privacy.model;

import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken.Type;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: feed_edit_review_privacy */
public class PrivacyToken extends BaseToken<Integer> {
    protected int f15081e;
    protected int f15082f;
    protected int f15083g;
    protected int f15084h;
    protected String f15085i;
    @Nullable
    protected String f15086j;
    private Integer f15087k;

    @Nullable
    public /* synthetic */ Object mo1186d() {
        return mo1196c();
    }

    public PrivacyToken(Integer num, int i, int i2, int i3, int i4, String str, @Nullable String str2) {
        super(Type.PRIVACY);
        boolean z = num == null || num.intValue() >= 0;
        Preconditions.checkArgument(z);
        this.f15087k = num;
        this.f15081e = i;
        this.f15082f = i2;
        this.f15083g = i3;
        this.f15084h = i4;
        this.f15085i = str;
        this.f15086j = str2;
    }

    public PrivacyToken(Type type, int i, int i2, int i3, int i4, String str, @Nullable String str2) {
        super(type);
        this.f15087k = null;
        this.f15081e = i;
        this.f15082f = i2;
        this.f15083g = i3;
        this.f15084h = i4;
        this.f15085i = str;
        this.f15086j = str2;
    }

    public PrivacyToken(Type type) {
        super(type);
        this.f15087k = null;
        this.f15081e = -1;
        this.f15082f = -1;
        this.f15083g = -1;
        this.f15084h = -1;
    }

    @Nullable
    public Integer mo1196c() {
        return this.f15087k;
    }

    public String mo1185b() {
        return this.f15085i;
    }

    public final int mo1187e() {
        return this.f15081e;
    }

    public int mo1190h() {
        return this.f15082f;
    }

    public int mo1188f() {
        return this.f15083g;
    }

    public int mo1189g() {
        return this.f15084h;
    }

    public String mo1191i() {
        return null;
    }

    public final String mo1192l() {
        return this.f15086j;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f15087k});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PrivacyToken) {
            return Objects.equal(this.f15087k, ((PrivacyToken) obj).mo1196c());
        }
        return false;
    }
}
