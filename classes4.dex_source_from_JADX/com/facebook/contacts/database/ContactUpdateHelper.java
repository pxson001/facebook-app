package com.facebook.contacts.database;

import android.os.Bundle;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.contacts.server.UpdateContactIsMessengerUserParams;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.Operation;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Strings;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fetchViewerAudienceInfo */
public class ContactUpdateHelper {
    private static volatile ContactUpdateHelper f11672c;
    private final DefaultBlueServiceOperationFactory f11673a;
    private final Product f11674b;

    public static com.facebook.contacts.database.ContactUpdateHelper m12218a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f11672c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.contacts.database.ContactUpdateHelper.class;
        monitor-enter(r1);
        r0 = f11672c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m12219b(r0);	 Catch:{ all -> 0x0035 }
        f11672c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11672c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.database.ContactUpdateHelper.a(com.facebook.inject.InjectorLike):com.facebook.contacts.database.ContactUpdateHelper");
    }

    private static ContactUpdateHelper m12219b(InjectorLike injectorLike) {
        return new ContactUpdateHelper(ProductMethodAutoProvider.b(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike));
    }

    @Inject
    public ContactUpdateHelper(Product product, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f11674b = product;
        this.f11673a = defaultBlueServiceOperationFactory;
    }

    public final void m12220a(String str, boolean z) {
        if (this.f11674b == Product.MESSENGER && !Strings.isNullOrEmpty(str)) {
            UpdateContactIsMessengerUserParams updateContactIsMessengerUserParams = new UpdateContactIsMessengerUserParams(str, z);
            Bundle bundle = new Bundle();
            bundle.putParcelable("updateIsMessengerUserParams", updateContactIsMessengerUserParams);
            Operation a = BlueServiceOperationFactoryDetour.a(this.f11673a, "update_contact_is_messenger_user", bundle, 547016515);
            a.a(true);
            a.a();
        }
    }
}
