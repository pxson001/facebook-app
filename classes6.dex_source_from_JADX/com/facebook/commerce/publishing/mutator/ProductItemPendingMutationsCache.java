package com.facebook.commerce.publishing.mutator;

import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsInterfaces.AdminCommerceProductItem;
import com.facebook.common.util.StringUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.inject.Singleton;

@Singleton
/* compiled from: place_visits */
public class ProductItemPendingMutationsCache {
    private static volatile ProductItemPendingMutationsCache f7683b;
    private final List<AdminCommerceProductItemWrapper> f7684a = Collections.synchronizedList(new ArrayList());

    /* compiled from: place_visits */
    class AdminCommerceProductItemWrapper {
        private String f7681a;
        private AdminCommerceProductItem f7682b;

        AdminCommerceProductItemWrapper(AdminCommerceProductItem adminCommerceProductItem, String str) {
            if (StringUtil.c(str)) {
                throw new IllegalArgumentException("ID can't be blank! '" + str + "'");
            }
            this.f7681a = str;
            this.f7682b = adminCommerceProductItem;
        }

        public final String m10988a() {
            return this.f7681a;
        }

        public final AdminCommerceProductItem m10989b() {
            return this.f7682b;
        }
    }

    public static com.facebook.commerce.publishing.mutator.ProductItemPendingMutationsCache m10990a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f7683b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.commerce.publishing.mutator.ProductItemPendingMutationsCache.class;
        monitor-enter(r1);
        r0 = f7683b;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m10992c();	 Catch:{ all -> 0x0034 }
        f7683b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f7683b;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.commerce.publishing.mutator.ProductItemPendingMutationsCache.a(com.facebook.inject.InjectorLike):com.facebook.commerce.publishing.mutator.ProductItemPendingMutationsCache");
    }

    private static ProductItemPendingMutationsCache m10992c() {
        return new ProductItemPendingMutationsCache();
    }

    public final synchronized ImmutableList<AdminCommerceProductItem> m10993a() {
        Builder builder;
        builder = new Builder();
        for (AdminCommerceProductItemWrapper adminCommerceProductItemWrapper : this.f7684a) {
            if (m10991a(adminCommerceProductItemWrapper.m10989b())) {
                builder.c(adminCommerceProductItemWrapper.m10989b());
            }
        }
        return builder.b();
    }

    public final synchronized ImmutableMap<String, AdminCommerceProductItem> m10996b() {
        ImmutableMap.Builder builder;
        builder = new ImmutableMap.Builder();
        for (AdminCommerceProductItemWrapper adminCommerceProductItemWrapper : this.f7684a) {
            if (!m10991a(adminCommerceProductItemWrapper.m10989b())) {
                builder.b(adminCommerceProductItemWrapper.m10989b().cu_(), adminCommerceProductItemWrapper.m10989b());
            }
        }
        return builder.b();
    }

    public final synchronized void m10994a(AdminCommerceProductItem adminCommerceProductItem, String str) {
        this.f7684a.add(new AdminCommerceProductItemWrapper(adminCommerceProductItem, str));
    }

    public final synchronized void m10995a(String str) {
        if (!StringUtil.c(str)) {
            Iterator it = this.f7684a.iterator();
            while (it.hasNext()) {
                if (((AdminCommerceProductItemWrapper) it.next()).m10988a().equals(str)) {
                    it.remove();
                    break;
                }
            }
        }
    }

    public static boolean m10991a(AdminCommerceProductItem adminCommerceProductItem) {
        return StringUtil.a(adminCommerceProductItem.cu_());
    }
}
