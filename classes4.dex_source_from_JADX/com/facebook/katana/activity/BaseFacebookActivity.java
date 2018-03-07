package com.facebook.katana.activity;

import android.os.Bundle;
import android.view.View;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.bugreporter.activity.ActivityWithDebugInfo;
import com.facebook.common.activitylistener.ActivityListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.FbInjector;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.collect.RegularImmutableBiMap;
import java.util.Map;

@Deprecated
/* compiled from: uploadStagingResourcePhoto%d */
public class BaseFacebookActivity extends FbFragmentActivity implements ActivityWithDebugInfo, BookmarksMenuHost, FacebookActivity {
    private FacebookActivityDelegate f457p;
    private AbstractFbErrorReporter f458q;

    protected final void m760a(Bundle bundle) {
        super.a(bundle);
        this.f458q = (AbstractFbErrorReporter) FbErrorReporterImpl.a(FbInjector.get(this));
    }

    public final synchronized FacebookActivityDelegate mo54i() {
        if (this.f457p == null) {
            m759j();
        }
        return this.f457p;
    }

    private void m759j() {
        for (ActivityListener activityListener : hA_()) {
            if (activityListener instanceof FacebookActivityDelegate) {
                this.f457p = (FacebookActivityDelegate) activityListener;
                return;
            }
        }
        throw new RuntimeException("Unable to find a FbActivityListener of type FacebookActivityDelegate");
    }

    @Deprecated
    public final void m761a(TitleBarButtonSpec titleBarButtonSpec) {
        mo54i().a(titleBarButtonSpec);
    }

    @Deprecated
    public void titleBarPrimaryActionClickHandler(View view) {
        this.f458q.b(getClass().getName(), "Either override titleBarPrimaryActionClickHandler or call FBAD.setPrimaryClickHandler for the click handling.");
    }

    public Map<String, String> getDebugInfo() {
        if (this.f457p != null) {
            return this.f457p.g();
        }
        return RegularImmutableBiMap.a;
    }
}
