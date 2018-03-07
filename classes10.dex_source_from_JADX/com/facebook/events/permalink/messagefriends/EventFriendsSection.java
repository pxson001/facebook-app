package com.facebook.events.permalink.messagefriends;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.events.graphql.EventFriendsGraphQLInterfaces.BasicEventGuest;
import com.facebook.events.graphql.EventFriendsGraphQLModels.BasicEventGuestModel;
import com.facebook.events.permalink.guestlist.common.EventGuestListType;
import com.facebook.fbui.widget.contentview.CheckedContentView;
import com.facebook.widget.sectionedadapter.SectionedAdapterForRecyclerView.SectionAdapter;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;

/* compiled from: birthday_click_compose_button */
public class EventFriendsSection extends SectionAdapter {
    private final ImmutableList<? extends BasicEventGuest> f18612a;
    private final LayoutInflater f18613b;
    private final EventGuestListType f18614c;
    public final HashSet<String> f18615d = new HashSet();

    /* compiled from: birthday_click_compose_button */
    /* synthetic */ class C26451 {
        static final /* synthetic */ int[] f18611a = new int[EventGuestListType.values().length];

        static {
            try {
                f18611a[EventGuestListType.PUBLIC_GOING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18611a[EventGuestListType.PUBLIC_WATCHED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18611a[EventGuestListType.PUBLIC_INVITED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: birthday_click_compose_button */
    public @interface ItemViewType {
    }

    public EventFriendsSection(Context context, ImmutableList<? extends BasicEventGuest> immutableList, EventGuestListType eventGuestListType) {
        this.f18612a = immutableList;
        this.f18613b = LayoutInflater.from(context);
        this.f18614c = eventGuestListType;
    }

    public final View m18931d(ViewGroup viewGroup, int i) {
        return this.f18613b.inflate(m18929f(i), viewGroup, false);
    }

    public final void m18930a(View view, int i) {
        switch (getItemViewType(i)) {
            case 0:
                CheckedContentView checkedContentView = (CheckedContentView) view;
                BasicEventGuestModel basicEventGuestModel = (BasicEventGuestModel) this.f18612a.get(i - 1);
                checkedContentView.setTitleText(basicEventGuestModel.c());
                if (basicEventGuestModel.d() != null) {
                    checkedContentView.setThumbnailUri(basicEventGuestModel.d().b());
                } else {
                    checkedContentView.setThumbnailUri(null);
                }
                checkedContentView.setChecked(this.f18615d.contains(basicEventGuestModel.b()));
                return;
            case 1:
                ((TextView) view).setText(m18928a(this.f18614c));
                return;
            default:
                throw new IllegalArgumentException("Unknown View Type");
        }
    }

    public int getViewTypeCount() {
        return 2;
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return 1;
        }
        return 0;
    }

    public int getCount() {
        int size = this.f18612a.size();
        return size > 0 ? size + 1 : 0;
    }

    public Object getItem(int i) {
        if (i == 0) {
            return this.f18614c;
        }
        return this.f18612a.get(i - 1);
    }

    private static int m18929f(int i) {
        switch (i) {
            case 0:
                return 2130904049;
            case 1:
                return 2130904048;
            default:
                throw new IllegalArgumentException("Unknown View Type");
        }
    }

    private static int m18928a(EventGuestListType eventGuestListType) {
        switch (C26451.f18611a[eventGuestListType.ordinal()]) {
            case 1:
                return 2131237238;
            case 2:
                return 2131237239;
            case 3:
                return 2131237240;
            default:
                throw new IllegalArgumentException("Unknown or non-public guest list type.");
        }
    }
}
