package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;

/* compiled from: supports_timestamps */
public abstract class LoaderManager {
    public abstract <D> Loader<D> mo876a(int i, Bundle bundle, LoaderCallbacks<D> loaderCallbacks);

    public abstract void mo877a(int i);

    public abstract <D> Loader<D> mo879b(int i);

    public abstract <D> Loader<D> mo880b(int i, Bundle bundle, LoaderCallbacks<D> loaderCallbacks);

    public boolean mo878a() {
        return false;
    }
}
