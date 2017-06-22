package sptechindia.redit_assignment.ui.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import java.util.List;

import sptechindia.redit_assignment.R;

public class SortListAdapter extends BaseAdapter {

	private static final String TAG = SortListAdapter.class.getSimpleName();
	List<String > listSortNames;
	Context             context;
	LayoutInflater      layoutInflater;

	private static final int NOT_SELECTED = -1;
	private int selectedPos = NOT_SELECTED;

	public SortListAdapter(Context mContext,List<String> listSortNames) {
		this.context  = mContext;
		this.listSortNames = listSortNames;
		this.layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}


	@Override
	public int getCount() {
		return listSortNames.size();
	}

	@Override
	public Object getItem(int position) {
		return listSortNames.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView( int position, View convertView, ViewGroup parent) {
		final SortListAdapter.ViewHolder viewHolder;

		if (convertView == null) {
			try {
				convertView = layoutInflater.inflate( R.layout.itemview_sortlist, parent, false);

			} catch (Exception e) {
				e.printStackTrace();
			}
			viewHolder = new SortListAdapter.ViewHolder();
			viewHolder.textViewNameSortItem = (AppCompatTextView ) convertView.findViewById( R.id.textViewNameSortItem);
			viewHolder.linearLayoutRootSortItem = (LinearLayout ) convertView.findViewById( R.id.linearLayoutRootSortItem);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (SortListAdapter.ViewHolder ) convertView.getTag();
		}

		//new line added
		if (position == selectedPos) {
			Log.i( TAG, "getView: text color true");
			viewHolder.textViewNameSortItem.setTextColor( ContextCompat.getColor( context, R.color.colorPrimaryDark));
		//	viewHolder.linearLayoutRootSortItem.setBackgroundColor( ContextCompat.getColor(context,R.color.color_D3D3D3) );
			viewHolder.textViewNameSortItem.setTypeface( null, Typeface.BOLD);
			// your color for selected item
		} else {
			Log.i(TAG, "getView: text color false");
			viewHolder.textViewNameSortItem.setTextColor( ContextCompat.getColor( context, R.color.secondary_text));
		//	viewHolder.linearLayoutRootSortItem.setBackgroundColor( ContextCompat.getColor(context,R.color.white) );
			viewHolder.textViewNameSortItem.setTypeface( null, Typeface.NORMAL);
		}
		//new line added end


		viewHolder.textViewNameSortItem.setText(listSortNames.get( position ));
		return convertView;
	}
	static class ViewHolder {

		LinearLayout      linearLayoutRootSortItem;
		AppCompatTextView textViewNameSortItem;
	}

	//new method added
	public void setSelectedRow(int selectedPosition){
		this.selectedPos = selectedPosition;
		notifyDataSetChanged();
	}
}
