package com.facebook.widget.animatablelistview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Interpolator;
import android.widget.AbsListView.RecyclerListener;
import android.widget.BaseAdapter;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.debug.log.BLog;
import com.facebook.widget.animatablelistview.AnimatingListMutation.MutationType;
import com.facebook.widget.animatablelistview.custom.AnimatingListViewCustomAnimation;
import com.facebook.widget.animatablelistview.custom.InterceptAnimation;
import com.facebook.widget.listview.BetterListView;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: android.permission.READ_CALL_LOG */
public class AnimatingListAdapter<T> extends BaseAdapter {
    private static final Class<?> f20457a = AnimatingListAdapter.class;
    private final Context f20458b;
    public final BetterListView f20459c;
    private final AbstractFbErrorReporter f20460d;
    public final Map<T, AnimatingItemInfo<T>> f20461e;
    private final AnimatingListMultiItemRecycler<T> f20462f;
    public final OnPreDrawListener f20463g;
    private ItemBasedListAdapter<T> f20464h;
    private DataSetObservable f20465i;
    private boolean f20466j;
    private State f20467k = State.STEADY_STATE;
    private final List<AnimatingListTransaction<T>> f20468l;
    private AnimatingListTransaction<T> f20469m;
    private ImmutableList<T> f20470n;
    public ImmutableList<T> f20471o;
    private Set<AnimatorListener> f20472p = Sets.a();
    private Set<AnimatorUpdateListener> f20473q = Sets.a();
    private boolean f20474r;
    public long f20475s = 300;
    @Nullable
    public Interpolator f20476t;
    private AnimatingListTransactionBuilder<T> f20477u;
    private AnimatorSet f20478v;
    public List<AnimatingListViewCustomAnimation> f20479w;
    private final Optional<AnalyticsTagger> f20480x;

    /* compiled from: android.permission.READ_CALL_LOG */
    class C24081 implements RecyclerListener {
        final /* synthetic */ AnimatingListAdapter f20452a;

        C24081(AnimatingListAdapter animatingListAdapter) {
            this.f20452a = animatingListAdapter;
        }

        public void onMovedToScrapHeap(View view) {
            this.f20452a.m20035a(view);
        }
    }

    /* compiled from: android.permission.READ_CALL_LOG */
    class C24092 implements OnPreDrawListener {
        final /* synthetic */ AnimatingListAdapter f20453a;

        C24092(AnimatingListAdapter animatingListAdapter) {
            this.f20453a = animatingListAdapter;
        }

        public boolean onPreDraw() {
            AnimatingListAdapter animatingListAdapter = this.f20453a;
            animatingListAdapter.f20459c.getViewTreeObserver().removeOnPreDrawListener(animatingListAdapter.f20463g);
            for (InterceptAnimation b : animatingListAdapter.f20479w) {
                b.m20074b();
            }
            return false;
        }
    }

    /* compiled from: android.permission.READ_CALL_LOG */
    class C24103 implements AnimatorUpdateListener {
        final /* synthetic */ AnimatingListAdapter f20454a;

        C24103(AnimatingListAdapter animatingListAdapter) {
            this.f20454a = animatingListAdapter;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f20454a.f20459c.d();
        }
    }

    /* compiled from: android.permission.READ_CALL_LOG */
    public class C24114 implements AnimatorListener {
        final /* synthetic */ AnimatingListAdapter f20455a;

        public C24114(AnimatingListAdapter animatingListAdapter) {
            this.f20455a = animatingListAdapter;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f20455a.m20034a(animator);
        }

