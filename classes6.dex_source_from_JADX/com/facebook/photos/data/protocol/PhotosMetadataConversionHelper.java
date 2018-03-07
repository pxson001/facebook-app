package com.facebook.photos.data.protocol;

import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ReactionsCountFieldsModel.TopReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ReactionsCountFieldsModel.TopReactionsModel.EdgesModel.NodeModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.SimpleReactionsFeedbackFieldsModel.ReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsFeedbackFieldsModel.SupportedReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ImportantReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ImportantReactorsModel.NodesModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ViewerActsAsPersonModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivityPreviewTemplateFields;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaePreviewTemplateModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaePreviewTemplateModel.TemplateTokensModel;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLActivityTemplateToken;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLApplication;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLFaceBox;
import com.facebook.graphql.model.GraphQLFaceBoxTagSuggestionsConnection;
import com.facebook.graphql.model.GraphQLFaceBoxTagSuggestionsEdge;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLFeedbackReaction;
import com.facebook.graphql.model.GraphQLFeedbackReactionInfo;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLImageOverlay;
import com.facebook.graphql.model.GraphQLImportantReactorsConnection;
import com.facebook.graphql.model.GraphQLInlineActivitiesConnection;
import com.facebook.graphql.model.GraphQLInlineActivity;
import com.facebook.graphql.model.GraphQLLikersOfContentConnection;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLMobileStoreObject;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.GraphQLPhotoFaceBoxesConnection;
import com.facebook.graphql.model.GraphQLPhotoTag;
import com.facebook.graphql.model.GraphQLPhotoTagsConnection;
import com.facebook.graphql.model.GraphQLPhotoTagsEdge;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLPlaceSuggestionInfo;
import com.facebook.graphql.model.GraphQLPrivacyScope;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLReactorsOfContentConnection;
import com.facebook.graphql.model.GraphQLSponsoredData;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTaggableActivity;
import com.facebook.graphql.model.GraphQLTaggableActivityIcon;
import com.facebook.graphql.model.GraphQLTaggableActivityPreviewTemplate;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLTopLevelCommentsConnection;
import com.facebook.graphql.model.GraphQLTopReactionsConnection;
import com.facebook.graphql.model.GraphQLTopReactionsEdge;
import com.facebook.graphql.model.GraphQLUser;
import com.facebook.graphql.model.GraphQLVect2;
import com.facebook.graphql.model.GraphQLWithTagsConnection;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesEntityFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields.Ranges;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.FaceBoxInfoModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.FaceBoxSuggestionsQueryModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.FaceBoxSuggestionsQueryModel.EdgesModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.FaceBoxUserModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.ImageModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityObjectModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.LocationSuggestionModel.LocationTagSuggestionModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataAttributionAppModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataAttributionAppModel.NativeStoreObjectModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataAttributionAppModel.SquareLogoModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.ApplicationModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.ActionLinksModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.UserModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataInlineActivitiesModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataOwnerModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataWithoutFeedbackModel.AlbumModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataWithoutFeedbackModel.ExplicitPlaceModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataWithoutFeedbackModel.PendingPlaceModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataWithoutFeedbackModel.WithTagsModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.IconImageModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.PhotosFaceBoxesQueryModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.PlaceInfoModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.PlaceInfoModel.PlaceProfilePictureModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.SimpleMediaFeedbackModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoModel.TaggerModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;

