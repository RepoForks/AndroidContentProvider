package com.androidcontentproviderdemo.androidcontentproviderusage;

import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ContentProviderUsageActivity extends Activity {

    private static final String PROVIDER_NAME = "androidcontentproviderdemo.androidcontentprovider.images";
    private static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME + "/images");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider_usage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_content_provider_usage, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickAddImage(View view) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("IMAGETITLE" , ((EditText)findViewById(R.id.edtTxtImageTitle)).getText().toString());
        contentValues.put("IMAGEURL" , ((EditText)findViewById(R.id.edtImageUrl)).getText().toString());
        contentValues.put("IMAGEDESC" , ((EditText)findViewById(R.id.edtImageDesc)).getText().toString());
        Uri uri = getContentResolver().insert(CONTENT_URI, contentValues);
        Toast.makeText(getBaseContext(), uri.toString(), Toast.LENGTH_LONG).show();

    }
}
