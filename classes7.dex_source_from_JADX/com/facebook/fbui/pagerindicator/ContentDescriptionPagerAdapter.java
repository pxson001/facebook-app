package com.facebook.fbui.pagerindicator;

import android.database.DataSetObservable;
import android.database.DataSetObserver;

/* compiled from: sprout */
public abstract class ContentDescriptionPagerAdapter {
    public final DataSetObservable f3556a = new DataSetObservable();

    public abstract CharSequence m4266b(int i);

    public final void m4267b(DataSetObserver dataSetObserver) {
        this.f3556a.unregisterObserver(dataSetObserver);
    }

    public final void m4265a() {
        this.f3556a.notifyChanged();
    }
}
