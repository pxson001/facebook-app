package com.facebook.widget.friendselector;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.friendselector.FriendSelectorResultItem.C12563;
import com.facebook.widget.friendselector.FriendSelectorResultItem.C12574;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: ddts */
public class FriendSelectorResultContainer extends CustomLinearLayout {
    public final ArrayList<FriendSelectorResultItem> f16063a = new ArrayList();
    public FriendSelectorResultItem f16064b;
    public ItemClickListener f16065c;
    public ItemSetChangeListener f16066d;
    private Handler f16067e;
    private Queue<Message> f16068f;
    private int f16069g = Integer.MAX_VALUE;
    private int f16070h;
    private int f16071i;
    public int f16072j;

    /* compiled from: ddts */
    public interface ItemClickListener {
        void mo1234a(SimpleUserToken simpleUserToken);
    }

    /* compiled from: ddts */
    public interface ItemSetChangeListener {
        void mo1235a();
    }

    /* compiled from: ddts */
    class C12501 extends AnimatorListenerAdapter {
        final /* synthetic */ FriendSelectorResultContainer f16055a;

        C12501(FriendSelectorResultContainer friendSelectorResultContainer) {
            this.f16055a = friendSelectorResultContainer;
        }

        public void onAnimationEnd(Animator animator) {
            ((FriendSelectorResultItem) this.f16055a.f16063a.get(this.f16055a.f16072j)).m20103b();
        }
    }

    /* compiled from: ddts */
    class C12512 extends AnimatorListenerAdapter {
        final /* synthetic */ FriendSelectorResultContainer f16056a;

        C12512(FriendSelectorResultContainer friendSelectorResultContainer) {
            this.f16056a = friendSelectorResultContainer;
        }

        public void onAnimationEnd(Animator animator) {
            FriendSelectorResultContainer.m20091h(this.f16056a);
        }
    }

    /* compiled from: ddts */
    class MessageHandler extends Handler {
        private WeakReference<FriendSelectorResultContainer> f16062a;

        public MessageHandler(FriendSelectorResultContainer friendSelectorResultContainer) {
            this.f16062a = new WeakReference(friendSelectorResultContainer);
        }

        public void handleMessage(Message message) {
            FriendSelectorResultContainer friendSelectorResultContainer = (FriendSelectorResultContainer) this.f16062a.get();
            if (friendSelectorResultContainer != null) {
                switch (message.what) {
                    case 0:
                        FriendSelectorResultContainer.m20081b(friendSelectorResultContainer, (SimpleUserToken) message.obj);
                        return;
                    case 1:
                        FriendSelectorResultContainer.m20082b(friendSelectorResultContainer, (SimpleUserToken) message.obj, message.arg1 != 0);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public FriendSelectorResultContainer(Context context) {
        super(context);
        m20080b();
    }

    public FriendSelectorResultContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20080b();
    }

    public FriendSelectorResultContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20080b();
    }

    private void m20080b() {
        this.f16067e = new MessageHandler(this);
        this.f16068f = new LinkedList();
    }

    public void setBadgeView(SelectedFriendItemView selectedFriendItemView) {
        this.f16064b = new FriendSelectorResultItem(this, selectedFriendItemView);
    }

    public ItemClickListener getItemClickListener() {
        return this.f16065c;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.f16065c = itemClickListener;
    }

    public void setItemSetChangeListener(ItemSetChangeListener itemSetChangeListener) {
        this.f16066d = itemSetChangeListener;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredWidth() != this.f16071i) {
            this.f16071i = getMeasuredWidth();
            m20083c();
        }
    }

    public final boolean m20094a() {
        return this.f16063a.isEmpty();
    }

    public ImmutableList<SimpleUserToken> getItems() {
        Builder builder = ImmutableList.builder();
        int size = this.f16063a.size();
        for (int i = 0; i < size; i++) {
            builder.c(((FriendSelectorResultItem) this.f16063a.get(i)).f16085c);
        }
        return builder.b();
    }

