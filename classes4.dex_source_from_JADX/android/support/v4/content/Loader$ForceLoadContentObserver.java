package android.support.v4.content;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: excls */
public final class Loader$ForceLoadContentObserver extends ContentObserver {
    final /* synthetic */ Loader f12707a;

    public Loader$ForceLoadContentObserver(Loader loader) {
        this.f12707a = loader;
        super(new Handler());
    }

    public final boolean deliverSelfNotifications() {
        return true;
    }

    public final void onChange(boolean z) {
        this.f12707a.w();
    }
}
