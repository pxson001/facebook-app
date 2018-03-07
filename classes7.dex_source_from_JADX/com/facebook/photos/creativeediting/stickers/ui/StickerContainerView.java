package com.facebook.photos.creativeediting.stickers.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable.Callback;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.creativeediting.analytics.CreativeEditingAnalyticsLogger;
import com.facebook.photos.creativeediting.analytics.CreativeEditingAnalyticsLogger.Events;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger;
import com.facebook.photos.creativeediting.interfaces.PhotoOverlayItem;
import com.facebook.photos.creativeediting.interfaces.UriAwarePhotoOverlayItem;
import com.facebook.photos.creativeediting.model.StickerParams;
import com.facebook.photos.creativeediting.model.StickerParams.Builder;
import com.facebook.photos.creativeediting.renderers.MovableItemContainer;
import com.facebook.photos.creativeediting.renderers.MovableItemContainerProvider;
import com.facebook.photos.creativeediting.stickers.events.StickerEventBus;
import com.facebook.photos.creativeediting.stickers.events.StickerEvents.ShowStickerPickerEvent;
import com.facebook.photos.creativeediting.ui.MovableContainerView;
import com.facebook.photos.creativeediting.ui.MovableItemAnimationController;
import com.facebook.photos.creativeediting.ui.MovableItemAnimationControllerProvider;
import com.facebook.photos.creativeediting.utilities.PhotoOverlayDrawUtilities;
import com.facebook.sequencelogger.Sequence;
import com.facebook.stickers.model.Sticker;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;

/* compiled from: mModel */
public class StickerContainerView extends MovableContainerView {
    @Inject
    StickerEventBus f9663f;
    @Inject
    MovableItemAnimationControllerProvider f9664g;
    @Inject
    MovableItemContainerProvider f9665h;
    @Inject
    CreativeEditingLogger f9666i;
    @Inject
    CreativeEditingAnalyticsLogger f9667j;
    @Inject
    PhotoOverlayDrawUtilities f9668k;
    private MovableItemContainer f9669l;
    private MovableItemAnimationController f9670m;
    public int f9671n = 0;
    public int f9672o = 0;

    private static <T extends View> void m11595a(Class<T> cls, T t) {
        m11596a((Object) t, t.getContext());
    }

    private static void m11596a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((StickerContainerView) obj).m11594a(StickerEventBus.m11541a(injectorLike), (MovableItemAnimationControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MovableItemAnimationControllerProvider.class), (MovableItemContainerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MovableItemContainerProvider.class), CreativeEditingLogger.m11468b(injectorLike), CreativeEditingAnalyticsLogger.m11459a(injectorLike), PhotoOverlayDrawUtilities.b(injectorLike));
    }

    protected MovableItemAnimationController getAnimationController() {
        return this.f9670m;
    }

    protected MovableItemContainer getMovableItemContainer() {
        return this.f9669l;
    }

    public StickerContainerView(Context context) {
        super(context);
        m11597k();
    }

    public StickerContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11597k();
    }

    public StickerContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11597k();
    }

    protected final void mo501a() {
        this.f9663f.a(new ShowStickerPickerEvent());
    }

    protected final void mo503a(boolean z) {
    }

    protected final void mo502a(PhotoOverlayItem photoOverlayItem) {
        Preconditions.checkNotNull(photoOverlayItem);
        CreativeEditingAnalyticsLogger creativeEditingAnalyticsLogger = this.f9667j;
        Sequence b = creativeEditingAnalyticsLogger.f9511b.b(CreativeEditingAnalyticsLogger.f9509a, this.f9654c);
        if (b != null) {
            SequenceLoggerDetour.e(b, Events.STICKER_REMOVED.name, 2028513235);
        }
        this.f9666i.m11488c(((StickerParams) photoOverlayItem).g());
    }

    private void m11594a(StickerEventBus stickerEventBus, MovableItemAnimationControllerProvider movableItemAnimationControllerProvider, MovableItemContainerProvider movableItemContainerProvider, CreativeEditingLogger creativeEditingLogger, CreativeEditingAnalyticsLogger creativeEditingAnalyticsLogger, PhotoOverlayDrawUtilities photoOverlayDrawUtilities) {
        this.f9663f = stickerEventBus;
        this.f9664g = movableItemAnimationControllerProvider;
        this.f9665h = movableItemContainerProvider;
        this.f9666i = creativeEditingLogger;
        this.f9667j = creativeEditingAnalyticsLogger;
        this.f9668k = photoOverlayDrawUtilities;
    }

    private void m11597k() {
        m11595a(StickerContainerView.class, (View) this);
        this.f9669l = this.f9665h.m11524a(this.f9655d);
        this.f9670m = this.f9664g.m11948a(this.f9653b, this.f9669l, this);
        this.f9653b.setContentDescription(getResources().getString(2131237773));
    }

    public final void m11601a(String str, String str2) {
        this.c = str;
        this.f9666i.m11480a(this.f9654c, str2);
    }

    public int getNumStickersRemoved() {
        return this.f9672o;
    }

    public int getNumStickersAdded() {
        return this.f9671n;
    }

    public final void m11600a(Sticker sticker) {
        Uri uri;
        Preconditions.checkNotNull(this.f9655d);
        if (sticker.d != null) {
            uri = sticker.d;
        } else {
            uri = sticker.c;
        }
        Rect a = this.f9668k.a(this.f9655d);
        float width = ((float) (a.left - this.f9655d.left)) / ((float) this.f9655d.width());
        float height = ((float) (a.top - this.f9655d.top)) / ((float) this.f9655d.height());
        float width2 = ((float) a.width()) / ((float) this.f9655d.width());
        float height2 = ((float) a.height()) / ((float) this.f9655d.height());
        Builder builder = new Builder(uri, sticker.a);
        builder.e = width;
        Builder builder2 = builder;
        builder2.f = height;
        builder2 = builder2;
        builder2.g = width2;
        builder2 = builder2;
        builder2.h = height2;
        PhotoOverlayItem a2 = builder2.a();
        this.f9669l.m11509a((UriAwarePhotoOverlayItem) a2, (Callback) this);
        this.f9669l.m11514b(a2);
        m11592i();
        invalidate();
        this.f9671n++;
        CreativeEditingAnalyticsLogger creativeEditingAnalyticsLogger = this.f9667j;
        Sequence b = creativeEditingAnalyticsLogger.f9511b.b(CreativeEditingAnalyticsLogger.f9509a, this.f9654c);
        if (b != null) {
            SequenceLoggerDetour.e(b, Events.STICKER_ADDED.name, 1140962400);
        }
        this.f9666i.m11485b(sticker.a);
    }

    public ImmutableList<StickerParams> getStickerParamsForDisplayedPhoto() {
        Preconditions.checkNotNull(this.f9655d);
        return this.f9669l.m11522i();
    }

    public ImmutableList<StickerParams> getStickerParamsForOriginalPhoto() {
        Collection b = this.f9652a.b(this.f9669l.m11522i());
        if (b == null) {
            return RegularImmutableList.a;
        }
        return ImmutableList.copyOf(b);
    }

    public final void m11602a(List<StickerParams> list) {
        Preconditions.checkNotNull(this.f9655d);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                this.f9669l.m11509a((UriAwarePhotoOverlayItem) this.f9652a.b((PhotoOverlayItem) list.get(i)), (Callback) this);
            }
            m11592i();
            invalidate();
        }
    }
}
