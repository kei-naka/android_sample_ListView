package com.example.samplelistview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Book 型の ArrayAdapter を使う。
 * 独自レイアウトを使うが、
 * 　　1) TextView は１つだけ
 * 　　2) アイコン等の素材は全部固定（動的に変わらない）
 * という条件を満たせば、TextView の id を指定することで、
 * Adapter を継承することなく、ArrayAdapter に独自レイアウトを指定して使うことができる。
 * @author keigo
 *
 */
public class BookArgActivity extends Activity {
	
	private ArrayAdapter<Book> adapter;
	private int i = 0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adapter);
		
		ArrayList<Book> items = new ArrayList<Book>();
		adapter = new ArrayAdapter<Book>(BookArgActivity.this, R.layout.row_summary, R.id.infoText, items);
		
		ListView listView = (ListView) findViewById(R.id.listView);
		listView.setAdapter(adapter);
		
		// 先頭に追加
		findViewById(R.id.btnAddTop).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				adapter.insert(new Book("author" + i++, 0), 0);
			}
		});
		
		// 末尾に追加
		findViewById(R.id.btnAddBottom).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				adapter.add(new Book("author" + i++, 0));
			}
		});
		
		// 先頭を削除
		findViewById(R.id.btnRemoveTop).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (adapter.getCount() > 0) {
					adapter.remove(adapter.getItem(0));
				}
			}
		});
		
		// 末尾を削除
		findViewById(R.id.btnRemoveBottom).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (adapter.getCount() > 0) {
					adapter.remove(adapter.getItem(adapter.getCount() - 1));
				}
			}
		});
		
		// 全て削除
		findViewById(R.id.btnRemoveAll).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				adapter.clear();
			}
		});
	}
}
