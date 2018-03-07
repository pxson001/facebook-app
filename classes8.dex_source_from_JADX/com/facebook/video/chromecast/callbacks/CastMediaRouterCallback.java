package com.facebook.video.chromecast.callbacks;

import android.annotation.TargetApi;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.Callback;
import android.support.v7.media.MediaRouter.RouteInfo;
import com.facebook.video.chromecast.BaseCastManager;
import com.facebook.video.chromecast.BaseCastManager.ReconnectionStatus;
import com.google.android.gms.cast.CastDevice;

@TargetApi(16)
/* compiled from: mAccuracy */
public class CastMediaRouterCallback extends Callback {
    public BaseCastManager f9681a;
    private boolean f9682b;

    public CastMediaRouterCallback(BaseCastManager baseCastManager) {
        this.f9681a = baseCastManager;
    }

    public final void m11396a(RouteInfo routeInfo) {
        if (this.f9681a.f9587a == ReconnectionStatus.FINALIZED) {
            this.f9681a.f9587a = ReconnectionStatus.IN_ACTIVE;
            BaseCastManager baseCastManager = this.f9681a;
            if (baseCastManager.f9588b != null && !baseCastManager.f9588b.isCancelled()) {
                baseCastManager.f9588b.cancel(true);
                return;
            }
            return;
        }
        this.f9681a.f9589g.edit().a(BaseCastManager.f9585f, routeInfo.c).commit();
        this.f9681a.mo608a(CastDevice.m11767b(routeInfo.p));
    }

    public final void m11395a() {
        this.f9681a.mo608a(null);
    }

    public final void m11398a(MediaRouter mediaRouter, RouteInfo routeInfo) {
        if (!MediaRouter.b().equals(routeInfo)) {
            m11394c(mediaRouter);
        }
        if (this.f9681a.f9587a == ReconnectionStatus.STARTED) {
            if (routeInfo.c.equals(this.f9681a.f9589g.a(BaseCastManager.f9585f, null))) {
                this.f9681a.f9587a = ReconnectionStatus.IN_PROGRESS;
                this.f9681a.mo608a(CastDevice.m11767b(routeInfo.p));
            }
        }
    }

    public final void m11397a(MediaRouter mediaRouter) {
        m11394c(mediaRouter);
    }

    public final void m11399b(MediaRouter mediaRouter) {
        m11394c(mediaRouter);
    }

    private void m11394c(MediaRouter mediaRouter) {
        boolean a = MediaRouter.a(this.f9681a.f9594l, 3);
        if (a != this.f9682b) {
            this.f9682b = a;
            this.f9681a.mo610b(this.f9682b);
        }
    }
}
