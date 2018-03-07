package com.facebook.photos.tagging.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.facebook.inject.Assisted;
import com.facebook.photos.base.photos.LocalPhoto;
import com.facebook.photos.base.tagging.FaceBox;
import com.facebook.photos.base.tagging.Tag;
import com.facebook.photos.base.tagging.TagPoint;
import com.facebook.photos.base.tagging.TagTarget;
import com.facebook.photos.base.tagging.TaggablePhoto;
import com.facebook.photos.galleryutil.GlobalOnLayoutHelper;
import com.facebook.photos.galleryutil.PhotosKeyboard;
import com.facebook.photos.taggablegallery.TaggablePhotoGalleryFragment;
import com.facebook.photos.taggablegallery.TaggablePhotoGalleryFragment.TaggingInterfaceControllerHostImpl;
import com.facebook.photos.taggablegallery.TaggablePhotoGalleryFragment.TaggingInterfaceControllerImpl;
import com.facebook.photos.tagging.shared.TagTypeahead;
import com.facebook.photos.tagging.shared.TagTypeahead.TagTypeaheadListener;
import com.facebook.photos.tagging.shared.TagTypeaheadAdapter.TagTypeaheadAdapterCallback;
import com.facebook.photos.tagging.shared.TypeaheadAnimationHelper;
import com.facebook.photos.tagging.shared.TypeaheadAnimationHelper.SelectedFaceParams;
import com.facebook.photos.tagging.store.FaceBoxStore;
import com.facebook.photos.tagging.store.TagStore;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tagging.abtest.ExperimentsForTaggingABTestModule;
import com.facebook.tagging.data.TagTypeaheadDataSource;
import com.facebook.tagging.graphql.data.GroupMembersTaggingTypeaheadDataSourceProvider;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.widget.images.zoomableimageview.ZoomableImageView;
import com.facebook.widget.images.zoomableimageview.ZoomableView.ZoomableImageViewZoomAndPanListener;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: interrupted */
public class TaggingInterfaceController {
    private final TypeaheadAnimationHelper f10991a;
    private Context f10992b;
    public TaggingInterfaceControllerHostImpl f10993c;
    public TagTypeahead f10994d;
    public List<FaceBox> f10995e;
    public TaggablePhoto f10996f;
    public TagTarget f10997g;
    private float f10998h;
    private Matrix f10999i;
    private PointF f11000j;
    public TaggingInterfaceControllerImpl f11001k;
    public boolean f11002l = false;
    @Nullable
    public FaceBoxConverter f11003m;
    public TagStore f11004n;
    public FaceBoxStore f11005o;

    /* compiled from: interrupted */
    class C09531 implements TagTypeaheadListener {
        final /* synthetic */ TaggingInterfaceController f10979a;

        C09531(TaggingInterfaceController taggingInterfaceController) {
            this.f10979a = taggingInterfaceController;
        }

        public final void m12988a(TaggingProfile taggingProfile, int i, String str) {
            TagTarget tagTarget = this.f10979a.f10997g;
            if (tagTarget instanceof FaceBox) {
                FaceBox faceBox = (FaceBox) this.f10979a.f10997g;
                if (this.f10979a.f11003m != null) {
                    FaceBox faceBox2;
                    faceBox = (FaceBox) this.f10979a.f10997g;
                    for (Entry entry : this.f10979a.f11003m.f10922b.entrySet()) {
                        if (entry.getKey() != faceBox) {
                            if (FaceBoxConverter.m12938a((FaceBox) entry.getKey(), faceBox)) {
                            }
                        }
                        faceBox2 = (FaceBox) entry.getValue();
                    }
                    faceBox2 = null;
                    faceBox = faceBox2;
                    if (faceBox == null) {
                        this.f10979a.m13002b();
                        return;
                    }
                }
                faceBox.f = true;
                tagTarget = faceBox;
            } else if ((tagTarget instanceof TagPoint) && this.f10979a.f11003m != null) {
                int c;
                if (this.f10979a.f10996f instanceof LocalPhoto) {
                    c = ((LocalPhoto) this.f10979a.f10996f).c();
                } else {
                    c = 0;
                }
                tagTarget = this.f10979a.f11003m.m12943a((TagPoint) this.f10979a.f10997g, c);
            }
            Tag tag = new Tag(tagTarget, taggingProfile.a(), taggingProfile.b(), true, taggingProfile.d());
            if (tagTarget instanceof FaceBox) {
                tag.a(((FaceBox) tagTarget).i());
                ((FaceBox) tagTarget).f = true;
            }
            this.f10979a.f11002l = true;
            this.f10979a.f11001k.a(tag);
            TagTarget tagTarget2 = null;
            if (this.f10979a.f10997g instanceof FaceBox) {
                tagTarget2 = TaggingInterfaceController.m12994a(this.f10979a, (FaceBox) this.f10979a.f10997g);
                this.f10979a.f10995e.remove(this.f10979a.f10997g);
                this.f10979a.f10993c.a().m12983m();
            }
            if (tagTarget2 != null) {
                TaggingInterfaceController.m12996a(this.f10979a, tagTarget2, false, true);
            } else {
                this.f10979a.m13002b();
            }
        }

