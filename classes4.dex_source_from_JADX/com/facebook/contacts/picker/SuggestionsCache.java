package com.facebook.contacts.picker;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.cache.CacheSizeHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableList;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: emid */
public class SuggestionsCache<T> implements IHaveUserData {
    private static final Object f13169f = new Object();
    private final UserCache f13170a;
    private final CacheSizeHelper f13171b;
    private final Cache<UserKey, User> f13172c;
    private final Cache<SuggestionType, ImmutableList<UserKey>> f13173d = CacheBuilder.newBuilder().a(1200, TimeUnit.SECONDS).q();
    private final Cache<SuggestionType, ImmutableList<T>> f13174e = CacheBuilder.newBuilder().a(1200, TimeUnit.SECONDS).q();

    private static SuggestionsCache m14033b(InjectorLike injectorLike) {
        return new SuggestionsCache(UserCache.m10371a(injectorLike), CacheSizeHelper.m12985a(injectorLike));
    }

    @Inject
    public SuggestionsCache(UserCache userCache, CacheSizeHelper cacheSizeHelper) {
        this.f13170a = userCache;
        this.f13171b = cacheSizeHelper;
        this.f13172c = CacheBuilder.newBuilder().a(1200, TimeUnit.SECONDS).a((long) this.f13171b.m12987a(60, 200)).q();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.contacts.picker.SuggestionsCache m14031a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f13169f;	 Catch:{ all -> 0x006c }
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
        r1 = m14033b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f13169f;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.contacts.picker.SuggestionsCache) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.contacts.picker.SuggestionsCache) r0;	 Catch:{  }
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
        r0 = f13169f;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.contacts.picker.SuggestionsCache) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.picker.SuggestionsCache.a(com.facebook.inject.InjectorLike):com.facebook.contacts.picker.SuggestionsCache");
    }

    public final synchronized User m14034a(UserKey userKey) {
        User user;
        Preconditions.checkNotNull(userKey);
        user = (User) this.f13172c.a(userKey);
        if (user == null) {
            user = this.f13170a.m10373a(userKey);
        }
        return user;
    }

    private synchronized void m14032a(User user) {
        Preconditions.checkNotNull(user);
        this.f13172c.a(user.e(), user);
    }

    public final synchronized void m14037a(ImmutableList<User> immutableList) {
        ImmutableList reverse = immutableList.reverse();
        int size = reverse.size();
        for (int i = 0; i < size; i++) {
            m14032a((User) reverse.get(i));
        }
    }

    public final synchronized void m14036a(SuggestionType suggestionType, ImmutableList<UserKey> immutableList) {
        this.f13173d.a(suggestionType, immutableList);
    }

    public final synchronized void m14038b(SuggestionType suggestionType, ImmutableList<T> immutableList) {
        this.f13174e.a(suggestionType, immutableList);
    }

    public final synchronized ImmutableList<UserKey> m14035a(SuggestionType suggestionType) {
        return (ImmutableList) this.f13173d.a(suggestionType);
    }

    public synchronized void clearUserData() {
        this.f13172c.a();
        this.f13173d.a();
        this.f13174e.a();
    }
}
