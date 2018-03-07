package com.facebook.messaging.sms;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android_src.provider.Telephony.Mms;
import android_src.provider.Telephony.Sms;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.ConjunctionExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.debug.log.BLog;
import javax.inject.Inject;

@TargetApi(19)
/* compiled from: complete_oauth */
public class SmsSpecialThreadManager {
    private static final String[] f17478a = new String[]{"_id", "read"};
    private static final ContentValues f17479b = new ContentValues(2);
    private static final ContentValues f17480c = new ContentValues(1);
    private final ContentResolver f17481d;

    static {
        f17479b.put("read", "1");
        f17479b.put("seen", "1");
        f17480c.put("read", "0");
    }

    @Inject
    public SmsSpecialThreadManager(ContentResolver contentResolver) {
        this.f17481d = contentResolver;
    }

    public final void m17460a(long j) {
        Cursor query;
        Throwable e;
        Cursor cursor = null;
        Expression[] expressionArr = new Expression[2];
        expressionArr[0] = SqlExpression.a("thread_id", String.valueOf(j));
        expressionArr[1] = SqlExpression.b(new Expression[]{SqlExpression.a("read", "0"), SqlExpression.a("seen", "0")});
        ConjunctionExpression a = SqlExpression.a(expressionArr);
        try {
            query = this.f17481d.query(Sms.a, f17478a, a.a(), a.b(), "_id DESC LIMIT 1");
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        Long.valueOf(j);
                        this.f17481d.update(Sms.a, f17479b, a.a(), a.b());
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        BLog.b("SmsSpecialThreadManager", e, "Failed to query unread SMS messages in thread %d", new Object[]{Long.valueOf(j)});
                        if (query != null) {
                            query.close();
                            query = this.f17481d.query(Mms.a, f17478a, a.a(), a.b(), "_id DESC LIMIT 1");
                            if (query != null) {
                                try {
                                    if (query.moveToNext()) {
                                        Long.valueOf(j);
                                        this.f17481d.update(Mms.a, f17479b, a.a(), a.b());
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    try {
                                        BLog.b("SmsSpecialThreadManager", e, "Failed to query unread MMS messages in thread %d", new Object[]{Long.valueOf(j)});
                                        if (query != null) {
                                            query.close();
                                        }
                                    } catch (Throwable th) {
                                        e = th;
                                        if (query != null) {
                                            query.close();
                                        }
                                        throw e;
                                    }
                                }
                            }
                            if (query != null) {
                                query.close();
                            }
                        }
                        cursor = query;
                        query = this.f17481d.query(Mms.a, f17478a, a.a(), a.b(), "_id DESC LIMIT 1");
                        if (query != null) {
                            if (query.moveToNext()) {
                                Long.valueOf(j);
                                this.f17481d.update(Mms.a, f17479b, a.a(), a.b());
                            }
                        }
                        if (query != null) {
                            query.close();
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw e;
                    }
                }
            }
            if (query != null) {
                query.close();
                query = this.f17481d.query(Mms.a, f17478a, a.a(), a.b(), "_id DESC LIMIT 1");
                if (query != null) {
                    if (query.moveToNext()) {
                        Long.valueOf(j);
                        this.f17481d.update(Mms.a, f17479b, a.a(), a.b());
                    }
                }
                if (query != null) {
                    query.close();
                }
            }
        } catch (Exception e4) {
            e = e4;
            query = null;
            BLog.b("SmsSpecialThreadManager", e, "Failed to query unread SMS messages in thread %d", new Object[]{Long.valueOf(j)});
            if (query != null) {
                query.close();
                query = this.f17481d.query(Mms.a, f17478a, a.a(), a.b(), "_id DESC LIMIT 1");
                if (query != null) {
                    if (query.moveToNext()) {
                        Long.valueOf(j);
                        this.f17481d.update(Mms.a, f17479b, a.a(), a.b());
                    }
                }
                if (query != null) {
                    query.close();
                }
            }
            cursor = query;
            query = this.f17481d.query(Mms.a, f17478a, a.a(), a.b(), "_id DESC LIMIT 1");
            if (query != null) {
                if (query.moveToNext()) {
                    Long.valueOf(j);
                    this.f17481d.update(Mms.a, f17479b, a.a(), a.b());
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th3) {
            e = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
        cursor = query;
        try {
            query = this.f17481d.query(Mms.a, f17478a, a.a(), a.b(), "_id DESC LIMIT 1");
            if (query != null) {
                if (query.moveToNext()) {
                    Long.valueOf(j);
                    this.f17481d.update(Mms.a, f17479b, a.a(), a.b());
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e5) {
            e = e5;
            query = cursor;
            BLog.b("SmsSpecialThreadManager", e, "Failed to query unread MMS messages in thread %d", new Object[]{Long.valueOf(j)});
            if (query != null) {
                query.close();
            }
        } catch (Throwable th4) {
            e = th4;
            query = cursor;
            if (query != null) {
                query.close();
            }
            throw e;
        }
    }

    public final void m17461b(long j) {
        Cursor query;
        Throwable e;
        Cursor cursor = null;
        ConjunctionExpression a = SqlExpression.a(new Expression[]{SqlExpression.a("thread_id", String.valueOf(j)), SqlExpression.a("read", "1")});
        try {
            query = this.f17481d.query(Sms.a, f17478a, a.a(), a.b(), "_id DESC LIMIT 1");
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        Long.valueOf(j);
                        this.f17481d.update(Sms.a, f17480c, a.a(), a.b());
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        BLog.b("SmsSpecialThreadManager", e, "Failed to query read SMS messages in thread %d", new Object[]{Long.valueOf(j)});
                        if (query != null) {
                            query.close();
                            query = this.f17481d.query(Mms.a, f17478a, a.a(), a.b(), "_id DESC LIMIT 1");
                            if (query != null) {
                                try {
                                    if (query.moveToNext()) {
                                        Long.valueOf(j);
                                        this.f17481d.update(Mms.a, f17480c, a.a(), a.b());
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    try {
                                        BLog.b("SmsSpecialThreadManager", e, "Failed to query read MMS messages in thread %d", new Object[]{Long.valueOf(j)});
                                        if (query != null) {
                                            query.close();
                                        }
                                    } catch (Throwable th) {
                                        e = th;
                                        if (query != null) {
                                            query.close();
                                        }
                                        throw e;
                                    }
                                }
                            }
                            if (query != null) {
                                query.close();
                            }
                        }
                        cursor = query;
                        query = this.f17481d.query(Mms.a, f17478a, a.a(), a.b(), "_id DESC LIMIT 1");
                        if (query != null) {
                            if (query.moveToNext()) {
                                Long.valueOf(j);
                                this.f17481d.update(Mms.a, f17480c, a.a(), a.b());
                            }
                        }
                        if (query != null) {
                            query.close();
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw e;
                    }
                }
            }
            if (query != null) {
                query.close();
                query = this.f17481d.query(Mms.a, f17478a, a.a(), a.b(), "_id DESC LIMIT 1");
                if (query != null) {
                    if (query.moveToNext()) {
                        Long.valueOf(j);
                        this.f17481d.update(Mms.a, f17480c, a.a(), a.b());
                    }
                }
                if (query != null) {
                    query.close();
                }
            }
        } catch (Exception e4) {
            e = e4;
            query = null;
            BLog.b("SmsSpecialThreadManager", e, "Failed to query read SMS messages in thread %d", new Object[]{Long.valueOf(j)});
            if (query != null) {
                query.close();
                query = this.f17481d.query(Mms.a, f17478a, a.a(), a.b(), "_id DESC LIMIT 1");
                if (query != null) {
                    if (query.moveToNext()) {
                        Long.valueOf(j);
                        this.f17481d.update(Mms.a, f17480c, a.a(), a.b());
                    }
                }
                if (query != null) {
                    query.close();
                }
            }
            cursor = query;
            query = this.f17481d.query(Mms.a, f17478a, a.a(), a.b(), "_id DESC LIMIT 1");
            if (query != null) {
                if (query.moveToNext()) {
                    Long.valueOf(j);
                    this.f17481d.update(Mms.a, f17480c, a.a(), a.b());
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th3) {
            e = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
        cursor = query;
        try {
            query = this.f17481d.query(Mms.a, f17478a, a.a(), a.b(), "_id DESC LIMIT 1");
            if (query != null) {
                if (query.moveToNext()) {
                    Long.valueOf(j);
                    this.f17481d.update(Mms.a, f17480c, a.a(), a.b());
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e5) {
            e = e5;
            query = cursor;
            BLog.b("SmsSpecialThreadManager", e, "Failed to query read MMS messages in thread %d", new Object[]{Long.valueOf(j)});
            if (query != null) {
                query.close();
            }
        } catch (Throwable th4) {
            e = th4;
            query = cursor;
            if (query != null) {
                query.close();
            }
            throw e;
        }
    }

    public final void m17462c(long j) {
        Expression a = SqlExpression.a("thread_id", String.valueOf(j));
        try {
            Long.valueOf(j);
            this.f17481d.delete(Sms.a, a.a(), a.b());
        } catch (Throwable e) {
            BLog.b("SmsSpecialThreadManager", e, "Failed to delete SMS messages in thread %d", new Object[]{Long.valueOf(j)});
        }
        try {
            Long.valueOf(j);
            this.f17481d.delete(Mms.a, a.a(), a.b());
        } catch (Throwable e2) {
            BLog.b("SmsSpecialThreadManager", e2, "Failed to delete MMS messages in thread %d", new Object[]{Long.valueOf(j)});
        }
    }
}
