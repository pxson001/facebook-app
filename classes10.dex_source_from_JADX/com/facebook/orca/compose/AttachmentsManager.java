package com.facebook.orca.compose;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.util.StringUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.media.upload.MediaUploadManager;
import com.facebook.messaging.media.upload.MediaUploadManagerImpl;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.orca.compose.ComposeFragment.C07608;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

/* compiled from: overall_rank */
public class AttachmentsManager {
    private final Lazy<MediaUploadManager> f5325a;
    private final BaseFbBroadcastManager f5326b;
    public final Lazy<MediaUploadManager> f5327c;
    public final List<MediaResource> f5328d = Lists.a();
    public AttachmentContainer f5329e;
    private SelfRegistrableReceiverImpl f5330f;
    public C07608 f5331g;
    private boolean f5332h;

    /* compiled from: overall_rank */
    class C07511 implements ActionReceiver {
        final /* synthetic */ AttachmentsManager f5324a;

        C07511(AttachmentsManager attachmentsManager) {
            this.f5324a = attachmentsManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1677781799);
            if (this.f5324a.f5329e != null) {
                this.f5324a.f5329e.mo209a(intent);
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1050518836, a);
        }
    }

    public static AttachmentsManager m4730a(InjectorLike injectorLike) {
        return new AttachmentsManager(IdBasedLazy.a(injectorLike, 2644), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), IdBasedLazy.a(injectorLike, 2644));
    }

    @Inject
    public AttachmentsManager(Lazy<MediaUploadManager> lazy, FbBroadcastManager fbBroadcastManager, Lazy<MediaUploadManager> lazy2) {
        this.f5325a = lazy;
        this.f5326b = fbBroadcastManager;
        this.f5327c = lazy2;
        C07511 c07511 = new C07511(this);
        this.f5330f = this.f5326b.a().a("com.facebook.orca.media.upload.PROCESS_MEDIA_TOTAL_PROGRESS", c07511).a("com.facebook.orca.media.upload.PROCESS_MEDIA_COMPLETE", c07511).a();
    }

    public final boolean m4735a() {
        return this.f5329e != null;
    }

    public final void m4733a(MediaResource mediaResource, String str, ThreadKey threadKey) {
        MediaResourceBuilder a = MediaResource.a().a(mediaResource);
        a.k = str;
        a = a;
        a.l = threadKey;
        MediaResource C = a.C();
        if (!StringUtil.a(str)) {
            ((MediaUploadManagerImpl) this.f5325a.get()).a(C);
        }
        this.f5328d.add(C);
        if (this.f5329e != null) {
            this.f5329e.mo210a(C);
        }
        this.f5331g.m4818a();
    }

    public final boolean m4736b() {
        return this.f5328d.isEmpty();
    }

    public final void m4737c() {
        this.f5328d.clear();
        if (this.f5329e != null) {
            this.f5329e.mo208a();
        }
        this.f5331g.m4818a();
    }

    public final void m4734a(boolean z) {
        if (z != this.f5332h) {
            this.f5332h = z;
            if (this.f5332h) {
                this.f5330f.b();
            } else {
                this.f5330f.c();
            }
        }
    }

    public final ImmutableList<MediaResource> m4738d() {
        return ImmutableList.copyOf(this.f5328d);
    }

    private int m4731f() {
        return m4729a(Type.VIDEO);
    }

    private int m4732g() {
        return m4729a(Type.PHOTO);
    }

    private int m4729a(Type type) {
        ImmutableList d = m4738d();
        int size = d.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            if (((MediaResource) d.get(i)).d == type) {
                i3 = i2 + 1;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        return i2;
    }

    public final boolean m4739e() {
        int f = m4731f();
        if (f > 1) {
            return true;
        }
        int g = m4732g();
        if (f <= 0 || g <= 0) {
            return false;
        }
        return true;
    }
}
