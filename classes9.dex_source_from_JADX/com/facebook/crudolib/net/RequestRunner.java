package com.facebook.crudolib.net;

import android.util.Log;
import com.facebook.crudolib.netengine.HttpHeaders;
import com.facebook.crudolib.netengine.fbhttp.FbHttpEngineRequest;
import com.facebook.crudolib.netengine.fbhttp.FbHttpEngineResponse;
import com.facebook.debug.log.BLog;
import com.facebook.saved2.bus.Saved2EventBus;
import com.facebook.saved2.bus.Saved2EventBus.FetchFailedData;
import com.facebook.saved2.network.Saved2DataFetcher.FetchFreshSavedItemsCallback;
import java.io.IOException;

/* compiled from: TincanSendReadReceipt */
public class RequestRunner {
    public final CrudoNet f24049a;

    /* compiled from: TincanSendReadReceipt */
    public class InternalRequestRunnable implements Runnable {
        protected final AppRequest f24047a;
        final /* synthetic */ RequestRunner f24048b;

        public InternalRequestRunnable(RequestRunner requestRunner, AppRequest appRequest) {
            this.f24048b = requestRunner;
            this.f24047a = appRequest;
        }

        public void run() {
            Thread currentThread = Thread.currentThread();
            String name = currentThread.getName();
            currentThread.setName("RequestRunner " + this.f24047a.m25954a());
            try {
                m25977a();
            } finally {
                currentThread.setName(name);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m25977a() {
            /*
            r2 = this;
            r0 = r2.m25981c();	 Catch:{ IOException -> 0x001f }
            r1 = r2.m25980b();	 Catch:{ IOException -> 0x001f }
            if (r1 != 0) goto L_0x0019;
        L_0x000a:
            r1 = r2.f24048b;	 Catch:{ IOException -> 0x001f }
            r1 = r1.f24049a;	 Catch:{ IOException -> 0x001f }
            r1 = r1.m25970a();	 Catch:{ IOException -> 0x001f }
            r0 = r1.m25997a(r0);	 Catch:{ IOException -> 0x001f }
            r2.m25978a(r0);	 Catch:{ IOException -> 0x001f }
        L_0x0019:
            r0 = r2.f24047a;
            r0.m25959k();
        L_0x001e:
            return;
        L_0x001f:
            r0 = move-exception;
            r2.m25979a(r0);	 Catch:{ all -> 0x0029 }
            r0 = r2.f24047a;
            r0.m25959k();
            goto L_0x001e;
        L_0x0029:
            r0 = move-exception;
            r1 = r2.f24047a;
            r1.m25959k();
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.crudolib.net.RequestRunner.InternalRequestRunnable.a():void");
        }

        private boolean m25980b() {
            return this.f24047a.f24016e.f24021a;
        }

        private FbHttpEngineRequest m25981c() {
            for (ChainableRequestMutator chainableRequestMutator = this.f24047a.f24015d; chainableRequestMutator != null; chainableRequestMutator = chainableRequestMutator.mo1106b()) {
                chainableRequestMutator.mo1105a().mo1108a(this.f24047a.m25955d());
            }
            this.f24047a.m25957g();
            HttpHeaders f = this.f24047a.m25956f();
            if (RequestRunner.m25982a(this.f24048b)) {
                Log.d("RequestRunner", "Enqueued request for " + this.f24047a.f24012a + ":\n" + f.f24061a.getMethod() + " " + f.f24061a.getURI().toString() + "\n" + m25976a(f));
            }
            this.f24047a.m25958j();
            return f;
        }

        private static String m25976a(HttpHeaders httpHeaders) {
            StringBuilder stringBuilder = new StringBuilder();
            int d = httpHeaders.mo1117d();
            for (int i = 0; i < d; i++) {
                stringBuilder.append(httpHeaders.mo1115a(i));
                stringBuilder.append(": ");
                stringBuilder.append(httpHeaders.mo1116b(i));
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        }

        private void m25979a(IOException iOException) {
            if (RequestRunner.m25982a(this.f24048b)) {
                Log.d("RequestRunner", this.f24047a.f24012a + " error: " + iOException);
            }
            if (!this.f24047a.f24016e.f24021a) {
                FetchFreshSavedItemsCallback fetchFreshSavedItemsCallback = this.f24047a.f24017f;
                if (BLog.b(3)) {
                    iOException.toString();
                }
                Saved2EventBus.a.b(new FetchFailedData(fetchFreshSavedItemsCallback.b));
            } else if (RequestRunner.m25982a(this.f24048b)) {
                Log.d("RequestRunner", this.f24047a.f24012a + " error dropped due to caller cancelation");
            }
        }

        private void m25978a(FbHttpEngineResponse fbHttpEngineResponse) {
            Object obj;
            if (RequestRunner.m25982a(this.f24048b)) {
                Log.d("RequestRunner", "Response for " + this.f24047a.f24012a + ":\n" + fbHttpEngineResponse.m26017a() + " " + fbHttpEngineResponse.m26018b() + "\n" + m25976a((HttpHeaders) fbHttpEngineResponse));
            }
            CancelTrigger cancelTrigger = this.f24047a.f24016e;
            if (this.f24047a.f24014c != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                this.f24047a.f24014c.mo1107a(this.f24047a, fbHttpEngineResponse);
            }
            if (!cancelTrigger.f24021a) {
                this.f24047a.f24017f.a(fbHttpEngineResponse);
            } else if (RequestRunner.m25982a(this.f24048b)) {
                Log.d("RequestRunner", this.f24047a.f24012a + " response dropped due to caller cancelation");
            }
        }
    }

    public RequestRunner(CrudoNet crudoNet) {
        this.f24049a = crudoNet;
    }

    public static boolean m25982a(RequestRunner requestRunner) {
        return requestRunner.f24049a.f24031c;
    }
}
