package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.WindowCallbackWrapper;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import com.facebook.R;

/* compiled from: use_neighborhood_data_source */
public abstract class AppCompatDelegateImplBase extends AppCompatDelegate {
    final Context f575a;
    final WindowLike f576b;
    public final Callback f577c;
    final Callback f578d;
    final AppCompatCallback f579e;
    boolean f580f;
    boolean f581g;
    boolean f582h;
    boolean f583i;
    boolean f584j;
    public ActionBar f585k;
    private MenuInflater f586l;
    private CharSequence f587m;
    public boolean f588n;

    /* compiled from: use_neighborhood_data_source */
    public class AppCompatWindowCallback extends WindowCallbackWrapper {
        public final /* synthetic */ AppCompatDelegateImplBase f574a;

        AppCompatWindowCallback(AppCompatDelegateImplBase appCompatDelegateImplBase, Callback callback) {
            this.f574a = appCompatDelegateImplBase;
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (this.f574a.mo215a(keyEvent)) {
                return true;
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            if (i == 0 && !(menu instanceof MenuBuilder)) {
                return false;
            }
            if (i == 0) {
                Object obj = 1;
                if ((VERSION.SDK_INT >= 16 || !(this.f574a.f577c instanceof Activity)) && !(this.f574a.f577c instanceof Dialog)) {
                    obj = null;
                }
                if (obj != null) {
                    if (this.f574a.f577c instanceof Activity) {
                        return ((Activity) this.f574a.f577c).onPrepareOptionsMenu(menu);
                    }
                    if (this.f574a.f577c instanceof Dialog) {
                        return ((Dialog) this.f574a.f577c).onPrepareOptionsMenu(menu);
                    }
                    return false;
                }
            }
            return super.onPreparePanel(i, view, menu);
        }

        public boolean onMenuOpened(int i, Menu menu) {
            if (this.f574a.mo222d(i)) {
                return true;
            }
            return super.onMenuOpened(i, menu);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            if (this.f574a.mo213a(keyEvent.getKeyCode(), keyEvent)) {
                return true;
            }
            return super.dispatchKeyShortcutEvent(keyEvent);
        }

        public void onContentChanged() {
        }

        public void onPanelClosed(int i, Menu menu) {
            if (!this.f574a.mo220c(i)) {
                super.onPanelClosed(i, menu);
            }
        }
    }

    abstract ActionMode mo207a(ActionMode.Callback callback);

    abstract void mo212a(CharSequence charSequence);

    abstract boolean mo213a(int i, KeyEvent keyEvent);

    abstract boolean mo215a(KeyEvent keyEvent);

    abstract boolean mo220c(int i);

    abstract boolean mo222d(int i);

    abstract ActionBar mo223f();

    AppCompatDelegateImplBase(Context context, Window window, AppCompatCallback appCompatCallback) {
        this(context, new WindowLikeImpl(window), appCompatCallback);
    }

    AppCompatDelegateImplBase(Context context, WindowLike windowLike, AppCompatCallback appCompatCallback) {
        this.f575a = context;
        this.f576b = windowLike;
        this.f579e = appCompatCallback;
        Callback a = this.f576b.mo235a();
        if (a instanceof AppCompatWindowCallback) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        WindowCallbackCollectionWrapper windowCallbackCollectionWrapper;
        if (a instanceof WindowCallbackCollectionWrapper) {
            windowCallbackCollectionWrapper = (WindowCallbackCollectionWrapper) a;
            this.f577c = windowCallbackCollectionWrapper.f651c;
        } else {
            WindowLike windowLike2 = this.f576b;
            Callback windowCallbackCollectionWrapper2 = new WindowCallbackCollectionWrapper(windowLike2, windowLike2.mo235a());
            windowLike2.mo238a(windowCallbackCollectionWrapper2);
            Callback callback = windowCallbackCollectionWrapper2;
            this.f577c = a;
            a = callback;
        }
        this.f578d = new AppCompatWindowCallback(this, windowCallbackCollectionWrapper.f651c);
        windowCallbackCollectionWrapper.f649a.add(this.f578d);
    }

    public final ActionBar mo203a() {
        if (this.f580f && this.f585k == null) {
            this.f585k = mo223f();
        }
        return this.f585k;
    }

    public final MenuInflater mo205b() {
        if (this.f586l == null) {
            this.f586l = new SupportMenuInflater(m1106h());
        }
        return this.f586l;
    }

    public void mo204a(Bundle bundle) {
        TypedArray obtainStyledAttributes = this.f575a.obtainStyledAttributes(R.styleable.Theme);
        if (obtainStyledAttributes.hasValue(2)) {
            if (obtainStyledAttributes.getBoolean(2, false)) {
                this.f580f = true;
            }
            if (obtainStyledAttributes.getBoolean(4, false)) {
                this.f581g = true;
            }
            if (obtainStyledAttributes.getBoolean(5, false)) {
                this.f582h = true;
            }
            this.f583i = obtainStyledAttributes.getBoolean(0, false);
            this.f584j = obtainStyledAttributes.getBoolean(3, false);
            obtainStyledAttributes.recycle();
            return;
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    final Context m1106h() {
        Context context = null;
        ActionBar a = mo203a();
        if (a != null) {
            context = a.mo280e();
        }
        if (context == null) {
            return this.f575a;
        }
        return context;
    }

    public final void mo206e() {
        Callback a = this.f576b.mo235a();
        if (a instanceof WindowCallbackCollectionWrapper) {
            WindowCallbackCollectionWrapper windowCallbackCollectionWrapper = (WindowCallbackCollectionWrapper) a;
            windowCallbackCollectionWrapper.f649a.remove(this.f578d);
            if (windowCallbackCollectionWrapper.f649a.isEmpty()) {
                windowCallbackCollectionWrapper.f650b.mo238a(windowCallbackCollectionWrapper.f651c);
            }
            this.f588n = true;
            return;
        }
        throw new IllegalStateException("Something went wrong, expecting AppCompatWindowCallbackWrapper but found " + a.getClass().getSimpleName() + " instead.");
    }

    final Callback m1107j() {
        return this.f576b.mo235a();
    }

    final CharSequence m1108k() {
        if (this.f577c instanceof Activity) {
            return ((Activity) this.f577c).getTitle();
        }
        return this.f587m;
    }
}
