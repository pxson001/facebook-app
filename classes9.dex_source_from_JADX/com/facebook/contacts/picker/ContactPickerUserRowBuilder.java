package com.facebook.contacts.picker;

import com.facebook.contacts.graphql.ChatContextsGraphQLInterfaces.ChatContextForUser;
import com.facebook.contacts.picker.ContactPickerUserRow.ContactRowSectionType;
import com.facebook.contacts.picker.ContactPickerUserRow.MenuHandler;
import com.facebook.contacts.picker.ContactPickerUserRow.PushableType;
import com.facebook.contacts.picker.ContactPickerUserRow.RowStyle;
import com.facebook.orca.contacts.picker.ContactMultipickerFragment.10;
import com.facebook.user.model.User;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: posts_info */
public class ContactPickerUserRowBuilder {
    public User f6412a;
    public RowStyle f6413b;
    public boolean f6414c;
    public boolean f6415d;
    public boolean f6416e;
    public boolean f6417f;
    public boolean f6418g;
    public boolean f6419h;
    @Nullable
    public String f6420i;
    public boolean f6421j;
    @Nullable
    public ChatContextForUser f6422k;
    public PushableType f6423l = PushableType.NONE;
    public ContactPickerRowSectionType f6424m = ContactRowSectionType.UNKNOWN;
    public MenuHandler f6425n;
    public boolean f6426o;
    public 10 f6427p;
    public boolean f6428q = true;
    public boolean f6429r;
    public String f6430s;
    public boolean f6431t;
    public boolean f6432u = false;
    public boolean f6433v;
    public final List<Integer> f6434w = new LinkedList();
    public final List<Integer> f6435x = new LinkedList();
    public final List<Integer> f6436y = new LinkedList();
    public boolean f6437z;

    public final ContactPickerUserRow m6802a() {
        return new ContactPickerUserRow(this);
    }
}
