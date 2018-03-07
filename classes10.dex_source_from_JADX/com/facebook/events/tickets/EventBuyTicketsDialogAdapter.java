package com.facebook.events.tickets;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.format.DateFormat;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.SpannableStringFormatter;
import com.facebook.common.util.SpannableStringSubstitution;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel.EventCreatorModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketTierPermalinkFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketTierPermalinkFragmentModel.TicketTiersModel.NodesModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketTierPermalinkFragmentModel.TicketTiersModel.NodesModel.TierPriceModel;
import com.facebook.events.logging.BuyTicketsLoggingInfo;
import com.facebook.events.tickets.EventBuyTicketsQuantityButtonsAdapter.OnQuantityChangeListener;
import com.facebook.events.tickets.modal.EventBuyTicketStringFormattingUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentsflow.ui.PayView;
import com.facebook.payments.paymentsflow.ui.PayViewController;
import com.facebook.payments.paymentsflow.ui.PayViewController$PaymentMethodChangeListener;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.text.NoUnderlineClickableSpan;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Date;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: audio_clips_cancelled_by_user */
public class EventBuyTicketsDialogAdapter extends Adapter {
    public static final int[] f19093a = new int[]{f19096d, f19097e, f19098f, f19099g, f19100h};
    public static final int[] f19094b = new int[]{f19096d, f19097e, f19098f, f19099g, f19101i};
    public static final int[] f19095c = new int[]{f19096d, f19097e, f19098f, f19102j, f19100h};
    @IdRes
    private static final int f19096d = 2131558817;
    @IdRes
    private static final int f19097e = 2131558818;
    @IdRes
    private static final int f19098f = 2131558819;
    @IdRes
    private static final int f19099g = 2131558821;
    @IdRes
    private static final int f19100h = 2131558822;
    @IdRes
    private static final int f19101i = 2131558823;
    @IdRes
    private static final int f19102j = 2131558820;
    public Runnable f19103A;
    private final PayViewController$PaymentMethodChangeListener f19104B = new C27042(this);
    private OnClickListener f19105C;
    public FbDialogFragment f19106D;
    public EventBuyTicketsRecyclerView f19107E;
    private OnClickListener f19108F;
    private OnClickListener f19109G;
    public int[] f19110H;
    public final SparseIntArray f19111k = new SparseIntArray();
    public BuyTicketPayViewController f19112l;
    public PayViewController f19113m;
    private final Context f19114n;
    private final SecureContextHelper f19115o;
    private final Drawable f19116p;
    public AutoRotateDrawable f19117q;
    public final Toaster f19118r;
    private final EventsBuyTicketsDialogArgument f19119s;
    public final NodesModel f19120t;
    public int f19121u;
    @Nullable
    public String f19122v;
    public CharSequence f19123w;
    public BuyTicketsLoggingInfo f19124x;
    private EventBuyTicketStringFormattingUtil f19125y;
    private final OnQuantityChangeListener f19126z = new C27031(this);

    /* compiled from: audio_clips_cancelled_by_user */
    class C27031 implements OnQuantityChangeListener {
        final /* synthetic */ EventBuyTicketsDialogAdapter f19085a;

        C27031(EventBuyTicketsDialogAdapter eventBuyTicketsDialogAdapter) {
            this.f19085a = eventBuyTicketsDialogAdapter;
        }

        public final void mo856a(int i) {
            BuyTicketsLoggingInfo buyTicketsLoggingInfo = this.f19085a.f19124x;
            buyTicketsLoggingInfo.f17773a++;
            this.f19085a.f19121u = i;
            this.f19085a.notifyDataSetChanged();
        }
    }

    /* compiled from: audio_clips_cancelled_by_user */
    class C27042 implements PayViewController$PaymentMethodChangeListener {
        final /* synthetic */ EventBuyTicketsDialogAdapter f19086a;

        C27042(EventBuyTicketsDialogAdapter eventBuyTicketsDialogAdapter) {
            this.f19086a = eventBuyTicketsDialogAdapter;
        }

        public final void mo857a(@Nullable PaymentMethod paymentMethod) {
            String a = paymentMethod == null ? null : paymentMethod.a();
            if (!Objects.equal(this.f19086a.f19122v, a)) {
                this.f19086a.f19110H = EventBuyTicketsDialogAdapter.f19093a;
            }
            this.f19086a.f19122v = a;
            this.f19086a.f19103A = null;
            this.f19086a.notifyDataSetChanged();
        }

