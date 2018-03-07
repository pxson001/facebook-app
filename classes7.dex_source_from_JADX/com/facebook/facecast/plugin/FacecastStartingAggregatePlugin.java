package com.facebook.facecast.plugin;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.facecast.model.FacecastCompositionData;
import com.facebook.facecast.model.FacecastCompositionData.Builder;
import com.facebook.facecast.plugin.FacecastAspectRatioButtonPlugin.C15311;
import com.facebook.facecast.plugin.FacecastAspectRatioButtonPlugin.FacecastAspectRatioButtonClickListener;
import com.facebook.facecast.plugin.FacecastCountdownPlugin.FacecastCountdownTimer;
import com.facebook.facecast.plugin.FacecastEditTitlePlugin.FacecastEditTitleListener;
import com.facebook.facecast.plugin.FacecastGoLiveButtonPlugin.C15771;
import com.facebook.facecast.protocol.FacecastNetworker;
import com.facebook.facecast.protocol.VideoBroadcastUpdateRequest;
import com.facebook.facecastdisplay.FacecastUtil;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: c1406925ceeaaa1fc5e6e0de5f95bd34 */
public class FacecastStartingAggregatePlugin extends FacecastAggregatedBasePlugin implements FacecastAspectRatioButtonClickListener, FacecastEditTitleListener {
    @Inject
    public FacecastNetworker f18510c;
    @Inject
    public FacecastUtil f18511d;
    public final FacecastEditTitlePlugin f18512e;
    public final FacecastGoLiveButtonPlugin f18513f;
    @Nullable
    private FacecastCountdownPlugin f18514g;
    @Nullable
    private FacecastFullScreenCountDownPlugin f18515h;
    private FacecastCountdownPlugin f18516i;
    @Nullable
    private final FacecastAspectRatioButtonPlugin f18517j;
    public FacecastCompositionData f18518k;
    public boolean f18519l;
    private boolean f18520m;
    @Nullable
    private FacecastStartingAggregatePluginListener f18521n;

    /* compiled from: c1406925ceeaaa1fc5e6e0de5f95bd34 */
    public interface FacecastStartingAggregatePluginListener {
        void mo1388b(boolean z);

        void mo1396r();
    }

    /* compiled from: c1406925ceeaaa1fc5e6e0de5f95bd34 */
    public class C15901 {
        public final /* synthetic */ FacecastStartingAggregatePlugin f18509a;

        C15901(FacecastStartingAggregatePlugin facecastStartingAggregatePlugin) {
            this.f18509a = facecastStartingAggregatePlugin;
        }
    }

