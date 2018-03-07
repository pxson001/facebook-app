package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.timeformat.FeedTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
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
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.rows.ui.ReactionStoryBlockUnitComponentView;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionStoryAttachmentStoryFragmentModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionStoryAttachmentStoryFragmentModel.ActorsModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import javax.inject.Inject;

@ContextScoped
/* compiled from: account_recovery_search_account */
public class ReactionStoryBlockUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, ReactionStoryBlockUnitComponentView> {
    public static final ViewType f20085a = new C21501();
    private static ReactionStoryBlockUnitComponentPartDefinition f20086g;
    private static final Object f20087h = new Object();
    private final BasicReactionActionPartDefinition f20088b;
    private final TextAppearanceSpan f20089c;
    private final TextAppearanceSpan f20090d;
    private final TextPartDefinition f20091e;
    private final FeedTimeFormatUtil f20092f;

    /* compiled from: account_recovery_search_account */
    final class C21501 extends ViewType {
        C21501() {
        }

        public final View m23973a(Context context) {
            return new ReactionStoryBlockUnitComponentView(context);
        }
    }

    /* compiled from: account_recovery_search_account */
    public class State {
        public final Uri f20082a;
        public final Uri f20083b;
        public final Uri f20084c;

        public State(Uri uri, Uri uri2, Uri uri3) {
            this.f20082a = uri;
            this.f20083b = uri2;
            this.f20084c = uri3;
        }
    }

    private static ReactionStoryBlockUnitComponentPartDefinition m23977b(InjectorLike injectorLike) {
        return new ReactionStoryBlockUnitComponentPartDefinition(BasicReactionActionPartDefinition.m22984a(injectorLike), (Context) injectorLike.getInstance(Context.class), TextPartDefinition.a(injectorLike), FeedTimeFormatUtil.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m23980a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -750860190);
        State state = (State) obj2;
        ReactionStoryBlockUnitComponentView reactionStoryBlockUnitComponentView = (ReactionStoryBlockUnitComponentView) view;
        reactionStoryBlockUnitComponentView.setThumbnailUri(state.f20082a);
        reactionStoryBlockUnitComponentView.m23442a(state.f20083b, state.f20084c);
        Logger.a(8, EntryType.MARK_POP, -708914448, a);
    }

    public final boolean m23981a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        ReactionStoryAttachmentStoryFragmentModel cD = reactionUnitComponentFields.cD();
        if (cD == null || cD.b().isEmpty()) {
            return false;
        }
        ActorsModel actorsModel = (ActorsModel) cD.b().get(0);
        return (StringUtil.a(actorsModel.b()) || actorsModel.c() == null || StringUtil.a(actorsModel.c().b()) || cD.d() < 0 || reactionUnitComponentFields.bv() == null || StringUtil.a(reactionUnitComponentFields.bv().a()) || reactionUnitComponentFields.v() == null || reactionUnitComponentFields.v().V() == null || StringUtil.a(reactionUnitComponentFields.v().V().d())) ? false : true;
    }

    public static ReactionStoryBlockUnitComponentPartDefinition m23976a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionStoryBlockUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20087h) {
                ReactionStoryBlockUnitComponentPartDefinition reactionStoryBlockUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionStoryBlockUnitComponentPartDefinition = (ReactionStoryBlockUnitComponentPartDefinition) a2.a(f20087h);
                } else {
                    reactionStoryBlockUnitComponentPartDefinition = f20086g;
                }
                if (reactionStoryBlockUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23977b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20087h, b3);
                        } else {
                            f20086g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionStoryBlockUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionStoryBlockUnitComponentPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, Context context, TextPartDefinition textPartDefinition, FeedTimeFormatUtil feedTimeFormatUtil) {
        this.f20088b = basicReactionActionPartDefinition;
        this.f20091e = textPartDefinition;
        this.f20092f = feedTimeFormatUtil;
        this.f20089c = new TextAppearanceSpan(context, 2131625848);
        this.f20090d = new TextAppearanceSpan(context, 2131625849);
    }

    public final ViewType m23978a() {
        return f20085a;
    }

    private State m23975a(SubParts<E> subParts, ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        Uri parse;
        Uri parse2;
        ReactionUnitComponentFields f = reactionUnitComponentNode.m22885f();
        ReactionStoryAttachmentStoryFragmentModel cD = f.cD();
        ActorsModel actorsModel = (ActorsModel) cD.b().get(0);
        String b = actorsModel.b();
        String a = f.bv().a();
        String b2 = actorsModel.c().b();
        Object a2 = this.f20092f.a(TimeFormatStyle.STREAM_RELATIVE_STYLE, cD.d() * 1000);
        if (f.bb()) {
            a2 = ((HasContext) e).getContext().getResources().getString(2131237295, new Object[]{a2});
        }
        String b3 = f.aS() != null ? f.aS().b() : null;
        String b4 = f.an() != null ? f.an().b() : null;
        subParts.a(this.f20088b, new Props(f.v(), reactionUnitComponentNode.m22887k(), reactionUnitComponentNode.m22888l()));
        subParts.a(2131566784, this.f20091e, m23974a(b, a));
        subParts.a(2131566785, this.f20091e, a2);
        Uri parse3 = Uri.parse(b2);
        if (b3 != null) {
            parse = Uri.parse(b3);
        } else {
            parse = null;
        }
        if (b4 != null) {
            parse2 = Uri.parse(b4);
        } else {
            parse2 = null;
        }
        return new State(parse3, parse, parse2);
    }

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    private SpannableStringBuilder m23974a(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " — " + str2);
        int length = str.length();
        spannableStringBuilder.setSpan(this.f20089c, 0, length, 33);
        spannableStringBuilder.setSpan(this.f20090d, length + 1, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }
}
