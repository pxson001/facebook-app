package android.support.v7.internal.view;

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

/* compiled from: use_zip_code */
public class WindowCallbackWrapper implements Callback {
    final Callback f573b;

    public WindowCallbackWrapper(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f573b = callback;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f573b.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f573b.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f573b.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f573b.dispatchTrackballEvent(motionEvent);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f573b.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f573b.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public View onCreatePanelView(int i) {
        return this.f573b.onCreatePanelView(i);
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.f573b.onCreatePanelMenu(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.f573b.onPreparePanel(i, view, menu);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return this.f573b.onMenuOpened(i, menu);
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.f573b.onMenuItemSelected(i, menuItem);
    }

    public void onWindowAttributesChanged(LayoutParams layoutParams) {
        this.f573b.onWindowAttributesChanged(layoutParams);
    }

    public void onContentChanged() {
        this.f573b.onContentChanged();
    }

    public void onWindowFocusChanged(boolean z) {
        this.f573b.onWindowFocusChanged(z);
    }

    public void onAttachedToWindow() {
        this.f573b.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        this.f573b.onDetachedFromWindow();
    }

    public void onPanelClosed(int i, Menu menu) {
        this.f573b.onPanelClosed(i, menu);
    }

    public boolean onSearchRequested() {
        return this.f573b.onSearchRequested();
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f573b.onSearchRequested(searchEvent);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f573b.onWindowStartingActionMode(callback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        return this.f573b.onWindowStartingActionMode(callback, i);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.f573b.onActionModeStarted(actionMode);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.f573b.onActionModeFinished(actionMode);
    }
}
