package com.facebook.facecastdisplay;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbEditText;
import com.facebook.ui.dialogs.FbDialogFragment;
import javax.annotation.Nullable;

/* compiled from: storyset/ */
public class LiveEventCommentDialogFragment extends FbDialogFragment {
    public FbEditText am;
    private GlyphView an;
    private View ao;
    private View ap;
    private TextWatcher aq;
    public int ar;
    public CommentDialogFragmentListener as;

    /* compiled from: storyset/ */
    public interface CommentDialogFragmentListener {
        void mo127a();

        void mo128a(String str);
    }

    /* compiled from: storyset/ */
    class C02582 implements OnClickListener {
        final /* synthetic */ LiveEventCommentDialogFragment f2920a;

        C02582(LiveEventCommentDialogFragment liveEventCommentDialogFragment) {
            this.f2920a = liveEventCommentDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 959760400);
            if (this.f2920a.as != null) {
                this.f2920a.as.mo128a(LiveEventCommentDialogFragment.aq(this.f2920a));
            }
            this.f2920a.am.setText("");
            this.f2920a.b();
            Logger.a(2, EntryType.UI_INPUT_END, 1400892945, a);
        }
    }

    /* compiled from: storyset/ */
    class C02593 implements TextWatcher {
        final /* synthetic */ LiveEventCommentDialogFragment f2921a;

        C02593(LiveEventCommentDialogFragment liveEventCommentDialogFragment) {
            this.f2921a = liveEventCommentDialogFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            LiveEventCommentDialogFragment.ar(this.f2921a);
        }
    }

    /* compiled from: storyset/ */
    class C02604 implements OnClickListener {
        final /* synthetic */ LiveEventCommentDialogFragment f2922a;

        C02604(LiveEventCommentDialogFragment liveEventCommentDialogFragment) {
            this.f2922a = liveEventCommentDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 986448251);
            this.f2922a.a();
            Logger.a(2, EntryType.UI_INPUT_END, 1387634233, a);
        }
    }

    public final void m3204a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1411989738);
        super.a(bundle);
        a(2, 2131624725);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1122704395, a);
    }

    public final View m3203a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1462489152);
        final View inflate = layoutInflater.inflate(2130905072, viewGroup, false);
        inflate.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ LiveEventCommentDialogFragment f2919b;

            public void onGlobalLayout() {
                if (inflate.getHeight() - this.f2919b.ar > 100) {
                    this.f2919b.b();
                }
                this.f2919b.ar = inflate.getHeight();
            }
        });
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1818190757, a);
        return inflate;
    }

    public final void m3205a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.am = (FbEditText) e(2131563463);
        this.an = (GlyphView) e(2131563465);
        this.ao = e(2131563466);
        this.ap = e(2131563464);
        this.ar = Integer.MAX_VALUE;
        this.an.setOnClickListener(new C02582(this));
        this.aq = new C02593(this);
        this.am.addTextChangedListener(this.aq);
        ar(this);
        this.ap.setOnClickListener(new C02604(this));
    }

    public final void m3207h(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1247402865);
        super.h(bundle);
        if (bundle != null) {
            this.am.setText(bundle.getString("facecast_comment_draft_saved_tag"));
            ar(this);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -64285148, a);
    }

    public final void m3201G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 969503316);
        super.G();
        if (this.am.requestFocus()) {
            this.f.getWindow().setSoftInputMode(21);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1970671046, a);
    }

    public final void m3206e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("facecast_comment_draft_saved_tag", aq(this));
    }

    public final void m3202I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -449354341);
        super.I();
        this.an.setOnClickListener(null);
        this.am.removeTextChangedListener(this.aq);
        this.ap.setOnClickListener(null);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1791194482, a);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.as != null) {
            this.as.mo127a();
        }
    }

    public static String aq(LiveEventCommentDialogFragment liveEventCommentDialogFragment) {
        return liveEventCommentDialogFragment.am.getText().toString().trim();
    }

    public static void ar(LiveEventCommentDialogFragment liveEventCommentDialogFragment) {
        boolean z = !aq(liveEventCommentDialogFragment).isEmpty();
        liveEventCommentDialogFragment.an.setEnabled(z);
        liveEventCommentDialogFragment.ao.setEnabled(z);
    }
}
