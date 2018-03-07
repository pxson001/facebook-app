package com.facebook.android.maps.model;

import com.facebook.android.maps.internal.SynchronizedPool;
import com.facebook.android.maps.internal.analytics.AnalyticsEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: away_team_fan_count */
public abstract class UrlTileProvider implements TileProvider {
    private static final SynchronizedPool<ByteData> f8308d = new SynchronizedPool(32);
    protected int f8309b;
    protected int f8310c;
    public final AtomicLong f8311e = new AtomicLong(0);

    /* compiled from: away_team_fan_count */
    public class ByteData {
        public String f8673a;
        public byte[] f8674b;
        public int f8675c;

        public ByteData(String str, byte[] bArr, int i) {
            this.f8673a = str;
            this.f8674b = bArr;
            this.f8675c = i;
        }
    }

    public abstract URL mo1076c(int i, int i2, int i3);

    public UrlTileProvider(int i, int i2) {
        this.f8309b = i;
        this.f8310c = i2;
    }

    public Tile mo1066b(int i, int i2, int i3) {
        URL c = mo1076c(i, i2, i3);
        if (c == null) {
            return a;
        }
        ByteData a = m14429a(c);
        if (a == null) {
            return null;
        }
        Tile a2 = Tile.m14611a(a.f8674b, a.f8675c);
        m14428c(a);
        return a2;
    }

    public void mo1067b() {
        this.f8311e.set(0);
    }

    protected final ByteData m14429a(URL url) {
        InputStream openStream;
        Throwable e;
        ByteData byteData = null;
        if (url != null) {
            long a = AnalyticsEvent.a();
            try {
                openStream = url.openStream();
                try {
                    byteData = m14427a(openStream, true);
                    if (openStream != null) {
                        try {
                            openStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    if (byteData != null) {
                        this.f8311e.getAndAdd((long) byteData.f8675c);
                        AnalyticsEvent.e.a((long) byteData.f8675c);
                        AnalyticsEvent.d.a(AnalyticsEvent.a() - a);
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        AnalyticsEvent.r.a(e);
                        if (openStream != null) {
                            try {
                                openStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        if (byteData != null) {
                            this.f8311e.getAndAdd((long) byteData.f8675c);
                            AnalyticsEvent.e.a((long) byteData.f8675c);
                            AnalyticsEvent.d.a(AnalyticsEvent.a() - a);
                        }
                        return byteData;
                    } catch (Throwable th) {
                        e = th;
                        if (openStream != null) {
                            try {
                                openStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        if (byteData != null) {
                            this.f8311e.getAndAdd((long) byteData.f8675c);
                            AnalyticsEvent.e.a((long) byteData.f8675c);
                            AnalyticsEvent.d.a(AnalyticsEvent.a() - a);
                        }
                        throw e;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                openStream = byteData;
                AnalyticsEvent.r.a(e);
                if (openStream != null) {
                    openStream.close();
                }
                if (byteData != null) {
                    this.f8311e.getAndAdd((long) byteData.f8675c);
                    AnalyticsEvent.e.a((long) byteData.f8675c);
                    AnalyticsEvent.d.a(AnalyticsEvent.a() - a);
                }
                return byteData;
            } catch (Throwable th2) {
                e = th2;
                openStream = byteData;
                if (openStream != null) {
                    openStream.close();
                }
                if (byteData != null) {
                    this.f8311e.getAndAdd((long) byteData.f8675c);
                    AnalyticsEvent.e.a((long) byteData.f8675c);
                    AnalyticsEvent.d.a(AnalyticsEvent.a() - a);
                }
                throw e;
            }
        }
        return byteData;
    }

    protected static ByteData m14427a(InputStream inputStream, boolean z) {
        Throwable th;
        ByteData byteData = (ByteData) f8308d.m14516c();
        if (byteData == null) {
            byteData = new ByteData(null, new byte[131072], 0);
        }
        Object obj = byteData.f8674b;
        int i = 0;
        while (true) {
            try {
                int read = inputStream.read(obj, i, obj.length - i);
                if (read == -1) {
                    break;
                }
                read += i;
                try {
                    if (read >= obj.length) {
                        Object obj2 = new byte[(obj.length << 1)];
                        System.arraycopy(obj, 0, obj2, 0, obj.length);
                        obj = obj2;
                        i = read;
                    } else {
                        i = read;
                    }
                } catch (Throwable e) {
                    Throwable th2 = e;
                    i = read;
                    th = th2;
                }
            } catch (IOException e2) {
                th = e2;
            }
        }
        if (byteData.f8674b == obj) {
            f8308d.m14515a(byteData);
            return new ByteData(null, obj, i);
        }
        byteData.f8675c = i;
        return byteData;
        if (!z || r1 == 0) {
            f8308d.m14515a(byteData);
            if (z) {
                AnalyticsEvent.u.a(th);
                return null;
            }
            throw th;
        }
        if (byteData.f8674b == obj) {
            byteData.f8675c = i;
            return byteData;
        }
        f8308d.m14515a(byteData);
        return new ByteData(null, obj, i);
    }

    public static void m14428c(ByteData byteData) {
        if (byteData.f8674b.length == 131072) {
            byteData.f8673a = null;
            f8308d.m14515a(byteData);
        }
    }
}
