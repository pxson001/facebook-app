package com.facebook.messaging.sms;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android_src.mmsv2.pdu.ContentType;
import android_src.mmsv2.pdu.EncodedStringValue;
import android_src.mmsv2.pdu.GenericPdu;
import android_src.mmsv2.pdu.MultimediaMessagePdu;
import android_src.mmsv2.pdu.NotificationInd;
import android_src.mmsv2.pdu.PduBody;
import android_src.mmsv2.pdu.PduPart;
import android_src.mmsv2.pdu.PduPersister;
import android_src.provider.Telephony.Mms;
import android_src.provider.Telephony.MmsSms;
import android_src.provider.Telephony.Sms;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.cursors.CachedColumnNameCursor;
import com.facebook.common.cursors.CachedColumnNameCursorProvider;
import com.facebook.common.cursors.CursorHelper;
import com.facebook.common.util.ExifOrientationUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.messages.Publicity;
import com.facebook.messaging.model.mms.MmsData;
import com.facebook.messaging.model.send.SendError;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ActionIdHelper;
import com.facebook.messaging.sms.abtest.SmsGatekeepers;
import com.facebook.messaging.sms.common.Constants.MmsSmsErrorType;
import com.facebook.messaging.sms.common.MmsSmsIdUtils;
import com.facebook.messaging.sms.defaultapp.MmsSmsErrorHelper;
import com.facebook.messaging.sms.readonly.AnonymousSmsThreadHelper;
import com.facebook.messaging.sms.util.SmsContactUtil;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UserScoped
/* compiled from: component_app */
public class SmsMessageLoader {
    private static final Pattern f17453a = Pattern.compile("(sticker:)(\\d+)");
    private static final String[] f17454b = new String[]{"transport_type", "_id", "thread_id", "date", "address", "body", "type", "msg_box", "st", "m_size", "sub", "sub_cs"};
    private static final String[] f17455c = new String[]{"_id", "thread_id", "date", "address", "body", "type"};
    private static final String[] f17456d = new String[]{"_id", "thread_id", "date", "msg_box", "st", "m_size", "sub", "sub_cs"};
    private static final String[] f17457e = new String[]{"_id", "thread_id", "address", "body", "date", "type"};
    private static final String[] f17458f = new String[]{"_id", "thread_id", "date", "msg_box", "st", "m_size", "sub", "sub_cs"};
    private static final Object f17459p = new Object();
    private final ContentResolver f17460g;
    private final SmsContactUtil f17461h;
    public final Context f17462i;
    private final CachedColumnNameCursorProvider f17463j;
    private final SmsGatekeepers f17464k;
    private final ParticipantInfo f17465l = new ParticipantInfo(new UserKey(Type.EMAIL, ""), "");
    private final MmsSmsErrorHelper f17466m;
    private final MmsSmsErrorCache f17467n;
    private final Comparator<Message> f17468o = new C20771(this);

    /* compiled from: component_app */
    class C20771 implements Comparator<Message> {
        final /* synthetic */ SmsMessageLoader f17452a;

        C20771(SmsMessageLoader smsMessageLoader) {
            this.f17452a = smsMessageLoader;
        }

        public int compare(Object obj, Object obj2) {
            Message message = (Message) obj;
            Message message2 = (Message) obj2;
            if (message.c == message2.c) {
                return 0;
            }
            return message.c > message2.c ? -1 : 1;
        }
    }

