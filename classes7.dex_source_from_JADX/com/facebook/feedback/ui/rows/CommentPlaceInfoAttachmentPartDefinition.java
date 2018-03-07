package com.facebook.feedback.ui.rows;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.style.ForegroundColorSpan;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLMutations.DeletePlaceRecommendationFromCommentMutationString;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLMutationsModels.AddPlaceListItemToCommentMutationModel;
import com.facebook.checkin.socialsearch.utils.AddPlaceListItemToCommentMutationHelper;
import com.facebook.checkin.socialsearch.utils.DeletePlaceRecommendationFromCommentMutationHelper;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.SeparatedSpannableStringBuilder;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.controller.mutation.util.FeedbackMutator.Result;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.feedback.ui.rows.CommentPlaceInfoStylingPartDefinition.AttachmentStylingTypes;
import com.facebook.feedback.ui.rows.views.CommentPlaceInfoAttachmentView;
import com.facebook.feedback.ui.rows.views.CommentRowPadding;
import com.facebook.graphql.calls.CommentPlaceRecommendationDeleteInputData;
import com.facebook.graphql.calls.CommentPlaceRecommendationDeleteInputData.RecommendationTypes;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.query.GraphQlQueryString;
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
import com.facebook.multirow.parts.TextOrHiddenPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ufiservices.event.CommentEvents.UpdateCommentEvent;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.text.FbImageSpan;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ridge_opt_in_back_out_tapped */
public class CommentPlaceInfoAttachmentPartDefinition extends MultiRowSinglePartDefinition<Props, Void, CommentsEnvironment, CommentPlaceInfoAttachmentView> {
    public static final ViewType<CommentPlaceInfoAttachmentView> f4973a = new C04861();
    private static CommentPlaceInfoAttachmentPartDefinition f4974p;
    private static final Object f4975q = new Object();
    public final Context f4976b;
    private final CommentPlaceInfoStylingPartDefinition f4977c;
    private final ClickListenerPartDefinition f4978d;
    private final TextPartDefinition f4979e;
    private final TextOrHiddenPartDefinition f4980f;
    private final GlyphColorizer f4981g;
    public final AddPlaceListItemToCommentMutationHelper f4982h;
    public final DeletePlaceRecommendationFromCommentMutationHelper f4983i;
    public final FeedStoryMutator f4984j;
    public final FeedbackMutator f4985k;
    public final FeedEventBus f4986l;
    public final EventsStream f4987m;
    public final FbUriIntentHandler f4988n;
    public final Toaster f4989o;

    /* compiled from: ridge_opt_in_back_out_tapped */
    final class C04861 extends ViewType<CommentPlaceInfoAttachmentView> {
        C04861() {
        }

        public final View m5465a(Context context) {
            return new CommentPlaceInfoAttachmentView(new ContextThemeWrapper(context, 2131625248));
        }
    }

    /* compiled from: ridge_opt_in_back_out_tapped */
    public class Props {
        public final FeedProps<GraphQLStoryAttachment> f4968a;
        public final GraphQLPage f4969b;
        public final boolean f4970c;
        @AttachmentStylingTypes
        public final int f4971d;
        public final CommentRowPadding f4972e;

        public Props(FeedProps<GraphQLStoryAttachment> feedProps, GraphQLPage graphQLPage, @AttachmentStylingTypes int i, boolean z, CommentRowPadding commentRowPadding) {
            this.f4968a = feedProps;
            this.f4969b = graphQLPage;
            this.f4970c = z;
            this.f4971d = i;
            this.f4972e = commentRowPadding;
        }
    }

