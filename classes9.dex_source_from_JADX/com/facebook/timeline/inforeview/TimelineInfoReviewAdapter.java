package com.facebook.timeline.inforeview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.identitygrowth.profilequestion.utils.ProfileQuestionHelper;
import com.facebook.inject.Assisted;
import com.facebook.resources.ui.FbButton;
import com.facebook.timeline.event.TimelineHeaderEventBus;
import com.facebook.timeline.inforeview.PlutoniumProfileQuestionView.C00853;
import com.facebook.timeline.protocol.TimelineInfoReviewGraphQLModels.InfoReviewItemFragmentModel;
import com.facebook.timeline.protocol.TimelineInfoReviewGraphQLModels.InfoReviewItemsFragmentModel;
import com.facebook.timeline.protocol.TimelineInfoReviewGraphQLModels.InfoReviewOverflowLinkModel;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: uploadAdImage */
public class TimelineInfoReviewAdapter extends FbBaseAdapter {
    private final Context f909a;
    public final AbstractFbErrorReporter f910b;
    private final TimelineHeaderEventBus f911c;
    private final InfoReviewHandler f912d;
    private final TimelineInfoReviewData f913e;

    /* compiled from: uploadAdImage */
    public enum ViewTypes {
        COLLAPSED_ITEM,
        EXPANDED_PROFILE_QUESTION_ITEM,
        OVERFLOW_LINK,
        UNKNOWN
    }

    @Inject
    public TimelineInfoReviewAdapter(@Assisted Context context, @Assisted TimelineInfoReviewData timelineInfoReviewData, AbstractFbErrorReporter abstractFbErrorReporter, TimelineHeaderEventBus timelineHeaderEventBus, InfoReviewHandler infoReviewHandler) {
        this.f909a = (Context) Preconditions.checkNotNull(context);
        this.f913e = (TimelineInfoReviewData) Preconditions.checkNotNull(timelineInfoReviewData);
        this.f910b = abstractFbErrorReporter;
        this.f911c = timelineHeaderEventBus;
        this.f912d = infoReviewHandler;
    }

    public final View m918a(int i, ViewGroup viewGroup) {
        switch (ViewTypes.values()[i]) {
            case COLLAPSED_ITEM:
                return new InfoReviewItemView(this.f909a);
            case EXPANDED_PROFILE_QUESTION_ITEM:
                return new PlutoniumProfileQuestionView(this.f909a);
            case OVERFLOW_LINK:
                return new InfoReviewOverflowLinkView(this.f909a);
            default:
                throw new IllegalArgumentException("Unknown item type for TimelineInfoReviewAdapter of type " + i);
        }
    }

