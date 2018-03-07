package com.facebook.user.model;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.TriState;
import com.facebook.messaging.business.common.calltoaction.model.CallToAction;
import com.facebook.user.gender.Gender;
import com.facebook.user.model.User.CommercePageSetting;
import com.facebook.user.model.User.CommercePageType;
import com.facebook.user.model.User.Type;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: t_fs */
public class UserBuilder {
    public boolean f3518A;
    public boolean f3519B;
    @Nullable
    public CommercePageType f3520C;
    @Nullable
    public ImmutableList<CommercePageSetting> f3521D;
    public long f3522E;
    public long f3523F;
    public boolean f3524G;
    public boolean f3525H;
    public int f3526I;
    public int f3527J;
    public int f3528K;
    public boolean f3529L;
    public boolean f3530M;
    public TriState f3531N = TriState.UNSET;
    public boolean f3532O;
    public boolean f3533P;
    public boolean f3534Q;
    public boolean f3535R;
    public float f3536S;
    @Nullable
    public ImmutableList<CallToAction> f3537T;
    public boolean f3538U;
    public boolean f3539V;
    public boolean f3540W = true;
    public long f3541X;
    public long f3542Y;
    public boolean f3543Z;
    public Type f3544a;
    public String f3545b;
    public List<UserEmailAddress> f3546c = null;
    public List<UserPhoneNumber> f3547d = null;
    public ImmutableList<UserCustomTag> f3548e = null;
    public String f3549f;
    public Name f3550g;
    public String f3551h;
    public String f3552i;
    public String f3553j;
    public Name f3554k;
    public String f3555l;
    public Gender f3556m = Gender.UNKNOWN;
    public String f3557n;
    public String f3558o;
    public PicSquare f3559p;
    public String f3560q;
    public String f3561r;
    public String f3562s;
    public float f3563t;
    public TriState f3564u = TriState.UNSET;
    public boolean f3565v;
    public boolean f3566w;
    public String f3567x;
    public String f3568y;
    @Nullable
    public String f3569z;

    public final UserBuilder m5767a(Type type, String str) {
        this.f3544a = type;
        this.f3545b = str;
        return this;
    }

    public final UserBuilder m5770a(@Nullable String str, @Nullable String str2) {
        this.f3544a = Type.PHONE_NUMBER;
        this.f3545b = m5755b(str, str2);
        return this;
    }

    public final List<UserEmailAddress> m5783c() {
        return this.f3546c;
    }

    public final UserBuilder m5771a(List<UserEmailAddress> list) {
        this.f3546c = list;
        return this;
    }

    public final UserBuilder m5769a(ImmutableList<UserCustomTag> immutableList) {
        this.f3548e = immutableList;
        return this;
    }

    public final List<UserPhoneNumber> m5788e() {
        return this.f3547d;
    }

    public final UserBuilder m5778b(List<UserPhoneNumber> list) {
        this.f3547d = list;
        return this;
    }

    public final UserBuilder m5776b(Name name) {
        this.f3550g = name;
        return this;
    }

    public final UserBuilder m5786e(String str) {
        this.f3555l = str;
        return this;
    }

    public final UserBuilder m5789f(String str) {
        this.f3557n = str;
        return this;
    }

    public final UserBuilder m5768a(User user) {
        this.f3544a = user.f3599b;
        this.f3545b = user.f3598a;
        this.f3546c = user.f3600c;
        this.f3548e = user.f3601d;
        this.f3547d = user.m5851r();
        this.f3550g = user.f3602e;
        this.f3551h = user.m5845j();
        this.f3555l = user.f3604g;
        this.f3556m = user.f3605h;
        this.f3557n = user.m5856x();
        this.f3558o = user.f3607j;
        this.f3559p = user.m5858z();
        this.f3561r = user.f3608k;
        this.f3562s = user.f3609l;
        this.f3563t = user.f3610m;
        this.f3564u = user.f3611n;
        this.f3565v = user.f3612o;
        this.f3566w = user.f3613p;
        this.f3567x = user.f3614q;
        this.f3568y = user.f3615r;
        this.f3569z = user.f3616s;
        this.f3518A = user.f3617t;
        this.f3519B = user.f3618u;
        this.f3520C = user.f3619v;
        this.f3521D = user.f3620w;
        this.f3522E = user.f3621x;
        this.f3523F = user.f3622y;
        this.f3524G = user.f3623z;
        this.f3526I = user.f3574B;
        this.f3527J = user.f3575C;
        this.f3528K = user.f3576D;
        this.f3529L = user.f3577E;
        this.f3530M = user.f3578F;
        this.f3531N = user.f3579G;
        this.f3532O = user.f3580H;
        this.f3533P = user.f3581I;
        this.f3540W = user.f3583K;
        this.f3541X = user.f3584L;
        this.f3535R = user.f3587O;
        this.f3536S = user.f3588P;
        this.f3537T = user.f3589Q;
        this.f3538U = user.f3590R;
        this.f3539V = user.f3591S;
        return this;
    }

