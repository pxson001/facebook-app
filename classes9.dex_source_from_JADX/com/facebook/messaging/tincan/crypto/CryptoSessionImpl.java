package com.facebook.messaging.tincan.crypto;

import android.util.Base64;
import android.util.JsonReader;
import android.util.JsonWriter;
import com.facebook.debug.log.BLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.whispersystems.libsignal.IdentityKey;
import org.whispersystems.libsignal.IdentityKeyPair;
import org.whispersystems.libsignal.InvalidKeyIdException;
import org.whispersystems.libsignal.SignalProtocolAddress;
import org.whispersystems.libsignal.state.IdentityKeyStore;
import org.whispersystems.libsignal.state.PreKeyRecord;
import org.whispersystems.libsignal.state.PreKeyStore;
import org.whispersystems.libsignal.state.SessionRecord;
import org.whispersystems.libsignal.state.SignedPreKeyRecord;
import org.whispersystems.libsignal.state.SignedPreKeyStore;

/* compiled from: columnWidths */
public class CryptoSessionImpl extends CryptoSession implements IdentityKeyStore, PreKeyStore, SignedPreKeyStore {
    private static final Class<?> f17862a = CryptoSessionImpl.class;
    private final IdentityKeyStore f17863b;
    private String f17864c;
    public State f17865d;
    private int f17866e;
    public PreKeyRecord f17867f;
    private int f17868g;
    public SignedPreKeyRecord f17869h;
    private int f17870i;
    private SignalProtocolAddress f17871j;
    public byte[] f17872k;

    /* compiled from: columnWidths */
    public enum State {
        NEW(0),
        SENDER_ACCEPT_PENDING(1),
        RECEIVER_ACCEPT_PENDING(2),
        RUNNING(3),
        PRE_KEY_ERROR(4),
        ACCEPT_GEN_ERROR(5),
        ACCEPT_PROCESS_ERROR(6),
        DECRYPT_ERROR(7);
        
        private static final Map<Integer, State> sStateMap = null;
        private int mValue;

        static {
            sStateMap = new HashMap();
            State[] values = values();
            int length = values.length;
            int i;
            while (i < length) {
                State state = values[i];
                sStateMap.put(Integer.valueOf(state.getValue()), state);
                i++;
            }
        }

        private State(int i) {
            this.mValue = i;
        }

        public final int getValue() {
            return this.mValue;
        }

        public static State from(int i) {
            return (State) sStateMap.get(Integer.valueOf(i));
        }
    }

    public CryptoSessionImpl(String str, IdentityKeyStore identityKeyStore) {
        this.f17864c = str;
        this.f17863b = identityKeyStore;
        this.f17865d = State.NEW;
        this.f17866e = 0;
    }

    public CryptoSessionImpl(JsonReader jsonReader, IdentityKeyStore identityKeyStore) {
        this.f17863b = identityKeyStore;
        String str = null;
        int i = 0;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("state")) {
                this.f17865d = State.from(jsonReader.nextInt());
            } else if (nextName.equals("counter")) {
                this.f17866e = jsonReader.nextInt();
            } else if (nextName.equals("id")) {
                this.f17864c = jsonReader.nextString();
            } else if (nextName.equals("pre_key_id")) {
                this.f17868g = jsonReader.nextInt();
            } else if (nextName.equals("pre_key_record")) {
                this.f17867f = new PreKeyRecord(m17872a(jsonReader));
            } else if (nextName.equals("signed_pre_key_id")) {
                this.f17870i = jsonReader.nextInt();
            } else if (nextName.equals("signed_pre_key_record")) {
                this.f17869h = new SignedPreKeyRecord(m17872a(jsonReader));
            } else if (nextName.equals("session_address_name")) {
                str = jsonReader.nextString();
            } else if (nextName.equals("session_address_device")) {
                i = jsonReader.nextInt();
            } else if (nextName.equals("session_record")) {
                this.f17872k = m17872a(jsonReader);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        if (str != null || i != 0) {
            if (str == null) {
                str = "";
            }
            this.f17871j = new SignalProtocolAddress(str, i);
        }
    }

    public final IdentityKeyPair mo702a() {
        return this.f17863b.mo702a();
    }

