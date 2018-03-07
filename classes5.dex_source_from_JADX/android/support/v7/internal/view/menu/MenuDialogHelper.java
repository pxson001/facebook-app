package android.support.v7.internal.view.menu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;

/* compiled from: unsure */
public class MenuDialogHelper implements OnClickListener, OnDismissListener, OnKeyListener, Callback {
    public ListMenuPresenter f870a;
    public MenuBuilder f871b;
    public AlertDialog f872c;
    private Callback f873d;

    public MenuDialogHelper(MenuBuilder menuBuilder) {
        this.f871b = menuBuilder;
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            Window window;
            View decorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                window = this.f872c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                window = this.f872c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.f871b.m1403a(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.f871b.performShortcut(i, keyEvent, 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f870a.mo307a(this.f871b, true);
    }

    public final void mo228a(MenuBuilder menuBuilder, boolean z) {
        if ((z || menuBuilder == this.f871b) && this.f872c != null) {
            this.f872c.dismiss();
        }
        if (this.f873d != null) {
            this.f873d.mo228a(menuBuilder, z);
        }
    }

    public final boolean a_(MenuBuilder menuBuilder) {
        if (this.f873d != null) {
            return this.f873d.a_(menuBuilder);
        }
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f871b.m1406a((MenuItemImpl) this.f870a.m1378a().getItem(i), 0);
    }
}
