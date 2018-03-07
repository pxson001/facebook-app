package android.support.design.widget;

import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.view.View;

/* compiled from: publish_photos_sticky */
class CoordinatorLayoutInsetsHelperLollipop implements CoordinatorLayoutInsetsHelper {
    CoordinatorLayoutInsetsHelperLollipop() {
    }

    public final void mo873a(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        if (ViewCompat.A(view)) {
            ViewCompat.a(view, onApplyWindowInsetsListener);
            view.setSystemUiVisibility(1280);
        }
    }
}
