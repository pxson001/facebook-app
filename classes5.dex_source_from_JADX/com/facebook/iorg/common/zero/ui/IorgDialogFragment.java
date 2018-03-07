package com.facebook.iorg.common.zero.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import com.facebook.common.util.ContextUtils;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.iorg.common.zero.IorgDialogDisplayContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.dialogs.DialogWindowUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TOPICAL_LIVE */
public class IorgDialogFragment extends DialogFragment implements InjectableComponentWithContext {
    public final CopyOnWriteArrayList<Object> al = new CopyOnWriteArrayList();
    @Inject
    public IorgDialogDisplayMap am;
    private boolean an = false;

    public static void m23271a(Object obj, Context context) {
        ((IorgDialogFragment) obj).am = IorgDialogDisplayMap.m23267a(FbInjector.get(context));
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        Iterator it = this.al.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public void mo1278a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 440034883);
        super.a(bundle);
        Class cls = IorgDialogFragment.class;
        m23271a(this, getContext());
        this.an = false;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 204850943, a);
    }

    public Dialog mo1280c(Bundle bundle) {
        this.am.m23269a(aq());
        Dialog c = super.c(bundle);
        DialogWindowUtils.m10316a(c);
        return c;
    }

    public void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -782800822);
        super.mY_();
        this.am.m23270b(aq());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1081161843, a);
    }

    public final Activity ao() {
        return (Activity) ContextUtils.a(getContext(), Activity.class);
    }

    public final void m23272G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1465686872);
        super.G();
        if (this.an) {
            a();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 941585617, a);
    }

    @Nullable
    private IorgDialogDisplayContext aq() {
        if (this.s.containsKey("dialog_context")) {
            return (IorgDialogDisplayContext) this.s.getParcelable("dialog_context");
        }
        return null;
    }

    public final void ap() {
        FragmentManager fragmentManager = this.D;
        if (fragmentManager == null || !fragmentManager.c()) {
            this.an = true;
        } else {
            a();
        }
    }
}
