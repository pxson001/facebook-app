package android_src.mmsv2.pdu;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.Telephony.Mms.Draft;
import android.provider.Telephony.Mms.Inbox;
import android.provider.Telephony.Mms.Outbox;
import android.provider.Telephony.Mms.Sent;
import android.provider.Telephony.MmsSms;
import android.provider.Telephony.MmsSms.PendingMessages;
import android.support.v4.util.SimpleArrayMap;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android_src.database.sqlite.SqliteWrapper;
import android_src.mmsv2.Utils;
import android_src.mmsv2.util.DownloadDrmHelper;
import android_src.mmsv2.util.DrmConvertSession;
import android_src.mmsv2.util.PduCache;
import android_src.provider.Telephony.Threads;
import com.facebook.debug.log.BLog;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: service_fb_app_id */
public class PduPersister {
    public static final String[] f3862a = new String[]{"_id", "msg_box", "thread_id", "retr_txt", "sub", "ct_l", "ct_t", "m_cls", "m_id", "resp_txt", "tr_id", "ct_cls", "d_rpt", "m_type", "v", "pri", "rr", "read_status", "rpt_a", "retr_st", "st", "date", "d_tm", "exp", "m_size", "sub_cs", "retr_txt_cs", "read", "seen"};
    public static final String[] f3863b = new String[]{"normalized_date"};
    private static PduPersister f3864c;
    private static final PduCache f3865d = PduCache.m3747b();
    private static final int[] f3866e = new int[]{129, 130, 137, 151};
    private static final String[] f3867f = new String[]{"_id", "chset", "cd", "cid", "cl", "ct", "fn", "name", "text"};
    private static final SimpleArrayMap<Uri, Integer> f3868g;
    public static final SparseIntArray f3869h;
    private static final SparseIntArray f3870i;
    private static final SparseIntArray f3871j;
    private static final SparseIntArray f3872k;
    private static final SparseIntArray f3873l;
    private static final SparseArray<String> f3874m;
    private static final SparseArray<String> f3875n;
    private static final SparseArray<String> f3876o;
    private static final SparseArray<String> f3877p;
    private static final SparseArray<String> f3878q;
    private final Context f3879r;
    private final ContentResolver f3880s;
    private String f3881t;
    private final TelephonyManager f3882u;

    static {
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        f3868g = simpleArrayMap;
        simpleArrayMap.put(Inbox.CONTENT_URI, Integer.valueOf(1));
        f3868g.put(Sent.CONTENT_URI, Integer.valueOf(2));
        f3868g.put(Draft.CONTENT_URI, Integer.valueOf(3));
        f3868g.put(Outbox.CONTENT_URI, Integer.valueOf(4));
        SparseIntArray sparseIntArray = new SparseIntArray();
        f3869h = sparseIntArray;
        sparseIntArray.put(150, 25);
        f3869h.put(154, 26);
        SparseArray sparseArray = new SparseArray();
        f3874m = sparseArray;
        sparseArray.put(150, "sub_cs");
        f3874m.put(154, "retr_txt_cs");
        sparseIntArray = new SparseIntArray();
        f3870i = sparseIntArray;
        sparseIntArray.put(154, 3);
        f3870i.put(150, 4);
        sparseArray = new SparseArray();
        f3875n = sparseArray;
        sparseArray.put(154, "retr_txt");
        f3875n.put(150, "sub");
        sparseIntArray = new SparseIntArray();
        f3871j = sparseIntArray;
        sparseIntArray.put(131, 5);
        f3871j.put(132, 6);
        f3871j.put(138, 7);
        f3871j.put(139, 8);
        f3871j.put(147, 9);
        f3871j.put(152, 10);
        sparseArray = new SparseArray();
        f3876o = sparseArray;
        sparseArray.put(131, "ct_l");
        f3876o.put(132, "ct_t");
        f3876o.put(138, "m_cls");
        f3876o.put(139, "m_id");
        f3876o.put(147, "resp_txt");
        f3876o.put(152, "tr_id");
        sparseIntArray = new SparseIntArray();
        f3872k = sparseIntArray;
        sparseIntArray.put(186, 11);
        f3872k.put(134, 12);
        f3872k.put(140, 13);
        f3872k.put(141, 14);
        f3872k.put(143, 15);
        f3872k.put(144, 16);
        f3872k.put(155, 17);
        f3872k.put(145, 18);
        f3872k.put(153, 19);
        f3872k.put(149, 20);
        sparseArray = new SparseArray();
        f3877p = sparseArray;
        sparseArray.put(186, "ct_cls");
        f3877p.put(134, "d_rpt");
        f3877p.put(140, "m_type");
        f3877p.put(141, "v");
        f3877p.put(143, "pri");
        f3877p.put(144, "rr");
        f3877p.put(155, "read_status");
        f3877p.put(145, "rpt_a");
        f3877p.put(153, "retr_st");
        f3877p.put(149, "st");
        sparseIntArray = new SparseIntArray();
        f3873l = sparseIntArray;
        sparseIntArray.put(133, 21);
        f3873l.put(135, 22);
        f3873l.put(136, 23);
        f3873l.put(142, 24);
        sparseArray = new SparseArray();
        f3878q = sparseArray;
        sparseArray.put(133, "date");
        f3878q.put(135, "d_tm");
        f3878q.put(136, "exp");
        f3878q.put(142, "m_size");
    }

