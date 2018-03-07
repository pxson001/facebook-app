package com.facebook.messaging.media.mediapicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.media.mediapicker.MediaPickerGridAdapter.PhotoItemListener;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.PhotoToggleButton;
import com.facebook.widget.PhotoToggleButton.OnCheckedChangeListener;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: mBarCode */
public class PhotoItemController extends ViewHolder {
    public static final CallerContext f11722l = CallerContext.a(PhotoItemController.class);
    public final FbDraweeControllerBuilder f11723m;
    public final Resources f11724n;
    public final TimeFormatUtil f11725o;
    public final ResizeOptions f11726p;
    public final FbDraweeView f11727q;
    public final PhotoToggleButton f11728r;
    public final View f11729s;
    public final DraweeControllerListener f11730t = new DraweeControllerListener(this);
    private final PhotoClickListener f11731u = new PhotoClickListener(this);
    private final SelectedChangedListener f11732v = new SelectedChangedListener(this);
    @Nullable
    public PhotoItemListener f11733w;
    @Nullable
    public MediaResource f11734x;

    /* compiled from: mBarCode */
    class DraweeControllerListener extends BaseControllerListener {
        final /* synthetic */ PhotoItemController f11719a;

        public DraweeControllerListener(PhotoItemController photoItemController) {
            this.f11719a = photoItemController;
        }

        public final void m12375a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }

        public final void m12376b(String str, Throwable th) {
            this.f11719a.f11727q.setVisibility(8);
            this.f11719a.f11729s.setVisibility(0);
        }
    }

    /* compiled from: mBarCode */
    class PhotoClickListener implements OnClickListener {
        final /* synthetic */ PhotoItemController f11720a;

        public PhotoClickListener(PhotoItemController photoItemController) {
            this.f11720a = photoItemController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -70819256);
            if (this.f11720a.f11733w != null) {
                Preconditions.checkNotNull(this.f11720a.f11734x);
                PhotoItemListener photoItemListener = this.f11720a.f11733w;
                MediaResource mediaResource = this.f11720a.f11734x;
                if (photoItemListener.f11701a.f11711i != null) {
                    photoItemListener.f11701a.f11711i.m12340a(mediaResource);
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, 655448291, a);
        }
    }

    /* compiled from: mBarCode */
    class SelectedChangedListener implements OnCheckedChangeListener {
        final /* synthetic */ PhotoItemController f11721a;

        public SelectedChangedListener(PhotoItemController photoItemController) {
            this.f11721a = photoItemController;
        }

        public final void m12377a(boolean z) {
            if (this.f11721a.f11733w != null) {
                Preconditions.checkNotNull(this.f11721a.f11734x);
                PhotoItemListener photoItemListener = this.f11721a.f11733w;
                MediaResource mediaResource = this.f11721a.f11734x;
                if (!z) {
                    photoItemListener.f11701a.f11712j.m12384b(mediaResource);
                } else if (!photoItemListener.f11701a.f11712j.m12382a(mediaResource)) {
                    SelectionState selectionState = photoItemListener.f11701a.f11712j;
                    Context context = photoItemListener.f11701a.f11708f;
                    Toaster.a(context, context.getString(2131240884, new Object[]{Integer.valueOf(selectionState.f11735a)}));
                    int indexOf = MediaPickerGridAdapter.m12370d(photoItemListener.f11701a).indexOf(mediaResource);
                    if (indexOf >= 0) {
                        photoItemListener.f11701a.j_(indexOf);
                    }
                }
            }
        }
    }

    @Inject
    public PhotoItemController(FbDraweeControllerBuilder fbDraweeControllerBuilder, Resources resources, TimeFormatUtil timeFormatUtil, @Assisted View view) {
        super(view);
        this.f11723m = fbDraweeControllerBuilder;
        this.f11724n = resources;
        this.f11725o = timeFormatUtil;
        int dimensionPixelSize = resources.getDimensionPixelSize(2131431776);
        this.f11726p = new ResizeOptions(dimensionPixelSize, dimensionPixelSize);
        this.f11727q = (FbDraweeView) view.findViewById(2131561583);
        this.f11728r = (PhotoToggleButton) view.findViewById(2131565904);
        this.f11729s = view.findViewById(2131563975);
        this.f11727q.setOnClickListener(this.f11731u);
        this.f11728r.e = this.f11732v;
    }
}