    private static CommentPlaceInfoAttachmentPartDefinition m5467b(InjectorLike injectorLike) {
        return new CommentPlaceInfoAttachmentPartDefinition((Context) injectorLike.getInstance(Context.class), CommentPlaceInfoStylingPartDefinition.m5477a(injectorLike), ClickListenerPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), TextOrHiddenPartDefinition.a(injectorLike), GlyphColorizer.a(injectorLike), AddPlaceListItemToCommentMutationHelper.m1236b(injectorLike), DeletePlaceRecommendationFromCommentMutationHelper.m1240b(injectorLike), FeedStoryMutator.b(injectorLike), FeedbackMutator.a(injectorLike), EventsStream.a(injectorLike), FeedEventBus.a(injectorLike), FbUriIntentHandler.a(injectorLike), Toaster.b(injectorLike));
    }

    public final Object m5470a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object string;
        final Props props = (Props) obj;
        GraphQLNode z = ((GraphQLStoryAttachment) props.f4968a.a).z();
        subParts.a(this.f4977c, new com.facebook.feedback.ui.rows.CommentPlaceInfoStylingPartDefinition.Props(props.f4971d, props.f4972e, props.f4970c));
        ClickListenerPartDefinition clickListenerPartDefinition = this.f4978d;
        final GraphQLPage graphQLPage = props.f4969b;
        subParts.a(2131560452, clickListenerPartDefinition, new OnClickListener(this) {
            final /* synthetic */ CommentPlaceInfoAttachmentPartDefinition f4967b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1547980672);
                this.f4967b.f4988n.a(this.f4967b.f4976b, StringFormatUtil.formatStrLocaleSafe(FBLinks.af, graphQLPage.ae()));
                Logger.a(2, EntryType.UI_INPUT_END, -1131997186, a);
            }
        });
        subParts.a(2131560453, this.f4979e, props.f4969b.aG());
        subParts.a(2131560454, this.f4980f, m5468b(props.f4969b));
        subParts.a(2131560455, this.f4980f, props.f4969b.l() != null ? props.f4969b.l().o() : null);
        if (props.f4970c) {
            string = this.f4976b.getString(2131233345);
        } else {
            string = this.f4976b.getString(2131233346);
            ClickListenerPartDefinition clickListenerPartDefinition2 = this.f4978d;
            final String y = AttachmentProps.h(props.f4968a).y();
            subParts.a(2131560456, clickListenerPartDefinition2, new OnClickListener(this) {
                final /* synthetic */ CommentPlaceInfoAttachmentPartDefinition f4961c;

                /* compiled from: ridge_opt_in_back_out_tapped */
                class C04871 implements FutureCallback<GraphQLResult<AddPlaceListItemToCommentMutationModel>> {
                    final /* synthetic */ C04882 f4958a;

                    C04871(C04882 c04882) {
                        this.f4958a = c04882;
                    }

                    public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
                    }

                    public void onFailure(Throwable th) {
                        this.f4958a.f4961c.f4989o.a(new ToastBuilder("Error adding Place to Map"));
                    }
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -2064308878);
                    this.f4961c.f4982h.m1237a(y, props.f4969b.ae(), new C04871(this));
                    FeedProps feedProps = props.f4968a.b;
                    if (feedProps == null) {
                        Logger.a(2, EntryType.UI_INPUT_END, -1000401207, a);
                        return;
                    }
                    while (feedProps.b != null) {
                        feedProps = feedProps.b;
                    }
                    if (feedProps.a instanceof GraphQLStory) {
                        this.f4961c.f4986l.a(new FeedUnitMutatedEvent(StoryProps.f(this.f4961c.f4984j.a(feedProps, props.f4969b, y))));
                    } else if (feedProps.a instanceof GraphQLFeedback) {
                        Result a2 = this.f4961c.f4985k.a((GraphQLFeedback) feedProps.a, props.f4969b, y);
                        if (a2 == null) {
                            LogUtils.a(650000143, a);
                            return;
                        }
                        this.f4961c.f4987m.a(new UpdateCommentEvent(a2.b, a2.a.z_()));
                    }
                    LogUtils.a(-402189194, a);
                }
            });
        }
        subParts.a(2131560450, this.f4979e, string);
        if (z.kO()) {
            ClickListenerPartDefinition clickListenerPartDefinition3 = this.f4978d;
            y = AttachmentProps.h(props.f4968a).y();
            subParts.a(2131560451, clickListenerPartDefinition3, new OnClickListener(this) {
                final /* synthetic */ CommentPlaceInfoAttachmentPartDefinition f4965c;

                /* compiled from: ridge_opt_in_back_out_tapped */
                class C04891 implements FutureCallback {
                    final /* synthetic */ C04903 f4962a;

                    C04891(C04903 c04903) {
                        this.f4962a = c04903;
                    }

                    public void onSuccess(@Nullable Object obj) {
                    }

                    public void onFailure(Throwable th) {
                        this.f4962a.f4965c.f4989o.a(new ToastBuilder("Error removing Place"));
                    }
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1532260055);
                    Object obj = props.f4970c ? RecommendationTypes.CONFIRMED_PLACE : RecommendationTypes.PENDING_PLACE;
                    DeletePlaceRecommendationFromCommentMutationHelper deletePlaceRecommendationFromCommentMutationHelper = this.f4965c.f4983i;
                    String str = y;
                    String ae = props.f4969b.ae();
                    C04891 c04891 = new C04891(this);
                    ImmutableList of = ImmutableList.of(obj);
                    CommentPlaceRecommendationDeleteInputData commentPlaceRecommendationDeleteInputData = new CommentPlaceRecommendationDeleteInputData();
                    commentPlaceRecommendationDeleteInputData.a("comment_id", str);
                    GraphQlCallInput graphQlCallInput = commentPlaceRecommendationDeleteInputData;
                    graphQlCallInput.a("place_id", ae);
                    graphQlCallInput = graphQlCallInput;
                    graphQlCallInput.a("recommendation_types", of);
                    GraphQlCallInput graphQlCallInput2 = graphQlCallInput;
                    GraphQlQueryString deletePlaceRecommendationFromCommentMutationString = new DeletePlaceRecommendationFromCommentMutationString();
                    deletePlaceRecommendationFromCommentMutationString.a("input", graphQlCallInput2);
                    deletePlaceRecommendationFromCommentMutationString.a("profile_image_size", GraphQLStoryHelper.a());
                    deletePlaceRecommendationFromCommentMutationHelper.f1150c.a("remove_place", deletePlaceRecommendationFromCommentMutationHelper.f1148a.a(GraphQLRequest.a(deletePlaceRecommendationFromCommentMutationString)), AbstractDisposableFutureCallback.a(c04891));
                    FeedProps feedProps = props.f4968a.b;
                    if (feedProps == null) {
                        LogUtils.a(839242075, a);
                        return;
                    }
                    while (feedProps.b != null) {
                        feedProps = feedProps.b;
                    }
                    if (feedProps.a instanceof GraphQLStory) {
                        this.f4965c.f4986l.a(new FeedUnitMutatedEvent(StoryProps.f(this.f4965c.f4984j.a(feedProps, props.f4969b.ae(), y, props.f4970c))));
                    } else if (feedProps.a instanceof GraphQLFeedback) {
                        Result a2 = this.f4965c.f4985k.a((GraphQLFeedback) feedProps.a, y, props.f4969b.ae(), props.f4970c);
                        if (a2 == null) {
                            LogUtils.a(1160933085, a);
                            return;
                        }
                        this.f4965c.f4987m.a(new UpdateCommentEvent(a2.b, a2.a.z_()));
                    }
                    LogUtils.a(767679094, a);
                }
            });
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ void m5471a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int i;
        int a = Logger.a(8, EntryType.MARK_PUSH, -625971474);
        Props props = (Props) obj;
        CommentPlaceInfoAttachmentView commentPlaceInfoAttachmentView = (CommentPlaceInfoAttachmentView) view;
        GraphQLNode z = ((GraphQLStoryAttachment) props.f4968a.a).z();
        GraphQLImage bs = props.f4969b.bs();
        if (bs != null) {
            commentPlaceInfoAttachmentView.f5189c.setThumbnailUri(ImageUtil.a(bs));
        }
        if (z.kO()) {
            i = 0;
        } else {
            i = 8;
        }
        commentPlaceInfoAttachmentView.f5191e.setVisibility(i);
        Logger.a(8, EntryType.MARK_POP, 1358599214, a);
    }

    public static CommentPlaceInfoAttachmentPartDefinition m5466a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommentPlaceInfoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4975q) {
                CommentPlaceInfoAttachmentPartDefinition commentPlaceInfoAttachmentPartDefinition;
                if (a2 != null) {
                    commentPlaceInfoAttachmentPartDefinition = (CommentPlaceInfoAttachmentPartDefinition) a2.a(f4975q);
                } else {
                    commentPlaceInfoAttachmentPartDefinition = f4974p;
                }
                if (commentPlaceInfoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5467b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4975q, b3);
                        } else {
                            f4974p = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commentPlaceInfoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public CommentPlaceInfoAttachmentPartDefinition(Context context, CommentPlaceInfoStylingPartDefinition commentPlaceInfoStylingPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, TextPartDefinition textPartDefinition, TextOrHiddenPartDefinition textOrHiddenPartDefinition, GlyphColorizer glyphColorizer, AddPlaceListItemToCommentMutationHelper addPlaceListItemToCommentMutationHelper, DeletePlaceRecommendationFromCommentMutationHelper deletePlaceRecommendationFromCommentMutationHelper, FeedStoryMutator feedStoryMutator, FeedbackMutator feedbackMutator, EventsStream eventsStream, FeedEventBus feedEventBus, FbUriIntentHandler fbUriIntentHandler, Toaster toaster) {
        this.f4976b = context;
        this.f4977c = commentPlaceInfoStylingPartDefinition;
        this.f4978d = clickListenerPartDefinition;
        this.f4979e = textPartDefinition;
        this.f4980f = textOrHiddenPartDefinition;
        this.f4981g = glyphColorizer;
        this.f4982h = addPlaceListItemToCommentMutationHelper;
        this.f4983i = deletePlaceRecommendationFromCommentMutationHelper;
        this.f4984j = feedStoryMutator;
        this.f4985k = feedbackMutator;
        this.f4986l = feedEventBus;
        this.f4987m = eventsStream;
        this.f4988n = fbUriIntentHandler;
        this.f4989o = toaster;
    }

    public final boolean m5472a(Object obj) {
        return true;
    }

    public final ViewType<CommentPlaceInfoAttachmentView> m5469a() {
        return f4973a;
    }

    private CharSequence m5468b(GraphQLPage graphQLPage) {
        SeparatedSpannableStringBuilder separatedSpannableStringBuilder = new SeparatedSpannableStringBuilder();
        if (graphQLPage.aM() != null) {
            int dimensionPixelSize = this.f4976b.getResources().getDimensionPixelSize(2131427400);
            Drawable a = this.f4981g.a(2130840114, -10972929);
            a.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            FbImageSpan fbImageSpan = new FbImageSpan(a, 2);
            separatedSpannableStringBuilder.append(Double.toString(graphQLPage.aM().k()));
            separatedSpannableStringBuilder.append(" ");
            separatedSpannableStringBuilder.append(" ");
            separatedSpannableStringBuilder.setSpan(fbImageSpan, separatedSpannableStringBuilder.length() - 1, separatedSpannableStringBuilder.length(), 33);
        }
        if (graphQLPage.bd() != null) {
            separatedSpannableStringBuilder.a(graphQLPage.bd(), new ForegroundColorSpan(this.f4976b.getResources().getColor(2131361935)), 0);
        }
        if (!(graphQLPage.F() == null || graphQLPage.F().isEmpty())) {
            separatedSpannableStringBuilder.a((CharSequence) graphQLPage.F().get(0), new ForegroundColorSpan(this.f4976b.getResources().getColor(2131361935)), 0);
        }
        return separatedSpannableStringBuilder;
    }
}
