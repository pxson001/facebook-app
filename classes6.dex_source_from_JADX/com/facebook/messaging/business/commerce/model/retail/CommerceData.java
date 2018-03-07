package com.facebook.messaging.business.commerce.model.retail;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.business.attachments.converters.PlatformAttachmentsConverter;
import com.facebook.messaging.business.attachments.model.LogoImageBuilder;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItemBuilder;
import com.facebook.messaging.business.commerce.converters.ModelConverters;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceBaseShipmentTracking;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceRetailItem;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceShipmentBubble;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.StoryAttachmentTargetFragmentModel;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: video_trim_params */
public class CommerceData implements Parcelable {
    public static final Creator<CommerceData> CREATOR = new C00631();
    public final CommerceBubbleModel f574a;

    /* compiled from: video_trim_params */
    final class C00631 implements Creator<CommerceData> {
        C00631() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CommerceData(parcel);
        }

        public final Object[] newArray(int i) {
            return new CommerceData[i];
        }
    }

    public CommerceData(CommerceBubbleModel commerceBubbleModel) {
        this.f574a = commerceBubbleModel;
    }

    @Nullable
    public static CommerceData m687a(StoryAttachmentTargetFragmentModel storyAttachmentTargetFragmentModel) {
        CommerceBubbleModel u;
        List arrayList;
        ImmutableList b;
        int size;
        int i;
        if (storyAttachmentTargetFragmentModel.mo113I().g() == -1649510526) {
            Preconditions.checkNotNull(storyAttachmentTargetFragmentModel);
            ReceiptBuilder receiptBuilder = new ReceiptBuilder();
            receiptBuilder.f595a = storyAttachmentTargetFragmentModel.mo58c();
            receiptBuilder.f596b = storyAttachmentTargetFragmentModel.aD_();
            receiptBuilder.m692e(storyAttachmentTargetFragmentModel.ar_());
            receiptBuilder.f602h = storyAttachmentTargetFragmentModel.as_();
            receiptBuilder.f603i = storyAttachmentTargetFragmentModel.aH_();
            receiptBuilder.f598d = storyAttachmentTargetFragmentModel.aC_();
            receiptBuilder.f601g = ModelConverters.m397a(storyAttachmentTargetFragmentModel.aE_());
            receiptBuilder.f610p = ModelConverters.m394a(storyAttachmentTargetFragmentModel.at_());
            if (!(storyAttachmentTargetFragmentModel.mo86r() == null || storyAttachmentTargetFragmentModel.mo86r().m1070b() == null)) {
                receiptBuilder.f609o = storyAttachmentTargetFragmentModel.mo86r().m1066a();
                arrayList = new ArrayList();
                b = storyAttachmentTargetFragmentModel.mo86r().m1070b();
                size = b.size();
                for (i = 0; i < size; i++) {
                    arrayList.add(PlatformAttachmentsConverter.m388a((CommerceRetailItem) b.get(i)));
                }
                receiptBuilder.f611q = arrayList;
            }
            u = receiptBuilder.m694u();
        } else if (storyAttachmentTargetFragmentModel.mo113I().g() == -1039777287) {
            Preconditions.checkNotNull(storyAttachmentTargetFragmentModel);
            ReceiptCancellationBuilder receiptCancellationBuilder = new ReceiptCancellationBuilder();
            receiptCancellationBuilder.f619a = storyAttachmentTargetFragmentModel.mo83c();
            ReceiptBuilder a = ModelConverters.m396a(storyAttachmentTargetFragmentModel.mo85q());
            if (a != null) {
                receiptCancellationBuilder.f620b = a.m694u();
            }
            if (storyAttachmentTargetFragmentModel.mo84p() != null) {
                receiptCancellationBuilder.f621c = storyAttachmentTargetFragmentModel.mo84p().m1046a();
                arrayList = new ArrayList();
                b = storyAttachmentTargetFragmentModel.mo84p().m1050b();
                size = b.size();
                for (i = 0; i < size; i++) {
                    arrayList.add(PlatformAttachmentsConverter.m388a((CommerceRetailItem) b.get(i)));
                }
                receiptCancellationBuilder.f622d = arrayList;
            }
            r1 = receiptCancellationBuilder.m698e();
        } else if (storyAttachmentTargetFragmentModel.mo113I().g() == 697177488) {
            u = ModelConverters.m398a((CommerceShipmentBubble) storyAttachmentTargetFragmentModel);
        } else if (storyAttachmentTargetFragmentModel.mo113I().g() == 558867059) {
            ShipmentTrackingEvent shipmentTrackingEvent;
            Preconditions.checkNotNull(storyAttachmentTargetFragmentModel);
            ShipmentTrackingEventBuilder a2 = ModelConverters.m399a((CommerceBaseShipmentTracking) storyAttachmentTargetFragmentModel);
            if (a2 == null) {
                shipmentTrackingEvent = null;
            } else {
                if (storyAttachmentTargetFragmentModel.mo109H() != null) {
                    a2.f700g = ModelConverters.m398a(storyAttachmentTargetFragmentModel.mo109H());
                }
                shipmentTrackingEvent = a2.m710h();
            }
            r1 = shipmentTrackingEvent;
        } else if (storyAttachmentTargetFragmentModel.mo113I().g() == 1611225566) {
            Preconditions.checkNotNull(storyAttachmentTargetFragmentModel);
            Preconditions.checkNotNull(storyAttachmentTargetFragmentModel.mo103t());
            NodesModel nodesModel = (NodesModel) storyAttachmentTargetFragmentModel.mo103t().m1108a().get(0);
            SubscriptionBuilder subscriptionBuilder = new SubscriptionBuilder();
            subscriptionBuilder.f705a = storyAttachmentTargetFragmentModel.mo101c();
            subscriptionBuilder = subscriptionBuilder;
            String aF_ = nodesModel.aF_();
            subscriptionBuilder.f707c = !Strings.isNullOrEmpty(aF_) ? Uri.parse(aF_) : null;
            subscriptionBuilder = subscriptionBuilder;
            subscriptionBuilder.f708d = PlatformAttachmentsConverter.m388a(nodesModel);
            SubscriptionBuilder subscriptionBuilder2 = subscriptionBuilder;
            if (storyAttachmentTargetFragmentModel.mo102s() != null) {
                LogoImageBuilder logoImageBuilder = new LogoImageBuilder();
                logoImageBuilder.f436c = storyAttachmentTargetFragmentModel.mo102s().mo87a();
                logoImageBuilder = logoImageBuilder;
                logoImageBuilder.f435b = storyAttachmentTargetFragmentModel.mo102s().mo89c();
                subscriptionBuilder2.f706b = logoImageBuilder.m389a(storyAttachmentTargetFragmentModel.mo102s().mo88b()).m390d();
            }
            r1 = new Subscription(subscriptionBuilder2);
        } else if (storyAttachmentTargetFragmentModel.mo113I().g() == 1851543484) {
            Preconditions.checkNotNull(storyAttachmentTargetFragmentModel);
            PlatformGenericAttachmentItemBuilder platformGenericAttachmentItemBuilder = new PlatformGenericAttachmentItemBuilder();
            platformGenericAttachmentItemBuilder.f460a = storyAttachmentTargetFragmentModel.mo68c();
            platformGenericAttachmentItemBuilder.f461b = storyAttachmentTargetFragmentModel.mo107g();
            platformGenericAttachmentItemBuilder.f466g = storyAttachmentTargetFragmentModel.al();
            platformGenericAttachmentItemBuilder.m391d(storyAttachmentTargetFragmentModel.ax_());
            platformGenericAttachmentItemBuilder.f467h = storyAttachmentTargetFragmentModel.bi();
            AgentItemSuggestionBuilder agentItemSuggestionBuilder = new AgentItemSuggestionBuilder();
            agentItemSuggestionBuilder.f568a = platformGenericAttachmentItemBuilder.m393n();
            String aF_2 = storyAttachmentTargetFragmentModel.aF_();
            agentItemSuggestionBuilder.f569b = !Strings.isNullOrEmpty(aF_2) ? Uri.parse(aF_2) : null;
            agentItemSuggestionBuilder.f572e = storyAttachmentTargetFragmentModel.bd();
            agentItemSuggestionBuilder.f573f = storyAttachmentTargetFragmentModel.be();
            if (storyAttachmentTargetFragmentModel.bM() != null) {
                if (storyAttachmentTargetFragmentModel.bM().m1720c() != null) {
                    agentItemSuggestionBuilder.f570c = storyAttachmentTargetFragmentModel.bM().m1720c().toString();
                }
                if (!Strings.isNullOrEmpty(storyAttachmentTargetFragmentModel.bM().mo129b())) {
                    agentItemSuggestionBuilder.f571d = storyAttachmentTargetFragmentModel.bM().mo129b();
                }
            }
            r1 = new AgentItemSuggestion(agentItemSuggestionBuilder);
        } else {
            Preconditions.checkState(false, "Unsupported graphql model.");
            u = null;
        }
        if (u != null) {
            return new CommerceData(u);
        }
        return null;
    }

    public CommerceData(Parcel parcel) {
        CommerceBubbleModelType modelType = CommerceBubbleModelType.getModelType(parcel.readInt());
        ClassLoader classLoader = modelType == CommerceBubbleModelType.RECEIPT ? Receipt.class.getClassLoader() : modelType == CommerceBubbleModelType.CANCELLATION ? ReceiptCancellation.class.getClassLoader() : (modelType == CommerceBubbleModelType.SHIPMENT || modelType == CommerceBubbleModelType.SHIPMENT_FOR_UNSUPPORTED_CARRIER) ? Shipment.class.getClassLoader() : (modelType == CommerceBubbleModelType.SHIPMENT_TRACKING_ETA || modelType == CommerceBubbleModelType.SHIPMENT_ETA || modelType == CommerceBubbleModelType.SHIPMENT_TRACKING_IN_TRANSIT || modelType == CommerceBubbleModelType.SHIPMENT_TRACKING_OUT_FOR_DELIVERY || modelType == CommerceBubbleModelType.SHIPMENT_TRACKING_DELAYED || modelType == CommerceBubbleModelType.SHIPMENT_TRACKING_DELIVERED) ? ShipmentTrackingEvent.class.getClassLoader() : modelType == CommerceBubbleModelType.PRODUCT_SUBSCRIPTION ? Subscription.class.getClassLoader() : modelType == CommerceBubbleModelType.AGENT_ITEM_SUGGESTION ? AgentItemSuggestion.class.getClassLoader() : null;
        this.f574a = (CommerceBubbleModel) parcel.readParcelable(classLoader);
    }

    public final CommerceBubbleModel m688a() {
        return this.f574a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt((this.f574a != null ? this.f574a.mo75b() : CommerceBubbleModelType.UNKNOWN).getValue());
        parcel.writeParcelable(this.f574a, 0);
    }
}
