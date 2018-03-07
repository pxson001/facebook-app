package com.facebook.reportaproblem.fb.fileprovider;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.util.TriState;
import com.facebook.fbui.viewdescriptionbuilder.ViewDescriptionBuilder;
import com.facebook.fbui.viewdescriptionbuilder.ViewDescriptionBuilder.JSONOutputType;
import com.facebook.fbui.viewdescriptionbuilder.ViewDescriptionBuilder.ViewTraversalMode;
import com.facebook.reportaproblem.base.bugreport.file.BugReportActivityFileProvider;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFile;
import java.io.File;
import javax.inject.Inject;

/* compiled from: setLaunchLoggingParams */
public class ViewHierarchyActivityFileProvider implements BugReportActivityFileProvider {
    private Bundle f4626a = null;
    private final ViewDescriptionBuilder f4627b;
    private final TriState f4628c;

    @Inject
    public ViewHierarchyActivityFileProvider(ViewDescriptionBuilder viewDescriptionBuilder, TriState triState) {
        this.f4627b = viewDescriptionBuilder;
        this.f4628c = triState;
    }

    public final void m7138a(Activity activity) {
        if (TriState.YES.equals(this.f4628c)) {
            this.f4626a = this.f4627b.a(activity.getWindow().getDecorView(), ViewTraversalMode.ALL);
        }
    }

    public final BugReportFile m7137a(File file) {
        if (this.f4626a == null || !TriState.YES.equals(this.f4628c)) {
            return null;
        }
        File file2 = new File(file, "view_hierarchy.txt");
        this.f4627b.a(file2, JSONOutputType.PRETTY, this.f4626a);
        return new BugReportFile("view_hierarchy.txt", Uri.fromFile(file2).toString(), "text/plain");
    }
}
