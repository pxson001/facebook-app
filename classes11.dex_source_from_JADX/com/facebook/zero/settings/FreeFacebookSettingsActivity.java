package com.facebook.zero.settings;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListView;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.zero.common.constants.DialtonePrefKeys;
import com.facebook.zero.common.constants.FbZeroTokenType;
import com.facebook.zero.sdk.common.TokenRequestReason;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.sdk.constants.ZeroTokenType;
import com.facebook.zero.sdk.request.FetchZeroInterstitialContentResult;
import com.facebook.zero.sdk.token.ZeroToken;
import com.facebook.zero.sdk.token.ZeroTokenFetchListener;
import com.facebook.zero.sdk.token.ZeroTokenFetcher;
import com.facebook.zero.sdk.util.UiFeatureDataSerializer;
import com.facebook.zero.sdk.util.ZeroOptinInterstitialContentFetchListener;
import com.facebook.zero.sdk.util.ZeroOptinInterstitialContentFetcher;
import com.facebook.zero.service.FbZeroTokenFetcher;
import com.facebook.zero.service.FbZeroTokenManager;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Ljava/lang/Boolean; */
public class FreeFacebookSettingsActivity extends FbFragmentActivity {
    @Inject
    UiFeatureDataSerializer f14000A;
    @Inject
    SecureContextHelper f14001B;
    @Inject
    FbSharedPreferences f14002C;
    @Inject
    UriIntentMapper f14003D;
    protected View f14004E;
    protected ImageView f14005F;
    public ArrayAdapter f14006p;
    @Inject
    ZeroOptinInterstitialContentFetcher f14007w;
    @Inject
    ZeroTokenFetcher f14008x;
    @Inject
    FbZeroTokenManager f14009y;
    @Inject
    DefaultAndroidThreadUtil f14010z;

    /* compiled from: Ljava/lang/Boolean; */
    class C16412 implements OnClickListener {
        final /* synthetic */ FreeFacebookSettingsActivity f14023a;

