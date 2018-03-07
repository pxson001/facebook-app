package com.facebook.thrift;

import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;

/* compiled from: transfer_progress */
public abstract class TUnion implements TBase {
    public int setField_ = 0;
    public Object value_ = null;

    protected abstract TField mo154a(int i);

    protected abstract Object mo155a(TProtocol tProtocol, TField tField);

    protected abstract void mo156a(TProtocol tProtocol, short s);

    protected TUnion() {
    }

    public final int m3825a() {
        return this.setField_;
    }

    public final void m3828a(TProtocol tProtocol) {
        if (this.setField_ == 0 || this.value_ == null) {
            throw new TProtocolException("Cannot write a TUnion with no set value!");
        }
        tProtocol.a();
        tProtocol.a(mo154a(this.setField_));
        mo156a(tProtocol, (short) this.setField_);
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        String stringBuilder;
        Object obj = this.value_;
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            StringBuilder stringBuilder2 = new StringBuilder();
            int min = Math.min(bArr.length, 128);
            for (int i = 0; i < min; i++) {
                if (i != 0) {
                    stringBuilder2.append(" ");
                }
                String toHexString = Integer.toHexString(bArr[i]);
                if (toHexString.length() <= 1) {
                    toHexString = "0" + toHexString;
                }
                stringBuilder2.append(toHexString);
            }
            if (bArr.length > 128) {
                stringBuilder2.append(" ...");
            }
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = obj.toString();
        }
        return "<" + getClass().getSimpleName() + " " + mo154a(this.setField_).a + ":" + stringBuilder + ">";
    }
}
