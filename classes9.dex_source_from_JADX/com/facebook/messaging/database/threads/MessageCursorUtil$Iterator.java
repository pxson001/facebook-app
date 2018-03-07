package com.facebook.messaging.database.threads;

import android.database.Cursor;
import com.facebook.common.util.StringUtil;
import com.facebook.messaging.database.serialization.DbMessageCustomizationSerialization;
import com.facebook.messaging.database.serialization.DbMessageMetadataSerialization;
import com.facebook.messaging.database.serialization.DbMessagePlatformMetadataSerialization;
import com.facebook.messaging.messageclassifier.MessageExaminer;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo.AdProperties;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo.BotChoice;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo.EventReminderProperties;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo.NicknameChoice;
import com.facebook.messaging.model.messages.GenericAdminMessageInfoBuilder;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.Publicity;
import com.facebook.messaging.model.send.SendError;
import com.facebook.messaging.model.send.SendErrorBuilder;
import com.facebook.messaging.model.send.SendErrorType;
import com.facebook.messaging.model.share.Share;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.List;

/* compiled from: maximumSize must be greater than or equal to minimumSize */
public class MessageCursorUtil$Iterator {
    private final int f10487A;
    private final int f10488B;
    private final int f10489C;
    private final int f10490D;
    private final int f10491E;
    private final int f10492F;
    private final int f10493G;
    private final int f10494H;
    private final int f10495I;
    private final int f10496J;
    private final int f10497K;
    private final int f10498L;
    private final int f10499M;
    private final int f10500N;
    private final int f10501O;
    private final int f10502P;
    private final int f10503Q;
    private final int f10504R;
    private final int f10505S;
    private final int f10506T;
    private final int f10507U;
    private final int f10508V;
    private final int f10509W;
    private final int f10510X;
    private final int f10511Y;
    private final int f10512Z;
    final /* synthetic */ MessageCursorUtil f10513a;
    private final int aa;
    private final int ab;
    private final int ac;
    private final int ad;
    private final int ae;
    private final int af;
    private final int ag;
    private final int ah;
    private final int ai;
    private final Cursor f10514b;
    public final MessageExaminer f10515c;
    private final int f10516d;
    private final int f10517e;
    private final int f10518f;
    private final int f10519g;
    private final int f10520h;
    private final int f10521i;
    private final int f10522j;
    private final int f10523k;
    private final int f10524l;
    private final int f10525m;
    private final int f10526n;
    private final int f10527o;
    private final int f10528p;
    private final int f10529q;
    private final int f10530r;
    private final int f10531s;
    private final int f10532t;
    private final int f10533u;
    private final int f10534v;
    private final int f10535w;
    private final int f10536x;
    private final int f10537y;
    private final int f10538z;

    /* compiled from: maximumSize must be greater than or equal to minimumSize */
    class C11881 extends TypeReference<ImmutableList<NicknameChoice>> {
        final /* synthetic */ MessageCursorUtil$Iterator f10483b;

        C11881(MessageCursorUtil$Iterator messageCursorUtil$Iterator) {
            this.f10483b = messageCursorUtil$Iterator;
        }
    }

    /* compiled from: maximumSize must be greater than or equal to minimumSize */
    class C11892 extends TypeReference<ImmutableList<BotChoice>> {
        final /* synthetic */ MessageCursorUtil$Iterator f10484b;

        C11892(MessageCursorUtil$Iterator messageCursorUtil$Iterator) {
            this.f10484b = messageCursorUtil$Iterator;
        }
    }

    /* compiled from: maximumSize must be greater than or equal to minimumSize */
    class C11903 extends TypeReference<AdProperties> {
        final /* synthetic */ MessageCursorUtil$Iterator f10485b;

        C11903(MessageCursorUtil$Iterator messageCursorUtil$Iterator) {
            this.f10485b = messageCursorUtil$Iterator;
        }
    }