        public final void mo858a(Runnable runnable) {
            this.f19086a.f19110H = EventBuyTicketsDialogAdapter.f19095c;
            this.f19086a.f19103A = runnable;
            this.f19086a.notifyDataSetChanged();
        }
    }

    /* compiled from: audio_clips_cancelled_by_user */
    public class C27053 {
        public final /* synthetic */ EventBuyTicketsDialogAdapter f19087a;

        public C27053(EventBuyTicketsDialogAdapter eventBuyTicketsDialogAdapter) {
            this.f19087a = eventBuyTicketsDialogAdapter;
        }

        public final void m19312a(EventTicketTierPermalinkFragmentModel eventTicketTierPermalinkFragmentModel, String str) {
            Object obj;
            this.f19087a.f19113m.a("payments_pay_fail", str);
            BuyTicketsLoggingInfo buyTicketsLoggingInfo = this.f19087a.f19124x;
            buyTicketsLoggingInfo.f17777e++;
            Toaster toaster = this.f19087a.f19118r;
            ToastBuilder toastBuilder = new ToastBuilder(str);
            toastBuilder.b = 17;
            toaster.a(toastBuilder);
            if (eventTicketTierPermalinkFragmentModel == null || eventTicketTierPermalinkFragmentModel.k() == null || eventTicketTierPermalinkFragmentModel.k().a().isEmpty() || !eventTicketTierPermalinkFragmentModel.j()) {
                obj = null;
            } else {
                ImmutableList a = eventTicketTierPermalinkFragmentModel.k().a();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    if (Objects.equal(((NodesModel) a.get(i)).d(), this.f19087a.f19120t.d())) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
            }
            if (obj == null) {
                this.f19087a.f19106D.a();
                return;
            }
            this.f19087a.f19107E.setEnabled(true);
            this.f19087a.notifyDataSetChanged();
        }

        public final void m19313a(Throwable th) {
            this.f19087a.f19113m.a("payments_pay_fail", th.getMessage());
            BuyTicketsLoggingInfo buyTicketsLoggingInfo = this.f19087a.f19124x;
            buyTicketsLoggingInfo.f17777e++;
            Toaster toaster = this.f19087a.f19118r;
            ToastBuilder toastBuilder = new ToastBuilder(2131230762);
            toastBuilder.b = 17;
            toaster.a(toastBuilder);
            this.f19087a.f19107E.setEnabled(true);
            this.f19087a.notifyDataSetChanged();
        }
    }

    /* compiled from: audio_clips_cancelled_by_user */
    class C27064 implements OnClickListener {
        final /* synthetic */ EventBuyTicketsDialogAdapter f19088a;

