package com.facebook.reaction.ui.card;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.graphql.enums.GraphQLReactionStoryActionStyle;
import com.facebook.graphql.enums.GraphQLReactionUnitHeaderStyle;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.GetEntityFbLinkGraphQL;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.LinkableTextWithEntities;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reaction.action.ReactionActionHandler;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.common.ReactionAttachmentListener;
import com.facebook.reaction.common.ReactionAttachmentStyleMapper;
import com.facebook.reaction.common.ReactionCard;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.common.ReactionUnitValidator;
import com.facebook.reaction.common.ReactionValidationResult;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.interfaces.ReactionUnitParent;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionImageFields;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStoryFragment.ReactionAttachments;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitDefaultFields;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitHeaderFieldsModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionStoryAttachmentActionFragment;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.facebook.reaction.ui.card.header.ReactionEventSubscribeButtonBinder;
import com.facebook.ui.touchlistener.HighlightViewOnTouchListener;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView.LinkableEntityListener;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.LinkedHashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Updated Tutorial Nux Debug Mode.  Don't forget to kill the app! */
public class ReactionCardView extends CustomLinearLayout implements ReactionCard {
    private static final int[] f21060a = new int[]{2130773596};
    private ReactionActionHandler f21061b;
    private ReactionAttachmentStyleMapper f21062c;
    public ReactionCardContainer f21063d;
    private ReactionEventSubscribeButtonBinder f21064e;
    public ReactionIntentFactory f21065f;
    public ReactionIntentLauncher f21066g;
    private ReactionCardNode f21067h;
    private int f21068i;
    public String f21069j;
    private String f21070k;
    public ViewGroup f21071l = ((ViewGroup) findViewById(2131566633));
    private ReactionAttachmentHandler f21072m;
    public View f21073n = findViewById(2131566643);
    public ViewGroup f21074o = ((ViewGroup) a(2131566642));
    public ViewGroup f21075p = ((ViewGroup) a(2131566641));

