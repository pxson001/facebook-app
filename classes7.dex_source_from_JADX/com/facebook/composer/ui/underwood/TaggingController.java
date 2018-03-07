package com.facebook.composer.ui.underwood;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.common.util.SizeUtil;
import com.facebook.composer.activity.ComposerFragment.62;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.ui.tagging.ComposerAttachmentsAutoTaggingController;
import com.facebook.composer.ui.underwood.UnderwoodController.AttachmentEventsListener;
import com.facebook.composer.ui.underwood.VerticalAttachmentView.AnonymousClass15;
import com.facebook.inject.Assisted;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.tagging.FaceBox;
import com.facebook.photos.base.tagging.Tag;
import com.facebook.photos.creativeediting.utilities.PhotoOverlayObjectMapper;
import com.facebook.photos.galleryutil.GlobalOnLayoutHelper;
import com.facebook.photos.tagging.shared.FaceBoxesView;
import com.facebook.photos.tagging.shared.FaceBoxesView.FaceBoxClickListener;
import com.facebook.photos.tagging.shared.layout.TagWithFacebox;
import com.facebook.photos.tagging.shared.layout.TagsViewLayoutHelper;
import com.facebook.photos.tagging.shared.layout.TagsViewLayoutHelperProvider;
import com.facebook.photos.tagging.store.TagStore;
import com.facebook.photos.tagging.ui.FaceBoxConverter;
import com.facebook.photos.tagging.ui.TagView;
import com.facebook.photos.tagging.ui.TagView.DisplayText;
import com.facebook.photos.tagging.ui.TagView.TagViewListener;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: commercial_break_initiate */
public class TaggingController {
    public final HashMap<TagView, TagWithFacebox> f17156a;
    public final TagsViewLayoutHelper f17157b;
    public final FrameLayout f17158c;
    public final FaceBoxesView f17159d;
    private final Context f17160e;
    public final ComposerAttachmentsAutoTaggingController f17161f;
    public final FaceBoxConverter f17162g;
    public final PhotoOverlayObjectMapper f17163h;
    public final AnonymousClass15 f17164i;
    public final 62 f17165j;
    public final TagStore f17166k;
    private boolean f17167l = true;
    public List<FaceBox> f17168m;
    public PhotoItem f17169n;

    /* compiled from: commercial_break_initiate */
    class C13981 implements Runnable {
        final /* synthetic */ TaggingController f17152a;

        C13981(TaggingController taggingController) {
            this.f17152a = taggingController;
        }

        public void run() {
            this.f17152a.f17157b.a();
        }
    }

    /* compiled from: commercial_break_initiate */
    public class C14003 implements FaceBoxClickListener {
        final /* synthetic */ TaggingController f17155a;

        public C14003(TaggingController taggingController) {
            this.f17155a = taggingController;
        }

        public final void m21124a(RectF rectF) {
            FaceBox a = this.f17155a.f17162g.m12941a(rectF);
            AnonymousClass15 anonymousClass15 = this.f17155a.f17164i;
            Preconditions.checkNotNull(a);
            AttachmentEventsListener attachmentEventsListener = anonymousClass15.f17258a.ad;
            ComposerAttachment composerAttachment = anonymousClass15.f17258a.as;
            if (attachmentEventsListener.f17177a.f17187F.k()) {
                attachmentEventsListener.f17177a.f17183B.m21065a(composerAttachment, a);
            }
        }
    }

    @Inject
    public TaggingController(@Assisted FrameLayout frameLayout, @Assisted FaceBoxesView faceBoxesView, @Assisted AnonymousClass15 anonymousClass15, @Assisted 62 62, Context context, FaceBoxConverter faceBoxConverter, PhotoOverlayObjectMapper photoOverlayObjectMapper, ComposerAttachmentsAutoTaggingController composerAttachmentsAutoTaggingController, TagsViewLayoutHelperProvider tagsViewLayoutHelperProvider, TagStore tagStore) {
        this.f17158c = frameLayout;
        this.f17159d = faceBoxesView;
        this.f17159d.i = new C14003(this);
        this.f17164i = anonymousClass15;
        this.f17165j = 62;
        this.f17160e = context;
        this.f17162g = faceBoxConverter;
        this.f17163h = photoOverlayObjectMapper;
        this.f17161f = composerAttachmentsAutoTaggingController;
        this.f17156a = Maps.c();
        this.f17157b = tagsViewLayoutHelperProvider.a(this.f17158c, 0.0f);
        this.f17157b.a(this.f17156a);
        this.f17166k = tagStore;
    }

