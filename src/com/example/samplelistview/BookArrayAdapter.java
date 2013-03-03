package com.example.samplelistview;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BookArrayAdapter extends ArrayAdapter<Book> {
	
	private LayoutInflater inflater;
	private int layoutId;

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
	
		Book item = getItem(position);
		if (item != null) {
			((TextView) view.findViewById(R.id.infoText)).setText(item.getName());
			((ImageView) view.findViewById(R.id.infoIcon)).setImageResource(item.getIconId());
		}

		return view;
	}
}
