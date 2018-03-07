package com.facebook.contacts.omnistore;

import android.content.Context;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.contacts.graphql.contactprofiletype.ContactProfileTypes;
import com.facebook.contacts.pictures.ContactPictureSizes;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.coverphotosize.CoverPhotoSize;
import javax.inject.Inject;

@UserScoped
/* compiled from: parentUnitType */
public class ContactsOmnistoreParamsBuilder {
    private static final Object f8359g = new Object();
    private final ContactPictureSizes f8360a;
    private final GraphQLImageHelper f8361b;
    private final CoverPhotoSize f8362c;
    private final ContactProfileTypes f8363d;
    private final AbstractFbErrorReporter f8364e;
    private final Context f8365f;

    private static ContactsOmnistoreParamsBuilder m12152b(InjectorLike injectorLike) {
        return new ContactsOmnistoreParamsBuilder(ContactPictureSizes.a(injectorLike), GraphQLImageHelper.a(injectorLike), CoverPhotoSize.m7818a(injectorLike), ContactProfileTypes.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public ContactsOmnistoreParamsBuilder(ContactPictureSizes contactPictureSizes, GraphQLImageHelper graphQLImageHelper, CoverPhotoSize coverPhotoSize, ContactProfileTypes contactProfileTypes, AbstractFbErrorReporter abstractFbErrorReporter, Context context) {
        this.f8360a = contactPictureSizes;
        this.f8361b = graphQLImageHelper;
        this.f8362c = coverPhotoSize;
        this.f8363d = contactProfileTypes;
        this.f8364e = abstractFbErrorReporter;
        this.f8365f = context;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.contacts.omnistore.ContactsOmnistoreParamsBuilder m12151a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f8359g;	 Catch:{ all -> 0x006c }
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
        r1 = m12152b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f8359g;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.contacts.omnistore.ContactsOmnistoreParamsBuilder) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.contacts.omnistore.ContactsOmnistoreParamsBuilder) r0;	 Catch:{  }
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
        r0 = f8359g;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.contacts.omnistore.ContactsOmnistoreParamsBuilder) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.omnistore.ContactsOmnistoreParamsBuilder.a(com.facebook.inject.InjectorLike):com.facebook.contacts.omnistore.ContactsOmnistoreParamsBuilder");
    }
}
