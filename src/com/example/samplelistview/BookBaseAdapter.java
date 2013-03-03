package com.example.samplelistview;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BookBaseAdapter extends BaseAdapter {

	private ArrayList<Book> items;
	private LayoutInflater inflater;

	public BookBaseAdapter(Context context, ArrayList<Book> items) {
		this.items = items;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		int num = -1;
		if (items != null) {
			num = items.size();
		}
		return num;
	}
	
	@Override
	public Book getItem(int position) {
		if (items == null) {
			return null;
		}
		if (position < 0 || getCount() <= position) {
			return null;
		}
		return (Book) items.get(position);
	}

	@Override
	public long getItemId(int position ) {
		long id = position;
		if (items == null) {
			id = -1;
		}
		if (position < 0 || items.size() <= position) {
			id = -1;
		}
		return id;
	}
	
	@Override
	public View getView(int position, View convertedView, ViewGroup parent) {
		View view = convertedView;
		if (view == null) {
		view = inflater.inflate(R.layout.row_summary, null);
		}
	
		Book item = getItem(position);
		if (item != null) {
			((TextView) view.findViewById(R.id.infoText)).setText(item.getName());
			((ImageView) view.findViewById(R.id.infoIcon)).setImageResource(item.getIconId());
		}
	
		return view;
	}
	
	public void add(Book item) {
		if (items == null) {
			return;
		}
		if (item == null) {
			return;
		}
		items.add(item);
		notifyDataSetChanged();
	}
	
	public void insert(Book item, int index) {
		if (items == null) {
			return;
		}
		if (item == null) {
			return;
		}
		if (index < 0) {
			return;
		}
		items.add(0, item);
		notifyDataSetChanged();
	}
	
	public void remove(int position) {
		if (items == null) {
			return;
		}
		if (position < 0 || items.size() <= position) {
			return;
		}
		items.remove(position);
		notifyDataSetChanged();
	}
	
	public void clear() {
		if (items == null) {
			return;
		}
		items.clear();
		notifyDataSetChanged();
	}
}
