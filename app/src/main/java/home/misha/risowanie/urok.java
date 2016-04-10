package home.misha.risowanie;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Misha on 09.04.2016.
 */
public class urok implements Parcelable {
    private String name;
    private int nomer;
    private ArrayList<Krok> list_krok=new ArrayList<Krok>();
    private int krok_; // я её впринципе пока не использовал

    public urok (String _name, int _nomer) {
        this.name=_name;
        this.nomer=_nomer;
         }
    public int getNomer(){
        return this.nomer;
    }

    public String getName(){
        return this.name;

    }

    public int getKrok_(){
        return this.krok_;
    }

    public void setKrokList(ArrayList<Krok> _list_krok) {
        this.list_krok = _list_krok;
    }

    public ArrayList<Krok> getList_krok(){
        return this.list_krok;
    }


    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {

        parcel.writeString(name);
        parcel.writeInt(nomer);
        parcel.writeTypedList(list_krok);

    }

    public static final Parcelable.Creator<urok> CREATOR =new Parcelable.Creator<urok>(){

        public urok createFromParcel(Parcel in) {
           return new urok(in);
        }

        public urok[] newArray(int size) {
            return new urok[size];
        }


    };

    private urok(Parcel parcel) {
        this.name= parcel.readString();
        this.nomer=parcel.readInt();
        this.list_krok=parcel.createTypedArrayList(Krok.CREATOR);
    }


}


class Krok implements Parcelable {
    private String name;
    private int ID_res;

    public Krok (String _name, int _ID_res){
        this.name=_name;
        this.ID_res=_ID_res;
    }

    public String getName(){
        return this.name;
    }

    public int getID_res(){
        return this.ID_res;
    }



    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {

        parcel.writeString(name);
        parcel.writeInt(ID_res);

    }

    public static final Parcelable.Creator<Krok> CREATOR =new Parcelable.Creator<Krok>(){

        public Krok createFromParcel(Parcel in) {
            return new Krok(in);
        }

        public Krok[] newArray(int size) {
            return new Krok[size];
        }


    };

    private Krok(Parcel parcel) {
        this.name= parcel.readString();
        this.ID_res=parcel.readInt();

    }


}