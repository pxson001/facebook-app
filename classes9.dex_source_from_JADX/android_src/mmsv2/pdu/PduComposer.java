package android_src.mmsv2.pdu;

import android.content.ContentResolver;
import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* compiled from: service_intro_warning_message */
public class PduComposer {
    static final /* synthetic */ boolean f3839c;
    private static SimpleArrayMap<String, Integer> f3840h;
    protected ByteArrayOutputStream f3841a = null;
    protected int f3842b = 0;
    private GenericPdu f3843d = null;
    public BufferStack f3844e = null;
    private final ContentResolver f3845f;
    private PduHeaders f3846g = null;

    /* compiled from: service_intro_warning_message */
    class BufferStack {
        int f3829a = 0;
        final /* synthetic */ PduComposer f3830b;
        private LengthRecordNode f3831c = null;
        private LengthRecordNode f3832d = null;

        public BufferStack(PduComposer pduComposer) {
            this.f3830b = pduComposer;
        }

        final void m3625a() {
            if (this.f3832d != null) {
                throw new RuntimeException("BUG: Invalid newbuf() before copy()");
            }
            LengthRecordNode lengthRecordNode = new LengthRecordNode();
            lengthRecordNode.f3833a = this.f3830b.f3841a;
            lengthRecordNode.f3834b = this.f3830b.f3842b;
            lengthRecordNode.f3835c = this.f3831c;
            this.f3831c = lengthRecordNode;
            this.f3829a++;
            this.f3830b.f3841a = new ByteArrayOutputStream();
            this.f3830b.f3842b = 0;
        }

        final void m3626b() {
            ByteArrayOutputStream byteArrayOutputStream = this.f3830b.f3841a;
            int i = this.f3830b.f3842b;
            this.f3830b.f3841a = this.f3831c.f3833a;
            this.f3830b.f3842b = this.f3831c.f3834b;
            this.f3832d = this.f3831c;
            this.f3831c = this.f3831c.f3835c;
            this.f3829a--;
            this.f3832d.f3833a = byteArrayOutputStream;
            this.f3832d.f3834b = i;
        }

        final void m3627c() {
            this.f3830b.m3649a(this.f3832d.f3833a.toByteArray(), 0, this.f3832d.f3834b);
            this.f3832d = null;
        }

        final PositionMarker m3628d() {
            PositionMarker positionMarker = new PositionMarker(this.f3830b);
            positionMarker.f3837b = this.f3830b.f3842b;
            positionMarker.f3838c = this.f3829a;
            return positionMarker;
        }
    }

    /* compiled from: service_intro_warning_message */
    class LengthRecordNode {
        ByteArrayOutputStream f3833a = null;
        public int f3834b = 0;
        public LengthRecordNode f3835c = null;
    }

    /* compiled from: service_intro_warning_message */
    public class PositionMarker {
        final /* synthetic */ PduComposer f3836a;
        public int f3837b;
        public int f3838c;

        public PositionMarker(PduComposer pduComposer) {
            this.f3836a = pduComposer;
        }

        final int m3629a() {
            if (this.f3838c == this.f3836a.f3844e.f3829a) {
                return this.f3836a.f3842b - this.f3837b;
            }
            throw new RuntimeException("BUG: Invalid call to getLength()");
        }
    }

