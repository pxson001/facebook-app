package com.facebook.photos.editgallery;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Environment;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.facebook.bitmaps.ImageResizer.ImageResizingInputFileException;
import com.facebook.bitmaps.NativeImageProcessor;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.editgallery.EditFeature;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativeediting.CropOverlayView;
import com.facebook.photos.creativeediting.CropOverlayView.CropMode;
import com.facebook.photos.creativeediting.RotatingFrameLayout;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger.LoggingParameters;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.creativeediting.model.CreativeEditingData.Builder;
import com.facebook.photos.creativeediting.renderers.CreativeEditingPhotoOverlayView;
import com.facebook.photos.creativeediting.renderers.MovableItemContainer;
import com.facebook.photos.creativeediting.renderers.MovableItemContainerProvider;
import com.facebook.photos.creativeediting.renderers.PhotoOverlayController;
import com.facebook.photos.creativeediting.renderers.PhotoOverlayController.OverlayType;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableParamsHelper;
import com.facebook.photos.creativeediting.utilities.CreativeEditingFileManager;
import com.facebook.photos.creativeediting.utilities.MediaRotationHelper;
import com.facebook.photos.creativeediting.utilities.RotateRectfHelper;
import com.facebook.photos.creativeediting.utilities.SpringAlphaAnimator;
import com.facebook.photos.editgallery.EditFeatureController.UriRequestType;
import com.facebook.photos.editgallery.EditGalleryFragmentController.C08695;
import com.facebook.photos.editgallery.EditGalleryFragmentController.FileEditingListener;
import com.facebook.photos.editgallery.EditGalleryFragmentController.State;
import com.facebook.photos.editgallery.EditGalleryFragmentManager.UsageParams;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: links_add_click */
public class CropEditController implements EditFeatureController {
    public ImageButton f10175A;
    public FbTextView f10176B;
    public FbTextView f10177C;
    public boolean f10178D;
    @Nullable
    public RectF f10179E;
    private EditableOverlayContainerView f10180F;
    public boolean f10181G;
    private CreativeEditingPhotoOverlayView f10182H;
    public boolean f10183I;
    public Uri f10184J;
    public Uri f10185K;
    private boolean f10186L;
    private Optional<CreativeEditingLogger> f10187M;
    public LoggingParameters f10188N;
    public int f10189O = 0;
    public Optional<MovableItemContainer> f10190P = Absent.withType();
    public final OnClickListener f10191a = new C08531(this);
    public final OnClickListener f10192b = new C08542(this);
    public final OnClickListener f10193c = new C08553(this);
    public final RotatingFrameLayout f10194d;
    public final String f10195e;
    public final Context f10196f;
    private final PhotoOverlayController f10197g;
    public final ListeningExecutorService f10198h;
    private final Lazy<TasksManager> f10199i;
    public final CreativeEditingFileManager f10200j;
    public final C08695 f10201k;
    public final ImagePipeline f10202l;
    private final Lazy<MediaRotationHelper> f10203m;
    private final EditGalleryFragmentController f10204n;
    private final View f10205o;
    private final Provider<SpringAlphaAnimator> f10206p;
    private final SwipeableParamsHelper f10207q;
    public final MovableItemContainerProvider f10208r;
    public final Rect f10209s = new Rect();
    public final Toaster f10210t;
    public State f10211u;
    public CreativeEditingData f10212v;
    public boolean f10213w;
    @Nullable
    public RectF f10214x;
    public CropOverlayView f10215y;
    public FbDraweeView f10216z;

    /* compiled from: links_add_click */
    class C08531 implements OnClickListener {
        final /* synthetic */ CropEditController f10164a;

