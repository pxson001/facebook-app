package com.facebook.messaging.payment.value.input;

import android.content.Context;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: exc */
public class MessengerPayViewFactory {
    private final Context f15472a;
    private final Provider<Boolean> f15473b;

    public static MessengerPayViewFactory m15773a(InjectorLike injectorLike) {
        return new MessengerPayViewFactory((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 4183));
    }

    @Inject
    public MessengerPayViewFactory(Context context, Provider<Boolean> provider) {
        this.f15472a = context;
        this.f15473b = provider;
    }

    public final MessengerPayView m15775a(MessengerPayType messengerPayType) {
        switch (messengerPayType) {
            case MP:
                return new MPMessengerPayView(this.f15472a);
            case MC:
            case PAGES_COMMERCE:
                return new MCMessengerPayView(this.f15472a);
            case GROUP_COMMERCE_PAY:
                return new OrionMessengerPayView(this.f15472a);
            case ORION:
                return ((Boolean) this.f15473b.get()).booleanValue() ? new OrionPayMessengerPayView(this.f15472a) : new OrionMessengerPayView(this.f15472a);
            case ORION_REQUEST:
            case GROUP_COMMERCE_REQUEST:
                return new OrionRequestMessengerPayView(this.f15472a);
            case ORION_REQUEST_ACK:
                return new OrionRequestAckMessengerPayView(this.f15472a);
            default:
                throw new RuntimeException("Unsupported enterPaymentValueType: " + messengerPayType);
        }
    }

    public static MessengerPayViewParams m15774a(MessengerPayType messengerPayType, MessengerPayData messengerPayData) {
        switch (messengerPayType) {
            case MP:
                MPMessengerPayViewParamsBuilder mPMessengerPayViewParamsBuilder = new MPMessengerPayViewParamsBuilder();
                mPMessengerPayViewParamsBuilder.f15430a = messengerPayData.f15445b;
                mPMessengerPayViewParamsBuilder = mPMessengerPayViewParamsBuilder;
                mPMessengerPayViewParamsBuilder.f15432c = messengerPayData.f15456m;
                mPMessengerPayViewParamsBuilder = mPMessengerPayViewParamsBuilder;
                mPMessengerPayViewParamsBuilder.f15431b = messengerPayData.f15450g;
                return new MPMessengerPayViewParams(mPMessengerPayViewParamsBuilder);
            case MC:
            case PAGES_COMMERCE:
                MCMessengerPayViewParamsBuilder mCMessengerPayViewParamsBuilder = new MCMessengerPayViewParamsBuilder();
                mCMessengerPayViewParamsBuilder.f15380a = messengerPayData.f15445b;
                mCMessengerPayViewParamsBuilder = mCMessengerPayViewParamsBuilder;
                mCMessengerPayViewParamsBuilder.f15386g = messengerPayData.f15455l;
                mCMessengerPayViewParamsBuilder = mCMessengerPayViewParamsBuilder;
                mCMessengerPayViewParamsBuilder.f15385f = messengerPayData.f15454k;
                mCMessengerPayViewParamsBuilder = mCMessengerPayViewParamsBuilder;
                mCMessengerPayViewParamsBuilder.f15384e = messengerPayData.f15453j;
                mCMessengerPayViewParamsBuilder = mCMessengerPayViewParamsBuilder;
                mCMessengerPayViewParamsBuilder.f15383d = messengerPayData.f15452i;
                mCMessengerPayViewParamsBuilder = mCMessengerPayViewParamsBuilder;
                mCMessengerPayViewParamsBuilder.f15382c = messengerPayData.m15767s();
                mCMessengerPayViewParamsBuilder = mCMessengerPayViewParamsBuilder;
                mCMessengerPayViewParamsBuilder.f15381b = messengerPayData.f15450g;
                return new MCMessengerPayViewParams(mCMessengerPayViewParamsBuilder);
            case GROUP_COMMERCE_PAY:
            case ORION:
            case ORION_REQUEST_ACK:
                OrionMessengerPayViewParamsBuilder orionMessengerPayViewParamsBuilder = new OrionMessengerPayViewParamsBuilder();
                orionMessengerPayViewParamsBuilder.f15562a = messengerPayData.f15445b;
                orionMessengerPayViewParamsBuilder = orionMessengerPayViewParamsBuilder;
                orionMessengerPayViewParamsBuilder.f15563b = messengerPayData.f15449f;
                orionMessengerPayViewParamsBuilder = orionMessengerPayViewParamsBuilder;
                orionMessengerPayViewParamsBuilder.f15566e = messengerPayData.f15461r;
                orionMessengerPayViewParamsBuilder = orionMessengerPayViewParamsBuilder;
                orionMessengerPayViewParamsBuilder.f15564c = messengerPayData.f15459p;
                orionMessengerPayViewParamsBuilder = orionMessengerPayViewParamsBuilder;
                orionMessengerPayViewParamsBuilder.f15565d = messengerPayData.f15460q;
                orionMessengerPayViewParamsBuilder = orionMessengerPayViewParamsBuilder;
                orionMessengerPayViewParamsBuilder.f15568g = messengerPayData.f15463t;
                orionMessengerPayViewParamsBuilder = orionMessengerPayViewParamsBuilder;
                orionMessengerPayViewParamsBuilder.f15569h = messengerPayData.m15766q();
                orionMessengerPayViewParamsBuilder = orionMessengerPayViewParamsBuilder;
                orionMessengerPayViewParamsBuilder.f15570i = messengerPayData.f15458o;
                orionMessengerPayViewParamsBuilder = orionMessengerPayViewParamsBuilder;
                orionMessengerPayViewParamsBuilder.f15567f = messengerPayData.f15462s;
                return new OrionMessengerPayViewParams(orionMessengerPayViewParamsBuilder);
            case ORION_REQUEST:
            case GROUP_COMMERCE_REQUEST:
                OrionRequestMessengerPayViewParamsBuilder orionRequestMessengerPayViewParamsBuilder = new OrionRequestMessengerPayViewParamsBuilder();
                orionRequestMessengerPayViewParamsBuilder.f15678a = messengerPayData.f15445b;
                orionRequestMessengerPayViewParamsBuilder = orionRequestMessengerPayViewParamsBuilder;
                orionRequestMessengerPayViewParamsBuilder.f15680c = messengerPayData.f15463t;
                orionRequestMessengerPayViewParamsBuilder = orionRequestMessengerPayViewParamsBuilder;
                orionRequestMessengerPayViewParamsBuilder.f15679b = messengerPayData.f15462s;
                orionRequestMessengerPayViewParamsBuilder = orionRequestMessengerPayViewParamsBuilder;
                orionRequestMessengerPayViewParamsBuilder.f15681d = messengerPayData.m15766q();
                orionRequestMessengerPayViewParamsBuilder = orionRequestMessengerPayViewParamsBuilder;
                orionRequestMessengerPayViewParamsBuilder.f15682e = messengerPayData.f15458o;
                return new OrionRequestMessengerPayViewParams(orionRequestMessengerPayViewParamsBuilder);
            default:
                throw new RuntimeException("Unsupported MessengerPayType: " + messengerPayType);
        }
    }
}
