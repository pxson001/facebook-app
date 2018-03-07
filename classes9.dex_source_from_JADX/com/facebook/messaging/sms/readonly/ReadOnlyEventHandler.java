package com.facebook.messaging.sms.readonly;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.util.LongSparseArray;
import android_src.provider.Telephony.Mms;
import android_src.provider.Telephony.Sms;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.inject.InjectorLike;
import com.facebook.messages.ipc.MessagingIntentUris;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.linkhandling.ComponentName_ForSecureIntentHandlerActivityMethodAutoProvider;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.sms.SmsMessageLoader;
import com.facebook.messaging.sms.abtest.AnonymousSmsThreadStateHelper;
import com.facebook.messaging.sms.abtest.SmsIntegrationState;
import com.facebook.messaging.sms.abtest.SmsTakeoverMultiverseExperimentHelper;
import com.facebook.messaging.sms.analytics.SmsTakeoverAnalyticsLogger;
import com.facebook.messaging.sms.defaultapp.action.MmsSmsCacheUpdateAction;
import com.facebook.messaging.sms.defaultapp.action.MmsSmsCacheUpdateAction.C20871;
import com.facebook.messaging.sms.prefs.SmsPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

@TargetApi(19)
/* compiled from: com.facebook.orca.category.PLATFORM_THREAD_20150311 */
public class ReadOnlyEventHandler {
    private static final String[] f17742a = new String[]{"_id", "thread_id", "type"};
    private static final String[] f17743b = new String[]{"_id", "thread_id", "msg_box", "m_type"};
    private static final boolean f17744c;
    private final ContentResolver f17745d;
    private final SmsMessageLoader f17746e;
    public final MmsSmsCacheUpdateAction f17747f;
    private final SmsIntegrationState f17748g;
    private final Context f17749h;
    private final SecureContextHelper f17750i;
    private final AnonymousSmsThreadStateHelper f17751j;
    private final ComponentName f17752k;
    private final FbSharedPreferences f17753l;
    private WaterMark f17754m;
    private WaterMark f17755n;
    private boolean f17756o;

    public static ReadOnlyEventHandler m17692b(InjectorLike injectorLike) {
        return new ReadOnlyEventHandler(ContentResolverMethodAutoProvider.b(injectorLike), SmsMessageLoader.m17430a(injectorLike), MmsSmsCacheUpdateAction.m17596b(injectorLike), SmsIntegrationState.a(injectorLike), (Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), AnonymousSmsThreadStateHelper.a(injectorLike), ComponentName_ForSecureIntentHandlerActivityMethodAutoProvider.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 23) {
            z = false;
        }
        f17744c = z;
    }

    @Inject
    public ReadOnlyEventHandler(ContentResolver contentResolver, SmsMessageLoader smsMessageLoader, MmsSmsCacheUpdateAction mmsSmsCacheUpdateAction, SmsIntegrationState smsIntegrationState, Context context, SecureContextHelper secureContextHelper, AnonymousSmsThreadStateHelper anonymousSmsThreadStateHelper, ComponentName componentName, FbSharedPreferences fbSharedPreferences) {
        this.f17745d = contentResolver;
        this.f17746e = smsMessageLoader;
        this.f17747f = mmsSmsCacheUpdateAction;
        this.f17748g = smsIntegrationState;
        this.f17749h = context;
        this.f17750i = secureContextHelper;
        this.f17751j = anonymousSmsThreadStateHelper;
        this.f17752k = componentName;
        this.f17753l = fbSharedPreferences;
    }

    public final void m17696a() {
        this.f17754m = m17694d();
        this.f17755n = m17695e();
    }

