package com.facebook.thrift.protocol;

import com.facebook.thrift.TException;
import com.facebook.thrift.transport.TTransport;
import java.util.Collections;

/* compiled from: flow_control_recv_to_ack */
public abstract class TProtocol {
    protected TTransport f23597e;

    public abstract void mo3468a();

    public abstract void mo3469a(byte b);

    public abstract void mo3470a(int i);

    public abstract void mo3471a(long j);

    public abstract void mo3472a(TField tField);

    public abstract void mo3473a(TList tList);

    public abstract void mo3474a(TMap tMap);

    public abstract void mo3475a(String str);

    public abstract void mo3476a(short s);

    public abstract void mo3477a(boolean z);

    public abstract void mo3478a(byte[] bArr);

    public abstract void mo3479b();

    public abstract void mo3480c();

    public abstract TStruct mo3481d();

    public abstract void mo3482e();

    public abstract TField mo3483f();

    public abstract TMap mo3484g();

    public abstract TList mo3485h();

    public abstract TSet mo3486i();

    public abstract boolean mo3487j();

    public abstract byte mo3488k();

    public abstract short mo3489l();

    public abstract int mo3490m();

    public abstract long mo3491n();

    public abstract double mo3492o();

    public abstract String mo3493p();

    public abstract byte[] mo3494q();

    private TProtocol() {
    }

    protected TProtocol(TTransport tTransport) {
        this.f23597e = tTransport;
    }

    public final TStruct m31998r() {
        Collections.emptyMap();
        return mo3481d();
    }

    public static boolean m31968s() {
        throw new TException("Peeking into a map not supported, likely because it's sized");
    }

    public static boolean m31969t() {
        throw new TException("Peeking into a list not supported, likely because it's sized");
    }

    public static boolean m31970u() {
        throw new TException("Peeking into a set not supported, likely because it's sized");
    }
}
