package com.facebook.search.results.rows.sections.livefeed;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.highlighter.FeedHighlighter;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActorUtil;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.StoryTextHelper;
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
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.rows.sections.livefeed.ui.LiveFeedHeaderView;
import com.facebook.search.util.TypeaheadRowTitleFormatter;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ufiservices.util.MessageSpannableBuilder;
import com.facebook.widget.text.span.SpanUtils;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PmaColdStartSequence */
public class LiveFeedHeaderPartDefinition extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, State, HasSearchResultsContext, LiveFeedHeaderView> {
    public static final CallerContext f24464a = CallerContext.a(LiveFeedHeaderPartDefinition.class, "graph_search_results_live_conversation_fragment");
    private static LiveFeedHeaderPartDefinition f24465k;
    private static final Object f24466l = new Object();
    public final Context f24467b;
    public final FbUriIntentHandler f24468c;
    public final SecureContextHelper f24469d;
    private final LiveFeedPermalinkListenerProvider f24470e;
    private final TypeaheadRowTitleFormatter f24471f;
    private final MessageSpannableBuilder f24472g;
    private final DefaultTimeFormatUtil f24473h;
    private final FeedHighlighter f24474i;
    public final GraphQLLinkExtractor f24475j;

    /* compiled from: PmaColdStartSequence */
    public class State {
        public Uri f24460a;
        public OnClickListener f24461b;
        public OnClickListener f24462c;
        public CharSequence f24463d;

        public State(Uri uri, OnClickListener onClickListener, OnClickListener onClickListener2, CharSequence charSequence) {
            this.f24460a = uri;
            this.f24461b = onClickListener;
            this.f24462c = onClickListener2;
            this.f24463d = charSequence;
        }
    }

    private static LiveFeedHeaderPartDefinition m27934b(InjectorLike injectorLike) {
        return new LiveFeedHeaderPartDefinition((Context) injectorLike.getInstance(Context.class), FbUriIntentHandler.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (LiveFeedPermalinkListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LiveFeedPermalinkListenerProvider.class), TypeaheadRowTitleFormatter.m10667a(injectorLike), MessageSpannableBuilder.a(injectorLike), DefaultTimeFormatUtil.a(injectorLike), FeedHighlighter.a(injectorLike), GraphQLLinkExtractor.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m27936a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 767182976);
        State state = (State) obj2;
        LiveFeedHeaderView liveFeedHeaderView = (LiveFeedHeaderView) view;
        liveFeedHeaderView.f24078h.a(state.f24460a, f24464a);
        liveFeedHeaderView.setBodyClickListener(state.f24461b);
        liveFeedHeaderView.setActorClickListener(state.f24462c);
        liveFeedHeaderView.setPostBodyText(state.f24463d);
        Logger.a(8, EntryType.MARK_POP, -1982920046, a);
    }

