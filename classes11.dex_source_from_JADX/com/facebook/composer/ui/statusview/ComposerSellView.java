package com.facebook.composer.ui.statusview;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.common.locale.Locales;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLCurrencyQuantity.Builder;
import com.facebook.groupcommerce.model.GroupCommerceCategory;
import com.facebook.groupcommerce.util.GroupCommercePriceFormatter;
import com.facebook.groupcommerce.widget.marketplace.CheckedPostToMarketplaceTextView;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.model.MarketplaceCrossPostSettingModel;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbEditText;
import com.facebook.resources.ui.FbTextView;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.Currency;
import javax.annotation.Nullable;

/* compiled from: fb4a_react_events */
public class ComposerSellView extends SegmentedLinearLayout {
    private FbEditText f7160a;
    public FbTextView f7161b;
    public FbEditText f7162c;
    private FbEditText f7163d;
    private FbTextView f7164e;
    private FbTextView f7165f;
    private FbEditText f7166g;
    private int f7167h;
    private CheckedPostToMarketplaceTextView f7168i;
    public Locales f7169j;
    public GroupCommercePriceFormatter f7170k;
    public String f7171l;
    public String f7172m;
    private ImmutableList<GroupCommerceCategory> f7173n;
    public GatekeeperStoreImpl f7174o;
    public QeAccessor f7175p;

    /* compiled from: fb4a_react_events */
    class C09071 implements TextWatcher {
        final /* synthetic */ ComposerSellView f7156a;

        C09071(ComposerSellView composerSellView) {
            this.f7156a = composerSellView;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.f7156a.f7162c;
        }
    }

    /* compiled from: fb4a_react_events */
    class C09082 implements OnFocusChangeListener {
        final /* synthetic */ ComposerSellView f7157a;

        C09082(ComposerSellView composerSellView) {
            this.f7157a = composerSellView;
        }

        public void onFocusChange(View view, boolean z) {
            this.f7157a.f7161b.setVisibility(z ? 0 : 8);
            this.f7157a.f7162c;
        }
    }

    /* compiled from: fb4a_react_events */
    class C09093 implements OnFocusChangeListener {
        final /* synthetic */ ComposerSellView f7158a;

        C09093(ComposerSellView composerSellView) {
            this.f7158a = composerSellView;
        }

        public void onFocusChange(View view, boolean z) {
            Preconditions.checkNotNull(this.f7158a.f7171l, "Currency code must be set.");
            FbEditText fbEditText = (FbEditText) view;
            Object obj = fbEditText.getText().toString();
            if (!StringUtil.a(obj)) {
                obj = this.f7158a.f7170k.a(obj);
                if (z) {
                    fbEditText.setText(obj);
                } else {
                    fbEditText.setText(ComposerSellView.m8376b(this.f7158a, obj));
                }
            }
        }
    }

    /* compiled from: fb4a_react_events */
    class C09104 implements TextWatcher {
        final /* synthetic */ ComposerSellView f7159a;

        C09104(ComposerSellView composerSellView) {
            this.f7159a = composerSellView;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            String a = this.f7159a.f7170k.a(editable.toString());
            if (!StringUtil.a(a)) {
                try {
                    if (Long.parseLong(a) <= 99999999999999L) {
                        return;
                    }
                } catch (NumberFormatException e) {
                }
                this.f7159a.f7162c.setText(a.substring(0, "99999999999999".length()));
                ComposerSellView.m8372a(this.f7159a.f7162c);
            }
        }
    }

    private static <T extends View> void m8373a(Class<T> cls, T t) {
        m8374a((Object) t, t.getContext());
    }