        public final void m12987a() {
            this.f10979a.m13002b();
        }

        public final void m12989b() {
            this.f10979a.f11001k.a.al.i();
        }
    }

    /* compiled from: interrupted */
    class C09553 implements ZoomableImageViewZoomAndPanListener {
        final /* synthetic */ TaggingInterfaceController f10985a;

        C09553(TaggingInterfaceController taggingInterfaceController) {
            this.f10985a = taggingInterfaceController;
        }

        public final void m12990a() {
            TaggingInterfaceControllerImpl taggingInterfaceControllerImpl = this.f10985a.f11001k;
            if (this.f10985a.f11002l) {
                TaggablePhotoGalleryFragment.aA(taggingInterfaceControllerImpl.a).m12978h();
            }
            TaggablePhotoGalleryFragment.aA(taggingInterfaceControllerImpl.a).f10966i = false;
            TaggablePhotoGalleryFragment.aA(taggingInterfaceControllerImpl.a).getZoomableImageView().c();
            taggingInterfaceControllerImpl.a.aN.b();
            this.f10985a.f11002l = false;
        }
    }

    /* compiled from: interrupted */
    class C09575 implements TagTypeaheadAdapterCallback {
        final /* synthetic */ TaggingInterfaceController f10989a;

        C09575(TaggingInterfaceController taggingInterfaceController) {
            this.f10989a = taggingInterfaceController;
        }

