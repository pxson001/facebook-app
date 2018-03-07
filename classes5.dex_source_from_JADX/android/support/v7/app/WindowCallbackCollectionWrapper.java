package android.support.v7.app;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.HashSet;
import java.util.Set;

/* compiled from: upsell_decline_button_label */
public class WindowCallbackCollectionWrapper implements Callback {
    public final Set<Callback> f649a = new HashSet();
    public final WindowLike f650b;
    public final Callback f651c;

    public WindowCallbackCollectionWrapper(WindowLike windowLike, Callback callback) {
        this.f650b = windowLike;
        this.f651c = callback;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        for (Callback dispatchKeyEvent : this.f649a) {
            if (dispatchKeyEvent.dispatchKeyEvent(keyEvent)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        for (Callback dispatchKeyShortcutEvent : this.f649a) {
            if (dispatchKeyShortcutEvent.dispatchKeyShortcutEvent(keyEvent)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        for (Callback dispatchTouchEvent : this.f649a) {
            if (dispatchTouchEvent.dispatchTouchEvent(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        for (Callback dispatchTrackballEvent : this.f649a) {
            if (dispatchTrackballEvent.dispatchTrackballEvent(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        for (Callback dispatchGenericMotionEvent : this.f649a) {
            if (dispatchGenericMotionEvent.dispatchGenericMotionEvent(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        for (Callback dispatchPopulateAccessibilityEvent : this.f649a) {
            if (dispatchPopulateAccessibilityEvent.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    public View onCreatePanelView(int i) {
        for (Callback onCreatePanelView : this.f649a) {
            View onCreatePanelView2 = onCreatePanelView.onCreatePanelView(i);
            if (onCreatePanelView2 != null) {
                return onCreatePanelView2;
            }
        }
        return null;
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        for (Callback onCreatePanelMenu : this.f649a) {
            if (onCreatePanelMenu.onCreatePanelMenu(i, menu)) {
                return true;
            }
        }
        return false;
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        for (Callback onPreparePanel : this.f649a) {
            if (onPreparePanel.onPreparePanel(i, view, menu)) {
                return true;
            }
        }
        return false;
    }

    public boolean onMenuOpened(int i, Menu menu) {
        for (Callback onMenuOpened : this.f649a) {
            if (onMenuOpened.onMenuOpened(i, menu)) {
                return true;
            }
        }
        return false;
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        for (Callback onMenuItemSelected : this.f649a) {
            if (onMenuItemSelected.onMenuItemSelected(i, menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void onWindowAttributesChanged(LayoutParams layoutParams) {
        for (Callback onWindowAttributesChanged : this.f649a) {
            onWindowAttributesChanged.onWindowAttributesChanged(layoutParams);
        }
    }

    public void onContentChanged() {
        for (Callback onContentChanged : this.f649a) {
            onContentChanged.onContentChanged();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        for (Callback onWindowFocusChanged : this.f649a) {
            onWindowFocusChanged.onWindowFocusChanged(z);
        }
    }

    public void onAttachedToWindow() {
        for (Callback onAttachedToWindow : this.f649a) {
            onAttachedToWindow.onAttachedToWindow();
        }
    }

    public void onDetachedFromWindow() {
        for (Callback onDetachedFromWindow : this.f649a) {
            onDetachedFromWindow.onDetachedFromWindow();
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        for (Callback onPanelClosed : this.f649a) {
            onPanelClosed.onPanelClosed(i, menu);
        }
    }

    public boolean onSearchRequested() {
        for (Callback onSearchRequested : this.f649a) {
            if (onSearchRequested.onSearchRequested()) {
                return true;
            }
        }
        return false;
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        for (Callback onSearchRequested : this.f649a) {
            if (onSearchRequested.onSearchRequested(searchEvent)) {
                return true;
            }
        }
        return false;
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        for (Callback onWindowStartingActionMode : this.f649a) {
            ActionMode onWindowStartingActionMode2 = onWindowStartingActionMode.onWindowStartingActionMode(callback);
            if (onWindowStartingActionMode2 != null) {
                return onWindowStartingActionMode2;
            }
        }
        return null;
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        for (Callback onWindowStartingActionMode : this.f649a) {
            ActionMode onWindowStartingActionMode2 = onWindowStartingActionMode.onWindowStartingActionMode(callback, i);
            if (onWindowStartingActionMode2 != null) {
                return onWindowStartingActionMode2;
            }
        }
        return null;
    }

    public void onActionModeStarted(ActionMode actionMode) {
        for (Callback onActionModeStarted : this.f649a) {
            onActionModeStarted.onActionModeStarted(actionMode);
        }
    }

    public void onActionModeFinished(ActionMode actionMode) {
        for (Callback onActionModeFinished : this.f649a) {
            onActionModeFinished.onActionModeFinished(actionMode);
        }
    }
}
