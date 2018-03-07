package com.facebook.messaging.sms.defaultapp.send;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.util.LongSparseArray;
import android_src.provider.Telephony.Mms.Outbox;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.cursors.CachedColumnNameCursorProvider;
import com.facebook.common.cursors.CursorHelper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.sms.common.MmsSmsIdUtils;
import com.facebook.messaging.sms.defaultapp.SmsReceiver;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UserScoped
/* compiled from: com.facebook.orca.extra.METADATA */
public class MmsSmsPendingSendQueue {
    private static final String[] f17681a = new String[]{"_id", "thread_id", "date"};
    private static final Uri f17682b = Uri.parse("content://sms/queued");
    private static final Comparator<PendingSendMessage> f17683c = new C20881();
    private static final Object f17684k = new Object();
    public final LongSparseArray<String> f17685d = new LongSparseArray();
    private final Queue<PendingSendMessage> f17686e = new LinkedList();
    private final Context f17687f;
    private final Clock f17688g;
    private final CachedColumnNameCursorProvider f17689h;
    private boolean f17690i = true;
    private boolean f17691j;

    /* compiled from: com.facebook.orca.extra.METADATA */
    final class C20881 implements Comparator<PendingSendMessage> {
        C20881() {
        }

        public final int compare(Object obj, Object obj2) {
            return (int) (((PendingSendMessage) obj).f17705c - ((PendingSendMessage) obj2).f17705c);
        }
    }

