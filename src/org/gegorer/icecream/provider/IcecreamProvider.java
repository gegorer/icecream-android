package org.gegorer.icecream.provider;

import java.util.ArrayList;

import org.gegorer.icecream.ProviderHelper;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;

public class IcecreamProvider extends ContentProvider {

    static final int URI_TYPE_FAMI_TABLE = 0;

    static UriMatcher sUriMatcher;
    static {
        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        sUriMatcher.addURI(ProviderHelper.AUTHORITY, ProviderHelper.FAMI_TABLE, URI_TYPE_FAMI_TABLE);
    };

	static final String[][] DATA={
        {"金融店", "台北市信義區市府路45號"},
        {"北醫店","台北市信義區吳興街263號"},
        {"新昆陽店","台北市南港區昆陽街145號"},
        {"國興店","台北市南港區舊莊街一段3巷3弄2號"},
        {"貴陽店","台北市萬華區貴陽街二段182號，184號"},
        {"信美店", "台北市大安區信義路三段134巷2號1樓"},
        {"新敦民店",	"台北市大安區敦化南路一段161巷7號"},
        {"新遠企店","台北市大安區敦化南路二段261號"}
    };
	@Override
    public boolean onCreate() {
        return true;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        MatrixCursor cursor = new MatrixCursor(ProviderHelper.COLUMN_NAMES);

        for(int i=0;i<DATA.length;i++) {
            ArrayList<Object> arr = new ArrayList<Object>();
            arr.add(i);
            for(int j=1;j<ProviderHelper.COLUMN_NAMES.length;j++) {
                //column 0 is _id
                arr.add(DATA[i][j-1]);
            }
            cursor.addRow(arr.toArray());
        }

        return cursor;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int delete(Uri arg0, String arg1, String[] arg2) {
        return 0;
    }
}
