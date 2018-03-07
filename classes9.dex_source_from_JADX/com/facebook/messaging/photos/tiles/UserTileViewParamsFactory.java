package com.facebook.messaging.photos.tiles;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.badges.BadgesExperimentController;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.users.MessengerUserCheckHelper;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.tiles.TileBadge;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: dialog/feed?link={share_link}&app_id={#app_id 0}&name={name null}&caption={caption null}&description={description null}&picture={picture null}&in_app={in_app false} */
public class UserTileViewParamsFactory {
    private static final Object f16310e = new Object();
    private final BadgesExperimentController f16311a;
    private final MessengerUserCheckHelper f16312b;
    private final Provider<Boolean> f16313c;
    private final UserCache f16314d;

    private static UserTileViewParamsFactory m16380b(InjectorLike injectorLike) {
        return new UserTileViewParamsFactory(BadgesExperimentController.m8365b(injectorLike), MessengerUserCheckHelper.m18273b(injectorLike), IdBasedProvider.a(injectorLike, 3902), UserCache.a(injectorLike));
    }

    @Inject
    public UserTileViewParamsFactory(BadgesExperimentController badgesExperimentController, MessengerUserCheckHelper messengerUserCheckHelper, Provider<Boolean> provider, UserCache userCache) {
        this.f16311a = badgesExperimentController;
        this.f16312b = messengerUserCheckHelper;
        this.f16313c = provider;
        this.f16314d = userCache;
    }

    public final UserTileViewParams m16381a(User user) {
        TileBadge b = m16385b(user);
        return user.ao() ? UserTileViewParams.b(user, b) : UserTileViewParams.a(user, b);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.photos.tiles.UserTileViewParamsFactory m16379a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f16310e;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m16380b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f16310e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.photos.tiles.UserTileViewParamsFactory) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.photos.tiles.UserTileViewParamsFactory) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f16310e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.photos.tiles.UserTileViewParamsFactory) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.photos.tiles.UserTileViewParamsFactory.a(com.facebook.inject.InjectorLike):com.facebook.messaging.photos.tiles.UserTileViewParamsFactory");
    }

    public final UserTileViewParams m16382a(UserKey userKey) {
        return m16383a(userKey, "");
    }

    public final UserTileViewParams m16383a(UserKey userKey, String str) {
        TileBadge b = m16386b(userKey);
        return userKey.e() ? UserTileViewParams.a(userKey.f(), str, b) : UserTileViewParams.a(userKey, b);
    }

    public final UserTileViewParams m16384a(UserKey userKey, String str, ThreadKey threadKey) {
        if (ThreadKey.g(threadKey)) {
            return UserTileViewParams.a(userKey, TileBadge.TINCAN);
        }
        return m16383a(userKey, str);
    }

    public final TileBadge m16385b(User user) {
        if (this.f16311a.m8366a()) {
            return TileBadge.NONE;
        }
        if (user.A) {
            return TileBadge.NONE;
        }
        if (user.t) {
            return TileBadge.MESSENGER;
        }
        if (user.b()) {
            return TileBadge.SMS;
        }
        return (((Boolean) this.f16313c.get()).booleanValue() || user.E) ? TileBadge.NONE : TileBadge.FACEBOOK;
    }

    public final TileBadge m16386b(UserKey userKey) {
        User a = this.f16314d.a(userKey);
        if (a != null) {
            return m16385b(a);
        }
        if (this.f16311a.m8366a()) {
            return TileBadge.NONE;
        }
        if (this.f16312b.m18275a(userKey)) {
            return TileBadge.MESSENGER;
        }
        if (userKey.e()) {
            return TileBadge.SMS;
        }
        return (((Boolean) this.f16313c.get()).booleanValue() || this.f16312b.m18276c(userKey)) ? TileBadge.NONE : TileBadge.FACEBOOK;
    }
}