    /* compiled from: maximumSize must be greater than or equal to minimumSize */
    class C11914 extends TypeReference<EventReminderProperties> {
        final /* synthetic */ MessageCursorUtil$Iterator f10486b;

        C11914(MessageCursorUtil$Iterator messageCursorUtil$Iterator) {
            this.f10486b = messageCursorUtil$Iterator;
        }
    }

    public MessageCursorUtil$Iterator(MessageCursorUtil messageCursorUtil, Cursor cursor, MessageExaminer messageExaminer) {
        this.f10513a = messageCursorUtil;
        this.f10514b = cursor;
        this.f10515c = messageExaminer;
        this.f10516d = cursor.getColumnIndex("thread_key");
        this.f10517e = cursor.getColumnIndex("msg_id");
        this.f10518f = cursor.getColumnIndex("action_id");
        this.f10519g = cursor.getColumnIndex("text");
        this.f10520h = cursor.getColumnIndex("sender");
        this.f10521i = cursor.getColumnIndex("is_not_forwardable");
        this.f10522j = cursor.getColumnIndex("timestamp_ms");
        this.f10523k = cursor.getColumnIndex("timestamp_sent_ms");
        this.f10525m = cursor.getColumnIndex("msg_type");
        this.f10526n = cursor.getColumnIndex("affected_users");
        this.f10527o = cursor.getColumnIndex("attachments");
        this.f10528p = cursor.getColumnIndex("shares");
        this.f10529q = cursor.getColumnIndex("sticker_id");
        this.f10530r = cursor.getColumnIndex("client_tags");
        this.f10531s = cursor.getColumnIndex("offline_threading_id");
        this.f10532t = cursor.getColumnIndex("source");
        this.f10533u = cursor.getColumnIndex("channel_source");
        this.f10489C = cursor.getColumnIndex("send_channel");
        this.f10534v = cursor.getColumnIndex("is_non_authoritative");
        this.f10535w = cursor.getColumnIndex("pending_send_media_attachment");
        this.f10536x = cursor.getColumnIndex("sent_share_attachment");
        this.f10537y = cursor.getColumnIndex("send_error");
        this.f10538z = cursor.getColumnIndex("send_error_message");
        this.f10487A = cursor.getColumnIndex("send_error_number");
        this.f10524l = cursor.getColumnIndex("send_error_timestamp_ms");
        this.f10488B = cursor.getColumnIndex("send_error_error_url");
        this.f10490D = cursor.getColumnIndex("publicity");
        this.f10491E = cursor.getColumnIndex("send_queue_type");
        this.f10492F = cursor.getColumnIndex("payment_transaction");
        this.f10493G = cursor.getColumnIndex("payment_request");
        this.f10494H = cursor.getColumnIndex("has_unavailable_attachment");
        this.f10495I = cursor.getColumnIndex("app_attribution");
        this.f10496J = cursor.getColumnIndex("content_app_attribution");
        this.f10497K = cursor.getColumnIndex("xma");
        this.f10498L = cursor.getColumnIndex("admin_text_type");
        this.f10499M = cursor.getColumnIndex("admin_text_theme_color");
        this.f10500N = cursor.getColumnIndex("admin_text_thread_icon_emoji");
        this.f10501O = cursor.getColumnIndex("admin_text_nickname");
        this.f10502P = cursor.getColumnIndex("admin_text_target_id");
        this.f10503Q = cursor.getColumnIndex("admin_text_thread_message_lifetime");
        this.f10504R = cursor.getColumnIndex("admin_text_thread_journey_color_choices");
        this.f10505S = cursor.getColumnIndex("admin_text_thread_journey_emoji_choices");
        this.f10506T = cursor.getColumnIndex("admin_text_thread_journey_nickname_choices");
        this.f10507U = cursor.getColumnIndex("admin_text_thread_journey_bot_choices");
        this.f10512Z = cursor.getColumnIndex("message_lifetime");
        this.f10508V = cursor.getColumnIndex("admin_text_thread_rtc_event");
        this.f10509W = cursor.getColumnIndex("admin_text_thread_rtc_server_info_data");
        this.f10510X = cursor.getColumnIndex("admin_text_thread_rtc_is_video_call");
        this.f10511Y = cursor.getColumnIndex("admin_text_thread_ride_provider_name");
        this.aa = cursor.getColumnIndex("is_sponsored");
        this.ab = cursor.getColumnIndex("admin_text_thread_ad_properties");
        this.ac = cursor.getColumnIndex("admin_text_game_score_data");
        this.ad = cursor.getColumnIndex("admin_text_thread_event_reminder_properties");
        this.ae = cursor.getColumnIndex("commerce_message_type");
        this.af = cursor.getColumnIndex("customizations");
        this.ag = cursor.getColumnIndex("admin_text_joinable_event_type");
        this.ah = cursor.getColumnIndex("metadata_at_text_ranges");
        this.ai = cursor.getColumnIndex("platform_metadata");
    }

