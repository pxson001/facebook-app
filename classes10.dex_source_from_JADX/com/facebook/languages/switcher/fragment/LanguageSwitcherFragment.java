package com.facebook.languages.switcher.fragment;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.LocaleUtil;
import com.facebook.inject.FbInjector;
import com.facebook.katana.dbl.FbAndroidAuthActivityUtil;
import com.facebook.languages.switcher.LanguageSwitcher;
import com.facebook.languages.switcher.LanguageSwitcherList;
import com.facebook.languages.switcher.LanguageSwitcherListHelper;
import com.facebook.languages.switcher.logging.LanguageSwitcherActivityEventType;
import com.facebook.languages.switcher.logging.LanguageSwitcherActivityLogger;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.futures.TasksManager;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: timed out waiting for response */
public class LanguageSwitcherFragment extends FbFragment {
    private static final int f1407g = 2131240206;
    private static final int f1408h = 2131240207;
    private static final int f1409i = 2131240204;
    @Inject
    LanguageSwitcher f1410a;
    private FbButton al;
    private FbTextView am;
    public View an;
    public View ao;
    private RadioGroup ap;
    private FbTextView aq;
    public int ar = 0;
    public int as = 0;
    private boolean at = false;
    public int au = 0;
    public int av = 0;
    public int aw;
    private boolean ax;
    public List<String> ay = null;
    private List<RadioButton> az = null;
    @Inject
    LanguageSwitcherActivityLogger f1411b;
    @Inject
    FbAndroidAuthActivityUtil f1412c;
    @Inject
    TasksManager f1413d;
    @Inject
    LanguageSwitcherListHelper f1414e;
    private final String f1415f = "en";

    /* compiled from: timed out waiting for response */
    class C02341 implements OnCheckedChangeListener {
        final /* synthetic */ LanguageSwitcherFragment f1382a;

        C02341(LanguageSwitcherFragment languageSwitcherFragment) {
            this.f1382a = languageSwitcherFragment;
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            LanguageSwitcherFragment.m1404g(this.f1382a, i);
        }
    }

    /* compiled from: timed out waiting for response */
    class C02383 implements OnClickListener {
        final /* synthetic */ LanguageSwitcherFragment f1388a;