        C08531(CropEditController cropEditController) {
            this.f10164a = cropEditController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1316727266);
            CropEditController cropEditController = this.f10164a;
            cropEditController.f10176B.setTextColor(cropEditController.f10196f.getResources().getColor(2131361917));
            cropEditController.f10177C.setTextColor(cropEditController.f10196f.getResources().getColor(2131362927));
            cropEditController.f10215y.setCropMode(CropMode.SQUARE);
            Logger.a(2, EntryType.UI_INPUT_END, -1156132109, a);
        }
    }

    /* compiled from: links_add_click */
    class C08542 implements OnClickListener {
        final /* synthetic */ CropEditController f10165a;

        C08542(CropEditController cropEditController) {
            this.f10165a = cropEditController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1638829542);
            CropEditController cropEditController = this.f10165a;
            cropEditController.f10176B.setTextColor(cropEditController.f10196f.getResources().getColor(2131362927));
            cropEditController.f10177C.setTextColor(cropEditController.f10196f.getResources().getColor(2131361917));
            cropEditController.f10215y.setCropMode(CropMode.FREE_FORM);
            Logger.a(2, EntryType.UI_INPUT_END, 2094103058, a);
        }
    }

    /* compiled from: links_add_click */
    class C08553 implements OnClickListener {
        final /* synthetic */ CropEditController f10166a;

        C08553(CropEditController cropEditController) {
            this.f10166a = cropEditController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 515770044);
            if (ImageFormatChecker.a(this.f10166a.f10184J.getPath()) == ImageFormat.JPEG) {
                this.f10166a.f10181G = true;
                this.f10166a.f10194d.m11441a(-90.0d);
                CropEditController cropEditController = this.f10166a;
                cropEditController.f10189O++;
            } else {
                this.f10166a.f10210t.a(new ToastBuilder(2131237804));
            }
            LogUtils.a(820172952, a);
        }
    }

    /* compiled from: links_add_click */
    public class C08564 {
        public final /* synthetic */ CropEditController f10167a;

        C08564(CropEditController cropEditController) {
            this.f10167a = cropEditController;
        }

        public final void m12040a(RectF rectF, boolean z) {
            Preconditions.checkNotNull(rectF);
            if (z || this.f10167a.f10178D) {
                FbDraweeView fbDraweeView = this.f10167a.f10216z;
                if (rectF != null) {
                    rectF.left -= (float) fbDraweeView.getPaddingLeft();
                    rectF.top -= (float) fbDraweeView.getPaddingTop();
                    rectF.right -= (float) fbDraweeView.getPaddingLeft();
                    rectF.bottom -= (float) fbDraweeView.getPaddingTop();
                }
            }
            this.f10167a.f10214x = rectF;
            if (z) {
                this.f10167a.f10181G = true;
                this.f10167a.f10183I = true;
                this.f10167a.f10213w = false;
                this.f10167a.f10188N = this.f10167a.f10215y.f9467E;
            }
            CropEditController.m12065s(this.f10167a);
        }
    }

    @Inject
    public CropEditController(@Assisted Uri uri, @Assisted RotatingFrameLayout rotatingFrameLayout, @Assisted EditableOverlayContainerView editableOverlayContainerView, @Assisted FbDraweeView fbDraweeView, @Assisted View view, @Assisted FileEditingListener fileEditingListener, @Assisted String str, @Assisted RotatingPhotoViewController rotatingPhotoViewController, @Assisted Optional<CreativeEditingLogger> optional, @Assisted CreativeEditingPhotoOverlayView creativeEditingPhotoOverlayView, Toaster toaster, MovableItemContainerProvider movableItemContainerProvider, Provider<SpringAlphaAnimator> provider, SwipeableParamsHelper swipeableParamsHelper, PhotoOverlayController photoOverlayController, ListeningExecutorService listeningExecutorService, CreativeEditingFileManager creativeEditingFileManager, Lazy<MediaRotationHelper> lazy, Lazy<TasksManager> lazy2, ImagePipeline imagePipeline, Context context) {
        this.f10184J = uri;
        this.f10204n = rotatingPhotoViewController;
        this.f10194d = rotatingFrameLayout;
        this.f10196f = context;
        this.f10195e = str;
        this.f10180F = editableOverlayContainerView;
        this.f10216z = fbDraweeView;
        this.f10198h = listeningExecutorService;
        this.f10199i = lazy2;
        this.f10200j = creativeEditingFileManager;
        this.f10202l = imagePipeline;
        this.f10201k = fileEditingListener;
        this.f10203m = lazy;
        this.f10205o = view;
        this.f10210t = toaster;
        this.f10175A = (ImageButton) this.f10205o.findViewById(2131559198);
        this.f10176B = (FbTextView) this.f10205o.findViewById(2131559199);
        this.f10177C = (FbTextView) this.f10205o.findViewById(2131559197);
        this.f10175A.setOnClickListener(this.f10193c);
        this.f10197g = photoOverlayController;
        this.f10206p = provider;
        this.f10207q = swipeableParamsHelper;
        this.f10215y = new CropOverlayView(this.f10196f);
        this.f10215y.setId(2131558575);
        this.f10215y.setOnCropChangeListener(m12064p());
        this.f10215y.setCropMode(CropMode.FREE_FORM);
        this.f10182H = creativeEditingPhotoOverlayView;
        this.f10187M = optional;
        this.f10188N = new LoggingParameters();
        this.f10208r = movableItemContainerProvider;
    }

    public final void mo561a(State state) {
        Preconditions.checkNotNull(state.f10290k);
        this.f10194d.m11442a(this.f10204n.f10313P, this.f10204n.f10314Q);
        this.f10211u = state;
        this.f10212v = state.f10290k;
        this.f10213w = true;
        this.f10178D = false;
        this.f10181G = false;
        this.f10186L = true;
        this.f10180F.setVisibility(4);
        this.f10194d.m11444b();
        this.f10194d.setVisibility(0);
        this.f10175A.setImageResource(2130843177);
        this.f10175A.setOnClickListener(this.f10193c);
        this.f10176B.setText(this.f10196f.getString(2131237789));
        this.f10176B.setOnClickListener(this.f10191a);
        this.f10176B.setContentDescription(this.f10196f.getString(2131237797));
        this.f10177C.setText(this.f10196f.getString(2131237791));
        this.f10177C.setOnClickListener(this.f10192b);
        this.f10177C.setContentDescription(this.f10196f.getString(2131237798));
    }

    public final void mo564b() {
        if (this.f10186L) {
            this.f10186L = false;
            this.f10215y.m11423a();
            this.f10205o.setVisibility(4);
            this.f10182H.setVisibility(4);
        }
    }

    public final String mo559a() {
        return this.f10196f.getResources().getString(2131237792);
    }

    public final void mo560a(Rect rect) {
        this.f10179E = new RectF(rect);
    }

    public final UriRequestType mo573k() {
        return UriRequestType.SHOW_ORIGINAL_URI;
    }

    public final boolean mo574l() {
        return this.f10181G;
    }

    public final void mo565c() {
    }

    @TargetApi(11)
    public final void mo570h() {
        this.f10175A.setVisibility(0);
        this.f10176B.setVisibility(0);
        this.f10177C.setVisibility(0);
        m12066u();
        m12067v();
        if (this.f10212v.n()) {
            boolean z = true;
            Preconditions.checkState(this.f10179E != null);
            if (this.f10215y == null) {
                z = false;
            }
            Preconditions.checkState(z);
            Preconditions.checkState(this.f10212v.n());
            if (!this.f10190P.isPresent()) {
                this.f10179E.round(this.f10209s);
                this.f10190P = Optional.of(this.f10208r.m11524a(this.f10209s));
            }
            this.f10215y.m11425a(this.f10212v.i(), (MovableItemContainer) this.f10190P.get());
        }
        View view = this.f10215y;
        SpringAlphaAnimator springAlphaAnimator = (SpringAlphaAnimator) this.f10206p.get();
        view.bringToFront();
        if (springAlphaAnimator != null) {
            springAlphaAnimator.a();
            view.setAlpha(0.0f);
            view.setVisibility(0);
            springAlphaAnimator.f = 25.0f;
            springAlphaAnimator.a(view, 1);
        } else {
            view.setVisibility(0);
        }
        this.f10182H.setAlpha(0.0f);
        this.f10182H.setVisibility(0);
        ((SpringAlphaAnimator) this.f10206p.get()).a(this.f10182H, 1);
        this.f10205o.setAlpha(0.0f);
        this.f10205o.setVisibility(0);
        ((SpringAlphaAnimator) this.f10206p.get()).a(this.f10205o, 1);
    }

    public final void mo571i() {
        this.f10215y.m11423a();
        this.f10182H.setVisibility(4);
        this.f10205o.setVisibility(4);
    }

    public final void mo562a(UsageParams usageParams) {
        usageParams.f10349d++;
    }

    public final void mo569g() {
        this.f10213w = true;
    }

    public final Object mo572j() {
        return EditFeature.CROP;
    }

    public final State mo575m() {
        int finalRotation = this.f10194d.getFinalRotation();
        boolean z = (finalRotation == 0 || finalRotation == 360) ? false : true;
        int a = ((MediaRotationHelper) this.f10203m.get()).a(this.f10184J);
        if (!z && !this.f10183I && a == 0) {
            return this.f10211u;
        }
        RectF rectF;
        if (this.f10214x != null) {
            rectF = new RectF(this.f10214x.left / this.f10179E.width(), this.f10214x.top / this.f10179E.height(), this.f10214x.right / this.f10179E.width(), this.f10214x.bottom / this.f10179E.height());
        } else {
            rectF = null;
        }
        if (z || a != 0) {
            int a2 = 4 - RotateRectfHelper.a(a);
            int i = (a + finalRotation) % 360;
            if (i != a) {
                ((MediaRotationHelper) this.f10203m.get()).a(this.f10184J, i);
                LoggingParameters loggingParameters = this.f10188N;
                i = loggingParameters.f9526m;
                EditGalleryFragmentController editGalleryFragmentController = this.f10204n;
                int i2 = (a + finalRotation) % 360;
                int a3 = editGalleryFragmentController.f10332m.mo220a(i2);
                editGalleryFragmentController.f10331l.aA.f9656e = i2;
                State state = editGalleryFragmentController.f10300C;
                if (!state.f10289j) {
                    state.f10286g = a;
                    state.f10289j = true;
                }
                editGalleryFragmentController.f10300C.f10288i = true;
                if (finalRotation == 90 || finalRotation == 270) {
                    i2 = editGalleryFragmentController.f10314Q;
                    editGalleryFragmentController.f10314Q = editGalleryFragmentController.f10313P;
                    editGalleryFragmentController.f10313P = i2;
                }
                EditGalleryFragmentController.m12184m(editGalleryFragmentController);
                loggingParameters.f9526m = a3 + i;
            }
            if (rectF == null) {
                Builder builder = new Builder(this.f10212v);
                builder.b = z;
                this.f10212v = builder.a();
                this.f10211u.f10290k = this.f10212v;
                if (z) {
                    m12068x(this);
                }
                return this.f10211u;
            }
            RectF a4 = RotateRectfHelper.a(rectF, a2);
            RectF c = this.f10212v.c();
            Builder builder2 = new Builder(this.f10212v);
            builder2.e = a4;
            builder2 = builder2;
            builder2.b = z;
            this.f10212v = builder2.a();
            this.f10211u.f10290k = this.f10212v;
            m12061a(a4, z, c);
            return this.f10211u;
        }
        a4 = this.f10212v.c();
        Builder builder3 = new Builder(this.f10212v);
        builder3.e = rectF;
        this.f10212v = builder3.a();
        this.f10211u.f10290k = this.f10212v;
        if (rectF != null) {
            m12061a(rectF, false, a4);
        }
        return this.f10211u;
    }

    public final boolean mo566d() {
        return false;
    }

    public final boolean mo567e() {
        return false;
    }

    public final void mo568f() {
    }

    public final void mo563a(boolean z) {
        float f = 0.0f;
        this.f10188N.f9523j = this.f10204n.f10314Q == 0 ? 0.0f : ((float) this.f10204n.f10313P) / ((float) this.f10204n.f10314Q);
        LoggingParameters loggingParameters = this.f10188N;
        if (this.f10214x == null) {
            f = this.f10188N.f9523j;
        } else if (((double) this.f10214x.height()) != 0.0d) {
            f = this.f10214x.width() / this.f10214x.height();
        }
        loggingParameters.f9524k = f;
        this.f10188N.f9522i = this.f10189O;
        this.f10188N.f9525l = z;
        if (this.f10187M.isPresent()) {
            ((CreativeEditingLogger) this.f10187M.get()).m11474a(this.f10188N);
        }
    }

    private C08564 m12064p() {
        return new C08564(this);
    }

    public static void m12065s(CropEditController cropEditController) {
        if (cropEditController.f10215y.f9469G != CropMode.SQUARE) {
            Object obj;
            if (cropEditController.f10214x == null || (cropEditController.f10214x.left == 0.0f && cropEditController.f10214x.top == 0.0f && cropEditController.f10214x.bottom == cropEditController.f10179E.height() && cropEditController.f10214x.right == cropEditController.f10179E.width())) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                cropEditController.f10177C.setTextColor(cropEditController.f10196f.getResources().getColor(2131361917));
                return;
            }
        }
        cropEditController.f10177C.setTextColor(cropEditController.f10196f.getResources().getColor(2131362927));
    }

    private boolean m12063b(RectF rectF, View view) {
        if (rectF == null || this.f10179E.width() == 0.0f || this.f10179E.height() == 0.0f) {
            return false;
        }
        rectF.left += (float) view.getPaddingLeft();
        rectF.top += (float) view.getPaddingTop();
        rectF.right += (float) view.getPaddingLeft();
        rectF.bottom += (float) view.getPaddingTop();
        return true;
    }

    private void m12066u() {
        if (this.f10179E != null && this.f10186L) {
            RectF a;
            RectF c = this.f10212v.c();
            if (c != null) {
                a = RotateRectfHelper.a(c, RotateRectfHelper.a(((MediaRotationHelper) this.f10203m.get()).a(this.f10184J)));
            } else {
                a = c;
            }
            c = new RectF(this.f10179E);
            RectF rectF = new RectF(this.f10179E);
            m12063b(rectF, this.f10216z);
            c.bottom += (float) (this.f10216z.getPaddingTop() + this.f10216z.getPaddingBottom());
            c.right += (float) (this.f10216z.getPaddingLeft() + this.f10216z.getPaddingRight());
            if (!(a == null || !this.f10213w || this.f10179E.width() == 0.0f || this.f10179E.height() == 0.0f)) {
                a.left *= this.f10179E.width();
                a.top *= this.f10179E.height();
                a.right *= this.f10179E.width();
                a.bottom *= this.f10179E.height();
            }
            this.f10178D = m12063b(a, this.f10216z);
            if (this.f10194d.findViewById(2131558575) == null) {
                this.f10194d.addView(this.f10215y);
            }
            if (rectF.height() > 0.0f && rectF.width() > 0.0f) {
                this.f10215y.m11424a(rectF, c, a);
            }
            m12065s(this);
        }
    }

    private void m12067v() {
        if (this.f10179E != null && this.f10186L) {
            if (this.f10212v.k()) {
                int finalRotation;
                LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.f10179E.width(), (int) this.f10179E.height());
                layoutParams.topMargin = ((int) this.f10179E.top) + this.f10216z.getPaddingTop();
                layoutParams.leftMargin = ((int) this.f10179E.left) + this.f10216z.getPaddingLeft();
                this.f10182H.setLayoutParams(layoutParams);
                PhotoOverlayController photoOverlayController = this.f10197g;
                CreativeEditingData creativeEditingData = this.f10212v;
                int width = (int) this.f10179E.width();
                int height = (int) this.f10179E.height();
                if (this.f10194d.f9505g) {
                    finalRotation = this.f10194d.getFinalRotation();
                } else {
                    finalRotation = ((MediaRotationHelper) this.f10203m.get()).a(this.f10184J);
                }
                photoOverlayController.m11529a(creativeEditingData, width, height, finalRotation, this.f10182H, false, OverlayType.STICKERS, OverlayType.TEXTS, OverlayType.DOODLE);
                this.f10182H.f9581a = this.f10197g;
                return;
            }
            this.f10197g.m11533d();
        }
    }

    private void m12061a(final RectF rectF, final boolean z, final RectF rectF2) {
        Preconditions.checkNotNull(rectF);
        if (this.f10183I || z) {
            this.f10201k.m12162a();
            ((TasksManager) this.f10199i.get()).a("crop_task", new Callable<ListenableFuture>(this) {
                final /* synthetic */ CropEditController f10174b;

                /* compiled from: links_add_click */
                class C08581 implements Runnable {
                    final /* synthetic */ C08596 f10172a;

                    C08581(C08596 c08596) {
                        this.f10172a = c08596;
                    }

                    public void run() {
                        boolean z = false;
                        if ("mounted".equals(Environment.getExternalStorageState())) {
                            File a;
                            ImageFormat a2 = ImageFormatChecker.a(this.f10172a.f10174b.f10184J.getPath());
                            if (a2 == ImageFormat.JPEG || a2 == ImageFormat.PNG) {
                                z = true;
                            }
                            Preconditions.checkArgument(z);
                            String path = this.f10172a.f10174b.f10212v.o() == null ? null : this.f10172a.f10174b.f10212v.o().getPath();
                            if (path == null) {
                                try {
                                    a = this.f10172a.f10174b.f10200j.a(this.f10172a.f10174b.f10195e, a2.name());
                                } catch (ImageResizingInputFileException e) {
                                    e.printStackTrace();
                                    if (this.f10172a.f10174b.f10185K != null) {
                                        CreativeEditingFileManager.a(this.f10172a.f10174b.f10185K);
                                        return;
                                    }
                                    return;
                                } catch (IOException e2) {
                                    if (this.f10172a.f10174b.f10185K != null) {
                                        CreativeEditingFileManager.a(this.f10172a.f10174b.f10185K);
                                        return;
                                    }
                                    return;
                                }
                            }
                            a = new File(path);
                            this.f10172a.f10174b.f10185K = Uri.fromFile(a);
                            if (a2 == ImageFormat.JPEG) {
                                NativeImageProcessor.a(this.f10172a.f10174b.f10184J.getPath(), 0, rectF, a.getPath());
                            } else if (a2 == ImageFormat.PNG) {
                                Pair a3 = BitmapUtil.a(new FileInputStream(this.f10172a.f10174b.f10184J.getPath()));
                                Options options = new Options();
                                options.inSampleSize = CropEditController.m12062b(((Integer) a3.first).intValue(), ((Integer) a3.second).intValue());
                                options.inJustDecodeBounds = false;
                                Rect rect = new Rect((int) ((((float) ((Integer) a3.first).intValue()) * this.f10172a.f10174b.f10214x.left) / this.f10172a.f10174b.f10179E.width()), (int) ((((float) ((Integer) a3.second).intValue()) * this.f10172a.f10174b.f10214x.top) / this.f10172a.f10174b.f10179E.height()), (int) ((((float) ((Integer) a3.first).intValue()) * this.f10172a.f10174b.f10214x.right) / this.f10172a.f10174b.f10179E.width()), (int) ((((float) ((Integer) a3.second).intValue()) * this.f10172a.f10174b.f10214x.bottom) / this.f10172a.f10174b.f10179E.height()));
                                BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(this.f10172a.f10174b.f10184J.getPath(), false);
                                Bitmap decodeRegion = newInstance.decodeRegion(rect, options);
                                OutputStream fileOutputStream = new FileOutputStream(a);
                                decodeRegion.compress(CompressFormat.PNG, 100, fileOutputStream);
                                fileOutputStream.close();
                                newInstance.recycle();
                                decodeRegion.recycle();
                            }
                            this.f10172a.f10174b.f10202l.a(this.f10172a.f10174b.f10185K);
                        }
                    }
                }

                public Object call() {
                    return this.f10174b.f10198h.a(new C08581(this));
                }
            }, new AbstractDisposableFutureCallback(this) {
                final /* synthetic */ CropEditController f10171d;

                protected final void m12041a(Object obj) {
                    CropEditController.m12068x(this.f10171d);
                    Builder builder = new Builder(this.f10171d.f10212v);
                    builder.c = this.f10171d.f10185K;
                    builder = builder;
                    builder.e = rectF;
                    builder = builder;
                    builder.b = z;
                    CreativeEditingData a = builder.a();
                    this.f10171d.f10194d.m11444b();
                    this.f10171d.f10201k.m12163a(a);
                }

                protected final void m12042a(Throwable th) {
                    this.f10171d.f10210t.b(new ToastBuilder(2131237803));
                    Builder builder = new Builder(this.f10171d.f10212v);
                    builder.e = rectF2;
                    builder = builder;
                    builder.b = z;
                    CreativeEditingData a = builder.a();
                    this.f10171d.f10194d.m11444b();
                    this.f10171d.f10201k.m12163a(a);
                }
            });
        }
    }

    public static int m12062b(int i, int i2) {
        int i3 = 1;
        while (true) {
            if (i / i3 <= 1024 && i2 / i3 <= 1024) {
                return i3;
            }
            i3 *= 2;
        }
    }

    public static void m12068x(CropEditController cropEditController) {
        if (!cropEditController.f10212v.i().isEmpty()) {
            Builder builder = new Builder(cropEditController.f10212v);
            cropEditController.f10194d.getFinalRotation();
            if (cropEditController.f10214x != null) {
                cropEditController.f10214x.width();
            }
            if (cropEditController.f10214x != null) {
                cropEditController.f10214x.height();
            }
            builder.j = SwipeableParamsHelper.m11714b(cropEditController.f10211u.f10295p, cropEditController.f10212v.a());
            cropEditController.f10212v = builder.a();
        }
    }
}