    private static SmsMessageLoader m17438b(InjectorLike injectorLike) {
        return new SmsMessageLoader((Context) injectorLike.getInstance(Context.class), ContentResolverMethodAutoProvider.b(injectorLike), SmsContactUtil.m17710a(injectorLike), (CachedColumnNameCursorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CachedColumnNameCursorProvider.class), SmsGatekeepers.b(injectorLike), MmsSmsErrorHelper.m17537b(injectorLike), MmsSmsErrorCache.m17411a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sms.SmsMessageLoader m17430a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f17459p;	 Catch:{ all -> 0x006c }
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
        r1 = m17438b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f17459p;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sms.SmsMessageLoader) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sms.SmsMessageLoader) r0;	 Catch:{  }
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
        r0 = f17459p;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sms.SmsMessageLoader) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.SmsMessageLoader.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sms.SmsMessageLoader");
    }

    @Inject
    public SmsMessageLoader(Context context, ContentResolver contentResolver, SmsContactUtil smsContactUtil, CachedColumnNameCursorProvider cachedColumnNameCursorProvider, SmsGatekeepers smsGatekeepers, MmsSmsErrorHelper mmsSmsErrorHelper, MmsSmsErrorCache mmsSmsErrorCache) {
        this.f17462i = context;
        this.f17460g = contentResolver;
        this.f17461h = smsContactUtil;
        this.f17463j = cachedColumnNameCursorProvider;
        this.f17464k = smsGatekeepers;
        this.f17466m = mmsSmsErrorHelper;
        this.f17467n = mmsSmsErrorCache;
    }

    public final ImmutableList<Message> m17442a(long j, int i, long j2) {
        Cursor cursor = null;
        if (j == AnonymousSmsThreadHelper.f17729a) {
            return ImmutableList.of();
        }
        if (j < 0) {
            return m17439b(j, i, j2);
        }
        Builder builder = ImmutableList.builder();
        if (j2 > 0) {
            String str = "normalized_date<=" + j2;
        } else {
            Object obj = cursor;
        }
        try {
            cursor = this.f17460g.query(Uri.withAppendedPath(MmsSms.b, String.valueOf(j)), f17454b, str, null, "normalized_date DESC LIMIT " + i);
            if (cursor != null) {
                cursor = CachedColumnNameCursorProvider.a(cursor);
                Map hashMap = new HashMap();
                while (cursor.moveToNext()) {
                    String c = CursorHelper.c(cursor, "transport_type");
                    if ("sms".equals(c)) {
                        builder.c(m17428a(cursor, hashMap));
                    } else if ("mms".equals(c)) {
                        builder.c(m17436b(cursor, hashMap));
                    }
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return builder.b();
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.common.collect.ImmutableList<com.facebook.messaging.model.messages.Message> m17439b(long r11, int r13, long r14) {
        /*
        r10 = this;
        r0 = "thread_id";
        r1 = java.lang.String.valueOf(r11);
        r7 = com.facebook.database.sqlite.SqlExpression.a(r0, r1);
        r8 = new java.util.ArrayList;
        r8.<init>();
        r6 = 0;
        r4 = com.facebook.database.sqlite.SqlExpression.a();	 Catch:{ Throwable -> 0x0133, all -> 0x0128 }
        r4.a(r7);	 Catch:{ Throwable -> 0x0133, all -> 0x0128 }
        r0 = 0;
        r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x002a;
    L_0x001d:
        r0 = "date";
        r1 = java.lang.String.valueOf(r14);	 Catch:{ Throwable -> 0x0133, all -> 0x0128 }
        r0 = com.facebook.database.sqlite.SqlExpression.c(r0, r1);	 Catch:{ Throwable -> 0x0133, all -> 0x0128 }
        r4.a(r0);	 Catch:{ Throwable -> 0x0133, all -> 0x0128 }
    L_0x002a:
        r0 = r10.f17460g;	 Catch:{ Throwable -> 0x0133, all -> 0x0128 }
        r1 = android_src.provider.Telephony.Sms.a;	 Catch:{ Throwable -> 0x0133, all -> 0x0128 }
        r2 = f17455c;	 Catch:{ Throwable -> 0x0133, all -> 0x0128 }
        r3 = r4.a();	 Catch:{ Throwable -> 0x0133, all -> 0x0128 }
        r4 = r4.b();	 Catch:{ Throwable -> 0x0133, all -> 0x0128 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0133, all -> 0x0128 }
        r9 = "date DESC LIMIT ";
        r5.<init>(r9);	 Catch:{ Throwable -> 0x0133, all -> 0x0128 }
        r5 = r5.append(r13);	 Catch:{ Throwable -> 0x0133, all -> 0x0128 }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x0133, all -> 0x0128 }
        r1 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Throwable -> 0x0133, all -> 0x0128 }
        if (r1 == 0) goto L_0x0137;
    L_0x004d:
        r1 = com.facebook.common.cursors.CachedColumnNameCursorProvider.a(r1);	 Catch:{ Throwable -> 0x0064, all -> 0x012b }
        r0 = new java.util.HashMap;	 Catch:{ Throwable -> 0x0064, all -> 0x012f }
        r0.<init>();	 Catch:{ Throwable -> 0x0064, all -> 0x012f }
    L_0x0056:
        r2 = r1.moveToNext();	 Catch:{ Throwable -> 0x0064, all -> 0x012f }
        if (r2 == 0) goto L_0x0083;
    L_0x005c:
        r2 = r10.m17428a(r1, r0);	 Catch:{ Throwable -> 0x0064, all -> 0x012f }
        r8.add(r2);	 Catch:{ Throwable -> 0x0064, all -> 0x012f }
        goto L_0x0056;
    L_0x0064:
        r0 = move-exception;
    L_0x0065:
        r2 = "SmsMessageLoader";
        r3 = "Failed to fetch SMS messages for thread %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x007b }
        r5 = 0;
        r6 = java.lang.Long.valueOf(r11);	 Catch:{ all -> 0x007b }
        r4[r5] = r6;	 Catch:{ all -> 0x007b }
        com.facebook.debug.log.BLog.c(r2, r0, r3, r4);	 Catch:{ all -> 0x007b }
        r0 = com.google.common.base.Throwables.propagate(r0);	 Catch:{ all -> 0x007b }
        throw r0;	 Catch:{ all -> 0x007b }
    L_0x007b:
        r0 = move-exception;
        r6 = r1;
    L_0x007d:
        if (r6 == 0) goto L_0x0082;
    L_0x007f:
        r6.close();
    L_0x0082:
        throw r0;
    L_0x0083:
        r6 = r1;
    L_0x0084:
        if (r6 == 0) goto L_0x008a;
    L_0x0086:
        r6.close();
        r6 = 0;
    L_0x008a:
        r4 = com.facebook.database.sqlite.SqlExpression.a();	 Catch:{ Throwable -> 0x0125, all -> 0x011d }
        r4.a(r7);	 Catch:{ Throwable -> 0x0125, all -> 0x011d }
        r0 = 0;
        r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x00a8;
    L_0x0097:
        r0 = "date";
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r14 / r2;
        r1 = java.lang.String.valueOf(r2);	 Catch:{ Throwable -> 0x0125, all -> 0x011d }
        r0 = com.facebook.database.sqlite.SqlExpression.c(r0, r1);	 Catch:{ Throwable -> 0x0125, all -> 0x011d }
        r4.a(r0);	 Catch:{ Throwable -> 0x0125, all -> 0x011d }
    L_0x00a8:
        r0 = r10.f17460g;	 Catch:{ Throwable -> 0x0125, all -> 0x011d }
        r1 = android_src.provider.Telephony.Mms.a;	 Catch:{ Throwable -> 0x0125, all -> 0x011d }
        r2 = f17456d;	 Catch:{ Throwable -> 0x0125, all -> 0x011d }
        r3 = r4.a();	 Catch:{ Throwable -> 0x0125, all -> 0x011d }
        r4 = r4.b();	 Catch:{ Throwable -> 0x0125, all -> 0x011d }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0125, all -> 0x011d }
        r7 = "date DESC LIMIT ";
        r5.<init>(r7);	 Catch:{ Throwable -> 0x0125, all -> 0x011d }
        r5 = r5.append(r13);	 Catch:{ Throwable -> 0x0125, all -> 0x011d }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x0125, all -> 0x011d }
        r1 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Throwable -> 0x0125, all -> 0x011d }
        if (r1 == 0) goto L_0x0101;
    L_0x00cb:
        r1 = com.facebook.common.cursors.CachedColumnNameCursorProvider.a(r1);	 Catch:{ Throwable -> 0x00e2, all -> 0x011f }
        r0 = new java.util.HashMap;	 Catch:{ Throwable -> 0x00e2, all -> 0x0122 }
        r0.<init>();	 Catch:{ Throwable -> 0x00e2, all -> 0x0122 }
    L_0x00d4:
        r2 = r1.moveToNext();	 Catch:{ Throwable -> 0x00e2, all -> 0x0122 }
        if (r2 == 0) goto L_0x0101;
    L_0x00da:
        r2 = r10.m17436b(r1, r0);	 Catch:{ Throwable -> 0x00e2, all -> 0x0122 }
        r8.add(r2);	 Catch:{ Throwable -> 0x00e2, all -> 0x0122 }
        goto L_0x00d4;
    L_0x00e2:
        r0 = move-exception;
    L_0x00e3:
        r2 = "SmsMessageLoader";
        r3 = "Failed to fetch MMS messages for thread %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00f9 }
        r5 = 0;
        r6 = java.lang.Long.valueOf(r11);	 Catch:{ all -> 0x00f9 }
        r4[r5] = r6;	 Catch:{ all -> 0x00f9 }
        com.facebook.debug.log.BLog.c(r2, r0, r3, r4);	 Catch:{ all -> 0x00f9 }
        r0 = com.google.common.base.Throwables.propagate(r0);	 Catch:{ all -> 0x00f9 }
        throw r0;	 Catch:{ all -> 0x00f9 }
    L_0x00f9:
        r0 = move-exception;
        r6 = r1;
    L_0x00fb:
        if (r6 == 0) goto L_0x0100;
    L_0x00fd:
        r6.close();
    L_0x0100:
        throw r0;
    L_0x0101:
        if (r1 == 0) goto L_0x0106;
    L_0x0103:
        r1.close();
    L_0x0106:
        r0 = r10.f17468o;
        java.util.Collections.sort(r8, r0);
        r0 = 0;
        r1 = r8.size();
        r1 = java.lang.Math.min(r1, r13);
        r0 = r8.subList(r0, r1);
        r0 = com.google.common.collect.ImmutableList.copyOf(r0);
        return r0;
    L_0x011d:
        r0 = move-exception;
        goto L_0x00fb;
    L_0x011f:
        r0 = move-exception;
        r6 = r1;
        goto L_0x00fb;
    L_0x0122:
        r0 = move-exception;
        r6 = r1;
        goto L_0x00fb;
    L_0x0125:
        r0 = move-exception;
        r1 = r6;
        goto L_0x00e3;
    L_0x0128:
        r0 = move-exception;
        goto L_0x007d;
    L_0x012b:
        r0 = move-exception;
        r6 = r1;
        goto L_0x007d;
    L_0x012f:
        r0 = move-exception;
        r6 = r1;
        goto L_0x007d;
    L_0x0133:
        r0 = move-exception;
        r1 = r6;
        goto L_0x0065;
    L_0x0137:
        r6 = r1;
        goto L_0x0084;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.SmsMessageLoader.b(long, int, long):com.google.common.collect.ImmutableList<com.facebook.messaging.model.messages.Message>");
    }

    @Nullable
    public final Message m17441a(Uri uri) {
        String a = MmsSmsIdUtils.m17499a(uri);
        if (MmsSmsIdUtils.m17502c(a)) {
            return m17437b(MmsSmsIdUtils.m17497a(a));
        }
        if (MmsSmsIdUtils.m17503d(a)) {
            return m17440c(MmsSmsIdUtils.m17500b(a));
        }
        return null;
    }

    @Nullable
    private Message m17437b(Uri uri) {
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor query = this.f17460g.query(uri, f17457e, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        cursor = CachedColumnNameCursorProvider.a(query);
                        Message a = m17428a(cursor, null);
                        if (cursor == null) {
                            return a;
                        }
                        cursor.close();
                        return a;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @Nullable
    private Message m17440c(Uri uri) {
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor query = this.f17460g.query(uri, f17458f, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        CachedColumnNameCursor a = CachedColumnNameCursorProvider.a(query);
                        Message b = m17436b(a, null);
                        if (a == null) {
                            return b;
                        }
                        a.close();
                        return b;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @Nullable
    private ParticipantInfo m17429a(@Nullable String str, @Nullable Map<String, ParticipantInfo> map) {
        ParticipantInfo participantInfo = null;
        if (!Strings.isNullOrEmpty(str)) {
            if (map != null) {
                participantInfo = (ParticipantInfo) map.get(str);
            }
            if (participantInfo == null) {
                participantInfo = SmsContactUtil.m17709a(this.f17461h.m17714a(str));
            }
            if (map != null) {
                map.put(str, participantInfo);
            }
        }
        return participantInfo;
    }

    private Message m17428a(Cursor cursor, @Nullable Map<String, ParticipantInfo> map) {
        ParticipantInfo a;
        MessageType messageType;
        SendError sendError = null;
        long b = CursorHelper.b(cursor, "_id");
        long b2 = CursorHelper.b(cursor, "thread_id");
        String c = CursorHelper.c(cursor, "address");
        String c2 = CursorHelper.c(cursor, "body");
        long b3 = CursorHelper.b(cursor, "date");
        int a2 = CursorHelper.a(cursor, "type");
        long a3 = m17426a(b3, b);
        if (Sms.a(a2)) {
            a = this.f17461h.m17713a();
        } else {
            a = m17429a(c, (Map) map);
        }
        if (a == null) {
            a = this.f17465l;
        }
        String a4 = MmsSmsIdUtils.m17498a(b);
        if (a2 == 5) {
            messageType = MessageType.FAILED_SEND;
            MmsSmsErrorType a5 = this.f17467n.m17416a(a4);
            MmsSmsErrorHelper mmsSmsErrorHelper = this.f17466m;
            if (a5 == null) {
                a5 = MmsSmsErrorType.GENERIC;
            }
            sendError = mmsSmsErrorHelper.m17539a(a5);
        } else {
            messageType = (a2 == 6 || a2 == 4) ? MessageType.PENDING_SEND : null;
        }
        MessageBuilder a6 = Message.newBuilder().a(a4);
        a6.n = a4;
        MessageBuilder messageBuilder = a6;
        messageBuilder.b = ThreadKey.b(b2);
        messageBuilder = messageBuilder;
        messageBuilder.f = c2;
        messageBuilder = messageBuilder.a(b3).c(a3);
        messageBuilder.e = a;
        MessageBuilder messageBuilder2 = messageBuilder;
        messageBuilder2.o = false;
        messageBuilder2 = messageBuilder2;
        messageBuilder2.v = Publicity.a;
        messageBuilder2 = messageBuilder2;
        messageBuilder2.h = true;
        messageBuilder2 = messageBuilder2;
        messageBuilder2.p = "sms";
        messageBuilder2 = messageBuilder2;
        if (messageType != null) {
            messageBuilder2.l = messageType;
        }
        if (sendError != null) {
            messageBuilder2.u = sendError;
        }
        return messageBuilder2.R();
    }

    private Message m17436b(Cursor cursor, @Nullable Map<String, ParticipantInfo> map) {
        long b = CursorHelper.b(cursor, "_id");
        Uri withAppendedId = ContentUris.withAppendedId(Mms.a, b);
        long b2 = CursorHelper.b(cursor, "thread_id");
        long b3 = CursorHelper.b(cursor, "date") * 1000;
        long a = m17426a(b3, b);
        int a2 = CursorHelper.a(cursor, "msg_box");
        int a3 = CursorHelper.a(cursor, "st");
        String b4 = MmsSmsIdUtils.m17501b(b);
        MessageType messageType = null;
        SendError sendError = null;
        if (a2 == 4) {
            if (a3 == 135) {
                messageType = MessageType.FAILED_SEND;
                MmsSmsErrorType a4 = this.f17467n.m17416a(b4);
                MmsSmsErrorHelper mmsSmsErrorHelper = this.f17466m;
                if (a4 == null) {
                    a4 = MmsSmsErrorType.GENERIC;
                }
                sendError = mmsSmsErrorHelper.m17540b(a4);
            } else {
                messageType = MessageType.PENDING_SEND;
            }
        }
        MessageBuilder e = Message.newBuilder().a(b4).d(b4).a(ThreadKey.b(b2)).a(b3).c(a).b(false).a(Publicity.a).a(true).e("sms");
        if (messageType != null) {
            e.a(messageType);
        }
        if (sendError != null) {
            e.a(sendError);
        }
        try {
            GenericPdu a5 = PduPersister.m3702a(this.f17462i).m3721a(withAppendedId);
            int b5 = a5.m3593b();
            String c = a5.mo123c() == null ? null : a5.mo123c().m3610c();
            if (130 == b5) {
                NotificationInd notificationInd = (NotificationInd) a5;
                e.a(m17429a(c, (Map) map));
                e.a(MmsData.a(notificationInd.m3618e() * 1000, notificationInd.m3619f()));
            } else if (128 == b5 || 132 == b5) {
                MultimediaMessagePdu multimediaMessagePdu = (MultimediaMessagePdu) a5;
                if (132 == b5) {
                    e.a(m17429a(c, (Map) map));
                } else {
                    e.a(this.f17461h.m17713a());
                }
                m17433a(multimediaMessagePdu, e);
            }
        } catch (Throwable e2) {
            BLog.c("SmsMessageLoader", e2, "failed to load mms %s", new Object[]{withAppendedId.toString()});
            e.b(this.f17462i.getResources().getString(2131232333));
        }
        if (Strings.isNullOrEmpty(e.f()) && e.L().d.isEmpty()) {
            String c2 = CursorHelper.c(cursor, "sub");
            int a6 = CursorHelper.a(cursor, "sub_cs");
            if (!(a6 == 0 || c2 == null)) {
                c2 = new EncodedStringValue(a6, PduPersister.m3715a(c2)).m3610c();
            }
            e.b(c2);
        }
        if (e.e() == null) {
            e.a(this.f17465l);
        }
        return e.R();
    }

    private void m17433a(MultimediaMessagePdu multimediaMessagePdu, MessageBuilder messageBuilder) {
        Builder builder = ImmutableList.builder();
        PduBody d = multimediaMessagePdu.m3613d();
        int b = d.m3624b();
        for (int i = 0; i < b; i++) {
            try {
                PduPart a = d.m3620a(i);
                if (!(a == null || a.m3694g() == null)) {
                    String str = new String(a.m3694g());
                    if ("text/plain".equals(str)) {
                        messageBuilder.b(new String(a.m3683a()));
                    } else if ("application/smil".equals(str) && this.f17464k.a()) {
                        String a2 = m17432a(a.m3696i());
                        if (a2 != null) {
                            messageBuilder.c(a2);
                        }
                    } else {
                        String a3 = m17432a(a.m3696i());
                        if (ContentType.m3601b(str) && this.f17464k.a() && a3 != null) {
                            messageBuilder.c(a3);
                        } else {
                            MediaResource a4 = m17431a(a);
                            if (a4 != null) {
                                builder.c(a4);
                            }
                        }
                    }
                }
            } catch (Throwable e) {
                BLog.b("SmsMessageLoader", e, "Failed to load part %d", new Object[]{Integer.valueOf(i)});
            }
        }
        ImmutableList b2 = builder.b();
        if (!b2.isEmpty() && messageBuilder.k() == null) {
            messageBuilder.a(MmsData.a(b2));
        }
    }

    @Nullable
    private MediaResource m17431a(PduPart pduPart) {
        MediaResourceBuilder mediaResourceBuilder = new MediaResourceBuilder();
        String str = new String(pduPart.m3694g());
        Uri uri = pduPart.f3860e;
        if (uri != null) {
            mediaResourceBuilder.a = uri;
        }
        if (ContentType.m3601b(str)) {
            m17434a(mediaResourceBuilder, uri);
        } else if (ContentType.m3603d(str)) {
            m17435a(mediaResourceBuilder, uri, MediaResource.Type.VIDEO);
        } else if (ContentType.m3602c(str)) {
            m17435a(mediaResourceBuilder, uri, MediaResource.Type.AUDIO);
        } else if ("text/x-vCard".equalsIgnoreCase(str)) {
            String str2 = new String(pduPart.f3861f);
            mediaResourceBuilder.w = pduPart.f3860e;
            MediaResourceBuilder mediaResourceBuilder2 = mediaResourceBuilder;
            mediaResourceBuilder2.b = MediaResource.Type.OTHER;
            mediaResourceBuilder2.m = new String(pduPart.m3694g());
            String str3 = null;
            if (str2 != null) {
                int indexOf = str2.indexOf("FN:");
                if (indexOf != -1) {
                    int indexOf2 = str2.indexOf(10, indexOf);
                    if (indexOf2 != -1) {
                        str3 = str2.substring(indexOf + 3, indexOf2);
                    }
                }
            }
            str2 = str3;
            if (str2 == null) {
                str2 = this.f17462i.getString(2131232344);
            }
            mediaResourceBuilder.a = Uri.parse(str2);
        }
        if (mediaResourceBuilder.b != null) {
            return mediaResourceBuilder.C();
        }
        return null;
    }

    private void m17434a(MediaResourceBuilder mediaResourceBuilder, Uri uri) {
        mediaResourceBuilder.a(MediaResource.Type.PHOTO);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        try {
            ParcelFileDescriptor openFileDescriptor = this.f17462i.getContentResolver().openFileDescriptor(uri, "r");
            BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor(), null, options);
            mediaResourceBuilder.b(options.outHeight);
            mediaResourceBuilder.a(options.outWidth);
            if (openFileDescriptor != null) {
                openFileDescriptor.close();
            }
        } catch (Throwable e) {
            BLog.b("SmsMessageLoader", e, "failed to open file descriptor: %s", new Object[]{String.valueOf(uri)});
        }
    }

    private void m17435a(MediaResourceBuilder mediaResourceBuilder, Uri uri, MediaResource.Type type) {
        boolean z = false;
        if (type == MediaResource.Type.AUDIO || type == MediaResource.Type.VIDEO) {
            z = true;
        }
        Preconditions.checkArgument(z);
        mediaResourceBuilder.a(type);
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            ParcelFileDescriptor openFileDescriptor = this.f17462i.getContentResolver().openFileDescriptor(uri, "r");
            mediaMetadataRetriever.setDataSource(openFileDescriptor.getFileDescriptor());
            mediaResourceBuilder.b(m17427a(mediaMetadataRetriever, 9, 0));
            if (type == MediaResource.Type.VIDEO) {
                mediaResourceBuilder.a(m17425a(mediaMetadataRetriever, 18, 0));
                mediaResourceBuilder.b(m17425a(mediaMetadataRetriever, 19, 0));
                mediaResourceBuilder.a(ExifOrientationUtil.a(m17425a(mediaMetadataRetriever, 24, 0)));
            }
            mediaMetadataRetriever.release();
            if (openFileDescriptor != null) {
                openFileDescriptor.close();
            }
        } catch (Throwable e) {
            BLog.b("SmsMessageLoader", "Failed to extract meta data", e);
        }
    }

    private static int m17425a(MediaMetadataRetriever mediaMetadataRetriever, int i, int i2) {
        String extractMetadata = mediaMetadataRetriever.extractMetadata(i);
        if (!Strings.isNullOrEmpty(extractMetadata)) {
            try {
                i2 = Integer.parseInt(extractMetadata);
            } catch (Throwable e) {
                BLog.b("SmsMessageLoader", e, "wrong type for key %s : %s", new Object[]{Integer.valueOf(i), extractMetadata});
            }
        }
        return i2;
    }

    private static long m17427a(MediaMetadataRetriever mediaMetadataRetriever, int i, long j) {
        String extractMetadata = mediaMetadataRetriever.extractMetadata(i);
        if (!Strings.isNullOrEmpty(extractMetadata)) {
            try {
                j = Long.parseLong(extractMetadata);
            } catch (Throwable e) {
                BLog.b("SmsMessageLoader", e, "wrong type for key %s : %s", new Object[]{Integer.valueOf(i), extractMetadata});
            }
        }
        return j;
    }

    private static long m17426a(long j, long j2) {
        return ActionIdHelper.b(j) + (j2 % 1000000);
    }

    private static String m17432a(byte[] bArr) {
        if (bArr != null) {
            Matcher matcher = f17453a.matcher(new String(bArr));
            if (matcher.find()) {
                return matcher.group(2);
            }
        }
        return null;
    }
}