    private static MmsSmsPendingSendQueue m17645b(InjectorLike injectorLike) {
        return new MmsSmsPendingSendQueue((Context) injectorLike.getInstance(Context.class), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (CachedColumnNameCursorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CachedColumnNameCursorProvider.class));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sms.defaultapp.send.MmsSmsPendingSendQueue m17644a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f17684k;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m17645b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f17684k;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sms.defaultapp.send.MmsSmsPendingSendQueue) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sms.defaultapp.send.MmsSmsPendingSendQueue) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f17684k;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sms.defaultapp.send.MmsSmsPendingSendQueue) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.defaultapp.send.MmsSmsPendingSendQueue.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sms.defaultapp.send.MmsSmsPendingSendQueue");
    }

    @Inject
    public MmsSmsPendingSendQueue(Context context, Clock clock, CachedColumnNameCursorProvider cachedColumnNameCursorProvider) {
        this.f17687f = context;
        this.f17688g = clock;
        this.f17689h = cachedColumnNameCursorProvider;
    }

    public final synchronized void m17652a(String str, long j) {
        this.f17690i = true;
        this.f17685d.b(j, str);
        m17646c();
    }

    public final synchronized void m17654b(String str, long j) {
        this.f17691j = false;
        PendingSendMessage pendingSendMessage = (PendingSendMessage) this.f17686e.poll();
        if (pendingSendMessage == null || !pendingSendMessage.m17663a().equals(str)) {
            m17650a();
        } else {
            String str2 = (String) this.f17685d.a(j);
            if (str2 != null && StringUtil.a(str2, str)) {
                this.f17685d.c(j);
            }
        }
        m17646c();
    }

    private void m17646c() {
        this.f17687f.sendBroadcast(new Intent("com.facebook.messaging.sms.REQUEST_SEND_MESSAGE", null, this.f17687f, SmsReceiver.class));
    }

    public final synchronized void m17650a() {
        this.f17686e.clear();
        this.f17685d.b();
        this.f17690i = true;
        this.f17691j = false;
    }

    public final synchronized void m17651a(PendingSendMessage pendingSendMessage) {
        this.f17691j = false;
        PendingSendMessage pendingSendMessage2 = (PendingSendMessage) this.f17686e.peek();
        if (pendingSendMessage2 == null || !pendingSendMessage2.m17663a().equals(pendingSendMessage.m17663a())) {
            m17650a();
        } else {
            pendingSendMessage2.m17668g();
        }
        m17646c();
    }

    @Nullable
    public final synchronized PendingSendMessage m17653b() {
        PendingSendMessage pendingSendMessage;
        if (this.f17691j) {
            pendingSendMessage = null;
        } else {
            pendingSendMessage = (PendingSendMessage) this.f17686e.peek();
            if (pendingSendMessage == null && this.f17690i) {
                m17647d();
                pendingSendMessage = (PendingSendMessage) this.f17686e.peek();
            }
            if (pendingSendMessage != null) {
                this.f17691j = true;
                if (this.f17688g.a() - pendingSendMessage.m17665c() > 3600000) {
                    pendingSendMessage.m17667f();
                }
            } else {
                pendingSendMessage = null;
            }
        }
        return pendingSendMessage;
    }

    private void m17647d() {
        m17650a();
        this.f17690i = false;
        m17648e();
        m17649f();
        Collections.sort((LinkedList) this.f17686e, f17683c);
        for (PendingSendMessage pendingSendMessage : this.f17686e) {
            this.f17685d.b(pendingSendMessage.f17704b, pendingSendMessage.f17703a);
        }
    }

    private void m17648e() {
        Cursor a;
        Throwable e;
        Cursor query;
        try {
            query = this.f17687f.getContentResolver().query(f17682b, f17681a, "date>=" + String.valueOf(this.f17688g.a() - 86400000), null, "date ASC");
            if (query != null) {
                try {
                    a = CachedColumnNameCursorProvider.a(query);
                    while (a.moveToNext()) {
                        try {
                            long b = CursorHelper.b(a, "_id");
                            this.f17686e.offer(new PendingSendMessage(MmsSmsIdUtils.m17498a(b), CursorHelper.b(a, "thread_id"), CursorHelper.b(a, "date"), 0));
                        } catch (Exception e2) {
                            e = e2;
                            query = a;
                        } catch (Throwable th) {
                            e = th;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        BLog.b("MmsSmsPendingSendQueue", e, "Exception in constructing queue for sms pending messages.", new Object[0]);
                        if (query != null) {
                            query.close();
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        a = query;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                } catch (Throwable th3) {
                    e = th3;
                    a = query;
                    if (a != null) {
                        a.close();
                    }
                    throw e;
                }
            }
            a = query;
            if (a != null) {
                a.close();
            }
        } catch (Exception e4) {
            e = e4;
            query = null;
            BLog.b("MmsSmsPendingSendQueue", e, "Exception in constructing queue for sms pending messages.", new Object[0]);
            if (query != null) {
                query.close();
            }
        } catch (Throwable th4) {
            e = th4;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
    }

    private void m17649f() {
        Cursor query;
        Cursor a;
        Throwable e;
        try {
            query = this.f17687f.getContentResolver().query(Outbox.a, f17681a, "(st IS NULL OR st!=135) AND date>=?", new String[]{String.valueOf((this.f17688g.a() - 86400000) / 1000)}, "date ASC");
            if (query != null) {
                try {
                    a = CachedColumnNameCursorProvider.a(query);
                    while (a.moveToNext()) {
                        try {
                            long b = CursorHelper.b(a, "_id");
                            this.f17686e.offer(new PendingSendMessage(MmsSmsIdUtils.m17501b(b), CursorHelper.b(a, "thread_id"), CursorHelper.b(a, "date") * 1000, 0));
                        } catch (Exception e2) {
                            e = e2;
                            query = a;
                        } catch (Throwable th) {
                            e = th;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        BLog.b("MmsSmsPendingSendQueue", e, "Exception in constructing queue for mms pending messages.", new Object[0]);
                        if (query != null) {
                            query.close();
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        a = query;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                } catch (Throwable th3) {
                    e = th3;
                    a = query;
                    if (a != null) {
                        a.close();
                    }
                    throw e;
                }
            }
            a = query;
            if (a != null) {
                a.close();
            }
        } catch (Exception e4) {
            e = e4;
            query = null;
            BLog.b("MmsSmsPendingSendQueue", e, "Exception in constructing queue for mms pending messages.", new Object[0]);
            if (query != null) {
                query.close();
            }
        } catch (Throwable th4) {
            e = th4;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
    }
}
