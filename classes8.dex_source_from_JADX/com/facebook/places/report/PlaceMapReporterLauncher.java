package com.facebook.places.report;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.content.SecureContextHelper;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.inject.Assisted;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.maps.report.FbMapReporterLauncher;
import com.facebook.places.suggestions.PlaceSuggestionsIntentBuilder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: sections_can_add */
public class PlaceMapReporterLauncher extends FbMapReporterLauncher {
    public final long f3616a;
    public final String f3617b;
    public final String f3618c;
    private final AnalyticsLogger f3619d;
    public final SecureContextHelper f3620e;
    public final PlaceSuggestionsIntentBuilder f3621f;

    @Inject
    public PlaceMapReporterLauncher(@Assisted Long l, @Assisted String str, @Nullable @Assisted String str2, Context context, ZeroDialogController zeroDialogController, AnalyticsLogger analyticsLogger, SecureContextHelper secureContextHelper, PlaceSuggestionsIntentBuilder placeSuggestionsIntentBuilder) {
        super(zeroDialogController, context, secureContextHelper);
        this.f3616a = l.longValue();
        this.f3617b = str;
        this.f3618c = str2;
        this.f3619d = analyticsLogger;
        this.f3620e = secureContextHelper;
        this.f3621f = placeSuggestionsIntentBuilder;
    }

    public final void m3550a(final Context context, final Uri uri) {
        Resources resources = context.getResources();
        PopoverMenu popoverMenu = new PopoverMenu(context);
        popoverMenu.a(this.f3617b, resources.getText(2131235320)).setIcon(2130840023);
        popoverMenu.a(2131235318, 2131235319).setIcon(2130839947);
        View textView = new TextView(context);
        textView.setText(2131235317);
        textView.setTextAppearance(context, 2131624229);
        View listView = new ListView(context);
        listView.setAdapter(popoverMenu);
        listView.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ PlaceMapReporterLauncher f3613c;

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                switch (i) {
                    case 0:
                        PlaceMapReporterLauncher.m3548a(this.f3613c, this.f3613c.f3616a, uri, "report_place");
                        this.f3613c.f3620e.a(this.f3613c.f3621f.m3591a(this.f3613c.f3616a, this.f3613c.f3617b, this.f3613c.f3618c, null, CrowdEntryPoint.MAP_REPORT_BUTTON_MENU), context);
                        return;
                    case 1:
                        PlaceMapReporterLauncher.m3548a(this.f3613c, this.f3613c.f3616a, uri, "report_map");
                        PlaceMapReporterLauncher.m3549b(this.f3613c, context, uri);
                        return;
                    default:
                        return;
                }
            }
        });
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131430020);
        AlertDialog a = new Builder(context).a(textView).a(listView, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize).a();
        a.setOnCancelListener(new OnCancelListener(this) {
            final /* synthetic */ PlaceMapReporterLauncher f3615b;

            public void onCancel(DialogInterface dialogInterface) {
                PlaceMapReporterLauncher.m3548a(this.f3615b, this.f3615b.f3616a, uri, "cancel");
            }
        });
        a.show();
    }

    public static void m3549b(PlaceMapReporterLauncher placeMapReporterLauncher, Context context, Uri uri) {
        super.a(context, uri);
    }

    public static void m3548a(PlaceMapReporterLauncher placeMapReporterLauncher, long j, Uri uri, String str) {
        AnalyticsLogger analyticsLogger = placeMapReporterLauncher.f3619d;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("oxygen_map_place_reporter_dialog_clicked");
        honeyClientEvent.c = "oxygen_map";
        analyticsLogger.a(honeyClientEvent.b("place_id", String.valueOf(j)).b("map_uri", uri.toString()).b("action", str));
    }
}
