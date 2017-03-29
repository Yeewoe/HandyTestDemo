package org.yeewoe.handytestdemo.picture;

import android.widget.ImageView;

import org.yeewoe.handytestdemo.R;

/**
 * 圖片幫助類
 * Created by ivo on 2017/3/29.
 */

public class ImageHelper {
    public static final String TEST_1 = "hash_1";
    public static final String TEST_BIG = "hash_big";
    public static final String TEST_2 = "hash_2";

    public static void loadImage(ImageView mImgViPic, String picture) {
        /**
         * 此處應該對圖片HASH做處理，獲取圖片的URL路徑
         * 此處應該使用圖片庫對圖片進行異步加載
         * 此處為了省略複雜流程，簡單處理
         **/
        if (TEST_1.equals(picture)) {
            mImgViPic.setImageResource(R.mipmap.img_test_1);
        } else if (TEST_BIG.equals(picture)) {
            mImgViPic.setImageResource(R.mipmap.img_test_big);
        } else if (TEST_2.equals(picture)) {
            mImgViPic.setImageResource(R.mipmap.img_test_2);
        }
    }
}
