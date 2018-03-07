package android.support.v7.app;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.internal.view.SupportActionModeWrapper;
import android.support.v7.internal.view.SupportActionModeWrapper.CallbackWrapper;
import android.support.v7.internal.widget.NativeActionModeAwareLayout;
import android.support.v7.internal.widget.NativeActionModeAwareLayout.OnActionModeForChildListener;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

@TargetApi(11)
/* compiled from: upsell_title_label */
public class AppCompatDelegateImplV11 extends AppCompatDelegateImplV7 implements OnActionModeForChildListener {
    private Fragment f614o;
    private NativeActionModeAwareLayout f615p;

    public AppCompatDelegateImplV11(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    public AppCompatDelegateImplV11(Fragment fragment, WindowLike windowLike, AppCompatCallback appCompatCallback) {
        super(fragment, windowLike, appCompatCallback);
        this.f614o = fragment;
    }

    final void mo225a(ViewGroup viewGroup) {
        this.f615p = (NativeActionModeAwareLayout) viewGroup.findViewById(this.f614o == null ? 16908290 : 2131558403);
        if (this.f615p != null) {
            this.f615p.f1111a = this;
        }
    }

    public final ActionMode mo224a(View view, Callback callback) {
        android.support.v7.view.ActionMode b = m1144b(new CallbackWrapper(view.getContext(), callback));
        if (b != null) {
            return new SupportActionModeWrapper(this.f575a, b);
        }
        return null;
    }
}
