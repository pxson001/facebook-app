package com.facebook.auth.userscope;

import com.facebook.auth.userscope.UserScope.UserScopeAwareInjector;
import com.facebook.inject.InjectorThreadStack;
import javax.inject.Provider;

/* compiled from: suggested_groups_new */
public class UserScope$UserScopeAwareInjector$1 implements Provider<T> {
    final /* synthetic */ Provider f2397a;
    final /* synthetic */ UserScopeAwareInjector f2398b;

    public UserScope$UserScopeAwareInjector$1(UserScopeAwareInjector userScopeAwareInjector, Provider provider) {
        this.f2398b = userScopeAwareInjector;
        this.f2397a = provider;
    }

    public T get() {
        InjectorThreadStack a = UserScope.a(this.f2398b.a, this.f2398b);
        try {
            T t = this.f2397a.get();
            return t;
        } finally {
            UserScope userScope = this.f2398b.a;
            UserScope.a(a);
        }
    }
}
