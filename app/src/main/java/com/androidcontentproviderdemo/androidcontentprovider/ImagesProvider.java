package com.androidcontentproviderdemo.androidcontentprovider;


import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

public class ImagesProvider extends ContentProvider {

    private static final String PROVIDER_NAME = "androidcontentproviderdemo.androidcontentprovider.images";
    private static final int IMAGES = 1;
    private static final int IMAGE_ID = 2;

    private static final UriMatcher uriMatcher = getUriMatcher();

    private static UriMatcher getUriMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "images", IMAGES);
        uriMatcher.addURI(PROVIDER_NAME, "images/#", IMAGE_ID);
        return uriMatcher;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case IMAGES:
                return "vnd.android.cursor.dir/vnd.com.androidcontentproviderdemo.androidcontentprovider.provider.images";
            case IMAGE_ID:
                return "vnd.android.cursor.item/vnd.com.androidcontentproviderdemo.androidcontentprovider.provider.images";

        }
        return "";
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }



    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
