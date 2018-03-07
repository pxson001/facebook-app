package com.facebook.messaging.sms.defaultapp.action;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android_src.mmsv2.MmsManager;
import android_src.mmsv2.pdu.EncodedStringValue;
import android_src.mmsv2.pdu.MmsException;
import android_src.mmsv2.pdu.NotificationInd;
import android_src.mmsv2.pdu.PduBody;
import android_src.mmsv2.pdu.PduParser;
import android_src.mmsv2.pdu.PduPart;
import android_src.mmsv2.pdu.PduPersister;
import android_src.mmsv2.pdu.RetrieveConf;
import android_src.provider.Telephony.Mms.Inbox;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.cursors.CursorHelper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.sms.SmsMessageLoader;
import com.facebook.messaging.sms.analytics.SmsTakeoverAnalyticsLogger;
import com.facebook.messaging.sms.common.MmsSmsIdUtils;
import com.facebook.messaging.sms.defaultapp.MmsDownloadManager;
import com.facebook.messaging.sms.defaultapp.MmsDownloadManager.ErrorCode;
import com.facebook.messaging.sms.defaultapp.MmsFileProvider;
import com.facebook.messaging.sms.defaultapp.MmsSmsErrorHelper;
import com.facebook.messaging.sms.defaultapp.config.MmsSmsConfig;
import com.facebook.messaging.sms.prefs.SmsPrefKeys;
import com.facebook.messaging.sms.util.TelephonyUtils;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.videocodec.trimmer.VideoTrimmer;
import com.facebook.videocodec.trimmer.VideoTrimmerParams;
import com.google.common.io.Files;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: com.facebook.orca.media.upload.MEDIA_RESIZE_PROGRESS */
public class ProcessMmsDownloadedAction {
    private static final String[] f17637a = new String[]{"thread_id", "resp_st", "exp"};
    private final Context f17638b;
    private final Clock f17639c;
    private final MmsDownloadManager f17640d;
    private final FbSharedPreferences f17641e;
    private final MmsSmsConfig f17642f;
    private final SmsMessageLoader f17643g;
    private final MmsSmsCacheUpdateAction f17644h;
    private final Lazy<VideoTrimmer> f17645i;
    private final Lazy<SmsTakeoverAnalyticsLogger> f17646j;

