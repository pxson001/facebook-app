package com.facebook.reaction.feed.rows.subparts;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.GetEntityFbLinkGraphQL;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.LinkableTextWithEntities;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView.LinkableEntityListener;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: android_native_article_webview_perf */
public class ReactionTextWithEntitiesPartDefinition extends BaseSinglePartDefinition<Props, State, CanLaunchReactionIntent, TextWithEntitiesView> {
    private static ReactionTextWithEntitiesPartDefinition f19443b;
    private static final Object f19444c = new Object();
    public final ReactionIntentFactory f19445a;

    /* compiled from: android_native_article_webview_perf */
    public class Props {
        @Nullable
        public final LinkableTextWithEntities f19439a;
        public final String f19440b;
        public final String f19441c;

        public Props(@Nullable LinkableTextWithEntities linkableTextWithEntities, String str, String str2) {
            this.f19439a = linkableTextWithEntities;
            this.f19440b = str;
            this.f19441c = str2;
        }
    }

    /* compiled from: android_native_article_webview_perf */
    public class State {
        public final LinkableEntityListener f19442a;

        public State(LinkableEntityListener linkableEntityListener) {
            this.f19442a = linkableEntityListener;
        }
    }

    private static ReactionTextWithEntitiesPartDefinition m23424b(InjectorLike injectorLike) {
        return new ReactionTextWithEntitiesPartDefinition(ReactionIntentFactory.m22683a(injectorLike));
    }

    public final Object m23425a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final Props props = (Props) obj;
        final CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        return new State(new LinkableEntityListener(this) {
            final /* synthetic */ ReactionTextWithEntitiesPartDefinition f19438c;

            public final void m23422a(GetEntityFbLinkGraphQL getEntityFbLinkGraphQL) {
                canLaunchReactionIntent.mo695a(props.f19440b, props.f19441c, this.f19438c.f19445a.m22734a(getEntityFbLinkGraphQL));
            }
        });
    }

    public final /* bridge */ /* synthetic */ void m23426a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 734369563);
        Props props = (Props) obj;
        State state = (State) obj2;
        TextWithEntitiesView textWithEntitiesView = (TextWithEntitiesView) view;
        if (props.f19439a != null) {
            textWithEntitiesView.setVisibility(0);
            textWithEntitiesView.a(props.f19439a, state.f19442a);
        } else {
            textWithEntitiesView.setVisibility(8);
        }
        Logger.a(8, EntryType.MARK_POP, 374439302, a);
    }

    @Inject
    public ReactionTextWithEntitiesPartDefinition(ReactionIntentFactory reactionIntentFactory) {
        this.f19445a = reactionIntentFactory;
    }

    public static ReactionTextWithEntitiesPartDefinition m23423a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionTextWithEntitiesPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19444c) {
                ReactionTextWithEntitiesPartDefinition reactionTextWithEntitiesPartDefinition;
                if (a2 != null) {
                    reactionTextWithEntitiesPartDefinition = (ReactionTextWithEntitiesPartDefinition) a2.a(f19444c);
                } else {
                    reactionTextWithEntitiesPartDefinition = f19443b;
                }
                if (reactionTextWithEntitiesPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23424b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19444c, b3);
                        } else {
                            f19443b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionTextWithEntitiesPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