    public final void m20092a(SimpleUserToken simpleUserToken) {
        if (!this.f16063a.isEmpty() && this.f16070h == 0) {
            FriendSelectorResultItem friendSelectorResultItem = (FriendSelectorResultItem) this.f16063a.get(0);
            if (FriendSelectorResultItem.f16083a == 0 && friendSelectorResultItem.f16086d.getMeasuredWidth() > 0) {
                FriendSelectorResultItem.f16083a = friendSelectorResultItem.f16086d.getMeasuredWidth() + (friendSelectorResultItem.f16087e * 2);
            }
            this.f16070h = FriendSelectorResultItem.f16083a;
            m20083c();
        }
        Message obtainMessage = this.f16067e.obtainMessage(0, simpleUserToken);
        this.f16068f.add(obtainMessage);
        if (this.f16068f.size() == 1) {
            this.f16067e.sendMessage(obtainMessage);
        }
    }

    public final void m20093a(SimpleUserToken simpleUserToken, boolean z) {
        Message obtainMessage = this.f16067e.obtainMessage(1, z ? 1 : 0, 0, simpleUserToken);
        this.f16068f.add(obtainMessage);
        if (this.f16068f.size() == 1) {
            this.f16067e.sendMessage(obtainMessage);
        }
    }

    public static void m20081b(FriendSelectorResultContainer friendSelectorResultContainer, SimpleUserToken simpleUserToken) {
        friendSelectorResultContainer.m20077a(new FriendSelectorResultItem(friendSelectorResultContainer, simpleUserToken));
    }

    public static void m20082b(FriendSelectorResultContainer friendSelectorResultContainer, SimpleUserToken simpleUserToken, boolean z) {
        int i = 0;
        FriendSelectorResultItem friendSelectorResultItem = null;
        int i2 = 0;
        while (i2 < friendSelectorResultContainer.f16063a.size()) {
            friendSelectorResultItem = (FriendSelectorResultItem) friendSelectorResultContainer.f16063a.get(i2);
            if (friendSelectorResultItem.f16085c.p().equals(simpleUserToken.p())) {
                break;
            }
            i2++;
        }
        i2 = -1;
        if (i2 == -1) {
            m20091h(friendSelectorResultContainer);
        } else if (z) {
            friendSelectorResultContainer.m20078a(friendSelectorResultItem, i2);
        } else {
            friendSelectorResultContainer.f16063a.remove(friendSelectorResultItem);
            friendSelectorResultItem.m20098a();
            if (friendSelectorResultContainer.f16063a.size() > friendSelectorResultContainer.f16069g) {
                i = friendSelectorResultContainer.f16063a.size() - friendSelectorResultContainer.f16069g;
            }
            friendSelectorResultContainer.f16072j = i;
            if (!friendSelectorResultContainer.f16063a.isEmpty()) {
                ((FriendSelectorResultItem) friendSelectorResultContainer.f16063a.get(friendSelectorResultContainer.f16072j)).m20103b();
            }
            m20090g(friendSelectorResultContainer);
            m20091h(friendSelectorResultContainer);
        }
    }

    private void m20083c() {
        if (this.f16070h != 0 && this.f16071i != 0) {
            this.f16069g = this.f16071i / this.f16070h;
            m20086d();
        }
    }

    private void m20086d() {
        if (getChildCount() > this.f16069g) {
            m20087e();
        } else {
            m20089f();
        }
        m20090g(this);
    }

    private void m20087e() {
        this.f16072j = this.f16063a.size() - this.f16069g;
        for (int i = this.f16072j - 1; i >= 0; i--) {
            ((FriendSelectorResultItem) this.f16063a.get(i)).m20098a();
        }
    }

    private void m20089f() {
        if (this.f16072j != 0) {
            int i = this.f16072j;
            if (this.f16063a.size() <= this.f16069g) {
                this.f16072j = 0;
            } else {
                this.f16072j = this.f16063a.size() - this.f16069g;
            }
            for (int i2 = i - 1; i2 >= this.f16072j; i2--) {
                FriendSelectorResultItem friendSelectorResultItem = (FriendSelectorResultItem) this.f16063a.get(i2);
                if (!friendSelectorResultItem.f16088f) {
                    friendSelectorResultItem.m20103b();
                }
            }
        }
    }

