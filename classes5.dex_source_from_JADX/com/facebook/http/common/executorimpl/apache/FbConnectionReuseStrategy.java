package com.facebook.http.common.executorimpl.apache;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpConnection;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.TokenIterator;
import org.apache.http.message.BasicTokenIterator;
import org.apache.http.protocol.HttpContext;

/* compiled from: distance */
public class FbConnectionReuseStrategy implements ConnectionReuseStrategy {
    public boolean keepAlive(HttpResponse httpResponse, HttpContext httpContext) {
        if (httpResponse == null) {
            throw new IllegalArgumentException("HTTP response may not be null.");
        } else if (httpContext == null) {
            throw new IllegalArgumentException("HTTP context may not be null.");
        } else {
            HttpConnection httpConnection = (HttpConnection) httpContext.getAttribute("http.connection");
            if (httpConnection != null && !httpConnection.isOpen()) {
                return false;
            }
            ProtocolVersion protocolVersion = httpResponse.getStatusLine().getProtocolVersion();
            Header firstHeader = httpResponse.getFirstHeader("Transfer-Encoding");
            if (firstHeader != null) {
                if (!"chunked".equalsIgnoreCase(firstHeader.getValue())) {
                    return false;
                }
            } else if (m9909a(httpResponse)) {
                Header[] headers = httpResponse.getHeaders("Content-Length");
                if (headers.length != 1) {
                    return false;
                }
                try {
                    if (Integer.parseInt(headers[0].getValue()) < 0) {
                        return false;
                    }
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            HeaderIterator headerIterator = httpResponse.headerIterator("Connection");
            if (!headerIterator.hasNext()) {
                headerIterator = httpResponse.headerIterator("Proxy-Connection");
            }
            if (headerIterator.hasNext()) {
                try {
                    TokenIterator a = m9908a(headerIterator);
                    int i = 0;
                    while (a.hasNext()) {
                        String nextToken = a.nextToken();
                        if ("Close".equalsIgnoreCase(nextToken)) {
                            return false;
                        }
                        if ("Keep-Alive".equalsIgnoreCase(nextToken)) {
                            i = true;
                        }
                    }
                    if (i != 0) {
                        return true;
                    }
                } catch (ParseException e2) {
                    return false;
                }
            }
            if (protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
                return false;
            }
            return true;
        }
    }

    private static TokenIterator m9908a(HeaderIterator headerIterator) {
        return new BasicTokenIterator(headerIterator);
    }

    private static boolean m9909a(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        return (statusCode < 200 || statusCode == 204 || statusCode == 304 || statusCode == 205) ? false : true;
    }
}