        public void onAnimationCancel(Animator animator) {
            this.f20455a.m20039b(animator);
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: android.permission.READ_CALL_LOG */
    enum State {
        STEADY_STATE,
        WAITING_FOR_ANIMATION_TO_FINISH
    }

    public AnimatingListAdapter(Context context, BetterListView betterListView, ItemBasedListAdapter<T> itemBasedListAdapter, FbErrorReporter fbErrorReporter, @Nullable AnalyticsTagger analyticsTagger) {
        this.f20458b = context;
        this.f20459c = betterListView;
        this.f20464h = itemBasedListAdapter;
        this.f20462f = new AnimatingListMultiItemRecycler(this.f20464h);
        this.f20460d = fbErrorReporter;
        this.f20461e = new MapMaker().e().l();
        this.f20468l = Lists.a();
        this.f20470n = RegularImmutableList.a;
        this.f20471o = RegularImmutableList.a;
        this.f20472p.add(new C24114(this));
        this.f20479w = Lists.a();
        this.f20459c.setRecyclerListener(new C24081(this));
        this.f20480x = Optional.fromNullable(analyticsTagger);
        this.f20463g = new C24092(this);
        this.f20473q.add(new C24103(this));
    }

    private Animator m20026g(AnimatingListMutation<T> animatingListMutation) {
        InterceptAnimation interceptAnimation = (InterceptAnimation) animatingListMutation.f20487c.get();
        this.f20479w.add(interceptAnimation);
        Animator animator = interceptAnimation.f20525b;
        if (animatingListMutation.f20485a != MutationType.CUSTOM) {
            throw new IllegalArgumentException("Unknown mutation type " + animatingListMutation.f20485a);
        } else if (animator instanceof AnimatorSet) {
            ArrayList childAnimations = ((AnimatorSet) animator).getChildAnimations();
            int size = childAnimations.size();
            for (int i = 0; i < size; i++) {
                Animator animator2 = (Animator) childAnimations.get(i);
                if (animator2 instanceof ObjectAnimator) {
                    ObjectAnimator objectAnimator = (ObjectAnimator) animator2;
                    for (AnimatorUpdateListener addUpdateListener : this.f20473q) {
                        objectAnimator.addUpdateListener(addUpdateListener);
                    }
                }
            }
            return animator;
        } else if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            for (AnimatorUpdateListener addUpdateListener2 : this.f20473q) {
                valueAnimator.addUpdateListener(addUpdateListener2);
            }
            return animator;
        } else {
            BLog.b(f20457a, "Unsupported animation: " + interceptAnimation);
            return null;
        }
    }

    protected void m20037a(List<T> list) {
        this.f20470n = ImmutableList.copyOf(list);
    }

    public final AnimatingListTransactionBuilder<T> m20033a() {
        Preconditions.checkState(this.f20477u == null, "Already a pending transaction");
        this.f20477u = new AnimatingListTransactionBuilder(this);
        return this.f20477u;
    }

    final void m20036a(AnimatingListTransactionBuilder<?> animatingListTransactionBuilder, ImmutableList<T> immutableList, ImmutableList<T> immutableList2, ImmutableList<AnimatingListMutation<T>> immutableList3) {
        Preconditions.checkState(this.f20477u == animatingListTransactionBuilder, "Wrong transaction");
        this.f20468l.add(new AnimatingListTransaction(immutableList3, immutableList, immutableList2, animatingListTransactionBuilder.f20502h, animatingListTransactionBuilder.f20503i));
        this.f20471o = immutableList2;
        this.f20477u = null;
        m20027j();
    }

    public final void m20038b() {
        m20037a((List) RegularImmutableList.a);
        this.f20471o = RegularImmutableList.a;
        this.f20468l.clear();
        this.f20478v = null;
        this.f20477u = null;
        m20031p();
        this.f20467k = State.STEADY_STATE;
    }

    public ImmutableList<T> m20040d() {
        return this.f20470n;
    }

