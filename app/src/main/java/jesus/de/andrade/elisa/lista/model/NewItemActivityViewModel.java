package jesus.de.andrade.elisa.lista.model;

import android.net.Uri;

import androidx.lifecycle.ViewModel;

public class NewItemActivityViewModel extends ViewModel {
    Uri selectPhotoLocation = null;
    public Uri getSelectedPhototoLocation(){
        return selectPhotoLocation;
    }
    public void setSelectPhotoLocation(Uri selectPhotoLocation) {
        this.selectPhotoLocation = selectPhotoLocation;
    };
}
