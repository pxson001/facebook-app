package com.facebook.universalfeedback.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.fbui.popover.PopoverViewFlipper.TransitionType;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.universalfeedback.UniversalFeedbackController.C11541;
import com.facebook.universalfeedback.UniversalFeedbackController.C11541.C11531;
import com.facebook.universalfeedback.graphql.UniversalFeedbackSubmissionMutation.FBUniversalFeedbackGiveFeedbackMutationString;
import com.facebook.universalfeedback.ui.UniversalFeedbackExplanationRequestView.ExplanationListener;
import com.facebook.universalfeedback.ui.UniversalFeedbackPageView.NavigationListener;
import com.facebook.universalfeedback.ui.UniversalFeedbackSatisfactionQuestionView.RatingListener;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: edit_gallery */
public class UniversalFeedbackUIController implements ExplanationListener, RatingListener {
    @Nullable
    public C11541 f15397a;
    @Nullable
    public UniversalFeedbackPopoverWindow f15398b;
    @Nullable
    public UniversalFeedbackExplanationRequestView f15399c;
    public UniversalFeedbackDialogFragment f15400d;
    public int f15401e;
    public List<View> f15402f;
    public final OnGlobalLayoutListener f15403g = new C11641(this);

    /* compiled from: edit_gallery */
    class C11641 implements OnGlobalLayoutListener {
        final /* synthetic */ UniversalFeedbackUIController f15393a;

        C11641(UniversalFeedbackUIController universalFeedbackUIController) {
            this.f15393a = universalFeedbackUIController;
        }

        public void onGlobalLayout() {
            UniversalFeedbackUIController.m19427a(this.f15393a, this.f15393a.f15402f);
        }
    }

    /* compiled from: edit_gallery */
    public class C11652 implements NavigationListener {
        final /* synthetic */ UniversalFeedbackUIController f15394a;

        public C11652(UniversalFeedbackUIController universalFeedbackUIController) {
            this.f15394a = universalFeedbackUIController;
        }

        public final void mo1190a() {
            this.f15394a.f15399c.setRating(this.f15394a.f15401e);
            this.f15394a.f15398b.e();
        }

        public final void mo1191b() {
            this.f15394a.f15398b.l();
            UniversalFeedbackUIController.m19428c(this.f15394a);
        }
    }

    /* compiled from: edit_gallery */
    public class C11663 implements NavigationListener {
        final /* synthetic */ UniversalFeedbackUIController f15395a;

        public C11663(UniversalFeedbackUIController universalFeedbackUIController) {
            this.f15395a = universalFeedbackUIController;
        }

        public final void mo1190a() {
            this.f15395a.f15398b.e();
            UniversalFeedbackUIController universalFeedbackUIController = this.f15395a;
            if (universalFeedbackUIController.f15397a != null) {
                C11541 c11541 = universalFeedbackUIController.f15397a;
                c11541.f15345a.f15353h.a("client_mutation_id", SafeUUIDGenerator.a().toString());
                c11541.f15345a.f15353h.a("actor_id", (String) c11541.f15345a.f15350e.get());
                c11541.f15345a.f15353h.a("score", Integer.valueOf(c11541.f15345a.f15354i + 1));
                c11541.f15345a.f15353h.a("text_feedback", c11541.f15345a.f15355j);
                GraphQlQueryString fBUniversalFeedbackGiveFeedbackMutationString = new FBUniversalFeedbackGiveFeedbackMutationString();
                fBUniversalFeedbackGiveFeedbackMutationString.a("input", c11541.f15345a.f15353h);
                Futures.a(c11541.f15345a.f15347b.a(GraphQLRequest.a(fBUniversalFeedbackGiveFeedbackMutationString)), new C11531(c11541), c11541.f15345a.f15349d);
            }
        }

        public final void mo1191b() {
            this.f15395a.f15398b.f();
        }
    }

    /* compiled from: edit_gallery */
    public class C11674 implements NavigationListener {
        final /* synthetic */ UniversalFeedbackUIController f15396a;

        public C11674(UniversalFeedbackUIController universalFeedbackUIController) {
            this.f15396a = universalFeedbackUIController;
        }

        public final void mo1190a() {
            this.f15396a.f15398b.l();
            UniversalFeedbackUIController.m19426a(this.f15396a);
        }

