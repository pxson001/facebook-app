package com.facebook.messaging.send.service;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.MessageLocationFragmentModel.CoordinatesModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.StoryAttachmentTargetFragmentModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.location.sending.LocationMessageUtil;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.share.Share;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.send.service.SendViaMqttResult.Details;
import com.facebook.messaging.service.methods.SendMessageParameterHelper;
import com.facebook.messaging.service.model.SendMessageParams;
import com.facebook.messaging.threads.util.MessagingIdUtil;
import com.facebook.mqtt.model.thrift.Coordinates;
import com.facebook.mqtt.model.thrift.LocationAttachment;
import com.facebook.sync.model.thrift.MqttThriftHeader;
import com.facebook.thrift.TSerializer;
import com.facebook.thrift.protocol.TCompactProtocol.Factory;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: redirect_after_accept */
public class MqttSendMessageSerializer {
    private final MessageUtil f3865a;
    private final AbstractFbErrorReporter f3866b;

    public static MqttSendMessageSerializer m3631b(InjectorLike injectorLike) {
        return new MqttSendMessageSerializer(SendMessageParameterHelper.b(injectorLike), MessageUtil.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public MqttSendMessageSerializer(SendMessageParameterHelper sendMessageParameterHelper, MessageUtil messageUtil, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f3865a = messageUtil;
        this.f3866b = abstractFbErrorReporter;
    }

    public final byte[] m3632a(SendMessageParams sendMessageParams, FbTraceNode fbTraceNode, MqttSendMessageProtocol mqttSendMessageProtocol, @Nullable Integer num) {
        switch (mqttSendMessageProtocol) {
            case THRIFT:
                return m3629a(sendMessageParams, fbTraceNode, num);
            default:
                throw new RuntimeException("Unsupported send-message serialization protocol");
        }
    }

    private byte[] m3629a(SendMessageParams sendMessageParams, FbTraceNode fbTraceNode, @Nullable Integer num) {
        String l;
        SendMessageRequestBuilder sendMessageRequestBuilder = new SendMessageRequestBuilder();
        Message message = sendMessageParams.a;
        ThreadKey threadKey = message.b;
        if (threadKey.a == Type.ONE_TO_ONE) {
            l = Long.toString(threadKey.d);
        } else {
            l = MessagingIdUtil.c(threadKey.b);
        }
        sendMessageRequestBuilder.m3659a(l);
        sendMessageRequestBuilder.m3664b(message.f);
        sendMessageRequestBuilder.m3658a(Long.valueOf(Long.parseLong(message.n)));
        sendMessageRequestBuilder.m3657a(message.J);
        if (MessageUtil.N(message)) {
            sendMessageRequestBuilder.m3661a(message.v);
        }
        Share share = message.u != null ? message.u.b : null;
        if (share != null && !StringUtil.a(share.a)) {
            sendMessageRequestBuilder.m3665c(share.a);
        } else if (message.k != null) {
            sendMessageRequestBuilder.m3665c(message.k);
        }
        if (message.x != null) {
            sendMessageRequestBuilder.m3666d(MessagingIdUtil.b(message.x));
        } else if (message.y != null) {
            sendMessageRequestBuilder.m3667e(message.y);
        }
        sendMessageRequestBuilder.m3663b(Long.valueOf(Long.parseLong(message.e.b.b())));
        if (MessageUtil.e(message)) {
            List a = m3628a(message);
            if (a == null) {
                throw new SendViaMqttException(SendViaMqttResult.m3698a(Details.SEND_SKIPPED_MEDIA_UPLOAD_FAILED));
            } else if (!a.isEmpty()) {
                sendMessageRequestBuilder.m3660a(a);
            }
        }
        if (LocationMessageUtil.a(message.G)) {
            sendMessageRequestBuilder.m3656a(m3627a(message.G));
        }
        if (fbTraceNode != FbTraceNode.a) {
            sendMessageRequestBuilder.m3668f(fbTraceNode.a());
        }
        sendMessageRequestBuilder.m3662b(num);
        try {
            MqttThriftHeader mqttThriftHeader = new MqttThriftHeader(fbTraceNode == FbTraceNode.a ? "" : fbTraceNode.a());
            TSerializer tSerializer = new TSerializer(new Factory());
            return m3630a(tSerializer.a(mqttThriftHeader), tSerializer.a(sendMessageRequestBuilder.m3655a()));
        } catch (Exception e) {
            throw new SendViaMqttException(SendViaMqttResult.m3702a(e, Details.SEND_FAILED_THRIFT_EXCEPTION.errorCode));
        }
    }

    private static byte[] m3630a(byte[] bArr, byte[] bArr2) {
        Object copyOf = Arrays.copyOf(bArr, bArr.length + bArr2.length);
        System.arraycopy(bArr2, 0, copyOf, bArr.length, bArr2.length);
        return copyOf;
    }

    @VisibleForTesting
    private static LocationAttachment m3627a(XMAModel xMAModel) {
        Object obj;
        StoryAttachmentTargetFragmentModel p = xMAModel.l().p();
        if (p.bK() == null || StringUtil.a(p.bK().c())) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return new LocationAttachment(null, null, Long.valueOf(Long.parseLong(p.bK().c())));
        }
        CoordinatesModel bH = p.bH();
        return new LocationAttachment(new Coordinates(StringFormatUtil.formatStrLocaleSafe("%.6f", Double.valueOf(bH.a())), StringFormatUtil.formatStrLocaleSafe("%.6f", Double.valueOf(bH.b())), null), Boolean.valueOf(p.aI()), null);
    }

    private static List<String> m3628a(Message message) {
        int i = 0;
        Preconditions.checkArgument(!ThreadKey.d(message.b));
        if (message.t == null || message.t.isEmpty()) {
            return Lists.a();
        }
        List<String> a = Lists.a();
        ImmutableList immutableList = message.t;
        int size = immutableList.size();
        while (i < size) {
            MediaResource mediaResource = (MediaResource) immutableList.get(i);
            if (mediaResource.u == null) {
                return null;
            }
            a.add(mediaResource.u);
            i++;
        }
        return a;
    }
}
