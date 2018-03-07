package com.facebook.events.dashboard;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.format.DateUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.dateformatter.EventsBirthdayTimeFormatUtil;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.events.graphql.EventsGraphQLModels.EventUserWithBirthdayFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventUserWithBirthdayFragmentModel.BirthdateModel;
import com.facebook.events.logging.BirthdayReminderLogger;
import com.facebook.events.model.EventUser;
import com.facebook.events.model.EventUser.Builder;
import com.facebook.events.model.EventUser.EventUserType;
import com.facebook.events.permalink.EventPermalinkController;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.launch.ComposerIntentLauncher;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.inject.Inject;

/* compiled from: composeExpanded */
public class EventsBirthdayRow extends CustomLinearLayout {
    @Inject
    AllCapsTransformationMethod f16514a;
    @Inject
    BirthdayReminderLogger f16515b;
    @Inject
    EventsDashboardBirthdaysComposerController f16516c;
    @Inject
    EventPermalinkController f16517d;
    @Inject
    EventsDashboardTimeFormatUtil f16518e;
    @Inject
    GlyphColorizer f16519f;
    @Inject
    InterstitialManager f16520g;
    @Inject
    Lazy<ComposerIntentLauncher> f16521h;
    @Inject
    QeAccessor f16522i;
    @Inject
    SecureContextHelper f16523j;
    public FbFragment f16524k;
    public ContentView f16525l = ((ContentView) a(2131559680));
    public BetterTextView f16526m;
    public GlyphView f16527n;
    public GlyphView f16528o;
    public EventUserWithBirthdayFragmentModel f16529p;
    public boolean f16530q;
    private boolean f16531r;
    public String f16532s;

    /* compiled from: composeExpanded */
    public class C23001 implements OnClickListener {
        final /* synthetic */ EventsBirthdayRow f16509a;

