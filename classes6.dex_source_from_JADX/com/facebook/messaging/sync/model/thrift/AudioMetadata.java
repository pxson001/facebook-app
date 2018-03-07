package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: unable to get EGL14 display */
public class AudioMetadata implements TBase, Serializable, Cloneable {
    public static boolean f2485a = true;
    private static final TStruct f2486b = new TStruct("AudioMetadata");
    private static final TField f2487c = new TField("isVoicemail", (byte) 2, (short) 1);
    public final Boolean isVoicemail;

    private AudioMetadata(Boolean bool) {
        this.isVoicemail = bool;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AudioMetadata)) {
            return m3683a((AudioMetadata) obj);
        }
        return false;
    }

    public final boolean m3683a(AudioMetadata audioMetadata) {
        if (audioMetadata == null) {
            return false;
        }
        boolean z = this.isVoicemail != null;
        boolean z2;
        if (audioMetadata.isVoicemail != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((z || r3) && (!z || !r3 || !this.isVoicemail.equals(audioMetadata.isVoicemail))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public static AudioMetadata m3680b(TProtocol tProtocol) {
        Boolean bool = null;
        tProtocol.r();
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 2) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        bool = Boolean.valueOf(tProtocol.j());
                        break;
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new AudioMetadata(bool);
        }
    }

    public final void m3682a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.isVoicemail == null || this.isVoicemail == null)) {
            tProtocol.a(f2487c);
            tProtocol.a(this.isVoicemail.booleanValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3681a(1, f2485a);
    }

    public final String m3681a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("AudioMetadata");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        if (this.isVoicemail != null) {
            stringBuilder.append(a);
            stringBuilder.append("isVoicemail");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.isVoicemail == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.isVoicemail, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
