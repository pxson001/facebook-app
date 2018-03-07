package com.facebook.katana;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.service.AppSession;
import com.facebook.katana.urimap.IntentHandlerUtil;

/* compiled from: via_graph */
public class ContactUriHandler extends BaseFacebookActivity {
    public final void m619b(Bundle bundle) {
        super.b(bundle);
        Uri data = getIntent().getData();
        AppSession a = AppSession.a(this, true);
        if (a != null) {
            String str;
            String str2 = FBLinks.a("profile/") + a.b().userId;
            if (data != null && data.getScheme().equals("content") && "com.android.contacts".equals(data.getAuthority())) {
                String resolveType;
                ContentResolver contentResolver = getContentResolver();
                Cursor query = contentResolver.query(data, new String[]{"data1"}, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            long j = query.getLong(0);
                            resolveType = getIntent().resolveType(contentResolver);
                            if ("vnd.android.cursor.item/vnd.facebook.profile".equals(resolveType)) {
                                resolveType = FBLinks.a("profile/") + j;
                            } else if ("vnd.android.cursor.item/vnd.facebook.presence".equals(resolveType)) {
                                resolveType = StringFormatUtil.formatStrLocaleSafe(FBLinks.V, Long.valueOf(j));
                            }
                            if (query == null) {
                                query.close();
                                str = resolveType;
                            } else {
                                str = resolveType;
                            }
                        }
                    } catch (Throwable th) {
                        if (query != null) {
                            query.close();
                        }
                    }
                }
                resolveType = str2;
                if (query == null) {
                    str = resolveType;
                } else {
                    query.close();
                    str = resolveType;
                }
            } else {
                str = str2;
            }
            IntentHandlerUtil.m1246a(hz_()).m1254a((Context) this, str);
        }
        finish();
    }
}
