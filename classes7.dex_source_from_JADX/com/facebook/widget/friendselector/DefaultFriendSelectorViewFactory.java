package com.facebook.widget.friendselector;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.friendselector.GenericFriendsSelectorFragment.FriendSelectorViewFactory;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView;

/* compiled from: de5d0d34f15eb81a4800f5c09331fbbf */
public class DefaultFriendSelectorViewFactory implements FriendSelectorViewFactory {
    public static DefaultFriendSelectorViewFactory m20042a(InjectorLike injectorLike) {
        return new DefaultFriendSelectorViewFactory();
    }

    public final View mo1226a(ViewGroup viewGroup, LayoutInflater layoutInflater) {
        return layoutInflater.inflate(2130904502, viewGroup, false);
    }

    public final TextView mo1227a(View view) {
        return (TextView) view.findViewById(2131562304);
    }

    public final View mo1228b(View view) {
        return view.findViewById(2131562302);
    }

    public final BetterListView mo1229c(View view) {
        return (BetterListView) view.findViewById(2131562303);
    }

    public final TokenizedAutoCompleteTextView mo1230d(View view) {
        return (TokenizedAutoCompleteTextView) view.findViewById(2131562301);
    }

    public final View mo1231e(View view) {
        return view.findViewById(2131562299);
    }

    public final View mo1232f(View view) {
        return view.findViewById(2131562300);
    }

    public final ViewStub mo1233g(View view) {
        return (ViewStub) view.findViewById(2131562305);
    }
}
