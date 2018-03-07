package com.facebook.composer.ui.underwood;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.SizeUtil;
import com.facebook.composer.attachments.AttachmentUtils;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.ui.underwood.UnderwoodController.AttachmentEventsListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.spherical.photo.abtest.ExperimentsForPhotos360AbTestModule;
import com.facebook.spherical.photo.abtest.Photos360QEHelper;
import com.facebook.spherical.photo.utils.SphericalPhotoMetadataUtil;
import com.facebook.spherical.photo.utils.SphericalPhotoMetadataUtil.SphericalProps;
import com.facebook.ultralight.Inject;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: commercial_break_start */
public class SphericalPhotoAttachmentViewController<DataProvider extends ProvidesAttachments> implements UnderwoodAttachmentViewController {
    private static final CallerContext f17143a = CallerContext.a(SphericalPhotoAttachmentViewController.class, "composer");
    private final WeakReference<DataProvider> f17144b;
    private final ComposerAttachmentViewUtility f17145c;
    private final FbDraweeControllerBuilder f17146d;
    public final AttachmentEventsListener f17147e;
    private final Photos360QEHelper f17148f;
    @Nullable
    public ComposerAttachment f17149g;
    private SphericalPhotoAttachmentView f17150h;
    private final int f17151i;

    /* compiled from: commercial_break_start */
    class C13971 implements OnClickListener {
        final /* synthetic */ SphericalPhotoAttachmentViewController f17142a;

        C13971(SphericalPhotoAttachmentViewController sphericalPhotoAttachmentViewController) {
            this.f17142a = sphericalPhotoAttachmentViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 104736786);
            if (this.f17142a.f17149g != null) {
                this.f17142a.f17147e.m21139b(this.f17142a.f17149g);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 769864490, a);
        }
    }

    @Inject
    public SphericalPhotoAttachmentViewController(@Nullable @Assisted DataProvider dataProvider, @Assisted AttachmentsEventListener attachmentsEventListener, Context context, FbDraweeControllerBuilder fbDraweeControllerBuilder, ComposerAttachmentViewUtility composerAttachmentViewUtility, Photos360QEHelper photos360QEHelper) {
        this.f17144b = new WeakReference(Preconditions.checkNotNull(dataProvider));
        this.f17145c = composerAttachmentViewUtility;
        this.f17146d = fbDraweeControllerBuilder;
        this.f17151i = SizeUtil.a(context, 220.0f);
        this.f17147e = attachmentsEventListener;
        this.f17148f = photos360QEHelper;
        this.f17150h = new SphericalPhotoAttachmentView(context);
        Preconditions.checkNotNull(this.f17150h.f17141d);
        this.f17150h.f17141d.setOnClickListener(new C13971(this));
    }

    public final void mo1339a() {
    }

    public final void mo1343b() {
    }

    public final float mo1345c() {
        return this.f17150h.f17139b;
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
        this.f17150h.setScale(f);
    }

    public final float mo1350g() {
        return this.f17150h.f17138a;
    }

    public final boolean mo1342a(ComposerAttachment composerAttachment) {
        if (((ProvidesAttachments) this.f17144b.get()).m().size() == 1 && AttachmentUtils.b(composerAttachment) && this.f17148f.i()) {
            PhotoItem photoItem = (PhotoItem) composerAttachment.b();
            if (photoItem.e) {
                return photoItem.c;
            }
            if (this.f17148f.a.a(ExperimentsForPhotos360AbTestModule.k, false)) {
                SphericalProps a = SphericalPhotoMetadataUtil.a(composerAttachment.b().f().getPath());
                if (a.b) {
                    photoItem.c = true;
                    photoItem.d = a.a;
                    return true;
                }
            }
        }
        return false;
    }

    public final View mo1351h() {
        return this.f17150h;
    }

    @Nullable
    public final ComposerAttachment mo1352i() {
        return this.f17149g;
    }

    public final void mo1344b(ComposerAttachment composerAttachment) {
        this.f17149g = composerAttachment;
    }

    public final void mo1346c(@Nullable ComposerAttachment composerAttachment) {
        this.f17149g = composerAttachment;
        if (this.f17149g != null) {
            this.f17150h.f17139b = this.f17145c.m21073a(this.f17149g.b());
            this.f17150h.setScale(1.0f);
            FbDraweeControllerBuilder a = this.f17146d.a(f17143a);
            ImageRequestBuilder a2 = ImageRequestBuilder.a(this.f17149g.b().f());
            a2.d = new ResizeOptions(this.f17151i, this.f17151i);
            this.f17150h.setController(((FbDraweeControllerBuilder) a.c(a2.m())).s());
        }
    }

    public final void mo1353j() {
        this.f17149g = null;
        this.f17150h.f17139b = 0.0f;
        this.f17150h.setController(null);
    }

    public final void m21108a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
    }
}
