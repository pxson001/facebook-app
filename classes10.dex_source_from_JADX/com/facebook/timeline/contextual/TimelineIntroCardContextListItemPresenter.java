package com.facebook.timeline.contextual;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.graphql.enums.GraphQLTimelineContextListItemType;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.presenter.Presenter;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineContextListItemFieldsModel;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

/* compiled from: group_mediaset_page_cursor */
public class TimelineIntroCardContextListItemPresenter extends Presenter<BetterTextView> {
    private final AllCapsTransformationMethod f10344a;
    public final ProfileControllerDelegate f10345b;
    @Nullable
    public final TimelineContextListItemFieldsModel f10346c;
    private final boolean f10347d;
    private final OnClickListener f10348e = new C15221(this);

    /* compiled from: group_mediaset_page_cursor */
    class C15221 implements OnClickListener {
        final /* synthetic */ TimelineIntroCardContextListItemPresenter f10343a;

        C15221(TimelineIntroCardContextListItemPresenter timelineIntroCardContextListItemPresenter) {
            this.f10343a = timelineIntroCardContextListItemPresenter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1765605823);
            this.f10343a.f10345b.mo482r().mo504a(this.f10343a.f10346c, true);
            Logger.a(2, EntryType.UI_INPUT_END, -32363946, a);
        }
    }

    public final /* bridge */ /* synthetic */ void m10476b(Object obj) {
    }

    @Inject
    public TimelineIntroCardContextListItemPresenter(@Assisted TimelineContextListItemFieldsModel timelineContextListItemFieldsModel, @Assisted Boolean bool, AllCapsTransformationMethod allCapsTransformationMethod, ProfileControllerDelegate profileControllerDelegate) {
        this.f10346c = timelineContextListItemFieldsModel;
        this.f10347d = bool.booleanValue();
        this.f10344a = allCapsTransformationMethod;
        this.f10345b = profileControllerDelegate;
    }

    protected final void m10475b() {
        super.b();
        BetterTextView betterTextView = (BetterTextView) a().orNull();
        if (betterTextView != null && this.f10346c != null && this.f10346c.g() != null) {
            if (this.f10346c.dr_() == GraphQLTimelineContextListItemType.SELF_TIMELINE_REVIEW) {
                betterTextView.setTransformationMethod(this.f10344a);
            }
            betterTextView.setText(this.f10346c.g().a());
            Object obj = null;
            if (this.f10347d || this.f10346c.dr_() == GraphQLTimelineContextListItemType.BIRTHDAY) {
                obj = 1;
            }
            betterTextView.setTextColor(betterTextView.getResources().getColor(obj != null ? 2131361917 : 2131361937));
            betterTextView.setOnClickListener(this.f10348e);
        }
    }
}
