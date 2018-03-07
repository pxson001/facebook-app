package com.facebook.android.maps;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;

/* compiled from: b0 */
class MapReporterLauncher$2 implements OnClickListener {
    final /* synthetic */ Uri f8174a;
    final /* synthetic */ MapReporterLauncher f8175b;

    MapReporterLauncher$2(MapReporterLauncher mapReporterLauncher, Uri uri) {
        this.f8175b = mapReporterLauncher;
        this.f8174a = uri;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        MapReporterLauncher.a(this.f8175b, this.f8174a, "open");
        this.f8175b.a(this.f8174a);
    }
}
