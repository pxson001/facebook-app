package com.facebook.tablet.sideshow.pymk.ui;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.glyph.GlyphButton;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tablet.sideshow.pymk.events.SideshowFriendingEvents.FriendRequestClickedEvent;
import com.facebook.tablet.sideshow.pymk.model.PeopleYouMayKnowRow;
import com.facebook.widget.text.BetterTextView;

/* compiled from: onDrawerOpen */
public class PeopleYouMayKnowRowView extends ContentView {
    public PeopleYouMayKnowRow f4784h;
    public GlyphButton f4785i;
    public BetterTextView f4786j;
    public BetterTextView f4787k;
    public FeedEventBus f4788l;

    /* compiled from: onDrawerOpen */
    public class C06481 implements OnClickListener {
        final /* synthetic */ PeopleYouMayKnowRowView f4782a;

        public C06481(PeopleYouMayKnowRowView peopleYouMayKnowRowView) {
            this.f4782a = peopleYouMayKnowRowView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1525865072);
            PeopleYouMayKnowRowView peopleYouMayKnowRowView = this.f4782a;
            switch (C06492.f4783a[peopleYouMayKnowRowView.f4784h.f4777f.ordinal()]) {
                case 1:
                    peopleYouMayKnowRowView.setFriendRequestStatus(GraphQLFriendshipStatus.OUTGOING_REQUEST);
                    break;
                case 2:
                    peopleYouMayKnowRowView.setFriendRequestStatus(GraphQLFriendshipStatus.CAN_REQUEST);
                    break;
            }
            Logger.a(2, EntryType.UI_INPUT_END, 2129196333, a);
        }
    }

    /* compiled from: onDrawerOpen */
    public /* synthetic */ class C06492 {
        public static final /* synthetic */ int[] f4783a = new int[GraphQLFriendshipStatus.values().length];

        static {
            try {
                f4783a[GraphQLFriendshipStatus.CAN_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4783a[GraphQLFriendshipStatus.OUTGOING_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4783a[GraphQLFriendshipStatus.INCOMING_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4783a[GraphQLFriendshipStatus.ARE_FRIENDS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public PeopleYouMayKnowRowView(Context context) {
        super(context);
        setContentView(2130907401);
        setMaxLinesFromThumbnailSize(false);
        if (getBackground() == null) {
            setBackgroundResource(2130839797);
        }
        this.f4785i = (GlyphButton) findViewById(2131567862);
        this.f4787k = (BetterTextView) findViewById(2131562388);
        this.f4786j = (BetterTextView) findViewById(2131567861);
        this.f4785i.setOnClickListener(new C06481(this));
        setShowAuxView(true);
    }

    public final void m5978a(PeopleYouMayKnowRow peopleYouMayKnowRow) {
        this.f4784h = peopleYouMayKnowRow;
        m5977g();
    }

    private void m5977g() {
        if (this.f4784h.f4775d != null) {
            setThumbnailUri(Uri.parse(this.f4784h.f4775d));
        }
        setTitleText(this.f4784h.f4773b);
        if (this.f4784h.f4774c == null) {
            this.f4787k.setVisibility(8);
        } else {
            setSubtitleText(this.f4784h.f4774c);
        }
        switch (C06492.f4783a[this.f4784h.f4777f.ordinal()]) {
            case 1:
                this.f4785i.setImageResource(2130839877);
                this.f4785i.setSelected(false);
                int i = this.f4784h.f4776e;
                if (i > 0) {
                    setMetaText(getResources().getQuantityString(2131689802, i, new Object[]{Integer.valueOf(i)}));
                    this.f4786j.setTextColor(getResources().getColor(2131361937));
                    return;
                }
                this.f4786j.setVisibility(8);
                return;
            case 2:
                this.f4785i.setImageResource(2130839892);
                this.f4785i.setSelected(true);
                this.f4786j.setText(2131241714);
                this.f4786j.setTextColor(getResources().getColor(2131361917));
                return;
            default:
                this.f4785i.setImageResource(2130839888);
                this.f4785i.setSelected(false);
                this.f4786j.setVisibility(8);
                return;
        }
    }

    public void setFriendRequestStatus(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        switch (C06492.f4783a[graphQLFriendshipStatus.ordinal()]) {
            case 1:
                if (this.f4788l != null) {
                    this.f4788l.a(new FriendRequestClickedEvent(this.f4784h.f4772a, GraphQLFriendshipStatus.OUTGOING_REQUEST, "sideshow"));
                    this.f4784h.f4777f = GraphQLFriendshipStatus.CAN_REQUEST;
                    m5977g();
                    return;
                }
                return;
            case 2:
                if (this.f4788l != null) {
                    this.f4788l.a(new FriendRequestClickedEvent(this.f4784h.f4772a, GraphQLFriendshipStatus.CAN_REQUEST, "sideshow"));
                    this.f4784h.f4777f = GraphQLFriendshipStatus.OUTGOING_REQUEST;
                    m5977g();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
