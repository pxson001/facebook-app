package com.facebook.transliteration.gridview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.transliteration.TransliterateAnalyticsLogger;
import com.facebook.ui.dialogs.FbDialogFragment;
import java.util.List;

/* compiled from: event_space */
public class CharacterMapGridFragment extends FbDialogFragment {
    public static String am = CharacterMapGridFragment.class.toString();
    public Context an;
    public List<CharacterMapItem> ao;
    public OnItemClickListener ap;
    public TransliterateAnalyticsLogger aq;

    /* compiled from: event_space */
    class C11341 implements OnShowListener {
        final /* synthetic */ CharacterMapGridFragment f15180a;

        C11341(CharacterMapGridFragment characterMapGridFragment) {
            this.f15180a = characterMapGridFragment;
        }

        public void onShow(DialogInterface dialogInterface) {
            this.f15180a.aq.m19050a();
        }
    }

    /* compiled from: event_space */
    class C11352 implements OnCancelListener {
        final /* synthetic */ CharacterMapGridFragment f15181a;

        C11352(CharacterMapGridFragment characterMapGridFragment) {
            this.f15181a = characterMapGridFragment;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f15181a.aq.m19057b();
        }
    }

    public static void m19189a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        CharacterMapGridFragment characterMapGridFragment = (CharacterMapGridFragment) obj;
        Context context2 = (Context) injectorLike.getInstance(Context.class);
        characterMapGridFragment.aq = TransliterateAnalyticsLogger.m19046a(injectorLike);
        characterMapGridFragment.an = context2;
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        this.aq.m19057b();
    }

    public final void m19190H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 7528140);
        super.H();
        b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -818376057, a);
    }

    public final Dialog m19191c(Bundle bundle) {
        Class cls = CharacterMapGridFragment.class;
        m19189a(this, getContext());
        Dialog dialog = new Dialog(this.an);
        ListAdapter characterMappingGridAdapter = new CharacterMappingGridAdapter(this.an, this.ao);
        dialog.requestWindowFeature(1);
        dialog.setContentView(2130903550);
        GridView gridView = (GridView) dialog.findViewById(2131560291);
        gridView.setAdapter(characterMappingGridAdapter);
        if (this.ap != null) {
            gridView.setOnItemClickListener(this.ap);
        }
        dialog.setOnShowListener(new C11341(this));
        dialog.setOnCancelListener(new C11352(this));
        return dialog;
    }
}
