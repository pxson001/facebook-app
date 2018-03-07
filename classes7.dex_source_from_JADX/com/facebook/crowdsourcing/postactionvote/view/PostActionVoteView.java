package com.facebook.crowdsourcing.postactionvote.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.crowdsourcing.enums.CrowdsourcingFieldType;
import com.facebook.crowdsourcing.postactionvote.PostActionVoteController.C14592;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: com.facebook.backgroundlocation.reporting.OLD_SETTINGS_CHANGED_ACTION */
public class PostActionVoteView extends CustomLinearLayout {
    C14592 f17590a;
    ProgressBar f17591b = ((ProgressBar) a(2131566184));

    /* compiled from: com.facebook.backgroundlocation.reporting.OLD_SETTINGS_CHANGED_ACTION */
    class C14653 implements AnimatorListener {
        final /* synthetic */ PostActionVoteView f17589a;

        C14653(PostActionVoteView postActionVoteView) {
            this.f17589a = postActionVoteView;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f17589a.f17590a.f17572d.m21448b();
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    public PostActionVoteView(String str, String str2, final C14592 c14592, Context context) {
        super(context);
        setContentView(2130906346);
        setOrientation(1);
        ((TextView) a(2131566182)).setText(str);
        ((TextView) a(2131566183)).setText(str2);
        a(2131566181).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PostActionVoteView f17586b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1099029780);
                C14592 c14592 = c14592;
                c14592.f17572d.m21447a(c14592.f17569a, c14592.f17570b, c14592.f17571c, CrowdsourcingFieldType.PAGE_PHONE, true);
                c14592.f17572d.f17582g.add(Long.valueOf(c14592.f17571c));
                c14592.f17572d.m21448b();
                Logger.a(2, EntryType.UI_INPUT_END, 579070717, a);
            }
        });
        a(2131566180).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PostActionVoteView f17588b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1999787072);
                C14592 c14592 = c14592;
                c14592.f17572d.m21447a(c14592.f17569a, c14592.f17570b, c14592.f17571c, CrowdsourcingFieldType.PAGE_PHONE, false);
                c14592.f17572d.f17582g.add(Long.valueOf(c14592.f17571c));
                c14592.f17572d.m21448b();
                Logger.a(2, EntryType.UI_INPUT_END, 502412256, a);
            }
        });
        this.f17590a = c14592;
    }

    public final void m21456a(long j) {
        this.f17591b.setMax(1000);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.f17591b, "progress", new int[]{1000, 0});
        ofInt.setDuration(j);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addListener(new C14653(this));
        ofInt.start();
    }
}
