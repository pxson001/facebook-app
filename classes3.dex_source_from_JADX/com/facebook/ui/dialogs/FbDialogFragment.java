package com.facebook.ui.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.facebook.common.queryinterface.ProvidesInterface;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ufi/reactions/v2/face_models/love */
public class FbDialogFragment extends DialogFragment implements ProvidesInterface, InjectableComponentWithContext {
    @Inject
    public FbDialogFragmentEventListenerDispatcher al;
    private DialogContext am;

    public static void m77a(Object obj, Context context) {
        ((FbDialogFragment) obj).al = FbDialogFragmentEventListenerDispatcher.a(FbInjector.get(context));
    }

    public void mo1a(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1455026319);
        super.a(bundle);
        Class cls = FbDialogFragment.class;
        m77a((Object) this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1074422681, a);
    }

    public Dialog mo3c(Bundle bundle) {
        FbDialog fbDialog = new FbDialog(this, getContext(), d());
        DialogWindowUtils.a(fbDialog);
        return fbDialog;
    }

    public void mo2a(View view, @Nullable Bundle bundle) {
        this.al.a(this);
        super.a(view, bundle);
    }

    public void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 454401071);
        super.mY_();
        this.al.b(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1601625266, a);
    }

    public void m80a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        this.al.a(i, i2, intent);
    }

    public Context getContext() {
        Context context = super.getContext();
        if (this.d) {
            if (this.am == null || this.am.getBaseContext() != context) {
                this.am = new DialogContext(context);
            }
            return this.am;
        }
        this.am = null;
        return context;
    }

    public final Activity an() {
        return (Activity) ContextUtils.a(getContext(), Activity.class);
    }

    public final void m83a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        View view = this.T;
        if (view != null) {
            printWriter.write(str);
            printWriter.write("FbDialogFragment View Hierarchy:\n");
            FragmentActivity.a(str, printWriter, view);
        }
    }

    public boolean O_() {
        return false;
    }

    public final <T> T m79a(Class<? extends T> cls) {
        T b = m78b(cls);
        if (b != null) {
            return b;
        }
        Fragment fragment = this.G;
        if (fragment instanceof ProvidesInterface) {
            return ((ProvidesInterface) fragment).a(cls);
        }
        Context context = getContext();
        if (context instanceof ProvidesInterface) {
            return ((ProvidesInterface) context).a(cls);
        }
        return null;
    }

    private <T> T m78b(Class<? extends T> cls) {
        return cls.isInstance(this) ? this : null;
    }

    public final boolean ap() {
        return !this.x && mx_() && !this.L && z();
    }

    public final <T extends View> T m85e(int i) {
        return FindViewUtil.b(this.T, i);
    }
}
