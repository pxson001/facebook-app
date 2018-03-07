package com.facebook.saved.contextmenu.interfaces;

import android.support.v4.app.Fragment;
import com.facebook.analytics.CurationMechanism;
import javax.annotation.Nonnull;

/* compiled from: is_traveling */
public interface SavedContextMenuItem<T> {
    Class<T> mo409a();

    String mo410a(T t);

    boolean mo411a(T t, Fragment fragment);

    String mo412b();

    boolean mo413b(T t);

    @Nonnull
    CurationMechanism mo414c();

    int mo415d();
}
