package com.example.samplelistview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * String の ArrayAdapter を使う。
 * 一番基本的な使い方。
 * @author keigo
 *
 */
public class StrAdapterActivity extends Activity {
	private int i = 0;
	
	private ArrayAdapter<String> adapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adapter);
		
		// 配列を使う時は事前に定義しておく
		// String[] items = {"aaa", "bbb"};
		
		// リストを使うときは枠をnewする
		ArrayList<String> items = new ArrayList<String>();
		
		adapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, items);
		
		ListView listView = (ListView) findViewById(R.id.listView);
		listView.setAdapter(adapter);
		
		// 先頭に追加
		Button btnAddTop = (Button) findViewById(R.id.btnAddTop);
		btnAddTop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				adapter.insert("gomi" + i++, 0);
			}
		});
		
		// 末尾に追加
		Button btnAddBottom = (Button) findViewById(R.id.btnAddBottom);
		btnAddBottom.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				adapter.add("gomi" + i++);
			}
		});
		
		// 先頭を削除
		Button btnRemoveTop = (Button) findViewById(R.id.btnRemoveTop);
		btnRemoveTop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (adapter.getCount() > 0) {
					adapter.remove(adapter.getItem(0));
				}
			}
		});
		
		// 末尾を削除
		Button btnRemoveBottom = (Button) findViewById(R.id.btnRemoveBottom);
		btnRemoveBottom.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (adapter.getCount() > 0) {
					adapter.remove(adapter.getItem(adapter.getCount() - 1));
				}
			}
		});
		
		// 全て削除
		Button btnRemoveAll = (Button) findViewById(R.id.btnRemoveAll);
		btnRemoveAll.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				adapter.clear();
				i = 0;
			}
		});
	}
}
