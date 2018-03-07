package com.facebook.pages.fb4a.videohub.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ListView;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.text.BadgeTextView;
import com.facebook.pages.common.ui.widgets.ExpandableTextView;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLInterfaces.VideoDetailFragment;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;
import java.util.List;

/* compiled from: privacy_review_write_timeout */
public class PageVideoListCardWithVideos extends CustomFrameLayout {
    private final BadgeTextView f3100a;
    private final ExpandableTextView f3101b;
    private final BetterListView f3102c;

    /* compiled from: privacy_review_write_timeout */
    class DarkListViewMagic {
        public static void m4207a(ListView listView) {
            listView.measure(listView.getWidth(), MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
            listView.getLayoutParams().height = listView.getMeasuredHeight();
        }
    }

    /* compiled from: privacy_review_write_timeout */
    class VideoListsVideosAdapter extends FbBaseAdapter {
        private List<VideoDetailFragment> f3099a;

        public VideoListsVideosAdapter(List<VideoDetailFragment> list) {
            this.f3099a = list;
        }

        public final View m4208a(int i, ViewGroup viewGroup) {
            return new PageVideoListItem(viewGroup.getContext());
        }

        public final void m4209a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
            ((PageVideoListItem) view).m4214a((VideoDetailFragmentModel) obj);
        }

        public int getCount() {
            return this.f3099a.size();
        }

        public Object getItem(int i) {
            return (VideoDetailFragmentModel) this.f3099a.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }
    }

    public PageVideoListCardWithVideos(Context context, int i) {
        this(context, null, i);
    }

    private PageVideoListCardWithVideos(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130907688);
        this.f3100a = (BadgeTextView) c(2131568358);
        this.f3101b = (ExpandableTextView) c(2131568359);
        this.f3102c = (BetterListView) c(2131568360);
        CustomFontHelper.a(this.f3100a, FontFamily.ROBOTO, FontWeight.MEDIUM, this.f3100a.getTypeface());
        CustomFontHelper.a(this.f3101b, FontFamily.ROBOTO, FontWeight.LIGHT, this.f3101b.getTypeface());
    }

    public final void m4210a(List<VideoDetailFragment> list, String str, String str2) {
        this.f3100a.setText(str);
        BadgeTextView badgeTextView = this.f3100a;
        Resources resources = getResources();
        int size = list.size();
        Object[] objArr = new Object[1];
        objArr[0] = StringLocaleUtil.a("%,d", new Object[]{Integer.valueOf(list.size())});
        badgeTextView.setBadgeText(resources.getQuantityString(2131689620, size, objArr));
        if (StringUtil.a(str2)) {
            this.f3101b.setVisibility(8);
        } else {
            this.f3101b.setVisibility(0);
            this.f3101b.setText(str2);
        }
        this.f3101b.f2722e = true;
        this.f3102c.setAdapter(new VideoListsVideosAdapter(list));
        DarkListViewMagic.m4207a(this.f3102c);
    }
}
