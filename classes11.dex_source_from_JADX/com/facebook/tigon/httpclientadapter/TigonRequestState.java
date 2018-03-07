package com.facebook.tigon.httpclientadapter;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.facebook.http.common.FbRequestState;
import com.facebook.tigon.iface.TigonRequest;
import com.facebook.tigon.tigonapi.TigonDirectBufferRelease;
import com.facebook.tigon.tigonapi.TigonError;
import com.facebook.tigon.tigonapi.TigonRequestStatsSummaryInfoImpl;
import com.facebook.tigon.tigonapi.TigonRequestToken;
import com.facebook.tigon.tigonapi.TigonResponse;
import com.facebook.tigon.tigonapi.TigonSummaryImpl;
import com.facebook.tigon.tigonapi.TigonSummaryLayers;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.SettableFuture;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.InputStreamEntity;

/* compiled from: not_batch_rerun */
public class TigonRequestState {
    public static volatile AbstractFbErrorReporter f4972c;
    public final String f4973a;
    public final int f4974b;
    private byte f4975d;
    private byte f4976e;
    private int f4977f = 0;
    private int f4978g;
    private final ResponseHandler f4979h;
    private final FlowObserverRequestInfo f4980i;
    private final SettableFuture f4981j;
    private final TigonDirectBufferRelease f4982k;
    private final FbRequestState f4983l;
    public final TigonStateMachine f4984m;
    private final boolean f4985n;
    private final int f4986o;
    private Object f4987p;
    private Throwable f4988q;
    private TigonSummaryImpl f4989r;
    private int f4990s;
    private TigonBodyBuffer f4991t;
    @Nullable
    private TigonRequestToken f4992u;

    private TigonRequestState(String str, int i, ResponseHandler responseHandler, FlowObserverRequestInfo flowObserverRequestInfo, FbRequestState fbRequestState, SettableFuture settableFuture, TigonDirectBufferRelease tigonDirectBufferRelease, int i2, boolean z) {
        this.f4973a = str;
        this.f4974b = i;
        this.f4979h = responseHandler;
        this.f4980i = flowObserverRequestInfo;
        this.f4983l = fbRequestState;
        this.f4981j = settableFuture;
        this.f4982k = tigonDirectBufferRelease;
        this.f4985n = z;
        this.f4986o = i2;
        this.f4975d = (byte) 0;
        this.f4976e = (byte) 10;
        this.f4978g = 0;
        this.f4991t = new TigonBodyBuffer(tigonDirectBufferRelease, this.f4974b);
        this.f4984m = new TigonStateMachine(this);
    }

    @Nonnull
    static TigonRequestState m6246a(String str, int i, ResponseHandler responseHandler, FlowObserverRequestInfo flowObserverRequestInfo, FbRequestState fbRequestState, SettableFuture settableFuture, TigonDirectBufferRelease tigonDirectBufferRelease, int i2, boolean z) {
        if (TigonHttpClientAdapterModule.f4962b) {
            Integer.valueOf(i);
        }
        return new TigonRequestState(str, i, responseHandler, flowObserverRequestInfo, fbRequestState, settableFuture, tigonDirectBufferRelease, i2, z);
    }

    private boolean m6251b(int i) {
        return i == this.f4978g;
    }

    final synchronized boolean m6269a() {
        return this.f4975d == (byte) 0;
    }

    final synchronized boolean m6271b() {
        boolean z = true;
        synchronized (this) {
            if (this.f4975d != (byte) 1) {
                z = false;
            }
        }
        return z;
    }

    final synchronized boolean m6272c() {
        boolean z;
        z = this.f4975d == (byte) 2 || this.f4975d == (byte) 3;
        return z;
    }

    public final String m6273d() {
        return this.f4973a;
    }

    final synchronized int m6274e() {
        return this.f4978g;
    }

    @Nullable
    public final TigonRequestToken m6275f() {
        return this.f4992u;
    }

    public final long m6276g() {
        return this.f4984m.m6296b();
    }

    final synchronized TigonBodyBuffer m6277h() {
        return this.f4991t;
    }

