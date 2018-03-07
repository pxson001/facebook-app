package com.facebook.events.permalink.header;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.format.DateFormat;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.caspian.ui.standardheader.StandardCoverHeaderView;
import com.facebook.caspian.ui.standardheader.StandardCoverHeaderView.StandardHeaderSizingType;
import com.facebook.caspian.ui.standardheader.StandardCoverPhotoView;
import com.facebook.caspian.ui.standardheader.StandardCoverType;
import com.facebook.caspian.ui.standardheader.StandardPermalinkHeaderDateView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.device.ScreenUtil;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.graphql.EventsGraphQLModels.EventCardFragmentModel.CoverPhotoModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventCardFragmentModel.CoverPhotoModel.PhotoModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventCategoryInfoFragmentModel.EventCategoryInfoModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventArtist;
import com.facebook.events.model.EventUser;
import com.facebook.events.model.EventUser.EventUserType;
import com.facebook.events.permalink.EventPermalinkController;
import com.facebook.events.permalink.cancelevent.CancelEventBannerView;
import com.facebook.events.permalink.draft.DraftEventBannerView;
import com.facebook.events.protocol.EventGraphQLModelHelper;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.data.model.PhotoSet;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.tablet.Boolean_IsTabletMethodAutoProvider;
import com.facebook.tablet.IsTablet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Date;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: block messages */
public class CaspianEventPermalinkHeaderView extends StandardCoverHeaderView {
    private static final CallerContext f18525D = CallerContext.a(CaspianEventPermalinkHeaderView.class, "event_permalink", "cover_photo");
    private Context f18526A;
    private int f18527B;
    private String[] f18528C;
    private final OnClickListener f18529E = new C26301(this);
    private StandardPermalinkHeaderDateView f18530F;
    @Inject
    EventPermalinkController f18531k;
    @Inject
    IFeedIntentBuilder f18532l;
    @Inject
    SecureContextHelper f18533m;
    @Inject
    @IsTablet
    Boolean f18534n;
    @Inject
    QuickPerformanceLogger f18535o;
    @Inject
    EventEventLogger f18536p;
    @Inject
    ScreenUtil f18537q;
    public Event f18538r;
    private FetchEventPermalinkFragmentModel f18539s;
    @Nullable
    private DraftEventBannerView f18540t;
    @Nullable
    private CancelEventBannerView f18541u;
    public EventHeaderStyle f18542v;
    public ImmutableList<EventUser> f18543w;
    public ImmutableList<EventArtist> f18544x;
    private EventAnalyticsParams f18545y;
    private boolean f18546z;

    /* compiled from: block messages */
    class C26301 implements OnClickListener {
        final /* synthetic */ CaspianEventPermalinkHeaderView f18520a;

