package android.support.v4.app;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

/* compiled from: production_prompts_use_aggressive_photo_reminder */
class NoSaveStateFrameLayout extends FrameLayout {
    static ViewGroup m13818a(View view) {
        if (view instanceof NoSaveStateView) {
            NoSaveStateView noSaveStateView = (NoSaveStateView) view;
            noSaveStateView.setSaveFromParentEnabledCompat(false);
            return noSaveStateView.asViewGroup();
        }
        ViewGroup noSaveStateFrameLayout = new NoSaveStateFrameLayout(view.getContext());
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            noSaveStateFrameLayout.setLayoutParams(layoutParams);
        }
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        noSaveStateFrameLayout.addView(view);
        return noSaveStateFrameLayout;
    }

    private NoSaveStateFrameLayout(Context context) {
        super(context);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }
}
