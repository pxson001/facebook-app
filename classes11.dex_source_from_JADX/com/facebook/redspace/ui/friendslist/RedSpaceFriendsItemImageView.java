package com.facebook.redspace.ui.friendslist;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.redspace.data.RedSpaceFeedProfileUnreadStoriesHelper;
import com.facebook.redspace.data.RedSpaceFriendsSection;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringListener;
import com.facebook.springs.SpringSystem;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: PRIVACY_CHECKUP_WRITE_REQUEST_FAILURE */
public class RedSpaceFriendsItemImageView extends CustomFrameLayout implements RedSpaceFriendsListItemHolder {
    public static final SpringConfig f12445a = SpringConfig.a(70.0d, 5.0d);
    private static final CallerContext f12446b = CallerContext.a(RedSpaceFriendsItemImageView.class, "red_space_grid");
    @Inject
    private SpringSystem f12447c;
    @Inject
    private RedSpaceFeedProfileUnreadStoriesHelper f12448d;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<Resources> f12449e = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceFriendsItemHelper> f12450f = UltralightRuntime.b;
    private RedSpaceFeedProfileFragmentModel f12451g;
    private RedSpaceFriendsSection f12452h;
    private Spring f12453i;
    private SpringListener f12454j;
    private FbDraweeView f12455k;
    private TextView f12456l;

    /* compiled from: PRIVACY_CHECKUP_WRITE_REQUEST_FAILURE */
    class C14741 extends SimpleSpringListener {
        final /* synthetic */ RedSpaceFriendsItemImageView f12444a;

        C14741(RedSpaceFriendsItemImageView redSpaceFriendsItemImageView) {
            this.f12444a = redSpaceFriendsItemImageView;
        }

        public final void m12850a(Spring spring) {
            float d = (float) spring.d();
            this.f12444a.setScaleX(d);
            this.f12444a.setScaleY(d);
        }
    }

    private static <T extends View> void m12853a(Class<T> cls, T t) {
        m12854a((Object) t, t.getContext());
    }

    private static void m12854a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((RedSpaceFriendsItemImageView) obj).m12852a(SpringSystem.b(injectorLike), RedSpaceFeedProfileUnreadStoriesHelper.m12202a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 30), IdBasedLazy.a(injectorLike, 10223));
    }

    private void m12852a(SpringSystem springSystem, RedSpaceFeedProfileUnreadStoriesHelper redSpaceFeedProfileUnreadStoriesHelper, com.facebook.inject.Lazy<Resources> lazy, com.facebook.inject.Lazy<RedSpaceFriendsItemHelper> lazy2) {
        this.f12447c = springSystem;
        this.f12448d = redSpaceFeedProfileUnreadStoriesHelper;
        this.f12449e = lazy;
        this.f12450f = lazy2;
    }

    public RedSpaceFriendsItemImageView(Context context) {
        super(context);
        m12851a();
    }

    public RedSpaceFriendsItemImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12851a();
    }

    public RedSpaceFriendsItemImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12851a();
    }

    private void m12851a() {
        m12853a(RedSpaceFriendsItemImageView.class, (View) this);
        setContentView(2130906764);
        this.f12455k = (FbDraweeView) c(2131566858);
        this.f12456l = (TextView) c(2131566859);
        this.f12453i = this.f12447c.a().a(f12445a).a(1.0d);
        this.f12454j = new C14741(this);
    }

    protected void dispatchSetPressed(boolean z) {
        super.dispatchSetPressed(z);
        if (m12855b()) {
            this.f12453i.b(z ? 0.8500000238418579d : 1.0d);
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -566344431);
        super.onAttachedToWindow();
        if (m12855b()) {
            this.f12453i.a(this.f12454j);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1345472382, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2033623530);
        super.onDetachedFromWindow();
        if (m12855b()) {
            this.f12453i.b(this.f12454j);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 714941064, a);
    }

    private boolean m12855b() {
        return isClickable();
    }

    public final void m12856a(RedSpaceFriendsSection redSpaceFriendsSection, RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        setImageURI(Uri.parse(redSpaceFeedProfileFragmentModel.l().b()));
        setBadgeCount(((RedSpaceFriendsItemHelper) this.f12450f.get()).m12849c(redSpaceFeedProfileFragmentModel));
        setContentDescription(GraphQLHelper.a(redSpaceFeedProfileFragmentModel.n()));
        setTag(redSpaceFeedProfileFragmentModel.k());
        this.f12451g = redSpaceFeedProfileFragmentModel;
        this.f12452h = redSpaceFriendsSection;
    }

    private void setBadgeCount(@Nullable CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f12456l.setVisibility(8);
            return;
        }
        this.f12456l.setVisibility(0);
        this.f12456l.setText(charSequence);
    }

    private void setImageURI(Uri uri) {
        this.f12455k.a(uri, f12446b);
    }

    public View getProfilePictureView() {
        return this.f12455k;
    }

    public RedSpaceFeedProfileFragmentModel getProfile() {
        return this.f12451g;
    }

    public RedSpaceFriendsSection getSection() {
        return this.f12452h;
    }
}
