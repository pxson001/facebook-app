package com.facebook.zero.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.zero.common.annotations.CurrentlyActiveTokenType;
import com.facebook.zero.common.constants.FbZeroTokenType;
import com.facebook.zero.common.constants.ZeroPrefKeys;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.sdk.rewrite.ZeroUrlRewriteRule;
import com.facebook.zero.sdk.rewrite.ZeroUrlRewriteRuleSerialization;
import com.facebook.zero.sdk.util.UiFeatureDataSerializer;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: ्ऋ */
public class ZeroInternStatusActivity extends FbFragmentActivity {
    @Inject
    FbSharedPreferences f42p;
    @CurrentlyActiveTokenType
    @Inject
    Provider<FbZeroTokenType> f43q;
    @Inject
    ZeroUrlRewriteRuleSerialization f44r;
    @Inject
    UiFeatureDataSerializer f45s;
    private ViewPager f46t;
    public Set<ZeroFeatureKey> f47u;

    /* compiled from: ्ऋ */
    class TokenFragment extends FbFragment {
        final /* synthetic */ ZeroInternStatusActivity f36a;
        public FbZeroTokenType f37b;
        public ImmutableList<ZeroUrlRewriteRule> f38c;
        public ImmutableList<ZeroUrlRewriteRule> f39d;

        public TokenFragment(ZeroInternStatusActivity zeroInternStatusActivity, FbZeroTokenType fbZeroTokenType) {
            this.f36a = zeroInternStatusActivity;
            this.f37b = fbZeroTokenType;
        }

