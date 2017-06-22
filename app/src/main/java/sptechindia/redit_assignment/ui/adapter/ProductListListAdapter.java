package sptechindia.redit_assignment.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import sptechindia.redit_assignment.R;
import sptechindia.redit_assignment.base.adapter.RecyclerViewAdapter;
import sptechindia.redit_assignment.base.view.ViewType;
import sptechindia.redit_assignment.model.BaseItem;
import sptechindia.redit_assignment.model.ProductModel;


public class ProductListListAdapter extends RecyclerViewAdapter< ProductModel > {

	private AddressListener mAddressListener;

	public ProductListListAdapter( List< ProductModel > objects, AddressListener listener ) {
		super( objects );
		mAddressListener = listener;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType ) {
		RecyclerViewHolder holder;
		switch ( ViewType.valueOf( viewType ) ) {
			case ITEM:
				holder = new AddressViewHolder( LayoutInflater.from( parent.getContext() )
						                                .inflate( R.layout.item_product_item, parent, false ) );
				break;
			case EMPTY_VIEW:
				View emptyView = LayoutInflater.from( parent.getContext() ).inflate( R.layout.item_empty_view, parent, false );
				holder = new EmptyView( emptyView );
				break;
			default:
				return super.onCreateViewHolder(parent, viewType);

		}

		return holder;
	}

	@Override
	public void onBindViewHolder( RecyclerView.ViewHolder holder, int position ) {

		switch ( ViewType.valueOf( getItemViewType( position ) ) ) {
			case ITEM:
				AddressViewHolder addressHolder = ( AddressViewHolder ) holder;

				break;

			case EMPTY_VIEW:
				break;
			default:

				break;
		}

	}

	@Override
	public void onDestroy() {
		mAddressListener = null;
	}

	@Override
	public int getItemViewType( int position ) {
		BaseItem item = getItemAtPosition( position );
		return item.viewType.getValue();
	}

	public interface AddressListener {
		void addAddress();

		void editAddress( ProductModel item );

		void deleteAddress( ProductModel item, int position );

		void makeDefaultAddress( ProductModel item );
	}

	public class AddressViewHolder extends RecyclerViewHolder {
		TextView mName, mAddress, mMarkAsDefault, mAddressType;

		public AddressViewHolder( View itemView ) {
			super( itemView );

		}

		@Override
		public void onClick( View v ) {
			switch ( v.getId() ) {
		       /* case R.id.delete_btn:
                    mAddressListener.deleteAddress(getItemAtPosition(getAdapterPosition()), getAdapterPosition());
                    break;
                case R.id.edit_btn:
                    mAddressListener.editAddress(getItemAtPosition(getAdapterPosition()));
                    break;

                case R.id.mark_as_default:
                    mAddressListener.makeDefaultAddress(getItemAtPosition(getAdapterPosition()));
                    break;*/

			}
			super.onClick( v );
		}
	}

	public class AddAddressHolder extends RecyclerViewHolder {

		TextView textView;

		public AddAddressHolder( View itemView ) {
			super( itemView );
		//	textView = ( TextView ) itemView.findViewById( R.id.add_coupon );
		}

		@Override
		public void onClick( View v ) {
			super.onClick( v );
			mAddressListener.addAddress();
		}
	}
}
