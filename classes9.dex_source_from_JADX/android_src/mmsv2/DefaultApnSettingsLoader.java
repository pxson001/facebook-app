package android_src.mmsv2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.provider.Telephony.Carriers;
import android.text.TextUtils;
import android.util.SparseArray;
import com.facebook.debug.log.BLog;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: setVertexAttribArray */
public class DefaultApnSettingsLoader {
    private static final String[] f3753a = new String[]{"type", "mmsc", "mmsproxy", "mmsport"};
    private final Context f3754b;
    private final SparseArray<List<ApnSettingsLoader$Apn>> f3755c = new SparseArray();

    /* compiled from: setVertexAttribArray */
    public class C03361 {
        final /* synthetic */ int[] f3744a;
        final /* synthetic */ String f3745b;
        final /* synthetic */ List f3746c;
        final /* synthetic */ DefaultApnSettingsLoader f3747d;

        C03361(DefaultApnSettingsLoader defaultApnSettingsLoader, int[] iArr, String str, List list) {
            this.f3747d = defaultApnSettingsLoader;
            this.f3744a = iArr;
            this.f3745b = str;
            this.f3746c = list;
        }

        public final void m3480a(ContentValues contentValues) {
            String d = DefaultApnSettingsLoader.m3496d(contentValues.getAsString("mcc"));
            String d2 = DefaultApnSettingsLoader.m3496d(contentValues.getAsString("mnc"));
            String d3 = DefaultApnSettingsLoader.m3496d(contentValues.getAsString("apn"));
            try {
                if (this.f3744a[0] != Integer.parseInt(d) || this.f3744a[1] != Integer.parseInt(d2)) {
                    return;
                }
                if (TextUtils.isEmpty(this.f3745b) || this.f3745b.equalsIgnoreCase(d3)) {
                    MemoryApn a = MemoryApn.m3486a(this.f3746c, contentValues.getAsString("type"), contentValues.getAsString("mmsc"), contentValues.getAsString("mmsproxy"), contentValues.getAsString("mmsport"));
                    if (a != null) {
                        this.f3746c.add(a);
                    }
                }
            } catch (NumberFormatException e) {
            }
        }
    }

    /* compiled from: setVertexAttribArray */
    public class BaseApn implements ApnSettingsLoader$Apn {
        public final String f3748a;
        public final String f3749b;
        public final int f3750c;

        public static BaseApn m3481a(String str, String str2, String str3, String str4) {
            int i = 80;
            if (!DefaultApnSettingsLoader.m3493a(DefaultApnSettingsLoader.m3496d(str), "mms")) {
                return null;
            }
            Object d = DefaultApnSettingsLoader.m3496d(str2);
            if (TextUtils.isEmpty(d)) {
                return null;
            }
            String e = DefaultApnSettingsLoader.m3497e(d);
            try {
                URI uri = new URI(e);
                String d2 = DefaultApnSettingsLoader.m3496d(str3);
                if (!TextUtils.isEmpty(d2)) {
                    String e2 = DefaultApnSettingsLoader.m3497e(d2);
                    d2 = DefaultApnSettingsLoader.m3496d(str4);
                    if (d2 != null) {
                        try {
                            int parseInt = Integer.parseInt(d2);
                            if (parseInt > 0) {
                                i = parseInt;
                            }
                            d2 = e2;
                        } catch (NumberFormatException e3) {
                        }
                    }
                    d2 = e2;
                }
                return new BaseApn(e, d2, i);
            } catch (URISyntaxException e4) {
                return null;
            }
        }

        private BaseApn(String str, String str2, int i) {
            this.f3748a = str;
            this.f3749b = str2;
            this.f3750c = i;
        }

        public final String mo113a() {
            return this.f3748a;
        }

        public final String mo114b() {
            return this.f3749b;
        }

        public final int mo115c() {
            return this.f3750c;
        }

        public final void mo116d() {
        }
    }

    /* compiled from: setVertexAttribArray */
    public class MemoryApn implements ApnSettingsLoader$Apn {
        private final List<ApnSettingsLoader$Apn> f3751a;
        public final BaseApn f3752b;