    public static void m22134a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        FacecastStartingAggregatePlugin facecastStartingAggregatePlugin = (FacecastStartingAggregatePlugin) obj;
        FacecastNetworker b = FacecastNetworker.m22307b(injectorLike);
        FacecastUtil b2 = FacecastUtil.m3107b(injectorLike);
        facecastStartingAggregatePlugin.f18510c = b;
        facecastStartingAggregatePlugin.f18511d = b2;
    }

    public FacecastStartingAggregatePlugin(Context context) {
        this(context, null);
    }

    private FacecastStartingAggregatePlugin(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastStartingAggregatePlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = FacecastStartingAggregatePlugin.class;
        m22134a((Object) this, getContext());
        this.f18512e = new FacecastEditTitlePlugin(context);
        this.f18512e.f18276v = this;
        this.f18513f = new FacecastGoLiveButtonPlugin(context);
        m21957a(this.f18512e, this.f18513f);
        if (this.f18511d.f2822a.a(585, false) && this.f18511d.m3121u()) {
            this.f18517j = new FacecastAspectRatioButtonPlugin(context);
            FacecastAspectRatioButtonPlugin facecastAspectRatioButtonPlugin = this.f18517j;
            facecastAspectRatioButtonPlugin.f18207c.setOnClickListener(new C15311(facecastAspectRatioButtonPlugin, this));
            m21955a(this.f18517j);
            return;
        }
        this.f18517j = null;
    }

    public final void m22136a(FacecastCompositionData facecastCompositionData, boolean z, boolean z2, FacecastStartingAggregatePluginListener facecastStartingAggregatePluginListener) {
        this.f18518k = facecastCompositionData;
        this.f18519l = z;
        this.f18521n = facecastStartingAggregatePluginListener;
        FacecastEditTitlePlugin facecastEditTitlePlugin = this.f18512e;
        facecastEditTitlePlugin.f18271q.setText(this.f18518k.f18152a);
        facecastEditTitlePlugin.f18271q.setSelection(facecastEditTitlePlugin.f18271q.getText().length());
        this.f18512e.setUpProfile(this.f18518k.f18154c);
        this.f18512e.m22011a(this.f18518k.f18153b, this.f18518k.f18154c);
        FacecastGoLiveButtonPlugin facecastGoLiveButtonPlugin = this.f18513f;
        facecastGoLiveButtonPlugin.f18423d.setOnClickListener(new C15771(facecastGoLiveButtonPlugin, new C15901(this)));
        if (this.f18519l) {
            this.f18513f.setVisibility(8);
        }
        setFullscreen(z2);
    }

    public static void m22135l(FacecastStartingAggregatePlugin facecastStartingAggregatePlugin) {
        facecastStartingAggregatePlugin.f18512e.m22013i();
        facecastStartingAggregatePlugin.f18512e.setVisibility(8);
        facecastStartingAggregatePlugin.f18513f.setVisibility(8);
        if (facecastStartingAggregatePlugin.f18517j != null) {
            facecastStartingAggregatePlugin.f18517j.setVisibility(8);
        }
        FacecastCountdownPlugin facecastCountdownPlugin = facecastStartingAggregatePlugin.f18516i;
        if (facecastCountdownPlugin.f18243e == null) {
            facecastCountdownPlugin.f18243e = new FacecastCountdownTimer(facecastCountdownPlugin);
        }
        facecastCountdownPlugin.f18242d.setVisibility(0);
        facecastCountdownPlugin.f18243e.start();
        facecastStartingAggregatePlugin.f18520m = true;
    }

    public final void mo1413d() {
        this.f18516i.m21999h();
        this.f18520m = false;
    }

    public final void mo1419e() {
        this.f18512e.setVisibility(this.f18519l ? 0 : 8);
        this.f18513f.setVisibility(0);
    }

    public final boolean mo1409a() {
        if (!this.f18520m || !this.f18519l) {
            return false;
        }
        this.f18512e.setVisibility(0);
        this.f18512e.m22012h();
        this.f18513f.setVisibility(0);
        if (this.f18517j != null) {
            this.f18517j.setVisibility(0);
        }
        this.f18516i.m21999h();
        this.f18520m = false;
        return true;
    }

    public final void mo1429b() {
        if (this.f18521n != null) {
            this.f18521n.mo1396r();
        }
    }

    public final void mo1428a(boolean z) {
        if (this.f18521n != null) {
            this.f18521n.mo1388b(z);
        }
    }

    public final void m22143h() {
        Preconditions.checkNotNull(this.f18512e);
        if (this.f18519l) {
            Builder builder = new Builder(this.f18518k);
            builder.f18139a = this.f18512e.f18271q.getText().toString();
            builder = builder;
            builder.f18140b = this.f18512e.f18274t;
            this.f18518k = builder.m21945a();
        }
    }

    public final void m22137a(String str, boolean z) {
        Builder builder = new Builder(this.f18518k);
        builder.f18150l = z;
        this.f18518k = builder.m21945a();
        FacecastNetworker facecastNetworker = this.f18510c;
        Parcelable videoBroadcastUpdateRequest = new VideoBroadcastUpdateRequest(str, this.f18518k);
        Bundle bundle = new Bundle();
        bundle.putParcelable("video_broadcast_update_key", videoBroadcastUpdateRequest);
        BlueServiceOperationFactoryDetour.a(facecastNetworker.f18762a, "video_broadcast_update_type", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(FacecastNetworker.class), 377937403).a();
    }

    public void setFullscreen(boolean z) {
        if (z) {
            if (this.f18515h == null) {
                this.f18515h = new FacecastFullScreenCountDownPlugin(getContext());
                m21955a(this.f18515h);
            }
            this.f18516i = this.f18515h;
            return;
        }
        if (this.f18514g == null) {
            this.f18514g = new FacecastCountdownPlugin(getContext());
            m21955a(this.f18514g);
        }
        this.f18516i = this.f18514g;
    }

    public FacecastCompositionData getFacecastCompositionData() {
        return this.f18518k;
    }
}
