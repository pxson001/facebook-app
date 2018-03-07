package com.facebook.widget.text.html;

import android.text.Editable;
import com.facebook.widget.text.html.FbHtml.TagHandler;
import java.util.Vector;
import org.xml.sax.Attributes;

/* compiled from: com.google.android.gms.location.places.personalized.IPlaceAliasCallbacks */
public class GroupTagHandler extends BaseTagHandler {
    private final Vector<TagHandler> f19876a = new Vector();

    public final GroupTagHandler m28606a(BaseTagHandler baseTagHandler) {
        this.f19876a.add(baseTagHandler);
        return this;
    }

    public final boolean mo1503a(String str, Attributes attributes, Editable editable) {
        int size = this.f19876a.size();
        for (int i = 0; i < size; i++) {
            if (((BaseTagHandler) this.f19876a.get(i)).mo1503a(str, attributes, editable)) {
                return true;
            }
        }
        return false;
    }

    public final boolean mo1502a(String str, Editable editable) {
        int size = this.f19876a.size();
        for (int i = 0; i < size; i++) {
            if (((BaseTagHandler) this.f19876a.get(i)).mo1502a(str, editable)) {
                return true;
            }
        }
        return false;
    }

    public final boolean mo1505a(char[] cArr, int i, int i2, Editable editable) {
        int size = this.f19876a.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((BaseTagHandler) this.f19876a.get(i3)).mo1505a(cArr, i, i2, editable)) {
                return true;
            }
        }
        return super.mo1505a(cArr, i, i2, editable);
    }
}
