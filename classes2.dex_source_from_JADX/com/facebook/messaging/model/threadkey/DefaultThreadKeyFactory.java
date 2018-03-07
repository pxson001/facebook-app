package com.facebook.messaging.model.threadkey;

import android.content.Context;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.identifiers.UniqueIdGenerator;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: mStartFrame */
public class DefaultThreadKeyFactory {
    private final Context f15423a;
    private final Provider<ViewerContext> f15424b;
    private final UniqueIdGenerator f15425c;

    public static DefaultThreadKeyFactory m21964b(InjectorLike injectorLike) {
        return new DefaultThreadKeyFactory((Context) injectorLike.getInstance(Context.class), IdBasedProvider.m1811a(injectorLike, 372), UniqueIdGenerator.m21968a(injectorLike));
    }

    @Inject
    public DefaultThreadKeyFactory(Context context, Provider<ViewerContext> provider, UniqueIdGenerator uniqueIdGenerator) {
        this.f15423a = context;
        this.f15424b = provider;
        this.f15425c = uniqueIdGenerator;
    }

    public final ThreadKey m21966a(UserKey userKey) {
        if (userKey.m5866a() == Type.FACEBOOK) {
            return m21965a(Long.parseLong(userKey.m5867b()));
        }
        if (userKey.m5866a() == Type.PHONE_NUMBER) {
            return ThreadKey.b(SmsThreadKeyUtil.a(this.f15423a, userKey.m5872g()));
        }
        throw new IllegalArgumentException("Unsupported UserKey type.");
    }

    public static DefaultThreadKeyFactory m21963a(InjectorLike injectorLike) {
        return m21964b(injectorLike);
    }

    public final ThreadKey m21965a(long j) {
        return ThreadKey.a(j, Long.parseLong(((ViewerContext) this.f15424b.get()).mUserId));
    }

    public final ThreadKey m21967b(long j) {
        return ThreadKey.a("PENDING", j, Long.parseLong(((ViewerContext) this.f15424b.get()).mUserId));
    }
}
