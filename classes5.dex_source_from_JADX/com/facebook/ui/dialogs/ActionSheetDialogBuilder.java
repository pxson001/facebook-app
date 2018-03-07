package com.facebook.ui.dialogs;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.ArrayList;

@Deprecated
/* compiled from: community */
public class ActionSheetDialogBuilder extends Builder {
    private ArrayList<String> f5430a = new ArrayList();
    public ArrayList<OnClickListener> f5431b = new ArrayList();
    private Context f5432c;

    /* compiled from: community */
    public class C05001 implements OnClickListener {
        final /* synthetic */ ActionSheetDialogBuilder f5428a;

        public C05001(ActionSheetDialogBuilder actionSheetDialogBuilder) {
            this.f5428a = actionSheetDialogBuilder;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    /* compiled from: community */
    class C05012 implements OnClickListener {
        final /* synthetic */ ActionSheetDialogBuilder f5429a;

        C05012(ActionSheetDialogBuilder actionSheetDialogBuilder) {
            this.f5429a = actionSheetDialogBuilder;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ((OnClickListener) this.f5429a.f5431b.get(i)).onClick(dialogInterface, i);
        }
    }

    public ActionSheetDialogBuilder(Context context) {
        super(context);
        this.f5432c = context;
    }

    public final ActionSheetDialogBuilder m10315a(String str, OnClickListener onClickListener) {
        this.f5430a.add(str);
        this.f5431b.add(onClickListener);
        return this;
    }

    public AlertDialog show() {
        setItems((CharSequence[]) this.f5430a.toArray(new String[this.f5430a.size()]), new C05012(this));
        this.f5430a = null;
        AlertDialog show = super.show();
        show.setCanceledOnTouchOutside(true);
        return show;
    }
}
