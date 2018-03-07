package com.facebook.http.common.executorimpl.apache;

import com.google.common.base.Preconditions;
import java.net.URI;
import javax.annotation.Nullable;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.methods.AbortableHttpRequest;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionReleaseTrigger;
import org.apache.http.impl.client.EntityEnclosingRequestWrapper;

/* compiled from: num_days_until_show_clipboard_prompt_again */
public class AbortForwardingEntityEnclosingRequestWrapper extends EntityEnclosingRequestWrapper implements AbortableHttpRequest {
    private final AbortableHttpRequest f11984a;
    @Nullable
    private RequestLine f11985b;

    public AbortForwardingEntityEnclosingRequestWrapper(AbortableHttpRequest abortableHttpRequest, HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        super(httpEntityEnclosingRequest);
        this.f11984a = (AbortableHttpRequest) Preconditions.checkNotNull(abortableHttpRequest);
    }

    public void setConnectionRequest(ClientConnectionRequest clientConnectionRequest) {
        this.f11984a.setConnectionRequest(clientConnectionRequest);
    }

    public void setReleaseTrigger(ConnectionReleaseTrigger connectionReleaseTrigger) {
        this.f11984a.setReleaseTrigger(connectionReleaseTrigger);
    }

    public void setMethod(String str) {
        this.f11985b = null;
        super.setMethod(str);
    }

    public void setURI(URI uri) {
        this.f11985b = null;
        super.setURI(uri);
    }

    public void setProtocolVersion(ProtocolVersion protocolVersion) {
        this.f11985b = null;
        super.setProtocolVersion(protocolVersion);
    }

    public RequestLine getRequestLine() {
        RequestLine requestLine = this.f11985b;
        if (requestLine != null) {
            return requestLine;
        }
        this.f11985b = super.getRequestLine();
        return this.f11985b;
    }
}
