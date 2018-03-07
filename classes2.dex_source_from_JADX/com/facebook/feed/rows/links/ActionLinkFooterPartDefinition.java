package com.facebook.feed.rows.links;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.StoryActionLinkHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.links.AttachmentLinkLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: feedback_reactions_footer_interaction */
public class ActionLinkFooterPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, State, HasPositionInformation, View> {
    public static final ViewType f24386a = ViewType.m15456a(2130903079);
    private static final PaddingStyle f24387b = PaddingStyle.f13071a;
    private static ActionLinkFooterPartDefinition f24388f;
    private static final Object f24389g = new Object();
    private final BackgroundPartDefinition f24390c;
    public final AttachmentLinkLauncher f24391d;
    public final Resources f24392e;

    private static ActionLinkFooterPartDefinition m32694b(InjectorLike injectorLike) {
        return new ActionLinkFooterPartDefinition(BackgroundPartDefinition.m19135a(injectorLike), AttachmentLinkLauncher.m32296a(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        subParts.mo2756a(this.f24390c, new StylingData(feedProps, f24387b));
        GraphQLStoryActionLink a = StoryActionLinkHelper.m28072a(graphQLStory, -301083314);
        return a == null ? new State(null, null, false) : new State(new 1(this, StringFormatUtil.formatStrLocaleSafe(FBLinks.ej, "shared_feed_story")), a.aB(), true);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1674290667);
        State state = (State) obj2;
        view.setOnClickListener(state.a);
        TextView textView = (TextView) view.findViewById(2131558966);
        textView.setText(state.b);
        if (state.c) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), textView.getPaddingTop());
        }
        textView.setTextSize(0, (float) this.f24392e.getDimensionPixelSize(2131427400));
        Logger.a(8, EntryType.MARK_POP, 453251053, a);
    }

    public final boolean m32698a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return StoryProps.m27463k(feedProps) && StoryActionLinkHelper.m28072a((GraphQLStory) feedProps.f13444a, -301083314) != null;
    }

    public static ActionLinkFooterPartDefinition m32693a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ActionLinkFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24389g) {
                ActionLinkFooterPartDefinition actionLinkFooterPartDefinition;
                if (a2 != null) {
                    actionLinkFooterPartDefinition = (ActionLinkFooterPartDefinition) a2.mo818a(f24389g);
                } else {
                    actionLinkFooterPartDefinition = f24388f;
                }
                if (actionLinkFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32694b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24389g, b3);
                        } else {
                            f24388f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = actionLinkFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public ActionLinkFooterPartDefinition(BackgroundPartDefinition backgroundPartDefinition, AttachmentLinkLauncher attachmentLinkLauncher, Resources resources) {
        this.f24390c = backgroundPartDefinition;
        this.f24391d = attachmentLinkLauncher;
        this.f24392e = resources;
    }

    public final ViewType mo2547a() {
        return f24386a;
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        view.setOnClickListener(null);
    }
}
