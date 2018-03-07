package com.facebook.redspace.ui.friendslist;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.redspace.abtest.RedSpaceStrings;
import com.facebook.redspace.data.RedSpaceFeedProfileUnreadStoriesHelper;
import com.facebook.redspace.data.RedSpaceFriendsSection;
import com.facebook.redspace.data.RedSpaceTimeHelper;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel.RedspaceModel.RecentStoryModel.NodesModel;
import com.facebook.redspace.ui.RedSpaceFriendOptionsHelper;
import com.facebook.redspace.ui.animation.RedSpaceFadeAnimationHelper;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.annotations.VisibleForTesting;

/* compiled from: PRIVACY_CHECKUP_PROFILE_STEP_PREVIOUS */
public class RedSpaceFriendsItemViewList extends ContentView implements RedSpaceAnimationSupportedView, RedSpaceFriendsItemView, RedSpaceFriendsListItemHolder {
    private static final CallerContext f12462h = CallerContext.a(RedSpaceFriendsItemViewList.class, "red_space_grid");
    private static final int[] f12463i = new int[0];
    private RedSpaceFeedProfileFragmentModel f12464j;
    private RedSpaceFriendsSection f12465k;
    private FbDraweeView f12466l;
    private TextView f12467m;
    private GlyphView f12468n;
    private boolean f12469o;
    private boolean f12470p;
    @Inject
    private Resources f12471q;
    @Inject
    private RedSpaceFeedProfileUnreadStoriesHelper f12472r;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceStrings> f12473s = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceTimeHelper> f12474t = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceFriendsItemHelper> f12475u = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RedSpaceFriendOptionsHelper> f12476v = UltralightRuntime.b;
    private final OnClickListener f12477w = new C14751(this);

    /* compiled from: PRIVACY_CHECKUP_PROFILE_STEP_PREVIOUS */
    class C14751 implements OnClickListener {
        final /* synthetic */ RedSpaceFriendsItemViewList f12461a;

