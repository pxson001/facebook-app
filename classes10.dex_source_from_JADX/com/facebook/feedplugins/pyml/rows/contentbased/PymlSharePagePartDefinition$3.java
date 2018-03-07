package com.facebook.feedplugins.pyml.rows.contentbased;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: android.intent.action.ACTION_POWER_DISCONNECTED */
public class PymlSharePagePartDefinition$3 implements OnClickListener {
    final /* synthetic */ Intent f19884a;
    final /* synthetic */ PymlSharePagePartDefinition f19885b;

    public PymlSharePagePartDefinition$3(PymlSharePagePartDefinition pymlSharePagePartDefinition, Intent intent) {
        this.f19885b = pymlSharePagePartDefinition;
        this.f19884a = intent;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -423058990);
        this.f19885b.f.a(this.f19884a, view.getContext());
        Logger.a(2, EntryType.UI_INPUT_END, -2100845733, a);
    }
}
