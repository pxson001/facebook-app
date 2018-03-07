package com.facebook.feedplugins.pyml.rows.contentbased.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: android.intent.action.ACTION_POWER_CONNECTED */
class PymlSeeAllPagePartDefinition$2 implements OnClickListener {
    final /* synthetic */ PymlSeeAllPagePartDefinition f19886a;

    PymlSeeAllPagePartDefinition$2(PymlSeeAllPagePartDefinition pymlSeeAllPagePartDefinition) {
        this.f19886a = pymlSeeAllPagePartDefinition;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1452778080);
        this.f19886a.c.a(view.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.aK, "top"));
        Logger.a(2, EntryType.UI_INPUT_END, -541353087, a);
    }
}