        C14751(RedSpaceFriendsItemViewList redSpaceFriendsItemViewList) {
            this.f12461a = redSpaceFriendsItemViewList;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 14508892);
            RedSpaceFriendsSection section = this.f12461a.getSection();
            RedSpaceFeedProfileFragmentModel profile = this.f12461a.getProfile();
            if (section == null || profile == null) {
                Logger.a(2, EntryType.UI_INPUT_END, 1082975646, a);
                return;
            }
            if (section.isTop()) {
                ((RedSpaceFriendOptionsHelper) this.f12461a.f12476v.get()).m12743a(profile, section, "edit_mode");
            } else {
                ((RedSpaceFriendOptionsHelper) this.f12461a.f12476v.get()).m12744b(profile, section, "edit_mode");
            }
            LogUtils.a(427828483, a);
        }
    }

    private static <T extends View> void m12867a(Class<T> cls, T t) {
        m12868a((Object) t, t.getContext());
    }

    private static void m12868a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((RedSpaceFriendsItemViewList) obj).m12865a(ResourcesMethodAutoProvider.a(injectorLike), RedSpaceFeedProfileUnreadStoriesHelper.m12202a(injectorLike), IdBasedLazy.a(injectorLike, 3264), IdBasedLazy.a(injectorLike, 10176), IdBasedLazy.a(injectorLike, 10223), IdBasedLazy.a(injectorLike, 10220));
    }

    private void m12865a(Resources resources, RedSpaceFeedProfileUnreadStoriesHelper redSpaceFeedProfileUnreadStoriesHelper, com.facebook.inject.Lazy<RedSpaceStrings> lazy, com.facebook.inject.Lazy<RedSpaceTimeHelper> lazy2, com.facebook.inject.Lazy<RedSpaceFriendsItemHelper> lazy3, com.facebook.inject.Lazy<RedSpaceFriendOptionsHelper> lazy4) {
        this.f12471q = resources;
        this.f12472r = redSpaceFeedProfileUnreadStoriesHelper;
        this.f12473s = lazy;
        this.f12474t = lazy2;
        this.f12475u = lazy3;
        this.f12476v = lazy4;
    }

    public RedSpaceFriendsItemViewList(Context context) {
        super(context);
        m12873f();
    }

    public RedSpaceFriendsItemViewList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12873f();
    }

    public RedSpaceFriendsItemViewList(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12873f();
    }

    private void m12873f() {
        m12867a(RedSpaceFriendsItemViewList.class, (View) this);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 739161006);
        super.onFinishInflate();
        m12874g();
        this.f12466l = (FbDraweeView) getView(2131566860);
        this.f12467m = (TextView) getView(2131566861);
        this.f12468n = (GlyphView) getView(2131566862);
        this.f12468n.setOnClickListener(this.f12477w);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1264024240, a);
    }

    public final void mo353a(RedSpaceFriendsSection redSpaceFriendsSection, RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, boolean z) {
        if (this.f12464j != redSpaceFeedProfileFragmentModel || this.f12465k != redSpaceFriendsSection || this.f12469o != z) {
            this.f12464j = redSpaceFeedProfileFragmentModel;
            this.f12465k = redSpaceFriendsSection;
            boolean z2 = this.f12470p && this.f12469o != z;
            this.f12469o = z;
            this.f12470p = false;
            String a = redSpaceFriendsSection == RedSpaceFriendsSection.TOP ? GraphQLHelper.a(redSpaceFeedProfileFragmentModel.n()) : redSpaceFeedProfileFragmentModel.n().s_();
            int b = ((RedSpaceFriendsItemHelper) this.f12475u.get()).m12848b(redSpaceFeedProfileFragmentModel);
            this.f12475u.get();
            setTitleText(RedSpaceFriendsItemHelper.m12845a(a, b));
            setSubtitleText(m12864a(redSpaceFeedProfileFragmentModel));
            m12872b(z2);
            m12869a(z2);
            setTag(redSpaceFeedProfileFragmentModel.k());
            this.f12466l.a(Uri.parse(redSpaceFeedProfileFragmentModel.l().b()), f12462h);
        }
    }

    public final void mo356a() {
        this.f12470p = true;
    }

    @VisibleForTesting
    private String m12864a(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        Object b = m12870b(redSpaceFeedProfileFragmentModel);
        Object a = ((RedSpaceFriendsItemHelper) this.f12475u.get()).m12847a(redSpaceFeedProfileFragmentModel);
        StringBuilder stringBuilder = new StringBuilder();
        String str = "";
        if (!TextUtils.isEmpty(b)) {
            stringBuilder.append(b);
            str = " • ";
        }
        if (!TextUtils.isEmpty(a)) {
            stringBuilder.append(str);
            stringBuilder.append(a);
        }
        return stringBuilder.toString();
    }

    private String m12870b(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        if (redSpaceFeedProfileFragmentModel.m() == null || redSpaceFeedProfileFragmentModel.m().l() == null || redSpaceFeedProfileFragmentModel.m().l().a().isEmpty()) {
            return null;
        }
        return ((RedSpaceStrings) this.f12473s.get()).c(((RedSpaceTimeHelper) this.f12474t.get()).m12323a(((NodesModel) redSpaceFeedProfileFragmentModel.m().l().a().get(0)).a() * 1000));
    }

    private void m12869a(boolean z) {
        if (this.f12469o) {
            int i = this.f12465k == RedSpaceFriendsSection.TOP ? 2130839815 : 2130840032;
            int i2 = this.f12465k == RedSpaceFriendsSection.TOP ? 2131361918 : 2131361919;
            this.f12468n.setImageResource(i);
            this.f12468n.setGlyphColor(this.f12471q.getColor(i2));
            m12871b(this.f12468n, z);
            return;
        }
        m12866a(this.f12468n, z);
    }

    private void m12872b(boolean z) {
        if (this.f12469o) {
            m12866a(this.f12467m, z);
            return;
        }
        CharSequence c = ((RedSpaceFriendsItemHelper) this.f12475u.get()).m12849c(this.f12464j);
        if (TextUtils.isEmpty(c)) {
            m12866a(this.f12467m, false);
            return;
        }
        this.f12467m.setText(c);
        m12871b(this.f12467m, z);
    }

    private static void m12866a(View view, boolean z) {
        RedSpaceFadeAnimationHelper.m12838a(view, z, 0.0f);
    }

    private static void m12871b(View view, boolean z) {
        RedSpaceFadeAnimationHelper.m12838a(view, z, 1.0f);
    }

    private void m12874g() {
        int i;
        boolean a = RTLUtil.a(getContext());
        int paddingRight = a ? getPaddingRight() : getPaddingLeft();
        if (a) {
            i = 0;
        } else {
            i = paddingRight;
        }
        if (!a) {
            paddingRight = 0;
        }
        setPadding(i, getPaddingTop(), paddingRight, getPaddingBottom());
    }

    public void setOnProfileClickListener(OnClickListener onClickListener) {
        if (this.f12469o) {
            setOnClickListener(null);
        } else {
            setOnClickListener(onClickListener);
        }
        refreshDrawableState();
    }

    public void setOnProfileLongClickListener(OnLongClickListener onLongClickListener) {
        if (this.f12469o) {
            setOnLongClickListener(null);
        } else {
            setOnLongClickListener(onLongClickListener);
        }
    }

    public View getProfilePictureView() {
        return this.f12466l;
    }

    public RedSpaceFeedProfileFragmentModel getProfile() {
        return this.f12464j;
    }

    public RedSpaceFriendsSection getSection() {
        return this.f12465k;
    }

    protected int[] onCreateDrawableState(int i) {
        return this.f12469o ? f12463i : super.onCreateDrawableState(i);
    }
}
