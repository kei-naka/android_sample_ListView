package com.example.samplelistview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

/**
 * Book 型の ArrayAdapter を継承した独自 Adapter を外部クラスとして定義する。
 * 表示したいオブジェクトが Book 型で、View を独自に定義したいので、String ではなく、Book 型の ArrayAdapter を継承する。
 * Activity とは独立しているので、この Adapter だけ使いたい時に便利なのは BaseAdapter を継承した時と同じ。
 * BaseAdapter ではなく、ArrayAdapter を継承しているので、getView() 以外の基本的なメソッドは定義済み。
 * @author keigo
 *
 */
public class BookArrExtActivity extends Activity {

	private BookArrayAdapter adapter = null;
	private int i = 0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adapter);
		
		adapter = new BookArrayAdapter(this, R.layout.row_summary, new ArrayList<Book>());
		((ListView) findViewById(R.id.listView)).setAdapter(adapter);
		
		// 先頭に追加
		findViewById(R.id.btnAddTop).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				adapter.insert(new Book("author" + i, createIconId(i)), 0);
				i++;
			}
		});
		
		// 末尾に追加
		findViewById(R.id.btnAddBottom).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				adapter.add(new Book("author" + i, createIconId(i)));
				i++;
			}
		});
		
		// 先頭を削除
		findViewById(R.id.btnRemoveTop).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (adapter.getCount() > 0) {
					adapter.remove(adapter.getItem(0));
				}
			}
		});
		
		// 末尾を削除
		findViewById(R.id.btnRemoveBottom).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (adapter.getCount() > 0) {
					adapter.remove(adapter.getItem(adapter.getCount() - 1));
				}
			}
		});
		
		// 全て削除
		findViewById(R.id.btnRemoveAll).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				adapter.clear();
				i = 0;
			}
		});
	}
	
	private int createIconId(int index) {
		int iconId = R.drawable.icon5;
		if (index < 0) {
			iconId = R.drawable.icon6;
		} else {
			switch (i % 2) {
			case 0:
				iconId = R.drawable.icon7;
				break;
			case 1:
				iconId = R.drawable.icon8;
				break;
			}
		}
		return iconId;
	}

}
