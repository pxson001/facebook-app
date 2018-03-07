package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmn.zzb;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.LargeAssetApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.internal.zzba.zza;
import java.util.List;

public final class zzcf<T> extends zza {
    private zzmn<Object> f13416a;
    private zzmn<Object> f13417b;
    private zzmn<DataListener> f13418c;
    private zzmn<MessageListener> f13419d;
    private zzmn<NodeListener> f13420e;
    private zzmn<Object> f13421f;
    private zzmn<ChannelListener> f13422g;
    private zzmn<LargeAssetApi.zza> f13423h;
    private zzmn<CapabilityListener> f13424i;
    public final IntentFilter[] f13425j;
    public final String f13426k;

    public final class AnonymousClass10 implements zzb<LargeAssetApi.zza> {
        final /* synthetic */ LargeAssetQueueStateChangeParcelable f13406a;

        public AnonymousClass10(LargeAssetQueueStateChangeParcelable largeAssetQueueStateChangeParcelable) {
            this.f13406a = largeAssetQueueStateChangeParcelable;
        }

        public final void m13591a() {
            this.f13406a.m13330c();
        }

        public final void m13592a(Object obj) {
            LargeAssetApi.zza com_google_android_gms_wearable_LargeAssetApi_zza = (LargeAssetApi.zza) obj;
            this.f13406a.m13330c();
        }
    }

    public final class C18391 implements zzb<Object> {
        final /* synthetic */ AncsNotificationParcelable f13407a;

        public C18391(AncsNotificationParcelable ancsNotificationParcelable) {
            this.f13407a = ancsNotificationParcelable;
        }

        public final void m13593a() {
        }

        public final /* synthetic */ void m13594a(Object obj) {
        }
    }

    public final class C18402 implements zzb<CapabilityListener> {
        final /* synthetic */ CapabilityInfoParcelable f13408a;

        public C18402(CapabilityInfoParcelable capabilityInfoParcelable) {
            this.f13408a = capabilityInfoParcelable;
        }

        public final void m13595a() {
        }

        public final void m13596a(Object obj) {
            ((CapabilityListener) obj).mo133a(this.f13408a);
        }
    }

    public final class C18413 implements zzb<Object> {
        final /* synthetic */ AmsEntityUpdateParcelable f13409a;

        public C18413(AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
            this.f13409a = amsEntityUpdateParcelable;
        }

        public final void m13597a() {
        }

        public final /* synthetic */ void m13598a(Object obj) {
        }
    }

    public final class C18424 implements zzb<DataListener> {
        final /* synthetic */ DataHolder f13410a;

        public C18424(DataHolder dataHolder) {
            this.f13410a = dataHolder;
        }

        public final void m13599a() {
            this.f13410a.h();
        }

        public final void m13600a(Object obj) {
            try {
                ((DataListener) obj).mo134a(new DataEventBuffer(this.f13410a));
            } finally {
                this.f13410a.h();
            }
        }
    }

    public final class C18435 implements zzb<MessageListener> {
        final /* synthetic */ MessageEventParcelable f13411a;

        public C18435(MessageEventParcelable messageEventParcelable) {
            this.f13411a = messageEventParcelable;
        }

        public final void m13601a() {
        }

        public final void m13602a(Object obj) {
            ((MessageListener) obj).mo135a(this.f13411a);
        }
    }

    public final class C18446 implements zzb<NodeListener> {
        final /* synthetic */ NodeParcelable f13412a;

        public C18446(NodeParcelable nodeParcelable) {
            this.f13412a = nodeParcelable;
        }

        public final void m13603a() {
        }

        public final void m13604a(Object obj) {
            ((NodeListener) obj).mo136a(this.f13412a);
        }
    }

    public final class C18457 implements zzb<NodeListener> {
        final /* synthetic */ NodeParcelable f13413a;

        public C18457(NodeParcelable nodeParcelable) {
            this.f13413a = nodeParcelable;
        }

        public final void m13605a() {
        }

