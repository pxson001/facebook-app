package com.facebook.groups.docsandfiles.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.docsandfiles.protocol.GroupDocsAndFilesModels.GroupDocsAndFilesQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: Unknown viewType  */
public final class GroupDocsAndFiles {

    /* compiled from: Unknown viewType  */
    public class GroupDocsAndFilesQueryString extends TypedGraphQlQueryString<GroupDocsAndFilesQueryModel> {
        public GroupDocsAndFilesQueryString() {
            super(GroupDocsAndFilesQueryModel.class, false, "GroupDocsAndFilesQuery", "0c4560943e77f00efe6c543260494062", "group_address", "10154097886006729", RegularImmutableSet.a);
        }

        public final String m22450a(String str) {
            switch (str.hashCode()) {
                case -1019779949:
                    return "1";
                case 3355:
                    return "0";
                case 94851343:
                    return "2";
                default:
                    return str;
            }
        }
    }
}
