package com.facebook.timeline.tempprofilepic;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.Toast;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.stagingground.StagingGroundController.C10734;
import java.util.GregorianCalendar;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: facecast_reactions_toggle_on */
public class ExpirationDialogController {
    public final OnMenuItemClickListener f14922a = new C10971(this);
    private final OnValueChangeListener f14923b = new C10982(this);
    private final OnValueChangeListener f14924c = new C10993(this);
    private final OnValueChangeListener f14925d = new C11004(this);
    private final OnValueChangeListener f14926e = new C11015(this);
    private final OnClickListener f14927f = new C11026(this);
    private final OnClickListener f14928g = new C11037(this);
    public AlertDialog f14929h;
    private NumberPicker f14930i;
    private NumberPicker f14931j;
    private NumberPicker f14932k;
    private NumberPicker f14933l;
    public PopoverMenuWindow f14934m;
    public ImageWithTextView f14935n;
    public C10734 f14936o;
    public final Context f14937p;
    public final ExpirationDialogModel f14938q;
    private final ExpirationDialogViewBinder f14939r;
    private final ExpirationDialogNumberPickersViewBinder f14940s;
    private final AllCapsTransformationMethod f14941t;
    private final GlyphColorizer f14942u;

    /* compiled from: facecast_reactions_toggle_on */
    class C10971 implements OnMenuItemClickListener {
        final /* synthetic */ ExpirationDialogController f14913a;

        C10971(ExpirationDialogController expirationDialogController) {
            this.f14913a = expirationDialogController;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            C10734 c10734;
            switch (menuItem.getItemId()) {
                case 1:
                    this.f14913a.f14938q.m18780a(10, 1);
                    ExpirationDialogController.m18770a(this.f14913a, this.f14913a.f14935n, this.f14913a.f14938q);
                    if (this.f14913a.f14936o != null) {
                        c10734 = this.f14913a.f14936o;
                        this.f14913a.f14938q.m18781d();
                        c10734.m18654a();
                        break;
                    }
                    break;
                case 2:
                    this.f14913a.f14938q.m18780a(6, 1);
                    ExpirationDialogController.m18770a(this.f14913a, this.f14913a.f14935n, this.f14913a.f14938q);
                    if (this.f14913a.f14936o != null) {
                        c10734 = this.f14913a.f14936o;
                        this.f14913a.f14938q.m18781d();
                        c10734.m18654a();
                        break;
                    }
                    break;
                case 3:
                    this.f14913a.f14938q.m18780a(6, 7);
                    ExpirationDialogController.m18770a(this.f14913a, this.f14913a.f14935n, this.f14913a.f14938q);
                    if (this.f14913a.f14936o != null) {
                        c10734 = this.f14913a.f14936o;
                        this.f14913a.f14938q.m18781d();
                        c10734.m18654a();
                        break;
                    }
                    break;
                case 4:
                    ExpirationDialogController.m18772d(this.f14913a);
                    ExpirationDialogController.m18771c(this.f14913a);
                    this.f14913a.f14929h.show();
                    break;
                case 5:
                    this.f14913a.f14938q.m18784g();
                    ExpirationDialogController.m18770a(this.f14913a, this.f14913a.f14935n, this.f14913a.f14938q);
                    if (this.f14913a.f14936o != null) {
                        c10734 = this.f14913a.f14936o;
                        this.f14913a.f14938q.m18781d();
                        c10734.m18654a();
                        break;
                    }
                    break;
                default:
                    throw new UnsupportedOperationException("Unimplemented Context Menu Entry!");
            }
            return true;
        }
    }

    /* compiled from: facecast_reactions_toggle_on */
    class C10982 implements OnValueChangeListener {
        final /* synthetic */ ExpirationDialogController f14914a;

        C10982(ExpirationDialogController expirationDialogController) {
            this.f14914a = expirationDialogController;
        }

        public void onValueChange(NumberPicker numberPicker, int i, int i2) {
            this.f14914a.f14938q.f14947e = i2;
            ExpirationDialogController.m18772d(this.f14914a);
            ExpirationDialogController.m18771c(this.f14914a);
        }
    }

    /* compiled from: facecast_reactions_toggle_on */
    class C10993 implements OnValueChangeListener {
        final /* synthetic */ ExpirationDialogController f14915a;

