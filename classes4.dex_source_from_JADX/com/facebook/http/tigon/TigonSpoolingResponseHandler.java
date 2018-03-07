package com.facebook.http.tigon;

import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

/* compiled from: push_missing_payload */
public class TigonSpoolingResponseHandler implements ResponseHandler<TigonResult> {
    private static final String f4037a = TigonSpoolingResponseHandler.class.getSimpleName();
    public final Tigon4aRequestToken f4038b;
    public boolean f4039c = false;

    public TigonSpoolingResponseHandler(Tigon4aRequestToken tigon4aRequestToken) {
        this.f4038b = tigon4aRequestToken;
    }

    public Object handleResponse(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        this.f4038b.onResponse(statusCode, m4534a(httpResponse.getAllHeaders()));
        int i = 0;
        InputStream content = httpResponse.getEntity().getContent();
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = content.read(bArr);
                if (read != -1) {
                    i += read;
                    this.f4038b.onBody(bArr, read);
                } else {
                    this.f4038b.onEOM();
                    content.close();
                    return new TigonResult(statusCode, i);
                }
            }
        } catch (Throwable e) {
            if (this.f4039c) {
                this.f4038b.m9886b(e);
            }
            throw e;
        } catch (Throwable th) {
            content.close();
        }
    }

    private static String[] m4534a(Header[] headerArr) {
        int i = 0;
        String[] strArr = new String[(headerArr.length * 2)];
        for (int i2 = 0; i2 < headerArr.length; i2++) {
            int i3 = i + 1;
            strArr[i] = headerArr[i2].getName();
            i = i3 + 1;
            strArr[i3] = headerArr[i2].getValue();
        }
        return strArr;
    }
}
