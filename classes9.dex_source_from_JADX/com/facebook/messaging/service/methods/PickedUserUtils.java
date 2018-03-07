package com.facebook.messaging.service.methods;

import com.facebook.user.model.UserFbidIdentifier;
import com.facebook.user.model.UserIdentifier;
import com.facebook.user.model.UserSmsIdentifier;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import javax.inject.Singleton;

@Singleton
/* compiled from: current_result */
public class PickedUserUtils {
    private static volatile PickedUserUtils f16953a;

    public static com.facebook.messaging.service.methods.PickedUserUtils m16996a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f16953a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.messaging.service.methods.PickedUserUtils.class;
        monitor-enter(r1);
        r0 = f16953a;	 Catch:{ all -> 0x0039 }
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
        r0 = m16995a();	 Catch:{ all -> 0x0034 }
        f16953a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f16953a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.service.methods.PickedUserUtils.a(com.facebook.inject.InjectorLike):com.facebook.messaging.service.methods.PickedUserUtils");
    }

    private static PickedUserUtils m16995a() {
        return new PickedUserUtils();
    }

    public static JsonNode m16998a(List<? extends UserIdentifier> list) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (UserIdentifier a : list) {
            arrayNode.a(m16997a(a));
        }
        return arrayNode;
    }

    public static JsonNode m16999b(List<UserFbidIdentifier> list) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (UserFbidIdentifier a : list) {
            arrayNode.h(a.a());
        }
        return arrayNode;
    }

    public static JsonNode m16997a(UserIdentifier userIdentifier) {
        if (userIdentifier instanceof UserSmsIdentifier) {
            UserSmsIdentifier userSmsIdentifier = (UserSmsIdentifier) userIdentifier;
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            objectNode.a("type", "phone");
            objectNode.a("phone", userSmsIdentifier.b);
            return objectNode;
        }
        JsonNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
        objectNode2.a("type", "id");
        objectNode2.a("id", userIdentifier.a());
        return objectNode2;
    }
}
