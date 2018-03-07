package com.facebook.fbservice.ops;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.common.NetworkException;
import com.google.common.base.Throwables;
import java.io.IOException;
import java.net.SocketTimeoutException;
import javax.net.ssl.SSLException;

/* compiled from: method/auth.expireSession */
public abstract class ResultFutureCallback<T> extends AbstractDisposableFutureCallback<T> {
    protected abstract void mo148a(ServiceException serviceException);

    protected final void m8088a(Throwable th) {
        if (th instanceof ServiceException) {
            mo148a((ServiceException) th);
        } else if ((th instanceof SSLException) || (th instanceof SocketTimeoutException) || (th instanceof NetworkException) || (th instanceof IOException)) {
            mo148a(ServiceException.m10950a(th));
        } else {
            m8089b(th);
        }
    }

    protected void m8089b(Throwable th) {
        Throwables.propagate(th);
    }
}