    public final ImmutableList<T> m20041e() {
        return this.f20471o;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean areAllItemsEnabled() {
        return this.f20464h.areAllItemsEnabled();
    }

    public boolean isEnabled(int i) {
        return this.f20464h.m20064c(getItem(i));
    }

    public int getViewTypeCount() {
        return this.f20464h.getViewTypeCount() + 1;
    }

    public int getItemViewType(int i) {
        if (m20021b(i)) {
            return this.f20464h.getViewTypeCount();
        }
        Object item = getItem(i);
        if (item == null) {
            return -1;
        }
        return this.f20464h.m20061a(item);
    }

    public int getCount() {
        return m20040d().size();
    }

    public T getItem(int i) {
        if (i >= m20040d().size()) {
            return null;
        }
        return m20040d().get(i);
    }

    public long getItemId(int i) {
        Object item = getItem(i);
        if (item != null) {
            return this.f20464h.m20063b(item);
        }
        return Long.MIN_VALUE;
    }

    public boolean isEmpty() {
        return getCount() == 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        view = (AnimatingItemView) view;
        Object item = getItem(i);
        if (item == null) {
            this.f20460d.a(SoftError.b(f20457a.getSimpleName() + " (t2841974)", "Null item for position " + i + "/" + getCount()));
            return new AnimatingItemView(this.f20458b);
        }
        View view2;
        if (view == null) {
            view = new AnimatingItemView(this.f20458b);
            view2 = null;
        } else {
            view2 = view.getChildAt(0);
        }
        AnimatingListMutation a = m20017a(i);
        if (a != null) {
            ViewGroup animatingListMultiItemContainerView;
            if (view2 == null) {
                animatingListMultiItemContainerView = new AnimatingListMultiItemContainerView(this.f20458b);
                view.addView(animatingListMultiItemContainerView);
            } else {
                AnimatingListMultiItemContainerView animatingListMultiItemContainerView2 = (AnimatingListMultiItemContainerView) view2;
                this.f20462f.m20044a(animatingListMultiItemContainerView2);
            }
            for (int i2 = 0; i2 < a.f20486b.size(); i2++) {
                Object item2 = getItem(i + i2);
                AnimatingListMultiItemRecycler animatingListMultiItemRecycler = this.f20462f;
                int a2 = animatingListMultiItemRecycler.f20481a.m20061a(item2);
                List list = (List) animatingListMultiItemRecycler.f20482b.get(a2);
                View view3 = null;
                if (!(list == null || list.isEmpty())) {
                    view3 = (View) list.remove(list.size() - 1);
                    animatingListMultiItemRecycler.f20484d--;
                }
                View a3 = animatingListMultiItemRecycler.f20481a.m20062a(item2, view3, animatingListMultiItemContainerView);
                if (!(view3 == null || a3 == view3)) {
                    list.add(view3);
                    animatingListMultiItemRecycler.f20484d++;
                }
                animatingListMultiItemRecycler.f20483c.put(a3, Integer.valueOf(a2));
                animatingListMultiItemContainerView.addView(a3);
            }
        } else if (view2 == null) {
            view.addView(this.f20464h.m20062a(item, null, view));
        } else {
            View a4 = this.f20464h.m20062a(item, view2, view);
            if (a4 != view2) {
                view.removeAllViews();
                view.addView(a4);
            }
        }
        if (view != null && this.f20480x.isPresent()) {
            AnalyticsTagger analyticsTagger = (AnalyticsTagger) this.f20480x.get();
            view.setTag(2131558561, AnalyticsTagger.b(viewGroup));
        }
        view.setItemInfo((AnimatingItemInfo) this.f20461e.get(item));
        return view;
    }

    public void notifyDataSetChanged() {
        throw new UnsupportedOperationException("AnimatingListAdapter does not support notifyDataSetChanged");
    }

    public void notifyDataSetInvalidated() {
        throw new UnsupportedOperationException("AnimatingListAdapter does not support notifyDataSetInvalidated");
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        throw new UnsupportedOperationException("AnimatingListAdapter does not support getDropDownView");
    }

    private void m20027j() {
        if (this.f20467k == State.STEADY_STATE && !this.f20468l.isEmpty()) {
            this.f20469m = (AnimatingListTransaction) this.f20468l.remove(0);
            m20037a((List) this.f20469m.f20490b);
            this.f20466j = true;
            m20032q();
            m20042h();
            if (this.f20469m != null) {
                List a = Lists.a();
                ImmutableList immutableList = this.f20469m.f20489a;
                int size = immutableList.size();
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    AnimatingListMutation animatingListMutation = (AnimatingListMutation) immutableList.get(i);
                    MutationType mutationType = animatingListMutation.f20485a;
                    if (mutationType == MutationType.ADD_WITH_ANIMATION_UP || mutationType == MutationType.ADD_WITH_ANIMATION_DOWN || mutationType == MutationType.REMOVE_WITH_ANIMATION_DOWN || mutationType == MutationType.REMOVE_WITH_ANIMATION_UP || mutationType == MutationType.FADE_IN || mutationType == MutationType.FADE_OUT || mutationType == MutationType.CUSTOM) {
                        z = true;
                    }
                    m20018a(a, animatingListMutation, mutationType);
                }
                this.f20466j = false;
                if (!z) {
                    this.f20469m = null;
                    this.f20467k = State.STEADY_STATE;
                    m20027j();
                } else if (this.f20474r) {
                    this.f20467k = State.WAITING_FOR_ANIMATION_TO_FINISH;
                } else {
                    if (!this.f20479w.isEmpty()) {
                        this.f20459c.getViewTreeObserver().addOnPreDrawListener(this.f20463g);
                    }
                    this.f20478v = new AnimatorSet();
                    for (AnimatorListener addListener : this.f20472p) {
                        this.f20478v.addListener(addListener);
                    }
                    this.f20478v.playTogether(a);
                    this.f20478v.start();
                    this.f20467k = State.WAITING_FOR_ANIMATION_TO_FINISH;
                }
            }
        }
    }

