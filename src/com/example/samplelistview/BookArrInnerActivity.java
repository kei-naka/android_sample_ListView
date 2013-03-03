package com.example.samplelistview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Book 型の ArrayAdapter を継承した独自 Adapter を独自のインナークラスとして定義する。
 * 表示したいオブジェクトが Book 型で、View を独自に定義したいので、String ではなく、Book 型の ArrayAdapter を継承する。
 * インナークラスなので、クラスのメンバー変数に直接アクセスできるのが強み。
 * ArrayAdapter を継承しているので、getView() 以外の基本的なメソッドは定義済み。
 * Activity との結びつきが強いので、この Adapter だけ使いたい時には不便なのは BaseAdapter を継承した時と同じ。
 * @author keigo
 *
 */
public class BookArrInnerActivity extends Activity {
	
	private int i = 0;
	private BookArrayAdapter adapter;

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
	
	private int createIconId(int i) {
		int iconId = R.drawable.icon0;
		if (i < 0) {
			iconId = R.drawable.icon1;
		} else {
			switch (i % 3) {
			case 0:
				iconId = R.drawable.icon2;
				break;
			case 1:
				iconId = R.drawable.icon3;
				break;
			case 2:
				iconId = R.drawable.icon4;
				break;
			}
		}
		return iconId;
	}
	
	public class BookArrayAdapter extends ArrayAdapter<Book> {

		LayoutInflater inflater;
		int layoutId;
		
		public BookArrayAdapter(Context context, int layoutId, ArrayList<Book> items) {
			super(context, layoutId, items);
			this.layoutId = layoutId;
			inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public View getView(int position, View convertedView, ViewGroup parent) {
			View view = convertedView;
			if (view == null) {
			view = inflater.inflate(layoutId, null);
			}

			Book item = (Book) getItem(position);
			if (item != null) {
				((TextView) view.findViewById(R.id.infoText)).setText(item.getName());
				((ImageView) view.findViewById(R.id.infoIcon)).setImageResource(item.getIconId());
			}
			return view;
		}

	}
}