    public static ProcessMmsDownloadedAction m17607a(InjectorLike injectorLike) {
        return new ProcessMmsDownloadedAction((Context) injectorLike.getInstance(Context.class), (Clock) SystemClockMethodAutoProvider.a(injectorLike), MmsDownloadManager.m17517a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), MmsSmsConfig.m17636b(injectorLike), SmsMessageLoader.m17430a(injectorLike), MmsSmsCacheUpdateAction.m17596b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 11740), IdBasedLazy.a(injectorLike, 2706));
    }

    @Inject
    public ProcessMmsDownloadedAction(Context context, Clock clock, MmsDownloadManager mmsDownloadManager, FbSharedPreferences fbSharedPreferences, MmsSmsConfig mmsSmsConfig, SmsMessageLoader smsMessageLoader, MmsSmsCacheUpdateAction mmsSmsCacheUpdateAction, Lazy<VideoTrimmer> lazy, Lazy<SmsTakeoverAnalyticsLogger> lazy2) {
        this.f17638b = context;
        this.f17639c = clock;
        this.f17640d = mmsDownloadManager;
        this.f17641e = fbSharedPreferences;
        this.f17642f = mmsSmsConfig;
        this.f17643g = smsMessageLoader;
        this.f17644h = mmsSmsCacheUpdateAction;
        this.f17645i = lazy;
        this.f17646j = lazy2;
    }

    public final void m17614a(Bundle bundle) {
        boolean z;
        Throwable e;
        boolean z2;
        String mmsSmsErrorType;
        SmsTakeoverAnalyticsLogger smsTakeoverAnalyticsLogger;
        boolean z3;
        String b;
        boolean z4 = true;
        int i = bundle.getInt("result_code", -1);
        Uri uri = (Uri) bundle.getParcelable("extra_uri");
        Uri uri2 = (Uri) bundle.getParcelable("content_uri");
        boolean z5 = bundle.getBoolean("extra_repersist_on_error", false);
        if (i == -1) {
            try {
                RetrieveConf retrieveConf = (RetrieveConf) new PduParser(m17610a(uri2), this.f17642f.m17640b()).m3679a();
                m17612b(retrieveConf);
                if (retrieveConf.mo123c() == null) {
                    try {
                        EncodedStringValue c = PduPersister.m3702a(this.f17638b).m3721a(uri).mo123c();
                        if (c != null) {
                            retrieveConf.mo122a(c);
                        }
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BLog.b("ProcessMmsDownloadedAction", e, "Error processing downloaded MMS content: %s, msg: %s", new Object[]{uri2, uri});
                        i = 100;
                        if (i != -1) {
                            if (z5) {
                                try {
                                    uri = m17611b(uri);
                                    m17608a(uri, null);
                                } catch (Throwable e3) {
                                    BLog.b("ProcessMmsDownloadedAction", e3, "Failed repersisting MMS Notif: %s", new Object[]{uri});
                                }
                            } else {
                                m17613c(uri);
                            }
                            MmsPendingMessageAction.m17595a(this.f17638b, uri);
                            this.f17640d.m17519a(MmsSmsIdUtils.m17499a(uri), ErrorCode.OTHER);
                        }
                        if (i != -1) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        mmsSmsErrorType = z2 ? MmsSmsErrorHelper.m17536b(i).toString() : null;
                        smsTakeoverAnalyticsLogger = (SmsTakeoverAnalyticsLogger) this.f17646j.get();
                        if (i != -1) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        b = MmsSmsErrorHelper.m17538b(i, bundle.getInt("android.telephony.extra.MMS_HTTP_STATUS", 0));
                        if (MmsManager.m3541a()) {
                            z4 = false;
                        }
                        smsTakeoverAnalyticsLogger.a(z3, mmsSmsErrorType, b, z5, z4, z);
                    }
                }
                z = false;
                try {
                    Uri a = m17606a(retrieveConf);
                    this.f17638b.getContentResolver().delete(uri, null, null);
                    m17608a(a, uri);
                    this.f17640d.m17520c(MmsSmsIdUtils.m17499a(uri));
                } catch (Exception e4) {
                    e = e4;
                    BLog.b("ProcessMmsDownloadedAction", e, "Error processing downloaded MMS content: %s, msg: %s", new Object[]{uri2, uri});
                    i = 100;
                    if (i != -1) {
                        if (z5) {
                            uri = m17611b(uri);
                            m17608a(uri, null);
                        } else {
                            m17613c(uri);
                        }
                        MmsPendingMessageAction.m17595a(this.f17638b, uri);
                        this.f17640d.m17519a(MmsSmsIdUtils.m17499a(uri), ErrorCode.OTHER);
                    }
                    if (i != -1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                    }
                    smsTakeoverAnalyticsLogger = (SmsTakeoverAnalyticsLogger) this.f17646j.get();
                    if (i != -1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    b = MmsSmsErrorHelper.m17538b(i, bundle.getInt("android.telephony.extra.MMS_HTTP_STATUS", 0));
                    if (MmsManager.m3541a()) {
                        z4 = false;
                    }
                    smsTakeoverAnalyticsLogger.a(z3, mmsSmsErrorType, b, z5, z4, z);
                }
            } catch (Exception e5) {
                e = e5;
                z = false;
                BLog.b("ProcessMmsDownloadedAction", e, "Error processing downloaded MMS content: %s, msg: %s", new Object[]{uri2, uri});
                i = 100;
                if (i != -1) {
                    if (z5) {
                        m17613c(uri);
                    } else {
                        uri = m17611b(uri);
                        m17608a(uri, null);
                    }
                    MmsPendingMessageAction.m17595a(this.f17638b, uri);
                    this.f17640d.m17519a(MmsSmsIdUtils.m17499a(uri), ErrorCode.OTHER);
                }
                if (i != -1) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                }
                smsTakeoverAnalyticsLogger = (SmsTakeoverAnalyticsLogger) this.f17646j.get();
                if (i != -1) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                b = MmsSmsErrorHelper.m17538b(i, bundle.getInt("android.telephony.extra.MMS_HTTP_STATUS", 0));
                if (MmsManager.m3541a()) {
                    z4 = false;
                }
                smsTakeoverAnalyticsLogger.a(z3, mmsSmsErrorType, b, z5, z4, z);
            }
        }
        z = false;
        if (i != -1) {
            if (z5) {
                uri = m17611b(uri);
                m17608a(uri, null);
            } else {
                m17613c(uri);
            }
            MmsPendingMessageAction.m17595a(this.f17638b, uri);
            this.f17640d.m17519a(MmsSmsIdUtils.m17499a(uri), ErrorCode.OTHER);
        }
        if (i != -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
        }
        smsTakeoverAnalyticsLogger = (SmsTakeoverAnalyticsLogger) this.f17646j.get();
        if (i != -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        b = MmsSmsErrorHelper.m17538b(i, bundle.getInt("android.telephony.extra.MMS_HTTP_STATUS", 0));
        if (MmsManager.m3541a()) {
            z4 = false;
        }
        smsTakeoverAnalyticsLogger.a(z3, mmsSmsErrorType, b, z5, z4, z);
    }

    private Uri m17606a(RetrieveConf retrieveConf) {
        PduPersister a = PduPersister.m3703a(this.f17638b, this.f17641e.a(SmsPrefKeys.L, null));
        return a.m3720a(retrieveConf, Inbox.a, TelephonyUtils.m17716a(-1), a.m3723b(), true, null);
    }

    private byte[] m17610a(Uri uri) {
        File a = MmsFileProvider.m17522a(this.f17638b, uri);
        try {
            byte[] b = Files.b(a);
            if (a.exists()) {
                a.delete();
            }
            return b;
        } catch (Throwable e) {
            BLog.b("ProcessMmsDownloadedAction", e, "Error processing extracting downloaded MMS content: %s", new Object[]{uri});
            throw new MmsException(e.getMessage());
        } catch (Throwable th) {
            if (a.exists()) {
                a.delete();
            }
        }
    }

    private Uri m17611b(Uri uri) {
        PduPersister a = PduPersister.m3703a(this.f17638b, this.f17641e.a(SmsPrefKeys.L, null));
        NotificationInd notificationInd = (NotificationInd) a.m3721a(uri);
        this.f17638b.getContentResolver().delete(uri, null, null);
        return a.m3720a(notificationInd, Inbox.a, TelephonyUtils.m17716a(-1), a.m3723b(), true, null);
    }

    private ErrorCode m17613c(Uri uri) {
        Throwable th;
        ErrorCode errorCode = ErrorCode.NO_ERROR;
        Expression a = SqlExpression.a("_id", String.valueOf(ContentUris.parseId(uri)));
        Cursor query;
        try {
            ErrorCode errorCode2;
            query = this.f17638b.getContentResolver().query(Inbox.a, f17637a, a.a(), a.b(), null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        if (CursorHelper.a(query, "resp_st") == 228) {
                            errorCode2 = ErrorCode.MESSAGE_NOT_FOUND;
                        } else {
                            errorCode2 = errorCode;
                        }
                        if (CursorHelper.b(query, "exp") < this.f17639c.a() / 1000) {
                            errorCode2 = ErrorCode.MESSAGE_EXPIRED;
                        }
                        if (errorCode2 != ErrorCode.NO_ERROR) {
                            long b = CursorHelper.b(query, "thread_id");
                            Integer.valueOf(this.f17638b.getContentResolver().delete(uri, null, null));
                            this.f17644h.m17599a(CallerContext.a(getClass()), uri, ThreadKey.b(b));
                        }
                        if (query != null) {
                            query.close();
                        }
                        return errorCode2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            errorCode2 = errorCode;
            if (query != null) {
                query.close();
            }
            return errorCode2;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private void m17608a(Uri uri, Uri uri2) {
        Message a = this.f17643g.m17441a(uri);
        if (a != null) {
            this.f17644h.m17600a(CallerContext.a(getClass()), a, uri2);
            return;
        }
        BLog.c("ProcessMmsDownloadedAction", "Failed to load received message %s", new Object[]{uri.toString()});
    }

    private void m17612b(RetrieveConf retrieveConf) {
        PduBody d = retrieveConf.m3613d();
        for (int i = 0; i < d.m3624b(); i++) {
            PduPart a = d.m3620a(i);
            if ("video/mp4".equals(new String(a.m3694g()))) {
                try {
                    m17609a(a);
                } catch (Exception e) {
                    ((SmsTakeoverAnalyticsLogger) this.f17646j.get()).g(e.getMessage());
                    throw e;
                }
            }
        }
    }

    private void m17609a(PduPart pduPart) {
        FileOutputStream fileOutputStream;
        Throwable e;
        File a = MmsFileProvider.m17522a(this.f17638b, MmsFileProvider.m17523d());
        File a2 = MmsFileProvider.m17522a(this.f17638b, MmsFileProvider.m17523d());
        try {
            fileOutputStream = new FileOutputStream(a);
            try {
                fileOutputStream.write(pduPart.m3683a());
                try {
                    fileOutputStream.close();
                    try {
                        FutureDetour.a(((VideoTrimmer) this.f17645i.get()).m20003a(new VideoTrimmerParams(a, a2, -1, -2, null, true)), 60, TimeUnit.SECONDS, 1119806905);
                        byte[] b = Files.b(a2);
                        if (b == null) {
                            throw new MmsException("Remux result not valid");
                        }
                        pduPart.m3682a(b);
                    } catch (Throwable e2) {
                        throw new MmsException(e2);
                    }
                } finally {
                    a.delete();
                    a2.delete();
                }
            } catch (Throwable th) {
                e2 = th;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e2;
            }
        } catch (Throwable th2) {
            e2 = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e2;
        }
    }
}