        C10993(ExpirationDialogController expirationDialogController) {
            this.f14915a = expirationDialogController;
        }

        public void onValueChange(NumberPicker numberPicker, int i, int i2) {
            int i3 = i2 % 12;
            if (this.f14915a.f14938q.f14948f < 12) {
                this.f14915a.f14938q.f14948f = i3;
            } else {
                this.f14915a.f14938q.f14948f = i3 + 12;
            }
            ExpirationDialogController.m18772d(this.f14915a);
            ExpirationDialogController.m18771c(this.f14915a);
        }
    }

    /* compiled from: facecast_reactions_toggle_on */
    class C11004 implements OnValueChangeListener {
        final /* synthetic */ ExpirationDialogController f14916a;

        C11004(ExpirationDialogController expirationDialogController) {
            this.f14916a = expirationDialogController;
        }

        public void onValueChange(NumberPicker numberPicker, int i, int i2) {
            this.f14916a.f14938q.f14949g = i2 * 15;
            ExpirationDialogController.m18772d(this.f14916a);
            ExpirationDialogController.m18771c(this.f14916a);
        }
    }

    /* compiled from: facecast_reactions_toggle_on */
    class C11015 implements OnValueChangeListener {
        final /* synthetic */ ExpirationDialogController f14917a;

        C11015(ExpirationDialogController expirationDialogController) {
            this.f14917a = expirationDialogController;
        }

        public void onValueChange(NumberPicker numberPicker, int i, int i2) {
            if (i2 == 1 && i == 0) {
                this.f14917a.f14938q.f14948f += 12;
            } else if (i2 == 0 && i == 1) {
                this.f14917a.f14938q.f14948f -= 12;
            }
            ExpirationDialogController.m18772d(this.f14917a);
            ExpirationDialogController.m18771c(this.f14917a);
        }
    }

    /* compiled from: facecast_reactions_toggle_on */
    class C11026 implements OnClickListener {
        final /* synthetic */ ExpirationDialogController f14918a;

        C11026(ExpirationDialogController expirationDialogController) {
            this.f14918a = expirationDialogController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ExpirationDialogController.m18770a(this.f14918a, this.f14918a.f14935n, this.f14918a.f14938q);
            if (this.f14918a.f14936o != null) {
                C10734 c10734 = this.f14918a.f14936o;
                this.f14918a.f14938q.m18781d();
                c10734.m18654a();
            }
        }
    }

    /* compiled from: facecast_reactions_toggle_on */
    class C11037 implements OnClickListener {
        final /* synthetic */ ExpirationDialogController f14919a;

        C11037(ExpirationDialogController expirationDialogController) {
            this.f14919a = expirationDialogController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f14919a.f14938q.m18784g();
            ExpirationDialogController.m18770a(this.f14919a, this.f14919a.f14935n, this.f14919a.f14938q);
            if (this.f14919a.f14936o != null) {
                C10734 c10734 = this.f14919a.f14936o;
                this.f14919a.f14938q.m18781d();
                c10734.m18654a();
            }
        }
    }

    @Inject
    public ExpirationDialogController(Context context, ExpirationDialogModelProvider expirationDialogModelProvider, ExpirationDialogViewBinder expirationDialogViewBinder, ExpirationDialogNumberPickersViewBinder expirationDialogNumberPickersViewBinder, AllCapsTransformationMethod allCapsTransformationMethod, GlyphColorizer glyphColorizer, @Assisted long j) {
        this.f14937p = context;
        this.f14938q = new ExpirationDialogModel(DefaultTimeFormatUtil.a(expirationDialogModelProvider), Long.valueOf(j));
        this.f14939r = expirationDialogViewBinder;
        this.f14940s = expirationDialogNumberPickersViewBinder;
        this.f14941t = allCapsTransformationMethod;
        this.f14942u = glyphColorizer;
    }

