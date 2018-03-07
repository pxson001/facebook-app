package com.facebook.photos.upload.progresspage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.inject.FbInjector;
import com.facebook.photos.upload.compost.analytics.CompostAnalyticsLogger;
import javax.inject.Inject;

/* compiled from: glAttachShader */
public class CompostActivity extends FbFragmentActivity {
    @Inject
    public CompostAnalyticsLogger f13833p;

    private static <T extends Context> void m21604a(Class<T> cls, T t) {
        m21605a((Object) t, (Context) t);
    }

    public static void m21605a(Object obj, Context context) {
        ((CompostActivity) obj).f13833p = CompostAnalyticsLogger.m21244b(FbInjector.get(context));
    }

    private void m21603a(CompostAnalyticsLogger compostAnalyticsLogger) {
        this.f13833p = compostAnalyticsLogger;
    }

    public static Intent m21601a(Context context, CompostSourceType compostSourceType) {
        return new Intent(context, CompostActivity.class).putExtra("source", compostSourceType);
    }

    public final void m21606b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130903740);
        CompostSourceType compostSourceType = (CompostSourceType) getIntent().getExtras().getSerializable("source");
        if (compostSourceType == null) {
            compostSourceType = CompostSourceType.UNKNOWN;
        }
        m21602a(compostSourceType);
        Class cls = CompostActivity.class;
        m21605a((Object) this, (Context) this);
        this.f13833p.m21249a(compostSourceType.analyticsName);
    }

    private CompostFragment m21602a(CompostSourceType compostSourceType) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("source", compostSourceType);
        CompostFragment compostFragment = (CompostFragment) kO_().a(2131558429);
        if (compostFragment != null) {
            return compostFragment;
        }
        compostFragment = new CompostFragment();
        compostFragment.g(bundle);
        kO_().a().a(2131558429, compostFragment).b();
        kO_().b();
        return compostFragment;
    }
}
