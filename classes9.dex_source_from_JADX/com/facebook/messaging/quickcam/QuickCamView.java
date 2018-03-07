package com.facebook.messaging.quickcam;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ProgressBar;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.permissions.PermissionRequestIconView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.ViewStubHolder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: is_transient_api_error */
public abstract class QuickCamView extends CustomFrameLayout {
    @Nullable
    private QuickCamController f12444a;

    @Nullable
    public abstract View getCameraFlipButton();

    public abstract ViewStub getCameraPreviewViewStub();

    @Nullable
    public abstract View getCancelButton();

    public abstract View getCaptureButton();

    public abstract FbTextView getErrorMessage();

    public abstract ProgressBar getProgressBar();

    public abstract ViewStubHolder<PermissionRequestIconView> getRequestPermissionViewStub();

    public abstract FbTextView getTimerText();

    public abstract View getVideoCancelOverlay();

    public QuickCamView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setListener(QuickCamController quickCamController) {
        this.f12444a = quickCamController;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1637398386);
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f12444a != null) {
            this.f12444a.m16524a();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1348225660, a);
    }

    protected void onMeasure(int i, int i2) {
        if (this.f12444a != null) {
            QuickCamController quickCamController = this.f12444a;
            boolean z = MeasureSpec.getMode(i) == 1073741824 && MeasureSpec.getMode(i2) == 1073741824;
            Preconditions.checkState(z);
            LayoutParams layoutParams = quickCamController.f16497z.getLayoutParams();
            LayoutParams layoutParams2 = quickCamController.f16486o.m6472d().getLayoutParams();
            if (!(layoutParams.width == layoutParams2.width && layoutParams.height == layoutParams2.height)) {
                layoutParams.width = layoutParams2.width;
                layoutParams.height = layoutParams2.height;
                quickCamController.f16497z.setLayoutParams(layoutParams);
            }
        }
        super.onMeasure(i, i2);
    }
}
