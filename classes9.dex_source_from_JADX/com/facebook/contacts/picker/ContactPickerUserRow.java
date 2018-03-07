package com.facebook.contacts.picker;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.facebook.common.util.StringUtil;
import com.facebook.contacts.graphql.ChatContextsGraphQLInterfaces.ChatContextForUser;
import com.facebook.orca.contacts.picker.ContactMultipickerFragment.10;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: potential_reach */
public class ContactPickerUserRow extends PickableContactPickerRow {
    public boolean f6379A;
    public boolean f6380B;
    private List<Integer> f6381C;
    private List<Integer> f6382D;
    private List<Integer> f6383E;
    private long f6384F = 0;
    public int f6385G = 1;
    public final User f6386a;
    public final RowStyle f6387b;
    public final boolean f6388c;
    public final boolean f6389d;
    public final boolean f6390e;
    private final boolean f6391f;
    public boolean f6392g;
    public final boolean f6393h;
    private final PushableType f6394i;
    public final boolean f6395j;
    @Nullable
    public final String f6396k;
    @Nullable
    public final ChatContextForUser f6397l;
    public final ContactPickerRowSectionType f6398m;
    private boolean f6399n;
    public boolean f6400o = false;
    public boolean f6401p;
    public final boolean f6402q;
    public boolean f6403r;
    public final MenuHandler f6404s;
    public final 10 f6405t;
    public boolean f6406u = false;
    public boolean f6407v = false;
    public boolean f6408w = false;
    public String f6409x;
    public String f6410y;
    public boolean f6411z;

    /* compiled from: potential_reach */
    public enum ContactRowSectionType implements ContactPickerRowSectionType {
        UNKNOWN,
        SELF_PROFILE,
        FAVORITES,
        TOP_FRIENDS,
        ACTIVE_FRIENDS,
        SEARCH_RESULT,
        AUTO_COMPLETE,
        SUGGESTIONS,
        NEARBY,
        ON_MESSENGER,
        ONLINE,
        ALPHABETIC_SECTION,
        CONTACTS_UPLOADED_DIALOG,
        PROMOTION,
        CALL_LOGS,
        OMNIPICKER_SUGGESTIONS,
        NULL_STATE_TOP_PEOPLE,
        NULL_STATE_BYMM,
        NULL_STATE_BOTS
    }

    /* compiled from: potential_reach */
    public interface MenuHandler {
        void mo699a(View view);

        void mo700a(ContactPickerUserRow contactPickerUserRow, Menu menu, MenuInflater menuInflater);

        boolean mo701a(MenuItem menuItem, ContactPickerUserRow contactPickerUserRow);
    }

    /* compiled from: potential_reach */
    public enum PushableType {
        ON_MESSENGER,
        ON_FACEBOOK,
        NONE
    }

    /* compiled from: potential_reach */
    public enum RowStyle {
        MESSENGER_TAB,
        FACEBOOK_TAB,
        NEUE_PICKER,
        ONE_LINE,
        TWO_LINE,
        INVITE_BUTTON_PICKER,
        SINGLE_TAP_SEND
    }

    public ContactPickerUserRow(ContactPickerUserRowBuilder contactPickerUserRowBuilder) {
        boolean z = true;
        this.f6386a = contactPickerUserRowBuilder.f6412a;
        this.f6387b = contactPickerUserRowBuilder.f6413b;
        this.f6388c = contactPickerUserRowBuilder.f6415d;
        this.f6389d = contactPickerUserRowBuilder.f6414c;
        this.f6390e = contactPickerUserRowBuilder.f6416e;
        this.f6391f = contactPickerUserRowBuilder.f6417f;
        boolean z2 = this.f6390e && this.f6391f;
        this.f6392g = z2;
        this.f6393h = contactPickerUserRowBuilder.f6418g;
        this.f6394i = contactPickerUserRowBuilder.f6423l;
        this.f6395j = contactPickerUserRowBuilder.f6419h;
        this.f6396k = contactPickerUserRowBuilder.f6420i;
        this.f6397l = contactPickerUserRowBuilder.f6422k;
        this.f6398m = contactPickerUserRowBuilder.f6424m;
        this.f6399n = contactPickerUserRowBuilder.f6421j;
        this.f6401p = contactPickerUserRowBuilder.f6437z;
        this.f6402q = contactPickerUserRowBuilder.f6426o;
        this.f6404s = contactPickerUserRowBuilder.f6425n;
        this.f6405t = contactPickerUserRowBuilder.f6427p;
        this.f6403r = contactPickerUserRowBuilder.f6428q;
        this.f6409x = contactPickerUserRowBuilder.f6430s;
        if (!contactPickerUserRowBuilder.f6429r || StringUtil.a(this.f6409x)) {
            z = false;
        }
        this.f6406u = z;
        this.f6411z = contactPickerUserRowBuilder.f6431t;
        this.f6379A = contactPickerUserRowBuilder.f6432u;
        this.f6380B = contactPickerUserRowBuilder.f6433v;
        this.f6381C = contactPickerUserRowBuilder.f6434w;
        this.f6382D = contactPickerUserRowBuilder.f6435x;
        this.f6383E = contactPickerUserRowBuilder.f6436y;
    }

    public String toString() {
        return this.f6386a.j();
    }

    public final void mo249b(boolean z) {
        this.f6403r = z;
    }

    public final void mo248a(boolean z) {
        this.f6399n = z;
    }

    public final boolean mo250d() {
        return this.f6399n;
    }

    public final void m6798c(boolean z) {
        this.f6401p = z;
    }

    public final void m6799d(boolean z) {
        this.f6406u = z;
    }

    public final void m6801e(boolean z) {
        this.f6407v = z;
    }

    public final void m6794a(String str) {
        this.f6409x = str;
    }

    public final void m6796b(String str) {
        this.f6410y = str;
    }

    public final ImmutableList<Integer> m6791B() {
        return ImmutableList.copyOf(this.f6381C);
    }

    public final ImmutableList<Integer> m6792C() {
        return ImmutableList.copyOf(this.f6382D);
    }

    public final ImmutableList<Integer> m6793D() {
        return ImmutableList.copyOf(this.f6383E);
    }
}