    static {
        boolean z;
        int i = 0;
        if (PduComposer.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f3839c = z;
        f3840h = null;
        f3840h = new SimpleArrayMap();
        while (i < PduContentTypes.f3847a.length) {
            f3840h.put(PduContentTypes.f3847a[i], Integer.valueOf(i));
            i++;
        }
    }

    public PduComposer(Context context, GenericPdu genericPdu) {
        this.f3843d = genericPdu;
        this.f3845f = context.getContentResolver();
        this.f3846g = genericPdu.f3814a;
        this.f3844e = new BufferStack(this);
        this.f3841a = new ByteArrayOutputStream();
        this.f3842b = 0;
    }

    public final boolean m3650a(OutputStream outputStream) {
        switch (this.f3843d.m3593b()) {
            case 128:
                if (m3646e() != 0) {
                    return false;
                }
                break;
            case 130:
                if (m3644d() != 0) {
                    return false;
                }
                break;
            case 131:
                if (m3636b() != 0) {
                    return false;
                }
                break;
            case 133:
                if (m3642c() != 0) {
                    return false;
                }
                break;
            case 135:
                if (m3630a() != 0) {
                    return false;
                }
                break;
            default:
                return false;
        }
        this.f3841a.writeTo(outputStream);
        return true;
    }

    protected final void m3649a(byte[] bArr, int i, int i2) {
        this.f3841a.write(bArr, i, i2);
        this.f3842b += i2;
    }

    private void m3631a(int i) {
        this.f3841a.write(i);
        this.f3842b++;
    }

    private void m3638b(int i) {
        m3631a((i | 128) & 255);
    }

    private void m3632a(long j) {
        int i = 0;
        int i2 = 0;
        long j2 = j;
        while (j2 != 0 && i2 < 8) {
            j2 >>>= 8;
            i2++;
        }
        m3631a(i2);
        long j3 = (i2 - 1) * 8;
        while (i < i2) {
            m3631a((int) ((j >>> j3) & 255));
            j3 -= 8;
            i++;
        }
    }

    private void m3635a(byte[] bArr) {
        if ((bArr[0] & 255) > 127) {
            m3631a(127);
        }
        m3649a(bArr, 0, bArr.length);
        m3631a(0);
    }

    private void m3634a(String str) {
        m3635a(str.getBytes());
    }

    private void m3633a(EncodedStringValue encodedStringValue) {
        if (f3839c || encodedStringValue != null) {
            int i = encodedStringValue.f3825a;
            byte[] b = encodedStringValue.m3609b();
            if (b != null) {
                this.f3844e.m3625a();
                PositionMarker d = this.f3844e.m3628d();
                m3638b(i);
                m3635a(b);
                i = d.m3629a();
                this.f3844e.m3626b();
                m3645d((long) i);
                this.f3844e.m3627c();
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    private void m3639b(long j) {
        int i = 0;
        long j2 = 127;
        while (i < 5 && j >= j2) {
            j2 = (j2 << 7) | 127;
            i++;
        }
        while (i > 0) {
            m3631a((int) ((((j >>> (i * 7)) & 127) | 128) & 255));
            i--;
        }
        m3631a((int) (j & 127));
    }

    private void m3645d(long j) {
        if (j < 31) {
            m3631a((int) j);
            return;
        }
        m3631a(31);
        m3639b(j);
    }

    private void m3641b(byte[] bArr) {
        m3631a(34);
        m3649a(bArr, 0, bArr.length);
        m3631a(0);
    }

    private void m3640b(String str) {
        m3641b(str.getBytes());
    }

    private static EncodedStringValue m3637b(EncodedStringValue encodedStringValue) {
        try {
            int c = m3643c(encodedStringValue.m3610c());
            EncodedStringValue a = EncodedStringValue.m3604a(encodedStringValue);
            if (1 == c) {
                a.m3608b("/TYPE=PLMN".getBytes());
                return a;
            } else if (3 == c) {
                a.m3608b("/TYPE=IPV4".getBytes());
                return a;
            } else if (4 != c) {
                return a;
            } else {
                a.m3608b("/TYPE=IPV6".getBytes());
                return a;
            }
        } catch (NullPointerException e) {
            return null;
        }
    }

    private int m3647e(int i) {
        int a;
        byte[] b;
        long e;
        switch (i) {
            case 129:
            case 130:
            case 151:
                EncodedStringValue[] d = this.f3846g.m3660d(i);
                if (d == null) {
                    return 2;
                }
                for (EncodedStringValue b2 : d) {
                    EncodedStringValue b22 = m3637b(b22);
                    if (b22 == null) {
                        return 1;
                    }
                    m3631a(i);
                    m3633a(b22);
                }
                return 0;
            case 131:
            case 139:
            case 152:
                b = this.f3846g.m3658b(i);
                if (b == null) {
                    return 2;
                }
                m3631a(i);
                m3635a(b);
                return 0;
            case 133:
                e = this.f3846g.m3661e(i);
                if (-1 == e) {
                    return 2;
                }
                m3631a(i);
                m3632a(e);
                return 0;
            case 134:
            case 143:
            case 144:
            case 145:
            case 149:
            case 155:
                int a2 = this.f3846g.m3651a(i);
                if (a2 == 0) {
                    return 2;
                }
                m3631a(i);
                m3631a(a2);
                return 0;
            case 136:
            case 142:
                e = this.f3846g.m3661e(i);
                if (-1 == e) {
                    return 2;
                }
                m3631a(i);
                this.f3844e.m3625a();
                PositionMarker d2 = this.f3844e.m3628d();
                m3631a(129);
                m3632a(e);
                a = d2.m3629a();
                this.f3844e.m3626b();
                m3645d((long) a);
                this.f3844e.m3627c();
                return 0;
            case 137:
                m3631a(i);
                EncodedStringValue c = this.f3846g.m3659c(i);
                if (c == null || TextUtils.isEmpty(c.m3610c()) || new String(c.m3609b()).equals("insert-address-token")) {
                    m3631a(1);
                    m3631a(129);
                    return 0;
                }
                this.f3844e.m3625a();
                PositionMarker d3 = this.f3844e.m3628d();
                m3631a(128);
                c = m3637b(c);
                if (c == null) {
                    return 1;
                }
                m3633a(c);
                a = d3.m3629a();
                this.f3844e.m3626b();
                m3645d((long) a);
                this.f3844e.m3627c();
                return 0;
            case 138:
                b = this.f3846g.m3658b(i);
                if (b == null) {
                    return 2;
                }
                m3631a(i);
                if (Arrays.equals(b, "advertisement".getBytes())) {
                    m3631a(129);
                    return 0;
                } else if (Arrays.equals(b, "auto".getBytes())) {
                    m3631a(131);
                    return 0;
                } else if (Arrays.equals(b, "personal".getBytes())) {
                    m3631a(128);
                    return 0;
                } else if (Arrays.equals(b, "informational".getBytes())) {
                    m3631a(130);
                    return 0;
                } else {
                    m3635a(b);
                    return 0;
                }
            case 141:
                m3631a(i);
                a = this.f3846g.m3651a(i);
                if (a == 0) {
                    m3638b(18);
                    return 0;
                }
                m3638b(a);
                return 0;
            case 150:
                EncodedStringValue c2 = this.f3846g.m3659c(i);
                if (c2 == null) {
                    return 2;
                }
                m3631a(i);
                m3633a(c2);
                return 0;
            default:
                return 3;
        }
    }

    private int m3630a() {
        if (this.f3841a == null) {
            this.f3841a = new ByteArrayOutputStream();
            this.f3842b = 0;
        }
        m3631a(140);
        m3631a(135);
        if (m3647e(141) != 0 || m3647e(139) != 0 || m3647e(151) != 0 || m3647e(137) != 0) {
            return 1;
        }
        m3647e(133);
        if (m3647e(155) == 0) {
            return 0;
        }
        return 1;
    }

    private int m3636b() {
        if (this.f3841a == null) {
            this.f3841a = new ByteArrayOutputStream();
            this.f3842b = 0;
        }
        m3631a(140);
        m3631a(131);
        if (m3647e(152) == 0 && m3647e(141) == 0 && m3647e(149) == 0) {
            return 0;
        }
        return 1;
    }

    private int m3642c() {
        if (this.f3841a == null) {
            this.f3841a = new ByteArrayOutputStream();
            this.f3842b = 0;
        }
        m3631a(140);
        m3631a(133);
        if (m3647e(152) != 0 || m3647e(141) != 0) {
            return 1;
        }
        m3647e(145);
        return 0;
    }

    private int m3644d() {
        if (this.f3841a == null) {
            this.f3841a = new ByteArrayOutputStream();
            this.f3842b = 0;
        }
        m3631a(140);
        m3631a(130);
        if (m3647e(152) != 0 || m3647e(141) != 0 || m3647e(137) != 0) {
            return 1;
        }
        m3647e(150);
        if (m3647e(138) == 0 && m3647e(142) == 0 && m3647e(136) == 0 && m3647e(131) == 0) {
            return 0;
        }
        return 1;
    }

    private int m3646e() {
        int i = 0;
        if (this.f3841a == null) {
            this.f3841a = new ByteArrayOutputStream();
            this.f3842b = 0;
        }
        m3631a(140);
        m3631a(128);
        m3631a(152);
        byte[] b = this.f3846g.m3658b(152);
        if (b == null) {
            throw new IllegalArgumentException("Transaction-ID is null.");
        }
        m3635a(b);
        if (m3647e(141) != 0) {
            return 1;
        }
        m3647e(133);
        if (m3647e(137) != 0) {
            return 1;
        }
        if (m3647e(151) != 1) {
            i = 1;
        }
        if (m3647e(130) != 1) {
            i = 1;
        }
        if (m3647e(129) != 1) {
            i = 1;
        }
        if (i == 0) {
            return 1;
        }
        m3647e(150);
        m3647e(138);
        m3647e(136);
        m3647e(143);
        m3647e(134);
        m3647e(144);
        m3631a(132);
        return m3648f();
    }

    private int m3648f() {
        InputStream openInputStream;
        Throwable th;
        this.f3844e.m3625a();
        PositionMarker d = this.f3844e.m3628d();
        Integer num = (Integer) f3840h.get(new String(this.f3846g.m3658b(132)));
        if (num == null) {
            return 1;
        }
        m3638b(num.intValue());
        PduBody d2 = ((SendReq) this.f3843d).m3613d();
        if (d2 == null || d2.m3624b() == 0) {
            m3639b(0);
            this.f3844e.m3626b();
            this.f3844e.m3627c();
            return 0;
        }
        try {
            PduPart a = d2.m3620a(0);
            byte[] c = a.m3687c();
            if (c != null) {
                m3631a(138);
                if ((byte) 60 == c[0] && (byte) 62 == c[c.length - 1]) {
                    m3635a(c);
                } else {
                    m3634a("<" + new String(c) + ">");
                }
            }
            m3631a(137);
            m3635a(a.m3694g());
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        int a2 = d.m3629a();
        this.f3844e.m3626b();
        m3645d((long) a2);
        this.f3844e.m3627c();
        int b = d2.m3624b();
        m3639b((long) b);
        for (int i = 0; i < b; i++) {
            PduPart a3 = d2.m3620a(i);
            this.f3844e.m3625a();
            PositionMarker d3 = this.f3844e.m3628d();
            this.f3844e.m3625a();
            PositionMarker d4 = this.f3844e.m3628d();
            byte[] g = a3.m3694g();
            if (g == null) {
                return 1;
            }
            num = (Integer) f3840h.get(new String(g));
            if (num == null) {
                m3635a(g);
            } else {
                m3638b(num.intValue());
            }
            byte[] i2 = a3.m3696i();
            if (i2 == null) {
                i2 = a3.m3697j();
                if (i2 == null) {
                    i2 = a3.m3691e();
                    if (i2 == null) {
                        i2 = "smil.xml".getBytes();
                    }
                }
            }
            m3631a(133);
            m3635a(i2);
            a2 = a3.m3688d();
            if (a2 != 0) {
                m3631a(129);
                m3638b(a2);
            }
            a2 = d4.m3629a();
            this.f3844e.m3626b();
            m3645d((long) a2);
            this.f3844e.m3627c();
            i2 = a3.m3687c();
            if (i2 != null) {
                m3631a(192);
                if ((byte) 60 == i2[0] && (byte) 62 == i2[i2.length - 1]) {
                    m3641b(i2);
                } else {
                    m3640b("<" + new String(i2) + ">");
                }
            }
            i2 = a3.m3691e();
            if (i2 != null) {
                m3631a(142);
                m3635a(i2);
            }
            int a4 = d3.m3629a();
            i2 = a3.m3683a();
            if (i2 != null) {
                m3649a(i2, 0, i2.length);
                a2 = i2.length;
            } else {
                InputStream inputStream = null;
                try {
                    g = new byte[1024];
                    openInputStream = this.f3845f.openInputStream(a3.m3684b());
                    a2 = 0;
                    while (true) {
                        try {
                            int read = openInputStream.read(g);
                            if (read == -1) {
                                break;
                            }
                            this.f3841a.write(g, 0, read);
                            this.f3842b += read;
                            a2 += read;
                        } catch (FileNotFoundException e2) {
                            inputStream = openInputStream;
                        } catch (IOException e3) {
                        } catch (RuntimeException e4) {
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (FileNotFoundException e6) {
                } catch (IOException e7) {
                    openInputStream = null;
                } catch (RuntimeException e8) {
                    openInputStream = null;
                } catch (Throwable th3) {
                    openInputStream = null;
                    th = th3;
                }
            }
            if (a2 != d3.m3629a() - a4) {
                throw new RuntimeException("BUG: Length sanity check failed");
            }
            this.f3844e.m3626b();
            m3639b((long) a4);
            m3639b((long) a2);
            this.f3844e.m3627c();
        }
        return 0;
        return 1;
        return 1;
        if (openInputStream != null) {
            try {
                openInputStream.close();
            } catch (IOException e9) {
            }
        }
        return 1;
        return 1;
        if (openInputStream != null) {
            try {
                openInputStream.close();
            } catch (IOException e10) {
            }
        }
        throw th;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e11) {
            }
        }
        return 1;
        if (openInputStream != null) {
            try {
                openInputStream.close();
            } catch (IOException e12) {
            }
        }
        return 1;
        throw th;
    }

    private static int m3643c(String str) {
        if (str == null) {
            return 5;
        }
        if (str.matches("[0-9]{1,3}\\.{1}[0-9]{1,3}\\.{1}[0-9]{1,3}\\.{1}[0-9]{1,3}")) {
            return 3;
        }
        if (str.matches("\\+?[0-9|\\.|\\-]+")) {
            return 1;
        }
        if (str.matches("[a-zA-Z| ]*\\<{0,1}[a-zA-Z| ]+@{1}[a-zA-Z| ]+\\.{1}[a-zA-Z| ]+\\>{0,1}")) {
            return 2;
        }
        if (str.matches("[a-fA-F]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}")) {
            return 4;
        }
        return 5;
    }
}
