package com.facebook.messaging.sms.defaultapp.action;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android_src.mmsv2.DownloadRequest;
import android_src.mmsv2.MmsManager;
import android_src.mmsv2.MmsService;
import android_src.mmsv2.Utils;
import com.facebook.content.SecurePendingIntent;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.sms.defaultapp.MmsFileProvider;
import com.facebook.messaging.sms.defaultapp.SmsDefaultAppManager;
import com.facebook.messaging.sms.defaultapp.SmsReceiver;
import com.facebook.messaging.sms.util.TelephonyUtils;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.orca.media.upload.MEDIA_UPLOAD_COMPLETE */
public class ProcessDownloadMmsAction {
    private static final String[] f17634a = new String[]{"ct_l"};
    private final Context f17635b;
    private final SmsDefaultAppManager f17636c;

    public static ProcessDownloadMmsAction m17604b(InjectorLike injectorLike) {
        return new ProcessDownloadMmsAction((Context) injectorLike.getInstance(Context.class), SmsDefaultAppManager.a(injectorLike));
    }

    @Inject
    public ProcessDownloadMmsAction(Context context, SmsDefaultAppManager smsDefaultAppManager) {
        this.f17635b = context;
        this.f17636c = smsDefaultAppManager;
    }

    public final void m17605a(Bundle bundle) {
        String a;
        Uri uri = (Uri) bundle.getParcelable("extra_uri");
        boolean z = bundle.getBoolean("extra_repersist_on_error");
        String string = bundle.getString("location_url");
        Uri d = MmsFileProvider.m17523d();
        Intent intent = new Intent("com.facebook.messaging.sms.MMS_DOWNLOADED", uri, this.f17635b, SmsReceiver.class);
        intent.putExtra("content_uri", d);
        intent.putExtra("extra_uri", uri);
        if (z) {
            intent.putExtra("extra_repersist_on_error", true);
        }
        if (Strings.isNullOrEmpty(string)) {
            a = m17603a(uri);
        } else {
            a = string;
        }
        PendingIntent b = SecurePendingIntent.b(this.f17635b, 0, intent, 134217728);
        this.f17636c.b();
        int a2 = TelephonyUtils.m17716a(-1);
        Context context = this.f17635b;
        if (MmsManager.m3541a()) {
            int b2 = Utils.m3585b(a2);
            Utils.m3581a(b2).downloadMultimediaMessage(context, a, d, MmsManager.m3538a(b2), b);
            return;
        }
        MmsService.m3561a(context, new DownloadRequest(a, d, b));
    }

    public static ProcessDownloadMmsAction m17602a(InjectorLike injectorLike) {
        return m17604b(injectorLike);
    }

    @Nullable
    private String m17603a(Uri uri) {
        String str = null;
        Cursor query = this.f17635b.getContentResolver().query(uri, f17634a, null, null, null);
        if (query != null) {
            try {
                if (query.getCount() == 1 && query.moveToFirst()) {
                    str = query.getString(0);
                } else {
                    query.close();
                }
            } finally {
                query.close();
            }
        }
        return str;
    }
}
