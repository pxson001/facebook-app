package com.facebook.goodfriends.abtest;

import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: processor */
public class GoodFriendsFeedQEStore {
    private final QeAccessor f8969a;

    public static GoodFriendsFeedQEStore m13842b(InjectorLike injectorLike) {
        return new GoodFriendsFeedQEStore(QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public GoodFriendsFeedQEStore(QeAccessor qeAccessor) {
        this.f8969a = qeAccessor;
    }

    public final boolean m13843a() {
        return m13841a(ExperimentsForGoodFriendsAbtestModule.f8986p, ExperimentsForGoodFriendsAbtestModule.f8983m, false);
    }

    private boolean m13841a(short s, short s2, boolean z) {
        return this.f8969a.mo596a(s, z) || this.f8969a.mo596a(s2, z);
    }

    public final boolean m13844b() {
        return m13841a(ExperimentsForGoodFriendsAbtestModule.f8988r, ExperimentsForGoodFriendsAbtestModule.f8985o, false);
    }

    public static GoodFriendsFeedQEStore m13839a(InjectorLike injectorLike) {
        return m13842b(injectorLike);
    }

    public final boolean m13845c() {
        return m13840a(ExperimentsForGoodFriendsAbtestModule.f8987q, ExperimentsForGoodFriendsAbtestModule.f8984n, "glyph_pile", "camera");
    }

    private boolean m13840a(char c, char c2, String str, String str2) {
        return str2.equals(this.f8969a.mo581a(c, str)) || str2.equals(this.f8969a.mo581a(c2, str));
    }

    public final boolean m13846d() {
        return m13840a(ExperimentsForGoodFriendsAbtestModule.f8987q, ExperimentsForGoodFriendsAbtestModule.f8984n, "glyph_pile", "glyph_pile");
    }
}
