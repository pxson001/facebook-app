package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;

/* compiled from: user_identifier */
public class PopupWindowCompat {
    public static final PopupWindowImpl f506a;

    /* compiled from: user_identifier */
    public interface PopupWindowImpl {
        void mo192a(PopupWindow popupWindow, View view, int i, int i2, int i3);
    }

    /* compiled from: user_identifier */
    class BasePopupWindowImpl implements PopupWindowImpl {
        BasePopupWindowImpl() {
        }

        public void mo192a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2);
        }
    }

    /* compiled from: user_identifier */
    class KitKatPopupWindowImpl extends BasePopupWindowImpl {
        public final void mo192a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2, i3);
        }

        KitKatPopupWindowImpl() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f506a = new KitKatPopupWindowImpl();
        } else {
            f506a = new BasePopupWindowImpl();
        }
    }

    private PopupWindowCompat() {
    }
}
