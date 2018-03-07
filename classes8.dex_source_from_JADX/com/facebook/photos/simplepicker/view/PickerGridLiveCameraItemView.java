package com.facebook.photos.simplepicker.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.optic.CameraPreviewView;
import com.facebook.optic.CameraPreviewView.CameraInitialisedCallback;
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

/* compiled from: session_aggregate_view_time */
public class PickerGridLiveCameraItemView extends PickerGridPhotoItemView {
    @Inject
    public CreativeEditingSwipeableControllerProvider f3283a;
    @Inject
    public SwipeableDraweeControllerGeneratorImpl f3284h;
    @Inject
    public SwipeableParamsHelper f3285i;
    @Inject
    public SimplePickerFrameNuxControllerProvider f3286j;
    @Nullable
    private FramePackModel f3287k;
    @Nullable
    public CreativeEditingSwipeableController f3288l;
    @Nullable
    public C03828 f3289m;
    @Nullable
    public CameraPreviewView f3290n = ((CameraPreviewView) FindViewUtil.b(this, 2131560152));
    public boolean f3291o;

    /* compiled from: session_aggregate_view_time */
    public class C04161 implements OnAttachStateChangeListener {
        final /* synthetic */ PickerGridLiveCameraItemView f3279a;

        public C04161(PickerGridLiveCameraItemView pickerGridLiveCameraItemView) {
            this.f3279a = pickerGridLiveCameraItemView;
        }

        public void onViewAttachedToWindow(View view) {
            if (this.f3279a.f3288l != null) {
                this.f3279a.f3288l.b(true);
            }
        }

        public void onViewDetachedFromWindow(View view) {
            if (this.f3279a.f3288l != null) {
                this.f3279a.f3288l.b(false);
            }
        }
    }

    /* compiled from: session_aggregate_view_time */
    public class C04172 implements OnClickListener {
        final /* synthetic */ PickerGridLiveCameraItemView f3280a;

        public C04172(PickerGridLiveCameraItemView pickerGridLiveCameraItemView) {
            this.f3280a = pickerGridLiveCameraItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1249327965);
            PickerGridLiveCameraItemView pickerGridLiveCameraItemView = this.f3280a;
            if (pickerGridLiveCameraItemView.f3290n != null) {
                ((ViewGroup) pickerGridLiveCameraItemView.f3290n.getParent()).removeView(pickerGridLiveCameraItemView.f3290n);
            }
            pickerGridLiveCameraItemView.f3291o = true;
            if (this.f3280a.f3289m != null) {
                this.f3280a.f3289m.m2978a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -172834091, a);
        }
    }

    public static void m3235a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PickerGridLiveCameraItemView pickerGridLiveCameraItemView = (PickerGridLiveCameraItemView) obj;
        CreativeEditingSwipeableControllerProvider creativeEditingSwipeableControllerProvider = (CreativeEditingSwipeableControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CreativeEditingSwipeableControllerProvider.class);
        SwipeableDraweeControllerGeneratorImpl b = SwipeableDraweeControllerGeneratorImpl.b(fbInjector);
        SwipeableParamsHelper b2 = SwipeableParamsHelper.b(fbInjector);
        SimplePickerFrameNuxControllerProvider simplePickerFrameNuxControllerProvider = (SimplePickerFrameNuxControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(SimplePickerFrameNuxControllerProvider.class);
        pickerGridLiveCameraItemView.f3283a = creativeEditingSwipeableControllerProvider;
        pickerGridLiveCameraItemView.f3284h = b;
        pickerGridLiveCameraItemView.f3285i = b2;
        pickerGridLiveCameraItemView.f3286j = simplePickerFrameNuxControllerProvider;
    }

    public PickerGridLiveCameraItemView(Context context) {
        super(context);
        Class cls = PickerGridLiveCameraItemView.class;
        m3235a(this, getContext());
    }

    public PickerGridItemType getItemType() {
        return PickerGridItemType.LIVE_CAMERA;
    }

    public int getLayoutResourceId() {
        return 2130906232;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.f3291o) {
            CreativeEditingSwipeableLayout creativeEditingSwipeableLayout = (CreativeEditingSwipeableLayout) FindViewUtil.b(this, 2131561936);
            creativeEditingSwipeableLayout.addOnAttachStateChangeListener(new C04161(this));
            if (this.f3288l == null && getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
                this.f3288l = this.f3283a.a(new BaseCreativeEditingUsageLoggerEventListener(), this.f3284h, null, "-1");
                this.f3288l.a(creativeEditingSwipeableLayout, getMeasuredWidth(), getMeasuredHeight(), true);
                this.f3288l.b();
                this.f3288l.a(new C04172(this));
            }
            final ImageView imageView = (ImageView) FindViewUtil.b(this, 2131558448);
            this.f3290n.setCameraInitialisedCallback(new CameraInitialisedCallback(this) {
                final /* synthetic */ PickerGridLiveCameraItemView f3282b;

                public final void m3233a() {
                    imageView.setVisibility(8);
                }

                public final void m3234a(Exception exception) {
                    imageView.setVisibility(0);
                }
            });
        }
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 179880146);
        super.onFinishInflate();
        m3236m();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1485617928, a);
    }

    public void setFramePack(@Nullable FramePackModel framePackModel) {
        this.f3287k = framePackModel;
        if (this.f3288l != null && this.f3287k != null) {
            this.f3288l.a(ImmutableList.of(this.f3286j.a(this.f3285i.a(this.f3287k, 1, 1))));
            m3236m();
        }
    }

    private void m3236m() {
        if (this.f3288l != null && this.f3287k != null) {
            this.f3288l.a(FrameShuffler.a(this.f3287k.c()), null, null);
        }
    }
}
