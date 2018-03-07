package com.facebook.messaging.contactsyoumayknow;

import android.content.Context;
import android.net.Uri;
import android.support.v7.internal.widget.ViewStubCompat;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbImageButton;
import com.facebook.widget.ViewStubHolder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: t6691775 */
public class ContactsYouMayKnowItemView extends CardView {
    @Inject
    public LayoutInflater f2107a;
    @Nullable
    public ContactsItemViewListener f2108b;
    private TextView f2109c;
    private TextView f2110d;
    private FbDraweeView f2111e;
    private TextView f2112f;
    private FbImageButton f2113g;
    private View f2114h;
    private ViewStubHolder<View> f2115i;
    public DisplayMode f2116j = DisplayMode.NEW_CONTACT;

    /* compiled from: t6691775 */
    public interface ContactsItemViewListener {
        void mo57a(View view);

        void mo58b(View view);

        void mo59c(View view);
    }

    /* compiled from: t6691775 */
    class C03511 implements OnClickListener {
        final /* synthetic */ ContactsYouMayKnowItemView f2103a;

        C03511(ContactsYouMayKnowItemView contactsYouMayKnowItemView) {
            this.f2103a = contactsYouMayKnowItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -891908475);
            if (this.f2103a.f2108b != null) {
                this.f2103a.f2108b.mo58b(this.f2103a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1537236108, a);
        }
    }

    /* compiled from: t6691775 */
    class C03522 implements OnClickListener {
        final /* synthetic */ ContactsYouMayKnowItemView f2104a;

        C03522(ContactsYouMayKnowItemView contactsYouMayKnowItemView) {
            this.f2104a = contactsYouMayKnowItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -866934667);
            this.f2104a.m1922b();
            if (this.f2104a.f2108b != null) {
                this.f2104a.f2108b.mo57a(this.f2104a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 282929541, a);
        }
    }

    /* compiled from: t6691775 */
    class C03533 implements OnClickListener {
        final /* synthetic */ ContactsYouMayKnowItemView f2105a;

        C03533(ContactsYouMayKnowItemView contactsYouMayKnowItemView) {
            this.f2105a = contactsYouMayKnowItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1631456690);
            if (this.f2105a.f2108b != null) {
                this.f2105a.f2108b.mo59c(this.f2105a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1681178917, a);
        }
    }

    /* compiled from: t6691775 */
    class C03544 implements OnClickListener {
        final /* synthetic */ ContactsYouMayKnowItemView f2106a;

        C03544(ContactsYouMayKnowItemView contactsYouMayKnowItemView) {
            this.f2106a = contactsYouMayKnowItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -29828112);
            if (this.f2106a.f2116j == DisplayMode.CONTACT_ADDED && this.f2106a.f2108b != null) {
                this.f2106a.f2108b.mo58b(this.f2106a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -281563245, a);
        }
    }

    /* compiled from: t6691775 */
    enum DisplayMode {
        NEW_CONTACT,
        ADDING_CONTACT,
        CONTACT_ADDED
    }

    private static <T extends View> void m1920a(Class<T> cls, T t) {
        m1921a((Object) t, t.getContext());
    }

    private static void m1921a(Object obj, Context context) {
        ((ContactsYouMayKnowItemView) obj).f2107a = LayoutInflaterMethodAutoProvider.b(FbInjector.get(context));
    }

    public ContactsYouMayKnowItemView(Context context) {
        super(context);
        m1917a();
    }

    public ContactsYouMayKnowItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1917a();
    }

    public ContactsYouMayKnowItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1917a();
    }

    private void m1917a() {
        m1920a(ContactsYouMayKnowItemView.class, (View) this);
        this.f2107a.inflate(2130903774, this);
        setUseCompatPadding(true);
        this.f2109c = (TextView) FindViewUtil.b(this, 2131560124);
        this.f2110d = (TextView) FindViewUtil.b(this, 2131560726);
        this.f2111e = (FbDraweeView) FindViewUtil.b(this, 2131559671);
        this.f2111e.setOnClickListener(new C03511(this));
        this.f2112f = (TextView) FindViewUtil.b(this, 2131560727);
        this.f2112f.setOnClickListener(new C03522(this));
        this.f2113g = (FbImageButton) FindViewUtil.b(this, 2131560725);
        this.f2113g.setOnClickListener(new C03533(this));
        this.f2114h = FindViewUtil.b(this, 2131560728);
        this.f2115i = ViewStubHolder.a((ViewStubCompat) FindViewUtil.b(this, 2131560729));
        setOnClickListener(new C03544(this));
    }

    public void setListener(ContactsItemViewListener contactsItemViewListener) {
        this.f2108b = contactsItemViewListener;
    }

    public final void m1930a(ContactSuggestion contactSuggestion, boolean z, boolean z2) {
        DisplayMode displayMode = z ? DisplayMode.CONTACT_ADDED : z2 ? DisplayMode.ADDING_CONTACT : DisplayMode.NEW_CONTACT;
        this.f2116j = displayMode;
        m1919a(contactSuggestion);
        m1925c();
    }

    private void m1922b() {
        this.f2116j = DisplayMode.ADDING_CONTACT;
        m1925c();
    }

    private void m1925c() {
        m1926d();
        m1927e();
        m1928f();
        m1929g();
    }

    private void m1926d() {
        if (this.f2116j == DisplayMode.NEW_CONTACT) {
            this.f2112f.setVisibility(0);
        } else {
            this.f2112f.setVisibility(4);
        }
    }

    private void m1927e() {
        if (this.f2116j == DisplayMode.NEW_CONTACT) {
            this.f2113g.setVisibility(0);
        } else {
            this.f2113g.setVisibility(8);
        }
    }

    private void m1928f() {
        if (this.f2116j == DisplayMode.CONTACT_ADDED) {
            this.f2115i.f();
        } else {
            this.f2115i.e();
        }
    }

    private void m1929g() {
        if (this.f2116j == DisplayMode.ADDING_CONTACT) {
            this.f2114h.setVisibility(0);
        } else {
            this.f2114h.setVisibility(4);
        }
    }

    private void m1919a(ContactSuggestion contactSuggestion) {
        this.f2109c.setText(contactSuggestion.f2078a.k());
        if (contactSuggestion.f2079b > 0) {
            this.f2110d.setVisibility(0);
            this.f2110d.setText(getResources().getQuantityString(2131689790, contactSuggestion.f2079b, new Object[]{Integer.valueOf(contactSuggestion.f2079b)}));
        } else {
            this.f2110d.setVisibility(4);
        }
        this.f2111e.setImageURI(Uri.parse(contactSuggestion.f2078a.x()));
    }

    private void m1918a(LayoutInflater layoutInflater) {
        this.f2107a = layoutInflater;
    }
}