    public final void m21128a(PhotoItem photoItem) {
        Preconditions.checkNotNull(photoItem);
        this.f17169n = photoItem;
    }

    public final void m21129a(boolean z, RectF rectF, RectF rectF2) {
        Preconditions.checkNotNull(rectF);
        Matrix b = m21127b(rectF, rectF2);
        if (b != null) {
            this.f17159d.a((int) rectF2.width(), (int) rectF2.height(), b);
        }
        this.f17168m = this.f17161f.m21043a(this.f17169n);
        this.f17159d.setFaceBoxes(this.f17162g.m12944a(this.f17168m));
        TagsViewLayoutHelper tagsViewLayoutHelper = this.f17157b;
        FaceBoxConverter faceBoxConverter = this.f17162g;
        tagsViewLayoutHelper.a(FaceBoxConverter.m12937a(this.f17168m, faceBoxConverter.f10923c, faceBoxConverter.f10924d));
        if (this.f17168m != null && z) {
            this.f17159d.a();
        }
        m21125a();
    }

    @Nullable
    public final List<RectF> m21130b(RectF rectF) {
        Preconditions.checkNotNull(rectF);
        return FaceBoxConverter.m12937a(this.f17161f.m21043a(this.f17169n), rectF, this.f17169n.g());
    }

    public static Matrix m21127b(RectF rectF, RectF rectF2) {
        Preconditions.checkNotNull(rectF);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(rectF2, rectF, ScaleToFit.FILL);
        return matrix;
    }

    private void m21125a() {
        for (TagView removeView : this.f17156a.keySet()) {
            this.f17158c.removeView(removeView);
        }
        this.f17156a.clear();
        List<Tag> b = this.f17166k.b(this.f17169n);
        Collection<Tag> a = this.f17163h.a(b);
        if (a != null && b != null) {
            List<Tag> arrayList = new ArrayList();
            for (Tag tag : b) {
                if (this.f17163h.c(tag) == null) {
                    arrayList.add(tag);
                }
            }
            for (Tag tag2 : arrayList) {
                this.f17166k.b(this.f17169n, tag2);
            }
            if (!(a.size() == b.size() || this.f17165j == null)) {
                this.f17165j.a();
            }
            for (Tag tag22 : a) {
                tag22.d = Boolean.valueOf(true).booleanValue();
                m21126a(tag22);
            }
            this.f17157b.a(this.f17156a);
            GlobalOnLayoutHelper.c(this.f17158c, new C13981(this));
        }
    }

    private void m21126a(Tag tag) {
        final TagView tagView = new TagView(this.f17160e, tag, true, DisplayText.FIRST_NAME, false, true);
        tagView.f10937h.setTextSize((float) SizeUtil.c(this.f17160e.getResources(), 2131427398));
        tagView.f10939j = new TagViewListener(this) {
            final /* synthetic */ TaggingController f17154b;

            public final void mo615a(Tag tag) {
                Preconditions.checkNotNull(tagView);
                Preconditions.checkNotNull(tag);
                Tag tag2 = (Tag) this.f17154b.f17163h.a(tag);
                if (tag2 != null) {
                    this.f17154b.f17166k.b(this.f17154b.f17169n, tag2);
                    this.f17154b.f17159d.setFaceBoxes(this.f17154b.f17162g.m12944a(this.f17154b.f17168m));
                    this.f17154b.f17158c.removeView(tagView);
                    this.f17154b.f17156a.remove(tagView);
                    this.f17154b.f17157b.a(this.f17154b.f17156a);
                    if (this.f17154b.f17165j != null) {
                        this.f17154b.f17165j.a();
                    }
                }
            }
        };
        int i = (int) ((this.f17160e.getResources().getDisplayMetrics().density * 4.0f) + 0.5f);
        tagView.f10937h.setPadding(i, i, i, i);
        tagView.f10952w += i;
        this.f17158c.addView(tagView, new LayoutParams(-2, -2));
        this.f17156a.put(tagView, new TagWithFacebox(tag.a.e(), tag.a.d()));
    }
}
