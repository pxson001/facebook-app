package com.facebook.socialgood.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.PointF;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.caspian.ui.standardheader.StandardCoverHeaderView;
import com.facebook.caspian.ui.standardheader.StandardCoverHeaderView.StandardHeaderSizingType;
import com.facebook.caspian.ui.standardheader.StandardCoverType;
import com.facebook.caspian.ui.standardheader.StandardProfileImageViewBinder;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.querybuilder.convertible.DefaultGraphQLConversionHelper;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.data.model.PhotoSet;
import com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserCoverPhotoFragmentModel;
import com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderQueryModel;
import com.facebook.timeline.util.TimelineViewHelper;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Preconditions;

/* compiled from: ONGOING */
public class FundraiserCoverHeaderView extends StandardCoverHeaderView {
    private static final CallerContext f12794k = CallerContext.a(FundraiserCoverHeaderView.class, "social_good", "cover_photo");
    private static final CallerContext f12795l = CallerContext.a(FundraiserCoverHeaderView.class, "social_good", "profile_picture");
    @Inject
    private StandardProfileImageViewBinder f12796m;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<IFeedIntentBuilder> f12797n = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SecureContextHelper> f12798o = UltralightRuntime.b;
    @Inject
    private LinkifyUtil f12799p;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<IFeedIntentBuilder> f12800q = UltralightRuntime.b;
    private FundraiserPageHeaderQueryModel f12801r;

    private static <T extends View> void m13456a(Class<T> cls, T t) {
        m13457a((Object) t, t.getContext());
    }