    public final void m919a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        if ((view instanceof PlutoniumProfileQuestionView) && (obj instanceof InfoReviewItemFragmentModel)) {
            PlutoniumProfileQuestionView plutoniumProfileQuestionView = (PlutoniumProfileQuestionView) view;
            TimelineHeaderEventBus timelineHeaderEventBus = this.f911c;
            InfoReviewItemFragmentModel infoReviewItemFragmentModel = (InfoReviewItemFragmentModel) obj;
            TimelineInfoReviewData timelineInfoReviewData = this.f913e;
            InfoReviewHandler infoReviewHandler = this.f912d;
            boolean z = false;
            plutoniumProfileQuestionView.f896d = timelineInfoReviewData.f914f;
            plutoniumProfileQuestionView.f897e = plutoniumProfileQuestionView.f895c.m914a(timelineHeaderEventBus, timelineInfoReviewData);
            plutoniumProfileQuestionView.f898f = infoReviewItemFragmentModel;
            plutoniumProfileQuestionView.f899g = infoReviewItemFragmentModel.dA_();
            plutoniumProfileQuestionView.f900h = infoReviewItemFragmentModel.j();
            if (plutoniumProfileQuestionView.f896d.f874g) {
                plutoniumProfileQuestionView.a = new ColorDrawable(plutoniumProfileQuestionView.getResources().getColor(2131361877));
                plutoniumProfileQuestionView.f906n.setVisibility(0);
            } else {
                plutoniumProfileQuestionView.a = null;
                plutoniumProfileQuestionView.f906n.setVisibility(8);
            }
            if (ProfileQuestionHelper.a(plutoniumProfileQuestionView.f899g)) {
                plutoniumProfileQuestionView.setVisibility(0);
                plutoniumProfileQuestionView.f902j.m893a(plutoniumProfileQuestionView.f898f, infoReviewHandler, timelineInfoReviewData, timelineHeaderEventBus);
                plutoniumProfileQuestionView.a(2131566161).setVisibility(0);
                plutoniumProfileQuestionView.f907o.setVisibility(0);
                plutoniumProfileQuestionView.f907o.a(plutoniumProfileQuestionView.f896d, plutoniumProfileQuestionView.f899g.dl_());
                plutoniumProfileQuestionView.f903k.setEnabled(true);
                plutoniumProfileQuestionView.f905m.a(plutoniumProfileQuestionView.f899g, plutoniumProfileQuestionView.f896d, false, false);
                plutoniumProfileQuestionView.f905m.g = new C00853(plutoniumProfileQuestionView);
                plutoniumProfileQuestionView.f903k.setText(2131234852);
                plutoniumProfileQuestionView.f903k.setOnClickListener(plutoniumProfileQuestionView.f901i);
                plutoniumProfileQuestionView.f904l.setText(2131230729);
                FbButton fbButton = plutoniumProfileQuestionView.f904l;
                if (plutoniumProfileQuestionView.f896d.m900b() != null) {
                    z = true;
                }
                fbButton.setEnabled(z);
                z = true;
                return;
            }
            plutoniumProfileQuestionView.f893a.a("identitygrowth", "The profileQuestions argument of this function should not be null or empty, please check hasValidData or manually check it before passing in");
            plutoniumProfileQuestionView.f897e.m913b();
        } else if ((view instanceof InfoReviewOverflowLinkView) && (obj instanceof InfoReviewOverflowLinkModel)) {
            ((InfoReviewOverflowLinkView) view).m894a((InfoReviewOverflowLinkModel) obj, this.f912d);
        } else if ((view instanceof InfoReviewItemView) && (obj instanceof InfoReviewItemFragmentModel)) {
            ((InfoReviewItemView) view).m893a((InfoReviewItemFragmentModel) obj, this.f912d, this.f913e, this.f911c);
        }
    }

    public int getCount() {
        if (!this.f913e.d()) {
            return 0;
        }
        int size = ((InfoReviewItemsFragmentModel) this.f913e.a().get()).a().size() + 0;
        return ((InfoReviewItemsFragmentModel) this.f913e.a().get()).b() != null ? size + 1 : size;
    }

    public Object getItem(int i) {
        boolean z = true;
        Preconditions.checkArgument(i >= 0);
        if (i >= getCount()) {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (this.f913e.d()) {
            int size = ((InfoReviewItemsFragmentModel) this.f913e.a().get()).a().size();
            if (!this.f913e.d() || i < size) {
                return ((InfoReviewItemsFragmentModel) this.f913e.a().get()).a().get(i);
            }
            return ((InfoReviewItemsFragmentModel) this.f913e.a().get()).b();
        }
        this.f910b.b("TimelineInfoReviewAdapter.no_valid_data", "No valid info review item for position " + i);
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getViewTypeCount() {
        return ViewTypes.values().length;
    }

    public int getItemViewType(int i) {
        ViewTypes viewTypes;
        Object item = getItem(i);
        if (item instanceof InfoReviewOverflowLinkModel) {
            viewTypes = ViewTypes.OVERFLOW_LINK;
        } else if (item instanceof InfoReviewItemFragmentModel) {
            InfoReviewItemFragmentModel infoReviewItemFragmentModel = (InfoReviewItemFragmentModel) item;
            if (infoReviewItemFragmentModel.dA_() == null || !infoReviewItemFragmentModel.dy_()) {
                viewTypes = ViewTypes.COLLAPSED_ITEM;
            } else {
                viewTypes = ViewTypes.EXPANDED_PROFILE_QUESTION_ITEM;
            }
        } else {
            this.f910b.a("TimelineInfoReviewAdapter.unknown_viewtype", "Unknown view type for position: " + i + " and item: " + (item == null ? null : item.getClass().getCanonicalName()));
            viewTypes = ViewTypes.UNKNOWN;
        }
        return viewTypes.ordinal();
    }
}
