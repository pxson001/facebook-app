package android.support.v4.app;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment.SavedState;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: }') */
public abstract class FragmentManager {

    /* compiled from: }') */
    public interface OnBackStackChangedListener {
        void le_();
    }

    public abstract SavedState mo838a(Fragment fragment);

    public abstract Fragment mo839a(@IdRes int i);

    public abstract Fragment mo840a(Bundle bundle, String str);

    public abstract Fragment mo841a(String str);

    public abstract FragmentTransaction mo842a();

    public abstract void mo843a(int i, int i2);

    public abstract void mo844a(Bundle bundle, String str, Fragment fragment);

    public abstract void mo845a(OnBackStackChangedListener onBackStackChangedListener);

    public abstract void mo846a(String str, int i);

    public abstract void mo847a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void mo848b(OnBackStackChangedListener onBackStackChangedListener);

    public abstract boolean mo849b();

    public abstract boolean mo850b(String str, int i);

    public abstract boolean mo851c();

    public abstract void mo852d();

    public abstract boolean mo853e();

    public abstract int mo854f();

    public abstract boolean mo855g();
}