    private void m20018a(List<Animator> list, AnimatingListMutation<T> animatingListMutation, MutationType mutationType) {
        switch (mutationType) {
            case ADD_WITH_ANIMATION_UP:
                list.add(m20019b((AnimatingListMutation) animatingListMutation));
                return;
            case ADD_WITH_ANIMATION_DOWN:
                list.add(m20014a((AnimatingListMutation) animatingListMutation));
                return;
            case REMOVE_WITH_ANIMATION_UP:
                list.add(m20023d(animatingListMutation));
                return;
            case REMOVE_WITH_ANIMATION_DOWN:
                list.add(m20022c(animatingListMutation));
                return;
            case FADE_IN:
                list.add(m20024e(animatingListMutation));
                return;
            case FADE_OUT:
                list.add(m20025f(animatingListMutation));
                return;
            case CUSTOM:
                list.add(m20026g(animatingListMutation));
                return;
            default:
                return;
        }
    }

    private ObjectAnimator m20014a(AnimatingListMutation<T> animatingListMutation) {
        return m20015a((AnimatingListMutation) animatingListMutation, 0.0f, -1.0f);
    }

    private ObjectAnimator m20019b(AnimatingListMutation<T> animatingListMutation) {
        return m20015a((AnimatingListMutation) animatingListMutation, 0.0f, 1.0f);
    }

    private ObjectAnimator m20022c(AnimatingListMutation<T> animatingListMutation) {
        return m20015a((AnimatingListMutation) animatingListMutation, 1.0f, 0.0f);
    }

    private ObjectAnimator m20023d(AnimatingListMutation<T> animatingListMutation) {
        return m20015a((AnimatingListMutation) animatingListMutation, -1.0f, 0.0f);
    }

    private ObjectAnimator m20024e(AnimatingListMutation<T> animatingListMutation) {
        return m20020b(animatingListMutation, 0.0f, 1.0f);
    }

    private ObjectAnimator m20025f(AnimatingListMutation<T> animatingListMutation) {
        return m20020b(animatingListMutation, 1.0f, 0.0f);
    }

    private ObjectAnimator m20015a(AnimatingListMutation<T> animatingListMutation, float f, float f2) {
        return m20016a((AnimatingListMutation) animatingListMutation, f, f2, "animationOffset");
    }

    private ObjectAnimator m20020b(AnimatingListMutation<T> animatingListMutation, float f, float f2) {
        return m20016a((AnimatingListMutation) animatingListMutation, f, f2, "alpha");
    }

