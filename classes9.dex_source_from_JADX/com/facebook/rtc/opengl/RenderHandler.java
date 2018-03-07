package com.facebook.rtc.opengl;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.rtc.services.BackgroundVideoCallService.C23459;
import java.lang.ref.WeakReference;

/* compiled from: application/vnd.oma.drm.rights+wbxml */
public class RenderHandler extends Handler {
    private WeakReference<RenderThread> f19877a;

    public RenderHandler(RenderThread renderThread) {
        this.f19877a = new WeakReference(renderThread);
    }

    public final void m19604a(SurfaceTexture surfaceTexture) {
        sendMessage(obtainMessage(0, surfaceTexture));
    }

    public final void m19603a(int i, int i2) {
        sendMessage(obtainMessage(1, i, i2));
    }

    public final void m19602a() {
        sendMessage(obtainMessage(2));
    }

    public void handleMessage(Message message) {
        int i = message.what;
        RenderThread renderThread = (RenderThread) this.f19877a.get();
        if (renderThread != null) {
            switch (i) {
                case 0:
                    renderThread.m19609a((SurfaceTexture) message.obj);
                    return;
                case 1:
                    renderThread.m19608a(message.arg1, message.arg2);
                    return;
                case 2:
                    renderThread.m19613d();
                    return;
                case 3:
                    Looper.myLooper().quit();
                    return;
                case 4:
                    if (renderThread.f19888k != null) {
                        renderThread.f19888k.updateTexImage();
                        renderThread.m19614g();
                        renderThread.f19896s = renderThread.f19895r.now();
                        if (renderThread.f19879a != null) {
                            C23459 c23459 = renderThread.f19879a;
                            if (c23459.f19949a.f20008w != null) {
                                c23459.f19949a.f20008w.m19849b();
                            }
                            renderThread.f19879a = null;
                        }
                    }
                    return;
                case 9:
                    renderThread.m19614g();
                    return;
                default:
                    throw new RuntimeException("unknown message " + i);
            }
        }
    }
}
