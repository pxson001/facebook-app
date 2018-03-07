package com.facebook.directinstall.appdetails;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView.BufferType;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.SeparatedSpannableStringBuilder;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.directinstall.appdetails.InstallProgressDisplayHelper.C05781;
import com.facebook.directinstall.appdetails.analytics.AppDetailsLogger;
import com.facebook.directinstall.feed.DirectInstallHandler;
import com.facebook.directinstall.intent.DirectInstallAppData;
import com.facebook.directinstall.intent.DirectInstallAppDetails;
import com.facebook.directinstall.intent.DirectInstallAppDetails.Screenshot;
import com.facebook.directinstall.intent.DirectInstallAppDetails.TextWithEntities;
import com.facebook.directinstall.intent.DirectInstallAppDetails.TextWithEntities.Entity;
import com.facebook.directinstall.intent.DirectInstallIntentUtils;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.paymentsflow.uicomponents.ContentRow;
import com.facebook.resources.ui.FbTextView;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: onUpgradeGkRefresh */
public class AppDetailsFragment extends FbFragment {
    public static final String f8687a = AppDetailsFragment.class.getSimpleName();
    public static final CallerContext f8688h = CallerContext.a(AppDetailsFragment.class);
    private final HScrollListener aA = new HScrollListener(this);
    private ScreenshotItemsAdapter aB;
    public PermissionDetailsListener aC;
    public String al;
    public Map<String, Object> am;
    public FbDraweeView an;
    private ContentRow ao;
    private Button ap;
    private LinearLayout aq;
    private RecyclerView ar;
    private FbTextView as;
    private FbTextView at;
    private FbTextView au;
    private FbTextView av;
    private FacepileView aw;
    private LinearLayout ax;
    private final LinkSpan ay = new LinkSpan(this);
    private final LinkSpan az = new LinkSpan(this);
    @Inject
    DirectInstaller f8689b;
    @Inject
    AbstractFbErrorReporter f8690c;
    @Inject
    SecureContextHelper f8691d;
    @Inject
    ScreenshotItemsAdapterProvider f8692e;
    @Inject
    InstallProgressDisplayHelper f8693f;
    @Inject
    AppDetailsLogger f8694g;
    public DirectInstallAppData f8695i;

    /* compiled from: onUpgradeGkRefresh */
    class C05751 implements OnClickListener {
        final /* synthetic */ AppDetailsFragment f8681a;