    public static void m20090g(FriendSelectorResultContainer friendSelectorResultContainer) {
        if (friendSelectorResultContainer.f16064b == null) {
            return;
        }
        if (friendSelectorResultContainer.f16072j <= 0) {
            friendSelectorResultContainer.f16064b.f16086d.setVisibility(8);
            return;
        }
        friendSelectorResultContainer.f16064b.m20099a(friendSelectorResultContainer.f16072j + 1);
        friendSelectorResultContainer.f16064b.m20104c();
    }

    private void m20077a(FriendSelectorResultItem friendSelectorResultItem) {
        this.f16063a.add(friendSelectorResultItem);
        if (getChildCount() < this.f16069g) {
            friendSelectorResultItem.m20101a(true);
            m20091h(this);
            return;
        }
        int i = this.f16072j;
        boolean z = this.f16072j != 0;
        this.f16072j = this.f16063a.size() - this.f16069g;
        m20090g(this);
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        if (z) {
            ((FriendSelectorResultItem) this.f16063a.get(i)).m20098a();
            arrayList.add(this.f16064b.m20106j());
            arrayList.add(((FriendSelectorResultItem) this.f16063a.get(this.f16072j)).m20107l());
        } else {
            arrayList.add(getBadgeAppearAnimation());
        }
        for (i = this.f16072j + 1; i < this.f16063a.size() - 1; i++) {
            arrayList.add(((FriendSelectorResultItem) this.f16063a.get(i)).m20108n());
        }
        arrayList.add(friendSelectorResultItem.m20102b(true));
        m20074a(animatorSet, arrayList);
    }

    private void m20078a(FriendSelectorResultItem friendSelectorResultItem, int i) {
        this.f16063a.remove(friendSelectorResultItem);
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        if (this.f16063a.size() < this.f16069g) {
            arrayList.add(friendSelectorResultItem.m20110q());
            while (i < this.f16063a.size()) {
                FriendSelectorResultItem friendSelectorResultItem2 = (FriendSelectorResultItem) this.f16063a.get(i);
                SelectedFriendItemView selectedFriendItemView = friendSelectorResultItem2.f16086d;
                int i2 = FriendSelectorResultItem.f16083a;
                Animator ofFloat = ObjectAnimator.ofFloat(selectedFriendItemView, "translationX", new float[]{0.0f, (float) (-i2)});
                ofFloat.setInterpolator(SelectedFriendItemAnimationHelper.f16110a);
                ofFloat.addListener(SelectedFriendItemAnimationHelper.m20129f(selectedFriendItemView));
                Animator animator = ofFloat;
                animator.addListener(new C12574(friendSelectorResultItem2));
                arrayList.add(animator);
                i++;
            }
        } else if (this.f16063a.size() == this.f16069g) {
            this.f16072j = 0;
            if (i < 2) {
                friendSelectorResultItem.m20098a();
                if (i != 0) {
                    ((FriendSelectorResultItem) this.f16063a.get(0)).m20103b();
                }
                m20090g(this);
                m20091h(this);
                return;
            }
            arrayList.add(getBadgeDisappearAnimation());
            arrayList.add(m20073a(friendSelectorResultItem, i, 1, false));
        } else {
            int i3 = this.f16072j;
            this.f16072j = this.f16063a.size() - this.f16069g;
            m20090g(this);
            if (i <= i3) {
                Animator j = this.f16064b.m20106j();
                j.setDuration(250);
                j.start();
                m20091h(this);
                return;
            }
            arrayList.add(this.f16064b.m20106j());
            arrayList.add(m20073a(friendSelectorResultItem, i, i3, true));
            animatorSet.addListener(new C12501(this));
        }
        m20074a(animatorSet, arrayList);
    }

    private void m20074a(AnimatorSet animatorSet, ArrayList<Animator> arrayList) {
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(250);
        animatorSet.addListener(new C12512(this));
        animatorSet.start();
    }

    public static void m20091h(FriendSelectorResultContainer friendSelectorResultContainer) {
        friendSelectorResultContainer.f16068f.remove();
        if (friendSelectorResultContainer.f16066d != null) {
            friendSelectorResultContainer.f16066d.mo1235a();
        }
        if (!friendSelectorResultContainer.f16068f.isEmpty()) {
            friendSelectorResultContainer.f16067e.sendMessage((Message) friendSelectorResultContainer.f16068f.peek());
        }
    }

