package org.jitu.filmstack;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class BookmarkAdapter extends BaseAdapter{

	private Activity act;
	private Cursor c ;
	private static LayoutInflater inflater = null;
	public BookmarkAdapter(Activity a , Cursor cursor ) {
		Log.d("cursor init","f") ;
		 act = a ;
		c = cursor ;
		Log.d("cursor init","f") ;
	//	Toast.makeText(act, c.getString(c.getColumnIndex(Database.bookmark.TITLE)), Toast.LENGTH_SHORT).show() ;
		inflater = (LayoutInflater)act
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		
		// TODO Auto-generated constructor stub
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return c.getCount() ;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View vi = convertView ;
   
		if(convertView==null)
		{
			vi  = inflater.inflate(R.layout.list_row, null) ;
		}
		
         c.moveToPosition(position) ;
         //  Toast.makeText(act, c.getString(c.getColumnIndex(Database.bookmark.TITLE)), Toast.LENGTH_SHORT).show() ;
        
		TextView Title = (TextView)vi.findViewById(R.id.title) ;
		
		ImageView iv  = (ImageView)vi.findViewById(R.id.list_image) ;
		
		Title.setText(c.getString(c.getColumnIndex(Database.bookmark.TITLE))) ;
		byte[] byteArray = c.getBlob(c.getColumnIndex(Database.bookmark.ICON));  

		Bitmap bm = BitmapFactory.decodeByteArray(byteArray, 0 ,byteArray.length);
	     iv.setImageBitmap(bm) ;
	
		return vi;
	
        }
}
