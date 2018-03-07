package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.graphics.PointF;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.rows.ui.ReactionPhotoWithMessageComponentView;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLModels.ReactionUnitPhotoComponentFragmentModel.PhotoModel.CreationStoryModel;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLModels.ReactionUnitPhotoComponentFragmentModel.PhotoModel.CreationStoryModel.FeedbackModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: ad_videos_json */
public abstract class ReactionPhotoUnitComponentPartDefinition extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, CanLaunchReactionIntent, ReactionPhotoWithMessageComponentView> {
    public static final ViewType f19941a = new C21361();
    private static final CallerContext f19942b = CallerContext.a(ReactionPhotoUnitComponentPartDefinition.class, "reaction_photos");
    private final FbDraweeControllerBuilder f19943c;
    public final ReactionIntentFactory f19944d;

    /* compiled from: ad_videos_json */
    final class C21361 extends ViewType {
        C21361() {
        }

        public final View m23842a(Context context) {
            return new ReactionPhotoWithMessageComponentView(context);
        }
    }

    /* compiled from: ad_videos_json */
    public class State {
        public final float f19951a;
        public final DraweeController f19952b;
        public final PointF f19953c;
        public final String f19954d;
        public final OnClickListener f19955e;

        public State(float f, DraweeController draweeController, @Nullable PointF pointF, @Nullable String str, @Nullable OnClickListener onClickListener) {
            this.f19951a = f;
            this.f19952b = draweeController;
            this.f19953c = pointF;
            this.f19954d = str;
            this.f19955e = onClickListener;
        }
    }

    protected abstract float mo1124b();

    public final Object m23834a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        OnClickListener onClickListener;
        String str;
        final ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        final CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        DefaultImageFields g = reactionUnitComponentFields.bM().g();
        final CreationStoryModel j = reactionUnitComponentFields.bM().j();
        if (j == null || Strings.isNullOrEmpty(j.d()) || Strings.isNullOrEmpty(j.b())) {
            onClickListener = null;
        } else {
            onClickListener = new OnClickListener(this) {
                final /* synthetic */ ReactionPhotoUnitComponentPartDefinition f19950d;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1295791521);
                    FeedbackModel c = j.c();
                    canLaunchReactionIntent.mo695a(reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d, this.f19950d.f19944d.m22748a(j.d(), j.b(), c != null ? c.a() : null, UnitInteractionType.PHOTO_TAP));
                    LogUtils.a(-340543067, a);
                }
            };
        }
        FbPipelineDraweeController s = ((FbDraweeControllerBuilder) this.f19943c.a(f19942b).b(Uri.parse(g.b())).a(true)).s();
        DefaultVect2Fields c = reactionUnitComponentFields.bM().c();
        PointF pointF = c == null ? null : new PointF((float) c.a(), (float) c.b());
        if (reactionUnitComponentFields.bv() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.bv().a())) {
            str = null;
        } else {
            str = reactionUnitComponentFields.bv().a();
        }
        return new State(Math.max(mo1124b(), ((float) g.c()) / ((float) g.a())), s, pointF, str, onClickListener);
    }

    public final /* bridge */ /* synthetic */ void m23835a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1991481007);
        State state = (State) obj2;
        ReactionPhotoWithMessageComponentView reactionPhotoWithMessageComponentView = (ReactionPhotoWithMessageComponentView) view;
        CharSequence charSequence = state.f19954d;
        if (charSequence == null) {
            reactionPhotoWithMessageComponentView.f19485c.setVisibility(8);
        } else {
            reactionPhotoWithMessageComponentView.f19485c.setText(charSequence);
            reactionPhotoWithMessageComponentView.f19485c.setVisibility(0);
        }
        reactionPhotoWithMessageComponentView.m23440a(state.f19951a, state.f19952b, state.f19953c, state.f19955e);
        Logger.a(8, EntryType.MARK_POP, -1183081512, a);
    }

    public final boolean m23836a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return (reactionUnitComponentFields.bM() == null || reactionUnitComponentFields.bM().g() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.bM().g().b())) ? false : true;
    }

    public final void m23838b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((ReactionPhotoWithMessageComponentView) view).m23440a(0.0f, null, null, null);
    }

    public ReactionPhotoUnitComponentPartDefinition(FbDraweeControllerBuilder fbDraweeControllerBuilder, ReactionIntentFactory reactionIntentFactory) {
        this.f19943c = fbDraweeControllerBuilder;
        this.f19944d = reactionIntentFactory;
    }

    public final ViewType m23833a() {
        return f19941a;
    }
}
