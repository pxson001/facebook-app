package com.facebook.katana.activity.codegenerator;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.logger.AnalyticsEventNames.ContentFragmentType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.search.titlebar.GraphSearchTitleBarController;

/* compiled from: user_for_settings */
class CodeGeneratorActivity$4 implements OnClickListener {
    final /* synthetic */ CodeGeneratorActivity f705a;

    CodeGeneratorActivity$4(CodeGeneratorActivity codeGeneratorActivity) {
        this.f705a = codeGeneratorActivity;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -493043296);
        ((GraphSearchTitleBarController) this.f705a.u.get()).a(null, ContentFragmentType.MAINTAB);
        Logger.a(2, EntryType.UI_INPUT_END, 45132907, a);
    }
}
