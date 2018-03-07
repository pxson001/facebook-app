package com.facebook.platform.common.util;

import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.InjectorLike;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Singleton
/* compiled from: storefront_collection_header */
public class PlatformBundleToJSONConverter {
    private static final Class[] f4094a = new Class[]{Boolean.class, Integer.class, Long.class, Double.class, String.class};
    private static volatile PlatformBundleToJSONConverter f4095c;
    private AbstractFbErrorReporter f4096b;

    public static com.facebook.platform.common.util.PlatformBundleToJSONConverter m6005a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f4095c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.platform.common.util.PlatformBundleToJSONConverter.class;
        monitor-enter(r1);
        r0 = f4095c;	 Catch:{ all -> 0x003a }
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
        r0 = m6007b(r0);	 Catch:{ all -> 0x0035 }
        f4095c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4095c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.platform.common.util.PlatformBundleToJSONConverter.a(com.facebook.inject.InjectorLike):com.facebook.platform.common.util.PlatformBundleToJSONConverter");
    }

    private static PlatformBundleToJSONConverter m6007b(InjectorLike injectorLike) {
        return new PlatformBundleToJSONConverter((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public PlatformBundleToJSONConverter(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f4096b = abstractFbErrorReporter;
    }

    public final JSONObject m6009a(Bundle bundle) {
        return m6006a(bundle, f4094a);
    }

    private JSONObject m6006a(Bundle bundle, Class[] clsArr) {
        if (bundle == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            Object obj;
            Object obj2 = bundle.get(str);
            if (obj2 == null) {
                obj = JSONObject.NULL;
            } else if (obj2 instanceof Bundle) {
                obj = m6006a((Bundle) obj2, clsArr);
            } else {
                int i;
                for (Class isAssignableFrom : clsArr) {
                    if (isAssignableFrom.isAssignableFrom(obj2.getClass())) {
                        i = 1;
                        break;
                    }
                }
                i = 0;
                if (i != 0) {
                    obj = obj2;
                } else {
                    JSONArray jSONArray = new JSONArray();
                    JSONArray jSONArray2;
                    if (obj2 instanceof int[]) {
                        for (int put : (int[]) obj2) {
                            jSONArray.put(put);
                        }
                        jSONArray2 = jSONArray;
                    } else if (obj2 instanceof long[]) {
                        for (long put2 : (long[]) obj2) {
                            jSONArray.put(put2);
                        }
                        jSONArray2 = jSONArray;
                    } else if (obj2 instanceof double[]) {
                        for (double put3 : (double[]) obj2) {
                            try {
                                jSONArray.put(put3);
                            } catch (JSONException e) {
                                jSONArray.put(0);
                            }
                        }
                        jSONArray2 = jSONArray;
                    } else if (obj2 instanceof boolean[]) {
                        for (boolean put4 : (boolean[]) obj2) {
                            jSONArray.put(put4);
                        }
                        jSONArray2 = jSONArray;
                    } else {
                        if (obj2 instanceof List) {
                            try {
                                for (Object obj3 : (List) obj2) {
                                    if (obj3 == null) {
                                        obj3 = JSONObject.NULL;
                                    }
                                    jSONArray.put(obj3);
                                }
                                jSONArray2 = jSONArray;
                            } catch (ClassCastException e2) {
                            }
                        }
                        obj3 = null;
                    }
                }
            }
            if (obj3 != null) {
                try {
                    jSONObject.put(str, obj3);
                } catch (Throwable e3) {
                    this.f4096b.a("PlatformBundleToJSONConverter", StringFormatUtil.formatStrLocaleSafe("Unsupported value for JSON : %s", obj3.toString()), e3);
                }
            } else {
                this.f4096b.a("PlatformBundleToJSONConverter", StringFormatUtil.formatStrLocaleSafe("Unsupported type for JSON : %s", obj2.getClass().toString()));
            }
        }
        return jSONObject;
    }

    public final Bundle m6008a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            try {
                Object obj = jSONObject.get(str);
                if (obj != null) {
                    if (obj instanceof String) {
                        bundle.putString(str, (String) obj);
                    } else if (obj instanceof Integer) {
                        bundle.putInt(str, ((Integer) obj).intValue());
                    } else if (obj instanceof Double) {
                        bundle.putDouble(str, ((Double) obj).doubleValue());
                    } else if (obj instanceof Long) {
                        bundle.putLong(str, ((Long) obj).longValue());
                    } else if (obj instanceof Boolean) {
                        bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof JSONObject) {
                        bundle.putBundle(str, m6008a((JSONObject) obj));
                    } else if (obj == JSONObject.NULL) {
                        bundle.putString(str, null);
                    }
                }
            } catch (Throwable e) {
                this.f4096b.a("PlatformBundleToJSONConverter", StringFormatUtil.formatStrLocaleSafe("JSONObject.keys() provided a problematic key : %s", str), e);
            }
        }
        return bundle;
    }
}