    private Animator m20073a(FriendSelectorResultItem friendSelectorResultItem, int i, int i2, boolean z) {
        FriendSelectorResultItem friendSelectorResultItem2;
        int i3;
        Animator animatorSet = new AnimatorSet();
        Object arrayList = new ArrayList();
        int i4 = i - 1;
        Object obj;
        if (i4 == i2) {
            obj = 1;
        } else {
            obj = null;
        }
        if (i4 >= 0) {
            friendSelectorResultItem2 = (FriendSelectorResultItem) this.f16063a.get(i4);
            arrayList.add(friendSelectorResultItem.m20097a(friendSelectorResultItem2));
            if (z && r2 != null) {
                arrayList.add(SelectedFriendItemAnimationHelper.m20125a(friendSelectorResultItem2.f16086d));
            }
            i3 = i4 - 1;
        } else {
            arrayList.add(friendSelectorResultItem.m20110q());
            i3 = i4;
        }
        for (i4 = i3; i4 > i2; i4--) {
            arrayList.add(((FriendSelectorResultItem) this.f16063a.get(i4)).m20109p());
        }
        if (z && r2 == null) {
            friendSelectorResultItem2 = (FriendSelectorResultItem) this.f16063a.get(i2);
            Animator d = SelectedFriendItemAnimationHelper.m20128d(friendSelectorResultItem2.f16086d, FriendSelectorResultItem.f16083a);
            d.addListener(new C12563(friendSelectorResultItem2));
            arrayList.add(d);
        }
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }

    private Animator getBadgeAppearAnimation() {
        Animator animatorSet = new AnimatorSet();
        FriendSelectorResultItem friendSelectorResultItem = (FriendSelectorResultItem) this.f16063a.get(0);
        if (friendSelectorResultItem.f16088f) {
            friendSelectorResultItem.m20098a();
        }
        this.f16064b.m20100a(friendSelectorResultItem.f16085c);
        this.f16064b.m20105h();
        Animator q = this.f16064b.m20110q();
        friendSelectorResultItem = (FriendSelectorResultItem) this.f16063a.get(1);
        friendSelectorResultItem.m20099a(this.f16072j + 1);
        Animator n = friendSelectorResultItem.m20108n();
        animatorSet.playTogether(new Animator[]{q, n});
        animatorSet.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ FriendSelectorResultContainer f16058b;

            public void onAnimationStart(Animator animator) {
                this.f16058b.f16064b.m20104c();
                this.f16058b.bringToFront();
            }

            public void onAnimationEnd(Animator animator) {
                friendSelectorResultItem.m20105h();
                FriendSelectorResultContainer.m20090g(this.f16058b);
                this.f16058b.f16064b.f16086d.bringToFront();
            }
        });
        return animatorSet;
    }

    private Animator getBadgeDisappearAnimation() {
        Animator animatorSet = new AnimatorSet();
        final FriendSelectorResultItem friendSelectorResultItem = (FriendSelectorResultItem) this.f16063a.get(0);
        this.f16064b.m20100a(friendSelectorResultItem.f16085c);
        this.f16064b.m20105h();
        this.f16064b.m20104c();
        Animator b = this.f16064b.m20102b(false);
        final FriendSelectorResultItem friendSelectorResultItem2 = (FriendSelectorResultItem) this.f16063a.get(1);
        friendSelectorResultItem2.m20099a(this.f16072j + 2);
        Animator p = friendSelectorResultItem2.m20109p();
        animatorSet.playTogether(new Animator[]{b, p});
        animatorSet.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ FriendSelectorResultContainer f16061c;

            public void onAnimationStart(Animator animator) {
                this.f16061c.f16064b.m20104c();
            }

            public void onAnimationEnd(Animator animator) {
                friendSelectorResultItem.m20103b();
                friendSelectorResultItem2.m20105h();
                FriendSelectorResultContainer.m20090g(this.f16061c);
            }
        });
        return animatorSet;
    }
}
