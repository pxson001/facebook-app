package com.facebook.katana.activity.codegenerator;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: user_for_settings */
class CodeGeneratorActivity$3 implements OnClickListener {
    final /* synthetic */ CodeGeneratorActivity f704a;

    CodeGeneratorActivity$3(CodeGeneratorActivity codeGeneratorActivity) {
        this.f704a = codeGeneratorActivity;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -387385149);
        this.f704a.onBackPressed();
        Logger.a(2, EntryType.UI_INPUT_END, 1593471301, a);
    }
}
