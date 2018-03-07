package android.support.v7.internal.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;

/* compiled from: unblock_promotion */
public class TintContextWrapper extends ContextWrapper {
    public final TintManager f1208a;

    public static Context m1679a(Context context) {
        if (context instanceof TintContextWrapper) {
            return context;
        }
        return new TintContextWrapper(context);
    }

    private TintContextWrapper(Context context) {
        super(context);
        this.f1208a = new TintManager(context);
    }

    public Resources getResources() {
        return this.f1208a.f1223k;
    }
}
