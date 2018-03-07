package com.facebook.auth.protocol;

import com.facebook.common.util.JSONUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: suggestion */
public class UserFqlHelper {
    private static volatile UserFqlHelper f2372a;

    public static com.facebook.auth.protocol.UserFqlHelper m3245a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2372a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.auth.protocol.UserFqlHelper.class;
        monitor-enter(r1);
        r0 = f2372a;	 Catch:{ all -> 0x0039 }
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
        r0 = m3244a();	 Catch:{ all -> 0x0034 }
        f2372a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f2372a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.auth.protocol.UserFqlHelper.a(com.facebook.inject.InjectorLike):com.facebook.auth.protocol.UserFqlHelper");
    }

    private static UserFqlHelper m3244a() {
        return new UserFqlHelper();
    }

    public static JsonNode m3247a(JsonNode... jsonNodeArr) {
        if (jsonNodeArr.length == 0) {
            return new ArrayNode(JsonNodeFactory.a);
        }
        if (jsonNodeArr.length == 1) {
            return jsonNodeArr[0];
        }
        JsonNode jsonNode;
        int length = jsonNodeArr.length;
        int i = 0;
        ArrayNode arrayNode = null;
        while (i < length) {
            ArrayNode arrayNode2;
            jsonNode = jsonNodeArr[i];
            if (jsonNode.e() > 0) {
                if (arrayNode != null) {
                    jsonNode = null;
                    break;
                }
                arrayNode2 = (ArrayNode) jsonNode;
            } else {
                arrayNode2 = arrayNode;
            }
            i++;
            arrayNode = arrayNode2;
        }
        jsonNode = arrayNode;
        if (jsonNode != null) {
            return jsonNode;
        }
        arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (JsonNode jsonNode2 : jsonNodeArr) {
            for (int i2 = 0; i2 < jsonNode2.e(); i2++) {
                arrayNode.a(jsonNode2.a(i2));
            }
        }
        return arrayNode;
    }

    public static JsonNode m3246a(JsonNode jsonNode, JsonNode jsonNode2, JsonNode jsonNode3) {
        int i;
        int i2 = 0;
        Map c = Maps.c();
        for (i = 0; i < jsonNode2.e(); i++) {
            JsonNode a = jsonNode2.a(i);
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            objectNode.a("uid", JSONUtil.b(a.b("id")));
            Iterator j = a.j();
            while (j.hasNext()) {
                String str = (String) j.next();
                objectNode.c(str, a.b(str));
            }
            c.put(JSONUtil.b(a.b("id")), objectNode);
        }
        for (i = 0; i < jsonNode.e(); i++) {
            ObjectNode objectNode2;
            JsonNode a2 = jsonNode.a(i);
            ObjectNode objectNode3 = (ObjectNode) c.get(JSONUtil.b(a2.b("uid")));
            if (objectNode3 == null) {
                objectNode3 = new ObjectNode(JsonNodeFactory.a);
                c.put(JSONUtil.b(objectNode3.b("uid")), objectNode3);
                objectNode2 = objectNode3;
            } else {
                objectNode2 = objectNode3;
            }
            j = a2.j();
            while (j.hasNext()) {
                str = (String) j.next();
                objectNode2.c(str, a2.b(str));
            }
        }
        if (jsonNode3 != null) {
            Map c2 = Maps.c();
            while (i2 < jsonNode3.e()) {
                a = jsonNode3.a(i2);
                ArrayNode arrayNode = (ArrayNode) c2.get(JSONUtil.b(a.b("id")));
                if (arrayNode == null) {
                    arrayNode = new ArrayNode(JsonNodeFactory.a);
                    c2.put(JSONUtil.b(a.b("id")), arrayNode);
                }
                arrayNode.a(a);
                i2++;
            }
            for (Entry entry : c2.entrySet()) {
                ObjectNode objectNode4 = (ObjectNode) c.get(entry.getKey());
                if (objectNode4 != null) {
                    objectNode4.c("profile_pic_square", (JsonNode) entry.getValue());
                }
            }
        }
        ArrayNode arrayNode2 = new ArrayNode(JsonNodeFactory.a);
        for (ObjectNode objectNode32 : c.values()) {
            arrayNode2.a(objectNode32);
        }
        return arrayNode2;
    }
}
