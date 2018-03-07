package com.facebook.redspace.ui;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.locale.Locales;
import com.facebook.common.time.TimeConversions;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.LayoutParams;
import com.facebook.feed.util.composer.launch.FeedComposerLauncherProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.redspace.abtest.RedSpaceStrings;
import com.facebook.redspace.data.RedSpaceTimeHelper;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsQueryModel.ActorModel.RedspaceModel.RecentStoryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsQueryModel.ActorModel.RedspaceModel.RecentStoryModel.NodesModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceVisitFragmentModel;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User;
import java.util.List;

/* compiled from: PRIVACY_REVIEW_WRITE_SENT */
public class RedSpaceHomeComposerView extends ContentView {
    private static final CallerContext f12332h = CallerContext.a(RedSpaceHomeComposerView.class, "red_space_grid");
    @Inject
    private LoggedInUserSessionManager f12333i;
    @Inject
    private FeedComposerLauncherProvider f12334j;
    @Inject
    private Locales f12335k;
    @Inject
    private RedSpaceStrings f12336l;
    @Inject
    private QeAccessor f12337m;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceTimeHelper> f12338n;
    private User f12339o;
    private boolean f12340p;
    private RedSpaceGridSeenStateView f12341q;
    public FbDraweeView f12342r;

    private static <T extends View> void m12757a(Class<T> cls, T t) {
        m12758a((Object) t, t.getContext());
    }

    private static void m12758a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RedSpaceHomeComposerView) obj).m12756a(LoggedInUserSessionManager.a(fbInjector), (FeedComposerLauncherProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FeedComposerLauncherProvider.class), Locales.a(fbInjector), RedSpaceStrings.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), IdBasedLazy.a(fbInjector, 10176));
    }

    public RedSpaceHomeComposerView(Context context) {
        this(context, null);
    }

    private void m12756a(LoggedInUserAuthDataStore loggedInUserAuthDataStore, FeedComposerLauncherProvider feedComposerLauncherProvider, Locales locales, RedSpaceStrings redSpaceStrings, QeAccessor qeAccessor, com.facebook.inject.Lazy<RedSpaceTimeHelper> lazy) {
        this.f12333i = loggedInUserAuthDataStore;
        this.f12334j = feedComposerLauncherProvider;
        this.f12335k = locales;
        this.f12336l = redSpaceStrings;
        this.f12337m = qeAccessor;
        this.f12338n = lazy;
    }

    public RedSpaceHomeComposerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12338n = UltralightRuntime.b;
        m12760f();
    }

    private void m12760f() {
        m12757a(RedSpaceHomeComposerView.class, (View) this);
        setContentView(2130906775);
        this.f12342r = (FbDraweeView) this.f;
        this.f12341q = (RedSpaceGridSeenStateView) getView(2131566869);
        m12759a(false);
        this.f12339o = this.f12333i.c();
        if (this.f12339o != null) {
            m12761g();
        }
    }

    public View getImageView() {
        return this.f12342r;
    }

    public void setOnHeaderClickedListener(OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    private void m12761g() {
        setTag(this.f12339o.a);
        ((TextView) getView(2131566867)).setText(this.f12339o.k());
        this.f12342r.a(Uri.parse(this.f12339o.x()), f12332h);
    }

    public final void m12763a(List<RedSpaceVisitFragmentModel> list, int i) {
        this.f12341q.m12754a(list, i);
        m12759a(!list.isEmpty());
    }

    public final void m12762a(RecentStoryModel recentStoryModel) {
        if (recentStoryModel == null || recentStoryModel.a().isEmpty() || ((NodesModel) recentStoryModel.a().get(0)).a() == 0) {
            setSubtitleText(null);
            return;
        }
        setSubtitleText(this.f12336l.c(((RedSpaceTimeHelper) this.f12338n.get()).m12323a(TimeConversions.o(((NodesModel) recentStoryModel.a().get(0)).a()))));
    }

    private void m12759a(boolean z) {
        if (this.f12340p != z) {
            removeView(this.f12341q);
            m12755a(this.f12341q, z);
            addView(this.f12341q);
            this.f12340p = z;
        }
    }

    private static void m12755a(View view, boolean z) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.b = z;
        view.setLayoutParams(layoutParams);
        view.setVisibility(z ? 0 : 8);
    }
}
