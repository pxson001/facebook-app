package com.facebook.katana.activity.faceweb.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.katana.activity.faceweb.ActionSheetButton;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.webview.FacebookWebView;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

/* compiled from: uri= */
public class FacewebActionSheetDialogFragment extends DialogFragment {
    public List<ActionSheetButton> al = null;
    private final JsonFactory am;
    public AbstractFbErrorReporter an;
    public FacebookWebView ao;

    /* compiled from: uri= */
    class C01361 extends TypeReference<List<ActionSheetButton>> {
        final /* synthetic */ FacewebActionSheetDialogFragment f860b;

        C01361(FacewebActionSheetDialogFragment facewebActionSheetDialogFragment) {
            this.f860b = facewebActionSheetDialogFragment;
        }
    }

    /* compiled from: uri= */
    class C01372 implements OnClickListener {
        final /* synthetic */ FacewebActionSheetDialogFragment f861a;

        C01372(FacewebActionSheetDialogFragment facewebActionSheetDialogFragment) {
            this.f861a = facewebActionSheetDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f861a.a();
        }
    }

    /* compiled from: uri= */
    class C01383 implements OnClickListener {
        final /* synthetic */ FacewebActionSheetDialogFragment f862a;

        C01383(FacewebActionSheetDialogFragment facewebActionSheetDialogFragment) {
            this.f862a = facewebActionSheetDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f862a.a();
            if (this.f862a.al != null && this.f862a.al.size() > i) {
                String str = ((ActionSheetButton) this.f862a.al.get(i)).callback;
                if (str != null) {
                    this.f862a.ao.a(str, null);
                }
            }
        }
    }

    /* compiled from: uri= */
    class C01394 implements OnClickListener {
        final /* synthetic */ FacewebActionSheetDialogFragment f863a;

        C01394(FacewebActionSheetDialogFragment facewebActionSheetDialogFragment) {
            this.f863a = facewebActionSheetDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f863a.a();
        }
    }

    public static void m851a(Object obj, Context context) {
        ((FacewebActionSheetDialogFragment) obj).an = (AbstractFbErrorReporter) FbErrorReporterImpl.a(FbInjector.get(context));
    }

    public FacewebActionSheetDialogFragment(JsonFactory jsonFactory) {
        this.am = jsonFactory;
    }

    public final void m852a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2102149273);
        super.a(bundle);
        Class cls = FacewebActionSheetDialogFragment.class;
        m851a(this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1342366858, a);
    }

    public final Dialog m853c(Bundle bundle) {
        String string = mt_().getString("action_sheet_buttons");
        try {
            this.al = (List) this.am.a(string).a(new C01361(this));
        } catch (JsonParseException e) {
            this.an.a("JSON", "Could not parse JSON:" + string, e);
        } catch (Throwable e2) {
            this.an.a("JSON", "IOError in JSON parser", e2);
        }
        if (this.al.size() == 0) {
            return new Builder(getContext()).a(2131236463).b(2131236463).b(2131230756, new C01372(this)).a();
        }
        CharSequence[] charSequenceArr = new CharSequence[this.al.size()];
        for (int i = 0; i < this.al.size(); i++) {
            charSequenceArr[i] = ((ActionSheetButton) this.al.get(i)).title;
        }
        Builder a = new Builder(getContext()).a(charSequenceArr, new C01383(this));
        if (!mt_().getBoolean("action_sheet_hide_cancel")) {
            a.b(2131237528, new C01394(this));
        }
        return a.a();
    }
}
