package com.facebook.reportaproblem.fb;

import android.content.Context;
import com.facebook.inject.InjectorLike;
import com.facebook.reportaproblem.base.ReportAProblemConfig;
import com.facebook.reportaproblem.base.bugreport.BugReportCategoryInfo;
import java.util.List;
import javax.inject.Inject;

/* compiled from: setPosition */
public class DefaultReportAProblemConfig extends ReportAProblemConfig {
    private static final UnsupportedOperationException f4603b = new UnsupportedOperationException("Provide a binding to your own implementation");

    private static DefaultReportAProblemConfig m7108b(InjectorLike injectorLike) {
        return new DefaultReportAProblemConfig((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public DefaultReportAProblemConfig(Context context) {
        super(context);
        throw f4603b;
    }

    protected final List<BugReportCategoryInfo> mo312e() {
        throw f4603b;
    }

    protected final boolean mo313h() {
        throw f4603b;
    }

    public final String mo314i() {
        throw f4603b;
    }

    public final String mo315j() {
        throw f4603b;
    }

    public final FbBugReportUploader mo316k() {
        throw f4603b;
    }

    public final FbBitmapDecoder mo317l() {
        throw f4603b;
    }
}
