package com.facebook.video.player.plugins;

import com.facebook.common.executors.FbAsyncTask;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.player.events.RVPCameraUpdateEvent;
import com.facebook.video.player.events.RVPGyroDismissalEvent;

/* compiled from: communication_rank */
class Video360Plugin$UpdateCameraFovTask extends FbAsyncTask<Object, String, Void> {
    final /* synthetic */ Video360Plugin f19410a;

    public Video360Plugin$UpdateCameraFovTask(Video360Plugin video360Plugin) {
        this.f19410a = video360Plugin;
    }

    protected final Object m28185a(Object[] objArr) {
        if (this.f19410a.r >= 0.0f || !this.f19410a.a()) {
            if (this.f19410a.a()) {
                float yaw = this.f19410a.get360TextureView().getYaw() - this.f19410a.q;
                float pitch = this.f19410a.get360TextureView().getPitch() - this.f19410a.p;
                this.f19410a.r = (float) Math.sqrt((double) ((yaw * yaw) + (pitch * pitch)));
            }
        } else if (!(this.f19410a.get360TextureView().getPitch() == 0.0f || this.f19410a.get360TextureView().getYaw() == 0.0f)) {
            this.f19410a.p = this.f19410a.get360TextureView().getPitch();
            this.f19410a.q = this.f19410a.get360TextureView().getYaw();
            this.f19410a.r = 0.0f;
        }
        return null;
    }

    protected void onPostExecute(Object obj) {
        super.onPostExecute((Void) obj);
        if (this.f19410a.a() && this.f19410a.g != null) {
            this.f19410a.g.a(new RVPCameraUpdateEvent(this.f19410a.get360TextureView().getPitch(), this.f19410a.get360TextureView().getYaw(), this.f19410a.get360TextureView().getFov()));
        }
        if (this.f19410a.g != null && this.f19410a.r > 30.0f) {
            this.f19410a.g.a(new RVPGyroDismissalEvent());
        }
        if (this.f19410a.v) {
            HandlerDetour.b(this.f19410a.t, this.f19410a.z, 150, 2115722200);
        }
    }
}