        C02383(LanguageSwitcherFragment languageSwitcherFragment) {
            this.f1388a = languageSwitcherFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1247251543);
            this.f1388a.f1412c.a(this.f1388a.ao());
            LanguageSwitcherActivityLogger languageSwitcherActivityLogger = this.f1388a.f1411b;
            List<String> list = this.f1388a.ay;
            int i = this.f1388a.as;
            int i2 = this.f1388a.av;
            int i3 = this.f1388a.au;
            HoneyClientEvent a2 = LanguageSwitcherActivityLogger.m1410a(LanguageSwitcherActivityEventType.FINISHED);
            a2.b("device_locale", String.valueOf(Locale.getDefault())).b("network_country", languageSwitcherActivityLogger.f1417b.getNetworkCountryIso()).b("sim_country", languageSwitcherActivityLogger.f1417b.getSimCountryIso()).a("selected_index", i).a("num_selected", i2).a("num_manual_selected", i3);
            if (!(list == null || list.isEmpty())) {
                ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
                for (String h : list) {
                    arrayNode.h(h);
                }
                a2.a("locale_list", arrayNode).a("locale_list_count", list.size());
                a2.b("current_app_locale", (String) list.get(0));
                if (i < list.size()) {
                    a2.b("selected_locale", (String) list.get(i));
                }
            }
            languageSwitcherActivityLogger.f1416a.a(a2);
            Logger.a(2, EntryType.UI_INPUT_END, -924348427, a);
        }
    }

    /* compiled from: timed out waiting for response */
    class C02394 implements Callable<ListenableFuture<ImmutableList<String>>> {
        final /* synthetic */ LanguageSwitcherFragment f1389a;

        C02394(LanguageSwitcherFragment languageSwitcherFragment) {
            this.f1389a = languageSwitcherFragment;
        }

        public Object call() {
            return this.f1389a.f1410a.e();
        }
    }

    /* compiled from: timed out waiting for response */
    class C02469 implements AnimatorListener {
        final /* synthetic */ LanguageSwitcherFragment f1406a;

        C02469(LanguageSwitcherFragment languageSwitcherFragment) {
            this.f1406a = languageSwitcherFragment;
        }

        public void onAnimationEnd(Animator animator) {
            this.f1406a.ao.setVisibility(8);
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationCancel(Animator animator) {
        }
    }

    /* compiled from: timed out waiting for response */
    enum Tasks {
        SUGGESTIONS
    }

    public static void m1398a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((LanguageSwitcherFragment) obj).m1397a(LanguageSwitcher.a(fbInjector), new LanguageSwitcherActivityLogger(AnalyticsLoggerMethodAutoProvider.a(fbInjector), TelephonyManagerMethodAutoProvider.b(fbInjector)), FbAndroidAuthActivityUtil.b(fbInjector), TasksManager.b(fbInjector), LanguageSwitcherListHelper.b(fbInjector));
    }

    public final void m1408c(Bundle bundle) {
        super.c(bundle);
        Class cls = LanguageSwitcherFragment.class;
        m1398a((Object) this, getContext());
        d(true);
        this.f1411b.f1416a.a(LanguageSwitcherActivityLogger.m1410a(LanguageSwitcherActivityEventType.STARTED).b("source", o().getIntent().getStringExtra("calling_intent")));
    }

    public final View m1407a(final LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String b;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1581332838);
        View inflate = layoutInflater.inflate(2130905002, viewGroup, false);
        this.al = (FbButton) FindViewUtil.b(inflate, 2131563349);
        this.am = (FbTextView) FindViewUtil.b(inflate, 2131563350);
        this.an = FindViewUtil.b(inflate, 2131563348);
        this.ao = FindViewUtil.b(inflate, 2131563347);
        this.ap = (RadioGroup) FindViewUtil.b(inflate, 2131563346);
        this.aq = (FbTextView) FindViewUtil.b(inflate, 2131563345);
        this.aw = this.aq.getTextColors().getDefaultColor();
        this.ax = false;
        if (bundle != null) {
            this.ay = bundle.getStringArrayList("display_locales");
            this.as = bundle.getInt("checked_index", 0);
            this.at = bundle.getBoolean("fetched_suggestions", false);
            this.au = bundle.getInt("num_manual_selected", 0);
            this.av = bundle.getInt("num_selected", 0);
        }
        if (this.ay == null) {
            this.ay = Lists.a();
            b = this.f1410a.b();
            String c = this.f1410a.c();
            if (b != null) {
                this.ay.add(b);
            }
            if (!(c == null || c.equals(b))) {
                this.ay.add(c);
            }
            if (this.ay.isEmpty()) {
                this.ay.add("en".toString());
            }
        }
        this.az = Lists.a();
        for (String b2 : this.ay) {
            m1393a(layoutInflater, LocaleUtil.a(b2));
        }
        this.ap.setOnCheckedChangeListener(new C02341(this));
        this.am.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LanguageSwitcherFragment f1387b;

            /* compiled from: timed out waiting for response */
            class C02351 implements DialogInterface.OnClickListener {
                final /* synthetic */ C02372 f1383a;

                C02351(C02372 c02372) {
                    this.f1383a = c02372;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f1383a.f1387b.f1411b.m1413b("cancel");
                }
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1756123918);
                LanguageSwitcherList b = this.f1387b.f1414e.b();
                final String[] a2 = b.a();
                new FbAlertDialogBuilder(this.f1387b.getContext()).a(b.b(), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ C02372 f1385b;

                    public void onClick(DialogInterface dialogInterface, int i) {
                        Locale a = LocaleUtil.a(a2[i]);
                        LanguageSwitcherFragment.m1402b(this.f1385b.f1387b, layoutInflater, a);
                        LanguageSwitcherFragment languageSwitcherFragment = this.f1385b.f1387b;
                        languageSwitcherFragment.au++;
                        this.f1385b.f1387b.f1411b.m1413b(a.toString());
                    }
                }).c(2131240208, new C02351(this)).a().show();
                this.f1387b.f1411b.f1416a.a(LanguageSwitcherActivityLogger.m1410a(LanguageSwitcherActivityEventType.OTHER_LANGUAGES_CLICKED));
                Logger.a(2, EntryType.UI_INPUT_END, -2081596110, a);
            }
        });
        this.al.setOnClickListener(new C02383(this));
        synchronized (this) {
            try {
                if (!this.at) {
                    m1403e();
                }
            } catch (Throwable th) {
                LogUtils.f(-1815087713, a);
            }
        }
        if (!(this.at || this.f1413d.a(Tasks.SUGGESTIONS.name()))) {
            this.f1413d.a(Tasks.SUGGESTIONS.name(), new C02394(this), new AbstractDisposableFutureCallback<ImmutableList<String>>(this) {
                final /* synthetic */ LanguageSwitcherFragment f1391b;

                public final void m1391a(Object obj) {
                    ImmutableList immutableList = (ImmutableList) obj;
                    synchronized (this.f1391b) {
                        this.f1391b.at = true;
                        if (immutableList == null || immutableList.isEmpty()) {
                            this.f1391b.f1411b.m1412b();
                        } else {
                            this.f1391b.f1411b.m1411a();
                        }
                        if (immutableList == null) {
                            LanguageSwitcherFragment.aq(this.f1391b);
                            return;
                        }
                        int size = immutableList.size();
                        int i = 0;
                        int i2 = 0;
                        while (i < size) {
                            String str = (String) immutableList.get(i);
                            if (this.f1391b.ay.size() >= 4) {
                                break;
                            }
                            int i3;
                            if (this.f1391b.ay.contains(str)) {
                                i3 = i2;
                            } else {
                                LanguageSwitcherFragment.m1394a(this.f1391b, layoutInflater, LocaleUtil.a(str), i2);
                                i3 = i2 + 125;
                            }
                            i++;
                            i2 = i3;
                        }
                        LanguageSwitcherFragment.aq(this.f1391b);
                    }
                }

                public final void m1392a(Throwable th) {
                    synchronized (this.f1391b) {
                        this.f1391b.at = true;
                        LanguageSwitcherFragment.aq(this.f1391b);
                        this.f1391b.f1411b.m1414c();
                    }
                }
            });
        }
        LogUtils.f(-304672222, a);
        return inflate;
    }

    public final void m1405G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 905904536);
        super.G();
        if (this.az != null && this.as < this.az.size()) {
            ((RadioButton) this.az.get(this.as)).setChecked(true);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 486157108, a);
    }

    public final void m1406I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1754256721);
        super.I();
        this.f1413d.c(Tasks.SUGGESTIONS.name());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -608293633, a);
    }

    public final void m1409e(Bundle bundle) {
        super.e(bundle);
        bundle.putInt("checked_index", this.as);
        bundle.putBoolean("fetched_suggestions", this.at);
        bundle.putInt("num_manual_selected", this.au);
        bundle.putInt("num_selected", this.av);
        bundle.putStringArrayList("display_locales", new ArrayList(this.ay));
    }

    public static synchronized void m1404g(LanguageSwitcherFragment languageSwitcherFragment, int i) {
        synchronized (languageSwitcherFragment) {
            int i2 = 0;
            while (i2 < languageSwitcherFragment.az.size() && i2 < languageSwitcherFragment.ay.size()) {
                if (((RadioButton) languageSwitcherFragment.az.get(i2)).getId() == i) {
                    languageSwitcherFragment.m1399a((String) languageSwitcherFragment.ay.get(i2));
                    languageSwitcherFragment.as = i2;
                    break;
                }
                i2++;
            }
        }
    }

    private void m1399a(String str) {
        if (this.ax) {
            this.av++;
        }
        this.f1410a.a(str);
        m1401b();
    }

    private synchronized void m1401b() {
        this.ar++;
        m1395a(this.aq, f1409i, 0);
        m1395a(this.al, f1407g, 125);
        m1395a(this.am, f1408h, 250);
        this.ax = true;
    }

    private void m1395a(TextView textView, int i, int i2) {
        m1396a(textView, getContext().getString(i), i2);
    }

    private synchronized void m1396a(TextView textView, String str, int i) {
        final int i2 = this.ar;
        if (this.ax) {
            int i3 = (this.aw & 16777215) | 1409286144;
            ObjectAnimator ofInt = ObjectAnimator.ofInt(textView, "textColor", new int[]{this.aw, i3});
            ofInt.setDuration(250);
            ofInt.setStartDelay((long) i);
            ofInt.setEvaluator(new ArgbEvaluator());
            final ObjectAnimator ofInt2 = ObjectAnimator.ofInt(textView, "textColor", new int[]{i3, this.aw});
            ofInt2.setDuration(250);
            ofInt2.setEvaluator(new ArgbEvaluator());
            final TextView textView2 = textView;
            final String str2 = str;
            ofInt.addListener(new AnimatorListener(this) {
                final /* synthetic */ LanguageSwitcherFragment f1396e;

                public void onAnimationEnd(Animator animator) {
                    synchronized (this.f1396e) {
                        if (i2 == this.f1396e.ar || (textView2 instanceof RadioButton)) {
                            textView2.setText(str2);
                            ofInt2.start();
                        }
                    }
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationCancel(Animator animator) {
                }
            });
            ofInt.start();
        } else {
            textView.setText(str);
        }
    }

    public static synchronized RadioButton m1394a(LanguageSwitcherFragment languageSwitcherFragment, LayoutInflater layoutInflater, Locale locale, final int i) {
        final RadioButton a;
        synchronized (languageSwitcherFragment) {
            languageSwitcherFragment.ay.add(locale.toString());
            a = languageSwitcherFragment.m1393a(layoutInflater, locale);
            a.setVisibility(8);
            a.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(languageSwitcherFragment) {
                final /* synthetic */ LanguageSwitcherFragment f1401c;

                /* compiled from: timed out waiting for response */
                class C02421 implements AnimatorUpdateListener {
                    final /* synthetic */ C02447 f1397a;

                    C02421(C02447 c02447) {
                        this.f1397a = c02447;
                    }

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        LayoutParams layoutParams = a.getLayoutParams();
                        layoutParams.height = intValue;
                        a.setLayoutParams(layoutParams);
                    }
                }

                /* compiled from: timed out waiting for response */
                class C02432 implements AnimatorListener {
                    final /* synthetic */ C02447 f1398a;

                    C02432(C02447 c02447) {
                        this.f1398a = c02447;
                    }

                    public void onAnimationEnd(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                        a.setVisibility(0);
                    }

                    public void onAnimationCancel(Animator animator) {
                    }
                }

                public boolean onPreDraw() {
                    a.getViewTreeObserver().removeOnPreDrawListener(this);
                    LayoutParams layoutParams = a.getLayoutParams();
                    ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, layoutParams.height});
                    ofInt.addUpdateListener(new C02421(this));
                    ofInt.setDuration(250);
                    ofInt.setStartDelay((long) i);
                    ofInt.addListener(new C02432(this));
                    int i = this.f1401c.aw & 16777215;
                    ObjectAnimator ofInt2 = ObjectAnimator.ofInt(a, "textColor", new int[]{i, this.f1401c.aw});
                    ofInt2.setDuration(500);
                    ofInt2.setStartDelay((long) i);
                    ofInt2.setEvaluator(new ArgbEvaluator());
                    ofInt.start();
                    ofInt2.start();
                    return true;
                }
            });
        }
        return a;
    }

    private synchronized RadioButton m1393a(LayoutInflater layoutInflater, Locale locale) {
        RadioButton radioButton;
        radioButton = (RadioButton) layoutInflater.inflate(2130905003, this.ap, false);
        radioButton.setText(LocaleUtil.a(locale));
        this.az.add(radioButton);
        this.ap.addView(radioButton);
        layoutInflater.inflate(2130905001, this.ap, true);
        return radioButton;
    }

    public static synchronized void m1402b(LanguageSwitcherFragment languageSwitcherFragment, LayoutInflater layoutInflater, Locale locale) {
        synchronized (languageSwitcherFragment) {
            String a = LocaleUtil.a(locale);
            for (RadioButton radioButton : languageSwitcherFragment.az) {
                if (radioButton.getText().equals(a)) {
                    radioButton.setChecked(true);
                    break;
                }
            }
            if (languageSwitcherFragment.ay.size() < 4) {
                m1394a(languageSwitcherFragment, layoutInflater, locale, 0).setChecked(true);
            } else {
                int min = Math.min(languageSwitcherFragment.ay.size(), languageSwitcherFragment.az.size()) - 1;
                languageSwitcherFragment.ay.set(min, locale.toString());
                TextView textView = (RadioButton) languageSwitcherFragment.az.get(min);
                languageSwitcherFragment.m1396a(textView, a, 0);
                if (textView.isChecked()) {
                    m1404g(languageSwitcherFragment, textView.getId());
                } else {
                    textView.setChecked(true);
                }
            }
        }
    }

    private void m1403e() {
        this.ao.setVisibility(0);
    }

    public static void aq(LanguageSwitcherFragment languageSwitcherFragment) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) languageSwitcherFragment.an.getLayoutParams();
        final int i = marginLayoutParams.height;
        final int i2 = marginLayoutParams.topMargin;
        final int i3 = marginLayoutParams.bottomMargin;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.addUpdateListener(new AnimatorUpdateListener(languageSwitcherFragment) {
            final /* synthetic */ LanguageSwitcherFragment f1405d;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1405d.an.getLayoutParams();
                marginLayoutParams.height = (int) ((((float) i) * floatValue) + 0.5f);
                marginLayoutParams.topMargin = (int) ((((float) i2) * floatValue) + 0.5f);
                marginLayoutParams.bottomMargin = (int) ((floatValue * ((float) i3)) + 0.5f);
                this.f1405d.an.setLayoutParams(marginLayoutParams);
            }
        });
        ofFloat.setDuration(250);
        ofFloat.addListener(new C02469(languageSwitcherFragment));
        ofFloat.start();
    }

    private void m1397a(LanguageSwitcher languageSwitcher, LanguageSwitcherActivityLogger languageSwitcherActivityLogger, FbAndroidAuthActivityUtil fbAndroidAuthActivityUtil, TasksManager tasksManager, LanguageSwitcherListHelper languageSwitcherListHelper) {
        this.f1410a = languageSwitcher;
        this.f1411b = languageSwitcherActivityLogger;
        this.f1412c = fbAndroidAuthActivityUtil;
        this.f1413d = tasksManager;
        this.f1414e = languageSwitcherListHelper;
    }
}