/* compiled from: suggestedPrivacyJson */
public final class PhotosMetadataConversionHelper {
    private static int m4834a(FlatBufferBuilder flatBufferBuilder, GraphQLImportantReactorsConnection graphQLImportantReactorsConnection) {
        if (graphQLImportantReactorsConnection == null) {
            return 0;
        }
        int a;
        ImmutableList a2 = graphQLImportantReactorsConnection.a();
        if (a2 != null) {
            int[] iArr = new int[a2.size()];
            for (int i = 0; i < a2.size(); i++) {
                GraphQLActor graphQLActor = (GraphQLActor) a2.get(i);
                int i2 = 0;
                if (graphQLActor != null) {
                    int a3 = flatBufferBuilder.a(graphQLActor.b());
                    int b = flatBufferBuilder.b(graphQLActor.aa());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a3);
                    flatBufferBuilder.b(1, b);
                    i2 = flatBufferBuilder.d();
                    flatBufferBuilder.d(i2);
                }
                iArr[i] = i2;
            }
            a = flatBufferBuilder.a(iArr, true);
        } else {
            a = 0;
        }
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4837a(FlatBufferBuilder flatBufferBuilder, GraphQLLikersOfContentConnection graphQLLikersOfContentConnection) {
        if (graphQLLikersOfContentConnection == null) {
            return 0;
        }
        flatBufferBuilder.c(1);
        flatBufferBuilder.a(0, graphQLLikersOfContentConnection.a(), 0);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4846a(FlatBufferBuilder flatBufferBuilder, GraphQLReactorsOfContentConnection graphQLReactorsOfContentConnection) {
        if (graphQLReactorsOfContentConnection == null) {
            return 0;
        }
        flatBufferBuilder.c(1);
        flatBufferBuilder.a(0, graphQLReactorsOfContentConnection.a(), 0);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4832a(FlatBufferBuilder flatBufferBuilder, GraphQLFeedbackReaction graphQLFeedbackReaction) {
        if (graphQLFeedbackReaction == null) {
            return 0;
        }
        flatBufferBuilder.c(1);
        flatBufferBuilder.a(0, graphQLFeedbackReaction.a(), 0);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4854a(FlatBufferBuilder flatBufferBuilder, GraphQLTopLevelCommentsConnection graphQLTopLevelCommentsConnection) {
        if (graphQLTopLevelCommentsConnection == null) {
            return 0;
        }
        flatBufferBuilder.c(2);
        flatBufferBuilder.a(0, graphQLTopLevelCommentsConnection.a(), 0);
        flatBufferBuilder.a(1, graphQLTopLevelCommentsConnection.b(), 0);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4855a(FlatBufferBuilder flatBufferBuilder, GraphQLTopReactionsConnection graphQLTopReactionsConnection) {
        if (graphQLTopReactionsConnection == null) {
            return 0;
        }
        int a;
        ImmutableList a2 = graphQLTopReactionsConnection.a();
        if (a2 != null) {
            int[] iArr = new int[a2.size()];
            for (int i = 0; i < a2.size(); i++) {
                GraphQLTopReactionsEdge graphQLTopReactionsEdge = (GraphQLTopReactionsEdge) a2.get(i);
                int i2 = 0;
                if (graphQLTopReactionsEdge != null) {
                    GraphQLFeedbackReactionInfo a3 = graphQLTopReactionsEdge.a();
                    int i3 = 0;
                    if (a3 != null) {
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.a(0, a3.m(), 0);
                        i3 = flatBufferBuilder.d();
                        flatBufferBuilder.d(i3);
                    }
                    int i4 = i3;
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, i4);
                    flatBufferBuilder.a(1, graphQLTopReactionsEdge.j(), 0);
                    i2 = flatBufferBuilder.d();
                    flatBufferBuilder.d(i2);
                }
                iArr[i] = i2;
            }
            a = flatBufferBuilder.a(iArr, true);
        } else {
            a = 0;
        }
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4856a(FlatBufferBuilder flatBufferBuilder, GraphQLUser graphQLUser) {
        if (graphQLUser == null) {
            return 0;
        }
        int b = flatBufferBuilder.b(graphQLUser.ar());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    public static int m4831a(FlatBufferBuilder flatBufferBuilder, GraphQLFeedback graphQLFeedback) {
        if (graphQLFeedback == null) {
            return 0;
        }
        int i;
        int a;
        int b = flatBufferBuilder.b(graphQLFeedback.z_());
        int a2 = m4834a(flatBufferBuilder, graphQLFeedback.W());
        int b2 = flatBufferBuilder.b(graphQLFeedback.j());
        int a3 = m4837a(flatBufferBuilder, graphQLFeedback.C());
        int a4 = m4846a(flatBufferBuilder, graphQLFeedback.E());
        int b3 = flatBufferBuilder.b(graphQLFeedback.G());
        ImmutableList K = graphQLFeedback.K();
        if (K != null) {
            int[] iArr = new int[K.size()];
            for (i = 0; i < K.size(); i++) {
                iArr[i] = m4832a(flatBufferBuilder, (GraphQLFeedbackReaction) K.get(i));
            }
            a = flatBufferBuilder.a(iArr, true);
        } else {
            a = 0;
        }
        i = m4854a(flatBufferBuilder, graphQLFeedback.L());
        int a5 = m4855a(flatBufferBuilder, graphQLFeedback.M());
        int a6 = m4856a(flatBufferBuilder, graphQLFeedback.X());
        flatBufferBuilder.c(21);
        flatBufferBuilder.a(0, graphQLFeedback.b());
        flatBufferBuilder.a(1, graphQLFeedback.c());
        flatBufferBuilder.a(2, graphQLFeedback.d());
        flatBufferBuilder.a(3, graphQLFeedback.x_());
        flatBufferBuilder.a(4, graphQLFeedback.g());
        flatBufferBuilder.a(5, graphQLFeedback.n());
        flatBufferBuilder.a(6, graphQLFeedback.o());
        flatBufferBuilder.a(7, graphQLFeedback.t());
        flatBufferBuilder.a(8, graphQLFeedback.y_());
        flatBufferBuilder.b(9, b);
        flatBufferBuilder.b(10, a2);
        flatBufferBuilder.a(11, graphQLFeedback.A());
        flatBufferBuilder.b(12, b2);
        flatBufferBuilder.b(13, a3);
        flatBufferBuilder.b(14, a4);
        flatBufferBuilder.b(15, b3);
        flatBufferBuilder.b(16, a);
        flatBufferBuilder.b(17, i);
        flatBufferBuilder.b(18, a5);
        flatBufferBuilder.b(19, a6);
        flatBufferBuilder.a(20, graphQLFeedback.S(), 0);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4852a(FlatBufferBuilder flatBufferBuilder, GraphQLTaggableActivityPreviewTemplate graphQLTaggableActivityPreviewTemplate) {
        if (graphQLTaggableActivityPreviewTemplate == null) {
            return 0;
        }
        int a;
        int b = flatBufferBuilder.b(graphQLTaggableActivityPreviewTemplate.a());
        ImmutableList j = graphQLTaggableActivityPreviewTemplate.j();
        if (j != null) {
            int[] iArr = new int[j.size()];
            for (int i = 0; i < j.size(); i++) {
                GraphQLActivityTemplateToken graphQLActivityTemplateToken = (GraphQLActivityTemplateToken) j.get(i);
                int i2 = 0;
                if (graphQLActivityTemplateToken != null) {
                    int a2 = flatBufferBuilder.a(graphQLActivityTemplateToken.j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, graphQLActivityTemplateToken.a(), 0);
                    flatBufferBuilder.b(1, a2);
                    i2 = flatBufferBuilder.d();
                    flatBufferBuilder.d(i2);
                }
                iArr[i] = i2;
            }
            a = flatBufferBuilder.a(iArr, true);
        } else {
            a = 0;
        }
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4850a(FlatBufferBuilder flatBufferBuilder, GraphQLTaggableActivity graphQLTaggableActivity) {
        if (graphQLTaggableActivity == null) {
            return 0;
        }
        int a = m4852a(flatBufferBuilder, graphQLTaggableActivity.r());
        int a2 = m4852a(flatBufferBuilder, graphQLTaggableActivity.s());
        int a3 = m4852a(flatBufferBuilder, graphQLTaggableActivity.t());
        int a4 = m4852a(flatBufferBuilder, graphQLTaggableActivity.u());
        int a5 = m4852a(flatBufferBuilder, graphQLTaggableActivity.v());
        int a6 = m4852a(flatBufferBuilder, graphQLTaggableActivity.w());
        flatBufferBuilder.c(6);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, a3);
        flatBufferBuilder.b(3, a4);
        flatBufferBuilder.b(4, a5);
        flatBufferBuilder.b(5, a6);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4851a(FlatBufferBuilder flatBufferBuilder, GraphQLTaggableActivityIcon graphQLTaggableActivityIcon) {
        if (graphQLTaggableActivityIcon == null) {
            return 0;
        }
        GraphQLImage l = graphQLTaggableActivityIcon.l();
        int i = 0;
        if (l != null) {
            int b = flatBufferBuilder.b(l.b());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i2 = i;
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, i2);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4836a(FlatBufferBuilder flatBufferBuilder, GraphQLInlineActivity graphQLInlineActivity) {
        if (graphQLInlineActivity == null) {
            return 0;
        }
        int b = flatBufferBuilder.b(graphQLInlineActivity.j());
        GraphQLNode k = graphQLInlineActivity.k();
        int i = 0;
        if (k != null) {
            int a = flatBufferBuilder.a(k.j());
            int b2 = flatBufferBuilder.b(k.dp());
            int b3 = flatBufferBuilder.b(k.eP());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i2 = i;
        int a2 = m4850a(flatBufferBuilder, graphQLInlineActivity.l());
        int a3 = m4851a(flatBufferBuilder, graphQLInlineActivity.m());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, i2);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4835a(FlatBufferBuilder flatBufferBuilder, GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection) {
        if (graphQLInlineActivitiesConnection == null) {
            return 0;
        }
        int a;
        ImmutableList a2 = graphQLInlineActivitiesConnection.a();
        if (a2 != null) {
            int[] iArr = new int[a2.size()];
            for (int i = 0; i < a2.size(); i++) {
                iArr[i] = m4836a(flatBufferBuilder, (GraphQLInlineActivity) a2.get(i));
            }
            a = flatBufferBuilder.a(iArr, true);
        } else {
            a = 0;
        }
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    public static MediaMetadataModel m4877a(GraphQLMedia graphQLMedia) {
        if (graphQLMedia == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4838a(flatBufferBuilder, graphQLMedia);
        if (a == 0) {
            return null;
        }
        flatBufferBuilder.d(a);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new MediaMetadataModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    private static int m4827a(FlatBufferBuilder flatBufferBuilder, GraphQLAlbum graphQLAlbum) {
        if (graphQLAlbum == null) {
            return 0;
        }
        int a = flatBufferBuilder.a(graphQLAlbum.k());
        int b = flatBufferBuilder.b(graphQLAlbum.u());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4828a(FlatBufferBuilder flatBufferBuilder, GraphQLApplication graphQLApplication) {
        if (graphQLApplication == null) {
            return 0;
        }
        int b = flatBufferBuilder.b(graphQLApplication.u());
        int b2 = flatBufferBuilder.b(graphQLApplication.y());
        GraphQLMobileStoreObject A = graphQLApplication.A();
        int i = 0;
        if (A != null) {
            int b3 = flatBufferBuilder.b(A.k());
            int b4 = flatBufferBuilder.b(A.l());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b3);
            flatBufferBuilder.b(1, b4);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i2 = i;
        GraphQLImage O = graphQLApplication.O();
        i = 0;
        if (O != null) {
            b3 = flatBufferBuilder.b(O.b());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b3);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i3 = i;
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, i2);
        flatBufferBuilder.b(3, i3);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4848a(FlatBufferBuilder flatBufferBuilder, GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return 0;
        }
        int b = flatBufferBuilder.b(graphQLStory.g());
        int b2 = flatBufferBuilder.b(graphQLStory.c());
        int b3 = flatBufferBuilder.b(graphQLStory.ai());
        GraphQLPrivacyScope ao = graphQLStory.ao();
        int i = 0;
        if (ao != null) {
            GraphQLImage m = ao.m();
            int i2 = 0;
            if (m != null) {
                int b4 = flatBufferBuilder.b(m.b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b4);
                i2 = flatBufferBuilder.d();
                flatBufferBuilder.d(i2);
            }
            int i3 = i2;
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, ao.a());
            flatBufferBuilder.b(1, i3);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i4 = i;
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, b3);
        flatBufferBuilder.b(3, i4);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4849a(FlatBufferBuilder flatBufferBuilder, GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment == null) {
            return 0;
        }
        int a;
        ImmutableList j = graphQLStoryAttachment.j();
        if (j != null) {
            int[] iArr = new int[j.size()];
            for (int i = 0; i < j.size(); i++) {
                GraphQLStoryActionLink graphQLStoryActionLink = (GraphQLStoryActionLink) j.get(i);
                int i2 = 0;
                if (graphQLStoryActionLink != null) {
                    int a2 = flatBufferBuilder.a(graphQLStoryActionLink.a());
                    int a3 = flatBufferBuilder.a(graphQLStoryActionLink.j());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a2);
                    flatBufferBuilder.b(1, a3);
                    flatBufferBuilder.a(2, graphQLStoryActionLink.s(), 0);
                    i2 = flatBufferBuilder.d();
                    flatBufferBuilder.d(i2);
                }
                iArr[i] = i2;
            }
            a = flatBufferBuilder.a(iArr, true);
        } else {
            a = 0;
        }
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4847a(FlatBufferBuilder flatBufferBuilder, GraphQLSponsoredData graphQLSponsoredData) {
        if (graphQLSponsoredData == null) {
            return 0;
        }
        GraphQLUser p = graphQLSponsoredData.p();
        int i = 0;
        if (p != null) {
            int b = flatBufferBuilder.b(p.P());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i2 = i;
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, i2);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4881b(FlatBufferBuilder flatBufferBuilder, GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return 0;
        }
        int i;
        int a;
        GraphQLApplication J = graphQLStory.J();
        int i2 = 0;
        if (J != null) {
            int b = flatBufferBuilder.b(J.u());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i2 = flatBufferBuilder.d();
            flatBufferBuilder.d(i2);
        }
        int i3 = i2;
        ImmutableList M = graphQLStory.M();
        if (M != null) {
            int[] iArr = new int[M.size()];
            for (i = 0; i < M.size(); i++) {
                iArr[i] = m4849a(flatBufferBuilder, (GraphQLStoryAttachment) M.get(i));
            }
            a = flatBufferBuilder.a(iArr, true);
        } else {
            a = 0;
        }
        i = flatBufferBuilder.b(graphQLStory.g());
        int b2 = flatBufferBuilder.b(graphQLStory.c());
        int b3 = flatBufferBuilder.b(graphQLStory.ai());
        int a2 = m4847a(flatBufferBuilder, graphQLStory.ay());
        int b4 = flatBufferBuilder.b(graphQLStory.k());
        flatBufferBuilder.c(7);
        flatBufferBuilder.b(0, i3);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, i);
        flatBufferBuilder.b(3, b2);
        flatBufferBuilder.b(4, b3);
        flatBufferBuilder.b(5, a2);
        flatBufferBuilder.b(6, b4);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4844a(FlatBufferBuilder flatBufferBuilder, GraphQLPlace graphQLPlace) {
        if (graphQLPlace == null) {
            return 0;
        }
        int a = flatBufferBuilder.a(graphQLPlace.j());
        int b = flatBufferBuilder.b(graphQLPlace.x());
        int b2 = flatBufferBuilder.b(graphQLPlace.B());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    public static int m4857a(FlatBufferBuilder flatBufferBuilder, GraphQLVect2 graphQLVect2) {
        if (graphQLVect2 == null) {
            return 0;
        }
        flatBufferBuilder.c(2);
        flatBufferBuilder.a(0, graphQLVect2.a(), 0.0d);
        flatBufferBuilder.a(1, graphQLVect2.b(), 0.0d);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    public static int m4830a(FlatBufferBuilder flatBufferBuilder, GraphQLFaceBoxTagSuggestionsConnection graphQLFaceBoxTagSuggestionsConnection) {
        if (graphQLFaceBoxTagSuggestionsConnection == null) {
            return 0;
        }
        int a;
        ImmutableList a2 = graphQLFaceBoxTagSuggestionsConnection.a();
        if (a2 != null) {
            int[] iArr = new int[a2.size()];
            for (int i = 0; i < a2.size(); i++) {
                GraphQLFaceBoxTagSuggestionsEdge graphQLFaceBoxTagSuggestionsEdge = (GraphQLFaceBoxTagSuggestionsEdge) a2.get(i);
                int i2 = 0;
                if (graphQLFaceBoxTagSuggestionsEdge != null) {
                    int b = flatBufferBuilder.b(graphQLFaceBoxTagSuggestionsEdge.a());
                    GraphQLProfile j = graphQLFaceBoxTagSuggestionsEdge.j();
                    int i3 = 0;
                    if (j != null) {
                        int a3 = flatBufferBuilder.a(j.j());
                        int b2 = flatBufferBuilder.b(j.b());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a3);
                        flatBufferBuilder.b(1, b2);
                        i3 = flatBufferBuilder.d();
                        flatBufferBuilder.d(i3);
                    }
                    int i4 = i3;
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, i4);
                    i2 = flatBufferBuilder.d();
                    flatBufferBuilder.d(i2);
                }
                iArr[i] = i2;
            }
            a = flatBufferBuilder.a(iArr, true);
        } else {
            a = 0;
        }
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4840a(FlatBufferBuilder flatBufferBuilder, GraphQLPhotoFaceBoxesConnection graphQLPhotoFaceBoxesConnection) {
        if (graphQLPhotoFaceBoxesConnection == null) {
            return 0;
        }
        int a;
        ImmutableList a2 = graphQLPhotoFaceBoxesConnection.a();
        if (a2 != null) {
            int[] iArr = new int[a2.size()];
            for (int i = 0; i < a2.size(); i++) {
                GraphQLFaceBox graphQLFaceBox = (GraphQLFaceBox) a2.get(i);
                int i2 = 0;
                if (graphQLFaceBox != null) {
                    int a3 = m4857a(flatBufferBuilder, graphQLFaceBox.j());
                    int a4 = m4857a(flatBufferBuilder, graphQLFaceBox.k());
                    int b = flatBufferBuilder.b(graphQLFaceBox.l());
                    int a5 = m4830a(flatBufferBuilder, graphQLFaceBox.m());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a3);
                    flatBufferBuilder.b(1, a4);
                    flatBufferBuilder.b(2, b);
                    flatBufferBuilder.b(3, a5);
                    i2 = flatBufferBuilder.d();
                    flatBufferBuilder.d(i2);
                }
                iArr[i] = i2;
            }
            a = flatBufferBuilder.a(iArr, true);
        } else {
            a = 0;
        }
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4883d(FlatBufferBuilder flatBufferBuilder, GraphQLImage graphQLImage) {
        if (graphQLImage == null) {
            return 0;
        }
        int b = flatBufferBuilder.b(graphQLImage.b());
        flatBufferBuilder.c(3);
        flatBufferBuilder.a(0, graphQLImage.a(), 0);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.a(2, graphQLImage.c(), 0);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4845a(FlatBufferBuilder flatBufferBuilder, GraphQLPlaceSuggestionInfo graphQLPlaceSuggestionInfo) {
        if (graphQLPlaceSuggestionInfo == null) {
            return 0;
        }
        GraphQLPage a = graphQLPlaceSuggestionInfo.a();
        int i = 0;
        if (a != null) {
            int a2 = flatBufferBuilder.a(new GraphQLObjectType(2479791));
            int b = flatBufferBuilder.b(a.ae());
            int b2 = flatBufferBuilder.b(a.aG());
            GraphQLImage aW = a.aW();
            int i2 = 0;
            if (aW != null) {
                int b3 = flatBufferBuilder.b(aW.b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b3);
                i2 = flatBufferBuilder.d();
                flatBufferBuilder.d(i2);
            }
            int i3 = i2;
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a2);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, i3);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i4 = i;
        int b4 = flatBufferBuilder.b(graphQLPlaceSuggestionInfo.j());
        int a3 = flatBufferBuilder.a(graphQLPlaceSuggestionInfo.k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, i4);
        flatBufferBuilder.b(1, b4);
        flatBufferBuilder.b(2, a3);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4829a(FlatBufferBuilder flatBufferBuilder, GraphQLEntityAtRange graphQLEntityAtRange) {
        if (graphQLEntityAtRange == null) {
            return 0;
        }
        GraphQLEntity j = graphQLEntityAtRange.j();
        int i = 0;
        if (j != null) {
            int a = flatBufferBuilder.a(j.b());
            int c = flatBufferBuilder.c(j.c());
            int b = flatBufferBuilder.b(j.d());
            int b2 = flatBufferBuilder.b(j.C_());
            int b3 = flatBufferBuilder.b(j.g());
            int b4 = flatBufferBuilder.b(j.D_());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, c);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.b(5, b4);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i2 = i;
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, i2);
        flatBufferBuilder.a(1, graphQLEntityAtRange.b(), 0);
        flatBufferBuilder.a(2, graphQLEntityAtRange.c(), 0);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4853a(FlatBufferBuilder flatBufferBuilder, GraphQLTextWithEntities graphQLTextWithEntities) {
        if (graphQLTextWithEntities == null) {
            return 0;
        }
        int i;
        int a;
        ImmutableList b = graphQLTextWithEntities.b();
        if (b != null) {
            int[] iArr = new int[b.size()];
            for (i = 0; i < b.size(); i++) {
                iArr[i] = m4829a(flatBufferBuilder, (GraphQLEntityAtRange) b.get(i));
            }
            a = flatBufferBuilder.a(iArr, true);
        } else {
            a = 0;
        }
        i = flatBufferBuilder.b(graphQLTextWithEntities.a());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, i);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4878b(FlatBufferBuilder flatBufferBuilder, GraphQLActor graphQLActor) {
        if (graphQLActor == null) {
            return 0;
        }
        int a = flatBufferBuilder.a(graphQLActor.b());
        int b = flatBufferBuilder.b(graphQLActor.H());
        int b2 = flatBufferBuilder.b(graphQLActor.aa());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4879b(FlatBufferBuilder flatBufferBuilder, GraphQLPlace graphQLPlace) {
        if (graphQLPlace == null) {
            return 0;
        }
        int a = flatBufferBuilder.a(graphQLPlace.j());
        int b = flatBufferBuilder.b(graphQLPlace.x());
        int b2 = flatBufferBuilder.b(graphQLPlace.B());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4880b(FlatBufferBuilder flatBufferBuilder, GraphQLPrivacyScope graphQLPrivacyScope) {
        if (graphQLPrivacyScope == null) {
            return 0;
        }
        GraphQLImage m = graphQLPrivacyScope.m();
        int i = 0;
        if (m != null) {
            int b = flatBufferBuilder.b(m.b());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i2 = i;
        flatBufferBuilder.c(2);
        flatBufferBuilder.a(0, graphQLPrivacyScope.a());
        flatBufferBuilder.b(1, i2);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4833a(FlatBufferBuilder flatBufferBuilder, GraphQLImageOverlay graphQLImageOverlay) {
        if (graphQLImageOverlay == null) {
            return 0;
        }
        int a = flatBufferBuilder.a(graphQLImageOverlay.j());
        int b = flatBufferBuilder.b(graphQLImageOverlay.l());
        GraphQLImage m = graphQLImageOverlay.m();
        int i = 0;
        if (m != null) {
            int b2 = flatBufferBuilder.b(m.b());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b2);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i2 = i;
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, i2);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4841a(FlatBufferBuilder flatBufferBuilder, GraphQLPhotoTag graphQLPhotoTag) {
        if (graphQLPhotoTag == null) {
            return 0;
        }
        int a = m4857a(flatBufferBuilder, graphQLPhotoTag.j());
        GraphQLActor k = graphQLPhotoTag.k();
        int i = 0;
        if (k != null) {
            int a2 = flatBufferBuilder.a(k.b());
            int b = flatBufferBuilder.b(k.aa());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a2);
            flatBufferBuilder.b(1, b);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i2 = i;
        flatBufferBuilder.c(4);
        flatBufferBuilder.a(0, graphQLPhotoTag.a());
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, i2);
        flatBufferBuilder.a(3, graphQLPhotoTag.l(), 0);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4843a(FlatBufferBuilder flatBufferBuilder, GraphQLPhotoTagsEdge graphQLPhotoTagsEdge) {
        if (graphQLPhotoTagsEdge == null) {
            return 0;
        }
        int b = flatBufferBuilder.b(graphQLPhotoTagsEdge.a());
        GraphQLProfile j = graphQLPhotoTagsEdge.j();
        int i = 0;
        if (j != null) {
            int a = flatBufferBuilder.a(j.j());
            int b2 = flatBufferBuilder.b(j.b());
            int b3 = flatBufferBuilder.b(j.U());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i2 = i;
        int a2 = m4841a(flatBufferBuilder, graphQLPhotoTagsEdge.k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, i2);
        flatBufferBuilder.b(2, a2);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4842a(FlatBufferBuilder flatBufferBuilder, GraphQLPhotoTagsConnection graphQLPhotoTagsConnection) {
        if (graphQLPhotoTagsConnection == null) {
            return 0;
        }
        int a;
        ImmutableList a2 = graphQLPhotoTagsConnection.a();
        if (a2 != null) {
            int[] iArr = new int[a2.size()];
            for (int i = 0; i < a2.size(); i++) {
                iArr[i] = m4843a(flatBufferBuilder, (GraphQLPhotoTagsEdge) a2.get(i));
            }
            a = flatBufferBuilder.a(iArr, true);
        } else {
            a = 0;
        }
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4858a(FlatBufferBuilder flatBufferBuilder, GraphQLWithTagsConnection graphQLWithTagsConnection) {
        if (graphQLWithTagsConnection == null) {
            return 0;
        }
        int a;
        ImmutableList a2 = graphQLWithTagsConnection.a();
        if (a2 != null) {
            int[] iArr = new int[a2.size()];
            for (int i = 0; i < a2.size(); i++) {
                GraphQLActor graphQLActor = (GraphQLActor) a2.get(i);
                int i2 = 0;
                if (graphQLActor != null) {
                    int a3 = flatBufferBuilder.a(graphQLActor.b());
                    int b = flatBufferBuilder.b(graphQLActor.H());
                    int b2 = flatBufferBuilder.b(graphQLActor.aa());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a3);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    i2 = flatBufferBuilder.d();
                    flatBufferBuilder.d(i2);
                }
                iArr[i] = i2;
            }
            a = flatBufferBuilder.a(iArr, true);
        } else {
            a = 0;
        }
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m4838a(FlatBufferBuilder flatBufferBuilder, GraphQLMedia graphQLMedia) {
        if (graphQLMedia == null) {
            return 0;
        }
        int a = flatBufferBuilder.a(graphQLMedia.j());
        int b = flatBufferBuilder.b(graphQLMedia.k());
        int a2 = m4827a(flatBufferBuilder, graphQLMedia.l());
        int a3 = m4828a(flatBufferBuilder, graphQLMedia.o());
        int b2 = flatBufferBuilder.b(graphQLMedia.p());
        int a4 = m4848a(flatBufferBuilder, graphQLMedia.D());
        int b3 = m4881b(flatBufferBuilder, graphQLMedia.F());
        int a5 = m4844a(flatBufferBuilder, graphQLMedia.G());
        int a6 = m4840a(flatBufferBuilder, graphQLMedia.H());
        int a7 = m4831a(flatBufferBuilder, graphQLMedia.I());
        int a8 = m4857a(flatBufferBuilder, graphQLMedia.J());
        int b4 = flatBufferBuilder.b(graphQLMedia.Q());
        int b5 = flatBufferBuilder.b(graphQLMedia.b());
        int d = m4883d(flatBufferBuilder, graphQLMedia.S());
        int d2 = m4883d(flatBufferBuilder, graphQLMedia.T());
        int d3 = m4883d(flatBufferBuilder, graphQLMedia.U());
        int d4 = m4883d(flatBufferBuilder, graphQLMedia.Y());
        int d5 = m4883d(flatBufferBuilder, graphQLMedia.Z());
        int d6 = m4883d(flatBufferBuilder, graphQLMedia.ae());
        int a9 = m4835a(flatBufferBuilder, graphQLMedia.ai());
        int d7 = m4883d(flatBufferBuilder, graphQLMedia.au());
        int a10 = m4845a(flatBufferBuilder, graphQLMedia.aw());
        int a11 = m4853a(flatBufferBuilder, graphQLMedia.az());
        int b6 = m4878b(flatBufferBuilder, graphQLMedia.aF());
        int b7 = m4879b(flatBufferBuilder, graphQLMedia.aH());
        int b8 = flatBufferBuilder.b(graphQLMedia.aO());
        int b9 = m4880b(flatBufferBuilder, graphQLMedia.aS());
        int a12 = m4833a(flatBufferBuilder, graphQLMedia.aT());
        int a13 = m4842a(flatBufferBuilder, graphQLMedia.bk());
        int a14 = m4858a(flatBufferBuilder, graphQLMedia.bp());
        flatBufferBuilder.c(46);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, b2);
        flatBufferBuilder.a(5, graphQLMedia.s());
        flatBufferBuilder.a(6, graphQLMedia.t());
        flatBufferBuilder.a(7, graphQLMedia.u());
        flatBufferBuilder.a(8, graphQLMedia.v());
        flatBufferBuilder.a(9, graphQLMedia.w());
        flatBufferBuilder.a(10, graphQLMedia.x());
        flatBufferBuilder.a(11, graphQLMedia.y());
        flatBufferBuilder.a(12, graphQLMedia.z());
        flatBufferBuilder.a(13, graphQLMedia.A());
        flatBufferBuilder.a(14, graphQLMedia.B());
        flatBufferBuilder.b(15, a4);
        flatBufferBuilder.a(16, graphQLMedia.E(), 0);
        flatBufferBuilder.b(17, b3);
        flatBufferBuilder.b(18, a5);
        flatBufferBuilder.b(19, a6);
        flatBufferBuilder.b(20, a7);
        flatBufferBuilder.b(21, a8);
        flatBufferBuilder.a(22, graphQLMedia.L());
        flatBufferBuilder.b(23, b4);
        flatBufferBuilder.b(24, b5);
        flatBufferBuilder.b(25, d);
        flatBufferBuilder.b(26, d2);
        flatBufferBuilder.b(27, d3);
        flatBufferBuilder.b(28, d4);
        flatBufferBuilder.b(29, d5);
        flatBufferBuilder.b(30, d6);
        flatBufferBuilder.b(31, a9);
        flatBufferBuilder.a(32, graphQLMedia.bx());
        flatBufferBuilder.a(33, graphQLMedia.an());
        flatBufferBuilder.b(34, d7);
        flatBufferBuilder.b(35, a10);
        flatBufferBuilder.b(36, a11);
        flatBufferBuilder.b(37, b6);
        flatBufferBuilder.b(38, b7);
        flatBufferBuilder.a(39, graphQLMedia.aN(), 0);
        flatBufferBuilder.b(40, b8);
        flatBufferBuilder.b(41, b9);
        flatBufferBuilder.b(42, a12);
        flatBufferBuilder.a(43, graphQLMedia.ba());
        flatBufferBuilder.b(44, a13);
        flatBufferBuilder.b(45, a14);
        a = flatBufferBuilder.d();
        flatBufferBuilder.d(a);
        return a;
    }

    public static int m4839a(FlatBufferBuilder flatBufferBuilder, GraphQLPhoto graphQLPhoto) {
        if (graphQLPhoto == null) {
            return 0;
        }
        int a = flatBufferBuilder.a(new GraphQLObjectType(77090322));
        int b = flatBufferBuilder.b(graphQLPhoto.j());
        int a2 = m4827a(flatBufferBuilder, graphQLPhoto.k());
        int a3 = m4828a(flatBufferBuilder, graphQLPhoto.o());
        int b2 = flatBufferBuilder.b(graphQLPhoto.p());
        int a4 = m4848a(flatBufferBuilder, graphQLPhoto.A());
        int b3 = m4881b(flatBufferBuilder, graphQLPhoto.C());
        int a5 = m4844a(flatBufferBuilder, graphQLPhoto.D());
        int a6 = m4840a(flatBufferBuilder, graphQLPhoto.E());
        int a7 = m4831a(flatBufferBuilder, graphQLPhoto.F());
        int a8 = m4857a(flatBufferBuilder, graphQLPhoto.G());
        int b4 = flatBufferBuilder.b(graphQLPhoto.K());
        int d = m4883d(flatBufferBuilder, graphQLPhoto.L());
        int d2 = m4883d(flatBufferBuilder, graphQLPhoto.N());
        int d3 = m4883d(flatBufferBuilder, graphQLPhoto.O());
        int d4 = m4883d(flatBufferBuilder, graphQLPhoto.U());
        int d5 = m4883d(flatBufferBuilder, graphQLPhoto.X());
        int d6 = m4883d(flatBufferBuilder, graphQLPhoto.af());
        int a9 = m4835a(flatBufferBuilder, graphQLPhoto.ah());
        int d7 = m4883d(flatBufferBuilder, graphQLPhoto.aq());
        int a10 = m4845a(flatBufferBuilder, graphQLPhoto.ar());
        int a11 = m4853a(flatBufferBuilder, graphQLPhoto.au());
        int b5 = m4878b(flatBufferBuilder, graphQLPhoto.aB());
        int b6 = m4879b(flatBufferBuilder, graphQLPhoto.aD());
        int b7 = flatBufferBuilder.b(graphQLPhoto.aJ());
        int b8 = m4880b(flatBufferBuilder, graphQLPhoto.aN());
        int a12 = m4833a(flatBufferBuilder, graphQLPhoto.aR());
        int a13 = m4842a(flatBufferBuilder, graphQLPhoto.aW());
        int a14 = m4858a(flatBufferBuilder, graphQLPhoto.aY());
        flatBufferBuilder.c(46);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, b2);
        flatBufferBuilder.a(5, graphQLPhoto.r());
        flatBufferBuilder.a(6, graphQLPhoto.s());
        flatBufferBuilder.a(7, graphQLPhoto.t());
        flatBufferBuilder.a(8, graphQLPhoto.u());
        flatBufferBuilder.a(9, graphQLPhoto.v());
        flatBufferBuilder.a(10, graphQLPhoto.w());
        flatBufferBuilder.a(11, graphQLPhoto.x());
        flatBufferBuilder.a(13, graphQLPhoto.y());
        flatBufferBuilder.a(14, graphQLPhoto.z());
        flatBufferBuilder.b(15, a4);
        flatBufferBuilder.a(16, graphQLPhoto.B(), 0);
        flatBufferBuilder.b(17, b3);
        flatBufferBuilder.b(18, a5);
        flatBufferBuilder.b(19, a6);
        flatBufferBuilder.b(20, a7);
        flatBufferBuilder.b(21, a8);
        flatBufferBuilder.a(22, graphQLPhoto.H());
        flatBufferBuilder.b(24, b4);
        flatBufferBuilder.b(25, d);
        flatBufferBuilder.b(26, d2);
        flatBufferBuilder.b(27, d3);
        flatBufferBuilder.b(28, d4);
        flatBufferBuilder.b(29, d5);
        flatBufferBuilder.b(30, d6);
        flatBufferBuilder.b(31, a9);
        flatBufferBuilder.a(32, graphQLPhoto.bb());
        flatBufferBuilder.a(33, graphQLPhoto.al());
        flatBufferBuilder.b(34, d7);
        flatBufferBuilder.b(35, a10);
        flatBufferBuilder.b(36, a11);
        flatBufferBuilder.b(37, b5);
        flatBufferBuilder.b(38, b6);
        flatBufferBuilder.a(39, graphQLPhoto.aI(), 0);
        flatBufferBuilder.b(40, b7);
        flatBufferBuilder.b(41, b8);
        flatBufferBuilder.b(42, a12);
        flatBufferBuilder.a(43, graphQLPhoto.aU());
        flatBufferBuilder.b(44, a13);
        flatBufferBuilder.b(45, a14);
        a = flatBufferBuilder.d();
        flatBufferBuilder.d(a);
        return a;
    }

    public static GraphQLStory m4871a(MediaPrivacyContainerStoryModel mediaPrivacyContainerStoryModel) {
        if (mediaPrivacyContainerStoryModel == null) {
            return null;
        }
        GraphQLPrivacyScope graphQLPrivacyScope;
        Builder builder = new Builder();
        builder.o = mediaPrivacyContainerStoryModel.m5266b();
        builder.K = mediaPrivacyContainerStoryModel.m5267c();
        builder.P = mediaPrivacyContainerStoryModel.m5268d();
        PrivacyScopeModel bl_ = mediaPrivacyContainerStoryModel.bl_();
        if (bl_ == null) {
            graphQLPrivacyScope = null;
        } else {
            GraphQLImage graphQLImage;
            GraphQLPrivacyScope.Builder builder2 = new GraphQLPrivacyScope.Builder();
            builder2.d = bl_.m5257a();
            IconImageModel b = bl_.m5258b();
            if (b == null) {
                graphQLImage = null;
            } else {
                GraphQLImage.Builder builder3 = new GraphQLImage.Builder();
                builder3.g = b.m5251a();
                graphQLImage = builder3.a();
            }
            builder2.h = graphQLImage;
            graphQLPrivacyScope = builder2.a();
        }
        builder.ae = graphQLPrivacyScope;
        return builder.a();
    }

    private static GraphQLSponsoredData m4869a(SponsoredDataModel sponsoredDataModel) {
        if (sponsoredDataModel == null) {
            return null;
        }
        GraphQLUser graphQLUser;
        GraphQLSponsoredData.Builder builder = new GraphQLSponsoredData.Builder();
        UserModel a = sponsoredDataModel.m5066a();
        if (a == null) {
            graphQLUser = null;
        } else {
            GraphQLUser.Builder builder2 = new GraphQLUser.Builder();
            builder2.N = a.m5062b();
            graphQLUser = builder2.a();
        }
        builder.p = graphQLUser;
        return new GraphQLSponsoredData(builder);
    }

    public static GraphQLStory m4870a(MediaMetadataCreationStoryModel mediaMetadataCreationStoryModel) {
        if (mediaMetadataCreationStoryModel == null) {
            return null;
        }
        GraphQLApplication graphQLApplication;
        Builder builder = new Builder();
        ApplicationModel b = mediaMetadataCreationStoryModel.m5074b();
        if (b == null) {
            graphQLApplication = null;
        } else {
            GraphQLApplication.Builder builder2 = new GraphQLApplication.Builder();
            builder2.o = b.m5037b();
            graphQLApplication = builder2.a();
        }
        builder.j = graphQLApplication;
        if (mediaMetadataCreationStoryModel.m5075c() != null) {
            ImmutableList.Builder builder3 = ImmutableList.builder();
            for (int i = 0; i < mediaMetadataCreationStoryModel.m5075c().size(); i++) {
                GraphQLStoryAttachment graphQLStoryAttachment;
                AttachmentsModel attachmentsModel = (AttachmentsModel) mediaMetadataCreationStoryModel.m5075c().get(i);
                if (attachmentsModel == null) {
                    graphQLStoryAttachment = null;
                } else {
                    GraphQLStoryAttachment.Builder builder4 = new GraphQLStoryAttachment.Builder();
                    if (attachmentsModel.m5050a() != null) {
                        ImmutableList.Builder builder5 = ImmutableList.builder();
                        for (int i2 = 0; i2 < attachmentsModel.m5050a().size(); i2++) {
                            GraphQLStoryActionLink graphQLStoryActionLink;
                            ActionLinksModel actionLinksModel = (ActionLinksModel) attachmentsModel.m5050a().get(i2);
                            if (actionLinksModel == null) {
                                graphQLStoryActionLink = null;
                            } else {
                                GraphQLStoryActionLink.Builder builder6 = new GraphQLStoryActionLink.Builder();
                                builder6.aP = actionLinksModel.m5041a();
                                builder6.d = actionLinksModel.m5044b();
                                builder6.m = actionLinksModel.m5045c();
                                graphQLStoryActionLink = builder6.a();
                            }
                            builder5.c(graphQLStoryActionLink);
                        }
                        builder4.d = builder5.b();
                    }
                    graphQLStoryAttachment = builder4.a();
                }
                builder3.c(graphQLStoryAttachment);
            }
            builder.m = builder3.b();
        }
        builder.o = mediaMetadataCreationStoryModel.m5076d();
        builder.K = mediaMetadataCreationStoryModel.bi_();
        builder.P = mediaMetadataCreationStoryModel.m5077g();
        builder.ao = m4869a(mediaMetadataCreationStoryModel.bk_());
        builder.aC = mediaMetadataCreationStoryModel.bj_();
        return builder.a();
    }

    public static GraphQLVect2 m4875a(DefaultVect2Fields defaultVect2Fields) {
        if (defaultVect2Fields == null) {
            return null;
        }
        GraphQLVect2.Builder builder = new GraphQLVect2.Builder();
        builder.d = defaultVect2Fields.a();
        builder.e = defaultVect2Fields.b();
        return builder.a();
    }

    private static GraphQLPhotoFaceBoxesConnection m4866a(PhotosFaceBoxesQueryModel photosFaceBoxesQueryModel) {
        if (photosFaceBoxesQueryModel == null) {
            return null;
        }
        GraphQLPhotoFaceBoxesConnection.Builder builder = new GraphQLPhotoFaceBoxesConnection.Builder();
        if (photosFaceBoxesQueryModel.m5317a() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < photosFaceBoxesQueryModel.m5317a().size(); i++) {
                Object obj;
                FaceBoxInfoModel faceBoxInfoModel = (FaceBoxInfoModel) photosFaceBoxesQueryModel.m5317a().get(i);
                if (faceBoxInfoModel == null) {
                    obj = null;
                } else {
                    GraphQLFaceBoxTagSuggestionsConnection graphQLFaceBoxTagSuggestionsConnection;
                    GraphQLFaceBox.Builder builder3 = new GraphQLFaceBox.Builder();
                    builder3.d = m4875a(faceBoxInfoModel.m4942b());
                    builder3.e = m4875a(faceBoxInfoModel.m4943c());
                    builder3.f = faceBoxInfoModel.m4944d();
                    FaceBoxSuggestionsQueryModel bf_ = faceBoxInfoModel.bf_();
                    if (bf_ == null) {
                        graphQLFaceBoxTagSuggestionsConnection = null;
                    } else {
                        GraphQLFaceBoxTagSuggestionsConnection.Builder builder4 = new GraphQLFaceBoxTagSuggestionsConnection.Builder();
                        if (bf_.m4956a() != null) {
                            ImmutableList.Builder builder5 = ImmutableList.builder();
                            for (int i2 = 0; i2 < bf_.m4956a().size(); i2++) {
                                Object obj2;
                                EdgesModel edgesModel = (EdgesModel) bf_.m4956a().get(i2);
                                if (edgesModel == null) {
                                    obj2 = null;
                                } else {
                                    GraphQLProfile graphQLProfile;
                                    GraphQLFaceBoxTagSuggestionsEdge.Builder builder6 = new GraphQLFaceBoxTagSuggestionsEdge.Builder();
                                    builder6.d = edgesModel.m4951a();
                                    FaceBoxUserModel b = edgesModel.m4952b();
                                    if (b == null) {
                                        graphQLProfile = null;
                                    } else {
                                        GraphQLProfile.Builder builder7 = new GraphQLProfile.Builder();
                                        builder7.aE = b.m4964b();
                                        builder7.G = b.m4965c();
                                        graphQLProfile = builder7.a();
                                    }
                                    builder6.e = graphQLProfile;
                                    GraphQLFaceBoxTagSuggestionsEdge graphQLFaceBoxTagSuggestionsEdge = new GraphQLFaceBoxTagSuggestionsEdge(builder6);
                                }
                                builder5.c(obj2);
                            }
                            builder4.d = builder5.b();
                        }
                        graphQLFaceBoxTagSuggestionsConnection = new GraphQLFaceBoxTagSuggestionsConnection(builder4);
                    }
                    builder3.g = graphQLFaceBoxTagSuggestionsConnection;
                    GraphQLFaceBox graphQLFaceBox = new GraphQLFaceBox(builder3);
                }
                builder2.c(obj);
            }
            builder.d = builder2.b();
        }
        return builder.a();
    }

    private static GraphQLTopReactionsConnection m4874a(TopReactionsModel topReactionsModel) {
        if (topReactionsModel == null) {
            return null;
        }
        GraphQLTopReactionsConnection.Builder builder = new GraphQLTopReactionsConnection.Builder();
        if (topReactionsModel.a() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < topReactionsModel.a().size(); i++) {
                GraphQLTopReactionsEdge graphQLTopReactionsEdge;
                TopReactionsModel.EdgesModel edgesModel = (TopReactionsModel.EdgesModel) topReactionsModel.a().get(i);
                if (edgesModel == null) {
                    graphQLTopReactionsEdge = null;
                } else {
                    GraphQLFeedbackReactionInfo graphQLFeedbackReactionInfo;
                    GraphQLTopReactionsEdge.Builder builder3 = new GraphQLTopReactionsEdge.Builder();
                    NodeModel a = edgesModel.a();
                    if (a == null) {
                        graphQLFeedbackReactionInfo = null;
                    } else {
                        GraphQLFeedbackReactionInfo.Builder builder4 = new GraphQLFeedbackReactionInfo.Builder();
                        builder4.g = a.a();
                        graphQLFeedbackReactionInfo = builder4.a();
                    }
                    builder3.d = graphQLFeedbackReactionInfo;
                    builder3.e = edgesModel.b();
                    graphQLTopReactionsEdge = builder3.a();
                }
                builder2.c(graphQLTopReactionsEdge);
            }
            builder.d = builder2.b();
        }
        return builder.a();
    }

    public static GraphQLFeedback m4862a(SimpleMediaFeedbackModel simpleMediaFeedbackModel) {
        if (simpleMediaFeedbackModel == null) {
            return null;
        }
        GraphQLImportantReactorsConnection graphQLImportantReactorsConnection;
        GraphQLLikersOfContentConnection graphQLLikersOfContentConnection;
        GraphQLReactorsOfContentConnection graphQLReactorsOfContentConnection;
        GraphQLTopLevelCommentsConnection graphQLTopLevelCommentsConnection;
        GraphQLUser graphQLUser;
        GraphQLFeedback.Builder builder = new GraphQLFeedback.Builder();
        builder.d = simpleMediaFeedbackModel.b();
        builder.b(simpleMediaFeedbackModel.c());
        builder.f = simpleMediaFeedbackModel.d();
        builder.h = simpleMediaFeedbackModel.bn_();
        builder.f(simpleMediaFeedbackModel.g());
        builder.j = simpleMediaFeedbackModel.bo_();
        builder.k = simpleMediaFeedbackModel.bp_();
        builder.p = simpleMediaFeedbackModel.j();
        builder.j(simpleMediaFeedbackModel.k());
        builder.v = simpleMediaFeedbackModel.l();
        ImportantReactorsModel m = simpleMediaFeedbackModel.m();
        if (m == null) {
            graphQLImportantReactorsConnection = null;
        } else {
            GraphQLImportantReactorsConnection.Builder builder2 = new GraphQLImportantReactorsConnection.Builder();
            if (m.a() != null) {
                ImmutableList.Builder builder3 = ImmutableList.builder();
                for (int i = 0; i < m.a().size(); i++) {
                    GraphQLActor graphQLActor;
                    NodesModel nodesModel = (NodesModel) m.a().get(i);
                    if (nodesModel == null) {
                        graphQLActor = null;
                    } else {
                        GraphQLActor.Builder builder4 = new GraphQLActor.Builder();
                        builder4.aH = nodesModel.a();
                        builder4.V = nodesModel.b();
                        graphQLActor = builder4.a();
                    }
                    builder3.c(graphQLActor);
                }
                builder2.d = builder3.b();
            }
            graphQLImportantReactorsConnection = builder2.a();
        }
        builder.w = graphQLImportantReactorsConnection;
        builder.m(simpleMediaFeedbackModel.n());
        builder.A = simpleMediaFeedbackModel.o();
        PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel p = simpleMediaFeedbackModel.p();
        if (p == null) {
            graphQLLikersOfContentConnection = null;
        } else {
            GraphQLLikersOfContentConnection.Builder builder5 = new GraphQLLikersOfContentConnection.Builder();
            builder5.a(p.m5340a());
            graphQLLikersOfContentConnection = builder5.a();
        }
        builder.C = graphQLLikersOfContentConnection;
        ReactorsModel q = simpleMediaFeedbackModel.q();
        if (q == null) {
            graphQLReactorsOfContentConnection = null;
        } else {
            GraphQLReactorsOfContentConnection.Builder builder6 = new GraphQLReactorsOfContentConnection.Builder();
            builder6.a(q.a());
            graphQLReactorsOfContentConnection = builder6.a();
        }
        builder.E = graphQLReactorsOfContentConnection;
        builder.G = simpleMediaFeedbackModel.r();
        if (simpleMediaFeedbackModel.s() != null) {
            ImmutableList.Builder builder7 = ImmutableList.builder();
            for (int i2 = 0; i2 < simpleMediaFeedbackModel.s().size(); i2++) {
                GraphQLFeedbackReaction graphQLFeedbackReaction;
                SupportedReactionsModel supportedReactionsModel = (SupportedReactionsModel) simpleMediaFeedbackModel.s().get(i2);
                if (supportedReactionsModel == null) {
                    graphQLFeedbackReaction = null;
                } else {
                    GraphQLFeedbackReaction.Builder builder8 = new GraphQLFeedbackReaction.Builder();
                    builder8.d = supportedReactionsModel.a();
                    graphQLFeedbackReaction = builder8.a();
                }
                builder7.c(graphQLFeedbackReaction);
            }
            builder.K = builder7.b();
        }
        C0220xee8e0a15 t = simpleMediaFeedbackModel.t();
        if (t == null) {
            graphQLTopLevelCommentsConnection = null;
        } else {
            GraphQLTopLevelCommentsConnection.Builder builder9 = new GraphQLTopLevelCommentsConnection.Builder();
            builder9.a(t.m5349a());
            builder9.b(t.m5354b());
            graphQLTopLevelCommentsConnection = builder9.a();
        }
        builder.L = graphQLTopLevelCommentsConnection;
        builder.M = m4874a(simpleMediaFeedbackModel.u());
        ViewerActsAsPersonModel v = simpleMediaFeedbackModel.v();
        if (v == null) {
            graphQLUser = null;
        } else {
            GraphQLUser.Builder builder10 = new GraphQLUser.Builder();
            builder10.ar = v.a();
            graphQLUser = builder10.a();
        }
        builder.Q = graphQLUser;
        builder.a(simpleMediaFeedbackModel.w());
        return builder.a();
    }

    public static GraphQLImage m4863a(DefaultImageFields defaultImageFields) {
        if (defaultImageFields == null) {
            return null;
        }
        GraphQLImage.Builder builder = new GraphQLImage.Builder();
        builder.d = defaultImageFields.a();
        builder.g = defaultImageFields.b();
        builder.h = defaultImageFields.c();
        return builder.a();
    }

    public static GraphQLTaggableActivityPreviewTemplate m4872a(MinutiaePreviewTemplateModel minutiaePreviewTemplateModel) {
        if (minutiaePreviewTemplateModel == null) {
            return null;
        }
        GraphQLTaggableActivityPreviewTemplate.Builder builder = new GraphQLTaggableActivityPreviewTemplate.Builder();
        builder.d = minutiaePreviewTemplateModel.a();
        if (minutiaePreviewTemplateModel.b() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < minutiaePreviewTemplateModel.b().size(); i++) {
                GraphQLActivityTemplateToken graphQLActivityTemplateToken;
                TemplateTokensModel templateTokensModel = (TemplateTokensModel) minutiaePreviewTemplateModel.b().get(i);
                if (templateTokensModel == null) {
                    graphQLActivityTemplateToken = null;
                } else {
                    GraphQLActivityTemplateToken.Builder builder3 = new GraphQLActivityTemplateToken.Builder();
                    builder3.d = templateTokensModel.a();
                    builder3.e = templateTokensModel.b();
                    graphQLActivityTemplateToken = builder3.a();
                }
                builder2.c(graphQLActivityTemplateToken);
            }
            builder.e = builder2.b();
        }
        return builder.a();
    }

    public static GraphQLInlineActivitiesConnection m4864a(MediaMetadataInlineActivitiesModel mediaMetadataInlineActivitiesModel) {
        if (mediaMetadataInlineActivitiesModel == null) {
            return null;
        }
        GraphQLInlineActivitiesConnection.Builder builder = new GraphQLInlineActivitiesConnection.Builder();
        if (mediaMetadataInlineActivitiesModel.m5082a() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < mediaMetadataInlineActivitiesModel.m5082a().size(); i++) {
                GraphQLInlineActivity graphQLInlineActivity;
                InlineActivityInfoModel inlineActivityInfoModel = (InlineActivityInfoModel) mediaMetadataInlineActivitiesModel.m5082a().get(i);
                if (inlineActivityInfoModel == null) {
                    graphQLInlineActivity = null;
                } else {
                    GraphQLNode graphQLNode;
                    GraphQLTaggableActivity graphQLTaggableActivity;
                    GraphQLTaggableActivityIcon graphQLTaggableActivityIcon;
                    GraphQLInlineActivity.Builder builder3 = new GraphQLInlineActivity.Builder();
                    builder3.d = inlineActivityInfoModel.m4985b();
                    InlineActivityObjectModel c = inlineActivityInfoModel.m4986c();
                    if (c == null) {
                        graphQLNode = null;
                    } else {
                        GraphQLNode.Builder builder4 = new GraphQLNode.Builder();
                        builder4.kQ = c.m4995b();
                        builder4.dK = c.m4996c();
                        builder4.fw = c.m4997d();
                        graphQLNode = builder4.a();
                    }
                    builder3.e = graphQLNode;
                    MinutiaeTaggableActivityPreviewTemplateFields d = inlineActivityInfoModel.m4987d();
                    if (d == null) {
                        graphQLTaggableActivity = null;
                    } else {
                        GraphQLTaggableActivity.Builder builder5 = new GraphQLTaggableActivity.Builder();
                        builder5.l = m4872a(d.y());
                        builder5.m = m4872a(d.x());
                        builder5.n = m4872a(d.w());
                        builder5.o = m4872a(d.v());
                        builder5.p = m4872a(d.u());
                        builder5.q = m4872a(d.t());
                        graphQLTaggableActivity = builder5.a();
                    }
                    builder3.f = graphQLTaggableActivity;
                    TaggableActivityIconModel bg_ = inlineActivityInfoModel.bg_();
                    if (bg_ == null) {
                        graphQLTaggableActivityIcon = null;
                    } else {
                        GraphQLImage graphQLImage;
                        GraphQLTaggableActivityIcon.Builder builder6 = new GraphQLTaggableActivityIcon.Builder();
                        ImageModel a = bg_.m4978a();
                        if (a == null) {
                            graphQLImage = null;
                        } else {
                            GraphQLImage.Builder builder7 = new GraphQLImage.Builder();
                            builder7.g = a.m4973a();
                            graphQLImage = builder7.a();
                        }
                        builder6.f = graphQLImage;
                        graphQLTaggableActivityIcon = builder6.a();
                    }
                    builder3.g = graphQLTaggableActivityIcon;
                    graphQLInlineActivity = builder3.a();
                }
                builder2.c(graphQLInlineActivity);
            }
            builder.d = builder2.b();
        }
        return builder.a();
    }

    private static GraphQLPlaceSuggestionInfo m4868a(LocationTagSuggestionModel locationTagSuggestionModel) {
        if (locationTagSuggestionModel == null) {
            return null;
        }
        GraphQLPlaceSuggestionInfo.Builder builder = new GraphQLPlaceSuggestionInfo.Builder();
        PlaceInfoModel a = locationTagSuggestionModel.m5004a();
        GraphQLPage graphQLPage = null;
        if (a != null) {
            GraphQLObjectType b = a.m5332b();
            if (b != null && b.g() == 2479791) {
                GraphQLImage graphQLImage;
                GraphQLPage.Builder builder2 = new GraphQLPage.Builder();
                builder2.Z = a.m5333c();
                builder2.aF = a.m5334d();
                PlaceProfilePictureModel bm_ = a.bm_();
                if (bm_ == null) {
                    graphQLImage = null;
                } else {
                    GraphQLImage.Builder builder3 = new GraphQLImage.Builder();
                    builder3.g = bm_.m5323a();
                    graphQLImage = builder3.a();
                }
                builder2.aZ = graphQLImage;
                graphQLPage = builder2.a();
            }
        }
        builder.d = graphQLPage;
        builder.e = locationTagSuggestionModel.m5005b();
        builder.f = locationTagSuggestionModel.m5006c();
        return new GraphQLPlaceSuggestionInfo(builder);
    }

    private static GraphQLTextWithEntities m4873a(DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields) {
        if (defaultTextWithEntitiesLongFields == null) {
            return null;
        }
        GraphQLTextWithEntities.Builder builder = new GraphQLTextWithEntities.Builder();
        if (defaultTextWithEntitiesLongFields.b() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < defaultTextWithEntitiesLongFields.b().size(); i++) {
                GraphQLEntityAtRange graphQLEntityAtRange;
                Ranges ranges = (Ranges) defaultTextWithEntitiesLongFields.b().get(i);
                if (ranges == null) {
                    graphQLEntityAtRange = null;
                } else {
                    GraphQLEntity graphQLEntity;
                    GraphQLEntityAtRange.Builder builder3 = new GraphQLEntityAtRange.Builder();
                    DefaultTextWithEntitiesEntityFields a = ranges.a();
                    if (a == null) {
                        graphQLEntity = null;
                    } else {
                        GraphQLEntity.Builder builder4 = new GraphQLEntity.Builder();
                        builder4.S = a.b();
                        builder4.d = a.c();
                        builder4.m = a.d();
                        builder4.u = a.C_();
                        builder4.O = a.g();
                        builder4.P = a.D_();
                        graphQLEntity = builder4.a();
                    }
                    builder3.d = graphQLEntity;
                    builder3.e = ranges.b();
                    builder3.f = ranges.c();
                    graphQLEntityAtRange = builder3.a();
                }
                builder2.c(graphQLEntityAtRange);
            }
            builder.h = builder2.b();
        }
        builder.i = defaultTextWithEntitiesLongFields.a();
        return builder.a();
    }

    public static GraphQLActor m4861a(MediaMetadataOwnerModel mediaMetadataOwnerModel) {
        if (mediaMetadataOwnerModel == null) {
            return null;
        }
        GraphQLActor.Builder builder = new GraphQLActor.Builder();
        builder.aH = mediaMetadataOwnerModel.m5145b();
        builder.B = mediaMetadataOwnerModel.m5146c();
        builder.V = mediaMetadataOwnerModel.m5147d();
        return builder.a();
    }

    private static GraphQLPhotoTagsConnection m4867a(TagInfoQueryModel tagInfoQueryModel) {
        if (tagInfoQueryModel == null) {
            return null;
        }
        GraphQLPhotoTagsConnection.Builder builder = new GraphQLPhotoTagsConnection.Builder();
        if (tagInfoQueryModel.m5403a() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < tagInfoQueryModel.m5403a().size(); i++) {
                Object obj;
                TagInfoQueryModel.EdgesModel edgesModel = (TagInfoQueryModel.EdgesModel) tagInfoQueryModel.m5403a().get(i);
                if (edgesModel == null) {
                    obj = null;
                } else {
                    GraphQLProfile graphQLProfile;
                    GraphQLPhotoTag graphQLPhotoTag;
                    GraphQLPhotoTagsEdge.Builder builder3 = new GraphQLPhotoTagsEdge.Builder();
                    builder3.d = edgesModel.m5396a();
                    TagInfoQueryModel.EdgesModel.NodeModel b = edgesModel.m5397b();
                    if (b == null) {
                        graphQLProfile = null;
                    } else {
                        GraphQLProfile.Builder builder4 = new GraphQLProfile.Builder();
                        builder4.aE = b.m5389b();
                        builder4.G = b.m5390c();
                        builder4.Q = b.m5391d();
                        graphQLProfile = builder4.a();
                    }
                    builder3.e = graphQLProfile;
                    TagInfoModel c = edgesModel.m5398c();
                    if (c == null) {
                        graphQLPhotoTag = null;
                    } else {
                        GraphQLActor graphQLActor;
                        GraphQLPhotoTag.Builder builder5 = new GraphQLPhotoTag.Builder();
                        builder5.d = c.m5373a();
                        builder5.e = m4875a(c.m5374b());
                        TaggerModel c2 = c.m5375c();
                        if (c2 == null) {
                            graphQLActor = null;
                        } else {
                            GraphQLActor.Builder builder6 = new GraphQLActor.Builder();
                            builder6.aH = c2.m5363a();
                            builder6.V = c2.m5367b();
                            graphQLActor = builder6.a();
                        }
                        builder5.f = graphQLActor;
                        builder5.g = c.m5376d();
                        graphQLPhotoTag = new GraphQLPhotoTag(builder5);
                    }
                    builder3.f = graphQLPhotoTag;
                    GraphQLPhotoTagsEdge graphQLPhotoTagsEdge = new GraphQLPhotoTagsEdge(builder3);
                }
                builder2.c(obj);
            }
            builder.d = builder2.b();
        }
        return new GraphQLPhotoTagsConnection(builder);
    }

    private static GraphQLWithTagsConnection m4876a(WithTagsModel withTagsModel) {
        if (withTagsModel == null) {
            return null;
        }
        GraphQLWithTagsConnection.Builder builder = new GraphQLWithTagsConnection.Builder();
        if (withTagsModel.m5195a() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < withTagsModel.m5195a().size(); i++) {
                GraphQLActor graphQLActor;
                WithTagsModel.NodesModel nodesModel = (WithTagsModel.NodesModel) withTagsModel.m5195a().get(i);
                if (nodesModel == null) {
                    graphQLActor = null;
                } else {
                    GraphQLActor.Builder builder3 = new GraphQLActor.Builder();
                    builder3.aH = nodesModel.m5189b();
                    builder3.B = nodesModel.m5190c();
                    builder3.V = nodesModel.m5191d();
                    graphQLActor = builder3.a();
                }
                builder2.c(graphQLActor);
            }
            builder.d = builder2.b();
        }
        return builder.a();
    }

    public static GraphQLMedia m4865a(MediaMetadata mediaMetadata) {
        if (mediaMetadata == null) {
            return null;
        }
        GraphQLAlbum graphQLAlbum;
        GraphQLApplication graphQLApplication;
        GraphQLImage graphQLImage;
        GraphQLPlace graphQLPlace;
        GraphQLPrivacyScope graphQLPrivacyScope;
        GraphQLImageOverlay graphQLImageOverlay;
        GraphQLMedia.Builder builder = new GraphQLMedia.Builder();
        builder.bv = mediaMetadata.mo255b();
        builder.d = mediaMetadata.mo262j();
        AlbumModel k = mediaMetadata.mo263k();
        if (k == null) {
            graphQLAlbum = null;
        } else {
            GraphQLAlbum.Builder builder2 = new GraphQLAlbum.Builder();
            builder2.e = k.m5153b();
            builder2.o = k.m5154c();
            graphQLAlbum = builder2.a();
        }
        builder.e = graphQLAlbum;
        MediaMetadataAttributionAppModel l = mediaMetadata.mo264l();
        if (l == null) {
            graphQLApplication = null;
        } else {
            GraphQLMobileStoreObject graphQLMobileStoreObject;
            GraphQLApplication.Builder builder3 = new GraphQLApplication.Builder();
            builder3.o = l.m5029b();
            builder3.s = l.m5030c();
            NativeStoreObjectModel d = l.m5031d();
            if (d == null) {
                graphQLMobileStoreObject = null;
            } else {
                GraphQLMobileStoreObject.Builder builder4 = new GraphQLMobileStoreObject.Builder();
                builder4.e = d.m5016a();
                builder4.f = d.m5017b();
                graphQLMobileStoreObject = new GraphQLMobileStoreObject(builder4);
            }
            builder3.u = graphQLMobileStoreObject;
            SquareLogoModel bh_ = l.bh_();
            if (bh_ == null) {
                graphQLImage = null;
            } else {
                GraphQLImage.Builder builder5 = new GraphQLImage.Builder();
                builder5.g = bh_.m5023a();
                graphQLImage = builder5.a();
            }
            builder3.I = graphQLImage;
            graphQLApplication = builder3.a();
        }
        builder.h = graphQLApplication;
        builder.i = mediaMetadata.mo265m();
        builder.m = mediaMetadata.mo266n();
        builder.n = mediaMetadata.mo267o();
        builder.o = mediaMetadata.mo268p();
        builder.p = mediaMetadata.mo269q();
        builder.q = mediaMetadata.mo270r();
        builder.r = mediaMetadata.mo271s();
        builder.s = mediaMetadata.mo272t();
        builder.t = mediaMetadata.mo273u();
        builder.u = mediaMetadata.mo274v();
        builder.v = mediaMetadata.mo275w();
        builder.x = m4871a(mediaMetadata.mo276x());
        builder.y = mediaMetadata.mo277y();
        builder.z = m4870a(mediaMetadata.mo278z());
        ExplicitPlaceModel A = mediaMetadata.mo233A();
        if (A == null) {
            graphQLPlace = null;
        } else {
            GraphQLPlace.Builder builder6 = new GraphQLPlace.Builder();
            builder6.X = A.m5165b();
            builder6.q = A.m5166c();
            builder6.c(A.m5167d());
            graphQLPlace = builder6.a();
        }
        builder.A = graphQLPlace;
        builder.B = m4866a(mediaMetadata.mo234B());
        builder.C = m4862a(mediaMetadata.mo235C());
        builder.D = m4875a(mediaMetadata.mo259c());
        builder.F = mediaMetadata.mo236D();
        builder.K = mediaMetadata.mo237E();
        builder.M = mediaMetadata.mo260d();
        builder.N = m4863a(mediaMetadata.be_());
        builder.O = m4863a(mediaMetadata.mo261g());
        builder.P = m4863a(mediaMetadata.mo238F());
        builder.T = m4863a(mediaMetadata.bd_());
        builder.U = m4863a(mediaMetadata.bc_());
        builder.aa = m4863a(mediaMetadata.mo239G());
        builder.af = m4864a(mediaMetadata.mo240H());
        builder.ah = mediaMetadata.mo241I();
        builder.am = mediaMetadata.mo242J();
        builder.at = m4863a(mediaMetadata.mo243K());
        builder.av = m4868a(mediaMetadata.mo244L());
        builder.ay = m4873a(mediaMetadata.mo245M());
        builder.aE = m4861a(mediaMetadata.mo246N());
        PendingPlaceModel O = mediaMetadata.mo247O();
        if (O == null) {
            graphQLPlace = null;
        } else {
            builder6 = new GraphQLPlace.Builder();
            builder6.X = O.m5177b();
            builder6.q = O.m5178c();
            builder6.c(O.m5179d());
            graphQLPlace = builder6.a();
        }
        builder.aG = graphQLPlace;
        builder.aM = mediaMetadata.mo248P();
        builder.aN = mediaMetadata.mo249Q();
        MediaPrivacyAndContainerStoryModel.PrivacyScopeModel R = mediaMetadata.mo250R();
        if (R == null) {
            graphQLPrivacyScope = null;
        } else {
            GraphQLPrivacyScope.Builder builder7 = new GraphQLPrivacyScope.Builder();
            builder7.d = R.m5238a();
            MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.IconImageModel b = R.m5239b();
            if (b == null) {
                graphQLImage = null;
            } else {
                builder5 = new GraphQLImage.Builder();
                builder5.g = b.m5232a();
                graphQLImage = builder5.a();
            }
            builder7.h = graphQLImage;
            graphQLPrivacyScope = builder7.a();
        }
        builder.aS = graphQLPrivacyScope;
        ImageOverlayFieldsModel S = mediaMetadata.mo251S();
        if (S == null) {
            graphQLImageOverlay = null;
        } else {
            GraphQLImageOverlay.Builder builder8 = new GraphQLImageOverlay.Builder();
            builder8.g = S.b();
            builder8.e = S.c();
            ImageOverlayFieldsModel.ImageModel d2 = S.d();
            if (d2 == null) {
                graphQLImage = null;
            } else {
                builder5 = new GraphQLImage.Builder();
                builder5.g = d2.a();
                graphQLImage = builder5.a();
            }
            builder8.f = graphQLImage;
            graphQLImageOverlay = new GraphQLImageOverlay(builder8);
        }
        builder.aT = graphQLImageOverlay;
        builder.ba = mediaMetadata.mo252T();
        builder.bn = m4867a(mediaMetadata.mo253U());
        builder.bu = m4876a(mediaMetadata.mo254V());
        return builder.a();
    }

    public static MediaMetadataModel m4882b(SizeAwareMedia sizeAwareMedia) {
        if (sizeAwareMedia == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int i = 0;
        if (sizeAwareMedia != null) {
            int a = flatBufferBuilder.a(sizeAwareMedia.b());
            int a2 = m4859a(flatBufferBuilder, sizeAwareMedia.c());
            int b = flatBufferBuilder.b(sizeAwareMedia.d());
            int a3 = m4860a(flatBufferBuilder, sizeAwareMedia.be_());
            int a4 = m4860a(flatBufferBuilder, sizeAwareMedia.g());
            int a5 = m4860a(flatBufferBuilder, sizeAwareMedia.bd_());
            int a6 = m4860a(flatBufferBuilder, sizeAwareMedia.bc_());
            flatBufferBuilder.c(46);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(21, a2);
            flatBufferBuilder.b(24, b);
            flatBufferBuilder.b(25, a3);
            flatBufferBuilder.b(26, a4);
            flatBufferBuilder.b(28, a5);
            flatBufferBuilder.b(29, a6);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i2 = i;
        if (i2 == 0) {
            return null;
        }
        flatBufferBuilder.d(i2);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new MediaMetadataModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    public static int m4859a(FlatBufferBuilder flatBufferBuilder, DefaultVect2Fields defaultVect2Fields) {
        if (defaultVect2Fields == null) {
            return 0;
        }
        flatBufferBuilder.c(2);
        flatBufferBuilder.a(0, defaultVect2Fields.a(), 0.0d);
        flatBufferBuilder.a(1, defaultVect2Fields.b(), 0.0d);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    public static int m4860a(FlatBufferBuilder flatBufferBuilder, DefaultImageFields defaultImageFields) {
        if (defaultImageFields == null) {
            return 0;
        }
        int b = flatBufferBuilder.b(defaultImageFields.b());
        flatBufferBuilder.c(3);
        flatBufferBuilder.a(0, defaultImageFields.a(), 0);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.a(2, defaultImageFields.c(), 0);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }
}
