package com.facebook.growth.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.Profile;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: edit_cta */
public class DeviceOwnerProfilePhotoUtil {
    private final Context f14921a;
    private final AbstractFbErrorReporter f14922b;

    public static DeviceOwnerProfilePhotoUtil m17385b(InjectorLike injectorLike) {
        return new DeviceOwnerProfilePhotoUtil((Context) injectorLike.getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public DeviceOwnerProfilePhotoUtil(Context context, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f14921a = context.getApplicationContext();
        this.f14922b = abstractFbErrorReporter;
    }

    public final Uri m17386a() {
        try {
            return m17384b();
        } catch (Throwable e) {
            this.f14922b.a("Prefill Profile Photo via Me Profile in user account NUX flow on ICS+", e);
            return null;
        }
    }

    @TargetApi(14)
    private Uri m17384b() {
        Uri uri = null;
        if (this.f14921a.checkCallingOrSelfPermission("android.permission.READ_PROFILE") == 0) {
            Cursor query = this.f14921a.getContentResolver().query(Uri.withAppendedPath(Profile.CONTENT_URI, "data"), new String[]{"photo_uri"}, "mimetype = ?", new String[]{"vnd.android.cursor.item/photo"}, null);
            if (query != null && query.getCount() > 0) {
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex("photo_uri"));
                if (string != null) {
                    uri = Uri.parse(string);
                }
            }
            if (query != null) {
                query.close();
            }
        }
        return uri;
    }
}
