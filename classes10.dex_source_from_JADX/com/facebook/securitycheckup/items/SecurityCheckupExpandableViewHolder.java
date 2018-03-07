package com.facebook.securitycheckup.items;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.SecurityCheckupLoggingInputData.Event;
import com.facebook.graphql.calls.SecurityCheckupLoginAlertsInputData;
import com.facebook.graphql.calls.SecurityCheckupLoginAlertsInputData.SetEmail;
import com.facebook.graphql.calls.SecurityCheckupLoginAlertsInputData.SetNotif;
import com.facebook.graphql.calls.SecurityCheckupLoginAlertsInputData.SetPhone;
import com.facebook.graphql.calls.SecurityCheckupLoginAlertsInputData.Source;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.securitycheckup.SecurityCheckupIconGenerator;
import com.facebook.securitycheckup.SecurityCheckupLogger;
import com.facebook.securitycheckup.SecurityCheckupScrollingController;
import com.facebook.securitycheckup.SecurityCheckupScrollingController.ScrollingState;
import com.facebook.securitycheckup.SecurityCheckupScrollingController.SecurityCheckupItemStateChangeListener;
import com.facebook.securitycheckup.SecurityCheckupState;
import com.facebook.securitycheckup.api.SecurityCheckupLoginAlertsMutation.SecurityCheckupLoginAlertsMutationString;
import com.facebook.securitycheckup.inner.SecurityCheckupInnerController;
import com.facebook.securitycheckup.inner.SecurityCheckupInnerControllerProvider;
import com.facebook.securitycheckup.items.SecurityCheckupItem.ItemType;
import com.facebook.securitycheckup.password.PasswordBulletSpan;
import com.facebook.securitycheckup.password.SecurityCheckupPasswordChangeActivityLauncher;
import com.facebook.securitycheckup.utils.ViewUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

/* compiled from: ia_gql_query_result */
public class SecurityCheckupExpandableViewHolder extends SecurityCheckupViewHolder {
    public SecurityCheckupInnerController f9822A;
    private SecurityCheckupInnerControllerProvider f9823B;
    public SecurityCheckupIconGenerator f9824C;
    public SecurityCheckupPasswordChangeActivityLauncher f9825D;
    private final Runnable f9826E = new C14571(this);
    public SecurityCheckupLogger f9827F;
    public boolean f9828G = false;
    public SecurityCheckupState f9829H;
    private final FbTextView f9830o;
    public final FbTextView f9831p;
    public final FbButton f9832q;
    public final View f9833r;
    private final LinearLayout f9834s;
    public final DisableScrollRelativeLayout f9835t;
    private final FrameLayout f9836u;
    public int f9837v;
    public int f9838w;
    public SecurityCheckupItemStateChangeListener f9839x;
    public boolean f9840y = false;
    private boolean f9841z = false;

    /* compiled from: ia_gql_query_result */
    class C14571 implements Runnable {
        final /* synthetic */ SecurityCheckupExpandableViewHolder f9812a;

        C14571(SecurityCheckupExpandableViewHolder securityCheckupExpandableViewHolder) {
            this.f9812a = securityCheckupExpandableViewHolder;
        }

        public void run() {
            Object string;
            if (this.f9812a.f9822A.f9769s.aZ_() == 0) {
                string = this.f9812a.f9801m.getResources().getString(2131241583);
            } else {
                string = this.f9812a.f9801m.getResources().getString(2131241582, new Object[]{Integer.valueOf(r0)});
            }
            this.f9812a.f9831p.setText(string);
            this.f9812a.f9800l.f9843b = string;
        }
    }

    /* compiled from: ia_gql_query_result */
    class C14582 implements OnClickListener {
        final /* synthetic */ SecurityCheckupExpandableViewHolder f9813a;