        C16412(FreeFacebookSettingsActivity freeFacebookSettingsActivity) {
            this.f14023a = freeFacebookSettingsActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1551331786);
            this.f14023a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -1131517067, a);
        }
    }

    /* compiled from: Ljava/lang/Boolean; */
    class FreeFacebookAdapter extends ArrayAdapter<FreeFacebookPreference> {
        final /* synthetic */ FreeFacebookSettingsActivity f14033a;

        public FreeFacebookAdapter(FreeFacebookSettingsActivity freeFacebookSettingsActivity, Context context, List<FreeFacebookPreference> list) {
            this.f14033a = freeFacebookSettingsActivity;
            super(context, 0, list);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(2130904466, viewGroup, false);
            }
            final FreeFacebookPreference freeFacebookPreference = (FreeFacebookPreference) getItem(i);
            ((FbTextView) view.findViewById(2131562232)).setText(freeFacebookPreference.f14039f ? freeFacebookPreference.f14034a : freeFacebookPreference.f14035b);
            CompoundButton compoundButton = (CompoundButton) view.findViewById(2131562233);
            compoundButton.setChecked(freeFacebookPreference.f14039f);
            compoundButton.setOnCheckedChangeListener(freeFacebookPreference.f14043j);
            FbTextView fbTextView = (FbTextView) view.findViewById(2131562234);
            FbTextView fbTextView2 = (FbTextView) view.findViewById(2131562235);
            if (freeFacebookPreference.f14039f && freeFacebookPreference.f14036c != null) {
                fbTextView.setText(freeFacebookPreference.f14036c);
                fbTextView.setVisibility(0);
                fbTextView2.setVisibility(8);
            } else if (!(freeFacebookPreference.f14039f || freeFacebookPreference.f14037d == null)) {
                fbTextView2.setText(freeFacebookPreference.f14037d);
                fbTextView2.setVisibility(0);
                fbTextView.setVisibility(8);
                if (freeFacebookPreference.f14038e != null) {
                    fbTextView2.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ FreeFacebookAdapter f14032b;

                        public void onClick(View view) {
                            int a = Logger.a(2, EntryType.UI_INPUT_START, -1505723837);
                            this.f14032b.f14033a.f14001B.b(FreeFacebookSettingsActivity.m15126b(freeFacebookPreference.f14038e), this.f14032b.f14033a.getApplicationContext());
                            Logger.a(2, EntryType.UI_INPUT_END, -944001901, a);
                        }
                    });
                }
            }
            if (freeFacebookPreference.f14040g) {
                view.findViewById(2131562236).setVisibility(0);
                CheckBox checkBox = (CheckBox) view.findViewById(2131562238);
                ((FbTextView) view.findViewById(2131562237)).setText(freeFacebookPreference.f14041h);
                checkBox.setChecked(freeFacebookPreference.f14042i);
            }
            return view;
        }
    }

    /* compiled from: Ljava/lang/Boolean; */
    public class FreeFacebookPreference {
        String f14034a;
        String f14035b;
        CharSequence f14036c;
        CharSequence f14037d;
        Uri f14038e;
        boolean f14039f;
        boolean f14040g;
        String f14041h;
        boolean f14042i;
        OnCheckedChangeListener f14043j;

        public FreeFacebookPreference(String str, String str2, CharSequence charSequence, CharSequence charSequence2, boolean z) {
            this.f14034a = str;
            this.f14035b = str2;
            this.f14036c = charSequence;
            this.f14037d = charSequence2;
            this.f14039f = z;
        }
    }

    private static <T extends Context> void m15124a(Class<T> cls, T t) {
        m15125a((Object) t, (Context) t);
    }

    public static void m15125a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FreeFacebookSettingsActivity) obj).m15122a(ZeroOptinInterstitialContentFetcher.b(fbInjector), (ZeroTokenFetcher) FbZeroTokenFetcher.a(fbInjector), FbZeroTokenManager.b(fbInjector), DefaultAndroidThreadUtil.b(fbInjector), UiFeatureDataSerializer.b(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), (UriIntentMapper) Fb4aUriIntentMapper.a(fbInjector));
    }

    private void m15122a(ZeroOptinInterstitialContentFetcher zeroOptinInterstitialContentFetcher, ZeroTokenFetcher zeroTokenFetcher, FbZeroTokenManager fbZeroTokenManager, DefaultAndroidThreadUtil defaultAndroidThreadUtil, UiFeatureDataSerializer uiFeatureDataSerializer, SecureContextHelper secureContextHelper, FbSharedPreferences fbSharedPreferences, UriIntentMapper uriIntentMapper) {
        this.f14007w = zeroOptinInterstitialContentFetcher;
        this.f14008x = zeroTokenFetcher;
        this.f14009y = fbZeroTokenManager;
        this.f14010z = defaultAndroidThreadUtil;
        this.f14000A = uiFeatureDataSerializer;
        this.f14001B = secureContextHelper;
        this.f14002C = fbSharedPreferences;
        this.f14003D = uriIntentMapper;
    }

    protected final void m15134b(Bundle bundle) {
        super.b(bundle);
        Class cls = FreeFacebookSettingsActivity.class;
        m15125a((Object) this, (Context) this);
        mo429i();
        ListView listView = (ListView) findViewById(2131561013);
        this.f14004E = findViewById(2131559554);
        this.f14006p = new FreeFacebookAdapter(this, this, m15129l());
        listView.setAdapter(this.f14006p);
        m15128k();
    }

    protected void mo429i() {
        setContentView(2130904467);
    }

    protected final CharSequence m15130a(final FreeFacebookPreference freeFacebookPreference) {
        String a = this.f14002C.a(DialtonePrefKeys.s, "");
        String a2 = this.f14002C.a(DialtonePrefKeys.t, "");
        if (!StringUtil.a(a)) {
            return mo427a(a, a2);
        }
        this.f14004E.setVisibility(0);
        this.f14007w.a(new ZeroOptinInterstitialContentFetchListener(this) {
            final /* synthetic */ FreeFacebookSettingsActivity f14022b;

            public final void m15150a(Throwable th) {
                this.f14022b.f14007w.b(this);
                this.f14022b.finish();
                this.f14022b.f14004E.setVisibility(8);
            }

            public final void m15149a(@Nullable FetchZeroInterstitialContentResult fetchZeroInterstitialContentResult) {
                this.f14022b.f14007w.b(this);
                if (fetchZeroInterstitialContentResult == null) {
                    this.f14022b.f14004E.setVisibility(8);
                    return;
                }
                String c = fetchZeroInterstitialContentResult.c();
                String i = fetchZeroInterstitialContentResult.i();
                Uri j = fetchZeroInterstitialContentResult.j();
                this.f14022b.f14002C.edit().a(DialtonePrefKeys.s, c).a(DialtonePrefKeys.t, i).a(DialtonePrefKeys.u, j.toString()).commit();
                if (!StringUtil.a(c)) {
                    freeFacebookPreference.f14037d = this.f14022b.mo427a(c, i);
                    freeFacebookPreference.f14038e = j;
                    AdapterDetour.a(this.f14022b.f14006p, -1175075060);
                }
                this.f14022b.f14004E.setVisibility(8);
            }
        });
        Resources resources = getResources();
        this.f14007w.a(SizeUtil.a(resources), "get_terms_and_conditions", "get_terms_and_conditions");
        return resources.getString(2131232962);
    }

    protected CharSequence mo427a(String str, @Nullable String str2) {
        Resources resources = getResources();
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(resources);
        styledStringBuilder.a(str);
        styledStringBuilder.a("\n\n");
        if (!StringUtil.a(str2)) {
            styledStringBuilder.a(new ForegroundColorSpan(resources.getColor(2131361958)), 33);
            styledStringBuilder.a(str2);
            styledStringBuilder.a();
        }
        return styledStringBuilder.b();
    }

    public final Uri m15136j() {
        Object a = this.f14002C.a(DialtonePrefKeys.u, "");
        return StringUtil.a(a) ? null : Uri.parse(a);
    }

    public static Intent m15126b(Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.setFlags(335544320);
        return intent;
    }

    private void m15128k() {
        FbTitleBar fbTitleBar = (FbTitleBar) findViewById(2131558563);
        fbTitleBar.setButtonSpecs(null);
        fbTitleBar.setHasBackButton(true);
        fbTitleBar.a(new C16412(this));
        fbTitleBar.setTitle(2131232629);
    }

    private List<FreeFacebookPreference> m15129l() {
        List<FreeFacebookPreference> arrayList = new ArrayList();
        ImmutableSet a = this.f14000A.a(FbZeroTokenType.DIALTONE.getBaseToken().getUIFeaturesKey());
        if (a.contains(ZeroFeatureKey.DIALTONE_TOGGLE_BOOKMARK)) {
            if (a.contains(ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE)) {
                if (this.f14005F != null) {
                    this.f14005F.setVisibility(0);
                }
                arrayList.add(mo428b(true));
            } else {
                if (this.f14005F != null) {
                    this.f14005F.setVisibility(8);
                }
                arrayList.add(mo428b(false));
            }
        }
        return arrayList;
    }

    protected FreeFacebookPreference mo428b(boolean z) {
        Resources resources = getResources();
        final FreeFacebookPreference freeFacebookPreference = new FreeFacebookPreference(resources.getString(2131232961), resources.getString(2131232961), resources.getString(2131232962), resources.getString(2131232962), z);
        freeFacebookPreference.f14037d = m15130a(freeFacebookPreference);
        freeFacebookPreference.f14038e = m15136j();
        freeFacebookPreference.f14043j = new OnCheckedChangeListener(this) {
            final /* synthetic */ FreeFacebookSettingsActivity f14025b;

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                boolean z2 = false;
                if (z != freeFacebookPreference.f14039f) {
                    if (this.f14025b.f14004E != null) {
                        this.f14025b.f14004E.setVisibility(0);
                    }
                    FreeFacebookSettingsActivity freeFacebookSettingsActivity = this.f14025b;
                    FreeFacebookPreference freeFacebookPreference = freeFacebookPreference;
                    if (!freeFacebookPreference.f14039f) {
                        z2 = true;
                    }
                    freeFacebookSettingsActivity.m15132a(freeFacebookPreference, z2);
                }
            }
        };
        return freeFacebookPreference;
    }

    protected final void m15132a(final FreeFacebookPreference freeFacebookPreference, final boolean z) {
        this.f14007w.a(new ZeroOptinInterstitialContentFetchListener(this) {
            final /* synthetic */ FreeFacebookSettingsActivity f14030c;

            /* compiled from: Ljava/lang/Boolean; */
            class C16441 implements ZeroTokenFetchListener {
                final /* synthetic */ C16454 f14027a;

                /* compiled from: Ljava/lang/Boolean; */
                class C16431 implements Runnable {
                    final /* synthetic */ C16441 f14026a;

                    C16431(C16441 c16441) {
                        this.f14026a = c16441;
                    }

                    public void run() {
                        AdapterDetour.a(this.f14026a.f14027a.f14030c.f14006p, -281633705);
                        if (this.f14026a.f14027a.f14030c.f14004E != null) {
                            this.f14026a.f14027a.f14030c.f14004E.setVisibility(8);
                        }
                    }
                }

                C16441(C16454 c16454) {
                    this.f14027a = c16454;
                }

                public final void m15152a(Throwable th, ZeroTokenType zeroTokenType) {
                    this.f14027a.f14030c.f14008x.b(this);
                    this.f14027a.f14030c.f14009y.a(th, zeroTokenType);
                }

                public final void m15151a(ZeroToken zeroToken, ZeroTokenType zeroTokenType) {
                    this.f14027a.f14030c.f14008x.b(this);
                    this.f14027a.f14030c.f14009y.a(zeroToken, zeroTokenType);
                    freeFacebookPreference.f14039f = z;
                    this.f14027a.f14030c.f14010z.a(new C16431(this));
                    FreeFacebookSettingsActivity.m15127c(this.f14027a.f14030c, z);
                }
            }

            public final void m15154a(Throwable th) {
                this.f14030c.f14007w.b(this);
                this.f14030c.finish();
            }

            public final void m15153a(@Nullable FetchZeroInterstitialContentResult fetchZeroInterstitialContentResult) {
                this.f14030c.f14007w.b(this);
                ZeroTokenType zeroTokenType = ZeroTokenType.DIALTONE;
                this.f14030c.f14008x.a(new C16441(this));
                this.f14030c.f14008x.a(zeroTokenType, TokenRequestReason.OPTIN);
            }
        });
        this.f14007w.a(SizeUtil.a(getResources()), "bookmark", "update_optin_state");
    }

    public static void m15127c(FreeFacebookSettingsActivity freeFacebookSettingsActivity, boolean z) {
        Intent intent;
        Bundle bundle = new Bundle();
        bundle.putString("ref", "dialtone_settings_screen");
        String str = z ? "dialtone://switch_to_dialtone" : "dialtone://switch_to_full_fb";
        Intent a = freeFacebookSettingsActivity.f14003D.a(freeFacebookSettingsActivity, str);
        if (a == null) {
            a = new Intent();
            a.setData(Uri.parse(str));
            intent = a;
        } else {
            intent = a;
        }
        intent.putExtras(bundle);
        freeFacebookSettingsActivity.f14001B.a(intent, freeFacebookSettingsActivity);
    }
}
