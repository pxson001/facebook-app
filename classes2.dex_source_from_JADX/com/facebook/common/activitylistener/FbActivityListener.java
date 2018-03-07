package com.facebook.common.activitylistener;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import com.google.common.base.Optional;

/* compiled from: was expecting either '*' or '/' for a comment */
public interface FbActivityListener extends ActivityListener {
    Dialog mo243a(int i);

    Optional<Boolean> mo244a();

    Optional<Boolean> mo245a(Activity activity, int i, KeyEvent keyEvent);

    void mo246a(Activity activity, int i, int i2, Intent intent);

    void mo247a(Activity activity, Intent intent);

    void mo248a(Activity activity, Configuration configuration);

    void mo249a(Activity activity, Bundle bundle);

    void mo250a(Activity activity, Fragment fragment);

    void mo251a(Bundle bundle);

    boolean mo252a(int i, Dialog dialog);

    boolean mo253a(Activity activity, Throwable th);

    Optional<Boolean> mo254b(Activity activity, int i, KeyEvent keyEvent);

    void mo255b(Activity activity, Bundle bundle);

    void mo256b(Bundle bundle);

    boolean mo257b();

    void mo258g(Activity activity);

    void mo259h(Activity activity);

    boolean mo260i(Activity activity);
}
