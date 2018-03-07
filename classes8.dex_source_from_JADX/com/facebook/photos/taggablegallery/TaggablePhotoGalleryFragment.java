package com.facebook.photos.taggablegallery;

import android.content.Context;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.Toast;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.FindViewUtil;
import com.facebook.facerec.manager.FaceBoxPrioritizer;
import com.facebook.facerec.manager.FaceBoxPrioritizer.FaceBoxPrioritizerListener;
import com.facebook.facerec.manager.FaceRecManager;
import com.facebook.facerec.model.LocalFaceRecImageData;
import com.facebook.gif.abtest.ExperimentsForAnimatedGifAbTestModule;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.internal.ImageRequestBuilderFactory;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.media.MediaIdKey;
import com.facebook.ipc.media.SupportedMediaType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.TaggablePhotoGalleryFlowLogger;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.photos.LocalPhoto;
import com.facebook.photos.base.photos.Photo.PhotoSize;
import com.facebook.photos.base.tagging.FaceBox;
import com.facebook.photos.base.tagging.Tag;
import com.facebook.photos.base.tagging.TaggablePhoto;
import com.facebook.photos.creativeediting.abtest.IsUnifiedEditGalleryEnabled;
import com.facebook.photos.creativeediting.abtest.IsWhiteDesignEnabled;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.data.method.FetchDefaultTagSuggestions;
import com.facebook.photos.data.method.FetchDefaultTagSuggestions.DefaultTagSuggestionsCallback;
import com.facebook.photos.galleryutil.VisibilityAnimator;
import com.facebook.photos.local.LocalMediaCursor;
import com.facebook.photos.local.LocalMediaCursorImp;
import com.facebook.photos.local.LocalMediaCursorMethodAutoProvider;
import com.facebook.photos.local.MediaCursorUtil;
import com.facebook.photos.photogallery.PhotoView;
import com.facebook.photos.rotation.RotationManager;
import com.facebook.photos.taggablegallery.PhotoGallery.EventListener;
import com.facebook.photos.taggablegallery.TaggableGalleryConstants.Source;
import com.facebook.photos.tagging.AutoTaggingHelper;
import com.facebook.photos.tagging.shared.FamilyTagTypeaheadUtil;
import com.facebook.photos.tagging.shared.TagTypeahead;
import com.facebook.photos.tagging.shared.TagTypeahead.TagSuggestionsAdapter;
import com.facebook.photos.tagging.store.FaceBoxStore;
import com.facebook.photos.tagging.store.TagStore;
import com.facebook.photos.tagging.ui.TaggablePhotoView;
import com.facebook.photos.tagging.ui.TaggingInterfaceController;
import com.facebook.photos.tagging.ui.TaggingInterfaceControllerProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.resources.utils.ResourceUtils;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.animations.ViewAnimatorFactory;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;
import com.facebook.ui.images.fetch.FetchImageParams;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: show_snackbar_extra */
public class TaggablePhotoGalleryFragment extends FbFragment {
    private static final CallerContext at = CallerContext.a(TaggablePhotoGalleryFragment.class, "taggable_gallery");
    @Inject
    @IsWhiteDesignEnabled
    Provider<Boolean> f3446a;
    public boolean aA;
    private Cursor aB;
    private FbTextView aC;
    private ImageView aD;
    private Drawable aE;
    private Drawable aF;
    public int aG;
    private int aH;
    private int aI;
    private int aJ;
    public List<TaggingProfile> aK;
    private MediaIdKey aL;
    public NavigationEventListener aM;
    public PhotoGallery aN;
    public String aO;
    private String aP;
    private Source aQ;
    private TaggableGalleryPhotoSource aR;
    public ArrayList<CreativeEditingData> aS;
    public TaggablePhotoView aT;
    public TaggingInterfaceController aU;
    private Fb4aTitleBar aV;
    private VisibilityAnimator aW;
    private VisibilityAnimator aX;
    public TagTypeahead aY;
    private int aZ;
    @Inject
    public TaggablePhotoGalleryFlowLogger al;
    @Inject
    TaggableGalleryPhotoSourceCursorImpProvider am;
    @Inject
    TaggingInterfaceControllerProvider an;
    @Inject
    public TagStore ao;
    @Inject
    ViewHelperViewAnimatorFactory ap;
    @Inject
    QeAccessor aq;
    @Inject
    @IsUnifiedEditGalleryEnabled
    Provider<Boolean> ar;
    @Inject
    ImagePipeline as;
    @Nullable
    public FaceBox au;
    public boolean av;
    public boolean aw;
    public boolean ax;
    public boolean ay;
    public boolean az;
    @Inject
    AutoTaggingHelper f3447b;
    private String ba;
    @Inject
    EnhanceablePhotoViewFactory f3448c;
    @Inject
    public FaceBoxStore f3449d;
    @Inject
    FamilyTagTypeaheadUtil f3450e;
    @Inject
    FetchDefaultTagSuggestions f3451f;
    @Inject
    public Lazy<FaceBoxPrioritizer> f3452g;
    @Inject
    LocalMediaCursorImp f3453h;
    @Inject
    public RotationManager f3454i;

