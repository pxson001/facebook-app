package com.facebook.feed.rows.sections.header;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.graphqlstory.header.BulletedHeaderSubtitleFormatter;
import com.facebook.feedplugins.graphqlstory.header.DefaultHeaderTimeInfoFormatter;
import com.facebook.feedplugins.highlighter.FeedHighlighter;
import com.facebook.graphql.model.GraphQLStory;
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
import com.facebook.privacy.ui.DefaultPrivacyScopeResourceResolver;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.widget.text.TextViewWithFallback;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Unset */
public class HeaderSubtitlePartDefinition extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, State, AnyEnvironment, TextViewWithFallback> {
    private static HeaderSubtitlePartDefinition f21160f;
    private static final Object f21161g = new Object();
    private final DefaultHeaderTimeInfoFormatter f21162a;
    private final BulletedHeaderSubtitleFormatter f21163b;
    private final FeedHighlighter f21164c;
    public final DefaultPrivacyScopeResourceResolver f21165d;
    public final GlyphColorizer f21166e;

    /* compiled from: Unset */
    public class State {
        public final CharSequence f21157a;
        public final CharSequence f21158b;
        public final int f21159c;

        public State(CharSequence charSequence, CharSequence charSequence2, int i) {
            this.f21157a = charSequence;
            this.f21158b = charSequence2;
            this.f21159c = i;
        }
    }

    private static HeaderSubtitlePartDefinition m24008b(InjectorLike injectorLike) {
        return new HeaderSubtitlePartDefinition(DefaultHeaderTimeInfoFormatter.a(injectorLike), BulletedHeaderSubtitleFormatter.a(injectorLike), FeedHighlighter.a(injectorLike), DefaultPrivacyScopeResourceResolver.a(injectorLike), GlyphColorizer.a(injectorLike));
    }

    public final Object m24009a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        int i;
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        String a = this.f21162a.a(feedProps);
        CharSequence a2 = this.f21163b.a(feedProps, a);
        CharSequence b = this.f21163b.b(feedProps, a);
        if (FeedHighlighter.a(graphQLStory)) {
            a2 = this.f21164c.a(graphQLStory, a2);
        }
        if (FeedHighlighter.a(graphQLStory)) {
            b = this.f21164c.a(graphQLStory, b);
        }
        if (GraphQLStoryHelper.c(graphQLStory) == null || a2 == null || a2.length() <= 0) {
            i = 0;
        } else {
            i = this.f21165d.a(GraphQLStoryHelper.c(graphQLStory).s());
        }
        return new State(b, a2, i);
    }

    public final /* bridge */ /* synthetic */ void m24010a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 252227939);
        State state = (State) obj2;
        TextViewWithFallback textViewWithFallback = (TextViewWithFallback) view;
        textViewWithFallback.setCompoundDrawablesWithIntrinsicBounds(null, null, this.f21166e.a(state.f21159c, -7235677), null);
        textViewWithFallback.setVisibility(state.f21158b != null ? 0 : 8);
        textViewWithFallback.setText(state.f21158b);
        textViewWithFallback.a = state.f21157a;
        Logger.a(8, EntryType.MARK_POP, 1324854840, a);
    }

    @Inject
    public HeaderSubtitlePartDefinition(DefaultHeaderTimeInfoFormatter defaultHeaderTimeInfoFormatter, BulletedHeaderSubtitleFormatter bulletedHeaderSubtitleFormatter, FeedHighlighter feedHighlighter, DefaultPrivacyScopeResourceResolver defaultPrivacyScopeResourceResolver, GlyphColorizer glyphColorizer) {
        this.f21162a = defaultHeaderTimeInfoFormatter;
        this.f21163b = bulletedHeaderSubtitleFormatter;
        this.f21164c = feedHighlighter;
        this.f21165d = defaultPrivacyScopeResourceResolver;
        this.f21166e = glyphColorizer;
    }

    public static HeaderSubtitlePartDefinition m24007a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderSubtitlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21161g) {
                HeaderSubtitlePartDefinition headerSubtitlePartDefinition;
                if (a2 != null) {
                    headerSubtitlePartDefinition = (HeaderSubtitlePartDefinition) a2.a(f21161g);
                } else {
                    headerSubtitlePartDefinition = f21160f;
                }
                if (headerSubtitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24008b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21161g, b3);
                        } else {
                            f21160f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = headerSubtitlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
