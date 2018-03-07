package com.facebook.messaging.payment.value.input;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.locale.Country;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentShippingOption;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.Theme;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformItemModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentShippingOptionModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.ThemeModel;
import com.facebook.messaging.payment.pin.model.PaymentPin;
import com.facebook.messaging.payment.value.input.EnterPaymentValueFragment.AnonymousClass10;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.shipping.model.MailingAddress;
import com.facebook.payments.util.PaymentsParcelableUtil;
import com.facebook.user.model.Name;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: exclude_video_id */
public class MessengerPayData implements Parcelable {
    public static final Creator<MessengerPayData> CREATOR = new C18031();
    public AnonymousClass10 f15444a;
    public MessengerPayState f15445b;
    public boolean f15446c;
    public PaymentPin f15447d;
    @Nullable
    public ImmutableList<PaymentCard> f15448e;
    public Optional<PaymentCard> f15449f;
    public Optional<PaymentMethod> f15450g;
    private List<PaymentShippingOption> f15451h;
    public Optional<PaymentShippingOption> f15452i;
    public ImmutableList<MailingAddress> f15453j;
    public Optional<MailingAddress> f15454k;
    public PaymentPlatformItemModel f15455l;
    public MoneyPennyItemParams f15456m;
    private List<Theme> f15457n;
    public ThemeModel f15458o;
    public Name f15459p;
    public UserKey f15460q;
    public TriState f15461r;
    public MessengerPayAmount f15462s;
    public String f15463t;
    public String f15464u;
    public String f15465v;
    public boolean f15466w;
    public boolean f15467x;
    public Country f15468y;

    /* compiled from: exclude_video_id */
    final class C18031 implements Creator<MessengerPayData> {
        C18031() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MessengerPayData(parcel);
        }

