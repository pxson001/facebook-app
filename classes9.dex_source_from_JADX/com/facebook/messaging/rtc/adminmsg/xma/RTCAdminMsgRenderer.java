package com.facebook.messaging.rtc.adminmsg.xma;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.rtc.adminmsg.model.RTCAdminMsgProperties;
import com.facebook.messaging.rtc.adminmsg.model.RTCAdminMsgProperties.Builder;
import com.facebook.messaging.util.date.MessagingDateUtil;
import com.facebook.messaging.xma.SimpleStyleRenderer;
import com.facebook.rtc.helpers.RtcCallHandler;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.user.model.UserKey;
import com.facebook.widget.text.BetterButton;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: deltaNewPaymentRequest */
public class RTCAdminMsgRenderer extends SimpleStyleRenderer<ViewHolder> {
    public final Context f16617a;
    private final Provider<UserKey> f16618b;
    private final MessagingDateUtil f16619c;
    public final RtcCallHandler f16620d;
    public final Provider<Boolean> f16621e;

    /* compiled from: deltaNewPaymentRequest */
    public class ViewHolder extends com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder {
        public final BetterTextView f16612b = ((BetterTextView) a(2131567139));
        public final LinearLayout f16613c = ((LinearLayout) a(2131567140));
        public final BetterTextView f16614d = ((BetterTextView) a(2131567142));
        public final GlyphView f16615e = ((GlyphView) a(2131567141));
        public final BetterButton f16616f = ((BetterButton) a(2131567144));

        public ViewHolder(View view) {
            super(view);
        }
    }

    public static RTCAdminMsgRenderer m16624b(InjectorLike injectorLike) {
        return new RTCAdminMsgRenderer((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 3597), RtcCallHandler.a(injectorLike), MessagingDateUtil.a(injectorLike), IdBasedProvider.a(injectorLike, 4314));
    }

    protected final void m16627a(com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder viewHolder, XMAModel xMAModel) {
        int color;
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        XMAAttachmentStoryFieldsModel c = xMAModel.c();
        RTCAdminMsgProperties a = new Builder((UserKey) this.f16618b.get()).a(c.b()).a();
        viewHolder2.f16612b.setText(c.l());
        BetterTextView betterTextView = viewHolder2.f16612b;
        if (m16626d(a) && a.d) {
            color = this.f16617a.getResources().getColor(2131362510);
        } else {
            color = this.f16617a.getResources().getColor(2131361921);
        }
        betterTextView.setTextColor(color);
        m16623a(viewHolder2, a);
        m16625b(viewHolder2, c, a);
    }

    @Inject
    public RTCAdminMsgRenderer(Context context, Provider<UserKey> provider, RtcCallHandler rtcCallHandler, MessagingDateUtil messagingDateUtil, Provider<Boolean> provider2) {
        this.f16617a = context;
        this.f16618b = provider;
        this.f16620d = rtcCallHandler;
        this.f16619c = messagingDateUtil;
        this.f16621e = provider2;
    }