        public static MemoryApn m3486a(List<ApnSettingsLoader$Apn> list, String str, String str2, String str3, String str4) {
            if (list == null) {
                return null;
            }
            BaseApn a = BaseApn.m3481a(str, str2, str3, str4);
            if (a == null) {
                return null;
            }
            for (ApnSettingsLoader$Apn apnSettingsLoader$Apn : list) {
                if (apnSettingsLoader$Apn instanceof MemoryApn) {
                    Object obj;
                    MemoryApn memoryApn = (MemoryApn) apnSettingsLoader$Apn;
                    if (a == null) {
                        obj = null;
                    } else {
                        BaseApn baseApn = memoryApn.f3752b;
                        Object obj2 = (TextUtils.equals(baseApn.f3748a, a.mo113a()) && TextUtils.equals(baseApn.f3749b, a.mo114b()) && baseApn.f3750c == a.mo115c()) ? 1 : null;
                        obj = obj2;
                    }
                    if (obj != null) {
                        return null;
                    }
                }
            }
            return new MemoryApn(list, a);
        }

        private MemoryApn(List<ApnSettingsLoader$Apn> list, BaseApn baseApn) {
            this.f3751a = list;
            this.f3752b = baseApn;
        }

        public final String mo113a() {
            return this.f3752b.mo113a();
        }

        public final String mo114b() {
            return this.f3752b.mo114b();
        }

        public final int mo115c() {
            return this.f3752b.mo115c();
        }

        public final void mo116d() {
            Object obj = null;
            synchronized (this.f3751a) {
                if (this.f3751a.get(0) != this) {
                    this.f3751a.remove(this);
                    this.f3751a.add(0, this);
                    obj = 1;
                }
            }
            if (obj != null) {
                new StringBuilder("Set APN [MMSC=").append(mo113a()).append(", PROXY=").append(mo114b()).append(", PORT=").append(mo115c()).append("] to be first");
            }
        }
    }

