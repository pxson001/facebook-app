package com.facebook.android.maps;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import com.facebook.android.maps.internal.analytics.AnalyticsEvent;

/* compiled from: edit_history */
public class MapReporterLauncher {
    private static final Uri f13412a = Uri.parse("https://www.facebook.com/maps/report/?");
    public final Context f13413b;
    private final DialogBuilder f13414c;
    private final ActivityLauncher f13415d;
    private final CharSequence f13416e;
    private final CharSequence f13417f;

    /* compiled from: edit_history */
    public interface DialogBuilder {
        Dialog mo958a();

        DialogBuilder mo959a(CharSequence charSequence);

        DialogBuilder mo960a(CharSequence charSequence, OnClickListener onClickListener);

        DialogBuilder mo961b(CharSequence charSequence, OnClickListener onClickListener);
    }

    /* compiled from: edit_history */
    public interface ActivityLauncher {
        void mo969a(Intent intent);
    }

    public MapReporterLauncher(Context context) {
        this(context, "Open", "This map is operated by third-party providers. You will be redirected to them to provide feedback.", null, null);
    }

    public MapReporterLauncher(Context context, CharSequence charSequence, CharSequence charSequence2, @Nullable DialogBuilder dialogBuilder, @Nullable ActivityLauncher activityLauncher) {
        this.f13413b = context;
        this.f13416e = charSequence;
        this.f13417f = charSequence2;
        if (dialogBuilder == null) {
            dialogBuilder = new 5(this);
        }
        this.f13414c = dialogBuilder;
        if (activityLauncher == null) {
            activityLauncher = new 6(this);
        }
        this.f13415d = activityLauncher;
    }

    public void m14311a(Context context, Uri uri) {
        Dialog a = this.f13414c.mo959a(this.f13417f).mo960a(this.f13416e, new 2(this, uri)).mo961b(this.f13413b.getResources().getString(17039360), new 1(this, uri)).mo958a();
        a.setOnCancelListener(new 3(this, uri));
        a.show();
    }

    protected void mo957a(Uri uri) {
        this.f13415d.mo969a(new Intent("android.intent.action.VIEW").setData(f13412a.buildUpon().appendQueryParameter("static_map_url", uri.toString()).build()).setFlags(268435456));
    }

    public static void m14310a(MapReporterLauncher mapReporterLauncher, Uri uri, String str) {
        AnalyticsEvent.f13537x.m14394a(new 4(mapReporterLauncher, str, uri));
    }
}