        C26301(CaspianEventPermalinkHeaderView caspianEventPermalinkHeaderView) {
            this.f18520a = caspianEventPermalinkHeaderView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 382754563);
            CaspianEventPermalinkHeaderView.m18891l(this.f18520a);
            Logger.a(2, EntryType.UI_INPUT_END, 584769313, a);
        }
    }

    /* compiled from: block messages */
    class C26323 extends ClickableSpan {
        final /* synthetic */ CaspianEventPermalinkHeaderView f18523a;

        C26323(CaspianEventPermalinkHeaderView caspianEventPermalinkHeaderView) {
            this.f18523a = caspianEventPermalinkHeaderView;
        }

        public void onClick(View view) {
            Context context = this.f18523a.getContext();
            if (this.f18523a.f18542v == EventHeaderStyle.HOSTED_BY_PAGE_OR_PEOPLE) {
                if (this.f18523a.f18543w.size() == 1) {
                    this.f18523a.f18531k.m18268a(context, (EventUser) this.f18523a.f18543w.get(0));
                    return;
                }
                EventPermalinkController eventPermalinkController = this.f18523a.f18531k;
                String str = this.f18523a.f18538r.a;
                ImmutableList immutableList = this.f18523a.f18543w;
                Intent component = new Intent().setComponent((ComponentName) eventPermalinkController.f17857d.get());
                component.putExtra("target_fragment", ContentFragmentType.EVENTS_HOSTS_FRAGMENT.ordinal());
                Bundle bundle = new Bundle();
                bundle.putString("EVENT_ID", str);
                bundle.putParcelableArrayList("HOSTS", Lists.a(immutableList));
                component.putExtras(bundle);
                eventPermalinkController.f17855b.a(component, context);
            } else if (this.f18523a.f18542v != EventHeaderStyle.WITH_ARTISTS) {
            } else {
                if (this.f18523a.f18544x.size() == 1) {
                    this.f18523a.f18531k.m18267a(context, (EventArtist) this.f18523a.f18544x.get(0));
                    return;
                }
                this.f18523a.f18531k.m18273b(context, this.f18523a.f18538r.a, this.f18523a.f18544x);
            }
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.bgColor = 0;
        }
    }

    /* compiled from: block messages */
    class CoverPhotoControllerListener extends BaseControllerListener {
        final /* synthetic */ CaspianEventPermalinkHeaderView f18524a;

        public CoverPhotoControllerListener(CaspianEventPermalinkHeaderView caspianEventPermalinkHeaderView) {
            this.f18524a = caspianEventPermalinkHeaderView;
        }

        public final void m18861a(String str, Object obj) {
        }

        public final void m18862a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            this.f18524a.f18535o.b(393238, (short) 2);
        }

        public final void m18864b(String str, Throwable th) {
            this.f18524a.f18535o.b(393238, (short) 3);
        }
    }

    /* compiled from: block messages */
    enum EventHeaderStyle {
        UNKNOWN,
        HOSTED_BY_PAGE_OR_PEOPLE,
        WITH_ARTISTS
    }

    private static <T extends View> void m18876a(Class<T> cls, T t) {
        m18877a((Object) t, t.getContext());
    }

    private static void m18877a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((CaspianEventPermalinkHeaderView) obj).m18874a(EventPermalinkController.m18262b(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), Boolean_IsTabletMethodAutoProvider.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), EventEventLogger.m18119b(injectorLike), ScreenUtil.a(injectorLike));
    }

    private void m18874a(EventPermalinkController eventPermalinkController, IFeedIntentBuilder iFeedIntentBuilder, SecureContextHelper secureContextHelper, Boolean bool, QuickPerformanceLogger quickPerformanceLogger, EventEventLogger eventEventLogger, ScreenUtil screenUtil) {
        this.f18531k = eventPermalinkController;
        this.f18532l = iFeedIntentBuilder;
        this.f18533m = secureContextHelper;
        this.f18534n = bool;
        this.f18535o = quickPerformanceLogger;
        this.f18536p = eventEventLogger;
        this.f18537q = screenUtil;
    }

    public CaspianEventPermalinkHeaderView(Context context, boolean z) {
        super(context);
        this.f18546z = z;
        m18871a(context);
    }

    public CaspianEventPermalinkHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m18871a(context);
    }

    public CaspianEventPermalinkHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18871a(context);
    }

    private void m18871a(Context context) {
        m18876a(CaspianEventPermalinkHeaderView.class, (View) this);
        this.f18526A = context;
        this.d = StandardHeaderSizingType.NARROW;
        setCoverType(StandardCoverType.IMAGE);
        if (this.f18534n.booleanValue()) {
            this.i.setVisibility(8);
        }
        if (this.f18546z) {
            this.j.setVisibility(8);
            this.f.setMinimumHeight(getResources().getDimensionPixelOffset(2131427569));
            return;
        }
        e();
    }

    public final void m18893a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, EventAnalyticsParams eventAnalyticsParams, boolean z, boolean z2) {
        int i = 0;
        this.f18546z = z;
        if (event.x && this.f18546z && this.f18541u == null) {
            this.f18541u = new CancelEventBannerView(getContext());
            a(this.f18541u, this.e.getChildCount() > 0 ? this.e.getChildCount() - 1 : 0);
        }
        if (this.f18541u != null) {
            this.f18541u.m18652a(event, this.f18545y);
        }
        if (z2 && this.f18546z && this.f18540t == null) {
            this.f18540t = new DraftEventBannerView(getContext());
            DraftEventBannerView draftEventBannerView = this.f18540t;
            if (this.e.getChildCount() > 0) {
                i = this.e.getChildCount() - 1;
            }
            a(draftEventBannerView, i);
        }
        if (this.f18540t != null) {
            this.f18540t.m18667a(event, eventAnalyticsParams);
        }
        m18873a(event, fetchEventPermalinkFragmentModel, eventAnalyticsParams);
    }

    private void m18873a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, EventAnalyticsParams eventAnalyticsParams) {
        f();
        this.f18538r = event;
        this.f18539s = fetchEventPermalinkFragmentModel;
        this.f18545y = eventAnalyticsParams;
        m18872a(event, fetchEventPermalinkFragmentModel);
        this.f.setTitleTextAppearance(this.f18546z ? 2131625784 : 2131625783);
        this.f.setSubtitleTextAppearance(this.f18546z ? 2131625789 : 2131625788);
        if (this.f18546z) {
            this.f18530F = new StandardPermalinkHeaderDateView(this.f18526A);
            this.f.setThumbnailView(this.f18530F);
            StandardPermalinkHeaderDateView standardPermalinkHeaderDateView = this.f18530F;
            Date J = this.f18538r.J();
            standardPermalinkHeaderDateView.b.setText(DateFormat.format("dd", J));
            standardPermalinkHeaderDateView.c.setText(DateFormat.format("MMM", J).toString().toUpperCase(standardPermalinkHeaderDateView.a.a()));
        }
        TypedArray obtainStyledAttributes = this.f18526A.obtainStyledAttributes(new int[]{2130772560});
        this.f18527B = obtainStyledAttributes.getInt(0, 3);
        obtainStyledAttributes.recycle();
        m18887h();
        if (this.f18546z) {
            m18882b();
        }
        m18886g();
    }

    private void m18882b() {
        MarginLayoutParamsCompat.a((MarginLayoutParams) this.f.getLayoutParams(), 0);
    }

    private void m18886g() {
        PointF pointF;
        ImageRequest imageRequest;
        ImageRequest imageRequest2;
        BaseControllerListener baseControllerListener;
        boolean z;
        boolean z2;
        if (this.f18539s != null) {
            CoverPhotoModel ag = this.f18539s.ag();
            if (ag == null || ag.j() == null) {
                pointF = null;
            } else {
                pointF = new PointF((float) ag.j().a(), (float) ag.j().b());
            }
            if (ag == null || ag.k() == null || ag.k().l() == null || ag.k().l().b() == null) {
                imageRequest = null;
            } else {
                imageRequest = ImageRequest.a(ag.k().l().b());
            }
            if (ag == null || ag.k() == null || ag.k().m() == null || ag.k().m().b() == null) {
                imageRequest2 = null;
            } else {
                ImageRequestBuilder a = ImageRequestBuilder.a(Uri.parse(ag.k().m().b()));
                a.i = Priority.LOW;
                imageRequest2 = a.m();
            }
        } else {
            imageRequest = null;
            imageRequest2 = null;
            pointF = null;
        }
        if (this.f18546z) {
            this.d = this.f18538r.Z() != null ? StandardHeaderSizingType.NARROW : StandardHeaderSizingType.CUSTOM;
            f();
        }
        if (imageRequest == null && imageRequest2 == null) {
            baseControllerListener = null;
        } else {
            baseControllerListener = new CoverPhotoControllerListener(this);
        }
        StandardCoverPhotoView standardCoverPhotoView = this.g;
        int screenWidth = getScreenWidth();
        int i = this.c;
        String[] coverPhotoDescription = getCoverPhotoDescription();
        CallerContext callerContext = f18525D;
        OnClickListener onClickListener = this.f18529E;
        if (this.f18546z) {
            z = false;
        } else {
            z = true;
        }
        if (this.f18539s != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        standardCoverPhotoView.a(screenWidth, i, false, imageRequest, imageRequest2, pointF, false, false, coverPhotoDescription, callerContext, onClickListener, baseControllerListener, z, z2);
    }

    private boolean m18879a(TextPaint textPaint, int i, SpannableStringBuilder spannableStringBuilder) {
        if (new StaticLayout(spannableStringBuilder, textPaint, i, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineCount() <= this.f18527B) {
            return true;
        }
        return false;
    }

    private void m18878a(String str) {
        int c = (this.f18537q.c() - getResources().getDimensionPixelSize(2131427573)) - getResources().getDimensionPixelSize(2131427564);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        this.f.setTitleTextAppearance(2131625784);
        if (!m18879a(this.f.getTitleTextPaint(), c, spannableStringBuilder)) {
            this.f.setTitleTextAppearance(2131625785);
            if (!m18879a(this.f.getTitleTextPaint(), c, spannableStringBuilder)) {
                this.f.setTitleTextAppearance(2131625786);
            }
        }
    }

    private void m18887h() {
        String str = this.f18538r.b;
        this.f.setTitleText(str);
        if (this.f18546z) {
            m18878a(str);
        }
        if (this.f18539s != null) {
            if (this.f18546z) {
                m18889j();
            } else {
                m18888i();
            }
        }
    }

    private void m18872a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        if (fetchEventPermalinkFragmentModel == null || fetchEventPermalinkFragmentModel.ag() == null || fetchEventPermalinkFragmentModel.ag().k() == null || fetchEventPermalinkFragmentModel.ag().k().b() == null) {
            this.f18528C = new String[]{event.b};
            return;
        }
        this.f18528C = new String[]{event.b, fetchEventPermalinkFragmentModel.ag().k().b()};
    }

    public String[] getCoverPhotoDescription() {
        return this.f18528C;
    }

    private void m18888i() {
        CharSequence a;
        String str = null;
        this.f18544x = EventGraphQLModelHelper.m19260a(this.f18539s);
        if (this.f18544x.isEmpty()) {
            this.f18542v = EventHeaderStyle.HOSTED_BY_PAGE_OR_PEOPLE;
        } else {
            this.f18542v = EventHeaderStyle.WITH_ARTISTS;
        }
        CharSequence a2 = m18870a(this.f18539s);
        CharSequence a3;
        EventCategoryInfoModel am;
        if (this.f18542v == EventHeaderStyle.HOSTED_BY_PAGE_OR_PEOPLE) {
            this.f18543w = EventGraphQLModelHelper.m19279b(this.f18539s);
            a3 = m18865a(this.f18543w, true);
            am = this.f18539s.am();
            if (am != null) {
                a = am.a();
            }
            a = m18868a(a3, a, a2);
        } else if (this.f18542v == EventHeaderStyle.WITH_ARTISTS) {
            a3 = m18880b(this.f18544x, true);
            am = this.f18539s.am();
            if (am != null) {
                str = am.a();
            }
            a = m18868a(a3, str, a2);
        }
        this.f.setSubtitleText(a);
    }

    private void m18889j() {
        this.f18544x = EventGraphQLModelHelper.m19260a(this.f18539s);
        if (this.f18544x.isEmpty()) {
            this.f18542v = EventHeaderStyle.HOSTED_BY_PAGE_OR_PEOPLE;
        } else {
            this.f18542v = EventHeaderStyle.WITH_ARTISTS;
        }
        CharSequence charSequence = null;
        if (this.f18542v == EventHeaderStyle.HOSTED_BY_PAGE_OR_PEOPLE) {
            this.f18543w = EventGraphQLModelHelper.m19279b(this.f18539s);
            if (this.f18543w == null || this.f18543w.isEmpty() || ((EventUser) this.f18543w.get(0)).a != EventUserType.PAGE) {
                Spannable a = m18865a(this.f18543w, true);
                charSequence = m18868a(m18870a(this.f18539s), a);
            } else {
                charSequence = m18867a(m18865a(this.f18543w, false));
            }
        } else if (this.f18542v == EventHeaderStyle.WITH_ARTISTS) {
            charSequence = m18867a(m18880b(this.f18544x, false));
        }
        this.f.setSubtitleText(charSequence);
    }

    private SpannableStringBuilder m18867a(Spannable spannable) {
        EventCategoryInfoModel am = this.f18539s.am();
        return m18868a(am == null ? null : am.a(), spannable);
    }

    private Spannable m18865a(ImmutableList<EventUser> immutableList, boolean z) {
        if (immutableList == null || immutableList.isEmpty()) {
            return null;
        }
        CharSequence charSequence = ((EventUser) immutableList.get(0)).c;
        if (StringUtil.a(charSequence)) {
            return null;
        }
        CharSequence b;
        int size = immutableList.size() - 1;
        if (size != 0) {
            charSequence = getResources().getQuantityString(2131689660, size, new Object[]{charSequence, Integer.valueOf(size)});
        }
        if (z) {
            StyledStringBuilder styledStringBuilder = new StyledStringBuilder(getResources());
            styledStringBuilder.a(getResources().getString(2131236991, new Object[]{"{sentence}"}));
            b = styledStringBuilder.a("{sentence}", charSequence, 17, new Object[0]).b();
        } else {
            b = null;
        }
        StyledStringBuilder a = new StyledStringBuilder(getResources()).a(m18890k(), 33);
        if (b == null) {
            b = charSequence;
        }
        return a.a(b).a().b();
    }

    private static SpannableStringBuilder m18868a(@Nullable CharSequence charSequence, CharSequence... charSequenceArr) {
        return m18869a(false, charSequence, charSequenceArr);
    }

    private static SpannableStringBuilder m18869a(boolean z, @Nullable CharSequence charSequence, CharSequence... charSequenceArr) {
        int i;
        int i2 = 0;
        CharSequence spannableStringBuilder = new SpannableStringBuilder(" · ");
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        if (charSequence != null) {
            spannableStringBuilder2.append(charSequence);
            if (z) {
                spannableStringBuilder2.append("\n");
                i = 0;
            } else {
                i = 1;
            }
        } else {
            i = 0;
        }
        int length = charSequenceArr.length;
        while (i2 < length) {
            CharSequence charSequence2 = charSequenceArr[i2];
            if (charSequence2 != null) {
                if (i != 0) {
                    spannableStringBuilder2.append(spannableStringBuilder);
                }
                spannableStringBuilder2.append(charSequence2);
                i = 1;
            }
            i2++;
        }
        return spannableStringBuilder2;
    }

    @Nullable
    private CharSequence m18870a(FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        if (fetchEventPermalinkFragmentModel.aM() != null) {
            CharSequence string = getResources().getString(2131236990, new Object[]{fetchEventPermalinkFragmentModel.aM().c()});
            if (this.f18539s.ah() == null || !this.f18539s.aM().b().equals(this.f18539s.ah().b())) {
                return string;
            }
            return m18866a(string);
        } else if (fetchEventPermalinkFragmentModel.B() == GraphQLEventPrivacyType.PRIVATE_TYPE) {
            return getResources().getString(2131241636);
        } else {
            if (fetchEventPermalinkFragmentModel.B() == GraphQLEventPrivacyType.PUBLIC_TYPE) {
                return getResources().getString(2131241637);
            }
            return null;
        }
    }

    private SpannableString m18866a(CharSequence charSequence) {
        final String b = this.f18539s.ah().b();
        return new StyledStringBuilder(getResources()).a(new ClickableSpan(this) {
            final /* synthetic */ CaspianEventPermalinkHeaderView f18522b;

            public void onClick(View view) {
                EventPermalinkController eventPermalinkController = this.f18522b.f18531k;
                ((IFeedIntentBuilder) eventPermalinkController.f17854a.get()).a(this.f18522b.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.u, b), null, null);
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.bgColor = 0;
            }
        }, 33).a(charSequence).a().b();
    }

    private Spannable m18880b(ImmutableList<EventArtist> immutableList, boolean z) {
        if (immutableList == null || immutableList.isEmpty()) {
            return null;
        }
        CharSequence charSequence = ((EventArtist) immutableList.get(0)).b;
        if (StringUtil.a(charSequence)) {
            return null;
        }
        CharSequence b;
        int size = immutableList.size() - 1;
        if (size != 0) {
            charSequence = getResources().getQuantityString(2131689660, size, new Object[]{charSequence, Integer.valueOf(size)});
        }
        if (z) {
            StyledStringBuilder styledStringBuilder = new StyledStringBuilder(getResources());
            styledStringBuilder.a(getResources().getString(2131236992, new Object[]{"{sentence}"}));
            b = styledStringBuilder.a("{sentence}", charSequence, 17, new Object[0]).b();
        } else {
            b = null;
        }
        StyledStringBuilder a = new StyledStringBuilder(getResources()).a(m18890k(), 33);
        if (b == null) {
            b = charSequence;
        }
        return a.a(b).a().b();
    }

    private ClickableSpan m18890k() {
        return new C26323(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.b = getResources().getConfiguration().orientation;
        f();
        if (this.f18546z) {
            m18887h();
        }
        m18886g();
    }

    protected final int m18892a(int i, int i2) {
        return !this.f18546z ? super.a(i, i2) : getResources().getDimensionPixelSize(2131428150);
    }

    public static void m18891l(CaspianEventPermalinkHeaderView caspianEventPermalinkHeaderView) {
        if (caspianEventPermalinkHeaderView.f18532l != null && caspianEventPermalinkHeaderView.f18539s != null && caspianEventPermalinkHeaderView.f18539s.ag() != null && caspianEventPermalinkHeaderView.f18539s.ag().k() != null && caspianEventPermalinkHeaderView.f18539s.ag().k().k() != null && caspianEventPermalinkHeaderView.f18539s.ag().k().k().b() != null) {
            String str;
            PhotoModel k = caspianEventPermalinkHeaderView.f18539s.ag().k();
            if (k.d() == null || k.j() == null) {
                str = null;
            } else {
                str = PhotoSet.c(Long.parseLong(k.j().b()));
            }
            IFeedIntentBuilder iFeedIntentBuilder = caspianEventPermalinkHeaderView.f18532l;
            long parseLong = Long.parseLong(k.d());
            k.k().b();
            Intent a = iFeedIntentBuilder.a(parseLong, str, FullscreenGallerySource.EVENT_COVER_PHOTO);
            if (a != null) {
                caspianEventPermalinkHeaderView.f18533m.a(a, caspianEventPermalinkHeaderView.getContext());
            }
            if (caspianEventPermalinkHeaderView.f18545y == null) {
                caspianEventPermalinkHeaderView.f18536p.m18134a(caspianEventPermalinkHeaderView.f18538r.a, null, null, null, k.d());
                return;
            }
            caspianEventPermalinkHeaderView.f18536p.m18134a(caspianEventPermalinkHeaderView.f18538r.a, caspianEventPermalinkHeaderView.f18545y.c, caspianEventPermalinkHeaderView.f18545y.d, caspianEventPermalinkHeaderView.f18545y.e, k.d());
        }
    }
}