    public final int mo707b() {
        return this.f17863b.mo707b();
    }

    public final void mo706a(String str, IdentityKey identityKey) {
        this.f17863b.mo706a(str, identityKey);
    }

    public final boolean mo709b(String str, IdentityKey identityKey) {
        return this.f17863b.mo709b(str, identityKey);
    }

    public final PreKeyRecord mo703a(int i) {
        if (i == this.f17868g && this.f17867f != null) {
            return this.f17867f;
        }
        throw new InvalidKeyIdException("Invalid key id " + Integer.toString(i));
    }

    public final void m17876a(int i, PreKeyRecord preKeyRecord) {
        this.f17868g = i;
        this.f17867f = preKeyRecord;
    }

    public final void mo708b(int i) {
        if (this.f17868g == i) {
            this.f17867f = null;
        }
    }

    public final SignedPreKeyRecord mo711c(int i) {
        if (i == this.f17870i && this.f17869h != null) {
            return this.f17869h;
        }
        throw new InvalidKeyIdException("Invalid key id " + Integer.toString(i));
    }

    public final void m17877a(int i, SignedPreKeyRecord signedPreKeyRecord) {
        this.f17870i = i;
        this.f17869h = signedPreKeyRecord;
    }

    public final SessionRecord m17875a(SignalProtocolAddress signalProtocolAddress) {
        if (this.f17872k == null) {
            this.f17871j = signalProtocolAddress;
            SessionRecord sessionRecord = new SessionRecord();
            this.f17872k = sessionRecord.m21914e();
            return sessionRecord;
        } else if (signalProtocolAddress.equals(this.f17871j)) {
            try {
                return new SessionRecord(this.f17872k);
            } catch (Throwable e) {
                BLog.b(f17862a, "Error deserialising crypto session record", e);
            }
        } else {
            BLog.b(f17862a, "Could not find session for %s", new Object[]{signalProtocolAddress.toString()});
            return null;
        }
    }

    public final void m17882a(SignalProtocolAddress signalProtocolAddress, SessionRecord sessionRecord) {
        if (this.f17871j == null || !signalProtocolAddress.equals(this.f17871j)) {
            this.f17871j = signalProtocolAddress;
        }
        this.f17872k = sessionRecord.m21914e();
    }

    public final boolean m17886b(SignalProtocolAddress signalProtocolAddress) {
        return this.f17871j == null ? false : signalProtocolAddress.equals(this.f17871j);
    }

    public final void m17879a(State state) {
        this.f17865d = state;
    }

    public final void m17889d() {
        this.f17866e++;
    }

    public final void mo704a(JsonWriter jsonWriter) {
        jsonWriter.beginObject();
        jsonWriter.name("state").value((long) this.f17865d.getValue());
        jsonWriter.name("counter").value((long) this.f17866e);
        jsonWriter.name("id").value(this.f17864c);
        if (this.f17867f != null) {
            jsonWriter.name("pre_key_id").value((long) this.f17868g);
            jsonWriter.name("pre_key_record").value(m17870a(this.f17867f.m21907b()));
        }
        if (this.f17869h != null) {
            jsonWriter.name("signed_pre_key_id").value((long) this.f17870i);
            jsonWriter.name("signed_pre_key_record").value(m17870a(this.f17869h.m21951c()));
        }
        if (this.f17871j != null) {
            jsonWriter.name("session_address_name").value(this.f17871j.f21258a);
            jsonWriter.name("session_address_device").value((long) this.f17871j.f21259b);
        }
        if (this.f17872k != null) {
            jsonWriter.name("session_record").value(m17870a(this.f17872k));
        }
        jsonWriter.endObject();
    }

    public final String mo710c() {
        return this.f17864c;
    }

