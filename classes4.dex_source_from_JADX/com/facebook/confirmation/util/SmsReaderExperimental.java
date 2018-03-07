package com.facebook.confirmation.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android_src.provider.Telephony$Mms;
import android_src.provider.Telephony$Mms.Inbox;
import android_src.provider.Telephony$Sms$Inbox;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.confirmation.task.SimpleSmsMessage;
import com.facebook.inject.InjectorLike;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fbTraceNode */
public class SmsReaderExperimental {
    private static final String f12064a = (Telephony$Mms.f12071a + "/%d/addr");
    private static final Uri f12065b = Inbox.f12076a;
    private static final String f12066c = (Telephony$Mms.f12071a + "/part");
    private static final String f12067d = (f12066c + "/%d");
    private static final Uri f12068e = Telephony$Sms$Inbox.f12077a;
    private final ContentResolver f12069f;
    private final RuntimePermissionsUtil f12070g;

    private static SmsReaderExperimental m12746a(InjectorLike injectorLike) {
        return new SmsReaderExperimental(ContentResolverMethodAutoProvider.b(injectorLike), RuntimePermissionsUtil.b(injectorLike));
    }

    @Inject
    public SmsReaderExperimental(ContentResolver contentResolver, RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f12069f = contentResolver;
        this.f12070g = runtimePermissionsUtil;
    }

