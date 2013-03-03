package com.example.samplelistview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * BaseAdapter を継承した独自 Adapter をインナークラスとして定義する。
 * インナークラスなので、クラスのメンバー変数に直接アクセスできるのが強み。
 * Activity との結びつきが強いので、この Adapter だけ使いたい時には不便。
 * @author keigo
 *
 */
public class BookBaseInnerActivity extends Activity {
	
	private BookAdapter adapter = null;
	private ArrayList<Book> items = null;
	private int i = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adapter);
		
		items = new ArrayList<Book>();
		adapter = new BookAdapter();

		ListView listView = (ListView) findViewById(R.id.listView);
		listView.setAdapter(adapter);
		
		// 先頭に追加
		findViewById(R.id.btnAddTop).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
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
			public void onClick(View v) {
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
			public void onClick(View v) {
				adapter.clear();
				i = 0;
			}
		});
	}
	
	private int createIconId(int index) {
		int iconId = -1;
		switch(index % 10) {
		case 0:
			iconId = R.drawable.icon0;
			break;
		case 1:
			iconId = R.drawable.icon1;
			break;
		case 2:
			iconId = R.drawable.icon2;
			break;
		case 3:
			iconId = R.drawable.icon3;
			break;
		case 4:
			iconId = R.drawable.icon4;
			break;
		case 5:
			iconId = R.drawable.icon5;
			break;
		case 6:
			iconId = R.drawable.icon6;
			break;
		case 7:
			iconId = R.drawable.icon7;
			break;
		case 8:
			iconId = R.drawable.icon8;
			break;
		case 9:
			iconId = R.drawable.icon9;
			break;
		default:
			iconId = R.drawable.ic_launcher;
			break;
		}
		return iconId;
	}

	public class BookAdapter extends BaseAdapter {

		LayoutInflater inflater;
		
		public BookAdapter() {
			inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			return items.size();
		}

		@Override
		public Book getItem(int position) {
			Book item = null;
			if (items != null) {
				item = items.get(position);
			}
			return item;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertedView, ViewGroup parent) {
			View view = convertedView;
			if (view == null) {
				view = inflater.inflate(R.layout.row_summary, null);
			}

			Book item = (Book) getItem(position);
			if (item != null) {
	
				TextView text = (TextView) view.findViewById(R.id.infoText);
				text.setText(item.getName());
	
				ImageView icon = (ImageView) view.findViewById(R.id.infoIcon);
				icon.setImageResource(item.getIconId());
			}

			return view;
		}
		
		/**
		 * リストの末尾に item を追加する
		 * @param item
		 */
		private void add(Book item) {
			if (items == null) {
				return;
			}
			if (item == null) {
				return;
			}
			items.add(item);
			notifyDataSetChanged();
		}
		
		/**
		 * 指定された index に item を挿入する
		 * @param item
		 * @param index
		 */
		private void insert(Book item, int index) {
			if (items == null) {
				return;
			}
			if (item == null) {
				return;
			}
			items.add(0, item);
			notifyDataSetChanged();
		}
		
		/**
		 * position のデータを削除する
		 * @param position
		 */
		private void remove(int position) {
			if (items == null) {
				return;
			}
			if (position < 0 || items.size() -1 < position) {
				return;
			}
			items.remove(position);
			notifyDataSetChanged();
		}
		
		/**
		 * adapter が管理している全データを削除する
		 */
		private void clear() {
			if (items == null) {
				return;
			}
			items.clear();
			notifyDataSetChanged();
		}
	}
}
