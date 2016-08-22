
package com.yzy.horizontalscrollview;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ListView;
import com.yzy.horizontalscrollview.R;

public class MainActivity extends Activity {

    private ListView mListView;

    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        mAdapter = new MyAdapter(this, dm.widthPixels,mListView);
        mListView.setAdapter(mAdapter);
    }
}
