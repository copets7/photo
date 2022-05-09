package by.itstep.yarosh.photo.repository;

import by.itstep.yarosh.photo.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository <Photo, Integer> {

}
