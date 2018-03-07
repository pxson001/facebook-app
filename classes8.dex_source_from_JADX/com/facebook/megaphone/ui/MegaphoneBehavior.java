package com.facebook.megaphone.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.model.GraphQLMegaphone;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.megaphone.data.MegaphoneStore;
import com.facebook.megaphone.logger.MegaphoneLogger;
import javax.inject.Inject;

/* compiled from: tried to handle an input event after dropping the view */
public class MegaphoneBehavior {
    private final Context f1356a;
    private final FbUriIntentHandler f1357b;
    private final MegaphoneLogger f1358c;
    private final MegaphoneStore f1359d;
    private final SecureContextHelper f1360e;

    public static MegaphoneBehavior m1555b(InjectorLike injectorLike) {
        return new MegaphoneBehavior((Context) injectorLike.getInstance(Context.class), FbUriIntentHandler.a(injectorLike), new MegaphoneLogger(IdBasedProvider.a(injectorLike, 1144)), MegaphoneStore.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    MegaphoneBehavior(Context context, FbUriIntentHandler fbUriIntentHandler, MegaphoneLogger megaphoneLogger, MegaphoneStore megaphoneStore, SecureContextHelper secureContextHelper) {
        this.f1356a = context;
        this.f1357b = fbUriIntentHandler;
        this.f1358c = megaphoneLogger;
        this.f1359d = megaphoneStore;
        this.f1360e = secureContextHelper;
    }

    public final void m1556a(GraphQLMegaphone graphQLMegaphone) {
        this.f1358c.m1539a(graphQLMegaphone, "ACTION");
        m1554a(graphQLMegaphone.j().k());
        if (!graphQLMegaphone.p()) {
            this.f1359d.c(graphQLMegaphone.q());
        }
    }

    public final void m1557b(GraphQLMegaphone graphQLMegaphone) {
        if (graphQLMegaphone.o() != null && graphQLMegaphone.n() != null && graphQLMegaphone.n().b() != null) {
            this.f1358c.m1539a(graphQLMegaphone, "IMAGE_ACTION");
            m1554a(graphQLMegaphone.o());
        }
    }

    public final void m1558c(GraphQLMegaphone graphQLMegaphone) {
        this.f1358c.m1539a(graphQLMegaphone, "DISMISSAL");
        this.f1359d.c(graphQLMegaphone.q());
    }

    public final void m1559d(GraphQLMegaphone graphQLMegaphone) {
        this.f1358c.m1539a(graphQLMegaphone, "IMPRESSION");
    }

    private void m1554a(String str) {
        if (!this.f1357b.a(this.f1356a, str)) {
            this.f1360e.b(new Intent("android.intent.action.VIEW").setFlags(268435456).setData(Uri.parse(str)), this.f1356a);
        }
    }
}