        public C23001(EventsBirthdayRow eventsBirthdayRow) {
            this.f16509a = eventsBirthdayRow;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 654159826);
            Builder builder = new Builder();
            builder.a = EventUserType.USER;
            builder = builder;
            builder.c = this.f16509a.f16529p.m();
            EventUser a2 = builder.a();
            this.f16509a.f16515b.m18115b(this.f16509a.f16530q, this.f16509a.f16532s);
            this.f16509a.f16517d.m18268a(this.f16509a.getContext(), a2);
            Logger.a(2, EntryType.UI_INPUT_END, 326176321, a);
        }
    }

    /* compiled from: composeExpanded */
    public class C23012 implements OnClickListener {
        final /* synthetic */ EventsBirthdayRow f16510a;

        public C23012(EventsBirthdayRow eventsBirthdayRow) {
            this.f16510a = eventsBirthdayRow;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -448759554);
            EventsDashboardBirthdaysComposerController eventsDashboardBirthdaysComposerController = this.f16510a.f16516c;
            EventUserWithBirthdayFragmentModel eventUserWithBirthdayFragmentModel = this.f16510a.f16529p;
            boolean z = this.f16510a.f16530q;
            String str = this.f16510a.f16532s;
            FbFragment fbFragment = this.f16510a.f16524k;
            ComposerConfiguration a2 = ComposerConfigurationFactory.a(ComposerSourceSurface.EVENT, "eventDashboardCelebrations").setInitialTargetData(EventsDashboardBirthdaysComposerController.m16956a(eventUserWithBirthdayFragmentModel)).setIsFireAndForget(true).setAllowsRedSpaceToggle(true).setReactionSurface(Surface.ANDROID_EVENTS_DASHBOARD_COMPOSER).a();
            eventsDashboardBirthdaysComposerController.f16546a.a(eventsDashboardBirthdaysComposerController.f16547b.m18113a(z, str), a2, 1756, fbFragment);
            Logger.a(2, EntryType.UI_INPUT_END, -772789478, a);
        }
    }

    /* compiled from: composeExpanded */
    public class C23023 implements OnClickListener {
        final /* synthetic */ EventsBirthdayRow f16511a;

        public C23023(EventsBirthdayRow eventsBirthdayRow) {
            this.f16511a = eventsBirthdayRow;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -853980078);
            String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.R, this.f16511a.f16529p.m());
            Intent intent = new Intent();
            intent.setData(Uri.parse(formatStrLocaleSafe));
            intent.addFlags(268435456);
            this.f16511a.f16523j.a(intent, view.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, 933504773, a);
        }
    }

    /* compiled from: composeExpanded */
    public class C23034 implements OnClickListener {
        final /* synthetic */ EventsBirthdayRow f16512a;

        public C23034(EventsBirthdayRow eventsBirthdayRow) {
            this.f16512a = eventsBirthdayRow;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 312157109);
            ComposerConfiguration.Builder reactionSurface = ComposerConfigurationFactory.a(ComposerSourceSurface.EVENT, "eventDashboardCelebrations").setIsFireAndForget(true).setInitialTargetData(EventsDashboardBirthdaysComposerController.m16956a(this.f16512a.f16529p)).setReactionSurface(Surface.ANDROID_EVENTS_DASHBOARD_COMPOSER);
            SimplePickerLauncherConfiguration.Builder builder = new SimplePickerLauncherConfiguration.Builder(SimplePickerSource.REACTION);
            builder.a = reactionSurface.a();
            ((ComposerIntentLauncher) this.f16512a.f16521h.get()).a(SimplePickerIntent.a(view.getContext(), builder.o().p().h()), 1756, this.f16512a.f16524k);
            Logger.a(2, EntryType.UI_INPUT_END, 1180237569, a);
        }
    }

    /* compiled from: composeExpanded */
    public class C23045 implements OnTouchListener {
        final /* synthetic */ EventsBirthdayRow f16513a;

        public C23045(EventsBirthdayRow eventsBirthdayRow) {
            this.f16513a = eventsBirthdayRow;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            GlyphView glyphView = (GlyphView) view;
            switch (motionEvent.getAction()) {
                case 0:
                    glyphView.setGlyphColor(-10972929);
                    break;
                case 1:
                    glyphView.setGlyphColor(-4341303);
                    glyphView.performClick();
                    break;
                case 3:
                    glyphView.setGlyphColor(-4341303);
                    break;
            }
            return true;
        }
    }

    public static void m16938a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EventsBirthdayRow) obj).m16937a(AllCapsTransformationMethod.b(injectorLike), BirthdayReminderLogger.m18107a(injectorLike), EventsDashboardBirthdaysComposerController.m16958b(injectorLike), EventPermalinkController.m18262b(injectorLike), EventsDashboardTimeFormatUtil.a(injectorLike), GlyphColorizer.a(injectorLike), InterstitialManager.a(injectorLike), IdBasedLazy.a(injectorLike, 2371), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    private void m16937a(AllCapsTransformationMethod allCapsTransformationMethod, BirthdayReminderLogger birthdayReminderLogger, EventsDashboardBirthdaysComposerController eventsDashboardBirthdaysComposerController, EventPermalinkController eventPermalinkController, EventsDashboardTimeFormatUtil eventsDashboardTimeFormatUtil, GlyphColorizer glyphColorizer, InterstitialManager interstitialManager, Lazy<ComposerIntentLauncher> lazy, QeAccessor qeAccessor, SecureContextHelper secureContextHelper) {
        this.f16514a = allCapsTransformationMethod;
        this.f16515b = birthdayReminderLogger;
        this.f16516c = eventsDashboardBirthdaysComposerController;
        this.f16517d = eventPermalinkController;
        this.f16518e = eventsDashboardTimeFormatUtil;
        this.f16519f = glyphColorizer;
        this.f16520g = interstitialManager;
        this.f16521h = lazy;
        this.f16522i = qeAccessor;
        this.f16523j = secureContextHelper;
    }

    public EventsBirthdayRow(Context context) {
        super(context);
        Class cls = EventsBirthdayRow.class;
        m16938a(this, getContext());
        setContentView(2130904119);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131431286);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131431287);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(2131431288);
        setPadding(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
        setOrientation(1);
        setBackgroundColor(-1);
        setBackgroundResource(2130843556);
        setOnClickListener(new C23001(this));
        this.f16525l.setThumbnailResource(2131363346);
        this.f16526m = (BetterTextView) a(2131561499);
        SegmentedLinearLayout segmentedLinearLayout = (SegmentedLinearLayout) a(2131561498);
        segmentedLinearLayout.setBackgroundResource(2130839540);
        this.f16526m.setPadding((int) getResources().getDimension(2131431292), 0, 0, 0);
        segmentedLinearLayout.setOnClickListener(new C23012(this));
        C23045 c23045 = new C23045(this);
        this.f16527n = (GlyphView) a(2131561496);
        this.f16527n.setOnClickListener(new C23034(this));
        this.f16527n.setOnTouchListener(c23045);
        this.f16528o = (GlyphView) a(2131561500);
        this.f16528o.setOnClickListener(new C23023(this));
        this.f16528o.setOnTouchListener(c23045);
    }

    public final void m16940a(EventUserWithBirthdayFragmentModel eventUserWithBirthdayFragmentModel, FbFragment fbFragment, boolean z, boolean z2, String str) {
        this.f16529p = eventUserWithBirthdayFragmentModel;
        this.f16524k = fbFragment;
        this.f16532s = str;
        String n = eventUserWithBirthdayFragmentModel.n();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n);
        DefaultImageFieldsModel p = eventUserWithBirthdayFragmentModel.p();
        String b = p == null ? null : p.b();
        Date date = new Date();
        BirthdateModel j = eventUserWithBirthdayFragmentModel.j();
        if (j != null) {
            String a;
            String str2 = "";
            Calendar a2 = EventsBirthdayTimeFormatUtil.a(date, TimeZone.getDefault(), j.a(), j.b());
            Calendar calendar = (Calendar) a2.clone();
            calendar.roll(1, -1);
            this.f16530q = DateUtils.isToday(a2.getTimeInMillis());
            Calendar instance = Calendar.getInstance();
            instance.set(j.c(), j.b() - 1, j.a());
            this.f16531r = EventsBirthdayTimeFormatUtil.a(Calendar.getInstance(), instance);
            if (!this.f16531r) {
                calendar = a2;
            }
            if (z) {
                a = this.f16518e.a(calendar.getTime(), date);
            } else {
                a = this.f16518e.b(calendar.getTime());
            }
            if (j.c() > 0) {
                int c = calendar.get(1) - j.c();
                int i = this.f16531r ? 2131689677 : this.f16530q ? 2131689675 : 2131689676;
                str2 = getResources().getQuantityString(i, c, new Object[]{Integer.valueOf(c)});
            }
            m16941a(n, a, str2, b, stringBuilder);
            boolean z3 = eventUserWithBirthdayFragmentModel.l() || z2;
            setComposeViews(z3);
        }
    }

    public final void m16939a(EventUserWithBirthdayFragmentModel eventUserWithBirthdayFragmentModel, FbFragment fbFragment, String str, boolean z, boolean z2) {
        this.f16529p = eventUserWithBirthdayFragmentModel;
        this.f16524k = fbFragment;
        this.f16532s = str;
        this.f16531r = z;
        this.f16530q = z2;
    }

    public final void m16941a(String str, String str2, String str3, String str4, StringBuilder stringBuilder) {
        this.f16525l.setThumbnailUri(str4 == null ? null : Uri.parse(str4));
        this.f16525l.setTitleText(str);
        this.f16525l.setTitleTextAppearance(2131625773);
        this.f16525l.setSubtitleText(str2);
        this.f16525l.setMetaText(str3);
        if (this.f16530q) {
            this.f16525l.setSubtitleTextAppearance(2131625775);
        } else {
            this.f16525l.setSubtitleTextAppearance(2131625774);
        }
        stringBuilder.append("\n").append(str2);
        stringBuilder.append("\n").append(str3);
        this.f16525l.setContentDescription(stringBuilder.toString());
    }

    public void setComposeViews(boolean z) {
        int i = 0;
        int i2 = (this.f16530q || this.f16531r) ? 1 : 0;
        ImageWithTextView imageWithTextView = (ImageWithTextView) a(2131561495);
        if (z) {
            imageWithTextView.setImageDrawable(this.f16519f.a(2130839774, -4341303));
            imageWithTextView.setTransformationMethod(this.f16514a);
            imageWithTextView.setVisibility(0);
            this.f16526m.setVisibility(8);
            this.f16527n.setVisibility(8);
            this.f16528o.setVisibility(8);
            return;
        }
        imageWithTextView.setVisibility(8);
        this.f16526m.setText(getResources().getString(2131237154));
        if (!this.f16529p.k() || i2 == 0) {
            i = 8;
        }
        this.f16526m.setVisibility(i);
        this.f16527n.setVisibility(i);
        this.f16528o.setVisibility(i);
    }
}
