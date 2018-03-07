package com.facebook.feedplugins.attachments.poll;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.HasFeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feedplugins.attachments.poll.DefaultPollDisplayAndClickListenerBuilder.C19732;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.HasFeedUnit;
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
import com.facebook.resources.ui.FbTextView;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: THIS_AD_IS_USEFUL */
public class PollSeeMorePartDefinition<E extends HasInvalidate & HasPositionInformation & HasPersistentState & HasFeedListType> extends MultiRowSinglePartDefinition<Props, Void, E, FbTextView> {
    public static final ViewType f22713a = ViewType.a(2130906340);
    private static PollSeeMorePartDefinition f22714e;
    private static final Object f22715f = new Object();
    private final ClickListenerPartDefinition f22716b;
    private final BackgroundPartDefinition f22717c;
    private final DefaultPollDisplayAndClickListenerBuilder f22718d;

    @Immutable
    /* compiled from: THIS_AD_IS_USEFUL */
    public class Props implements HasFeedProps<GraphQLStory>, HasFeedUnit {
        public final String f22709a;
        public final FeedProps<GraphQLStoryAttachment> f22710b;
        public final boolean f22711c;
        public final FeedProps<GraphQLStory> f22712d;

        public Props(String str, FeedProps<GraphQLStoryAttachment> feedProps, boolean z) {
            this.f22709a = str;
            this.f22710b = feedProps;
            this.f22712d = AttachmentProps.e(feedProps);
            this.f22711c = z;
        }

        public final FeedUnit m25337c() {
            return (FeedUnit) this.f22712d.a;
        }

        public final FeedProps<GraphQLStory> m25338f() {
            return this.f22712d;
        }
    }

    private static PollSeeMorePartDefinition m25340b(InjectorLike injectorLike) {
        return new PollSeeMorePartDefinition(ClickListenerPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike), DefaultPollDisplayAndClickListenerBuilder.m25295a(injectorLike));
    }

    public final Object m25342a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        subParts.a(this.f22717c, PollItemBackgroundStyler.m25321a(props.f22711c, props.f22712d, this.f22718d));
        subParts.a(this.f22716b, new C19732(this.f22718d, props.f22710b));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m25343a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1340387925);
        ((FbTextView) view).setText(((Props) obj).f22709a);
        Logger.a(8, EntryType.MARK_POP, 1405365370, a);
    }

    public final boolean m25344a(Object obj) {
        return !StringUtil.a(((Props) obj).f22709a);
    }

    public final ViewType<FbTextView> m25341a() {
        return f22713a;
    }

    public static PollSeeMorePartDefinition m25339a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PollSeeMorePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22715f) {
                PollSeeMorePartDefinition pollSeeMorePartDefinition;
                if (a2 != null) {
                    pollSeeMorePartDefinition = (PollSeeMorePartDefinition) a2.a(f22715f);
                } else {
                    pollSeeMorePartDefinition = f22714e;
                }
                if (pollSeeMorePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25340b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22715f, b3);
                        } else {
                            f22714e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pollSeeMorePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PollSeeMorePartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, BackgroundPartDefinition backgroundPartDefinition, DefaultPollDisplayAndClickListenerBuilder defaultPollDisplayAndClickListenerBuilder) {
        this.f22716b = clickListenerPartDefinition;
        this.f22717c = backgroundPartDefinition;
        this.f22718d = defaultPollDisplayAndClickListenerBuilder;
    }
}
