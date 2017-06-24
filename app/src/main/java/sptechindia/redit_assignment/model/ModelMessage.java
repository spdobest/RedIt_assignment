package sptechindia.redit_assignment.model;

import android.os.Parcel;
import android.os.Parcelable;

import sptechindia.redit_assignment.utility.Constants;

/**
 * Created by sibaprasad on 23/06/17.
 */

public class ModelMessage extends Object implements Parcelable {

	public String textTitle;
	public String textDesc;
	public int rowType = Constants.ROW_TEXT;

	public ModelMessage(   ) {

	}

	public ModelMessage( String textTitle,String desc, int rowType ) {
		this.textTitle = textTitle;
		this.rowType = rowType;
		this.textDesc = desc;
	}


	 @Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel( Parcel dest, int flags ) {
		dest.writeString( this.textTitle );
		dest.writeString( this.textDesc );
		dest.writeInt( this.rowType );
	}

	protected ModelMessage( Parcel in ) {
		this.textTitle = in.readString();
		this.textDesc = in.readString();
		this.rowType = in.readInt();
	}

	public static final Creator< ModelMessage > CREATOR = new Creator< ModelMessage >() {
		@Override
		public ModelMessage createFromParcel( Parcel source ) {
			return new ModelMessage( source );
		}

		@Override
		public ModelMessage[] newArray( int size ) {
			return new ModelMessage[size];
		}
	};
}
