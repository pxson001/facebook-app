package com.facebook.fbui.viewdescriptionbuilder;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.facebook.base.activity.FbRootViewUtil;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.content.SecureContextHelper;
import java.io.File;
import javax.inject.Inject;

/* compiled from: YEAR */
public class ViewDescriptionShareHelper {
    public final SecureContextHelper f12217a;
    public final ViewDescriptionBuilder f12218b;
    public final TempFileManager f12219c;

    @Inject
    public ViewDescriptionShareHelper(SecureContextHelper secureContextHelper, ViewDescriptionBuilder viewDescriptionBuilder, TempFileManager tempFileManager) {
        this.f12217a = secureContextHelper;
        this.f12218b = viewDescriptionBuilder;
        this.f12219c = tempFileManager;
    }

    public final void m20236a(Activity activity) {
        View a = FbRootViewUtil.a(activity);
        File a2 = this.f12219c.a("view_hierarchy", ".json", false);
        ViewDescriptionBuilder viewDescriptionBuilder = this.f12218b;
        boolean a3 = viewDescriptionBuilder.a(a2, ViewDescriptionBuilder$JSONOutputType.PRETTY, viewDescriptionBuilder.a(a, ViewDescriptionBuilder$ViewTraversalMode.ALL));
        File file = a2;
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", "View Hierarchy Debug Info");
        intent.putExtra("android.intent.extra.TEXT", "View Hierarchy json attached.");
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
        intent.setType("text/plain");
        this.f12217a.b(Intent.createChooser(intent, "Share via..."), a.getContext());
    }
}
