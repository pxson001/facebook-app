package com.facebook.thrift.protocol;

import com.facebook.thrift.TException;

/* compiled from: selected_result_display_text */
public class TProtocolException extends TException {
    protected int type_ = 0;

    public TProtocolException(int i, String str) {
        super(str);
        this.type_ = i;
    }

    public TProtocolException(String str) {
        super(str);
    }
}
