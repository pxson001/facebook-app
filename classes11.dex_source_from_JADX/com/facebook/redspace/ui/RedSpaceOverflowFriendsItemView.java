package com.facebook.redspace.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.redspace.abtest.RedSpaceStrings;
import com.facebook.redspace.data.RedSpaceFriendsSection;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.ui.friendslist.RedSpaceFriendsItemHelper;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;

/* compiled from: PRIVACY_REVIEW_WRITE_FAILURE */
public class RedSpaceOverflowFriendsItemView extends ContentView implements OnClickListener, OnLongClickListener {
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceFriendOptionsHelper> f12347h = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceStrings> f12348i = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceFriendsItemHelper> f12349j = UltralightRuntime.b;
    private RedSpaceFeedProfileFragmentModel f12350k;
    private RedSpaceFriendsSection f12351l;

    private static <T extends View> void m12768a(Class<T> cls, T t) {
        m12769a((Object) t, t.getContext());
    }

    private static void m12769a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RedSpaceOverflowFriendsItemView) obj).m12767a(IdBasedLazy.a(fbInjector, 10220), IdBasedLazy.a(fbInjector, 3264), IdBasedLazy.a(fbInjector, 10223));
    }

    public RedSpaceOverflowFriendsItemView(Context context) {
        super(context);
        m12770f();
    }

    public RedSpaceOverflowFriendsItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12770f();
    }

    public RedSpaceOverflowFriendsItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12770f();
    }

    private void m12770f() {
        setContentView(2130906769);
        m12768a(RedSpaceOverflowFriendsItemView.class, (View) this);
        setOnLongClickListener(this);
        setOnClickListener(this);
    }

    public boolean onLongClick(View view) {
        if (this.f12350k == null || this.f12351l == null) {
            return false;
        }
        ((RedSpaceFriendOptionsHelper) this.f12347h.get()).m12741a(getContext(), view, this.f12350k, this.f12351l);
        return true;
    }

    public final void m12771a(RedSpaceFriendsSection redSpaceFriendsSection, RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        setSubtitleText(((RedSpaceFriendsItemHelper) this.f12349j.get()).m12847a(redSpaceFeedProfileFragmentModel));
        setTitleText(redSpaceFeedProfileFragmentModel.n().s_());
        setThumbnailUri(redSpaceFeedProfileFragmentModel.l() == null ? null : redSpaceFeedProfileFragmentModel.l().b());
        this.f12351l = redSpaceFriendsSection;
        this.f12350k = redSpaceFeedProfileFragmentModel;
    }

    private void m12767a(com.facebook.inject.Lazy<RedSpaceFriendOptionsHelper> lazy, com.facebook.inject.Lazy<RedSpaceStrings> lazy2, com.facebook.inject.Lazy<RedSpaceFriendsItemHelper> lazy3) {
        this.f12347h = lazy;
        this.f12348i = lazy2;
        this.f12349j = lazy3;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 978305788);
        ((RedSpaceFriendOptionsHelper) this.f12347h.get()).m12742a(getContext(), this.f12350k, "person_list");
        Logger.a(2, EntryType.UI_INPUT_END, -661149035, a);
    }
}
