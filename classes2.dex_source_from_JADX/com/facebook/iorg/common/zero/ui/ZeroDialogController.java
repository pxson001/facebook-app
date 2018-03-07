package com.facebook.iorg.common.zero.ui;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import com.facebook.debug.log.BLog;
import com.facebook.iorg.common.zero.IorgDialogDisplayContext;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: small_actor_photo */
public abstract class ZeroDialogController {
    public final Map<ZeroFeatureKey, DialogData> f4655a = Maps.m838c();

    protected abstract DialogFragment mo1238a(DialogData dialogData, Object obj, ZeroFeatureKey zeroFeatureKey);

    protected abstract void mo1239a();

    public abstract boolean mo1240a(DialogToShow dialogToShow, ZeroFeatureKey zeroFeatureKey);

    protected abstract String mo1241b();

    public final ZeroDialogController m8430a(ZeroFeatureKey zeroFeatureKey, String str, Listener listener) {
        return m8425a(zeroFeatureKey, str, listener, null);
    }

    public final ZeroDialogController m8432a(ZeroFeatureKey zeroFeatureKey, String str, String str2, DialogToShow dialogToShow) {
        return m8426a(zeroFeatureKey, str, str2, null, null, null, null, null, dialogToShow);
    }

    private ZeroDialogController m8425a(ZeroFeatureKey zeroFeatureKey, String str, Listener listener, @Nullable IorgDialogDisplayContext iorgDialogDisplayContext) {
        return m8426a(zeroFeatureKey, mo1241b(), str, listener, iorgDialogDisplayContext, null, null, null, DialogToShow.DEFAULT);
    }

    public final ZeroDialogController m8433a(ZeroFeatureKey zeroFeatureKey, String str, String str2, Listener listener) {
        return m8426a(zeroFeatureKey, str, str2, listener, null, null, null, null, DialogToShow.DEFAULT);
    }

    public final ZeroDialogController m8431a(ZeroFeatureKey zeroFeatureKey, String str, ListenableFuture listenableFuture, FutureCallback futureCallback, DialogToShow dialogToShow) {
        return m8426a(zeroFeatureKey, mo1241b(), "", null, null, str, listenableFuture, futureCallback, dialogToShow);
    }

    private ZeroDialogController m8426a(ZeroFeatureKey zeroFeatureKey, String str, String str2, @Nullable Listener listener, @Nullable IorgDialogDisplayContext iorgDialogDisplayContext, @Nullable String str3, @Nullable ListenableFuture listenableFuture, @Nullable FutureCallback futureCallback, DialogToShow dialogToShow) {
        DialogData dialogData = new DialogData(this);
        dialogData.a = zeroFeatureKey;
        dialogData.b = str;
        dialogData.c = str2;
        dialogData.d = listener;
        dialogData.e = str3;
        dialogData.f = listenableFuture;
        dialogData.g = futureCallback;
        dialogData.h = iorgDialogDisplayContext;
        dialogData.j = dialogToShow;
        this.f4655a.put(zeroFeatureKey, dialogData);
        return this;
    }

    public final void m8435a(ZeroFeatureKey zeroFeatureKey, FragmentManager fragmentManager) {
        m8429a(zeroFeatureKey, fragmentManager, null);
    }

    public final DialogFragment m8429a(ZeroFeatureKey zeroFeatureKey, FragmentManager fragmentManager, @Nullable Object obj) {
        DialogData dialogData = (DialogData) this.f4655a.get(zeroFeatureKey);
        if (dialogData == null) {
            return null;
        }
        dialogData.i = fragmentManager;
        if (mo1240a(dialogData.j, zeroFeatureKey)) {
            mo1239a();
            if (!m8427a(fragmentManager, zeroFeatureKey)) {
                DialogFragment a = mo1238a(dialogData, obj, zeroFeatureKey);
                if (fragmentManager.mo851c()) {
                    a.m213a(fragmentManager, zeroFeatureKey.prefString);
                    return a;
                }
                BLog.b("ZeroDialogController", "Attempting to show fragment after onSaveInstanceState() has been called");
                return null;
            }
        }
        Listener listener = dialogData.d;
        if (listener == null) {
            return null;
        }
        listener.a(obj);
        return null;
    }

    public static boolean m8427a(FragmentManager fragmentManager, ZeroFeatureKey zeroFeatureKey) {
        return fragmentManager.mo841a(zeroFeatureKey.prefString) != null;
    }

    public final boolean m8437a(ZeroFeatureKey zeroFeatureKey) {
        return mo1240a(DialogToShow.DEFAULT, zeroFeatureKey);
    }
}