    protected final com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder m16628b(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.f16617a).inflate(2130906911, viewGroup, false));
    }

    private void m16623a(ViewHolder viewHolder, RTCAdminMsgProperties rTCAdminMsgProperties) {
        Object obj;
        if (rTCAdminMsgProperties.a > 0 || (rTCAdminMsgProperties.c && rTCAdminMsgProperties.b > 0)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            int color;
            if (rTCAdminMsgProperties.c && rTCAdminMsgProperties.b > 0) {
                viewHolder.f16614d.setText(m16622a(rTCAdminMsgProperties.b));
            } else if (rTCAdminMsgProperties.a > 0) {
                viewHolder.f16614d.setText(this.f16619c.b(rTCAdminMsgProperties.a));
            }
            BetterTextView betterTextView = viewHolder.f16614d;
            if (m16626d(rTCAdminMsgProperties) && rTCAdminMsgProperties.d) {
                color = this.f16617a.getResources().getColor(2131362510);
            } else {
                color = this.f16617a.getResources().getColor(2131362507);
            }
            betterTextView.setTextColor(color);
            if (m16626d(rTCAdminMsgProperties) && rTCAdminMsgProperties.d) {
                viewHolder.f16615e.setImageResource(2130841342);
                viewHolder.f16615e.setGlyphColor(this.f16617a.getResources().getColor(2131362510));
            } else {
                if (rTCAdminMsgProperties.d) {
                    viewHolder.f16615e.setImageResource(2130841343);
                } else {
                    viewHolder.f16615e.setImageResource(2130841341);
                }
                viewHolder.f16615e.setGlyphColor(this.f16617a.getResources().getColor(2131362507));
            }
            viewHolder.f16613c.setVisibility(0);
            return;
        }
        viewHolder.f16613c.setVisibility(8);
    }

    private void m16625b(ViewHolder viewHolder, final XMAAttachmentStoryFieldsModel xMAAttachmentStoryFieldsModel, final RTCAdminMsgProperties rTCAdminMsgProperties) {
        boolean z;
        int i = 0;
        int paddingTop = viewHolder.f16612b.getPaddingTop();
        int i2 = 8;
        if (!StringUtil.a(rTCAdminMsgProperties.e) && rTCAdminMsgProperties.d && ((Boolean) this.f16621e.get()).booleanValue()) {
            z = true;
        } else {
            z = false;
        }
        final boolean z2 = z;
        if (!z2) {
            Object obj = (StringUtil.a(rTCAdminMsgProperties.f) || rTCAdminMsgProperties.d || !((Boolean) this.f16621e.get()).booleanValue()) ? null : 1;
            if (obj == null) {
                i = paddingTop;
                viewHolder.f16613c.setPadding(viewHolder.f16613c.getPaddingLeft(), viewHolder.f16613c.getPaddingTop(), viewHolder.f16613c.getPaddingRight(), i);
                viewHolder.f16616f.setVisibility(i2);
            }
        }
        viewHolder.f16616f.setText(z2 ? 2131232044 : 2131232045);
        viewHolder.f16616f.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RTCAdminMsgRenderer f16611d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1146658991);
                this.f16611d.f16620d.a(this.f16611d.f16617a, z2 ? UserKey.b(rTCAdminMsgProperties.e) : UserKey.b(rTCAdminMsgProperties.f), this.f16611d.f16617a.getString(2131232036), xMAAttachmentStoryFieldsModel.l(), this.f16611d.f16617a.getString(2131232091), z2, "admin_message");
                LogUtils.a(62382920, a);
            }
        });
        i2 = 0;
        viewHolder.f16613c.setPadding(viewHolder.f16613c.getPaddingLeft(), viewHolder.f16613c.getPaddingTop(), viewHolder.f16613c.getPaddingRight(), i);
        viewHolder.f16616f.setVisibility(i2);
    }

    public static boolean m16626d(RTCAdminMsgProperties rTCAdminMsgProperties) {
        return !rTCAdminMsgProperties.c;
    }

    private String m16622a(long j) {
        if (j <= 0 || j > 2147483647L) {
            return "";
        }
        int i;
        int i2 = (int) (j / 3600);
        int i3 = (int) ((j / 60) % 60);
        int i4 = (int) (j % 60);
        int i5 = i2 > 0 ? 1 : 0;
        if (i3 > 0) {
            i = 1;
        } else {
            i = 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (i5 != 0) {
            stringBuilder.append(this.f16617a.getResources().getQuantityString(2131689762, i2, new Object[]{Integer.valueOf(i2)}));
            stringBuilder.append(' ');
            i = 1;
        }
        if (i != 0) {
            stringBuilder.append(this.f16617a.getResources().getQuantityString(2131689763, i3, new Object[]{Integer.valueOf(i3)}));
            stringBuilder.append(' ');
        }
        stringBuilder.append(this.f16617a.getResources().getQuantityString(2131689764, i4, new Object[]{Integer.valueOf(i4)}));
        return stringBuilder.toString();
    }
}
