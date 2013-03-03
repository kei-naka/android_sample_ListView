package com.example.samplelistview;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private Button btnStrAdapter;
    private Button btnStrToString;
    private Button btnBookArg;
    private Button btnBookBaseInner;
    private Button btnBookBaseExt;
    private Button btnBookArrInner;
    private Button btnBookArrExt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnStrAdapter = (Button) findViewById(R.id.btnStrAdapter);
		btnStrAdapter.setOnClickListener(lstnStrAdapter);
		
		btnStrToString = (Button) findViewById(R.id.btnStrToString);
		btnStrToString.setOnClickListener(lstnStrToString);
		
		btnBookArg = (Button) findViewById(R.id.btnBookArg);
		btnBookArg.setOnClickListener(lstnBookArg);
		
		btnBookBaseInner = (Button) findViewById(R.id.btnBookBaseInner);
		btnBookBaseInner.setOnClickListener(lstnBookBaseInner);
		
		btnBookBaseExt = (Button) findViewById(R.id.btnBookBaseExt);
		btnBookBaseExt.setOnClickListener(lstnBookBaseExt);
		
		btnBookArrInner = (Button) findViewById(R.id.btnBookArrInner);
		btnBookArrInner.setOnClickListener(lstnBookArrInner);
		
		btnBookArrExt = (Button) findViewById(R.id.btnBookArrExt);
		btnBookArrExt.setOnClickListener(lstnBookArrExt);
		
		/* HistoryManager hmanager = new HistoryManager(this);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		// hmanager.add("gomi", "2012-12-12 11:22:33");
		hmanager.add("gomi2", sdf.format(new Date())); */
		
		/* GomiAsyncTask at = new GomiAsyncTask(this);
		at.execute(new String[] {"main", "gomi"}); */
	}

	private OnClickListener lstnStrAdapter = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this, StrAdapterActivity.class);
			startActivity(intent);
		}
	};
	
	private OnClickListener lstnStrToString = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this, StrToStringActivity.class);
			startActivity(intent);
		}
	};
	
	private OnClickListener lstnBookArg = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this, BookArgActivity.class);
			startActivity(intent);
		}
	};
	
	private OnClickListener lstnBookBaseInner = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this, BookBaseInnerActivity.class);
			startActivity(intent);
		}
	};
	
	private OnClickListener lstnBookBaseExt = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this, BookBaseExtActivity.class);
			startActivity(intent);
		}
	};
	
	private OnClickListener lstnBookArrInner = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this, BookArrInnerActivity.class);
			startActivity(intent);
		}
	};

	private OnClickListener lstnBookArrExt = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this, BookArrExtActivity.class);
			startActivity(intent);
		}
	};
}
