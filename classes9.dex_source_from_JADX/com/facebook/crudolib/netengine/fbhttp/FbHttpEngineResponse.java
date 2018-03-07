package com.facebook.crudolib.netengine.fbhttp;

import com.facebook.crudolib.netengine.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

/* compiled from: TincanAutoAcceptPendingSession */
public class FbHttpEngineResponse extends FbHttpHeaders implements HttpHeaders {
    public final RequestSynchronizationBarrier f24070a = new RequestSynchronizationBarrier();
    public volatile HttpResponse f24071b;

    /* compiled from: TincanAutoAcceptPendingSession */
    abstract class ProxyInputStreamCallback {
        final /* synthetic */ FbHttpEngineResponse f24066b;

        public abstract void mo1118a();

        public abstract void mo1119a(IOException iOException);

        public abstract void mo1120b();

        public ProxyInputStreamCallback(FbHttpEngineResponse fbHttpEngineResponse) {
            this.f24066b = fbHttpEngineResponse;
        }
    }

    /* compiled from: TincanAutoAcceptPendingSession */
    class C29111 extends ProxyInputStreamCallback {
        final /* synthetic */ FbHttpEngineResponse f24067a;

        C29111(FbHttpEngineResponse fbHttpEngineResponse) {
            this.f24067a = fbHttpEngineResponse;
            super(fbHttpEngineResponse);
        }

        public final void mo1119a(IOException iOException) {
            this.f24067a.f24070a.m26022a(iOException);
        }

        public final void mo1118a() {
            this.f24067a.f24070a.m26022a(null);
        }

        public final void mo1120b() {
            this.f24067a.f24070a.m26022a(null);
        }
    }

    /* compiled from: TincanAutoAcceptPendingSession */
    class ProxyInputStream extends InputStream {
        private final InputStream f24068a;
        private final ProxyInputStreamCallback f24069b;

        public ProxyInputStream(InputStream inputStream, ProxyInputStreamCallback proxyInputStreamCallback) {
            this.f24068a = inputStream;
            this.f24069b = proxyInputStreamCallback;
        }

        public int available() {
            return this.f24068a.available();
        }

        public void close() {
            try {
                this.f24068a.close();
            } finally {
                this.f24069b.mo1118a();
            }
        }

        public boolean markSupported() {
            return false;
        }

        public void mark(int i) {
            throw new IllegalStateException();
        }

        public synchronized void reset() {
            throw new IllegalStateException();
        }

        public int read() {
            try {
                return m26015a(this.f24068a.read());
            } catch (IOException e) {
                throw m26016a(e);
            }
        }

        public int read(byte[] bArr) {
            try {
                return m26015a(this.f24068a.read(bArr));
            } catch (IOException e) {
                throw m26016a(e);
            }
        }

        public int read(byte[] bArr, int i, int i2) {
            try {
                return m26015a(this.f24068a.read(bArr, i, i2));
            } catch (IOException e) {
                throw m26016a(e);
            }
        }

        private int m26015a(int i) {
            if (i == -1) {
                this.f24069b.mo1120b();
            }
            return i;
        }

        private IOException m26016a(IOException iOException) {
            this.f24069b.mo1119a(iOException);
            throw iOException;
        }
    }

    public final int m26017a() {
        return this.f24071b.getStatusLine().getStatusCode();
    }

    public final String m26018b() {
        return this.f24071b.getStatusLine().getReasonPhrase();
    }

    public final InputStream m26019c() {
        HttpEntity entity = this.f24071b.getEntity();
        if (entity != null) {
            return new ProxyInputStream(entity.getContent(), new C29111(this));
        }
        throw new EOFException("No body, the caller should consult response code!");
    }
}
