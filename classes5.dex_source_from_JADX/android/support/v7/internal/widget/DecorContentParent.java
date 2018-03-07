package android.support.v7.internal.widget;

import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.view.Menu;
import android.view.Window;

/* compiled from: unit_title */
public interface DecorContentParent {
    void mo347a(int i);

    void mo348a(Menu menu, Callback callback);

    boolean mo349b();

    boolean mo350c();

    boolean mo351d();

    boolean mo352e();

    boolean mo353f();

    void mo354g();

    void mo355h();

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);
}
