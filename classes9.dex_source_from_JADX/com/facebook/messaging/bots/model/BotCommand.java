package com.facebook.messaging.bots.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.graphql.enums.GraphQLMessengerBotCommandIconStyle;
import com.facebook.messaging.bots.graphql.FetchBotCommandsQueryModels.FetchBotCommandsQueryModel.SuggestionsModel;
import com.facebook.messaging.bots.graphql.FetchBotCommandsQueryModels.FetchBotCommandsQueryModel.SuggestionsModel.CommandModel;
import com.facebook.messaging.bots.graphql.FetchBotCommandsQueryModels.FetchBotCommandsQueryModel.SuggestionsModel.IconModel;
import com.facebook.messaging.bots.graphql.FetchBotCommandsQueryModels.FetchBotCommandsQueryModel.SuggestionsModel.IconModel.ImageModel;
import com.facebook.messaging.bots.graphql.FetchBotCommandsQueryModels.FetchBotCommandsQueryModel.SuggestionsModel.ItemModel;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: object_participants */
public class BotCommand implements Parcelable {
    public static final Creator<BotCommand> CREATOR = new C09431();
    @Nullable
    public final String f8328a;
    public final String f8329b;
    @Nullable
    public final String f8330c;
    public final boolean f8331d;
    @Nullable
    public final ImageCrop f8332e;
    public final int f8333f;
    public final int f8334g;
    @Nullable
    public final String f8335h;

    /* compiled from: object_participants */
    final class C09431 implements Creator<BotCommand> {
        C09431() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new BotCommand(parcel);
        }

        public final Object[] newArray(int i) {
            return new BotCommand[i];
        }
    }

    /* compiled from: object_participants */
    public class Builder {
    }

    /* compiled from: object_participants */
    public enum ImageCrop {
        SQUARE,
        CIRCLE
    }

    public BotCommand(SuggestionsModel suggestionsModel) {
        boolean z;
        int i = 0;
        String str = null;
        ItemModel k = suggestionsModel.m8616k();
        this.f8329b = k == null ? null : k.m8610j();
        this.f8330c = k == null ? null : k.m8609a();
        CommandModel a = suggestionsModel.m8614a();
        this.f8328a = a == null ? null : a.m8589j();
        if (a == null || !a.m8588a()) {
            z = false;
        } else {
            z = true;
        }
        this.f8331d = z;
        IconModel j = suggestionsModel.m8615j();
        ImageCrop imageCrop = (j == null || j.m8604j() == GraphQLMessengerBotCommandIconStyle.CIRCLE) ? ImageCrop.CIRCLE : ImageCrop.SQUARE;
        this.f8332e = imageCrop;
        ImageModel a2 = j == null ? null : j.m8603a();
        this.f8333f = a2 == null ? 0 : a2.m8599k();
        if (a2 != null) {
            i = a2.m8594a();
        }
        this.f8334g = i;
        if (a2 != null) {
            str = a2.m8598j();
        }
        this.f8335h = str;
    }

    public BotCommand(Parcel parcel) {
        this.f8328a = parcel.readString();
        this.f8329b = parcel.readString();
        this.f8330c = parcel.readString();
        this.f8331d = ParcelUtil.a(parcel);
        this.f8332e = (ImageCrop) ParcelUtil.c(parcel, ImageCrop.class);
        this.f8333f = parcel.readInt();
        this.f8334g = parcel.readInt();
        this.f8335h = parcel.readString();
    }

    public String toString() {
        return "BotCommand{command='" + this.f8328a + '\'' + ", title='" + this.f8329b + '\'' + ", description='" + this.f8330c + '\'' + ", imageCrop=" + this.f8332e + ", imageWidth=" + this.f8333f + ", imageHeight=" + this.f8334g + ", imageUrl='" + this.f8335h + '\'' + '}';
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8328a);
        parcel.writeString(this.f8329b);
        parcel.writeString(this.f8330c);
        ParcelUtil.a(parcel, this.f8331d);
        ParcelUtil.a(parcel, this.f8332e);
        parcel.writeInt(this.f8333f);
        parcel.writeInt(this.f8334g);
        parcel.writeString(this.f8335h);
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
