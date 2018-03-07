package com.facebook.fbreact.instance;

import com.facebook.auth.component.AbstractAuthComponent;
import com.facebook.auth.component.AuthenticationResult;
import com.facebook.fbreact.fb4a.Fb4aReactInstanceManager;
import com.facebook.fbreact.interfaces.FbReactInstanceManager;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: staging_ground_post_to_news_feed */
public class FbReactInstanceAuthComponent extends AbstractAuthComponent {
    private final Lazy<FbReactInstanceHolder> f3499a;
    private final Lazy<FbReactInstanceManager> f3500b;

    private static FbReactInstanceAuthComponent m4200b(InjectorLike injectorLike) {
        return new FbReactInstanceAuthComponent(IdBasedSingletonScopeProvider.b(injectorLike, 5782), IdBasedSingletonScopeProvider.b(injectorLike, 1138));
    }

    @Inject
    public FbReactInstanceAuthComponent(Lazy<FbReactInstanceHolder> lazy, Lazy<FbReactInstanceManager> lazy2) {
        this.f3499a = lazy;
        this.f3500b = lazy2;
    }

    public final void m4201a(@Nullable AuthenticationResult authenticationResult) {
        ((Fb4aReactInstanceManager) this.f3500b.get()).init();
    }

    public final void m4202f() {
        ((FbReactInstanceHolder) this.f3499a.get()).m4206b();
    }
}
