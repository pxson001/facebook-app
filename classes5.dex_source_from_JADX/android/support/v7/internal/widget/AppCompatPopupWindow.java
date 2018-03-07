package android.support.v7.internal.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import com.facebook.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* compiled from: unit_score */
public class AppCompatPopupWindow extends PopupWindow {
    private final boolean f1099a;

    /* compiled from: unit_score */
    final class C00541 implements OnScrollChangedListener {
        final /* synthetic */ Field f1096a;
        final /* synthetic */ PopupWindow f1097b;
        final /* synthetic */ OnScrollChangedListener f1098c;

        C00541(Field field, PopupWindow popupWindow, OnScrollChangedListener onScrollChangedListener) {
            this.f1096a = field;
            this.f1097b = popupWindow;
            this.f1098c = onScrollChangedListener;
        }

        public final void onScrollChanged() {
            try {
                WeakReference weakReference = (WeakReference) this.f1096a.get(this.f1097b);
                if (weakReference != null && weakReference.get() != null) {
                    this.f1098c.onScrollChanged();
                }
            } catch (IllegalAccessException e) {
            }
        }
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TintTypedArray a = TintTypedArray.m1693a(context, attributeSet, R.styleable.PopupWindow, i, 0);
        this.f1099a = a.m1696a(1, false);
        setBackgroundDrawable(a.m1695a(0));
        a.m1698b();
        if (VERSION.SDK_INT < 14) {
            m1591a(this);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (VERSION.SDK_INT < 21 && this.f1099a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @TargetApi(19)
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (VERSION.SDK_INT < 21 && this.f1099a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        int i5;
        if (VERSION.SDK_INT >= 21 || !this.f1099a) {
            i5 = i2;
        } else {
            i5 = i2 - view.getHeight();
        }
        super.update(view, i, i5, i3, i4);
    }

    private static void m1591a(PopupWindow popupWindow) {
        try {
            Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
            declaredField.setAccessible(true);
            Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField2.setAccessible(true);
            declaredField2.set(popupWindow, new C00541(declaredField, popupWindow, (OnScrollChangedListener) declaredField2.get(popupWindow)));
        } catch (Throwable e) {
            Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", e);
        }
    }
}
