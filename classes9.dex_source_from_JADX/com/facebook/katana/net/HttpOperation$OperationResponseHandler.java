package com.facebook.katana.net;

import android.os.SystemClock;
import com.google.common.io.Closeables;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

/* compiled from: p2p_payment */
class HttpOperation$OperationResponseHandler implements ResponseHandler<Void> {
    final /* synthetic */ HttpOperation f7562a;

    public HttpOperation$OperationResponseHandler(HttpOperation httpOperation) {
        this.f7562a = httpOperation;
    }

    public Object handleResponse(HttpResponse httpResponse) {
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2 = null;
        try {
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            String reasonPhrase = httpResponse.getStatusLine().getReasonPhrase();
            HttpEntity entity = httpResponse.getEntity();
            if (statusCode != 200 || entity == null) {
                inputStream = null;
            } else {
                String value;
                if (entity.getContentEncoding() != null) {
                    entity.getContentEncoding().getValue();
                }
                if (entity.getContentType() != null) {
                    value = entity.getContentType().getValue();
                } else {
                    value = null;
                }
                inputStream = new HttpOperation$ResponseInputStream(entity.getContent(), value);
            }
            try {
                HttpOperation.a(this.f7562a, SystemClock.uptimeMillis());
                if (this.f7562a.i != null) {
                    this.f7562a.i.a(statusCode, reasonPhrase, inputStream, null);
                }
                Closeables.a(inputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                Closeables.a(inputStream2);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            Closeables.a(inputStream2);
            throw th;
        }
    }
}
