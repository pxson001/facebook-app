package com.facebook.graphql.executor.cache;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: saved_dashboard_saved_item_vpv */
public class ConsistencyTypeHelper {
    private static volatile ConsistencyTypeHelper f6161b;
    private final ObjectMapper f6162a;

    public static com.facebook.graphql.executor.cache.ConsistencyTypeHelper m10340a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6161b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.graphql.executor.cache.ConsistencyTypeHelper.class;
        monitor-enter(r1);
        r0 = f6161b;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m10343b(r0);	 Catch:{ all -> 0x0035 }
        f6161b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6161b;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.executor.cache.ConsistencyTypeHelper.a(com.facebook.inject.InjectorLike):com.facebook.graphql.executor.cache.ConsistencyTypeHelper");
    }

    private static ConsistencyTypeHelper m10343b(InjectorLike injectorLike) {
        return new ConsistencyTypeHelper(FbObjectMapperMethodAutoProvider.m6609a(injectorLike));
    }

    @Inject
    public ConsistencyTypeHelper(ObjectMapper objectMapper) {
        this.f6162a = objectMapper;
    }

    public static int m10342b(Object obj) {
        if (obj instanceof List) {
            if (((List) obj).isEmpty()) {
                return -1;
            }
            obj = ((List) obj).get(0);
        }
        if (obj instanceof Integer) {
            return 1;
        }
        if (obj instanceof Double) {
            return 2;
        }
        if (obj instanceof Long) {
            return 3;
        }
        if (obj instanceof Boolean) {
            return 4;
        }
        if (obj instanceof Enum) {
            return 6;
        }
        if (obj instanceof String) {
            return 5;
        }
        return 7;
    }

    public static Object m10341a(int i, String str, @Nullable String str2) {
        if (i == 1) {
            return Integer.valueOf(Integer.parseInt(str));
        }
        if (i == 2) {
            return Double.valueOf(Double.parseDouble(str));
        }
        if (i == 3) {
            return Long.valueOf(Long.parseLong(str));
        }
        if (i == 4) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
        if (i != 6) {
            return str;
        }
        try {
            return Enum.valueOf(Class.forName(str2), str);
        } catch (Throwable e) {
            throw Throwables.propagate(e);
        }
    }

    public static String m10344c(Object obj) {
        if (!(obj instanceof List) || ((List) obj).isEmpty()) {
            return obj.getClass().getName();
        }
        return ((List) obj).get(0).getClass().getName();
    }

    public final List<?> m10345b(int i, String str, String str2) {
        if (i == -1) {
            return ImmutableList.of();
        }
        Class cls;
        if (i == 1) {
            try {
                cls = Integer.class;
            } catch (Throwable e) {
                throw Throwables.propagate(e);
            } catch (Throwable e2) {
                throw Throwables.propagate(e2);
            }
        } else if (i == 2) {
            cls = Double.class;
        } else if (i == 3) {
            cls = Long.class;
        } else if (i == 4) {
            cls = Boolean.class;
        } else if (i == 6) {
            cls = Class.forName(str2);
        } else if (i == 5) {
            cls = String.class;
        } else {
            throw new RuntimeException("Unsupported type number " + i);
        }
        JsonParser a = this.f6162a.mo910b().m7165a(str);
        a.mo1766c();
        if (a.mo1794g() == JsonToken.START_ARRAY) {
            a.mo1766c();
            return ImmutableList.copyOf(this.f6162a.m6665c(a, cls));
        }
        throw new RuntimeException("Failed to parse array, expecting start array but was " + str);
    }

    public final String m10346d(Object obj) {
        if (!(obj instanceof List)) {
            return obj.toString();
        }
        try {
            return this.f6162a.m6659a(obj);
        } catch (JsonProcessingException e) {
            throw Throwables.propagate(e);
        }
    }
}