    /* compiled from: Updated Tutorial Nux Debug Mode.  Don't forget to kill the app! */
    /* synthetic */ class C22273 {
        static final /* synthetic */ int[] f21059a = new int[GraphQLReactionUnitHeaderStyle.values().length];

        static {
            try {
                f21059a[GraphQLReactionUnitHeaderStyle.CENTER_ALIGNED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f21059a[GraphQLReactionUnitHeaderStyle.ICON.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f21059a[GraphQLReactionUnitHeaderStyle.ICON_INLINE_ACTION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f21059a[GraphQLReactionUnitHeaderStyle.DESCRIPTIVE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: Updated Tutorial Nux Debug Mode.  Don't forget to kill the app! */
    class CardFooterOnTouchListener extends HighlightViewOnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view.getId() == 2131566645) {
                View findViewById = view.findViewById(2131566657);
                if (findViewById != null) {
                    super.onTouch(findViewById, motionEvent);
                }
            }
            return false;
        }
    }

    public static void m24707a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ReactionCardView) obj).m24701a(ReactionActionHandler.m22673a(injectorLike), ReactionAttachmentStyleMapper.m22863a(injectorLike), ReactionEventSubscribeButtonBinder.m24716b(injectorLike), ReactionIntentFactory.m22683a(injectorLike), ReactionIntentLauncher.m24381a(injectorLike));
    }

    public ReactionCardView(ReactionCardContainer reactionCardContainer, Context context) {
        super(context);
        this.f21063d = reactionCardContainer;
        Class cls = ReactionCardView.class;
        m24707a((Object) this, getContext());
        setContentView(2130906620);
        setLayoutParams(new LayoutParams(-1, -2));
        setOrientation(1);
        int dimension = (int) getResources().getDimension(2131431415);
        setPadding(0, dimension, 0, dimension);
    }

    @Inject
    private void m24701a(ReactionActionHandler reactionActionHandler, ReactionAttachmentStyleMapper reactionAttachmentStyleMapper, ReactionEventSubscribeButtonBinder reactionEventSubscribeButtonBinder, ReactionIntentFactory reactionIntentFactory, ReactionIntentLauncher reactionIntentLauncher) {
        this.f21061b = reactionActionHandler;
        this.f21062c = reactionAttachmentStyleMapper;
        this.f21064e = reactionEventSubscribeButtonBinder;
        this.f21065f = reactionIntentFactory;
        this.f21066g = reactionIntentLauncher;
    }

    public final void m24709a(ReactionUnitDefaultFields reactionUnitDefaultFields, ReactionValidationResult reactionValidationResult, @Nullable ReactionUnitParent reactionUnitParent) {
        this.f21069j = reactionUnitDefaultFields.d();
        this.f21070k = reactionUnitDefaultFields.n();
        ReactionAttachmentsModel fx_ = reactionUnitDefaultFields.fx_();
        this.f21072m = reactionValidationResult.f18874a;
        ReactionAttachmentListener interactionTracker = this.f21063d.getInteractionTracker();
        this.f21071l.removeAllViews();
        this.f21074o.removeAllViews();
        this.f21075p.removeAllViews();
        m24704a(fx_, this.f21072m, interactionTracker, reactionUnitParent);
        m24703a(reactionUnitDefaultFields, interactionTracker);
        if (this.f21072m == null || !this.f21072m.mo1136a()) {
            m24705a(fx_, reactionUnitDefaultFields, interactionTracker);
        }
    }

    public int getNumAttachmentsLoaded() {
        return this.f21068i;
    }

    public String getUnitType() {
        return this.f21070k;
    }

    public View getView() {
        return this;
    }

    private void m24700a(SegmentedLinearLayout segmentedLinearLayout, ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel, ReactionAttachmentIntent reactionAttachmentIntent, TextView textView, ReactionAttachmentListener reactionAttachmentListener, Boolean bool) {
        DefaultTextWithEntitiesFields fU_ = reactionStoryAttachmentActionFragmentModel.fU_();
        if (!(textView == null || fU_ == null)) {
            textView.setText(fU_.a());
        }
        m24702a(reactionAttachmentListener, this.f21069j, this.f21070k, bool.booleanValue() ? textView : segmentedLinearLayout, reactionAttachmentIntent);
        segmentedLinearLayout.addView(textView);
    }

    private void m24704a(@Nullable ReactionAttachmentsModel reactionAttachmentsModel, @Nullable ReactionAttachmentHandler reactionAttachmentHandler, ReactionAttachmentListener reactionAttachmentListener, @Nullable ReactionUnitParent reactionUnitParent) {
        if (reactionAttachmentsModel == null || reactionAttachmentHandler == null) {
            this.f21071l.setVisibility(8);
            return;
        }
        this.f21071l.setVisibility(0);
        reactionAttachmentHandler.mo1127a(reactionAttachmentListener, this.f21071l, this.f21063d, this.f21063d.getSessionId(), this.f21063d.getSurface(), reactionUnitParent);
        reactionAttachmentHandler.mo1135a(this.f21069j, this.f21070k, reactionAttachmentsModel);
        this.f21068i = reactionAttachmentsModel.b().size();
        if (reactionAttachmentHandler.mo1136a()) {
            this.f21071l.setBackgroundResource(0);
            this.f21073n.setVisibility(8);
            this.f21074o.setVisibility(8);
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(f21060a);
        this.f21071l.setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
        obtainStyledAttributes.recycle();
        this.f21073n.setVisibility(0);
        this.f21074o.setVisibility(0);
    }

    private void m24703a(ReactionUnitDefaultFields reactionUnitDefaultFields, ReactionAttachmentListener reactionAttachmentListener) {
        if (ReactionUnitValidator.m22911b(reactionUnitDefaultFields)) {
            View inflate;
            View view;
            switch (C22273.f21059a[reactionUnitDefaultFields.fw_().c().ordinal()]) {
                case 1:
                case 2:
                    inflate = LayoutInflater.from(getContext()).inflate(2130906625, this.f21075p, false);
                    view = inflate;
                    break;
                case 3:
                    view = LayoutInflater.from(getContext()).inflate(2130906629, this.f21075p, false);
                    inflate = view.findViewById(2131566654);
                    break;
                case 4:
                    view = LayoutInflater.from(getContext()).inflate(2130906623, this.f21075p, false);
                    inflate = view.findViewById(2131566647);
                    break;
                default:
                    return;
            }
            m24699a(view, reactionUnitDefaultFields.fw_(), reactionAttachmentListener);
            m24708b(inflate, reactionUnitDefaultFields.fw_(), reactionAttachmentListener);
            this.f21075p.addView(view);
        }
    }

    private void m24699a(View view, ReactionUnitHeaderFieldsModel reactionUnitHeaderFieldsModel, ReactionAttachmentListener reactionAttachmentListener) {
        TextView textView = (TextWithEntitiesView) view.findViewById(2131566648);
        m24706a((TextWithEntitiesView) textView, this.f21069j, this.f21070k, reactionUnitHeaderFieldsModel.fA_(), reactionAttachmentListener);
        TextView textView2 = (TextWithEntitiesView) view.findViewById(2131566653);
        m24706a((TextWithEntitiesView) textView2, this.f21069j, this.f21070k, reactionUnitHeaderFieldsModel.fz_(), reactionAttachmentListener);
        switch (C22273.f21059a[reactionUnitHeaderFieldsModel.c().ordinal()]) {
            case 1:
                m24697a(view, textView, textView2);
                return;
            case 2:
            case 3:
                m24698a(view, reactionUnitHeaderFieldsModel, textView, textView2);
                break;
            case 4:
                break;
            default:
                return;
        }
        textView.setGravity(3);
    }

    private void m24708b(View view, ReactionUnitHeaderFieldsModel reactionUnitHeaderFieldsModel, ReactionAttachmentListener reactionAttachmentListener) {
        String str = null;
        if (reactionUnitHeaderFieldsModel.b() == null) {
            view.setOnClickListener(null);
            return;
        }
        if (reactionUnitHeaderFieldsModel.fA_() != null) {
            str = reactionUnitHeaderFieldsModel.fA_().a();
        }
        if (reactionUnitHeaderFieldsModel.b().j() == GraphQLReactionStoryActionStyle.EVENTS_SUBSCRIBE) {
            this.f21064e.m24718a(this.f21067h, (TextView) view, this.f21063d.getInteractionTracker());
            return;
        }
        if (GraphQLReactionUnitHeaderStyle.ICON_INLINE_ACTION.equals(reactionUnitHeaderFieldsModel.c()) && (view instanceof TextView)) {
            TextView textView = (TextView) view;
            textView.setText(reactionUnitHeaderFieldsModel.b().fU_().a());
            textView.setTextColor(getResources().getColor(reactionUnitHeaderFieldsModel.b().fS_() ? 2131361917 : 2131361974));
        }
        m24702a(reactionAttachmentListener, this.f21069j, this.f21070k, view, this.f21061b.m22676a(reactionUnitHeaderFieldsModel.b(), getContext(), str, this.f21063d.getSessionId(), this.f21063d.getSurface(), this.f21069j));
    }

    private static void m24697a(View view, TextView textView, TextView textView2) {
        textView.setGravity(17);
        textView2.setGravity(17);
        ((ImageBlockLayout) view).setShowThumbnail(false);
    }

    private static void m24698a(View view, ReactionUnitHeaderFieldsModel reactionUnitHeaderFieldsModel, TextView textView, TextView textView2) {
        textView2.setGravity(3);
        textView.setGravity(3);
        textView2.setGravity(8388611);
        textView.setGravity(8388611);
        ImageBlockLayout imageBlockLayout = (ImageBlockLayout) view;
        imageBlockLayout.setThumbnailPlaceholderResource(2131361970);
        ReactionImageFields d = reactionUnitHeaderFieldsModel.d();
        if (d != null && !Strings.isNullOrEmpty(d.b())) {
            imageBlockLayout.setThumbnailUri(d.b());
            imageBlockLayout.setShowThumbnail(true);
        }
    }

    private void m24705a(@Nullable ReactionAttachmentsModel reactionAttachmentsModel, ReactionUnitDefaultFields reactionUnitDefaultFields, ReactionAttachmentListener reactionAttachmentListener) {
        if (reactionAttachmentsModel == null) {
            this.f21074o.setVisibility(8);
            return;
        }
        LinkedHashMap a = m24696a(reactionAttachmentsModel, reactionUnitDefaultFields);
        if (a == null || a.size() == 0) {
            this.f21074o.setVisibility(8);
            return;
        }
        this.f21074o.setVisibility(0);
        SegmentedLinearLayout segmentedLinearLayout = (SegmentedLinearLayout) LayoutInflater.from(getContext()).inflate(2130906621, this.f21074o, false);
        ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel;
        if (a.size() == 1) {
            reactionStoryAttachmentActionFragmentModel = (ReactionStoryAttachmentActionFragmentModel) a.keySet().iterator().next();
            m24700a(segmentedLinearLayout, reactionStoryAttachmentActionFragmentModel, (ReactionAttachmentIntent) a.get(reactionStoryAttachmentActionFragmentModel), (TextView) LayoutInflater.from(getContext()).inflate(2130906633, segmentedLinearLayout, false), reactionAttachmentListener, Boolean.valueOf(false));
            segmentedLinearLayout.setOnTouchListener(new CardFooterOnTouchListener());
        } else if (a.size() > 1) {
            for (ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel2 : a.keySet()) {
                TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(2130906631, segmentedLinearLayout, false);
                m24700a(segmentedLinearLayout, reactionStoryAttachmentActionFragmentModel2, (ReactionAttachmentIntent) a.get(reactionStoryAttachmentActionFragmentModel2), textView, reactionAttachmentListener, Boolean.valueOf(true));
                textView.setOnTouchListener(new HighlightViewOnTouchListener());
            }
        }
        this.f21074o.addView(segmentedLinearLayout);
    }

    private LinkedHashMap<ReactionStoryAttachmentActionFragment, ReactionAttachmentIntent> m24696a(ReactionAttachments reactionAttachments, ReactionUnitDefaultFields reactionUnitDefaultFields) {
        LinkedHashMap<ReactionStoryAttachmentActionFragment, ReactionAttachmentIntent> linkedHashMap = new LinkedHashMap();
        ImmutableList a = reactionAttachments.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            String str;
            ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel = (ReactionStoryAttachmentActionFragmentModel) a.get(i);
            if (reactionUnitDefaultFields.fw_() == null || reactionUnitDefaultFields.fw_().fA_() == null) {
                str = null;
            } else {
                str = reactionUnitDefaultFields.fw_().fA_().a();
            }
            ReactionAttachmentIntent a2 = this.f21061b.m22676a(reactionStoryAttachmentActionFragmentModel, getContext(), str, this.f21063d.getSessionId(), this.f21063d.getSurface(), this.f21069j);
            if (!(a2 == null || reactionStoryAttachmentActionFragmentModel.fU_() == null || Strings.isNullOrEmpty(reactionStoryAttachmentActionFragmentModel.fU_().a()))) {
                linkedHashMap.put(reactionStoryAttachmentActionFragmentModel, a2);
            }
        }
        return linkedHashMap;
    }

    private void m24702a(ReactionAttachmentListener reactionAttachmentListener, String str, String str2, View view, ReactionAttachmentIntent reactionAttachmentIntent) {
        final ReactionAttachmentListener reactionAttachmentListener2 = reactionAttachmentListener;
        final String str3 = str;
        final String str4 = str2;
        final ReactionAttachmentIntent reactionAttachmentIntent2 = reactionAttachmentIntent;
        view.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ReactionCardView f21054e;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 2017875041);
                reactionAttachmentListener2.mo981a(str3, str4, reactionAttachmentIntent2);
                this.f21054e.f21066g.m24384a(str3, reactionAttachmentIntent2, this.f21054e.f21063d, this.f21054e.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, 1913361019, a);
            }
        });
    }

    private void m24706a(@Nullable TextWithEntitiesView textWithEntitiesView, final String str, final String str2, @Nullable LinkableTextWithEntities linkableTextWithEntities, final ReactionAttachmentListener reactionAttachmentListener) {
        if (textWithEntitiesView != null) {
            if (linkableTextWithEntities == null || Strings.isNullOrEmpty(linkableTextWithEntities.a())) {
                textWithEntitiesView.setVisibility(8);
                return;
            }
            textWithEntitiesView.a(linkableTextWithEntities, new LinkableEntityListener(this) {
                final /* synthetic */ ReactionCardView f21058d;

                public final void m24695a(GetEntityFbLinkGraphQL getEntityFbLinkGraphQL) {
                    ReactionAttachmentIntent a = this.f21058d.f21065f.m22734a(getEntityFbLinkGraphQL);
                    if (a != null) {
                        reactionAttachmentListener.mo981a(str, str2, a);
                        this.f21058d.f21066g.m24384a(str, a, this.f21058d.f21063d, this.f21058d.getContext());
                    }
                }
            });
            textWithEntitiesView.setVisibility(0);
        }
    }

    @VisibleForTesting
    ReactionActionHandler getActionHandler() {
        return this.f21061b;
    }

    @VisibleForTesting
    ReactionAttachmentStyleMapper getAttachmentStyleMapper() {
        return this.f21062c;
    }
}
