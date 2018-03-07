package com.facebook.composer.ui.underwood;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.SizeUtil;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.ui.underwood.UnderwoodController.AttachmentEventsListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.model.ComposerContentType;
import com.facebook.ipc.composer.model.ComposerContentType.ProvidesContentType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.slideshow.analytics.SlideshowLogger;
import com.facebook.ultralight.Inject;
import com.facebook.widget.mediareorderview.UnderwoodBitmapWidthHelper;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: componentName must not be null */
public class SlideshowAttachmentViewController<DataProvider extends ProvidesAttachments & ProvidesContentType & ProvidesSessionId> implements UnderwoodAttachmentViewController {
    private static final CallerContext f17127a = CallerContext.a(SphericalPhotoAttachmentViewController.class, "composer");
    public final WeakReference<DataProvider> f17128b;
    private final boolean f17129c;
    public final AttachmentEventsListener f17130d;
    private final Context f17131e;
    private final FbDraweeControllerBuilder f17132f;
    public final SlideshowLogger f17133g;
    @Nullable
    private final SlideshowAttachmentView f17134h;
    @Nullable
    private final View f17135i;
    @Nullable
    public ComposerAttachment f17136j;
    private final int f17137k;

    /* compiled from: componentName must not be null */
    class C13951 implements OnClickListener {
        final /* synthetic */ SlideshowAttachmentViewController f17125a;

        C13951(SlideshowAttachmentViewController slideshowAttachmentViewController) {
            this.f17125a = slideshowAttachmentViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 477242021);
            if (this.f17125a.f17136j != null) {
                ProvidesAttachments providesAttachments = (ProvidesAttachments) Preconditions.checkNotNull(this.f17125a.f17128b.get());
                this.f17125a.f17133g.b = ((ProvidesSessionId) providesAttachments).ab();
                this.f17125a.f17133g.h();
                this.f17125a.f17130d.m21139b(this.f17125a.f17136j);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 644073914, a);
        }
    }

    /* compiled from: componentName must not be null */
    class C13962 implements OnClickListener {
        final /* synthetic */ SlideshowAttachmentViewController f17126a;

        C13962(SlideshowAttachmentViewController slideshowAttachmentViewController) {
            this.f17126a = slideshowAttachmentViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 329208498);
            if (this.f17126a.f17136j != null) {
                this.f17126a.f17130d.m21136a(this.f17126a.f17136j);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1688642612, a);
        }
    }

    @Inject
    public SlideshowAttachmentViewController(@Assisted DataProvider dataProvider, @Assisted Integer num, @Assisted AttachmentsEventListener attachmentsEventListener, Context context, FbDraweeControllerBuilder fbDraweeControllerBuilder, UnderwoodBitmapWidthHelper underwoodBitmapWidthHelper, SlideshowLogger slideshowLogger) {
        this.f17128b = new WeakReference(Preconditions.checkNotNull(dataProvider));
        this.f17129c = num.intValue() == 0;
        this.f17130d = attachmentsEventListener;
        this.f17131e = context;
        this.f17132f = fbDraweeControllerBuilder;
        this.f17137k = SizeUtil.a(this.f17131e, (float) underwoodBitmapWidthHelper.a());
        this.f17133g = slideshowLogger;
        if (this.f17129c) {
            this.f17134h = new SlideshowAttachmentView(this.f17131e);
            this.f17135i = null;
            return;
        }
        this.f17134h = null;
        this.f17135i = new ViewStub(this.f17131e);
        this.f17135i.setVisibility(8);
    }

    public final void mo1339a() {
    }

    public final void mo1343b() {
    }

    public final float mo1345c() {
        return this.f17134h == null ? 0.0f : this.f17134h.f17120b;
    }

    public final void mo1347d() {
    }

    public final void mo1348e() {
    }

    public final void mo1349f() {
    }

    public final void mo1341a(boolean z) {
    }

    public final void mo1340a(float f) {
        if (this.f17134h != null) {
            this.f17134h.setScale(f);
            this.f17134h.setAlpha(f);
        }
    }

    public final float mo1350g() {
        return this.f17134h == null ? 0.0f : this.f17134h.f17119a;
    }

    public final boolean mo1342a(ComposerAttachment composerAttachment) {
        return composerAttachment != null && ((ProvidesContentType) ((ProvidesAttachments) Preconditions.checkNotNull(this.f17128b.get()))).c() == ComposerContentType.SLIDESHOW;
    }

    public final View mo1351h() {
        return this.f17129c ? this.f17134h : this.f17135i;
    }

    @Nullable
    public final ComposerAttachment mo1352i() {
        return this.f17136j;
    }

    public final void mo1344b(ComposerAttachment composerAttachment) {
        this.f17136j = composerAttachment;
    }

    public final void mo1346c(@Nullable ComposerAttachment composerAttachment) {
        this.f17136j = composerAttachment;
        if (this.f17134h != null && this.f17136j != null && this.f17136j.b() != null) {
            this.f17134h.f17120b = 1.0f;
            this.f17134h.setScale(1.0f);
            FbDraweeControllerBuilder a = this.f17132f.a(f17127a);
            ImageRequestBuilder a2 = ImageRequestBuilder.a(this.f17136j.b().f());
            a2.d = new ResizeOptions(this.f17137k, this.f17137k);
            this.f17134h.setController(((FbDraweeControllerBuilder) a.c(a2.m())).s());
            this.f17134h.f17123e.setOnClickListener(new C13951(this));
            OnClickListener c13962 = new C13962(this);
            this.f17134h.f17122d.setOnClickListener(c13962);
            this.f17134h.f17121c.setOnClickListener(c13962);
            this.f17134h.f17124f.setOnClickListener(c13962);
        }
    }

    public final void mo1353j() {
        this.f17136j = null;
        if (this.f17134h != null) {
            this.f17134h.f17120b = 0.0f;
            this.f17134h.setController(null);
            this.f17134h.f17123e.setOnClickListener(null);
            this.f17134h.f17122d.setOnClickListener(null);
            this.f17134h.f17121c.setOnClickListener(null);
            this.f17134h.f17124f.setOnClickListener(null);
        }
    }

    public final void m21091a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
    }
}
