package android_src.mmsv2;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.debug.log.BLog;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: setPreviousStoryFinder(..) was not called */
class SendRequest extends MmsRequest {
    public static final Creator<SendRequest> CREATOR = new C03452();
    private byte[] f3813e;

    /* compiled from: setPreviousStoryFinder(..) was not called */
    final class C03452 implements Creator<SendRequest> {
        C03452() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SendRequest(parcel);
        }

        public final Object[] newArray(int i) {
            return new SendRequest[i];
        }
    }

    SendRequest(String str, Uri uri, PendingIntent pendingIntent) {
        super(str, uri, pendingIntent);
    }

    protected final boolean mo120a(Context context, Bundle bundle) {
        this.f3813e = m3576a(context, this.f3770b, bundle.getInt("maxMessageSize", 614400));
        return this.f3813e != null;
    }

    protected final boolean mo119a(Context context, Intent intent, byte[] bArr) {
        if (!(bArr == null || intent == null)) {
            if (bArr.length > 1024000) {
                return false;
            }
            intent.putExtra("android.telephony.extra.MMS_DATA", bArr);
        }
        return true;
    }

    protected final byte[] mo121a(MmsNetworkManager mmsNetworkManager, ApnSettingsLoader$Apn apnSettingsLoader$Apn, Bundle bundle, String str, String str2) {
        return mmsNetworkManager.m3554b().m3536a(mo118a(apnSettingsLoader$Apn), this.f3813e, "POST", !TextUtils.isEmpty(apnSettingsLoader$Apn.mo114b()), apnSettingsLoader$Apn.mo114b(), apnSettingsLoader$Apn.mo115c(), bundle, str, str2);
    }

    protected final String mo118a(ApnSettingsLoader$Apn apnSettingsLoader$Apn) {
        return !TextUtils.isEmpty(this.f3769a) ? this.f3769a : apnSettingsLoader$Apn.mo113a();
    }

    private byte[] m3576a(final Context context, final Uri uri, final int i) {
        if (uri == null) {
            return null;
        }
        Future a = ExecutorDetour.a(this.f3772d, new Callable<byte[]>(this) {
            final /* synthetic */ SendRequest f3812d;

            public Object call() {
                Throwable e;
                Throwable th;
                AutoCloseInputStream autoCloseInputStream;
                try {
                    autoCloseInputStream = new AutoCloseInputStream(context.getContentResolver().openFileDescriptor(uri, "r"));
                    try {
                        Object obj = new byte[(i + 1)];
                        int read = autoCloseInputStream.read(obj, 0, i + 1);
                        if (read <= 0) {
                            BLog.b("MmsLib", "Reading PDU from sender: empty PDU");
                            try {
                                autoCloseInputStream.close();
                                return null;
                            } catch (IOException e2) {
                                return null;
                            }
                        } else if (read > i) {
                            BLog.b("MmsLib", "Reading PDU from sender: PDU too large");
                            try {
                                autoCloseInputStream.close();
                                return null;
                            } catch (IOException e3) {
                                return null;
                            }
                        } else {
                            Object obj2 = new byte[read];
                            System.arraycopy(obj, 0, obj2, 0, read);
                            try {
                                autoCloseInputStream.close();
                            } catch (IOException e4) {
                            }
                            return obj2;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        try {
                            BLog.b("MmsLib", "Reading PDU from sender: IO exception", e);
                            if (autoCloseInputStream != null) {
                                return null;
                            }
                            try {
                                autoCloseInputStream.close();
                                return null;
                            } catch (IOException e6) {
                                return null;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (autoCloseInputStream != null) {
                                try {
                                    autoCloseInputStream.close();
                                } catch (IOException e7) {
                                }
                            }
                            throw th;
                        }
                    }
                } catch (IOException e8) {
                    e = e8;
                    autoCloseInputStream = null;
                    BLog.b("MmsLib", "Reading PDU from sender: IO exception", e);
                    if (autoCloseInputStream != null) {
                        return null;
                    }
                    autoCloseInputStream.close();
                    return null;
                } catch (Throwable e9) {
                    autoCloseInputStream = null;
                    th = e9;
                    if (autoCloseInputStream != null) {
                        autoCloseInputStream.close();
                    }
                    throw th;
                }
            }
        }, -1603351619);
        try {
            return (byte[]) FutureDetour.a(a, 30000, TimeUnit.MILLISECONDS, 1987457253);
        } catch (Exception e) {
            a.cancel(true);
            return null;
        }
    }

    public SendRequest(Parcel parcel) {
        super(parcel);
    }
}
