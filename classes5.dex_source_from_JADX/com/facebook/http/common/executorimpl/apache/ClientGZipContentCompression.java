package com.facebook.http.common.executorimpl.apache;

import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.protocol.HttpContext;

/* compiled from: doAfterTextChanged */
public class ClientGZipContentCompression {

    /* compiled from: doAfterTextChanged */
    class GzipDecompressingEntity extends HttpEntityWrapper {
        public GzipDecompressingEntity(HttpEntity httpEntity) {
            super(httpEntity);
        }

        public InputStream getContent() {
            return new GZIPInputStream(this.wrappedEntity.getContent());
        }

        public long getContentLength() {
            return -1;
        }
    }

    /* compiled from: doAfterTextChanged */
    public class MyHttpRequestInterceptor implements HttpRequestInterceptor {
        public void process(HttpRequest httpRequest, HttpContext httpContext) {
            if (!httpRequest.containsHeader("Accept-Encoding")) {
                httpRequest.addHeader("Accept-Encoding", "gzip");
            }
        }
    }

    /* compiled from: doAfterTextChanged */
    public class MyHttpResponseInterceptor implements HttpResponseInterceptor {
        public void process(HttpResponse httpResponse, HttpContext httpContext) {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                Header contentEncoding = entity.getContentEncoding();
                if (contentEncoding != null) {
                    HeaderElement[] elements = contentEncoding.getElements();
                    for (HeaderElement name : elements) {
                        if (name.getName().equalsIgnoreCase("gzip")) {
                            httpResponse.setEntity(new GzipDecompressingEntity(httpResponse.getEntity()));
                            return;
                        }
                    }
                }
            }
        }
    }
}
