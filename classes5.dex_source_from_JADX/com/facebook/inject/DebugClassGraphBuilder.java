package com.facebook.inject;

import android.os.Environment;
import com.facebook.androidinternals.android.os.SystemPropertiesInternal;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.instrumentation.InstrumentationHelper;
import com.facebook.common.instrumentation.InstrumentationHelper.InstrumentationLogger;
import com.facebook.common.instrumentation.InstrumentationInfo;
import com.facebook.common.instrumentation.InstrumentationInformationCollector;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Key;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: desired_initial_facing */
public class DebugClassGraphBuilder {
    @GuardedBy("this")
    static final DebugClassGraphBuilder f5119a = new DebugClassGraphBuilder();
    static final /* synthetic */ boolean f5120b = (!DebugClassGraphBuilder.class.desiredAssertionStatus());
    public static final Class<?> f5121c = DebugClassGraphBuilder.class;
    public static final InstrumentationLogger f5122d = new C04831();
    private final Object f5123e = new Object();
    @GuardedBy("mLock")
    private final Map<Long, ProviderCallTreeInfo> f5124f = Maps.c();
    @GuardedBy("mLock")
    private final List<ProviderCallTreeInfo> f5125g = Lists.b();
    private InstrumentationInfo f5126h;
    private AtomicBoolean f5127i;
    private AtomicBoolean f5128j;
    private boolean f5129k = false;

    /* compiled from: desired_initial_facing */
    final class C04831 implements InstrumentationLogger {
        public final void mo565a(String str) {
            Class cls = DebugClassGraphBuilder.f5121c;
        }

        public final void mo566a(String str, Throwable th) {
            Class cls = DebugClassGraphBuilder.f5121c;
        }

        C04831() {
        }
    }

    /* compiled from: desired_initial_facing */
    public class ProviderCall {
        public final Key<?> f5108a;
        public final List<ProviderCall> f5109b = Lists.b();
        public final InstrumentationInfo f5110c;
        public InstrumentationInformationCollector f5111d;
        public Long f5112e;
        public Long f5113f;
        public long f5114g;
        public Class<?> f5115h;

        public ProviderCall(Key<?> key, InstrumentationInfo instrumentationInfo) {
            this.f5108a = key;
            this.f5110c = instrumentationInfo;
            this.f5114g = 0;
        }

        public static void m10003b(ProviderCall providerCall, long j) {
            providerCall.f5114g += j;
        }

        public final void m10004a(JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (this.f5115h != null) {
                jsonGenerator.a("class", this.f5115h.getName());
            }
            if (!(this.f5108a == null || this.f5108a.b() == null)) {
                jsonGenerator.a("annotationClass", this.f5108a.b().getName());
            }
            if (this.f5112e != null) {
                jsonGenerator.a("startTime", this.f5112e.longValue());
            }
            if (this.f5113f != null) {
                jsonGenerator.a("duration", this.f5113f.longValue());
            }
            if (this.f5111d != null) {
                jsonGenerator.a("callCnt", this.f5111d.f2634a.get());
            }
            jsonGenerator.a("overheadCorrection", this.f5114g);
            jsonGenerator.a("dependencies");
            jsonGenerator.d();
            for (ProviderCall a : this.f5109b) {
                a.m10004a(jsonGenerator);
            }
            jsonGenerator.e();
            jsonGenerator.g();
        }
    }

    /* compiled from: desired_initial_facing */
    class ProviderCallTreeInfo {
        public final Stack<ProviderCall> f5116a = new Stack();
        public final ProviderCall f5117b;
        public final String[] f5118c;

        private ProviderCallTreeInfo(ProviderCall providerCall, String[] strArr) {
            this.f5117b = providerCall;
            this.f5118c = strArr;
        }

