package android.support.v7.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* compiled from: current_song_title */
public abstract class MediaRouteProvider {
    public final Context f16255a;
    public final ProviderMetadata f16256b;
    public final ProviderHandler f16257c = new ProviderHandler(this);
    public Callback f16258d;
    public MediaRouteDiscoveryRequest f16259e;
    public boolean f16260f;
    public MediaRouteProviderDescriptor f16261g;
    public boolean f16262h;

    /* compiled from: current_song_title */
    public abstract class Callback {
        public void mo1254a(@NonNull MediaRouteProvider mediaRouteProvider, @Nullable MediaRouteProviderDescriptor mediaRouteProviderDescriptor) {
        }
    }

    /* compiled from: current_song_title */
    final class ProviderHandler extends Handler {
        final /* synthetic */ MediaRouteProvider f16253a;

        public ProviderHandler(MediaRouteProvider mediaRouteProvider) {
            this.f16253a = mediaRouteProvider;
        }

        public final void handleMessage(Message message) {
            MediaRouteProvider mediaRouteProvider;
            switch (message.what) {
                case 1:
                    mediaRouteProvider = this.f16253a;
                    mediaRouteProvider.f16262h = false;
                    if (mediaRouteProvider.f16258d != null) {
                        mediaRouteProvider.f16258d.mo1254a(mediaRouteProvider, mediaRouteProvider.f16261g);
                    }
                    return;
                case 2:
                    mediaRouteProvider = this.f16253a;
                    mediaRouteProvider.f16260f = false;
                    mediaRouteProvider.mo1264b(mediaRouteProvider.f16259e);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: current_song_title */
    public final class ProviderMetadata {
        public final ComponentName f16254a;

        ProviderMetadata(ComponentName componentName) {
            if (componentName == null) {
                throw new IllegalArgumentException("componentName must not be null");
            }
            this.f16254a = componentName;
        }

        public final String toString() {
            return "ProviderMetadata{ componentName=" + this.f16254a.flattenToShortString() + " }";
        }
    }

    /* compiled from: current_song_title */
    public abstract class RouteController {
        public void mo1258a() {
        }

        public void mo1260b() {
        }

        public void mo1262c() {
        }

        public void mo1259a(int i) {
        }

        public void mo1261b(int i) {
        }
    }

    MediaRouteProvider(Context context, ProviderMetadata providerMetadata) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        this.f16255a = context;
        if (providerMetadata == null) {
            this.f16256b = new ProviderMetadata(new ComponentName(context, getClass()));
        } else {
            this.f16256b = providerMetadata;
        }
    }

    public final Context m20325a() {
        return this.f16255a;
    }

    public final void m20328a(@Nullable Callback callback) {
        MediaRouter.m20388d();
        this.f16258d = callback;
    }

    public final void m20327a(MediaRouteDiscoveryRequest mediaRouteDiscoveryRequest) {
        MediaRouter.m20388d();
        if (this.f16259e == mediaRouteDiscoveryRequest) {
            return;
        }
        if (this.f16259e == null || !this.f16259e.equals(mediaRouteDiscoveryRequest)) {
            this.f16259e = mediaRouteDiscoveryRequest;
            if (!this.f16260f) {
                this.f16260f = true;
                this.f16257c.sendEmptyMessage(2);
            }
        }
    }

    public void mo1264b(@Nullable MediaRouteDiscoveryRequest mediaRouteDiscoveryRequest) {
    }

    public final void m20329a(@Nullable MediaRouteProviderDescriptor mediaRouteProviderDescriptor) {
        MediaRouter.m20388d();
        if (this.f16261g != mediaRouteProviderDescriptor) {
            this.f16261g = mediaRouteProviderDescriptor;
            if (!this.f16262h) {
                this.f16262h = true;
                this.f16257c.sendEmptyMessage(1);
            }
        }
    }

    @Nullable
    public RouteController mo1263a(String str) {
        return null;
    }
}
