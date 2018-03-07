package com.facebook.common.activitylistener;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.annotation.Nullable;

/* compiled from: was_clicked */
public class AbstractFbActivityListener extends BaseActivityListener implements FbActivityListener {
    public void mo249a(Activity activity, @Nullable Bundle bundle) {
    }

    public void mo255b(Activity activity, @Nullable Bundle bundle) {
    }

    public final Optional<Boolean> mo244a() {
        return Absent.INSTANCE;
    }

    public Optional<Boolean> mo245a(Activity activity, int i, KeyEvent keyEvent) {
        return Absent.INSTANCE;
    }

    public Optional<Boolean> mo254b(Activity activity, int i, KeyEvent keyEvent) {
        return Absent.INSTANCE;
    }

    public void mo251a(Bundle bundle) {
    }

    public final void mo247a(Activity activity, Intent intent) {
    }

    public final void mo258g(Activity activity) {
    }

    public void mo259h(Activity activity) {
    }

    public Dialog mo243a(int i) {
        return null;
    }

    public boolean mo252a(int i, Dialog dialog) {
        return false;
    }

    public boolean mo260i(Activity activity) {
        return false;
    }

    public void mo248a(Activity activity, Configuration configuration) {
    }

    public final boolean mo253a(Activity activity, Throwable th) {
        return false;
    }

    public final boolean mo257b() {
        return false;
    }

    public void mo246a(Activity activity, int i, int i2, Intent intent) {
    }

    public void mo256b(Bundle bundle) {
    }

    public final void mo250a(Activity activity, Fragment fragment) {
    }
}
