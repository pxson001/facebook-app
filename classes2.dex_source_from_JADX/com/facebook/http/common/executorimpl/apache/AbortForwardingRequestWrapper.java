package com.facebook.http.common.executorimpl.apache;

import com.google.common.base.Preconditions;
import java.net.URI;
import javax.annotation.Nullable;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.methods.AbortableHttpRequest;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionReleaseTrigger;
import org.apache.http.impl.client.RequestWrapper;

/* compiled from: maximum_backoff_seconds */
public class AbortForwardingRequestWrapper extends RequestWrapper implements AbortableHttpRequest {
    private final AbortableHttpRequest f14753a;
    @Nullable
    private RequestLine f14754b;

    public AbortForwardingRequestWrapper(AbortableHttpRequest abortableHttpRequest, HttpUriRequest httpUriRequest) {
        super(httpUriRequest);
        this.f14753a = (AbortableHttpRequest) Preconditions.checkNotNull(abortableHttpRequest);
    }

    public void setConnectionRequest(ClientConnectionRequest clientConnectionRequest) {
        this.f14753a.setConnectionRequest(clientConnectionRequest);
    }

    public void setReleaseTrigger(ConnectionReleaseTrigger connectionReleaseTrigger) {
        this.f14753a.setReleaseTrigger(connectionReleaseTrigger);
    }

    public void setMethod(String str) {
        this.f14754b = null;
        super.setMethod(str);
    }

    public void setURI(URI uri) {
        this.f14754b = null;
        super.setURI(uri);
    }

    public void setProtocolVersion(ProtocolVersion protocolVersion) {
        this.f14754b = null;
        super.setProtocolVersion(protocolVersion);
    }

    public RequestLine getRequestLine() {
        RequestLine requestLine = this.f14754b;
        if (requestLine != null) {
            return requestLine;
        }
        this.f14754b = super.getRequestLine();
        return this.f14754b;
    }
}