        public final boolean m12992a(String str) {
            try {
                long parseLong = Long.parseLong(str);
                if (this.f10989a.f10996f == null || !this.f10989a.f11004n.a(this.f10989a.f10996f, parseLong)) {
                    return false;
                }
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        public final boolean m12993b(String str) {
            if (this.f10989a.f10996f != null) {
                TagStore tagStore = this.f10989a.f11004n;
                TaggablePhoto taggablePhoto = this.f10989a.f10996f;
                Object obj = 1;
                Preconditions.checkArgument(!Strings.isNullOrEmpty(str));
                for (Tag tag : tagStore.a(taggablePhoto)) {
                    if (tag.j() && tag.b.g().equalsIgnoreCase(str)) {
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: interrupted */
    public class C09586 implements Comparator<FaceBox> {
        final /* synthetic */ TaggingInterfaceController f10990a;

        public C09586(TaggingInterfaceController taggingInterfaceController) {
            this.f10990a = taggingInterfaceController;
        }

        public int compare(Object obj, Object obj2) {
            FaceBox faceBox = (FaceBox) obj;
            FaceBox faceBox2 = (FaceBox) obj2;
            int compare = Float.compare(faceBox.d().left, faceBox2.d().left);
            if (compare == 0) {
                return Float.compare(faceBox.d().top, faceBox2.d().top);
            }
            return compare;
        }
    }

    @Inject
    public TaggingInterfaceController(@Assisted Context context, @Assisted TaggingInterfaceControllerHostImpl taggingInterfaceControllerHostImpl, @Assisted TagTypeahead tagTypeahead, @Assisted int i, @Assisted String str, TagTypeaheadDataSource tagTypeaheadDataSource, GroupMembersTaggingTypeaheadDataSourceProvider groupMembersTaggingTypeaheadDataSourceProvider, TypeaheadAnimationHelper typeaheadAnimationHelper, TagStore tagStore, FaceBoxStore faceBoxStore, QeAccessor qeAccessor) {
        this.f10992b = context;
        this.f10993c = taggingInterfaceControllerHostImpl;
        this.f10994d = tagTypeahead;
        this.f10991a = typeaheadAnimationHelper;
        this.f11004n = tagStore;
        this.f11005o = faceBoxStore;
        m12995a(i, str, tagTypeaheadDataSource, groupMembersTaggingTypeaheadDataSourceProvider, qeAccessor);
        this.f10994d.a(new C09531(this));
        PhotosKeyboard.a(((Activity) this.f10992b).getWindow());
    }

    public final boolean m13001a() {
        return this.f10994d.t;
    }

    public final void m12999a(TaggablePhoto taggablePhoto, TaggablePhotoView taggablePhotoView, TagTarget tagTarget, boolean z) {
        final TaggablePhoto taggablePhoto2 = taggablePhoto;
        final TagTarget tagTarget2 = tagTarget;
        final boolean z2 = z;
        final TaggablePhotoView taggablePhotoView2 = taggablePhotoView;
        GlobalOnLayoutHelper.c(this.f10994d, new Runnable(this) {
            final /* synthetic */ TaggingInterfaceController f10984e;

            public void run() {
                this.f10984e.m12998a(taggablePhoto2, tagTarget2, z2, taggablePhotoView2.f10972o);
            }
        });
    }

    public final void m12998a(TaggablePhoto taggablePhoto, TagTarget tagTarget, boolean z, @Nullable FaceBoxConverter faceBoxConverter) {
        ZoomableImageView zoomableImageView = this.f10993c.a().getZoomableImageView();
        if (zoomableImageView != null && zoomableImageView.getDrawable() != null) {
            this.f10996f = taggablePhoto;
            this.f11003m = faceBoxConverter;
            List arrayList = new ArrayList();
            if (this.f11005o.b(taggablePhoto)) {
                for (Object obj : this.f11005o.a(taggablePhoto)) {
                    Object obj2;
                    if (!obj2.f) {
                        if (faceBoxConverter != null) {
                            obj2 = faceBoxConverter.m12942a((FaceBox) obj2);
                        }
                        if (obj2 != null) {
                            arrayList.add(obj2);
                        }
                    }
                }
                Collections.sort(arrayList, new C09586(this));
            }
            this.f10995e = arrayList;
            this.f10998h = zoomableImageView.getScale();
            this.f10999i = new Matrix(zoomableImageView.getPhotoDisplayMatrix());
            m12996a(this, tagTarget, true, z);
        }
    }

    public final void m13002b() {
        m13000a(true);
    }

    public final void m13000a(boolean z) {
        if (this.f10993c.a() != null && this.f10993c.a().getZoomableImageView() != null) {
            ZoomableImageView zoomableImageView = this.f10993c.a().getZoomableImageView();
            RectF a = TypeaheadAnimationHelper.a(zoomableImageView, this.f10997g.d(), this.f10999i);
            PointF pointF = new PointF(a.centerX(), a.centerY());
            float f = pointF.x - this.f11000j.x;
            float f2 = pointF.y - this.f11000j.y;
            zoomableImageView.setZoomAndPanListener(new C09553(this));
            zoomableImageView.a(this.f10998h, this.f11000j.x, this.f11000j.y, f, f2, z ? 300 : 0);
            this.f10994d.a(z, new PointF(pointF.x, a.bottom));
            this.f10993c.a().m12976b(z);
            TaggingInterfaceControllerImpl taggingInterfaceControllerImpl = this.f11001k;
            taggingInterfaceControllerImpl.a.aO = null;
            TaggablePhotoGalleryFragment.aA(taggingInterfaceControllerImpl.a).m12984n();
            TaggablePhotoGalleryFragment.aC(taggingInterfaceControllerImpl.a);
            TaggablePhotoGalleryFragment.aD(taggingInterfaceControllerImpl.a);
        } else if (this.f10994d != null && this.f10994d.isShown()) {
            this.f10994d.a(false, null);
        }
    }

    private void m12995a(int i, String str, TagTypeaheadDataSource tagTypeaheadDataSource, GroupMembersTaggingTypeaheadDataSourceProvider groupMembersTaggingTypeaheadDataSourceProvider, QeAccessor qeAccessor) {
        if (i == 69076575 && qeAccessor.a(ExperimentsForTaggingABTestModule.d, false)) {
            this.f10994d.a(groupMembersTaggingTypeaheadDataSourceProvider.a(Long.valueOf(Long.parseLong(str))));
        } else {
            this.f10994d.a(tagTypeaheadDataSource);
        }
    }

    public static void m12996a(TaggingInterfaceController taggingInterfaceController, TagTarget tagTarget, boolean z, boolean z2) {
        SelectedFaceParams a;
        TaggingInterfaceControllerImpl taggingInterfaceControllerImpl = taggingInterfaceController.f11001k;
        taggingInterfaceControllerImpl.a.al.h();
        TaggablePhotoGalleryFragment.aB(taggingInterfaceControllerImpl.a);
        TaggablePhotoGalleryFragment.aA(taggingInterfaceControllerImpl.a).m12985o();
        TaggablePhotoGalleryFragment.aA(taggingInterfaceControllerImpl.a).f10966i = true;
        TaggablePhotoGalleryFragment.aA(taggingInterfaceControllerImpl.a).getZoomableImageView().d();
        taggingInterfaceControllerImpl.a.aN.c();
        TaggablePhotoGalleryFragment.aE(taggingInterfaceControllerImpl.a);
        taggingInterfaceController.f10997g = tagTarget;
        ZoomableImageView zoomableImageView = taggingInterfaceController.f10993c.a().getZoomableImageView();
        RectF a2 = TypeaheadAnimationHelper.a(zoomableImageView, taggingInterfaceController.f10997g.d(), zoomableImageView.getPhotoDisplayMatrix());
        PointF pointF = new PointF(a2.centerX(), a2.centerY());
        PointF pointF2 = new PointF(tagTarget.f().x * ((float) zoomableImageView.getPhotoWidth()), tagTarget.f().y * ((float) zoomableImageView.getPhotoHeight()));
        if (z2) {
            float a3;
            if (tagTarget instanceof FaceBox) {
                a3 = TypeaheadAnimationHelper.a(zoomableImageView.getPhotoHeight(), zoomableImageView.getPhotoWidth(), tagTarget.d());
            } else {
                a3 = taggingInterfaceController.f10991a.a(zoomableImageView.getPhotoDisplayMatrix());
            }
            taggingInterfaceController.f10993c.a().m12972a(pointF2, a3);
        }
        if (tagTarget instanceof FaceBox) {
            a = taggingInterfaceController.f10991a.a(zoomableImageView, tagTarget.d());
        } else {
            a = taggingInterfaceController.f10991a.a(zoomableImageView);
        }
        taggingInterfaceController.f11000j = TypeaheadAnimationHelper.a(zoomableImageView, pointF2, a);
        final PointF pointF3 = new PointF(pointF.x, a2.bottom);
        final PointF pointF4 = new PointF(taggingInterfaceController.f11000j.x, taggingInterfaceController.f11000j.y + (a.b / 2.0f));
        taggingInterfaceController.f10994d.a(pointF4, z ? 0.0f : 300.0f);
        if (!z) {
            taggingInterfaceController.f10994d.b();
        }
        if (z) {
            taggingInterfaceController.f10994d.a(true, m12997c(taggingInterfaceController), taggingInterfaceController.f10997g.n(), pointF3, pointF4, true);
        } else {
            zoomableImageView.setZoomAndPanListener(new ZoomableImageViewZoomAndPanListener(taggingInterfaceController) {
                final /* synthetic */ TaggingInterfaceController f10988c;

                public final void m12991a() {
                    this.f10988c.f10994d.a(true, TaggingInterfaceController.m12997c(this.f10988c), this.f10988c.f10997g.n(), pointF3, pointF4, true);
                }
            });
        }
        zoomableImageView.a(a.a, pointF.x, pointF.y, taggingInterfaceController.f11000j.x - pointF.x, taggingInterfaceController.f11000j.y - pointF.y, 300);
        if (tagTarget instanceof FaceBox) {
            taggingInterfaceController.f11001k.a((FaceBox) tagTarget);
        }
    }

    public static TagTypeaheadAdapterCallback m12997c(TaggingInterfaceController taggingInterfaceController) {
        return new C09575(taggingInterfaceController);
    }

    public static FaceBox m12994a(TaggingInterfaceController taggingInterfaceController, FaceBox faceBox) {
        if (taggingInterfaceController.f10995e.size() <= 1) {
            return null;
        }
        int indexOf = taggingInterfaceController.f10995e.indexOf(faceBox);
        return (FaceBox) taggingInterfaceController.f10995e.get(indexOf + 1 < taggingInterfaceController.f10995e.size() ? indexOf + 1 : 0);
    }
}
