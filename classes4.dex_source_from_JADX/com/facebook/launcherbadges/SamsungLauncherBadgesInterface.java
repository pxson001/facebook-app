package com.facebook.launcherbadges;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.intent.HomeIntentHandlerHelper;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.TriState;
import javax.inject.Inject;

/* compiled from: mUsername */
public class SamsungLauncherBadgesInterface implements LauncherBadgesInterface {
    private final Context f8444a;
    private final AbstractFbErrorReporter f8445b;
    private final HomeIntentHandlerHelper f8446c;
    private final String f8447d;
    private final String f8448e;
    private TriState f8449f = TriState.UNSET;

    @Inject
    public SamsungLauncherBadgesInterface(Context context, AbstractFbErrorReporter abstractFbErrorReporter, HomeIntentHandlerHelper homeIntentHandlerHelper, String str) {
        this.f8444a = context;
        this.f8445b = abstractFbErrorReporter;
        this.f8446c = homeIntentHandlerHelper;
        this.f8448e = str;
        this.f8447d = context.getPackageName();
    }

    public final TriState mo683a(int i) {
        if (this.f8449f == TriState.UNSET) {
            this.f8449f = m8697a() ? TriState.YES : TriState.NO;
        }
        if (this.f8449f == TriState.NO) {
            return TriState.NO;
        }
        try {
            ContentResolver contentResolver = this.f8444a.getContentResolver();
            Uri parse = Uri.parse("content://com.sec.badge/apps");
            ContentValues contentValues = new ContentValues();
            contentValues.put("package", this.f8447d);
            contentValues.put("class", this.f8448e);
            contentValues.put("badgecount", Integer.valueOf(i));
            if (contentResolver.update(parse, contentValues, StringFormatUtil.a("%s=? AND %s=?", new Object[]{"package", "class"}), new String[]{this.f8447d, this.f8448e}) != 0) {
                return TriState.YES;
            }
            contentResolver.insert(parse, contentValues);
            return TriState.YES;
        } catch (IllegalArgumentException e) {
            this.f8449f = TriState.NO;
            return TriState.NO;
        } catch (Throwable e2) {
            this.f8445b.a(SamsungLauncherBadgesInterface.class.getName(), "unexpected exception", e2);
            this.f8449f = TriState.NO;
            return TriState.NO;
        }
    }

    private final boolean m8697a() {
        return this.f8446c.m8689b() || this.f8446c.m8691d();
    }
}