    private PduPersister(Context context) {
        this.f3879r = context;
        this.f3880s = context.getContentResolver();
        this.f3882u = (TelephonyManager) context.getSystemService("phone");
    }

    public static PduPersister m3702a(Context context) {
        if (f3864c == null || !context.equals(f3864c.f3879r)) {
            f3864c = new PduPersister(context);
        }
        return f3864c;
    }

    public static PduPersister m3703a(Context context, String str) {
        PduPersister a = m3702a(context);
        f3864c.f3881t = str;
        return a;
    }

    private static Integer m3704a(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(i));
    }

    private static byte[] m3716b(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return m3715a(cursor.getString(i));
    }

    private PduPart[] m3717b(long j) {
        Throwable e;
        InputStream inputStream = null;
        Cursor a = SqliteWrapper.a(this.f3879r, this.f3880s, Uri.parse("content://mms/" + j + "/part"), f3867f, null, null, null);
        if (a != null) {
            try {
                if (a.getCount() != 0) {
                    PduPart[] pduPartArr = new PduPart[a.getCount()];
                    int i = 0;
                    while (a.moveToNext()) {
                        PduPart pduPart = new PduPart();
                        Integer a2 = m3704a(a, 1);
                        if (a2 != null) {
                            pduPart.m3680a(a2.intValue());
                        }
                        byte[] b = m3716b(a, 2);
                        if (b != null) {
                            pduPart.m3689d(b);
                        }
                        b = m3716b(a, 3);
                        if (b != null) {
                            pduPart.m3685b(b);
                        }
                        b = m3716b(a, 4);
                        if (b != null) {
                            pduPart.m3686c(b);
                        }
                        b = m3716b(a, 5);
                        if (b != null) {
                            pduPart.m3690e(b);
                            byte[] b2 = m3716b(a, 6);
                            if (b2 != null) {
                                pduPart.m3695h(b2);
                            }
                            b2 = m3716b(a, 7);
                            if (b2 != null) {
                                pduPart.m3693g(b2);
                            }
                            Uri parse = Uri.parse("content://mms/part/" + a.getLong(0));
                            pduPart.m3681a(parse);
                            String a3 = m3707a(b);
                            if (!(ContentType.m3601b(a3) || ContentType.m3602c(a3) || ContentType.m3603d(a3))) {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                int intValue;
                                if ("text/plain".equals(a3) || "application/smil".equals(a3) || "text/html".equals(a3)) {
                                    a3 = a.getString(8);
                                    intValue = a2 != null ? a2.intValue() : 106;
                                    if (a3 == null) {
                                        a3 = "";
                                    }
                                    b = new EncodedStringValue(intValue, a3).m3609b();
                                    byteArrayOutputStream.write(b, 0, b.length);
                                } else {
                                    try {
                                        InputStream openInputStream = this.f3880s.openInputStream(parse);
                                        try {
                                            b2 = new byte[256];
                                            for (intValue = openInputStream.read(b2); intValue >= 0; intValue = openInputStream.read(b2)) {
                                                byteArrayOutputStream.write(b2, 0, intValue);
                                            }
                                            if (openInputStream != null) {
                                                try {
                                                    openInputStream.close();
                                                } catch (Throwable e2) {
                                                    BLog.b("PduPersister", "Failed to close stream", e2);
                                                }
                                            }
                                        } catch (IOException e3) {
                                            e = e3;
                                            inputStream = openInputStream;
                                        } catch (Throwable th) {
                                            e = th;
                                            inputStream = openInputStream;
                                        }
                                    } catch (IOException e4) {
                                        e = e4;
                                    }
                                }
                                pduPart.m3682a(byteArrayOutputStream.toByteArray());
                            }
                            int i2 = i + 1;
                            pduPartArr[i] = pduPart;
                            i = i2;
                        } else {
                            throw new MmsException("Content-Type must be set.");
                        }
                    }
                    return pduPartArr;
                }
            } finally {
                if (a != null) {
                    a.close();
                }
            }
        }
        if (a == null) {
            return null;
        }
        a.close();
        return null;
        try {
            BLog.b("PduPersister", "Failed to load part data", e);
            a.close();
            throw new MmsException(e);
        } catch (Throwable th2) {
            e = th2;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e22) {
                    BLog.b("PduPersister", "Failed to close stream", e22);
                }
            }
            throw e;
        }
    }

    private void m3710a(long j, PduHeaders pduHeaders) {
        Cursor a = SqliteWrapper.a(this.f3879r, this.f3880s, Uri.parse("content://mms/" + j + "/addr"), new String[]{"address", "charset", "type"}, null, null, null);
        if (a != null) {
            while (a.moveToNext()) {
                try {
                    String string = a.getString(0);
                    if (!TextUtils.isEmpty(string)) {
                        int i = a.getInt(2);
                        switch (i) {
                            case 129:
                            case 130:
                            case 151:
                                pduHeaders.m3657b(new EncodedStringValue(a.getInt(1), m3715a(string)), i);
                                break;
                            case 137:
                                pduHeaders.m3654a(new EncodedStringValue(a.getInt(1), m3715a(string)), i);
                                break;
                            default:
                                BLog.b("PduPersister", "Unknown address type: " + i);
                                break;
                        }
                    }
                } finally {
                    a.close();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android_src.mmsv2.pdu.GenericPdu m3721a(android.net.Uri r13) {
        /*
        r12 = this;
        r10 = -1;
        r8 = 1;
        r7 = 0;
        r1 = f3865d;	 Catch:{ all -> 0x0045 }
        monitor-enter(r1);	 Catch:{ all -> 0x0045 }
        r0 = f3865d;	 Catch:{ all -> 0x0042 }
        r0 = r0.m3754a(r13);	 Catch:{ all -> 0x0042 }
        if (r0 == 0) goto L_0x0017;
    L_0x000f:
        r0 = f3865d;	 Catch:{ InterruptedException -> 0x0039 }
        r2 = -37290238; // 0xfffffffffdc6ff02 float:-3.3063902E37 double:NaN;
        com.facebook.tools.dextr.runtime.detour.ObjectDetour.a(r0, r2);	 Catch:{ InterruptedException -> 0x0039 }
    L_0x0017:
        r0 = f3865d;	 Catch:{  }
        r0 = r0.m3736a(r13);	 Catch:{  }
        r0 = (android_src.mmsv2.util.PduCacheEntry) r0;	 Catch:{  }
        if (r0 == 0) goto L_0x005c;
    L_0x0021:
        r0 = r0.m3759a();	 Catch:{  }
        monitor-exit(r1);	 Catch:{  }
        r1 = f3865d;
        monitor-enter(r1);
        r2 = f3865d;	 Catch:{ all -> 0x0059 }
        r3 = 0;
        r2.m3753a(r13, r3);	 Catch:{ all -> 0x0059 }
        r2 = f3865d;	 Catch:{ all -> 0x0059 }
        r3 = -1428924016; // 0xffffffffaad45990 float:-3.7720911E-13 double:NaN;
        com.facebook.tools.dextr.runtime.detour.ObjectDetour.c(r2, r3);	 Catch:{ all -> 0x0059 }
        monitor-exit(r1);	 Catch:{ all -> 0x0059 }
    L_0x0038:
        return r0;
    L_0x0039:
        r0 = move-exception;
        r2 = "PduPersister";
        r3 = "load: ";
        com.facebook.debug.log.BLog.b(r2, r3, r0);	 Catch:{  }
        goto L_0x0017;
    L_0x0042:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0045:
        r0 = move-exception;
        r1 = f3865d;
        monitor-enter(r1);
        r2 = f3865d;	 Catch:{ all -> 0x00fa }
        r3 = 0;
        r2.m3753a(r13, r3);	 Catch:{ all -> 0x00fa }
        r2 = f3865d;	 Catch:{ all -> 0x00fa }
        r3 = 1482417222; // 0x585be446 float:9.6709389E14 double:7.32411422E-315;
        com.facebook.tools.dextr.runtime.detour.ObjectDetour.c(r2, r3);	 Catch:{ all -> 0x00fa }
        monitor-exit(r1);	 Catch:{ all -> 0x00fa }
        throw r0;
    L_0x0059:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
    L_0x005c:
        r0 = f3865d;	 Catch:{  }
        r2 = 1;
        r0.m3753a(r13, r2);	 Catch:{  }
        monitor-exit(r1);	 Catch:{  }
        r0 = r12.f3879r;	 Catch:{  }
        r1 = r12.f3880s;	 Catch:{  }
        r3 = f3862a;	 Catch:{  }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r2 = r13;
        r1 = android_src.database.sqlite.SqliteWrapper.a(r0, r1, r2, r3, r4, r5, r6);	 Catch:{  }
        r0 = new android_src.mmsv2.pdu.PduHeaders;	 Catch:{  }
        r0.<init>();	 Catch:{  }
        r2 = android.content.ContentUris.parseId(r13);	 Catch:{  }
        if (r1 == 0) goto L_0x0088;
    L_0x007c:
        r4 = r1.getCount();	 Catch:{ all -> 0x00bd }
        if (r4 != r8) goto L_0x0088;
    L_0x0082:
        r4 = r1.moveToFirst();	 Catch:{ all -> 0x00bd }
        if (r4 != 0) goto L_0x00a4;
    L_0x0088:
        if (r1 == 0) goto L_0x008d;
    L_0x008a:
        r1.close();	 Catch:{  }
    L_0x008d:
        r1 = f3865d;
        monitor-enter(r1);
        r0 = f3865d;	 Catch:{ all -> 0x00a1 }
        r2 = 0;
        r0.m3753a(r13, r2);	 Catch:{ all -> 0x00a1 }
        r0 = f3865d;	 Catch:{ all -> 0x00a1 }
        r2 = 24619830; // 0x177ab36 float:4.5489573E-38 double:1.2163812E-316;
        com.facebook.tools.dextr.runtime.detour.ObjectDetour.c(r0, r2);	 Catch:{ all -> 0x00a1 }
        monitor-exit(r1);	 Catch:{ all -> 0x00a1 }
        r0 = r7;
        goto L_0x0038;
    L_0x00a1:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00a1 }
        throw r0;
    L_0x00a4:
        r4 = 1;
        r4 = r1.getInt(r4);	 Catch:{  }
        r12.m3711a(r1, r0);	 Catch:{  }
        if (r1 == 0) goto L_0x00b1;
    L_0x00ae:
        r1.close();	 Catch:{  }
    L_0x00b1:
        r1 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r1 != 0) goto L_0x00c4;
    L_0x00b5:
        r0 = new android_src.mmsv2.pdu.MmsException;	 Catch:{  }
        r1 = "Error! ID of the message: -1.";
        r0.<init>(r1);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x00bd:
        r0 = move-exception;
        if (r1 == 0) goto L_0x00c3;
    L_0x00c0:
        r1.close();	 Catch:{  }
    L_0x00c3:
        throw r0;	 Catch:{  }
    L_0x00c4:
        r12.m3710a(r2, r0);	 Catch:{  }
        r1 = 140; // 0x8c float:1.96E-43 double:6.9E-322;
        r1 = r0.m3651a(r1);	 Catch:{  }
        r2 = r12.m3701a(r2, r1);	 Catch:{  }
        r0 = m3700a(r1, r0, r2);	 Catch:{  }
        r1 = f3865d;
        monitor-enter(r1);
        if (r0 == 0) goto L_0x00e6;
    L_0x00da:
        r2 = new android_src.mmsv2.util.PduCacheEntry;	 Catch:{ all -> 0x00f7 }
        r6 = -1;
        r2.<init>(r0, r4, r6);	 Catch:{ all -> 0x00f7 }
        r3 = f3865d;	 Catch:{ all -> 0x00f7 }
        r3.m3755a(r13, r2);	 Catch:{ all -> 0x00f7 }
    L_0x00e6:
        r2 = f3865d;	 Catch:{ all -> 0x00f7 }
        r3 = 0;
        r2.m3753a(r13, r3);	 Catch:{ all -> 0x00f7 }
        r2 = f3865d;	 Catch:{ all -> 0x00f7 }
        r3 = 1634613625; // 0x616e3979 float:2.7465415E20 double:8.076064363E-315;
        com.facebook.tools.dextr.runtime.detour.ObjectDetour.c(r2, r3);	 Catch:{ all -> 0x00f7 }
        monitor-exit(r1);	 Catch:{ all -> 0x00f7 }
        goto L_0x0038;
    L_0x00f7:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00f7 }
        throw r0;
    L_0x00fa:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android_src.mmsv2.pdu.PduPersister.a(android.net.Uri):android_src.mmsv2.pdu.GenericPdu");
    }

    private void m3711a(Cursor cursor, PduHeaders pduHeaders) {
        int size = f3870i.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            int valueAt = f3870i.valueAt(size);
            int keyAt = f3870i.keyAt(size);
            String string = cursor.getString(valueAt);
            if (string != null && string.length() > 0) {
                pduHeaders.m3654a(new EncodedStringValue(cursor.getInt(f3869h.get(keyAt)), m3715a(string)), keyAt);
            }
        }
        size = f3871j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            valueAt = f3871j.valueAt(size);
            keyAt = f3871j.keyAt(size);
            string = cursor.getString(valueAt);
            if (string != null) {
                pduHeaders.m3655a(m3715a(string), keyAt);
            }
        }
        size = f3872k.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            valueAt = f3872k.valueAt(size);
            keyAt = f3872k.keyAt(size);
            if (!cursor.isNull(valueAt)) {
                pduHeaders.m3652a(cursor.getInt(valueAt), keyAt);
            }
        }
        size = f3873l.size();
        while (true) {
            size--;
            if (size >= 0) {
                valueAt = f3873l.valueAt(size);
                keyAt = f3873l.keyAt(size);
                if (!cursor.isNull(valueAt)) {
                    pduHeaders.m3653a(cursor.getLong(valueAt), keyAt);
                }
            } else {
                return;
            }
        }
    }

    private static GenericPdu m3700a(int i, PduHeaders pduHeaders, PduBody pduBody) {
        switch (i) {
            case 128:
                return new SendReq(pduHeaders, pduBody);
            case 129:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
                throw new MmsException("Unsupported PDU type: " + Integer.toHexString(i));
            case 130:
                return new NotificationInd(pduHeaders);
            case 131:
                return new NotifyRespInd(pduHeaders);
            case 132:
                return new RetrieveConf(pduHeaders, pduBody);
            case 133:
                return new AcknowledgeInd(pduHeaders);
            case 134:
                return new DeliveryInd(pduHeaders);
            case 135:
                return new ReadRecInd(pduHeaders);
            case 136:
                return new ReadOrigInd(pduHeaders);
            default:
                throw new MmsException("Unrecognized PDU type: " + Integer.toHexString(i));
        }
    }

    private PduBody m3701a(long j, int i) {
        PduBody pduBody = new PduBody();
        if (i == 132 || i == 128) {
            PduPart[] b = m3717b(j);
            if (b != null) {
                for (PduPart a : b) {
                    pduBody.m3623a(a);
                }
            }
        }
        return pduBody;
    }

    private void m3709a(long j, int i, EncodedStringValue[] encodedStringValueArr) {
        ContentValues contentValues = new ContentValues(3);
        for (EncodedStringValue encodedStringValue : encodedStringValueArr) {
            contentValues.clear();
            contentValues.put("address", m3707a(encodedStringValue.m3609b()));
            contentValues.put("charset", Integer.valueOf(encodedStringValue.f3825a));
            contentValues.put("type", Integer.valueOf(i));
            SqliteWrapper.a(this.f3879r, this.f3880s, Uri.parse("content://mms/" + j + "/addr"), contentValues);
        }
    }

    private static String m3706a(PduPart pduPart) {
        return pduPart.m3694g() == null ? null : m3707a(pduPart.m3694g());
    }

    private static void m3712a(PduPart pduPart, ContentValues contentValues) {
        byte[] j = pduPart.m3697j();
        if (j != null) {
            contentValues.put("fn", new String(j));
        }
        j = pduPart.m3696i();
        if (j != null) {
            contentValues.put("name", new String(j));
        }
        j = (byte[]) pduPart.f3859d.get(197);
        if (j != null) {
            contentValues.put("cd", m3707a(j));
        }
        j = pduPart.m3687c();
        if (j != null) {
            contentValues.put("cid", m3707a(j));
        }
        j = pduPart.m3691e();
        if (j != null) {
            contentValues.put("cl", m3707a(j));
        }
    }

    private Uri m3699a(PduPart pduPart, long j, Map<Uri, InputStream> map) {
        Uri parse = Uri.parse("content://mms/" + j + "/part");
        ContentValues contentValues = new ContentValues(8);
        int d = pduPart.m3688d();
        if (d != 0) {
            contentValues.put("chset", Integer.valueOf(d));
        }
        String a = m3706a(pduPart);
        byte[] a2 = pduPart.m3683a();
        new StringBuilder("PduPersister.persistPart part: ").append(parse).append(" contentType: ").append(a);
        if (a != null) {
            if ("image/jpg".equals(a)) {
                a = "image/jpeg";
            }
            if ("text/plain".equals(a) && a2 != null) {
                String c = new EncodedStringValue(d, a2).m3610c();
                if (c != null && c.startsWith("BEGIN:VCARD")) {
                    a = "text/x-vCard";
                    pduPart.m3690e(a.getBytes());
                    new StringBuilder("PduPersister.persistPart part: ").append(parse).append(" contentType: ").append(a).append(" changing to vcard");
                }
            }
            contentValues.put("ct", a);
            if ("application/smil".equals(a)) {
                contentValues.put("seq", Integer.valueOf(-1));
            }
            m3712a(pduPart, contentValues);
            try {
                parse = SqliteWrapper.a(this.f3879r, this.f3880s, parse, contentValues);
            } catch (Throwable e) {
                BLog.b("PduPersister", "SqliteWrapper.insert threw: ", e);
                parse = null;
            }
            if (parse == null) {
                throw new MmsException("Failed to persist part, return null.");
            }
            m3713a(pduPart, parse, a, map);
            pduPart.m3681a(parse);
            return parse;
        }
        throw new MmsException("MIME type of the part must be set.");
    }

    private void m3713a(PduPart pduPart, Uri uri, String str, Map<Uri, InputStream> map) {
        OutputStream outputStream = null;
        InputStream inputStream = null;
        DrmConvertSession drmConvertSession = null;
        String str2 = null;
        File file;
        try {
            byte[] a = pduPart.m3683a();
            int d = pduPart.m3688d();
            if (!"text/plain".equals(str) && !"application/smil".equals(str) && !"text/html".equals(str)) {
                boolean a2 = DownloadDrmHelper.m3740a(str);
                if (a2) {
                    if (uri != null) {
                        try {
                            str2 = m3705a(this.f3879r, uri);
                            if (new File(str2).length() > 0) {
                                return;
                            }
                        } catch (Throwable e) {
                            BLog.b("PduPersister", "Can't get file info for: " + pduPart.m3684b(), e);
                        }
                    }
                    drmConvertSession = DrmConvertSession.m3741a(this.f3879r, str);
                    if (drmConvertSession == null) {
                        throw new MmsException("Mimetype " + str + " can not be converted.");
                    }
                }
                outputStream = this.f3880s.openOutputStream(uri);
                if (outputStream == null) {
                    throw new MmsException("Failed to create output stream on " + uri);
                } else if (a == null) {
                    Uri b = pduPart.m3684b();
                    if (b != null && b != uri) {
                        if (map != null && map.containsKey(b)) {
                            inputStream = (InputStream) map.get(b);
                        }
                        if (inputStream == null) {
                            inputStream = this.f3880s.openInputStream(b);
                        }
                        if (inputStream != null) {
                            r2 = new byte[8192];
                            while (true) {
                                int read = inputStream.read(r2);
                                if (read == -1) {
                                    break;
                                } else if (a2) {
                                    a = drmConvertSession.m3743a(r2, read);
                                    if (a != null) {
                                        outputStream.write(a, 0, a.length);
                                    } else {
                                        throw new MmsException("Error converting drm data.");
                                    }
                                } else {
                                    outputStream.write(r2, 0, read);
                                }
                            }
                        } else {
                            throw new MmsException("Failed to create input stream on " + b);
                        }
                    }
                    BLog.a("PduPersister", "Can't find data for this part.");
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable e2) {
                            BLog.b("PduPersister", "IOException while closing: " + outputStream, e2);
                        }
                    }
                    if (drmConvertSession != null) {
                        drmConvertSession.m3742a(str2);
                        file = new File(str2);
                        SqliteWrapper.a(this.f3879r, this.f3880s, Uri.parse("content://mms/resetFilePerm/" + file.getName()), new ContentValues(0), null, null);
                        return;
                    }
                    return;
                } else if (a2) {
                    r2 = drmConvertSession.m3743a(a, a.length);
                    if (r2 != null) {
                        outputStream.write(r2, 0, r2.length);
                    } else {
                        throw new MmsException("Error converting drm data.");
                    }
                } else {
                    outputStream.write(a);
                }
            } else if (a != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("text", new EncodedStringValue(d, a).m3610c());
                if (this.f3880s.update(uri, contentValues, null, null) != 1) {
                    throw new MmsException("unable to update " + uri.toString());
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable e22) {
                    BLog.b("PduPersister", "IOException while closing: " + outputStream, e22);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e222) {
                    BLog.b("PduPersister", "IOException while closing: " + inputStream, e222);
                }
            }
            if (drmConvertSession != null) {
                drmConvertSession.m3742a(str2);
                file = new File(str2);
                SqliteWrapper.a(this.f3879r, this.f3880s, Uri.parse("content://mms/resetFilePerm/" + file.getName()), new ContentValues(0), null, null);
            }
        } catch (Throwable e2222) {
            BLog.b("PduPersister", "Failed with SQLiteException.", e2222);
            throw new MmsException(e2222);
        } catch (Throwable e22222) {
            BLog.b("PduPersister", "Failed to open Input/Output stream.", e22222);
            throw new MmsException(e22222);
        } catch (Throwable e222222) {
            BLog.b("PduPersister", "Failed to read/write data.", e222222);
            throw new MmsException(e222222);
        } catch (Throwable e2222222) {
            Throwable th = e2222222;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable e22222222) {
                    BLog.b("PduPersister", "IOException while closing: " + outputStream, e22222222);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e222222222) {
                    BLog.b("PduPersister", "IOException while closing: " + inputStream, e222222222);
                }
            }
            if (drmConvertSession != null) {
                drmConvertSession.m3742a(null);
                file = new File(null);
                SqliteWrapper.a(this.f3879r, this.f3880s, Uri.parse("content://mms/resetFilePerm/" + file.getName()), new ContentValues(0), null, null);
            }
        }
    }

    private static String m3705a(Context context, Uri uri) {
        Cursor cursor = null;
        if (uri == null) {
            return cursor;
        }
        String scheme = uri.getScheme();
        if (scheme == null || scheme.equals("") || scheme.equals("file")) {
            return uri.getPath();
        }
        if (scheme.equals("http")) {
            return uri.toString();
        }
        if (scheme.equals("content")) {
            try {
                cursor = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
                if (cursor == null || cursor.getCount() == 0 || !cursor.moveToFirst()) {
                    throw new IllegalArgumentException("Given Uri could not be found in media store");
                }
                scheme = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                if (cursor == null) {
                    return scheme;
                }
                cursor.close();
                return scheme;
            } catch (SQLiteException e) {
                throw new IllegalArgumentException("Given Uri is not formatted in a way so that it can be found in media store.");
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        } else {
            throw new IllegalArgumentException("Given Uri scheme is not supported");
        }
    }

    public final Uri m3720a(GenericPdu genericPdu, Uri uri, int i, String str, boolean z, Map<Uri, InputStream> map) {
        if (uri == null) {
            throw new MmsException("Uri may not be null.");
        }
        long j = -1;
        try {
            j = ContentUris.parseId(uri);
        } catch (NumberFormatException e) {
        }
        Object obj = j != -1 ? 1 : null;
        if (obj == null && f3868g.get(uri) == null) {
            throw new MmsException("Bad destination, must be one of content://mms/inbox, content://mms/sent, content://mms/drafts, content://mms/outbox, content://mms/temp.");
        }
        int i2;
        Object obj2;
        long a;
        Uri uri2;
        synchronized (f3865d) {
            if (f3865d.m3754a(uri)) {
                try {
                    ObjectDetour.a(f3865d, 24123735);
                } catch (Throwable e2) {
                    Throwable e22;
                    BLog.b("PduPersister", "persist1: ", e22);
                }
            }
        }
        f3865d.m3757b(uri);
        PduHeaders a2 = genericPdu.m3590a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("seen", Integer.valueOf(1));
        int size = f3875n.size();
        while (true) {
            int i3 = size - 1;
            if (i3 < 0) {
                break;
            }
            size = f3875n.keyAt(i3);
            EncodedStringValue c = a2.m3659c(size);
            if (c != null) {
                String str2 = (String) f3874m.get(size);
                contentValues.put((String) f3875n.valueAt(i3), m3707a(c.m3609b()));
                contentValues.put(str2, Integer.valueOf(c.m3606a()));
            }
            size = i3;
        }
        size = f3876o.size();
        while (true) {
            i2 = size - 1;
            if (i2 < 0) {
                break;
            }
            byte[] b = a2.m3658b(f3876o.keyAt(i2));
            if (b != null) {
                contentValues.put((String) f3876o.valueAt(i2), m3707a(b));
            }
            size = i2;
        }
        size = f3877p.size();
        while (true) {
            i2 = size - 1;
            if (i2 < 0) {
                break;
            }
            i3 = a2.m3651a(f3877p.keyAt(i2));
            if (i3 != 0) {
                contentValues.put((String) f3877p.valueAt(i2), Integer.valueOf(i3));
            }
            size = i2;
        }
        size = f3878q.size();
        while (true) {
            i2 = size - 1;
            if (i2 < 0) {
                break;
            }
            long e3 = a2.m3661e(f3878q.keyAt(i2));
            if (e3 != -1) {
                contentValues.put((String) f3878q.valueAt(i2), Long.valueOf(e3));
            }
            size = i2;
        }
        SparseArray sparseArray = new SparseArray(f3866e.length);
        for (int i4 : f3866e) {
            int i42;
            obj2 = null;
            if (i42 == 137) {
                if (a2.m3659c(i42) != null) {
                    obj2 = new EncodedStringValue[]{a2.m3659c(i42)};
                }
            } else {
                obj2 = a2.m3660d(i42);
            }
            sparseArray.put(i42, obj2);
        }
        HashSet hashSet = new HashSet();
        size = genericPdu.m3593b();
        if (size == 130 || size == 132 || size == 128) {
            switch (size) {
                case 128:
                    m3708a(151, hashSet, sparseArray);
                    break;
                case 130:
                case 132:
                    m3708a(137, hashSet, sparseArray);
                    m3714a(hashSet, sparseArray, str);
                    break;
            }
            long j2 = -1;
            if (z) {
                if (hashSet.isEmpty()) {
                    BLog.b("PduPersister", "Empty recipients for Uri %s, skip this download", new Object[]{uri.toString()});
                    throw new MmsException("Asked to create thread id but got empty recipients");
                }
                a = Threads.a(this.f3879r, hashSet);
                if (a > 0) {
                    Cursor a3;
                    try {
                        a3 = SqliteWrapper.a(this.f3879r, this.f3880s, Uri.withAppendedPath(MmsSms.CONTENT_CONVERSATIONS_URI, String.valueOf(a)), f3863b, null, null, "normalized_date DESC LIMIT 1");
                        if (a3 != null) {
                            try {
                                if (a3.moveToFirst()) {
                                    contentValues.put("date", Long.valueOf(Math.max(a3.getLong(0) + 1000, System.currentTimeMillis()) / 1000));
                                }
                            } catch (Throwable th) {
                                e22 = th;
                                if (a3 != null) {
                                    a3.close();
                                }
                                throw e22;
                            }
                        }
                        if (a3 != null) {
                            a3.close();
                            j2 = a;
                        } else {
                            j2 = a;
                        }
                    } catch (Throwable th2) {
                        e22 = th2;
                        a3 = null;
                        if (a3 != null) {
                            a3.close();
                        }
                        throw e22;
                    }
                }
                j2 = a;
            }
            contentValues.put("thread_id", Long.valueOf(j2));
        }
        long currentTimeMillis = System.currentTimeMillis();
        obj2 = 1;
        i2 = 0;
        if (genericPdu instanceof MultimediaMessagePdu) {
            PduBody d = ((MultimediaMessagePdu) genericPdu).m3613d();
            if (d != null) {
                i42 = d.m3624b();
                if (i42 > 2) {
                    obj2 = null;
                }
                i3 = 0;
                while (i3 < i42) {
                    PduPart a4 = d.m3620a(i3);
                    int k = a4.m3698k() + i2;
                    m3699a(a4, currentTimeMillis, (Map) map);
                    String a5 = m3706a(a4);
                    if (!(a5 == null || "application/smil".equals(a5) || "text/plain".equals(a5))) {
                        obj2 = null;
                    }
                    i3++;
                    i2 = k;
                }
            }
        }
        int i5 = i2;
        Object obj3 = obj2;
        size = i5;
        if (Utils.m3588d()) {
            contentValues.put("text_only", Integer.valueOf(obj3 != null ? 1 : 0));
        }
        if (contentValues.getAsInteger("m_size") == null) {
            contentValues.put("m_size", Integer.valueOf(size));
        }
        if (Utils.m3589e()) {
            contentValues.put("sub_id", Integer.valueOf(i));
        } else if (-1 != i) {
            throw new MmsException("Incorrect subscription Id: " + i);
        }
        if (obj != null) {
            SqliteWrapper.a(this.f3879r, this.f3880s, uri, contentValues, null, null);
            uri2 = uri;
            a = j;
        } else {
            Uri a6 = SqliteWrapper.a(this.f3879r, this.f3880s, uri, contentValues);
            if (a6 == null) {
                throw new MmsException("persist() failed: return null.");
            }
            uri2 = a6;
            a = ContentUris.parseId(a6);
        }
        ContentValues contentValues2 = new ContentValues(1);
        contentValues2.put("mid", Long.valueOf(a));
        SqliteWrapper.a(this.f3879r, this.f3880s, Uri.parse("content://mms/" + currentTimeMillis + "/part"), contentValues2, null, null);
        if (obj == null) {
            uri2 = Uri.parse(uri + "/" + a);
        }
        for (int i6 : f3866e) {
            EncodedStringValue[] encodedStringValueArr = (EncodedStringValue[]) sparseArray.get(i6);
            if (encodedStringValueArr != null) {
                m3709a(a, i6, encodedStringValueArr);
            }
        }
        return uri2;
    }

    private static void m3708a(int i, HashSet<String> hashSet, SparseArray<EncodedStringValue[]> sparseArray) {
        EncodedStringValue[] encodedStringValueArr = (EncodedStringValue[]) sparseArray.get(i);
        if (encodedStringValueArr != null) {
            for (EncodedStringValue encodedStringValue : encodedStringValueArr) {
                if (encodedStringValue != null) {
                    String c = encodedStringValue.m3610c();
                    if (!hashSet.contains(c)) {
                        hashSet.add(c);
                    }
                }
            }
        }
    }

    private static void m3714a(HashSet<String> hashSet, SparseArray<EncodedStringValue[]> sparseArray, String str) {
        EncodedStringValue[] encodedStringValueArr = (EncodedStringValue[]) sparseArray.get(151);
        EncodedStringValue[] encodedStringValueArr2 = (EncodedStringValue[]) sparseArray.get(130);
        ArrayList arrayList = new ArrayList();
        if (encodedStringValueArr != null) {
            for (EncodedStringValue encodedStringValue : encodedStringValueArr) {
                if (encodedStringValue != null) {
                    arrayList.add(encodedStringValue.m3610c());
                }
            }
        }
        if (encodedStringValueArr2 != null) {
            for (EncodedStringValue encodedStringValue2 : encodedStringValueArr2) {
                if (encodedStringValue2 != null) {
                    arrayList.add(encodedStringValue2.m3610c());
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if ((TextUtils.isEmpty(str) || !PhoneNumberUtils.compare(str2, str)) && !hashSet.contains(str2)) {
                hashSet.add(str2);
            }
        }
    }

    public final Uri m3719a(Uri uri, Uri uri2) {
        long parseId = ContentUris.parseId(uri);
        if (parseId == -1) {
            throw new MmsException("Error! ID of the message: -1.");
        }
        Integer num = (Integer) f3868g.get(uri2);
        if (num == null) {
            throw new MmsException("Bad destination, must be one of content://mms/inbox, content://mms/sent, content://mms/drafts, content://mms/outbox, content://mms/temp.");
        }
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("msg_box", num);
        SqliteWrapper.a(this.f3879r, this.f3880s, uri, contentValues, null, null);
        return ContentUris.withAppendedId(uri2, parseId);
    }

    private static String m3707a(byte[] bArr) {
        try {
            return new String(bArr, "iso-8859-1");
        } catch (Throwable e) {
            BLog.b("PduPersister", "ISO_8859_1 must be supported!", e);
            return "";
        }
    }

    public static byte[] m3715a(String str) {
        try {
            return str.getBytes("iso-8859-1");
        } catch (Throwable e) {
            BLog.b("PduPersister", "ISO_8859_1 must be supported!", e);
            return new byte[0];
        }
    }

    public final void m3722a() {
        SqliteWrapper.a(this.f3879r, this.f3880s, Uri.parse("content://mms/9223372036854775807/part"), null, null);
    }

    public final Cursor m3718a(long j) {
        Builder buildUpon = PendingMessages.CONTENT_URI.buildUpon();
        buildUpon.appendQueryParameter("protocol", "mms");
        return SqliteWrapper.a(this.f3879r, this.f3880s, buildUpon.build(), null, "err_type < ? AND due_time <= ?", new String[]{"10", String.valueOf(j)}, "due_time");
    }

    public final String m3723b() {
        String line1Number = this.f3882u.getLine1Number();
        if (TextUtils.isEmpty(line1Number)) {
            return this.f3881t;
        }
        return line1Number;
    }
}