    public final void mo705a(String str) {
        this.f17864c = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
        r6 = this;
        r1 = 1;
        r0 = 0;
        if (r7 != 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        if (r6 != r7) goto L_0x0009;
    L_0x0007:
        r0 = r1;
        goto L_0x0004;
    L_0x0009:
        r2 = r7 instanceof com.facebook.messaging.tincan.crypto.CryptoSessionImpl;
        if (r2 == 0) goto L_0x0004;
    L_0x000d:
        r7 = (com.facebook.messaging.tincan.crypto.CryptoSessionImpl) r7;
        r2 = r7.f17865d;
        r3 = r6.f17865d;
        if (r2 != r3) goto L_0x0004;
    L_0x0015:
        r2 = r7.f17866e;
        r3 = r6.f17866e;
        if (r2 != r3) goto L_0x0004;
    L_0x001b:
        r2 = r7.f17864c;
        r3 = r6.f17864c;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0004;
    L_0x0025:
        r2 = r7.f17868g;
        r3 = r6.f17868g;
        if (r2 != r3) goto L_0x0004;
    L_0x002b:
        r2 = r7.f17870i;
        r3 = r6.f17870i;
        if (r2 != r3) goto L_0x0004;
    L_0x0031:
        r2 = r7.f17871j;
        r3 = r6.f17871j;
        if (r2 != 0) goto L_0x005d;
    L_0x0037:
        if (r3 != 0) goto L_0x005b;
    L_0x0039:
        r4 = 1;
    L_0x003a:
        r2 = r4;
        if (r2 == 0) goto L_0x0004;
    L_0x003d:
        r4 = r7.f17867f;
        if (r4 != 0) goto L_0x0062;
    L_0x0041:
        r4 = r6.f17867f;
        if (r4 != 0) goto L_0x0078;
    L_0x0045:
        r4 = r7.f17869h;
        if (r4 != 0) goto L_0x007a;
    L_0x0049:
        r4 = r6.f17869h;
        if (r4 != 0) goto L_0x0078;
    L_0x004d:
        r4 = r7.f17872k;
        if (r4 != 0) goto L_0x0091;
    L_0x0051:
        r4 = r6.f17872k;
        if (r4 != 0) goto L_0x0078;
    L_0x0055:
        r4 = 1;
    L_0x0056:
        r2 = r4;
        if (r2 == 0) goto L_0x0004;
    L_0x0059:
        r0 = r1;
        goto L_0x0004;
    L_0x005b:
        r4 = 0;
        goto L_0x003a;
    L_0x005d:
        r4 = r2.equals(r3);
        goto L_0x003a;
    L_0x0062:
        r4 = r6.f17867f;
        if (r4 == 0) goto L_0x0078;
    L_0x0066:
        r4 = r7.f17867f;
        r4 = r4.m21907b();
        r5 = r6.f17867f;
        r5 = r5.m21907b();
        r4 = m17871a(r4, r5);
        if (r4 != 0) goto L_0x0045;
    L_0x0078:
        r4 = 0;
        goto L_0x0056;
    L_0x007a:
        r4 = r6.f17869h;
        if (r4 == 0) goto L_0x0078;
    L_0x007e:
        r4 = r7.f17869h;
        r4 = r4.m21951c();
        r5 = r6.f17869h;
        r5 = r5.m21951c();
        r4 = m17871a(r4, r5);
        if (r4 == 0) goto L_0x0078;
    L_0x0090:
        goto L_0x004d;
    L_0x0091:
        r4 = r6.f17872k;
        if (r4 == 0) goto L_0x0078;
    L_0x0095:
        r4 = r7.f17872k;
        r5 = r6.f17872k;
        r4 = m17871a(r4, r5);
        if (r4 == 0) goto L_0x0078;
    L_0x009f:
        goto L_0x0055;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.crypto.CryptoSessionImpl.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return ((((((((((((((((this.f17864c.hashCode() + 527) * 31) + this.f17865d.hashCode()) * 31) + this.f17866e) * 31) + this.f17868g) * 31) + this.f17870i) * 31) + m17869a(this.f17867f)) * 31) + m17869a(this.f17869h)) * 31) + m17869a(this.f17871j)) * 31) + m17869a(this.f17872k);
    }

    private static int m17869a(Object obj) {
        return obj == null ? 0 : obj.hashCode();
    }

    public static boolean m17871a(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    private static byte[] m17872a(JsonReader jsonReader) {
        return Base64.decode(jsonReader.nextString(), 0);
    }

    private static String m17870a(byte[] bArr) {
        return Base64.encodeToString(bArr, 0);
    }
}