    final synchronized void m6267a(@Nonnull TigonRequestToken tigonRequestToken) {
        this.f4992u = tigonRequestToken;
    }

    private InputStream m6252l() {
        return this.f4991t;
    }

    final synchronized void m6265a(TigonRequest tigonRequest) {
        this.f4984m.m6307m();
        this.f4980i.m6211a(tigonRequest);
    }

    final void m6278i() {
        this.f4984m.m6309o();
    }

    final void m6279k() {
        this.f4984m.m6310p();
    }

    final synchronized void m6264a(TigonHttpClientAdapterImpl tigonHttpClientAdapterImpl, TigonSummaryImpl tigonSummaryImpl) {
        Preconditions.checkState(this.f4976e == (byte) 10);
        this.f4976e = (byte) 11;
        this.f4989r = tigonSummaryImpl;
        this.f4984m.m6305k();
        if (this.f4975d == (byte) 2) {
            if (TigonHttpClientAdapterModule.f4962b) {
                Integer.valueOf(this.f4974b);
            }
            this.f4991t.m6224a();
            m6247a(this.f4978g, tigonHttpClientAdapterImpl, this.f4987p);
        } else if (this.f4975d == (byte) 3) {
            if (TigonHttpClientAdapterModule.f4962b) {
                Integer.valueOf(this.f4974b);
            }
            this.f4991t.m6225a(this.f4988q);
            m6248a(this.f4978g, tigonHttpClientAdapterImpl, this.f4988q);
        } else {
            if (TigonHttpClientAdapterModule.f4962b) {
                Integer.valueOf(this.f4974b);
                Byte.valueOf(this.f4975d);
            }
            this.f4991t.m6224a();
        }
        m6256p();
    }

    final synchronized void m6263a(TigonHttpClientAdapterImpl tigonHttpClientAdapterImpl, TigonError tigonError, TigonSummaryImpl tigonSummaryImpl) {
        Preconditions.checkState(this.f4976e == (byte) 10);
        this.f4984m.m6306l();
        this.f4976e = (byte) 12;
        this.f4989r = tigonSummaryImpl;
        if (TigonHttpClientAdapterModule.f4962b) {
            Integer.valueOf(this.f4974b);
            Byte.valueOf(this.f4975d);
        }
        Throwable tigonErrorException = new TigonErrorException(tigonError);
        switch (this.f4975d) {
            case (byte) 1:
                this.f4991t.m6225a(tigonErrorException);
                this.f4988q = tigonErrorException;
                break;
            case (byte) 2:
                this.f4991t.m6224a();
                m6247a(this.f4978g, tigonHttpClientAdapterImpl, this.f4987p);
                break;
            default:
                if (this.f4988q != null) {
                    tigonErrorException = this.f4988q;
                }
                this.f4991t.m6225a(tigonErrorException);
                m6248a(this.f4978g, tigonHttpClientAdapterImpl, tigonErrorException);
                break;
        }
        m6256p();
    }

    final synchronized void m6266a(TigonError tigonError, TigonSummaryImpl tigonSummaryImpl) {
        if (TigonHttpClientAdapterModule.f4962b) {
            Integer.valueOf(this.f4974b);
        }
        this.f4980i.m6213a(tigonError, tigonSummaryImpl, this.f4978g);
        this.f4984m.m6304j();
        this.f4975d = (byte) 0;
        this.f4976e = (byte) 10;
        this.f4987p = null;
        this.f4988q = null;
        this.f4978g++;
        this.f4991t.m6224a();
        this.f4991t = new TigonBodyBuffer(this.f4982k, this.f4974b);
        this.f4990s = 0;
        m6256p();
    }

