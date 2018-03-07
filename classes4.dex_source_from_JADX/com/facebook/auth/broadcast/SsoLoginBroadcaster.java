package com.facebook.auth.broadcast;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.build.SignatureType;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.config.application.SignatureTypeMethodAutoProvider;
import com.facebook.content.FacebookOnlyIntentActionFactory;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: syncUserQE */
public class SsoLoginBroadcaster {
    private final Context f1503a;
    private final SignatureType f1504b;
    private final Product f1505c;
    private final FacebookOnlyIntentActionFactory f1506d;

    public static SsoLoginBroadcaster m1711b(InjectorLike injectorLike) {
        return new SsoLoginBroadcaster((Context) injectorLike.getInstance(Context.class), SignatureTypeMethodAutoProvider.b(injectorLike), ProductMethodAutoProvider.b(injectorLike), FacebookOnlyIntentActionFactory.a(injectorLike));
    }

    @Inject
    public SsoLoginBroadcaster(Context context, SignatureType signatureType, Product product, FacebookOnlyIntentActionFactory facebookOnlyIntentActionFactory) {
        this.f1503a = context;
        this.f1504b = signatureType;
        this.f1505c = product;
        this.f1506d = facebookOnlyIntentActionFactory;
    }

    public final void m1712a() {
        m1710a("SSO_LOGIN");
    }

    public final void m1713b() {
        m1710a("AUTH_LOGOUT");
    }

    private void m1710a(String str) {
        Intent intent = new Intent(this.f1506d.a(str));
        intent.putExtra("extra_product", this.f1505c.name());
        intent.addFlags(32);
        this.f1503a.sendBroadcast(intent, this.f1504b.getPermission());
    }
}
