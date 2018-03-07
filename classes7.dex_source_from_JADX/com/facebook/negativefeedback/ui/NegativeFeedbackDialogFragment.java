package com.facebook.negativefeedback.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.graphql.calls.UniversalFeedbackGiveFeedbackInputData.DeliveryType;
import com.facebook.graphql.calls.UniversalFeedbackGiveFeedbackInputData.ExperienceType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.negativefeedback.logging.NegativeFeedbackAnalyticsLogger;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.universalfeedback.UniversalFeedbackContextBuilder;
import com.facebook.universalfeedback.UniversalFeedbackController;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Stack;

/* compiled from: notif_option_action */
public class NegativeFeedbackDialogFragment extends FbDialogFragment implements AnalyticsFragment {
    public AlertDialog am;
    public String an;
    public long ao;
    public String ap;
    public NegativeFeedbackDialogController aq;
    public UniversalFeedbackController ar;

    /* compiled from: notif_option_action */
    class C06451 implements OnClickListener {
        final /* synthetic */ NegativeFeedbackDialogFragment f8062a;

        C06451(NegativeFeedbackDialogFragment negativeFeedbackDialogFragment) {
            this.f8062a = negativeFeedbackDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f8062a.a();
        }
    }

    public static void m9748a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        NegativeFeedbackDialogFragment negativeFeedbackDialogFragment = (NegativeFeedbackDialogFragment) obj;
        NegativeFeedbackDialogController b = NegativeFeedbackDialogController.m9737b(injectorLike);
        UniversalFeedbackController b2 = UniversalFeedbackController.m19350b(injectorLike);
        negativeFeedbackDialogFragment.aq = b;
        negativeFeedbackDialogFragment.ar = b2;
    }

    private static Bundle m9745a(String str, String str2, long j) {
        Bundle bundle = new Bundle();
        bundle.putString("node_token", str);
        bundle.putString("location", str2);
        bundle.putLong("responsible_user", j);
        return bundle;
    }

    public static NegativeFeedbackDialogFragment m9746a(String str, String str2) {
        NegativeFeedbackDialogFragment negativeFeedbackDialogFragment = new NegativeFeedbackDialogFragment();
        negativeFeedbackDialogFragment.g(m9745a(str, str2, -1));
        return negativeFeedbackDialogFragment;
    }

    public static NegativeFeedbackDialogFragment m9747a(String str, String str2, Bundle bundle) {
        NegativeFeedbackDialogFragment negativeFeedbackDialogFragment = new NegativeFeedbackDialogFragment();
        Bundle a = m9745a(str, str2, -1);
        a.putBundle("extras", bundle);
        negativeFeedbackDialogFragment.g(a);
        return negativeFeedbackDialogFragment;
    }

    public final void m9749a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -422086210);
        super.a(bundle);
        Class cls = NegativeFeedbackDialogFragment.class;
        m9748a((Object) this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 68013029, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1874907135);
        super.mi_();
        LayoutParams layoutParams = new LayoutParams();
        Window window = this.f.getWindow();
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = -1;
        window.setAttributes(layoutParams);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 221209030, a);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        NegativeFeedbackDialogController negativeFeedbackDialogController = this.aq;
        negativeFeedbackDialogController.f8053r.m9600d(negativeFeedbackDialogController.f8046k.f8006a);
        negativeFeedbackDialogController.f8054s.f7976a.b(5046273, (short) 4);
        if (!(negativeFeedbackDialogController.f8058w == NegativeFeedbackExperienceLocation.MESSENGER_THREAD_ACTION_PANEL.stringValueOf() || negativeFeedbackDialogController.f8058w == NegativeFeedbackExperienceLocation.MESSENGER_CONTACT_DETAILS.stringValueOf())) {
            if (negativeFeedbackDialogController.f8056u instanceof NegativeFeedbackResponsesView) {
                negativeFeedbackDialogController.f8057v.a("1415134408797047", negativeFeedbackDialogController.f8042g.getContext());
            }
            if ((negativeFeedbackDialogController.f8056u instanceof NegativeFeedbackGuidedActionsView) && !negativeFeedbackDialogController.f8030B.booleanValue()) {
                if (negativeFeedbackDialogController.f8029A.booleanValue()) {
                    negativeFeedbackDialogController.f8057v.a("1564957227079130", negativeFeedbackDialogController.f8042g.getContext());
                } else {
                    negativeFeedbackDialogController.f8057v.a("1607155906162890", negativeFeedbackDialogController.f8042g.getContext());
                }
            }
        }
        if (this.aq.f8030B.booleanValue() && !this.aq.f8031C.booleanValue() && !this.aq.f8032D.booleanValue()) {
            Iterable copyOf = ImmutableList.copyOf(this.aq.f8059x);
            if (copyOf != null && !copyOf.isEmpty()) {
                UniversalFeedbackContextBuilder universalFeedbackContextBuilder = new UniversalFeedbackContextBuilder(ExperienceType.NFX_FEEDBACK, DeliveryType.FB4A_NFX_DIALOG);
                universalFeedbackContextBuilder.f15343c = (String) Iterables.g(copyOf);
                this.ar.m19351a(universalFeedbackContextBuilder, this.D);
            }
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        a();
    }

    public final Dialog m9750c(Bundle bundle) {
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            this.an = bundle2.getString("node_token");
            this.ap = bundle2.getString("location");
            this.ao = bundle2.getLong("responsible_user");
            if (bundle2.containsKey("extras")) {
                this.aq.f8060y = bundle2.getBundle("extras");
            }
        }
        FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(getContext(), 2131626049);
        fbAlertDialogBuilder.c(false);
        fbAlertDialogBuilder.a(null);
        fbAlertDialogBuilder.a(false);
        fbAlertDialogBuilder.a(new NegativeFeedbackResponsesView(getContext()), 0, 0, 0, 0);
        final NegativeFeedbackDialogViewHolder negativeFeedbackDialogViewHolder = new NegativeFeedbackDialogViewHolder();
        NegativeFeedbackDialogController negativeFeedbackDialogController = this.aq;
        negativeFeedbackDialogController.f8044i = Lists.a();
        negativeFeedbackDialogController.f8043h = new Stack();
        negativeFeedbackDialogController.f8045j = negativeFeedbackDialogViewHolder;
        negativeFeedbackDialogController.f8049n = new NegativeFeedbackDialogViewFactory();
        negativeFeedbackDialogController.f8052q = Sets.a();
        negativeFeedbackDialogController.f8059x = new ArrayList();
        if (negativeFeedbackDialogController.f8060y != null && negativeFeedbackDialogController.f8060y.containsKey("analytics_params")) {
            NegativeFeedbackAnalyticsLogger negativeFeedbackAnalyticsLogger = negativeFeedbackDialogController.f8053r;
            Bundle bundle3 = negativeFeedbackDialogController.f8060y.getBundle("analytics_params");
            for (String str : bundle3.keySet()) {
                negativeFeedbackAnalyticsLogger.f7975b.put(str, bundle3.get(str));
            }
        }
        fbAlertDialogBuilder.a(2131237741, new C06451(this));
        fbAlertDialogBuilder.c(2131237740, this.aq.f8033E);
        fbAlertDialogBuilder.b(2131237742, this.aq.f8034F);
        this.am = fbAlertDialogBuilder.a();
        this.am.setOnShowListener(new OnShowListener(this) {
            final /* synthetic */ NegativeFeedbackDialogFragment f8064b;

            public void onShow(DialogInterface dialogInterface) {
                negativeFeedbackDialogViewHolder.f8066a = this.f8064b.am.a(-3);
                negativeFeedbackDialogViewHolder.f8067b = this.f8064b.am.a(-1);
                negativeFeedbackDialogViewHolder.f8068c = this.f8064b.am.a(-2);
                negativeFeedbackDialogViewHolder.f8068c.setTextColor(this.f8064b.jW_().getColor(2131361917));
                negativeFeedbackDialogViewHolder.m9752c();
                negativeFeedbackDialogViewHolder.m9753g();
                this.f8064b.f.getWindow().setSoftInputMode(4);
                NegativeFeedbackDialogController negativeFeedbackDialogController = this.f8064b.aq;
                negativeFeedbackDialogController.f8042g = this.f8064b.am;
                negativeFeedbackDialogController.f8050o = (FrameLayout) negativeFeedbackDialogController.f8042g.findViewById(2131561830);
                negativeFeedbackDialogController.f8051p = (LinearLayout) negativeFeedbackDialogController.f8042g.findViewById(2131561819);
                if (this.f8064b.ao != -1) {
                    this.f8064b.aq.m9743a(this.f8064b.an, this.f8064b.ao, this.f8064b.ap);
                } else {
                    this.f8064b.aq.m9744a(this.f8064b.an, this.f8064b.ap);
                }
            }
        });
        return this.am;
    }

    public final String am_() {
        return "negative_feedback";
    }
}
