package com.facebook.katana.activity.codegenerator;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.katana.util.AlertDialogs;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: user_for_settings */
class CodeGeneratorActivity$2 implements OnClickListener {
    final /* synthetic */ CodeGeneratorActivity f703a;

    /* compiled from: user_for_settings */
    class C01031 implements DialogInterface.OnClickListener {
        final /* synthetic */ CodeGeneratorActivity$2 f701a;

        C01031(CodeGeneratorActivity$2 codeGeneratorActivity$2) {
            this.f701a = codeGeneratorActivity$2;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    /* compiled from: user_for_settings */
    class C01042 implements DialogInterface.OnClickListener {
        final /* synthetic */ CodeGeneratorActivity$2 f702a;

        C01042(CodeGeneratorActivity$2 codeGeneratorActivity$2) {
            this.f702a = codeGeneratorActivity$2;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f702a.f703a.t.a(new Intent(this.f702a.f703a, CodeGeneratorAutoProvisionSecretActivity.class), this.f702a.f703a);
            this.f702a.f703a.finish();
        }
    }

    CodeGeneratorActivity$2(CodeGeneratorActivity codeGeneratorActivity) {
        this.f703a = codeGeneratorActivity;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -694695128);
        AlertDialogs.a(this.f703a, this.f703a.getString(2131236482), 17301659, this.f703a.getString(2131236467), this.f703a.getString(2131236470), new C01031(this), this.f703a.getString(2131236472), new C01042(this), null, false).show();
        Logger.a(2, EntryType.UI_INPUT_END, 666109367, a);
    }
}