    private ObjectAnimator m20016a(AnimatingListMutation<T> animatingListMutation, float f, float f2, String str) {
        AnimatingItemInfo animatingItemInfo;
        int i = 1;
        List list = animatingListMutation.f20486b;
        if (list == null) {
            animatingItemInfo = null;
        } else {
            boolean z;
            if (list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            Preconditions.checkState(z);
            animatingItemInfo = (AnimatingItemInfo) this.f20461e.get(list.get(0));
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(animatingItemInfo, str, new float[]{f, f2});
        ofFloat.setDuration(m20028l());
        TimeInterpolator m = m20029m();
        if (m != null) {
            ofFloat.setInterpolator(m);
        }
        for (AnimatorUpdateListener addUpdateListener : this.f20473q) {
            ofFloat.addUpdateListener(addUpdateListener);
        }
        if (animatingListMutation.m20045c() > 1) {
            while (i < animatingListMutation.f20486b.size()) {
                ((AnimatingItemInfo) this.f20461e.get(animatingListMutation.f20486b.get(i))).setAnimationOffset(0.0f);
                i++;
            }
        }
        return ofFloat;
    }

    private long m20028l() {
        return this.f20469m.f20492d;
    }

    @Nullable
    private Interpolator m20029m() {
        return this.f20469m.f20493e;
    }

    public final void m20034a(Animator animator) {
        if (animator == this.f20478v && this.f20467k == State.WAITING_FOR_ANIMATION_TO_FINISH) {
            m20030n();
        }
    }

    public final void m20039b(Animator animator) {
        if (animator == this.f20478v && this.f20467k == State.WAITING_FOR_ANIMATION_TO_FINISH) {
            m20030n();
        }
    }

    private void m20030n() {
        this.f20459c.getViewTreeObserver().removeOnPreDrawListener(this.f20463g);
        for (InterceptAnimation interceptAnimation : this.f20479w) {
            interceptAnimation.f20528e = false;
            InterceptAnimation.m20073e(interceptAnimation);
        }
        this.f20479w.clear();
        m20037a((List) this.f20469m.f20491c);
        m20032q();
        m20042h();
        m20031p();
        this.f20478v = null;
        this.f20467k = State.STEADY_STATE;
        m20027j();
    }

    private void m20031p() {
        this.f20469m = null;
        if (this.f20466j) {
            this.f20466j = false;
            this.f20460d.a(SoftError.b(f20457a.getSimpleName() + " (t2693685)", "Cannot set currentTransaction to null while using currentTranscation."));
        }
    }

    private void m20032q() {
        ImmutableList d = m20040d();
        int size = d.size();
        for (int i = 0; i < size; i++) {
            Object obj = d.get(i);
            AnimatingItemInfo animatingItemInfo = (AnimatingItemInfo) this.f20461e.get(obj);
            if (animatingItemInfo == null) {
                this.f20461e.put(obj, new AnimatingItemInfo());
            } else {
                animatingItemInfo.setAnimationOffset(1.0f);
            }
        }
    }

    protected synchronized void m20042h() {
        if (this.f20465i != null) {
            this.f20465i.notifyChanged();
        }
    }

    public synchronized void m20043i() {
        if (this.f20465i != null) {
            this.f20465i.notifyInvalidated();
        }
    }

    public synchronized void registerDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.f20465i == null) {
            this.f20465i = new DataSetObservable();
        }
        this.f20465i.registerObserver(dataSetObserver);
    }

    public synchronized void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.f20465i != null) {
            this.f20465i.unregisterObserver(dataSetObserver);
        }
    }

    private AnimatingListMutation<T> m20017a(int i) {
        if (this.f20469m == null) {
            return null;
        }
        ImmutableList immutableList = this.f20469m.f20489a;
        int size = immutableList.size();
        for (int i2 = 0; i2 < size; i2++) {
            AnimatingListMutation<T> animatingListMutation = (AnimatingListMutation) immutableList.get(i2);
            if (animatingListMutation.f20488d == i && animatingListMutation.m20045c() > 1) {
                return animatingListMutation;
            }
        }
        return null;
    }

    private boolean m20021b(int i) {
        return m20017a(i) != null;
    }

    @VisibleForTesting
    final void m20035a(View view) {
        if (view instanceof AnimatingItemView) {
            View childAt = ((AnimatingItemView) view).getChildAt(0);
            if (childAt instanceof AnimatingListMultiItemContainerView) {
                this.f20462f.m20044a((AnimatingListMultiItemContainerView) childAt);
            }
        }
    }
}
