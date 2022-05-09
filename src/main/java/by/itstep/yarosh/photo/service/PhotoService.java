package by.itstep.yarosh.photo.service;
import by.itstep.yarosh.photo.model.Photo;
import by.itstep.yarosh.photo.repository.PhotoRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class PhotoService {

    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Iterable<Photo> get() {
        return photoRepository.findAll();
    }

    public Photo get(Integer id) {
        return photoRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photoRepository.deleteById(id);
    }

    public Photo save(String fileNAme, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setFileName(fileNAme);
        photo.setData(data);
        photoRepository.save(photo);
        return photo;
    }
}