        public static ProviderCallTreeInfo m10005a(ProviderCall providerCall) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            String[] strArr = new String[(stackTrace.length - 5)];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = stackTrace[i + 5].toString();
            }
            return new ProviderCallTreeInfo(providerCall, strArr);
        }

        public final void m10006a(JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            jsonGenerator.a("stackTrace");
            jsonGenerator.d();
            for (String b : this.f5118c) {
                jsonGenerator.b(b);
            }
            jsonGenerator.e();
            jsonGenerator.a("head");
            this.f5117b.m10004a(jsonGenerator);
            jsonGenerator.g();
        }
    }

    private DebugClassGraphBuilder() {
    }

    final ProviderCall m10017a(Key<?> key) {
        long nanoTime = System.nanoTime();
        if (!m10013e()) {
            return null;
        }
        if (this.f5126h == null) {
            this.f5126h = new InstrumentationInfo();
        }
        ProviderCall providerCall = new ProviderCall(key, this.f5126h);
        m10007a(providerCall);
        nanoTime = System.nanoTime() - nanoTime;
        if (providerCall.f5112e != null) {
            BLog.b(f5121c, "Already started provider call.");
        } else {
            providerCall.f5114g += nanoTime;
            providerCall.f5112e = Long.valueOf(System.nanoTime());
        }
        return providerCall;
    }

    final void m10018a(ProviderCall providerCall, Object obj) {
        if (providerCall != null) {
            if (providerCall.f5112e == null) {
                BLog.b(f5121c, "Haven't started provider call.");
            } else if (providerCall.f5113f != null) {
                BLog.b(f5121c, "Have already called stop on this provider calls");
            } else {
                Class cls;
                providerCall.f5113f = Long.valueOf(System.nanoTime() - providerCall.f5112e.longValue());
                long nanoTime = System.nanoTime();
                if (obj != null) {
                    cls = obj.getClass();
                } else {
                    cls = providerCall.f5108a.b.a;
                }
                providerCall.f5115h = cls;
                providerCall.f5111d = InstrumentationHelper.m3742a(obj, providerCall.f5110c, f5122d);
                providerCall.f5114g += System.nanoTime() - nanoTime;
            }
            long nanoTime2 = System.nanoTime();
            ProviderCall b = m10010b(providerCall);
            if (b != null) {
                b.f5109b.add(providerCall);
            }
            m10011c();
            ProviderCall.m10003b(providerCall, System.nanoTime() - nanoTime2);
        }
    }

    private void m10011c() {
        m10008a(m10014f());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m10008a(boolean r3) {
        /*
        r2 = this;
        r1 = r2.f5123e;
        monitor-enter(r1);
        if (r3 != 0) goto L_0x000d;
    L_0x0005:
        r0 = r2.f5124f;	 Catch:{ all -> 0x0014 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0014 }
        if (r0 != 0) goto L_0x000f;
    L_0x000d:
        monitor-exit(r1);	 Catch:{ all -> 0x0014 }
    L_0x000e:
        return;
    L_0x000f:
        monitor-exit(r1);	 Catch:{ all -> 0x0014 }
        r2.m10015g();
        goto L_0x000e;
    L_0x0014:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.inject.DebugClassGraphBuilder.a(boolean):void");
    }

    private void m10007a(ProviderCall providerCall) {
        synchronized (this.f5123e) {
            long d = m10012d();
            ProviderCallTreeInfo providerCallTreeInfo = (ProviderCallTreeInfo) this.f5124f.get(Long.valueOf(d));
            if (providerCallTreeInfo == null) {
                providerCallTreeInfo = ProviderCallTreeInfo.m10005a(providerCall);
                this.f5124f.put(Long.valueOf(d), providerCallTreeInfo);
            }
            providerCallTreeInfo.f5116a.add(providerCall);
        }
    }

    private ProviderCall m10010b(ProviderCall providerCall) {
        ProviderCall providerCall2;
        synchronized (this.f5123e) {
            long d = m10012d();
            ProviderCallTreeInfo providerCallTreeInfo = (ProviderCallTreeInfo) this.f5124f.get(Long.valueOf(d));
            ProviderCall providerCall3 = (ProviderCall) providerCallTreeInfo.f5116a.pop();
            if (!f5120b && providerCall3 != providerCall) {
                throw new AssertionError();
            } else if (providerCallTreeInfo.f5116a.isEmpty()) {
                this.f5124f.remove(Long.valueOf(d));
                this.f5125g.add(providerCallTreeInfo);
                providerCall2 = null;
            } else {
                providerCall2 = (ProviderCall) providerCallTreeInfo.f5116a.peek();
            }
        }
        return providerCall2;
    }

    private static long m10012d() {
        return Thread.currentThread().getId();
    }

    private boolean m10013e() {
        boolean f = m10014f();
        if (this.f5129k == f) {
            return this.f5129k;
        }
        this.f5129k = f;
        if (this.f5129k) {
            File i = m10016i();
            if (i.exists() && !i.delete()) {
                BLog.b(f5121c, "Could not delete DI call graph to the sdcard");
            }
            return f;
        }
        if (this.f5126h != null) {
            this.f5126h.f2633a.set(false);
            this.f5126h = null;
        }
        m10008a(f);
        return f;
    }

    private boolean m10014f() {
        if (this.f5128j != null) {
            return this.f5128j.get();
        }
        if (!BuildConstants.i) {
            return false;
        }
        if (this.f5127i == null) {
            this.f5127i = new AtomicBoolean(m10009a("fb4a.debug.digraph.enabled"));
        }
        if (this.f5127i.get()) {
            return m10009a("fb4a.debug.digraph.running");
        }
        return false;
    }

    private static boolean m10009a(String str) {
        try {
            return "true".equalsIgnoreCase(SystemPropertiesInternal.a(str));
        } catch (Throwable e) {
            BLog.b(f5121c, StringFormatUtil.formatStrLocaleSafe("Cannot call get for key %s from SystemProperties", str), e);
            return false;
        }
    }

    private void m10015g() {
        try {
            JsonGenerator a = new JsonFactory().a(m10016i(), JsonEncoding.UTF8);
            a.f();
            a.a("callTrees");
            a.d();
            synchronized (this.f5123e) {
                for (ProviderCallTreeInfo a2 : this.f5125g) {
                    a2.m10006a(a);
                }
                this.f5125g.clear();
            }
            a.e();
            a.g();
            a.close();
        } catch (Throwable e) {
            BLog.b(f5121c, "Could not write DI call graph to the sdcard", e);
        }
    }

    public static File m10016i() {
        return new File(Environment.getExternalStorageDirectory(), "DIGraph.json");
    }
}
