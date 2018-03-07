package com.facebook.messaging.service.methods;

import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.event.sending.EventMessageUtil;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.MessageEventFragmentModel.EventCoordinatesModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.MessageEventFragmentModel.EventPlaceModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.MessageLocationFragmentModel.CoordinatesModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.StoryAttachmentTargetFragmentModel;
import com.facebook.messaging.location.sending.LocationMessageUtil;
import com.facebook.messaging.model.attachment.ImageData.Source;
import com.facebook.messaging.model.messagemetadata.PlatformMetadataUtil;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.share.Share;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.threads.util.MessagingIdUtil;
import com.facebook.share.model.ComposerAppAttribution;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResourceBodyFactory;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import javax.inject.Inject;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: ct_l */
public class SendMessageParameterHelper {
    private static final Class<?> f16978a = SendMessageParameterHelper.class;
    private final MediaResourceBodyFactory f16979b;
    private final MessageUtil f16980c;

    public static SendMessageParameterHelper m17035b(InjectorLike injectorLike) {
        return new SendMessageParameterHelper(MediaResourceBodyFactory.a(injectorLike), MessageUtil.a(injectorLike));
    }

    @Inject
    public SendMessageParameterHelper(MediaResourceBodyFactory mediaResourceBodyFactory, MessageUtil messageUtil) {
        this.f16979b = mediaResourceBodyFactory;
        this.f16980c = messageUtil;
    }

    final void m17038a(List<NameValuePair> list, Message message) {
        int i = 0;
        Preconditions.checkArgument(!ThreadKey.d(message.b));
        if (MessageUtil.A(message)) {
            list.add(new BasicNameValuePair("message", message.f));
        }
        if (MessageUtil.N(message)) {
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            Iterator it = message.v.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                objectNode.a((String) entry.getKey(), (String) entry.getValue());
            }
            list.add(new BasicNameValuePair("client_tags", objectNode.toString()));
        }
        if (MessageUtil.O(message)) {
            list.add(new BasicNameValuePair("offline_threading_id", message.n));
        }
        Share share = message.u != null ? message.u.b : null;
        if (share != null && !StringUtil.a(share.a)) {
            list.add(new BasicNameValuePair("object_attachment", share.a));
        } else if (share != null && !StringUtil.a(share.b)) {
            list.add(new BasicNameValuePair("shareable_attachment", share.b));
        } else if (message.k != null) {
            list.add(new BasicNameValuePair("object_attachment", message.k));
        }
        if (m17034a(message)) {
            list.add(new BasicNameValuePair("image_type", Source.QUICKCAM.apiStringValue));
        }
        Iterable arrayList = new ArrayList();
        ImmutableList immutableList = message.t;
        int size = immutableList.size();
        while (i < size) {
            MediaResource mediaResource = (MediaResource) immutableList.get(i);
            if (mediaResource.u != null) {
                arrayList.add(mediaResource.u);
            }
            i++;
        }
        if (!arrayList.isEmpty()) {
            list.add(new BasicNameValuePair("media", Joiner.on(",").join(arrayList)));
        }
        if (message.x != null) {
            list.add(new BasicNameValuePair("copy_message", MessagingIdUtil.m17836b(message.x)));
        } else if (message.y != null) {
            list.add(new BasicNameValuePair("copy_attachment", message.y));
        }
        if (!(message.z == null || message.z.keySet().isEmpty())) {
            ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
            Iterator it2 = message.z.entrySet().iterator();
            while (it2.hasNext()) {
                Entry entry2 = (Entry) it2.next();
                ThreadKey threadKey = (ThreadKey) entry2.getValue();
                objectNode2.a((String) entry2.getKey(), threadKey.a == Type.ONE_TO_ONE ? "ct_" + threadKey.d : "gt_" + threadKey.b);
            }
            list.add(new BasicNameValuePair("broadcast_recipients", objectNode2.toString()));
        }
        ComposerAppAttribution composerAppAttribution = message.E;
        if (composerAppAttribution != null) {
            list.add(new BasicNameValuePair("proxied_app_id", composerAppAttribution.a()));
            list.add(new BasicNameValuePair("android_key_hash", composerAppAttribution.c()));
        }
        if (LocationMessageUtil.m11973a(message.G)) {
            list.add(new BasicNameValuePair("location_attachment", m17036c(message).toString()));
        }
        if (EventMessageUtil.m11475a(message.G)) {
            list.add(new BasicNameValuePair("event_attachment", m17037d(message).toString()));
        }
        if (message.J != null) {
            list.add(new BasicNameValuePair("ttl", String.valueOf(message.J)));
        }
        if (message.O) {
            list.add(new BasicNameValuePair("customizations", "{\"border\":\"flowers\"}"));
        }
        if (message.Q != null && !message.Q.isEmpty()) {
            list.add(new BasicNameValuePair("platform_xmd", PlatformMetadataUtil.a(message.Q).toString()));
        }
    }

    private static boolean m17034a(Message message) {
        return message.t != null && message.t.size() == 1 && ((MediaResource) message.t.get(0)).e.isQuickCamSource();
    }

    private static ObjectNode m17036c(Message message) {
        StoryAttachmentTargetFragmentModel p = message.G.l().p();
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        if (p.bK() == null || StringUtil.a(p.bK().c())) {
            CoordinatesModel bH = p.bH();
            ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
            objectNode2.a("latitude", bH.a());
            objectNode2.a("longitude", bH.b());
            objectNode.c("coordinates", objectNode2);
            objectNode.a("is_current_location", String.valueOf(p.aI()));
        } else {
            objectNode.a("place_id", p.bK().c());
        }
        return objectNode;
    }

    private static ObjectNode m17037d(Message message) {
        StoryAttachmentTargetFragmentModel p = message.G.l().p();
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("title", p.ax());
        EventPlaceModel bJ = p.bJ();
        if (bJ == null || StringUtil.a(bJ.c())) {
            EventCoordinatesModel bI = p.bI();
            ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
            objectNode2.a("latitude", bI.a());
            objectNode2.a("longitude", bI.b());
            objectNode.c("coordinates", objectNode2);
        } else {
            objectNode.a("place_id", bJ.c());
        }
        objectNode.a("is_all_day", p.aH());
        objectNode.a("start_timestamp", p.bn());
        objectNode.a("end_timestamp", p.at());
        return objectNode;
    }
}
