package com.facebook.ufiservices.flyout;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbui.draggable.Direction;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.feed.ProfileListParamType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ufiservices.flyout.UFIProfileListFragmentGraphQLInterfaces.UFIProfileListFragmentGraphQL;
import com.facebook.ufiservices.flyout.UFIProfileListFragmentGraphQLModels.UFIProfileListFragmentGraphQLModel;
import com.facebook.ufiservices.ui.ProfileListAdapter;
import com.facebook.ufiservices.ui.ProfileListFragment;
import com.facebook.widget.listeners.BaseAnimationListener;
import com.facebook.widget.listview.BetterListView;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: customization_value */
public class UFIProfileListFragment extends ProfileListFragment<UFIProfileListFragmentGraphQL> implements UFIContentFragment {
    private static final CallerContext f18122a = CallerContext.a(UFIProfileListFragment.class, "story_feedback_flyout");
    public FlyoutUtil f18123b;
    public PopoverFragmentContainer f18124c;
    private ProfileListParams f18125d;

    /* compiled from: customization_value */
    class C13161 implements OnClickListener {
        final /* synthetic */ UFIProfileListFragment f18109a;

        C13161(UFIProfileListFragment uFIProfileListFragment) {
            this.f18109a = uFIProfileListFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 822673582);
            this.f18109a.f18124c.O_();
            Logger.a(2, EntryType.UI_INPUT_END, 1415411430, a);
        }
    }

    /* compiled from: customization_value */
    class C13172 extends Animation {
        final /* synthetic */ UFIProfileListFragment f18110a;

        C13172(UFIProfileListFragment uFIProfileListFragment) {
            this.f18110a = uFIProfileListFragment;
        }
    }

    /* compiled from: customization_value */
    class C13183 extends BaseAnimationListener {
        final /* synthetic */ UFIProfileListFragment f18111a;

        C13183(UFIProfileListFragment uFIProfileListFragment) {
            this.f18111a = uFIProfileListFragment;
        }

        public void onAnimationEnd(Animation animation) {
            this.f18111a.f18124c.dC_();
        }
    }

    /* compiled from: customization_value */
    /* synthetic */ class C13194 {
        static final /* synthetic */ int[] f18112a = new int[Direction.values().length];

        static {
            try {
                f18112a[Direction.UP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18112a[Direction.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static void m26647a(Object obj, Context context) {
        ((UFIProfileListFragment) obj).f18123b = FlyoutUtil.m26559a(FbInjector.get(context));
    }

    public final void mo1384c(@Nullable Bundle bundle) {
        super.mo1384c(bundle);
        Class cls = UFIProfileListFragment.class;
        m26647a((Object) this, getContext());
        this.f18125d = (ProfileListParams) this.s.getParcelable("profileListParams");
        this.f18124c = (PopoverFragmentContainer) this.G;
    }

    public final void m26650a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        View e = e(2131562226);
        View e2 = e(2131562229);
        TextView textView = (TextView) e(2131562228);
        if (this.f18125d.f18094f) {
            if (this.f18125d.f18096h != null) {
                textView.setText(this.f18125d.f18096h);
            }
            if (!this.f18125d.f18093e) {
                e.setVisibility(8);
                e2.setVisibility(4);
            }
        } else {
            OnClickListener c13161 = new C13161(this);
            View e3 = e(2131562227);
            e.setOnClickListener(c13161);
            e3.setFocusable(true);
            e3.setVisibility(0);
            textView.setFocusable(true);
        }
        if (this.f18125d.f18092d == ProfileListParamType.PROFILES) {
            e(2131562214).setVisibility(0);
        }
    }

    public final Animation m26648a(int i, boolean z, int i2) {
        Animation animation = null;
        if (!this.f18123b.f18076a) {
            animation = new C13172(this);
            animation.setDuration(0);
        } else if (i2 != 0) {
            animation = AnimationUtils.loadAnimation(getContext(), i2);
        }
        if (animation != null) {
            animation.setAnimationListener(new C13183(this));
        }
        return animation;
    }

    protected final List<UFIProfileListFragmentGraphQL> mo1380a(List<GraphQLActor> list) {
        List<UFIProfileListFragmentGraphQL> arrayList = new ArrayList();
        for (GraphQLActor graphQLActor : list) {
            UFIProfileListFragmentGraphQLModel uFIProfileListFragmentGraphQLModel = null;
            if (graphQLActor != null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = UFIProfileListConverter.m26639a(flatBufferBuilder, graphQLActor);
                if (a != 0) {
                    flatBufferBuilder.d(a);
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    uFIProfileListFragmentGraphQLModel = new UFIProfileListFragmentGraphQLModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }
            arrayList.add(uFIProfileListFragmentGraphQLModel);
        }
        return arrayList;
    }

    public final BaseAdapter au() {
        return new ProfileListAdapter(this.am);
    }

    public final boolean mo1354b() {
        return false;
    }

    public final void mo1355e() {
    }

    public final void aq() {
    }

    protected final int av() {
        return 2130904461;
    }

    public final View at() {
        return null;
    }

    public final void mo1353b(View view) {
    }

    public final String ar() {
        return "flyout_likers_animation_perf";
    }

    public final void as() {
    }

    protected final CallerContext aw() {
        return f18122a;
    }

    public final boolean mo1348a(float f, float f2, Direction direction) {
        BetterListView betterListView = this.f18120h;
        switch (C13194.f18112a[direction.ordinal()]) {
            case 1:
                return betterListView.isAtBottom();
            case 2:
                return betterListView.a();
            default:
                return false;
        }
    }
}
