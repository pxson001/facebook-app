package com.facebook.feed.rows.sections.text;

import android.content.Context;
import android.view.View;
import com.facebook.common.util.ContextUtils;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.views.AccessibleTextLayoutView;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.feedplugins.spannable.SpannableInTextLayoutPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

/* compiled from: host */
public class ContentTextLayoutBasePartDefinition<E extends HasContext & HasFeedListType & HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, AccessibleTextLayoutView> {
    public static final ViewType f20885a = new C08331();
    private final CopyTextPartDefinition f20886b;
    private final BackgroundPartDefinition f20887c;
    private final boolean f20888d;
    private final FeedStoryUtil f20889e;
    private final SpannableInTextLayoutPartDefinition f20890f;
    private final TextLayoutBuilder f20891g;
    private final ContentTextLayoutPersistentSpannableInputProvider f20892h;
    private final PaddingStyle f20893i;

    /* compiled from: host */
    final class C08331 extends ViewType {
        C08331() {
        }

        public final View mo1995a(Context context) {
            View accessibleTextLayoutView = new AccessibleTextLayoutView(context);
            accessibleTextLayoutView.setId(2131558553);
            return accessibleTextLayoutView;
        }
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        subParts.mo2756a(this.f20887c, new StylingData(feedProps, this.f20893i));
        subParts.mo2756a(this.f20886b, graphQLStory);
        int c = ContextUtils.m2503c(hasContext.getContext(), 2130772561, 2131362048);
        int b = ContextUtils.m2501b(hasContext.getContext(), 2130772562, 2131361972);
        this.f20891g.m28606c(c);
        subParts.mo2756a(this.f20890f, this.f20892h.m28632a(this.f20891g, feedProps, (int) this.f20891g.m28602b(), b, this.f20888d, ((HasFeedListType) hasContext).mo2446c()));
        return null;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1142256399);
        ((AccessibleTextLayoutView) view).setTag(2131558541, Boolean.valueOf(StoryProps.m27466p((FeedProps) obj)));
        Logger.a(8, EntryType.MARK_POP, -2041699436, a);
    }

    @Inject
    public ContentTextLayoutBasePartDefinition(@Assisted Boolean bool, @Assisted TextLayoutBuilder textLayoutBuilder, @Assisted PaddingStyle paddingStyle, BackgroundPartDefinition backgroundPartDefinition, CopyTextPartDefinition copyTextPartDefinition, FeedStoryUtil feedStoryUtil, SpannableInTextLayoutPartDefinition spannableInTextLayoutPartDefinition, ContentTextLayoutPersistentSpannableInputProvider contentTextLayoutPersistentSpannableInputProvider) {
        this.f20888d = bool.booleanValue();
        this.f20887c = backgroundPartDefinition;
        this.f20886b = copyTextPartDefinition;
        this.f20889e = feedStoryUtil;
        this.f20890f = spannableInTextLayoutPartDefinition;
        this.f20891g = textLayoutBuilder;
        this.f20892h = contentTextLayoutPersistentSpannableInputProvider;
        this.f20893i = paddingStyle;
    }

    public final ViewType mo2547a() {
        return f20885a;
    }

    public final boolean m28615a(FeedProps<GraphQLStory> feedProps) {
        return FeedStoryUtil.m18583b((GraphQLStory) feedProps.f13444a);
    }
}