        C14582(SecurityCheckupExpandableViewHolder securityCheckupExpandableViewHolder) {
            this.f9813a = securityCheckupExpandableViewHolder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1410381709);
            if (!this.f9813a.f9828G) {
                this.f9813a.f9832q.callOnClick();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -151508446, a);
        }
    }

    /* compiled from: ia_gql_query_result */
    class C14593 implements Runnable {
        final /* synthetic */ SecurityCheckupExpandableViewHolder f9814a;

        C14593(SecurityCheckupExpandableViewHolder securityCheckupExpandableViewHolder) {
            this.f9814a = securityCheckupExpandableViewHolder;
        }

        public void run() {
            this.f9814a.f9837v = this.f9814a.a.getHeight();
            if (this.f9814a.f9839x != null) {
                SecurityCheckupItemStateChangeListener securityCheckupItemStateChangeListener = this.f9814a.f9839x;
                int i = this.f9814a.f9837v;
                if (securityCheckupItemStateChangeListener.f9693a.f9704c != null) {
                    securityCheckupItemStateChangeListener.f9693a.f9704c.f9855b = i;
                }
            }
        }
    }

    /* compiled from: ia_gql_query_result */
    class C14604 implements Runnable {
        final /* synthetic */ SecurityCheckupExpandableViewHolder f9815a;

        C14604(SecurityCheckupExpandableViewHolder securityCheckupExpandableViewHolder) {
            this.f9815a = securityCheckupExpandableViewHolder;
        }

        public void run() {
            this.f9815a.f9833r.setVisibility(8);
            this.f9815a.f9833r.setAlpha(1.0f);
        }
    }

    /* compiled from: ia_gql_query_result */
    class C14615 implements OnClickListener {
        final /* synthetic */ SecurityCheckupExpandableViewHolder f9816a;

        C14615(SecurityCheckupExpandableViewHolder securityCheckupExpandableViewHolder) {
            this.f9816a = securityCheckupExpandableViewHolder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -32398060);
            this.f9816a.f9827F.m9903a(Event.PASSWORD_CHANGE_CTA);
            SecurityCheckupPasswordChangeActivityLauncher securityCheckupPasswordChangeActivityLauncher = this.f9816a.f9825D;
            Intent component = new Intent().setComponent((ComponentName) securityCheckupPasswordChangeActivityLauncher.f9900b.get());
            component.putExtra("target_fragment", ContentFragmentType.SECURITY_CHECKUP_PASSWORD_CHANGE_FRAGMENT.ordinal());
            securityCheckupPasswordChangeActivityLauncher.f9899a.a(component, securityCheckupPasswordChangeActivityLauncher.f9901c);
            Logger.a(2, EntryType.UI_INPUT_END, -872843266, a);
        }
    }

    /* compiled from: ia_gql_query_result */
    public class C14626 implements Runnable {
        final /* synthetic */ SecurityCheckupExpandableViewHolder f9817a;

        public C14626(SecurityCheckupExpandableViewHolder securityCheckupExpandableViewHolder) {
            this.f9817a = securityCheckupExpandableViewHolder;
        }

        public void run() {
            this.f9817a.f9835t.setVisibility(0);
        }
    }

    /* compiled from: ia_gql_query_result */
    public class SecurityCheckupItemOnClickListener implements OnClickListener {
        final /* synthetic */ SecurityCheckupExpandableViewHolder f9821a;

        /* compiled from: ia_gql_query_result */
        class C14641 implements AnimatorUpdateListener {
            final /* synthetic */ SecurityCheckupItemOnClickListener f9819a;

            C14641(SecurityCheckupItemOnClickListener securityCheckupItemOnClickListener) {
                this.f9819a = securityCheckupItemOnClickListener;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                this.f9819a.f9821a.a.getLayoutParams().height = num.intValue();
                this.f9819a.f9821a.a.requestLayout();
            }
        }

        /* compiled from: ia_gql_query_result */
        class C14652 extends AnimatorListenerAdapter {
            final /* synthetic */ SecurityCheckupItemOnClickListener f9820a;

            C14652(SecurityCheckupItemOnClickListener securityCheckupItemOnClickListener) {
                this.f9820a = securityCheckupItemOnClickListener;
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (this.f9820a.f9821a.f9828G) {
                    SecurityCheckupItemStateChangeListener securityCheckupItemStateChangeListener = this.f9820a.f9821a.f9839x;
                    int i = this.f9820a.f9821a.f9802n;
                    securityCheckupItemStateChangeListener.f9693a.f9706e = ScrollingState.EXPAND_COMPLETED;
                    securityCheckupItemStateChangeListener.f9693a.f9709h = i;
                    securityCheckupItemStateChangeListener.f9693a.f9704c.f9856c = true;
                    securityCheckupItemStateChangeListener.f9693a.f9704c.m10042d();
                    securityCheckupItemStateChangeListener.f9693a.f9705d.m10016e(i);
                    SecurityCheckupScrollingController securityCheckupScrollingController = securityCheckupItemStateChangeListener.f9693a;
                    Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation.setDuration(20);
                    alphaAnimation.setInterpolator(new AccelerateInterpolator());
                    alphaAnimation.setAnimationListener(/* anonymous class already generated */);
                    Animation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation2.setDuration(20);
                    alphaAnimation2.setStartOffset(20);
                    alphaAnimation2.setInterpolator(new DecelerateInterpolator());
                    Animation animationSet = new AnimationSet(false);
                    animationSet.addAnimation(alphaAnimation2);
                    animationSet.addAnimation(alphaAnimation);
                    securityCheckupScrollingController.f9707f.startAnimation(animationSet);
                    securityCheckupItemStateChangeListener.f9693a.f9707f.setContentDescription(securityCheckupItemStateChangeListener.f9693a.f9703b.getResources().getString(2131241626));
                    SecurityCheckupExpandableViewHolder.m10023A(this.f9820a.f9821a);
                    this.f9820a.f9821a.f9824C.m9899a();
                    return;
                }
                securityCheckupItemStateChangeListener = this.f9820a.f9821a.f9839x;
                i = this.f9820a.f9821a.f9802n;
                securityCheckupItemStateChangeListener.f9693a.f9706e = ScrollingState.COLLAPSE_COMPLETED;
                securityCheckupItemStateChangeListener.f9693a.f9704c.m10042d();
            }
        }

        public SecurityCheckupItemOnClickListener(SecurityCheckupExpandableViewHolder securityCheckupExpandableViewHolder) {
            this.f9821a = securityCheckupExpandableViewHolder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1047002963);
            if (this.f9821a.f9800l == null || this.f9821a.f9837v == 0 || !this.f9821a.f9800l.f9846e) {
                Logger.a(2, EntryType.UI_INPUT_END, 1073069788, a);
                return;
            }
            ValueAnimator a2;
            if (this.f9821a.f9828G) {
                a2 = m10022a(this.f9821a.f9838w, this.f9821a.f9837v);
                this.f9821a.f9828G = false;
                this.f9821a.f9839x.m9917a(this.f9821a.f9802n, this.f9821a.f9840y);
                this.f9821a.f9840y = false;
                SecurityCheckupExpandableViewHolder.m10025D(this.f9821a);
                this.f9821a.f9832q.animate().alpha(1.0f).setDuration(100);
                this.f9821a.f9832q.setTextColor(this.f9821a.f9801m.getResources().getColor(2131361937));
                this.f9821a.f9800l.f9848g = true;
            } else {
                a2 = m10022a(this.f9821a.f9837v, this.f9821a.f9838w);
                this.f9821a.f9828G = true;
                this.f9821a.f9839x.m9916a(this.f9821a.f9802n);
                this.f9821a.f9832q.animate().alpha(0.0f).setDuration(100);
            }
            a2.start();
            LogUtils.a(326942802, a);
        }

        private ValueAnimator m10022a(int i, int i2) {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
            ofInt.setDuration(250);
            ofInt.setInterpolator(new DecelerateInterpolator());
            ofInt.addUpdateListener(new C14641(this));
            ofInt.addListener(new C14652(this));
            return ofInt;
        }
    }

    @Inject
    @SuppressLint({"ConstructorMayLeakThis"})
    public SecurityCheckupExpandableViewHolder(@Assisted View view, @Assisted Context context, SecurityCheckupPasswordChangeActivityLauncher securityCheckupPasswordChangeActivityLauncher, SecurityCheckupInnerControllerProvider securityCheckupInnerControllerProvider, SecurityCheckupLogger securityCheckupLogger, SecurityCheckupState securityCheckupState) {
        super(view, context);
        this.f9838w = context.getResources().getDisplayMetrics().heightPixels;
        this.f9830o = (FbTextView) view.findViewById(2131567316);
        this.f9831p = (FbTextView) view.findViewById(2131567317);
        this.f9832q = (FbButton) view.findViewById(2131567319);
        this.f9833r = view.findViewById(2131567320);
        this.f9834s = (LinearLayout) view.findViewById(2131567314);
        this.f9835t = (DisableScrollRelativeLayout) view.findViewById(2131567318);
        this.f9836u = (FrameLayout) view.findViewById(2131567315);
        this.f9832q.setOnClickListener(new SecurityCheckupItemOnClickListener(this));
        view.setOnClickListener(new C14582(this));
        this.f9825D = securityCheckupPasswordChangeActivityLauncher;
        this.f9823B = securityCheckupInnerControllerProvider;
        this.f9827F = securityCheckupLogger;
        this.f9829H = securityCheckupState;
    }

    public final void mo452a(SecurityCheckupItem securityCheckupItem, int i) {
        super.mo452a(securityCheckupItem, i);
        this.f9830o.setText(securityCheckupItem.f9842a);
        this.f9831p.setText(securityCheckupItem.f9843b);
        DisplayMetrics displayMetrics = this.f9801m.getResources().getDisplayMetrics();
        LayoutParams layoutParams;
        if (StringUtil.a(securityCheckupItem.f9844c)) {
            this.f9832q.setVisibility(8);
            layoutParams = (LayoutParams) this.f9834s.getLayoutParams();
            layoutParams.bottomMargin = ViewUtil.m10068a(displayMetrics, 32);
            this.f9834s.setLayoutParams(layoutParams);
        } else {
            this.f9832q.setText(securityCheckupItem.f9844c);
            this.f9832q.setVisibility(0);
            if (securityCheckupItem.f9848g) {
                this.f9832q.setTextColor(this.f9801m.getResources().getColor(2131361937));
            } else {
                this.f9832q.setTextColor(this.f9801m.getResources().getColor(2131361917));
            }
            layoutParams = (LayoutParams) this.f9834s.getLayoutParams();
            layoutParams.bottomMargin = ViewUtil.m10068a(displayMetrics, 72);
            this.f9834s.setLayoutParams(layoutParams);
        }
        this.f9836u.removeAllViews();
        this.f9824C = new SecurityCheckupIconGenerator(this.f9836u, this.f9800l.f9845d, this.f9800l.f9847f);
        if (this.f9800l.f9845d == ItemType.INTRO && !this.f9800l.f9847f) {
            this.f9824C.m9899a();
            this.f9800l.f9847f = true;
            this.f9824C.f9669o = true;
        }
        this.a.post(new C14593(this));
        this.f9833r.setVisibility(8);
        this.f9835t.setVisibility(8);
        this.f9841z = false;
    }

    public final void m10031w() {
        this.f9824C.m9899a();
    }

    public final void m10032x() {
        this.f9824C.m9900b();
    }

    public final void m10030c(int i) {
        if (this.f9841z) {
            this.f9841z = false;
        } else {
            this.f9833r.setVisibility(i);
        }
    }

    public final void m10033y() {
        this.f9833r.animate().alpha(0.0f).setDuration(200).setInterpolator(new AccelerateInterpolator()).withEndAction(new C14604(this));
        this.f9841z = true;
    }

    public final void m10029b(boolean z) {
        this.f9840y = z;
        this.f9832q.callOnClick();
    }

    public static void m10023A(SecurityCheckupExpandableViewHolder securityCheckupExpandableViewHolder) {
        switch (securityCheckupExpandableViewHolder.f9800l.f9845d) {
            case UNUSED_SESSIONS:
            case LOGIN_ALERTS:
                securityCheckupExpandableViewHolder.f9822A = securityCheckupExpandableViewHolder.f9823B.m10010a(LayoutInflater.from(securityCheckupExpandableViewHolder.f9801m).inflate(2130907030, securityCheckupExpandableViewHolder.f9835t, true), securityCheckupExpandableViewHolder.f9801m, securityCheckupExpandableViewHolder.f9800l.f9845d, securityCheckupExpandableViewHolder.f9800l.f9849h, securityCheckupExpandableViewHolder.f9826E);
                securityCheckupExpandableViewHolder.f9822A.m10009a();
                break;
            case PASSWORD:
                securityCheckupExpandableViewHolder.m10024B();
                break;
        }
        switch (securityCheckupExpandableViewHolder.f9800l.f9845d) {
            case UNUSED_SESSIONS:
                securityCheckupExpandableViewHolder.f9827F.m9903a(Event.END_SESSION_EXPAND);
                break;
            case LOGIN_ALERTS:
                securityCheckupExpandableViewHolder.f9827F.m9903a(Event.LA_EXPAND);
                break;
            case PASSWORD:
                securityCheckupExpandableViewHolder.f9827F.m9903a(Event.PASSWORD_EXPAND);
                break;
        }
        securityCheckupExpandableViewHolder.f9835t.animate().alpha(1.0f).setDuration(200).setInterpolator(new AccelerateInterpolator()).withEndAction(new C14626(securityCheckupExpandableViewHolder));
    }

    private void m10024B() {
        View inflate = LayoutInflater.from(this.f9801m).inflate(2130907029, this.f9835t, true);
        m10026a(inflate);
        ((FbButton) inflate.findViewById(2131567329)).setOnClickListener(new C14615(this));
    }

    private void m10026a(View view) {
        DisplayMetrics displayMetrics = this.f9801m.getResources().getDisplayMetrics();
        int a = ViewUtil.m10068a(displayMetrics, 8);
        int a2 = ViewUtil.m10068a(displayMetrics, 2);
        m10027a(view, 2131567331, 2131241609, a, a2);
        m10027a(view, 2131567332, 2131241610, a, a2);
        m10027a(view, 2131567333, 2131241611, a, a2);
    }

    private void m10027a(View view, int i, int i2, int i3, int i4) {
        FbTextView fbTextView = (FbTextView) view.findViewById(i);
        CharSequence spannableString = new SpannableString(this.f9801m.getResources().getString(i2));
        spannableString.setSpan(new PasswordBulletSpan(i3, i4), 0, spannableString.length(), 0);
        fbTextView.setText(spannableString);
    }

    public static void m10025D(SecurityCheckupExpandableViewHolder securityCheckupExpandableViewHolder) {
        switch (securityCheckupExpandableViewHolder.f9800l.f9845d) {
            case UNUSED_SESSIONS:
                securityCheckupExpandableViewHolder.f9827F.m9903a(Event.END_SESSION_COLLAPSE);
                break;
            case LOGIN_ALERTS:
                securityCheckupExpandableViewHolder.f9827F.m9903a(Event.LA_COLLAPSE);
                break;
            case PASSWORD:
                securityCheckupExpandableViewHolder.f9827F.m9903a(Event.PASSWORD_COLLAPSE);
                break;
        }
        if (securityCheckupExpandableViewHolder.f9822A != null && securityCheckupExpandableViewHolder.f9800l.f9845d == ItemType.LOGIN_ALERTS) {
            Object string;
            Object string2;
            boolean i = securityCheckupExpandableViewHolder.f9829H.m9934i();
            if (i) {
                string = securityCheckupExpandableViewHolder.f9801m.getResources().getString(2131241590);
            } else {
                String string3 = securityCheckupExpandableViewHolder.f9801m.getResources().getString(2131241589);
            }
            if (i) {
                string2 = securityCheckupExpandableViewHolder.f9801m.getResources().getString(2131241588);
            } else {
                string2 = securityCheckupExpandableViewHolder.f9801m.getResources().getString(2131241587);
            }
            securityCheckupExpandableViewHolder.f9832q.setText(string);
            securityCheckupExpandableViewHolder.f9831p.setText(string2);
            securityCheckupExpandableViewHolder.f9800l.f9844c = string;
            securityCheckupExpandableViewHolder.f9800l.f9843b = string2;
            SecurityCheckupInnerController securityCheckupInnerController = securityCheckupExpandableViewHolder.f9822A;
            string = 1;
            if (securityCheckupInnerController.f9760j.m9978a() != null) {
                Object obj;
                Enum enumR;
                if (securityCheckupInnerController.f9751a == null || !securityCheckupInnerController.f9751a.f9779e) {
                    string2 = null;
                } else {
                    string2 = 1;
                }
                if (securityCheckupInnerController.f9752b == null || !securityCheckupInnerController.f9752b.f9779e) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (securityCheckupInnerController.f9753c == null || !securityCheckupInnerController.f9753c.f9779e) {
                    string = null;
                }
                SecurityCheckupLoginAlertsInputData securityCheckupLoginAlertsInputData = new SecurityCheckupLoginAlertsInputData();
                if (string2 != null) {
                    enumR = SetNotif.TRUE;
                } else {
                    enumR = SetNotif.FALSE;
                }
                securityCheckupLoginAlertsInputData.a("set_notif", enumR);
                GraphQlCallInput graphQlCallInput = securityCheckupLoginAlertsInputData;
                if (obj != null) {
                    enumR = SetEmail.TRUE;
                } else {
                    enumR = SetEmail.FALSE;
                }
                graphQlCallInput.a("set_email", enumR);
                graphQlCallInput = graphQlCallInput;
                if (string != null) {
                    enumR = SetPhone.TRUE;
                } else {
                    enumR = SetPhone.FALSE;
                }
                graphQlCallInput.a("set_phone", enumR);
                GraphQlCallInput graphQlCallInput2 = graphQlCallInput;
                graphQlCallInput2.a("source", Source.FB4A_MEGAPHONE);
                graphQlCallInput2 = graphQlCallInput2;
                GraphQlQueryString securityCheckupLoginAlertsMutationString = new SecurityCheckupLoginAlertsMutationString();
                securityCheckupLoginAlertsMutationString.a("input", graphQlCallInput2);
                ((GraphQLQueryExecutor) securityCheckupInnerController.f9770t.get()).a(GraphQLRequest.a(securityCheckupLoginAlertsMutationString));
            }
        }
        securityCheckupExpandableViewHolder.f9822A = null;
        securityCheckupExpandableViewHolder.f9835t.removeAllViews();
    }
}