    public final UserBuilder m5765a(PicSquare picSquare) {
        this.f3559p = picSquare;
        return this;
    }

    public final UserBuilder m5793i(String str) {
        this.f3562s = str;
        return this;
    }

    public final float m5805t() {
        return this.f3563t;
    }

    public final UserBuilder m5760a(float f) {
        this.f3563t = f;
        return this;
    }

    public final TriState m5806u() {
        return this.f3564u;
    }

    public final UserBuilder m5764a(TriState triState) {
        this.f3564u = triState;
        return this;
    }

    public final UserBuilder m5772a(boolean z) {
        this.f3565v = z;
        return this;
    }

    public final UserBuilder m5779b(boolean z) {
        this.f3566w = z;
        return this;
    }

    public final UserBuilder m5795j(String str) {
        this.f3567x = str;
        return this;
    }

    public final UserBuilder m5797k(String str) {
        this.f3568y = str;
        return this;
    }

    public final UserBuilder m5799l(@Nullable String str) {
        this.f3569z = str;
        return this;
    }

    public final UserBuilder m5782c(boolean z) {
        this.f3518A = z;
        return this;
    }

    public final UserBuilder m5785d(boolean z) {
        this.f3519B = z;
        return this;
    }

    public final UserBuilder m5766a(@Nullable CommercePageType commercePageType) {
        this.f3520C = commercePageType;
        return this;
    }

    public final UserBuilder m5777b(@Nullable ImmutableList<CommercePageSetting> immutableList) {
        this.f3521D = immutableList;
        return this;
    }

    public final UserBuilder m5763a(long j) {
        this.f3522E = j;
        return this;
    }

    public final UserBuilder m5774b(long j) {
        this.f3523F = j;
        return this;
    }

    public final UserBuilder m5787e(boolean z) {
        this.f3532O = z;
        return this;
    }

    public final UserBuilder m5790f(boolean z) {
        this.f3533P = z;
        return this;
    }

    public final UserBuilder m5791g(boolean z) {
        this.f3534Q = z;
        return this;
    }

    public final UserBuilder m5792h(boolean z) {
        this.f3524G = z;
        return this;
    }

    public final UserBuilder m5794i(boolean z) {
        this.f3525H = z;
        return this;
    }

    public final UserBuilder m5796j(boolean z) {
        this.f3540W = z;
        return this;
    }

    public final UserBuilder m5762a(int i, int i2, int i3) {
        this.f3526I = i;
        this.f3527J = i2;
        this.f3528K = i3;
        return this;
    }

    public final UserBuilder m5761a(int i, int i2) {
        this.f3527J = i;
        this.f3528K = i2;
        return this;
    }

    public final int m5756M() {
        return this.f3526I;
    }

    public final int m5757N() {
        return this.f3527J;
    }

    public final int m5758O() {
        return this.f3528K;
    }

    public final UserBuilder m5798k(boolean z) {
        this.f3529L = z;
        return this;
    }

    public final UserBuilder m5800l(boolean z) {
        this.f3530M = z;
        return this;
    }

    public final UserBuilder m5780c(long j) {
        this.f3541X = j;
        return this;
    }

    public final UserBuilder m5775b(TriState triState) {
        this.f3531N = triState;
        return this;
    }

    public final TriState m5759S() {
        return this.f3531N;
    }

    public final UserBuilder m5784d(long j) {
        this.f3542Y = j;
        return this;
    }

    public final UserBuilder m5801m(boolean z) {
        this.f3543Z = z;
        return this;
    }

    public final UserBuilder m5802n(boolean z) {
        this.f3535R = z;
        return this;
    }

    public final UserBuilder m5773b(float f) {
        this.f3536S = f;
        return this;
    }

    public final UserBuilder m5781c(@Nullable ImmutableList<CallToAction> immutableList) {
        this.f3537T = immutableList;
        return this;
    }

    public final UserBuilder m5803o(boolean z) {
        this.f3538U = z;
        return this;
    }

    public final UserBuilder m5804p(boolean z) {
        this.f3539V = z;
        return this;
    }

    public final User aa() {
        return new User(this);
    }

    private static String m5755b(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            str = "";
        }
        String str3 = "%s:%s";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (str2 == null) {
            str2 = "";
        }
        objArr[1] = str2;
        return StringFormatUtil.a(str3, objArr);
    }
}
