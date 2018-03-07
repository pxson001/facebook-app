package com.facebook.katana.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.content.FirstPartySecureContentProvider;
import com.facebook.inject.FbInjector;
import com.facebook.katana.binding.sessioninfo.SessionInfoHelper;
import com.facebook.proxygen.HTTPTransportCallback;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;

/* compiled from: μs */
public class FirstPartyUserValuesProvider extends FirstPartySecureContentProvider {
    private static final String f22b = (BuildConstants.n() + ".provider.FirstPartyUserValuesProvider");
    private static final String[] f23c = new String[]{"value"};
    private UriMatcher f24d;
    private FbInjector f25e;

    protected final void mo10a() {
        super.mo10a();
        this.f24d = new UriMatcher(-1);
        this.f24d.addURI(f22b, "user_values", 1);
        this.f25e = FbInjector.get(getContext());
        AppInitLockHelper.m8874a(getContext());
    }

    protected final Cursor mo6a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Object obj = null;
        if (uri != null && this.f24d.match(uri) == 1 && "name='active_session_info'".equals(str)) {
            String str3;
            ObjectMapper a = FbObjectMapperMethodAutoProvider.m6609a(this.f25e);
            Object a2 = SessionInfoHelper.m8877b(this.f25e).m8882a();
            if (a2 == null) {
                str3 = null;
            } else {
                try {
                    str3 = a.m6659a(a2);
                } catch (Throwable e) {
                    FbErrorReporterImpl.m2317a(this.f25e).m2343a("SessionInfoSerialization", "Couldn't serialize sessionInfo.", e);
                }
            }
            obj = str3;
            Cursor matrixCursor = new MatrixCursor(strArr);
            if (obj != null) {
                if (strArr == null) {
                    strArr = f23c;
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : r9) {
                    if ("name".equals(obj2)) {
                        arrayList.add("active_session_info");
                    } else if ("value".equals(obj2)) {
                        arrayList.add(obj);
                    } else {
                        throw new IllegalArgumentException("Only name and value are supported in the projection map");
                    }
                }
                matrixCursor.addRow(arrayList.toArray());
            }
            return matrixCursor;
        }
        throw new IllegalArgumentException("Unknown URL " + uri);
    }

    protected final String mo8a(Uri uri) {
        switch (this.f24d.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return "vnd.android.cursor.item/vnd.facebook.katana.uservalues";
            default:
                throw new IllegalArgumentException("Unknown URL " + uri);
        }
    }

    protected final Uri mo7a(Uri uri, ContentValues contentValues) {
        return null;
    }

    protected final int mo4a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    protected final int mo5a(Uri uri, String str, String[] strArr) {
        return 0;
    }
}
