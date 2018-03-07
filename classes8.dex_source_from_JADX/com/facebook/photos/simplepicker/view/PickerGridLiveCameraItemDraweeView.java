package com.facebook.photos.simplepicker.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.optic.CameraPreviewView;
import com.facebook.photos.creativeediting.analytics.BaseCreativeEditingUsageLoggerEventListener;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FramePackModel;
import com.facebook.photos.creativeediting.swipeable.common.FrameShuffler;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableParamsHelper;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableController;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableControllerProvider;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableLayout;
import com.facebook.photos.creativeediting.swipeable.composer.SwipeableDraweeControllerGeneratorImpl;
import com.facebook.photos.creativeediting.swipeable.composer.nux.SimplePickerFrameNuxControllerProvider;
import com.facebook.photos.simplepicker.SimplePickerFragment.C03828;
import com.facebook.photos.simplepicker.controller.PickerGridItemType;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: set up audio annotation auto play failed */
public class PickerGridLiveCameraItemDraweeView extends PickerGridPhotoItemDraweeView {
    @Inject
    public CreativeEditingSwipeableControllerProvider f3270a;
    @Inject
    public SwipeableDraweeControllerGeneratorImpl f3271c;
    @Inject
    public SwipeableParamsHelper f3272d;
    @Inject
    public SimplePickerFrameNuxControllerProvider f3273e;
    @Nullable
    private FramePackModel f3274f;
    @Nullable
    public CreativeEditingSwipeableController f3275g;
    @Nullable
    public C03828 f3276h;
    @Nullable
    public CameraPreviewView f3277i = ((CameraPreviewView) FindViewUtil.b(this, 2131560152));
    public boolean f3278j;

    /* compiled from: set up audio annotation auto play failed */
    public class C04141 implements OnAttachStateChangeListener {
        final /* synthetic */ PickerGridLiveCameraItemDraweeView f3268a;

        public C04141(PickerGridLiveCameraItemDraweeView pickerGridLiveCameraItemDraweeView) {
            this.f3268a = pickerGridLiveCameraItemDraweeView;
        }

        public void onViewAttachedToWindow(View view) {
            if (this.f3268a.f3275g != null) {
                this.f3268a.f3275g.b(true);
            }
        }

        public void onViewDetachedFromWindow(View view) {
            if (this.f3268a.f3275g != null) {
                this.f3268a.f3275g.b(false);
            }
        }
    }

    /* compiled from: set up audio annotation auto play failed */
    public class C04152 implements OnClickListener {
        final /* synthetic */ PickerGridLiveCameraItemDraweeView f3269a;

        public C04152(PickerGridLiveCameraItemDraweeView pickerGridLiveCameraItemDraweeView) {
            this.f3269a = pickerGridLiveCameraItemDraweeView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1206665701);
            PickerGridLiveCameraItemDraweeView pickerGridLiveCameraItemDraweeView = this.f3269a;
            if (pickerGridLiveCameraItemDraweeView.f3277i != null) {
                ((ViewGroup) pickerGridLiveCameraItemDraweeView.f3277i.getParent()).removeView(pickerGridLiveCameraItemDraweeView.f3277i);
            }
            pickerGridLiveCameraItemDraweeView.f3278j = true;
            if (this.f3269a.f3276h != null) {
                this.f3269a.f3276h.m2978a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1411233349, a);
        }
    }

    public static void m3231a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PickerGridLiveCameraItemDraweeView pickerGridLiveCameraItemDraweeView = (PickerGridLiveCameraItemDraweeView) obj;
        CreativeEditingSwipeableControllerProvider creativeEditingSwipeableControllerProvider = (CreativeEditingSwipeableControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CreativeEditingSwipeableControllerProvider.class);
        SwipeableDraweeControllerGeneratorImpl b = SwipeableDraweeControllerGeneratorImpl.b(fbInjector);
        SwipeableParamsHelper b2 = SwipeableParamsHelper.b(fbInjector);
        SimplePickerFrameNuxControllerProvider simplePickerFrameNuxControllerProvider = (SimplePickerFrameNuxControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(SimplePickerFrameNuxControllerProvider.class);
        pickerGridLiveCameraItemDraweeView.f3270a = creativeEditingSwipeableControllerProvider;
        pickerGridLiveCameraItemDraweeView.f3271c = b;
        pickerGridLiveCameraItemDraweeView.f3272d = b2;
        pickerGridLiveCameraItemDraweeView.f3273e = simplePickerFrameNuxControllerProvider;
    }

    public PickerGridLiveCameraItemDraweeView(Context context) {
        super(context);
        Class cls = PickerGridLiveCameraItemDraweeView.class;
        m3231a(this, getContext());
    }

    public PickerGridItemType getItemType() {
        return PickerGridItemType.LIVE_CAMERA;
    }

    public int getLayoutResourceId() {
        return 2130906231;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.f3278j) {
            CreativeEditingSwipeableLayout creativeEditingSwipeableLayout = (CreativeEditingSwipeableLayout) FindViewUtil.b(this, 2131561936);
            creativeEditingSwipeableLayout.addOnAttachStateChangeListener(new C04141(this));
            if (this.f3275g == null && getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
                this.f3275g = this.f3270a.a(new BaseCreativeEditingUsageLoggerEventListener(), this.f3271c, null, "-1");
                this.f3275g.a(creativeEditingSwipeableLayout, getMeasuredWidth(), getMeasuredHeight(), true);
                this.f3275g.b();
                this.f3275g.a(new C04152(this));
            }
        }
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2004343504);
        super.onFinishInflate();
        m3232j();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1337620092, a);
    }

    public void setFramePack(@Nullable FramePackModel framePackModel) {
        this.f3274f = framePackModel;
        if (this.f3275g != null && this.f3274f != null) {
            this.f3275g.a(ImmutableList.of(this.f3273e.a(this.f3272d.a(this.f3274f, 1, 1))));
            m3232j();
        }
    }

    private void m3232j() {
        if (this.f3275g != null && this.f3274f != null) {
            this.f3275g.a(FrameShuffler.a(this.f3274f.c()), null, null);
        }
    }
}