        public final void mo1191b() {
        }
    }

    public static void m19426a(UniversalFeedbackUIController universalFeedbackUIController) {
        if (universalFeedbackUIController.f15397a != null) {
            C11541 c11541 = universalFeedbackUIController.f15397a;
            if (c11541.f15345a.f15356k != null) {
                c11541.f15345a.f15356k.mo1188a();
            }
        }
        universalFeedbackUIController.m19429d();
    }

    public static void m19428c(UniversalFeedbackUIController universalFeedbackUIController) {
        if (universalFeedbackUIController.f15397a != null) {
            universalFeedbackUIController.f15397a.m19347c();
        }
        universalFeedbackUIController.m19429d();
    }

    public final void mo1192a(int i) {
        this.f15401e = i;
        if (this.f15397a != null) {
            this.f15397a.f15345a.f15354i = i;
        }
    }

    public final void mo1193a(String str) {
        if (this.f15397a != null) {
            this.f15397a.f15345a.f15355j = str;
        }
    }

    public final void m19431a(View view, Context context) {
        boolean z;
        if (this.f15398b == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        this.f15398b = new UniversalFeedbackPopoverWindow(context);
        UniversalFeedbackPopoverWindow universalFeedbackPopoverWindow = this.f15398b;
        boolean z2 = -2 == -1 || -2 == -2;
        Preconditions.checkArgument(z2);
        universalFeedbackPopoverWindow.f15384a = -2;
        this.f15402f = new ArrayList();
        List list = this.f15402f;
        UniversalFeedbackSatisfactionQuestionView universalFeedbackSatisfactionQuestionView = (UniversalFeedbackSatisfactionQuestionView) LayoutInflater.from(context).inflate(2130907597, null);
        universalFeedbackSatisfactionQuestionView.m19418a();
        universalFeedbackSatisfactionQuestionView.f15372a = new C11652(this);
        universalFeedbackSatisfactionQuestionView.f15389b = this;
        list.add(universalFeedbackSatisfactionQuestionView);
        list = this.f15402f;
        this.f15399c = (UniversalFeedbackExplanationRequestView) LayoutInflater.from(context).inflate(2130907592, null);
        this.f15399c.m19400a();
        this.f15399c.f15372a = new C11663(this);
        this.f15399c.f15373a = this;
        list.add(this.f15399c);
        list = this.f15402f;
        UniversalFeedbackThankyouView universalFeedbackThankyouView = (UniversalFeedbackThankyouView) LayoutInflater.from(context).inflate(2130907594, null);
        universalFeedbackThankyouView.f15372a = new C11674(this);
        list.add(universalFeedbackThankyouView);
        m19427a(this, this.f15402f);
        this.f15398b.d((View) this.f15402f.get(0));
        for (View e : Iterables.b(this.f15402f, 1)) {
            this.f15398b.e(e);
        }
        this.f15398b.d(true);
        this.f15398b.a(Position.CENTER);
        this.f15398b.a(TransitionType.SLIDE_UP);
        this.f15398b.x = false;
        this.f15398b.w = false;
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f15403g);
        this.f15398b.f(view);
    }

    public static void m19427a(UniversalFeedbackUIController universalFeedbackUIController, List list) {
        PopoverWindowViewMeasurer popoverWindowViewMeasurer = new PopoverWindowViewMeasurer(universalFeedbackUIController.f15398b.getContext());
        int i = 0;
        for (View view : list) {
            popoverWindowViewMeasurer.m19387a(view);
            i = Math.max(i, view.getMeasuredWidth());
        }
        for (View view2 : list) {
            view2.setMinimumWidth(i);
            LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(i, -2);
            } else {
                layoutParams.width = i;
                layoutParams.height = -2;
            }
            view2.setLayoutParams(layoutParams);
        }
    }

    private void m19429d() {
        if (this.f15400d != null) {
            this.f15400d.a();
        }
        ViewTreeObserver viewTreeObserver = this.f15398b.h().getViewTreeObserver();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            if (VERSION.SDK_INT >= 16) {
                viewTreeObserver.removeOnGlobalLayoutListener(this.f15403g);
            } else {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f15403g);
            }
        }
        this.f15399c = null;
        this.f15398b = null;
        this.f15400d = null;
    }
}
