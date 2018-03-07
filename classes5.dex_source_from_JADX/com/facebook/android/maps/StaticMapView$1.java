package com.facebook.android.maps;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.facebook.android.maps.internal.GrandCentralDispatch;
import com.facebook.android.maps.internal.GrandCentralDispatch.Dispatchable;
import com.facebook.android.maps.internal.analytics.AnalyticsEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

/* compiled from: awesomizer_discovery */
class StaticMapView$1 extends Dispatchable {
    final /* synthetic */ View f8245a;
    final /* synthetic */ String f8246b;
    final /* synthetic */ Uri f8247c;
    final /* synthetic */ StaticMapView f8248d;

    StaticMapView$1(StaticMapView staticMapView, View view, String str, Uri uri) {
        this.f8248d = staticMapView;
        this.f8245a = view;
        this.f8246b = str;
        this.f8247c = uri;
    }

    public void run() {
        final Drawable b = m14389b();
        if (b != null && this.f8248d.f == this) {
            GrandCentralDispatch.c(new Dispatchable(this) {
                final /* synthetic */ StaticMapView$1 f8244c;

                /* compiled from: awesomizer_discovery */
                class C09171 extends HashMap<String, Object> {
                    C09171() {
                        put("duration", Long.valueOf(AnalyticsEvent.a() - C09181.this.f8244c.f8248d.r));
                        put("surface", C09181.this.f8244c.f8246b == null ? "unknown" : C09181.this.f8244c.f8246b);
                    }
                }

                public void run() {
                    ((ImageView) this.f8244c.f8245a).setImageDrawable(b);
                    if (this.f8244c.f8248d.r > 0 && AnalyticsEvent.C.c()) {
                        AnalyticsEvent.C.a(new C09171());
                        this.f8244c.f8248d.r = 0;
                    }
                    if (this.f8244c.f8248d.f == this) {
                        this.f8244c.f8248d.f = null;
                    }
                }
            });
        }
    }

    private Drawable m14389b() {
        InputStream openStream;
        Throwable e;
        Throwable th;
        Drawable drawable = null;
        try {
            openStream = new URL(this.f8247c.toString()).openStream();
            if (openStream != null) {
                try {
                    drawable = Drawable.createFromStream(openStream, "mapImage");
                    if (openStream != null) {
                        try {
                            openStream.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        AnalyticsEvent.t.a(e);
                        if (openStream != null) {
                            try {
                                openStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        return drawable;
                    } catch (Throwable th2) {
                        th = th2;
                        if (openStream != null) {
                            try {
                                openStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        throw th;
                    }
                }
            } else if (openStream != null) {
                try {
                    openStream.close();
                } catch (IOException e6) {
                }
            }
        } catch (IOException e7) {
            e = e7;
            openStream = drawable;
            AnalyticsEvent.t.a(e);
            if (openStream != null) {
                openStream.close();
            }
            return drawable;
        } catch (Throwable e8) {
            openStream = drawable;
            th = e8;
            if (openStream != null) {
                openStream.close();
            }
            throw th;
        }
        return drawable;
    }
}