    public final void m27937b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        LiveFeedHeaderView liveFeedHeaderView = (LiveFeedHeaderView) view;
        liveFeedHeaderView.setBodyClickListener(null);
        liveFeedHeaderView.setActorClickListener(null);
        liveFeedHeaderView.setPostBodyText(null);
    }

    public static LiveFeedHeaderPartDefinition m27927a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LiveFeedHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24466l) {
                LiveFeedHeaderPartDefinition liveFeedHeaderPartDefinition;
                if (a2 != null) {
                    liveFeedHeaderPartDefinition = (LiveFeedHeaderPartDefinition) a2.a(f24466l);
                } else {
                    liveFeedHeaderPartDefinition = f24465k;
                }
                if (liveFeedHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27934b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24466l, b3);
                        } else {
                            f24465k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = liveFeedHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public LiveFeedHeaderPartDefinition(Context context, FbUriIntentHandler fbUriIntentHandler, SecureContextHelper secureContextHelper, LiveFeedPermalinkListenerProvider liveFeedPermalinkListenerProvider, TypeaheadRowTitleFormatter typeaheadRowTitleFormatter, MessageSpannableBuilder messageSpannableBuilder, DefaultTimeFormatUtil defaultTimeFormatUtil, FeedHighlighter feedHighlighter, GraphQLLinkExtractor graphQLLinkExtractor) {
        this.f24467b = context;
        this.f24468c = fbUriIntentHandler;
        this.f24469d = secureContextHelper;
        this.f24470e = liveFeedPermalinkListenerProvider;
        this.f24471f = typeaheadRowTitleFormatter;
        this.f24472g = messageSpannableBuilder;
        this.f24473h = defaultTimeFormatUtil;
        this.f24474i = feedHighlighter;
        this.f24475j = graphQLLinkExtractor;
    }

    private State m27926a(FeedProps<GraphQLStory> feedProps, HasSearchResultsContext hasSearchResultsContext) {
        CharSequence a;
        final GraphQLStory graphQLStory = (GraphQLStory) feedProps.a();
        CharSequence string = this.f24467b.getString(2131239036);
        CharSequence string2 = this.f24467b.getString(2131239037);
        CharSequence string3 = this.f24467b.getString(2131239038);
        OnClickListener a2 = this.f24470e.m27969a(graphQLStory, hasSearchResultsContext.mo1248s());
        final GraphQLActor b = StoryActorHelper.b(graphQLStory);
        OnClickListener c25821 = new OnClickListener(this) {
            final /* synthetic */ LiveFeedHeaderPartDefinition f24453c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 966742042);
                if (graphQLStory == null || b == null) {
                    Logger.a(2, EntryType.UI_INPUT_END, -616933504, a);
                    return;
                }
                this.f24453c.f24468c.a(this.f24453c.f24467b, StringFormatUtil.formatStrLocaleSafe(this.f24453c.f24475j.a(b.b(), b.H())));
                LogUtils.a(1307206389, a);
            }
        };
        Uri parse = b == null ? null : Uri.parse(GraphQLActorUtil.c(b));
        Object obj = hasSearchResultsContext.mo1248s().m27098l() == GraphQLGraphSearchResultsDisplayStyle.LATEST ? 1 : null;
        Object obj2 = !Strings.isNullOrEmpty(StoryTextHelper.a(graphQLStory)) ? 1 : null;
        boolean z = obj == null && FeedHighlighter.a(graphQLStory);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(m27929a(b, graphQLStory, z));
        if (b != null && spannableStringBuilder.length() > 0 && b.R()) {
            this.f24471f.m10671a(new SpannableStringBuilder(spannableStringBuilder));
        }
        spannableStringBuilder.setSpan(m27925a(c25821), 0, spannableStringBuilder.length(), 33);
        if (obj2 != null || graphQLStory.L() == null) {
            a = m27924a((FeedProps) feedProps, z, a2);
        } else {
            a = new SpannableStringBuilder(this.f24467b.getString(2131239024, new Object[]{GraphQLActorUtil.a(b)}));
            a.setSpan(m27932b(a2), 0, a.length(), 18);
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        spannableStringBuilder2.append(string2);
        int length = spannableStringBuilder2.length();
        Object a3 = graphQLStory.V() == 0 ? "" : this.f24473h.a(TimeFormatStyle.FUZZY_RELATIVE_DATE_STYLE, graphQLStory.V() * 1000);
        spannableStringBuilder2.append(a3);
        if (a.length() > 0 && a3.length() > 0) {
            spannableStringBuilder2.append(string);
            spannableStringBuilder2.append(string3);
            spannableStringBuilder2.append(string);
        }
        int length2 = spannableStringBuilder2.length();
        if (length2 - length > 0) {
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.b(this.f24467b, 2131362159)), length, length2, 33);
            spannableStringBuilder2.setSpan(Integer.valueOf(1), length, length2, 33);
        }
        spannableStringBuilder2.append(a);
        return new State(parse, a2, c25821, TextUtils.concat(new CharSequence[]{spannableStringBuilder, spannableStringBuilder2}));
    }

    private CharSequence m27929a(GraphQLActor graphQLActor, GraphQLStory graphQLStory, boolean z) {
        if (graphQLActor == null) {
            return "";
        }
        CharSequence a = GraphQLActorUtil.a(graphQLActor);
        if (z) {
            return this.f24474i.a(graphQLStory, a);
        }
        return a;
    }

    private CharSequence m27930a(GraphQLStory graphQLStory, boolean z) {
        String str;
        CharSequence a = m27931a(graphQLStory);
        if (a == null) {
            str = "";
        } else {
            str = a.toString().replaceFirst("^https?://www\\.|^https?://|^www\\.", "");
        }
        a = str;
        if (a == null) {
            return "";
        }
        int i = a.length() > 60 ? 1 : 0;
        if (i != 0) {
            a = a.substring(0, 60);
        }
        if (z) {
            a = this.f24474i.a(graphQLStory, a);
        }
        if (i == 0) {
            return a;
        }
        return TextUtils.concat(new CharSequence[]{a, this.f24467b.getString(2131230738)});
    }

    public static String m27931a(GraphQLStory graphQLStory) {
        return (graphQLStory.av() == null || graphQLStory.av().o() == null) ? "" : graphQLStory.av().o();
    }

    private CharSequence m27928a(Spannable spannable, GraphQLStory graphQLStory, boolean z) {
        int i = spannable.length() > 160 ? 1 : 0;
        if (i != 0) {
            CharSequence a = SpanUtils.a(spannable, 0, 160);
        } else {
            Object obj = spannable;
        }
        if (z) {
            a = this.f24474i.a(graphQLStory, a);
        }
        if (i == 0) {
            return a;
        }
        return TextUtils.concat(new CharSequence[]{a, this.f24467b.getString(2131230738)});
    }

    private Spannable m27924a(FeedProps<GraphQLStory> feedProps, boolean z, OnClickListener onClickListener) {
        Object obj;
        int i;
        Spannable spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.setSpan(m27932b(onClickListener), 0, spannableStringBuilder.length(), 18);
        Spannable a = m27923a((FeedProps) feedProps);
        if (a.length() > 160) {
            obj = 1;
        } else {
            obj = null;
        }
        spannableStringBuilder.append(m27928a(a, (GraphQLStory) feedProps.a, z));
        int length = spannableStringBuilder.length();
        if (a.length() > 160) {
            i = length - 1;
        } else {
            i = length;
        }
        for (Object obj2 : (CharacterStyle[]) a.getSpans(0, i, CharacterStyle.class)) {
            spannableStringBuilder.setSpan(obj2, a.getSpanStart(obj2), Math.min(a.getSpanEnd(obj2), i), 33);
        }
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a();
        obj = (obj != null || m27931a(graphQLStory).length() > 60) ? 1 : null;
        CharSequence a2 = m27930a(graphQLStory, z);
        CharSequence string = this.f24467b.getString(2131239036);
        if (a2 != null && a2.length() > 0) {
            spannableStringBuilder.append(string);
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append(a2);
            spannableStringBuilder.setSpan(m27933b(graphQLStory), length2, a2.length() + length2, 34);
        }
        if (obj != null) {
            spannableStringBuilder.append(string);
            CharSequence spannableStringBuilder2 = new SpannableStringBuilder(this.f24467b.getString(2131239040));
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.b(this.f24467b, 2131362159)), 0, spannableStringBuilder2.length(), 33);
            spannableStringBuilder.append(spannableStringBuilder2);
        }
        return spannableStringBuilder;
    }

    private ClickableSpan m27925a(final OnClickListener onClickListener) {
        return new ClickableSpan(this) {
            final /* synthetic */ LiveFeedHeaderPartDefinition f24455b;

            public void onClick(View view) {
                onClickListener.onClick(view);
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(this.f24455b.f24467b.getResources().getColor(2131361972));
                textPaint.setTypeface(Typeface.create(textPaint.getTypeface(), 1));
            }
        };
    }

    private ClickableSpan m27932b(final OnClickListener onClickListener) {
        return new ClickableSpan(this) {
            final /* synthetic */ LiveFeedHeaderPartDefinition f24457b;

            public void onClick(View view) {
                onClickListener.onClick(view);
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
                textPaint.setColor(this.f24457b.f24467b.getResources().getColor(2131362762));
            }
        };
    }

    private ClickableSpan m27933b(final GraphQLStory graphQLStory) {
        return new ClickableSpan(this) {
            final /* synthetic */ LiveFeedHeaderPartDefinition f24459b;

            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW");
                LiveFeedHeaderPartDefinition liveFeedHeaderPartDefinition = this.f24459b;
                intent.setData(Uri.parse(LiveFeedHeaderPartDefinition.m27931a(graphQLStory)));
                this.f24459b.f24469d.b(intent, this.f24459b.f24467b);
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
                textPaint.setColor(this.f24459b.f24467b.getResources().getColor(2131361975));
            }
        };
    }

    private Spannable m27923a(FeedProps<GraphQLStory> feedProps) {
        Spannable a = this.f24472g.a(feedProps);
        return a != null ? a : new SpannableString("");
    }
}
