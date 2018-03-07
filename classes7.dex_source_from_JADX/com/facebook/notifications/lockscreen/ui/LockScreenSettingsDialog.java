package com.facebook.notifications.lockscreen.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.fbui.widget.contentview.CheckedContentView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.lockscreen.util.LockScreenUtil;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.SwitchCompat;
import com.facebook.widget.dialog.CustomDialog;
import javax.inject.Inject;

@TargetApi(16)
/* compiled from: newsfeed_attached_story_view */
public class LockScreenSettingsDialog extends CustomDialog {
    @Inject
    public FbSharedPreferences f8217a;
    @Inject
    public LayoutInflater f8218b;
    @Inject
    public LockScreenUtil f8219c;
    @Inject
    public AnalyticsLogger f8220d;
    private View f8221e;
    public int f8222f;
    public int f8223g;
    public boolean f8224h;
    public OnClickListener f8225i;
    private final float f8226j;

    /* compiled from: newsfeed_attached_story_view */
    abstract class CheckedContentViewOnClickListener implements OnClickListener {
        abstract void mo449a(boolean z);

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1254660394);
            if (view instanceof CheckedContentView) {
                CheckedContentView checkedContentView = (CheckedContentView) view;
                checkedContentView.toggle();
                mo449a(checkedContentView.isChecked());
                LogUtils.a(755252210, a);
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            Logger.a(2, EntryType.UI_INPUT_END, -1552062061, a);
            throw illegalArgumentException;
        }
    }

    /* compiled from: newsfeed_attached_story_view */
    class C06563 extends CheckedContentViewOnClickListener {
        final /* synthetic */ LockScreenSettingsDialog f8191a;

        C06563(LockScreenSettingsDialog lockScreenSettingsDialog) {
            this.f8191a = lockScreenSettingsDialog;
        }

        final void mo449a(boolean z) {
        }
    }

    public static void m9822a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        LockScreenSettingsDialog lockScreenSettingsDialog = (LockScreenSettingsDialog) obj;
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector);
        LayoutInflater b = LayoutInflaterMethodAutoProvider.b(fbInjector);
        LockScreenUtil a = LockScreenUtil.a(fbInjector);
        AnalyticsLogger a2 = AnalyticsLoggerMethodAutoProvider.a(fbInjector);
        lockScreenSettingsDialog.f8217a = fbSharedPreferences;
        lockScreenSettingsDialog.f8218b = b;
        lockScreenSettingsDialog.f8219c = a;
        lockScreenSettingsDialog.f8220d = a2;
    }

    public LockScreenSettingsDialog(Context context) {
        this(context, null);
    }

    private LockScreenSettingsDialog(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private LockScreenSettingsDialog(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8222f = 3;
        this.f8226j = getResources().getDisplayMetrics().density;
        Class cls = LockScreenSettingsDialog.class;
        m9822a(this, getContext());
        View e = m9823e();
        this.f8221e = e;
        this.f8201c.removeAllViews();
        this.f8201c.addView(e);
    }

    private ViewGroup m9823e() {
        ViewGroup viewGroup = (ViewGroup) this.f8218b.inflate(2130905139, null);
        final SwitchCompat switchCompat = (SwitchCompat) viewGroup.findViewById(2131563635);
        final ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(2131563636);
        boolean a = this.f8217a.a(NotificationsPreferenceConstants.C, true);
        this.f8222f = 0;
        if (a) {
            this.f8222f |= 1;
        }
        if (this.f8217a.a(NotificationsPreferenceConstants.D, true)) {
            this.f8222f |= 2;
        }
        switchCompat.setChecked(this.f8222f != 0);
        this.f8223g = this.f8222f;
        this.f8224h = switchCompat.isEnabled();
        if (null != null) {
            viewGroup2.addView(m9819a(1, 2131233709, 2131233675, new CheckedContentViewOnClickListener(this) {
                final /* synthetic */ LockScreenSettingsDialog f8188b;

                final void mo449a(boolean z) {
                    boolean z2 = true;
                    LockScreenSettingsDialog.m9820a(this.f8188b, 1, z);
                    SwitchCompat switchCompat = switchCompat;
                    if (this.f8188b.f8222f == 0) {
                        z2 = false;
                    }
                    switchCompat.setChecked(z2);
                }
            }));
            viewGroup2.addView(m9819a(2, 2131233710, 2131233676, new CheckedContentViewOnClickListener(this) {
                final /* synthetic */ LockScreenSettingsDialog f8190b;

                final void mo449a(boolean z) {
                    LockScreenSettingsDialog.m9820a(this.f8190b, 2, z);
                    switchCompat.setChecked(this.f8190b.f8222f != 0);
                }
            }));
            viewGroup.findViewById(2131563637).setVisibility(0);
        }
        final CheckedContentView checkedContentView = (CheckedContentView) viewGroup.findViewById(2131563638);
        checkedContentView.setTitleText(2131233677);
        checkedContentView.setSubtitleText(2131233678);
        checkedContentView.setOnClickListener(new C06563(this));
        checkedContentView.setChecked(this.f8219c.c());
        switchCompat.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ LockScreenSettingsDialog f8194c;

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                boolean z2;
                int childCount = viewGroup2.getChildCount();
                if (z && this.f8194c.f8222f == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                for (int i = 0; i < childCount; i++) {
                    CheckedContentView checkedContentView = (CheckedContentView) viewGroup2.getChildAt(i);
                    checkedContentView.setEnabled(z);
                    if (z2) {
                        LockScreenSettingsDialog lockScreenSettingsDialog = this.f8194c;
                        lockScreenSettingsDialog.f8222f |= ((Integer) checkedContentView.getTag(2131558557)).intValue();
                        checkedContentView.setChecked(true);
                    }
                }
                checkedContentView.setEnabled(z);
            }
        });
        final Button button = (Button) viewGroup.findViewById(2131563639);
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LockScreenSettingsDialog f8198d;

            public void onClick(View view) {
                boolean z;
                boolean z2 = true;
                int a = Logger.a(2, EntryType.UI_INPUT_START, -502847687);
                if (this.f8198d.f8224h != switchCompat.isChecked()) {
                    LockScreenSettingsDialog.m9821a(this.f8198d, "master", switchCompat.isChecked());
                }
                if ((this.f8198d.f8223g & 1) != (this.f8198d.f8222f & 1)) {
                    LockScreenSettingsDialog.m9821a(this.f8198d, "notifications", (this.f8198d.f8222f & 1) != 0);
                }
                if ((this.f8198d.f8223g & 2) != (this.f8198d.f8222f & 2)) {
                    LockScreenSettingsDialog lockScreenSettingsDialog = this.f8198d;
                    String str = "messages";
                    if ((this.f8198d.f8222f & 2) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    LockScreenSettingsDialog.m9821a(lockScreenSettingsDialog, str, z);
                }
                if (this.f8198d.f8219c.c() != checkedContentView.isChecked()) {
                    LockScreenSettingsDialog.m9821a(this.f8198d, "light", checkedContentView.isChecked());
                }
                if (!switchCompat.isChecked() && this.f8198d.f8222f == 0) {
                    this.f8198d.f8222f = 3;
                }
                Editor putBoolean = this.f8198d.f8217a.edit().putBoolean(NotificationsPreferenceConstants.j, switchCompat.isChecked());
                PrefKey prefKey = NotificationsPreferenceConstants.C;
                if ((this.f8198d.f8222f & 1) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                Editor putBoolean2 = putBoolean.putBoolean(prefKey, z);
                PrefKey prefKey2 = NotificationsPreferenceConstants.D;
                if ((this.f8198d.f8222f & 2) == 0) {
                    z2 = false;
                }
                putBoolean2.putBoolean(prefKey2, z2).putBoolean(NotificationsPreferenceConstants.E, checkedContentView.isChecked()).commit();
                if (this.f8198d.f8225i != null) {
                    this.f8198d.f8225i.onClick(button);
                }
                LogUtils.a(1702233107, a);
            }
        });
        return viewGroup;
    }

    private ViewGroup m9819a(int i, int i2, int i3, CheckedContentViewOnClickListener checkedContentViewOnClickListener) {
        CheckedContentView checkedContentView = (CheckedContentView) this.f8218b.inflate(2130905138, null);
        checkedContentView.setTag(2131558557, Integer.valueOf(i));
        checkedContentView.setTitleText(i2);
        checkedContentView.setSubtitleText(i3);
        checkedContentView.setChecked((this.f8222f & i) != 0);
        checkedContentView.setOnClickListener(checkedContentViewOnClickListener);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, getResources().getDimensionPixelSize(2131429154), (int) ((-5.0f * this.f8226j) - 0.5f), 0);
        checkedContentView.setLayoutParams(layoutParams);
        return checkedContentView;
    }

    public static void m9820a(LockScreenSettingsDialog lockScreenSettingsDialog, int i, boolean z) {
        if (z) {
            lockScreenSettingsDialog.f8222f |= i;
        } else {
            lockScreenSettingsDialog.f8222f &= i ^ -1;
        }
    }

    public final void m9825b() {
        SwitchCompat switchCompat = (SwitchCompat) findViewById(2131563635);
        ViewGroup viewGroup = (ViewGroup) findViewById(2131563636);
        boolean a = this.f8217a.a(NotificationsPreferenceConstants.C, true);
        this.f8222f = 0;
        if (a) {
            this.f8222f |= 1;
        }
        if (null != null && this.f8217a.a(NotificationsPreferenceConstants.D, true)) {
            this.f8222f |= 2;
        }
        switchCompat.setChecked(this.f8222f != 0);
        this.f8223g = this.f8222f;
        this.f8224h = switchCompat.isEnabled();
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            CheckedContentView checkedContentView = (CheckedContentView) viewGroup.getChildAt(i);
            checkedContentView.setChecked((((Integer) checkedContentView.getTag(2131558557)).intValue() & this.f8222f) != 0);
        }
    }

    public final void m9824a(int i) {
        int i2 = -1;
        View view = (View) this.f8221e.getParent();
        LayoutParams layoutParams = view.getLayoutParams();
        if (i != -1) {
            i2 = -2;
        }
        layoutParams.width = i2;
        view.setLayoutParams(layoutParams);
        LayoutParams layoutParams2 = this.f8221e.getLayoutParams();
        layoutParams2.width = i;
        this.f8221e.setLayoutParams(layoutParams2);
        requestLayout();
    }

    public static void m9821a(LockScreenSettingsDialog lockScreenSettingsDialog, String str, boolean z) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("lockscreen_notification_setting_status");
        honeyClientEvent.c = "notifications";
        lockScreenSettingsDialog.f8220d.c(honeyClientEvent.a("lockscreen_notification_on", z).b("source", "info_icon").b("setting", str));
    }
}