    public final synchronized HttpResponse m6258a(TigonResponse tigonResponse) {
        HttpResponse a;
        a = TigonHttpResponseBuilder.m6244a(this.f4974b, tigonResponse);
        FlowObserverRequestInfo flowObserverRequestInfo = this.f4980i;
        flowObserverRequestInfo.m6216a(a);
        InputStream a2 = flowObserverRequestInfo.m6210a(m6252l());
        if (a2 != null) {
            a.setEntity(new InputStreamEntity(a2, TigonHttpUtils.m6245a(tigonResponse)));
        }
        return a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final synchronized boolean m6270a(int r5, int r6) {
        /*
        r4 = this;
        r1 = 1;
        r0 = 0;
        monitor-enter(r4);
        r2 = com.facebook.tigon.httpclientadapter.TigonHttpClientAdapterModule.f4962b;	 Catch:{ all -> 0x004e }
        if (r2 == 0) goto L_0x000c;
    L_0x0007:
        r2 = r4.f4974b;	 Catch:{ all -> 0x004e }
        java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x004e }
    L_0x000c:
        r2 = r4.m6251b(r5);	 Catch:{ all -> 0x004e }
        if (r2 != 0) goto L_0x0025;
    L_0x0012:
        r1 = com.facebook.tigon.httpclientadapter.TigonHttpClientAdapterModule.f4962b;	 Catch:{ all -> 0x004e }
        if (r1 == 0) goto L_0x0023;
    L_0x0016:
        r1 = r4.f4974b;	 Catch:{ all -> 0x004e }
        java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x004e }
        java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x004e }
        r1 = r4.f4978g;	 Catch:{ all -> 0x004e }
        java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x004e }
    L_0x0023:
        monitor-exit(r4);
        return r0;
    L_0x0025:
        r4.f4990s = r6;	 Catch:{  }
        r2 = r4.f4984m;	 Catch:{  }
        r2.m6301g();	 Catch:{  }
        r2 = r4.f4976e;	 Catch:{  }
        r3 = 12;
        if (r2 != r3) goto L_0x003e;
    L_0x0032:
        r2 = com.facebook.tigon.httpclientadapter.TigonHttpClientAdapterModule.f4962b;	 Catch:{  }
        if (r2 == 0) goto L_0x003b;
    L_0x0036:
        r2 = r4.f4974b;	 Catch:{  }
        java.lang.Integer.valueOf(r2);	 Catch:{  }
    L_0x003b:
        r2 = 3;
        r4.f4975d = r2;	 Catch:{  }
    L_0x003e:
        r2 = r4.f4975d;	 Catch:{ all -> 0x0049 }
        switch(r2) {
            case 0: goto L_0x0051;
            case 1: goto L_0x0043;
            case 2: goto L_0x0059;
            case 3: goto L_0x0059;
            default: goto L_0x0043;
        };	 Catch:{ all -> 0x0049 }
    L_0x0043:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0049 }
        r0.<init>();	 Catch:{ all -> 0x0049 }
        throw r0;	 Catch:{ all -> 0x0049 }
    L_0x0049:
        r0 = move-exception;
        r4.m6256p();	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x004e:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
    L_0x0051:
        r0 = 1;
        r4.f4975d = r0;	 Catch:{  }
        r4.m6256p();	 Catch:{  }
        r0 = r1;
        goto L_0x0023;
    L_0x0059:
        r4.m6256p();	 Catch:{  }
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.tigon.httpclientadapter.TigonRequestState.a(int, int):boolean");
    }

    final synchronized void m6262a(int i, Object obj, TigonHttpClientAdapterImpl tigonHttpClientAdapterImpl) {
        if (TigonHttpClientAdapterModule.f4962b) {
            Integer.valueOf(this.f4974b);
        }
        if (m6251b(i)) {
            this.f4984m.m6302h();
            m6250a(tigonHttpClientAdapterImpl, i, obj, null);
            m6256p();
        }
    }

    final synchronized void m6261a(int i, Exception exception, TigonHttpClientAdapterImpl tigonHttpClientAdapterImpl) {
        if (TigonHttpClientAdapterModule.f4962b) {
            Integer.valueOf(this.f4974b);
        }
        if (m6251b(i)) {
            this.f4984m.m6303i();
            m6250a(tigonHttpClientAdapterImpl, i, null, exception);
            m6256p();
        }
    }

    final synchronized void m6260a(int i) {
        if (m6251b(i)) {
            this.f4984m.m6308n();
        }
    }

    private void m6250a(TigonHttpClientAdapterImpl tigonHttpClientAdapterImpl, int i, @Nullable Object obj, @Nullable Exception exception) {
        if (TigonHttpClientAdapterModule.f4962b) {
            Integer.valueOf(this.f4974b);
            Byte.valueOf(this.f4976e);
        }
        if (m6251b(i)) {
            this.f4975d = exception != null ? (byte) 3 : (byte) 2;
            if (this.f4976e != (byte) 11 && this.f4976e != (byte) 12) {
                this.f4987p = obj;
                this.f4988q = exception;
            } else if (exception == null) {
                if (TigonHttpClientAdapterModule.f4962b) {
                    Integer.valueOf(this.f4974b);
                }
                m6247a(i, tigonHttpClientAdapterImpl, obj);
            } else {
                if (TigonHttpClientAdapterModule.f4962b) {
                    Integer.valueOf(this.f4974b);
                }
                m6248a(i, tigonHttpClientAdapterImpl, (Throwable) exception);
            }
        } else if (TigonHttpClientAdapterModule.f4962b) {
            Integer.valueOf(this.f4974b);
            Integer.valueOf(i);
            Integer.valueOf(this.f4978g);
        }
    }

    private void m6247a(int i, TigonHttpClientAdapterImpl tigonHttpClientAdapterImpl, @Nullable Object obj) {
        if (TigonHttpClientAdapterModule.f4962b) {
            Integer.valueOf(this.f4974b);
        }
        m6253m();
        FutureDetour.a(this.f4981j, obj, 504614008);
        if (m6251b(i)) {
            this.f4980i.m6214a(this.f4989r);
        }
        m6249a(tigonHttpClientAdapterImpl);
    }

    private void m6248a(int i, TigonHttpClientAdapterImpl tigonHttpClientAdapterImpl, Throwable th) {
        if (TigonHttpClientAdapterModule.f4962b) {
            Integer.valueOf(this.f4974b);
        }
        m6253m();
        this.f4981j.a(th);
        if (m6251b(i)) {
            IOException iOException;
            if (th instanceof IOException) {
                iOException = (IOException) th;
            } else {
                th = new IOException(th);
            }
            this.f4980i.m6215a(this.f4989r, iOException);
        }
        m6249a(tigonHttpClientAdapterImpl);
    }

    private void m6249a(TigonHttpClientAdapterImpl tigonHttpClientAdapterImpl) {
        Preconditions.checkState(this.f4981j.isDone());
        int i = this.f4974b;
        TigonHttpClientAdapterImpl.m6236a(i, "cleanup");
        tigonHttpClientAdapterImpl.f4956d.m6285c(i);
        if (!this.f4984m.m6295a()) {
            m6268a("Not completed successfully", 3);
        }
    }

    private void m6253m() {
        Object obj;
        TigonRequestStatsSummaryInfoImpl tigonRequestStatsSummaryInfoImpl = this.f4989r == null ? null : (TigonRequestStatsSummaryInfoImpl) this.f4989r.m6345a(TigonSummaryLayers.f5063a);
        Map hashMap = new HashMap();
        String str = "tigon_redirects";
        if (tigonRequestStatsSummaryInfoImpl == null) {
            obj = "0";
        } else {
            obj = String.valueOf(tigonRequestStatsSummaryInfoImpl.f5051i);
        }
        hashMap.put(str, obj);
        hashMap.put("tigon_handlers", String.valueOf(this.f4990s));
        hashMap.put("tigon_request_states", String.valueOf(this.f4986o));
        this.f4983l.k = hashMap;
    }

    public final Object m6257a(HttpResponse httpResponse) {
        if (TigonHttpClientAdapterModule.f4962b) {
            Integer.valueOf(this.f4974b);
        }
        Preconditions.checkState(m6271b());
        return this.f4979h.handleResponse(httpResponse);
    }

    private boolean m6254n() {
        switch (this.f4984m.m6297c()) {
            case (byte) 0:
                if (this.f4975d == (byte) 0) {
                    return true;
                }
                return false;
            case (byte) 1:
                if (this.f4975d != (byte) 1) {
                    return false;
                }
                return true;
            case (byte) 2:
                if (this.f4975d != (byte) 2) {
                    return false;
                }
                return true;
            case (byte) 3:
                if (this.f4975d != (byte) 3) {
                    return false;
                }
                return true;
            case (byte) 4:
                if (this.f4975d == (byte) 0 || this.f4975d == (byte) 2 || this.f4975d == (byte) 3) {
                    return true;
                }
                return false;
            case (byte) 5:
                return false;
            default:
                throw new AssertionError();
        }
    }

    private boolean m6255o() {
        switch (this.f4984m.m6299e()) {
            case (byte) 0:
                if (this.f4976e == (byte) 10) {
                    return true;
                }
                return false;
            case (byte) 1:
                if (this.f4976e != (byte) 11) {
                    return false;
                }
                return true;
            case (byte) 2:
                if (this.f4976e != (byte) 12) {
                    return false;
                }
                return true;
            case (byte) 3:
                if (this.f4976e == (byte) 11 || this.f4976e == (byte) 12) {
                    return true;
                }
                return false;
            case (byte) 4:
                return false;
            default:
                throw new AssertionError();
        }
    }

    private void m6256p() {
        if (this.f4977f == 0 && !m6254n()) {
            m6268a(StringFormatUtil.formatStrLocaleSafe("Handler state mismatch (%d, %s)", Byte.valueOf(this.f4975d), this.f4984m.m6298d()), 1);
        }
        if (this.f4977f == 0 && !m6255o()) {
            m6268a(StringFormatUtil.formatStrLocaleSafe("Request state mismatch (%d,%s)", Byte.valueOf(this.f4976e), this.f4984m.m6300f()), 1);
        }
    }

    public final void m6259a(byte b, byte b2, byte b3, byte b4) {
        if (b != b3 && b3 == (byte) 5) {
            m6268a("Handler fail state", 1);
        }
        if (b2 != b4 && b4 == (byte) 4) {
            m6268a("Request fail state", 1);
        }
    }

    public final void m6268a(String str, int i) {
        if (this.f4977f < i) {
            StringBuilder append = new StringBuilder().append(str).append(" seq=").append(this.f4974b).append(" name=").append(this.f4973a).append(" handler=").append(this.f4979h.getClass().getSimpleName()).append(" buffer=(");
            TigonBodyBuffer tigonBodyBuffer = this.f4991t;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(' ').append(tigonBodyBuffer.f4926i ? "waiting" : "notWaiting");
            stringBuilder.append(' ').append(tigonBodyBuffer.f4923f ? "outputOpen" : "outputCLosed");
            stringBuilder.append(' ').append(tigonBodyBuffer.f4927j ? "clientOpen" : "clientClosed");
            String stringBuilder2 = append.append(stringBuilder.toString()).append(" ) state=").append(this.f4984m.m6312r()).toString();
            BLog.b("TigonHttpClientAdapter", stringBuilder2);
            if (f4972c != null) {
                f4972c.a("tigon", stringBuilder2);
            }
            if (this.f4985n) {
                throw new IllegalStateException(stringBuilder2);
            }
            this.f4977f++;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("TigonRequestState{");
        stringBuffer.append("mHandlerState=").append(this.f4975d);
        stringBuffer.append(", mRequestState=").append(this.f4976e);
        stringBuffer.append(", mReportedCount=").append(this.f4977f);
        stringBuffer.append(", mTicket=").append(this.f4978g);
        stringBuffer.append(", mName='").append(this.f4973a).append('\'');
        stringBuffer.append(", mSequence=").append(this.f4974b);
        stringBuffer.append(", mResponseHandler=").append(this.f4979h);
        stringBuffer.append(", mFuture=").append(this.f4981j);
        stringBuffer.append(", mThrowOnStateFailures=").append(this.f4985n);
        stringBuffer.append(", mResult=").append(this.f4987p);
        stringBuffer.append(", mException=").append(this.f4988q);
        stringBuffer.append(", mTerminalSummary=").append(this.f4989r);
        stringBuffer.append(", mBodyBuffer=").append(this.f4991t);
        stringBuffer.append(", requestToken=").append(this.f4992u);
        stringBuffer.append(", name='").append(this.f4973a).append('\'');
        stringBuffer.append(", creationTimeNanos=").append(m6276g());
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
