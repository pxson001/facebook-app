package com.facebook.katana.provider;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.config.application.SignatureTypeMethodAutoProvider;
import com.facebook.content.FacebookOnlyIntentActionFactory;
import com.facebook.inject.FbInjector;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.notifications.GraphQLNotificationsCrossProcessContract;
import com.facebook.notifications.provider.NotificationsContentProvider;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: zero_rating_native_interstitial */
public class GraphQLNotificationsContentProvider extends NotificationsContentProvider {
    private GraphQLNotificationsCrossProcessContract f337a;
    private Provider<String> f338b;

    private static <T extends InjectableComponentWithContext> void m677a(Class<T> cls, T t) {
        m678a((Object) t, t.getContext());
    }

    private static void m678a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((GraphQLNotificationsContentProvider) obj).m676a(new GraphQLNotificationsCrossProcessContract((Context) injectorLike.getInstance(Context.class, ForAppContext.class), IdBasedProvider.m1811a(injectorLike, 4442), SignatureTypeMethodAutoProvider.m2801b(injectorLike), FacebookOnlyIntentActionFactory.m4495a(injectorLike), Handler_ForNonUiThreadMethodAutoProvider.m5523b(injectorLike)), IdBasedProvider.m1811a(injectorLike, 4442));
    }

    @Inject
    private void m676a(GraphQLNotificationsCrossProcessContract graphQLNotificationsCrossProcessContract, Provider<String> provider) {
        this.f337a = graphQLNotificationsCrossProcessContract;
        this.f338b = provider;
    }

    protected final void mo10a() {
        m677a(GraphQLNotificationsContentProvider.class, (InjectableComponentWithContext) this);
        super.mo10a();
    }

    protected final void mo52c(Uri uri) {
        super.mo52c(uri);
        GraphQLNotificationsCrossProcessContract graphQLNotificationsCrossProcessContract = this.f337a;
        String str = (String) this.f338b.get();
        Intent intent = new Intent(graphQLNotificationsCrossProcessContract.e);
        intent.putExtra("userId", str);
        graphQLNotificationsCrossProcessContract.b.sendBroadcast(intent, graphQLNotificationsCrossProcessContract.d);
    }
}