        public final void m13606a(Object obj) {
            ((NodeListener) obj).mo137b(this.f13413a);
        }
    }

    public final class C18468 implements zzb<Object> {
        final /* synthetic */ List f13414a;

        public C18468(List list) {
            this.f13414a = list;
        }

        public final void m13607a() {
        }

        public final /* synthetic */ void m13608a(Object obj) {
        }
    }

    public final class C18479 implements zzb<ChannelListener> {
        final /* synthetic */ ChannelEventParcelable f13415a;

        public C18479(ChannelEventParcelable channelEventParcelable) {
            this.f13415a = channelEventParcelable;
        }

        public final void m13609a() {
        }

        public final void m13610a(Object obj) {
            this.f13415a.m13322a((ChannelListener) obj);
        }
    }

    private static void m13611a(zzmn<?> com_google_android_gms_internal_zzmn_) {
        if (com_google_android_gms_internal_zzmn_ != null) {
            com_google_android_gms_internal_zzmn_.a();
        }
    }

    public final void m13612a() {
        m13611a(this.f13416a);
        this.f13416a = null;
        m13611a(this.f13417b);
        this.f13417b = null;
        m13611a(this.f13418c);
        this.f13418c = null;
        m13611a(this.f13419d);
        this.f13419d = null;
        m13611a(this.f13420e);
        this.f13420e = null;
        m13611a(this.f13421f);
        this.f13421f = null;
        m13611a(this.f13422g);
        this.f13422g = null;
        m13611a(this.f13423h);
        this.f13423h = null;
        m13611a(this.f13424i);
        this.f13424i = null;
    }

    public final void mo562a(DataHolder dataHolder) {
        if (this.f13418c != null) {
            this.f13418c.a(new C18424(dataHolder));
        } else {
            dataHolder.h();
        }
    }

    public final void mo563a(AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
        if (this.f13416a != null) {
            this.f13416a.a(new C18413(amsEntityUpdateParcelable));
        }
    }

    public final void mo564a(AncsNotificationParcelable ancsNotificationParcelable) {
        if (this.f13417b != null) {
            this.f13417b.a(new C18391(ancsNotificationParcelable));
        }
    }

    public final void mo565a(CapabilityInfoParcelable capabilityInfoParcelable) {
        if (this.f13424i != null) {
            this.f13424i.a(new C18402(capabilityInfoParcelable));
        }
    }

    public final void mo566a(ChannelEventParcelable channelEventParcelable) {
        if (this.f13422g != null) {
            this.f13422g.a(new C18479(channelEventParcelable));
        }
    }

    public final void mo567a(LargeAssetQueueStateChangeParcelable largeAssetQueueStateChangeParcelable) {
        if (this.f13423h != null) {
            this.f13423h.a(new AnonymousClass10(largeAssetQueueStateChangeParcelable));
        } else {
            largeAssetQueueStateChangeParcelable.m13330c();
        }
    }

    public final void mo568a(LargeAssetSyncRequestPayload largeAssetSyncRequestPayload, zzay com_google_android_gms_wearable_internal_zzay) {
        throw new UnsupportedOperationException("onLargeAssetSyncRequest not supported on live listener");
    }

    public final void mo569a(MessageEventParcelable messageEventParcelable) {
        if (this.f13419d != null) {
            this.f13419d.a(new C18435(messageEventParcelable));
        }
    }

    public final void mo570a(NodeParcelable nodeParcelable) {
        if (this.f13420e != null) {
            this.f13420e.a(new C18446(nodeParcelable));
        }
    }

    public final void mo571a(zzax com_google_android_gms_wearable_internal_zzax, String str, int i) {
        throw new UnsupportedOperationException("openFileDescriptor not supported on live listener");
    }

    public final void mo572a(List<NodeParcelable> list) {
        if (this.f13421f != null) {
            this.f13421f.a(new C18468(list));
        }
    }

    public final void mo573b(NodeParcelable nodeParcelable) {
        if (this.f13420e != null) {
            this.f13420e.a(new C18457(nodeParcelable));
        }
    }
}
