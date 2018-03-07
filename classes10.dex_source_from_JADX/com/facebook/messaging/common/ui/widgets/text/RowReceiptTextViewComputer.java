package com.facebook.messaging.common.ui.widgets.text;

import android.content.Context;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.MessengerUserNameUtil;
import com.facebook.messaging.common.ui.widgets.text.RowReceiptTextView.Data;
import com.facebook.messaging.deliveryreceipt.RowReceiptParticipant;
import com.facebook.messaging.ui.name.TextListWithMoreComputer;
import com.facebook.messaging.ui.name.TextListWithMoreComputer.Result;
import com.facebook.widget.text.VariableTextLayoutComputer;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

/* compiled from: thread.isSubscribed */
public class RowReceiptTextViewComputer implements VariableTextLayoutComputer<Data> {
    private static final Class<?> f1692a = RowReceiptTextViewComputer.class;
    private final Context f1693b;
    private final TextListWithMoreComputer f1694c;
    private final MessengerUserNameUtil f1695d;

    public static RowReceiptTextViewComputer m1670b(InjectorLike injectorLike) {
        return new RowReceiptTextViewComputer((Context) injectorLike.getInstance(Context.class), TextListWithMoreComputer.b(injectorLike), MessengerUserNameUtil.a(injectorLike));
    }

    @Inject
    public RowReceiptTextViewComputer(Context context, TextListWithMoreComputer textListWithMoreComputer, MessengerUserNameUtil messengerUserNameUtil) {
        this.f1693b = context;
        this.f1694c = textListWithMoreComputer;
        this.f1695d = messengerUserNameUtil;
    }

    public static RowReceiptTextViewComputer m1665a(InjectorLike injectorLike) {
        return m1670b(injectorLike);
    }

    private Layout m1662a(Data data, List<TextPaint> list, int i, Alignment alignment, int i2, int i3) {
        boolean z = true;
        Preconditions.checkArgument(list.size() == 1, "Since only one textPaint is picked, it should only include one");
        if (i2 != 1) {
            z = false;
        }
        Preconditions.checkArgument(z, "Only one line is laid out by this logic.");
        TextPaint textPaint = (TextPaint) list.get(0);
        if (data == null) {
            return m1663a("", alignment, i, textPaint);
        }
        if (data.f1690b == null && !StringUtil.a(data.f1689a)) {
            return m1663a(data.f1689a, alignment, i, textPaint);
        }
        if (data.f1690b == null || data.f1690b.isEmpty()) {
            m1668a(data);
            return m1663a("", alignment, i, textPaint);
        }
        List a = m1667a(data.f1690b);
        Layout a2 = m1664a(a, textPaint, i, alignment, i3);
        if (a2 == null) {
            return m1669b(a, textPaint, i, alignment, i3);
        }
        return a2;
    }

    private Layout m1664a(List<String> list, TextPaint textPaint, int i, Alignment alignment, int i2) {
        Result a = this.f1694c.a(list, 16384.0f, 1, (float) i2, textPaint, null);
        if (a.a.isEmpty()) {
            return null;
        }
        String a2 = m1666a((String) a.a.get(0), a.b);
        if (textPaint.measureText(a2) <= ((float) i)) {
            return m1663a(a2, alignment, i, textPaint);
        }
        return null;
    }

    private Layout m1669b(List<String> list, TextPaint textPaint, int i, Alignment alignment, int i2) {
        float measureText = textPaint.measureText(this.f1693b.getString(2131231548, new Object[]{""}));
        float measureText2 = textPaint.measureText(this.f1693b.getString(2131231549, new Object[]{"", Integer.valueOf(8)}));
        float measureText3 = textPaint.measureText(this.f1693b.getString(2131231549, new Object[]{"", Integer.valueOf(88)}));
        float[] fArr = new float[]{measureText2 - measureText, measureText3 - measureText};
        Result a = this.f1694c.a(list, ((float) i) - measureText, 1, (float) i2, textPaint, fArr);
        if (a.a.isEmpty()) {
            return m1663a(m1666a("", a.b()), alignment, i, textPaint);
        }
        return m1663a(m1666a((String) a.a().get(0), a.b()), alignment, i, textPaint);
    }

    private static void m1668a(Data data) {
        StringBuilder stringBuilder = new StringBuilder(200);
        stringBuilder.append("RowReceiptTextView.Data\n");
        if (!StringUtil.a(data.f1689a)) {
            stringBuilder.append("getSimpleText ").append(data.f1689a).append('\n');
        }
        if (data.f1690b != null) {
            stringBuilder.append("getRowReceiptParticipantList\n");
            for (RowReceiptParticipant append : data.f1690b) {
                stringBuilder.append(append).append('\n');
            }
        }
        BLog.a(f1692a, stringBuilder.toString());
    }

    private static Layout m1663a(String str, Alignment alignment, int i, TextPaint textPaint) {
        return new StaticLayout(str, 0, str.length(), textPaint, 16384, alignment, 1.0f, 0.0f, false, TruncateAt.END, i);
    }

    private String m1666a(String str, int i) {
        if (StringUtil.a(str)) {
            String num = Integer.toString(i);
            return this.f1693b.getString(2131231548, new Object[]{num});
        } else if (i > 0) {
            return this.f1693b.getString(2131231549, new Object[]{str, Integer.valueOf(i)});
        } else {
            return this.f1693b.getString(2131231548, new Object[]{str});
        }
    }

    private List<String> m1667a(List<RowReceiptParticipant> list) {
        List<String> b = Lists.b(list.size());
        for (RowReceiptParticipant rowReceiptParticipant : list) {
            b.add(this.f1695d.a(rowReceiptParticipant.b));
        }
        return b;
    }
}
