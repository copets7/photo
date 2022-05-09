package by.itstep.yarosh.photo.conrollers;

import by.itstep.yarosh.photo.model.Photo;
import by.itstep.yarosh.photo.service.PhotoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;

@RestController
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }


    @GetMapping("/")
    public String hello(){
        return "PHOTO";
    }

    @GetMapping("/photo")
    public Iterable<Photo> get(){
        return photoService.get();
    }

    @GetMapping("/photo/{id}")
    public Photo get (@PathVariable Integer id){
        Photo photo = photoService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photo/{id}")
    public void delete(@PathVariable Integer id){
       photoService.remove(id);
    }

    @PostMapping("/photo")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
       return photoService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }

}