        public final Object[] newArray(int i) {
            return new MessengerPayData[i];
        }
    }

    public MessengerPayData() {
        this.f15445b = MessengerPayState.PREPARE_PAYMENT;
        this.f15461r = TriState.UNSET;
        this.f15462s = new MessengerPayAmount("");
    }

    protected MessengerPayData(Parcel parcel) {
        Optional fromNullable;
        this.f15459p = (Name) parcel.readParcelable(Name.class.getClassLoader());
        this.f15460q = (UserKey) parcel.readParcelable(UserKey.class.getClassLoader());
        this.f15462s = (MessengerPayAmount) parcel.readParcelable(MessengerPayAmount.class.getClassLoader());
        this.f15447d = (PaymentPin) parcel.readParcelable(PaymentPin.class.getClassLoader());
        this.f15450g = PaymentsParcelableUtil.b(parcel, PaymentMethod.class);
        this.f15449f = PaymentsParcelableUtil.b(parcel, PaymentCard.class);
        Collection readArrayList = parcel.readArrayList(PaymentCard.class.getClassLoader());
        this.f15448e = readArrayList != null ? ImmutableList.copyOf(readArrayList) : null;
        this.f15461r = (TriState) parcel.readSerializable();
        this.f15446c = ParcelUtil.a(parcel);
        this.f15463t = parcel.readString();
        this.f15464u = parcel.readString();
        this.f15445b = (MessengerPayState) parcel.readSerializable();
        this.f15465v = parcel.readString();
        this.f15466w = ParcelUtil.a(parcel);
        this.f15467x = ParcelUtil.a(parcel);
        this.f15456m = (MoneyPennyItemParams) parcel.readParcelable(MoneyPennyItemParams.class.getClassLoader());
        this.f15457n = FlatBufferModelHelper.b(parcel);
        this.f15458o = (ThemeModel) FlatBufferModelHelper.a(parcel);
        this.f15451h = FlatBufferModelHelper.b(parcel);
        if (ParcelUtil.a(parcel)) {
            fromNullable = Optional.fromNullable(FlatBufferModelHelper.a(parcel));
        } else {
            fromNullable = null;
        }
        this.f15452i = fromNullable;
        this.f15453j = PaymentsParcelableUtil.a(parcel, MailingAddress.class);
        this.f15454k = PaymentsParcelableUtil.b(parcel, MailingAddress.class);
        this.f15455l = (PaymentPlatformItemModel) FlatBufferModelHelper.a(parcel);
        this.f15468y = (Country) parcel.readParcelable(Country.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f15459p, i);
        parcel.writeParcelable(this.f15460q, i);
        parcel.writeParcelable(this.f15462s, i);
        parcel.writeParcelable(this.f15447d, i);
        PaymentsParcelableUtil.a(this.f15450g, parcel, i);
        PaymentsParcelableUtil.a(this.f15449f, parcel, i);
        parcel.writeList(this.f15448e);
        parcel.writeSerializable(this.f15461r);
        ParcelUtil.a(parcel, this.f15446c);
        parcel.writeString(this.f15463t);
        parcel.writeString(this.f15464u);
        parcel.writeSerializable(this.f15445b);
        parcel.writeString(this.f15465v);
        ParcelUtil.a(parcel, this.f15466w);
        ParcelUtil.a(parcel, this.f15467x);
        parcel.writeParcelable(this.f15456m, i);
        FlatBufferModelHelper.a(parcel, this.f15457n);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f15458o);
        FlatBufferModelHelper.a(parcel, this.f15451h);
        Optional optional = this.f15452i;
        boolean z = optional != null;
        ParcelUtil.a(parcel, z);
        if (z) {
            FlatBufferModelHelper.a(parcel, (Flattenable) optional.orNull());
        }
        parcel.writeList(this.f15453j);
        PaymentsParcelableUtil.a(this.f15454k, parcel, i);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f15455l);
        parcel.writeParcelable(this.f15468y, i);
    }

    public final void m15749a(Name name) {
        if (this.f15459p == null || !this.f15459p.equals(name)) {
            this.f15459p = name;
            m15741y();
        }
    }

    public final void m15750a(UserKey userKey) {
        if (this.f15460q == null || !this.f15460q.equals(userKey)) {
            this.f15460q = userKey;
            m15741y();
        }
    }

    public final void m15746a(MessengerPayAmount messengerPayAmount) {
        if (!this.f15462s.equals(messengerPayAmount)) {
            this.f15462s = messengerPayAmount;
            m15741y();
        }
    }

    public final void m15745a(PaymentPin paymentPin) {
        if (this.f15447d == null || !this.f15447d.equals(paymentPin)) {
            this.f15447d = paymentPin;
            m15741y();
        }
    }

    @Nullable
    public final Optional<PaymentMethod> m15763e() {
        return this.f15450g;
    }

    public final void m15751a(Optional<PaymentMethod> optional) {
        if (this.f15450g != null) {
            if (!this.f15450g.isPresent() && !optional.isPresent()) {
                return;
            }
            if (this.f15450g.isPresent() && optional.isPresent() && ((PaymentMethod) this.f15450g.get()).equals(optional.get())) {
                return;
            }
        }
        this.f15450g = optional;
        m15741y();
    }

    public final void m15756b(Optional<PaymentCard> optional) {
        if (this.f15449f != null) {
            if (!this.f15449f.isPresent() && !optional.isPresent()) {
                return;
            }
            if (this.f15449f.isPresent() && optional.isPresent() && ((PaymentCard) this.f15449f.get()).equals(optional.get())) {
                return;
            }
        }
        this.f15449f = optional;
        m15741y();
    }

    public final void m15754a(List<PaymentCard> list) {
        if (!Objects.equal(list, this.f15448e)) {
            this.f15448e = ImmutableList.copyOf(list);
            m15741y();
        }
    }

    public final void m15755a(boolean z) {
        if (!this.f15461r.isSet() || this.f15461r.asBoolean() != z) {
            this.f15461r = TriState.valueOf(z);
            m15741y();
        }
    }

    public final void m15759b(boolean z) {
        if (this.f15446c != z) {
            this.f15446c = z;
            m15741y();
        }
    }

    public final void m15753a(String str) {
        if (!StringUtil.a(str, this.f15463t)) {
            this.f15463t = str;
            m15741y();
        }
    }

    public final void m15757b(String str) {
        if (!StringUtil.a(str, this.f15464u)) {
            this.f15464u = str;
            m15741y();
        }
    }

    public final void m15747a(MessengerPayState messengerPayState) {
        if (!this.f15445b.equals(messengerPayState)) {
            this.f15445b = messengerPayState;
            m15741y();
        }
    }

    @Nullable
    public final String m15764m() {
        return this.f15465v;
    }

    @Nullable
    public final MoneyPennyItemParams m15765p() {
        return this.f15456m;
    }

    public final void m15748a(MoneyPennyItemParams moneyPennyItemParams) {
        if (this.f15456m == null || !this.f15456m.equals(moneyPennyItemParams)) {
            this.f15456m = moneyPennyItemParams;
            m15741y();
        }
    }

    @Nullable
    public final ImmutableList<Theme> m15766q() {
        return this.f15457n == null ? null : ImmutableList.copyOf(this.f15457n);
    }

    public final void m15758b(List<Theme> list) {
        if (this.f15457n == null || !this.f15457n.equals(list)) {
            this.f15457n = list;
            m15741y();
        }
    }

    public final void m15744a(ThemeModel themeModel) {
        if (this.f15458o != themeModel) {
            this.f15458o = themeModel;
            m15741y();
        }
    }

    public final ImmutableList<PaymentShippingOption> m15767s() {
        return (ImmutableList) this.f15451h;
    }

    public final void m15761c(@Nullable List<PaymentShippingOption> list) {
        if (this.f15451h == null || !this.f15451h.equals(list)) {
            this.f15451h = list;
            m15741y();
        }
    }

    public final void m15760c(@Nullable Optional<PaymentShippingOption> optional) {
        if (this.f15452i != null || optional != null) {
            if (!(this.f15452i == null || optional == null)) {
                if (!this.f15452i.isPresent() && !optional.isPresent()) {
                    return;
                }
                if (this.f15452i.isPresent() && optional.isPresent() && ((PaymentShippingOptionModel) this.f15452i.get()).equals(optional.get())) {
                    return;
                }
            }
            this.f15452i = optional;
            m15741y();
        }
    }

    public final void m15752a(ImmutableList<MailingAddress> immutableList) {
        if (this.f15453j == null || !this.f15453j.equals(immutableList)) {
            this.f15453j = immutableList;
            m15741y();
        }
    }

    public final void m15762d(Optional<MailingAddress> optional) {
        if (this.f15454k != null) {
            if (!this.f15454k.isPresent() && !optional.isPresent()) {
                return;
            }
            if (this.f15454k.isPresent() && optional.isPresent() && ((MailingAddress) this.f15454k.get()).equals(optional.get())) {
                return;
            }
        }
        this.f15454k = optional;
        m15741y();
    }

    public final void m15743a(PaymentPlatformItemModel paymentPlatformItemModel) {
        if (this.f15455l == null || !this.f15455l.equals(paymentPlatformItemModel)) {
            this.f15455l = paymentPlatformItemModel;
            m15741y();
        }
    }

    public final void m15742a(Country country) {
        if (this.f15468y == null || !this.f15468y.equals(country)) {
            this.f15468y = country;
            m15741y();
        }
    }

    private void m15741y() {
        if (this.f15444a != null) {
            EnterPaymentValueFragment.at(this.f15444a.f15260a);
        }
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("mRecipientName", this.f15459p).add("mRecipientUserKey", this.f15460q).add("mPaymentValue", this.f15462s).add("mPaymentPin", this.f15447d).add("selectedPaymentMethod", this.f15450g).add("mSelectedPaymentCard", this.f15449f).add("mPaymentCards", this.f15448e).add("mIsRecipientEligible", this.f15461r).add("mHasSenderInitiatedPay", this.f15446c).add("mMessengerPayState", this.f15445b).add("mSenderPin", this.f15465v).add("mShowPinNux", this.f15466w).add("mShowCardAddedNux", this.f15467x).add("mMoneyPennyItemParams", this.f15456m).add("mThemeList", this.f15457n).add("mSelectedTheme", this.f15458o).add("mShippingOptions", this.f15451h).add("mSelectedShippingOption", this.f15452i).add("mMailingAddresses", this.f15453j).add("mSelectedMailingAddress", this.f15454k).add("mPaymentPlatformItem", this.f15455l).add("mCountry", this.f15468y).toString();
    }
}
