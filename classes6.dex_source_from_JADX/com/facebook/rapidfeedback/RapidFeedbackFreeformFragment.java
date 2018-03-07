package com.facebook.rapidfeedback;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.SizeUtil;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.structuredsurvey.StructuredSurveyConstants.ImpressionExtra;
import com.facebook.structuredsurvey.StructuredSurveyConstants.ImpressionType;
import com.facebook.structuredsurvey.items.SurveyEditTextItem;
import com.facebook.structuredsurvey.items.SurveyQuestionItem;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.widget.text.BetterEditTextView;

/* compiled from: fake status publish break */
public class RapidFeedbackFreeformFragment extends FbDialogFragment {
    public static final String am = RapidFeedbackFreeformFragment.class.getSimpleName();
    public View an;
    public TextView ao;
    public TextView ap;
    public BetterEditTextView aq;
    public RapidFeedbackController ar;
    public final OnClickListener as = new C10821(this);
    public final OnClickListener at = new C10832(this);
    public SurveyEditTextItem au;
    public SurveyQuestionItem av;

    /* compiled from: fake status publish break */
    class C10821 implements OnClickListener {
        final /* synthetic */ RapidFeedbackFreeformFragment f15356a;

        C10821(RapidFeedbackFreeformFragment rapidFeedbackFreeformFragment) {
            this.f15356a = rapidFeedbackFreeformFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1107164298);
            this.f15356a.ar.a(ImpressionExtra.CANCEL_FREEFORM);
            RapidFeedbackFreeformFragment.aw(this.f15356a);
            Logger.a(2, EntryType.UI_INPUT_END, 1802948201, a);
        }
    }

    /* compiled from: fake status publish break */
    class C10832 implements OnClickListener {
        final /* synthetic */ RapidFeedbackFreeformFragment f15357a;

        C10832(RapidFeedbackFreeformFragment rapidFeedbackFreeformFragment) {
            this.f15357a = rapidFeedbackFreeformFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 945488134);
            RapidFeedbackFreeformFragment rapidFeedbackFreeformFragment = this.f15357a;
            if (rapidFeedbackFreeformFragment.au != null) {
                rapidFeedbackFreeformFragment.au.m24928a(rapidFeedbackFreeformFragment.aq.getText().toString());
                rapidFeedbackFreeformFragment.ar.g();
            }
            rapidFeedbackFreeformFragment = this.f15357a;
            rapidFeedbackFreeformFragment.ar.h();
            rapidFeedbackFreeformFragment.ar.a(ImpressionType.COMPLETE);
            RapidFeedbackFreeformFragment.aw(this.f15357a);
            rapidFeedbackFreeformFragment = this.f15357a;
            View textView = new TextView(rapidFeedbackFreeformFragment.getContext());
            textView.setText(rapidFeedbackFreeformFragment.jW_().getString(2131236118));
            textView.setGravity(17);
            textView.setTextSize((float) SizeUtil.c(rapidFeedbackFreeformFragment.jW_(), 2131427404));
            textView.setTextColor(rapidFeedbackFreeformFragment.jW_().getColor(2131361972));
            textView.setTypeface(null, 1);
            textView.setPadding(0, 0, 0, rapidFeedbackFreeformFragment.jW_().getDimensionPixelSize(2131427418));
            AlertDialog a2 = new Builder(rapidFeedbackFreeformFragment.getContext()).b(textView).a();
            a2.show();
            HandlerDetour.b(new Handler(), new C10854(rapidFeedbackFreeformFragment, a2), 2000, 1880419214);
            Logger.a(2, EntryType.UI_INPUT_END, -1987810915, a);
        }
    }

    /* compiled from: fake status publish break */
    public class C10843 implements TextWatcher {
        final /* synthetic */ RapidFeedbackFreeformFragment f15358a;

        public C10843(RapidFeedbackFreeformFragment rapidFeedbackFreeformFragment) {
            this.f15358a = rapidFeedbackFreeformFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Object obj;
            RapidFeedbackFreeformFragment rapidFeedbackFreeformFragment = this.f15358a;
            if (charSequence.length() > 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (rapidFeedbackFreeformFragment.ap != null) {
                if (obj != null) {
                    rapidFeedbackFreeformFragment.ap.setTextColor(rapidFeedbackFreeformFragment.jW_().getColor(2131361917));
                    rapidFeedbackFreeformFragment.ap.setOnClickListener(rapidFeedbackFreeformFragment.at);
                    rapidFeedbackFreeformFragment.ap.setClickable(true);
                    return;
                }
                rapidFeedbackFreeformFragment.ap.setTextColor(rapidFeedbackFreeformFragment.jW_().getColor(2131361974));
                rapidFeedbackFreeformFragment.ap.setClickable(false);
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: fake status publish break */
    public class C10854 implements Runnable {
        final /* synthetic */ AlertDialog f15359a;
        final /* synthetic */ RapidFeedbackFreeformFragment f15360b;

        public C10854(RapidFeedbackFreeformFragment rapidFeedbackFreeformFragment, AlertDialog alertDialog) {
            this.f15360b = rapidFeedbackFreeformFragment;
            this.f15359a = alertDialog;
        }

        public void run() {
            if (this.f15359a != null) {
                this.f15359a.dismiss();
            }
        }
    }

    public final void m22983a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 610172489);
        super.a(bundle);
        d(true);
        this.an = LayoutInflater.from(getContext()).inflate(2130906571, new LinearLayout(getContext()), false);
        if (this.ar != null) {
            this.aq = (BetterEditTextView) FindViewUtil.b(this.an, 2131566539);
            if (!TextUtils.isEmpty(this.av.f17175d)) {
                this.aq.setHint(this.av.f17175d);
            }
            this.aq.addTextChangedListener(new C10843(this));
            this.ao = (TextView) FindViewUtil.b(this.an, 2131566540);
            this.ao.setText(jW_().getString(2131230727));
            this.ao.setOnClickListener(this.as);
            this.ap = (TextView) FindViewUtil.b(this.an, 2131566541);
            this.ap.setText(jW_().getString(2131236117));
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1515487947, a);
    }

    public final void m22985d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1012423584);
        super.d(bundle);
        if (this.ar == null) {
            a();
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1283163840, a);
            return;
        }
        LogUtils.f(177302297, a);
    }

    public final Dialog m22984c(Bundle bundle) {
        Builder builder = new Builder(getContext());
        if (this.ar != null) {
            if (!(this.an == null || this.an.getParent() == null)) {
                ((ViewGroup) this.an.getParent()).removeView(this.an);
            }
            builder.a(this.an, 0, 0, 0, 0);
        }
        AlertDialog a = builder.a();
        a.setCanceledOnTouchOutside(false);
        d_(false);
        return a;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1781600316);
        if (this.f != null && this.M) {
            this.f.setDismissMessage(null);
        }
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1275517967, a);
    }

    public static void aw(RapidFeedbackFreeformFragment rapidFeedbackFreeformFragment) {
        rapidFeedbackFreeformFragment.a();
        rapidFeedbackFreeformFragment.ar.j();
    }
}
