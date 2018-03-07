package com.facebook.goodwill.feed.rows;

import android.content.Context;
import android.text.Spannable;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feedplugins.facebookvoice.FacebookVoiceHeaderView;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackAnniversaryCampaignStory;
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
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetchFamilyAlbum */
public class ThrowbackAnniversaryCampaignHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLGoodwillThrowbackAnniversaryCampaignStory>, State, HasPositionInformation, FacebookVoiceHeaderView> {
    public static final ViewType f13512a = new C14361();
    public static final CallerContext f13513b = CallerContext.a(ThrowbackAnniversaryCampaignHeaderPartDefinition.class, "goodwill_throwback");
    private static final PaddingStyle f13514e = Builder.a().i();
    private static ThrowbackAnniversaryCampaignHeaderPartDefinition f13515f;
    private static final Object f13516g = new Object();
    private final BackgroundPartDefinition f13517c;
    private final LinkifyUtil f13518d;

    /* compiled from: fetchFamilyAlbum */
    final class C14361 extends ViewType {
        C14361() {
        }

        public final View m15286a(Context context) {
            return new FacebookVoiceHeaderView(context);
        }
    }

    /* compiled from: fetchFamilyAlbum */
    public class State {
        public final CharSequence f13509a;
        public final CharSequence f13510b;
        public final int f13511c;

        public State(CharSequence charSequence, CharSequence charSequence2, int i) {
            this.f13509a = charSequence;
            this.f13510b = charSequence2;
            this.f13511c = i;
        }
    }

    private static ThrowbackAnniversaryCampaignHeaderPartDefinition m15288b(InjectorLike injectorLike) {
        return new ThrowbackAnniversaryCampaignHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike), LinkifyUtil.a(injectorLike));
    }

    public final Object m15290a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        int i;
        CharSequence charSequence;
        FeedProps feedProps = (FeedProps) obj;
        CharSequence charSequence2 = null;
        GraphQLGoodwillThrowbackAnniversaryCampaignStory graphQLGoodwillThrowbackAnniversaryCampaignStory = (GraphQLGoodwillThrowbackAnniversaryCampaignStory) feedProps.a;
        subParts.a(this.f13517c, new StylingData(feedProps, f13514e, Position.TOP));
        if (graphQLGoodwillThrowbackAnniversaryCampaignStory != null) {
            Spannable a = this.f13518d.a(LinkifyUtilConverter.c(graphQLGoodwillThrowbackAnniversaryCampaignStory.n()), true, null);
            Spannable a2 = this.f13518d.a(LinkifyUtilConverter.c(graphQLGoodwillThrowbackAnniversaryCampaignStory.m()), true, null);
            if (graphQLGoodwillThrowbackAnniversaryCampaignStory.l() == null || graphQLGoodwillThrowbackAnniversaryCampaignStory.l().a() == null) {
                i = -16777216;
                Object obj2 = a2;
                Object obj3 = a;
            } else {
                i = (int) Long.parseLong(graphQLGoodwillThrowbackAnniversaryCampaignStory.l().a(), 16);
                charSequence = a2;
                charSequence2 = a;
            }
        } else {
            i = -16777216;
            charSequence = null;
        }
        return new State(charSequence2, charSequence, i);
    }

    public final /* bridge */ /* synthetic */ void m15291a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1609960764);
        State state = (State) obj2;
        FacebookVoiceHeaderView facebookVoiceHeaderView = (FacebookVoiceHeaderView) view;
        facebookVoiceHeaderView.a(state.f13509a, state.f13510b, null);
        facebookVoiceHeaderView.setContentSummaryColor(state.f13511c);
        facebookVoiceHeaderView.setMenuButtonActive(false);
        facebookVoiceHeaderView.a(null, false, f13513b);
        facebookVoiceHeaderView.setOverlapMode(false);
        facebookVoiceHeaderView.a(null, f13513b);
        Logger.a(8, EntryType.MARK_POP, -477733680, a);
    }

    public final boolean m15292a(Object obj) {
        GraphQLGoodwillThrowbackAnniversaryCampaignStory graphQLGoodwillThrowbackAnniversaryCampaignStory = (GraphQLGoodwillThrowbackAnniversaryCampaignStory) ((FeedProps) obj).a;
        return (graphQLGoodwillThrowbackAnniversaryCampaignStory == null || graphQLGoodwillThrowbackAnniversaryCampaignStory.n() == null || StringUtil.a(graphQLGoodwillThrowbackAnniversaryCampaignStory.n().a())) ? false : true;
    }

    public static ThrowbackAnniversaryCampaignHeaderPartDefinition m15287a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackAnniversaryCampaignHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13516g) {
                ThrowbackAnniversaryCampaignHeaderPartDefinition throwbackAnniversaryCampaignHeaderPartDefinition;
                if (a2 != null) {
                    throwbackAnniversaryCampaignHeaderPartDefinition = (ThrowbackAnniversaryCampaignHeaderPartDefinition) a2.a(f13516g);
                } else {
                    throwbackAnniversaryCampaignHeaderPartDefinition = f13515f;
                }
                if (throwbackAnniversaryCampaignHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15288b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13516g, b3);
                        } else {
                            f13515f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackAnniversaryCampaignHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ThrowbackAnniversaryCampaignHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, LinkifyUtil linkifyUtil) {
        this.f13517c = backgroundPartDefinition;
        this.f13518d = linkifyUtil;
    }

    public final ViewType m15289a() {
        return f13512a;
    }
}
