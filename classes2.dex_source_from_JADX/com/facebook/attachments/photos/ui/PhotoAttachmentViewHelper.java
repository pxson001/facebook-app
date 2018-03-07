package com.facebook.attachments.photos.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.photos.ui.HasPhotoAttachment.OnPhotoClickListener;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.galleryutil.events.C0423xe259026e;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents$MediaGalleryFragmentVisibilityChangeEvent;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: graph_search_scoped_entity_name */
public class PhotoAttachmentViewHelper<V extends View & HasPhotoAttachment> {
    public V f21959a;
    private C0423xe259026e f21960b;
    public View f21961c;
    private PostPostBadge f21962d;
    public OnPhotoClickListener f21963e;
    public OnPhotoClickListener f21964f;
    private ConsumptionPhotoEventBus f21965g;
    public int f21966h = -1;

    /* compiled from: graph_search_scoped_entity_name */
    class C08772 implements OnClickListener {
        final /* synthetic */ PhotoAttachmentViewHelper f21967a;

        C08772(PhotoAttachmentViewHelper photoAttachmentViewHelper) {
            this.f21967a = photoAttachmentViewHelper;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -388204704);
            if (this.f21967a.f21963e == null) {
                Logger.a(2, EntryType.UI_INPUT_END, 437625320, a);
                return;
            }
            this.f21967a.f21963e.mo3222a(this.f21967a.f21959a, false, this.f21967a.f21966h);
            LogUtils.a(99541417, a);
        }
    }

    /* compiled from: graph_search_scoped_entity_name */
    class C08783 implements OnClickListener {
        final /* synthetic */ PhotoAttachmentViewHelper f21968a;

        C08783(PhotoAttachmentViewHelper photoAttachmentViewHelper) {
            this.f21968a = photoAttachmentViewHelper;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1248467637);
            if (this.f21968a.f21964f == null) {
                Logger.a(2, EntryType.UI_INPUT_END, 1950384710, a);
                return;
            }
            this.f21968a.f21964f.mo3222a(this.f21968a.f21959a, true, this.f21968a.f21966h);
            LogUtils.a(-732506328, a);
        }
    }

    /* compiled from: graph_search_scoped_entity_name */
    class C08791 extends C0423xe259026e {
        final /* synthetic */ PhotoAttachmentViewHelper f21969a;

        C08791(PhotoAttachmentViewHelper photoAttachmentViewHelper) {
            this.f21969a = photoAttachmentViewHelper;
        }

        public final void mo650b(FbEvent fbEvent) {
            ConsumptionPhotoEvents$MediaGalleryFragmentVisibilityChangeEvent consumptionPhotoEvents$MediaGalleryFragmentVisibilityChangeEvent = (ConsumptionPhotoEvents$MediaGalleryFragmentVisibilityChangeEvent) fbEvent;
            if (this.f21969a.f21966h != -1 && this.f21969a.f21966h == consumptionPhotoEvents$MediaGalleryFragmentVisibilityChangeEvent.f14048b) {
                this.f21969a.f21961c.setVisibility(!consumptionPhotoEvents$MediaGalleryFragmentVisibilityChangeEvent.f14047a ? 0 : 4);
            }
        }
    }

    @Inject
    public PhotoAttachmentViewHelper(@Assisted V v, @Assisted View view, @Assisted PostPostBadge postPostBadge, ConsumptionPhotoEventBus consumptionPhotoEventBus) {
        this.f21959a = v;
        this.f21961c = view;
        this.f21962d = postPostBadge;
        this.f21965g = consumptionPhotoEventBus;
        m29756a();
    }

    private void m29756a() {
        this.f21961c.setOnClickListener(m29757b());
        this.f21962d.setOnClickListener(m29759c());
        this.f21960b = new C08791(this);
        this.f21965g.m4568a(this.f21960b);
    }

    public final void m29765a(@Nullable String str, int i) {
        if (Strings.isNullOrEmpty(str)) {
            this.f21966h = -1;
            return;
        }
        this.f21966h = str.hashCode();
        View view = this.f21961c;
        int i2 = (i == -1 || i != this.f21966h) ? 0 : 4;
        view.setVisibility(i2);
    }

    public final void m29764a(@Nullable OnPhotoClickListener onPhotoClickListener) {
        this.f21963e = onPhotoClickListener;
    }

    public final void m29766b(@Nullable OnPhotoClickListener onPhotoClickListener) {
        this.f21964f = onPhotoClickListener;
    }

    public final void m29763a(int i, int i2) {
        if (i == 0) {
            this.f21962d.setVisibility(8);
            return;
        }
        this.f21962d.m29754a(i, i2);
        this.f21962d.setVisibility(0);
    }

    private OnClickListener m29757b() {
        return new C08772(this);
    }

    private OnClickListener m29759c() {
        return new C08783(this);
    }
}
