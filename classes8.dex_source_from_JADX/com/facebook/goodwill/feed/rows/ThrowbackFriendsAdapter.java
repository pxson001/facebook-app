package com.facebook.goodwill.feed.rows;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;

/* compiled from: feed_awesomizer_card_close */
public class ThrowbackFriendsAdapter extends BaseAdapter {
    private final ImmutableList<ThrowbackFriend> f13585a;
    public final FbUriIntentHandler f13586b;
    private GlyphColorizer f13587c;

    public ThrowbackFriendsAdapter(ThrowbackFriendList throwbackFriendList, FbUriIntentHandler fbUriIntentHandler, GlyphColorizer glyphColorizer) {
        this.f13585a = throwbackFriendList.f13579a;
        this.f13586b = fbUriIntentHandler;
        this.f13587c = glyphColorizer;
    }

    public int getCount() {
        return this.f13585a.size();
    }

    public Object getItem(int i) {
        return this.f13585a.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        final ThrowbackFriend throwbackFriend = (ThrowbackFriend) this.f13585a.get(i);
        if (view == null) {
            view = new ContentViewWithButton(viewGroup.getContext());
        } else {
            ContentViewWithButton contentViewWithButton = (ContentViewWithButton) view;
        }
        view.setTitleText(throwbackFriend.f13577c);
        view.setThumbnailUri(throwbackFriend.f13576b);
        view.setThumbnailSize(ThumbnailSize.LARGE);
        view.setActionButtonDrawable(this.f13587c.a(2130839685, -5066062));
        view.setSubtitleText(throwbackFriend.f13578d);
        view.setActionButtonBackground(null);
        view.a.setFocusable(false);
        view.setActionButtonOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ThrowbackFriendsAdapter f13584c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1884720847);
                this.f13584c.f13586b.a(view.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.V, throwbackFriend.f13575a));
                Logger.a(2, EntryType.UI_INPUT_END, 1846186633, a);
            }
        });
        return view;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean isEnabled(int i) {
        return true;
    }
}
