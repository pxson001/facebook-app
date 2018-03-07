package com.facebook.contacts.pna.qps;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android_src.telephony.PhoneNumberFormattingTextWatcher;
import com.facebook.common.hardware.PhoneIsoCountryCode;
import com.facebook.common.phonenumbers.PhoneNumberUtilMethodAutoProvider;
import com.facebook.common.util.CollectionUtil;
import com.facebook.contacts.pna.abtest.ExperimentsForPnaABTestModule;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.katana.app.module.LocaleMethodAutoProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.phonenumbers.PhoneNumberUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quickpromotion.asset.QuickPromotionImageFetcher;
import com.facebook.quickpromotion.asset.QuickPromotionImageFetcher.ImageType;
import com.facebook.quickpromotion.customrender.CustomRenderBaseView;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Action;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Creative;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ImageParameters;
import com.facebook.quickpromotion.ui.QuickPromotionViewHelperProvider;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.user.tiles.UserTileViewLogic;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.FbImageView;
import com.facebook.widget.countryselector.CountrySelector;
import com.facebook.widget.countryselector.CountrySelector.OnCountrySelectListener;
import com.facebook.widget.countryselector.CountrySelectorProvider;
import com.facebook.widget.countryspinner.CountryCode;
import com.google.common.base.CharMatcher;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: platformContextId */
public class PhoneNumberAcquisitionQPView extends CustomFrameLayout implements CustomRenderBaseView {
    private Runnable f6525A;
    public String f6526B;
    private TextWatcher f6527C;
    @Inject
    public AllCapsTransformationMethod f6528a;
    @Inject
    CountrySelectorProvider f6529b;
    @Inject
    GlyphColorizer f6530c;
    @Inject
    public Locale f6531d;
    @Inject
    PhoneNumberAcquisitionQPControllerProvider f6532e;
    @Inject
    public PhoneNumberUtil f6533f;
    @Inject
    @PhoneIsoCountryCode
    public Provider<String> f6534g;
    @Inject
    public QeAccessor f6535h;
    @Inject
    QuickPromotionImageFetcher f6536i;
    @Inject
    QuickPromotionViewHelperProvider f6537j;
    @Inject
    UserTileViewLogic f6538k;
    public final AutoCompleteTextView f6539l;
    private final FacepileView f6540m;
    public final FbButton f6541n;
    private final FbDraweeView f6542o;
    private final FbImageView f6543p;
    private final FbTextView f6544q;
    private final TextView f6545r = ((TextView) c(2131565866));
    private final TextView f6546s = ((TextView) c(2131565867));
    public final TextView f6547t = ((TextView) c(2131565872));
    public final View f6548u;
    public CountrySelector f6549v;
    private boolean f6550w;
    private int f6551x;
    public PhoneNumberAcquisitionQPController f6552y;
    private QuickPromotionDefinition f6553z;

    /* compiled from: platformContextId */
    public class C06731 implements OnClickListener {
        final /* synthetic */ PhoneNumberAcquisitionQPView f6522a;

        /* compiled from: platformContextId */
        class C06721 implements OnCountrySelectListener {
            final /* synthetic */ C06731 f6521a;

            C06721(C06731 c06731) {
                this.f6521a = c06731;
            }

            public final void m6868a(CountryCode countryCode) {
                PhoneNumberAcquisitionQPView.m6870a(this.f6521a.f6522a, countryCode);
            }
        }