    private static void m13457a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FundraiserCoverHeaderView) obj).m13453a(StandardProfileImageViewBinder.b(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 2347), IdBasedSingletonScopeProvider.b(fbInjector, 968), LinkifyUtil.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 2347));
    }

    public FundraiserCoverHeaderView(Context context, boolean z) {
        super(context);
        m13459b();
    }

    public FundraiserCoverHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m13459b();
    }

    public FundraiserCoverHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13459b();
    }

    private void m13459b() {
        m13456a(FundraiserCoverHeaderView.class, (View) this);
        this.d = StandardHeaderSizingType.NARROW;
        setCoverType(StandardCoverType.IMAGE);
        this.j.setVisibility(8);
        this.f.setMinimumHeight(getResources().getDimensionPixelOffset(2131427569));
        this.i.setAlpha(0.0f);
        this.i.setVisibility(0);
        f();
    }

    public final void m13464a(FundraiserPageHeaderQueryModel fundraiserPageHeaderQueryModel) {
        Preconditions.checkNotNull(fundraiserPageHeaderQueryModel);
        this.f12801r = fundraiserPageHeaderQueryModel;
        this.f.setTitleTextAppearance(2131626660);
        this.f.setSubtitleTextAppearance(2131626661);
        m13460g();
        m13461h();
        m13462i();
    }

    private void m13460g() {
        String formatStrLocaleSafe;
        OnClickListener c15011;
        String b = this.f12801r.m13415s().b();
        FundraiserPageHeaderQueryModel fundraiserPageHeaderQueryModel = this.f12801r;
        SocialGoodDataModelHelper.m13529n(fundraiserPageHeaderQueryModel);
        if (SocialGoodDataModelHelper.m13523b(fundraiserPageHeaderQueryModel)) {
            formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.af, SocialGoodDataModelHelper.m13525d(fundraiserPageHeaderQueryModel));
        } else if (SocialGoodDataModelHelper.m13524c(fundraiserPageHeaderQueryModel)) {
            Object obj;
            Preconditions.checkNotNull(fundraiserPageHeaderQueryModel.m13417u());
            Preconditions.checkArgument(!TextUtils.isEmpty(fundraiserPageHeaderQueryModel.m13417u().m13362k()));
            if (SocialGoodDataModelHelper.m13530o(fundraiserPageHeaderQueryModel) == 2645995) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                formatStrLocaleSafe = FBLinks.aX;
            } else {
                if (SocialGoodDataModelHelper.m13530o(fundraiserPageHeaderQueryModel) == 2479791) {
                    obj = 1;
                } else {
                    obj = null;
                }
                formatStrLocaleSafe = obj != null ? FBLinks.af : null;
            }
            formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(formatStrLocaleSafe, fundraiserPageHeaderQueryModel.m13417u().m13362k());
        } else {
            formatStrLocaleSafe = null;
        }
        final String str = formatStrLocaleSafe;
        if (str != null) {
            c15011 = new OnClickListener(this) {
                final /* synthetic */ FundraiserCoverHeaderView f12790b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1771968407);
                    ((SecureContextHelper) this.f12790b.f12798o.get()).a(((IFeedIntentBuilder) this.f12790b.f12797n.get()).b(this.f12790b.getContext(), str), this.f12790b.getContext());
                    Logger.a(2, EntryType.UI_INPUT_END, 1261680879, a);
                }
            };
        } else {
            c15011 = null;
        }
        this.f12796m.a(null, ImageRequest.a(b), false, true, false, false, f12795l, c15011, null, getProfileImageView());
        this.j.setVisibility(0);
    }

    private void m13461h() {
        String g = SocialGoodDataModelHelper.m13526g(this.f12801r);
        PointF h = SocialGoodDataModelHelper.m13527h(this.f12801r);
        String[] j = SocialGoodDataModelHelper.m13528j(this.f12801r);
        OnClickListener a = m13450a(g);
        f();
        this.g.a(getScreenWidth(), this.c, true, null, ImageRequest.a(g), h, false, false, j, f12794k, a, null, false, true);
    }

    private OnClickListener m13450a(final String str) {
        FundraiserCoverPhotoFragmentModel j;
        FundraiserPageHeaderQueryModel fundraiserPageHeaderQueryModel = this.f12801r;
        SocialGoodDataModelHelper.m13529n(fundraiserPageHeaderQueryModel);
        if (SocialGoodDataModelHelper.m13523b(fundraiserPageHeaderQueryModel)) {
            Preconditions.checkNotNull(fundraiserPageHeaderQueryModel.m13411o());
            if (!(fundraiserPageHeaderQueryModel.m13411o().m13350j() == null || fundraiserPageHeaderQueryModel.m13411o().m13350j().m13344j() == null)) {
                j = fundraiserPageHeaderQueryModel.m13411o().m13350j().m13344j();
            }
            j = null;
        } else {
            if (SocialGoodDataModelHelper.m13524c(fundraiserPageHeaderQueryModel) && fundraiserPageHeaderQueryModel.m13413q() != null) {
                j = fundraiserPageHeaderQueryModel.m13413q();
            }
            j = null;
        }
        final FundraiserCoverPhotoFragmentModel fundraiserCoverPhotoFragmentModel = j;
        if (fundraiserCoverPhotoFragmentModel == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return new OnClickListener(this) {
            final /* synthetic */ FundraiserCoverHeaderView f12793c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 632138771);
                this.f12793c.m13454a(fundraiserCoverPhotoFragmentModel, str);
                Logger.a(2, EntryType.UI_INPUT_END, -110014408, a);
            }
        };
    }

    private void m13454a(FundraiserCoverPhotoFragmentModel fundraiserCoverPhotoFragmentModel, String str) {
        String str2 = null;
        if (!(TextUtils.isEmpty(fundraiserCoverPhotoFragmentModel.m13305l()) || fundraiserCoverPhotoFragmentModel.m13304k() == null || TextUtils.isEmpty(fundraiserCoverPhotoFragmentModel.m13304k().m13297j()))) {
            str2 = PhotoSet.c(Long.parseLong(fundraiserCoverPhotoFragmentModel.m13304k().m13297j()));
        }
        m13452a(Long.parseLong(fundraiserCoverPhotoFragmentModel.m13305l()), str, str2);
    }

    private void m13452a(long j, String str, String str2) {
        Intent a = ((IFeedIntentBuilder) this.f12800q.get()).a(j, str2, FullscreenGallerySource.FUNDRAISER_COVER_PHOTO);
        if (a != null) {
            ((SecureContextHelper) this.f12798o.get()).a(a, getContext());
        }
    }

    private void m13462i() {
        CharSequence a;
        this.f.setTitleText(this.f12801r.m13407k());
        CharSequence a2 = this.f12799p.a(LinkifyUtilConverter.c(DefaultGraphQLConversionHelper.a(this.f12801r.m13412p())), true, null);
        if (SocialGoodDataModelHelper.m13523b(this.f12801r)) {
            boolean c = SocialGoodDataModelHelper.m13531s(this.f12801r).m13380c();
            if (c) {
                a = TimelineViewHelper.a(c, false, new SpannableStringBuilder(a2), 2130843879, 0, getContext(), getResources().getDimensionPixelSize(2131434497), getResources().getDimensionPixelSize(2131434498), null);
                this.f.setSubtitleText(a);
            }
        }
        a = a2;
        this.f.setSubtitleText(a);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.b = getResources().getConfiguration().orientation;
        if (this.f12801r != null) {
            m13460g();
            m13461h();
            m13462i();
        }
    }

    protected final int m13463a(int i, int i2) {
        return getResources().getDimensionPixelSize(2131428150);
    }

    private void m13453a(StandardProfileImageViewBinder standardProfileImageViewBinder, com.facebook.inject.Lazy<IFeedIntentBuilder> lazy, com.facebook.inject.Lazy<SecureContextHelper> lazy2, LinkifyUtil linkifyUtil, com.facebook.inject.Lazy<IFeedIntentBuilder> lazy3) {
        this.f12796m = standardProfileImageViewBinder;
        this.f12797n = lazy;
        this.f12798o = lazy2;
        this.f12799p = linkifyUtil;
        this.f12800q = lazy3;
    }
}