    private static void m8374a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ComposerSellView composerSellView = (ComposerSellView) obj;
        Locales a = Locales.a(fbInjector);
        GroupCommercePriceFormatter a2 = GroupCommercePriceFormatter.a(fbInjector);
        GatekeeperStoreImpl a3 = GatekeeperStoreImplMethodAutoProvider.a(fbInjector);
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector);
        composerSellView.f7169j = a;
        composerSellView.f7170k = a2;
        composerSellView.f7174o = a3;
        composerSellView.f7175p = qeAccessor;
    }

    public ComposerSellView(Context context) {
        super(context);
        m8379d();
    }

    public ComposerSellView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8379d();
    }

    private void m8379d() {
        m8373a(ComposerSellView.class, (View) this);
        setContentView(2130903724);
        this.f7160a = (FbEditText) a(2131560622);
        this.f7161b = (FbTextView) a(2131560623);
        this.f7162c = (FbEditText) a(2131560624);
        this.f7164e = (FbTextView) a(2131560627);
        this.f7163d = (FbEditText) a(2131560626);
        this.f7165f = (FbTextView) a(2131560625);
        this.f7166g = (FbEditText) a(2131560628);
        this.f7168i = (CheckedPostToMarketplaceTextView) a(2131560620);
        this.f7167h = getContext().getResources().getInteger(2131492896);
        this.f7160a.addTextChangedListener(new C09071(this));
        this.f7160a.setOnFocusChangeListener(new C09082(this));
        this.f7162c.setOnFocusChangeListener(new C09093(this));
        this.f7162c.addTextChangedListener(new C09104(this));
    }

    public final void m8382a() {
        this.f7168i.setVisibility(8);
    }

    public final void m8383a(TextWatcher textWatcher) {
        this.f7160a.addTextChangedListener(textWatcher);
        this.f7162c.addTextChangedListener(textWatcher);
        this.f7163d.addTextChangedListener(textWatcher);
        this.f7166g.addTextChangedListener(textWatcher);
    }

    public final void m8388b(TextWatcher textWatcher) {
        this.f7160a.removeTextChangedListener(textWatcher);
        this.f7162c.removeTextChangedListener(textWatcher);
        this.f7163d.removeTextChangedListener(textWatcher);
        this.f7166g.removeTextChangedListener(textWatcher);
    }

    public void setOnCategoryClickedListener(OnClickListener onClickListener) {
        this.f7165f.setOnClickListener(onClickListener);
    }

    public void setOnLocationClickedListener(OnClickListener onClickListener) {
        this.f7164e.setOnClickListener(onClickListener);
    }

    public void setOnPostToMarketplaceCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f7168i.setOnPostToMarketplaceCheckedChangeListener(onCheckedChangeListener);
    }

    public CharSequence getTitleText() {
        return this.f7160a.getText();
    }

    public void setTitleText(CharSequence charSequence) {
        this.f7160a.setText(charSequence);
        m8372a(this.f7160a);
    }

    private static void m8372a(FbEditText fbEditText) {
        int length = fbEditText.getText().length();
        Selection.setSelection(fbEditText.getText(), length, length);
    }

    public Optional<Long> getPrice() {
        String a = this.f7170k.a(this.f7162c.getText().toString());
        if (Strings.isNullOrEmpty(a)) {
            return Absent.withType();
        }
        try {
            return Optional.of(Long.valueOf(Long.parseLong(a)));
        } catch (NumberFormatException e) {
            return Absent.withType();
        }
    }

    public final void m8385a(CharSequence charSequence, String str) {
        this.f7171l = str;
        this.f7162c.setText(m8376b(this, charSequence.toString()));
        m8372a(this.f7162c);
    }

    public CharSequence getZipcodeText() {
        return this.f7163d.getText();
    }

    public void setZipcodeText(CharSequence charSequence) {
        this.f7163d.setText(charSequence);
        m8372a(this.f7163d);
    }

    public CharSequence getStructuredLocationText() {
        return this.f7164e.getText();
    }

    public void setStructuredLocationText(CharSequence charSequence) {
        this.f7164e.setText(charSequence);
    }

    public CharSequence getDescriptionText() {
        return this.f7166g.getText();
    }

    public void setDescriptionText(CharSequence charSequence) {
        this.f7166g.setText(charSequence);
        m8372a(this.f7166g);
    }

    public void setCurrencyCode(String str) {
        this.f7171l = str;
        this.f7162c.setHint(getContext().getResources().getString(2131234740) + " " + getCurrencySymbol());
    }

    public String getCurrencySymbol() {
        return m8369a(this.f7171l);
    }

    private String m8369a(String str) {
        return Currency.getInstance(str).getSymbol(this.f7169j.a());
    }

    public void setCategories(ImmutableList<GroupCommerceCategory> immutableList) {
        if (immutableList == null || immutableList.isEmpty()) {
            this.f7173n = null;
            return;
        }
        this.f7173n = immutableList;
        this.f7165f.setVisibility(0);
    }

    public final void m8386a(boolean z, @Nullable String str) {
        this.f7165f.setText(z ? getContext().getResources().getString(2131234746) : getContext().getResources().getString(2131234745));
        setCategoryID(str);
    }

    public final void m8387a(boolean z, boolean z2) {
        if (z) {
            this.f7163d.setVisibility(0);
            this.f7163d.setHint(z2 ? getContext().getResources().getString(2131234743) : getContext().getResources().getString(2131234744));
            return;
        }
        this.f7164e.setVisibility(0);
        this.f7164e.setHint(z2 ? getContext().getResources().getString(2131234742) : getContext().getResources().getString(2131234741));
    }

    public final void m8384a(@Nullable MarketplaceCrossPostSettingModel marketplaceCrossPostSettingModel, String str) {
        if (marketplaceCrossPostSettingModel != null && marketplaceCrossPostSettingModel.a().booleanValue()) {
            this.f7168i.m10441a(marketplaceCrossPostSettingModel, str);
        }
    }

    public final boolean m8389b() {
        return this.f7173n != null;
    }

    public String getSelectedCategoryID() {
        return this.f7172m;
    }

    public void setCategoryID(String str) {
        if (this.f7173n != null) {
            int size = this.f7173n.size();
            for (int i = 0; i < size; i++) {
                GroupCommerceCategory groupCommerceCategory = (GroupCommerceCategory) this.f7173n.get(i);
                if (groupCommerceCategory.categoryID.equals(str)) {
                    this.f7172m = str;
                    this.f7165f.setText(groupCommerceCategory.name);
                    this.f7165f.setTextColor(getResources().getColor(2131361921));
                    if (this.f7162c.hasFocus()) {
                        this.f7162c.clearFocus();
                        return;
                    }
                    return;
                }
            }
        }
    }

    public boolean getShouldPostToMarketplace() {
        return this.f7168i.isChecked();
    }

    public void setIsPostToMarketplaceChecked(boolean z) {
        this.f7168i.setChecked(z);
    }

    public final void m8390c() {
        this.f7160a.requestFocus();
    }

    public static void m8381e(ComposerSellView composerSellView) {
        composerSellView.f7161b.setText(StringFormatUtil.a("%d", new Object[]{Integer.valueOf(composerSellView.f7167h - composerSellView.f7160a.length())}));
    }

    public static String m8376b(ComposerSellView composerSellView, String str) {
        long parseLong = StringUtil.a(str) ? 0 : Long.parseLong(str);
        Builder builder = new Builder();
        builder.f = composerSellView.f7171l;
        builder = builder;
        builder.i = String.valueOf(parseLong * 100);
        return composerSellView.f7170k.a(builder.a(), false);
    }
}