        public C06731(PhoneNumberAcquisitionQPView phoneNumberAcquisitionQPView) {
            this.f6522a = phoneNumberAcquisitionQPView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -708524307);
            KeyboardUtils.a((Activity) this.f6522a.getContext());
            if (this.f6522a.f6549v == null) {
                this.f6522a.f6549v = this.f6522a.f6529b.m3342a(this.f6522a.getContext(), true);
            }
            this.f6522a.f6549v.f3545u = new C06721(this);
            this.f6522a.f6549v.a(view);
            Logger.a(2, EntryType.UI_INPUT_END, -1379945259, a);
        }
    }

    /* compiled from: platformContextId */
    class C06742 implements OnClickListener {
        final /* synthetic */ PhoneNumberAcquisitionQPView f6523a;

        C06742(PhoneNumberAcquisitionQPView phoneNumberAcquisitionQPView) {
            this.f6523a = phoneNumberAcquisitionQPView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1082780149);
            this.f6523a.f6552y.m6865a(this.f6523a.f6539l.getText().toString(), this.f6523a.f6526B);
            Logger.a(2, EntryType.UI_INPUT_END, -1592099564, a);
        }
    }

    /* compiled from: platformContextId */
    public class C06753 implements OnClickListener {
        final /* synthetic */ PhoneNumberAcquisitionQPView f6524a;

        public C06753(PhoneNumberAcquisitionQPView phoneNumberAcquisitionQPView) {
            this.f6524a = phoneNumberAcquisitionQPView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1957562006);
            PhoneNumberAcquisitionQPController phoneNumberAcquisitionQPController = this.f6524a.f6552y;
            phoneNumberAcquisitionQPController.a.h();
            if (phoneNumberAcquisitionQPController.a.i()) {
                phoneNumberAcquisitionQPController.c();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 823686190, a);
        }
    }

    public static void m6872a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PhoneNumberAcquisitionQPView) obj).m6871a(AllCapsTransformationMethod.b(fbInjector), (CountrySelectorProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CountrySelectorProvider.class), GlyphColorizer.a(fbInjector), LocaleMethodAutoProvider.b(fbInjector), (PhoneNumberAcquisitionQPControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PhoneNumberAcquisitionQPControllerProvider.class), PhoneNumberUtilMethodAutoProvider.a(fbInjector), IdBasedProvider.a(fbInjector, 4446), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), QuickPromotionImageFetcher.a(fbInjector), (QuickPromotionViewHelperProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(QuickPromotionViewHelperProvider.class), UserTileViewLogic.a(fbInjector));
    }

    public PhoneNumberAcquisitionQPView(Context context) {
        super(context);
        Class cls = PhoneNumberAcquisitionQPView.class;
        m6872a((Object) this, getContext());
        setContentView(2130906184);
        if (this.f6535h.a(ExperimentsForPnaABTestModule.f6504c, false)) {
            this.f6547t.setBackgroundResource(2130840349);
            int dimensionPixelSize = getResources().getDimensionPixelSize(2131433314);
            this.f6547t.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        } else {
            this.f6547t.setTextColor(getResources().getColor(2131361917));
        }
        this.f6542o = (FbDraweeView) c(2131565865);
        this.f6543p = (FbImageView) c(2131565870);
        this.f6548u = c(2131565873);
        this.f6544q = (FbTextView) c(2131565869);
        this.f6540m = (FacepileView) c(2131565868);
        this.f6539l = (AutoCompleteTextView) c(2131560679);
        this.f6541n = (FbButton) c(2131565871);
        this.f6526B = (String) this.f6534g.get();
        String str = this.f6526B;
        m6870a(this, new CountryCode(str, "+" + Integer.toString(this.f6533f.getCountryCodeForRegion(str)), new Locale(this.f6531d.getLanguage(), str).getDisplayCountry(this.f6531d)));
        this.f6541n.setOnClickListener(new C06731(this));
        this.f6551x = getResources().getDimensionPixelSize(2131427501);
        this.f6543p.setImageDrawable(this.f6530c.a(2130839973, -7235677));
    }

    public final void m6874a(QuickPromotionDefinition quickPromotionDefinition, String str) {
        if (this.f6553z != quickPromotionDefinition) {
            this.f6553z = quickPromotionDefinition;
            Creative c = this.f6553z.c();
            if (c == null) {
                m6873a();
                return;
            }
            this.f6552y = this.f6532e.m6867a(getContext(), this.f6537j.a(this.f6553z, str, c, null), this.f6525A, this.f6553z, this);
            setPrimaryActionButton(c.primaryAction);
            this.f6548u.setOnClickListener(new C06753(this));
            this.f6545r.setText(c.title);
            this.f6546s.setText(c.content);
            ImageParameters b = QuickPromotionImageFetcher.b(c, ImageType.ANY);
            if (!this.f6535h.a(ExperimentsForPnaABTestModule.f6503b, false) || b == null) {
                this.f6542o.setVisibility(8);
            } else {
                this.f6542o.setImageURI(Uri.parse(b.uri));
                this.f6542o.setVisibility(0);
            }
            setFacepileUrls(null);
            if (!this.f6535h.a(ExperimentsForPnaABTestModule.f6502a, false) || c.socialContext == null) {
                setSocialContext(null);
            } else {
                setSocialContext(c.socialContext.text);
                ImmutableList immutableList = c.socialContext.friendIds;
                if (CollectionUtil.b(immutableList)) {
                    List arrayList = new ArrayList(3);
                    int i = 0;
                    while (i < immutableList.size() && i < 3) {
                        arrayList.add(this.f6538k.a((String) immutableList.get(i), this.f6551x, this.f6551x));
                        i++;
                    }
                    setFacepileUrls(arrayList);
                }
            }
            this.f6552y.a();
            this.f6550w = false;
            setVisibility(0);
        } else if (this.f6550w) {
            setVisibility(8);
        }
    }

    public void setOnDismiss(Runnable runnable) {
        this.f6525A = runnable;
    }

    public final void m6873a() {
        if (this.f6525A != null) {
            this.f6525A.run();
        }
        this.f6550w = true;
        setVisibility(8);
    }

    protected void onMeasure(int i, int i2) {
        if (this.f6550w) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(i, i2);
        }
    }

    private void setFacepileUrls(List<Uri> list) {
        FacepileView facepileView = this.f6540m;
        int i = (list == null || list.isEmpty()) ? 8 : 0;
        facepileView.setVisibility(i);
        this.f6540m.setFaceSize(this.f6551x);
        this.f6540m.setFaceUrls(list);
    }

    private void setSocialContext(CharSequence charSequence) {
        this.f6544q.setText(charSequence);
        this.f6544q.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    public static void m6870a(PhoneNumberAcquisitionQPView phoneNumberAcquisitionQPView, CountryCode countryCode) {
        phoneNumberAcquisitionQPView.f6526B = countryCode.f3547a;
        phoneNumberAcquisitionQPView.f6541n.setText("+" + Integer.toString(phoneNumberAcquisitionQPView.f6533f.getCountryCodeForRegion(phoneNumberAcquisitionQPView.f6526B)));
        phoneNumberAcquisitionQPView.f6539l.removeTextChangedListener(phoneNumberAcquisitionQPView.f6527C);
        phoneNumberAcquisitionQPView.f6527C = new PhoneNumberFormattingTextWatcher(countryCode.f3547a, phoneNumberAcquisitionQPView.getContext());
        phoneNumberAcquisitionQPView.f6539l.addTextChangedListener(phoneNumberAcquisitionQPView.f6527C);
        String removeFrom = CharMatcher.WHITESPACE.or(CharMatcher.anyOf("()-.")).removeFrom(phoneNumberAcquisitionQPView.f6539l.getText().toString());
        m6869a(phoneNumberAcquisitionQPView.f6539l, "");
        m6869a(phoneNumberAcquisitionQPView.f6539l, removeFrom);
    }

    private static void m6869a(AutoCompleteTextView autoCompleteTextView, String str) {
        ListAdapter adapter = autoCompleteTextView.getAdapter();
        if (adapter instanceof ArrayAdapter) {
            autoCompleteTextView.setAdapter(null);
            autoCompleteTextView.setText(str);
            autoCompleteTextView.setAdapter((ArrayAdapter) adapter);
            return;
        }
        autoCompleteTextView.setText(str);
    }

    private void setPrimaryActionButton(Action action) {
        this.f6547t.setOnClickListener(new C06742(this));
        TextView textView = this.f6547t;
        if (action == null || Strings.isNullOrEmpty(action.title)) {
            textView.setVisibility(8);
            return;
        }
        textView.setText(this.f6528a.getTransformation(action.title, null));
        textView.setVisibility(0);
    }

    private void m6871a(AllCapsTransformationMethod allCapsTransformationMethod, CountrySelectorProvider countrySelectorProvider, GlyphColorizer glyphColorizer, Locale locale, PhoneNumberAcquisitionQPControllerProvider phoneNumberAcquisitionQPControllerProvider, PhoneNumberUtil phoneNumberUtil, Provider<String> provider, QeAccessor qeAccessor, QuickPromotionImageFetcher quickPromotionImageFetcher, QuickPromotionViewHelperProvider quickPromotionViewHelperProvider, UserTileViewLogic userTileViewLogic) {
        this.f6528a = allCapsTransformationMethod;
        this.f6529b = countrySelectorProvider;
        this.f6530c = glyphColorizer;
        this.f6531d = locale;
        this.f6532e = phoneNumberAcquisitionQPControllerProvider;
        this.f6533f = phoneNumberUtil;
        this.f6534g = provider;
        this.f6535h = qeAccessor;
        this.f6536i = quickPromotionImageFetcher;
        this.f6537j = quickPromotionViewHelperProvider;
        this.f6538k = userTileViewLogic;
    }
}