        C05751(AppDetailsFragment appDetailsFragment) {
            this.f8681a = appDetailsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -282307319);
            if (this.f8681a.f8689b != null) {
                DirectInstaller directInstaller = this.f8681a.f8689b;
                Context context = this.f8681a.getContext();
                DirectInstallAppData directInstallAppData = this.f8681a.f8695i;
                Map map = this.f8681a.am;
                String str = this.f8681a.al;
                directInstaller.mo961a(context, directInstallAppData, map);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1028764174, a);
        }
    }

    /* compiled from: onUpgradeGkRefresh */
    class C05762 implements OnClickListener {
        final /* synthetic */ AppDetailsFragment f8682a;

        C05762(AppDetailsFragment appDetailsFragment) {
            this.f8682a = appDetailsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -769666919);
            PermissionDetailsListener permissionDetailsListener = this.f8682a.aC;
            Logger.a(2, EntryType.UI_INPUT_END, 1505403294, a);
        }
    }

    /* compiled from: onUpgradeGkRefresh */
    class C05773 implements Function<Entity, Uri> {
        final /* synthetic */ AppDetailsFragment f8683a;

        C05773(AppDetailsFragment appDetailsFragment) {
            this.f8683a = appDetailsFragment;
        }

        public Object apply(@Nullable Object obj) {
            Entity entity = (Entity) obj;
            Preconditions.checkNotNull(entity);
            return Uri.parse(entity.f8796b);
        }
    }

    /* compiled from: onUpgradeGkRefresh */
    class HScrollListener extends OnScrollListener {
        final /* synthetic */ AppDetailsFragment f8684a;

        public HScrollListener(AppDetailsFragment appDetailsFragment) {
            this.f8684a = appDetailsFragment;
        }

        public final void m12482a(RecyclerView recyclerView, int i) {
            super.a(recyclerView, i);
            if (i == 0) {
                this.f8684a.f8694g.m12510b(this.f8684a.f8695i.f8768b.f8773a, this.f8684a.f8695i.f8768b.f8777e, 0, this.f8684a.am);
            }
        }
    }

    /* compiled from: onUpgradeGkRefresh */
    public class LinkSpan extends ClickableSpan {
        final /* synthetic */ AppDetailsFragment f8685a;
        public String f8686b;

        public LinkSpan(AppDetailsFragment appDetailsFragment) {
            this.f8685a = appDetailsFragment;
        }

        public void onClick(View view) {
            this.f8685a.m12490a(this.f8686b, this.f8685a.getContext());
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(this.f8685a.jW_().getColor(2131363181));
        }
    }

    /* compiled from: onUpgradeGkRefresh */
    public interface PermissionDetailsListener {
    }

    public static void m12484a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AppDetailsFragment) obj).m12483a(DirectInstallHandler.m12523a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), (ScreenshotItemsAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ScreenshotItemsAdapterProvider.class), new InstallProgressDisplayHelper((Context) fbInjector.getInstance(Context.class), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(fbInjector), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector)), AppDetailsLogger.m12505a(fbInjector));
    }

    private void m12483a(DirectInstaller directInstaller, AbstractFbErrorReporter abstractFbErrorReporter, SecureContextHelper secureContextHelper, ScreenshotItemsAdapterProvider screenshotItemsAdapterProvider, InstallProgressDisplayHelper installProgressDisplayHelper, AppDetailsLogger appDetailsLogger) {
        this.f8689b = directInstaller;
        this.f8690c = abstractFbErrorReporter;
        this.f8691d = secureContextHelper;
        this.f8692e = screenshotItemsAdapterProvider;
        this.f8693f = installProgressDisplayHelper;
        this.f8694g = appDetailsLogger;
    }

    public final void m12491c(@android.support.annotation.Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = AppDetailsFragment.class;
        m12484a((Object) this, getContext());
        this.f8695i = DirectInstallIntentUtils.m12552a(this.s);
        this.al = DirectInstallIntentUtils.m12557c(this.s);
        HashMap hashMap = new HashMap(DirectInstallIntentUtils.m12556b(this.s));
        hashMap.put("app_details", Boolean.valueOf(true));
        this.am = hashMap;
        if (this.f8695i == null || this.f8695i.f8769c == null) {
            this.f8690c.a(f8687a, "Missing app data");
        }
    }

    public final View m12489a(LayoutInflater layoutInflater, @android.support.annotation.Nullable ViewGroup viewGroup, @android.support.annotation.Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -709825500);
        View inflate = layoutInflater.inflate(2130904416, viewGroup, false);
        this.ao = (ContentRow) FindViewUtil.b(inflate, 2131562135);
        this.an = (FbDraweeView) FindViewUtil.b(inflate, 2131562134);
        this.ap = (Button) FindViewUtil.b(inflate, 2131562138);
        this.au = (FbTextView) FindViewUtil.b(inflate, 2131562137);
        this.aw = (FacepileView) FindViewUtil.b(inflate, 2131562136);
        this.ax = (LinearLayout) FindViewUtil.b(inflate, 2131562139);
        this.av = (FbTextView) FindViewUtil.b(inflate, 2131562145);
        this.ap.setOnClickListener(new C05751(this));
        this.av.setOnClickListener(new C05762(this));
        m12487b(inflate);
        this.as = (FbTextView) FindViewUtil.b(inflate, 2131559642);
        this.at = (FbTextView) FindViewUtil.b(inflate, 2131562144);
        m12488c(this.f8695i.f8769c);
        m12486b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 726356017, a);
        return inflate;
    }

    private void m12487b(View view) {
        this.aq = (LinearLayout) FindViewUtil.b(view, 2131562142);
        ArrayList b = m12485b(this.f8695i.f8769c);
        ScreenshotItemsAdapterProvider screenshotItemsAdapterProvider = this.f8692e;
        FragmentActivity o = o();
        DirectInstallAppData directInstallAppData = this.f8695i;
        this.aB = new ScreenshotItemsAdapter(o, directInstallAppData, this.am, b, (SecureContextHelper) DefaultSecureContextHelper.a(screenshotItemsAdapterProvider), AppDetailsLogger.m12505a(screenshotItemsAdapterProvider));
        this.ar = (RecyclerView) FindViewUtil.b(view, 2131562143);
        this.ar.setAdapter(this.aB);
        this.ar.setOnScrollListener(this.aA);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.b(0);
        this.ar.setLayoutManager(linearLayoutManager);
        if (b.isEmpty()) {
            this.aq.setVisibility(8);
        } else {
            this.aq.setVisibility(0);
        }
    }

    private void m12486b() {
        DirectInstallAppDetails directInstallAppDetails = this.f8695i.f8769c;
        if (directInstallAppDetails.f8811m.isEmpty()) {
            this.an.setImageDrawable(jW_().getDrawable(directInstallAppDetails.f8804f));
            this.an.setScaleType(ScaleType.CENTER_CROP);
        } else {
            this.an.a(Uri.parse(((Screenshot) directInstallAppDetails.f8811m.get(0)).f8792a), f8688h);
        }
        this.ao.setTitleText(directInstallAppDetails.f8799a);
        this.ao.setSubtitleText(directInstallAppDetails.f8801c);
        this.ao.setAccessoryText(directInstallAppDetails.f8806h);
        if (directInstallAppDetails.f8802d != null) {
            this.ao.setImageUri(Uri.parse(directInstallAppDetails.f8802d));
        } else {
            this.ao.setImageResource(jW_().getDrawable(directInstallAppDetails.f8803e));
        }
        this.as.setText(directInstallAppDetails.f8800b);
        this.ay.f8686b = directInstallAppDetails.f8807i;
        this.az.f8686b = directInstallAppDetails.f8808j;
        if (directInstallAppDetails.f8809k != null) {
            TextWithEntities textWithEntities = directInstallAppDetails.f8809k;
            this.au.setText(textWithEntities.f8797a);
            List a = Lists.a(ImmutableList.copyOf(textWithEntities.f8798b), new C05773(this));
            if (a.size() > 0) {
                this.aw.setFaceUrls(a);
            } else {
                this.aw.setVisibility(8);
            }
        } else {
            this.au.setVisibility(8);
            this.aw.setVisibility(8);
        }
        ProgressBar progressBar = (ProgressBar) this.ax.findViewById(2131562141);
        ImageButton imageButton = (ImageButton) this.ax.findViewById(2131560414);
        FbTextView fbTextView = (FbTextView) this.ax.findViewById(2131562140);
        FbTextView fbTextView2 = (FbTextView) this.ax.findViewById(2131561835);
        InstallProgressDisplayHelper installProgressDisplayHelper = this.f8693f;
        installProgressDisplayHelper.f8704d = progressBar;
        installProgressDisplayHelper.f8707g = imageButton;
        installProgressDisplayHelper.f8705e = fbTextView;
        installProgressDisplayHelper.f8706f = fbTextView2;
        installProgressDisplayHelper.f8707g.setOnClickListener(new C05781(installProgressDisplayHelper));
        installProgressDisplayHelper.m12496a();
    }

    private static ArrayList<ScreenshotItem> m12485b(DirectInstallAppDetails directInstallAppDetails) {
        ArrayList<ScreenshotItem> arrayList = new ArrayList();
        ImmutableList immutableList = directInstallAppDetails.f8812n;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Screenshot screenshot = (Screenshot) immutableList.get(i);
            if (screenshot != null) {
                Uri parse = Uri.parse(screenshot.f8792a);
                int i2 = screenshot.f8793b;
                int i3 = screenshot.f8794c;
                if (parse != null && i2 > 0 && i3 > 0) {
                    arrayList.add(new ScreenshotItem(parse, i2, i3));
                }
            }
        }
        return arrayList;
    }

    private void m12488c(DirectInstallAppDetails directInstallAppDetails) {
        int i;
        int i2 = 1;
        SeparatedSpannableStringBuilder separatedSpannableStringBuilder = new SeparatedSpannableStringBuilder(" ");
        if (TextUtils.isEmpty(directInstallAppDetails.f8807i)) {
            i = 0;
        } else {
            i = 1;
        }
        if (TextUtils.isEmpty(directInstallAppDetails.f8808j)) {
            i2 = 0;
        }
        if (i != 0) {
            separatedSpannableStringBuilder.a(b(2131236003), this.ay, 0);
        }
        if (!(i == 0 || i2 == 0)) {
            separatedSpannableStringBuilder.a(b(2131236004));
        }
        if (i2 != 0) {
            separatedSpannableStringBuilder.a(b(2131236002), this.az, 0);
        }
        this.at.setText(separatedSpannableStringBuilder, BufferType.SPANNABLE);
        this.at.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void m12490a(String str, Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            this.f8691d.b(intent, context);
        } catch (Throwable e) {
            this.f8690c.a(f8687a, "Unable to openURL: " + str, e);
        }
    }
}
