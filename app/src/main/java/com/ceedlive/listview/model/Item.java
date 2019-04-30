package com.ceedlive.listview.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
    int index;
    String title;
    String description;


    protected Item(Parcel in) {
        index = in.readInt();
        title = in.readString();
        description = in.readString();
    }

    public static class Builder {
        private int index;
        private String title;
        private String description;

        public Builder(String title, String description) {
            this.title = title;
            this.description = description;
        }

        public Builder index(int index) {
            this.index = index;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }

    public Item(Builder builder) {
        this.index = builder.index;
        this.title = builder.title;
        this.description = builder.description;
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public int getIndex() { return index; }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }

    /**
     * Parcel의 내용을 기술한다.
     * FileDescriptor 같은 특별한 객체가 들어가면 이 부분을 통해서 알려줘야한다.
     * 보통은 0을 리턴해준다.
     * @return
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Parcel안에 데이터를 넣는 작업을 한다.
     *
     * writeToParcel에서 Parcel 목적지(dest)에다가 데이터를 포맷에 따라 차곡차곡 넣어주고,
     * Parcel이 있는 생성자에서 순서대로 꺼내오면 된다. (두 개의 순서는 같아야 한다!)
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(index);
        dest.writeString(title);
        dest.writeString(description);
    }
}
