package com.facebook.reaction.feed.rows.subparts;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasContext;
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
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.rows.ui.ReactionIconMenuHeaderView;
import com.facebook.reaction.feed.rows.ui.ReactionSecondaryActionPopoverMenuProvider;
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionUriIconPartDefinition;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitHeaderFieldsModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: annotations */
public class BasicReactionMenuHeaderPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends BaseSinglePartDefinition<Props, State, E, ReactionIconMenuHeaderView> {
    private static BasicReactionMenuHeaderPartDefinition f19413d;
    private static final Object f19414e = new Object();
    private final ReactionUriIconPartDefinition f19415a;
    public final ReactionSecondaryActionPopoverMenuProvider f19416b;
    private final ReactionTextWithEntitiesPartDefinition f19417c;

    /* compiled from: annotations */
    public class Props {
        public final ReactionUnitHeaderFieldsModel f19408a;
        public final String f19409b;
        public final String f19410c;
        public final String f19411d;

        public Props(ReactionUnitHeaderFieldsModel reactionUnitHeaderFieldsModel, String str, String str2, String str3) {
            this.f19408a = reactionUnitHeaderFieldsModel;
            this.f19409b = str;
            this.f19410c = str2;
            this.f19411d = str3;
        }
    }

    /* compiled from: annotations */
    public class State {
        @Nullable
        public final OnClickListener f19412a;

        public State(@Nullable OnClickListener onClickListener) {
            this.f19412a = onClickListener;
        }
    }

    private static BasicReactionMenuHeaderPartDefinition m23398b(InjectorLike injectorLike) {
        return new BasicReactionMenuHeaderPartDefinition(ReactionUriIconPartDefinition.m24360a(injectorLike), (ReactionSecondaryActionPopoverMenuProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionSecondaryActionPopoverMenuProvider.class), ReactionTextWithEntitiesPartDefinition.m23423a(injectorLike));
    }

    public final Object m23399a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        LinkableTextWithEntities linkableTextWithEntities;
        Object obj2;
        final Props props = (Props) obj;
        final CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        OnClickListener onClickListener = null;
        ReactionUnitHeaderFieldsModel reactionUnitHeaderFieldsModel = props.f19408a;
        String str = props.f19409b;
        String str2 = props.f19410c;
        subParts.a(2131566648, this.f19417c, new com.facebook.reaction.feed.rows.subparts.ReactionTextWithEntitiesPartDefinition.Props(reactionUnitHeaderFieldsModel.fA_(), str, str2));
        if (reactionUnitHeaderFieldsModel.fz_() == null || Strings.isNullOrEmpty(reactionUnitHeaderFieldsModel.fz_().a())) {
            linkableTextWithEntities = null;
        } else {
            linkableTextWithEntities = reactionUnitHeaderFieldsModel.fz_();
        }
        subParts.a(2131566653, this.f19417c, new com.facebook.reaction.feed.rows.subparts.ReactionTextWithEntitiesPartDefinition.Props(linkableTextWithEntities, str, str2));
        if (reactionUnitHeaderFieldsModel.d() == null || Strings.isNullOrEmpty(reactionUnitHeaderFieldsModel.d().b())) {
            obj2 = null;
        } else {
            obj2 = reactionUnitHeaderFieldsModel.d().b();
        }
        subParts.a(2131566655, this.f19415a, obj2);
        final List arrayList = new ArrayList();
        ImmutableList fy_ = props.f19408a.fy_();
        int size = fy_.size();
        for (int i = 0; i < size; i++) {
            Object obj3;
            ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel = (ReactionStoryAttachmentActionFragmentModel) fy_.get(i);
            if (reactionStoryAttachmentActionFragmentModel.d() == null || reactionStoryAttachmentActionFragmentModel.fU_() == null || StringUtil.a(reactionStoryAttachmentActionFragmentModel.fU_().a())) {
                obj3 = null;
            } else {
                obj3 = 1;
            }
            if (obj3 != null) {
                arrayList.add(reactionStoryAttachmentActionFragmentModel);
            }
        }
        if (!arrayList.isEmpty()) {
            onClickListener = new OnClickListener(this) {
                final /* synthetic */ BasicReactionMenuHeaderPartDefinition f19407d;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -190410042);
                    this.f19407d.f19416b.m23441a(canLaunchReactionIntent, arrayList, props.f19409b, props.f19410c, props.f19411d).f(view);
                    Logger.a(2, EntryType.UI_INPUT_END, -349399554, a);
                }
            };
        }
        return new State(onClickListener);
    }

    public final /* bridge */ /* synthetic */ void m23400a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 705705272);
        ReactionIconMenuHeaderView reactionIconMenuHeaderView = (ReactionIconMenuHeaderView) view;
        reactionIconMenuHeaderView.f19458b.setOnClickListener(((State) obj2).f19412a);
        Logger.a(8, EntryType.MARK_POP, 567218290, a);
    }

    public static BasicReactionMenuHeaderPartDefinition m23397a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BasicReactionMenuHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19414e) {
                BasicReactionMenuHeaderPartDefinition basicReactionMenuHeaderPartDefinition;
                if (a2 != null) {
                    basicReactionMenuHeaderPartDefinition = (BasicReactionMenuHeaderPartDefinition) a2.a(f19414e);
                } else {
                    basicReactionMenuHeaderPartDefinition = f19413d;
                }
                if (basicReactionMenuHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23398b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19414e, b3);
                        } else {
                            f19413d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = basicReactionMenuHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public BasicReactionMenuHeaderPartDefinition(ReactionUriIconPartDefinition reactionUriIconPartDefinition, ReactionSecondaryActionPopoverMenuProvider reactionSecondaryActionPopoverMenuProvider, ReactionTextWithEntitiesPartDefinition reactionTextWithEntitiesPartDefinition) {
        this.f19415a = reactionUriIconPartDefinition;
        this.f19416b = reactionSecondaryActionPopoverMenuProvider;
        this.f19417c = reactionTextWithEntitiesPartDefinition;
    }
}