    public final void m18774a(final ImageWithTextView imageWithTextView, int i) {
        ExpirationDialogModel.f14944b = new GregorianCalendar();
        this.f14938q.m18785h();
        this.f14934m = new FigPopoverMenuWindow(this.f14937p);
        Resources resources = this.f14937p.getResources();
        PopoverMenuWindow popoverMenuWindow = this.f14934m;
        OnMenuItemClickListener onMenuItemClickListener = this.f14922a;
        PopoverMenu c = popoverMenuWindow.c();
        c.a(1, 0, resources.getString(2131237811)).setOnMenuItemClickListener(onMenuItemClickListener);
        c.a(2, 0, resources.getString(2131237812)).setOnMenuItemClickListener(onMenuItemClickListener);
        c.a(3, 0, resources.getString(2131237813)).setOnMenuItemClickListener(onMenuItemClickListener);
        c.a(4, 0, 2131237814).setOnMenuItemClickListener(onMenuItemClickListener);
        c.a(5, 0, 2131237815).setOnMenuItemClickListener(onMenuItemClickListener);
        imageWithTextView.setImageDrawable(this.f14942u.a(2130839800, i));
        m18770a(this, imageWithTextView, this.f14938q);
        imageWithTextView.setTextColor(i);
        imageWithTextView.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ ExpirationDialogController f14921b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -252015564);
                ExpirationDialogController expirationDialogController = this.f14921b;
                expirationDialogController.f14934m.a(imageWithTextView);
                Logger.a(2, EntryType.UI_INPUT_END, -389239721, a);
            }
        });
    }

    public static void m18771c(ExpirationDialogController expirationDialogController) {
        ExpirationDialogViewBinder expirationDialogViewBinder = expirationDialogController.f14939r;
        ExpirationDialogModel expirationDialogModel = expirationDialogController.f14938q;
        AlertDialog alertDialog = expirationDialogController.f14929h;
        OnClickListener onClickListener = expirationDialogController.f14927f;
        OnClickListener onClickListener2 = expirationDialogController.f14928g;
        alertDialog.setTitle(expirationDialogModel.m18782e());
        alertDialog.a(-1, expirationDialogViewBinder.f14952a.getString(2131237809), onClickListener);
        alertDialog.a(-2, expirationDialogViewBinder.f14952a.getString(2131237810), onClickListener2);
        Button a = alertDialog.a(-1);
        long a2 = expirationDialogViewBinder.f14953b.a() / 1000;
        long d = expirationDialogModel.m18781d();
        if (a2 >= d && a != null && a.getVisibility() == 0) {
            Toast.makeText(alertDialog.getContext(), expirationDialogViewBinder.f14952a.getString(2131237816), 0).show();
            a.setVisibility(4);
        } else if (a2 < d && a != null && a.getVisibility() == 4) {
            a.setVisibility(0);
        }
    }

    public static void m18772d(ExpirationDialogController expirationDialogController) {
        expirationDialogController.f14940s.m18789a(expirationDialogController.f14938q, expirationDialogController.f14930i, expirationDialogController.f14923b, expirationDialogController.f14931j, expirationDialogController.f14924c, expirationDialogController.f14932k, expirationDialogController.f14925d, expirationDialogController.f14933l, expirationDialogController.f14926e);
    }

    public final void m18775a(ImageWithTextView imageWithTextView, @Nullable C10734 c10734) {
        this.f14935n = imageWithTextView;
        this.f14936o = c10734;
        View inflate = LayoutInflater.from(this.f14937p).inflate(2130904180, null);
        this.f14929h = new Builder(this.f14937p).b(inflate).a();
        this.f14930i = (NumberPicker) inflate.findViewById(2131561584);
        this.f14931j = (NumberPicker) inflate.findViewById(2131561585);
        this.f14932k = (NumberPicker) inflate.findViewById(2131561586);
        this.f14933l = (NumberPicker) inflate.findViewById(2131561587);
    }

    public static void m18770a(ExpirationDialogController expirationDialogController, ImageWithTextView imageWithTextView, ExpirationDialogModel expirationDialogModel) {
        if (expirationDialogModel.m18783f()) {
            imageWithTextView.setText(expirationDialogController.f14941t.getTransformation(expirationDialogModel.m18782e(), imageWithTextView));
        } else {
            imageWithTextView.setText(expirationDialogController.f14941t.getTransformation(expirationDialogController.f14937p.getResources().getString(2131237818), imageWithTextView));
        }
    }

    public final long m18773a() {
        return this.f14938q.m18781d();
    }
}
