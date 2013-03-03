package com.example.samplelistview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

/**
 * BaseAdapter を継承した独自 Adapter を外部クラスとして定義する。
 * Activity とは独立しているので、この Adapter だけ使いたい時には便利。
 * 
 * @author keigo
 *
 */
public class BookBaseExtActivity extends Activity {
	
	private BookBaseAdapter adapter = null;
	private int i = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adapter);
		
		adapter = new BookBaseAdapter(this, new ArrayList<Book>());
		ListView listView = (ListView) findViewById(R.id.listView);
		listView.setAdapter(adapter);
		
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
			public void onClick(View v) {
				adapter.add(new Book("author" + i, createIconId(i)));
				i++;
			}
		});

		// 先頭を削除
		findViewById(R.id.btnRemoveTop).setOnClickListener(new View.OnClickListener() {
			@Override
				public void onClick(View view) {
				adapter.remove(0);
			}
		});
		
		// 末尾を削除
		findViewById(R.id.btnRemoveBottom).setOnClickListener(new View.OnClickListener() {
			@Override
				public void onClick(View view) {
				adapter.remove(adapter.getCount() - 1);
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
	
	private int createIconId(int i) {
		int iconId = R.drawable.icon0;
		if (i <= 0) {
			iconId = R.drawable.icon2;
		} else {
			switch(i % 2) {
			case 0:
				iconId = R.drawable.icon0;
				break;
			case 1:
				iconId = R.drawable.icon1;
				break;
			default:
				iconId = R.drawable.icon2;
				break;
			}
		}
		return iconId;
	}
}
