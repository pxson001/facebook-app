package com.facebook.greetingcards.create;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.greetingcards.create.GreetingCardEditorActivity.C00103;
import com.facebook.greetingcards.create.MomentPhotosContainer.Listener;
import com.facebook.greetingcards.model.CardPhoto;
import com.facebook.greetingcards.model.GreetingCard.Slide;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;

/* compiled from: {AccessToken */
public class MomentView extends CustomLinearLayout {
    private EditText f136a;
    private EditText f137b;
    private MomentPhotosContainer f138c;
    private TextView f139d;
    private View f140e;
    private EditText f141f;
    public C00103 f142g;
    public ArrayList<CardPhoto> f143h;
    public int f144i = 0;

    /* compiled from: {AccessToken */
    class C00241 implements Listener {
        final /* synthetic */ MomentView f132a;

        C00241(MomentView momentView) {
            this.f132a = momentView;
        }

        public final void mo3a(int i) {
            this.f132a.f144i = i;
            this.f132a.f142g.m75a();
        }

        public final void mo4b(int i) {
            this.f132a.f143h.remove(i);
            this.f132a.m154d();
        }
    }

    /* compiled from: {AccessToken */
    class C00252 implements OnClickListener {
        final /* synthetic */ MomentView f133a;

        C00252(MomentView momentView) {
            this.f133a = momentView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1287140638);
            this.f133a.f144i = this.f133a.f143h.size();
            this.f133a.f142g.m75a();
            Logger.a(2, EntryType.UI_INPUT_END, 1778463537, a);
        }
    }

    /* compiled from: {AccessToken */
    class C00273 implements OnClickListener {
        final /* synthetic */ MomentView f135a;

        /* compiled from: {AccessToken */
        class C00261 implements DialogInterface.OnClickListener {
            final /* synthetic */ C00273 f134a;

            C00261(C00273 c00273) {
                this.f134a = c00273;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f134a.f135a.m152c();
                this.f134a.f135a.f142g.m76b();
            }
        }

        C00273(MomentView momentView) {
            this.f135a = momentView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1275563161);
            AlertDialog a2 = new FbAlertDialogBuilder(this.f135a.getContext()).b(2131241450, null).a(2131241441, new C00261(this)).a();
            a2.a(this.f135a.getResources().getString(2131241451));
            a2.show();
            Logger.a(2, EntryType.UI_INPUT_END, 1873209161, a);
        }
    }

    public MomentView(Context context) {
        super(context);
        m149a();
    }

    public MomentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m149a();
    }

    private void m149a() {
        this.f143h = Lists.a();
        setOrientation(1);
        setContentView(2130904783);
        this.f136a = (EditText) a(2131562894);
        this.f137b = (EditText) a(2131562895);
        this.f138c = (MomentPhotosContainer) a(2131562896);
        this.f141f = (EditText) a(2131562894);
        this.f139d = (TextView) a(2131562897);
        this.f140e = a(2131562898);
        this.f138c.f126a = new C00241(this);
        m154d();
        m151b();
    }

    private void m151b() {
        this.f139d.setOnClickListener(new C00252(this));
        this.f140e.setOnClickListener(new C00273(this));
        int integer = getResources().getInteger(2131492960) - 1;
        int integer2 = getResources().getInteger(2131492961) - 1;
        this.f136a.addTextChangedListener(new CharLimitNotifier(getContext(), this.f141f, integer, getResources().getString(2131241466, new Object[]{Integer.valueOf(integer)})));
        this.f137b.addTextChangedListener(new CharLimitNotifier(getContext(), this.f137b, integer2, getResources().getString(2131241467, new Object[]{Integer.valueOf(integer2)})));
    }

    private void m152c() {
        this.f144i = 0;
        this.f143h = Lists.a();
        this.f136a.setText(getContext().getResources().getText(2131241435));
        this.f137b.setText("");
        m154d();
    }

    public final void m156a(CardPhoto cardPhoto) {
        if (this.f144i < this.f143h.size()) {
            this.f143h.set(this.f144i, cardPhoto);
        } else {
            this.f143h.add(cardPhoto);
        }
        m154d();
    }

    public void setSlide(Slide slide) {
        this.f136a.setText(slide.a);
        this.f137b.setText(slide.b);
        ImmutableList immutableList = slide.c;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            this.f143h.add((CardPhoto) immutableList.get(i));
        }
        m154d();
    }

    public Slide getComposedSlide() {
        return new Slide(this.f136a.getText().toString(), this.f137b.getText().toString(), ImmutableList.copyOf(this.f143h));
    }

    private void m154d() {
        this.f138c.m140a(this.f143h);
        if (this.f143h.size() < 4) {
            this.f139d.setText(2131241442);
            this.f139d.setEnabled(true);
            return;
        }
        this.f139d.setText(getResources().getString(2131241459, new Object[]{Integer.valueOf(4), Integer.valueOf(4)}));
        this.f139d.setEnabled(false);
    }
}
