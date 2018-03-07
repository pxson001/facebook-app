package com.facebook.ufiservices.flyout.history;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.fbui.draggable.Direction;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ufiservices.flyout.FlyoutUtil;
import com.facebook.ufiservices.flyout.PopoverFragmentContainer;
import com.facebook.ufiservices.flyout.UFIContentFragment;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ui.edithistory.EditHistoryAdapter;
import com.facebook.ui.edithistory.EditHistoryFragment;
import com.facebook.widget.listeners.BaseAnimationListener;
import com.facebook.widget.listview.BetterListView;

/* compiled from: eventSubscriber is null */
public class CommentEditHistoryFragment extends EditHistoryFragment implements UFIContentFragment {
    public CommentEditHistoryAdapter f15206a;
    public FlyoutUtil f15207b;
    private View f15208c;
    public PopoverFragmentContainer f15209d;
    private boolean f15210e;

    /* compiled from: eventSubscriber is null */
    class C11361 implements OnClickListener {
        final /* synthetic */ CommentEditHistoryFragment f15193a;

        C11361(CommentEditHistoryFragment commentEditHistoryFragment) {
            this.f15193a = commentEditHistoryFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 763371757);
            this.f15193a.kO_().d();
            Logger.a(2, EntryType.UI_INPUT_END, 150347559, a);
        }
    }

    /* compiled from: eventSubscriber is null */
    class C11372 extends Animation {
        final /* synthetic */ CommentEditHistoryFragment f15194a;

        C11372(CommentEditHistoryFragment commentEditHistoryFragment) {
            this.f15194a = commentEditHistoryFragment;
        }
    }

    /* compiled from: eventSubscriber is null */
    class C11383 extends BaseAnimationListener {
        final /* synthetic */ CommentEditHistoryFragment f15195a;

        C11383(CommentEditHistoryFragment commentEditHistoryFragment) {
            this.f15195a = commentEditHistoryFragment;
        }

        public void onAnimationEnd(Animation animation) {
            this.f15195a.f15209d.dC_();
        }
    }

    /* compiled from: eventSubscriber is null */
    /* synthetic */ class C11394 {
        static final /* synthetic */ int[] f15196a = new int[Direction.values().length];

        static {
            try {
                f15196a[Direction.UP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15196a[Direction.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static void m19201a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        CommentEditHistoryFragment commentEditHistoryFragment = (CommentEditHistoryFragment) obj;
        CommentEditHistoryAdapter commentEditHistoryAdapter = new CommentEditHistoryAdapter((TimeFormatUtil) DefaultTimeFormatUtil.a(fbInjector), LinkifyUtil.a(fbInjector));
        FlyoutUtil a = FlyoutUtil.a(fbInjector);
        commentEditHistoryFragment.f15206a = commentEditHistoryAdapter;
        commentEditHistoryFragment.f15207b = a;
    }

    public final void mo1177c(Bundle bundle) {
        super.mo1177c(bundle);
        Class cls = CommentEditHistoryFragment.class;
        m19201a((Object) this, getContext());
        this.f15210e = this.s.getBoolean("standalone");
        this.f15209d = (PopoverFragmentContainer) this.G;
    }

    public final View mo1174a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -701831853);
        this.f15208c = super.mo1174a(layoutInflater, viewGroup, bundle);
        View view = this.f15208c;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 582877989, a);
        return view;
    }

    public final void m19204a(View view, Bundle bundle) {
        if (!this.f15210e) {
            e(2131562090).setVisibility(0);
            e(2131562089).setOnClickListener(new C11361(this));
        }
    }

    public final Animation m19203a(int i, boolean z, int i2) {
        Animation animation = null;
        if (!this.f15207b.a) {
            animation = new C11372(this);
            animation.setDuration(0);
        } else if (i2 != 0) {
            animation = AnimationUtils.loadAnimation(getContext(), i2);
        }
        if (animation != null) {
            animation.setAnimationListener(new C11383(this));
        }
        return animation;
    }

    protected final int au() {
        return 2130904384;
    }

    protected final EditHistoryAdapter av() {
        return this.f15206a;
    }

    public final boolean m19207b() {
        return false;
    }

    public final void m19209e() {
    }

    public final void aq() {
    }

    public final View at() {
        return null;
    }

    public final void m19206b(View view) {
    }

    public final String ar() {
        return "flyout_comments_edit_history_animation_perf";
    }

    public final void as() {
    }

    public final boolean m19205a(float f, float f2, Direction direction) {
        BetterListView betterListView = this.f15199c;
        switch (C11394.f15196a[direction.ordinal()]) {
            case 1:
                return betterListView.isAtBottom();
            case 2:
                return betterListView.a();
            default:
                return false;
        }
    }
}
