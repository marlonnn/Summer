/**
 *  Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
 */
package com.summer.adapter;

import java.util.Arrays;
import java.util.List;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @ClassName: CommonAdapter
 * @Description:Universal adapter
 * @author wen zhong
 * @Date: 2016/4/7 16:41:14 PM
 * @param <T>
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
	protected Context mContext;
	protected List<T> mDatas;
	protected final int mItemLayoutId;
	protected ViewHolder viewHolder;

	public CommonAdapter(Context context, int itemLayoutId, List<T> mDatas) {
		this.mContext = context;
		this.mDatas = mDatas;
		this.mItemLayoutId = itemLayoutId;
	}

	public CommonAdapter(Context context, int itemLayoutId, T[] mDatas) {
		this.mContext = context;
		this.mDatas = Arrays.asList(mDatas);
		this.mItemLayoutId = itemLayoutId;
	}

	@Override
	public int getCount() {
		if (mDatas != null) {
			return mDatas.size();
		}
		return 0;
	}

	@Override
	public T getItem(int position) {
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		viewHolder = new ViewHolder(mContext, parent, mItemLayoutId, position, mDatas);
		viewHolder.setPosition(position);
		setTag(viewHolder, getItem(position));
		convert(viewHolder, getItem(position));
		return viewHolder.getConvertView();
	}

	public void setTag(ViewHolder helper, final T item)
	{
	
	}
	public abstract void convert(ViewHolder helper, final T item);
	public void setList(List<T> list){
		if (list == null)
			return;
		this.mDatas = list;
		notifyDataSetChanged();
	}
	public void add(List<T> list) {
		if (list == null || list.size() == 0)
			return;
		this.mDatas.addAll(list);
		notifyDataSetChanged();
	}

	public void clearAll() {
		this.mDatas.clear();
		notifyDataSetChanged();
	}

	/**
	 * Common ViewHolde
	 * 
	 */
	public class ViewHolder {
		private final SparseArray<View> mViews;
		private View mConvertView;
		private int position;

		public int getPosition() {
			return position;
		}

		public void setPosition(int position) {
			this.position = position;
		}

		private ViewHolder(Context context, ViewGroup parent, int layoutId, int position, List<T> mDatas) {
			this.mViews = new SparseArray<View>();
			mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
			mConvertView.setTag(mDatas.get(position));
		}

		/**
		 * Get a viewHolder object
		 * 
		 * @param context
		 * @param convertView
		 * @param parent
		 * @param layoutId
		 * @param position
		 * @return
		 */
		@SuppressWarnings("unchecked")
		public  ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position, List<T> mDatas) {
			if (convertView == null) {
				return new ViewHolder(context, parent, layoutId, position, mDatas);
			}
			return (ViewHolder) convertView.getTag();
		}

		public View getConvertView() {
			return mConvertView;
		}

		/**
		 * get view by id
		 * @param viewId
		 * @return
		 */
		@SuppressWarnings({ "unchecked", "hiding" })
		public <T extends View> T getView(int viewId) {
			View view = mViews.get(viewId);
			if (view == null) {
				view = mConvertView.findViewById(viewId);
				mViews.put(viewId, view);
			}
			return (T) view;
		}

		/**
		 * set textView text
		 * 
		 * @param viewId
		 * @param text
		 * @return
		 */
		public void setText(int viewId, String text) {
			TextView view = getView(viewId);
			view.setText(text);
		}
		
		/**
		 * set textView color
		 * @param viewId
		 * @param color
		 */
		public void setTextColor(int viewId, int color)
		{
			TextView view = getView(viewId);
			view.setTextColor(color);
		}
		
		/**
		 * set imageView image
		 * 
		 * @param viewId
		 * @param drawableId
		 * @return
		 */
		public void setImageResource(int viewId, int drawableId) {
			ImageView view = getView(viewId);
			view.setImageResource(drawableId);
		}

		/**
		 * set imageView bitmap
		 * 
		 * @param viewId
		 * @param drawableId
		 * @return
		 */
		public void setImageBitmap(int viewId, Bitmap bm) {
			ImageView view = getView(viewId);
			view.setImageBitmap(bm);
		}
	}
}
