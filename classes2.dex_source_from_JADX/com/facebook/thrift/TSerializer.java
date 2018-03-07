package com.facebook.thrift;

import com.facebook.thrift.protocol.TBinaryProtocol.Factory;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolFactory;
import com.facebook.thrift.transport.TIOStreamTransport;
import java.io.ByteArrayOutputStream;

/* compiled from: fm.last.android.metachanged */
public class TSerializer {
    private final ByteArrayOutputStream f23580a;
    private final TIOStreamTransport f23581b;
    private TProtocol f23582c;

    public TSerializer() {
        this(new Factory());
    }

    public TSerializer(TProtocolFactory tProtocolFactory) {
        this.f23580a = new ByteArrayOutputStream();
        this.f23581b = new TIOStreamTransport(this.f23580a);
        this.f23582c = tProtocolFactory.mo3465a(this.f23581b);
    }

    public final byte[] m31914a(TBase tBase) {
        this.f23580a.reset();
        tBase.mo3464a(this.f23582c);
        return this.f23580a.toByteArray();
    }
}