    @Nullable
    private WaterMark m17694d() {
        Cursor query;
        Throwable e;
        try {
            WaterMark waterMark;
            query = this.f17745d.query(Sms.a, f17742a, null, null, "_id DESC LIMIT 1");
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        waterMark = new WaterMark(query.getLong(0), query.getInt(2));
                        if (query == null) {
                            return waterMark;
                        }
                        query.close();
                        return waterMark;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        BLog.b("ReadOnlyEventHandler", e, "Error establishing SMS watermark.", new Object[0]);
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        throw e;
                    }
                }
            }
            waterMark = new WaterMark(0, 0);
            if (query == null) {
                return waterMark;
            }
            query.close();
            return waterMark;
        } catch (Exception e3) {
            e = e3;
            query = null;
            BLog.b("ReadOnlyEventHandler", e, "Error establishing SMS watermark.", new Object[0]);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
    }

    @Nullable
    private WaterMark m17695e() {
        Cursor query;
        Throwable e;
        try {
            WaterMark waterMark;
            query = this.f17745d.query(Mms.a, f17743b, null, null, "_id DESC LIMIT 1");
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        waterMark = new WaterMark(query.getLong(0), query.getInt(2));
                        if (query == null) {
                            return waterMark;
                        }
                        query.close();
                        return waterMark;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        BLog.b("ReadOnlyEventHandler", e, "Error establishing MMS watermark.", new Object[0]);
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        throw e;
                    }
                }
            }
            waterMark = new WaterMark(0, 0);
            if (query == null) {
                return waterMark;
            }
            query.close();
            return waterMark;
        } catch (Exception e3) {
            e = e3;
            query = null;
            BLog.b("ReadOnlyEventHandler", e, "Error establishing MMS watermark.", new Object[0]);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
    }

    private void m17691a(LongSparseArray<Uri> longSparseArray) {
        Throwable e;
        if (this.f17754m != null) {
            Expression f = SqlExpression.f("_id", String.valueOf(this.f17754m.m17703a()));
            Cursor query;
            try {
                query = this.f17745d.query(Sms.a, f17742a, f.a(), f.b(), "_id DESC LIMIT 10");
                int i = -1;
                long j = -1;
                while (query != null) {
                    try {
                        if (query.moveToNext()) {
                            long j2 = query.getLong(0);
                            long j3 = query.getLong(1);
                            int i2 = query.getInt(2);
                            if (j == -1) {
                                i = i2;
                                j = j2;
                            }
                            if (this.f17754m.m17705b(j2, i2) > 0 && longSparseArray.a(j3) == null) {
                                if (i2 == 1) {
                                    this.f17756o = true;
                                }
                                longSparseArray.b(j3, ContentUris.withAppendedId(Sms.a, j2));
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                if (this.f17754m.m17705b(j, i) > 0) {
                    this.f17754m.m17704a(j, i);
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e3) {
                e = e3;
                query = null;
                try {
                    BLog.b("ReadOnlyEventHandler", e, "Error loading SMS message changes.", new Object[0]);
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
            } catch (Throwable th2) {
                e = th2;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw e;
            }
        }
    }

    private void m17693b(LongSparseArray<Uri> longSparseArray) {
        Throwable e;
        if (this.f17755n != null) {
            Expression f = SqlExpression.f("_id", String.valueOf(this.f17755n.m17703a()));
            Cursor query;
            try {
                query = this.f17745d.query(Mms.a, f17743b, f.a(), f.b(), "_id DESC LIMIT 10");
                int i = -1;
                long j = -1;
                while (query != null) {
                    try {
                        if (query.moveToNext()) {
                            long j2 = query.getLong(0);
                            long j3 = query.getLong(1);
                            int i2 = query.getInt(2);
                            if (!f17744c || 130 != query.getInt(3)) {
                                if (j == -1) {
                                    i = i2;
                                    j = j2;
                                }
                                if (this.f17755n.m17705b(j2, i2) > 0 && longSparseArray.a(j3) == null) {
                                    if (i2 == 1) {
                                        this.f17756o = true;
                                    }
                                    longSparseArray.b(j3, ContentUris.withAppendedId(Mms.a, j2));
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                if (this.f17755n.m17705b(j, i) > 0) {
                    this.f17755n.m17704a(j, i);
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e3) {
                e = e3;
                query = null;
                try {
                    BLog.b("ReadOnlyEventHandler", e, "Error loading MMS message changes.", new Object[0]);
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
            } catch (Throwable th2) {
                e = th2;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw e;
            }
        }
    }

    public final void m17697b() {
        LongSparseArray longSparseArray = new LongSparseArray();
        m17691a(longSparseArray);
        m17693b(longSparseArray);
        if (longSparseArray.a() != 0) {
            if (this.f17748g.b()) {
                for (int i = 0; i < longSparseArray.a(); i++) {
                    long b = longSparseArray.b(i);
                    Uri uri = (Uri) longSparseArray.a(b);
                    Long.valueOf(b);
                    Message a = this.f17746e.m17441a(uri);
                    if (a != null) {
                        MmsSmsCacheUpdateAction mmsSmsCacheUpdateAction = this.f17747f;
                        CallerContext a2 = CallerContext.a(getClass());
                        Preconditions.checkState(!a.o);
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("message", a);
                        bundle.putBoolean("is_readonly_mode", true);
                        if (!a.e.a()) {
                            switch (C20871.f17621a[((SmsTakeoverMultiverseExperimentHelper) mmsSmsCacheUpdateAction.f17628g.get()).p().ordinal()]) {
                                case 1:
                                    break;
                                case 2:
                                    bundle.putBoolean("should_show_notification", false);
                                    break;
                                case 3:
                                    bundle.putBoolean("only_notify_from_chathead", true);
                                    break;
                                case 4:
                                    if (((GentleNotificationChecker) mmsSmsCacheUpdateAction.f17629h.get()).m17690a()) {
                                        bundle.putBoolean("should_show_notification", false);
                                        break;
                                    }
                                    break;
                                case 5:
                                    if (!((GentleNotificationChecker) mmsSmsCacheUpdateAction.f17629h.get()).m17690a()) {
                                        bundle.putBoolean("only_notify_from_chathead", true);
                                        break;
                                    } else {
                                        bundle.putBoolean("should_show_notification", false);
                                        break;
                                    }
                                default:
                                    break;
                            }
                        }
                        bundle.putBoolean("should_show_notification", false);
                        BlueServiceOperationFactoryDetour.a(mmsSmsCacheUpdateAction.f17625d, "received_sms", bundle, ErrorPropagation.BY_EXCEPTION, a2, -912859332).a();
                        if (bundle.getBoolean("should_show_notification", true) && !bundle.getBoolean("only_notify_from_chathead", false)) {
                            ((SmsTakeoverAnalyticsLogger) mmsSmsCacheUpdateAction.f17630i.get()).a();
                        }
                    }
                }
                return;
            }
            if (this.f17751j.a()) {
                this.f17747f.m17598a(CallerContext.a(getClass()));
            }
            if (this.f17756o && this.f17751j.b()) {
                this.f17756o = false;
                this.f17753l.edit().a(SmsPrefKeys.j, longSparseArray.b(0)).commit();
                Intent intent = new Intent(MessagingIntentUris.a);
                intent.setData(Uri.parse(MessengerLinks.S));
                intent.setComponent(this.f17752k);
                intent.setFlags(268435456);
                intent.putExtra("prefer_chat_if_possible", true);
                this.f17750i.a(intent, this.f17749h);
            }
        }
    }
}
