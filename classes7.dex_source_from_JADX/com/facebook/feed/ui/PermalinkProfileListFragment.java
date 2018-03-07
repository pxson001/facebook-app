package com.facebook.feed.ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.BaseAdapter;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.feed.ui.PermalinkProfileListFragmentGraphQLInterfaces.PermalinkProfileListFragmentGraphQL;
import com.facebook.feed.ui.PermalinkProfileListFragmentGraphQLModels.PermalinkProfileListFragmentGraphQLModel;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ufiservices.flyout.ProfileListParams;
import com.facebook.ufiservices.ui.ProfileListAdapter;
import com.facebook.ufiservices.ui.ProfileListFragment;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: Trying to add or replace a root tag! */
public class PermalinkProfileListFragment extends ProfileListFragment<PermalinkProfileListFragmentGraphQL> implements AnalyticsFragment {
    private static final CallerContext f21770a = CallerContext.a(PermalinkProfileListFragment.class, "permalink_profile_list");
    public FbTitleBarSupplier f21771b;
    private ProfileListParams f21772c;

    public static void m24350a(Object obj, Context context) {
        ((PermalinkProfileListFragment) obj).f21771b = (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(FbInjector.get(context));
    }

    public final void m24352c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = PermalinkProfileListFragment.class;
        m24350a(this, getContext());
        this.f21772c = (ProfileListParams) this.s.getParcelable("profileListParams");
    }

    protected final List<PermalinkProfileListFragmentGraphQL> m24351a(List<GraphQLActor> list) {
        List<PermalinkProfileListFragmentGraphQL> arrayList = new ArrayList();
        for (GraphQLActor graphQLActor : list) {
            PermalinkProfileListFragmentGraphQLModel permalinkProfileListFragmentGraphQLModel = null;
            if (graphQLActor != null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = PermalinkProfileListConverter.m24349a(flatBufferBuilder, graphQLActor);
                if (a != 0) {
                    flatBufferBuilder.d(a);
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    permalinkProfileListFragmentGraphQLModel = new PermalinkProfileListFragmentGraphQLModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }
            arrayList.add(permalinkProfileListFragmentGraphQLModel);
        }
        return arrayList;
    }

    public final BaseAdapter au() {
        return new ProfileListAdapter(this.am);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -260370755);
        super.mi_();
        ((FbTitleBar) this.f21771b.get()).setTitle(this.f21772c.h);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1728234797, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1301765342);
        ((FbTitleBar) this.f21771b.get()).setTitle("");
        super.mj_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2608918, a);
    }

    protected final int av() {
        return 2130904446;
    }

    public final String am_() {
        return "permalink_profile_list";
    }

    protected final CallerContext aw() {
        return f21770a;
    }
}
