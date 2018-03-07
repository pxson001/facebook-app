package com.facebook.widget.friendselector;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;

/* compiled from: dc30cbd7510ad1eb0917564e3afc3647 */
public class FriendSelectorResultItem {
    public static int f16083a;
    public FriendSelectorResultContainer f16084b;
    public SimpleUserToken f16085c;
    public SelectedFriendItemView f16086d;
    public int f16087e;
    public boolean f16088f;

    /* compiled from: dc30cbd7510ad1eb0917564e3afc3647 */
    class C12541 implements OnClickListener {
        final /* synthetic */ FriendSelectorResultItem f16073a;

        C12541(FriendSelectorResultItem friendSelectorResultItem) {
            this.f16073a = friendSelectorResultItem;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1476628600);
            if (this.f16073a.f16084b.f16065c != null) {
                this.f16073a.f16084b.f16065c.mo1234a(this.f16073a.f16085c);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1473666405, a);
        }
    }

    /* compiled from: dc30cbd7510ad1eb0917564e3afc3647 */
    class C12552 extends AnimatorListenerAdapter {
        final /* synthetic */ FriendSelectorResultItem f16074a;

        C12552(FriendSelectorResultItem friendSelectorResultItem) {
            this.f16074a = friendSelectorResultItem;
        }

        public void onAnimationEnd(Animator animator) {
            this.f16074a.f16086d.setAlpha(1.0f);
        }
    }

    /* compiled from: dc30cbd7510ad1eb0917564e3afc3647 */
    public class C12563 extends AnimatorListenerAdapter {
        final /* synthetic */ FriendSelectorResultItem f16075a;

        public C12563(FriendSelectorResultItem friendSelectorResultItem) {
            this.f16075a = friendSelectorResultItem;
        }

        public void onAnimationEnd(Animator animator) {
            this.f16075a.f16086d.setTranslationX(0.0f);
        }
    }

    /* compiled from: dc30cbd7510ad1eb0917564e3afc3647 */
    public class C12574 extends AnimatorListenerAdapter {
        final /* synthetic */ FriendSelectorResultItem f16076a;

        public C12574(FriendSelectorResultItem friendSelectorResultItem) {
            this.f16076a = friendSelectorResultItem;
        }

        public void onAnimationEnd(Animator animator) {
            this.f16076a.f16086d.setTranslationX(0.0f);
        }
    }

    /* compiled from: dc30cbd7510ad1eb0917564e3afc3647 */
    class C12585 extends AnimatorListenerAdapter {
        final /* synthetic */ FriendSelectorResultItem f16077a;

        C12585(FriendSelectorResultItem friendSelectorResultItem) {
            this.f16077a = friendSelectorResultItem;
        }

        public void onAnimationEnd(Animator animator) {
            this.f16077a.f16086d.setTranslationX(0.0f);
        }
    }

    /* compiled from: dc30cbd7510ad1eb0917564e3afc3647 */
    class C12607 extends AnimatorListenerAdapter {
        final /* synthetic */ FriendSelectorResultItem f16080a;

        C12607(FriendSelectorResultItem friendSelectorResultItem) {
            this.f16080a = friendSelectorResultItem;
        }

        public void onAnimationEnd(Animator animator) {
            this.f16080a.m20098a();
            this.f16080a.f16086d.setScaleX(1.0f);
            this.f16080a.f16086d.setScaleY(1.0f);
        }
    }

    public FriendSelectorResultItem(FriendSelectorResultContainer friendSelectorResultContainer, SimpleUserToken simpleUserToken) {
        this.f16084b = friendSelectorResultContainer;
        this.f16085c = simpleUserToken;
        this.f16086d = new SelectedFriendItemView(friendSelectorResultContainer.getContext());
        this.f16086d.setToken(simpleUserToken);
        m20095r();
    }

    public FriendSelectorResultItem(FriendSelectorResultContainer friendSelectorResultContainer, SelectedFriendItemView selectedFriendItemView) {
        this.f16084b = friendSelectorResultContainer;
        this.f16086d = selectedFriendItemView;
        m20095r();
    }

    private void m20095r() {
        this.f16087e = this.f16084b.getResources().getDimensionPixelSize(2131428177);
        this.f16086d.setOnClickListener(new C12541(this));
    }

    public final void m20101a(boolean z) {
        if (!this.f16088f) {
            this.f16084b.addView(this.f16086d, m20096u());
            if (z) {
                this.f16086d.m20141a();
            }
            this.f16088f = true;
        }
    }

    public final void m20098a() {
        this.f16084b.removeView(this.f16086d);
        this.f16088f = false;
    }

    public final void m20103b() {
        if (!this.f16088f) {
            this.f16084b.addView(this.f16086d, 0, m20096u());
            this.f16088f = true;
        }
    }

    public final void m20104c() {
        this.f16086d.setVisibility(0);
        this.f16086d.requestLayout();
    }

    public final void m20100a(SimpleUserToken simpleUserToken) {
        this.f16085c = simpleUserToken;
        this.f16086d.setToken(simpleUserToken);
    }

    public final void m20099a(int i) {
        this.f16086d.m20142a(i);
    }

    public final void m20105h() {
        this.f16086d.m20143b();
    }

    public final Animator m20106j() {
        return SelectedFriendItemAnimationHelper.m20126b(this.f16086d);
    }

    public final Animator m20107l() {
        SelectedFriendItemView selectedFriendItemView = this.f16086d;
        int i = f16083a;
        Animator animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(selectedFriendItemView, "alpha", new float[]{0.0f});
        ObjectAnimator.ofFloat(selectedFriendItemView, "translationX", new float[]{(float) i, 0.0f}).setInterpolator(SelectedFriendItemAnimationHelper.f16110a);
        animatorSet.playTogether(new Animator[]{ofFloat, r4});
        animatorSet.addListener(SelectedFriendItemAnimationHelper.m20129f(selectedFriendItemView));
        Animator animator = animatorSet;
        animator.addListener(new C12552(this));
        return animator;
    }

    public final Animator m20108n() {
        SelectedFriendItemView selectedFriendItemView = this.f16086d;
        Animator ofFloat = ObjectAnimator.ofFloat(selectedFriendItemView, "translationX", new float[]{(float) f16083a, 0.0f});
        ofFloat.setInterpolator(SelectedFriendItemAnimationHelper.f16110a);
        ofFloat.addListener(SelectedFriendItemAnimationHelper.m20129f(selectedFriendItemView));
        return ofFloat;
    }

    public final Animator m20109p() {
        SelectedFriendItemView selectedFriendItemView = this.f16086d;
        int i = f16083a;
        Animator ofFloat = ObjectAnimator.ofFloat(selectedFriendItemView, "translationX", new float[]{0.0f, (float) i});
        ofFloat.setInterpolator(SelectedFriendItemAnimationHelper.f16110a);
        ofFloat.addListener(SelectedFriendItemAnimationHelper.m20129f(selectedFriendItemView));
        Animator animator = ofFloat;
        animator.addListener(new C12585(this));
        return animator;
    }

    public final Animator m20102b(final boolean z) {
        Animator a = SelectedFriendItemAnimationHelper.m20124a(this.f16086d);
        a.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ FriendSelectorResultItem f16079b;

            public void onAnimationStart(Animator animator) {
                if (z) {
                    this.f16079b.m20101a(false);
                }
            }
        });
        return a;
    }

    public final Animator m20110q() {
        Animator c = SelectedFriendItemAnimationHelper.m20127c(this.f16086d);
        c.addListener(new C12607(this));
        return c;
    }

    public final Animator m20097a(final FriendSelectorResultItem friendSelectorResultItem) {
        int indexOfChild = this.f16084b.indexOfChild(friendSelectorResultItem.f16086d);
        this.f16084b.removeView(this.f16086d);
        this.f16084b.addView(this.f16086d, indexOfChild);
        this.f16086d.setTranslationX((float) f16083a);
        Animator animatorSet = new AnimatorSet();
        Animator q = m20110q();
        SelectedFriendItemView selectedFriendItemView = friendSelectorResultItem.f16086d;
        Animator ofFloat = ObjectAnimator.ofFloat(selectedFriendItemView, "translationX", new float[]{(float) (-f16083a), 0.0f});
        ofFloat.setInterpolator(SelectedFriendItemAnimationHelper.f16110a);
        ofFloat.addListener(SelectedFriendItemAnimationHelper.m20129f(selectedFriendItemView));
        Animator animator = ofFloat;
        animatorSet.playTogether(new Animator[]{q, animator});
        animatorSet.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ FriendSelectorResultItem f16082b;

            public void onAnimationEnd(Animator animator) {
                this.f16082b.m20098a();
                friendSelectorResultItem.f16086d.setTranslationX(0.0f);
                this.f16082b.f16086d.setTranslationX(0.0f);
            }
        });
        return animatorSet;
    }

    private LayoutParams m20096u() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.setMargins(this.f16087e, this.f16087e, this.f16087e, this.f16087e);
        layoutParams.gravity = 16;
        return layoutParams;
    }
}
