package com.facebook.android.maps;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;

/* compiled from: b0 */
class MapReporterLauncher$1 implements OnClickListener {
    final /* synthetic */ Uri f8172a;
    final /* synthetic */ MapReporterLauncher f8173b;

    MapReporterLauncher$1(MapReporterLauncher mapReporterLauncher, Uri uri) {
        this.f8173b = mapReporterLauncher;
        this.f8172a = uri;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        MapReporterLauncher.a(this.f8173b, this.f8172a, "cancel");
    }
}
