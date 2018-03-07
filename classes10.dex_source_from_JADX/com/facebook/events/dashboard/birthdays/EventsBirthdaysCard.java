package com.facebook.events.dashboard.birthdays;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.events.dashboard.EventsBirthdayRow;
import com.facebook.events.graphql.EventsGraphQLModels.EventUserWithBirthdayFragmentModel;
import com.facebook.events.permalink.EventPermalinkController;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: com.facebook.timeline.header.intro.protocol.bioQueryTag */
public class EventsBirthdaysCard extends CustomLinearLayout {
    @Inject
    public EventPermalinkController f16976a;
    public FbFragment f16977b;
    public CustomLinearLayout f16978c = ((CustomLinearLayout) a(2131561477));
    public Set<String> f16979d;
    public String f16980e;

    /* compiled from: com.facebook.timeline.header.intro.protocol.bioQueryTag */
    public class C23841 implements OnClickListener {
        final /* synthetic */ EventsBirthdaysCard f16975a;

        public C23841(EventsBirthdaysCard eventsBirthdaysCard) {
            this.f16975a = eventsBirthdaysCard;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -326320726);
            this.f16975a.f16976a.m18263a(this.f16975a.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -1118635183, a);
        }
    }

    public static void m17299a(Object obj, Context context) {
        ((EventsBirthdaysCard) obj).f16976a = EventPermalinkController.m18262b(FbInjector.get(context));
    }

    public EventsBirthdaysCard(Context context) {
        super(context);
        Class cls = EventsBirthdaysCard.class;
        m17299a(this, getContext());
        setContentView(2130904113);
        setOrientation(1);
        a(2131561479).setOnClickListener(new C23841(this));
        this.f16979d = Sets.a();
    }

    public final void m17301a(@Nonnull List<EventUserWithBirthdayFragmentModel> list, FbFragment fbFragment, String str) {
        this.f16977b = fbFragment;
        this.f16980e = str;
        if (!list.isEmpty() || this.f16979d.isEmpty()) {
            for (EventUserWithBirthdayFragmentModel m : list) {
                if (!this.f16979d.contains(m.m())) {
                    m17300a(list);
                    return;
                }
            }
            return;
        }
        m17300a(list);
    }

    private void m17300a(@Nonnull List<EventUserWithBirthdayFragmentModel> list) {
        this.f16979d.clear();
        this.f16978c.removeAllViews();
        for (EventUserWithBirthdayFragmentModel eventUserWithBirthdayFragmentModel : list) {
            this.f16979d.add(eventUserWithBirthdayFragmentModel.m());
            CustomLinearLayout customLinearLayout = this.f16978c;
            EventsBirthdayRow eventsBirthdayRow = new EventsBirthdayRow(getContext());
            eventsBirthdayRow.m16940a(eventUserWithBirthdayFragmentModel, this.f16977b, true, false, this.f16980e);
            customLinearLayout.addView(eventsBirthdayRow);
        }
        if (this.f16979d.isEmpty()) {
            this.f16978c.setVisibility(8);
            a(2131561478).setVisibility(0);
            return;
        }
        this.f16978c.setVisibility(0);
        a(2131561478).setVisibility(8);
    }
}
