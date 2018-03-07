package com.facebook.android.maps;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.net.Uri;

/* compiled from: b0 */
class MapReporterLauncher$3 implements OnCancelListener {
    final /* synthetic */ Uri f8176a;
    final /* synthetic */ MapReporterLauncher f8177b;

    MapReporterLauncher$3(MapReporterLauncher mapReporterLauncher, Uri uri) {
        this.f8177b = mapReporterLauncher;
        this.f8176a = uri;
    }

    public void onCancel(DialogInterface dialogInterface) {
        MapReporterLauncher.a(this.f8177b, this.f8176a, "cancel");
    }
}