    private void m3495c(int r5, java.lang.String r6, java.util.List<android_src.mmsv2.ApnSettingsLoader$Apn> r7) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = new java.lang.StringBuilder;
        r1 = "Loading APNs from resources, apnName=";
        r0.<init>(r1);
        r0.append(r6);
        r0 = r4.f3754b;
        r0 = android_src.mmsv2.Utils.m3584a(r0, r5);
        r1 = 0;
        r1 = r0[r1];
        if (r1 != 0) goto L_0x0022;
    L_0x0015:
        r1 = 1;
        r1 = r0[r1];
        if (r1 != 0) goto L_0x0022;
    L_0x001a:
        r0 = "MmsLib";
        r1 = "Can not get valid mcc/mnc from system";
        com.facebook.debug.log.BLog.b(r0, r1);
    L_0x0021:
        return;
    L_0x0022:
        r1 = 0;
        r2 = r4.f3754b;	 Catch:{ NotFoundException -> 0x0042, all -> 0x0050 }
        r2 = r2.getResources();	 Catch:{ NotFoundException -> 0x0042, all -> 0x0050 }
        r3 = 2131099648; // 0x7f060000 float:1.7811655E38 double:1.052903124E-314;	 Catch:{ NotFoundException -> 0x0042, all -> 0x0050 }
        r1 = r2.getXml(r3);	 Catch:{ NotFoundException -> 0x0042, all -> 0x0050 }
        r2 = new android_src.mmsv2.ApnsXmlParser;	 Catch:{ NotFoundException -> 0x0042, all -> 0x0050 }
        r3 = new android_src.mmsv2.DefaultApnSettingsLoader$1;	 Catch:{ NotFoundException -> 0x0042, all -> 0x0050 }
        r3.<init>(r4, r0, r6, r7);	 Catch:{ NotFoundException -> 0x0042, all -> 0x0050 }
        r2.<init>(r1, r3);	 Catch:{ NotFoundException -> 0x0042, all -> 0x0050 }
        r2.m3473c();	 Catch:{ NotFoundException -> 0x0042, all -> 0x0050 }
        if (r1 == 0) goto L_0x0021;
    L_0x003e:
        r1.close();
        goto L_0x0021;
    L_0x0042:
        r0 = move-exception;
        r2 = "MmsLib";	 Catch:{ NotFoundException -> 0x0042, all -> 0x0050 }
        r3 = "Can not get apns.xml ";	 Catch:{ NotFoundException -> 0x0042, all -> 0x0050 }
        com.facebook.debug.log.BLog.a(r2, r3, r0);	 Catch:{ NotFoundException -> 0x0042, all -> 0x0050 }
        if (r1 == 0) goto L_0x0021;
    L_0x004c:
        r1.close();
        goto L_0x0021;
    L_0x0050:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0056;
    L_0x0053:
        r1.close();
    L_0x0056:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android_src.mmsv2.DefaultApnSettingsLoader.c(int, java.lang.String, java.util.List):void");
    }

    DefaultApnSettingsLoader(Context context) {
        this.f3754b = context;
    }

    public final List<ApnSettingsLoader$Apn> m3498a(String str) {
        List<ApnSettingsLoader$Apn> list;
        int i;
        int b = Utils.m3585b(-1);
        synchronized (this) {
            list = (List) this.f3755c.get(b);
            if (list == null) {
                list = new ArrayList();
                this.f3755c.put(b, list);
                m3492a(b, str, (List) list);
                i = 1;
            } else {
                i = 0;
            }
        }
        if (i != 0) {
            new StringBuilder("Loaded ").append(list.size()).append(" APNs");
        }
        if (list.isEmpty()) {
            int[] a = Utils.m3584a(this.f3754b, b);
            BLog.c("MmsLib", "Failed to load APN for %s. MCC: %d MNC: %d", new Object[]{str, Integer.valueOf(a[0]), Integer.valueOf(a[1])});
        }
        return list;
    }

    private void m3492a(int i, String str, List<ApnSettingsLoader$Apn> list) {
        m3494b(i, str, list);
        if (list.size() <= 0) {
            m3495c(i, str, list);
            if (list.size() <= 0) {
                m3495c(i, null, list);
            }
        }
    }

    private void m3494b(int i, String str, List<ApnSettingsLoader$Apn> list) {
        Uri uri;
        if (!Utils.m3587b() || i == -1) {
            uri = Carriers.CONTENT_URI;
        } else {
            uri = Uri.withAppendedPath(Carriers.CONTENT_URI, "/subId/" + i);
        }
        try {
            Cursor a = m3491a(uri, true, str);
            if (a == null) {
                a = m3491a(uri, false, str);
                if (a == null) {
                    a = m3491a(uri, true, null);
                    if (a == null) {
                        a = m3491a(uri, false, null);
                    }
                }
            }
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        BaseApn a2 = BaseApn.m3481a(a.getString(0), a.getString(1), a.getString(2), a.getString(3));
                        if (a2 != null) {
                            list.add(a2);
                        }
                    }
                    a.close();
                } catch (Throwable th) {
                    a.close();
                }
            }
        } catch (SecurityException e) {
        }
    }

    private Cursor m3491a(Uri uri, boolean z, String str) {
        String[] strArr;
        new StringBuilder("Loading APNs from system, checkCurrent=").append(z).append(" apnName=").append(str);
        StringBuilder stringBuilder = new StringBuilder();
        if (z) {
            stringBuilder.append("current IS NOT NULL");
        }
        Object d = m3496d(str);
        if (TextUtils.isEmpty(d)) {
            strArr = null;
        } else {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" AND ");
            }
            stringBuilder.append("apn=?");
            strArr = new String[]{d};
        }
        try {
            Cursor query = this.f3754b.getContentResolver().query(uri, f3753a, stringBuilder.toString(), strArr, null);
            if (query != null && query.getCount() > 0) {
                return query;
            }
            String str2;
            if (query != null) {
                query.close();
            }
            String str3 = "MmsLib";
            StringBuilder append = new StringBuilder("Query ").append(uri).append(" with apn ").append(d).append(" and ");
            if (z) {
                str2 = "checking CURRENT";
            } else {
                str2 = "not checking CURRENT";
            }
            BLog.a(str3, append.append(str2).append(" returned empty").toString());
            return null;
        } catch (SQLiteException e) {
            BLog.a("MmsLib", "APN table query exception: " + e);
            return null;
        } catch (SecurityException e2) {
            BLog.a("MmsLib", "Platform restricts APN table access: " + e2);
            throw e2;
        }
    }

    public static String m3496d(String str) {
        return str != null ? str.trim() : null;
    }

    public static String m3497e(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\.");
        if (split.length != 4) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(16);
        int i = 0;
        while (i < 4) {
            try {
                if (split[i].length() > 3) {
                    return str;
                }
                stringBuilder.append(Integer.parseInt(split[i]));
                if (i < 3) {
                    stringBuilder.append('.');
                }
                i++;
            } catch (NumberFormatException e) {
                return str;
            }
        }
        return stringBuilder.toString();
    }

    public static boolean m3493a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        for (String str3 : str.split(",")) {
            if (str3.equals(str2) || str3.equals("*")) {
                return true;
            }
        }
        return false;
    }
}
