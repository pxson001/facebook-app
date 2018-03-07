package com.facebook.thrift.transport;

import com.facebook.thrift.TException;

/* compiled from: selected_position */
public class TTransportException extends TException {
    protected int type_ = 0;

    public TTransportException(int i) {
        this.type_ = i;
    }

    public TTransportException(int i, String str) {
        super(str);
        this.type_ = i;
    }

    public TTransportException(String str) {
        super(str);
    }

    public TTransportException(int i, Throwable th) {
        super(th);
        this.type_ = i;
    }
}
