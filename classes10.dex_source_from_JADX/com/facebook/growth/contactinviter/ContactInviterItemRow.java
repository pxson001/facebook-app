package com.facebook.growth.contactinviter;

import android.content.Context;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.fig.button.FigButton;
import com.facebook.growth.contactinviter.PhoneContactToken.State;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: TEST_MODE */
public class ContactInviterItemRow extends CustomViewGroup {
    @Inject
    public FreeFbJsonParams f23290a;
    private int f23291b;
    public PhoneContactToken f23292c;
    public ContactInviterFragment f23293d;
    private BetterTextView f23294e = ((BetterTextView) getView(2131558927));
    public BetterTextView f23295f = ((BetterTextView) getView(2131560318));
    public FigButton f23296g = ((FigButton) getView(2131560711));
    public ProgressBar f23297h = ((ProgressBar) getView(2131560712));

    /* compiled from: TEST_MODE */
    public class C33611 implements OnClickListener {
        final /* synthetic */ ContactInviterItemRow f23286a;

        public C33611(ContactInviterItemRow contactInviterItemRow) {
            this.f23286a = contactInviterItemRow;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1214108146);
            if (this.f23286a.f23293d != null) {
                this.f23286a.f23293d.m24616c(this.f23286a.f23292c);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -755791367, a);
        }
    }

    /* compiled from: TEST_MODE */
    public class C33622 implements OnClickListener {
        final /* synthetic */ ContactInviterItemRow f23287a;

        public C33622(ContactInviterItemRow contactInviterItemRow) {
            this.f23287a = contactInviterItemRow;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2080341703);
            if (this.f23287a.f23293d != null) {
                this.f23287a.f23293d.m24613a(this.f23287a.f23292c);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1367978919, a);
        }
    }

    /* compiled from: TEST_MODE */
    public class C33633 implements OnClickListener {
        final /* synthetic */ ContactInviterItemRow f23288a;

        public C33633(ContactInviterItemRow contactInviterItemRow) {
            this.f23288a = contactInviterItemRow;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -482102177);
            if (this.f23288a.f23293d != null) {
                this.f23288a.f23293d.m24615b(this.f23288a.f23292c);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1495749563, a);
        }
    }

    private static <T extends View> void m24617a(Class<T> cls, T t) {
        m24618a((Object) t, t.getContext());
    }

    private static void m24618a(Object obj, Context context) {
        ((ContactInviterItemRow) obj).f23290a = FreeFbJsonParams.m24621a(FbInjector.get(context));
    }

    public ContactInviterItemRow(Context context) {
        super(context);
        m24617a(ContactInviterItemRow.class, (View) this);
        setContentView(2130903764);
    }

    public final void m24620a(int i, PhoneContactToken phoneContactToken) {
        m24617a(ContactInviterItemRow.class, (View) this);
        this.f23291b = i;
        this.f23292c = phoneContactToken;
        this.f23294e.setText(phoneContactToken.f23315a);
        if (this.f23292c.f23317c == State.UNINVITED) {
            this.f23296g.setVisibility(0);
            this.f23297h.setVisibility(8);
            this.f23296g.setText(getResources().getString(2131236436));
            this.f23296g.setEnabled(true);
            this.f23296g.setOnClickListener(new C33611(this));
        } else if (this.f23292c.f23317c == State.PENDING) {
            this.f23296g.setVisibility(8);
            this.f23297h.setVisibility(0);
            this.f23296g.setOnClickListener(null);
        } else {
            this.f23296g.setVisibility(0);
            this.f23297h.setVisibility(8);
            this.f23296g.setText(getResources().getString(2131236437));
            this.f23296g.setEnabled(false);
            this.f23296g.setOnClickListener(null);
        }
        m24619b();
    }

    private void m24619b() {
        BetterTextView betterTextView;
        CharSequence string;
        StyledStringBuilder styledStringBuilder;
        switch (this.f23292c.f23317c) {
            case UNINVITED:
                this.f23295f.setText(this.f23292c.f23316b);
                this.f23295f.setOnClickListener(null);
                return;
            case PENDING:
                betterTextView = this.f23295f;
                string = getResources().getString(2131236438);
                CharSequence string2 = getResources().getString(2131236440);
                styledStringBuilder = new StyledStringBuilder(getResources());
                styledStringBuilder.a(string);
                styledStringBuilder.a(" ");
                styledStringBuilder.a(new ForegroundColorSpan(getResources().getColor(2131362081)), 33);
                styledStringBuilder.a(string2);
                this.f23295f.setOnClickListener(new C33622(this));
                betterTextView.setText(styledStringBuilder.a().b());
                return;
            case INVITED:
                betterTextView = this.f23295f;
                string = !Strings.isNullOrEmpty(this.f23290a.f23303b) ? this.f23290a.f23303b : getResources().getString(2131236439);
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(2131362081));
                styledStringBuilder = new StyledStringBuilder(getResources());
                styledStringBuilder.a(foregroundColorSpan, 33);
                styledStringBuilder.a(string);
                this.f23295f.setOnClickListener(new C33633(this));
                betterTextView.setText(styledStringBuilder.a().b());
                return;
            default:
                return;
        }
    }
}
