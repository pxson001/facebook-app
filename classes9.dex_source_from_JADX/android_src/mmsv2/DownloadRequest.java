package android_src.mmsv2;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.debug.log.BLog;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: setThreadParticipantNickname */
public class DownloadRequest extends MmsRequest {
    public static final Creator<DownloadRequest> CREATOR = new C03392();

    /* compiled from: setThreadParticipantNickname */
    final class C03392 implements Creator<DownloadRequest> {
        C03392() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DownloadRequest(parcel);
        }

        public final Object[] newArray(int i) {
            return new DownloadRequest[i];
        }
    }

    public DownloadRequest(String str, Uri uri, PendingIntent pendingIntent) {
        super(str, uri, pendingIntent);
    }

    protected final boolean mo120a(Context context, Bundle bundle) {
        return true;
    }

    protected final boolean mo119a(Context context, Intent intent, byte[] bArr) {
        return m3519a(context, this.f3770b, bArr);
    }

    protected final byte[] mo121a(MmsNetworkManager mmsNetworkManager, ApnSettingsLoader$Apn apnSettingsLoader$Apn, Bundle bundle, String str, String str2) {
        return mmsNetworkManager.m3554b().m3536a(mo118a(apnSettingsLoader$Apn), null, "GET", !TextUtils.isEmpty(apnSettingsLoader$Apn.mo114b()), apnSettingsLoader$Apn.mo114b(), apnSettingsLoader$Apn.mo115c(), bundle, str, str2);
    }

    protected final String mo118a(ApnSettingsLoader$Apn apnSettingsLoader$Apn) {
        return this.f3769a;
    }

    private boolean m3519a(final Context context, final Uri uri, final byte[] bArr) {
        if (uri == null || bArr == null) {
            return false;
        }
        Future a = ExecutorDetour.a(this.f3772d, new Callable<Boolean>(this) {
            final /* synthetic */ DownloadRequest f3767d;

            public Object call() {
                AutoCloseOutputStream autoCloseOutputStream;
                Object valueOf;
                Throwable e;
                try {
                    autoCloseOutputStream = new AutoCloseOutputStream(context.getContentResolver().openFileDescriptor(uri, "w"));
                    try {
                        autoCloseOutputStream.write(bArr);
                        valueOf = Boolean.valueOf(true);
                        try {
                            autoCloseOutputStream.close();
                        } catch (IOException e2) {
                        }
                    } catch (IOException e3) {
                        e = e3;
                        try {
                            BLog.b("MmsLib", "Writing PDU to downloader: IO exception", e);
                            valueOf = Boolean.valueOf(false);
                            if (autoCloseOutputStream != null) {
                                try {
                                    autoCloseOutputStream.close();
                                } catch (IOException e4) {
                                }
                            }
                            return valueOf;
                        } catch (Throwable th) {
                            e = th;
                            if (autoCloseOutputStream != null) {
                                try {
                                    autoCloseOutputStream.close();
                                } catch (IOException e5) {
                                }
                            }
                            throw e;
                        }
                    }
                } catch (IOException e6) {
                    e = e6;
                    autoCloseOutputStream = null;
                    BLog.b("MmsLib", "Writing PDU to downloader: IO exception", e);
                    valueOf = Boolean.valueOf(false);
                    if (autoCloseOutputStream != null) {
                        autoCloseOutputStream.close();
                    }
                    return valueOf;
                } catch (Throwable th2) {
                    e = th2;
                    autoCloseOutputStream = null;
                    if (autoCloseOutputStream != null) {
                        autoCloseOutputStream.close();
                    }
                    throw e;
                }
                return valueOf;
            }
        }, 1713413473);
        try {
            return ((Boolean) FutureDetour.a(a, 30000, TimeUnit.MILLISECONDS, 961438604)).booleanValue();
        } catch (Exception e) {
            a.cancel(true);
            return false;
        }
    }

    public DownloadRequest(Parcel parcel) {
        super(parcel);
    }
}