    public final SmsReaderPointer m12755a() {
        Throwable th;
        Cursor cursor;
        Cursor cursor2 = null;
        if (!m12753b()) {
            return new SmsReaderPointer(-1, -1);
        }
        try {
            long j;
            long j2;
            cursor2 = this.f12069f.query(f12068e, new String[]{"_id"}, null, null, "_id DESC LIMIT 1");
            if (cursor2 != null) {
                try {
                    if (cursor2.getCount() > 0) {
                        cursor2.moveToFirst();
                        j = cursor2.getLong(0);
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        cursor2 = this.f12069f.query(f12065b, new String[]{"_id"}, null, null, "_id DESC LIMIT 1");
                        if (cursor2 != null || cursor2.getCount() <= 0) {
                            j2 = -1;
                        } else {
                            cursor2.moveToFirst();
                            j2 = cursor2.getLong(0);
                        }
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        return new SmsReaderPointer(j, j2);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursor2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            j = -1;
            if (cursor2 != null) {
                cursor2.close();
            }
            try {
                cursor2 = this.f12069f.query(f12065b, new String[]{"_id"}, null, null, "_id DESC LIMIT 1");
                if (cursor2 != null) {
                }
                j2 = -1;
                if (cursor2 != null) {
                    cursor2.close();
                }
                return new SmsReaderPointer(j, j2);
            } catch (Throwable th3) {
                if (cursor2 != null) {
                    cursor2.close();
                }
            }
        } catch (Throwable th4) {
            th = th4;
            cursor = cursor2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List<SimpleSmsMessage> m12756b(SmsReaderPointer smsReaderPointer) {
        List<SimpleSmsMessage> arrayList = new ArrayList();
        arrayList.addAll(mo902a(smsReaderPointer));
        arrayList.addAll(m12754c(smsReaderPointer));
        return arrayList;
    }

    private boolean m12753b() {
        return this.f12070g.a("android.permission.READ_SMS");
    }

    private List<SimpleSmsMessage> mo902a(SmsReaderPointer smsReaderPointer) {
        Cursor query;
        Throwable th;
        if (!m12753b()) {
            return new ArrayList();
        }
        try {
            query = this.f12069f.query(f12068e, new String[]{"_id", "date", "address", "body"}, "_id > ?", new String[]{String.valueOf(smsReaderPointer.smsId)}, "_id DESC LIMIT 1000");
            try {
                List<SimpleSmsMessage> a = m12750a(smsReaderPointer, query);
                if (query != null) {
                    query.close();
                }
                if (a == null) {
                    return new ArrayList();
                }
                return a;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    @Nullable
    private static List<SimpleSmsMessage> m12750a(SmsReaderPointer smsReaderPointer, Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        List<SimpleSmsMessage> arrayList = new ArrayList();
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("date");
        int columnIndex3 = cursor.getColumnIndex("address");
        int columnIndex4 = cursor.getColumnIndex("body");
        while (cursor.moveToNext()) {
            long j = cursor.getLong(columnIndex);
            long j2 = cursor.getLong(columnIndex2);
            String string = cursor.getString(columnIndex3);
            Object string2 = cursor.getString(columnIndex4);
            if (j > smsReaderPointer.smsId) {
                smsReaderPointer.smsId = j;
            }
            if (!StringUtil.c(string2)) {
                arrayList.add(new SimpleSmsMessage(j, j2, string, string2));
            }
        }
        return arrayList;
    }

    private List<SimpleSmsMessage> m12754c(SmsReaderPointer smsReaderPointer) {
        Throwable th;
        if (!m12753b()) {
            return new ArrayList();
        }
        Cursor query;
        try {
            query = this.f12069f.query(f12065b, new String[]{"_id", "date"}, "_id > ?", new String[]{String.valueOf(smsReaderPointer.mmsId)}, "_id DESC LIMIT 1000");
            try {
                List<SimpleSmsMessage> b = m12752b(smsReaderPointer, query);
                if (query != null) {
                    query.close();
                }
                if (b == null) {
                    return new ArrayList();
                }
                return b;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    @Nullable
    private List<SimpleSmsMessage> m12752b(SmsReaderPointer smsReaderPointer, Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        List<SimpleSmsMessage> arrayList = new ArrayList();
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("date");
        while (cursor.moveToNext()) {
            long j = cursor.getLong(columnIndex);
            long j2 = cursor.getLong(columnIndex2);
            if (j > smsReaderPointer.mmsId) {
                smsReaderPointer.mmsId = j;
            }
            String a = m12747a(j);
            Object b = m12751b(j);
            if (!StringUtil.c(b)) {
                arrayList.add(new SimpleSmsMessage(j, j2, a, b));
            }
        }
        return arrayList;
    }

    @Nullable
    private String m12747a(long j) {
        Throwable th;
        String str = null;
        Cursor query;
        try {
            query = this.f12069f.query(Uri.parse(StringFormatUtil.formatStrLocaleSafe(f12064a, Long.valueOf(j))), new String[]{"address"}, "msg_id = ?", new String[]{String.valueOf(j)}, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        query.moveToFirst();
                        str = query.getString(0);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    @Nullable
    private String m12751b(long j) {
        Throwable th;
        String str = null;
        Cursor query;
        try {
            query = this.f12069f.query(Uri.parse(f12066c), new String[]{"_id", "ct", "_data", "text"}, "mid = ?", new String[]{String.valueOf(j)}, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        int columnIndex = query.getColumnIndex("_id");
                        int columnIndex2 = query.getColumnIndex("ct");
                        int columnIndex3 = query.getColumnIndex("_data");
                        int columnIndex4 = query.getColumnIndex("text");
                        String str2 = null;
                        while (query.moveToNext()) {
                            long j2 = query.getLong(columnIndex);
                            if ("text/plain".equals(query.getString(columnIndex2))) {
                                if (query.getString(columnIndex3) != null) {
                                    str2 = m12748a(Long.valueOf(j2));
                                } else {
                                    str2 = query.getString(columnIndex4);
                                }
                            }
                        }
                        str = str2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    @Nullable
    private String m12748a(Long l) {
        InputStream openInputStream;
        Throwable th;
        String str = null;
        try {
            openInputStream = this.f12069f.openInputStream(Uri.parse(StringFormatUtil.formatStrLocaleSafe(f12067d, l)));
            if (openInputStream != null) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openInputStream, "UTF-8"));
                    StringBuilder stringBuilder = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuilder.append(readLine);
                    }
                    str = stringBuilder.toString();
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (IOException e2) {
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } else if (openInputStream != null) {
                try {
                    openInputStream.close();
                } catch (IOException e5) {
                }
            }
        } catch (IOException e6) {
            openInputStream = null;
            if (openInputStream != null) {
                openInputStream.close();
            }
            return str;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            openInputStream = null;
            th = th4;
            if (openInputStream != null) {
                openInputStream.close();
            }
            throw th;
        }
        return str;
    }
}
