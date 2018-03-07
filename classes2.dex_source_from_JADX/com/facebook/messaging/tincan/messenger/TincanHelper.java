package com.facebook.messaging.tincan.messenger;

import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.model.threadkey.DefaultThreadKeyFactory;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKeyFactory;
import com.facebook.messaging.threadview.util.ThreadViewOpenHelper;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: mStarted= */
public class TincanHelper {
    private static final Class f15417a = TincanHelper.class;
    private final Lazy<BlueServiceOperationFactory> f15418b;
    private final Lazy<ThreadViewOpenHelper> f15419c;
    private final Lazy<Executor> f15420d;
    private final Provider<String> f15421e;
    private final DefaultThreadKeyFactory f15422f;

    public static TincanHelper m21961b(InjectorLike injectorLike) {
        return new TincanHelper(IdBasedLazy.m1808a(injectorLike, 1144), IdBasedLazy.m1808a(injectorLike, 8556), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3863), IdBasedProvider.m1811a(injectorLike, 4442), DefaultThreadKeyFactory.m21964b(injectorLike));
    }

    @Inject
    public TincanHelper(Lazy<BlueServiceOperationFactory> lazy, Lazy<ThreadViewOpenHelper> lazy2, Lazy<Executor> lazy3, Provider<String> provider, ThreadKeyFactory threadKeyFactory) {
        this.f15418b = lazy;
        this.f15419c = lazy2;
        this.f15420d = lazy3;
        this.f15421e = provider;
        this.f15422f = threadKeyFactory;
    }

    public static TincanHelper m21960a(InjectorLike injectorLike) {
        return m21961b(injectorLike);
    }

    public final ThreadKey m21962a(String str) {
        String str2 = (String) this.f15421e.get();
        Preconditions.checkState(str2 != null);
        long parseLong = Long.parseLong(str2);
        String[] split = str.split("_");
        long parseLong2 = Long.parseLong(split[0]);
        if (split.length > 1) {
            return ThreadKey.a(split[1], parseLong2, parseLong);
        }
        return this.f15422f.m21967b(parseLong2);
    }
}
