package com.facebook.launcherbadges;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.intent.HomeIntentHandlerHelper;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.TriState;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;

@NotThreadSafe
/* compiled from: magnetic_field_uncalibrated */
public class HtcLauncherBadgesInterface implements LauncherBadgesInterface {
    private static Pattern f8419l;
    private final String f8420a = "content://com.htc.launcher.settings/favorites";
    private final String f8421b = "_id";
    private final String f8422c = "intent";
    private final Context f8423d;
    private final PackageManager f8424e;
    private final AbstractFbErrorReporter f8425f;
    private final HomeIntentHandlerHelper f8426g;
    private final String f8427h;
    private final String f8428i;
    private TriState f8429j;
    private float f8430k;

    @Inject
    public HtcLauncherBadgesInterface(Context context, PackageManager packageManager, AbstractFbErrorReporter abstractFbErrorReporter, HomeIntentHandlerHelper homeIntentHandlerHelper, String str) {
        this.f8423d = context;
        this.f8424e = packageManager;
        this.f8425f = abstractFbErrorReporter;
        this.f8426g = homeIntentHandlerHelper;
        this.f8428i = str;
        this.f8427h = context.getPackageName();
        this.f8429j = TriState.UNSET;
    }

    public final TriState mo683a(int i) {
        if (this.f8429j == TriState.UNSET) {
            this.f8429j = m8682b() ? TriState.YES : TriState.NO;
        }
        if (this.f8429j == TriState.NO) {
            return TriState.NO;
        }
        try {
            ComponentName componentName = new ComponentName(this.f8427h, this.f8428i);
            Intent intent;
            if (this.f8430k >= 4.0f && this.f8430k < 5.0f) {
                intent = new Intent("com.htc.launcher.action.UPDATE_SHORTCUT");
                if (VERSION.SDK_INT >= 12) {
                    m8681a(intent);
                }
                intent.putExtra("packagename", this.f8427h);
                intent.putExtra("count", i);
                this.f8423d.sendBroadcast(intent);
                Iterator it = m8679a().iterator();
                while (it.hasNext()) {
                    Integer num = (Integer) it.next();
                    Intent intent2 = new Intent("com.htc.launcher.action.UPDATE_SHORTCUT");
                    if (VERSION.SDK_INT >= 12) {
                        m8681a(intent2);
                    }
                    intent2.putExtra("packagename", this.f8427h);
                    intent2.putExtra("favorite_item_id", num.longValue());
                    String[] strArr = new String[1];
                    strArr[0] = StringFormatUtil.a("%%%%s%%", new Object[]{componentName.flattenToShortString()});
                    intent2.putExtra("selectArgs", strArr);
                    intent2.putExtra("count", i);
                    this.f8423d.sendBroadcast(intent2);
                }
            } else if (this.f8430k >= 5.0f) {
                intent = new Intent("com.htc.launcher.action.SET_NOTIFICATION");
                if (VERSION.SDK_INT >= 12) {
                    m8681a(intent);
                }
                intent.putExtra("com.htc.launcher.extra.COMPONENT", componentName.flattenToShortString());
                intent.putExtra("com.htc.launcher.extra.COUNT", i);
                this.f8423d.sendBroadcast(intent);
            }
            return TriState.UNSET;
        } catch (Throwable e) {
            this.f8425f.a(HtcLauncherBadgesInterface.class.getName(), "unexpected exception", e);
            this.f8429j = TriState.NO;
            return TriState.NO;
        }
    }

    private final ImmutableSet<Integer> m8679a() {
        Throwable th;
        ContentResolver contentResolver = this.f8423d.getContentResolver();
        Builder builder = ImmutableSet.builder();
        Cursor query;
        try {
            query = contentResolver.query(Uri.parse("content://com.htc.launcher.settings/favorites"), new String[]{"_id", "intent"}, StringFormatUtil.a("%s LIKE ?", new Object[]{"intent"}), new String[]{"%" + this.f8427h + "%"}, null);
            try {
                int columnIndex = query.getColumnIndex("_id");
                int columnIndex2 = query.getColumnIndex("intent");
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    try {
                        ComponentName component = Intent.parseUri(query.getString(columnIndex2), 0).getComponent();
                        if (component != null && this.f8427h.equals(component.getPackageName()) && this.f8428i.equals(component.getClassName())) {
                            builder.c(Integer.valueOf(query.getInt(columnIndex)));
                        }
                    } catch (URISyntaxException e) {
                    }
                    query.moveToNext();
                }
                if (query != null) {
                    query.close();
                }
                return builder.b();
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    @TargetApi(12)
    private static final void m8681a(Intent intent) {
        intent.setFlags(16);
    }

    private final boolean m8682b() {
        if (!this.f8426g.m8688a()) {
            return false;
        }
        for (FeatureInfo featureInfo : this.f8424e.getSystemAvailableFeatures()) {
            try {
                Float a = m8680a(featureInfo.name);
                if (a != null && a.floatValue() >= 4.0f) {
                    this.f8430k = a.floatValue();
                    return true;
                }
            } catch (NumberFormatException e) {
            }
        }
        return false;
    }

    @Nullable
    @VisibleForTesting
    private static Float m8680a(String str) {
        if (str == null || !str.startsWith("com.htc.software.Sense")) {
            return null;
        }
        if (f8419l == null) {
            f8419l = Pattern.compile("com\\.htc\\.software\\.Sense(\\d+(?:\\.\\d+)?).*");
        }
        Matcher matcher = f8419l.matcher(str);
        if (matcher.matches()) {
            return Float.valueOf(Float.parseFloat(matcher.group(1)));
        }
        throw new NumberFormatException("could not find version");
    }
}
