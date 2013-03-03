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
 * 独自の java クラス内で toString() を事前に定義しておくことで、
 * 既存の行レイアウトを定義することなく、toString() のフォーマットで独自のレイアウトで表示可能。
 * @author keigo
 *
 */
public class StrToStringActivity extends Activity {
	private int i = 3;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adapter);
		
		ArrayList<Book> items = new ArrayList<Book>();
		items.add(new Book("author1", 0));
		items.add(new Book("author2", 0));

		final ArrayAdapter<Book> adapter = new ArrayAdapter<Book>(this, android.R.layout.simple_list_item_1, items);
		
		ListView listView = (ListView) findViewById(R.id.listView);
		listView.setAdapter(adapter);
		
		// �擪�ɒǉ�
		findViewById(R.id.btnAddTop).setOnClickListener(new View.OnClickListener() {
			@Override
				public void onClick(View v) {
				adapter.insert(new Book("author" + i++, 0), 0);
			}
		});		
		
		// �����ɒǉ�
		Button btnAddBottom = (Button) findViewById(R.id.btnAddBottom);
		btnAddBottom.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				adapter.add(new Book("author" + i++, 0));
			}
		});
		
		// �擪���폜
		findViewById(R.id.btnRemoveTop).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (adapter.getCount() > 0) {
				adapter.remove(adapter.getItem(0));
				}
			}
		});

		// �������폜
		findViewById(R.id.btnRemoveBottom).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (adapter.getCount() > 0) {
					adapter.remove(adapter.getItem(adapter.getCount() - 1));
				}
			}
		});
		
		// �S�č폜
		findViewById(R.id.btnRemoveAll).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				adapter.clear();
				i = 0;
			}
		});
	}
}
