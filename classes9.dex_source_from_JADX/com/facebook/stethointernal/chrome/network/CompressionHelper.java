package com.facebook.stethointernal.chrome.network;

import com.facebook.http.entity.mime.UnwrappableHttpEntityWrapper;
import com.facebook.stethointernal.chrome.network.GunzippingOutputStream.GunzippingCallable;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

/* compiled from: android_plutonium_expando */
public class CompressionHelper {

    /* compiled from: android_plutonium_expando */
    public final class C24061 extends HttpEntityWrapper {
        final /* synthetic */ HttpEntity f20408a;

        public C24061(HttpEntity httpEntity, HttpEntity httpEntity2) {
            this.f20408a = httpEntity2;
            super(httpEntity);
        }

        public final long getContentLength() {
            return -1;
        }

        public final Header getContentEncoding() {
            return null;
        }

        public final void writeTo(OutputStream outputStream) {
            HttpEntity httpEntity = this.f20408a;
            InputStream pipedInputStream = new PipedInputStream();
            httpEntity.writeTo(new GunzippingOutputStream(new PipedOutputStream(pipedInputStream), ExecutorDetour.a(GunzippingOutputStream.f20411b, new GunzippingCallable(pipedInputStream, outputStream), 143435303)));
        }
    }

    public static HttpEntity m19969a(HttpEntity httpEntity) {
        if (!m19970c(httpEntity)) {
            return httpEntity;
        }
        if (httpEntity instanceof UnwrappableHttpEntityWrapper) {
            return m19968a((UnwrappableHttpEntityWrapper) httpEntity);
        }
        return new C24061(httpEntity, httpEntity);
    }

    private static HttpEntity m19968a(UnwrappableHttpEntityWrapper unwrappableHttpEntityWrapper) {
        HttpEntity a = unwrappableHttpEntityWrapper.a();
        if (!m19970c(a)) {
            return a;
        }
        throw new CannotUndoCompressionException("Outermost entity is not responsible for compression");
    }

    private static boolean m19970c(HttpEntity httpEntity) {
        Header contentEncoding = httpEntity.getContentEncoding();
        return contentEncoding != null && "gzip".equalsIgnoreCase(contentEncoding.getValue());
    }
}
