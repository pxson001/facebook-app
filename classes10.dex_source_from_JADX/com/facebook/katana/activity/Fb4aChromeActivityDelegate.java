package com.facebook.katana.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.chrome.FbChromeActivityDelegate;
import com.facebook.inject.FbInjector;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import javax.annotation.Nullable;

/* compiled from: SEARCH_GROUP */
public abstract class Fb4aChromeActivityDelegate extends FbChromeActivityDelegate {
    public Fb4aTitleBarSupplier f24209a;

    public static void m25502a(Object obj, Context context) {
        ((Fb4aChromeActivityDelegate) obj).f24209a = Fb4aTitleBarSupplier.a(FbInjector.get(context));
    }

    protected void mo1046b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = Fb4aChromeActivityDelegate.class;
        m25502a(this, this.a);
    }

    protected Fragment mo1045A() {
        return kO_().a(2131558429);
    }
}
