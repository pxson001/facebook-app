package com.facebook.photos.editgallery;

import android.content.Context;
import android.graphics.Rect;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.editgallery.EditFeature;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger;
import com.facebook.photos.creativeediting.analytics.StickersOnPhotosLoggingParams;
import com.facebook.photos.creativeediting.interfaces.PhotoOverlayItem;
import com.facebook.photos.creativeediting.interfaces.PhotoOverlayItem.OverlayItemType;
import com.facebook.photos.creativeediting.model.CreativeEditingData.Builder;
import com.facebook.photos.creativeediting.stickers.events.StickerEventBus;
import com.facebook.photos.creativeediting.stickers.events.StickerEvents.ShowStickerPickerEvent;
import com.facebook.photos.creativeediting.stickers.events.StickerEvents.StickerSelectedEvent;
import com.facebook.photos.creativeediting.stickers.stickers.StickerPicker;
import com.facebook.photos.creativeediting.utilities.SpringAlphaAnimator;
import com.facebook.photos.editgallery.EditFeatureController.UriRequestType;
import com.facebook.photos.editgallery.EditGalleryFragmentController.State;
import com.facebook.photos.editgallery.EditGalleryFragmentManager.UsageParams;
import com.facebook.photos.editgallery.EditableOverlayContainerView.CallBack;
import com.facebook.stickers.model.StickerInterface;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: launch_point */
public class StickerEditController implements EditFeatureController, MovableItemListener {
    private static final String f10418b = StickerEditController.class.getSimpleName();
    public final CallBack f10419a = new C08791(this);
    private final StickerSelectedEventSubscriber f10420c = new StickerSelectedEventSubscriber(this);
    private final ShowStickerPickerEventSubscriber f10421d = new ShowStickerPickerEventSubscriber(this);
    public final Lazy<StickerEventBus> f10422e;
    private final FrameLayout f10423f;
    private final String f10424g;
    private final Context f10425h;
    private final SpringAlphaAnimator f10426i;
    public EditableOverlayContainerView f10427j;
    public StickerPicker f10428k;
    private State f10429l;
    private boolean f10430m;
    public boolean f10431n;
    private Optional<CreativeEditingLogger> f10432o;
    public StickersOnPhotosLoggingParams f10433p = new StickersOnPhotosLoggingParams();
    public MovableItemListener f10434q;

    /* compiled from: launch_point */
    class C08791 implements CallBack {
        final /* synthetic */ StickerEditController f10415a;

        C08791(StickerEditController stickerEditController) {
            this.f10415a = stickerEditController;
        }

        public final void mo587a() {
            ((StickerEventBus) this.f10415a.f10422e.get()).a(new ShowStickerPickerEvent());
        }

        public final void mo590a(boolean z) {
            this.f10415a.f10431n = z;
        }

        public final void mo588a(PhotoOverlayItem photoOverlayItem) {
            this.f10415a.f10431n = true;
            MovableItemListener movableItemListener = this.f10415a.f10434q;
            EditableOverlayContainerView editableOverlayContainerView = this.f10415a.f10427j;
            movableItemListener.mo579a(EditableOverlayContainerView.m12220c(photoOverlayItem));
        }

        public final void mo589a(String str) {
            this.f10415a.f10431n = true;
            MovableItemListener movableItemListener = this.f10415a.f10434q;
            EditableOverlayContainerView editableOverlayContainerView = this.f10415a.f10427j;
            movableItemListener.mo580a(str, EditableOverlayContainerView.m12220c(this.f10415a.f10427j.getSelectedItem()));
        }

        public final void mo591b(String str) {
            this.f10415a.f10431n = true;
            MovableItemListener movableItemListener = this.f10415a.f10434q;
            EditableOverlayContainerView editableOverlayContainerView = this.f10415a.f10427j;
            movableItemListener.mo581b(str, EditableOverlayContainerView.m12220c(this.f10415a.f10427j.getSelectedItem()));
        }

        public final void mo592c(String str) {
            this.f10415a.f10431n = true;
            MovableItemListener movableItemListener = this.f10415a.f10434q;
            EditableOverlayContainerView editableOverlayContainerView = this.f10415a.f10427j;
            movableItemListener.mo582c(str, EditableOverlayContainerView.m12220c(this.f10415a.f10427j.getSelectedItem()));
        }
    }

    /* compiled from: launch_point */
    class ShowStickerPickerEventSubscriber extends com.facebook.photos.creativeediting.stickers.events.StickerEvents.ShowStickerPickerEventSubscriber {
        final /* synthetic */ StickerEditController f10416a;

        public ShowStickerPickerEventSubscriber(StickerEditController stickerEditController) {
            this.f10416a = stickerEditController;
        }

        public final void m12275b(FbEvent fbEvent) {
            this.f10416a.f10428k.m11565b();
        }
    }

    /* compiled from: launch_point */
    class StickerSelectedEventSubscriber extends com.facebook.photos.creativeediting.stickers.events.StickerEvents.StickerSelectedEventSubscriber {
        final /* synthetic */ StickerEditController f10417a;

        public StickerSelectedEventSubscriber(StickerEditController stickerEditController) {
            this.f10417a = stickerEditController;
        }

        public final void m12276b(FbEvent fbEvent) {
            StickerSelectedEvent stickerSelectedEvent = (StickerSelectedEvent) fbEvent;
            if (stickerSelectedEvent.f9609a != null) {
                this.f10417a.f10427j.m12228a(stickerSelectedEvent.f9609a);
                this.f10417a.f10431n = true;
                StickersOnPhotosLoggingParams stickersOnPhotosLoggingParams = this.f10417a.f10433p;
                stickersOnPhotosLoggingParams.f9571e++;
                this.f10417a.f10428k.m11566c();
            }
        }
    }