    /* compiled from: show_snackbar_extra */
    public interface NavigationEventListener {
        void mo141a(PhotoItem photoItem, boolean z);
    }

    /* compiled from: show_snackbar_extra */
    class C04361 implements OnClickListener {
        final /* synthetic */ TaggablePhotoGalleryFragment f3433a;

        C04361(TaggablePhotoGalleryFragment taggablePhotoGalleryFragment) {
            this.f3433a = taggablePhotoGalleryFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -900964634);
            if (this.f3433a.ay) {
                TaggablePhotoGalleryFragment.ax(this.f3433a);
            } else {
                TaggablePhotoGalleryFragment.aw(this.f3433a);
            }
            LogUtils.a(-1238031208, a);
        }
    }

    /* compiled from: show_snackbar_extra */
    class C04372 implements OnClickListener {
        final /* synthetic */ TaggablePhotoGalleryFragment f3434a;

        C04372(TaggablePhotoGalleryFragment taggablePhotoGalleryFragment) {
            this.f3434a = taggablePhotoGalleryFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1427890807);
            if (TaggablePhotoGalleryFragment.ar(this.f3434a)) {
                this.f3434a.aM.mo141a(TaggablePhotoGalleryFragment.ay(this.f3434a), false);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 725110528, a);
        }
    }

    /* compiled from: show_snackbar_extra */
    class C04383 extends OnToolbarButtonListener {
        final /* synthetic */ TaggablePhotoGalleryFragment f3435a;

        C04383(TaggablePhotoGalleryFragment taggablePhotoGalleryFragment) {
            this.f3435a = taggablePhotoGalleryFragment;
        }

        public final void m3398a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            if (TaggablePhotoGalleryFragment.ar(this.f3435a)) {
                this.f3435a.aM.mo141a(TaggablePhotoGalleryFragment.ay(this.f3435a), true);
            }
        }
    }

    /* compiled from: show_snackbar_extra */
    class C04394 implements OnClickListener {
        final /* synthetic */ TaggablePhotoGalleryFragment f3436a;

        C04394(TaggablePhotoGalleryFragment taggablePhotoGalleryFragment) {
            this.f3436a = taggablePhotoGalleryFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1416023638);
            if (TaggablePhotoGalleryFragment.ar(this.f3436a)) {
                int i;
                TaggablePhotoGalleryFragment taggablePhotoGalleryFragment = this.f3436a;
                taggablePhotoGalleryFragment.al.d();
                PhotoItem ay = TaggablePhotoGalleryFragment.ay(taggablePhotoGalleryFragment);
                taggablePhotoGalleryFragment.ao.d(ay);
                taggablePhotoGalleryFragment.f3449d.a(ay);
                if (ay == null) {
                    i = 0;
                } else {
                    i = ay.g();
                }
                taggablePhotoGalleryFragment.f3454i.a(ay, (i + 270) % 360);
                taggablePhotoGalleryFragment.aN.m3363a();
                taggablePhotoGalleryFragment.az = true;
            }
            Logger.a(2, EntryType.UI_INPUT_END, 447862028, a);
        }
    }

    /* compiled from: show_snackbar_extra */
    class C04405 implements OnTouchListener {
        final /* synthetic */ TaggablePhotoGalleryFragment f3437a;

        C04405(TaggablePhotoGalleryFragment taggablePhotoGalleryFragment) {
            this.f3437a = taggablePhotoGalleryFragment;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            Rect selectedRemovableTagDisplayRect = TaggablePhotoGalleryFragment.aA(this.f3437a).getSelectedRemovableTagDisplayRect();
            if (selectedRemovableTagDisplayRect == null || selectedRemovableTagDisplayRect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                this.f3437a.aw = false;
            } else {
                TaggablePhotoGalleryFragment.aA(this.f3437a).l();
                this.f3437a.aw = true;
            }
            return false;
        }
    }

    /* compiled from: show_snackbar_extra */
    class C04416 implements TagSuggestionsAdapter {
        final /* synthetic */ TaggablePhotoGalleryFragment f3438a;

        C04416(TaggablePhotoGalleryFragment taggablePhotoGalleryFragment) {
            this.f3438a = taggablePhotoGalleryFragment;
        }

        public final List<TaggingProfile> m3399a() {
            return ((FaceRecManager) ((FaceBoxPrioritizer) this.f3438a.f3452g.get()).g.get()).h.f;
        }
    }

    /* compiled from: show_snackbar_extra */
    public class C04427 implements EventListener {
        final /* synthetic */ TaggablePhotoGalleryFragment f3439a;

        public C04427(TaggablePhotoGalleryFragment taggablePhotoGalleryFragment) {
            this.f3439a = taggablePhotoGalleryFragment;
        }

        public final void mo188a(PhotoView photoView, int i) {
            TaggablePhotoGalleryFragment taggablePhotoGalleryFragment = this.f3439a;
            TaggablePhotoView taggablePhotoView = (TaggablePhotoView) photoView;
            if (taggablePhotoGalleryFragment.aA && taggablePhotoGalleryFragment.ay) {
                boolean z;
                taggablePhotoView.j();
                PhotoItem ay = TaggablePhotoGalleryFragment.ay(taggablePhotoGalleryFragment);
                Object obj = (ay == null || ay.f == null || !(ay.f instanceof LocalPhoto)) ? null : !((LocalPhoto) ay.f).f ? 1 : null;
                if (obj == null) {
                    z = false;
                } else {
                    TaggablePhoto taggablePhoto = (TaggablePhoto) photoView.b;
                    if (taggablePhotoGalleryFragment.f3449d.b(taggablePhoto)) {
                        for (FaceBox o : taggablePhotoGalleryFragment.f3449d.a(taggablePhoto)) {
                            if (!o.o()) {
                                z = true;
                                break;
                            }
                        }
                        z = false;
                    } else {
                        z = true;
                    }
                }
                taggablePhotoView.n = z;
            }
            taggablePhotoView.getZoomableImageView().i = false;
            taggablePhotoView.getZoomableImageView().j = false;
            taggablePhotoView.a(new C04449(taggablePhotoGalleryFragment, taggablePhotoView), false);
            taggablePhotoView.g = new Object(taggablePhotoGalleryFragment) {
                public final /* synthetic */ TaggablePhotoGalleryFragment f3428a;

                {
                    this.f3428a = r1;
                }

                public final void m3397a(Tag tag) {
                    if (tag != null) {
                        this.f3428a.az = true;
                        this.f3428a.al.k();
                        this.f3428a.ao.b(TaggablePhotoGalleryFragment.ay(this.f3428a), tag);
                        TaggablePhotoGalleryFragment.aA(this.f3428a).n();
                    }
                }
            };
        }

        public final void mo189b(PhotoView photoView, int i) {
            this.f3439a.m3411a(photoView, i);
        }

        public final void mo187a() {
            TaggablePhotoGalleryFragment taggablePhotoGalleryFragment = this.f3439a;
            if (taggablePhotoGalleryFragment.aA) {
                FaceBoxPrioritizer faceBoxPrioritizer = (FaceBoxPrioritizer) taggablePhotoGalleryFragment.f3452g.get();
                faceBoxPrioritizer.c = true;
                if (faceBoxPrioritizer.a != null) {
                    faceBoxPrioritizer.a.cancel(false);
                }
                if (taggablePhotoGalleryFragment.aU.a()) {
                    taggablePhotoGalleryFragment.aU.a(false);
                }
            }
            taggablePhotoGalleryFragment.aT = null;
            taggablePhotoGalleryFragment.aG = -2;
        }
    }

    /* compiled from: show_snackbar_extra */
    class C04438 implements DefaultTagSuggestionsCallback {
        final /* synthetic */ TaggablePhotoGalleryFragment f3440a;

        C04438(TaggablePhotoGalleryFragment taggablePhotoGalleryFragment) {
            this.f3440a = taggablePhotoGalleryFragment;
        }

        public final void m3403a(List<TaggingProfile> list) {
            this.f3440a.aK = list;
            this.f3440a.aY.setDefaultTagSuggestions(this.f3440a.aK);
        }
    }

    /* compiled from: show_snackbar_extra */
    public class C04449 implements Runnable {
        final /* synthetic */ TaggablePhotoView f3441a;
        final /* synthetic */ TaggablePhotoGalleryFragment f3442b;

        public C04449(TaggablePhotoGalleryFragment taggablePhotoGalleryFragment, TaggablePhotoView taggablePhotoView) {
            this.f3442b = taggablePhotoGalleryFragment;
            this.f3441a = taggablePhotoView;
        }

        public void run() {
            this.f3441a.getZoomableImageView().i = true;
            this.f3441a.getZoomableImageView().j = true;
            if (this.f3442b.aA && this.f3442b.ay) {
                this.f3441a.n();
            }
        }
    }

    /* compiled from: show_snackbar_extra */
    class FaceBoxPrioritizerListenerImpl implements FaceBoxPrioritizerListener {
        final /* synthetic */ TaggablePhotoGalleryFragment f3443a;

        public FaceBoxPrioritizerListenerImpl(TaggablePhotoGalleryFragment taggablePhotoGalleryFragment) {
            this.f3443a = taggablePhotoGalleryFragment;
        }

        public final void m3404a(LocalFaceRecImageData localFaceRecImageData) {
            if (!this.f3443a.av && TaggablePhotoGalleryFragment.az(this.f3443a).a == localFaceRecImageData.g() && this.f3443a.f3449d.b(TaggablePhotoGalleryFragment.az(this.f3443a))) {
                TaggablePhotoGalleryFragment.aD(this.f3443a);
            }
            for (PhotoView photoView : this.f3443a.aN.getPhotoViewsInPager()) {
                if (((TaggablePhoto) photoView.b).a == localFaceRecImageData.g()) {
                    ((TaggablePhotoView) photoView).n();
                    EnhanceablePhotoView enhanceablePhotoView = (EnhanceablePhotoView) photoView;
                    if (!(enhanceablePhotoView.f3383c || enhanceablePhotoView.f3382b == null)) {
                        enhanceablePhotoView.setFetchParams(enhanceablePhotoView.f3382b);
                    }
                }
            }
        }

        public final void m3405b(LocalFaceRecImageData localFaceRecImageData) {
            if (this.f3443a.aO == null || TaggablePhotoGalleryFragment.az(this.f3443a).a != localFaceRecImageData.g()) {
                boolean z;
                TaggablePhotoGalleryFragment taggablePhotoGalleryFragment = this.f3443a;
                if (!localFaceRecImageData.e().isEmpty() || this.f3443a.az) {
                    z = true;
                } else {
                    z = false;
                }
                taggablePhotoGalleryFragment.az = z;
                this.f3443a.f3447b.a(this.f3443a.getContext(), localFaceRecImageData, null);
                for (PhotoView photoView : this.f3443a.aN.getPhotoViewsInPager()) {
                    if (((TaggablePhoto) photoView.b).a == localFaceRecImageData.g()) {
                        ((TaggablePhotoView) photoView).n = false;
                        if (!localFaceRecImageData.e().isEmpty()) {
                            ((TaggablePhotoView) photoView).h();
                        }
                        ((TaggablePhotoView) photoView).m();
                    }
                }
                return;
            }
            for (FaceBox faceBox : localFaceRecImageData.b()) {
                if (faceBox.a == this.f3443a.aO) {
                    TaggingInterfaceController taggingInterfaceController = this.f3443a.aU;
                    taggingInterfaceController.d.setTagSuggestions(faceBox.n());
                    return;
                }
            }
        }
    }

    /* compiled from: show_snackbar_extra */
    enum ScrollDirection {
        PREVIOUS,
        NEXT
    }

    /* compiled from: show_snackbar_extra */
    public class TaggingInterfaceControllerHostImpl {
        final /* synthetic */ TaggablePhotoGalleryFragment f3444a;

        public TaggingInterfaceControllerHostImpl(TaggablePhotoGalleryFragment taggablePhotoGalleryFragment) {
            this.f3444a = taggablePhotoGalleryFragment;
        }

        public final TaggablePhotoView m3406a() {
            return TaggablePhotoGalleryFragment.aA(this.f3444a);
        }
    }

    /* compiled from: show_snackbar_extra */
    public class TaggingInterfaceControllerImpl {
        public final /* synthetic */ TaggablePhotoGalleryFragment f3445a;

        public TaggingInterfaceControllerImpl(TaggablePhotoGalleryFragment taggablePhotoGalleryFragment) {
            this.f3445a = taggablePhotoGalleryFragment;
        }

        public final void m3407a(FaceBox faceBox) {
            this.f3445a.al.g();
            this.f3445a.aO = faceBox.a;
        }

        public final void m3408a(Tag tag) {
            int size;
            this.f3445a.az = true;
            List<Tag> a = this.f3445a.ao.a(TaggablePhotoGalleryFragment.az(this.f3445a));
            if (tag.c <= 0) {
                for (Tag tag2 : a) {
                    if (tag2.b.equals(tag.b)) {
                        return;
                    }
                }
            }
            TagStore tagStore = this.f3445a.ao;
            PhotoItem ay = TaggablePhotoGalleryFragment.ay(this.f3445a);
            if (tagStore.h.containsKey(ay.d())) {
                size = ((List) tagStore.h.get(ay.d())).size();
            } else {
                size = 0;
            }
            if (size >= 50) {
                Toast.makeText(this.f3445a.getContext(), 2131234424, 1).show();
                return;
            }
            this.f3445a.ao.a(TaggablePhotoGalleryFragment.ay(this.f3445a), tag);
            this.f3445a.al.j();
            TaggablePhotoGalleryFragment.aA(this.f3445a).h();
            TaggablePhotoGalleryFragment.aA(this.f3445a).n();
        }
    }

    public static void m3412a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((TaggablePhotoGalleryFragment) obj).m3413a(IdBasedProvider.a(fbInjector, 4251), AutoTaggingHelper.a(fbInjector), EnhanceablePhotoViewFactory.m3323b(fbInjector), FaceBoxStore.a(fbInjector), FamilyTagTypeaheadUtil.a(fbInjector), FetchDefaultTagSuggestions.a(fbInjector), IdBasedLazy.a(fbInjector, 5764), LocalMediaCursorMethodAutoProvider.a(fbInjector), RotationManager.a(fbInjector), TaggablePhotoGalleryFlowLogger.a(fbInjector), (TaggableGalleryPhotoSourceCursorImpProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(TaggableGalleryPhotoSourceCursorImpProvider.class), (TaggingInterfaceControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(TaggingInterfaceControllerProvider.class), TagStore.a(fbInjector), ViewHelperViewAnimatorFactory.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), IdBasedProvider.a(fbInjector, 4250), ImagePipelineMethodAutoProvider.a(fbInjector));
    }

    private void m3413a(Provider<Boolean> provider, AutoTaggingHelper autoTaggingHelper, EnhanceablePhotoViewFactory enhanceablePhotoViewFactory, FaceBoxStore faceBoxStore, FamilyTagTypeaheadUtil familyTagTypeaheadUtil, FetchDefaultTagSuggestions fetchDefaultTagSuggestions, Lazy<FaceBoxPrioritizer> lazy, LocalMediaCursor localMediaCursor, RotationManager rotationManager, TaggablePhotoGalleryFlowLogger taggablePhotoGalleryFlowLogger, TaggableGalleryPhotoSourceCursorImpProvider taggableGalleryPhotoSourceCursorImpProvider, TaggingInterfaceControllerProvider taggingInterfaceControllerProvider, TagStore tagStore, ViewAnimatorFactory viewAnimatorFactory, QeAccessor qeAccessor, Provider<Boolean> provider2, ImagePipeline imagePipeline) {
        this.f3446a = provider;
        this.f3447b = autoTaggingHelper;
        this.f3448c = enhanceablePhotoViewFactory;
        this.f3449d = faceBoxStore;
        this.f3450e = familyTagTypeaheadUtil;
        this.f3451f = fetchDefaultTagSuggestions;
        this.f3452g = lazy;
        this.f3453h = localMediaCursor;
        this.f3454i = rotationManager;
        this.al = taggablePhotoGalleryFlowLogger;
        this.am = taggableGalleryPhotoSourceCursorImpProvider;
        this.an = taggingInterfaceControllerProvider;
        this.ao = tagStore;
        this.ap = viewAnimatorFactory;
        this.aq = qeAccessor;
        this.ar = provider2;
        this.as = imagePipeline;
    }

    public final void m3427e(Bundle bundle) {
        bundle.putParcelable("start_photo_id_in_gallery", this.aL);
        super.e(bundle);
    }

    public final void m3426c(Bundle bundle) {
        super.c(bundle);
        Class cls = TaggablePhotoGalleryFragment.class;
        m3412a((Object) this, getContext());
        if (this.aR == null) {
            this.aB = this.f3453h.a(this.aq.a(ExperimentsForAnimatedGifAbTestModule.a, false) ? SupportedMediaType.PHOTO_ONLY_EXCLUDING_GIFS : SupportedMediaType.PHOTO_ONLY, null);
            TaggableGalleryPhotoSourceCursorImpProvider taggableGalleryPhotoSourceCursorImpProvider = this.am;
            this.aR = new TaggableGalleryPhotoSourceCursorImp(this.aB, MediaCursorUtil.b(taggableGalleryPhotoSourceCursorImpProvider), LocalMediaCursorMethodAutoProvider.b(taggableGalleryPhotoSourceCursorImpProvider));
        }
        if (bundle != null) {
            this.aL = (MediaIdKey) bundle.getParcelable("start_photo_id_in_gallery");
        }
        this.aJ = this.aR.mo186a(this.aL).intValue();
    }

    public final void m3420G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1773216536);
        super.G();
        if (this.aU != null && this.aU.a()) {
            this.aU.a(false);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1173924201, a);
    }

    public final void m3423a(MediaIdKey mediaIdKey, boolean z, NavigationEventListener navigationEventListener, Source source, String str) {
        m3424a(null, null, mediaIdKey, z, navigationEventListener, source, str, null, 0, null);
    }

    public final void m3424a(TaggableGalleryPhotoSource taggableGalleryPhotoSource, ArrayList<CreativeEditingData> arrayList, MediaIdKey mediaIdKey, boolean z, NavigationEventListener navigationEventListener, Source source, String str, @Nullable FaceBox faceBox, int i, @Nullable String str2) {
        this.aR = taggableGalleryPhotoSource;
        this.aS = arrayList;
        this.aL = mediaIdKey;
        this.aA = z;
        this.aM = navigationEventListener;
        this.aQ = source;
        this.aP = str;
        this.az = false;
        this.au = faceBox;
        this.aH = 0;
        this.aI = 0;
        this.aZ = i;
        this.ba = str2;
    }

    public final View m3422a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -973853036);
        this.al.a = this.aP;
        this.al.a();
        View inflate = layoutInflater.inflate(this.aQ == Source.COMPOSER ? 2130903731 : 2130907369, viewGroup, false);
        m3414b(inflate);
        if (this.aA) {
            this.f3447b.b();
            m3417c(inflate);
        }
        this.aN = (PhotoGallery) inflate.findViewById(2131560643);
        this.aN.m3364a((EventListener) new C04427(this));
        this.aN.m3365a(this.aR, this.f3448c, this.aJ);
        this.aD = (ImageView) inflate.findViewById(2131567509);
        this.aE = jW_().getDrawable(2130840533);
        this.aF = jW_().getDrawable(2130840533);
        this.aF.mutate().setColorFilter(new PorterDuffColorFilter(-7829368, Mode.SRC_ATOP));
        this.aD.setImageDrawable(this.aE);
        aC(this);
        if (this.aA) {
            aw(this);
            this.aD.setOnClickListener(new C04361(this));
        } else {
            ax(this);
            this.aD.setVisibility(8);
        }
        if (((Boolean) this.f3446a.get()).booleanValue()) {
            inflate.setBackgroundResource(2131361920);
        }
        LogUtils.f(-1699093643, a);
        return inflate;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m3418g(configuration.orientation);
    }

    public final void m3421I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 523625143);
        super.I();
        this.al.a(this.aH, this.aI);
        if (this.aA) {
            this.f3451f.f.clear();
            if (this.aQ != Source.SIMPLEPICKER) {
                ((FaceBoxPrioritizer) this.f3452g.get()).e();
            }
            ((FaceBoxPrioritizer) this.f3452g.get()).j = null;
            ((FaceBoxPrioritizer) this.f3452g.get()).b();
        }
        if (this.aB != null) {
            this.aB.close();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1829161741, a);
    }

    public final boolean m3425b() {
        if (this.aA && this.aU.a()) {
            this.aU.b();
        } else {
            this.aM.mo141a(ay(this), false);
        }
        switch (this.aQ) {
            case SIMPLEPICKER:
                this.al.b();
                break;
            case COMPOSER:
                this.al.c();
                break;
        }
        return true;
    }

    private void m3414b(View view) {
        int i;
        this.aV = (Fb4aTitleBar) FindViewUtil.b(view, 2131558563);
        m3418g(jW_().getConfiguration().orientation);
        this.aX = new VisibilityAnimator(this.aV, 150, false, this.ap);
        this.aW = new VisibilityAnimator(view.findViewById(2131567824), 150, false, this.ap);
        if (this.aQ != Source.COMPOSER) {
            this.aV.setTitle(b(2131234408));
        }
        this.aV.a(new C04372(this));
        Builder a = TitleBarButtonSpec.a();
        if (this.aQ == Source.COMPOSER) {
            i = 2131234399;
        } else {
            i = 2131234407;
        }
        a.g = b(i);
        this.aV.setButtonSpecs(ImmutableList.of(a.a()));
        this.aV.setOnToolbarButtonListener(new C04383(this));
        View findViewById = view.findViewById(2131567825);
        if (((Boolean) this.f3446a.get()).booleanValue() && (findViewById instanceof ImageView)) {
            ((ImageView) findViewById).setColorFilter(getContext().getResources().getColor(2131361917));
        }
        if (findViewById != null) {
            if (((Boolean) this.ar.get()).booleanValue()) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setOnClickListener(new C04394(this));
            }
        }
        view.findViewById(2131567828).setOnTouchListener(new C04405(this));
    }

    public static boolean ar(TaggablePhotoGalleryFragment taggablePhotoGalleryFragment) {
        Object obj;
        PhotoView photoView = (PhotoView) taggablePhotoGalleryFragment.aN.getCurrentPhotoView();
        if (photoView.c.getImageDrawable() == null || photoView.b()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            return true;
        }
        return false;
    }

    private void m3418g(int i) {
        LayoutParams layoutParams = this.aV.getLayoutParams();
        layoutParams.height = (int) jW_().getDimension(i == 2 ? 2131429462 : 2131429461);
        this.aV.setLayoutParams(layoutParams);
    }

    private void m3417c(View view) {
        this.aY = (TagTypeahead) view.findViewById(2131567827);
        this.f3450e.b();
        at(this);
        this.aY.A = new C04416(this);
        this.aU = this.an.a(getContext(), new TaggingInterfaceControllerHostImpl(this), this.aY, this.aZ, this.ba);
        this.aU.k = new TaggingInterfaceControllerImpl(this);
        ((FaceBoxPrioritizer) this.f3452g.get()).j = new FaceBoxPrioritizerListenerImpl(this);
        this.aC = (FbTextView) view.findViewById(2131567826);
        if (((Boolean) this.f3446a.get()).booleanValue()) {
            view.findViewById(2131567824).setBackgroundResource(2131361981);
            this.aC.setTextColor(jW_().getColor(2131361917));
        }
    }

    public static void at(TaggablePhotoGalleryFragment taggablePhotoGalleryFragment) {
        taggablePhotoGalleryFragment.f3451f.a(new C04438(taggablePhotoGalleryFragment));
    }

    private void m3411a(final PhotoView photoView, int i) {
        if (this.aQ == Source.COMPOSER) {
            this.aV.setTitle(ResourceUtils.a(jW_(), 2131234411, 2131234412, this.aR.mo184a(), new Object[]{Integer.valueOf(i + 1), Integer.valueOf(this.aR.mo184a())}));
        }
        m3419h(i);
        if (!(this.aG == -2 || this.aG == i)) {
            if (this.aG > i) {
                this.aH++;
            } else {
                this.aI++;
            }
        }
        ScrollDirection scrollDirection = i >= this.aG ? ScrollDirection.NEXT : ScrollDirection.PREVIOUS;
        this.aG = i;
        if (!this.av && this.f3449d.b(az(this))) {
            aD(this);
        }
        if (this.aT != null && this.aA) {
            this.aT.l();
        }
        this.aT = (TaggablePhotoView) photoView;
        if (this.aA) {
            ((TaggablePhotoView) photoView).g();
            ((FaceBoxPrioritizer) this.f3452g.get()).a(m3409a(photoView, scrollDirection));
            if (this.au != null && this.ay) {
                final TaggablePhoto taggablePhoto = (TaggablePhoto) ((TaggablePhotoView) photoView).b;
                photoView.a(new Runnable(this) {
                    final /* synthetic */ TaggablePhotoGalleryFragment f3431c;

                    public void run() {
                        FaceBox faceBox;
                        TaggablePhotoGalleryFragment taggablePhotoGalleryFragment = this.f3431c;
                        TaggablePhoto taggablePhoto = taggablePhoto;
                        FaceBox faceBox2 = this.f3431c.au;
                        Preconditions.checkNotNull(taggablePhoto);
                        Preconditions.checkNotNull(faceBox2);
                        if (taggablePhotoGalleryFragment.f3449d.a(taggablePhoto) == null) {
                            faceBox = null;
                        } else {
                            TaggablePhotoView aA = TaggablePhotoGalleryFragment.aA(taggablePhotoGalleryFragment);
                            for (FaceBox faceBox3 : taggablePhotoGalleryFragment.f3449d.a(TaggablePhotoGalleryFragment.az(taggablePhotoGalleryFragment))) {
                                if (faceBox3.a.equals(faceBox2.a)) {
                                    faceBox3 = aA.a(faceBox3);
                                    break;
                                }
                            }
                            faceBox3 = null;
                        }
                        FaceBox faceBox4 = faceBox3;
                        if (faceBox4 != null && !faceBox4.f) {
                            this.f3431c.aU.a(taggablePhoto, (TaggablePhotoView) photoView, faceBox4, true);
                            this.f3431c.au = null;
                        }
                    }
                }, false);
            }
        }
    }

    private List<LocalFaceRecImageData> m3409a(PhotoView photoView, ScrollDirection scrollDirection) {
        Preconditions.checkNotNull(photoView);
        List photoViewsInPager = this.aN.getPhotoViewsInPager();
        List<LocalFaceRecImageData> arrayList = new ArrayList();
        int size = photoViewsInPager.size();
        int i = 0;
        while (i < photoViewsInPager.size()) {
            if (photoViewsInPager.get(i) == photoView) {
                break;
            }
            i++;
        }
        i = -1;
        int i2 = i;
        if (i2 < 0) {
            return arrayList;
        }
        int i3;
        if (scrollDirection == ScrollDirection.NEXT) {
            for (i3 = i2; i3 < size; i3++) {
                arrayList.add(new LocalFaceRecImageData(m3416c((PhotoView) photoViewsInPager.get(i3)), this.ao, this.f3449d));
            }
            for (i3 = i2 - 1; i3 >= 0; i3--) {
                arrayList.add(new LocalFaceRecImageData(m3416c((PhotoView) photoViewsInPager.get(i3)), this.ao, this.f3449d));
            }
        } else {
            for (i3 = i2; i3 >= 0; i3--) {
                arrayList.add(new LocalFaceRecImageData(m3416c((PhotoView) photoViewsInPager.get(i3)), this.ao, this.f3449d));
            }
            for (i3 = i2 + 1; i3 < size; i3++) {
                arrayList.add(new LocalFaceRecImageData(m3416c((PhotoView) photoViewsInPager.get(i3)), this.ao, this.f3449d));
            }
        }
        return arrayList;
    }

    public static void aw(TaggablePhotoGalleryFragment taggablePhotoGalleryFragment) {
        taggablePhotoGalleryFragment.al.e();
        taggablePhotoGalleryFragment.ay = true;
        for (PhotoView photoView : taggablePhotoGalleryFragment.aN.getPhotoViewsInPager()) {
            ((TaggablePhotoView) photoView).j();
            ((TaggablePhotoView) photoView).n();
        }
        taggablePhotoGalleryFragment.aD.setImageDrawable(taggablePhotoGalleryFragment.aE);
        aD(taggablePhotoGalleryFragment);
    }

    public static void ax(TaggablePhotoGalleryFragment taggablePhotoGalleryFragment) {
        taggablePhotoGalleryFragment.al.f();
        aE(taggablePhotoGalleryFragment);
        taggablePhotoGalleryFragment.ay = false;
        for (PhotoView photoView : taggablePhotoGalleryFragment.aN.getPhotoViewsInPager()) {
            ((TaggablePhotoView) photoView).k();
            ((TaggablePhotoView) photoView).o();
        }
        taggablePhotoGalleryFragment.aD.setImageDrawable(taggablePhotoGalleryFragment.aF);
    }

    public static PhotoItem ay(TaggablePhotoGalleryFragment taggablePhotoGalleryFragment) {
        return taggablePhotoGalleryFragment.aR.mo185a(taggablePhotoGalleryFragment.aN.getCurrentPosition()).f3407a;
    }

    private PhotoItem m3416c(PhotoView photoView) {
        return this.aR.mo185a(PhotoGallery.m3351a(photoView)).f3407a;
    }

    public static LocalPhoto az(TaggablePhotoGalleryFragment taggablePhotoGalleryFragment) {
        return (LocalPhoto) taggablePhotoGalleryFragment.aN.f3402g;
    }

    public static TaggablePhotoView aA(TaggablePhotoGalleryFragment taggablePhotoGalleryFragment) {
        return (TaggablePhotoView) taggablePhotoGalleryFragment.aN.getCurrentPhotoView();
    }

    private void m3419h(int i) {
        if (i - 1 == this.aG) {
            m3410a(i + 2, (i + 2) + 1);
        } else if (i + 1 == this.aG) {
            m3410a(i - 2, (i - 2) + 1);
        } else if (i != this.aG && this.aG != -2) {
            m3410a(i - 2, (i + 2) + 1);
        }
    }

    private void m3410a(int i, int i2) {
        int min = Math.min(i2, this.aR.mo184a());
        for (int max = Math.max(i, 0); max < min; max++) {
            FetchImageParams a = this.aR.mo185a(max).f3407a.f.a(PhotoSize.THUMBNAIL);
            if (a.j() != null) {
                this.as.e(ImageRequestBuilderFactory.a(a, jW_()).m(), at);
            }
        }
    }

    public static void aB(TaggablePhotoGalleryFragment taggablePhotoGalleryFragment) {
        taggablePhotoGalleryFragment.aX.d();
        taggablePhotoGalleryFragment.aW.d();
        taggablePhotoGalleryFragment.ax = false;
    }

    public static void aC(TaggablePhotoGalleryFragment taggablePhotoGalleryFragment) {
        taggablePhotoGalleryFragment.aX.c();
        taggablePhotoGalleryFragment.aW.c();
        taggablePhotoGalleryFragment.ax = true;
    }

    public static void aD(TaggablePhotoGalleryFragment taggablePhotoGalleryFragment) {
        if (taggablePhotoGalleryFragment.ay) {
            taggablePhotoGalleryFragment.aC.setVisibility(0);
            taggablePhotoGalleryFragment.av = true;
        }
    }

    public static void aE(TaggablePhotoGalleryFragment taggablePhotoGalleryFragment) {
        if (taggablePhotoGalleryFragment.ay) {
            taggablePhotoGalleryFragment.aC.setVisibility(4);
        }
    }
}
