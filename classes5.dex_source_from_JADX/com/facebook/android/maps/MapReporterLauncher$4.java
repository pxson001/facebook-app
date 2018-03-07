package com.facebook.android.maps;

import android.net.Uri;
import java.util.HashMap;

/* compiled from: b0 */
class MapReporterLauncher$4 extends HashMap<String, String> {
    final /* synthetic */ MapReporterLauncher this$0;
    final /* synthetic */ String val$action;
    final /* synthetic */ Uri val$staticMapUrl;

    MapReporterLauncher$4(MapReporterLauncher mapReporterLauncher, String str, Uri uri) {
        this.this$0 = mapReporterLauncher;
        this.val$action = str;
        this.val$staticMapUrl = uri;
        put("action", this.val$action);
        put("map_uri", this.val$staticMapUrl.toString());
    }
}
