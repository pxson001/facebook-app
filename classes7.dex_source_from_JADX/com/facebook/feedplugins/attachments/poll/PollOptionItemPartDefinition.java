package com.facebook.feedplugins.attachments.poll;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.HasFeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feedplugins.attachments.poll.PollAttachmentListPartDefinition.QUESTION_RESPONSE_METHOD_TYPE;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLQuestionOption;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLUser;
import com.facebook.graphql.model.HasFeedUnit;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.FacepilePartDefinition;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: THREADED_PROFILE_PICTURE_OFFSET */
public class PollOptionItemPartDefinition extends MultiRowSinglePartDefinition<Props, Void, HasPositionInformation, View> {
    public static final ViewType f22687a = ViewType.a(2130906339);
    public static final int f22688b = 2130839773;
    public static final int f22689c = 2130840069;
    private static final String f22690d = PollOptionItemPartDefinition.class.getName();
    private static PollOptionItemPartDefinition f22691j;
    private static final Object f22692k = new Object();
    private final RadioButtonPartDefinition f22693e;
    private final FacepilePartDefinition f22694f;
    private final BackgroundPartDefinition f22695g;
    private final PollOptionTextWithProgressBarPartDefinition f22696h;
    private final AbstractFbErrorReporter f22697i;

    @Immutable
    /* compiled from: THREADED_PROFILE_PICTURE_OFFSET */
    public class Props implements HasFeedProps<GraphQLStory>, HasFeedUnit {
        public final boolean f22679a;
        public final FeedProps<GraphQLStoryAttachment> f22680b;
        public final GraphQLQuestionOption f22681c;
        public final int f22682d;
        public final OnClickListener f22683e;
        public final OnClickListener f22684f;
        public final QUESTION_RESPONSE_METHOD_TYPE f22685g;
        public final boolean f22686h;

        public Props(FeedProps<GraphQLStoryAttachment> feedProps, GraphQLQuestionOption graphQLQuestionOption, int i, boolean z, QUESTION_RESPONSE_METHOD_TYPE question_response_method_type, OnClickListener onClickListener, OnClickListener onClickListener2, boolean z2) {
            this.f22680b = feedProps;
            this.f22682d = i;
            this.f22681c = graphQLQuestionOption;
            this.f22679a = z;
            this.f22683e = onClickListener;
            this.f22684f = onClickListener2;
            this.f22685g = question_response_method_type;
            this.f22686h = z2;
        }

        public final FeedUnit m25322c() {
            return AttachmentProps.c(this.f22680b);
        }

        public final FeedProps<GraphQLStory> m25323f() {
            return AttachmentProps.e(this.f22680b);
        }
    }

    private static PollOptionItemPartDefinition m25326b(InjectorLike injectorLike) {
        return new PollOptionItemPartDefinition(BackgroundPartDefinition.a(injectorLike), RadioButtonPartDefinition.m25346a(injectorLike), PollOptionTextWithProgressBarPartDefinition.m25331a(injectorLike), FacepilePartDefinition.m9527a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    public final Object m25328a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PaddingStyle paddingStyle;
        Props props = (Props) obj;
        if (props.f22679a) {
            paddingStyle = PaddingStyle.a;
        } else {
            Builder a = Builder.a();
            a.b = -12.0f;
            paddingStyle = a.i();
        }
        subParts.a(this.f22695g, new StylingData(AttachmentProps.e(props.f22680b), paddingStyle));
        subParts.a(2131566172, this.f22693e, new com.facebook.feedplugins.attachments.poll.RadioButtonPartDefinition.Props(props.f22685g.equals(QUESTION_RESPONSE_METHOD_TYPE.CHOOSE_MULTIPLE) ? f22688b : f22689c, props.f22681c.m(), props.f22686h, props.f22683e));
        int a2 = props.f22681c.n().a();
        subParts.a(2131566173, this.f22696h, new com.facebook.feedplugins.attachments.poll.PollOptionTextWithProgressBarPartDefinition.Props(props.f22682d, a2, props.f22681c.k().a(), props.f22683e));
        subParts.a(2131566174, this.f22694f, new com.facebook.multirow.parts.FacepilePartDefinition.Props(m25325a(props.f22681c, a2), a2 == 0 ? null : props.f22684f, a2));
        return null;
    }

    public final boolean m25329a(Object obj) {
        Props props = (Props) obj;
        if (props.f22681c.k() != null) {
            return true;
        }
        this.f22697i.b(f22690d, "TextWithEntities is null for poll " + props.f22681c.j());
        return false;
    }

    public static PollOptionItemPartDefinition m25324a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PollOptionItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22692k) {
                PollOptionItemPartDefinition pollOptionItemPartDefinition;
                if (a2 != null) {
                    pollOptionItemPartDefinition = (PollOptionItemPartDefinition) a2.a(f22692k);
                } else {
                    pollOptionItemPartDefinition = f22691j;
                }
                if (pollOptionItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25326b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22692k, b3);
                        } else {
                            f22691j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pollOptionItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PollOptionItemPartDefinition(BackgroundPartDefinition backgroundPartDefinition, RadioButtonPartDefinition radioButtonPartDefinition, PollOptionTextWithProgressBarPartDefinition pollOptionTextWithProgressBarPartDefinition, FacepilePartDefinition facepilePartDefinition, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f22695g = backgroundPartDefinition;
        this.f22693e = radioButtonPartDefinition;
        this.f22694f = facepilePartDefinition;
        this.f22696h = pollOptionTextWithProgressBarPartDefinition;
        this.f22697i = abstractFbErrorReporter;
    }

    public final ViewType<View> m25327a() {
        return f22687a;
    }

    private static ImmutableList<Uri> m25325a(GraphQLQuestionOption graphQLQuestionOption, int i) {
        ImmutableList.Builder builder = ImmutableList.builder();
        if (graphQLQuestionOption.n() == null || graphQLQuestionOption.n().j() == null) {
            return builder.b();
        }
        ImmutableList j = graphQLQuestionOption.n().j();
        int size = j.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            int i4;
            GraphQLUser graphQLUser = (GraphQLUser) j.get(i2);
            if (graphQLUser.ag() && graphQLUser.aI() != null && graphQLUser.aI().b() != null) {
                builder.c(ImageUtil.a(graphQLUser.aI()));
                i4 = i3 + 1;
                if (i != 3 && i4 == 2) {
                    break;
                }
            }
            i4 = i3;
            i2++;
            i3 = i4;
        }
        return builder.b();
    }
}
