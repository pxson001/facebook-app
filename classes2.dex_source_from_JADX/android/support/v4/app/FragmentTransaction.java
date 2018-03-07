package android.support.v4.app;

import android.support.annotation.AnimRes;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;

/* compiled from: profile_image_size */
public abstract class FragmentTransaction {
    public abstract FragmentTransaction mo1838a();

    public abstract FragmentTransaction mo1839a(int i);

    public abstract FragmentTransaction mo1840a(@AnimRes int i, @AnimRes int i2);

    public abstract FragmentTransaction mo1841a(@AnimRes int i, @AnimRes int i2, @AnimRes int i3, @AnimRes int i4);

    public abstract FragmentTransaction mo1842a(@IdRes int i, Fragment fragment);

    public abstract FragmentTransaction mo1843a(@IdRes int i, Fragment fragment, @Nullable String str);

    public abstract FragmentTransaction mo1844a(Fragment fragment);

    public abstract FragmentTransaction mo1845a(Fragment fragment, String str);

    public abstract FragmentTransaction mo1846a(@Nullable String str);

    public abstract int mo1847b();

    public abstract FragmentTransaction mo1848b(@IdRes int i, Fragment fragment);

    public abstract FragmentTransaction mo1849b(@IdRes int i, Fragment fragment, @Nullable String str);

    public abstract FragmentTransaction mo1850b(Fragment fragment);

    public abstract int mo1851c();

    public abstract FragmentTransaction mo1852c(Fragment fragment);

    public abstract FragmentTransaction mo1853d(Fragment fragment);

    public abstract FragmentTransaction mo1854e(Fragment fragment);

    public abstract boolean mo1855e();
}
