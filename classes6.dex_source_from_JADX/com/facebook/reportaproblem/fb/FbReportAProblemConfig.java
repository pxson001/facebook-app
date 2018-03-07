package com.facebook.reportaproblem.fb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.analytics.activityidentifier.ActivityNameFormatter;
import com.facebook.common.locale.Locales;
import com.facebook.common.util.TriState;
import com.facebook.content.SecureContextHelper;
import com.facebook.reportaproblem.base.ReportAProblemConfig;
import com.facebook.reportaproblem.base.bugreport.file.BugReportActivityFileProvider;
import com.facebook.reportaproblem.base.bugreport.file.BugReportBackgroundDataProvider;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFileProvider;
import com.facebook.reportaproblem.base.bugreport.file.BugReportUiDataProvider;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: setOgMechanism */
public abstract class FbReportAProblemConfig extends ReportAProblemConfig {
    private final Provider<TriState> f4612b;
    private final Provider<String> f4613c;
    private final Provider<FbBugReportUploader> f4614d;
    private final Provider<Set<BugReportFileProvider>> f4615e;
    private final Provider<Set<BugReportActivityFileProvider>> f4616f;
    private final Provider<Set<BugReportBackgroundDataProvider>> f4617g;
    private final Provider<Set<BugReportUiDataProvider>> f4618h;
    private final Provider<SecureContextHelper> f4619i;
    private final Provider<FbBitmapDecoder> f4620j;
    private final Provider<FbBugReportMetadata> f4621k;
    private final Provider<ActivityNameFormatter> f4622l;
    private final Provider<Locales> f4623m;

    public FbReportAProblemConfig(Context context, Provider<TriState> provider, Provider<String> provider2, Provider<FbBugReportUploader> provider3, Provider<Set<BugReportFileProvider>> provider4, Provider<Set<BugReportActivityFileProvider>> provider5, Provider<Set<BugReportBackgroundDataProvider>> provider6, Provider<Set<BugReportUiDataProvider>> provider7, Provider<SecureContextHelper> provider8, Provider<FbBitmapDecoder> provider9, Provider<FbBugReportMetadata> provider10, Provider<ActivityNameFormatter> provider11, Provider<Locales> provider12) {
        super(context);
        this.f4612b = provider;
        this.f4613c = provider2;
        this.f4614d = provider3;
        this.f4615e = provider4;
        this.f4616f = provider5;
        this.f4617g = provider6;
        this.f4618h = provider7;
        this.f4619i = provider8;
        this.f4620j = provider9;
        this.f4621k = provider10;
        this.f4622l = provider11;
        this.f4623m = provider12;
    }

    public final FbBugReportUploader mo316k() {
        return (FbBugReportUploader) this.f4614d.get();
    }

    protected final boolean mo313h() {
        return ((TriState) this.f4612b.get()).asBoolean();
    }

    public final String mo314i() {
        return (String) this.f4613c.get();
    }

    public final String mo315j() {
        return ((Locales) this.f4623m.get()).c();
    }

    public final List<BugReportFileProvider> mo321n() {
        List<BugReportFileProvider> a = Lists.a(super.mo321n());
        a.addAll((Collection) this.f4615e.get());
        return a;
    }

    public final List<BugReportActivityFileProvider> mo322o() {
        List<BugReportActivityFileProvider> a = Lists.a(super.mo322o());
        a.addAll((Collection) this.f4616f.get());
        return a;
    }

    public final List<BugReportBackgroundDataProvider> mo324q() {
        List<BugReportBackgroundDataProvider> a = Lists.a(super.mo324q());
        a.addAll((Collection) this.f4617g.get());
        return a;
    }

    public final List<BugReportUiDataProvider> mo323p() {
        List<BugReportUiDataProvider> a = Lists.a(super.mo323p());
        a.addAll((Collection) this.f4618h.get());
        return a;
    }

    public final void mo319a(Uri uri, Activity activity) {
        ((SecureContextHelper) this.f4619i.get()).a(new Intent("android.intent.action.VIEW").setData(uri), activity);
    }

    public final FbBitmapDecoder mo317l() {
        return (FbBitmapDecoder) this.f4620j.get();
    }

    public final Map<String, String> mo320m() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(super.mo320m());
        linkedHashMap.putAll(((FbBugReportMetadata) this.f4621k.get()).m7117a());
        return linkedHashMap;
    }

    public final String mo318a(Activity activity) {
        this.f4622l.get();
        return ActivityNameFormatter.a(activity);
    }
}
