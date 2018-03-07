package com.facebook.browser.prefetch;

import com.google.common.base.Strings;
import java.io.InputStream;
import javax.annotation.Nullable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;

/* compiled from: privacy_scope_edit */
class BrowserPrefetcher$PrefetchHttpResponseHandler implements ResponseHandler<String> {
    final /* synthetic */ BrowserPrefetcher f7431a;
    private final String f7432b;
    private final String f7433c;
    private final boolean f7434d;

    @Nullable
    public Object handleResponse(HttpResponse httpResponse) {
        InputStream inputStream;
        Throwable th;
        StatusLine statusLine = httpResponse.getStatusLine();
        if (statusLine == null) {
            throw new ClientProtocolException("Invalid HttpResponse");
        }
        if (!this.f7434d) {
            Header[] headers = httpResponse.getHeaders("Set-Cookie");
            if (headers != null) {
                for (Header value : headers) {
                    this.f7431a.q.setCookie(this.f7433c, value.getValue());
                }
            }
        }
        int statusCode = statusLine.getStatusCode();
        if (statusCode == 302 || statusCode == 301 || statusCode == 303 || statusCode == 300 || statusCode == 307) {
            Header firstHeader = httpResponse.getFirstHeader("Location");
            if (firstHeader != null) {
                String value2 = firstHeader.getValue();
                if (!Strings.isNullOrEmpty(value2)) {
                    return value2.replace(" ", "%20").replace("|", "%7C");
                }
            }
            throw new ClientProtocolException("Redirect without location");
        } else if (statusCode != 200) {
            BrowserPrefetcher.k();
            Integer.valueOf(statusCode);
            statusLine.getReasonPhrase();
            throw new HttpResponseException(statusCode, statusLine.getReasonPhrase());
        } else {
            HttpEntity entity = httpResponse.getEntity();
            if (entity == null) {
                throw new ClientProtocolException("Missing HTTP entity");
            }
            try {
                if (this.f7434d) {
                    BrowserPrefetcher.k();
                    inputStream = null;
                } else {
                    inputStream = entity.getContent();
                    try {
                        Header contentType = entity.getContentType();
                        this.f7431a.d.a(this.f7432b, this.f7433c, inputStream, contentType == null ? null : contentType.getValue());
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th;
                    }
                }
                if (inputStream == null) {
                    return null;
                }
                inputStream.close();
                return null;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                inputStream = null;
                th = th4;
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        }
    }

    public BrowserPrefetcher$PrefetchHttpResponseHandler(BrowserPrefetcher browserPrefetcher, String str, String str2, boolean z) {
        this.f7431a = browserPrefetcher;
        this.f7432b = str;
        this.f7433c = str2;
        this.f7434d = z;
    }
}
