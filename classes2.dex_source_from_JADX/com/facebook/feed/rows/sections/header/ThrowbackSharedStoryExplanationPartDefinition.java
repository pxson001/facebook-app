package com.facebook.feed.rows.sections.header;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.sections.header.ui.ThrowbackSharedStoryExplanationView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLImageAtRange;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetchJewelCount */
public class ThrowbackSharedStoryExplanationPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, State, HasPositionInformation, ThrowbackSharedStoryExplanationView> {
    public static final ViewType f24304a = new C09851();
    public static final CallerContext f24305b = CallerContext.m9061a(ThrowbackSharedStoryExplanationPartDefinition.class, "goodwill_throwback");
    private static ThrowbackSharedStoryExplanationPartDefinition f24306d;
    private static final Object f24307e = new Object();
    private final BackgroundPartDefinition f24308c;

    /* compiled from: fetchJewelCount */
    final class C09851 extends ViewType {
        C09851() {
        }

        public final View mo1995a(Context context) {
            return new ThrowbackSharedStoryExplanationView(context);
        }
    }

    private static ThrowbackSharedStoryExplanationPartDefinition m32642b(InjectorLike injectorLike) {
        return new ThrowbackSharedStoryExplanationPartDefinition(BackgroundPartDefinition.m19135a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        Flattenable flattenable = feedProps.f13444a;
        Builder g = Builder.m19307g();
        g.f13066b = 12.0f;
        subParts.mo2756a(this.f24308c, new StylingData(feedProps, g.m19313i()));
        GraphQLTextWithEntities W = ((GraphQLStory) feedProps.f13444a).m22337W();
        String a = W.mo2911a();
        ImmutableList d = W.m22619d();
        return new State(a, !d.isEmpty() ? ImageUtil.m26990a(((GraphQLImageAtRange) d.get(0)).m23596j().m32375l()) : null);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 932136931);
        State state = (State) obj2;
        ThrowbackSharedStoryExplanationView throwbackSharedStoryExplanationView = (ThrowbackSharedStoryExplanationView) view;
        throwbackSharedStoryExplanationView.b.setText(state.a);
        if (state.b == null) {
            throwbackSharedStoryExplanationView.a.setVisibility(8);
        } else {
            throwbackSharedStoryExplanationView.a.m20507a(state.b, f24305b);
            throwbackSharedStoryExplanationView.a.setVisibility(0);
        }
        Logger.a(8, EntryType.MARK_POP, 1698002255, a);
    }

    public final boolean m32646a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        Object obj2 = (((GraphQLStory) feedProps.f13444a).m22337W() == null || Strings.isNullOrEmpty(((GraphQLStory) feedProps.f13444a).m22337W().mo2911a())) ? null : 1;
        return obj2 != null && StoryProps.m27463k(feedProps);
    }

    public static ThrowbackSharedStoryExplanationPartDefinition m32641a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackSharedStoryExplanationPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24307e) {
                ThrowbackSharedStoryExplanationPartDefinition throwbackSharedStoryExplanationPartDefinition;
                if (a2 != null) {
                    throwbackSharedStoryExplanationPartDefinition = (ThrowbackSharedStoryExplanationPartDefinition) a2.mo818a(f24307e);
                } else {
                    throwbackSharedStoryExplanationPartDefinition = f24306d;
                }
                if (throwbackSharedStoryExplanationPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32642b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24307e, b3);
                        } else {
                            f24306d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackSharedStoryExplanationPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public ThrowbackSharedStoryExplanationPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f24308c = backgroundPartDefinition;
    }

    public final ViewType mo2547a() {
        return f24304a;
    }
}
