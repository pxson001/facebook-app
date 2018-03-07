package com.facebook.android.maps.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.SystemClock;
import com.facebook.android.maps.FacebookMap;
import com.facebook.android.maps.MapDrawable;
import com.facebook.android.maps.internal.GrandCentralDispatch.Dispatchable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/* compiled from: await must not be called on the UI thread when time is greater than zero. */
public class CopyrightLogoDrawable extends MapDrawable {
    private float f8331A;
    private float f8332B;
    private float f8333C;
    int f8334o;
    private final float f8335p;
    private final float f8336q;
    private final float f8337r;
    private final float f8338s;
    public String f8339t;
    public String f8340u;
    public float f8341v;
    private final Paint f8342w = new Paint(1);
    public Bitmap f8343x;
    public boolean f8344y;
    public long f8345z;

    /* compiled from: await must not be called on the UI thread when time is greater than zero. */
    public class C09241 extends Dispatchable {
        final /* synthetic */ CopyrightLogoDrawable f8330a;

        public C09241(CopyrightLogoDrawable copyrightLogoDrawable) {
            this.f8330a = copyrightLogoDrawable;
        }

        public void run() {
            InputStream openStream;
            Throwable th;
            OutputStream outputStream = null;
            Bitmap decodeFile = BitmapFactory.decodeFile(this.f8330a.f8340u);
            if (decodeFile == null) {
                try {
                    openStream = new URL(this.f8330a.f8339t).openStream();
                    try {
                        outputStream = this.f8330a.f8082g.openFileOutput("copyright_logo", 0);
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = openStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            outputStream.write(bArr, 0, read);
                        }
                        outputStream.flush();
                        outputStream.close();
                        decodeFile = BitmapFactory.decodeFile(this.f8330a.f8340u);
                        if (openStream != null) {
                            try {
                                openStream.close();
                            } catch (IOException e) {
                            }
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                    } catch (IOException e3) {
                        if (openStream != null) {
                            try {
                                openStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        GrandCentralDispatch.c(new Dispatchable(this) {
                            final /* synthetic */ C09241 f8329b;

                            public void run() {
                                if (decodeFile != null) {
                                    this.f8329b.f8330a.f8343x = decodeFile;
                                    this.f8329b.f8330a.f8341v = (float) this.f8329b.f8330a.f8343x.getHeight();
                                    this.f8329b.f8330a.mo1036b();
                                    this.f8329b.f8330a.m14231f();
                                }
                                this.f8329b.f8330a.f8344y = false;
                            }
                        });
                    } catch (Throwable th2) {
                        th = th2;
                        if (openStream != null) {
                            try {
                                openStream.close();
                            } catch (IOException e6) {
                            }
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e7) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e8) {
                    Object obj = outputStream;
                    if (openStream != null) {
                        openStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    GrandCentralDispatch.c(/* anonymous class already generated */);
                } catch (Throwable th3) {
                    th = th3;
                    openStream = outputStream;
                    if (openStream != null) {
                        openStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    throw th;
                }
            }
            GrandCentralDispatch.c(/* anonymous class already generated */);
        }
    }

    public CopyrightLogoDrawable(FacebookMap facebookMap) {
        super(facebookMap);
        this.f8339t = this.f8079d >= 2.0f ? "https://www.facebook.com/images/here_maps/here_maps_logo_64px.png" : "https://www.facebook.com/images/here_maps/here_maps_logo_32px.png";
        this.f8340u = this.f8082g.getFilesDir().getAbsolutePath() + File.separator + "copyright_logo";
        this.f8335p = 12.0f * this.f8079d;
        this.j = 3;
        this.k = Float.MAX_VALUE;
        this.f8336q = this.f8079d * 9.0f;
        this.f8337r = this.f8079d * 1.5f;
        this.f8342w.setTextSize(this.f8336q);
        this.f8338s = this.f8342w.descent();
    }

    protected final void mo1036b() {
        int height = this.f8080e.f8112A.getHeight();
        this.f8331A = this.f8335p + ((float) this.f8080e.f8129c);
        this.f8332B = (((float) (height - this.f8080e.f8132f)) - this.f8341v) - this.f8335p;
        this.f8333C = (((float) (height - this.f8080e.f8132f)) - this.f8338s) - this.f8335p;
    }

    public final void mo1032a(Canvas canvas) {
        if ((this.f8334o & 2) != 0) {
            this.f8342w.setTextSize(this.f8336q);
            this.f8342w.setColor(-1073741825);
            this.f8342w.setStyle(Style.STROKE);
            this.f8342w.setStrokeWidth(this.f8337r);
            canvas.drawText("© OpenStreetMap", this.f8331A, this.f8333C, this.f8342w);
            this.f8342w.setColor(-1728053248);
            this.f8342w.setStyle(Style.FILL);
            canvas.drawText("© OpenStreetMap", this.f8331A, this.f8333C, this.f8342w);
        } else if ((this.f8334o & 1) == 0) {
        } else {
            if (this.f8343x != null) {
                canvas.drawBitmap(this.f8343x, this.f8331A, this.f8332B, this.f8342w);
            } else if (!this.f8344y && SystemClock.uptimeMillis() - this.f8345z > 10000) {
                this.f8344y = true;
                this.f8345z = SystemClock.uptimeMillis();
                GrandCentralDispatch.a(new C09241(this));
            }
        }
    }
}
