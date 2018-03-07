package com.facebook.katana.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.facebook.attribution.AttributionState;
import com.facebook.attribution.AttributionStateSerializer;
import com.facebook.content.PublicContentProvider;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesUtil;
import javax.annotation.Nullable;

/* compiled from: ‎ */
public class AttributionIdProvider extends PublicContentProvider {
    public final synchronized Cursor mo6a(Uri uri, String[] strArr, @Nullable String str, String[] strArr2, @Nullable String str2) {
        Cursor matrixCursor;
        String str3 = null;
        synchronized (this) {
            AttributionState a;
            Info info;
            String str4;
            String a2;
            try {
                a = AttributionStateSerializer.m21435a(getContext());
            } catch (Exception e) {
                a = null;
            }
            if (a != null) {
                if (a.f14990d) {
                    try {
                        Info a3;
                        if (GooglePlayServicesUtil.m153a(getContext()) == 0) {
                            a3 = AdvertisingIdClient.a(getContext());
                        } else {
                            a3 = null;
                        }
                        info = a3;
                    } catch (Exception e2) {
                    }
                    str4 = a == null ? a.f14987a : null;
                    if (info == null) {
                        a2 = info.a();
                    } else {
                        a2 = null;
                    }
                    if (info != null) {
                        str3 = Boolean.toString(info.b());
                    }
                    matrixCursor = new MatrixCursor(new String[]{"aid", "androidid", "limit_tracking"});
                    matrixCursor.addRow(new String[]{str4, a2, str3});
                }
            }
            info = null;
            if (a == null) {
            }
            if (info == null) {
                a2 = null;
            } else {
                a2 = info.a();
            }
            if (info != null) {
                str3 = Boolean.toString(info.b());
            }
            matrixCursor = new MatrixCursor(new String[]{"aid", "androidid", "limit_tracking"});
            matrixCursor.addRow(new String[]{str4, a2, str3});
        }
        return matrixCursor;
    }

    public final int mo5a(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }

    public final String mo8a(Uri uri) {
        throw new UnsupportedOperationException();
    }

    public final Uri mo7a(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException();
    }

    public final int mo4a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }
}
