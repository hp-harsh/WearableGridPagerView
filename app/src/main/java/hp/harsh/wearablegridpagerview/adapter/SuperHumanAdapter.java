
/*
* Copyright 2016 Harsh Patel
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package hp.harsh.wearablegridpagerview.adapter;

import android.content.Context;
import android.support.wearable.view.GridPagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import hp.harsh.wearablegridpagerview.R;

public class SuperHumanAdapter extends GridPagerAdapter {

    private Context mContext;

    Integer[][] mSuperHumanRes = {
            {R.mipmap.spider1,
                    R.mipmap.spider2,
                    R.mipmap.spider3},
            {R.mipmap.batman1,
                    R.mipmap.batman2,
                    R.mipmap.batman3},
            {R.mipmap.ironman1,
                    R.mipmap.ironman2,
                    R.mipmap.ironman3}
    };

    // Constructor to call adapter
    public SuperHumanAdapter(Context mContext) {
        this.mContext = mContext;
    }

    // Obtain the number of views (vertical)
    @Override
    public int getRowCount() {
        return mSuperHumanRes.length;
    }

    // Obtain the number of views (horizontal)
    @Override
    public int getColumnCount(int rowNum) {
        return mSuperHumanRes[rowNum].length;
    }

    // Obtain current column while scrolling up and down (Default is 0)
    @Override
    public int getCurrentColumnForRow(int row, int currentColumn) {
        return currentColumn;
    }

    // Return each view of row and column
    @Override
    public Object instantiateItem(ViewGroup viewGroup, int row, int col) {
        ImageView imageView;
        imageView = new ImageView(mContext);
        imageView.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        imageView.setImageResource(mSuperHumanRes[row][col]);
        viewGroup.addView(imageView);
        return imageView;
    }

    // Destroy view when no longer available
    @Override
    public void destroyItem(ViewGroup viewGroup, int i, int i1, Object object) {
        viewGroup.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}