package com.facebook.android.maps.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import com.facebook.android.maps.internal.DiskLruCache.Editor;
import com.facebook.android.maps.internal.DiskLruCache.Snapshot;
import com.facebook.android.maps.internal.GrandCentralDispatch.Dispatchable;
import com.facebook.android.maps.internal.analytics.AnalyticsEvent;
import com.facebook.android.maps.model.Tile;
import com.facebook.android.maps.model.UrlTileProvider;
import com.facebook.android.maps.model.UrlTileProvider.ByteData;
import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: away_team_name */
public abstract class CacheableUrlTileProvider extends UrlTileProvider {
    public static final BlockingQueue<ByteData> f8312d = new ArrayBlockingQueue(10);
    public static Thread f8313e;
    public static volatile DiskLruCache f8314f;
    private static final AtomicBoolean f8315g = new AtomicBoolean();
    public final AtomicLong f8316h = new AtomicLong(0);
    public final AtomicLong f8317i = new AtomicLong(0);

    /* compiled from: away_team_name */
    class BackgroundWriter implements Runnable {
        public void run() {
            while (true) {
                try {
                    ByteData byteData = (ByteData) CacheableUrlTileProvider.f8312d.take();
                    CacheableUrlTileProvider.m14436d(byteData);
                    UrlTileProvider.m14428c(byteData);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    protected abstract String mo1074a(int i, int i2, int i3);

    CacheableUrlTileProvider(final Context context, int i, int i2) {
        super(i, i2);
        if (f8315g.compareAndSet(false, true)) {
            GrandCentralDispatch.a(new Dispatchable(this) {
                final /* synthetic */ CacheableUrlTileProvider f8306b;

                public void run() {
                    Object obj = null;
                    Object obj2 = ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? 1 : null;
                    if (VERSION.SDK_INT < 23 || (context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0 && context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
                        obj = 1;
                    }
                    File cacheDir = (obj2 == null || obj == null) ? context.getCacheDir() : Environment.getExternalStorageDirectory();
                    long freeSpace = cacheDir.getFreeSpace();
                    if (freeSpace >= 30) {
                        try {
                            CacheableUrlTileProvider.f8314f = DiskLruCache.m14466a(new File(cacheDir, ".facebook_cache"), 2, 1, (long) (freeSpace >= 100 ? 5242880 : 2097152));
                            CacheableUrlTileProvider.f8313e = ThreadInitDetour.a(new BackgroundWriter(), 1398245509);
                            CacheableUrlTileProvider.f8313e.start();
                        } catch (Throwable e) {
                            AnalyticsEvent.p.a(e);
                        }
                    }
                }
            });
        }
    }

    public Tile mo1066b(int i, int i2, int i3) {
        URL c = mo1076c(i, i2, i3);
        if (c == null) {
            return a;
        }
        Tile a;
        String a2 = mo1074a(i, i2, i3);
        if (f8314f != null) {
            ByteData b = m14435b(a2);
            if (b != null) {
                a = Tile.m14611a(b.f8674b, b.f8675c);
                UrlTileProvider.m14428c(b);
                if (a != null) {
                    this.f8316h.incrementAndGet();
                    return a;
                }
            }
        }
        this.f8317i.incrementAndGet();
        ByteData a3 = m14429a(c);
        if (a3 == null) {
            return null;
        }
        a = Tile.m14611a(a3.f8674b, a3.f8675c);
        if (a != null) {
            if (f8314f == null) {
                UrlTileProvider.m14428c(a3);
            }
            a3.f8673a = a2;
            while (!f8312d.offer(a3)) {
                ByteData byteData = (ByteData) f8312d.poll();
                if (byteData != null) {
                    UrlTileProvider.m14428c(byteData);
                }
            }
            return a;
        }
        UrlTileProvider.m14428c(a3);
        return a;
    }

    public void mo1075a() {
    }

    public void m14439a(final String str) {
        if (AnalyticsEvent.z.c()) {
            AnalyticsEvent.D.a(new HashMap<String, Object>() {
            });
        }
    }

    public void mo1067b() {
        super.mo1067b();
        this.f8316h.set(0);
        this.f8317i.set(0);
    }

    private static ByteData m14435b(String str) {
        Snapshot a;
        Throwable e;
        Throwable th;
        ByteData byteData = null;
        if (f8314f != null) {
            try {
                a = f8314f.m14481a(str);
                if (a != null) {
                    try {
                        InputStream a2 = a.m14461a(0);
                        if (a2 != null) {
                            byteData = UrlTileProvider.m14427a(a2, false);
                        }
                        if (a != null) {
                            a.close();
                        }
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            AnalyticsEvent.o.a(e);
                            if (a != null) {
                                a.close();
                            }
                            return byteData;
                        } catch (Throwable th2) {
                            th = th2;
                            if (a != null) {
                                a.close();
                            }
                            throw th;
                        }
                    }
                } else if (a != null) {
                    a.close();
                }
            } catch (IOException e3) {
                e = e3;
                a = null;
                AnalyticsEvent.o.a(e);
                if (a != null) {
                    a.close();
                }
                return byteData;
            } catch (Throwable e4) {
                a = null;
                th = e4;
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        }
        return byteData;
    }

    public static void m14436d(ByteData byteData) {
        Throwable e;
        OutputStream outputStream = null;
        Editor b;
        try {
            if (byteData.f8673a == null) {
                AnalyticsEvent.m.a("Tile stringKey is null");
                return;
            }
            b = f8314f.m14482b(byteData.f8673a);
            if (b != null) {
                try {
                    outputStream = b.m14449a(0);
                    if (outputStream == null) {
                        if (b != null) {
                            b.m14452c();
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                                return;
                            } catch (IOException e2) {
                                return;
                            }
                        }
                        return;
                    }
                    outputStream.write(byteData.f8674b, 0, byteData.f8675c);
                    b.m14450a();
                    if (b != null) {
                        b.m14452c();
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    try {
                        AnalyticsEvent.n.a(e);
                        if (b != null) {
                            b.m14452c();
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                    } catch (Throwable th) {
                        e = th;
                        if (b != null) {
                            b.m14452c();
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e6) {
                            }
                        }
                        throw e;
                    }
                }
            } else if (b != null) {
                b.m14452c();
            }
        } catch (IOException e7) {
            e = e7;
            b = outputStream;
            AnalyticsEvent.n.a(e);
            if (b != null) {
                b.m14452c();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th2) {
            e = th2;
            b = outputStream;
            if (b != null) {
                b.m14452c();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            throw e;
        }
    }
}
