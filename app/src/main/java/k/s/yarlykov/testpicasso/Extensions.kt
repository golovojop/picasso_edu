package k.s.yarlykov.testpicasso

import android.util.Log
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation

/**
 * Загрузка растровой картинки из локальных ресурсов.
 * Picasso не поддерживает работу с векторной графикой, поэтому иконку направления
 * ветра поворачиваем самостоятельно, он векторная.
 */
fun ImageView.loadWithPicasso(resourceId: Int, transformation : Transformation, angle: Float) {
    Picasso
        .get()
        .load(resourceId)
        .transform(transformation)
        .rotate(angle)
        .into(this)
}

fun ImageView.loadAndCropWithPicasso(resourceId: Int, width : Int, height : Int) {

    Log.e("IMAGE_ERROR", "resize($width, $height)")

    Picasso
        .get()
        .load(resourceId)
//        .resize(width, height)
        .transform(CropTransformation(width, height))
//        .centerCrop()
        .into(this)
}
