package com.facebook.timeline.aboutpage.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.friending.center.constants.FriendsCenterSource;
import com.facebook.friendlist.constants.FriendListSource;
import com.facebook.friendlist.constants.FriendListType;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.inject.FbInjector;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.MutualFriendsInfo;
import com.facebook.timeline.aboutpage.StandardCollectionSizes;
import com.facebook.widget.CustomLinearLayout;
import java.util.List;
import javax.inject.Inject;

/* compiled from: Ljava/nio/ByteBuffer; */
public class ListCollectionView extends CustomLinearLayout {
    @Inject
    public StandardCollectionSizes f13880a;
    private final int f13881b = 4;
    private final View f13882c = LayoutInflater.from(getContext()).inflate(2130903591, this, false);

    public static void m15013a(Object obj, Context context) {
        ((ListCollectionView) obj).f13880a = StandardCollectionSizes.m13827a(FbInjector.get(context));
    }

    protected ListCollectionView(Context context) {
        int i = 0;
        super(context);
        Class cls = ListCollectionView.class;
        m15013a(this, getContext());
        addView(this.f13882c, 0);
        while (i < this.f13881b) {
            addView(new ListCollectionItemView(context));
            i++;
        }
        setOrientation(1);
    }

    protected final void m15014a(List<ListCollectionItemData> list, ProfileViewerContext profileViewerContext, MutualFriendsInfo mutualFriendsInfo, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType, IFeedIntentBuilder iFeedIntentBuilder) {
        int min = Math.min(list.size(), this.f13881b);
        int i = 0;
        while (i < min) {
            ListCollectionItemView listCollectionItemView = (ListCollectionItemView) getChildAt(i + 1);
            listCollectionItemView.m15010a((ListCollectionItemData) list.get(i), profileViewerContext);
            listCollectionItemView.setVisibility(0);
            View findViewById = listCollectionItemView.findViewById(2131560343);
            if (i == min - 1) {
                findViewById.setVisibility(4);
            } else {
                findViewById.setVisibility(0);
            }
            i++;
        }
        for (int i2 = i; i2 < this.f13881b; i2++) {
            getChildAt(i2 + 1).setVisibility(8);
        }
        if (graphQLTimelineAppSectionType == null || !graphQLTimelineAppSectionType.equals(GraphQLTimelineAppSectionType.FRIENDS)) {
            this.f13882c.setVisibility(8);
            return;
        }
        this.f13882c.setVisibility(0);
        m15012a(profileViewerContext, mutualFriendsInfo, iFeedIntentBuilder);
    }

    private void m15012a(ProfileViewerContext profileViewerContext, MutualFriendsInfo mutualFriendsInfo, final IFeedIntentBuilder iFeedIntentBuilder) {
        String str;
        TextView textView = (TextView) this.f13882c.findViewById(2131560364);
        ImageView imageView = (ImageView) this.f13882c.findViewById(2131560361);
        IconFacepileView iconFacepileView = (IconFacepileView) this.f13882c.findViewById(2131560362);
        String formatStrLocaleSafe;
        if (profileViewerContext.f()) {
            formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.cc, FriendsCenterSource.TIMELINE_ABOUT_FRIENDS_APP.name());
            textView.setText(2131233242);
            imageView.setImageResource(2130838110);
            imageView.setVisibility(0);
            iconFacepileView.setVisibility(8);
            str = formatStrLocaleSafe;
        } else {
            formatStrLocaleSafe = StringLocaleUtil.a(FBLinks.bf, new Object[]{profileViewerContext.a, FriendListType.MUTUAL_FRIENDS.name(), FriendListSource.TIMELINE_ABOUT_FRIENDS_APP_MUTUAL_FRIENDS_LINK.name()});
            if (mutualFriendsInfo.f13048a < 2 || !GraphQLFriendshipStatus.ARE_FRIENDS.equals(profileViewerContext.c)) {
                this.f13882c.setVisibility(8);
                str = formatStrLocaleSafe;
            } else {
                textView.setText(getContext().getResources().getQuantityString(2131689520, mutualFriendsInfo.f13048a, new Object[]{Integer.valueOf(mutualFriendsInfo.f13048a)}));
                iconFacepileView.m14990a(mutualFriendsInfo.f13049b);
                imageView.setVisibility(4);
                iconFacepileView.setVisibility(0);
                str = formatStrLocaleSafe;
            }
        }
        this.f13882c.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ListCollectionView f13879c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1023430733);
                iFeedIntentBuilder.a(view.getContext(), str);
                Logger.a(2, EntryType.UI_INPUT_END, 117767756, a);
            }
        });
    }
}
