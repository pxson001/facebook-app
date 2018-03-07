package com.facebook.reaction.feed.rows;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.HighlightViewOnTouchListenerPartDefinition;
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.feed.persistentstate.ReactionCollapsableUnitKey;
import com.facebook.reaction.feed.persistentstate.ReactionCollapsableUnitPersistentState;
import com.facebook.reaction.feed.rows.subparts.BasicReactionMenuHeaderPartDefinition;
import com.facebook.reaction.feed.rows.subparts.BasicReactionMenuHeaderPartDefinition.Props;
import com.facebook.reaction.feed.rows.ui.ReactionIconMenuHeaderView;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitHeaderFieldsModel;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: articles_thumbnail_size */
public class ReactionCollapsableStoryIconHeaderPartDefinition<E extends HasInvalidate & HasPersistentState> extends MultiRowSinglePartDefinition<ReactionCardNode, Void, E, ReactionIconMenuHeaderView> {
    public static final ViewType f19192a = new C20941();
    private static ReactionCollapsableStoryIconHeaderPartDefinition f19193e;
    private static final Object f19194f = new Object();
    private final BasicReactionMenuHeaderPartDefinition f19195b;
    private final ClickListenerPartDefinition f19196c;
    private final HighlightViewOnTouchListenerPartDefinition f19197d;

    /* compiled from: articles_thumbnail_size */
    final class C20941 extends ViewType {
        C20941() {
        }

        public final View m23205a(Context context) {
            return new ReactionIconMenuHeaderView(context);
        }
    }

    private static ReactionCollapsableStoryIconHeaderPartDefinition m23208b(InjectorLike injectorLike) {
        return new ReactionCollapsableStoryIconHeaderPartDefinition(ClickListenerPartDefinition.a(injectorLike), BasicReactionMenuHeaderPartDefinition.m23397a(injectorLike), HighlightViewOnTouchListenerPartDefinition.a(injectorLike));
    }

    public final Object m23210a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final ReactionCardNode reactionCardNode = (ReactionCardNode) obj;
        final HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        subParts.a(this.f19195b, new Props(reactionCardNode.mo1117k().fw_(), reactionCardNode.mo1117k().d(), reactionCardNode.mo1117k().n(), reactionCardNode.mo1117k().j()));
        subParts.a(this.f19196c, new OnClickListener(this) {
            final /* synthetic */ ReactionCollapsableStoryIconHeaderPartDefinition f19191c;

            public void onClick(View view) {
                boolean z;
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1773320867);
                ReactionCollapsableUnitPersistentState reactionCollapsableUnitPersistentState = (ReactionCollapsableUnitPersistentState) ((HasPersistentState) hasInvalidate).a(new ReactionCollapsableUnitKey(reactionCardNode.mo1117k().d()), reactionCardNode);
                if (reactionCollapsableUnitPersistentState.f19160a) {
                    z = false;
                } else {
                    z = true;
                }
                reactionCollapsableUnitPersistentState.m23182a(z);
                hasInvalidate.hL_();
                LogUtils.a(1654910482, a);
            }
        });
        subParts.a(this.f19197d, null);
        return null;
    }

    public final /* bridge */ /* synthetic */ void m23211a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1867849459);
        m23207a((ReactionCardNode) obj, (HasInvalidate) anyEnvironment, (ReactionIconMenuHeaderView) view);
        Logger.a(8, EntryType.MARK_POP, 744918070, a);
    }

    public final boolean m23212a(Object obj) {
        ReactionUnitHeaderFieldsModel fw_ = ((ReactionCardNode) obj).mo1117k().fw_();
        return (fw_ == null || fw_.fA_() == null || Strings.isNullOrEmpty(fw_.fA_().a())) ? false : true;
    }

    @Inject
    public ReactionCollapsableStoryIconHeaderPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, BasicReactionMenuHeaderPartDefinition basicReactionMenuHeaderPartDefinition, HighlightViewOnTouchListenerPartDefinition highlightViewOnTouchListenerPartDefinition) {
        this.f19196c = clickListenerPartDefinition;
        this.f19195b = basicReactionMenuHeaderPartDefinition;
        this.f19197d = highlightViewOnTouchListenerPartDefinition;
    }

    public final ViewType m23209a() {
        return f19192a;
    }

    public static ReactionCollapsableStoryIconHeaderPartDefinition m23206a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionCollapsableStoryIconHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19194f) {
                ReactionCollapsableStoryIconHeaderPartDefinition reactionCollapsableStoryIconHeaderPartDefinition;
                if (a2 != null) {
                    reactionCollapsableStoryIconHeaderPartDefinition = (ReactionCollapsableStoryIconHeaderPartDefinition) a2.a(f19194f);
                } else {
                    reactionCollapsableStoryIconHeaderPartDefinition = f19193e;
                }
                if (reactionCollapsableStoryIconHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23208b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19194f, b3);
                        } else {
                            f19193e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionCollapsableStoryIconHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static void m23207a(ReactionCardNode reactionCardNode, E e, ReactionIconMenuHeaderView reactionIconMenuHeaderView) {
        Object obj;
        if (((ReactionCollapsableUnitPersistentState) ((HasPersistentState) e).a(new ReactionCollapsableUnitKey(reactionCardNode.mo1117k().d()), reactionCardNode)).f19160a) {
            obj = null;
        } else {
            obj = 1;
        }
        reactionIconMenuHeaderView.f19458b.setVisibility(obj != null ? 0 : 8);
    }
}