    @Inject
    public StickerEditController(@Assisted FrameLayout frameLayout, @Assisted EditableOverlayContainerView editableOverlayContainerView, @Assisted String str, @Assisted MovableItemListener movableItemListener, @Assisted Optional<CreativeEditingLogger> optional, Context context, SpringAlphaAnimator springAlphaAnimator, Lazy<StickerEventBus> lazy) {
        this.f10423f = frameLayout;
        this.f10424g = str;
        this.f10425h = context;
        this.f10422e = lazy;
        this.f10426i = springAlphaAnimator;
        this.f10427j = editableOverlayContainerView;
        this.f10428k = new StickerPicker(this.f10425h);
        this.f10428k.setVisibility(8);
        this.f10423f.addView(this.f10428k, new LayoutParams(-1, -1));
        this.f10432o = optional;
        this.f10434q = movableItemListener;
    }

    public final void mo564b() {
        if (this.f10430m) {
            ((StickerEventBus) this.f10422e.get()).b(this.f10420c);
            ((StickerEventBus) this.f10422e.get()).b(this.f10421d);
            this.f10428k.m11563a();
            this.f10428k.setVisibility(8);
            this.f10427j.m11588b();
            this.f10427j.m11593j();
            this.f10430m = false;
        }
    }

    public final void mo569g() {
    }

    public final void mo565c() {
        this.f10419a.mo587a();
    }

    public final Object mo572j() {
        return EditFeature.STICKER;
    }

    public final String mo559a() {
        return this.f10425h.getResources().getString(2131237783);
    }

    public final UriRequestType mo573k() {
        return UriRequestType.SHOW_EDITED_URI;
    }

    public final void mo560a(Rect rect) {
    }

    public final void mo570h() {
        if (this.f10427j.getVisibility() != 0) {
            this.f10427j.setAlpha(0.0f);
            this.f10427j.setVisibility(0);
            this.f10426i.a();
            this.f10426i.a(this.f10427j, 1);
        }
        this.f10427j.setActionButtonEnabled(true);
    }

    public final void mo571i() {
        this.f10427j.setVisibility(4);
        this.f10427j.setActionButtonEnabled(false);
    }

    public final void mo562a(UsageParams usageParams) {
        usageParams.f10347b++;
    }

    public final boolean mo574l() {
        return this.f10431n;
    }

    public final State mo575m() {
        this.f10429l.f10290k = new Builder(this.f10429l.f10290k).b(this.f10427j.getOverlayParamsForOriginalPhoto()).a();
        return this.f10429l;
    }

    public final boolean mo566d() {
        if (this.f10428k.getVisibility() != 0) {
            return false;
        }
        this.f10428k.m11566c();
        return true;
    }

    public final boolean mo567e() {
        return false;
    }

    public final void mo568f() {
        this.f10428k.m11567d();
    }

    public final void mo563a(boolean z) {
        this.f10433p.f9567a = z;
        if (this.f10432o.isPresent()) {
            ((CreativeEditingLogger) this.f10432o.get()).m11476a(this.f10433p);
        }
    }

    public final void mo579a(@Nullable OverlayItemType overlayItemType) {
        if (overlayItemType != null && overlayItemType == OverlayItemType.STICKER) {
            StickersOnPhotosLoggingParams stickersOnPhotosLoggingParams = this.f10433p;
            stickersOnPhotosLoggingParams.f9572f++;
        }
    }

    public final void mo580a(String str, @Nullable OverlayItemType overlayItemType) {
        if (overlayItemType != null && overlayItemType == OverlayItemType.STICKER) {
            StickersOnPhotosLoggingParams stickersOnPhotosLoggingParams = this.f10433p;
            Preconditions.checkNotNull(str);
            if (!stickersOnPhotosLoggingParams.f9568b.contains(str)) {
                stickersOnPhotosLoggingParams.f9568b.add(str);
            }
        }
    }

    public final void mo581b(String str, @Nullable OverlayItemType overlayItemType) {
        if (overlayItemType != null && overlayItemType == OverlayItemType.STICKER) {
            StickersOnPhotosLoggingParams stickersOnPhotosLoggingParams = this.f10433p;
            Preconditions.checkNotNull(str);
            if (!stickersOnPhotosLoggingParams.f9569c.contains(str)) {
                stickersOnPhotosLoggingParams.f9569c.add(str);
            }
        }
    }

    public final void mo582c(String str, @Nullable OverlayItemType overlayItemType) {
        if (overlayItemType != null && overlayItemType == OverlayItemType.STICKER) {
            StickersOnPhotosLoggingParams stickersOnPhotosLoggingParams = this.f10433p;
            Preconditions.checkNotNull(str);
            if (!stickersOnPhotosLoggingParams.f9570d.contains(str)) {
                stickersOnPhotosLoggingParams.f9570d.add(str);
            }
        }
    }

    public final void mo561a(State state) {
        Preconditions.checkNotNull(state.f10290k);
        this.f10429l = state;
        this.f10428k.m11564a(this.f10424g, f10418b, StickerInterface.COMPOSER);
        this.f10428k.m11567d();
        ((StickerEventBus) this.f10422e.get()).a(this.f10420c);
        ((StickerEventBus) this.f10422e.get()).a(this.f10421d);
        this.f10430m = true;
        this.f10427j.m11585a(2130843809, 2131234482, 2131234483);
        this.f10427j.f10365n = this.f10419a;
        this.f10427j.m11590e();
    }
}
