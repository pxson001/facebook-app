package com.facebook.redspace.ui.friendslist;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.redspace.data.RedSpaceFriendsSection;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: PRIVACY_CHECKUP_REVIEW_STEP_CLOSE */
public class RedSpaceFriendsItemViewGrid extends CustomLinearLayout implements RedSpaceFriendsItemView {
    private TextView f12457a;
    private TextView f12458b;
    private RedSpaceFriendsItemImageView f12459c;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RedSpaceFriendsItemHelper> f12460d = UltralightRuntime.b;

    private static <T extends View> void m12860a(Class<T> cls, T t) {
        m12861a((Object) t, t.getContext());
    }

    private static void m12861a(Object obj, Context context) {
        ((RedSpaceFriendsItemViewGrid) obj).f12460d = IdBasedLazy.a(FbInjector.get(context), 10223);
    }

    public RedSpaceFriendsItemViewGrid(Context context) {
        super(context);
        m12858a();
    }

    public RedSpaceFriendsItemViewGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12858a();
    }

    public RedSpaceFriendsItemViewGrid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12858a();
    }

    private void m12858a() {
        m12860a(RedSpaceFriendsItemViewGrid.class, (View) this);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1962364464);
        super.onFinishInflate();
        this.f12457a = (TextView) a(2131566856);
        this.f12458b = (TextView) a(2131566857);
        this.f12459c = (RedSpaceFriendsItemImageView) a(2131566855);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1555610579, a);
    }

    public final void mo353a(RedSpaceFriendsSection redSpaceFriendsSection, RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, boolean z) {
        String a = GraphQLHelper.a(redSpaceFeedProfileFragmentModel.n());
        int b = ((RedSpaceFriendsItemHelper) this.f12460d.get()).m12848b(redSpaceFeedProfileFragmentModel);
        TextView textView = this.f12457a;
        this.f12460d.get();
        textView.setText(RedSpaceFriendsItemHelper.m12845a(a, b));
        CharSequence a2 = ((RedSpaceFriendsItemHelper) this.f12460d.get()).m12847a(redSpaceFeedProfileFragmentModel);
        this.f12458b.setText(a2);
        this.f12458b.setVisibility(TextUtils.isEmpty(a2) ? 8 : 0);
        setTag(redSpaceFeedProfileFragmentModel.k());
        this.f12459c.m12856a(redSpaceFriendsSection, redSpaceFeedProfileFragmentModel);
    }

    private void m12859a(com.facebook.inject.Lazy<RedSpaceFriendsItemHelper> lazy) {
        this.f12460d = lazy;
    }

    public void setOnProfileClickListener(OnClickListener onClickListener) {
        this.f12459c.setOnClickListener(onClickListener);
    }

    public void setOnProfileLongClickListener(OnLongClickListener onLongClickListener) {
        this.f12459c.setOnLongClickListener(onLongClickListener);
    }
}