    public final Message m11138a() {
        int i;
        int i2;
        Message message;
        EventReminderProperties eventReminderProperties;
        GenericAdminMessageInfoBuilder f;
        Message message2 = null;
        boolean z = true;
        if (!this.f10514b.moveToNext()) {
            return message2;
        }
        boolean z2;
        boolean z3;
        String string = this.f10514b.getString(this.f10517e);
        boolean z4 = (this.f10514b.isNull(this.f10534v) || this.f10514b.getInt(this.f10534v) == 0) ? false : true;
        if (this.f10514b.isNull(this.f10494H) || this.f10514b.getInt(this.f10494H) == 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (this.f10514b.isNull(this.aa) || this.f10514b.getInt(this.aa) == 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        ThreadKey a = ThreadKey.a(this.f10514b.getString(this.f10516d));
        MessageBuilder d = Message.newBuilder().a(string).a(a).c(this.f10514b.getLong(this.f10518f)).b(this.f10514b.getString(this.f10519g)).a(this.f10513a.b.a(this.f10514b.getString(this.f10520h))).a(this.f10514b.getLong(this.f10522j)).b(this.f10514b.getLong(this.f10523k)).a(MessageType.fromDbKeyValue(this.f10514b.getInt(this.f10525m))).c(this.f10513a.b.b(this.f10514b.getString(this.f10526n))).a(this.f10513a.d.a(this.f10514b.getString(this.f10527o), string)).b(this.f10513a.e.a(this.f10514b.getString(this.f10528p))).c(this.f10514b.getString(this.f10529q)).a(this.f10513a.g.a(this.f10514b.getString(this.f10530r))).d(this.f10514b.getString(this.f10531s)).e(this.f10514b.getString(this.f10532t)).a(MessageCursorUtil.e(this.f10514b.getString(this.f10533u))).b(z4).d(this.f10513a.c.a(this.f10514b.getString(this.f10535w))).a(this.f10513a.f.a(this.f10514b.getString(this.f10536x))).a(m11137c()).a(MessageCursorUtil.f(this.f10514b.getString(this.f10489C))).a(Publicity.a(this.f10514b.getString(this.f10490D))).a(MessageCursorUtil.b(a, this.f10514b.getString(this.f10491E))).a(this.f10513a.i.a(this.f10514b.getString(this.f10492F))).a(this.f10513a.h.a(this.f10514b.getString(this.f10493G))).c(z2).a(this.f10513a.j.a(this.f10514b.getString(this.f10495I))).a(this.f10513a.j.b(this.f10514b.getString(this.f10496J))).a(this.f10513a.o.a(this.f10514b.getString(this.f10497K))).d(z3);
        if (!this.f10514b.isNull(this.f10512Z)) {
            d.a(Integer.valueOf(this.f10514b.getInt(this.f10512Z)));
        }
        if (!this.f10514b.isNull(this.ae)) {
            d.h(this.f10514b.getString(this.ae));
        }
        if (!this.f10514b.isNull(this.af)) {
            String string2 = this.f10514b.getString(this.af);
            MessageCursorUtil.k(this.f10513a);
            d.e(DbMessageCustomizationSerialization.a(string2));
        }
        if (!this.f10514b.isNull(this.ah)) {
            d.e(((DbMessageMetadataSerialization) this.f10513a.l.get()).m11085a(this.f10514b.getString(this.ah)));
        }
        if (!this.f10514b.isNull(this.ai)) {
            d.c(((DbMessagePlatformMetadataSerialization) this.f10513a.m.get()).m11087a(this.f10514b.getString(this.ai)));
        }
        List j = d.j();
        if (!(j == null || j.isEmpty())) {
            d.a(((Share) j.get(0)).l);
        }
        if (d.l() == MessageType.ADMIN) {
            ImmutableList d2 = MessageCursorUtil.d(this.f10514b.getString(this.f10504R));
            ImmutableList d3 = MessageCursorUtil.d(this.f10514b.getString(this.f10505S));
            ImmutableList a2 = MessageCursorUtil.a(this.f10513a, this.f10514b.getString(this.f10506T), new C11881(this));
            ImmutableList a3 = MessageCursorUtil.a(this.f10513a, this.f10514b.getString(this.f10507U), new C11892(this));
            AdProperties adProperties = (AdProperties) MessageCursorUtil.b(this.f10513a, this.f10514b.getString(this.ab), new C11903(this));
            Object string3 = this.f10514b.getString(this.ac);
            if (StringUtil.a(string3)) {
                z3 = false;
                string = message2;
                i = 0;
            } else {
                try {
                    int b;
                    JsonNode a4 = this.f10513a.n.a(string3);
                    String B = a4.b("game_type").B();
                    try {
                        b = a4.b("score").b(0);
                    } catch (IOException e) {
                        i2 = 0;
                        message = B;
                        i = i2;
                        string = message;
                        z3 = false;
                        eventReminderProperties = (EventReminderProperties) MessageCursorUtil.b(this.f10513a, this.f10514b.getString(this.ad), new C11914(this));
                        f = GenericAdminMessageInfo.newBuilder().a(this.f10514b.getInt(this.f10498L)).b(this.f10514b.getInt(this.f10499M)).b(this.f10514b.getString(this.f10500N)).c(this.f10514b.getString(this.f10501O)).d(this.f10514b.getString(this.f10502P)).c(this.f10514b.getInt(this.f10503Q)).a(d2).b(d3).c(a2).d(a3).e(this.f10514b.getString(this.f10508V)).f(this.f10514b.getString(this.f10509W));
                        if (this.f10514b.getInt(this.f10510X) == 0) {
                            z = false;
                        }
                        d.a(f.a(z).g(this.f10514b.getString(this.f10511Y)).a(adProperties).h(string).d(i).b(z3).a(eventReminderProperties).i(this.f10514b.getString(this.ag)).a());
                        return m11136a(d.R());
                    }
                    try {
                        string = B;
                        i = b;
                        z3 = a4.b("is_new_high_score").a(false);
                    } catch (IOException e2) {
                        i2 = b;
                        message = B;
                        i = i2;
                        string = message;
                        z3 = false;
                        eventReminderProperties = (EventReminderProperties) MessageCursorUtil.b(this.f10513a, this.f10514b.getString(this.ad), new C11914(this));
                        f = GenericAdminMessageInfo.newBuilder().a(this.f10514b.getInt(this.f10498L)).b(this.f10514b.getInt(this.f10499M)).b(this.f10514b.getString(this.f10500N)).c(this.f10514b.getString(this.f10501O)).d(this.f10514b.getString(this.f10502P)).c(this.f10514b.getInt(this.f10503Q)).a(d2).b(d3).c(a2).d(a3).e(this.f10514b.getString(this.f10508V)).f(this.f10514b.getString(this.f10509W));
                        if (this.f10514b.getInt(this.f10510X) == 0) {
                            z = false;
                        }
                        d.a(f.a(z).g(this.f10514b.getString(this.f10511Y)).a(adProperties).h(string).d(i).b(z3).a(eventReminderProperties).i(this.f10514b.getString(this.ag)).a());
                        return m11136a(d.R());
                    }
                } catch (IOException e3) {
                    i2 = 0;
                    message = message2;
                    i = i2;
                    string = message;
                    z3 = false;
                    eventReminderProperties = (EventReminderProperties) MessageCursorUtil.b(this.f10513a, this.f10514b.getString(this.ad), new C11914(this));
                    f = GenericAdminMessageInfo.newBuilder().a(this.f10514b.getInt(this.f10498L)).b(this.f10514b.getInt(this.f10499M)).b(this.f10514b.getString(this.f10500N)).c(this.f10514b.getString(this.f10501O)).d(this.f10514b.getString(this.f10502P)).c(this.f10514b.getInt(this.f10503Q)).a(d2).b(d3).c(a2).d(a3).e(this.f10514b.getString(this.f10508V)).f(this.f10514b.getString(this.f10509W));
                    if (this.f10514b.getInt(this.f10510X) == 0) {
                        z = false;
                    }
                    d.a(f.a(z).g(this.f10514b.getString(this.f10511Y)).a(adProperties).h(string).d(i).b(z3).a(eventReminderProperties).i(this.f10514b.getString(this.ag)).a());
                    return m11136a(d.R());
                }
            }
            eventReminderProperties = (EventReminderProperties) MessageCursorUtil.b(this.f10513a, this.f10514b.getString(this.ad), new C11914(this));
            f = GenericAdminMessageInfo.newBuilder().a(this.f10514b.getInt(this.f10498L)).b(this.f10514b.getInt(this.f10499M)).b(this.f10514b.getString(this.f10500N)).c(this.f10514b.getString(this.f10501O)).d(this.f10514b.getString(this.f10502P)).c(this.f10514b.getInt(this.f10503Q)).a(d2).b(d3).c(a2).d(a3).e(this.f10514b.getString(this.f10508V)).f(this.f10514b.getString(this.f10509W));
            if (this.f10514b.getInt(this.f10510X) == 0) {
                z = false;
            }
            d.a(f.a(z).g(this.f10514b.getString(this.f10511Y)).a(adProperties).h(string).d(i).b(z3).a(eventReminderProperties).i(this.f10514b.getString(this.ag)).a());
        }
        return m11136a(d.R());
    }

    private SendError m11137c() {
        SendErrorBuilder newBuilder = SendError.newBuilder();
        newBuilder.a = SendErrorType.fromSerializedString(this.f10514b.getString(this.f10537y));
        newBuilder = newBuilder;
        newBuilder.b = this.f10514b.getString(this.f10538z);
        newBuilder = newBuilder;
        newBuilder.e = this.f10514b.getInt(this.f10487A);
        newBuilder = newBuilder;
        newBuilder.c = this.f10514b.getLong(this.f10524l);
        newBuilder = newBuilder;
        newBuilder.d = this.f10514b.getString(this.f10488B);
        return newBuilder.f();
    }

    private Message m11136a(Message message) {
        Object obj;
        boolean z = false;
        boolean z2 = (this.f10514b.isNull(this.f10521i) || this.f10514b.getInt(this.f10521i) == 0) ? false : true;
        if (this.f10515c.e(message) || this.f10515c.f(message) || this.f10515c.g(message)) {
            obj = 1;
        } else {
            obj = null;
        }
        Object obj2 = obj;
        MessageBuilder a = Message.newBuilder().a(message);
        if (z2 || obj2 != null) {
            z = true;
        }
        a.h = z;
        return a.R();
    }

    public final void m11139b() {
        this.f10514b.close();
    }
}
