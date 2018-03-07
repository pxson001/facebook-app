package com.facebook.feedplugins.graphqlstory.footer;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.thirdparty.instagram.InstagramEntryPoint;
import com.facebook.feed.thirdparty.instagram.InstagramUtils;
import com.facebook.feedplugins.base.blingbar.BlingBarPartDefinition;
import com.facebook.feedplugins.base.blingbar.BlingBarPartDefinition.Props;
import com.facebook.feedplugins.base.blingbar.BlingBarRootPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.ui.InstagramBlingBarView;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Social Prompt invite friends GraphQL mutation failed */
public class InstagramBlingBarPartDefinition<E extends HasPositionInformation & HasPersistentState> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, InstagramBlingBarView> {
    public static final ViewType f23243a = new C20071();
    private static InstagramBlingBarPartDefinition f23244f;
    private static final Object f23245g = new Object();
    public final InstagramUtils f23246b;
    private final BlingBarPartDefinition f23247c;
    private final ClickListenerPartDefinition f23248d;
    private final BackgroundPartDefinition f23249e;

    /* compiled from: Social Prompt invite friends GraphQL mutation failed */
    final class C20071 extends ViewType {
        C20071() {
        }

        public final View m25618a(Context context) {
            return new InstagramBlingBarView(context);
        }
    }

    private static InstagramBlingBarPartDefinition m25620b(InjectorLike injectorLike) {
        return new InstagramBlingBarPartDefinition(BackgroundPartDefinition.a(injectorLike), InstagramUtils.a(injectorLike), BlingBarPartDefinition.m25426a(injectorLike), ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m25622a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f23249e, new StylingData(feedProps, BlingBarRootPartDefinition.f22896a));
        subParts.a(this.f23247c, new Props(feedProps, true));
        subParts.a(2131562039, this.f23248d, new OnClickListener(this) {
            final /* synthetic */ InstagramBlingBarPartDefinition f23242b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 744456810);
                InstagramUtils instagramUtils = this.f23242b.f23246b;
                Context context = view.getContext();
                InstagramEntryPoint instagramEntryPoint = InstagramEntryPoint.Text;
                FeedProps feedProps = feedProps;
                instagramUtils.a(context, instagramEntryPoint, (GraphQLStory) feedProps.a, TrackableFeedProps.a(feedProps));
                Logger.a(2, EntryType.UI_INPUT_END, -262301894, a);
            }
        });
        return null;
    }

    public final /* bridge */ /* synthetic */ void m25623a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1896014832);
        InstagramBlingBarView instagramBlingBarView = (InstagramBlingBarView) view;
        if (this.f23246b.a()) {
            instagramBlingBarView.setLinkText(2131233567);
        } else {
            if (this.f23246b.f() > 0) {
                instagramBlingBarView.f23325b.setText(instagramBlingBarView.getContext().getResources().getString(2131233575, new Object[]{Integer.valueOf(r4)}));
            } else {
                instagramBlingBarView.setLinkText(2131233566);
            }
        }
        Logger.a(8, EntryType.MARK_POP, -1360372935, a);
    }

    public final boolean m25624a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        boolean z = InstagramUtils.a(graphQLStory) && GraphQLStoryUtil.a(graphQLStory) != null && this.f23246b.a(InstagramEntryPoint.Text);
        return z;
    }

    @Inject
    public InstagramBlingBarPartDefinition(BackgroundPartDefinition backgroundPartDefinition, InstagramUtils instagramUtils, BlingBarPartDefinition blingBarPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f23246b = instagramUtils;
        this.f23247c = blingBarPartDefinition;
        this.f23248d = clickListenerPartDefinition;
        this.f23249e = backgroundPartDefinition;
    }

    public static InstagramBlingBarPartDefinition m25619a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstagramBlingBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23245g) {
                InstagramBlingBarPartDefinition instagramBlingBarPartDefinition;
                if (a2 != null) {
                    instagramBlingBarPartDefinition = (InstagramBlingBarPartDefinition) a2.a(f23245g);
                } else {
                    instagramBlingBarPartDefinition = f23244f;
                }
                if (instagramBlingBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25620b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23245g, b3);
                        } else {
                            f23244f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = instagramBlingBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m25621a() {
        return f23243a;
    }
}