        C27064(EventBuyTicketsDialogAdapter eventBuyTicketsDialogAdapter) {
            this.f19088a = eventBuyTicketsDialogAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -951434516);
            BuyTicketsLoggingInfo buyTicketsLoggingInfo = this.f19088a.f19124x;
            buyTicketsLoggingInfo.f17774b++;
            this.f19088a.f19110H = EventBuyTicketsDialogAdapter.f19094b;
            this.f19088a.notifyDataSetChanged();
            Logger.a(2, EntryType.UI_INPUT_END, -278332734, a);
        }
    }

    /* compiled from: audio_clips_cancelled_by_user */
    class C27075 implements OnClickListener {
        final /* synthetic */ EventBuyTicketsDialogAdapter f19089a;

        C27075(EventBuyTicketsDialogAdapter eventBuyTicketsDialogAdapter) {
            this.f19089a = eventBuyTicketsDialogAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1571244034);
            BuyTicketsLoggingInfo buyTicketsLoggingInfo = this.f19089a.f19124x;
            buyTicketsLoggingInfo.f17775c++;
            ImageWithTextView imageWithTextView = (ImageWithTextView) view;
            imageWithTextView.setImageDrawable(this.f19089a.f19117q);
            imageWithTextView.setText(this.f19089a.f19123w);
            imageWithTextView.setOnClickListener(null);
            this.f19089a.f19107E.setEnabled(false);
            BuyTicketPayViewController buyTicketPayViewController = this.f19089a.f19112l;
            NodesModel nodesModel = this.f19089a.f19120t;
            int i = this.f19089a.f19121u;
            PaymentMethod paymentMethod = this.f19089a.f19113m.k;
            int i2 = i;
            buyTicketPayViewController.f19083d.m19328a(nodesModel.d(), paymentMethod.a(), i2, buyTicketPayViewController.f19081b, new C27053(this.f19089a));
            this.f19089a.f19113m.a("payments_pay_submitted");
            Logger.a(2, EntryType.UI_INPUT_END, 1975072352, a);
        }
    }

    /* compiled from: audio_clips_cancelled_by_user */
    public class C27086 implements OnClickListener {
        final /* synthetic */ EventBuyTicketsDialogAdapter f19090a;

        public C27086(EventBuyTicketsDialogAdapter eventBuyTicketsDialogAdapter) {
            this.f19090a = eventBuyTicketsDialogAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -540062082);
            this.f19090a.f19110H = EventBuyTicketsDialogAdapter.f19093a;
            if (this.f19090a.f19103A != null) {
                this.f19090a.f19103A.run();
            }
            this.f19090a.notifyDataSetChanged();
            Logger.a(2, EntryType.UI_INPUT_END, 1561838586, a);
        }
    }

    /* compiled from: audio_clips_cancelled_by_user */
    class EventQuantityPickerViewHolder extends ViewHolder {
        public EventQuantityPickerViewHolder(View view) {
            super(view);
        }
    }

    /* compiled from: audio_clips_cancelled_by_user */
    class TicketVendorNameSpan extends NoUnderlineClickableSpan {
        private final SecureContextHelper f19091a;
        private final EventCreatorModel f19092b;

        public TicketVendorNameSpan(SecureContextHelper secureContextHelper, EventCreatorModel eventCreatorModel) {
            this.f19091a = secureContextHelper;
            this.f19092b = eventCreatorModel;
        }

        public void onClick(View view) {
            Uri uri = null;
            switch (this.f19092b.b().g()) {
                case 2479791:
                    uri = Uri.parse(StringFormatUtil.a(FBLinks.af, new Object[]{this.f19092b.c()}));
                    break;
                case 2645995:
                    uri = Uri.parse(StringFormatUtil.a(FBLinks.aX, new Object[]{this.f19092b.c()}));
                    break;
            }
            if (uri != null) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                this.f19091a.a(intent, view.getContext());
            }
        }
    }

    @Inject
    public EventBuyTicketsDialogAdapter(BuyTicketPayViewController buyTicketPayViewController, GlyphColorizer glyphColorizer, PayViewController payViewController, SecureContextHelper secureContextHelper, Toaster toaster, @Assisted Context context, @Assisted EventsBuyTicketsDialogArgument eventsBuyTicketsDialogArgument, @Assisted BuyTicketsLoggingInfo buyTicketsLoggingInfo, @Assisted int i, @Assisted FbDialogFragment fbDialogFragment) {
        this.f19114n = context;
        this.f19119s = eventsBuyTicketsDialogArgument;
        this.f19124x = buyTicketsLoggingInfo;
        this.f19121u = i;
        this.f19106D = fbDialogFragment;
        this.f19112l = buyTicketPayViewController;
        Resources resources = context.getResources();
        this.f19116p = glyphColorizer.a(resources.getDrawable(2130839972), -1);
        this.f19117q = new AutoRotateDrawable(resources.getDrawable(2130840153), 1000);
        this.f19123w = resources.getString(2131241921);
        this.f19113m = payViewController;
        this.f19115o = secureContextHelper;
        this.f19118r = toaster;
        this.f19120t = (NodesModel) this.f19119s.f19182h.a().get(0);
        this.f19110H = f19093a;
        this.f19105C = new C27086(this);
        this.f19108F = m19316g();
        this.f19109G = m19317h();
        this.f19122v = this.f19113m.b();
        this.f19125y = new EventBuyTicketStringFormattingUtil(resources);
    }

    public final void a_(RecyclerView recyclerView) {
        super.a_(recyclerView);
        this.f19107E = (EventBuyTicketsRecyclerView) recyclerView;
        this.f19111k.put(f19096d, 2130903998);
        this.f19111k.put(f19097e, 2130903992);
        this.f19111k.put(f19098f, 2130904005);
        this.f19111k.put(f19102j, 2130904007);
        this.f19111k.put(f19099g, 2130904001);
        this.f19111k.put(f19100h, 2130904002);
        this.f19111k.put(f19101i, 2130904000);
        recyclerView.a(new QuantityPickerDividerDecoration(recyclerView));
        this.f19112l.f19080a = this.f19113m;
        this.f19113m.a(this.f19119s.f19175a, 505, this.f19104B, this.f19106D);
    }

    public final void m19321b(RecyclerView recyclerView) {
        this.f19113m.a();
        super.b(recyclerView);
    }

    private CharSequence m19315e() {
        TierPriceModel ec_ = this.f19120t.ec_();
        return this.f19125y.m19391b(ec_.b(), ec_.c(), ec_.a(), this.f19121u);
    }

    private OnClickListener m19316g() {
        return new C27064(this);
    }

    private OnClickListener m19317h() {
        return new C27075(this);
    }

    public final ViewHolder m19318a(ViewGroup viewGroup, int i) {
        int i2 = this.f19111k.get(i, -1);
        Preconditions.checkState(i2 != -1);
        return new EventQuantityPickerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false));
    }

    public final void m19320a(ViewHolder viewHolder, int i) {
        OnClickListener onClickListener = null;
        boolean z = true;
        int i2 = this.f19110H[i];
        viewHolder.a.getContext().getResources();
        if (i2 == f19097e) {
            FbTextView fbTextView = (FbTextView) viewHolder.a;
            Resources resources = fbTextView.getResources();
            int color = resources.getColor(2131361921);
            fbTextView.setText(SpannableStringFormatter.a(resources, 2131241915, new SpannableStringSubstitution[]{new SpannableStringSubstitution(2131241916, new ForegroundColorSpan(color), 33), new SpannableStringSubstitution(2131241917, new ForegroundColorSpan(color), 33)}));
        } else if (i2 == f19096d) {
            ContentView contentView = (ContentView) viewHolder.a;
            ((FbTextView) contentView.getSubtitleView()).setMovementMethod(LinkMovementMethod.getInstance());
            contentView.setTitleText(this.f19119s.f19177c);
            contentView.setSubtitleText(m19314a(contentView));
            contentView.setThumbnailUri(this.f19119s.f19178d);
        } else if (i2 == f19098f) {
            ((EventBuyTicketsQuantityPickerView) viewHolder.a).m19353a(this.f19120t, this.f19121u, this.f19126z);
        } else if (i2 == f19102j) {
            ((RetryLoadPaymentMethodView) viewHolder.a).setActionClickListener(this.f19105C);
        } else if (i2 == f19099g) {
            ((PayView) viewHolder.a).a(this.f19113m);
        } else if (i2 == f19100h) {
            OnClickListener onClickListener2;
            r0 = (ImageWithTextView) viewHolder.a;
            r0.setText(2131230744);
            if (this.f19113m.e() || this.f19113m.c() == null) {
                z = false;
            }
            r0.setEnabled(z);
            if (z) {
                onClickListener2 = this.f19108F;
            } else {
                onClickListener2 = null;
            }
            r0.setOnClickListener(onClickListener2);
        } else if (i2 == f19101i) {
            r0 = (ImageWithTextView) viewHolder.a;
            if (this.f19112l.m19304a()) {
                r0.setImageDrawable(this.f19117q);
                r0.setText(this.f19123w);
            } else {
                r0.setImageDrawable(this.f19116p);
                r0.setText(m19315e());
            }
            if (this.f19112l.m19304a() || this.f19113m.e() || this.f19113m.c() == null) {
                z = false;
            }
            r0.setEnabled(z);
            if (z) {
                onClickListener = this.f19109G;
            }
            r0.setOnClickListener(onClickListener);
        }
    }

    private CharSequence m19314a(ContentView contentView) {
        CharSequence charSequence;
        Resources resources = contentView.getResources();
        boolean z = this.f19119s.f19179e;
        Date date = this.f19119s.f19180f;
        if (z) {
            charSequence = "MMM dd";
        } else {
            charSequence = "MMM dd, h:mm a";
        }
        CharSequence format = DateFormat.format(charSequence, date);
        if (this.f19119s.f19181g == null) {
            return format;
        }
        EventCreatorModel eventCreatorModel = this.f19119s.f19181g;
        return SpannableStringFormatter.a(resources, 2131241913, new SpannableStringSubstitution[]{new SpannableStringSubstitution(format), new SpannableStringSubstitution(eventCreatorModel.d(), new TicketVendorNameSpan(this.f19115o, eventCreatorModel), 33)});
    }

    public int getItemViewType(int i) {
        return this.f19110H[i];
    }

    public final int aZ_() {
        return this.f19110H.length;
    }

    public final void m19319a(ViewHolder viewHolder) {
        if (viewHolder.e == f19101i) {
            ((ImageWithTextView) viewHolder.a).setOnClickListener(null);
        }
    }
}
