package com.facebook.android.maps.internal;

import android.content.Context;
import android.util.Log;
import java.net.URL;

/* compiled from: available */
public class MapTileProvider extends CacheableUrlTileProvider {
    private static final String f8445d = MapTileProvider.class.getSimpleName();
    public static int f8446e = 0;
    private final int f8447f;
    public String f8448g;

    public final /* bridge */ /* synthetic */ void mo1075a() {
    }

    public MapTileProvider(Context context, int i, int i2) {
        super(context, i, i2);
        int i3 = context.getResources().getDisplayMetrics().densityDpi;
        if (i3 > 320) {
            this.f8447f = 320;
        } else if (i3 > 250) {
            this.f8447f = 250;
        } else {
            this.f8447f = 72;
        }
    }

    public final URL mo1076c(int i, int i2, int i3) {
        try {
            StringBuilder append;
            String str;
            if (f8446e == 0) {
                append = new StringBuilder().append(MapConfig.a(i, i2, i3)).append("&x=").append(i).append("&y=").append(i2).append("&z=").append(i3).append("&size=").append(this.f8309b).append("&ppi=").append(this.f8447f).append("&language=").append(MapConfig.a);
                if (this.f8448g != null) {
                    str = "&theme=" + this.f8448g;
                } else {
                    str = "";
                }
                return new URL(append.append(str).toString());
            } else if (f8446e == 2) {
                append = new StringBuilder("https://mts1.google.com/vt/lyrs=m&src=app&s=G&scale=");
                if (512 <= this.f8309b) {
                    str = "2";
                } else {
                    str = "1";
                }
                return new URL(append.append(str).append("&x=").append(i).append("&y=").append(i2).append("&z=").append(i3).append("&hl=").append(MapConfig.a).toString());
            } else if (f8446e == 4) {
                return new URL("https://dev503.prn2.facebook.com:8085/?width=" + this.f8309b + "&height=" + this.f8310c + "&zoom=" + i3 + "&x=" + i + "&y=" + i2 + "&language=" + MapConfig.a);
            } else {
                if (f8446e == 1) {
                    return new URL("http://1.base.maps.cit.api.here.com/maptile/2.1/maptile/newest/normal.day/" + i3 + "/" + i + "/" + i2 + "/" + this.f8309b + "/jpg?app_id=9wET31JBo5fPGrCwuHdB&app_code=QabaAYy2ULQhykNndQr98A&ppi=" + this.f8447f + "&lg=" + MapConfig.c);
                }
                if (f8446e == 3) {
                    return new URL("http://api.tiles.mapbox.com/v4/kunalb.ipim2pep/" + i3 + "/" + i + "/" + i2 + (512 <= this.f8309b ? "@2x" : "") + ".png?access_token=pk.eyJ1Ijoia3VuYWxiIiwiYSI6IjRwM3pBNkkifQ.eGAEbfEx3uuEOgXpOh-mxA");
                }
                Log.e(f8445d, "Invalid tile source specified.");
                return null;
            }
        } catch (Throwable e) {
            Log.e(f8445d, "Broken URL provided ", e);
            return null;
        }
    }

    protected final String mo1074a(int i, int i2, int i3) {
        return i + "_" + i2 + "_" + i3 + "_" + f8446e + "_" + MapConfig.b + "_" + MapConfig.l.b + (this.f8448g != null ? "_" + this.f8448g : "");
    }
}