        public final View m39a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
            int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 161122271);
            View inflate = layoutInflater.inflate(2130907516, viewGroup, false);
            TextView textView = (TextView) inflate.findViewById(2131568037);
            TextView textView2 = (TextView) inflate.findViewById(2131568038);
            TextView textView3 = (TextView) inflate.findViewById(2131568039);
            TextView textView4 = (TextView) inflate.findViewById(2131568040);
            TextView textView5 = (TextView) inflate.findViewById(2131560236);
            TextView textView6 = (TextView) inflate.findViewById(2131568041);
            TextView textView7 = (TextView) inflate.findViewById(2131568042);
            TextView textView8 = (TextView) inflate.findViewById(2131568043);
            TextView textView9 = (TextView) inflate.findViewById(2131568044);
            TextView textView10 = (TextView) inflate.findViewById(2131568045);
            TextView textView11 = (TextView) inflate.findViewById(2131568046);
            TextView textView12 = (TextView) inflate.findViewById(2131568047);
            EditText editText = (EditText) inflate.findViewById(2131568049);
            TextView textView13 = (TextView) inflate.findViewById(2131568050);
            TextView textView14 = (TextView) inflate.findViewById(2131568051);
            EditText editText2 = (EditText) inflate.findViewById(2131568052);
            TextView textView15 = (TextView) inflate.findViewById(2131568053);
            TextView textView16 = (TextView) inflate.findViewById(2131568054);
            TextView textView17 = (TextView) inflate.findViewById(2131568048);
            if (this.f37b == this.f36a.f43q.get()) {
                textView.setText("ACTIVE TOKEN");
            } else {
                textView.setText("INACTIVE TOKEN");
            }
            textView2.setText("Token Hash: " + this.f36a.f42p.a(this.f37b.getTokenHashKey(), ""));
            textView3.setText("Fast Token Hash: " + this.f36a.f42p.a(this.f37b.getTokenFastHashKey(), ""));
            textView4.setText("Server fetch time: " + ZeroInternStatusActivity.m43a(((long) this.f36a.f42p.a(this.f37b.getTokenRequestTimeKey(), 0)) * 1000));
            long a2 = this.f36a.f42p.a(this.f37b.getLastTimeCheckedKey(), 0);
            textView5.setText("Client last update time: " + ZeroInternStatusActivity.m43a(a2));
            textView6.setText("Client next update time: " + ZeroInternStatusActivity.m43a(a2 + ((long) (Integer.valueOf(this.f36a.f42p.a(this.f37b.getTokenTTLKey(), 0)).intValue() * 1000))));
            textView7.setText("Campaign ID: " + this.f36a.f42p.a(this.f37b.getCampaignIdKey(), ""));
            textView8.setText("Status: " + this.f36a.f42p.a(this.f37b.getStatusKey(), ""));
            String a3 = this.f36a.f42p.a(this.f37b.getRegistrationStatusKey(), "");
            textView9.setText("Registration status: " + a3);
            String a4 = this.f36a.f42p.a(this.f37b.getCarrierNameKey(), "");
            textView10.setText("Carrier name: " + a4 + " ID: " + this.f36a.f42p.a(this.f37b.getCarrierIdKey(), ""));
            textView11.setText("Stored MccMnc: " + this.f36a.f42p.a(ZeroPrefKeys.c, ""));
            if ("registered".equals(a3)) {
                textView12.setVisibility(8);
            } else {
                textView12.setText("Unregistered Reason: " + this.f36a.f42p.a(this.f37b.getUnregisteredReasonKey(), ""));
                textView12.setVisibility(0);
            }
            Object a5 = this.f36a.f42p.a(this.f37b.getRewriteRulesKey(), "");
            if (!StringUtil.a(a5)) {
                try {
                    this.f38c = ImmutableList.copyOf(this.f36a.f44r.a(a5));
                } catch (IOException e) {
                    Toast.makeText(this.f36a, "Error deserializing re-write rules", 0).show();
                }
            }
            final TextView textView18 = textView13;
            final TextView textView19 = textView14;
            editText.addTextChangedListener(new TextWatcher(this) {
                final /* synthetic */ TokenFragment f32c;

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    if (this.f32c.f38c != null) {
                        CharSequence obj = editable.toString();
                        int size = this.f32c.f38c.size();
                        for (int i = 0; i < size; i++) {
                            ZeroUrlRewriteRule zeroUrlRewriteRule = (ZeroUrlRewriteRule) this.f32c.f38c.get(i);
                            if (zeroUrlRewriteRule.a(obj)) {
                                textView18.setTextColor(-65536);
                                textView18.setText(zeroUrlRewriteRule.b(obj));
                                this.f32c.m35a(textView19, zeroUrlRewriteRule, this.f32c.f38c);
                                return;
                            }
                        }
                        textView18.setTextColor(-16776961);
                        textView18.setText(obj);
                        this.f32c.m35a(textView19, null, this.f32c.f38c);
                    }
                }
            });
            m35a(textView14, null, this.f38c);
            a5 = this.f36a.f42p.a(this.f37b.getBackupRewriteRulesKey(), "");
            if (!StringUtil.a(a5)) {
                try {
                    this.f39d = ImmutableList.copyOf(this.f36a.f44r.a(a5));
                } catch (IOException e2) {
                    Toast.makeText(this.f36a, "Error deserializing backup re-write rules", 0).show();
                }
            }
            textView18 = textView15;
            textView19 = textView16;
            editText2.addTextChangedListener(new TextWatcher(this) {
                final /* synthetic */ TokenFragment f35c;

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    if (this.f35c.f39d != null) {
                        CharSequence obj = editable.toString();
                        int size = this.f35c.f39d.size();
                        for (int i = 0; i < size; i++) {
                            ZeroUrlRewriteRule zeroUrlRewriteRule = (ZeroUrlRewriteRule) this.f35c.f39d.get(i);
                            if (zeroUrlRewriteRule.a(obj)) {
                                textView18.setTextColor(-65536);
                                textView18.setText(zeroUrlRewriteRule.b(obj));
                                this.f35c.m35a(textView19, zeroUrlRewriteRule, this.f35c.f39d);
                                return;
                            }
                        }
                        textView18.setTextColor(-16776961);
                        textView18.setText(obj);
                        this.f35c.m35a(textView19, null, this.f35c.f39d);
                    }
                }
            });
            m35a(textView16, null, this.f39d);
            this.f36a.f47u = this.f36a.f45s.a(this.f37b.getBaseToken().getUIFeaturesKey());
            if (this.f36a.f47u.isEmpty()) {
                Toast.makeText(this.f36a, "Error deserializing ui features", 0).show();
            } else {
                textView17.setText(" Features: \n" + Joiner.on("\n").join(this.f36a.f47u));
            }
            LogUtils.f(1169056784, a);
            return inflate;
        }

        private void m35a(TextView textView, ZeroUrlRewriteRule zeroUrlRewriteRule, ImmutableList<ZeroUrlRewriteRule> immutableList) {
            if (immutableList != null) {
                int i;
                int size = immutableList.size();
                String str = "";
                for (i = 0; i < size; i++) {
                    str = str + ZeroInternStatusActivity.m45a((ZeroUrlRewriteRule) immutableList.get(i));
                }
                Object obj = " Rewrite rules: \n" + str;
                textView.setText(obj, BufferType.SPANNABLE);
                if (zeroUrlRewriteRule != null) {
                    Spannable spannable = (Spannable) textView.getText();
                    str = ZeroInternStatusActivity.m45a(zeroUrlRewriteRule);
                    i = obj.indexOf(str);
                    spannable.setSpan(new ForegroundColorSpan(-65536), i, str.length() + i, 33);
                }
            }
        }

        public final CharSequence m40b() {
            return this.f37b.getBaseToken().name() + " TOKEN";
        }
    }

    /* compiled from: ्ऋ */
    class TokenPagerAdapter extends FragmentPagerAdapter {
        final /* synthetic */ ZeroInternStatusActivity f40a;
        private final List<TokenFragment> f41b;

        public TokenPagerAdapter(ZeroInternStatusActivity zeroInternStatusActivity, FragmentManager fragmentManager, List<TokenFragment> list) {
            this.f40a = zeroInternStatusActivity;
            super(fragmentManager);
            this.f41b = list;
        }

        public final Fragment m41a(int i) {
            return (Fragment) this.f41b.get(i);
        }

        public final int m42b() {
            return this.f41b.size();
        }

        public final CharSequence J_(int i) {
            return ((TokenFragment) this.f41b.get(i)).m40b();
        }
    }

    private static <T extends Context> void m49a(Class<T> cls, T t) {
        m50a((Object) t, (Context) t);
    }

    public static void m50a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ZeroInternStatusActivity) obj).m48a((FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), IdBasedProvider.a(fbInjector, 3759), ZeroUrlRewriteRuleSerialization.b(fbInjector), UiFeatureDataSerializer.b(fbInjector));
    }

    protected final void m51b(@javax.annotation.Nullable Bundle bundle) {
        int i = 0;
        super.b(bundle);
        Class cls = ZeroInternStatusActivity.class;
        m50a((Object) this, (Context) this);
        setContentView(2130907804);
        List a = Lists.a();
        for (FbZeroTokenType tokenFragment : FbZeroTokenType.values()) {
            a.add(new TokenFragment(this, tokenFragment));
        }
        this.f46t = (ViewPager) findViewById(2131562782);
        this.f46t.setAdapter(new TokenPagerAdapter(this, kO_(), a));
        while (i < a.size()) {
            if (((TokenFragment) a.get(i)).f37b == this.f43q.get()) {
                this.f46t.setCurrentItem(i);
            }
            i++;
        }
    }

    private void m48a(FbSharedPreferences fbSharedPreferences, Provider<FbZeroTokenType> provider, ZeroUrlRewriteRuleSerialization zeroUrlRewriteRuleSerialization, UiFeatureDataSerializer uiFeatureDataSerializer) {
        this.f42p = fbSharedPreferences;
        this.f43q = provider;
        this.f44r = zeroUrlRewriteRuleSerialization;
        this.f45s = uiFeatureDataSerializer;
    }

    private static String m45a(ZeroUrlRewriteRule zeroUrlRewriteRule) {
        return "Matcher:  " + zeroUrlRewriteRule.b() + "\nReplacer: " + zeroUrlRewriteRule.c() + "\n\n";
    }

    public static String m43a(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(instance.getTime());
    }
}
