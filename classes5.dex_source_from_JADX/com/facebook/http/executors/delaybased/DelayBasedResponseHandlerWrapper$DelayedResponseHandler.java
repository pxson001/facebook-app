package com.facebook.http.executors.delaybased;

import java.net.SocketTimeoutException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

/* compiled from: disabled */
public class DelayBasedResponseHandlerWrapper$DelayedResponseHandler<T> implements ResponseHandler<T> {
    private final ResponseHandler<? extends T> f5048a;
    private final String f5049b;
    private final int f5050c;
    private final boolean f5051d;

    public DelayBasedResponseHandlerWrapper$DelayedResponseHandler(ResponseHandler<? extends T> responseHandler, String str, int i, boolean z) {
        this.f5048a = responseHandler;
        this.f5049b = str;
        this.f5050c = i;
        this.f5051d = z;
    }

    public T handleResponse(HttpResponse httpResponse) {
        try {
            Integer.valueOf(this.f5050c);
            Boolean.valueOf(this.f5051d);
            Thread.sleep((long) this.f5050c);
        } catch (InterruptedException e) {
        }
        if (!this.f5051d) {
            return this.f5048a.handleResponse(httpResponse);
        }
        throw new SocketTimeoutException();
    }
}
