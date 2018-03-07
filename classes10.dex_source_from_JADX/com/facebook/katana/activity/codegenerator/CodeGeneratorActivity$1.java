package com.facebook.katana.activity.codegenerator;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: user_for_settings */
class CodeGeneratorActivity$1 implements OnClickListener {
    final /* synthetic */ CodeGeneratorActivity f700a;

    CodeGeneratorActivity$1(CodeGeneratorActivity codeGeneratorActivity) {
        this.f700a = codeGeneratorActivity;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 859423111);
        CodeGeneratorActivity.a(this.f700a, this.f700a.J.getText());
        Logger.a(2, EntryType.UI_INPUT_END, -2109975494, a);
    }
}
